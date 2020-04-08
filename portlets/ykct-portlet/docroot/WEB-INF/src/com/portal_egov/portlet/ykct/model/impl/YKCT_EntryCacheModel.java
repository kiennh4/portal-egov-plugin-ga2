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

import com.portal_egov.portlet.ykct.model.YKCT_Entry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing YKCT_Entry in entity cache.
 *
 * @author DucDVd
 * @see YKCT_Entry
 * @generated
 */
public class YKCT_EntryCacheModel implements CacheModel<YKCT_Entry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{entryId=");
		sb.append(entryId);
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
		sb.append(", entryName=");
		sb.append(entryName);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", fileAttachmentURL=");
		sb.append(fileAttachmentURL);
		sb.append("}");

		return sb.toString();
	}

	public YKCT_Entry toEntityModel() {
		YKCT_EntryImpl ykct_EntryImpl = new YKCT_EntryImpl();

		ykct_EntryImpl.setEntryId(entryId);
		ykct_EntryImpl.setGroupId(groupId);
		ykct_EntryImpl.setCompanyId(companyId);
		ykct_EntryImpl.setUserId(userId);

		if (userName == null) {
			ykct_EntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			ykct_EntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ykct_EntryImpl.setCreateDate(null);
		}
		else {
			ykct_EntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ykct_EntryImpl.setModifiedDate(null);
		}
		else {
			ykct_EntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (entryName == null) {
			ykct_EntryImpl.setEntryName(StringPool.BLANK);
		}
		else {
			ykct_EntryImpl.setEntryName(entryName);
		}

		ykct_EntryImpl.setCategoryId(categoryId);

		if (fileAttachmentURL == null) {
			ykct_EntryImpl.setFileAttachmentURL(StringPool.BLANK);
		}
		else {
			ykct_EntryImpl.setFileAttachmentURL(fileAttachmentURL);
		}

		ykct_EntryImpl.resetOriginalValues();

		return ykct_EntryImpl;
	}

	public long entryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String entryName;
	public long categoryId;
	public String fileAttachmentURL;
}