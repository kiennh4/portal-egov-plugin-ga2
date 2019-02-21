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

package com.bkav.portal.portlet.employee.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author    ducdvd
 * @see       Employee
 * @generated
 */
public class EmployeeWrapper implements Employee, ModelWrapper<Employee> {
	public EmployeeWrapper(Employee employee) {
		_employee = employee;
	}

	public Class<?> getModelClass() {
		return Employee.class;
	}

	public String getModelClassName() {
		return Employee.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("emplId", getEmplId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("birthday", getBirthday());
		attributes.put("male", getMale());
		attributes.put("phone", getPhone());
		attributes.put("addres", getAddres());
		attributes.put("email", getEmail());
		attributes.put("postId", getPostId());
		attributes.put("depId", getDepId());
		attributes.put("sal", getSal());
		attributes.put("breakDay", getBreakDay());
		attributes.put("addDay", getAddDay());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long emplId = (Long)attributes.get("emplId");

		if (emplId != null) {
			setEmplId(emplId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		String male = (String)attributes.get("male");

		if (male != null) {
			setMale(male);
		}

		Long phone = (Long)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String addres = (String)attributes.get("addres");

		if (addres != null) {
			setAddres(addres);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
		}

		Long depId = (Long)attributes.get("depId");

		if (depId != null) {
			setDepId(depId);
		}

		Long sal = (Long)attributes.get("sal");

		if (sal != null) {
			setSal(sal);
		}

		Integer breakDay = (Integer)attributes.get("breakDay");

		if (breakDay != null) {
			setBreakDay(breakDay);
		}

		Integer addDay = (Integer)attributes.get("addDay");

		if (addDay != null) {
			setAddDay(addDay);
		}

		String endDate = (String)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	/**
	* Returns the primary key of this employee.
	*
	* @return the primary key of this employee
	*/
	public long getPrimaryKey() {
		return _employee.getPrimaryKey();
	}

	/**
	* Sets the primary key of this employee.
	*
	* @param primaryKey the primary key of this employee
	*/
	public void setPrimaryKey(long primaryKey) {
		_employee.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the empl ID of this employee.
	*
	* @return the empl ID of this employee
	*/
	public long getEmplId() {
		return _employee.getEmplId();
	}

	/**
	* Sets the empl ID of this employee.
	*
	* @param emplId the empl ID of this employee
	*/
	public void setEmplId(long emplId) {
		_employee.setEmplId(emplId);
	}

	/**
	* Returns the group ID of this employee.
	*
	* @return the group ID of this employee
	*/
	public long getGroupId() {
		return _employee.getGroupId();
	}

	/**
	* Sets the group ID of this employee.
	*
	* @param groupId the group ID of this employee
	*/
	public void setGroupId(long groupId) {
		_employee.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this employee.
	*
	* @return the company ID of this employee
	*/
	public long getCompanyId() {
		return _employee.getCompanyId();
	}

	/**
	* Sets the company ID of this employee.
	*
	* @param companyId the company ID of this employee
	*/
	public void setCompanyId(long companyId) {
		_employee.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this employee.
	*
	* @return the user ID of this employee
	*/
	public long getUserId() {
		return _employee.getUserId();
	}

	/**
	* Sets the user ID of this employee.
	*
	* @param userId the user ID of this employee
	*/
	public void setUserId(long userId) {
		_employee.setUserId(userId);
	}

	/**
	* Returns the user uuid of this employee.
	*
	* @return the user uuid of this employee
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employee.getUserUuid();
	}

	/**
	* Sets the user uuid of this employee.
	*
	* @param userUuid the user uuid of this employee
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_employee.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this employee.
	*
	* @return the user name of this employee
	*/
	public java.lang.String getUserName() {
		return _employee.getUserName();
	}

	/**
	* Sets the user name of this employee.
	*
	* @param userName the user name of this employee
	*/
	public void setUserName(java.lang.String userName) {
		_employee.setUserName(userName);
	}

	/**
	* Returns the create date of this employee.
	*
	* @return the create date of this employee
	*/
	public java.util.Date getCreateDate() {
		return _employee.getCreateDate();
	}

	/**
	* Sets the create date of this employee.
	*
	* @param createDate the create date of this employee
	*/
	public void setCreateDate(java.util.Date createDate) {
		_employee.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this employee.
	*
	* @return the modified date of this employee
	*/
	public java.util.Date getModifiedDate() {
		return _employee.getModifiedDate();
	}

	/**
	* Sets the modified date of this employee.
	*
	* @param modifiedDate the modified date of this employee
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_employee.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this employee.
	*
	* @return the name of this employee
	*/
	public java.lang.String getName() {
		return _employee.getName();
	}

	/**
	* Sets the name of this employee.
	*
	* @param name the name of this employee
	*/
	public void setName(java.lang.String name) {
		_employee.setName(name);
	}

	/**
	* Returns the birthday of this employee.
	*
	* @return the birthday of this employee
	*/
	public java.util.Date getBirthday() {
		return _employee.getBirthday();
	}

	/**
	* Sets the birthday of this employee.
	*
	* @param birthday the birthday of this employee
	*/
	public void setBirthday(java.util.Date birthday) {
		_employee.setBirthday(birthday);
	}

	/**
	* Returns the male of this employee.
	*
	* @return the male of this employee
	*/
	public java.lang.String getMale() {
		return _employee.getMale();
	}

	/**
	* Sets the male of this employee.
	*
	* @param male the male of this employee
	*/
	public void setMale(java.lang.String male) {
		_employee.setMale(male);
	}

	/**
	* Returns the phone of this employee.
	*
	* @return the phone of this employee
	*/
	public long getPhone() {
		return _employee.getPhone();
	}

	/**
	* Sets the phone of this employee.
	*
	* @param phone the phone of this employee
	*/
	public void setPhone(long phone) {
		_employee.setPhone(phone);
	}

	/**
	* Returns the addres of this employee.
	*
	* @return the addres of this employee
	*/
	public java.lang.String getAddres() {
		return _employee.getAddres();
	}

	/**
	* Sets the addres of this employee.
	*
	* @param addres the addres of this employee
	*/
	public void setAddres(java.lang.String addres) {
		_employee.setAddres(addres);
	}

	/**
	* Returns the email of this employee.
	*
	* @return the email of this employee
	*/
	public java.lang.String getEmail() {
		return _employee.getEmail();
	}

	/**
	* Sets the email of this employee.
	*
	* @param email the email of this employee
	*/
	public void setEmail(java.lang.String email) {
		_employee.setEmail(email);
	}

	/**
	* Returns the post ID of this employee.
	*
	* @return the post ID of this employee
	*/
	public long getPostId() {
		return _employee.getPostId();
	}

	/**
	* Sets the post ID of this employee.
	*
	* @param postId the post ID of this employee
	*/
	public void setPostId(long postId) {
		_employee.setPostId(postId);
	}

	/**
	* Returns the dep ID of this employee.
	*
	* @return the dep ID of this employee
	*/
	public long getDepId() {
		return _employee.getDepId();
	}

	/**
	* Sets the dep ID of this employee.
	*
	* @param depId the dep ID of this employee
	*/
	public void setDepId(long depId) {
		_employee.setDepId(depId);
	}

	/**
	* Returns the sal of this employee.
	*
	* @return the sal of this employee
	*/
	public long getSal() {
		return _employee.getSal();
	}

	/**
	* Sets the sal of this employee.
	*
	* @param sal the sal of this employee
	*/
	public void setSal(long sal) {
		_employee.setSal(sal);
	}

	/**
	* Returns the break day of this employee.
	*
	* @return the break day of this employee
	*/
	public int getBreakDay() {
		return _employee.getBreakDay();
	}

	/**
	* Sets the break day of this employee.
	*
	* @param breakDay the break day of this employee
	*/
	public void setBreakDay(int breakDay) {
		_employee.setBreakDay(breakDay);
	}

	/**
	* Returns the add day of this employee.
	*
	* @return the add day of this employee
	*/
	public int getAddDay() {
		return _employee.getAddDay();
	}

	/**
	* Sets the add day of this employee.
	*
	* @param addDay the add day of this employee
	*/
	public void setAddDay(int addDay) {
		_employee.setAddDay(addDay);
	}

	/**
	* Returns the end date of this employee.
	*
	* @return the end date of this employee
	*/
	public java.lang.String getEndDate() {
		return _employee.getEndDate();
	}

	/**
	* Sets the end date of this employee.
	*
	* @param endDate the end date of this employee
	*/
	public void setEndDate(java.lang.String endDate) {
		_employee.setEndDate(endDate);
	}

	public boolean isNew() {
		return _employee.isNew();
	}

	public void setNew(boolean n) {
		_employee.setNew(n);
	}

	public boolean isCachedModel() {
		return _employee.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_employee.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _employee.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _employee.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_employee.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _employee.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_employee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmployeeWrapper((Employee)_employee.clone());
	}

	public int compareTo(
		com.bkav.portal.portlet.employee.model.Employee employee) {
		return _employee.compareTo(employee);
	}

	@Override
	public int hashCode() {
		return _employee.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.employee.model.Employee> toCacheModel() {
		return _employee.toCacheModel();
	}

	public com.bkav.portal.portlet.employee.model.Employee toEscapedModel() {
		return new EmployeeWrapper(_employee.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _employee.toString();
	}

	public java.lang.String toXmlString() {
		return _employee.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_employee.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Employee getWrappedEmployee() {
		return _employee;
	}

	public Employee getWrappedModel() {
		return _employee;
	}

	public void resetOriginalValues() {
		_employee.resetOriginalValues();
	}

	private Employee _employee;
}