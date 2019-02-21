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

package com.portal_egov.portlet.proposition_feedback.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.proposition_feedback.model.Proposition;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Proposition in entity cache.
 *
 * @author HungDX
 * @see Proposition
 * @generated
 */
public class PropositionCacheModel implements CacheModel<Proposition>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{propositionId=");
		sb.append(propositionId);
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
		sb.append(", compilationDepartmentId=");
		sb.append(compilationDepartmentId);
		sb.append(", verificationDepartmentId=");
		sb.append(verificationDepartmentId);
		sb.append(", propositionName=");
		sb.append(propositionName);
		sb.append(", propositionDesc=");
		sb.append(propositionDesc);
		sb.append(", propositionContent=");
		sb.append(propositionContent);
		sb.append(", documentFileId=");
		sb.append(documentFileId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", viewCount=");
		sb.append(viewCount);
		sb.append(", feedbackCount=");
		sb.append(feedbackCount);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	public Proposition toEntityModel() {
		PropositionImpl propositionImpl = new PropositionImpl();

		propositionImpl.setPropositionId(propositionId);
		propositionImpl.setCompanyId(companyId);
		propositionImpl.setGroupId(groupId);
		propositionImpl.setUserId(userId);

		if (userName == null) {
			propositionImpl.setUserName(StringPool.BLANK);
		}
		else {
			propositionImpl.setUserName(userName);
		}

		propositionImpl.setCategoryId(categoryId);
		propositionImpl.setCompilationDepartmentId(compilationDepartmentId);
		propositionImpl.setVerificationDepartmentId(verificationDepartmentId);

		if (propositionName == null) {
			propositionImpl.setPropositionName(StringPool.BLANK);
		}
		else {
			propositionImpl.setPropositionName(propositionName);
		}

		if (propositionDesc == null) {
			propositionImpl.setPropositionDesc(StringPool.BLANK);
		}
		else {
			propositionImpl.setPropositionDesc(propositionDesc);
		}

		if (propositionContent == null) {
			propositionImpl.setPropositionContent(StringPool.BLANK);
		}
		else {
			propositionImpl.setPropositionContent(propositionContent);
		}

		propositionImpl.setDocumentFileId(documentFileId);

		if (createDate == Long.MIN_VALUE) {
			propositionImpl.setCreateDate(null);
		}
		else {
			propositionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			propositionImpl.setModifiedDate(null);
		}
		else {
			propositionImpl.setModifiedDate(new Date(modifiedDate));
		}

		propositionImpl.setViewCount(viewCount);
		propositionImpl.setFeedbackCount(feedbackCount);
		propositionImpl.setStatus(status);
		propositionImpl.setStatusByUserId(statusByUserId);

		if (statusDate == Long.MIN_VALUE) {
			propositionImpl.setStatusDate(null);
		}
		else {
			propositionImpl.setStatusDate(new Date(statusDate));
		}

		propositionImpl.resetOriginalValues();

		return propositionImpl;
	}

	public long propositionId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long categoryId;
	public long compilationDepartmentId;
	public long verificationDepartmentId;
	public String propositionName;
	public String propositionDesc;
	public String propositionContent;
	public long documentFileId;
	public long createDate;
	public long modifiedDate;
	public int viewCount;
	public int feedbackCount;
	public int status;
	public long statusByUserId;
	public long statusDate;
}