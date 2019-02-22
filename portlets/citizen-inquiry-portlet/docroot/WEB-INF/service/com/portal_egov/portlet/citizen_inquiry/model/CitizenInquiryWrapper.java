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

package com.portal_egov.portlet.citizen_inquiry.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CitizenInquiry}.
 * </p>
 *
 * @author    HungDX
 * @see       CitizenInquiry
 * @generated
 */
public class CitizenInquiryWrapper implements CitizenInquiry,
	ModelWrapper<CitizenInquiry> {
	public CitizenInquiryWrapper(CitizenInquiry citizenInquiry) {
		_citizenInquiry = citizenInquiry;
	}

	public Class<?> getModelClass() {
		return CitizenInquiry.class;
	}

	public String getModelClassName() {
		return CitizenInquiry.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("inquiryId", getInquiryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryId", getCategoryId());
		attributes.put("citizenName", getCitizenName());
		attributes.put("citizenPhone", getCitizenPhone());
		attributes.put("citizenEmail", getCitizenEmail());
		attributes.put("citizenAddress", getCitizenAddress());
		attributes.put("inquiryTitle", getInquiryTitle());
		attributes.put("inquiryContent", getInquiryContent());
		attributes.put("inquiryFeedback", getInquiryFeedback());
		attributes.put("inquiryFeedbackUser", getInquiryFeedbackUser());
		attributes.put("inquiryFeedbackDate", getInquiryFeedbackDate());
		attributes.put("inquiryStatus", getInquiryStatus());
		attributes.put("approved", getApproved());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long inquiryId = (Long)attributes.get("inquiryId");

		if (inquiryId != null) {
			setInquiryId(inquiryId);
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

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String citizenName = (String)attributes.get("citizenName");

		if (citizenName != null) {
			setCitizenName(citizenName);
		}

		String citizenPhone = (String)attributes.get("citizenPhone");

		if (citizenPhone != null) {
			setCitizenPhone(citizenPhone);
		}

		String citizenEmail = (String)attributes.get("citizenEmail");

		if (citizenEmail != null) {
			setCitizenEmail(citizenEmail);
		}

		String citizenAddress = (String)attributes.get("citizenAddress");

		if (citizenAddress != null) {
			setCitizenAddress(citizenAddress);
		}

		String inquiryTitle = (String)attributes.get("inquiryTitle");

		if (inquiryTitle != null) {
			setInquiryTitle(inquiryTitle);
		}

		String inquiryContent = (String)attributes.get("inquiryContent");

		if (inquiryContent != null) {
			setInquiryContent(inquiryContent);
		}

		String inquiryFeedback = (String)attributes.get("inquiryFeedback");

		if (inquiryFeedback != null) {
			setInquiryFeedback(inquiryFeedback);
		}

		String inquiryFeedbackUser = (String)attributes.get(
				"inquiryFeedbackUser");

		if (inquiryFeedbackUser != null) {
			setInquiryFeedbackUser(inquiryFeedbackUser);
		}

		Date inquiryFeedbackDate = (Date)attributes.get("inquiryFeedbackDate");

		if (inquiryFeedbackDate != null) {
			setInquiryFeedbackDate(inquiryFeedbackDate);
		}

		Integer inquiryStatus = (Integer)attributes.get("inquiryStatus");

		if (inquiryStatus != null) {
			setInquiryStatus(inquiryStatus);
		}

		Boolean approved = (Boolean)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}
	}

	/**
	* Returns the primary key of this citizen inquiry.
	*
	* @return the primary key of this citizen inquiry
	*/
	public long getPrimaryKey() {
		return _citizenInquiry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this citizen inquiry.
	*
	* @param primaryKey the primary key of this citizen inquiry
	*/
	public void setPrimaryKey(long primaryKey) {
		_citizenInquiry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the inquiry ID of this citizen inquiry.
	*
	* @return the inquiry ID of this citizen inquiry
	*/
	public long getInquiryId() {
		return _citizenInquiry.getInquiryId();
	}

	/**
	* Sets the inquiry ID of this citizen inquiry.
	*
	* @param inquiryId the inquiry ID of this citizen inquiry
	*/
	public void setInquiryId(long inquiryId) {
		_citizenInquiry.setInquiryId(inquiryId);
	}

	/**
	* Returns the group ID of this citizen inquiry.
	*
	* @return the group ID of this citizen inquiry
	*/
	public long getGroupId() {
		return _citizenInquiry.getGroupId();
	}

	/**
	* Sets the group ID of this citizen inquiry.
	*
	* @param groupId the group ID of this citizen inquiry
	*/
	public void setGroupId(long groupId) {
		_citizenInquiry.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this citizen inquiry.
	*
	* @return the company ID of this citizen inquiry
	*/
	public long getCompanyId() {
		return _citizenInquiry.getCompanyId();
	}

	/**
	* Sets the company ID of this citizen inquiry.
	*
	* @param companyId the company ID of this citizen inquiry
	*/
	public void setCompanyId(long companyId) {
		_citizenInquiry.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this citizen inquiry.
	*
	* @return the user ID of this citizen inquiry
	*/
	public long getUserId() {
		return _citizenInquiry.getUserId();
	}

	/**
	* Sets the user ID of this citizen inquiry.
	*
	* @param userId the user ID of this citizen inquiry
	*/
	public void setUserId(long userId) {
		_citizenInquiry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this citizen inquiry.
	*
	* @return the user uuid of this citizen inquiry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiry.getUserUuid();
	}

	/**
	* Sets the user uuid of this citizen inquiry.
	*
	* @param userUuid the user uuid of this citizen inquiry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_citizenInquiry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this citizen inquiry.
	*
	* @return the user name of this citizen inquiry
	*/
	public java.lang.String getUserName() {
		return _citizenInquiry.getUserName();
	}

	/**
	* Sets the user name of this citizen inquiry.
	*
	* @param userName the user name of this citizen inquiry
	*/
	public void setUserName(java.lang.String userName) {
		_citizenInquiry.setUserName(userName);
	}

	/**
	* Returns the create date of this citizen inquiry.
	*
	* @return the create date of this citizen inquiry
	*/
	public java.util.Date getCreateDate() {
		return _citizenInquiry.getCreateDate();
	}

	/**
	* Sets the create date of this citizen inquiry.
	*
	* @param createDate the create date of this citizen inquiry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_citizenInquiry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this citizen inquiry.
	*
	* @return the modified date of this citizen inquiry
	*/
	public java.util.Date getModifiedDate() {
		return _citizenInquiry.getModifiedDate();
	}

	/**
	* Sets the modified date of this citizen inquiry.
	*
	* @param modifiedDate the modified date of this citizen inquiry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_citizenInquiry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category ID of this citizen inquiry.
	*
	* @return the category ID of this citizen inquiry
	*/
	public long getCategoryId() {
		return _citizenInquiry.getCategoryId();
	}

	/**
	* Sets the category ID of this citizen inquiry.
	*
	* @param categoryId the category ID of this citizen inquiry
	*/
	public void setCategoryId(long categoryId) {
		_citizenInquiry.setCategoryId(categoryId);
	}

	/**
	* Returns the citizen name of this citizen inquiry.
	*
	* @return the citizen name of this citizen inquiry
	*/
	public java.lang.String getCitizenName() {
		return _citizenInquiry.getCitizenName();
	}

	/**
	* Sets the citizen name of this citizen inquiry.
	*
	* @param citizenName the citizen name of this citizen inquiry
	*/
	public void setCitizenName(java.lang.String citizenName) {
		_citizenInquiry.setCitizenName(citizenName);
	}

	/**
	* Returns the citizen phone of this citizen inquiry.
	*
	* @return the citizen phone of this citizen inquiry
	*/
	public java.lang.String getCitizenPhone() {
		return _citizenInquiry.getCitizenPhone();
	}

	/**
	* Sets the citizen phone of this citizen inquiry.
	*
	* @param citizenPhone the citizen phone of this citizen inquiry
	*/
	public void setCitizenPhone(java.lang.String citizenPhone) {
		_citizenInquiry.setCitizenPhone(citizenPhone);
	}

	/**
	* Returns the citizen email of this citizen inquiry.
	*
	* @return the citizen email of this citizen inquiry
	*/
	public java.lang.String getCitizenEmail() {
		return _citizenInquiry.getCitizenEmail();
	}

	/**
	* Sets the citizen email of this citizen inquiry.
	*
	* @param citizenEmail the citizen email of this citizen inquiry
	*/
	public void setCitizenEmail(java.lang.String citizenEmail) {
		_citizenInquiry.setCitizenEmail(citizenEmail);
	}

	/**
	* Returns the citizen address of this citizen inquiry.
	*
	* @return the citizen address of this citizen inquiry
	*/
	public java.lang.String getCitizenAddress() {
		return _citizenInquiry.getCitizenAddress();
	}

	/**
	* Sets the citizen address of this citizen inquiry.
	*
	* @param citizenAddress the citizen address of this citizen inquiry
	*/
	public void setCitizenAddress(java.lang.String citizenAddress) {
		_citizenInquiry.setCitizenAddress(citizenAddress);
	}

	/**
	* Returns the inquiry title of this citizen inquiry.
	*
	* @return the inquiry title of this citizen inquiry
	*/
	public java.lang.String getInquiryTitle() {
		return _citizenInquiry.getInquiryTitle();
	}

	/**
	* Sets the inquiry title of this citizen inquiry.
	*
	* @param inquiryTitle the inquiry title of this citizen inquiry
	*/
	public void setInquiryTitle(java.lang.String inquiryTitle) {
		_citizenInquiry.setInquiryTitle(inquiryTitle);
	}

	/**
	* Returns the inquiry content of this citizen inquiry.
	*
	* @return the inquiry content of this citizen inquiry
	*/
	public java.lang.String getInquiryContent() {
		return _citizenInquiry.getInquiryContent();
	}

	/**
	* Sets the inquiry content of this citizen inquiry.
	*
	* @param inquiryContent the inquiry content of this citizen inquiry
	*/
	public void setInquiryContent(java.lang.String inquiryContent) {
		_citizenInquiry.setInquiryContent(inquiryContent);
	}

	/**
	* Returns the inquiry feedback of this citizen inquiry.
	*
	* @return the inquiry feedback of this citizen inquiry
	*/
	public java.lang.String getInquiryFeedback() {
		return _citizenInquiry.getInquiryFeedback();
	}

	/**
	* Sets the inquiry feedback of this citizen inquiry.
	*
	* @param inquiryFeedback the inquiry feedback of this citizen inquiry
	*/
	public void setInquiryFeedback(java.lang.String inquiryFeedback) {
		_citizenInquiry.setInquiryFeedback(inquiryFeedback);
	}

	/**
	* Returns the inquiry feedback user of this citizen inquiry.
	*
	* @return the inquiry feedback user of this citizen inquiry
	*/
	public java.lang.String getInquiryFeedbackUser() {
		return _citizenInquiry.getInquiryFeedbackUser();
	}

	/**
	* Sets the inquiry feedback user of this citizen inquiry.
	*
	* @param inquiryFeedbackUser the inquiry feedback user of this citizen inquiry
	*/
	public void setInquiryFeedbackUser(java.lang.String inquiryFeedbackUser) {
		_citizenInquiry.setInquiryFeedbackUser(inquiryFeedbackUser);
	}

	/**
	* Returns the inquiry feedback date of this citizen inquiry.
	*
	* @return the inquiry feedback date of this citizen inquiry
	*/
	public java.util.Date getInquiryFeedbackDate() {
		return _citizenInquiry.getInquiryFeedbackDate();
	}

	/**
	* Sets the inquiry feedback date of this citizen inquiry.
	*
	* @param inquiryFeedbackDate the inquiry feedback date of this citizen inquiry
	*/
	public void setInquiryFeedbackDate(java.util.Date inquiryFeedbackDate) {
		_citizenInquiry.setInquiryFeedbackDate(inquiryFeedbackDate);
	}

	/**
	* Returns the inquiry status of this citizen inquiry.
	*
	* @return the inquiry status of this citizen inquiry
	*/
	public int getInquiryStatus() {
		return _citizenInquiry.getInquiryStatus();
	}

	/**
	* Sets the inquiry status of this citizen inquiry.
	*
	* @param inquiryStatus the inquiry status of this citizen inquiry
	*/
	public void setInquiryStatus(int inquiryStatus) {
		_citizenInquiry.setInquiryStatus(inquiryStatus);
	}

	/**
	* Returns the approved of this citizen inquiry.
	*
	* @return the approved of this citizen inquiry
	*/
	public boolean getApproved() {
		return _citizenInquiry.getApproved();
	}

	/**
	* Returns <code>true</code> if this citizen inquiry is approved.
	*
	* @return <code>true</code> if this citizen inquiry is approved; <code>false</code> otherwise
	*/
	public boolean isApproved() {
		return _citizenInquiry.isApproved();
	}

	/**
	* Sets whether this citizen inquiry is approved.
	*
	* @param approved the approved of this citizen inquiry
	*/
	public void setApproved(boolean approved) {
		_citizenInquiry.setApproved(approved);
	}

	public boolean isNew() {
		return _citizenInquiry.isNew();
	}

	public void setNew(boolean n) {
		_citizenInquiry.setNew(n);
	}

	public boolean isCachedModel() {
		return _citizenInquiry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_citizenInquiry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _citizenInquiry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _citizenInquiry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_citizenInquiry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _citizenInquiry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_citizenInquiry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CitizenInquiryWrapper((CitizenInquiry)_citizenInquiry.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry citizenInquiry) {
		return _citizenInquiry.compareTo(citizenInquiry);
	}

	@Override
	public int hashCode() {
		return _citizenInquiry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> toCacheModel() {
		return _citizenInquiry.toCacheModel();
	}

	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry toEscapedModel() {
		return new CitizenInquiryWrapper(_citizenInquiry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _citizenInquiry.toString();
	}

	public java.lang.String toXmlString() {
		return _citizenInquiry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_citizenInquiry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CitizenInquiry getWrappedCitizenInquiry() {
		return _citizenInquiry;
	}

	public CitizenInquiry getWrappedModel() {
		return _citizenInquiry;
	}

	public void resetOriginalValues() {
		_citizenInquiry.resetOriginalValues();
	}

	private CitizenInquiry _citizenInquiry;
}