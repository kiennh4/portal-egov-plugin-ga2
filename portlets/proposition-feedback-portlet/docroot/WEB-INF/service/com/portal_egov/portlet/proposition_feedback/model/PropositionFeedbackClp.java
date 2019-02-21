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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class PropositionFeedbackClp extends BaseModelImpl<PropositionFeedback>
	implements PropositionFeedback {
	public PropositionFeedbackClp() {
	}

	public Class<?> getModelClass() {
		return PropositionFeedback.class;
	}

	public String getModelClassName() {
		return PropositionFeedback.class.getName();
	}

	public long getPrimaryKey() {
		return _feedbackId;
	}

	public void setPrimaryKey(long primaryKey) {
		setFeedbackId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_feedbackId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getFeedbackId() {
		return _feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		_feedbackId = feedbackId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public long getPropositionId() {
		return _propositionId;
	}

	public void setPropositionId(long propositionId) {
		_propositionId = propositionId;
	}

	public long getFeedbackFileAttId() {
		return _feedbackFileAttId;
	}

	public void setFeedbackFileAttId(long feedbackFileAttId) {
		_feedbackFileAttId = feedbackFileAttId;
	}

	public String getFeedbackTitle() {
		return _feedbackTitle;
	}

	public void setFeedbackTitle(String feedbackTitle) {
		_feedbackTitle = feedbackTitle;
	}

	public String getFeedbackContent() {
		return _feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		_feedbackContent = feedbackContent;
	}

	public String getCitizenName() {
		return _citizenName;
	}

	public void setCitizenName(String citizenName) {
		_citizenName = citizenName;
	}

	public String getCitizenEmail() {
		return _citizenEmail;
	}

	public void setCitizenEmail(String citizenEmail) {
		_citizenEmail = citizenEmail;
	}

	public String getCitizenPhone() {
		return _citizenPhone;
	}

	public void setCitizenPhone(String citizenPhone) {
		_citizenPhone = citizenPhone;
	}

	public String getCitizenAddress() {
		return _citizenAddress;
	}

	public void setCitizenAddress(String citizenAddress) {
		_citizenAddress = citizenAddress;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public BaseModel<?> getPropositionFeedbackRemoteModel() {
		return _propositionFeedbackRemoteModel;
	}

	public void setPropositionFeedbackRemoteModel(
		BaseModel<?> propositionFeedbackRemoteModel) {
		_propositionFeedbackRemoteModel = propositionFeedbackRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PropositionFeedbackLocalServiceUtil.addPropositionFeedback(this);
		}
		else {
			PropositionFeedbackLocalServiceUtil.updatePropositionFeedback(this);
		}
	}

	@Override
	public PropositionFeedback toEscapedModel() {
		return (PropositionFeedback)Proxy.newProxyInstance(PropositionFeedback.class.getClassLoader(),
			new Class[] { PropositionFeedback.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PropositionFeedbackClp clone = new PropositionFeedbackClp();

		clone.setFeedbackId(getFeedbackId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setPropositionId(getPropositionId());
		clone.setFeedbackFileAttId(getFeedbackFileAttId());
		clone.setFeedbackTitle(getFeedbackTitle());
		clone.setFeedbackContent(getFeedbackContent());
		clone.setCitizenName(getCitizenName());
		clone.setCitizenEmail(getCitizenEmail());
		clone.setCitizenPhone(getCitizenPhone());
		clone.setCitizenAddress(getCitizenAddress());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusDate(getStatusDate());

		return clone;
	}

	public int compareTo(PropositionFeedback propositionFeedback) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				propositionFeedback.getCreateDate());

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

		PropositionFeedbackClp propositionFeedback = null;

		try {
			propositionFeedback = (PropositionFeedbackClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = propositionFeedback.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{feedbackId=");
		sb.append(getFeedbackId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", propositionId=");
		sb.append(getPropositionId());
		sb.append(", feedbackFileAttId=");
		sb.append(getFeedbackFileAttId());
		sb.append(", feedbackTitle=");
		sb.append(getFeedbackTitle());
		sb.append(", feedbackContent=");
		sb.append(getFeedbackContent());
		sb.append(", citizenName=");
		sb.append(getCitizenName());
		sb.append(", citizenEmail=");
		sb.append(getCitizenEmail());
		sb.append(", citizenPhone=");
		sb.append(getCitizenPhone());
		sb.append(", citizenAddress=");
		sb.append(getCitizenAddress());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append(
			"com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>feedbackId</column-name><column-value><![CDATA[");
		sb.append(getFeedbackId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>propositionId</column-name><column-value><![CDATA[");
		sb.append(getPropositionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedbackFileAttId</column-name><column-value><![CDATA[");
		sb.append(getFeedbackFileAttId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedbackTitle</column-name><column-value><![CDATA[");
		sb.append(getFeedbackTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedbackContent</column-name><column-value><![CDATA[");
		sb.append(getFeedbackContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenName</column-name><column-value><![CDATA[");
		sb.append(getCitizenName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenEmail</column-name><column-value><![CDATA[");
		sb.append(getCitizenEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenPhone</column-name><column-value><![CDATA[");
		sb.append(getCitizenPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenAddress</column-name><column-value><![CDATA[");
		sb.append(getCitizenAddress());
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
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _feedbackId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private long _propositionId;
	private long _feedbackFileAttId;
	private String _feedbackTitle;
	private String _feedbackContent;
	private String _citizenName;
	private String _citizenEmail;
	private String _citizenPhone;
	private String _citizenAddress;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private Date _statusDate;
	private BaseModel<?> _propositionFeedbackRemoteModel;
}