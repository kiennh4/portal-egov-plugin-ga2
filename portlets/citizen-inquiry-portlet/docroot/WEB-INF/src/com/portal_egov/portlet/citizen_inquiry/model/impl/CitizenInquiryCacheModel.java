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

package com.portal_egov.portlet.citizen_inquiry.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CitizenInquiry in entity cache.
 *
 * @author HungDX
 * @see CitizenInquiry
 * @generated
 */
public class CitizenInquiryCacheModel implements CacheModel<CitizenInquiry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

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
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", citizenName=");
		sb.append(citizenName);
		sb.append(", citizenPhone=");
		sb.append(citizenPhone);
		sb.append(", citizenEmail=");
		sb.append(citizenEmail);
		sb.append(", citizenAddress=");
		sb.append(citizenAddress);
		sb.append(", inquiryTitle=");
		sb.append(inquiryTitle);
		sb.append(", inquiryContent=");
		sb.append(inquiryContent);
		sb.append(", inquiryFeedback=");
		sb.append(inquiryFeedback);
		sb.append(", inquiryFeedbackUser=");
		sb.append(inquiryFeedbackUser);
		sb.append(", inquiryFeedbackDate=");
		sb.append(inquiryFeedbackDate);
		sb.append(", inquiryStatus=");
		sb.append(inquiryStatus);
		sb.append(", approved=");
		sb.append(approved);
		sb.append("}");

		return sb.toString();
	}

	public CitizenInquiry toEntityModel() {
		CitizenInquiryImpl citizenInquiryImpl = new CitizenInquiryImpl();

		citizenInquiryImpl.setInquiryId(inquiryId);
		citizenInquiryImpl.setGroupId(groupId);
		citizenInquiryImpl.setCompanyId(companyId);
		citizenInquiryImpl.setUserId(userId);

		if (userName == null) {
			citizenInquiryImpl.setUserName(StringPool.BLANK);
		}
		else {
			citizenInquiryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			citizenInquiryImpl.setCreateDate(null);
		}
		else {
			citizenInquiryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			citizenInquiryImpl.setModifiedDate(null);
		}
		else {
			citizenInquiryImpl.setModifiedDate(new Date(modifiedDate));
		}

		citizenInquiryImpl.setCategoryId(categoryId);

		if (citizenName == null) {
			citizenInquiryImpl.setCitizenName(StringPool.BLANK);
		}
		else {
			citizenInquiryImpl.setCitizenName(citizenName);
		}

		if (citizenPhone == null) {
			citizenInquiryImpl.setCitizenPhone(StringPool.BLANK);
		}
		else {
			citizenInquiryImpl.setCitizenPhone(citizenPhone);
		}

		if (citizenEmail == null) {
			citizenInquiryImpl.setCitizenEmail(StringPool.BLANK);
		}
		else {
			citizenInquiryImpl.setCitizenEmail(citizenEmail);
		}

		if (citizenAddress == null) {
			citizenInquiryImpl.setCitizenAddress(StringPool.BLANK);
		}
		else {
			citizenInquiryImpl.setCitizenAddress(citizenAddress);
		}

		if (inquiryTitle == null) {
			citizenInquiryImpl.setInquiryTitle(StringPool.BLANK);
		}
		else {
			citizenInquiryImpl.setInquiryTitle(inquiryTitle);
		}

		if (inquiryContent == null) {
			citizenInquiryImpl.setInquiryContent(StringPool.BLANK);
		}
		else {
			citizenInquiryImpl.setInquiryContent(inquiryContent);
		}

		if (inquiryFeedback == null) {
			citizenInquiryImpl.setInquiryFeedback(StringPool.BLANK);
		}
		else {
			citizenInquiryImpl.setInquiryFeedback(inquiryFeedback);
		}

		if (inquiryFeedbackUser == null) {
			citizenInquiryImpl.setInquiryFeedbackUser(StringPool.BLANK);
		}
		else {
			citizenInquiryImpl.setInquiryFeedbackUser(inquiryFeedbackUser);
		}

		if (inquiryFeedbackDate == Long.MIN_VALUE) {
			citizenInquiryImpl.setInquiryFeedbackDate(null);
		}
		else {
			citizenInquiryImpl.setInquiryFeedbackDate(new Date(
					inquiryFeedbackDate));
		}

		citizenInquiryImpl.setInquiryStatus(inquiryStatus);
		citizenInquiryImpl.setApproved(approved);

		citizenInquiryImpl.resetOriginalValues();

		return citizenInquiryImpl;
	}

	public long inquiryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long categoryId;
	public String citizenName;
	public String citizenPhone;
	public String citizenEmail;
	public String citizenAddress;
	public String inquiryTitle;
	public String inquiryContent;
	public String inquiryFeedback;
	public String inquiryFeedbackUser;
	public long inquiryFeedbackDate;
	public int inquiryStatus;
	public boolean approved;
}