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
 * This class is a wrapper for {@link Department}.
 * </p>
 *
 * @author    ducdvd
 * @see       Department
 * @generated
 */
public class DepartmentWrapper implements Department, ModelWrapper<Department> {
	public DepartmentWrapper(Department department) {
		_department = department;
	}

	public Class<?> getModelClass() {
		return Department.class;
	}

	public String getModelClassName() {
		return Department.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("depId", getDepId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("depName", getDepName());
		attributes.put("depAddres", getDepAddres());
		attributes.put("depPhone", getDepPhone());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long depId = (Long)attributes.get("depId");

		if (depId != null) {
			setDepId(depId);
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

		String depName = (String)attributes.get("depName");

		if (depName != null) {
			setDepName(depName);
		}

		String depAddres = (String)attributes.get("depAddres");

		if (depAddres != null) {
			setDepAddres(depAddres);
		}

		String depPhone = (String)attributes.get("depPhone");

		if (depPhone != null) {
			setDepPhone(depPhone);
		}
	}

	/**
	* Returns the primary key of this department.
	*
	* @return the primary key of this department
	*/
	public long getPrimaryKey() {
		return _department.getPrimaryKey();
	}

	/**
	* Sets the primary key of this department.
	*
	* @param primaryKey the primary key of this department
	*/
	public void setPrimaryKey(long primaryKey) {
		_department.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dep ID of this department.
	*
	* @return the dep ID of this department
	*/
	public long getDepId() {
		return _department.getDepId();
	}

	/**
	* Sets the dep ID of this department.
	*
	* @param depId the dep ID of this department
	*/
	public void setDepId(long depId) {
		_department.setDepId(depId);
	}

	/**
	* Returns the group ID of this department.
	*
	* @return the group ID of this department
	*/
	public long getGroupId() {
		return _department.getGroupId();
	}

	/**
	* Sets the group ID of this department.
	*
	* @param groupId the group ID of this department
	*/
	public void setGroupId(long groupId) {
		_department.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this department.
	*
	* @return the company ID of this department
	*/
	public long getCompanyId() {
		return _department.getCompanyId();
	}

	/**
	* Sets the company ID of this department.
	*
	* @param companyId the company ID of this department
	*/
	public void setCompanyId(long companyId) {
		_department.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this department.
	*
	* @return the user ID of this department
	*/
	public long getUserId() {
		return _department.getUserId();
	}

	/**
	* Sets the user ID of this department.
	*
	* @param userId the user ID of this department
	*/
	public void setUserId(long userId) {
		_department.setUserId(userId);
	}

	/**
	* Returns the user uuid of this department.
	*
	* @return the user uuid of this department
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _department.getUserUuid();
	}

	/**
	* Sets the user uuid of this department.
	*
	* @param userUuid the user uuid of this department
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_department.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this department.
	*
	* @return the user name of this department
	*/
	public java.lang.String getUserName() {
		return _department.getUserName();
	}

	/**
	* Sets the user name of this department.
	*
	* @param userName the user name of this department
	*/
	public void setUserName(java.lang.String userName) {
		_department.setUserName(userName);
	}

	/**
	* Returns the create date of this department.
	*
	* @return the create date of this department
	*/
	public java.util.Date getCreateDate() {
		return _department.getCreateDate();
	}

	/**
	* Sets the create date of this department.
	*
	* @param createDate the create date of this department
	*/
	public void setCreateDate(java.util.Date createDate) {
		_department.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this department.
	*
	* @return the modified date of this department
	*/
	public java.util.Date getModifiedDate() {
		return _department.getModifiedDate();
	}

	/**
	* Sets the modified date of this department.
	*
	* @param modifiedDate the modified date of this department
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_department.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the dep name of this department.
	*
	* @return the dep name of this department
	*/
	public java.lang.String getDepName() {
		return _department.getDepName();
	}

	/**
	* Sets the dep name of this department.
	*
	* @param depName the dep name of this department
	*/
	public void setDepName(java.lang.String depName) {
		_department.setDepName(depName);
	}

	/**
	* Returns the dep addres of this department.
	*
	* @return the dep addres of this department
	*/
	public java.lang.String getDepAddres() {
		return _department.getDepAddres();
	}

	/**
	* Sets the dep addres of this department.
	*
	* @param depAddres the dep addres of this department
	*/
	public void setDepAddres(java.lang.String depAddres) {
		_department.setDepAddres(depAddres);
	}

	/**
	* Returns the dep phone of this department.
	*
	* @return the dep phone of this department
	*/
	public java.lang.String getDepPhone() {
		return _department.getDepPhone();
	}

	/**
	* Sets the dep phone of this department.
	*
	* @param depPhone the dep phone of this department
	*/
	public void setDepPhone(java.lang.String depPhone) {
		_department.setDepPhone(depPhone);
	}

	public boolean isNew() {
		return _department.isNew();
	}

	public void setNew(boolean n) {
		_department.setNew(n);
	}

	public boolean isCachedModel() {
		return _department.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_department.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _department.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _department.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_department.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _department.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_department.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DepartmentWrapper((Department)_department.clone());
	}

	public int compareTo(
		com.bkav.portal.portlet.employee.model.Department department) {
		return _department.compareTo(department);
	}

	@Override
	public int hashCode() {
		return _department.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.employee.model.Department> toCacheModel() {
		return _department.toCacheModel();
	}

	public com.bkav.portal.portlet.employee.model.Department toEscapedModel() {
		return new DepartmentWrapper(_department.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _department.toString();
	}

	public java.lang.String toXmlString() {
		return _department.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_department.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Department getWrappedDepartment() {
		return _department;
	}

	public Department getWrappedModel() {
		return _department;
	}

	public void resetOriginalValues() {
		_department.resetOriginalValues();
	}

	private Department _department;
}