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
 * This class is a wrapper for {@link ContactsDepartmentProperty}.
 * </p>
 *
 * @author    HungDX
 * @see       ContactsDepartmentProperty
 * @generated
 */
public class ContactsDepartmentPropertyWrapper
	implements ContactsDepartmentProperty,
		ModelWrapper<ContactsDepartmentProperty> {
	public ContactsDepartmentPropertyWrapper(
		ContactsDepartmentProperty contactsDepartmentProperty) {
		_contactsDepartmentProperty = contactsDepartmentProperty;
	}

	public Class<?> getModelClass() {
		return ContactsDepartmentProperty.class;
	}

	public String getModelClassName() {
		return ContactsDepartmentProperty.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("propertyId", getPropertyId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("propertyKey", getPropertyKey());
		attributes.put("propertyValue", getPropertyValue());
		attributes.put("propertyType", getPropertyType());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long propertyId = (Long)attributes.get("propertyId");

		if (propertyId != null) {
			setPropertyId(propertyId);
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

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		String propertyKey = (String)attributes.get("propertyKey");

		if (propertyKey != null) {
			setPropertyKey(propertyKey);
		}

		String propertyValue = (String)attributes.get("propertyValue");

		if (propertyValue != null) {
			setPropertyValue(propertyValue);
		}

		String propertyType = (String)attributes.get("propertyType");

		if (propertyType != null) {
			setPropertyType(propertyType);
		}
	}

	/**
	* Returns the primary key of this contacts department property.
	*
	* @return the primary key of this contacts department property
	*/
	public long getPrimaryKey() {
		return _contactsDepartmentProperty.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contacts department property.
	*
	* @param primaryKey the primary key of this contacts department property
	*/
	public void setPrimaryKey(long primaryKey) {
		_contactsDepartmentProperty.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the property ID of this contacts department property.
	*
	* @return the property ID of this contacts department property
	*/
	public long getPropertyId() {
		return _contactsDepartmentProperty.getPropertyId();
	}

	/**
	* Sets the property ID of this contacts department property.
	*
	* @param propertyId the property ID of this contacts department property
	*/
	public void setPropertyId(long propertyId) {
		_contactsDepartmentProperty.setPropertyId(propertyId);
	}

	/**
	* Returns the group ID of this contacts department property.
	*
	* @return the group ID of this contacts department property
	*/
	public long getGroupId() {
		return _contactsDepartmentProperty.getGroupId();
	}

	/**
	* Sets the group ID of this contacts department property.
	*
	* @param groupId the group ID of this contacts department property
	*/
	public void setGroupId(long groupId) {
		_contactsDepartmentProperty.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this contacts department property.
	*
	* @return the company ID of this contacts department property
	*/
	public long getCompanyId() {
		return _contactsDepartmentProperty.getCompanyId();
	}

	/**
	* Sets the company ID of this contacts department property.
	*
	* @param companyId the company ID of this contacts department property
	*/
	public void setCompanyId(long companyId) {
		_contactsDepartmentProperty.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this contacts department property.
	*
	* @return the user ID of this contacts department property
	*/
	public long getUserId() {
		return _contactsDepartmentProperty.getUserId();
	}

	/**
	* Sets the user ID of this contacts department property.
	*
	* @param userId the user ID of this contacts department property
	*/
	public void setUserId(long userId) {
		_contactsDepartmentProperty.setUserId(userId);
	}

	/**
	* Returns the user uuid of this contacts department property.
	*
	* @return the user uuid of this contacts department property
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentProperty.getUserUuid();
	}

	/**
	* Sets the user uuid of this contacts department property.
	*
	* @param userUuid the user uuid of this contacts department property
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_contactsDepartmentProperty.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this contacts department property.
	*
	* @return the user name of this contacts department property
	*/
	public java.lang.String getUserName() {
		return _contactsDepartmentProperty.getUserName();
	}

	/**
	* Sets the user name of this contacts department property.
	*
	* @param userName the user name of this contacts department property
	*/
	public void setUserName(java.lang.String userName) {
		_contactsDepartmentProperty.setUserName(userName);
	}

	/**
	* Returns the create date of this contacts department property.
	*
	* @return the create date of this contacts department property
	*/
	public java.util.Date getCreateDate() {
		return _contactsDepartmentProperty.getCreateDate();
	}

	/**
	* Sets the create date of this contacts department property.
	*
	* @param createDate the create date of this contacts department property
	*/
	public void setCreateDate(java.util.Date createDate) {
		_contactsDepartmentProperty.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this contacts department property.
	*
	* @return the modified date of this contacts department property
	*/
	public java.util.Date getModifiedDate() {
		return _contactsDepartmentProperty.getModifiedDate();
	}

	/**
	* Sets the modified date of this contacts department property.
	*
	* @param modifiedDate the modified date of this contacts department property
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_contactsDepartmentProperty.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the department ID of this contacts department property.
	*
	* @return the department ID of this contacts department property
	*/
	public long getDepartmentId() {
		return _contactsDepartmentProperty.getDepartmentId();
	}

	/**
	* Sets the department ID of this contacts department property.
	*
	* @param departmentId the department ID of this contacts department property
	*/
	public void setDepartmentId(long departmentId) {
		_contactsDepartmentProperty.setDepartmentId(departmentId);
	}

	/**
	* Returns the property key of this contacts department property.
	*
	* @return the property key of this contacts department property
	*/
	public java.lang.String getPropertyKey() {
		return _contactsDepartmentProperty.getPropertyKey();
	}

	/**
	* Sets the property key of this contacts department property.
	*
	* @param propertyKey the property key of this contacts department property
	*/
	public void setPropertyKey(java.lang.String propertyKey) {
		_contactsDepartmentProperty.setPropertyKey(propertyKey);
	}

	/**
	* Returns the property value of this contacts department property.
	*
	* @return the property value of this contacts department property
	*/
	public java.lang.String getPropertyValue() {
		return _contactsDepartmentProperty.getPropertyValue();
	}

	/**
	* Sets the property value of this contacts department property.
	*
	* @param propertyValue the property value of this contacts department property
	*/
	public void setPropertyValue(java.lang.String propertyValue) {
		_contactsDepartmentProperty.setPropertyValue(propertyValue);
	}

	/**
	* Returns the property type of this contacts department property.
	*
	* @return the property type of this contacts department property
	*/
	public java.lang.String getPropertyType() {
		return _contactsDepartmentProperty.getPropertyType();
	}

	/**
	* Sets the property type of this contacts department property.
	*
	* @param propertyType the property type of this contacts department property
	*/
	public void setPropertyType(java.lang.String propertyType) {
		_contactsDepartmentProperty.setPropertyType(propertyType);
	}

	public boolean isNew() {
		return _contactsDepartmentProperty.isNew();
	}

	public void setNew(boolean n) {
		_contactsDepartmentProperty.setNew(n);
	}

	public boolean isCachedModel() {
		return _contactsDepartmentProperty.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_contactsDepartmentProperty.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _contactsDepartmentProperty.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _contactsDepartmentProperty.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactsDepartmentProperty.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactsDepartmentProperty.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactsDepartmentProperty.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactsDepartmentPropertyWrapper((ContactsDepartmentProperty)_contactsDepartmentProperty.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty contactsDepartmentProperty) {
		return _contactsDepartmentProperty.compareTo(contactsDepartmentProperty);
	}

	@Override
	public int hashCode() {
		return _contactsDepartmentProperty.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> toCacheModel() {
		return _contactsDepartmentProperty.toCacheModel();
	}

	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty toEscapedModel() {
		return new ContactsDepartmentPropertyWrapper(_contactsDepartmentProperty.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactsDepartmentProperty.toString();
	}

	public java.lang.String toXmlString() {
		return _contactsDepartmentProperty.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactsDepartmentProperty.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ContactsDepartmentProperty getWrappedContactsDepartmentProperty() {
		return _contactsDepartmentProperty;
	}

	public ContactsDepartmentProperty getWrappedModel() {
		return _contactsDepartmentProperty;
	}

	public void resetOriginalValues() {
		_contactsDepartmentProperty.resetOriginalValues();
	}

	private ContactsDepartmentProperty _contactsDepartmentProperty;
}