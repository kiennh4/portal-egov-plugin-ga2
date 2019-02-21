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

package com.portal_egov.portlet.vbpq.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class VBPQ_EntryClp extends BaseModelImpl<VBPQ_Entry>
	implements VBPQ_Entry {
	public VBPQ_EntryClp() {
	}

	public Class<?> getModelClass() {
		return VBPQ_Entry.class;
	}

	public String getModelClassName() {
		return VBPQ_Entry.class.getName();
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
		attributes.put("departmentId", getDepartmentId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("docTypeId", getDocTypeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("entryName", getEntryName());
		attributes.put("entryCode", getEntryCode());
		attributes.put("entryDesc", getEntryDesc());
		attributes.put("fileAttachmentURL", getFileAttachmentURL());
		attributes.put("publicatorName", getPublicatorName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("publishDate", getPublishDate());
		attributes.put("executeDate", getExecuteDate());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("neverExpired", getNeverExpired());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long docTypeId = (Long)attributes.get("docTypeId");

		if (docTypeId != null) {
			setDocTypeId(docTypeId);
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

		String entryName = (String)attributes.get("entryName");

		if (entryName != null) {
			setEntryName(entryName);
		}

		String entryCode = (String)attributes.get("entryCode");

		if (entryCode != null) {
			setEntryCode(entryCode);
		}

		String entryDesc = (String)attributes.get("entryDesc");

		if (entryDesc != null) {
			setEntryDesc(entryDesc);
		}

		String fileAttachmentURL = (String)attributes.get("fileAttachmentURL");

		if (fileAttachmentURL != null) {
			setFileAttachmentURL(fileAttachmentURL);
		}

		String publicatorName = (String)attributes.get("publicatorName");

		if (publicatorName != null) {
			setPublicatorName(publicatorName);
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

		Date executeDate = (Date)attributes.get("executeDate");

		if (executeDate != null) {
			setExecuteDate(executeDate);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}

		Boolean neverExpired = (Boolean)attributes.get("neverExpired");

		if (neverExpired != null) {
			setNeverExpired(neverExpired);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getDocTypeId() {
		return _docTypeId;
	}

	public void setDocTypeId(long docTypeId) {
		_docTypeId = docTypeId;
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

	public String getEntryName() {
		return _entryName;
	}

	public void setEntryName(String entryName) {
		_entryName = entryName;
	}

	public String getEntryCode() {
		return _entryCode;
	}

	public void setEntryCode(String entryCode) {
		_entryCode = entryCode;
	}

	public String getEntryDesc() {
		return _entryDesc;
	}

	public void setEntryDesc(String entryDesc) {
		_entryDesc = entryDesc;
	}

	public String getFileAttachmentURL() {
		return _fileAttachmentURL;
	}

	public void setFileAttachmentURL(String fileAttachmentURL) {
		_fileAttachmentURL = fileAttachmentURL;
	}

	public String getPublicatorName() {
		return _publicatorName;
	}

	public void setPublicatorName(String publicatorName) {
		_publicatorName = publicatorName;
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

	public Date getExecuteDate() {
		return _executeDate;
	}

	public void setExecuteDate(Date executeDate) {
		_executeDate = executeDate;
	}

	public Date getExpirationDate() {
		return _expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;
	}

	public boolean getNeverExpired() {
		return _neverExpired;
	}

	public boolean isNeverExpired() {
		return _neverExpired;
	}

	public void setNeverExpired(boolean neverExpired) {
		_neverExpired = neverExpired;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public BaseModel<?> getVBPQ_EntryRemoteModel() {
		return _vbpq_EntryRemoteModel;
	}

	public void setVBPQ_EntryRemoteModel(BaseModel<?> vbpq_EntryRemoteModel) {
		_vbpq_EntryRemoteModel = vbpq_EntryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VBPQ_EntryLocalServiceUtil.addVBPQ_Entry(this);
		}
		else {
			VBPQ_EntryLocalServiceUtil.updateVBPQ_Entry(this);
		}
	}

	@Override
	public VBPQ_Entry toEscapedModel() {
		return (VBPQ_Entry)Proxy.newProxyInstance(VBPQ_Entry.class.getClassLoader(),
			new Class[] { VBPQ_Entry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VBPQ_EntryClp clone = new VBPQ_EntryClp();

		clone.setEntryId(getEntryId());
		clone.setDepartmentId(getDepartmentId());
		clone.setCategoryId(getCategoryId());
		clone.setDocTypeId(getDocTypeId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setEntryName(getEntryName());
		clone.setEntryCode(getEntryCode());
		clone.setEntryDesc(getEntryDesc());
		clone.setFileAttachmentURL(getFileAttachmentURL());
		clone.setPublicatorName(getPublicatorName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setPublishDate(getPublishDate());
		clone.setExecuteDate(getExecuteDate());
		clone.setExpirationDate(getExpirationDate());
		clone.setNeverExpired(getNeverExpired());
		clone.setActive(getActive());

		return clone;
	}

	public int compareTo(VBPQ_Entry vbpq_Entry) {
		int value = 0;

		value = DateUtil.compareTo(getPublishDate(), vbpq_Entry.getPublishDate());

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

		VBPQ_EntryClp vbpq_Entry = null;

		try {
			vbpq_Entry = (VBPQ_EntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = vbpq_Entry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(41);

		sb.append("{entryId=");
		sb.append(getEntryId());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", docTypeId=");
		sb.append(getDocTypeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", entryName=");
		sb.append(getEntryName());
		sb.append(", entryCode=");
		sb.append(getEntryCode());
		sb.append(", entryDesc=");
		sb.append(getEntryDesc());
		sb.append(", fileAttachmentURL=");
		sb.append(getFileAttachmentURL());
		sb.append(", publicatorName=");
		sb.append(getPublicatorName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", publishDate=");
		sb.append(getPublishDate());
		sb.append(", executeDate=");
		sb.append(getExecuteDate());
		sb.append(", expirationDate=");
		sb.append(getExpirationDate());
		sb.append(", neverExpired=");
		sb.append(getNeverExpired());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.vbpq.model.VBPQ_Entry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entryId</column-name><column-value><![CDATA[");
		sb.append(getEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>docTypeId</column-name><column-value><![CDATA[");
		sb.append(getDocTypeId());
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
			"<column><column-name>entryName</column-name><column-value><![CDATA[");
		sb.append(getEntryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entryCode</column-name><column-value><![CDATA[");
		sb.append(getEntryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entryDesc</column-name><column-value><![CDATA[");
		sb.append(getEntryDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileAttachmentURL</column-name><column-value><![CDATA[");
		sb.append(getFileAttachmentURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publicatorName</column-name><column-value><![CDATA[");
		sb.append(getPublicatorName());
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
			"<column><column-name>executeDate</column-name><column-value><![CDATA[");
		sb.append(getExecuteDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expirationDate</column-name><column-value><![CDATA[");
		sb.append(getExpirationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>neverExpired</column-name><column-value><![CDATA[");
		sb.append(getNeverExpired());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _entryId;
	private long _departmentId;
	private long _categoryId;
	private long _docTypeId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private String _entryName;
	private String _entryCode;
	private String _entryDesc;
	private String _fileAttachmentURL;
	private String _publicatorName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _publishDate;
	private Date _executeDate;
	private Date _expirationDate;
	private boolean _neverExpired;
	private boolean _active;
	private BaseModel<?> _vbpq_EntryRemoteModel;
}