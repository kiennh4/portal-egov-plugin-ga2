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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.visit_counter.service.http.VisitCounterLogServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.visit_counter.service.http.VisitCounterLogServiceSoap
 * @generated
 */
public class VisitCounterLogSoap implements Serializable {
	public static VisitCounterLogSoap toSoapModel(VisitCounterLog model) {
		VisitCounterLogSoap soapModel = new VisitCounterLogSoap();

		soapModel.setVisitorIp(model.getVisitorIp());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setHitCounter(model.getHitCounter());
		soapModel.setLastAccessPageId(model.getLastAccessPageId());
		soapModel.setLastAccessDate(model.getLastAccessDate());

		return soapModel;
	}

	public static VisitCounterLogSoap[] toSoapModels(VisitCounterLog[] models) {
		VisitCounterLogSoap[] soapModels = new VisitCounterLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VisitCounterLogSoap[][] toSoapModels(
		VisitCounterLog[][] models) {
		VisitCounterLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VisitCounterLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VisitCounterLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VisitCounterLogSoap[] toSoapModels(
		List<VisitCounterLog> models) {
		List<VisitCounterLogSoap> soapModels = new ArrayList<VisitCounterLogSoap>(models.size());

		for (VisitCounterLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VisitCounterLogSoap[soapModels.size()]);
	}

	public VisitCounterLogSoap() {
	}

	public String getPrimaryKey() {
		return _visitorIp;
	}

	public void setPrimaryKey(String pk) {
		setVisitorIp(pk);
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

	private String _visitorIp;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _hitCounter;
	private long _lastAccessPageId;
	private Date _lastAccessDate;
}