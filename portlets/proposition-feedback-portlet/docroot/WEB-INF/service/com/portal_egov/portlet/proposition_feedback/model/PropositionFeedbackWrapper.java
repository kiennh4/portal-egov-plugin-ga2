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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PropositionFeedback}.
 * </p>
 *
 * @author    HungDX
 * @see       PropositionFeedback
 * @generated
 */
public class PropositionFeedbackWrapper implements PropositionFeedback,
	ModelWrapper<PropositionFeedback> {
	public PropositionFeedbackWrapper(PropositionFeedback propositionFeedback) {
		_propositionFeedback = propositionFeedback;
	}

	public Class<?> getModelClass() {
		return PropositionFeedback.class;
	}

	public String getModelClassName() {
		return PropositionFeedback.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("feedbackId", getFeedbackId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("propositionId", getPropositionId());
		attributes.put("feedbackFileAttId", getFeedbackFileAttId());
		attributes.put("feedbackTitle", getFeedbackTitle());
		attributes.put("feedbackContent", getFeedbackContent());
		attributes.put("citizenName", getCitizenName());
		attributes.put("citizenEmail", getCitizenEmail());
		attributes.put("citizenPhone", getCitizenPhone());
		attributes.put("citizenAddress", getCitizenAddress());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long feedbackId = (Long)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long propositionId = (Long)attributes.get("propositionId");

		if (propositionId != null) {
			setPropositionId(propositionId);
		}

		Long feedbackFileAttId = (Long)attributes.get("feedbackFileAttId");

		if (feedbackFileAttId != null) {
			setFeedbackFileAttId(feedbackFileAttId);
		}

		String feedbackTitle = (String)attributes.get("feedbackTitle");

		if (feedbackTitle != null) {
			setFeedbackTitle(feedbackTitle);
		}

		String feedbackContent = (String)attributes.get("feedbackContent");

		if (feedbackContent != null) {
			setFeedbackContent(feedbackContent);
		}

		String citizenName = (String)attributes.get("citizenName");

		if (citizenName != null) {
			setCitizenName(citizenName);
		}

		String citizenEmail = (String)attributes.get("citizenEmail");

		if (citizenEmail != null) {
			setCitizenEmail(citizenEmail);
		}

		String citizenPhone = (String)attributes.get("citizenPhone");

		if (citizenPhone != null) {
			setCitizenPhone(citizenPhone);
		}

		String citizenAddress = (String)attributes.get("citizenAddress");

		if (citizenAddress != null) {
			setCitizenAddress(citizenAddress);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	/**
	* Returns the primary key of this proposition feedback.
	*
	* @return the primary key of this proposition feedback
	*/
	public long getPrimaryKey() {
		return _propositionFeedback.getPrimaryKey();
	}

	/**
	* Sets the primary key of this proposition feedback.
	*
	* @param primaryKey the primary key of this proposition feedback
	*/
	public void setPrimaryKey(long primaryKey) {
		_propositionFeedback.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the feedback ID of this proposition feedback.
	*
	* @return the feedback ID of this proposition feedback
	*/
	public long getFeedbackId() {
		return _propositionFeedback.getFeedbackId();
	}

	/**
	* Sets the feedback ID of this proposition feedback.
	*
	* @param feedbackId the feedback ID of this proposition feedback
	*/
	public void setFeedbackId(long feedbackId) {
		_propositionFeedback.setFeedbackId(feedbackId);
	}

	/**
	* Returns the company ID of this proposition feedback.
	*
	* @return the company ID of this proposition feedback
	*/
	public long getCompanyId() {
		return _propositionFeedback.getCompanyId();
	}

	/**
	* Sets the company ID of this proposition feedback.
	*
	* @param companyId the company ID of this proposition feedback
	*/
	public void setCompanyId(long companyId) {
		_propositionFeedback.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this proposition feedback.
	*
	* @return the group ID of this proposition feedback
	*/
	public long getGroupId() {
		return _propositionFeedback.getGroupId();
	}

	/**
	* Sets the group ID of this proposition feedback.
	*
	* @param groupId the group ID of this proposition feedback
	*/
	public void setGroupId(long groupId) {
		_propositionFeedback.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this proposition feedback.
	*
	* @return the user ID of this proposition feedback
	*/
	public long getUserId() {
		return _propositionFeedback.getUserId();
	}

	/**
	* Sets the user ID of this proposition feedback.
	*
	* @param userId the user ID of this proposition feedback
	*/
	public void setUserId(long userId) {
		_propositionFeedback.setUserId(userId);
	}

	/**
	* Returns the user uuid of this proposition feedback.
	*
	* @return the user uuid of this proposition feedback
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionFeedback.getUserUuid();
	}

	/**
	* Sets the user uuid of this proposition feedback.
	*
	* @param userUuid the user uuid of this proposition feedback
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_propositionFeedback.setUserUuid(userUuid);
	}

	/**
	* Returns the proposition ID of this proposition feedback.
	*
	* @return the proposition ID of this proposition feedback
	*/
	public long getPropositionId() {
		return _propositionFeedback.getPropositionId();
	}

	/**
	* Sets the proposition ID of this proposition feedback.
	*
	* @param propositionId the proposition ID of this proposition feedback
	*/
	public void setPropositionId(long propositionId) {
		_propositionFeedback.setPropositionId(propositionId);
	}

	/**
	* Returns the feedback file att ID of this proposition feedback.
	*
	* @return the feedback file att ID of this proposition feedback
	*/
	public long getFeedbackFileAttId() {
		return _propositionFeedback.getFeedbackFileAttId();
	}

	/**
	* Sets the feedback file att ID of this proposition feedback.
	*
	* @param feedbackFileAttId the feedback file att ID of this proposition feedback
	*/
	public void setFeedbackFileAttId(long feedbackFileAttId) {
		_propositionFeedback.setFeedbackFileAttId(feedbackFileAttId);
	}

	/**
	* Returns the feedback title of this proposition feedback.
	*
	* @return the feedback title of this proposition feedback
	*/
	public java.lang.String getFeedbackTitle() {
		return _propositionFeedback.getFeedbackTitle();
	}

	/**
	* Sets the feedback title of this proposition feedback.
	*
	* @param feedbackTitle the feedback title of this proposition feedback
	*/
	public void setFeedbackTitle(java.lang.String feedbackTitle) {
		_propositionFeedback.setFeedbackTitle(feedbackTitle);
	}

	/**
	* Returns the feedback content of this proposition feedback.
	*
	* @return the feedback content of this proposition feedback
	*/
	public java.lang.String getFeedbackContent() {
		return _propositionFeedback.getFeedbackContent();
	}

	/**
	* Sets the feedback content of this proposition feedback.
	*
	* @param feedbackContent the feedback content of this proposition feedback
	*/
	public void setFeedbackContent(java.lang.String feedbackContent) {
		_propositionFeedback.setFeedbackContent(feedbackContent);
	}

	/**
	* Returns the citizen name of this proposition feedback.
	*
	* @return the citizen name of this proposition feedback
	*/
	public java.lang.String getCitizenName() {
		return _propositionFeedback.getCitizenName();
	}

	/**
	* Sets the citizen name of this proposition feedback.
	*
	* @param citizenName the citizen name of this proposition feedback
	*/
	public void setCitizenName(java.lang.String citizenName) {
		_propositionFeedback.setCitizenName(citizenName);
	}

	/**
	* Returns the citizen email of this proposition feedback.
	*
	* @return the citizen email of this proposition feedback
	*/
	public java.lang.String getCitizenEmail() {
		return _propositionFeedback.getCitizenEmail();
	}

	/**
	* Sets the citizen email of this proposition feedback.
	*
	* @param citizenEmail the citizen email of this proposition feedback
	*/
	public void setCitizenEmail(java.lang.String citizenEmail) {
		_propositionFeedback.setCitizenEmail(citizenEmail);
	}

	/**
	* Returns the citizen phone of this proposition feedback.
	*
	* @return the citizen phone of this proposition feedback
	*/
	public java.lang.String getCitizenPhone() {
		return _propositionFeedback.getCitizenPhone();
	}

	/**
	* Sets the citizen phone of this proposition feedback.
	*
	* @param citizenPhone the citizen phone of this proposition feedback
	*/
	public void setCitizenPhone(java.lang.String citizenPhone) {
		_propositionFeedback.setCitizenPhone(citizenPhone);
	}

	/**
	* Returns the citizen address of this proposition feedback.
	*
	* @return the citizen address of this proposition feedback
	*/
	public java.lang.String getCitizenAddress() {
		return _propositionFeedback.getCitizenAddress();
	}

	/**
	* Sets the citizen address of this proposition feedback.
	*
	* @param citizenAddress the citizen address of this proposition feedback
	*/
	public void setCitizenAddress(java.lang.String citizenAddress) {
		_propositionFeedback.setCitizenAddress(citizenAddress);
	}

	/**
	* Returns the create date of this proposition feedback.
	*
	* @return the create date of this proposition feedback
	*/
	public java.util.Date getCreateDate() {
		return _propositionFeedback.getCreateDate();
	}

	/**
	* Sets the create date of this proposition feedback.
	*
	* @param createDate the create date of this proposition feedback
	*/
	public void setCreateDate(java.util.Date createDate) {
		_propositionFeedback.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this proposition feedback.
	*
	* @return the modified date of this proposition feedback
	*/
	public java.util.Date getModifiedDate() {
		return _propositionFeedback.getModifiedDate();
	}

	/**
	* Sets the modified date of this proposition feedback.
	*
	* @param modifiedDate the modified date of this proposition feedback
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_propositionFeedback.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the status of this proposition feedback.
	*
	* @return the status of this proposition feedback
	*/
	public int getStatus() {
		return _propositionFeedback.getStatus();
	}

	/**
	* Sets the status of this proposition feedback.
	*
	* @param status the status of this proposition feedback
	*/
	public void setStatus(int status) {
		_propositionFeedback.setStatus(status);
	}

	/**
	* Returns the status by user ID of this proposition feedback.
	*
	* @return the status by user ID of this proposition feedback
	*/
	public long getStatusByUserId() {
		return _propositionFeedback.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this proposition feedback.
	*
	* @param statusByUserId the status by user ID of this proposition feedback
	*/
	public void setStatusByUserId(long statusByUserId) {
		_propositionFeedback.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this proposition feedback.
	*
	* @return the status by user uuid of this proposition feedback
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionFeedback.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this proposition feedback.
	*
	* @param statusByUserUuid the status by user uuid of this proposition feedback
	*/
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_propositionFeedback.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status date of this proposition feedback.
	*
	* @return the status date of this proposition feedback
	*/
	public java.util.Date getStatusDate() {
		return _propositionFeedback.getStatusDate();
	}

	/**
	* Sets the status date of this proposition feedback.
	*
	* @param statusDate the status date of this proposition feedback
	*/
	public void setStatusDate(java.util.Date statusDate) {
		_propositionFeedback.setStatusDate(statusDate);
	}

	public boolean isNew() {
		return _propositionFeedback.isNew();
	}

	public void setNew(boolean n) {
		_propositionFeedback.setNew(n);
	}

	public boolean isCachedModel() {
		return _propositionFeedback.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_propositionFeedback.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _propositionFeedback.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _propositionFeedback.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_propositionFeedback.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _propositionFeedback.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_propositionFeedback.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PropositionFeedbackWrapper((PropositionFeedback)_propositionFeedback.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback propositionFeedback) {
		return _propositionFeedback.compareTo(propositionFeedback);
	}

	@Override
	public int hashCode() {
		return _propositionFeedback.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> toCacheModel() {
		return _propositionFeedback.toCacheModel();
	}

	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback toEscapedModel() {
		return new PropositionFeedbackWrapper(_propositionFeedback.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _propositionFeedback.toString();
	}

	public java.lang.String toXmlString() {
		return _propositionFeedback.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_propositionFeedback.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PropositionFeedback getWrappedPropositionFeedback() {
		return _propositionFeedback;
	}

	public PropositionFeedback getWrappedModel() {
		return _propositionFeedback;
	}

	public void resetOriginalValues() {
		_propositionFeedback.resetOriginalValues();
	}

	private PropositionFeedback _propositionFeedback;
}