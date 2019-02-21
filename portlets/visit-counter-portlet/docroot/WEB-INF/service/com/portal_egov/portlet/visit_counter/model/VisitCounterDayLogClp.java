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

import com.portal_egov.portlet.visit_counter.service.VisitCounterDayLogLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class VisitCounterDayLogClp extends BaseModelImpl<VisitCounterDayLog>
	implements VisitCounterDayLog {
	public VisitCounterDayLogClp() {
	}

	public Class<?> getModelClass() {
		return VisitCounterDayLog.class;
	}

	public String getModelClassName() {
		return VisitCounterDayLog.class.getName();
	}

	public String getPrimaryKey() {
		return _daylogId;
	}

	public void setPrimaryKey(String primaryKey) {
		setDaylogId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _daylogId;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("daylogId", getDaylogId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("hitCounter", getHitCounter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String daylogId = (String)attributes.get("daylogId");

		if (daylogId != null) {
			setDaylogId(daylogId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer hitCounter = (Integer)attributes.get("hitCounter");

		if (hitCounter != null) {
			setHitCounter(hitCounter);
		}
	}

	public String getDaylogId() {
		return _daylogId;
	}

	public void setDaylogId(String daylogId) {
		_daylogId = daylogId;
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

	public int getHitCounter() {
		return _hitCounter;
	}

	public void setHitCounter(int hitCounter) {
		_hitCounter = hitCounter;
	}

	public BaseModel<?> getVisitCounterDayLogRemoteModel() {
		return _visitCounterDayLogRemoteModel;
	}

	public void setVisitCounterDayLogRemoteModel(
		BaseModel<?> visitCounterDayLogRemoteModel) {
		_visitCounterDayLogRemoteModel = visitCounterDayLogRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VisitCounterDayLogLocalServiceUtil.addVisitCounterDayLog(this);
		}
		else {
			VisitCounterDayLogLocalServiceUtil.updateVisitCounterDayLog(this);
		}
	}

	@Override
	public VisitCounterDayLog toEscapedModel() {
		return (VisitCounterDayLog)Proxy.newProxyInstance(VisitCounterDayLog.class.getClassLoader(),
			new Class[] { VisitCounterDayLog.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VisitCounterDayLogClp clone = new VisitCounterDayLogClp();

		clone.setDaylogId(getDaylogId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setHitCounter(getHitCounter());

		return clone;
	}

	public int compareTo(VisitCounterDayLog visitCounterDayLog) {
		String primaryKey = visitCounterDayLog.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		VisitCounterDayLogClp visitCounterDayLog = null;

		try {
			visitCounterDayLog = (VisitCounterDayLogClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = visitCounterDayLog.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{daylogId=");
		sb.append(getDaylogId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", hitCounter=");
		sb.append(getHitCounter());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>daylogId</column-name><column-value><![CDATA[");
		sb.append(getDaylogId());
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
			"<column><column-name>hitCounter</column-name><column-value><![CDATA[");
		sb.append(getHitCounter());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _daylogId;
	private long _companyId;
	private long _groupId;
	private int _hitCounter;
	private BaseModel<?> _visitCounterDayLogRemoteModel;
}