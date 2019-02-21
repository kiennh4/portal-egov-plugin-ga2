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

package com.portal_egov.portlet.compaints.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.compaints.model.Complaint;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Complaint in entity cache.
 *
 * @author HungDX
 * @see Complaint
 * @generated
 */
public class ComplaintCacheModel implements CacheModel<Complaint>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{complaintId=");
		sb.append(complaintId);
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
		sb.append(", complaintTitle=");
		sb.append(complaintTitle);
		sb.append(", complaintDescription=");
		sb.append(complaintDescription);
		sb.append(", complaintContent=");
		sb.append(complaintContent);
		sb.append(", fileAttachmentURL=");
		sb.append(fileAttachmentURL);
		sb.append(", complaintStatus=");
		sb.append(complaintStatus);
		sb.append("}");

		return sb.toString();
	}

	public Complaint toEntityModel() {
		ComplaintImpl complaintImpl = new ComplaintImpl();

		complaintImpl.setComplaintId(complaintId);
		complaintImpl.setGroupId(groupId);
		complaintImpl.setCompanyId(companyId);
		complaintImpl.setUserId(userId);

		if (userName == null) {
			complaintImpl.setUserName(StringPool.BLANK);
		}
		else {
			complaintImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			complaintImpl.setCreateDate(null);
		}
		else {
			complaintImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			complaintImpl.setModifiedDate(null);
		}
		else {
			complaintImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (complaintTitle == null) {
			complaintImpl.setComplaintTitle(StringPool.BLANK);
		}
		else {
			complaintImpl.setComplaintTitle(complaintTitle);
		}

		if (complaintDescription == null) {
			complaintImpl.setComplaintDescription(StringPool.BLANK);
		}
		else {
			complaintImpl.setComplaintDescription(complaintDescription);
		}

		if (complaintContent == null) {
			complaintImpl.setComplaintContent(StringPool.BLANK);
		}
		else {
			complaintImpl.setComplaintContent(complaintContent);
		}

		if (fileAttachmentURL == null) {
			complaintImpl.setFileAttachmentURL(StringPool.BLANK);
		}
		else {
			complaintImpl.setFileAttachmentURL(fileAttachmentURL);
		}

		complaintImpl.setComplaintStatus(complaintStatus);

		complaintImpl.resetOriginalValues();

		return complaintImpl;
	}

	public long complaintId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String complaintTitle;
	public String complaintDescription;
	public String complaintContent;
	public String fileAttachmentURL;
	public int complaintStatus;
}