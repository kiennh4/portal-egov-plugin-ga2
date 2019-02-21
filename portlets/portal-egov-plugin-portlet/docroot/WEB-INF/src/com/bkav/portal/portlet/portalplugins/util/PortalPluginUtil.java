package com.bkav.portal.portlet.portalplugins.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.portalplugins.model.PortalPlugins;
import com.bkav.portal.portlet.portalplugins.service.PortalPluginsLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;

public class PortalPluginUtil {

	public static long uploadPluginFile(long groupId, long folderId,
			long currentFileId, String fileName, String mimeType,
			ServiceContext serviceContext, byte[] fileInputStream
			) throws SystemException, PortalException 
	{
		long fileId = 0L;
		if (currentFileId > 0) 
		{
			FileEntry file = DLAppServiceUtil.updateFileEntry(currentFileId,
					fileName, mimeType, fileName, StringPool.BLANK,
					StringPool.BLANK, true, fileInputStream, serviceContext);

			if (file != null) 
			{
				fileId = file.getFileEntryId();
			}
		} 
		else 
		{
			FileEntry file = DLAppServiceUtil.addFileEntry(groupId, folderId,
					fileName, mimeType, fileName, StringPool.BLANK,
					StringPool.BLANK, fileInputStream, serviceContext);

			if (file != null) 
			{
				fileId = file.getFileEntryId();
			}
		}
		return fileId;
	}
	
	public static boolean isValidatedFilePlugin (String mimeType)
	{
		for (String fileType : PortalPluginConstant.PLUGIN_FILE_TYPE)
		{
			if (mimeType.toLowerCase().equals(fileType))
			{
				return true;
			}
		}
		return false;
	}
	
	public static List<PortalPlugins> findPortalPluginsByFilter (long groupId, String pluginName, String pluginCode, int pluginType, long ePortalId, int start, int end)
	{
		try {
			return PortalPluginsLocalServiceUtil.findPortalPluginsByFilter(groupId, pluginName, pluginCode, pluginType, ePortalId, start, end);
		}
		catch (Exception e)
		{
			_log.error(e);
			return new ArrayList<PortalPlugins>();
		}
	}
	
	private static Log _log = LogFactory.getLog(PortalPluginUtil.class);
}
