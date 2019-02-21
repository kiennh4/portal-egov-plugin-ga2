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

package com.bkav.portal.portlet.employee.model.impl;

import com.bkav.portal.portlet.employee.model.Department;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Department in entity cache.
 *
 * @author ducdvd
 * @see Department
 * @generated
 */
public class DepartmentCacheModel implements CacheModel<Department>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{depId=");
		sb.append(depId);
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
		sb.append(", depName=");
		sb.append(depName);
		sb.append(", depAddres=");
		sb.append(depAddres);
		sb.append(", depPhone=");
		sb.append(depPhone);
		sb.append("}");

		return sb.toString();
	}

	public Department toEntityModel() {
		DepartmentImpl departmentImpl = new DepartmentImpl();

		departmentImpl.setDepId(depId);
		departmentImpl.setGroupId(groupId);
		departmentImpl.setCompanyId(companyId);
		departmentImpl.setUserId(userId);

		if (userName == null) {
			departmentImpl.setUserName(StringPool.BLANK);
		}
		else {
			departmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			departmentImpl.setCreateDate(null);
		}
		else {
			departmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			departmentImpl.setModifiedDate(null);
		}
		else {
			departmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (depName == null) {
			departmentImpl.setDepName(StringPool.BLANK);
		}
		else {
			departmentImpl.setDepName(depName);
		}

		if (depAddres == null) {
			departmentImpl.setDepAddres(StringPool.BLANK);
		}
		else {
			departmentImpl.setDepAddres(depAddres);
		}

		if (depPhone == null) {
			departmentImpl.setDepPhone(StringPool.BLANK);
		}
		else {
			departmentImpl.setDepPhone(depPhone);
		}

		departmentImpl.resetOriginalValues();

		return departmentImpl;
	}

	public long depId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String depName;
	public String depAddres;
	public String depPhone;
}