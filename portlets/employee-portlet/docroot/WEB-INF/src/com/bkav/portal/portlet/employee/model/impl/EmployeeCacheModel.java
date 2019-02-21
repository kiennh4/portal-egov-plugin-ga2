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

import com.bkav.portal.portlet.employee.model.Employee;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author ducdvd
 * @see Employee
 * @generated
 */
public class EmployeeCacheModel implements CacheModel<Employee>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{emplId=");
		sb.append(emplId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append(", male=");
		sb.append(male);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", addres=");
		sb.append(addres);
		sb.append(", email=");
		sb.append(email);
		sb.append(", postId=");
		sb.append(postId);
		sb.append(", depId=");
		sb.append(depId);
		sb.append(", sal=");
		sb.append(sal);
		sb.append(", breakDay=");
		sb.append(breakDay);
		sb.append(", addDay=");
		sb.append(addDay);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setEmplId(emplId);
		employeeImpl.setGroupId(groupId);
		employeeImpl.setCompanyId(companyId);
		employeeImpl.setUserId(userId);

		if (userName == null) {
			employeeImpl.setUserName(StringPool.BLANK);
		}
		else {
			employeeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeImpl.setCreateDate(null);
		}
		else {
			employeeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeImpl.setModifiedDate(null);
		}
		else {
			employeeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			employeeImpl.setName(StringPool.BLANK);
		}
		else {
			employeeImpl.setName(name);
		}

		if (birthday == Long.MIN_VALUE) {
			employeeImpl.setBirthday(null);
		}
		else {
			employeeImpl.setBirthday(new Date(birthday));
		}

		if (male == null) {
			employeeImpl.setMale(StringPool.BLANK);
		}
		else {
			employeeImpl.setMale(male);
		}

		employeeImpl.setPhone(phone);

		if (addres == null) {
			employeeImpl.setAddres(StringPool.BLANK);
		}
		else {
			employeeImpl.setAddres(addres);
		}

		if (email == null) {
			employeeImpl.setEmail(StringPool.BLANK);
		}
		else {
			employeeImpl.setEmail(email);
		}

		employeeImpl.setPostId(postId);
		employeeImpl.setDepId(depId);
		employeeImpl.setSal(sal);
		employeeImpl.setBreakDay(breakDay);
		employeeImpl.setAddDay(addDay);

		if (endDate == null) {
			employeeImpl.setEndDate(StringPool.BLANK);
		}
		else {
			employeeImpl.setEndDate(endDate);
		}

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	public long emplId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long birthday;
	public String male;
	public long phone;
	public String addres;
	public String email;
	public long postId;
	public long depId;
	public long sal;
	public int breakDay;
	public int addDay;
	public String endDate;
}