/**
 * @author HUNGDX
 * @time 3:12:20 PM
 * @project banner-portlet
 */
package com.portal_egov.portlet.banner.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;


public class BannerComparatorUtil {


	public static OrderByComparator getBannerOrderByComparator(String orderByColumn, String orderByType) {

		if (Validator.isNull(orderByColumn) || Validator.isNull(orderByType)) {
			return null;
		}

		boolean ascending = false;

		if (orderByType.equals("asc")) {
			ascending = true;
		}

		if(Validator.equals(orderByColumn, "banner-title")){
			
			return new BannerTitleComparator(ascending);
		
		}else if(Validator.equals(orderByColumn, "banner-status")){
			
			return new BannerStatusComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "banner-view-count")){
			
			return new BannerViewCountComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "banner-group")){
			
			return new BannerGroupIdComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "banner-user")){
			
			return new BannerUserNameComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "create-date")){
			
			return new BannerCreateDateComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "modified-date")){
			
			return new BannerModifiedDateComparator(ascending);
		}

		return null;
	}
}
