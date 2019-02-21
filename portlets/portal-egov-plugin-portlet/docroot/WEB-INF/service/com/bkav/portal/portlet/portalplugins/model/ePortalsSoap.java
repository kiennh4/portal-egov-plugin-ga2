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

package com.bkav.portal.portlet.portalplugins.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bkav.portal.portlet.portalplugins.service.http.ePortalsServiceSoap}.
 *
 * @author    AnhBDb
 * @see       com.bkav.portal.portlet.portalplugins.service.http.ePortalsServiceSoap
 * @generated
 */
public class ePortalsSoap implements Serializable {
	public static ePortalsSoap toSoapModel(ePortals model) {
		ePortalsSoap soapModel = new ePortalsSoap();

		soapModel.setEportalId(model.getEportalId());
		soapModel.setEportalName(model.getEportalName());
		soapModel.setEportalCode(model.getEportalCode());
		soapModel.setEportalDomain(model.getEportalDomain());
		soapModel.setEportalVersion(model.getEportalVersion());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifyDate(model.getModifyDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());

		return soapModel;
	}

	public static ePortalsSoap[] toSoapModels(ePortals[] models) {
		ePortalsSoap[] soapModels = new ePortalsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ePortalsSoap[][] toSoapModels(ePortals[][] models) {
		ePortalsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ePortalsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ePortalsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ePortalsSoap[] toSoapModels(List<ePortals> models) {
		List<ePortalsSoap> soapModels = new ArrayList<ePortalsSoap>(models.size());

		for (ePortals model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ePortalsSoap[soapModels.size()]);
	}

	public ePortalsSoap() {
	}

	public long getPrimaryKey() {
		return _eportalId;
	}

	public void setPrimaryKey(long pk) {
		setEportalId(pk);
	}

	public long getEportalId() {
		return _eportalId;
	}

	public void setEportalId(long eportalId) {
		_eportalId = eportalId;
	}

	public String getEportalName() {
		return _eportalName;
	}

	public void setEportalName(String eportalName) {
		_eportalName = eportalName;
	}

	public String getEportalCode() {
		return _eportalCode;
	}

	public void setEportalCode(String eportalCode) {
		_eportalCode = eportalCode;
	}

	public String getEportalDomain() {
		return _eportalDomain;
	}

	public void setEportalDomain(String eportalDomain) {
		_eportalDomain = eportalDomain;
	}

	public String getEportalVersion() {
		return _eportalVersion;
	}

	public void setEportalVersion(String eportalVersion) {
		_eportalVersion = eportalVersion;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifyDate() {
		return _modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		_modifyDate = modifyDate;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	private long _eportalId;
	private String _eportalName;
	private String _eportalCode;
	private String _eportalDomain;
	private String _eportalVersion;
	private Date _createDate;
	private Date _modifyDate;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
}