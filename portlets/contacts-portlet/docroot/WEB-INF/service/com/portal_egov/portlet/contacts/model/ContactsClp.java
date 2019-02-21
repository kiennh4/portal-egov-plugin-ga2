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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.contacts.service.ContactsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class ContactsClp extends BaseModelImpl<Contacts> implements Contacts {
	public ContactsClp() {
	}

	public Class<?> getModelClass() {
		return Contacts.class;
	}

	public String getModelClassName() {
		return Contacts.class.getName();
	}

	public long getPrimaryKey() {
		return _contactId;
	}

	public void setPrimaryKey(long primaryKey) {
		setContactId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_contactId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	public String getContactName() {
		return _contactName;
	}

	public void setContactName(String contactName) {
		_contactName = contactName;
	}

	public String getJobTitle() {
		return _jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	public String getPhoneNumbers() {
		return _phoneNumbers;
	}

	public void setPhoneNumbers(String phoneNumbers) {
		_phoneNumbers = phoneNumbers;
	}

	public String getHomePhone() {
		return _homePhone;
	}

	public void setHomePhone(String homePhone) {
		_homePhone = homePhone;
	}

	public String getMobile() {
		return _mobile;
	}

	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public int getDisplayPriority() {
		return _displayPriority;
	}

	public void setDisplayPriority(int displayPriority) {
		_displayPriority = displayPriority;
	}

	public int getContactStatus() {
		return _contactStatus;
	}

	public void setContactStatus(int contactStatus) {
		_contactStatus = contactStatus;
	}

	public BaseModel<?> getContactsRemoteModel() {
		return _contactsRemoteModel;
	}

	public void setContactsRemoteModel(BaseModel<?> contactsRemoteModel) {
		_contactsRemoteModel = contactsRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ContactsLocalServiceUtil.addContacts(this);
		}
		else {
			ContactsLocalServiceUtil.updateContacts(this);
		}
	}

	@Override
	public Contacts toEscapedModel() {
		return (Contacts)Proxy.newProxyInstance(Contacts.class.getClassLoader(),
			new Class[] { Contacts.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactsClp clone = new ContactsClp();

		clone.setContactId(getContactId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDepartmentId(getDepartmentId());
		clone.setImageId(getImageId());
		clone.setContactName(getContactName());
		clone.setJobTitle(getJobTitle());
		clone.setPhoneNumbers(getPhoneNumbers());
		clone.setHomePhone(getHomePhone());
		clone.setMobile(getMobile());
		clone.setEmail(getEmail());
		clone.setDisplayPriority(getDisplayPriority());
		clone.setContactStatus(getContactStatus());

		return clone;
	}

	public int compareTo(Contacts contacts) {
		int value = 0;

		if (getDepartmentId() < contacts.getDepartmentId()) {
			value = -1;
		}
		else if (getDepartmentId() > contacts.getDepartmentId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getDisplayPriority() < contacts.getDisplayPriority()) {
			value = -1;
		}
		else if (getDisplayPriority() > contacts.getDisplayPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ContactsClp contacts = null;

		try {
			contacts = (ContactsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = contacts.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{contactId=");
		sb.append(getContactId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append(", imageId=");
		sb.append(getImageId());
		sb.append(", contactName=");
		sb.append(getContactName());
		sb.append(", jobTitle=");
		sb.append(getJobTitle());
		sb.append(", phoneNumbers=");
		sb.append(getPhoneNumbers());
		sb.append(", homePhone=");
		sb.append(getHomePhone());
		sb.append(", mobile=");
		sb.append(getMobile());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", displayPriority=");
		sb.append(getDisplayPriority());
		sb.append(", contactStatus=");
		sb.append(getContactStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.contacts.model.Contacts");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageId</column-name><column-value><![CDATA[");
		sb.append(getImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactName</column-name><column-value><![CDATA[");
		sb.append(getContactName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobTitle</column-name><column-value><![CDATA[");
		sb.append(getJobTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNumbers</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumbers());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>homePhone</column-name><column-value><![CDATA[");
		sb.append(getHomePhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobile</column-name><column-value><![CDATA[");
		sb.append(getMobile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayPriority</column-name><column-value><![CDATA[");
		sb.append(getDisplayPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactStatus</column-name><column-value><![CDATA[");
		sb.append(getContactStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _departmentId;
	private long _imageId;
	private String _contactName;
	private String _jobTitle;
	private String _phoneNumbers;
	private String _homePhone;
	private String _mobile;
	private String _email;
	private int _displayPriority;
	private int _contactStatus;
	private BaseModel<?> _contactsRemoteModel;
}