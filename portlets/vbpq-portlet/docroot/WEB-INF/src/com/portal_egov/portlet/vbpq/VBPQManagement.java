package com.portal_egov.portlet.vbpq;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.DuplicateFolderNameException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.vbpq.model.VBPQ_Category;
import com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries;
import com.portal_egov.portlet.vbpq.model.VBPQ_Entry;
import com.portal_egov.portlet.vbpq.permission.VBPQCategoryPermission;
import com.portal_egov.portlet.vbpq.permission.VBPQEntryPermission;
import com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalServiceUtil;
import com.portal_egov.portlet.vbpq.service.VBPQ_DlFileEntriesLocalServiceUtil;
import com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil;
import com.portal_egov.portlet.vbpq.service.persistence.VBPQ_EntryFinderUtil;
import com.portal_egov.portlet.vbpq.util.FileAttachmentUtil;
import com.portal_egov.portlet.vbpq.util.VBPQConstants;

/**
 * Portlet implementation class VBPQManagement
 */
public class VBPQManagement extends MVCPortlet {

	public void savePortletConfig(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			long userId = PortalUtil.getUserId(actionRequest);

			long scopeGroupId = PortalUtil.getScopeGroupId(actionRequest);

			PortletPreferences preferences = PortletPreferencesFactoryUtil
					.getPortletSetup(actionRequest);

			long vbpqAttachmentFolderId = ParamUtil.getLong(actionRequest,
					"vbpqAttachmentFolderId", 0L);

			String folderName = ParamUtil
					.getString(actionRequest, "folderName");

			if (Validator.isNotNull(folderName)) {// Truong hop tao folder moi

				long parentFolderId = ParamUtil.getLong(actionRequest,
						"parentFolderId", 0L);

				ServiceContext serviceContext = ServiceContextFactory
						.getInstance(DLFolder.class.getName(), actionRequest);
				serviceContext
						.setGuestPermissions(new String[] { ActionKeys.VIEW });

				vbpqAttachmentFolderId = FileAttachmentUtil
						.createAttachmentFolder(userId, scopeGroupId,
								scopeGroupId, parentFolderId, folderName,
								serviceContext);
			}

			boolean autoCreateSubFolder = ParamUtil.getBoolean(actionRequest,
					"autoCreateSubFolder", true);

			preferences.setValue("vbpqAttachmentFolderId",
					String.valueOf(vbpqAttachmentFolderId));
			preferences.setValue("autoCreateSubFolder",
					String.valueOf(autoCreateSubFolder));

			preferences.store();

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL", StringPool.BLANK);

			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			if (e instanceof DuplicateFolderNameException) {
				_log.error(e);
				SessionErrors.add(actionRequest, "duplicate-folder-name");

			} else {
				_log.error(e);
			}
		}
	}

	public void updateCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			long categoryId = ParamUtil
					.getLong(actionRequest, "categoryId", 0L);

			long parentCategoryId = ParamUtil.getLong(actionRequest,
					"parentCategoryId", 0L);

			int categoryTypeId = ParamUtil.getInteger(actionRequest,
					"categoryTypeId", VBPQConstants.CATEGORY_ID);

			String categoryName = ParamUtil.getString(actionRequest,
					"categoryName", StringPool.BLANK);

			String categoryDesc = ParamUtil.getString(actionRequest,
					"categoryDesc", StringPool.BLANK);

			int displayPriority = ParamUtil.getInteger(actionRequest,
					"displayPriority", 0);

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL", StringPool.BLANK);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					VBPQ_Category.class.getName(), actionRequest);

			serviceContext
					.setGroupPermissions(new String[] { VBPQCategoryPermission.VIEW_CATEGORY });
			serviceContext
					.setGuestPermissions(new String[] { VBPQCategoryPermission.VIEW_CATEGORY });

			if (categoryId > 0) {

				VBPQ_CategoryLocalServiceUtil.updateCategory(categoryId,
						companyId, groupId, userId, parentCategoryId,
						categoryTypeId, categoryName, categoryDesc,
						displayPriority);
			} else {

				VBPQ_CategoryLocalServiceUtil.addCategory(companyId, groupId,
						userId, parentCategoryId, categoryTypeId, categoryName,
						categoryDesc, displayPriority, serviceContext);
			}

			actionResponse.sendRedirect(redirectURL);

		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			long companyId = PortalUtil.getCompanyId(actionRequest);
			long categoryId = ParamUtil
					.getLong(actionRequest, "categoryId", 0L);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL", StringPool.BLANK);

			if (categoryId > 0) {

				List<VBPQ_Entry> vbpqEntryList = VBPQ_EntryLocalServiceUtil
						.findByCategoryAndGroup(categoryId, groupId);

				VBPQ_Category vbpqCategory = VBPQ_CategoryLocalServiceUtil
						.getCategory(categoryId);

				for (VBPQ_Entry vbpqEntry : vbpqEntryList) {

					if (vbpqCategory.getTypeId() == VBPQConstants.DEPARTMENT_ID) {

						vbpqEntry.setDepartmentId(0);

					} else if (vbpqCategory.getTypeId() == VBPQConstants.CATEGORY_ID) {

						vbpqEntry.setCategoryId(0);

					} else if (vbpqCategory.getTypeId() == VBPQConstants.DOCUMENT_TYPE_ID) {

						vbpqEntry.setDocTypeId(0);

					} else {
						vbpqEntry.setDepartmentId(0);
						vbpqEntry.setCategoryId(0);
						vbpqEntry.setDocTypeId(0);
					}

					VBPQ_EntryLocalServiceUtil.updateVBPQ_Entry(vbpqEntry);
				}

				VBPQ_CategoryLocalServiceUtil.deleteCategory(companyId,
						categoryId);
			}

			actionResponse.sendRedirect(redirectURL);

		} catch (Exception e) {
			_log.error(e);
		}
	}

	/**
	 * @date Jun 22, 2012
	 * @author HungDX
	 * @RETURN void
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void updateVBPQEntry(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL", StringPool.BLANK);

			String[] selectedAttachmentFileNames = ParamUtil
					.getParameterValues(actionRequest, "selectedFileName",
							new String[0]);

			if (selectedAttachmentFileNames.length > 0) {// upload attachment
															// files and update
															// VBPQ Entry

				VBPQ_Entry vbpqEntry = updateVBPQContent(actionRequest,
						actionResponse);

				List<Long> vbpqFileAttactmentIdList = addFileAttachment(
						actionRequest, actionResponse);

				for (int i = 0; i < vbpqFileAttactmentIdList.size(); i++) {

					long vbpqDLfileEntryId = CounterLocalServiceUtil
							.increment();

					VBPQ_DlFileEntries vbpqDLfileEntry = VBPQ_DlFileEntriesLocalServiceUtil
							.createVBPQ_DlFileEntries(vbpqDLfileEntryId);

					vbpqDLfileEntry.setVbpqEntryId(vbpqEntry.getEntryId());
					vbpqDLfileEntry.setFileEntryId(vbpqFileAttactmentIdList
							.get(i));

					VBPQ_DlFileEntriesLocalServiceUtil
							.updateVBPQ_DlFileEntries(vbpqDLfileEntry, false);
				}
			} else { // Update vbpq entry and redirect
				updateVBPQContent(actionRequest, actionResponse);
			}

			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void deletaAllVBPQEntry(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			List<VBPQ_Entry> vbpq_Entries = VBPQ_EntryLocalServiceUtil
					.findAll();

			for (VBPQ_Entry vbpqEntry : vbpq_Entries) {
				if (vbpqEntry != null) {
					long entryId = vbpqEntry.getEntryId();
					// Ma so van ban tuong ung voi ten thu muc chua file
					// dinh kem van ban
					String entryCode = vbpqEntry.getEntryCode();

					long groupId = PortalUtil.getScopeGroupId(actionRequest);

					PortletPreferences preferences = PortletPreferencesFactoryUtil
							.getPortletSetup(actionRequest);

					long parentFolderId = GetterUtil.getLong(preferences
							.getValue("vbpqAttachmentFolderId", "0"));

					if (FileAttachmentUtil.checkExistDLFolder(groupId,
							parentFolderId, entryCode)) {

						DLFolder vbpqAttachmentDLFolder = DLFolderLocalServiceUtil
								.getFolder(groupId, parentFolderId, entryCode);

						List<FileEntry> vbpqFileAttachmentList = DLAppServiceUtil
								.getFileEntries(groupId,
										vbpqAttachmentDLFolder.getFolderId());

						for (FileEntry vbpqFileAttachment : vbpqFileAttachmentList) {

							DLAppServiceUtil.deleteFileEntry(vbpqFileAttachment
									.getFileEntryId());
						}

						DLAppServiceUtil.deleteFolder(vbpqAttachmentDLFolder
								.getFolderId());
					}

					List<VBPQ_DlFileEntries> vbpqDLFileEntryList = VBPQ_DlFileEntriesLocalServiceUtil
							.findByVBPQEntry(entryId);

					for (int i = 0; i < vbpqDLFileEntryList.size(); i++) {

						VBPQ_DlFileEntriesLocalServiceUtil
								.deleteVBPQ_DlFileEntries(vbpqDLFileEntryList
										.get(i));
					}

					VBPQ_EntryLocalServiceUtil.deleteVBPQ_Entry(entryId);
				}
			}
			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL", StringPool.BLANK);

			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteVBPQEntry(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			long entryId = ParamUtil.getLong(actionRequest, "entryId", 0);

			if (entryId > 0) {

				VBPQ_Entry vbpqEntry = VBPQ_EntryLocalServiceUtil
						.getVBPQ_Entry(entryId);

				if (vbpqEntry != null) {

					// Ma so van ban tuong ung voi ten thu muc chua file dinh
					// kem van ban
					String entryCode = vbpqEntry.getEntryCode();

					long groupId = PortalUtil.getScopeGroupId(actionRequest);

					PortletPreferences preferences = PortletPreferencesFactoryUtil
							.getPortletSetup(actionRequest);

					long parentFolderId = GetterUtil.getLong(preferences
							.getValue("vbpqAttachmentFolderId", "0"));

					if (FileAttachmentUtil.checkExistDLFolder(groupId,
							parentFolderId, entryCode)) {

						DLFolder vbpqAttachmentDLFolder = DLFolderLocalServiceUtil
								.getFolder(groupId, parentFolderId, entryCode);

						List<FileEntry> vbpqFileAttachmentList = DLAppServiceUtil
								.getFileEntries(groupId,
										vbpqAttachmentDLFolder.getFolderId());

						for (FileEntry vbpqFileAttachment : vbpqFileAttachmentList) {

							DLAppServiceUtil.deleteFileEntry(vbpqFileAttachment
									.getFileEntryId());
						}

						DLAppServiceUtil.deleteFolder(vbpqAttachmentDLFolder
								.getFolderId());
					}

					List<VBPQ_DlFileEntries> vbpqDLFileEntryList = VBPQ_DlFileEntriesLocalServiceUtil
							.findByVBPQEntry(entryId);

					for (int i = 0; i < vbpqDLFileEntryList.size(); i++) {

						VBPQ_DlFileEntriesLocalServiceUtil
								.deleteVBPQ_DlFileEntries(vbpqDLFileEntryList
										.get(i));
					}

					VBPQ_EntryLocalServiceUtil.deleteVBPQ_Entry(entryId);
				}
			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL", StringPool.BLANK);

			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteFileAttachment(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			long vbpqFileAttachmentId = ParamUtil.getLong(actionRequest,
					"vbpqFileAttachmentId", 0L);

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL", StringPool.BLANK);

			if (vbpqFileAttachmentId > 0) {

				DLFileEntryLocalServiceUtil
						.deleteDLFileEntry(vbpqFileAttachmentId);

				List<VBPQ_DlFileEntries> vbpqDLFileEntriesList = VBPQ_DlFileEntriesLocalServiceUtil
						.findByDLFileEntry(vbpqFileAttachmentId);

				for (int i = 0; i < vbpqDLFileEntriesList.size(); i++) {

					VBPQ_DlFileEntriesLocalServiceUtil
							.deleteVBPQ_DlFileEntries(vbpqDLFileEntriesList
									.get(i));
				}
			}

			actionResponse.sendRedirect(redirectURL);

		} catch (Exception e) {
			_log.error(e);
		}
	}

	public static void addTempAttachment(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		InputStream inputStream = null;

		try {

			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			long folderId = ParamUtil.getLong(actionRequest, "folderId", 0);

			String sourceFileName = uploadRequest.getFileName("file")
					.replaceAll(StringPool.COMMA, StringPool.BLANK);

			_log.info(sourceFileName);

			inputStream = uploadRequest.getFileAsStream("file");

			if (inputStream != null) {

				DLAppServiceUtil.addTempFileEntry(
						themeDisplay.getScopeGroupId(), folderId,
						sourceFileName, _TEMP_FOLDER_NAME, inputStream);
			}

		} catch (Exception e) {
			_log.error(e);
		} finally {
			StreamUtil.cleanUp(inputStream);
		}
	}

	public static void deleteTempAttachment(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		long folderId = ParamUtil.getLong(actionRequest, "folderId");

		String fileName = ParamUtil.getString(actionRequest, "fileName");

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		try {

			DLAppServiceUtil.deleteTempFileEntry(
					themeDisplay.getScopeGroupId(), folderId, fileName,
					_TEMP_FOLDER_NAME);

			jsonObject.put("deleted", Boolean.TRUE);
		} catch (SystemException e) {
			String errorMessage = LanguageUtil.get(themeDisplay.getLocale(),
					"an-unexpected-error-occurred-while-deleting-the-file");

			jsonObject.put("deleted", Boolean.FALSE);
			jsonObject.put("errorMessage", errorMessage);
		}

		HttpServletResponse response = PortalUtil
				.getHttpServletResponse(actionResponse);

		response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		ServletResponseUtil.write(response, jsonObject.toString());
	}

	protected VBPQ_Entry updateVBPQContent(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		VBPQ_Entry vbpqEntry = null;

		try {

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			long entryId = ParamUtil.getLong(actionRequest, "entryId", 0);

			String entryCode = ParamUtil.getString(actionRequest, "entryCode",
					StringPool.BLANK);

			String entryName = ParamUtil.getString(actionRequest, "entryName",
					StringPool.BLANK);

			String entryDesc = ParamUtil.getString(actionRequest, "entryDesc",
					StringPool.BLANK);

			long docTypeId = ParamUtil.getLong(actionRequest, "docTypeId", 0);

			long categoryId = ParamUtil.getLong(actionRequest, "categoryId", 0);

			long departmentId = ParamUtil.getLong(actionRequest,
					"departmentId", 0);

			String publicatorName = ParamUtil.getString(actionRequest,
					"publicatorName", StringPool.BLANK);

			Date publishDate = getDatePickerValue(actionRequest,
					VBPQ_PUBLISH_DAY, VBPQ_PUBLISH_MONTH, VBPQ_PUBLISH_YEAR);

			Date executeDate = getDatePickerValue(actionRequest,
					VBPQ_EXECUTE_DAY, VBPQ_EXECUTE_MONTH, VBPQ_EXECUTE_YEAR);

			Date expirationDate = getDatePickerValue(actionRequest,
					VBPQ_EXPIRATION_DAY, VBPQ_EXPIRATION_MONTH,
					VBPQ_EXPIRATION_YEAR);

			boolean neverExpired = GetterUtil.getBoolean(
					ParamUtil.getBoolean(actionRequest, "neverExpired"), true);

			String vbpqFileAttachmentURL = ParamUtil.getString(actionRequest,
					"vbpqFileAttachmentURL");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					VBPQ_Entry.class.getName(), actionRequest);

			serviceContext
					.setGroupPermissions(new String[] { VBPQEntryPermission.VIEW_VBPQ });
			serviceContext
					.setGuestPermissions(new String[] { VBPQEntryPermission.VIEW_VBPQ });

			if (entryId <= 0) { // Add new VBPQ Entry

				vbpqEntry = VBPQ_EntryLocalServiceUtil.addVBPQEntry(companyId,
						groupId, userId, departmentId, categoryId, docTypeId,
						entryName, entryCode, entryDesc, publicatorName,
						publishDate, executeDate, expirationDate, neverExpired,
						serviceContext);
			} else {// Update VBPQ Entry

				vbpqEntry = VBPQ_EntryLocalServiceUtil.updateVBPQEntry(entryId,
						companyId, groupId, userId, departmentId, categoryId,
						docTypeId, entryName, entryCode, entryDesc,
						publicatorName, publishDate, vbpqFileAttachmentURL,
						executeDate, expirationDate, neverExpired,
						serviceContext);
			}

		} catch (Exception e) {
			_log.error(e);
		}
		return vbpqEntry;
	}

	protected List<Long> addFileAttachment(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		long fileAttachmentId = 0L;

		List<String> validFileNameList = new ArrayList<String>();

		List<KeyValuePair> invalidFileNameKVPList = new ArrayList<KeyValuePair>();

		List<Long> fileAttachmentIdList = new ArrayList<Long>();

		try {

			String[] selectedFileNames = ParamUtil.getParameterValues(
					actionRequest, "selectedFileName", new String[0]);

			for (String selectedFileName : selectedFileNames) {

				fileAttachmentId = FileAttachmentUtil.addMultipleFileEntries(
						actionRequest, actionResponse, selectedFileName,
						validFileNameList, invalidFileNameKVPList);

				if (fileAttachmentId > 0) {

					fileAttachmentIdList.add(fileAttachmentId);
				}
			}

			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

			for (String validFileName : validFileNameList) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				jsonObject.put("added", Boolean.TRUE);
				jsonObject.put("fileName", validFileName);

				jsonArray.put(jsonObject);
			}

			for (KeyValuePair invalidFileNameKVP : invalidFileNameKVPList) {
				String fileName = invalidFileNameKVP.getKey();
				String errorMessage = invalidFileNameKVP.getValue();

				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				jsonObject.put("added", Boolean.FALSE);
				jsonObject.put("errorMessage", errorMessage);
				jsonObject.put("fileName", fileName);

				jsonArray.put(jsonObject);
			}

			writeJSON(actionRequest, actionResponse, jsonArray);

		} catch (Exception e) {
			_log.error(e);
		}

		return fileAttachmentIdList;
	}

	@Override
	protected void writeJSON(PortletRequest portletRequest,
			ActionResponse actionResponse, Object json) throws IOException {

		HttpServletResponse response = PortalUtil
				.getHttpServletResponse(actionResponse);

		response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		ServletResponseUtil.write(response, json.toString());
	}

	/**
	 * @todo LAY GIA TRI TU DATE PICKER TREN FORM UPDATE
	 * @author HungDX
	 * @date Aug 16, 2012
	 * @return Date
	 * @param actionRequest
	 * @param dayParam
	 * @param monthParam
	 * @param yearParam
	 * @return
	 */
	private static Date getDatePickerValue(ActionRequest actionRequest,
			String dayParam, String monthParam, String yearParam) {

		Calendar calendar = CalendarFactoryUtil.getCalendar();

		try {

			int dayValue = ParamUtil.getInteger(actionRequest, dayParam,
					calendar.get(Calendar.DATE));

			int monthValue = ParamUtil.getInteger(actionRequest, monthParam,
					calendar.get(Calendar.MONTH));

			int yearValue = ParamUtil.getInteger(actionRequest, yearParam,
					calendar.get(Calendar.YEAR));

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			Date datePickerValue = PortalUtil.getDate(monthValue, dayValue,
					yearValue, themeDisplay.getTimeZone(),
					new PortalException());

			return datePickerValue;
		} catch (Exception e) {
			_log.error(e);
			return calendar.getTime();
		}
	}

	private static final String _TEMP_FOLDER_NAME = VBPQManagement.class
			.getName();

	private static final String VBPQ_PUBLISH_DAY = "vbpqPublishDay";
	private static final String VBPQ_PUBLISH_MONTH = "vbpqPublishMonth";
	private static final String VBPQ_PUBLISH_YEAR = "vbpqPublishYear";

	private static final String VBPQ_EXECUTE_DAY = "vbpqExecuteDay";
	private static final String VBPQ_EXECUTE_MONTH = "vbpqExecuteMonth";
	private static final String VBPQ_EXECUTE_YEAR = "vbpqExecuteYear";

	private static final String VBPQ_EXPIRATION_DAY = "vbpqExpirationDay";
	private static final String VBPQ_EXPIRATION_MONTH = "vbpqExpirationMonth";
	private static final String VBPQ_EXPIRATION_YEAR = "vbpqExpirationYear";

	private static Log _log = LogFactory.getLog(VBPQManagement.class);
}
