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

import com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PropositionFeedback in entity cache.
 *
 * @author HungDX
 * @see PropositionFeedback
 * @generated
 */
public class PropositionFeedbackCacheModel implements CacheModel<PropositionFeedback>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{feedbackId=");
		sb.append(feedbackId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", propositionId=");
		sb.append(propositionId);
		sb.append(", feedbackFileAttId=");
		sb.append(feedbackFileAttId);
		sb.append(", feedbackTitle=");
		sb.append(feedbackTitle);
		sb.append(", feedbackContent=");
		sb.append(feedbackContent);
		sb.append(", citizenName=");
		sb.append(citizenName);
		sb.append(", citizenEmail=");
		sb.append(citizenEmail);
		sb.append(", citizenPhone=");
		sb.append(citizenPhone);
		sb.append(", citizenAddress=");
		sb.append(citizenAddress);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	public PropositionFeedback toEntityModel() {
		PropositionFeedbackImpl propositionFeedbackImpl = new PropositionFeedbackImpl();

		propositionFeedbackImpl.setFeedbackId(feedbackId);
		propositionFeedbackImpl.setCompanyId(companyId);
		propositionFeedbackImpl.setGroupId(groupId);
		propositionFeedbackImpl.setUserId(userId);
		propositionFeedbackImpl.setPropositionId(propositionId);
		propositionFeedbackImpl.setFeedbackFileAttId(feedbackFileAttId);

		if (feedbackTitle == null) {
			propositionFeedbackImpl.setFeedbackTitle(StringPool.BLANK);
		}
		else {
			propositionFeedbackImpl.setFeedbackTitle(feedbackTitle);
		}

		if (feedbackContent == null) {
			propositionFeedbackImpl.setFeedbackContent(StringPool.BLANK);
		}
		else {
			propositionFeedbackImpl.setFeedbackContent(feedbackContent);
		}

		if (citizenName == null) {
			propositionFeedbackImpl.setCitizenName(StringPool.BLANK);
		}
		else {
			propositionFeedbackImpl.setCitizenName(citizenName);
		}

		if (citizenEmail == null) {
			propositionFeedbackImpl.setCitizenEmail(StringPool.BLANK);
		}
		else {
			propositionFeedbackImpl.setCitizenEmail(citizenEmail);
		}

		if (citizenPhone == null) {
			propositionFeedbackImpl.setCitizenPhone(StringPool.BLANK);
		}
		else {
			propositionFeedbackImpl.setCitizenPhone(citizenPhone);
		}

		if (citizenAddress == null) {
			propositionFeedbackImpl.setCitizenAddress(StringPool.BLANK);
		}
		else {
			propositionFeedbackImpl.setCitizenAddress(citizenAddress);
		}

		if (createDate == Long.MIN_VALUE) {
			propositionFeedbackImpl.setCreateDate(null);
		}
		else {
			propositionFeedbackImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			propositionFeedbackImpl.setModifiedDate(null);
		}
		else {
			propositionFeedbackImpl.setModifiedDate(new Date(modifiedDate));
		}

		propositionFeedbackImpl.setStatus(status);
		propositionFeedbackImpl.setStatusByUserId(statusByUserId);

		if (statusDate == Long.MIN_VALUE) {
			propositionFeedbackImpl.setStatusDate(null);
		}
		else {
			propositionFeedbackImpl.setStatusDate(new Date(statusDate));
		}

		propositionFeedbackImpl.resetOriginalValues();

		return propositionFeedbackImpl;
	}

	public long feedbackId;
	public long companyId;
	public long groupId;
	public long userId;
	public long propositionId;
	public long feedbackFileAttId;
	public String feedbackTitle;
	public String feedbackContent;
	public String citizenName;
	public String citizenEmail;
	public String citizenPhone;
	public String citizenAddress;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public long statusDate;
}