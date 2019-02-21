package com.portal_egov.portlet.navigation.util;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.asset.NoSuchCategoryPropertyException;
import com.liferay.portlet.asset.model.AssetCategoryProperty;
import com.liferay.portlet.asset.service.AssetCategoryPropertyLocalServiceUtil;


public class CategoryPropertyUtil {

	public static String getCategoryPropertyValue(long categoryId,String propertyKey,String defaultPropertyValue){
		
		try {
			
			List<AssetCategoryProperty> categoryPropertyList = AssetCategoryPropertyLocalServiceUtil.getCategoryProperties(categoryId);
			
			if(categoryPropertyList.isEmpty()){
				
				return defaultPropertyValue;
				
			}else{
				
				AssetCategoryProperty categoryProperty = AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(categoryId, propertyKey);
				
				if(categoryProperty != null){
					
					return categoryProperty.getValue();
				}else{
					return defaultPropertyValue;
				}
			}
		} catch (Exception e) {
			
			if(e instanceof NoSuchCategoryPropertyException){

			}else{
				_log.error(e);
			}
			return defaultPropertyValue;
		}
	}
	
	public static void updateCategoryProperty(long userId,long categoryId,String propertyKey,String propertyValue){
		
		if(userId > 0 && categoryId > 0 && Validator.isNotNull(propertyKey) && Validator.isNotNull(propertyValue)){
			
			try {
				
				String oldPropertyValue = getCategoryPropertyValue(categoryId, propertyKey, StringPool.BLANK);

				// Kiem tra xem da ton tai thuoc tinh tuong ung voi propertyKey hay chua?
				if (Validator.equals(oldPropertyValue, StringPool.BLANK)) {

					// Them moi thuoc tinh
					AssetCategoryPropertyLocalServiceUtil.addCategoryProperty(userId, categoryId, propertyKey, propertyValue);
				} else {

					// Update gia tri thuoc tinh
					AssetCategoryProperty categoryProperty = AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(categoryId, propertyKey);

					categoryProperty.setValue(propertyValue);

					AssetCategoryPropertyLocalServiceUtil.updateAssetCategoryProperty(categoryProperty);
				}
	
			} catch (Exception e) {
				_log.error(e);
			}
		}
	}
	
	private static final Log _log = LogFactory.getLog(CategoryPropertyUtil.class);
}

