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

package com.portal_egov.portlet.tourism_map.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.tourism_map.service.http.TourismMapMarkerGroupServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.tourism_map.service.http.TourismMapMarkerGroupServiceSoap
 * @generated
 */
public class TourismMapMarkerGroupSoap implements Serializable {
	public static TourismMapMarkerGroupSoap toSoapModel(
		TourismMapMarkerGroup model) {
		TourismMapMarkerGroupSoap soapModel = new TourismMapMarkerGroupSoap();

		soapModel.setMarkerGroupId(model.getMarkerGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMarkerGroupName(model.getMarkerGroupName());
		soapModel.setMarkerGroupInfo(model.getMarkerGroupInfo());

		return soapModel;
	}

	public static TourismMapMarkerGroupSoap[] toSoapModels(
		TourismMapMarkerGroup[] models) {
		TourismMapMarkerGroupSoap[] soapModels = new TourismMapMarkerGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TourismMapMarkerGroupSoap[][] toSoapModels(
		TourismMapMarkerGroup[][] models) {
		TourismMapMarkerGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TourismMapMarkerGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TourismMapMarkerGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TourismMapMarkerGroupSoap[] toSoapModels(
		List<TourismMapMarkerGroup> models) {
		List<TourismMapMarkerGroupSoap> soapModels = new ArrayList<TourismMapMarkerGroupSoap>(models.size());

		for (TourismMapMarkerGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TourismMapMarkerGroupSoap[soapModels.size()]);
	}

	public TourismMapMarkerGroupSoap() {
	}

	public long getPrimaryKey() {
		return _markerGroupId;
	}

	public void setPrimaryKey(long pk) {
		setMarkerGroupId(pk);
	}

	public long getMarkerGroupId() {
		return _markerGroupId;
	}

	public void setMarkerGroupId(long markerGroupId) {
		_markerGroupId = markerGroupId;
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

	public String getMarkerGroupName() {
		return _markerGroupName;
	}

	public void setMarkerGroupName(String markerGroupName) {
		_markerGroupName = markerGroupName;
	}

	public String getMarkerGroupInfo() {
		return _markerGroupInfo;
	}

	public void setMarkerGroupInfo(String markerGroupInfo) {
		_markerGroupInfo = markerGroupInfo;
	}

	private long _markerGroupId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _markerGroupName;
	private String _markerGroupInfo;
}