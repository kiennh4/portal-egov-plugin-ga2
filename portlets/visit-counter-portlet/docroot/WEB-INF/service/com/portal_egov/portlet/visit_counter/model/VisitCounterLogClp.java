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

package com.portal_egov.portlet.visit_counter.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.visit_counter.service.VisitCounterLogLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class VisitCounterLogClp extends BaseModelImpl<VisitCounterLog>
	implements VisitCounterLog {
	public VisitCounterLogClp() {
	}

	public Class<?> getModelClass() {
		return VisitCounterLog.class;
	}

	public String getModelClassName() {
		return VisitCounterLog.class.getName();
	}

	public String getPrimaryKey() {
		return _visitorIp;
	}

	public void setPrimaryKey(String primaryKey) {
		setVisitorIp(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _visitorIp;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("visitorIp", getVisitorIp());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("hitCounter", getHitCounter());
		attributes.put("lastAccessPageId", getLastAccessPageId());
		attributes.put("lastAccessDate", getLastAccessDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String visitorIp = (String)attributes.get("visitorIp");

		if (visitorIp != null) {
			setVisitorIp(visitorIp);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer hitCounter = (Integer)attributes.get("hitCounter");

		if (hitCounter != null) {
			setHitCounter(hitCounter);
		}

		Long lastAccessPageId = (Long)attributes.get("lastAccessPageId");

		if (lastAccessPageId != null) {
			setLastAccessPageId(lastAccessPageId);
		}

		Date lastAccessDate = (Date)attributes.get("lastAccessDate");

		if (lastAccessDate != null) {
			setLastAccessDate(lastAccessDate);
		}
	}

	public String getVisitorIp() {
		return _visitorIp;
	}

	public void setVisitorIp(String visitorIp) {
		_visitorIp = visitorIp;
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

	public int getHitCounter() {
		return _hitCounter;
	}

	public void setHitCounter(int hitCounter) {
		_hitCounter = hitCounter;
	}

	public long getLastAccessPageId() {
		return _lastAccessPageId;
	}

	public void setLastAccessPageId(long lastAccessPageId) {
		_lastAccessPageId = lastAccessPageId;
	}

	public Date getLastAccessDate() {
		return _lastAccessDate;
	}

	public void setLastAccessDate(Date lastAccessDate) {
		_lastAccessDate = lastAccessDate;
	}

	public BaseModel<?> getVisitCounterLogRemoteModel() {
		return _visitCounterLogRemoteModel;
	}

	public void setVisitCounterLogRemoteModel(
		BaseModel<?> visitCounterLogRemoteModel) {
		_visitCounterLogRemoteModel = visitCounterLogRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VisitCounterLogLocalServiceUtil.addVisitCounterLog(this);
		}
		else {
			VisitCounterLogLocalServiceUtil.updateVisitCounterLog(this);
		}
	}

	@Override
	public VisitCounterLog toEscapedModel() {
		return (VisitCounterLog)Proxy.newProxyInstance(VisitCounterLog.class.getClassLoader(),
			new Class[] { VisitCounterLog.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VisitCounterLogClp clone = new VisitCounterLogClp();

		clone.setVisitorIp(getVisitorIp());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setHitCounter(getHitCounter());
		clone.setLastAccessPageId(getLastAccessPageId());
		clone.setLastAccessDate(getLastAccessDate());

		return clone;
	}

	public int compareTo(VisitCounterLog visitCounterLog) {
		int value = 0;

		if (getHitCounter() < visitCounterLog.getHitCounter()) {
			value = -1;
		}
		else if (getHitCounter() > visitCounterLog.getHitCounter()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		VisitCounterLogClp visitCounterLog = null;

		try {
			visitCounterLog = (VisitCounterLogClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = visitCounterLog.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{visitorIp=");
		sb.append(getVisitorIp());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", hitCounter=");
		sb.append(getHitCounter());
		sb.append(", lastAccessPageId=");
		sb.append(getLastAccessPageId());
		sb.append(", lastAccessDate=");
		sb.append(getLastAccessDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.visit_counter.model.VisitCounterLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>visitorIp</column-name><column-value><![CDATA[");
		sb.append(getVisitorIp());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hitCounter</column-name><column-value><![CDATA[");
		sb.append(getHitCounter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastAccessPageId</column-name><column-value><![CDATA[");
		sb.append(getLastAccessPageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastAccessDate</column-name><column-value><![CDATA[");
		sb.append(getLastAccessDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _visitorIp;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _hitCounter;
	private long _lastAccessPageId;
	private Date _lastAccessDate;
	private BaseModel<?> _visitCounterLogRemoteModel;
}