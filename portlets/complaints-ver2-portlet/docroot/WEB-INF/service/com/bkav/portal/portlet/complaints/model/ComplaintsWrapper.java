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

package com.bkav.portal.portlet.complaints.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Complaints}.
 * </p>
 *
 * @author    AnhBDb
 * @see       Complaints
 * @generated
 */
public class ComplaintsWrapper implements Complaints, ModelWrapper<Complaints> {
	public ComplaintsWrapper(Complaints complaints) {
		_complaints = complaints;
	}

	public Class<?> getModelClass() {
		return Complaints.class;
	}

	public String getModelClassName() {
		return Complaints.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("complaintId", getComplaintId());
		attributes.put("complaintNumber", getComplaintNumber());
		attributes.put("signingDate", getSigningDate());
		attributes.put("complaintName", getComplaintName());
		attributes.put("complaintDesc", getComplaintDesc());
		attributes.put("complaintContent", getComplaintContent());
		attributes.put("replyDocument", getReplyDocument());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long complaintId = (Long)attributes.get("complaintId");

		if (complaintId != null) {
			setComplaintId(complaintId);
		}

		String complaintNumber = (String)attributes.get("complaintNumber");

		if (complaintNumber != null) {
			setComplaintNumber(complaintNumber);
		}

		Date signingDate = (Date)attributes.get("signingDate");

		if (signingDate != null) {
			setSigningDate(signingDate);
		}

		String complaintName = (String)attributes.get("complaintName");

		if (complaintName != null) {
			setComplaintName(complaintName);
		}

		String complaintDesc = (String)attributes.get("complaintDesc");

		if (complaintDesc != null) {
			setComplaintDesc(complaintDesc);
		}

		String complaintContent = (String)attributes.get("complaintContent");

		if (complaintContent != null) {
			setComplaintContent(complaintContent);
		}

		String replyDocument = (String)attributes.get("replyDocument");

		if (replyDocument != null) {
			setReplyDocument(replyDocument);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this complaints.
	*
	* @return the primary key of this complaints
	*/
	public long getPrimaryKey() {
		return _complaints.getPrimaryKey();
	}

	/**
	* Sets the primary key of this complaints.
	*
	* @param primaryKey the primary key of this complaints
	*/
	public void setPrimaryKey(long primaryKey) {
		_complaints.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the complaint ID of this complaints.
	*
	* @return the complaint ID of this complaints
	*/
	public long getComplaintId() {
		return _complaints.getComplaintId();
	}

	/**
	* Sets the complaint ID of this complaints.
	*
	* @param complaintId the complaint ID of this complaints
	*/
	public void setComplaintId(long complaintId) {
		_complaints.setComplaintId(complaintId);
	}

	/**
	* Returns the complaint number of this complaints.
	*
	* @return the complaint number of this complaints
	*/
	public java.lang.String getComplaintNumber() {
		return _complaints.getComplaintNumber();
	}

	/**
	* Sets the complaint number of this complaints.
	*
	* @param complaintNumber the complaint number of this complaints
	*/
	public void setComplaintNumber(java.lang.String complaintNumber) {
		_complaints.setComplaintNumber(complaintNumber);
	}

	/**
	* Returns the signing date of this complaints.
	*
	* @return the signing date of this complaints
	*/
	public java.util.Date getSigningDate() {
		return _complaints.getSigningDate();
	}

	/**
	* Sets the signing date of this complaints.
	*
	* @param signingDate the signing date of this complaints
	*/
	public void setSigningDate(java.util.Date signingDate) {
		_complaints.setSigningDate(signingDate);
	}

	/**
	* Returns the complaint name of this complaints.
	*
	* @return the complaint name of this complaints
	*/
	public java.lang.String getComplaintName() {
		return _complaints.getComplaintName();
	}

	/**
	* Sets the complaint name of this complaints.
	*
	* @param complaintName the complaint name of this complaints
	*/
	public void setComplaintName(java.lang.String complaintName) {
		_complaints.setComplaintName(complaintName);
	}

	/**
	* Returns the complaint desc of this complaints.
	*
	* @return the complaint desc of this complaints
	*/
	public java.lang.String getComplaintDesc() {
		return _complaints.getComplaintDesc();
	}

	/**
	* Sets the complaint desc of this complaints.
	*
	* @param complaintDesc the complaint desc of this complaints
	*/
	public void setComplaintDesc(java.lang.String complaintDesc) {
		_complaints.setComplaintDesc(complaintDesc);
	}

	/**
	* Returns the complaint content of this complaints.
	*
	* @return the complaint content of this complaints
	*/
	public java.lang.String getComplaintContent() {
		return _complaints.getComplaintContent();
	}

	/**
	* Sets the complaint content of this complaints.
	*
	* @param complaintContent the complaint content of this complaints
	*/
	public void setComplaintContent(java.lang.String complaintContent) {
		_complaints.setComplaintContent(complaintContent);
	}

	/**
	* Returns the reply document of this complaints.
	*
	* @return the reply document of this complaints
	*/
	public java.lang.String getReplyDocument() {
		return _complaints.getReplyDocument();
	}

	/**
	* Sets the reply document of this complaints.
	*
	* @param replyDocument the reply document of this complaints
	*/
	public void setReplyDocument(java.lang.String replyDocument) {
		_complaints.setReplyDocument(replyDocument);
	}

	/**
	* Returns the group ID of this complaints.
	*
	* @return the group ID of this complaints
	*/
	public long getGroupId() {
		return _complaints.getGroupId();
	}

	/**
	* Sets the group ID of this complaints.
	*
	* @param groupId the group ID of this complaints
	*/
	public void setGroupId(long groupId) {
		_complaints.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this complaints.
	*
	* @return the company ID of this complaints
	*/
	public long getCompanyId() {
		return _complaints.getCompanyId();
	}

	/**
	* Sets the company ID of this complaints.
	*
	* @param companyId the company ID of this complaints
	*/
	public void setCompanyId(long companyId) {
		_complaints.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this complaints.
	*
	* @return the user ID of this complaints
	*/
	public long getUserId() {
		return _complaints.getUserId();
	}

	/**
	* Sets the user ID of this complaints.
	*
	* @param userId the user ID of this complaints
	*/
	public void setUserId(long userId) {
		_complaints.setUserId(userId);
	}

	/**
	* Returns the user uuid of this complaints.
	*
	* @return the user uuid of this complaints
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _complaints.getUserUuid();
	}

	/**
	* Sets the user uuid of this complaints.
	*
	* @param userUuid the user uuid of this complaints
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_complaints.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this complaints.
	*
	* @return the create date of this complaints
	*/
	public java.util.Date getCreateDate() {
		return _complaints.getCreateDate();
	}

	/**
	* Sets the create date of this complaints.
	*
	* @param createDate the create date of this complaints
	*/
	public void setCreateDate(java.util.Date createDate) {
		_complaints.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this complaints.
	*
	* @return the modified date of this complaints
	*/
	public java.util.Date getModifiedDate() {
		return _complaints.getModifiedDate();
	}

	/**
	* Sets the modified date of this complaints.
	*
	* @param modifiedDate the modified date of this complaints
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_complaints.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _complaints.isNew();
	}

	public void setNew(boolean n) {
		_complaints.setNew(n);
	}

	public boolean isCachedModel() {
		return _complaints.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_complaints.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _complaints.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _complaints.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_complaints.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _complaints.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_complaints.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ComplaintsWrapper((Complaints)_complaints.clone());
	}

	public int compareTo(
		com.bkav.portal.portlet.complaints.model.Complaints complaints) {
		return _complaints.compareTo(complaints);
	}

	@Override
	public int hashCode() {
		return _complaints.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.complaints.model.Complaints> toCacheModel() {
		return _complaints.toCacheModel();
	}

	public com.bkav.portal.portlet.complaints.model.Complaints toEscapedModel() {
		return new ComplaintsWrapper(_complaints.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _complaints.toString();
	}

	public java.lang.String toXmlString() {
		return _complaints.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_complaints.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Complaints getWrappedComplaints() {
		return _complaints;
	}

	public Complaints getWrappedModel() {
		return _complaints;
	}

	public void resetOriginalValues() {
		_complaints.resetOriginalValues();
	}

	private Complaints _complaints;
}