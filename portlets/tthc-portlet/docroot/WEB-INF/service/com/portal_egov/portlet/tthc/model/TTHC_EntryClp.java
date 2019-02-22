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

package com.portal_egov.portlet.tthc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class TTHC_EntryClp extends BaseModelImpl<TTHC_Entry>
	implements TTHC_Entry {
	public TTHC_EntryClp() {
	}

	public Class<?> getModelClass() {
		return TTHC_Entry.class;
	}

	public String getModelClassName() {
		return TTHC_Entry.class.getName();
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
		attributes.put("levelId", getLevelId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("audienceId", getAudienceId());
		attributes.put("resultTypeId", getResultTypeId());
		attributes.put("entryCode", getEntryCode());
		attributes.put("entryName", getEntryName());
		attributes.put("entryDesc", getEntryDesc());
		attributes.put("processGuide", getProcessGuide());
		attributes.put("processType", getProcessType());
		attributes.put("processTime", getProcessTime());
		attributes.put("processFee", getProcessFee());
		attributes.put("processRequirement", getProcessRequirement());
		attributes.put("processFoundationDocument",
			getProcessFoundationDocument());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

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

		Long levelId = (Long)attributes.get("levelId");

		if (levelId != null) {
			setLevelId(levelId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long audienceId = (Long)attributes.get("audienceId");

		if (audienceId != null) {
			setAudienceId(audienceId);
		}

		Long resultTypeId = (Long)attributes.get("resultTypeId");

		if (resultTypeId != null) {
			setResultTypeId(resultTypeId);
		}

		String entryCode = (String)attributes.get("entryCode");

		if (entryCode != null) {
			setEntryCode(entryCode);
		}

		String entryName = (String)attributes.get("entryName");

		if (entryName != null) {
			setEntryName(entryName);
		}

		String entryDesc = (String)attributes.get("entryDesc");

		if (entryDesc != null) {
			setEntryDesc(entryDesc);
		}

		String processGuide = (String)attributes.get("processGuide");

		if (processGuide != null) {
			setProcessGuide(processGuide);
		}

		String processType = (String)attributes.get("processType");

		if (processType != null) {
			setProcessType(processType);
		}

		String processTime = (String)attributes.get("processTime");

		if (processTime != null) {
			setProcessTime(processTime);
		}

		String processFee = (String)attributes.get("processFee");

		if (processFee != null) {
			setProcessFee(processFee);
		}

		String processRequirement = (String)attributes.get("processRequirement");

		if (processRequirement != null) {
			setProcessRequirement(processRequirement);
		}

		String processFoundationDocument = (String)attributes.get(
				"processFoundationDocument");

		if (processFoundationDocument != null) {
			setProcessFoundationDocument(processFoundationDocument);
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

	public long getLevelId() {
		return _levelId;
	}

	public void setLevelId(long levelId) {
		_levelId = levelId;
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

	public long getAudienceId() {
		return _audienceId;
	}

	public void setAudienceId(long audienceId) {
		_audienceId = audienceId;
	}

	public long getResultTypeId() {
		return _resultTypeId;
	}

	public void setResultTypeId(long resultTypeId) {
		_resultTypeId = resultTypeId;
	}

	public String getEntryCode() {
		return _entryCode;
	}

	public void setEntryCode(String entryCode) {
		_entryCode = entryCode;
	}

	public String getEntryName() {
		return _entryName;
	}

	public void setEntryName(String entryName) {
		_entryName = entryName;
	}

	public String getEntryDesc() {
		return _entryDesc;
	}

	public void setEntryDesc(String entryDesc) {
		_entryDesc = entryDesc;
	}

	public String getProcessGuide() {
		return _processGuide;
	}

	public void setProcessGuide(String processGuide) {
		_processGuide = processGuide;
	}

	public String getProcessType() {
		return _processType;
	}

	public void setProcessType(String processType) {
		_processType = processType;
	}

	public String getProcessTime() {
		return _processTime;
	}

	public void setProcessTime(String processTime) {
		_processTime = processTime;
	}

	public String getProcessFee() {
		return _processFee;
	}

	public void setProcessFee(String processFee) {
		_processFee = processFee;
	}

	public String getProcessRequirement() {
		return _processRequirement;
	}

	public void setProcessRequirement(String processRequirement) {
		_processRequirement = processRequirement;
	}

	public String getProcessFoundationDocument() {
		return _processFoundationDocument;
	}

	public void setProcessFoundationDocument(String processFoundationDocument) {
		_processFoundationDocument = processFoundationDocument;
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

	public BaseModel<?> getTTHC_EntryRemoteModel() {
		return _tthc_EntryRemoteModel;
	}

	public void setTTHC_EntryRemoteModel(BaseModel<?> tthc_EntryRemoteModel) {
		_tthc_EntryRemoteModel = tthc_EntryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TTHC_EntryLocalServiceUtil.addTTHC_Entry(this);
		}
		else {
			TTHC_EntryLocalServiceUtil.updateTTHC_Entry(this);
		}
	}

	@Override
	public TTHC_Entry toEscapedModel() {
		return (TTHC_Entry)Proxy.newProxyInstance(TTHC_Entry.class.getClassLoader(),
			new Class[] { TTHC_Entry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TTHC_EntryClp clone = new TTHC_EntryClp();

		clone.setEntryId(getEntryId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setLevelId(getLevelId());
		clone.setDepartmentId(getDepartmentId());
		clone.setCategoryId(getCategoryId());
		clone.setAudienceId(getAudienceId());
		clone.setResultTypeId(getResultTypeId());
		clone.setEntryCode(getEntryCode());
		clone.setEntryName(getEntryName());
		clone.setEntryDesc(getEntryDesc());
		clone.setProcessGuide(getProcessGuide());
		clone.setProcessType(getProcessType());
		clone.setProcessTime(getProcessTime());
		clone.setProcessFee(getProcessFee());
		clone.setProcessRequirement(getProcessRequirement());
		clone.setProcessFoundationDocument(getProcessFoundationDocument());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(TTHC_Entry tthc_Entry) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), tthc_Entry.getCreateDate());

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

		TTHC_EntryClp tthc_Entry = null;

		try {
			tthc_Entry = (TTHC_EntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = tthc_Entry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(43);

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
		sb.append(", levelId=");
		sb.append(getLevelId());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", audienceId=");
		sb.append(getAudienceId());
		sb.append(", resultTypeId=");
		sb.append(getResultTypeId());
		sb.append(", entryCode=");
		sb.append(getEntryCode());
		sb.append(", entryName=");
		sb.append(getEntryName());
		sb.append(", entryDesc=");
		sb.append(getEntryDesc());
		sb.append(", processGuide=");
		sb.append(getProcessGuide());
		sb.append(", processType=");
		sb.append(getProcessType());
		sb.append(", processTime=");
		sb.append(getProcessTime());
		sb.append(", processFee=");
		sb.append(getProcessFee());
		sb.append(", processRequirement=");
		sb.append(getProcessRequirement());
		sb.append(", processFoundationDocument=");
		sb.append(getProcessFoundationDocument());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.tthc.model.TTHC_Entry");
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
			"<column><column-name>levelId</column-name><column-value><![CDATA[");
		sb.append(getLevelId());
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
			"<column><column-name>audienceId</column-name><column-value><![CDATA[");
		sb.append(getAudienceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resultTypeId</column-name><column-value><![CDATA[");
		sb.append(getResultTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entryCode</column-name><column-value><![CDATA[");
		sb.append(getEntryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entryName</column-name><column-value><![CDATA[");
		sb.append(getEntryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entryDesc</column-name><column-value><![CDATA[");
		sb.append(getEntryDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processGuide</column-name><column-value><![CDATA[");
		sb.append(getProcessGuide());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processType</column-name><column-value><![CDATA[");
		sb.append(getProcessType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processTime</column-name><column-value><![CDATA[");
		sb.append(getProcessTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processFee</column-name><column-value><![CDATA[");
		sb.append(getProcessFee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processRequirement</column-name><column-value><![CDATA[");
		sb.append(getProcessRequirement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processFoundationDocument</column-name><column-value><![CDATA[");
		sb.append(getProcessFoundationDocument());
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

	private long _entryId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _levelId;
	private long _departmentId;
	private long _categoryId;
	private long _audienceId;
	private long _resultTypeId;
	private String _entryCode;
	private String _entryName;
	private String _entryDesc;
	private String _processGuide;
	private String _processType;
	private String _processTime;
	private String _processFee;
	private String _processRequirement;
	private String _processFoundationDocument;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _tthc_EntryRemoteModel;
}