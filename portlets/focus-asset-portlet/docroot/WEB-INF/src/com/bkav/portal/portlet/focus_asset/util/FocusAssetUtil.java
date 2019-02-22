/**
 * @author HUNGDX
 * @time 12:01:18 PM
 * @project focus_article-portlet
 */

package com.bkav.portal.portlet.focus_asset.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.focus_asset.cache.AssetEntryCache;
import com.bkav.portal.portlet.focus_asset.cache.MemcacheUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.SystemProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Image;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.NoSuchCategoryPropertyException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetCategoryProperty;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetCategoryPropertyLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;

public class FocusAssetUtil {

	public static long[] focusAssetValidateCategory (long[] categoryIds)
	{
		long[] categoryIdsValidated = new long[0];
				
		try {
			
			int index = 0;
			
			for (long categoryId : categoryIds)
			{
				
				AssetCategory assetCategory = AssetCategoryLocalServiceUtil.
						fetchAssetCategory(categoryId);
				
				if (assetCategory!=null)
				{
					categoryIdsValidated[index] = categoryId;
					index++;
				}
				
			}
			
			return categoryIdsValidated;
			
		} catch (Exception e) {
			_log.error(e);
			return categoryIdsValidated;
		}
	}
	
	public static List<AssetEntryCache> getTabAssetList(HttpServletRequest request, String tabParamPrefix) {

		List<AssetEntryCache> assetList = new ArrayList<AssetEntryCache>();

		try {

			long groupId = PortalUtil.getScopeGroupId(request);

			String portletId = PortalUtil.getPortletId(request);

			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletId);

			String queryName = preferences.getValue(tabParamPrefix + "TabQueryName", "assetTags");

			String[] queryValues = preferences.getValues(tabParamPrefix + "TabQueryValues", new String[0]);

			String orderByColumn = preferences.getValue(tabParamPrefix + "TabOrderByColumn", "publishDate");

			String orderByType = preferences.getValue(tabParamPrefix + "TabOrderByType", "DESC");

			int numbersOfEntriesDisplay =
				GetterUtil.getInteger(preferences.getValue(tabParamPrefix + "TabEntriesDisplay", "6"));

			String queryKey =
				buildQueryKey(groupId, queryName, queryValues, orderByColumn, orderByType, numbersOfEntriesDisplay);

			assetList = getCacheData(queryKey);

			if (assetList == null || assetList.isEmpty()) {

				Locale locale = PortalUtil.getLocale(request);

				AssetEntryQuery assetEntryQuery = new AssetEntryQuery();

				long[] selectedTagIds = new long[0];

				long[] selectedCategoryIds = new long[0];

				// Get asset entry list by Asset Tags
				if (Validator.equals(queryName, _ASSET_TAG_QUERY_NAME)) {

					selectedTagIds = AssetTagLocalServiceUtil.getTagIds(groupId, queryValues);

				}
				else {

					selectedCategoryIds = new long[queryValues.length];

					for (int i = 0; i < queryValues.length; i++) {
						selectedCategoryIds[i] = Long.parseLong(queryValues[i]);
					}
				}

				assetEntryQuery.setGroupIds(new long[] {
					groupId
				});

				assetEntryQuery.setClassName(JournalArticle.class.getName());

				assetEntryQuery.setAnyTagIds(selectedTagIds);
				assetEntryQuery.setAnyCategoryIds(selectedCategoryIds);

				assetEntryQuery.setOrderByCol1(orderByColumn);
				assetEntryQuery.setOrderByType1(orderByType);

				assetEntryQuery.setStart(0);
				assetEntryQuery.setEnd(numbersOfEntriesDisplay);

				List<AssetEntry> queryList = AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);

				for (int i = 0; i < queryList.size(); i++) {

					AssetEntry assetEntry = queryList.get(i);
					
					AssetEntryCache entryCache = new AssetEntryCache();

					entryCache.setDescription(assetEntry.getDescription(PortalUtil.getLocale(request)));
					entryCache.setEntryId(assetEntry.getEntryId());
					entryCache.setClassNameId(assetEntry.getClassNameId());
					entryCache.setClassPK(assetEntry.getClassPK());
					entryCache.setTitle(assetEntry.getTitle(locale));
					entryCache.setViewContentURL(getViewContentURL(request, entryCache));
					entryCache.setPublishDate(assetEntry.getPublishDate());
					entryCache.setSmallImagePath(getSmallImagePath(request, assetEntry.getClassPK()));

					assetList.add(entryCache);
				}

				if (!assetList.isEmpty()) {

					if (updateCacheData(queryKey, assetList)) {
						updateSystemQueryKeys(queryKey);
					}
				}
			}

		}
		catch (Exception e) {
			_log.error(e);
		}

		return assetList;
	}

	public static List<AssetEntryCache> getAssetList(HttpServletRequest request) {

		List<AssetEntryCache> assetList = new ArrayList<AssetEntryCache>();

		try {

			long groupId = PortalUtil.getScopeGroupId(request);

			String portletId = PortalUtil.getPortletId(request);

			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletId);

			String queryName = preferences.getValue("queryName", "assetTags");

			String[] queryValues = preferences.getValues("queryValues", new String[0]);

			String orderByColumn = preferences.getValue("orderByColumn", "publishDate");

			String orderByType = preferences.getValue("orderByType", "DESC");

			int numbersOfEntriesDisplay = GetterUtil.getInteger(preferences.getValue("numbersOfEntriesDisplay", "4"));

			String queryKey =
				buildQueryKey(groupId, queryName, queryValues, orderByColumn, orderByType, numbersOfEntriesDisplay);

			assetList = getCacheData(queryKey);

			if (assetList == null || assetList.isEmpty()) {

				Locale locale = PortalUtil.getLocale(request);

				AssetEntryQuery assetEntryQuery = new AssetEntryQuery();

				long[] selectedTagIds = new long[0];

				long[] selectedCategoryIds = new long[0];

				// Get asset entry list by Asset Tags
				if (Validator.equals(queryName, _ASSET_TAG_QUERY_NAME)) {

					selectedTagIds = AssetTagLocalServiceUtil.getTagIds(groupId, queryValues);

				}
				else {

					selectedCategoryIds = new long[queryValues.length];

					for (int i = 0; i < queryValues.length; i++) {
						selectedCategoryIds[i] = Long.parseLong(queryValues[i]);
					}
				}
				
				selectedCategoryIds = focusAssetValidateCategory(selectedCategoryIds);

				assetEntryQuery.setClassName(JournalArticle.class.getName());

				assetEntryQuery.setAnyTagIds(selectedTagIds);
				assetEntryQuery.setAnyCategoryIds(selectedCategoryIds);

				assetEntryQuery.setOrderByCol1(orderByColumn);
				assetEntryQuery.setOrderByType1(orderByType);

				assetEntryQuery.setStart(0);
				assetEntryQuery.setEnd(numbersOfEntriesDisplay);

				List<AssetEntry> queryList = AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);

				for (int i = 0; i < queryList.size(); i++) {

					AssetEntry assetEntry = queryList.get(i);

					AssetEntryCache entryCache = new AssetEntryCache();

					entryCache.setEntryId(assetEntry.getEntryId());
					entryCache.setClassNameId(assetEntry.getClassNameId());
					entryCache.setDescription(assetEntry.getDescription(PortalUtil.getLocale(request)));
					entryCache.setClassPK(assetEntry.getClassPK());
					entryCache.setTitle(assetEntry.getTitle(locale));
					entryCache.setViewContentURL(getViewContentURL(request, entryCache));
					entryCache.setPublishDate(assetEntry.getPublishDate());
					entryCache.setSmallImagePath(getSmallImagePath(request, assetEntry.getClassPK()));

					assetList.add(entryCache);
				}

				if (!assetList.isEmpty()) {

					if (updateCacheData(queryKey, assetList)) {
						updateSystemQueryKeys(queryKey);
					}
				}
			}
		}
		catch (SystemException e) {
			_log.error(e);
		}
		catch (PortalException e) {
			_log.error(e);
		}

		return assetList;
	}

	public static String getCategoryPropertyValue(long categoryId, String propertyKey, String defaultValue) {

		try {

			// Lay danh sach tat ca cac thuoc tinh dong cua Category theo
			// categoryId
			List<AssetCategoryProperty> propertyList =
				AssetCategoryPropertyLocalServiceUtil.getCategoryProperties(categoryId);

			if (propertyList.isEmpty()) {

				return defaultValue;

			}
			else {

				String propertyValue =
					AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(categoryId, propertyKey).getValue();

				return propertyValue;
			}
		}
		catch (Exception e) {

			if (e instanceof NoSuchCategoryPropertyException) {
				_log.info("No such categoryProperty exist with propertyKey = " + propertyKey);
			}
			else {
				_log.error(e);
			}
			return defaultValue;
		}
	}

	/**
	 * @todo TAO URL XEM CHI TIET NOI DUNG BAI VIET
	 * @author HUNGDX
	 * @date Nov 23, 2012
	 * @return String
	 */
	public static String getViewContentURL(HttpServletRequest request, AssetEntryCache assetEntry) {

		String viewContentURL = "";

		if (assetEntry != null) {
			try {

				long entryId = assetEntry.getEntryId();

				long classPK = assetEntry.getClassPK();

				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

				// layout id cua page hien thi chi tiet tin bai
				long pageLayoutId = themeDisplay.getLayout().getPlid();

				String className = PortalUtil.getClassName(assetEntry.getClassNameId());

				AssetRendererFactory assetRendererFactory =
					AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);

				AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(classPK);

				List<AssetCategory> assetCategoryList = AssetCategoryLocalServiceUtil.getEntryCategories(entryId);

				if (!assetCategoryList.isEmpty()) {

					AssetCategory assetCategory = assetCategoryList.get(0);

					List<AssetCategoryProperty> categoryPropertyList =
						AssetCategoryPropertyLocalServiceUtil.getCategoryProperties(assetCategory.getCategoryId());

					if (categoryPropertyList.size() > 0) {

						// layoutId la layoutId cua Page duoc chon de hien thi
						// tin bai theo tung Category
						// layoutId duoc luu duoi dang property cua Category voi
						// propertyKey = "link-to-page"
						// Cac thuoc tinh (property) cua Category duoc luu trong
						// bang assetcategoryproperty
						pageLayoutId =
							Long.parseLong(getCategoryPropertyValue(
								assetCategory.getCategoryId(), _PAGE_LAYOUT_ID_CATEGORY_PROPERTY_KEY,
								String.valueOf(pageLayoutId)));
					}
				}

				// Tao URL lien ket tu trang hien tai sang trang hien thi chi
				// tiet noi dung tin bai dua vao pageLayoutId
				// "101" la ten cua portlet Asset Publisher
				PortletURL viewFullContentURL =
					PortletURLFactoryUtil.create(request, "101", pageLayoutId, PortletRequest.RENDER_PHASE);

				viewFullContentURL.setWindowState(WindowState.NORMAL);
				viewFullContentURL.setPortletMode(PortletMode.VIEW);
				viewFullContentURL.setParameter("struts_action", "/asset_publisher/view_content");
				viewFullContentURL.setParameter("assetEntryId", String.valueOf(entryId));
				viewFullContentURL.setParameter("type", assetRendererFactory.getType());

				if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
					viewFullContentURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
				}

				viewContentURL = viewFullContentURL.toString();

			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		return viewContentURL;
	}

	/**
	 * @todo TAO DUONG DAN ANH MO TA CUA BAI VIET
	 * @author HUNGDX
	 * @date Nov 23, 2012
	 * @return String
	 */
	public static String getSmallImagePath(HttpServletRequest request, long classPK) {

		String smallImagePath = "";

		try {

			String languageId = LanguageUtil.getLanguageId(request);

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			// Dua vao classPK cua AssetEntry de lay tin bai chi tiet tuong ung
			// luu trong bang journalarticle
			JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(classPK);

			JournalArticleDisplay articleDisplay =
				JournalContentUtil.getDisplay(
					articleResource.getGroupId(), articleResource.getArticleId(), null, null, languageId, themeDisplay);
			if (articleDisplay.isSmallImage()) {// Neu tin bai co anh nho mo ta
												// thi method se tra ve duong
												// dan tuong doi cua anh mo ta

				long smallImageId = articleDisplay.getSmallImageId();

				if (smallImageId <= 0) {

					String smallImageURL = articleDisplay.getSmallImageURL();

					if (Validator.isNotNull(smallImageURL)) {
						smallImagePath = smallImageURL;
					}
				}
				else {

					Image smallImage = ImageLocalServiceUtil.fetchImage(smallImageId);

					if (smallImage != null) {

						String smallImageIdStr = String.valueOf(smallImageId);

						String[] smallImageIdStrSplitedArr = smallImageIdStr.split("(?<=\\G.{2})");

						StringBuilder stringBuilder = new StringBuilder();

						stringBuilder.append(_THUMBNAIL_FILTER_PATH);
						stringBuilder.append(_THUMBNAIL_DEFAULT_SIZE);
						stringBuilder.append(StringPool.SLASH);

						for (int i = 0; i < smallImageIdStrSplitedArr.length; i++) {

							stringBuilder.append(smallImageIdStrSplitedArr[i]);
							stringBuilder.append(StringPool.SLASH);
						}

						stringBuilder.append(smallImageId + "." + smallImage.getType());

						smallImagePath = stringBuilder.toString();
					}
				}
			}
		}
		catch (SystemException e) {
			_log.error(e);
		}
		catch (PortalException e) {
			_log.error(e);
		}

		return smallImagePath;
	}

	public static String getContentSummary(HttpServletRequest request, long classPK, int abstractLength) {

		String contentSummary = "";

		try {

			String languageId = LanguageUtil.getLanguageId(request);

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(classPK);

			JournalArticleDisplay articleDisplay =
				JournalContentUtil.getDisplay(
					articleResource.getGroupId(), articleResource.getArticleId(), null, null, languageId, themeDisplay);

			contentSummary = articleDisplay.getDescription();

			if (Validator.equals(contentSummary, StringPool.BLANK) || (contentSummary.length() <= 10)) {

				// Doi voi tin bai khong co mo ta ngan (Abstract) thi se cat 100
				// ky tu dau tien cua noi dung tin bai lam noi dung mo ta ngan
				contentSummary = StringUtil.shorten(articleDisplay.getContent(), 100);
			}

			if ((abstractLength > 0) && (abstractLength < contentSummary.length())) {

				// Cat noi dung mo ta tin bai theo do dai mo ta chon trong cau
				// hinh
				contentSummary = StringUtil.shorten(contentSummary, abstractLength);
			}
		}
		catch (Exception e) {
			_log.error(e);
		}

		return contentSummary;
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<AssetEntryCache> getCacheData(String queryKey) {

		if (!existQueryKey(queryKey)) {
			return new ArrayList<AssetEntryCache>();
		}

		Object cacheData = MemcacheUtil.getInstance().get(queryKey);

		if (cacheData != null) {
			return (ArrayList<AssetEntryCache>) cacheData;
		}
		else {
			return new ArrayList<AssetEntryCache>();
		}
	}

	private static boolean updateCacheData(String queryKey, List<AssetEntryCache> assetList) {

		return MemcacheUtil.getInstance().set(queryKey, assetList);
	}

	private static void updateSystemQueryKeys(String queryKey) {

		String systemQueryKeys = SystemProperties.get(_SYSTEM_QUERY_KEY);

		if (Validator.isNull(systemQueryKeys)) {
			systemQueryKeys = queryKey;
		}
		else {
			systemQueryKeys += StringPool.COMMA;
			systemQueryKeys += queryKey;
		}

		SystemProperties.set(_SYSTEM_QUERY_KEY, systemQueryKeys);
	}

	private static boolean existQueryKey(String queryKey) {

		if (Validator.isNull(SystemProperties.get(_SYSTEM_QUERY_KEY))) {
			return false;
		}
		else {
			return SystemProperties.get(_SYSTEM_QUERY_KEY).contains(queryKey);
		}
	}

	private static String buildQueryKey(
		long groupId, String queryName, String[] queryValues, String orderByColumn, String orderByType,
		int numbersOfEntriesDisplay)
		throws PortalException, SystemException {

		long[] queryIds = new long[queryValues.length];

		// Get asset entry list by Asset Tags
		if (Validator.equals(queryName, _ASSET_TAG_QUERY_NAME)) {

			queryIds = AssetTagLocalServiceUtil.getTagIds(groupId, queryValues);

		}
		else {
			for (int i = 0; i < queryValues.length; i++) {
				queryIds[i] = Long.parseLong(queryValues[i]);
			}
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < queryIds.length; i++) {

			stringBuilder.append(queryIds[i]);

			if (i < (queryIds.length - 1)) {
				stringBuilder.append(StringPool.DASH);
			}
		}

		stringBuilder.append(StringPool.UNDERLINE);

		stringBuilder.append(orderByColumn.toLowerCase());
		stringBuilder.append(StringPool.DASH);

		stringBuilder.append(orderByType.toLowerCase());
		stringBuilder.append(StringPool.DASH);

		stringBuilder.append(String.valueOf(numbersOfEntriesDisplay));

		return stringBuilder.toString();
	}

	private static Log _log = LogFactory.getLog(FocusAssetUtil.class);

	private static final int _DEFAULT_ASSET_SUMMARY_LENGTH = 300;

	private static final String _THUMBNAIL_FILTER_PATH = "/thumbnail/";

	private static final String _THUMBNAIL_DEFAULT_SIZE = "400x300";

	private static final String _SYSTEM_QUERY_KEY = "com.bkav.portal.memcache.key";

	public static final String _PAGE_LAYOUT_ID_CATEGORY_PROPERTY_KEY = "link-to-page";

	private static final String _ASSET_TAG_QUERY_NAME = "assetTags";
}
