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
 * This class is a wrapper for {@link Proposition}.
 * </p>
 *
 * @author    HungDX
 * @see       Proposition
 * @generated
 */
public class PropositionWrapper implements Proposition,
	ModelWrapper<Proposition> {
	public PropositionWrapper(Proposition proposition) {
		_proposition = proposition;
	}

	public Class<?> getModelClass() {
		return Proposition.class;
	}

	public String getModelClassName() {
		return Proposition.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("propositionId", getPropositionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("categoryId", getCategoryId());
		attributes.put("compilationDepartmentId", getCompilationDepartmentId());
		attributes.put("verificationDepartmentId", getVerificationDepartmentId());
		attributes.put("propositionName", getPropositionName());
		attributes.put("propositionDesc", getPropositionDesc());
		attributes.put("propositionContent", getPropositionContent());
		attributes.put("documentFileId", getDocumentFileId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("viewCount", getViewCount());
		attributes.put("feedbackCount", getFeedbackCount());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long propositionId = (Long)attributes.get("propositionId");

		if (propositionId != null) {
			setPropositionId(propositionId);
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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long compilationDepartmentId = (Long)attributes.get(
				"compilationDepartmentId");

		if (compilationDepartmentId != null) {
			setCompilationDepartmentId(compilationDepartmentId);
		}

		Long verificationDepartmentId = (Long)attributes.get(
				"verificationDepartmentId");

		if (verificationDepartmentId != null) {
			setVerificationDepartmentId(verificationDepartmentId);
		}

		String propositionName = (String)attributes.get("propositionName");

		if (propositionName != null) {
			setPropositionName(propositionName);
		}

		String propositionDesc = (String)attributes.get("propositionDesc");

		if (propositionDesc != null) {
			setPropositionDesc(propositionDesc);
		}

		String propositionContent = (String)attributes.get("propositionContent");

		if (propositionContent != null) {
			setPropositionContent(propositionContent);
		}

		Long documentFileId = (Long)attributes.get("documentFileId");

		if (documentFileId != null) {
			setDocumentFileId(documentFileId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}

		Integer feedbackCount = (Integer)attributes.get("feedbackCount");

		if (feedbackCount != null) {
			setFeedbackCount(feedbackCount);
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
	* Returns the primary key of this proposition.
	*
	* @return the primary key of this proposition
	*/
	public long getPrimaryKey() {
		return _proposition.getPrimaryKey();
	}

	/**
	* Sets the primary key of this proposition.
	*
	* @param primaryKey the primary key of this proposition
	*/
	public void setPrimaryKey(long primaryKey) {
		_proposition.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the proposition ID of this proposition.
	*
	* @return the proposition ID of this proposition
	*/
	public long getPropositionId() {
		return _proposition.getPropositionId();
	}

	/**
	* Sets the proposition ID of this proposition.
	*
	* @param propositionId the proposition ID of this proposition
	*/
	public void setPropositionId(long propositionId) {
		_proposition.setPropositionId(propositionId);
	}

	/**
	* Returns the company ID of this proposition.
	*
	* @return the company ID of this proposition
	*/
	public long getCompanyId() {
		return _proposition.getCompanyId();
	}

	/**
	* Sets the company ID of this proposition.
	*
	* @param companyId the company ID of this proposition
	*/
	public void setCompanyId(long companyId) {
		_proposition.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this proposition.
	*
	* @return the group ID of this proposition
	*/
	public long getGroupId() {
		return _proposition.getGroupId();
	}

	/**
	* Sets the group ID of this proposition.
	*
	* @param groupId the group ID of this proposition
	*/
	public void setGroupId(long groupId) {
		_proposition.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this proposition.
	*
	* @return the user ID of this proposition
	*/
	public long getUserId() {
		return _proposition.getUserId();
	}

	/**
	* Sets the user ID of this proposition.
	*
	* @param userId the user ID of this proposition
	*/
	public void setUserId(long userId) {
		_proposition.setUserId(userId);
	}

	/**
	* Returns the user uuid of this proposition.
	*
	* @return the user uuid of this proposition
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _proposition.getUserUuid();
	}

	/**
	* Sets the user uuid of this proposition.
	*
	* @param userUuid the user uuid of this proposition
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_proposition.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this proposition.
	*
	* @return the user name of this proposition
	*/
	public java.lang.String getUserName() {
		return _proposition.getUserName();
	}

	/**
	* Sets the user name of this proposition.
	*
	* @param userName the user name of this proposition
	*/
	public void setUserName(java.lang.String userName) {
		_proposition.setUserName(userName);
	}

	/**
	* Returns the category ID of this proposition.
	*
	* @return the category ID of this proposition
	*/
	public long getCategoryId() {
		return _proposition.getCategoryId();
	}

	/**
	* Sets the category ID of this proposition.
	*
	* @param categoryId the category ID of this proposition
	*/
	public void setCategoryId(long categoryId) {
		_proposition.setCategoryId(categoryId);
	}

	/**
	* Returns the compilation department ID of this proposition.
	*
	* @return the compilation department ID of this proposition
	*/
	public long getCompilationDepartmentId() {
		return _proposition.getCompilationDepartmentId();
	}

	/**
	* Sets the compilation department ID of this proposition.
	*
	* @param compilationDepartmentId the compilation department ID of this proposition
	*/
	public void setCompilationDepartmentId(long compilationDepartmentId) {
		_proposition.setCompilationDepartmentId(compilationDepartmentId);
	}

	/**
	* Returns the verification department ID of this proposition.
	*
	* @return the verification department ID of this proposition
	*/
	public long getVerificationDepartmentId() {
		return _proposition.getVerificationDepartmentId();
	}

	/**
	* Sets the verification department ID of this proposition.
	*
	* @param verificationDepartmentId the verification department ID of this proposition
	*/
	public void setVerificationDepartmentId(long verificationDepartmentId) {
		_proposition.setVerificationDepartmentId(verificationDepartmentId);
	}

	/**
	* Returns the proposition name of this proposition.
	*
	* @return the proposition name of this proposition
	*/
	public java.lang.String getPropositionName() {
		return _proposition.getPropositionName();
	}

	/**
	* Sets the proposition name of this proposition.
	*
	* @param propositionName the proposition name of this proposition
	*/
	public void setPropositionName(java.lang.String propositionName) {
		_proposition.setPropositionName(propositionName);
	}

	/**
	* Returns the proposition desc of this proposition.
	*
	* @return the proposition desc of this proposition
	*/
	public java.lang.String getPropositionDesc() {
		return _proposition.getPropositionDesc();
	}

	/**
	* Sets the proposition desc of this proposition.
	*
	* @param propositionDesc the proposition desc of this proposition
	*/
	public void setPropositionDesc(java.lang.String propositionDesc) {
		_proposition.setPropositionDesc(propositionDesc);
	}

	/**
	* Returns the proposition content of this proposition.
	*
	* @return the proposition content of this proposition
	*/
	public java.lang.String getPropositionContent() {
		return _proposition.getPropositionContent();
	}

	/**
	* Sets the proposition content of this proposition.
	*
	* @param propositionContent the proposition content of this proposition
	*/
	public void setPropositionContent(java.lang.String propositionContent) {
		_proposition.setPropositionContent(propositionContent);
	}

	/**
	* Returns the document file ID of this proposition.
	*
	* @return the document file ID of this proposition
	*/
	public long getDocumentFileId() {
		return _proposition.getDocumentFileId();
	}

	/**
	* Sets the document file ID of this proposition.
	*
	* @param documentFileId the document file ID of this proposition
	*/
	public void setDocumentFileId(long documentFileId) {
		_proposition.setDocumentFileId(documentFileId);
	}

	/**
	* Returns the create date of this proposition.
	*
	* @return the create date of this proposition
	*/
	public java.util.Date getCreateDate() {
		return _proposition.getCreateDate();
	}

	/**
	* Sets the create date of this proposition.
	*
	* @param createDate the create date of this proposition
	*/
	public void setCreateDate(java.util.Date createDate) {
		_proposition.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this proposition.
	*
	* @return the modified date of this proposition
	*/
	public java.util.Date getModifiedDate() {
		return _proposition.getModifiedDate();
	}

	/**
	* Sets the modified date of this proposition.
	*
	* @param modifiedDate the modified date of this proposition
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_proposition.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the view count of this proposition.
	*
	* @return the view count of this proposition
	*/
	public int getViewCount() {
		return _proposition.getViewCount();
	}

	/**
	* Sets the view count of this proposition.
	*
	* @param viewCount the view count of this proposition
	*/
	public void setViewCount(int viewCount) {
		_proposition.setViewCount(viewCount);
	}

	/**
	* Returns the feedback count of this proposition.
	*
	* @return the feedback count of this proposition
	*/
	public int getFeedbackCount() {
		return _proposition.getFeedbackCount();
	}

	/**
	* Sets the feedback count of this proposition.
	*
	* @param feedbackCount the feedback count of this proposition
	*/
	public void setFeedbackCount(int feedbackCount) {
		_proposition.setFeedbackCount(feedbackCount);
	}

	/**
	* Returns the status of this proposition.
	*
	* @return the status of this proposition
	*/
	public int getStatus() {
		return _proposition.getStatus();
	}

	/**
	* Sets the status of this proposition.
	*
	* @param status the status of this proposition
	*/
	public void setStatus(int status) {
		_proposition.setStatus(status);
	}

	/**
	* Returns the status by user ID of this proposition.
	*
	* @return the status by user ID of this proposition
	*/
	public long getStatusByUserId() {
		return _proposition.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this proposition.
	*
	* @param statusByUserId the status by user ID of this proposition
	*/
	public void setStatusByUserId(long statusByUserId) {
		_proposition.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this proposition.
	*
	* @return the status by user uuid of this proposition
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _proposition.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this proposition.
	*
	* @param statusByUserUuid the status by user uuid of this proposition
	*/
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_proposition.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status date of this proposition.
	*
	* @return the status date of this proposition
	*/
	public java.util.Date getStatusDate() {
		return _proposition.getStatusDate();
	}

	/**
	* Sets the status date of this proposition.
	*
	* @param statusDate the status date of this proposition
	*/
	public void setStatusDate(java.util.Date statusDate) {
		_proposition.setStatusDate(statusDate);
	}

	public boolean isNew() {
		return _proposition.isNew();
	}

	public void setNew(boolean n) {
		_proposition.setNew(n);
	}

	public boolean isCachedModel() {
		return _proposition.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_proposition.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _proposition.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _proposition.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_proposition.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _proposition.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_proposition.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PropositionWrapper((Proposition)_proposition.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.proposition_feedback.model.Proposition proposition) {
		return _proposition.compareTo(proposition);
	}

	@Override
	public int hashCode() {
		return _proposition.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.proposition_feedback.model.Proposition> toCacheModel() {
		return _proposition.toCacheModel();
	}

	public com.portal_egov.portlet.proposition_feedback.model.Proposition toEscapedModel() {
		return new PropositionWrapper(_proposition.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _proposition.toString();
	}

	public java.lang.String toXmlString() {
		return _proposition.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_proposition.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Proposition getWrappedProposition() {
		return _proposition;
	}

	public Proposition getWrappedModel() {
		return _proposition;
	}

	public void resetOriginalValues() {
		_proposition.resetOriginalValues();
	}

	private Proposition _proposition;
}