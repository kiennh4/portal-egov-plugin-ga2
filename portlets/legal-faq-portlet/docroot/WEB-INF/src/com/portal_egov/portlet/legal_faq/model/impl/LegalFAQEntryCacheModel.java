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

package com.portal_egov.portlet.legal_faq.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LegalFAQEntry in entity cache.
 *
 * @author HungDX
 * @see LegalFAQEntry
 * @generated
 */
public class LegalFAQEntryCacheModel implements CacheModel<LegalFAQEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{entryId=");
		sb.append(entryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
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
		sb.append(", askDate=");
		sb.append(askDate);
		sb.append(", askTitle=");
		sb.append(askTitle);
		sb.append(", askContent=");
		sb.append(askContent);
		sb.append(", answerDate=");
		sb.append(answerDate);
		sb.append(", answerContent=");
		sb.append(answerContent);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", publishDate=");
		sb.append(publishDate);
		sb.append(", viewCount=");
		sb.append(viewCount);
		sb.append(", publishStatus=");
		sb.append(publishStatus);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public LegalFAQEntry toEntityModel() {
		LegalFAQEntryImpl legalFAQEntryImpl = new LegalFAQEntryImpl();

		legalFAQEntryImpl.setEntryId(entryId);
		legalFAQEntryImpl.setCompanyId(companyId);
		legalFAQEntryImpl.setGroupId(groupId);
		legalFAQEntryImpl.setUserId(userId);

		if (userName == null) {
			legalFAQEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setUserName(userName);
		}

		legalFAQEntryImpl.setCategoryId(categoryId);

		if (citizenName == null) {
			legalFAQEntryImpl.setCitizenName(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setCitizenName(citizenName);
		}

		if (citizenPhone == null) {
			legalFAQEntryImpl.setCitizenPhone(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setCitizenPhone(citizenPhone);
		}

		if (citizenEmail == null) {
			legalFAQEntryImpl.setCitizenEmail(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setCitizenEmail(citizenEmail);
		}

		if (citizenAddress == null) {
			legalFAQEntryImpl.setCitizenAddress(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setCitizenAddress(citizenAddress);
		}

		if (askDate == Long.MIN_VALUE) {
			legalFAQEntryImpl.setAskDate(null);
		}
		else {
			legalFAQEntryImpl.setAskDate(new Date(askDate));
		}

		if (askTitle == null) {
			legalFAQEntryImpl.setAskTitle(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setAskTitle(askTitle);
		}

		if (askContent == null) {
			legalFAQEntryImpl.setAskContent(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setAskContent(askContent);
		}

		if (answerDate == Long.MIN_VALUE) {
			legalFAQEntryImpl.setAnswerDate(null);
		}
		else {
			legalFAQEntryImpl.setAnswerDate(new Date(answerDate));
		}

		if (answerContent == null) {
			legalFAQEntryImpl.setAnswerContent(StringPool.BLANK);
		}
		else {
			legalFAQEntryImpl.setAnswerContent(answerContent);
		}

		if (createDate == Long.MIN_VALUE) {
			legalFAQEntryImpl.setCreateDate(null);
		}
		else {
			legalFAQEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legalFAQEntryImpl.setModifiedDate(null);
		}
		else {
			legalFAQEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (publishDate == Long.MIN_VALUE) {
			legalFAQEntryImpl.setPublishDate(null);
		}
		else {
			legalFAQEntryImpl.setPublishDate(new Date(publishDate));
		}

		legalFAQEntryImpl.setViewCount(viewCount);
		legalFAQEntryImpl.setPublishStatus(publishStatus);
		legalFAQEntryImpl.setStatus(status);

		legalFAQEntryImpl.resetOriginalValues();

		return legalFAQEntryImpl;
	}

	public long entryId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long categoryId;
	public String citizenName;
	public String citizenPhone;
	public String citizenEmail;
	public String citizenAddress;
	public long askDate;
	public String askTitle;
	public String askContent;
	public long answerDate;
	public String answerContent;
	public long createDate;
	public long modifiedDate;
	public long publishDate;
	public int viewCount;
	public int publishStatus;
	public int status;
}