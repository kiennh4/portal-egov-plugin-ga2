package com.portal_egov.portlet.tthc;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
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
import com.portal_egov.portlet.tthc.model.TTHC_Attribute;
import com.portal_egov.portlet.tthc.model.TTHC_Entry;
import com.portal_egov.portlet.tthc.permission.TTHCAttributePermission;
import com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalServiceUtil;
import com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil;
import com.portal_egov.portlet.tthc.util.TTHCConstants;
import com.portal_egov.portlet.tthc.util.TTHCFileAttachmentUtil;

/**
 * Portlet implementation class TTHCEntryManagement
 */
public class TTHCAdmin extends MVCPortlet {

	/**
	 * @todo CAP NHAT THONG TIN CAU HINH UPLOAD FILE DINH KEM THU TUC
	 * @author HungDX
	 * @date Aug 20, 2012
	 * @return void
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void updateTTHCSettings(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			long userId = PortalUtil.getUserId(actionRequest);

			long scopeGroupId = PortalUtil.getScopeGroupId(actionRequest);

			PortletPreferences preferences = PortletPreferencesFactoryUtil
					.getPortletSetup(actionRequest);

			long tthcAttachmentFolderId = ParamUtil.getLong(actionRequest,
					"tthcAttachmentFolderId", 0L);

			String folderName = ParamUtil
					.getString(actionRequest, "folderName");

			if (Validator.isNotNull(folderName)) {// Truong hop tao moi thu muc
				long parentFolderId = ParamUtil.getLong(actionRequest,
						"parentFolderId", 0L);

				ServiceContext serviceContext = ServiceContextFactory
						.getInstance(DLFolder.class.getName(), actionRequest);
				serviceContext
						.setGuestPermissions(new String[] { ActionKeys.VIEW });

				tthcAttachmentFolderId = TTHCFileAttachmentUtil
						.createAttachmentFolder(userId, scopeGroupId,
								scopeGroupId, parentFolderId, folderName,
								serviceContext);
			}

			boolean autoCreateSubFolder = ParamUtil.getBoolean(actionRequest,
					"autoCreateSubFolder", true);

			preferences.setValue("tthcAttachmentFolderId",
					String.valueOf(tthcAttachmentFolderId));
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

			} else if (e instanceof NoSuchFolderException) {
				_log.error(e);
			} else {
				e.printStackTrace();
				_log.error(e);
			}
		}
	}

	/**
	 * @todo UPDATE THU TUC HANH CHINH
	 * @author HungDX
	 * @date Aug 22, 2012
	 * @return void
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void updateTTHCEntry(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			long tthcEntryId = ParamUtil.getLong(actionRequest, "tthcEntryId",
					0L);

			String[] selectedFileNames = ParamUtil.getParameterValues(
					actionRequest, "selectedFileName", new String[0]);

			if (selectedFileNames.length > 0) {// Truong hop co upload file dinh
												// kem
				// Update thong tin co ban cua thu tuc
				TTHC_Entry tthcEntry = ActionUtil.updateTTHCInfomation(
						tthcEntryId, actionRequest, actionResponse);

				if (tthcEntry != null) {

					tthcEntryId = tthcEntry.getEntryId();

					// Update danh sach VBPQ quy dinh thu tuc (mapping form)
					ActionUtil.updateVBPQMapping(tthcEntryId, actionRequest,
							actionResponse);

					// Upload van ban,bieu mau dinh kem thu tuc
					updateFileAttachment(tthcEntryId, actionRequest,
							actionResponse);
				}
			} else {// Khong upload file dinh kem

				// Update thong tin co ban cua thu tuc
				TTHC_Entry tthcEntry = ActionUtil.updateTTHCInfomation(
						tthcEntryId, actionRequest, actionResponse);

				if (tthcEntry != null) {

					tthcEntryId = tthcEntry.getEntryId();

					// Update danh sach VBPQ quy dinh thu tuc (mapping form)
					ActionUtil.updateVBPQMapping(tthcEntryId, actionRequest,
							actionResponse);
				}
			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL", StringPool.BLANK);

			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteAllTTHCEntry(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			List<TTHC_Entry> entries = TTHC_EntryLocalServiceUtil.findAll();
			for (TTHC_Entry entry : entries) {
				if (entry != null) {
					String attachmentFolderName = entry.getEntryCode();

					long groupId = PortalUtil.getScopeGroupId(actionRequest);

					PortletPreferences preferences = PortletPreferencesFactoryUtil
							.getPortletSetup(actionRequest);
					long parentFolderId = GetterUtil.getLong(preferences
							.getValue("tthcAttachmentFolderId", "0"));

					if (TTHCFileAttachmentUtil.checkExistDLFolder(groupId,
							parentFolderId, attachmentFolderName)) {
						DLFolder tthcAttachmentDlFolder = DLFolderLocalServiceUtil
								.getFolder(groupId, parentFolderId,
										attachmentFolderName);

						List<FileEntry> tthcAttachmentFileList = DLAppServiceUtil
								.getFileEntries(groupId,
										tthcAttachmentDlFolder.getFolderId());
						for (FileEntry tthcAttachmentFile : tthcAttachmentFileList) {
							DLAppServiceUtil.deleteFileEntry(tthcAttachmentFile
									.getFileEntryId());
						}

						DLAppServiceUtil.deleteFolder(tthcAttachmentDlFolder
								.getFolderId());
					}

					List<TTHC_Attribute> tthc_Attributes = TTHC_AttributeLocalServiceUtil
							.findByTTHCEntryAndGroup(groupId,
									entry.getEntryId());

					for (TTHC_Attribute attribute : tthc_Attributes) {
						TTHC_AttributeLocalServiceUtil
								.deleteTTHC_Attribute(attribute
										.getAttributeId());
					}

					TTHC_EntryLocalServiceUtil.deleteTTHC_Entry(entry
							.getEntryId());
				}
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	/**
	 * @todo XOA THU TUC HANH CHINH
	 * @author HungDX
	 * @date Aug 22, 2012
	 * @return void
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void deleteTTHCEntry(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			long tthcEntryId = ParamUtil.getLong(actionRequest, "tthcEntryId",
					0L);

			if (tthcEntryId > 0) {

				TTHC_Entry tthcEntry = TTHC_EntryLocalServiceUtil
						.getTTHC_Entry(tthcEntryId);

				if (tthcEntry != null) {

					String attachmentFolderName = tthcEntry.getEntryCode();

					long groupId = PortalUtil.getScopeGroupId(actionRequest);

					PortletPreferences preferences = PortletPreferencesFactoryUtil
							.getPortletSetup(actionRequest);

					long parentFolderId = GetterUtil.getLong(preferences
							.getValue("tthcAttachmentFolderId", "0"));

					if (TTHCFileAttachmentUtil.checkExistDLFolder(groupId,
							parentFolderId, attachmentFolderName)) {

						DLFolder tthcAttachmentDLFolder = DLFolderLocalServiceUtil
								.getFolder(groupId, parentFolderId,
										attachmentFolderName);

						List<FileEntry> tthcFileAttachmentList = DLAppServiceUtil
								.getFileEntries(groupId,
										tthcAttachmentDLFolder.getFolderId());

						for (FileEntry tthcFileAttachment : tthcFileAttachmentList) {

							DLAppServiceUtil.deleteFileEntry(tthcFileAttachment
									.getFileEntryId());
						}

						DLAppServiceUtil.deleteFolder(tthcAttachmentDLFolder
								.getFolderId());
					}

					// Danh sach cac attribute tuong ung voi Id cua thu tuc
					List<TTHC_Attribute> tthcAttributeList = TTHC_AttributeLocalServiceUtil
							.findByTTHCEntryAndGroup(groupId, tthcEntryId);

					// Xoa het cac attribute cua thu tuc luu trong bang
					// TTHC_ATTRIBUTE
					for (TTHC_Attribute tthcAttribute : tthcAttributeList) {
						TTHC_AttributeLocalServiceUtil
								.deleteTTHC_Attribute(tthcAttribute);
					}
					// Xoa thu tuc
					TTHC_EntryLocalServiceUtil.deleteTTHC_Entry(tthcEntryId);
				}
			}
			String redirect = ParamUtil.get(actionRequest, "redirectURL", "");
			
			actionResponse.sendRedirect(redirect);

		} catch (Exception e) {
			if (e instanceof NoSuchTTHC_EntryException) {
				System.out.println(e.getClass().getName());
			} else {
				_log.error(e);
			}
		}
	}

	/**
	 * @todo XOA FILE DINH KEM CUA TTHC
	 * @author HungDX
	 * @date Aug 21, 2012
	 * @return void
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void deleteFileAttachment(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {
			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			// Id cua thu tuc hien tai
			long tthcEntryId = ParamUtil.getLong(actionRequest, "tthcEntryId",
					0L);

			// Id cua file dinh kem
			long tthcFileAttachmentId = ParamUtil.getLong(actionRequest,
					"tthcFileAttachmentId", 0L);

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL", StringPool.BLANK);

			if (tthcFileAttachmentId > 0) {

				// Danh sach cac attribute luu id cua file dinh kem tuong ung
				// voi thu tuc
				List<TTHC_Attribute> fileAttachmentAttributeList = TTHC_AttributeLocalServiceUtil
						.findByTTHCEntryAndAttrTypeAndGroup(groupId,
								tthcEntryId,
								TTHCConstants.FILE_ATTACHMENT_ATTRIBUTE_TYPE_ID);

				for (TTHC_Attribute fileAttachmentAttribute : fileAttachmentAttributeList) {

					// Id cua file dinh kem tuong ung voi tung attribute
					long fileAttrachmentAttributeValue = GetterUtil
							.getLong(fileAttachmentAttribute
									.getAttributeValue());

					if (fileAttrachmentAttributeValue == tthcFileAttachmentId) {
						// Truong hop value cua Attribute = Id cua file dinh kem can xoa. Xoa cac Attribute tuong ung
						TTHC_AttributeLocalServiceUtil
								.deleteTTHC_Attribute(fileAttachmentAttribute);
					}
				}

				// Xoa file dinh kem luu tren server
				DLFileEntryLocalServiceUtil
						.deleteDLFileEntry(tthcFileAttachmentId);
			}

			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	/**
	 * @todo UPLOAD TAM THOI FILE DINH KEM THU TUC
	 * @author HungDX
	 * @date Aug 22, 2012
	 * @return void
	 * @param actionRequest
	 * @param actionResponse
	 */
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

