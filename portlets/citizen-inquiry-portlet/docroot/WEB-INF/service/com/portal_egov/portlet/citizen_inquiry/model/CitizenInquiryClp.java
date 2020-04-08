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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class CitizenInquiryClp extends BaseModelImpl<CitizenInquiry>
	implements CitizenInquiry {
	public CitizenInquiryClp() {
	}

	public Class<?> getModelClass() {
		return CitizenInquiry.class;
	}

	public String getModelClassName() {
		return CitizenInquiry.class.getName();
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

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getCitizenName() {
		return _citizenName;
	}

	public void setCitizenName(String citizenName) {
		_citizenName = citizenName;
	}

	public String getCitizenPhone() {
		return _citizenPhone;
	}

	public void setCitizenPhone(String citizenPhone) {
		_citizenPhone = citizenPhone;
	}

	public String getCitizenEmail() {
		return _citizenEmail;
	}

	public void setCitizenEmail(String citizenEmail) {
		_citizenEmail = citizenEmail;
	}

	public String getCitizenAddress() {
		return _citizenAddress;
	}

	public void setCitizenAddress(String citizenAddress) {
		_citizenAddress = citizenAddress;
	}

	public String getInquiryTitle() {
		return _inquiryTitle;
	}

	public void setInquiryTitle(String inquiryTitle) {
		_inquiryTitle = inquiryTitle;
	}

	public String getInquiryContent() {
		return _inquiryContent;
	}

	public void setInquiryContent(String inquiryContent) {
		_inquiryContent = inquiryContent;
	}

	public String getInquiryFeedback() {
		return _inquiryFeedback;
	}

	public void setInquiryFeedback(String inquiryFeedback) {
		_inquiryFeedback = inquiryFeedback;
	}

	public String getInquiryFeedbackUser() {
		return _inquiryFeedbackUser;
	}

	public void setInquiryFeedbackUser(String inquiryFeedbackUser) {
		_inquiryFeedbackUser = inquiryFeedbackUser;
	}

	public Date getInquiryFeedbackDate() {
		return _inquiryFeedbackDate;
	}

	public void setInquiryFeedbackDate(Date inquiryFeedbackDate) {
		_inquiryFeedbackDate = inquiryFeedbackDate;
	}

	public int getInquiryStatus() {
		return _inquiryStatus;
	}

	public void setInquiryStatus(int inquiryStatus) {
		_inquiryStatus = inquiryStatus;
	}

	public boolean getApproved() {
		return _approved;
	}

	public boolean isApproved() {
		return _approved;
	}

	public void setApproved(boolean approved) {
		_approved = approved;
	}

	public BaseModel<?> getCitizenInquiryRemoteModel() {
		return _citizenInquiryRemoteModel;
	}

	public void setCitizenInquiryRemoteModel(
		BaseModel<?> citizenInquiryRemoteModel) {
		_citizenInquiryRemoteModel = citizenInquiryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CitizenInquiryLocalServiceUtil.addCitizenInquiry(this);
		}
		else {
			CitizenInquiryLocalServiceUtil.updateCitizenInquiry(this);
		}
	}

	@Override
	public CitizenInquiry toEscapedModel() {
		return (CitizenInquiry)Proxy.newProxyInstance(CitizenInquiry.class.getClassLoader(),
			new Class[] { CitizenInquiry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CitizenInquiryClp clone = new CitizenInquiryClp();

		clone.setInquiryId(getInquiryId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCategoryId(getCategoryId());
		clone.setCitizenName(getCitizenName());
		clone.setCitizenPhone(getCitizenPhone());
		clone.setCitizenEmail(getCitizenEmail());
		clone.setCitizenAddress(getCitizenAddress());
		clone.setInquiryTitle(getInquiryTitle());
		clone.setInquiryContent(getInquiryContent());
		clone.setInquiryFeedback(getInquiryFeedback());
		clone.setInquiryFeedbackUser(getInquiryFeedbackUser());
		clone.setInquiryFeedbackDate(getInquiryFeedbackDate());
		clone.setInquiryStatus(getInquiryStatus());
		clone.setApproved(getApproved());

		return clone;
	}

	public int compareTo(CitizenInquiry citizenInquiry) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				citizenInquiry.getCreateDate());

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

		CitizenInquiryClp citizenInquiry = null;

		try {
			citizenInquiry = (CitizenInquiryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = citizenInquiry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

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
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", citizenName=");
		sb.append(getCitizenName());
		sb.append(", citizenPhone=");
		sb.append(getCitizenPhone());
		sb.append(", citizenEmail=");
		sb.append(getCitizenEmail());
		sb.append(", citizenAddress=");
		sb.append(getCitizenAddress());
		sb.append(", inquiryTitle=");
		sb.append(getInquiryTitle());
		sb.append(", inquiryContent=");
		sb.append(getInquiryContent());
		sb.append(", inquiryFeedback=");
		sb.append(getInquiryFeedback());
		sb.append(", inquiryFeedbackUser=");
		sb.append(getInquiryFeedbackUser());
		sb.append(", inquiryFeedbackDate=");
		sb.append(getInquiryFeedbackDate());
		sb.append(", inquiryStatus=");
		sb.append(getInquiryStatus());
		sb.append(", approved=");
		sb.append(getApproved());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append(
			"com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry");
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
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenName</column-name><column-value><![CDATA[");
		sb.append(getCitizenName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenPhone</column-name><column-value><![CDATA[");
		sb.append(getCitizenPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenEmail</column-name><column-value><![CDATA[");
		sb.append(getCitizenEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenAddress</column-name><column-value><![CDATA[");
		sb.append(getCitizenAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inquiryTitle</column-name><column-value><![CDATA[");
		sb.append(getInquiryTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inquiryContent</column-name><column-value><![CDATA[");
		sb.append(getInquiryContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inquiryFeedback</column-name><column-value><![CDATA[");
		sb.append(getInquiryFeedback());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inquiryFeedbackUser</column-name><column-value><![CDATA[");
		sb.append(getInquiryFeedbackUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inquiryFeedbackDate</column-name><column-value><![CDATA[");
		sb.append(getInquiryFeedbackDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inquiryStatus</column-name><column-value><![CDATA[");
		sb.append(getInquiryStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approved</column-name><column-value><![CDATA[");
		sb.append(getApproved());
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
	private long _categoryId;
	private String _citizenName;
	private String _citizenPhone;
	private String _citizenEmail;
	private String _citizenAddress;
	private String _inquiryTitle;
	private String _inquiryContent;
	private String _inquiryFeedback;
	private String _inquiryFeedbackUser;
	private Date _inquiryFeedbackDate;
	private int _inquiryStatus;
	private boolean _approved;
	private BaseModel<?> _citizenInquiryRemoteModel;
}