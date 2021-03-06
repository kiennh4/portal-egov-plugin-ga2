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

package com.portal_egov.portlet.proposition_feedback.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PropositionFeedback service. Represents a row in the &quot;PropositionFeedback&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.portal_egov.portlet.proposition_feedback.model.impl.PropositionFeedbackModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.portal_egov.portlet.proposition_feedback.model.impl.PropositionFeedbackImpl}.
 * </p>
 *
 * @author HungDX
 * @see PropositionFeedback
 * @see com.portal_egov.portlet.proposition_feedback.model.impl.PropositionFeedbackImpl
 * @see com.portal_egov.portlet.proposition_feedback.model.impl.PropositionFeedbackModelImpl
 * @generated
 */
public interface PropositionFeedbackModel extends BaseModel<PropositionFeedback> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a proposition feedback model instance should use the {@link PropositionFeedback} interface instead.
	 */

	/**
	 * Returns the primary key of this proposition feedback.
	 *
	 * @return the primary key of this proposition feedback
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this proposition feedback.
	 *
	 * @param primaryKey the primary key of this proposition feedback
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the feedback ID of this proposition feedback.
	 *
	 * @return the feedback ID of this proposition feedback
	 */
	public long getFeedbackId();

	/**
	 * Sets the feedback ID of this proposition feedback.
	 *
	 * @param feedbackId the feedback ID of this proposition feedback
	 */
	public void setFeedbackId(long feedbackId);

	/**
	 * Returns the company ID of this proposition feedback.
	 *
	 * @return the company ID of this proposition feedback
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this proposition feedback.
	 *
	 * @param companyId the company ID of this proposition feedback
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this proposition feedback.
	 *
	 * @return the group ID of this proposition feedback
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this proposition feedback.
	 *
	 * @param groupId the group ID of this proposition feedback
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this proposition feedback.
	 *
	 * @return the user ID of this proposition feedback
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this proposition feedback.
	 *
	 * @param userId the user ID of this proposition feedback
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this proposition feedback.
	 *
	 * @return the user uuid of this proposition feedback
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this proposition feedback.
	 *
	 * @param userUuid the user uuid of this proposition feedback
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the proposition ID of this proposition feedback.
	 *
	 * @return the proposition ID of this proposition feedback
	 */
	public long getPropositionId();

	/**
	 * Sets the proposition ID of this proposition feedback.
	 *
	 * @param propositionId the proposition ID of this proposition feedback
	 */
	public void setPropositionId(long propositionId);

	/**
	 * Returns the feedback file att ID of this proposition feedback.
	 *
	 * @return the feedback file att ID of this proposition feedback
	 */
	public long getFeedbackFileAttId();

	/**
	 * Sets the feedback file att ID of this proposition feedback.
	 *
	 * @param feedbackFileAttId the feedback file att ID of this proposition feedback
	 */
	public void setFeedbackFileAttId(long feedbackFileAttId);

	/**
	 * Returns the feedback title of this proposition feedback.
	 *
	 * @return the feedback title of this proposition feedback
	 */
	@AutoEscape
	public String getFeedbackTitle();

	/**
	 * Sets the feedback title of this proposition feedback.
	 *
	 * @param feedbackTitle the feedback title of this proposition feedback
	 */
	public void setFeedbackTitle(String feedbackTitle);

	/**
	 * Returns the feedback content of this proposition feedback.
	 *
	 * @return the feedback content of this proposition feedback
	 */
	@AutoEscape
	public String getFeedbackContent();

	/**
	 * Sets the feedback content of this proposition feedback.
	 *
	 * @param feedbackContent the feedback content of this proposition feedback
	 */
	public void setFeedbackContent(String feedbackContent);

	/**
	 * Returns the citizen name of this proposition feedback.
	 *
	 * @return the citizen name of this proposition feedback
	 */
	@AutoEscape
	public String getCitizenName();

	/**
	 * Sets the citizen name of this proposition feedback.
	 *
	 * @param citizenName the citizen name of this proposition feedback
	 */
	public void setCitizenName(String citizenName);

	/**
	 * Returns the citizen email of this proposition feedback.
	 *
	 * @return the citizen email of this proposition feedback
	 */
	@AutoEscape
	public String getCitizenEmail();

	/**
	 * Sets the citizen email of this proposition feedback.
	 *
	 * @param citizenEmail the citizen email of this proposition feedback
	 */
	public void setCitizenEmail(String citizenEmail);

	/**
	 * Returns the citizen phone of this proposition feedback.
	 *
	 * @return the citizen phone of this proposition feedback
	 */
	@AutoEscape
	public String getCitizenPhone();

	/**
	 * Sets the citizen phone of this proposition feedback.
	 *
	 * @param citizenPhone the citizen phone of this proposition feedback
	 */
	public void setCitizenPhone(String citizenPhone);

	/**
	 * Returns the citizen address of this proposition feedback.
	 *
	 * @return the citizen address of this proposition feedback
	 */
	@AutoEscape
	public String getCitizenAddress();

	/**
	 * Sets the citizen address of this proposition feedback.
	 *
	 * @param citizenAddress the citizen address of this proposition feedback
	 */
	public void setCitizenAddress(String citizenAddress);

	/**
	 * Returns the create date of this proposition feedback.
	 *
	 * @return the create date of this proposition feedback
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this proposition feedback.
	 *
	 * @param createDate the create date of this proposition feedback
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this proposition feedback.
	 *
	 * @return the modified date of this proposition feedback
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this proposition feedback.
	 *
	 * @param modifiedDate the modified date of this proposition feedback
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this proposition feedback.
	 *
	 * @return the status of this proposition feedback
	 */
	public int getStatus();

	/**
	 * Sets the status of this proposition feedback.
	 *
	 * @param status the status of this proposition feedback
	 */
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this proposition feedback.
	 *
	 * @return the status by user ID of this proposition feedback
	 */
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this proposition feedback.
	 *
	 * @param statusByUserId the status by user ID of this proposition feedback
	 */
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this proposition feedback.
	 *
	 * @return the status by user uuid of this proposition feedback
	 * @throws SystemException if a system exception occurred
	 */
	public String getStatusByUserUuid() throws SystemException;

	/**
	 * Sets the status by user uuid of this proposition feedback.
	 *
	 * @param statusByUserUuid the status by user uuid of this proposition feedback
	 */
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status date of this proposition feedback.
	 *
	 * @return the status date of this proposition feedback
	 */
	public Date getStatusDate();

	/**
	 * Sets the status date of this proposition feedback.
	 *
	 * @param statusDate the status date of this proposition feedback
	 */
	public void setStatusDate(Date statusDate);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(PropositionFeedback propositionFeedback);

	public int hashCode();

	public CacheModel<PropositionFeedback> toCacheModel();

	public PropositionFeedback toEscapedModel();

	public String toString();

	public String toXmlString();
}