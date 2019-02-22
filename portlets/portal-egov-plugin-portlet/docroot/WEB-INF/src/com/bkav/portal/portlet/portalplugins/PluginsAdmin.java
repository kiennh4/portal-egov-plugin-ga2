package com.bkav.portal.portlet.portalplugins;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.portalplugins.model.PortalPlugins;
import com.bkav.portal.portlet.portalplugins.service.PortalPluginsLocalServiceUtil;
import com.bkav.portal.portlet.portalplugins.util.PortalPluginUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.FileExtensionException;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PortalPlugins
 */
public class PluginsAdmin extends MVCPortlet {
 
	public void addPlugin (ActionRequest actionRequest, ActionResponse actionResponse)
	{
		try {
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			long folderId = GetterUtil.getLong(preferences.getValue(
					"pluginFolderId", String.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID)));
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			long warFileId = 0L;
			long signFileId = 0L;
			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					PortalPlugins.class.getName(), actionRequest);
			String pluginName = ParamUtil.getString(uploadRequest, "pluginName");
			String pluginCode = ParamUtil.getString(uploadRequest, "pluginCode");
			double pluginVersion = Double.parseDouble(ParamUtil.getString(uploadRequest, "pluginVersion"));
			String pluginDescription = ParamUtil.getString(uploadRequest, "pluginDescription");
			String pluginUpdateInfo = ParamUtil.getString(uploadRequest, "pluginUpdateInfo");
			int pluginType = ParamUtil.getInteger(uploadRequest, "pluginType");
			long ePortalId = ParamUtil.getLong(uploadRequest, "ePortalId");
			InputStream warFileStream = uploadRequest.getFileAsStream("warFile");
			String warFileName = uploadRequest.getFileName("warFile");
			String warMimeType = MimeTypesUtil.getContentType(warFileName);
			String warFileType = FilenameUtils.getExtension(warFileName);
			byte[] warFileBytes = FileUtil.getBytes(warFileStream);
			InputStream signFileStream = uploadRequest.getFileAsStream("signFile");
			String signFileName = uploadRequest.getFileName("signFile");
			String signMimeType =  MimeTypesUtil.getContentType(signFileName);
			String signFileType = FilenameUtils.getExtension(signFileName);
			byte[] signFileBytes = FileUtil.getBytes(signFileStream);
			int isImportant = ParamUtil.getInteger(uploadRequest, "isImportant");
			
			if ((!PortalPluginUtil.isValidatedFilePlugin(warFileType))||(!PortalPluginUtil.isValidatedFilePlugin(signFileType)))
			{
				throw new FileExtensionException();
			}
			
			serviceContext.setGroupPermissions(new String[] {
				ActionKeys.VIEW
			});
			serviceContext.setGuestPermissions(new String[] {
				ActionKeys.VIEW
			});
			
			
			if ((Validator.isNotNull(warFileBytes))&&(warFileBytes.length>0))
			{
				warFileId = PortalPluginUtil.uploadPluginFile(groupId, folderId
						, 0, warFileName, warMimeType, serviceContext, warFileBytes);
			}
			
			if ((Validator.isNotNull(signFileBytes))&&(signFileBytes.length>0))
			{
				signFileId = PortalPluginUtil.uploadPluginFile(groupId, folderId
						, 0, signFileName, signMimeType, serviceContext, signFileBytes);
			}
			
