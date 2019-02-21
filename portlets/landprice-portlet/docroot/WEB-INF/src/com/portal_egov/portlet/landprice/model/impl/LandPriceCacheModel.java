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

package com.portal_egov.portlet.landprice.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.landprice.model.LandPrice;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LandPrice in entity cache.
 *
 * @author HungDX
 * @see LandPrice
 * @generated
 */
public class LandPriceCacheModel implements CacheModel<LandPrice>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{priceId=");
		sb.append(priceId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", locationId=");
		sb.append(locationId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", statisticYear=");
		sb.append(statisticYear);
		sb.append("}");

		return sb.toString();
	}

	public LandPrice toEntityModel() {
		LandPriceImpl landPriceImpl = new LandPriceImpl();

		landPriceImpl.setPriceId(priceId);
		landPriceImpl.setCompanyId(companyId);
		landPriceImpl.setGroupId(groupId);
		landPriceImpl.setUserId(userId);

		if (userName == null) {
			landPriceImpl.setUserName(StringPool.BLANK);
		}
		else {
			landPriceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			landPriceImpl.setCreateDate(null);
		}
		else {
			landPriceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			landPriceImpl.setModifiedDate(null);
		}
		else {
			landPriceImpl.setModifiedDate(new Date(modifiedDate));
		}

		landPriceImpl.setLocationId(locationId);

		if (title == null) {
			landPriceImpl.setTitle(StringPool.BLANK);
		}
		else {
			landPriceImpl.setTitle(title);
		}

		if (content == null) {
			landPriceImpl.setContent(StringPool.BLANK);
		}
		else {
			landPriceImpl.setContent(content);
		}

		landPriceImpl.setStatisticYear(statisticYear);

		landPriceImpl.resetOriginalValues();

		return landPriceImpl;
	}

	public long priceId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long locationId;
	public String title;
	public String content;
	public int statisticYear;
}