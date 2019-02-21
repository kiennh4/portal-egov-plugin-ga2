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

import com.portal_egov.portlet.banner.model.BannerGroup;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing BannerGroup in entity cache.
 *
 * @author HungDX
 * @see BannerGroup
 * @generated
 */
public class BannerGroupCacheModel implements CacheModel<BannerGroup>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{bannerGroupId=");
		sb.append(bannerGroupId);
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
		sb.append(", groupName=");
		sb.append(groupName);
		sb.append(", groupDesc=");
		sb.append(groupDesc);
		sb.append("}");

		return sb.toString();
	}

	public BannerGroup toEntityModel() {
		BannerGroupImpl bannerGroupImpl = new BannerGroupImpl();

		bannerGroupImpl.setBannerGroupId(bannerGroupId);
		bannerGroupImpl.setCompanyId(companyId);
		bannerGroupImpl.setGroupId(groupId);
		bannerGroupImpl.setUserId(userId);

		if (userName == null) {
			bannerGroupImpl.setUserName(StringPool.BLANK);
		}
		else {
			bannerGroupImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			bannerGroupImpl.setCreateDate(null);
		}
		else {
			bannerGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bannerGroupImpl.setModifiedDate(null);
		}
		else {
			bannerGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (groupName == null) {
			bannerGroupImpl.setGroupName(StringPool.BLANK);
		}
		else {
			bannerGroupImpl.setGroupName(groupName);
		}

		if (groupDesc == null) {
			bannerGroupImpl.setGroupDesc(StringPool.BLANK);
		}
		else {
			bannerGroupImpl.setGroupDesc(groupDesc);
		}

		bannerGroupImpl.resetOriginalValues();

		return bannerGroupImpl;
	}

	public long bannerGroupId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String groupName;
	public String groupDesc;
}