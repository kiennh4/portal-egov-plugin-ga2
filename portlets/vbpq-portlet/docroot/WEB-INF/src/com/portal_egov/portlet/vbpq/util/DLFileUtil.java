package com.portal_egov.portlet.vbpq.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

public class DLFileUtil {
	
	public static String getDLFilePath(DLFileEntry dlFileEntry,ThemeDisplay themeDisplay){
		
		try {
			
			String filePath = "";
			
			if(Validator.isNotNull(STATIC_CACHE_DIR)){
				
				long dlFileEntryId = dlFileEntry.getFileEntryId();
				
				String fileIdStr = String.valueOf(dlFileEntryId);
				
				String[] fileIdStrSplitedArr = fileIdStr.split("(?<=\\G.{2})");
				
				StringBuilder stringBuilder = new StringBuilder();
				
				stringBuilder.append(StringPool.SLASH);
				stringBuilder.append(STATIC_DOCUMENTS_FOLDER_NAME);
				stringBuilder.append(StringPool.SLASH);
				stringBuilder.append(dlFileEntry.getGroupId());
				stringBuilder.append(StringPool.SLASH);
				stringBuilder.append(dlFileEntry.getFolderId());
				stringBuilder.append(StringPool.SLASH);
				
				for (int i = 0; i < fileIdStrSplitedArr.length; i++){
					
					stringBuilder.append(fileIdStrSplitedArr[i]);
					stringBuilder.append(StringPool.SLASH);
				}
				
				stringBuilder.append(dlFileEntry.getFileEntryId() + "." + dlFileEntry.getExtension());
				
				if(!FileUtil.exists(STATIC_CACHE_DIR + stringBuilder.toString())){
					
					InputStream dlFileInputStream = DLFileEntryLocalServiceUtil.getFileAsStream(dlFileEntry.getUserId(), 
							dlFileEntry.getFileEntryId(), dlFileEntry.getFileVersion().getVersion());
					
					if(dlFileInputStream != null){
						
						File staticFile = new File(STATIC_CACHE_DIR + stringBuilder.toString());
						
						FileUtil.write(staticFile, dlFileInputStream);
					}
					
					if(dlFileInputStream != null){
						dlFileInputStream.close();
					}
				}
				
				filePath = stringBuilder.toString();
				
			}else{
				
				String fileTitle = dlFileEntry.getTitle();
				
				StringBuilder stringBuilder = new StringBuilder();
				
				stringBuilder.append(themeDisplay.getPortalURL());
				stringBuilder.append(themeDisplay.getPathContext());
				stringBuilder.append("/documents/");
				stringBuilder.append(themeDisplay.getScopeGroupId());
				stringBuilder.append(StringPool.SLASH);
				stringBuilder.append(dlFileEntry.getFolderId());
				stringBuilder.append(StringPool.SLASH);
				stringBuilder.append(HttpUtil.encodeURL(fileTitle, true));
				
				filePath = stringBuilder.toString();
			}
			
			return filePath;
			
		} catch (SystemException e) {
			_log.error(e);
			return StringPool.BLANK;
		}
		catch (IOException e) {
			_log.error(e);
			return StringPool.BLANK;
		}
		catch (PortalException e) {
			_log.error(e);
			return StringPool.BLANK;
		}
	}
	
	private static final String STATIC_CACHE_DIR = PropsUtil.get("static.cache.dir");
	private static final String STATIC_DOCUMENTS_FOLDER_NAME = PropsUtil.get("static.documents.folder.name");
	
	private static Log _log = LogFactory.getLog(DLFileUtil.class);
}
