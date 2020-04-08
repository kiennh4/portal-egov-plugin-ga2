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

import com.bkav.portal.portlet.complaints.service.ComplaintsLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author AnhBDb
 */
public class ComplaintsClp extends BaseModelImpl<Complaints>
	implements Complaints {
	public ComplaintsClp() {
	}

	public Class<?> getModelClass() {
		return Complaints.class;
	}

	public String getModelClassName() {
		return Complaints.class.getName();
	}

	public long getPrimaryKey() {
		return _complaintId;
	}

	public void setPrimaryKey(long primaryKey) {
		setComplaintId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_complaintId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getComplaintId() {
		return _complaintId;
	}

	public void setComplaintId(long complaintId) {
		_complaintId = complaintId;
	}

	public String getComplaintNumber() {
		return _complaintNumber;
	}

	public void setComplaintNumber(String complaintNumber) {
		_complaintNumber = complaintNumber;
	}

	public Date getSigningDate() {
		return _signingDate;
	}

	public void setSigningDate(Date signingDate) {
		_signingDate = signingDate;
	}

	public String getComplaintName() {
		return _complaintName;
	}

	public void setComplaintName(String complaintName) {
		_complaintName = complaintName;
	}

	public String getComplaintDesc() {
		return _complaintDesc;
	}

	public void setComplaintDesc(String complaintDesc) {
		_complaintDesc = complaintDesc;
	}

	public String getComplaintContent() {
		return _complaintContent;
	}

	public void setComplaintContent(String complaintContent) {
		_complaintContent = complaintContent;
	}

	public String getReplyDocument() {
		return _replyDocument;
	}

	public void setReplyDocument(String replyDocument) {
		_replyDocument = replyDocument;
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

	public BaseModel<?> getComplaintsRemoteModel() {
		return _complaintsRemoteModel;
	}

	public void setComplaintsRemoteModel(BaseModel<?> complaintsRemoteModel) {
		_complaintsRemoteModel = complaintsRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ComplaintsLocalServiceUtil.addComplaints(this);
		}
		else {
			ComplaintsLocalServiceUtil.updateComplaints(this);
		}
	}

	@Override
	public Complaints toEscapedModel() {
		return (Complaints)Proxy.newProxyInstance(Complaints.class.getClassLoader(),
			new Class[] { Complaints.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ComplaintsClp clone = new ComplaintsClp();

		clone.setComplaintId(getComplaintId());
		clone.setComplaintNumber(getComplaintNumber());
		clone.setSigningDate(getSigningDate());
		clone.setComplaintName(getComplaintName());
		clone.setComplaintDesc(getComplaintDesc());
		clone.setComplaintContent(getComplaintContent());
		clone.setReplyDocument(getReplyDocument());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(Complaints complaints) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), complaints.getCreateDate());

		value = value * -1;

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

		ComplaintsClp complaints = null;

		try {
			complaints = (ComplaintsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = complaints.getPrimaryKey();

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

		sb.append("{complaintId=");
		sb.append(getComplaintId());
		sb.append(", complaintNumber=");
		sb.append(getComplaintNumber());
		sb.append(", signingDate=");
		sb.append(getSigningDate());
		sb.append(", complaintName=");
		sb.append(getComplaintName());
		sb.append(", complaintDesc=");
		sb.append(getComplaintDesc());
		sb.append(", complaintContent=");
		sb.append(getComplaintContent());
		sb.append(", replyDocument=");
		sb.append(getReplyDocument());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.complaints.model.Complaints");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>complaintId</column-name><column-value><![CDATA[");
		sb.append(getComplaintId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complaintNumber</column-name><column-value><![CDATA[");
		sb.append(getComplaintNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>signingDate</column-name><column-value><![CDATA[");
		sb.append(getSigningDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complaintName</column-name><column-value><![CDATA[");
		sb.append(getComplaintName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complaintDesc</column-name><column-value><![CDATA[");
		sb.append(getComplaintDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complaintContent</column-name><column-value><![CDATA[");
		sb.append(getComplaintContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>replyDocument</column-name><column-value><![CDATA[");
		sb.append(getReplyDocument());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _complaintId;
	private String _complaintNumber;
	private Date _signingDate;
	private String _complaintName;
	private String _complaintDesc;
	private String _complaintContent;
	private String _replyDocument;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _complaintsRemoteModel;
}