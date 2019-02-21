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

package com.portal_egov.portlet.banner.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.banner.model.Banner;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Banner in entity cache.
 *
 * @author HungDX
 * @see Banner
 * @generated
 */
public class BannerCacheModel implements CacheModel<Banner>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{bannerId=");
		sb.append(bannerId);
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
		sb.append(", bannerGroupId=");
		sb.append(bannerGroupId);
		sb.append(", bannerTitle=");
		sb.append(bannerTitle);
		sb.append(", bannerLink=");
		sb.append(bannerLink);
		sb.append(", bannerImageId=");
		sb.append(bannerImageId);
		sb.append(", viewCounter=");
		sb.append(viewCounter);
		sb.append(", bannerStatus=");
		sb.append(bannerStatus);
		sb.append("}");

		return sb.toString();
	}

	public Banner toEntityModel() {
		BannerImpl bannerImpl = new BannerImpl();

		bannerImpl.setBannerId(bannerId);
		bannerImpl.setCompanyId(companyId);
		bannerImpl.setGroupId(groupId);
		bannerImpl.setUserId(userId);

		if (userName == null) {
			bannerImpl.setUserName(StringPool.BLANK);
		}
		else {
			bannerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			bannerImpl.setCreateDate(null);
		}
		else {
			bannerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bannerImpl.setModifiedDate(null);
		}
		else {
			bannerImpl.setModifiedDate(new Date(modifiedDate));
		}

		bannerImpl.setBannerGroupId(bannerGroupId);

		if (bannerTitle == null) {
			bannerImpl.setBannerTitle(StringPool.BLANK);
		}
		else {
			bannerImpl.setBannerTitle(bannerTitle);
		}

		if (bannerLink == null) {
			bannerImpl.setBannerLink(StringPool.BLANK);
		}
		else {
			bannerImpl.setBannerLink(bannerLink);
		}

		bannerImpl.setBannerImageId(bannerImageId);
		bannerImpl.setViewCounter(viewCounter);
		bannerImpl.setBannerStatus(bannerStatus);

		bannerImpl.resetOriginalValues();

		return bannerImpl;
	}

	public long bannerId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long bannerGroupId;
	public String bannerTitle;
	public String bannerLink;
	public long bannerImageId;
	public int viewCounter;
	public int bannerStatus;
}