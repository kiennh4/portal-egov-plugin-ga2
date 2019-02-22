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

package com.portal_egov.portlet.landprice.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.landprice.service.http.LandLocationServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.landprice.service.http.LandLocationServiceSoap
 * @generated
 */
public class LandLocationSoap implements Serializable {
	public static LandLocationSoap toSoapModel(LandLocation model) {
		LandLocationSoap soapModel = new LandLocationSoap();

		soapModel.setLocationId(model.getLocationId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setParentLocationId(model.getParentLocationId());
		soapModel.setLocationName(model.getLocationName());
		soapModel.setLocationInfo(model.getLocationInfo());

		return soapModel;
	}

	public static LandLocationSoap[] toSoapModels(LandLocation[] models) {
		LandLocationSoap[] soapModels = new LandLocationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LandLocationSoap[][] toSoapModels(LandLocation[][] models) {
		LandLocationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LandLocationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LandLocationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LandLocationSoap[] toSoapModels(List<LandLocation> models) {
		List<LandLocationSoap> soapModels = new ArrayList<LandLocationSoap>(models.size());

		for (LandLocation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LandLocationSoap[soapModels.size()]);
	}

	public LandLocationSoap() {
	}

	public long getPrimaryKey() {
		return _locationId;
	}

	public void setPrimaryKey(long pk) {
		setLocationId(pk);
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
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

	public long getParentLocationId() {
		return _parentLocationId;
	}

	public void setParentLocationId(long parentLocationId) {
		_parentLocationId = parentLocationId;
	}

	public String getLocationName() {
		return _locationName;
	}

	public void setLocationName(String locationName) {
		_locationName = locationName;
	}

	public String getLocationInfo() {
		return _locationInfo;
	}

	public void setLocationInfo(String locationInfo) {
		_locationInfo = locationInfo;
	}

	private long _locationId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _parentLocationId;
	private String _locationName;
	private String _locationInfo;
}