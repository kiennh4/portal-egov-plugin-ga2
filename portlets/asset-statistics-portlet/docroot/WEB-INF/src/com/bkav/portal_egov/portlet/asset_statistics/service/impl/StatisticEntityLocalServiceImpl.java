/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.bkav.portal_egov.portlet.asset_statistics.service.impl;

import java.util.List;

import com.bkav.portal_egov.portlet.asset_statistics.service.base.StatisticEntityLocalServiceBaseImpl;
import com.bkav.portal_egov.portlet.asset_statistics.service.persistence.StatisticEntityFinderUtil;
import com.liferay.portlet.asset.model.AssetEntry;

/**
 * The implementation of the statistic entity local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.bkav.portal_egov.portlet.asset_statistics.service.StatisticEntityLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author HungDX
 * @see com.bkav.portal_egov.portlet.asset_statistics.service.base.StatisticEntityLocalServiceBaseImpl
 * @see com.bkav.portal_egov.portlet.asset_statistics.service.StatisticEntityLocalServiceUtil
 */
public class StatisticEntityLocalServiceImpl extends
		StatisticEntityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.bkav.portal_egov
	 * .portlet.asset_statistics.service.StatisticEntityLocalServiceUtil} to
	 * access the statistic entity local service.
	 */
	
	public int getAssetCounter(long groupId,long categoryId,long userId,String fromDate,String endDate){
		
		return StatisticEntityFinderUtil.getAssetCounter(groupId, categoryId, userId, fromDate, endDate);
	}
	
	public List<AssetEntry> getAssetEntry (long groupId,long categoryId,long userId,String fromDate,String endDate){
		
		return (List<AssetEntry>)StatisticEntityFinderUtil.getAssetEntry(groupId, categoryId, userId, fromDate, endDate);
	}
}