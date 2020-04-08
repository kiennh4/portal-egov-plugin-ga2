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

import com.portal_egov.portlet.tthc.model.TTHC_Entry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TTHC_Entry in entity cache.
 *
 * @author HungDX
 * @see TTHC_Entry
 * @generated
 */
public class TTHC_EntryCacheModel implements CacheModel<TTHC_Entry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{entryId=");
		sb.append(entryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", levelId=");
		sb.append(levelId);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", audienceId=");
		sb.append(audienceId);
		sb.append(", resultTypeId=");
		sb.append(resultTypeId);
		sb.append(", entryCode=");
		sb.append(entryCode);
		sb.append(", entryName=");
		sb.append(entryName);
		sb.append(", entryDesc=");
		sb.append(entryDesc);
		sb.append(", processGuide=");
		sb.append(processGuide);
		sb.append(", processType=");
		sb.append(processType);
		sb.append(", processTime=");
		sb.append(processTime);
		sb.append(", processFee=");
		sb.append(processFee);
		sb.append(", processRequirement=");
		sb.append(processRequirement);
		sb.append(", processFoundationDocument=");
		sb.append(processFoundationDocument);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	public TTHC_Entry toEntityModel() {
		TTHC_EntryImpl tthc_EntryImpl = new TTHC_EntryImpl();

		tthc_EntryImpl.setEntryId(entryId);
		tthc_EntryImpl.setCompanyId(companyId);
		tthc_EntryImpl.setGroupId(groupId);
		tthc_EntryImpl.setUserId(userId);

		if (userName == null) {
			tthc_EntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			tthc_EntryImpl.setUserName(userName);
		}

		tthc_EntryImpl.setLevelId(levelId);
		tthc_EntryImpl.setDepartmentId(departmentId);
		tthc_EntryImpl.setCategoryId(categoryId);
		tthc_EntryImpl.setAudienceId(audienceId);
		tthc_EntryImpl.setResultTypeId(resultTypeId);

		if (entryCode == null) {
			tthc_EntryImpl.setEntryCode(StringPool.BLANK);
		}
		else {
			tthc_EntryImpl.setEntryCode(entryCode);
		}

		if (entryName == null) {
			tthc_EntryImpl.setEntryName(StringPool.BLANK);
		}
		else {
			tthc_EntryImpl.setEntryName(entryName);
		}

		if (entryDesc == null) {
			tthc_EntryImpl.setEntryDesc(StringPool.BLANK);
		}
		else {
			tthc_EntryImpl.setEntryDesc(entryDesc);
		}

		if (processGuide == null) {
			tthc_EntryImpl.setProcessGuide(StringPool.BLANK);
		}
		else {
			tthc_EntryImpl.setProcessGuide(processGuide);
		}

		if (processType == null) {
			tthc_EntryImpl.setProcessType(StringPool.BLANK);
		}
		else {
			tthc_EntryImpl.setProcessType(processType);
		}

		if (processTime == null) {
			tthc_EntryImpl.setProcessTime(StringPool.BLANK);
		}
		else {
			tthc_EntryImpl.setProcessTime(processTime);
		}

		if (processFee == null) {
			tthc_EntryImpl.setProcessFee(StringPool.BLANK);
		}
		else {
			tthc_EntryImpl.setProcessFee(processFee);
		}

		if (processRequirement == null) {
			tthc_EntryImpl.setProcessRequirement(StringPool.BLANK);
		}
		else {
			tthc_EntryImpl.setProcessRequirement(processRequirement);
		}

		if (processFoundationDocument == null) {
			tthc_EntryImpl.setProcessFoundationDocument(StringPool.BLANK);
		}
		else {
			tthc_EntryImpl.setProcessFoundationDocument(processFoundationDocument);
		}

		if (createDate == Long.MIN_VALUE) {
			tthc_EntryImpl.setCreateDate(null);
		}
		else {
			tthc_EntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tthc_EntryImpl.setModifiedDate(null);
		}
		else {
			tthc_EntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		tthc_EntryImpl.resetOriginalValues();

		return tthc_EntryImpl;
	}

	public long entryId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long levelId;
	public long departmentId;
	public long categoryId;
	public long audienceId;
	public long resultTypeId;
	public String entryCode;
	public String entryName;
	public String entryDesc;
	public String processGuide;
	public String processType;
	public String processTime;
	public String processFee;
	public String processRequirement;
	public String processFoundationDocument;
	public long createDate;
	public long modifiedDate;
}