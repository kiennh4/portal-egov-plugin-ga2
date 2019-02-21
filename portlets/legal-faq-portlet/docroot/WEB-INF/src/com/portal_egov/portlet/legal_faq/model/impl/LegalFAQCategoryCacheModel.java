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

package com.portal_egov.portlet.legal_faq.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.legal_faq.model.LegalFAQCategory;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LegalFAQCategory in entity cache.
 *
 * @author HungDX
 * @see LegalFAQCategory
 * @generated
 */
public class LegalFAQCategoryCacheModel implements CacheModel<LegalFAQCategory>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", categoryDesc=");
		sb.append(categoryDesc);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	public LegalFAQCategory toEntityModel() {
		LegalFAQCategoryImpl legalFAQCategoryImpl = new LegalFAQCategoryImpl();

		legalFAQCategoryImpl.setCategoryId(categoryId);
		legalFAQCategoryImpl.setCompanyId(companyId);
		legalFAQCategoryImpl.setGroupId(groupId);
		legalFAQCategoryImpl.setUserId(userId);
		legalFAQCategoryImpl.setParentId(parentId);

		if (categoryName == null) {
			legalFAQCategoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			legalFAQCategoryImpl.setCategoryName(categoryName);
		}

		if (categoryDesc == null) {
			legalFAQCategoryImpl.setCategoryDesc(StringPool.BLANK);
		}
		else {
			legalFAQCategoryImpl.setCategoryDesc(categoryDesc);
		}

		if (createDate == Long.MIN_VALUE) {
			legalFAQCategoryImpl.setCreateDate(null);
		}
		else {
			legalFAQCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legalFAQCategoryImpl.setModifiedDate(null);
		}
		else {
			legalFAQCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		legalFAQCategoryImpl.resetOriginalValues();

		return legalFAQCategoryImpl;
	}

	public long categoryId;
	public long companyId;
	public long groupId;
	public long userId;
	public long parentId;
	public String categoryName;
	public String categoryDesc;
	public long createDate;
	public long modifiedDate;
}