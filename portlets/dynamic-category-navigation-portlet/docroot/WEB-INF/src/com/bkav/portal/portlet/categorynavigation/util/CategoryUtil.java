package com.bkav.portal.portlet.categorynavigation.util;

import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetCategoryProperty;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetCategoryPropertyLocalServiceUtil;

public class CategoryUtil {
	
	public static String getCategoryName(long categoryId){
		
		String categoryName = "";
		
		if(categoryId > 0){
			
			try {
				
				AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId);
				
				if(assetCategory != null){
					
					categoryName = assetCategory.getName();
				}
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		return categoryName;
	}
	
	public static String getCategoryContentURL(HttpServletRequest request,long categoryId){
		
		String categoryContentURL = "";
		
		if(categoryId > 0){
			
			try {
				
				long plId = 0L;
				
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				
				if(themeDisplay != null){
					
					plId = themeDisplay.getPlid();
				}
				
				AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId);
				
				if(assetCategory != null){
					
					long pageLayoutId = GetterUtil.getLong(getCategoryPropertyValue(categoryId, PAGE_LAYOUT_ID_CATEGORY_PROPERTY_KEY, String.valueOf(plId)));
					
					if(pageLayoutId > 0){
						
						PortletURL categoryContentRenderURL = PortletURLFactoryUtil.create(request, "101", pageLayoutId, PortletRequest.RENDER_PHASE);
						
						if(categoryContentRenderURL != null){
							
							categoryContentRenderURL.setParameter("categoryId", String.valueOf(assetCategory.getCategoryId()));
							
							categoryContentURL = categoryContentRenderURL.toString();
						}
					}
				}
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		return categoryContentURL;
	}
	
	public static String getCategoryPropertyValue(long categoryId,String propertyKey,String defaultValue){
		
		try {
			
			//Lay danh sach tat ca cac thuoc tinh dong cua Category theo categoryId
			List<AssetCategoryProperty> propertyList = AssetCategoryPropertyLocalServiceUtil.getCategoryProperties(categoryId);
			
			if (propertyList.isEmpty()) {//Truong hop Category khong co thuoc tinh dong thi method se tra ve gia tri mac dinh
				
				return defaultValue;
				
			}else {
				
				String propertyValue = AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(categoryId, propertyKey).getValue();
				
				return propertyValue;
			}
			
		} catch (Exception e) {
			_log.error(e);
			return defaultValue;
		}	
	}
	
	private static Log _log = LogFactory.getLog(CategoryUtil.class.getName());
	
	private static final String PAGE_LAYOUT_ID_CATEGORY_PROPERTY_KEY = "link-to-page";
}
