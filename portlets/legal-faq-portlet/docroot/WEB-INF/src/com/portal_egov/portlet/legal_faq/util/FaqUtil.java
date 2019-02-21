package com.portal_egov.portlet.legal_faq.util;

import java.awt.image.RenderedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.ImageTypeException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.TempFileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Image;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.ImageSizeException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.portal_egov.portlet.legal_faq.LegalFAQ;

@SuppressWarnings("unused")
public class FaqUtil {
public static String getAlbumCoverPath(HttpServletRequest request,long categoryId){
		
		try {
			
			String albumCoverPath = "/legal-faq-portlet/html/images/album-icon.png";
			
			Image coverImage = ImageLocalServiceUtil.fetchImage(categoryId);
			
			if(coverImage != null){
				
				if(Validator.isNotNull(PropsUtil.get(STATIC_CACHE_DIR_PROPERTY_KEY))){//Cache image
					
					String albumCoverIdStr = String.valueOf(categoryId);
					
					String[] albumCoverIdStrSplitedArr = albumCoverIdStr.split("(?<=\\G.{2})");
					
					StringBuilder stringBuilder = new StringBuilder();
					
					stringBuilder.append(StringPool.SLASH);
					stringBuilder.append(IMAGE_CACHE_FOLDER_NAME);
					stringBuilder.append(StringPool.SLASH);
					
					for (int i = 0; i < albumCoverIdStrSplitedArr.length; i++){
						
						stringBuilder.append(albumCoverIdStrSplitedArr[i]);
						stringBuilder.append(StringPool.SLASH);
					}
					
					stringBuilder.append(categoryId + "." + coverImage.getType());
					
					albumCoverPath = stringBuilder.toString();
					
				}else{
					
					ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
					
					albumCoverPath = themeDisplay.getPathImage() + "/logo?img_id=" + categoryId
									+ "&t" + WebServerServletTokenUtil.getToken(categoryId);
				}
			}
			
			return albumCoverPath;
		}
		catch (Exception e) {
			_log.error(e);
			return StringPool.BLANK;
		}
	}
private static Log _log = LogFactory.getLog(FaqUtil.class);

private static final String _TEMP_FOLDER_NAME = LegalFAQ.class.getName();
private static final String STATIC_CACHE_DIR_PROPERTY_KEY = "static.cache.dir";
private static final String IMAGE_CACHE_FOLDER_NAME = "images";
}