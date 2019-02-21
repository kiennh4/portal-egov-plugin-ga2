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

package com.portal_egov.portlet.banner.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.banner.service.http.BannerServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.banner.service.http.BannerServiceSoap
 * @generated
 */
public class BannerSoap implements Serializable {
	public static BannerSoap toSoapModel(Banner model) {
		BannerSoap soapModel = new BannerSoap();

		soapModel.setBannerId(model.getBannerId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBannerGroupId(model.getBannerGroupId());
		soapModel.setBannerTitle(model.getBannerTitle());
		soapModel.setBannerLink(model.getBannerLink());
		soapModel.setBannerImageId(model.getBannerImageId());
		soapModel.setViewCounter(model.getViewCounter());
		soapModel.setBannerStatus(model.getBannerStatus());

		return soapModel;
	}

	public static BannerSoap[] toSoapModels(Banner[] models) {
		BannerSoap[] soapModels = new BannerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BannerSoap[][] toSoapModels(Banner[][] models) {
		BannerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BannerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BannerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BannerSoap[] toSoapModels(List<Banner> models) {
		List<BannerSoap> soapModels = new ArrayList<BannerSoap>(models.size());

		for (Banner model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BannerSoap[soapModels.size()]);
	}

	public BannerSoap() {
	}

	public long getPrimaryKey() {
		return _bannerId;
	}

	public void setPrimaryKey(long pk) {
		setBannerId(pk);
	}

	public long getBannerId() {
		return _bannerId;
	}

	public void setBannerId(long bannerId) {
		_bannerId = bannerId;
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

	public long getBannerGroupId() {
		return _bannerGroupId;
	}

	public void setBannerGroupId(long bannerGroupId) {
		_bannerGroupId = bannerGroupId;
	}

	public String getBannerTitle() {
		return _bannerTitle;
	}

	public void setBannerTitle(String bannerTitle) {
		_bannerTitle = bannerTitle;
	}

	public String getBannerLink() {
		return _bannerLink;
	}

	public void setBannerLink(String bannerLink) {
		_bannerLink = bannerLink;
	}

	public long getBannerImageId() {
		return _bannerImageId;
	}

	public void setBannerImageId(long bannerImageId) {
		_bannerImageId = bannerImageId;
	}

	public int getViewCounter() {
		return _viewCounter;
	}

	public void setViewCounter(int viewCounter) {
		_viewCounter = viewCounter;
	}

	public int getBannerStatus() {
		return _bannerStatus;
	}

	public void setBannerStatus(int bannerStatus) {
		_bannerStatus = bannerStatus;
	}

	private long _bannerId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _bannerGroupId;
	private String _bannerTitle;
	private String _bannerLink;
	private long _bannerImageId;
	private int _viewCounter;
	private int _bannerStatus;
}