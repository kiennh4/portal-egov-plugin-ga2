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

package com.portal_egov.portlet.proposition_feedback.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.proposition_feedback.model.PropositionCategory;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PropositionCategory in entity cache.
 *
 * @author HungDX
 * @see PropositionCategory
 * @generated
 */
public class PropositionCategoryCacheModel implements CacheModel<PropositionCategory>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", categoryTypeId=");
		sb.append(categoryTypeId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", categoryDesc=");
		sb.append(categoryDesc);
		sb.append(", propositionCount=");
		sb.append(propositionCount);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	public PropositionCategory toEntityModel() {
		PropositionCategoryImpl propositionCategoryImpl = new PropositionCategoryImpl();

		propositionCategoryImpl.setCategoryId(categoryId);
		propositionCategoryImpl.setCompanyId(companyId);
		propositionCategoryImpl.setGroupId(groupId);
		propositionCategoryImpl.setUserId(userId);
		propositionCategoryImpl.setCategoryTypeId(categoryTypeId);
		propositionCategoryImpl.setParentId(parentId);

		if (categoryName == null) {
			propositionCategoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			propositionCategoryImpl.setCategoryName(categoryName);
		}

		if (categoryDesc == null) {
			propositionCategoryImpl.setCategoryDesc(StringPool.BLANK);
		}
		else {
			propositionCategoryImpl.setCategoryDesc(categoryDesc);
		}

		propositionCategoryImpl.setPropositionCount(propositionCount);

		if (createDate == Long.MIN_VALUE) {
			propositionCategoryImpl.setCreateDate(null);
		}
		else {
			propositionCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			propositionCategoryImpl.setModifiedDate(null);
		}
		else {
			propositionCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		propositionCategoryImpl.resetOriginalValues();

		return propositionCategoryImpl;
	}

	public long categoryId;
	public long companyId;
	public long groupId;
	public long userId;
	public int categoryTypeId;
	public long parentId;
	public String categoryName;
	public String categoryDesc;
	public int propositionCount;
	public long createDate;
	public long modifiedDate;
}