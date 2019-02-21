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

import com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class PropositionClp extends BaseModelImpl<Proposition>
	implements Proposition {
	public PropositionClp() {
	}

	public Class<?> getModelClass() {
		return Proposition.class;
	}

	public String getModelClassName() {
		return Proposition.class.getName();
	}

	public long getPrimaryKey() {
		return _propositionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPropositionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_propositionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getPropositionId() {
		return _propositionId;
	}

	public void setPropositionId(long propositionId) {
		_propositionId = propositionId;
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getCompilationDepartmentId() {
		return _compilationDepartmentId;
	}

	public void setCompilationDepartmentId(long compilationDepartmentId) {
		_compilationDepartmentId = compilationDepartmentId;
	}

	public long getVerificationDepartmentId() {
		return _verificationDepartmentId;
	}

	public void setVerificationDepartmentId(long verificationDepartmentId) {
		_verificationDepartmentId = verificationDepartmentId;
	}

	public String getPropositionName() {
		return _propositionName;
	}

	public void setPropositionName(String propositionName) {
		_propositionName = propositionName;
	}

	public String getPropositionDesc() {
		return _propositionDesc;
	}

	public void setPropositionDesc(String propositionDesc) {
		_propositionDesc = propositionDesc;
	}

	public String getPropositionContent() {
		return _propositionContent;
	}

	public void setPropositionContent(String propositionContent) {
		_propositionContent = propositionContent;
	}

	public long getDocumentFileId() {
		return _documentFileId;
	}

	public void setDocumentFileId(long documentFileId) {
		_documentFileId = documentFileId;
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

	public int getViewCount() {
		return _viewCount;
	}

	public void setViewCount(int viewCount) {
		_viewCount = viewCount;
	}

	public int getFeedbackCount() {
		return _feedbackCount;
	}

	public void setFeedbackCount(int feedbackCount) {
		_feedbackCount = feedbackCount;
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

	public BaseModel<?> getPropositionRemoteModel() {
		return _propositionRemoteModel;
	}

	public void setPropositionRemoteModel(BaseModel<?> propositionRemoteModel) {
		_propositionRemoteModel = propositionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PropositionLocalServiceUtil.addProposition(this);
		}
		else {
			PropositionLocalServiceUtil.updateProposition(this);
		}
	}

	@Override
	public Proposition toEscapedModel() {
		return (Proposition)Proxy.newProxyInstance(Proposition.class.getClassLoader(),
			new Class[] { Proposition.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PropositionClp clone = new PropositionClp();

		clone.setPropositionId(getPropositionId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCategoryId(getCategoryId());
		clone.setCompilationDepartmentId(getCompilationDepartmentId());
		clone.setVerificationDepartmentId(getVerificationDepartmentId());
		clone.setPropositionName(getPropositionName());
		clone.setPropositionDesc(getPropositionDesc());
		clone.setPropositionContent(getPropositionContent());
		clone.setDocumentFileId(getDocumentFileId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setViewCount(getViewCount());
		clone.setFeedbackCount(getFeedbackCount());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusDate(getStatusDate());

		return clone;
	}

	public int compareTo(Proposition proposition) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), proposition.getCreateDate());

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

		PropositionClp proposition = null;

		try {
			proposition = (PropositionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = proposition.getPrimaryKey();

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

		sb.append("{propositionId=");
		sb.append(getPropositionId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", compilationDepartmentId=");
		sb.append(getCompilationDepartmentId());
		sb.append(", verificationDepartmentId=");
		sb.append(getVerificationDepartmentId());
		sb.append(", propositionName=");
		sb.append(getPropositionName());
		sb.append(", propositionDesc=");
		sb.append(getPropositionDesc());
		sb.append(", propositionContent=");
		sb.append(getPropositionContent());
		sb.append(", documentFileId=");
		sb.append(getDocumentFileId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append(", feedbackCount=");
		sb.append(getFeedbackCount());
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
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append(
			"com.portal_egov.portlet.proposition_feedback.model.Proposition");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>propositionId</column-name><column-value><![CDATA[");
		sb.append(getPropositionId());
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
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>compilationDepartmentId</column-name><column-value><![CDATA[");
		sb.append(getCompilationDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>verificationDepartmentId</column-name><column-value><![CDATA[");
		sb.append(getVerificationDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>propositionName</column-name><column-value><![CDATA[");
		sb.append(getPropositionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>propositionDesc</column-name><column-value><![CDATA[");
		sb.append(getPropositionDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>propositionContent</column-name><column-value><![CDATA[");
		sb.append(getPropositionContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentFileId</column-name><column-value><![CDATA[");
		sb.append(getDocumentFileId());
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
			"<column><column-name>viewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedbackCount</column-name><column-value><![CDATA[");
		sb.append(getFeedbackCount());
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

	private long _propositionId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _categoryId;
	private long _compilationDepartmentId;
	private long _verificationDepartmentId;
	private String _propositionName;
	private String _propositionDesc;
	private String _propositionContent;
	private long _documentFileId;
	private Date _createDate;
	private Date _modifiedDate;
	private int _viewCount;
	private int _feedbackCount;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private Date _statusDate;
	private BaseModel<?> _propositionRemoteModel;
}