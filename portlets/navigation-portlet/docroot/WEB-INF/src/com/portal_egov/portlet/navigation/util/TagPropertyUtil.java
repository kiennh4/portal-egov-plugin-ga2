package com.portal_egov.portlet.navigation.util;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.asset.NoSuchTagPropertyException;
import com.liferay.portlet.asset.model.AssetTagProperty;
import com.liferay.portlet.asset.service.AssetTagPropertyLocalServiceUtil;

public class TagPropertyUtil {


	/**
	 * Lay gia tri thuoc tinh mo rong cua Tag
	 * @param tagId 
	 * @param propertyKey ten thuoc tinh
	 * @param defaultValue gia tri mac dinh tra ve khi khong tim thay gia tri tuong ung voi ten thuoc tinh
	 * @return String - gia tri cua thuoc tinh tuong ung
	 */
	public static String getTagPropertyValue(long tagId,String propertyKey,String defaultValue){
		
		try {
			
			List<AssetTagProperty> propertyList = AssetTagPropertyLocalServiceUtil.getTagProperties(tagId);
			
			if (propertyList.isEmpty()) {
				return defaultValue;
			}else {
				
				AssetTagProperty tagProperty = AssetTagPropertyLocalServiceUtil.getTagProperty(tagId,propertyKey);
								
				if(tagProperty!= null){
					return tagProperty.getValue();
				}else{
					return defaultValue;
				}
			}
		} catch (Exception e) {
			
			if(e instanceof NoSuchTagPropertyException){

			}else{
				_log.error(e);
			}
			return defaultValue;
		}	
	}
	
	
	/**
	 * Cap nhat thuoc tinh mo rong cho Tag
	 * @param userId Id cua nguoi quan tri
	 * @param tagId Id cua Tag
	 * @param propertyKey Ten thuoc tinh
	 * @param propertyValue Gia tri cua thuoc tinh
	 */
	public static void updateTagProperty(long userId,long tagId,String propertyKey,String propertyValue){
		
		if(userId > 0 && tagId > 0 && Validator.isNotNull(propertyKey) && Validator.isNotNull(propertyValue)){
			
			try {
	
				String oldPropertyValue = getTagPropertyValue(tagId, propertyKey,StringPool.BLANK);
	
				// Kiem tra xem da ton tai thuoc tinh tuong ung voi propertyKey hay
				// chua?
				if (Validator.equals(oldPropertyValue, StringPool.BLANK)) { //Chua co 
	
					// Them moi thuoc tinh
					AssetTagPropertyLocalServiceUtil.addTagProperty(userId, tagId,
							propertyKey, propertyValue);
				} else {
	
					// Update gia tri thuoc tinh
					AssetTagProperty tagProperty = AssetTagPropertyLocalServiceUtil.getTagProperty(tagId, propertyKey);
	
					tagProperty.setValue(propertyValue);
	
					AssetTagPropertyLocalServiceUtil.updateAssetTagProperty(tagProperty);
				}
	
			} catch (Exception e) {
				_log.error(e);
			}
		}
	}
	
	private static final Log _log = LogFactory.getLog(TagPropertyUtil.class);
}
