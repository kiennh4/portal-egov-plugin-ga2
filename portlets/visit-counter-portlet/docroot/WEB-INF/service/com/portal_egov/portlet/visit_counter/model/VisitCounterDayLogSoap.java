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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.visit_counter.service.http.VisitCounterDayLogServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.visit_counter.service.http.VisitCounterDayLogServiceSoap
 * @generated
 */
public class VisitCounterDayLogSoap implements Serializable {
	public static VisitCounterDayLogSoap toSoapModel(VisitCounterDayLog model) {
		VisitCounterDayLogSoap soapModel = new VisitCounterDayLogSoap();

		soapModel.setDaylogId(model.getDaylogId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setHitCounter(model.getHitCounter());

		return soapModel;
	}

	public static VisitCounterDayLogSoap[] toSoapModels(
		VisitCounterDayLog[] models) {
		VisitCounterDayLogSoap[] soapModels = new VisitCounterDayLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VisitCounterDayLogSoap[][] toSoapModels(
		VisitCounterDayLog[][] models) {
		VisitCounterDayLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VisitCounterDayLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VisitCounterDayLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VisitCounterDayLogSoap[] toSoapModels(
		List<VisitCounterDayLog> models) {
		List<VisitCounterDayLogSoap> soapModels = new ArrayList<VisitCounterDayLogSoap>(models.size());

		for (VisitCounterDayLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VisitCounterDayLogSoap[soapModels.size()]);
	}

	public VisitCounterDayLogSoap() {
	}

	public String getPrimaryKey() {
		return _daylogId;
	}

	public void setPrimaryKey(String pk) {
		setDaylogId(pk);
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

	private String _daylogId;
	private long _companyId;
	private long _groupId;
	private int _hitCounter;
}