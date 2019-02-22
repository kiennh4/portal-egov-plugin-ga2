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

import com.portal_egov.portlet.vbpq.model.VBPQ_Entry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VBPQ_Entry in entity cache.
 *
 * @author HungDX
 * @see VBPQ_Entry
 * @generated
 */
public class VBPQ_EntryCacheModel implements CacheModel<VBPQ_Entry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{entryId=");
		sb.append(entryId);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", docTypeId=");
		sb.append(docTypeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", entryName=");
		sb.append(entryName);
		sb.append(", entryCode=");
		sb.append(entryCode);
		sb.append(", entryDesc=");
		sb.append(entryDesc);
		sb.append(", fileAttachmentURL=");
		sb.append(fileAttachmentURL);
		sb.append(", publicatorName=");
		sb.append(publicatorName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", publishDate=");
		sb.append(publishDate);
		sb.append(", executeDate=");
		sb.append(executeDate);
		sb.append(", expirationDate=");
		sb.append(expirationDate);
		sb.append(", neverExpired=");
		sb.append(neverExpired);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	public VBPQ_Entry toEntityModel() {
		VBPQ_EntryImpl vbpq_EntryImpl = new VBPQ_EntryImpl();

		vbpq_EntryImpl.setEntryId(entryId);
		vbpq_EntryImpl.setDepartmentId(departmentId);
		vbpq_EntryImpl.setCategoryId(categoryId);
		vbpq_EntryImpl.setDocTypeId(docTypeId);
		vbpq_EntryImpl.setCompanyId(companyId);
		vbpq_EntryImpl.setGroupId(groupId);
		vbpq_EntryImpl.setUserId(userId);

		if (userName == null) {
			vbpq_EntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			vbpq_EntryImpl.setUserName(userName);
		}

		if (entryName == null) {
			vbpq_EntryImpl.setEntryName(StringPool.BLANK);
		}
		else {
			vbpq_EntryImpl.setEntryName(entryName);
		}

		if (entryCode == null) {
			vbpq_EntryImpl.setEntryCode(StringPool.BLANK);
		}
		else {
			vbpq_EntryImpl.setEntryCode(entryCode);
		}

		if (entryDesc == null) {
			vbpq_EntryImpl.setEntryDesc(StringPool.BLANK);
		}
		else {
			vbpq_EntryImpl.setEntryDesc(entryDesc);
		}

		if (fileAttachmentURL == null) {
			vbpq_EntryImpl.setFileAttachmentURL(StringPool.BLANK);
		}
		else {
			vbpq_EntryImpl.setFileAttachmentURL(fileAttachmentURL);
		}

		if (publicatorName == null) {
			vbpq_EntryImpl.setPublicatorName(StringPool.BLANK);
		}
		else {
			vbpq_EntryImpl.setPublicatorName(publicatorName);
		}

		if (createDate == Long.MIN_VALUE) {
			vbpq_EntryImpl.setCreateDate(null);
		}
		else {
			vbpq_EntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vbpq_EntryImpl.setModifiedDate(null);
		}
		else {
			vbpq_EntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (publishDate == Long.MIN_VALUE) {
			vbpq_EntryImpl.setPublishDate(null);
		}
		else {
			vbpq_EntryImpl.setPublishDate(new Date(publishDate));
		}

		if (executeDate == Long.MIN_VALUE) {
			vbpq_EntryImpl.setExecuteDate(null);
		}
		else {
			vbpq_EntryImpl.setExecuteDate(new Date(executeDate));
		}

		if (expirationDate == Long.MIN_VALUE) {
			vbpq_EntryImpl.setExpirationDate(null);
		}
		else {
			vbpq_EntryImpl.setExpirationDate(new Date(expirationDate));
		}

		vbpq_EntryImpl.setNeverExpired(neverExpired);
		vbpq_EntryImpl.setActive(active);

		vbpq_EntryImpl.resetOriginalValues();

		return vbpq_EntryImpl;
	}

	public long entryId;
	public long departmentId;
	public long categoryId;
	public long docTypeId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public String entryName;
	public String entryCode;
	public String entryDesc;
	public String fileAttachmentURL;
	public String publicatorName;
	public long createDate;
	public long modifiedDate;
	public long publishDate;
	public long executeDate;
	public long expirationDate;
	public boolean neverExpired;
	public boolean active;
}