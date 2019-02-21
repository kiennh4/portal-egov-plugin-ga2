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

package com.portal_egov.portlet.tthc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.tthc.model.TTHC_Category;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TTHC_Category in entity cache.
 *
 * @author HungDX
 * @see TTHC_Category
 * @generated
 */
public class TTHC_CategoryCacheModel implements CacheModel<TTHC_Category>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", categoryTypeId=");
		sb.append(categoryTypeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", categoryDesc=");
		sb.append(categoryDesc);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", displayPriority=");
		sb.append(displayPriority);
		sb.append("}");

		return sb.toString();
	}

	public TTHC_Category toEntityModel() {
		TTHC_CategoryImpl tthc_CategoryImpl = new TTHC_CategoryImpl();

		tthc_CategoryImpl.setCategoryId(categoryId);
		tthc_CategoryImpl.setParentId(parentId);
		tthc_CategoryImpl.setCategoryTypeId(categoryTypeId);
		tthc_CategoryImpl.setCompanyId(companyId);
		tthc_CategoryImpl.setGroupId(groupId);
		tthc_CategoryImpl.setUserId(userId);

		if (categoryName == null) {
			tthc_CategoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			tthc_CategoryImpl.setCategoryName(categoryName);
		}

		if (categoryDesc == null) {
			tthc_CategoryImpl.setCategoryDesc(StringPool.BLANK);
		}
		else {
			tthc_CategoryImpl.setCategoryDesc(categoryDesc);
		}

		if (createDate == Long.MIN_VALUE) {
			tthc_CategoryImpl.setCreateDate(null);
		}
		else {
			tthc_CategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tthc_CategoryImpl.setModifiedDate(null);
		}
		else {
			tthc_CategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		tthc_CategoryImpl.setDisplayPriority(displayPriority);

		tthc_CategoryImpl.resetOriginalValues();

		return tthc_CategoryImpl;
	}

	public long categoryId;
	public long parentId;
	public int categoryTypeId;
	public long companyId;
	public long groupId;
	public long userId;
	public String categoryName;
	public String categoryDesc;
	public long createDate;
	public long modifiedDate;
	public int displayPriority;
}