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
 * This class is a wrapper for {@link Contacts}.
 * </p>
 *
 * @author    HungDX
 * @see       Contacts
 * @generated
 */
public class ContactsWrapper implements Contacts, ModelWrapper<Contacts> {
	public ContactsWrapper(Contacts contacts) {
		_contacts = contacts;
	}

	public Class<?> getModelClass() {
		return Contacts.class;
	}

	public String getModelClassName() {
		return Contacts.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactId", getContactId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("imageId", getImageId());
		attributes.put("contactName", getContactName());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("phoneNumbers", getPhoneNumbers());
		attributes.put("homePhone", getHomePhone());
		attributes.put("mobile", getMobile());
		attributes.put("email", getEmail());
		attributes.put("displayPriority", getDisplayPriority());
		attributes.put("contactStatus", getContactStatus());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
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

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String contactName = (String)attributes.get("contactName");

		if (contactName != null) {
			setContactName(contactName);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		String phoneNumbers = (String)attributes.get("phoneNumbers");

		if (phoneNumbers != null) {
			setPhoneNumbers(phoneNumbers);
		}

		String homePhone = (String)attributes.get("homePhone");

		if (homePhone != null) {
			setHomePhone(homePhone);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Integer displayPriority = (Integer)attributes.get("displayPriority");

		if (displayPriority != null) {
			setDisplayPriority(displayPriority);
		}

		Integer contactStatus = (Integer)attributes.get("contactStatus");

		if (contactStatus != null) {
			setContactStatus(contactStatus);
		}
	}

	/**
	* Returns the primary key of this contacts.
	*
	* @return the primary key of this contacts
	*/
	public long getPrimaryKey() {
		return _contacts.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contacts.
	*
	* @param primaryKey the primary key of this contacts
	*/
	public void setPrimaryKey(long primaryKey) {
		_contacts.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact ID of this contacts.
	*
	* @return the contact ID of this contacts
	*/
	public long getContactId() {
		return _contacts.getContactId();
	}

	/**
	* Sets the contact ID of this contacts.
	*
	* @param contactId the contact ID of this contacts
	*/
	public void setContactId(long contactId) {
		_contacts.setContactId(contactId);
	}

	/**
	* Returns the group ID of this contacts.
	*
	* @return the group ID of this contacts
	*/
	public long getGroupId() {
		return _contacts.getGroupId();
	}

	/**
	* Sets the group ID of this contacts.
	*
	* @param groupId the group ID of this contacts
	*/
	public void setGroupId(long groupId) {
		_contacts.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this contacts.
	*
	* @return the company ID of this contacts
	*/
	public long getCompanyId() {
		return _contacts.getCompanyId();
	}

	/**
	* Sets the company ID of this contacts.
	*
	* @param companyId the company ID of this contacts
	*/
	public void setCompanyId(long companyId) {
		_contacts.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this contacts.
	*
	* @return the user ID of this contacts
	*/
	public long getUserId() {
		return _contacts.getUserId();
	}

	/**
	* Sets the user ID of this contacts.
	*
	* @param userId the user ID of this contacts
	*/
	public void setUserId(long userId) {
		_contacts.setUserId(userId);
	}

	/**
	* Returns the user uuid of this contacts.
	*
	* @return the user uuid of this contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contacts.getUserUuid();
	}

	/**
	* Sets the user uuid of this contacts.
	*
	* @param userUuid the user uuid of this contacts
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_contacts.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this contacts.
	*
	* @return the user name of this contacts
	*/
	public java.lang.String getUserName() {
		return _contacts.getUserName();
	}

	/**
	* Sets the user name of this contacts.
	*
	* @param userName the user name of this contacts
	*/
	public void setUserName(java.lang.String userName) {
		_contacts.setUserName(userName);
	}

	/**
	* Returns the create date of this contacts.
	*
	* @return the create date of this contacts
	*/
	public java.util.Date getCreateDate() {
		return _contacts.getCreateDate();
	}

	/**
	* Sets the create date of this contacts.
	*
	* @param createDate the create date of this contacts
	*/
	public void setCreateDate(java.util.Date createDate) {
		_contacts.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this contacts.
	*
	* @return the modified date of this contacts
	*/
	public java.util.Date getModifiedDate() {
		return _contacts.getModifiedDate();
	}

	/**
	* Sets the modified date of this contacts.
	*
	* @param modifiedDate the modified date of this contacts
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_contacts.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the department ID of this contacts.
	*
	* @return the department ID of this contacts
	*/
	public long getDepartmentId() {
		return _contacts.getDepartmentId();
	}

	/**
	* Sets the department ID of this contacts.
	*
	* @param departmentId the department ID of this contacts
	*/
	public void setDepartmentId(long departmentId) {
		_contacts.setDepartmentId(departmentId);
	}

	/**
	* Returns the image ID of this contacts.
	*
	* @return the image ID of this contacts
	*/
	public long getImageId() {
		return _contacts.getImageId();
	}

	/**
	* Sets the image ID of this contacts.
	*
	* @param imageId the image ID of this contacts
	*/
	public void setImageId(long imageId) {
		_contacts.setImageId(imageId);
	}

	/**
	* Returns the contact name of this contacts.
	*
	* @return the contact name of this contacts
	*/
	public java.lang.String getContactName() {
		return _contacts.getContactName();
	}

	/**
	* Sets the contact name of this contacts.
	*
	* @param contactName the contact name of this contacts
	*/
	public void setContactName(java.lang.String contactName) {
		_contacts.setContactName(contactName);
	}

	/**
	* Returns the job title of this contacts.
	*
	* @return the job title of this contacts
	*/
	public java.lang.String getJobTitle() {
		return _contacts.getJobTitle();
	}

	/**
	* Sets the job title of this contacts.
	*
	* @param jobTitle the job title of this contacts
	*/
	public void setJobTitle(java.lang.String jobTitle) {
		_contacts.setJobTitle(jobTitle);
	}

	/**
	* Returns the phone numbers of this contacts.
	*
	* @return the phone numbers of this contacts
	*/
	public java.lang.String getPhoneNumbers() {
		return _contacts.getPhoneNumbers();
	}

	/**
	* Sets the phone numbers of this contacts.
	*
	* @param phoneNumbers the phone numbers of this contacts
	*/
	public void setPhoneNumbers(java.lang.String phoneNumbers) {
		_contacts.setPhoneNumbers(phoneNumbers);
	}

	/**
	* Returns the home phone of this contacts.
	*
	* @return the home phone of this contacts
	*/
	public java.lang.String getHomePhone() {
		return _contacts.getHomePhone();
	}

	/**
	* Sets the home phone of this contacts.
	*
	* @param homePhone the home phone of this contacts
	*/
	public void setHomePhone(java.lang.String homePhone) {
		_contacts.setHomePhone(homePhone);
	}

	/**
	* Returns the mobile of this contacts.
	*
	* @return the mobile of this contacts
	*/
	public java.lang.String getMobile() {
		return _contacts.getMobile();
	}

	/**
	* Sets the mobile of this contacts.
	*
	* @param mobile the mobile of this contacts
	*/
	public void setMobile(java.lang.String mobile) {
		_contacts.setMobile(mobile);
	}

	/**
	* Returns the email of this contacts.
	*
	* @return the email of this contacts
	*/
	public java.lang.String getEmail() {
		return _contacts.getEmail();
	}

	/**
	* Sets the email of this contacts.
	*
	* @param email the email of this contacts
	*/
	public void setEmail(java.lang.String email) {
		_contacts.setEmail(email);
	}

	/**
	* Returns the display priority of this contacts.
	*
	* @return the display priority of this contacts
	*/
	public int getDisplayPriority() {
		return _contacts.getDisplayPriority();
	}

	/**
	* Sets the display priority of this contacts.
	*
	* @param displayPriority the display priority of this contacts
	*/
	public void setDisplayPriority(int displayPriority) {
		_contacts.setDisplayPriority(displayPriority);
	}

	/**
	* Returns the contact status of this contacts.
	*
	* @return the contact status of this contacts
	*/
	public int getContactStatus() {
		return _contacts.getContactStatus();
	}

	/**
	* Sets the contact status of this contacts.
	*
	* @param contactStatus the contact status of this contacts
	*/
	public void setContactStatus(int contactStatus) {
		_contacts.setContactStatus(contactStatus);
	}

	public boolean isNew() {
		return _contacts.isNew();
	}

	public void setNew(boolean n) {
		_contacts.setNew(n);
	}

	public boolean isCachedModel() {
		return _contacts.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_contacts.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _contacts.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _contacts.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contacts.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contacts.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contacts.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactsWrapper((Contacts)_contacts.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.contacts.model.Contacts contacts) {
		return _contacts.compareTo(contacts);
	}

	@Override
	public int hashCode() {
		return _contacts.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.contacts.model.Contacts> toCacheModel() {
		return _contacts.toCacheModel();
	}

	public com.portal_egov.portlet.contacts.model.Contacts toEscapedModel() {
		return new ContactsWrapper(_contacts.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contacts.toString();
	}

	public java.lang.String toXmlString() {
		return _contacts.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contacts.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Contacts getWrappedContacts() {
		return _contacts;
	}

	public Contacts getWrappedModel() {
		return _contacts;
	}

	public void resetOriginalValues() {
		_contacts.resetOriginalValues();
	}

	private Contacts _contacts;
}