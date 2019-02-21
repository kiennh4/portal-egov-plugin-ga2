/**
 * @author HUNGDX
 * @time 11:24:00 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.banner.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.banner.model.Banner;


public class BannerStatusComparator extends OrderByComparator{


	public static final String ORDER_BY_ASC = "Banner.bannerStatus ASC";

	public static final String ORDER_BY_DESC = "Banner.bannerStatus DESC";

	public static final String[] ORDER_BY_FIELDS = {"bannerStatus"};
	
	
	public BannerStatusComparator(){
		this(false);
	}
	
	public BannerStatusComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		Banner banner1 = (Banner) obj1;
		Banner banner2 = (Banner) obj2;
		
		
		int comparatorValue = 0;
		
		if(banner1.getBannerStatus() < banner2.getBannerStatus()){
			
			comparatorValue = -1;
			
		}else if(banner1.getBannerStatus() > banner2.getBannerStatus()){
			
			comparatorValue = 1;
		}
		
		if(_ascending){
			return comparatorValue;
		}else{
			return -comparatorValue;
		}
	}
	
	@Override
	public String getOrderBy() {

		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {

		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {

		return _ascending;
	}

	
	private boolean _ascending;
}
