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

package com.portal_egov.portlet.inquiry.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.inquiry.model.OnlineInquiry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing OnlineInquiry in entity cache.
 *
 * @author HungDX
 * @see OnlineInquiry
 * @generated
 */
public class OnlineInquiryCacheModel implements CacheModel<OnlineInquiry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{inquiryId=");
		sb.append(inquiryId);
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
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", phoneNumbers=");
		sb.append(phoneNumbers);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", inquiryContent=");
		sb.append(inquiryContent);
		sb.append(", inquiryStatus=");
		sb.append(inquiryStatus);
		sb.append("}");

		return sb.toString();
	}

	public OnlineInquiry toEntityModel() {
		OnlineInquiryImpl onlineInquiryImpl = new OnlineInquiryImpl();

		onlineInquiryImpl.setInquiryId(inquiryId);
		onlineInquiryImpl.setGroupId(groupId);
		onlineInquiryImpl.setCompanyId(companyId);
		onlineInquiryImpl.setUserId(userId);

		if (userName == null) {
			onlineInquiryImpl.setUserName(StringPool.BLANK);
		}
		else {
			onlineInquiryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			onlineInquiryImpl.setCreateDate(null);
		}
		else {
			onlineInquiryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			onlineInquiryImpl.setModifiedDate(null);
		}
		else {
			onlineInquiryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (fullName == null) {
			onlineInquiryImpl.setFullName(StringPool.BLANK);
		}
		else {
			onlineInquiryImpl.setFullName(fullName);
		}

		if (phoneNumbers == null) {
			onlineInquiryImpl.setPhoneNumbers(StringPool.BLANK);
		}
		else {
			onlineInquiryImpl.setPhoneNumbers(phoneNumbers);
		}

		if (emailAddress == null) {
			onlineInquiryImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			onlineInquiryImpl.setEmailAddress(emailAddress);
		}

		if (inquiryContent == null) {
			onlineInquiryImpl.setInquiryContent(StringPool.BLANK);
		}
		else {
			onlineInquiryImpl.setInquiryContent(inquiryContent);
		}

		onlineInquiryImpl.setInquiryStatus(inquiryStatus);

		onlineInquiryImpl.resetOriginalValues();

		return onlineInquiryImpl;
	}

	public long inquiryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String fullName;
	public String phoneNumbers;
	public String emailAddress;
	public String inquiryContent;
	public int inquiryStatus;
}