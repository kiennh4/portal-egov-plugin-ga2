package com.bkav.portal.portlet.site_display_setting.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class SiteSettingUtil {

	public static String getImageBannerFilePath(HttpServletRequest request,
			long bannerImageId) throws Exception, PortalException {
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil
				.getFileEntry(bannerImageId);

		fileEntry = fileEntry.toEscapedModel();

		long folderId = fileEntry.getFolderId();
		String title = fileEntry.getTitle();

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		String fileUrl = themeDisplay.getPortalURL()
				+ themeDisplay.getPathContext() + "/documents/"
				+ themeDisplay.getScopeGroupId() + "//" + folderId + "//"
				+ HttpUtil.encodeURL(HtmlUtil.unescape(title));

		return fileUrl;

	}

	public static String getImageBannerMimeType(HttpServletRequest request,
			long bannerImageId) throws Exception, PortalException {
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil
				.getFileEntry(bannerImageId);

		fileEntry = fileEntry.toEscapedModel();

		String extension = fileEntry.getExtension();

		return extension;

	}

	public static long getBannerImageId(long layoutSetId) {

		long bannerImageId = 0L;
		long columnId = 0L;
		long tableId = 0L;
		try {
			LayoutSet layoutSet = LayoutSetLocalServiceUtil
					.getLayoutSet(layoutSetId);

			if (layoutSet != null) {

				ExpandoBridge expandoBridge = layoutSet.getExpandoBridge();

				if (expandoBridge != null) {

					ExpandoTable expandoTable = ExpandoTableLocalServiceUtil
							.getDefaultTable(expandoBridge.getCompanyId(),
									expandoBridge.getClassName());

					if (expandoTable != null) {

						ExpandoColumn column = ExpandoUtil
								.getColumn(
										expandoBridge,
										SiteSettingConstants.BANNER_IMAGE_ID_COLUMN_NAME,
										ExpandoTableConstants.DEFAULT_TABLE_NAME);

						if (column != null) {
							columnId = column.getColumnId();
							tableId = column.getTableId();
							long classPK = layoutSet.getPrimaryKey();

							ExpandoValue bannerValue = ExpandoValueLocalServiceUtil
									.getValue(tableId, columnId, classPK);

							if (bannerValue != null) {
								bannerImageId = GetterUtil.getLong(
										bannerValue.getData(), 0L);
							}
						}
					}
				}
			}

		} catch (Exception e) {
			_log.error(e);
		}

		return bannerImageId;
	}

	public static String getFooterContent(long layoutSetId) {

		String footerContent = "";
		long columnId = 0L;
		long tableId = 0L;
		try {

			LayoutSet layoutSet = LayoutSetLocalServiceUtil
					.getLayoutSet(layoutSetId);

			if (layoutSet != null) {

				ExpandoBridge expandoBridge = layoutSet.getExpandoBridge();

				if (expandoBridge != null) {

					ExpandoTable expandoTable = ExpandoTableLocalServiceUtil
							.getDefaultTable(expandoBridge.getCompanyId(),
									expandoBridge.getClassName());

					if (expandoTable != null) {

						ExpandoColumn column = ExpandoUtil
								.getColumn(
										expandoBridge,
										SiteSettingConstants.FOOTER_CONTENT_COLUMN_NAME,
										ExpandoTableConstants.DEFAULT_TABLE_NAME);

						if (column != null) {
							columnId = column.getColumnId();
							tableId = column.getTableId();
							long classPK = layoutSet.getPrimaryKey();

							ExpandoValue contentfooterValue = ExpandoValueLocalServiceUtil
									.getValue(tableId, columnId, classPK);

							if (contentfooterValue != null) {
								footerContent = GetterUtil.getString(
										contentfooterValue.getData(),
										StringPool.BLANK);
							}
						}
					}
				}
			}

		} catch (Exception e) {
			_log.error(e);
		}

		return footerContent;
	}

	public static String getSloganContent(long layoutSetId) {
		String sloganContent = "";
		long columnId = 0L;
		long tableId = 0L;
		try {
			LayoutSet layoutSet = LayoutSetLocalServiceUtil
					.getLayoutSet(layoutSetId);
			if (layoutSet != null) {
				ExpandoBridge expandoBridge = layoutSet.getExpandoBridge();

				if (expandoBridge != null) {
					ExpandoTable expandoTable = ExpandoTableLocalServiceUtil
							.getDefaultTable(expandoBridge.getCompanyId(),
									expandoBridge.getClassName());

					if (expandoTable != null) {
						ExpandoColumn expandoColumn = ExpandoUtil.getColumn(
								expandoBridge,
								SiteSettingConstants.HEADER_SLOGAN,
								ExpandoTableConstants.DEFAULT_TABLE_NAME);

						if (expandoColumn != null) {
							columnId = expandoColumn.getColumnId();
							tableId = expandoColumn.getTableId();
							long classPK = layoutSet.getPrimaryKey();

							ExpandoValue sloganContentValue = ExpandoValueLocalServiceUtil
									.getValue(tableId, columnId, classPK);
							if (sloganContentValue != null) {
								sloganContent = GetterUtil.getString(
										sloganContentValue.getData(),
										StringPool.BLANK);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return sloganContent;
	}
	public static Map<String,String> getSiteInfo(long layoutSetId){
		Map<String, String> siteInfo = new HashMap<String, String>();
		try {
			LayoutSet layoutSet = LayoutSetLocalServiceUtil
					.getLayoutSet(layoutSetId);
			if (layoutSet != null) {
				ExpandoBridge expandoBridge = layoutSet.getExpandoBridge();

				if (expandoBridge != null) {
					String headline = getValueFromExpando(layoutSet, expandoBridge, SiteSettingConstants.HEADLINE);
					
					siteInfo.put(SiteSettingConstants.HEADLINE, headline);
					
					String imageUrl = getValueFromExpando(layoutSet, expandoBridge, SiteSettingConstants.IMAGE_URL);
					siteInfo.put(SiteSettingConstants.IMAGE_URL, imageUrl);
					
					String url = getValueFromExpando(layoutSet, expandoBridge, SiteSettingConstants.URL);
					siteInfo.put(SiteSettingConstants.URL, url);
					
					String keywords = getValueFromExpando(layoutSet, expandoBridge, SiteSettingConstants.KEYWORDS);
					siteInfo.put(SiteSettingConstants.KEYWORDS, keywords);
					
					String description = getValueFromExpando(layoutSet, expandoBridge, SiteSettingConstants.DESCRIPTION);
					siteInfo.put(SiteSettingConstants.DESCRIPTION, description);
					
					String type = getValueFromExpando(layoutSet, expandoBridge, SiteSettingConstants.TYPE);
					siteInfo.put(SiteSettingConstants.TYPE, type);
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return siteInfo;
	}
	
	private static String getValueFromExpando(LayoutSet layoutSet,ExpandoBridge expandoBridge, String columnName) throws PortalException, SystemException{
		String value = "";
		long columnId = 0L;
		long tableId = 0L;

		if (expandoBridge != null) {
			ExpandoTable expandoTable = ExpandoTableLocalServiceUtil
					.getDefaultTable(expandoBridge.getCompanyId(),
							expandoBridge.getClassName());

			if (expandoTable != null) {
				ExpandoColumn expandoColumn = ExpandoUtil.getColumn(
						expandoBridge,
						columnName,
						ExpandoTableConstants.DEFAULT_TABLE_NAME);

				if (expandoColumn != null) {
					columnId = expandoColumn.getColumnId();
					tableId = expandoColumn.getTableId();
					long classPK = layoutSet.getPrimaryKey();

					ExpandoValue contentValue = ExpandoValueLocalServiceUtil
							.getValue(tableId, columnId, classPK);
					if (contentValue != null) {
						value = GetterUtil.getString(
								contentValue.getData(),
								StringPool.BLANK);
					}
				}
			}
		}
		return value;
	}
	private final static Log _log = LogFactoryUtil
			.getLog(SiteSettingUtil.class);
}
