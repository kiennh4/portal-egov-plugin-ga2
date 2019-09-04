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

package com.portal_egov.portlet.legal_faq.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class LegalFAQEntryClp extends BaseModelImpl<LegalFAQEntry>
	implements LegalFAQEntry {
	public LegalFAQEntryClp() {
	}

	public Class<?> getModelClass() {
		return LegalFAQEntry.class;
	}

	public String getModelClassName() {
		return LegalFAQEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEntryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_entryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("categoryId", getCategoryId());
		attributes.put("citizenName", getCitizenName());
		attributes.put("citizenPhone", getCitizenPhone());
		attributes.put("citizenEmail", getCitizenEmail());
		attributes.put("citizenAddress", getCitizenAddress());
		attributes.put("askDate", getAskDate());
		attributes.put("askTitle", getAskTitle());
		attributes.put("askContent", getAskContent());
		attributes.put("answerDate", getAnswerDate());
		attributes.put("answerContent", getAnswerContent());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("publishDate", getPublishDate());
		attributes.put("attachmentId", getAttachmentId());
		attributes.put("viewCount", getViewCount());
		attributes.put("publishStatus", getPublishStatus());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
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

		Date askDate = (Date)attributes.get("askDate");

		if (askDate != null) {
			setAskDate(askDate);
		}

		String askTitle = (String)attributes.get("askTitle");

		if (askTitle != null) {
			setAskTitle(askTitle);
		}

		String askContent = (String)attributes.get("askContent");

		if (askContent != null) {
			setAskContent(askContent);
		}

		Date answerDate = (Date)attributes.get("answerDate");

		if (answerDate != null) {
			setAnswerDate(answerDate);
		}

		String answerContent = (String)attributes.get("answerContent");

		if (answerContent != null) {
			setAnswerContent(answerContent);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date publishDate = (Date)attributes.get("publishDate");

		if (publishDate != null) {
			setPublishDate(publishDate);
		}

		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}

		Integer publishStatus = (Integer)attributes.get("publishStatus");

		if (publishStatus != null) {
			setPublishStatus(publishStatus);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
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

	public Date getAskDate() {
		return _askDate;
	}

	public void setAskDate(Date askDate) {
		_askDate = askDate;
	}

	public String getAskTitle() {
		return _askTitle;
	}

	public void setAskTitle(String askTitle) {
		_askTitle = askTitle;
	}

	public String getAskContent() {
		return _askContent;
	}

	public void setAskContent(String askContent) {
		_askContent = askContent;
	}

	public Date getAnswerDate() {
		return _answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		_answerDate = answerDate;
	}

	public String getAnswerContent() {
		return _answerContent;
	}

	public void setAnswerContent(String answerContent) {
		_answerContent = answerContent;
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

	public Date getPublishDate() {
		return _publishDate;
	}

	public void setPublishDate(Date publishDate) {
		_publishDate = publishDate;
	}

	public long getAttachmentId() {
		return _attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;
	}

	public int getViewCount() {
		return _viewCount;
	}

	public void setViewCount(int viewCount) {
		_viewCount = viewCount;
	}

	public int getPublishStatus() {
		return _publishStatus;
	}

	public void setPublishStatus(int publishStatus) {
		_publishStatus = publishStatus;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public BaseModel<?> getLegalFAQEntryRemoteModel() {
		return _legalFAQEntryRemoteModel;
	}

	public void setLegalFAQEntryRemoteModel(
		BaseModel<?> legalFAQEntryRemoteModel) {
		_legalFAQEntryRemoteModel = legalFAQEntryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LegalFAQEntryLocalServiceUtil.addLegalFAQEntry(this);
		}
		else {
			LegalFAQEntryLocalServiceUtil.updateLegalFAQEntry(this);
		}
	}

	@Override
	public LegalFAQEntry toEscapedModel() {
		return (LegalFAQEntry)Proxy.newProxyInstance(LegalFAQEntry.class.getClassLoader(),
			new Class[] { LegalFAQEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegalFAQEntryClp clone = new LegalFAQEntryClp();

		clone.setEntryId(getEntryId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCategoryId(getCategoryId());
		clone.setCitizenName(getCitizenName());
		clone.setCitizenPhone(getCitizenPhone());
		clone.setCitizenEmail(getCitizenEmail());
		clone.setCitizenAddress(getCitizenAddress());
		clone.setAskDate(getAskDate());
		clone.setAskTitle(getAskTitle());
		clone.setAskContent(getAskContent());
		clone.setAnswerDate(getAnswerDate());
		clone.setAnswerContent(getAnswerContent());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setPublishDate(getPublishDate());
		clone.setAttachmentId(getAttachmentId());
		clone.setViewCount(getViewCount());
		clone.setPublishStatus(getPublishStatus());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(LegalFAQEntry legalFAQEntry) {
		int value = 0;

		value = DateUtil.compareTo(getPublishDate(),
				legalFAQEntry.getPublishDate());

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

		LegalFAQEntryClp legalFAQEntry = null;

		try {
			legalFAQEntry = (LegalFAQEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = legalFAQEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(45);

		sb.append("{entryId=");
		sb.append(getEntryId());
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
		sb.append(", citizenName=");
		sb.append(getCitizenName());
		sb.append(", citizenPhone=");
		sb.append(getCitizenPhone());
		sb.append(", citizenEmail=");
		sb.append(getCitizenEmail());
		sb.append(", citizenAddress=");
		sb.append(getCitizenAddress());
		sb.append(", askDate=");
		sb.append(getAskDate());
		sb.append(", askTitle=");
		sb.append(getAskTitle());
		sb.append(", askContent=");
		sb.append(getAskContent());
		sb.append(", answerDate=");
		sb.append(getAnswerDate());
		sb.append(", answerContent=");
		sb.append(getAnswerContent());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", publishDate=");
		sb.append(getPublishDate());
		sb.append(", attachmentId=");
		sb.append(getAttachmentId());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append(", publishStatus=");
		sb.append(getPublishStatus());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.legal_faq.model.LegalFAQEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entryId</column-name><column-value><![CDATA[");
		sb.append(getEntryId());
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
			"<column><column-name>askDate</column-name><column-value><![CDATA[");
		sb.append(getAskDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askTitle</column-name><column-value><![CDATA[");
		sb.append(getAskTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askContent</column-name><column-value><![CDATA[");
		sb.append(getAskContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerDate</column-name><column-value><![CDATA[");
		sb.append(getAnswerDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerContent</column-name><column-value><![CDATA[");
		sb.append(getAnswerContent());
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
			"<column><column-name>publishDate</column-name><column-value><![CDATA[");
		sb.append(getPublishDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachmentId</column-name><column-value><![CDATA[");
		sb.append(getAttachmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishStatus</column-name><column-value><![CDATA[");
		sb.append(getPublishStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _entryId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _categoryId;
	private String _citizenName;
	private String _citizenPhone;
	private String _citizenEmail;
	private String _citizenAddress;
	private Date _askDate;
	private String _askTitle;
	private String _askContent;
	private Date _answerDate;
	private String _answerContent;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _publishDate;
	private long _attachmentId;
	private int _viewCount;
	private int _publishStatus;
	private int _status;
	private BaseModel<?> _legalFAQEntryRemoteModel;
}