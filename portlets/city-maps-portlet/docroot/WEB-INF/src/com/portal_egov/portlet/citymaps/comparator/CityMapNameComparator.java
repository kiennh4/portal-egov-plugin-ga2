/**
 * @author HUNGDX
 * @time 11:24:00 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.citymaps.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.citymaps.model.CityMap;


public class CityMapNameComparator extends OrderByComparator{


	public static final String ORDER_BY_ASC = "CityMap.mapName ASC";

	public static final String ORDER_BY_DESC = "CityMap.mapName DESC";

	public static final String[] ORDER_BY_FIELDS = {"mapName"};
	
	
	public CityMapNameComparator(){
		this(false);
	}
	
	public CityMapNameComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		CityMap cityMap1 = (CityMap) obj1;
		CityMap cityMap2 = (CityMap) obj2;
		
		int comparatorValue = cityMap1.getMapName().toLowerCase().compareTo(cityMap2.getMapName().toLowerCase()); 
		
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
