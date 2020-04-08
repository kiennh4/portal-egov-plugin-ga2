package com.bkav.portal.portlet.site_display_setting;

import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bkav.portal.portlet.site_display_setting.util.ExpandoUtil;
import com.bkav.portal.portlet.site_display_setting.util.PortletPropsValues;
import com.bkav.portal.portlet.site_display_setting.util.SiteSettingConstants;
import com.liferay.portal.ImageTypeException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.ImageSizeException;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SiteDisplaySettingsPortlet
 */
public class SiteDisplaySettingsPortlet extends MVCPortlet {

	public void updateHeaderContent(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		InputStream bannerImageStream = null;

		try {

			UploadPortletRequest uploadPortletRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);

			long bannerImageId = ParamUtil.getLong(uploadPortletRequest,
					"bannerImageId");

			bannerImageStream = uploadPortletRequest
					.getFileAsStream("bannerImageFile");

			if (bannerImageStream != null) {

				String bannerImageFileName = uploadPortletRequest
						.getFileName("bannerImageFile");

				byte[] bannerImageBytes = FileUtil.getBytes(bannerImageStream);

				if (validateFile(bannerImageFileName, bannerImageBytes.length)) {

					long repositoryId = PortalUtil
							.getScopeGroupId(uploadPortletRequest);

					long folderId = CompanyConstants.SYSTEM;

					String mimeType = MimeTypesUtil
							.getContentType(bannerImageFileName);

					ServiceContext serviceContext = ServiceContextFactory
							.getInstance(FileEntry.class.getName(),
									actionRequest);

					serviceContext
							.setGroupPermissions(new String[] { ActionKeys.VIEW });
					serviceContext
							.setGuestPermissions(new String[] { ActionKeys.VIEW });

					String timeStampFileName = String
							.valueOf(System.nanoTime())
							+ StringPool.PERIOD
							+ FileUtil.getExtension(bannerImageFileName);

					if (bannerImageId > 0) {

						DLAppServiceUtil.updateFileEntry(bannerImageId,
								timeStampFileName, mimeType, timeStampFileName,
								StringPool.BLANK, StringPool.BLANK, true,
								bannerImageBytes, serviceContext);
					} else {

						FileEntry fileEntry = DLAppServiceUtil.addFileEntry(
								repositoryId, folderId, timeStampFileName,
								mimeType, timeStampFileName, StringPool.BLANK,
								StringPool.BLANK, bannerImageBytes,
								serviceContext);

						long groupId = PortalUtil
								.getScopeGroupId(actionRequest);

						LayoutSet layoutSet = LayoutSetLocalServiceUtil
								.getLayoutSet(groupId, false);

						if (layoutSet != null) {

							ExpandoBridge expandoBridge = layoutSet
									.getExpandoBridge();

							if (expandoBridge != null) {

								ExpandoUtil
										.updateColumnValue(
												PortalUtil
														.getCompanyId(actionRequest),
												expandoBridge,
												SiteSettingConstants.BANNER_IMAGE_ID_COLUMN_NAME,
												ExpandoColumnConstants.LONG,
												fileEntry.getFileEntryId());
							}
						}
					}
				}
			}

			String redirectURL = ParamUtil.getString(uploadPortletRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e.getClass());
			SessionErrors.add(actionRequest, e.getClass().getName());
		} finally {
			StreamUtil.cleanUp(bannerImageStream);
		}
	}

	public void updateSloganContent(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			ExpandoBridge expandoBridge = null;

			String sloganContent = ParamUtil.getString(actionRequest,
					"sloganContent");

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(
					groupId, false);

			if (layoutSet != null) {
				expandoBridge = layoutSet.getExpandoBridge();
				if (expandoBridge != null) {
					ExpandoUtil.updateColumnValue(
							PortalUtil.getCompanyId(actionRequest),
							expandoBridge, SiteSettingConstants.HEADER_SLOGAN,
							ExpandoColumnConstants.STRING, sloganContent);
				}
			}
			String redirectUrl = ParamUtil.getString(actionRequest,
					"redirectUrl");

			if (Validator.isNotNull(redirectUrl)) {
				actionResponse.sendRedirect(redirectUrl);
			}
		} catch (Exception e) {
			_log.error(e.getClass());
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	public void updateSiteInfo(ActionRequest actionRequest, ActionResponse actionResponse){
		try {
			ExpandoBridge expandoBridge = null;
			
			String headline = ParamUtil.getString(actionRequest, "headline");
			
			String image_url = ParamUtil.getString(actionRequest, "siteImage");
			
			String url = ParamUtil.getString(actionRequest, "url");
			
			String description  = ParamUtil.getString(actionRequest, "description");
			
			String type = ParamUtil.getString(actionRequest, "type");
			
			String keywords = ParamUtil.getString(actionRequest, "keywords");
			
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			
			LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId,false);
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			
			if(layoutSet != null){
				expandoBridge = layoutSet.getExpandoBridge();
				ExpandoUtil.updateColumnValue(companyId,
						expandoBridge, SiteSettingConstants.HEADLINE,
						ExpandoColumnConstants.STRING, headline);
				ExpandoUtil.updateColumnValue(companyId,
						expandoBridge, SiteSettingConstants.URL,
						ExpandoColumnConstants.STRING, url);
				ExpandoUtil.updateColumnValue(companyId,
						expandoBridge, SiteSettingConstants.KEYWORDS,
						ExpandoColumnConstants.STRING, keywords);
				ExpandoUtil.updateColumnValue(companyId,
						expandoBridge, SiteSettingConstants.TYPE,
						ExpandoColumnConstants.STRING, type);
				ExpandoUtil.updateColumnValue(companyId,
						expandoBridge, SiteSettingConstants.IMAGE_URL,
						ExpandoColumnConstants.STRING, image_url);
				ExpandoUtil.updateColumnValue(companyId,
						expandoBridge, SiteSettingConstants.DESCRIPTION,
						ExpandoColumnConstants.STRING, description);
			}
			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
		} catch (Exception e) {
			_log.error(e.getClass());
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	public void updateFooterContent(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			ExpandoBridge expandoBridge = null;

			String footerContent = ParamUtil.getString(actionRequest,
					"footerContent");

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(
					groupId, false);

			if (layoutSet != null) {

				expandoBridge = layoutSet.getExpandoBridge();

				if (expandoBridge != null) {

					ExpandoUtil.updateColumnValue(
							PortalUtil.getCompanyId(actionRequest),
							expandoBridge,
							SiteSettingConstants.FOOTER_CONTENT_COLUMN_NAME,
							ExpandoColumnConstants.STRING, footerContent);
				}
			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e.getClass());
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}

	private boolean validateFile(String fileName, long fileSize)
			throws ImageTypeException, ImageSizeException {

		boolean flag = false;

		String[] validExtensions = PortletPropsValues.SITE_BANNER_EXTENSIONS;

		// Validate upload file extension
		for (int i = 0; i < validExtensions.length; i++) {

			String validExtension = validExtensions[i].toLowerCase();

			if (!Validator.equals(validExtension, StringPool.STAR)
					&& StringUtil.endsWith(fileName, validExtension)) {

				flag = true;
				break;
			}
		}

		if (!flag) {

			throw new ImageTypeException();
		}

		long bannerImageMaxSize = PortletPropsValues.SITE_BANNER_MAX_SIZE;

		// Validate upload file size
		if ((bannerImageMaxSize > 0) && (fileSize > bannerImageMaxSize)) {

			throw new ImageSizeException();
		} else {

			flag = true;
		}

		return flag;
	}

	private final static Log _log = LogFactoryUtil
			.getLog(SiteDisplaySettingsPortlet.class);
}
