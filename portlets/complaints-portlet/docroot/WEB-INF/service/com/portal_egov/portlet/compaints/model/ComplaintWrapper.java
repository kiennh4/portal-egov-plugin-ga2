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

package com.portal_egov.portlet.compaints.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Complaint}.
 * </p>
 *
 * @author    HungDX
 * @see       Complaint
 * @generated
 */
public class ComplaintWrapper implements Complaint, ModelWrapper<Complaint> {
	public ComplaintWrapper(Complaint complaint) {
		_complaint = complaint;
	}

	public Class<?> getModelClass() {
		return Complaint.class;
	}

	public String getModelClassName() {
		return Complaint.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("complaintId", getComplaintId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("complaintTitle", getComplaintTitle());
		attributes.put("complaintDescription", getComplaintDescription());
		attributes.put("complaintContent", getComplaintContent());
		attributes.put("fileAttachmentURL", getFileAttachmentURL());
		attributes.put("complaintStatus", getComplaintStatus());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long complaintId = (Long)attributes.get("complaintId");

		if (complaintId != null) {
			setComplaintId(complaintId);
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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String complaintTitle = (String)attributes.get("complaintTitle");

		if (complaintTitle != null) {
			setComplaintTitle(complaintTitle);
		}

		String complaintDescription = (String)attributes.get(
				"complaintDescription");

		if (complaintDescription != null) {
			setComplaintDescription(complaintDescription);
		}

		String complaintContent = (String)attributes.get("complaintContent");

		if (complaintContent != null) {
			setComplaintContent(complaintContent);
		}

		String fileAttachmentURL = (String)attributes.get("fileAttachmentURL");

		if (fileAttachmentURL != null) {
			setFileAttachmentURL(fileAttachmentURL);
		}

		Integer complaintStatus = (Integer)attributes.get("complaintStatus");

		if (complaintStatus != null) {
			setComplaintStatus(complaintStatus);
		}
	}

	/**
	* Returns the primary key of this complaint.
	*
	* @return the primary key of this complaint
	*/
	public long getPrimaryKey() {
		return _complaint.getPrimaryKey();
	}

	/**
	* Sets the primary key of this complaint.
	*
	* @param primaryKey the primary key of this complaint
	*/
	public void setPrimaryKey(long primaryKey) {
		_complaint.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the complaint ID of this complaint.
	*
	* @return the complaint ID of this complaint
	*/
	public long getComplaintId() {
		return _complaint.getComplaintId();
	}

	/**
	* Sets the complaint ID of this complaint.
	*
	* @param complaintId the complaint ID of this complaint
	*/
	public void setComplaintId(long complaintId) {
		_complaint.setComplaintId(complaintId);
	}

	/**
	* Returns the group ID of this complaint.
	*
	* @return the group ID of this complaint
	*/
	public long getGroupId() {
		return _complaint.getGroupId();
	}

	/**
	* Sets the group ID of this complaint.
	*
	* @param groupId the group ID of this complaint
	*/
	public void setGroupId(long groupId) {
		_complaint.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this complaint.
	*
	* @return the company ID of this complaint
	*/
	public long getCompanyId() {
		return _complaint.getCompanyId();
	}

	/**
	* Sets the company ID of this complaint.
	*
	* @param companyId the company ID of this complaint
	*/
	public void setCompanyId(long companyId) {
		_complaint.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this complaint.
	*
	* @return the user ID of this complaint
	*/
	public long getUserId() {
		return _complaint.getUserId();
	}

	/**
	* Sets the user ID of this complaint.
	*
	* @param userId the user ID of this complaint
	*/
	public void setUserId(long userId) {
		_complaint.setUserId(userId);
	}

	/**
	* Returns the user uuid of this complaint.
	*
	* @return the user uuid of this complaint
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _complaint.getUserUuid();
	}

	/**
	* Sets the user uuid of this complaint.
	*
	* @param userUuid the user uuid of this complaint
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_complaint.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this complaint.
	*
	* @return the user name of this complaint
	*/
	public java.lang.String getUserName() {
		return _complaint.getUserName();
	}

	/**
	* Sets the user name of this complaint.
	*
	* @param userName the user name of this complaint
	*/
	public void setUserName(java.lang.String userName) {
		_complaint.setUserName(userName);
	}

	/**
	* Returns the create date of this complaint.
	*
	* @return the create date of this complaint
	*/
	public java.util.Date getCreateDate() {
		return _complaint.getCreateDate();
	}

	/**
	* Sets the create date of this complaint.
	*
	* @param createDate the create date of this complaint
	*/
	public void setCreateDate(java.util.Date createDate) {
		_complaint.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this complaint.
	*
	* @return the modified date of this complaint
	*/
	public java.util.Date getModifiedDate() {
		return _complaint.getModifiedDate();
	}

	/**
	* Sets the modified date of this complaint.
	*
	* @param modifiedDate the modified date of this complaint
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_complaint.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the complaint title of this complaint.
	*
	* @return the complaint title of this complaint
	*/
	public java.lang.String getComplaintTitle() {
		return _complaint.getComplaintTitle();
	}

	/**
	* Sets the complaint title of this complaint.
	*
	* @param complaintTitle the complaint title of this complaint
	*/
	public void setComplaintTitle(java.lang.String complaintTitle) {
		_complaint.setComplaintTitle(complaintTitle);
	}

	/**
	* Returns the complaint description of this complaint.
	*
	* @return the complaint description of this complaint
	*/
	public java.lang.String getComplaintDescription() {
		return _complaint.getComplaintDescription();
	}

	/**
	* Sets the complaint description of this complaint.
	*
	* @param complaintDescription the complaint description of this complaint
	*/
	public void setComplaintDescription(java.lang.String complaintDescription) {
		_complaint.setComplaintDescription(complaintDescription);
	}

	/**
	* Returns the complaint content of this complaint.
	*
	* @return the complaint content of this complaint
	*/
	public java.lang.String getComplaintContent() {
		return _complaint.getComplaintContent();
	}

	/**
	* Sets the complaint content of this complaint.
	*
	* @param complaintContent the complaint content of this complaint
	*/
	public void setComplaintContent(java.lang.String complaintContent) {
		_complaint.setComplaintContent(complaintContent);
	}

	/**
	* Returns the file attachment u r l of this complaint.
	*
	* @return the file attachment u r l of this complaint
	*/
	public java.lang.String getFileAttachmentURL() {
		return _complaint.getFileAttachmentURL();
	}

	/**
	* Sets the file attachment u r l of this complaint.
	*
	* @param fileAttachmentURL the file attachment u r l of this complaint
	*/
	public void setFileAttachmentURL(java.lang.String fileAttachmentURL) {
		_complaint.setFileAttachmentURL(fileAttachmentURL);
	}

	/**
	* Returns the complaint status of this complaint.
	*
	* @return the complaint status of this complaint
	*/
	public int getComplaintStatus() {
		return _complaint.getComplaintStatus();
	}

	/**
	* Sets the complaint status of this complaint.
	*
	* @param complaintStatus the complaint status of this complaint
	*/
	public void setComplaintStatus(int complaintStatus) {
		_complaint.setComplaintStatus(complaintStatus);
	}

	public boolean isNew() {
		return _complaint.isNew();
	}

	public void setNew(boolean n) {
		_complaint.setNew(n);
	}

	public boolean isCachedModel() {
		return _complaint.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_complaint.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _complaint.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _complaint.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_complaint.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _complaint.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_complaint.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ComplaintWrapper((Complaint)_complaint.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.compaints.model.Complaint complaint) {
		return _complaint.compareTo(complaint);
	}

	@Override
	public int hashCode() {
		return _complaint.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.compaints.model.Complaint> toCacheModel() {
		return _complaint.toCacheModel();
	}

	public com.portal_egov.portlet.compaints.model.Complaint toEscapedModel() {
		return new ComplaintWrapper(_complaint.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _complaint.toString();
	}

	public java.lang.String toXmlString() {
		return _complaint.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_complaint.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Complaint getWrappedComplaint() {
		return _complaint;
	}

	public Complaint getWrappedModel() {
		return _complaint;
	}

	public void resetOriginalValues() {
		_complaint.resetOriginalValues();
	}

	private Complaint _complaint;
}