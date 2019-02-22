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

package com.portal_egov.portlet.ykct.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.ykct.model.YKCT_Category;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing YKCT_Category in entity cache.
 *
 * @author DucDVd
 * @see YKCT_Category
 * @generated
 */
public class YKCT_CategoryCacheModel implements CacheModel<YKCT_Category>,
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

	public YKCT_Category toEntityModel() {
		YKCT_CategoryImpl ykct_CategoryImpl = new YKCT_CategoryImpl();

		ykct_CategoryImpl.setCategoryId(categoryId);
		ykct_CategoryImpl.setGroupId(groupId);
		ykct_CategoryImpl.setCompanyId(companyId);
		ykct_CategoryImpl.setUserId(userId);

		if (userName == null) {
			ykct_CategoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			ykct_CategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ykct_CategoryImpl.setCreateDate(null);
		}
		else {
			ykct_CategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ykct_CategoryImpl.setModifiedDate(null);
		}
		else {
			ykct_CategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (categoryName == null) {
			ykct_CategoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			ykct_CategoryImpl.setCategoryName(categoryName);
		}

		if (categoryDesc == null) {
			ykct_CategoryImpl.setCategoryDesc(StringPool.BLANK);
		}
		else {
			ykct_CategoryImpl.setCategoryDesc(categoryDesc);
		}

		ykct_CategoryImpl.resetOriginalValues();

		return ykct_CategoryImpl;
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