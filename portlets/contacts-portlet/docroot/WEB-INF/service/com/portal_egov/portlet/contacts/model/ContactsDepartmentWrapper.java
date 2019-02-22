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

package com.portal_egov.portlet.contacts.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ContactsDepartment}.
 * </p>
 *
 * @author    HungDX
 * @see       ContactsDepartment
 * @generated
 */
public class ContactsDepartmentWrapper implements ContactsDepartment,
	ModelWrapper<ContactsDepartment> {
	public ContactsDepartmentWrapper(ContactsDepartment contactsDepartment) {
		_contactsDepartment = contactsDepartment;
	}

	public Class<?> getModelClass() {
		return ContactsDepartment.class;
	}

	public String getModelClassName() {
		return ContactsDepartment.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("departmentId", getDepartmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("parentId", getParentId());
		attributes.put("departmentName", getDepartmentName());
		attributes.put("departmentAddress", getDepartmentAddress());
		attributes.put("departmentPhone", getDepartmentPhone());
		attributes.put("departmentWebsite", getDepartmentWebsite());
		attributes.put("departmentEmail", getDepartmentEmail());
		attributes.put("displayPriority", getDisplayPriority());
		attributes.put("departmentStatus", getDepartmentStatus());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
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

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String departmentName = (String)attributes.get("departmentName");

		if (departmentName != null) {
			setDepartmentName(departmentName);
		}

		String departmentAddress = (String)attributes.get("departmentAddress");

		if (departmentAddress != null) {
			setDepartmentAddress(departmentAddress);
		}

		String departmentPhone = (String)attributes.get("departmentPhone");

		if (departmentPhone != null) {
			setDepartmentPhone(departmentPhone);
		}

		String departmentWebsite = (String)attributes.get("departmentWebsite");

		if (departmentWebsite != null) {
			setDepartmentWebsite(departmentWebsite);
		}

		String departmentEmail = (String)attributes.get("departmentEmail");

		if (departmentEmail != null) {
			setDepartmentEmail(departmentEmail);
		}

		Integer displayPriority = (Integer)attributes.get("displayPriority");

		if (displayPriority != null) {
			setDisplayPriority(displayPriority);
		}

		Integer departmentStatus = (Integer)attributes.get("departmentStatus");

		if (departmentStatus != null) {
			setDepartmentStatus(departmentStatus);
		}
	}

	/**
	* Returns the primary key of this contacts department.
	*
	* @return the primary key of this contacts department
	*/
	public long getPrimaryKey() {
		return _contactsDepartment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contacts department.
	*
	* @param primaryKey the primary key of this contacts department
	*/
	public void setPrimaryKey(long primaryKey) {
		_contactsDepartment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the department ID of this contacts department.
	*
	* @return the department ID of this contacts department
	*/
	public long getDepartmentId() {
		return _contactsDepartment.getDepartmentId();
	}

	/**
	* Sets the department ID of this contacts department.
	*
	* @param departmentId the department ID of this contacts department
	*/
	public void setDepartmentId(long departmentId) {
		_contactsDepartment.setDepartmentId(departmentId);
	}

	/**
	* Returns the group ID of this contacts department.
	*
	* @return the group ID of this contacts department
	*/
	public long getGroupId() {
		return _contactsDepartment.getGroupId();
	}

	/**
	* Sets the group ID of this contacts department.
	*
	* @param groupId the group ID of this contacts department
	*/
	public void setGroupId(long groupId) {
		_contactsDepartment.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this contacts department.
	*
	* @return the company ID of this contacts department
	*/
	public long getCompanyId() {
		return _contactsDepartment.getCompanyId();
	}

	/**
	* Sets the company ID of this contacts department.
	*
	* @param companyId the company ID of this contacts department
	*/
	public void setCompanyId(long companyId) {
		_contactsDepartment.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this contacts department.
	*
	* @return the user ID of this contacts department
	*/
	public long getUserId() {
		return _contactsDepartment.getUserId();
	}

	/**
	* Sets the user ID of this contacts department.
	*
	* @param userId the user ID of this contacts department
	*/
	public void setUserId(long userId) {
		_contactsDepartment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this contacts department.
	*
	* @return the user uuid of this contacts department
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartment.getUserUuid();
	}

	/**
	* Sets the user uuid of this contacts department.
	*
	* @param userUuid the user uuid of this contacts department
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_contactsDepartment.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this contacts department.
	*
	* @return the user name of this contacts department
	*/
	public java.lang.String getUserName() {
		return _contactsDepartment.getUserName();
	}

	/**
	* Sets the user name of this contacts department.
	*
	* @param userName the user name of this contacts department
	*/
	public void setUserName(java.lang.String userName) {
		_contactsDepartment.setUserName(userName);
	}

	/**
	* Returns the create date of this contacts department.
	*
	* @return the create date of this contacts department
	*/
	public java.util.Date getCreateDate() {
		return _contactsDepartment.getCreateDate();
	}

	/**
	* Sets the create date of this contacts department.
	*
	* @param createDate the create date of this contacts department
	*/
	public void setCreateDate(java.util.Date createDate) {
		_contactsDepartment.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this contacts department.
	*
	* @return the modified date of this contacts department
	*/
	public java.util.Date getModifiedDate() {
		return _contactsDepartment.getModifiedDate();
	}

	/**
	* Sets the modified date of this contacts department.
	*
	* @param modifiedDate the modified date of this contacts department
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_contactsDepartment.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the parent ID of this contacts department.
	*
	* @return the parent ID of this contacts department
	*/
	public long getParentId() {
		return _contactsDepartment.getParentId();
	}

	/**
	* Sets the parent ID of this contacts department.
	*
	* @param parentId the parent ID of this contacts department
	*/
	public void setParentId(long parentId) {
		_contactsDepartment.setParentId(parentId);
	}

	/**
	* Returns the department name of this contacts department.
	*
	* @return the department name of this contacts department
	*/
	public java.lang.String getDepartmentName() {
		return _contactsDepartment.getDepartmentName();
	}

	/**
	* Sets the department name of this contacts department.
	*
	* @param departmentName the department name of this contacts department
	*/
	public void setDepartmentName(java.lang.String departmentName) {
		_contactsDepartment.setDepartmentName(departmentName);
	}

	/**
	* Returns the department address of this contacts department.
	*
	* @return the department address of this contacts department
	*/
	public java.lang.String getDepartmentAddress() {
		return _contactsDepartment.getDepartmentAddress();
	}

	/**
	* Sets the department address of this contacts department.
	*
	* @param departmentAddress the department address of this contacts department
	*/
	public void setDepartmentAddress(java.lang.String departmentAddress) {
		_contactsDepartment.setDepartmentAddress(departmentAddress);
	}

	/**
	* Returns the department phone of this contacts department.
	*
	* @return the department phone of this contacts department
	*/
	public java.lang.String getDepartmentPhone() {
		return _contactsDepartment.getDepartmentPhone();
	}

	/**
	* Sets the department phone of this contacts department.
	*
	* @param departmentPhone the department phone of this contacts department
	*/
	public void setDepartmentPhone(java.lang.String departmentPhone) {
		_contactsDepartment.setDepartmentPhone(departmentPhone);
	}

	/**
	* Returns the department website of this contacts department.
	*
	* @return the department website of this contacts department
	*/
	public java.lang.String getDepartmentWebsite() {
		return _contactsDepartment.getDepartmentWebsite();
	}

	/**
	* Sets the department website of this contacts department.
	*
	* @param departmentWebsite the department website of this contacts department
	*/
	public void setDepartmentWebsite(java.lang.String departmentWebsite) {
		_contactsDepartment.setDepartmentWebsite(departmentWebsite);
	}

	/**
	* Returns the department email of this contacts department.
	*
	* @return the department email of this contacts department
	*/
	public java.lang.String getDepartmentEmail() {
		return _contactsDepartment.getDepartmentEmail();
	}

	/**
	* Sets the department email of this contacts department.
	*
	* @param departmentEmail the department email of this contacts department
	*/
	public void setDepartmentEmail(java.lang.String departmentEmail) {
		_contactsDepartment.setDepartmentEmail(departmentEmail);
	}

	/**
	* Returns the display priority of this contacts department.
	*
	* @return the display priority of this contacts department
	*/
	public int getDisplayPriority() {
		return _contactsDepartment.getDisplayPriority();
	}

	/**
	* Sets the display priority of this contacts department.
	*
	* @param displayPriority the display priority of this contacts department
	*/
	public void setDisplayPriority(int displayPriority) {
		_contactsDepartment.setDisplayPriority(displayPriority);
	}

	/**
	* Returns the department status of this contacts department.
	*
	* @return the department status of this contacts department
	*/
	public int getDepartmentStatus() {
		return _contactsDepartment.getDepartmentStatus();
	}

	/**
	* Sets the department status of this contacts department.
	*
	* @param departmentStatus the department status of this contacts department
	*/
	public void setDepartmentStatus(int departmentStatus) {
		_contactsDepartment.setDepartmentStatus(departmentStatus);
	}

	public boolean isNew() {
		return _contactsDepartment.isNew();
	}

	public void setNew(boolean n) {
		_contactsDepartment.setNew(n);
	}

	public boolean isCachedModel() {
		return _contactsDepartment.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_contactsDepartment.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _contactsDepartment.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _contactsDepartment.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactsDepartment.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactsDepartment.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactsDepartment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactsDepartmentWrapper((ContactsDepartment)_contactsDepartment.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.contacts.model.ContactsDepartment contactsDepartment) {
		return _contactsDepartment.compareTo(contactsDepartment);
	}

	@Override
	public int hashCode() {
		return _contactsDepartment.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.contacts.model.ContactsDepartment> toCacheModel() {
		return _contactsDepartment.toCacheModel();
	}

	public com.portal_egov.portlet.contacts.model.ContactsDepartment toEscapedModel() {
		return new ContactsDepartmentWrapper(_contactsDepartment.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactsDepartment.toString();
	}

	public java.lang.String toXmlString() {
		return _contactsDepartment.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactsDepartment.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ContactsDepartment getWrappedContactsDepartment() {
		return _contactsDepartment;
	}

	public ContactsDepartment getWrappedModel() {
		return _contactsDepartment;
	}

	public void resetOriginalValues() {
		_contactsDepartment.resetOriginalValues();
	}

	private ContactsDepartment _contactsDepartment;
}