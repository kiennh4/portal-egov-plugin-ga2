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

package com.portal_egov.portlet.citizen_inquiry.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CitizenInquiryCategory in entity cache.
 *
 * @author HungDX
 * @see CitizenInquiryCategory
 * @generated
 */
public class CitizenInquiryCategoryCacheModel implements CacheModel<CitizenInquiryCategory>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", categoryDesc=");
		sb.append(categoryDesc);
		sb.append("}");

		return sb.toString();
	}

	public CitizenInquiryCategory toEntityModel() {
		CitizenInquiryCategoryImpl citizenInquiryCategoryImpl = new CitizenInquiryCategoryImpl();

		citizenInquiryCategoryImpl.setCategoryId(categoryId);
		citizenInquiryCategoryImpl.setGroupId(groupId);
		citizenInquiryCategoryImpl.setCompanyId(companyId);
		citizenInquiryCategoryImpl.setUserId(userId);

		if (userName == null) {
			citizenInquiryCategoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			citizenInquiryCategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			citizenInquiryCategoryImpl.setCreateDate(null);
		}
		else {
			citizenInquiryCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			citizenInquiryCategoryImpl.setModifiedDate(null);
		}
		else {
			citizenInquiryCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (categoryName == null) {
			citizenInquiryCategoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			citizenInquiryCategoryImpl.setCategoryName(categoryName);
		}

		if (categoryDesc == null) {
			citizenInquiryCategoryImpl.setCategoryDesc(StringPool.BLANK);
		}
		else {
			citizenInquiryCategoryImpl.setCategoryDesc(categoryDesc);
		}

		citizenInquiryCategoryImpl.resetOriginalValues();

		return citizenInquiryCategoryImpl;
	}

	public long categoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String categoryName;
	public String categoryDesc;
}