/**
 * @author HUNGDX
 * @time 1:42:00 PM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.weblinks.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.portal_egov.portlet.weblinks.comparator.WeblinkCategoryIdComparator;
import com.portal_egov.portlet.weblinks.comparator.WeblinkCreateDateComparator;
import com.portal_egov.portlet.weblinks.comparator.WeblinkModifiedDateComparator;
import com.portal_egov.portlet.weblinks.comparator.WeblinkNameComparator;
import com.portal_egov.portlet.weblinks.comparator.WeblinkUserNameComparator;
import com.portal_egov.portlet.weblinks.model.WeblinkCategory;
import com.portal_egov.portlet.weblinks.service.WeblinkCategoryLocalServiceUtil;


public class WeblinkUtil {

	public static OrderByComparator getWeblinkOrderByComparator(String orderByColumn, String orderByType) {

		if (Validator.isNull(orderByColumn) || Validator.isNull(orderByType)) {
			return null;
		}

		boolean ascending = false;

		if (orderByType.equals("asc")) {
			ascending = true;
		}

		if(Validator.equals(orderByColumn, "weblink-name")){
			
			return new WeblinkNameComparator(ascending);
		
		}else if(Validator.equals(orderByColumn, "weblink-category-id")){
			
			return new WeblinkCategoryIdComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "user-name")){
			
			return new WeblinkUserNameComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "create-date")){
			
			return new WeblinkCreateDateComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "modified-date")){
			
			return new WeblinkModifiedDateComparator(ascending);
		}

		return null;
	}
	
	/**
	 * @todo Lay List weblink category tu Array chua Id cua cac category duoc chon hien thi trong trang config
	 * @author HUNGDX	
	 * @date Oct 15, 2012
	 * @return List<WeblinkCategory>
	 */
	public static List<WeblinkCategory> getCategoryTabs(String[] selectedCategoryTabIds){
		
		try {
			
			List<WeblinkCategory> weblinkCategoryList = new ArrayList<WeblinkCategory>();
			
			if(selectedCategoryTabIds != null && selectedCategoryTabIds.length > 0){
				
				for (int i = 0; i < selectedCategoryTabIds.length; i++) {
					
					long selectedCategoryId = GetterUtil.getLong(selectedCategoryTabIds[i],0L);
					
					if(selectedCategoryId > 0L){
						
						WeblinkCategory weblinkCategory = WeblinkCategoryLocalServiceUtil.getWeblinkCategory(selectedCategoryId);
						
						if(weblinkCategory != null){
							
							weblinkCategoryList.add(weblinkCategory);
						}
					}
				}
			}
			
			return weblinkCategoryList;
		}
		catch (Exception e) {
			_log.error(e);
			return Collections.EMPTY_LIST;
		}
	}
	
	/**
	 * @todo Kiem tra weblink category co duoc chon trong danh sach hien thi ngoai site hay khong?
	 * @author HUNGDX	
	 * @date Oct 15, 2012
	 * @return boolean
	 */
	public static boolean isSelectedCategory(String[] selectedCategoryIds,long categoryId){
		
		boolean flag = false;
		
		if(selectedCategoryIds.length > 0 && categoryId > 0){
			
			for (int i = 0; i < selectedCategoryIds.length; i++) {
				
				long selectedCategoryId = GetterUtil.getLong(selectedCategoryIds[i]);
				
				if(selectedCategoryId == categoryId){
					flag = true;
				}
			}
			
		}
		
		return flag;
	}
	
	private static Log _log = LogFactory.getLog(WeblinkUtil.class);
}
