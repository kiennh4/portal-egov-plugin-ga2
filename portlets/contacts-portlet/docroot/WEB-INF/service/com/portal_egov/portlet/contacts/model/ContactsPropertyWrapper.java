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
 * This class is a wrapper for {@link ContactsProperty}.
 * </p>
 *
 * @author    HungDX
 * @see       ContactsProperty
 * @generated
 */
public class ContactsPropertyWrapper implements ContactsProperty,
	ModelWrapper<ContactsProperty> {
	public ContactsPropertyWrapper(ContactsProperty contactsProperty) {
		_contactsProperty = contactsProperty;
	}

	public Class<?> getModelClass() {
		return ContactsProperty.class;
	}

	public String getModelClassName() {
		return ContactsProperty.class.getName();
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
		attributes.put("contactId", getContactId());
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

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
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
	* Returns the primary key of this contacts property.
	*
	* @return the primary key of this contacts property
	*/
	public long getPrimaryKey() {
		return _contactsProperty.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contacts property.
	*
	* @param primaryKey the primary key of this contacts property
	*/
	public void setPrimaryKey(long primaryKey) {
		_contactsProperty.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the property ID of this contacts property.
	*
	* @return the property ID of this contacts property
	*/
	public long getPropertyId() {
		return _contactsProperty.getPropertyId();
	}

	/**
	* Sets the property ID of this contacts property.
	*
	* @param propertyId the property ID of this contacts property
	*/
	public void setPropertyId(long propertyId) {
		_contactsProperty.setPropertyId(propertyId);
	}

	/**
	* Returns the group ID of this contacts property.
	*
	* @return the group ID of this contacts property
	*/
	public long getGroupId() {
		return _contactsProperty.getGroupId();
	}

	/**
	* Sets the group ID of this contacts property.
	*
	* @param groupId the group ID of this contacts property
	*/
	public void setGroupId(long groupId) {
		_contactsProperty.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this contacts property.
	*
	* @return the company ID of this contacts property
	*/
	public long getCompanyId() {
		return _contactsProperty.getCompanyId();
	}

	/**
	* Sets the company ID of this contacts property.
	*
	* @param companyId the company ID of this contacts property
	*/
	public void setCompanyId(long companyId) {
		_contactsProperty.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this contacts property.
	*
	* @return the user ID of this contacts property
	*/
	public long getUserId() {
		return _contactsProperty.getUserId();
	}

	/**
	* Sets the user ID of this contacts property.
	*
	* @param userId the user ID of this contacts property
	*/
	public void setUserId(long userId) {
		_contactsProperty.setUserId(userId);
	}

	/**
	* Returns the user uuid of this contacts property.
	*
	* @return the user uuid of this contacts property
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsProperty.getUserUuid();
	}

	/**
	* Sets the user uuid of this contacts property.
	*
	* @param userUuid the user uuid of this contacts property
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_contactsProperty.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this contacts property.
	*
	* @return the user name of this contacts property
	*/
	public java.lang.String getUserName() {
		return _contactsProperty.getUserName();
	}

	/**
	* Sets the user name of this contacts property.
	*
	* @param userName the user name of this contacts property
	*/
	public void setUserName(java.lang.String userName) {
		_contactsProperty.setUserName(userName);
	}

	/**
	* Returns the create date of this contacts property.
	*
	* @return the create date of this contacts property
	*/
	public java.util.Date getCreateDate() {
		return _contactsProperty.getCreateDate();
	}

	/**
	* Sets the create date of this contacts property.
	*
	* @param createDate the create date of this contacts property
	*/
	public void setCreateDate(java.util.Date createDate) {
		_contactsProperty.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this contacts property.
	*
	* @return the modified date of this contacts property
	*/
	public java.util.Date getModifiedDate() {
		return _contactsProperty.getModifiedDate();
	}

	/**
	* Sets the modified date of this contacts property.
	*
	* @param modifiedDate the modified date of this contacts property
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_contactsProperty.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the contact ID of this contacts property.
	*
	* @return the contact ID of this contacts property
	*/
	public long getContactId() {
		return _contactsProperty.getContactId();
	}

	/**
	* Sets the contact ID of this contacts property.
	*
	* @param contactId the contact ID of this contacts property
	*/
	public void setContactId(long contactId) {
		_contactsProperty.setContactId(contactId);
	}

	/**
	* Returns the property key of this contacts property.
	*
	* @return the property key of this contacts property
	*/
	public java.lang.String getPropertyKey() {
		return _contactsProperty.getPropertyKey();
	}

	/**
	* Sets the property key of this contacts property.
	*
	* @param propertyKey the property key of this contacts property
	*/
	public void setPropertyKey(java.lang.String propertyKey) {
		_contactsProperty.setPropertyKey(propertyKey);
	}

	/**
	* Returns the property value of this contacts property.
	*
	* @return the property value of this contacts property
	*/
	public java.lang.String getPropertyValue() {
		return _contactsProperty.getPropertyValue();
	}

	/**
	* Sets the property value of this contacts property.
	*
	* @param propertyValue the property value of this contacts property
	*/
	public void setPropertyValue(java.lang.String propertyValue) {
		_contactsProperty.setPropertyValue(propertyValue);
	}

	/**
	* Returns the property type of this contacts property.
	*
	* @return the property type of this contacts property
	*/
	public java.lang.String getPropertyType() {
		return _contactsProperty.getPropertyType();
	}

	/**
	* Sets the property type of this contacts property.
	*
	* @param propertyType the property type of this contacts property
	*/
	public void setPropertyType(java.lang.String propertyType) {
		_contactsProperty.setPropertyType(propertyType);
	}

	public boolean isNew() {
		return _contactsProperty.isNew();
	}

	public void setNew(boolean n) {
		_contactsProperty.setNew(n);
	}

	public boolean isCachedModel() {
		return _contactsProperty.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_contactsProperty.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _contactsProperty.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _contactsProperty.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactsProperty.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactsProperty.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactsProperty.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactsPropertyWrapper((ContactsProperty)_contactsProperty.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.contacts.model.ContactsProperty contactsProperty) {
		return _contactsProperty.compareTo(contactsProperty);
	}

	@Override
	public int hashCode() {
		return _contactsProperty.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.contacts.model.ContactsProperty> toCacheModel() {
		return _contactsProperty.toCacheModel();
	}

	public com.portal_egov.portlet.contacts.model.ContactsProperty toEscapedModel() {
		return new ContactsPropertyWrapper(_contactsProperty.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactsProperty.toString();
	}

	public java.lang.String toXmlString() {
		return _contactsProperty.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactsProperty.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ContactsProperty getWrappedContactsProperty() {
		return _contactsProperty;
	}

	public ContactsProperty getWrappedModel() {
		return _contactsProperty;
	}

	public void resetOriginalValues() {
		_contactsProperty.resetOriginalValues();
	}

	private ContactsProperty _contactsProperty;
}