package com.portal_egov.portlet.navigation.util;

import java.awt.image.RenderedImage;
import java.io.InputStream;

import javax.portlet.ActionRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.UserPortraitSizeException;
import com.liferay.portal.UserPortraitTypeException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;

/**
 * @author HungDX
 */

public class NavigationUtil {

	public static final String DISPLAY_NAME_PROPERTY_KEY = "display-name";
	
	public static final String ICON_IMAGE_ID_PROPERTY_KEY = "icon-image-id";
	
	public static final String CUSTOM_URL_PROPERTY_KEY = "custom-url";
	
	public static final String DEFAULT_TAG_ICON_IMAGE_FOLDER_NAME = "tag-icon-images";
	
	public static final String DEFAULT_CATEGORY_ICON_IMAGE_FOLDER_NAME = "category-icon-images";
	
	public static final String CLASS_NAME = "className";
	
	public static final String CLASS_ID = "classId";
	
	public static final String DISPLAY_NAME_PARAM = "displayName";
	
	public static final String ICON_IMAGE_FILE_PARAM = "iconImageFile";
	
	public static final String CUSTOM_URL_PARAM = "customURL";
	
	public static void updateDisplayName(ActionRequest actionRequest){
		
		try {
			
			String assetTagClassName = AssetTag.class.getName();
															
			String className = ParamUtil.getString(actionRequest, CLASS_NAME,assetTagClassName);
			
			long classId = ParamUtil.getLong(actionRequest, CLASS_ID,0L);
			
			long userId = PortalUtil.getUserId(actionRequest);
			
			if(classId > 0){
				
				String displayName = ParamUtil.getString(actionRequest, DISPLAY_NAME_PARAM,StringPool.BLANK);
				
				if(Validator.equals(className, assetTagClassName)){
					
					TagPropertyUtil.updateTagProperty(userId, classId, DISPLAY_NAME_PROPERTY_KEY, displayName);
					
				}else{
					
					CategoryPropertyUtil.updateCategoryProperty(userId, classId, DISPLAY_NAME_PROPERTY_KEY, displayName);
				}
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public static void updateCustomURL(ActionRequest actionRequest){
		
		try {
			
			long userId = PortalUtil.getUserId(actionRequest);
			
			String assetTagClassName = AssetTag.class.getName();
									
			String className = ParamUtil.getString(actionRequest, CLASS_NAME,assetTagClassName);
			
			long classId = ParamUtil.getLong(actionRequest, CLASS_ID,0L);
			
			if(classId > 0){
				
				String customURL = ParamUtil.getString(actionRequest, CUSTOM_URL_PARAM,StringPool.BLANK);
				
				if(Validator.equals(className, assetTagClassName)){
					
					TagPropertyUtil.updateTagProperty(userId, classId, CUSTOM_URL_PROPERTY_KEY, customURL);
					
				}else{
				
					CategoryPropertyUtil.updateCategoryProperty(userId, classId, CUSTOM_URL_PROPERTY_KEY, customURL);
				}
			}
						
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public static void updateIconImage(ActionRequest actionRequest){
		
		try {
			
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			
			InputStream iconInputStream = uploadRequest.getFileAsStream(ICON_IMAGE_FILE_PARAM);
			
			if(iconInputStream != null){
				
				byte[] iconImageBytes = FileUtil.getBytes(iconInputStream);
				
				long groupId = PortalUtil.getScopeGroupId(actionRequest);
				
				long userId = PortalUtil.getUserId(actionRequest);
				
				String assetTagClassName = AssetTag.class.getName();
				
				String assetCategoryClassName = AssetCategory.class.getName();
				
				String className = ParamUtil.getString(actionRequest, CLASS_NAME,assetTagClassName);
				
				long classId = ParamUtil.getLong(actionRequest, CLASS_ID,0L);

				if(Validator.equals(className, assetTagClassName) && classId > 0){
					
					long tagIconImageId = GetterUtil.getLong(TagPropertyUtil.getTagPropertyValue(classId, ICON_IMAGE_ID_PROPERTY_KEY,
						String.valueOf(CounterLocalServiceUtil.increment())));
					
					uploadIconImage(groupId, tagIconImageId, iconImageBytes);
					
					TagPropertyUtil.updateTagProperty(userId, classId, ICON_IMAGE_ID_PROPERTY_KEY, String.valueOf(tagIconImageId));
					
				}else if(Validator.equals(className, assetCategoryClassName) && classId > 0){
					
					long categoryIconImageId = GetterUtil.getLong(CategoryPropertyUtil.getCategoryPropertyValue(classId, 
						ICON_IMAGE_ID_PROPERTY_KEY, String.valueOf(CounterLocalServiceUtil.increment())));
					
					uploadIconImage(groupId, categoryIconImageId, iconImageBytes);
					
					CategoryPropertyUtil.updateCategoryProperty(userId, classId, ICON_IMAGE_ID_PROPERTY_KEY, String.valueOf(categoryIconImageId));
					
				}else{
					_log.info("[Navigation Portlet]: Can not update icon image with className=" + className + " and classId=" + classId);
				}
				
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public static long[] validateSelectedEntryIds(long[] selectedEntryIds, String selectedName){
		
		for (long selectedEntryId : selectedEntryIds) {
			
			if(Validator.equals(selectedName, "assetTags")){
				
				if(!validateTag(selectedEntryId)){
					
					selectedEntryIds = ArrayUtil.remove(selectedEntryIds, selectedEntryId);
				}
			}else{
				
				if(!validateCategory(selectedEntryId)){
					selectedEntryIds = ArrayUtil.remove(selectedEntryIds, selectedEntryId);
				}
			}
		}
		
		return selectedEntryIds;
	}
	
	private static boolean validateTag(long selectedTagId){
		try {
			
			AssetTag assetTag = AssetTagLocalServiceUtil.getAssetTag(selectedTagId);
			
			if(assetTag != null){
				return true;
			}else{
				return false;
			}
		}
		catch (Exception e) {
			return false;
		}
	}
	
	private static boolean validateCategory(long selectedCategoryId){
		try {
			
			AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(selectedCategoryId);
			
			if(assetCategory != null){
				return true;
			}else{
				return false;
			}
		}
		catch (Exception e) {
			return false;
		}
	}
	
	private static void uploadIconImage(long groupId,long iconImageId,byte[] bytes) throws Exception{
		
			long userImageMaxSize = PrefsPropsUtil.getLong(PropsKeys.USERS_IMAGE_MAX_SIZE);

			if ((userImageMaxSize > 0) &&
				((bytes == null) || (bytes.length > userImageMaxSize))) {

				throw new UserPortraitSizeException();
			}
			
			ImageBag imageBag = ImageToolUtil.read(bytes);

			RenderedImage renderedImage = imageBag.getRenderedImage();

			if (renderedImage == null) {
				throw new UserPortraitTypeException();
			}

			int USERS_IMAGE_MAX_HEIGHT = GetterUtil.getInteger(PropsUtil.get(PropsKeys.USERS_IMAGE_MAX_HEIGHT));

			int USERS_IMAGE_MAX_WIDTH = GetterUtil.getInteger(PropsUtil.get(PropsKeys.USERS_IMAGE_MAX_WIDTH));
			
			renderedImage = ImageToolUtil.scale(renderedImage, USERS_IMAGE_MAX_HEIGHT,USERS_IMAGE_MAX_WIDTH);

			String contentType = imageBag.getType();
			
			byte[] iconImageBytes = ImageToolUtil.getBytes(renderedImage, contentType);
			
			ImageLocalServiceUtil.updateImage(iconImageId, iconImageBytes);
	}
	
	private static final Log _log = LogFactory.getLog(NavigationUtil.class);
}
