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
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.landprice.service.http.LandPriceServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.landprice.service.http.LandPriceServiceSoap
 * @generated
 */
public class LandPriceSoap implements Serializable {
	public static LandPriceSoap toSoapModel(LandPrice model) {
		LandPriceSoap soapModel = new LandPriceSoap();

		soapModel.setPriceId(model.getPriceId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setStatisticYear(model.getStatisticYear());

		return soapModel;
	}

	public static LandPriceSoap[] toSoapModels(LandPrice[] models) {
		LandPriceSoap[] soapModels = new LandPriceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LandPriceSoap[][] toSoapModels(LandPrice[][] models) {
		LandPriceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LandPriceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LandPriceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LandPriceSoap[] toSoapModels(List<LandPrice> models) {
		List<LandPriceSoap> soapModels = new ArrayList<LandPriceSoap>(models.size());

		for (LandPrice model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LandPriceSoap[soapModels.size()]);
	}

	public LandPriceSoap() {
	}

	public long getPrimaryKey() {
		return _priceId;
	}

	public void setPrimaryKey(long pk) {
		setPriceId(pk);
	}

	public long getPriceId() {
		return _priceId;
	}

	public void setPriceId(long priceId) {
		_priceId = priceId;
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

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public int getStatisticYear() {
		return _statisticYear;
	}

	public void setStatisticYear(int statisticYear) {
		_statisticYear = statisticYear;
	}

	private long _priceId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _locationId;
	private String _title;
	private String _content;
	private int _statisticYear;
}