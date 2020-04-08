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

package com.bkav.portal_egov.portlet.asset_statistics.service.persistence;

/**
 * @author HungDX
 */
public interface StatisticEntityFinder {
	public int getAssetCounter(long groupId, long categoryId, long userId,
		java.lang.String fromDate, java.lang.String endDate);

	public java.util.List<com.liferay.portlet.asset.model.AssetEntry> getAssetEntry(
		long groupId, long categoryId, long userId, java.lang.String fromDate,
		java.lang.String endDate);
}