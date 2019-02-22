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
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.tourism_map.service.http.TourismMapMarkerServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.tourism_map.service.http.TourismMapMarkerServiceSoap
 * @generated
 */
public class TourismMapMarkerSoap implements Serializable {
	public static TourismMapMarkerSoap toSoapModel(TourismMapMarker model) {
		TourismMapMarkerSoap soapModel = new TourismMapMarkerSoap();

		soapModel.setMarkerId(model.getMarkerId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMarkerGroupId(model.getMarkerGroupId());
		soapModel.setMarkerTitle(model.getMarkerTitle());
		soapModel.setMarkerInfo(model.getMarkerInfo());
		soapModel.setMarkerAddress(model.getMarkerAddress());
		soapModel.setMarkerImageId(model.getMarkerImageId());
		soapModel.setMarkerLongitude(model.getMarkerLongitude());
		soapModel.setMarkerLatitude(model.getMarkerLatitude());

		return soapModel;
	}

	public static TourismMapMarkerSoap[] toSoapModels(TourismMapMarker[] models) {
		TourismMapMarkerSoap[] soapModels = new TourismMapMarkerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TourismMapMarkerSoap[][] toSoapModels(
		TourismMapMarker[][] models) {
		TourismMapMarkerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TourismMapMarkerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TourismMapMarkerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TourismMapMarkerSoap[] toSoapModels(
		List<TourismMapMarker> models) {
		List<TourismMapMarkerSoap> soapModels = new ArrayList<TourismMapMarkerSoap>(models.size());

		for (TourismMapMarker model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TourismMapMarkerSoap[soapModels.size()]);
	}

	public TourismMapMarkerSoap() {
	}

	public long getPrimaryKey() {
		return _markerId;
	}

	public void setPrimaryKey(long pk) {
		setMarkerId(pk);
	}

	public long getMarkerId() {
		return _markerId;
	}

	public void setMarkerId(long markerId) {
		_markerId = markerId;
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

	public long getMarkerGroupId() {
		return _markerGroupId;
	}

	public void setMarkerGroupId(long markerGroupId) {
		_markerGroupId = markerGroupId;
	}

	public String getMarkerTitle() {
		return _markerTitle;
	}

	public void setMarkerTitle(String markerTitle) {
		_markerTitle = markerTitle;
	}

	public String getMarkerInfo() {
		return _markerInfo;
	}

	public void setMarkerInfo(String markerInfo) {
		_markerInfo = markerInfo;
	}

	public String getMarkerAddress() {
		return _markerAddress;
	}

	public void setMarkerAddress(String markerAddress) {
		_markerAddress = markerAddress;
	}

	public long getMarkerImageId() {
		return _markerImageId;
	}

	public void setMarkerImageId(long markerImageId) {
		_markerImageId = markerImageId;
	}

	public String getMarkerLongitude() {
		return _markerLongitude;
	}

	public void setMarkerLongitude(String markerLongitude) {
		_markerLongitude = markerLongitude;
	}

	public String getMarkerLatitude() {
		return _markerLatitude;
	}

	public void setMarkerLatitude(String markerLatitude) {
		_markerLatitude = markerLatitude;
	}

	private long _markerId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _markerGroupId;
	private String _markerTitle;
	private String _markerInfo;
	private String _markerAddress;
	private long _markerImageId;
	private String _markerLongitude;
	private String _markerLatitude;
}