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

package com.bkav.portal.portlet.dynamic_menu.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    hungdx
 * @generated
 */
public class DynamicMenuSoap implements Serializable {
	public static DynamicMenuSoap toSoapModel(DynamicMenu model) {
		DynamicMenuSoap soapModel = new DynamicMenuSoap();

		soapModel.setMenuId(model.getMenuId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setItemCount(model.getItemCount());

		return soapModel;
	}

	public static DynamicMenuSoap[] toSoapModels(DynamicMenu[] models) {
		DynamicMenuSoap[] soapModels = new DynamicMenuSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DynamicMenuSoap[][] toSoapModels(DynamicMenu[][] models) {
		DynamicMenuSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DynamicMenuSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DynamicMenuSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DynamicMenuSoap[] toSoapModels(List<DynamicMenu> models) {
		List<DynamicMenuSoap> soapModels = new ArrayList<DynamicMenuSoap>(models.size());

		for (DynamicMenu model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DynamicMenuSoap[soapModels.size()]);
	}

	public DynamicMenuSoap() {
	}

	public long getPrimaryKey() {
		return _menuId;
	}

	public void setPrimaryKey(long pk) {
		setMenuId(pk);
	}

	public long getMenuId() {
		return _menuId;
	}

	public void setMenuId(long menuId) {
		_menuId = menuId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getItemCount() {
		return _itemCount;
	}

	public void setItemCount(int itemCount) {
		_itemCount = itemCount;
	}

	private long _menuId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private int _itemCount;
}