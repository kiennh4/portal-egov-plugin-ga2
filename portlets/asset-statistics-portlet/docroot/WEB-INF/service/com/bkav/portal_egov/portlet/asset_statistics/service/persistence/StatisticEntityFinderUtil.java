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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author HungDX
 */
public class StatisticEntityFinderUtil {
	public static int getAssetCounter(long groupId, long categoryId,
		long userId, java.lang.String fromDate, java.lang.String endDate) {
		return getFinder()
				   .getAssetCounter(groupId, categoryId, userId, fromDate,
			endDate);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetEntry> getAssetEntry(
		long groupId, long categoryId, long userId, java.lang.String fromDate,
		java.lang.String endDate) {
		return getFinder()
				   .getAssetEntry(groupId, categoryId, userId, fromDate, endDate);
	}

	public static StatisticEntityFinder getFinder() {
		if (_finder == null) {
			_finder = (StatisticEntityFinder)PortletBeanLocatorUtil.locate(com.bkav.portal_egov.portlet.asset_statistics.service.ClpSerializer.getServletContextName(),
					StatisticEntityFinder.class.getName());

			ReferenceRegistry.registerReference(StatisticEntityFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(StatisticEntityFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(StatisticEntityFinderUtil.class,
			"_finder");
	}

	private static StatisticEntityFinder _finder;
}