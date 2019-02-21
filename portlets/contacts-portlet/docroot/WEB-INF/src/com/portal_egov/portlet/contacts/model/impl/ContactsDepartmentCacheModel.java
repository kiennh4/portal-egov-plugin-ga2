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

package com.portal_egov.portlet.contacts.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.contacts.model.ContactsDepartment;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ContactsDepartment in entity cache.
 *
 * @author HungDX
 * @see ContactsDepartment
 * @generated
 */
public class ContactsDepartmentCacheModel implements CacheModel<ContactsDepartment>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{departmentId=");
		sb.append(departmentId);
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
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", departmentName=");
		sb.append(departmentName);
		sb.append(", departmentAddress=");
		sb.append(departmentAddress);
		sb.append(", departmentPhone=");
		sb.append(departmentPhone);
		sb.append(", departmentWebsite=");
		sb.append(departmentWebsite);
		sb.append(", departmentEmail=");
		sb.append(departmentEmail);
		sb.append(", displayPriority=");
		sb.append(displayPriority);
		sb.append(", departmentStatus=");
		sb.append(departmentStatus);
		sb.append("}");

		return sb.toString();
	}

	public ContactsDepartment toEntityModel() {
		ContactsDepartmentImpl contactsDepartmentImpl = new ContactsDepartmentImpl();

		contactsDepartmentImpl.setDepartmentId(departmentId);
		contactsDepartmentImpl.setGroupId(groupId);
		contactsDepartmentImpl.setCompanyId(companyId);
		contactsDepartmentImpl.setUserId(userId);

		if (userName == null) {
			contactsDepartmentImpl.setUserName(StringPool.BLANK);
		}
		else {
			contactsDepartmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			contactsDepartmentImpl.setCreateDate(null);
		}
		else {
			contactsDepartmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contactsDepartmentImpl.setModifiedDate(null);
		}
		else {
			contactsDepartmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		contactsDepartmentImpl.setParentId(parentId);

		if (departmentName == null) {
			contactsDepartmentImpl.setDepartmentName(StringPool.BLANK);
		}
		else {
			contactsDepartmentImpl.setDepartmentName(departmentName);
		}

		if (departmentAddress == null) {
			contactsDepartmentImpl.setDepartmentAddress(StringPool.BLANK);
		}
		else {
			contactsDepartmentImpl.setDepartmentAddress(departmentAddress);
		}

		if (departmentPhone == null) {
			contactsDepartmentImpl.setDepartmentPhone(StringPool.BLANK);
		}
		else {
			contactsDepartmentImpl.setDepartmentPhone(departmentPhone);
		}

		if (departmentWebsite == null) {
			contactsDepartmentImpl.setDepartmentWebsite(StringPool.BLANK);
		}
		else {
			contactsDepartmentImpl.setDepartmentWebsite(departmentWebsite);
		}

		if (departmentEmail == null) {
			contactsDepartmentImpl.setDepartmentEmail(StringPool.BLANK);
		}
		else {
			contactsDepartmentImpl.setDepartmentEmail(departmentEmail);
		}

		contactsDepartmentImpl.setDisplayPriority(displayPriority);
		contactsDepartmentImpl.setDepartmentStatus(departmentStatus);

		contactsDepartmentImpl.resetOriginalValues();

		return contactsDepartmentImpl;
	}

	public long departmentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long parentId;
	public String departmentName;
	public String departmentAddress;
	public String departmentPhone;
	public String departmentWebsite;
	public String departmentEmail;
	public int displayPriority;
	public int departmentStatus;
}