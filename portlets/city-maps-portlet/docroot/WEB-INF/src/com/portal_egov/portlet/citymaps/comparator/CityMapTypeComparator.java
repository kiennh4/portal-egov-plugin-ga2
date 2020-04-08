/**
 * @author HUNGDX
 * @time 11:24:00 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.citymaps.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.citymaps.model.CityMap;


public class CityMapTypeComparator extends OrderByComparator{


	public static final String ORDER_BY_ASC = "CityMap.mapTypeId ASC";

	public static final String ORDER_BY_DESC = "CityMap.mapTypeId DESC";

	public static final String[] ORDER_BY_FIELDS = {"mapTypeId"};
	
	
	public CityMapTypeComparator(){
		this(false);
	}
	
	public CityMapTypeComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		CityMap cityMap1 = (CityMap) obj1;
		CityMap cityMap2 = (CityMap) obj2;
		
		
		int comparatorValue = 0;
		
		if(cityMap1.getMapTypeId() < cityMap2.getMapTypeId()){
			
			comparatorValue = -1;
			
		}else if(cityMap1.getMapTypeId() > cityMap2.getMapTypeId()){
			
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
