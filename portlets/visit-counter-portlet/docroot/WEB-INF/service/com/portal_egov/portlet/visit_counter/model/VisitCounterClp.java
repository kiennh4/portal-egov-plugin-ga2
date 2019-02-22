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

import com.portal_egov.portlet.visit_counter.service.VisitCounterLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class VisitCounterClp extends BaseModelImpl<VisitCounter>
	implements VisitCounter {
	public VisitCounterClp() {
	}

	public Class<?> getModelClass() {
		return VisitCounter.class;
	}

	public String getModelClassName() {
		return VisitCounter.class.getName();
	}

	public long getPrimaryKey() {
		return _counterId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCounterId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_counterId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("counterId", getCounterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("totalHitCounter", getTotalHitCounter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long counterId = (Long)attributes.get("counterId");

		if (counterId != null) {
			setCounterId(counterId);
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

		Integer totalHitCounter = (Integer)attributes.get("totalHitCounter");

		if (totalHitCounter != null) {
			setTotalHitCounter(totalHitCounter);
		}
	}

	public long getCounterId() {
		return _counterId;
	}

	public void setCounterId(long counterId) {
		_counterId = counterId;
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

	public int getTotalHitCounter() {
		return _totalHitCounter;
	}

	public void setTotalHitCounter(int totalHitCounter) {
		_totalHitCounter = totalHitCounter;
	}

	public BaseModel<?> getVisitCounterRemoteModel() {
		return _visitCounterRemoteModel;
	}

	public void setVisitCounterRemoteModel(BaseModel<?> visitCounterRemoteModel) {
		_visitCounterRemoteModel = visitCounterRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VisitCounterLocalServiceUtil.addVisitCounter(this);
		}
		else {
			VisitCounterLocalServiceUtil.updateVisitCounter(this);
		}
	}

	@Override
	public VisitCounter toEscapedModel() {
		return (VisitCounter)Proxy.newProxyInstance(VisitCounter.class.getClassLoader(),
			new Class[] { VisitCounter.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VisitCounterClp clone = new VisitCounterClp();

		clone.setCounterId(getCounterId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTotalHitCounter(getTotalHitCounter());

		return clone;
	}

	public int compareTo(VisitCounter visitCounter) {
		int value = 0;

		if (getTotalHitCounter() < visitCounter.getTotalHitCounter()) {
			value = -1;
		}
		else if (getTotalHitCounter() > visitCounter.getTotalHitCounter()) {
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

		VisitCounterClp visitCounter = null;

		try {
			visitCounter = (VisitCounterClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = visitCounter.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{counterId=");
		sb.append(getCounterId());
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
		sb.append(", totalHitCounter=");
		sb.append(getTotalHitCounter());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.visit_counter.model.VisitCounter");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>counterId</column-name><column-value><![CDATA[");
		sb.append(getCounterId());
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
			"<column><column-name>totalHitCounter</column-name><column-value><![CDATA[");
		sb.append(getTotalHitCounter());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _counterId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _totalHitCounter;
	private BaseModel<?> _visitCounterRemoteModel;
}