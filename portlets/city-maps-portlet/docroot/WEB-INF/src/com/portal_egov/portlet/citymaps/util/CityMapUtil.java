/**
 * @author HUNGDX
 * @time 5:20:49 PM
 * @project city_maps-portlet
 */
package com.portal_egov.portlet.citymaps.util;

import java.awt.image.RenderedImage;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.ImageTypeException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Image;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.documentlibrary.ImageSizeException;
import com.portal_egov.portlet.citymaps.comparator.CityMapCreateDateComparator;
import com.portal_egov.portlet.citymaps.comparator.CityMapModifiedDateComparator;
import com.portal_egov.portlet.citymaps.comparator.CityMapNameComparator;
import com.portal_egov.portlet.citymaps.comparator.CityMapTypeComparator;
import com.portal_egov.portlet.citymaps.comparator.CityMapUserNameComparator;


public class CityMapUtil {
	
	public static String getMapImagePath(HttpServletRequest request,long mapImageId){
		
		try {
			
			String mapImagePath = "";
			
			Image mapImage = ImageLocalServiceUtil.fetchImage(mapImageId);
			
			if(mapImage != null){
				
				if(Validator.isNotNull(PropsUtil.get(STATIC_CACHE_DIR_PROPERTY_KEY))){//Cache image
					
					String mapImageIdStr = String.valueOf(mapImageId);
					
					String[] mapImageIdStrSplitedArr = mapImageIdStr.split("(?<=\\G.{2})");
					
					StringBuilder stringBuilder = new StringBuilder();
					
					stringBuilder.append(StringPool.SLASH);
					stringBuilder.append(IMAGE_CACHE_FOLDER_NAME);
					stringBuilder.append(StringPool.SLASH);
					
					for (int i = 0; i < mapImageIdStrSplitedArr.length; i++){
						
						stringBuilder.append(mapImageIdStrSplitedArr[i]);
						stringBuilder.append(StringPool.SLASH);
					}
					
					stringBuilder.append(mapImageId + "." + mapImage.getType());
					
					mapImagePath = stringBuilder.toString();
					
				}else{
					
					ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
					
					mapImagePath = themeDisplay.getPathImage() + "/logo?img_id=" + mapImageId 
									+ "&t" + WebServerServletTokenUtil.getToken(mapImageId);
				}
			}
			
			return mapImagePath;
		}
		catch (Exception e) {
			_log.error(e);
			return StringPool.BLANK;
		}
	}
	
	public static OrderByComparator getOrderByComparator(String orderByColumn, String orderByType) {

		if (Validator.isNull(orderByColumn) || Validator.isNull(orderByType)) {
			return null;
		}

		boolean ascending = false;

		if (orderByType.equals("asc")) {
			ascending = true;
		}

		if(Validator.equals(orderByColumn, "map-name")){
			
			return new CityMapNameComparator(ascending);
		
		}else if(Validator.equals(orderByColumn, "map-type")){
			
			return new CityMapTypeComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "user-name")){
			
			return new CityMapUserNameComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "create-date")){
			
			return new CityMapCreateDateComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "modified-date")){
			
			return new CityMapModifiedDateComparator(ascending);
		}

		return null;
	}
	
	
	public static void uploadMapImage(long mapImageId,InputStream mapImageStream) throws Exception{
		
		if(mapImageStream != null){
			
			byte[] mapImageBytes = FileUtil.getBytes(mapImageStream);
			
			long uploadServletMaxSize = PrefsPropsUtil.getLong(PropsKeys.UPLOAD_SERVLET_REQUEST_IMPL_MAX_SIZE);

			if ((uploadServletMaxSize > 0)
				&& ((mapImageBytes == null) || (mapImageBytes.length > uploadServletMaxSize))) {

				throw new ImageSizeException();
			}
			
			ImageBag imageBag = ImageToolUtil.read(mapImageBytes);

			RenderedImage renderedImage = imageBag.getRenderedImage();

			if (renderedImage == null) {
				throw new ImageTypeException();
			}
			
			String contentType = imageBag.getType();
			
			byte[] mapImagesBytes = ImageToolUtil.getBytes(renderedImage, contentType);
			
			ImageLocalServiceUtil.updateImage(mapImageId, mapImagesBytes);
		}
	}
	
	
	private static Log _log = LogFactory.getLog(CityMapUtil.class);
	
	private static final String STATIC_CACHE_DIR_PROPERTY_KEY = "static.cache.dir";
	private static final String IMAGE_CACHE_FOLDER_NAME = "images";
}
