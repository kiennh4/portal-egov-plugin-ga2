package com.bkav.portal.portlet.article_publisher;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.jdom.IllegalDataException;

import com.bkav.portal.portlet.article_publisher.cache.AssetEntryCache;
import com.bkav.portal.portlet.article_publisher.util.ArticlePublisherUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetCategoryProperty;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetCategoryPropertyLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.util.Normalizer;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.SyndFeedOutput;

/**
 * Portlet implementation class ArticlePublisher
 */
public class ArticlePublisher extends MVCPortlet {
 
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		resourceResponse.setContentType(ContentTypes.TEXT_XML_UTF8);

		OutputStream outputStream = resourceResponse.getPortletOutputStream();

		try {
			
			PortletPreferences preferences = resourceRequest.getPreferences();
			
			List<AssetEntryCache> rssAssetList = getRssAssetList(resourceRequest,preferences);
			
			String rssTitle = preferences.getValue("rssTitle", DEFAULT_RSS_TITLE);
			String rssFormat = preferences.getValue("rssFormat", DEFAULT_RSS_FORMAT);
			
			String rssType = getFormatType(rssFormat);
			double rssVersion = getFormatVersion(rssFormat);

			String rssContent = exportToRSS(resourceRequest, resourceResponse,rssTitle, rssType, rssVersion, rssAssetList);

			byte[] bytes = rssContent.getBytes(StringPool.UTF8);

			outputStream.write(bytes);
			
		}catch(Exception e){
			_log.error(e);
		}finally {
			outputStream.close();
		}
	}
	
	protected List<AssetEntryCache> getRssAssetList(PortletRequest portletRequest,PortletPreferences preferences) 
			throws PortalException, SystemException {
		
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(portletRequest));
		
		return ArticlePublisherUtil.getAssetList(httpRequest,0);
	}

	protected String exportToRSS(
			PortletRequest portletRequest, PortletResponse portletResponse,String rssTitle,
			String rssType, double rssVersion,List<AssetEntryCache> rssAssets)
		throws Exception {

		SyndFeed syndFeed = new SyndFeedImpl();

		syndFeed.setFeedType(getFeedType(rssType, rssVersion));
		syndFeed.setTitle(rssTitle);
		syndFeed.setLink(StringPool.BLANK);
		syndFeed.setDescription(rssTitle);

		List<SyndEntry> syndEntries = new ArrayList<SyndEntry>();

		syndFeed.setEntries(syndEntries);

		for (AssetEntryCache assetEntryCache : rssAssets) {
			
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(assetEntryCache.getEntryId());
			
			String languageId = LanguageUtil.getLanguageId(portletRequest);
			
			String assetTitle = assetEntry.getTitle(languageId, true);
			
			String assetSummary =  assetEntry.getSummary(languageId, true);
			
			String assetURL = getAssetEntryURL(portletRequest, assetEntry);

			String assetAuthor = HtmlUtil.escape(
				PortalUtil.getUserName(assetEntry.getUserId(), assetEntry.getUserName()));

			SyndContent syndContent = new SyndContentImpl();

			syndContent.setType(ENTRY_TYPE_DEFAULT);
			syndContent.setValue(assetSummary);
			
			SyndEntry syndEntry = new SyndEntryImpl();
			
			syndEntry.setTitle(assetTitle);
			syndEntry.setLink(assetURL);
			syndEntry.setUri(assetURL);
			syndEntry.setDescription(syndContent);
			syndEntry.setAuthor(assetAuthor);
			syndEntry.setPublishedDate(assetEntry.getPublishDate());
			syndEntry.setUpdatedDate(assetEntry.getModifiedDate());

			syndEntries.add(syndEntry);
		}

		syndFeed.setEncoding(StringPool.UTF8);

		SyndFeedOutput output = new SyndFeedOutput();

		try {
			return output.outputString(syndFeed);
		}
		catch (IllegalDataException ide) {
			_regexpStrip(syndFeed);
			return output.outputString(syndFeed);
		}
	}
	
	protected String getAssetEntryURL(PortletRequest portletRequest,AssetEntry assetEntry)
			throws SystemException, PortalException {
		
		long entryId = assetEntry.getEntryId();
		
		long classPK = assetEntry.getClassPK();
		
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		AssetRendererFactory assetRendererFactory =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(
				assetEntry.getClassName());
		
		AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(classPK);
		
		Layout layout = themeDisplay.getLayout();
		
		List<AssetCategory> assetCategoryList = AssetCategoryLocalServiceUtil.getEntryCategories(entryId);
		
		if(!assetCategoryList.isEmpty()){	
			
			AssetCategory assetCategory = assetCategoryList.get(0);
																	
			List<AssetCategoryProperty> categoryPropertyList = 
					AssetCategoryPropertyLocalServiceUtil.getCategoryProperties(assetCategory.getCategoryId());
																			
			if(categoryPropertyList.size() > 0){
				
				//layoutId la layoutId cua Page duoc chon de hien thi tin bai theo tung Category
				//layoutId duoc luu duoi dang property cua Category voi propertyKey = "link-to-page"
				//Cac thuoc tinh (property) cua Category duoc luu trong bang assetcategoryproperty
				
				long referencePageLayoutId = 
						GetterUtil.getLong(ArticlePublisherUtil.getCategoryPropertyValue(assetCategory.getCategoryId(),
								ArticlePublisherUtil._PAGE_LAYOUT_ID_CATEGORY_PROPERTY_KEY, String.valueOf(layout.getPlid())));
				
				if(referencePageLayoutId > 0L){
					
					layout = LayoutLocalServiceUtil.getLayout(referencePageLayoutId);
				}
			}																																	
		}

		//Asset Publisher Portlet Display
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		
		String layoutFriendlyURL = GetterUtil.getString(
			PortalUtil.getLayoutFriendlyURL(layout, themeDisplay));
		
		StringBundler sb = new StringBundler();

		if (!layoutFriendlyURL.startsWith(Http.HTTP_WITH_SLASH) &&
			!layoutFriendlyURL.startsWith(Http.HTTPS_WITH_SLASH)) {
			sb.append(themeDisplay.getPortalURL());
		}
		
		sb.append(layoutFriendlyURL);
		sb.append(Portal.FRIENDLY_URL_SEPARATOR);
		sb.append("asset_publisher");
		sb.append(StringPool.SLASH);
		sb.append(portletDisplay.getInstanceId());
		sb.append(StringPool.SLASH);
		sb.append(assetRendererFactory.getType());
		sb.append("/id/");
		sb.append(assetEntry.getEntryId());
		sb.append(StringPool.SLASH);
		sb.append(assetRenderer.getUrlTitle());
		
		return sb.toString();
	}

	protected static String getFeedType(String type, double version) {
		return type + StringPool.UNDERLINE + version;
	}

	protected static String getFormatType(String format) {
		if (format == null) {
			return TYPE_DEFAULT;
		}

		int x = format.indexOf(ATOM);

		if (x >= 0) {
			return ATOM;
		}

		int y = format.indexOf(RSS);

		if (y >= 0) {
			return RSS;
		}

		return TYPE_DEFAULT;
	}

	protected static double getFormatVersion(String format) {
		if (format == null) {
			return VERSION_DEFAULT;
		}

		int x = format.indexOf("10");

		if (x >= 0) {
			return 1.0;
		}

		int y = format.indexOf("20");

		if (y >= 0) {
			return 2.0;
		}

		return VERSION_DEFAULT;
	}
	
	@SuppressWarnings("unchecked")
	protected static void _regexpStrip(SyndFeed syndFeed) {
		syndFeed.setTitle(_regexpStrip(syndFeed.getTitle()));
		syndFeed.setDescription(_regexpStrip(syndFeed.getDescription()));

		List<SyndEntry> syndEntries = syndFeed.getEntries();

		for (SyndEntry syndEntry : syndEntries) {
			syndEntry.setTitle(_regexpStrip(syndEntry.getTitle()));

			SyndContent syndContent = syndEntry.getDescription();

			syndContent.setValue(_regexpStrip(syndContent.getValue()));
		}
	}
	
	protected static String _regexpStrip(String text) {
		text = Normalizer.normalizeToAscii(text);

		char[] array = text.toCharArray();

		for (int i = 0; i < array.length; i++) {
			String s = String.valueOf(array[i]);

			if (!s.matches(_REGEXP_STRIP)) {
				array[i] = CharPool.SPACE;
			}
		}

		return new String(array);
	}
	
	private static Log _log = LogFactoryUtil.getLog(ArticlePublisher.class.getName());
	
	private static final double VERSION_DEFAULT = 1.0;

	private static final String DEFAULT_RSS_TITLE = "Portal-eGov-RSS";
	
	private static final String ATOM = "atom";

	private static final String RSS = "rss";
	
	private static final String DEFAULT_RSS_FORMAT = "rss10";

	private static final String TYPE_DEFAULT = ATOM;

	private static final String ENTRY_TYPE_DEFAULT = "html";
	
	private static final String _REGEXP_STRIP = "[\\d\\w]";
	
}
