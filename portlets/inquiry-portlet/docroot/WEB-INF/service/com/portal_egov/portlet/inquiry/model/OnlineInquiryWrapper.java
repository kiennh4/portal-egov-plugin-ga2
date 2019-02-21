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

package com.portal_egov.portlet.inquiry.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link OnlineInquiry}.
 * </p>
 *
 * @author    HungDX
 * @see       OnlineInquiry
 * @generated
 */
public class OnlineInquiryWrapper implements OnlineInquiry,
	ModelWrapper<OnlineInquiry> {
	public OnlineInquiryWrapper(OnlineInquiry onlineInquiry) {
		_onlineInquiry = onlineInquiry;
	}

	public Class<?> getModelClass() {
		return OnlineInquiry.class;
	}

	public String getModelClassName() {
		return OnlineInquiry.class.getName();
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
		attributes.put("fullName", getFullName());
		attributes.put("phoneNumbers", getPhoneNumbers());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("inquiryContent", getInquiryContent());
		attributes.put("inquiryStatus", getInquiryStatus());

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

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String phoneNumbers = (String)attributes.get("phoneNumbers");

		if (phoneNumbers != null) {
			setPhoneNumbers(phoneNumbers);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String inquiryContent = (String)attributes.get("inquiryContent");

		if (inquiryContent != null) {
			setInquiryContent(inquiryContent);
		}

		Integer inquiryStatus = (Integer)attributes.get("inquiryStatus");

		if (inquiryStatus != null) {
			setInquiryStatus(inquiryStatus);
		}
	}

	/**
	* Returns the primary key of this online inquiry.
	*
	* @return the primary key of this online inquiry
	*/
	public long getPrimaryKey() {
		return _onlineInquiry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this online inquiry.
	*
	* @param primaryKey the primary key of this online inquiry
	*/
	public void setPrimaryKey(long primaryKey) {
		_onlineInquiry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the inquiry ID of this online inquiry.
	*
	* @return the inquiry ID of this online inquiry
	*/
	public long getInquiryId() {
		return _onlineInquiry.getInquiryId();
	}

	/**
	* Sets the inquiry ID of this online inquiry.
	*
	* @param inquiryId the inquiry ID of this online inquiry
	*/
	public void setInquiryId(long inquiryId) {
		_onlineInquiry.setInquiryId(inquiryId);
	}

	/**
	* Returns the group ID of this online inquiry.
	*
	* @return the group ID of this online inquiry
	*/
	public long getGroupId() {
		return _onlineInquiry.getGroupId();
	}

	/**
	* Sets the group ID of this online inquiry.
	*
	* @param groupId the group ID of this online inquiry
	*/
	public void setGroupId(long groupId) {
		_onlineInquiry.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this online inquiry.
	*
	* @return the company ID of this online inquiry
	*/
	public long getCompanyId() {
		return _onlineInquiry.getCompanyId();
	}

	/**
	* Sets the company ID of this online inquiry.
	*
	* @param companyId the company ID of this online inquiry
	*/
	public void setCompanyId(long companyId) {
		_onlineInquiry.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this online inquiry.
	*
	* @return the user ID of this online inquiry
	*/
	public long getUserId() {
		return _onlineInquiry.getUserId();
	}

	/**
	* Sets the user ID of this online inquiry.
	*
	* @param userId the user ID of this online inquiry
	*/
	public void setUserId(long userId) {
		_onlineInquiry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this online inquiry.
	*
	* @return the user uuid of this online inquiry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _onlineInquiry.getUserUuid();
	}

	/**
	* Sets the user uuid of this online inquiry.
	*
	* @param userUuid the user uuid of this online inquiry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_onlineInquiry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this online inquiry.
	*
	* @return the user name of this online inquiry
	*/
	public java.lang.String getUserName() {
		return _onlineInquiry.getUserName();
	}

	/**
	* Sets the user name of this online inquiry.
	*
	* @param userName the user name of this online inquiry
	*/
	public void setUserName(java.lang.String userName) {
		_onlineInquiry.setUserName(userName);
	}

	/**
	* Returns the create date of this online inquiry.
	*
	* @return the create date of this online inquiry
	*/
	public java.util.Date getCreateDate() {
		return _onlineInquiry.getCreateDate();
	}

	/**
	* Sets the create date of this online inquiry.
	*
	* @param createDate the create date of this online inquiry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_onlineInquiry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this online inquiry.
	*
	* @return the modified date of this online inquiry
	*/
	public java.util.Date getModifiedDate() {
		return _onlineInquiry.getModifiedDate();
	}

	/**
	* Sets the modified date of this online inquiry.
	*
	* @param modifiedDate the modified date of this online inquiry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_onlineInquiry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the full name of this online inquiry.
	*
	* @return the full name of this online inquiry
	*/
	public java.lang.String getFullName() {
		return _onlineInquiry.getFullName();
	}

	/**
	* Sets the full name of this online inquiry.
	*
	* @param fullName the full name of this online inquiry
	*/
	public void setFullName(java.lang.String fullName) {
		_onlineInquiry.setFullName(fullName);
	}

	/**
	* Returns the phone numbers of this online inquiry.
	*
	* @return the phone numbers of this online inquiry
	*/
	public java.lang.String getPhoneNumbers() {
		return _onlineInquiry.getPhoneNumbers();
	}

	/**
	* Sets the phone numbers of this online inquiry.
	*
	* @param phoneNumbers the phone numbers of this online inquiry
	*/
	public void setPhoneNumbers(java.lang.String phoneNumbers) {
		_onlineInquiry.setPhoneNumbers(phoneNumbers);
	}

	/**
	* Returns the email address of this online inquiry.
	*
	* @return the email address of this online inquiry
	*/
	public java.lang.String getEmailAddress() {
		return _onlineInquiry.getEmailAddress();
	}

	/**
	* Sets the email address of this online inquiry.
	*
	* @param emailAddress the email address of this online inquiry
	*/
	public void setEmailAddress(java.lang.String emailAddress) {
		_onlineInquiry.setEmailAddress(emailAddress);
	}

	/**
	* Returns the inquiry content of this online inquiry.
	*
	* @return the inquiry content of this online inquiry
	*/
	public java.lang.String getInquiryContent() {
		return _onlineInquiry.getInquiryContent();
	}

	/**
	* Sets the inquiry content of this online inquiry.
	*
	* @param inquiryContent the inquiry content of this online inquiry
	*/
	public void setInquiryContent(java.lang.String inquiryContent) {
		_onlineInquiry.setInquiryContent(inquiryContent);
	}

	/**
	* Returns the inquiry status of this online inquiry.
	*
	* @return the inquiry status of this online inquiry
	*/
	public int getInquiryStatus() {
		return _onlineInquiry.getInquiryStatus();
	}

	/**
	* Sets the inquiry status of this online inquiry.
	*
	* @param inquiryStatus the inquiry status of this online inquiry
	*/
	public void setInquiryStatus(int inquiryStatus) {
		_onlineInquiry.setInquiryStatus(inquiryStatus);
	}

	public boolean isNew() {
		return _onlineInquiry.isNew();
	}

	public void setNew(boolean n) {
		_onlineInquiry.setNew(n);
	}

	public boolean isCachedModel() {
		return _onlineInquiry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_onlineInquiry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _onlineInquiry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _onlineInquiry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_onlineInquiry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _onlineInquiry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_onlineInquiry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OnlineInquiryWrapper((OnlineInquiry)_onlineInquiry.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.inquiry.model.OnlineInquiry onlineInquiry) {
		return _onlineInquiry.compareTo(onlineInquiry);
	}

	@Override
	public int hashCode() {
		return _onlineInquiry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.inquiry.model.OnlineInquiry> toCacheModel() {
		return _onlineInquiry.toCacheModel();
	}

	public com.portal_egov.portlet.inquiry.model.OnlineInquiry toEscapedModel() {
		return new OnlineInquiryWrapper(_onlineInquiry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _onlineInquiry.toString();
	}

	public java.lang.String toXmlString() {
		return _onlineInquiry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_onlineInquiry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public OnlineInquiry getWrappedOnlineInquiry() {
		return _onlineInquiry;
	}

	public OnlineInquiry getWrappedModel() {
		return _onlineInquiry;
	}

	public void resetOriginalValues() {
		_onlineInquiry.resetOriginalValues();
	}

	private OnlineInquiry _onlineInquiry;
}