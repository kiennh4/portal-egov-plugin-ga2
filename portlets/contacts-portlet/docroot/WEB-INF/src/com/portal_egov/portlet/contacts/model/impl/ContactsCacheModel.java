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

import com.portal_egov.portlet.contacts.model.Contacts;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Contacts in entity cache.
 *
 * @author HungDX
 * @see Contacts
 * @generated
 */
public class ContactsCacheModel implements CacheModel<Contacts>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{contactId=");
		sb.append(contactId);
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
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", contactName=");
		sb.append(contactName);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", phoneNumbers=");
		sb.append(phoneNumbers);
		sb.append(", homePhone=");
		sb.append(homePhone);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", email=");
		sb.append(email);
		sb.append(", displayPriority=");
		sb.append(displayPriority);
		sb.append(", contactStatus=");
		sb.append(contactStatus);
		sb.append("}");

		return sb.toString();
	}

	public Contacts toEntityModel() {
		ContactsImpl contactsImpl = new ContactsImpl();

		contactsImpl.setContactId(contactId);
		contactsImpl.setGroupId(groupId);
		contactsImpl.setCompanyId(companyId);
		contactsImpl.setUserId(userId);

		if (userName == null) {
			contactsImpl.setUserName(StringPool.BLANK);
		}
		else {
			contactsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			contactsImpl.setCreateDate(null);
		}
		else {
			contactsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contactsImpl.setModifiedDate(null);
		}
		else {
			contactsImpl.setModifiedDate(new Date(modifiedDate));
		}

		contactsImpl.setDepartmentId(departmentId);
		contactsImpl.setImageId(imageId);

		if (contactName == null) {
			contactsImpl.setContactName(StringPool.BLANK);
		}
		else {
			contactsImpl.setContactName(contactName);
		}

		if (jobTitle == null) {
			contactsImpl.setJobTitle(StringPool.BLANK);
		}
		else {
			contactsImpl.setJobTitle(jobTitle);
		}

		if (phoneNumbers == null) {
			contactsImpl.setPhoneNumbers(StringPool.BLANK);
		}
		else {
			contactsImpl.setPhoneNumbers(phoneNumbers);
		}

		if (homePhone == null) {
			contactsImpl.setHomePhone(StringPool.BLANK);
		}
		else {
			contactsImpl.setHomePhone(homePhone);
		}

		if (mobile == null) {
			contactsImpl.setMobile(StringPool.BLANK);
		}
		else {
			contactsImpl.setMobile(mobile);
		}

		if (email == null) {
			contactsImpl.setEmail(StringPool.BLANK);
		}
		else {
			contactsImpl.setEmail(email);
		}

		contactsImpl.setDisplayPriority(displayPriority);
		contactsImpl.setContactStatus(contactStatus);

		contactsImpl.resetOriginalValues();

		return contactsImpl;
	}

	public long contactId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long departmentId;
	public long imageId;
	public String contactName;
	public String jobTitle;
	public String phoneNumbers;
	public String homePhone;
	public String mobile;
	public String email;
	public int displayPriority;
	public int contactStatus;
}