			if ((warFileId>0)&&(signFileId>0))
			{
				FileEntry file = DLAppServiceUtil.getFileEntry(warFileId);
				double pluginSize = Double.valueOf(_formatter.format(file.getSize()/(1024*1024)));
				
				PortalPluginsLocalServiceUtil.addPortalPlugin(groupId, companyId, userId, userName, pluginName
						, pluginCode, pluginVersion, pluginType, ePortalId, isImportant, pluginDescription
						, pluginUpdateInfo, pluginSize, warFileId, signFileId, serviceContext);
				
				SessionMessages.add(actionRequest, "plugin-saved");
			}
			else
			{
				throw new FileNotFoundException();
			}
		}
		catch (Exception e)
		{
			if ((e instanceof FileExtensionException ) || (e instanceof FileNotFoundException))
			{
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			
			_log.error(e);
		}
	}
	
	public void updatePlugin  (ActionRequest actionRequest, ActionResponse actionResponse)
	{
		try {
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			long folderId = GetterUtil.getLong(preferences.getValue(
					"pluginFolderId", String.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID)));
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long pluginId = ParamUtil.getLong(actionRequest, "pluginId");
			long warFileId = 0L;
			long signFileId = 0L;
			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					PortalPlugins.class.getName(), actionRequest);
			String pluginName = ParamUtil.getString(uploadRequest, "pluginName");
			
			String pluginDescription = ParamUtil.getString(uploadRequest, "pluginDescription");
			String pluginUpdateInfo = ParamUtil.getString(uploadRequest, "pluginUpdateInfo");
			int pluginType = ParamUtil.getInteger(uploadRequest, "pluginType");
			long ePortalId = ParamUtil.getLong(uploadRequest, "ePortalId");
			InputStream warFileStream = uploadRequest.getFileAsStream("warFile");
			String warFileName = uploadRequest.getFileName("warFile");
			String warMimeType = MimeTypesUtil.getContentType(warFileName);
			String warFileType = FilenameUtils.getExtension(warFileName);
			byte[] warFileBytes = FileUtil.getBytes(warFileStream);
			InputStream signFileStream = uploadRequest.getFileAsStream("signFile");
			String signFileName = uploadRequest.getFileName("signFile");
			String signMimeType =  MimeTypesUtil.getContentType(signFileName);
			String signFileType = FilenameUtils.getExtension(signFileName);
			byte[] signFileBytes = FileUtil.getBytes(signFileStream);
			int isImportant = ParamUtil.getInteger(uploadRequest, "isImportant");
			PortalPlugins plugin = PortalPluginsLocalServiceUtil.fetchPortalPlugins(pluginId);
			
			if (Validator.isNotNull(plugin))
			{
				double pluginVersion = plugin.getPluginVersion();
				String pluginCode = plugin.getPluginCode();
				
				if ((Validator.isNotNull(warFileStream))&&(Validator.isNotNull(signFileStream)))
				{
					if ((!PortalPluginUtil.isValidatedFilePlugin(warFileType))||(!PortalPluginUtil.isValidatedFilePlugin(signFileType)))
					{
						throw new FileExtensionException();
					}
					
					DLAppServiceUtil.deleteFileEntry(plugin.getWarFileId());
					DLAppServiceUtil.deleteFileEntry(plugin.getSignFileId());
					
					if ((Validator.isNotNull(warFileBytes))&&(warFileBytes.length>0))
					{
						warFileId = PortalPluginUtil.uploadPluginFile(groupId, folderId
								, 0, warFileName, warMimeType, serviceContext, warFileBytes);
					}
					
					if ((Validator.isNotNull(signFileBytes))&&(signFileBytes.length>0))
					{
						signFileId = PortalPluginUtil.uploadPluginFile(groupId, folderId
								, 0, signFileName, signMimeType, serviceContext, signFileBytes);
					}
					
					pluginVersion = pluginVersion + 0.1;
				}
				else
				{
					warFileId = plugin.getWarFileId();
					signFileId = plugin.getSignFileId();
					//double pluginVersion = Double.parseDouble(ParamUtil.getString(uploadRequest, "pluginVersion"));
					
				}
				
				serviceContext.setGroupPermissions(new String[] {
					ActionKeys.VIEW
				});
				serviceContext.setGuestPermissions(new String[] {
					ActionKeys.VIEW
				});
			
				if ((warFileId>0)&&(signFileId>0))
				{
					FileEntry file = DLAppServiceUtil.getFileEntry(warFileId);
					double pluginSize = Double.valueOf(_formatter.format(file.getSize()/(1024*1024)));
					
					PortalPluginsLocalServiceUtil.updatePortalPlugin(pluginId, pluginName, pluginCode, pluginVersion
							, pluginType, ePortalId, isImportant, pluginDescription, pluginUpdateInfo
							, pluginSize, warFileId, signFileId);
					
					SessionMessages.add(actionRequest, "plugin-saved");
				}
				else
				{
					throw new FileNotFoundException();
				}
			}
		}
		catch (Exception e)
		{
			if ((e instanceof FileExtensionException ) || (e instanceof FileNotFoundException))
			{
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			
			_log.error(e);
		}
	}
	
	public void deletePlugin (ActionRequest actionRequest, ActionResponse actionResponse)
	{
		try {
			long pluginId = ParamUtil.getLong(actionRequest, "pluginId");
			
			PortalPlugins plugin = PortalPluginsLocalServiceUtil.fetchPortalPlugins(pluginId);
			
			if (plugin!=null)
			{
				try {
					DLAppServiceUtil.deleteFileEntry(plugin.getWarFileId());
					DLAppServiceUtil.deleteFileEntry(plugin.getSignFileId());
				}
				catch (Exception e)
				{
					
				}
				
				PortalPluginsLocalServiceUtil.deletePortalPlugins(plugin);
			}
		}
		catch (Exception e)
		{
			_log.error(e);
		}
	}
	
	private static NumberFormat _formatter = new DecimalFormat("#.##");
	
	private static Log _log = LogFactory.getLog(PluginsAdmin.class);
}
