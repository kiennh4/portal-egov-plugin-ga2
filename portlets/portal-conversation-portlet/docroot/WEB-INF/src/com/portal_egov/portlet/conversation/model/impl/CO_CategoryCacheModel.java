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

package com.portal_egov.portlet.conversation.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.conversation.model.CO_Category;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CO_Category in entity cache.
 *
 * @author DucDVd
 * @see CO_Category
 * @generated
 */
public class CO_CategoryCacheModel implements CacheModel<CO_Category>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", parentCategoryId=");
		sb.append(parentCategoryId);
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", categoryDesc=");
		sb.append(categoryDesc);
		sb.append(", threadCount=");
		sb.append(threadCount);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	public CO_Category toEntityModel() {
		CO_CategoryImpl co_CategoryImpl = new CO_CategoryImpl();

		co_CategoryImpl.setCategoryId(categoryId);
		co_CategoryImpl.setCompanyId(companyId);
		co_CategoryImpl.setGroupId(groupId);
		co_CategoryImpl.setUserId(userId);
		co_CategoryImpl.setParentCategoryId(parentCategoryId);

		if (categoryName == null) {
			co_CategoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			co_CategoryImpl.setCategoryName(categoryName);
		}

		if (categoryDesc == null) {
			co_CategoryImpl.setCategoryDesc(StringPool.BLANK);
		}
		else {
			co_CategoryImpl.setCategoryDesc(categoryDesc);
		}

		co_CategoryImpl.setThreadCount(threadCount);

		if (createDate == Long.MIN_VALUE) {
			co_CategoryImpl.setCreateDate(null);
		}
		else {
			co_CategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			co_CategoryImpl.setModifiedDate(null);
		}
		else {
			co_CategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		co_CategoryImpl.resetOriginalValues();

		return co_CategoryImpl;
	}

	public long categoryId;
	public long companyId;
	public long groupId;
	public long userId;
	public long parentCategoryId;
	public String categoryName;
	public String categoryDesc;
	public int threadCount;
	public long createDate;
	public long modifiedDate;
}