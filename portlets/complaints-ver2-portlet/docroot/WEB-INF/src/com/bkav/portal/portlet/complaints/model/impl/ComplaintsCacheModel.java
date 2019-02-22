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

package com.bkav.portal.portlet.complaints.model.impl;

import com.bkav.portal.portlet.complaints.model.Complaints;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Complaints in entity cache.
 *
 * @author AnhBDb
 * @see Complaints
 * @generated
 */
public class ComplaintsCacheModel implements CacheModel<Complaints>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{complaintId=");
		sb.append(complaintId);
		sb.append(", complaintNumber=");
		sb.append(complaintNumber);
		sb.append(", signingDate=");
		sb.append(signingDate);
		sb.append(", complaintName=");
		sb.append(complaintName);
		sb.append(", complaintDesc=");
		sb.append(complaintDesc);
		sb.append(", complaintContent=");
		sb.append(complaintContent);
		sb.append(", replyDocument=");
		sb.append(replyDocument);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	public Complaints toEntityModel() {
		ComplaintsImpl complaintsImpl = new ComplaintsImpl();

		complaintsImpl.setComplaintId(complaintId);

		if (complaintNumber == null) {
			complaintsImpl.setComplaintNumber(StringPool.BLANK);
		}
		else {
			complaintsImpl.setComplaintNumber(complaintNumber);
		}

		if (signingDate == Long.MIN_VALUE) {
			complaintsImpl.setSigningDate(null);
		}
		else {
			complaintsImpl.setSigningDate(new Date(signingDate));
		}

		if (complaintName == null) {
			complaintsImpl.setComplaintName(StringPool.BLANK);
		}
		else {
			complaintsImpl.setComplaintName(complaintName);
		}

		if (complaintDesc == null) {
			complaintsImpl.setComplaintDesc(StringPool.BLANK);
		}
		else {
			complaintsImpl.setComplaintDesc(complaintDesc);
		}

		if (complaintContent == null) {
			complaintsImpl.setComplaintContent(StringPool.BLANK);
		}
		else {
			complaintsImpl.setComplaintContent(complaintContent);
		}

		if (replyDocument == null) {
			complaintsImpl.setReplyDocument(StringPool.BLANK);
		}
		else {
			complaintsImpl.setReplyDocument(replyDocument);
		}

		complaintsImpl.setGroupId(groupId);
		complaintsImpl.setCompanyId(companyId);
		complaintsImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			complaintsImpl.setCreateDate(null);
		}
		else {
			complaintsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			complaintsImpl.setModifiedDate(null);
		}
		else {
			complaintsImpl.setModifiedDate(new Date(modifiedDate));
		}

		complaintsImpl.resetOriginalValues();

		return complaintsImpl;
	}

	public long complaintId;
	public String complaintNumber;
	public long signingDate;
	public String complaintName;
	public String complaintDesc;
	public String complaintContent;
	public String replyDocument;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
}