			inputStream = uploadRequest.getFileAsStream("file");

			if (inputStream != null) {

				DLAppServiceUtil
						.addTempFileEntry(
								themeDisplay.getScopeGroupId(),
								folderId,
								sourceFileName,
								TTHCConstants.DEFAULT_TTHC_FILE_ATTACHMENT_TEMP_FOLDER_NAME,
								inputStream);
			}

		} catch (Exception e) {
			_log.error(e);
		} finally {
			StreamUtil.cleanUp(inputStream);
		}
	}

	/**
	 * @todo XOA FILE UPLOAD TAM THOI
	 * @author HungDX
	 * @date Aug 22, 2012
	 * @return void
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public static void deleteTempAttachment(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		long folderId = ParamUtil.getLong(actionRequest, "folderId");

		String fileName = ParamUtil.getString(actionRequest, "fileName");

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		try {

			DLAppServiceUtil
					.deleteTempFileEntry(
							themeDisplay.getScopeGroupId(),
							folderId,
							fileName,
							TTHCConstants.DEFAULT_TTHC_FILE_ATTACHMENT_TEMP_FOLDER_NAME);

			jsonObject.put("deleted", Boolean.TRUE);
		} catch (Exception e) {
			String errorMessage = LanguageUtil.get(themeDisplay.getLocale(),
					"an-unexpected-error-occurred-while-deleting-the-file");

			jsonObject.put("deleted", Boolean.FALSE);
			jsonObject.put("errorMessage", errorMessage);

			_log.error(e);
		}

		HttpServletResponse response = PortalUtil
				.getHttpServletResponse(actionResponse);

		response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		ServletResponseUtil.write(response, jsonObject.toString());
	}

	/**
	 * @todo LUU ID CUA VAN BAN,TAI LIEU DINH KEM THU TUC VAO TTHC_ATTRIBUTE
	 * @author HungDX
	 * @date Aug 22, 2012
	 * @return void
	 * @param tthcEntryId
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void updateFileAttachment(long tthcEntryId,
			ActionRequest actionRequest, ActionResponse actionResponse) {

		try {
			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			// Danh sach Id cua van ban,tai lieu dinh kem thu tuc sau khi da
			// duoc upload len server
			List<Long> fileAttachmentIdList = uploadFileAttachment(
					actionRequest, actionResponse);

			if (fileAttachmentIdList.size() > 0) {

				// Luu lan luot cac Id vao tthc attribute
				for (int fileAttachmentIndex = 0; fileAttachmentIndex < fileAttachmentIdList
						.size(); fileAttachmentIndex++) {

					String fileAttachmentAttributeValue = String
							.valueOf(fileAttachmentIdList
									.get(fileAttachmentIndex));

					long companyId = PortalUtil.getCompanyId(actionRequest);

					long userId = PortalUtil.getUserId(actionRequest);

					ServiceContext serviceContext = ServiceContextFactory
							.getInstance(TTHC_Attribute.class.getName(),
									actionRequest);

					serviceContext
							.setGuestPermissions(new String[] { TTHCAttributePermission.VIEW_ATTRIBUTE });
					serviceContext
							.setGroupPermissions(new String[] { TTHCAttributePermission.VIEW_ATTRIBUTE });

					// Add attribute
					TTHC_AttributeLocalServiceUtil.addTTHCAttribute(companyId,
							groupId, userId, tthcEntryId,
							TTHCConstants.FILE_ATTACHMENT_ATTRIBUTE_TYPE_ID,
							fileAttachmentIndex,
							TTHCConstants.FILE_ATTACHMENT_ATTRIBUTE_NAME,
							fileAttachmentAttributeValue, serviceContext);
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	/**
	 * 
	 * @todo UPLOAD VAN BAN,BIEU MAU DINH KEM TTHC
	 * @author HungDX
	 * @date Jul 3, 2012
	 * @return List<Long>
	 * @param actionRequest
	 * @param actionResponse
	 * @return Tra ve Danh sach (List) Id cua cac van ban,file dinh kem thu tuc
	 *         sau khi upload len server
	 */
	protected List<Long> uploadFileAttachment(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		long fileAttachmentId = 0L;

		List<String> validFileNameList = new ArrayList<String>();

		List<KeyValuePair> invalidFileNameKVPList = new ArrayList<KeyValuePair>();

		List<Long> fileAttachmentIdList = new ArrayList<Long>();

		try {

			String[] selectedFileNames = ParamUtil.getParameterValues(
					actionRequest, "selectedFileName", new String[0]);

			for (String selectedFileName : selectedFileNames) {

				fileAttachmentId = TTHCFileAttachmentUtil
						.addMultipleFileEntries(actionRequest, actionResponse,
								selectedFileName, validFileNameList,
								invalidFileNameKVPList);
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

	protected void writeJSON(PortletRequest portletRequest,
			ActionResponse actionResponse, Object json) throws IOException {

		HttpServletResponse response = PortalUtil
				.getHttpServletResponse(actionResponse);

		response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		ServletResponseUtil.write(response, json.toString());
	}

	private static Log _log = LogFactory.getLog(TTHCAdmin.class);

}
