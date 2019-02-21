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

package com.portal_egov.portlet.weblinks.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.weblinks.model.WeblinkCategory;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing WeblinkCategory in entity cache.
 *
 * @author HungDX
 * @see WeblinkCategory
 * @generated
 */
public class WeblinkCategoryCacheModel implements CacheModel<WeblinkCategory>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

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
		sb.append(", categoryIconId=");
		sb.append(categoryIconId);
		sb.append("}");

		return sb.toString();
	}

	public WeblinkCategory toEntityModel() {
		WeblinkCategoryImpl weblinkCategoryImpl = new WeblinkCategoryImpl();

		weblinkCategoryImpl.setCategoryId(categoryId);
		weblinkCategoryImpl.setGroupId(groupId);
		weblinkCategoryImpl.setCompanyId(companyId);
		weblinkCategoryImpl.setUserId(userId);

		if (userName == null) {
			weblinkCategoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			weblinkCategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			weblinkCategoryImpl.setCreateDate(null);
		}
		else {
			weblinkCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			weblinkCategoryImpl.setModifiedDate(null);
		}
		else {
			weblinkCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (categoryName == null) {
			weblinkCategoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			weblinkCategoryImpl.setCategoryName(categoryName);
		}

		if (categoryDesc == null) {
			weblinkCategoryImpl.setCategoryDesc(StringPool.BLANK);
		}
		else {
			weblinkCategoryImpl.setCategoryDesc(categoryDesc);
		}

		weblinkCategoryImpl.setCategoryIconId(categoryIconId);

		weblinkCategoryImpl.resetOriginalValues();

		return weblinkCategoryImpl;
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
	public long categoryIconId;
}