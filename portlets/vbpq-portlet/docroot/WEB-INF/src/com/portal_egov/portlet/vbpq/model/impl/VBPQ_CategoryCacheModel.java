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

package com.portal_egov.portlet.vbpq.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.vbpq.model.VBPQ_Category;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VBPQ_Category in entity cache.
 *
 * @author HungDX
 * @see VBPQ_Category
 * @generated
 */
public class VBPQ_CategoryCacheModel implements CacheModel<VBPQ_Category>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", typeId=");
		sb.append(typeId);
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
		sb.append(", active=");
		sb.append(active);
		sb.append(", displayPriority=");
		sb.append(displayPriority);
		sb.append("}");

		return sb.toString();
	}

	public VBPQ_Category toEntityModel() {
		VBPQ_CategoryImpl vbpq_CategoryImpl = new VBPQ_CategoryImpl();

		vbpq_CategoryImpl.setCategoryId(categoryId);
		vbpq_CategoryImpl.setParentId(parentId);
		vbpq_CategoryImpl.setTypeId(typeId);
		vbpq_CategoryImpl.setCompanyId(companyId);
		vbpq_CategoryImpl.setGroupId(groupId);
		vbpq_CategoryImpl.setUserId(userId);

		if (categoryName == null) {
			vbpq_CategoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			vbpq_CategoryImpl.setCategoryName(categoryName);
		}

		if (categoryDesc == null) {
			vbpq_CategoryImpl.setCategoryDesc(StringPool.BLANK);
		}
		else {
			vbpq_CategoryImpl.setCategoryDesc(categoryDesc);
		}

		if (createDate == Long.MIN_VALUE) {
			vbpq_CategoryImpl.setCreateDate(null);
		}
		else {
			vbpq_CategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vbpq_CategoryImpl.setModifiedDate(null);
		}
		else {
			vbpq_CategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		vbpq_CategoryImpl.setActive(active);
		vbpq_CategoryImpl.setDisplayPriority(displayPriority);

		vbpq_CategoryImpl.resetOriginalValues();

		return vbpq_CategoryImpl;
	}

	public long categoryId;
	public long parentId;
	public int typeId;
	public long companyId;
	public long groupId;
	public long userId;
	public String categoryName;
	public String categoryDesc;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public int displayPriority;
}