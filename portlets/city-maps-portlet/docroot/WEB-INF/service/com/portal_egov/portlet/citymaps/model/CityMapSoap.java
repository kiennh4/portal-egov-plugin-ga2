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

package com.portal_egov.portlet.citymaps.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.citymaps.service.http.CityMapServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.citymaps.service.http.CityMapServiceSoap
 * @generated
 */
public class CityMapSoap implements Serializable {
	public static CityMapSoap toSoapModel(CityMap model) {
		CityMapSoap soapModel = new CityMapSoap();

		soapModel.setMapId(model.getMapId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMapTypeId(model.getMapTypeId());
		soapModel.setMapImageId(model.getMapImageId());
		soapModel.setMapName(model.getMapName());
		soapModel.setMapDesc(model.getMapDesc());
		soapModel.setMapSumary(model.getMapSumary());

		return soapModel;
	}

	public static CityMapSoap[] toSoapModels(CityMap[] models) {
		CityMapSoap[] soapModels = new CityMapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CityMapSoap[][] toSoapModels(CityMap[][] models) {
		CityMapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CityMapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CityMapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CityMapSoap[] toSoapModels(List<CityMap> models) {
		List<CityMapSoap> soapModels = new ArrayList<CityMapSoap>(models.size());

		for (CityMap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CityMapSoap[soapModels.size()]);
	}

	public CityMapSoap() {
	}

	public long getPrimaryKey() {
		return _mapId;
	}

	public void setPrimaryKey(long pk) {
		setMapId(pk);
	}

	public long getMapId() {
		return _mapId;
	}

	public void setMapId(long mapId) {
		_mapId = mapId;
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

	public long getMapTypeId() {
		return _mapTypeId;
	}

	public void setMapTypeId(long mapTypeId) {
		_mapTypeId = mapTypeId;
	}

	public long getMapImageId() {
		return _mapImageId;
	}

	public void setMapImageId(long mapImageId) {
		_mapImageId = mapImageId;
	}

	public String getMapName() {
		return _mapName;
	}

	public void setMapName(String mapName) {
		_mapName = mapName;
	}

	public String getMapDesc() {
		return _mapDesc;
	}

	public void setMapDesc(String mapDesc) {
		_mapDesc = mapDesc;
	}

	public String getMapSumary() {
		return _mapSumary;
	}

	public void setMapSumary(String mapSumary) {
		_mapSumary = mapSumary;
	}

	private long _mapId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _mapTypeId;
	private long _mapImageId;
	private String _mapName;
	private String _mapDesc;
	private String _mapSumary;
}