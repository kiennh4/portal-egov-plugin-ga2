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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.inquiry.service.OnlineInquiryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class OnlineInquiryClp extends BaseModelImpl<OnlineInquiry>
	implements OnlineInquiry {
	public OnlineInquiryClp() {
	}

	public Class<?> getModelClass() {
		return OnlineInquiry.class;
	}

	public String getModelClassName() {
		return OnlineInquiry.class.getName();
	}

	public long getPrimaryKey() {
		return _inquiryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setInquiryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_inquiryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getInquiryId() {
		return _inquiryId;
	}

	public void setInquiryId(long inquiryId) {
		_inquiryId = inquiryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getPhoneNumbers() {
		return _phoneNumbers;
	}

	public void setPhoneNumbers(String phoneNumbers) {
		_phoneNumbers = phoneNumbers;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getInquiryContent() {
		return _inquiryContent;
	}

	public void setInquiryContent(String inquiryContent) {
		_inquiryContent = inquiryContent;
	}

	public int getInquiryStatus() {
		return _inquiryStatus;
	}

	public void setInquiryStatus(int inquiryStatus) {
		_inquiryStatus = inquiryStatus;
	}

	public BaseModel<?> getOnlineInquiryRemoteModel() {
		return _onlineInquiryRemoteModel;
	}

	public void setOnlineInquiryRemoteModel(
		BaseModel<?> onlineInquiryRemoteModel) {
		_onlineInquiryRemoteModel = onlineInquiryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			OnlineInquiryLocalServiceUtil.addOnlineInquiry(this);
		}
		else {
			OnlineInquiryLocalServiceUtil.updateOnlineInquiry(this);
		}
	}

	@Override
	public OnlineInquiry toEscapedModel() {
		return (OnlineInquiry)Proxy.newProxyInstance(OnlineInquiry.class.getClassLoader(),
			new Class[] { OnlineInquiry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OnlineInquiryClp clone = new OnlineInquiryClp();

		clone.setInquiryId(getInquiryId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFullName(getFullName());
		clone.setPhoneNumbers(getPhoneNumbers());
		clone.setEmailAddress(getEmailAddress());
		clone.setInquiryContent(getInquiryContent());
		clone.setInquiryStatus(getInquiryStatus());

		return clone;
	}

	public int compareTo(OnlineInquiry onlineInquiry) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				onlineInquiry.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OnlineInquiryClp onlineInquiry = null;

		try {
			onlineInquiry = (OnlineInquiryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = onlineInquiry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{inquiryId=");
		sb.append(getInquiryId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", phoneNumbers=");
		sb.append(getPhoneNumbers());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", inquiryContent=");
		sb.append(getInquiryContent());
		sb.append(", inquiryStatus=");
		sb.append(getInquiryStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.inquiry.model.OnlineInquiry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>inquiryId</column-name><column-value><![CDATA[");
		sb.append(getInquiryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNumbers</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumbers());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inquiryContent</column-name><column-value><![CDATA[");
		sb.append(getInquiryContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inquiryStatus</column-name><column-value><![CDATA[");
		sb.append(getInquiryStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _inquiryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _fullName;
	private String _phoneNumbers;
	private String _emailAddress;
	private String _inquiryContent;
	private int _inquiryStatus;
	private BaseModel<?> _onlineInquiryRemoteModel;
}