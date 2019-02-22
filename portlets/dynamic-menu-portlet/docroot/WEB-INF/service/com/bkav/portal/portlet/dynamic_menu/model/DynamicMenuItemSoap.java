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
public class DynamicMenuItemSoap implements Serializable {
	public static DynamicMenuItemSoap toSoapModel(DynamicMenuItem model) {
		DynamicMenuItemSoap soapModel = new DynamicMenuItemSoap();

		soapModel.setItemId(model.getItemId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMenuId(model.getMenuId());
		soapModel.setParentId(model.getParentId());
		soapModel.setName(model.getName());
		soapModel.setUrl(model.getUrl());
		soapModel.setUrlType(model.getUrlType());
		soapModel.setPosition(model.getPosition());

		return soapModel;
	}

	public static DynamicMenuItemSoap[] toSoapModels(DynamicMenuItem[] models) {
		DynamicMenuItemSoap[] soapModels = new DynamicMenuItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DynamicMenuItemSoap[][] toSoapModels(
		DynamicMenuItem[][] models) {
		DynamicMenuItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DynamicMenuItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DynamicMenuItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DynamicMenuItemSoap[] toSoapModels(
		List<DynamicMenuItem> models) {
		List<DynamicMenuItemSoap> soapModels = new ArrayList<DynamicMenuItemSoap>(models.size());

		for (DynamicMenuItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DynamicMenuItemSoap[soapModels.size()]);
	}

	public DynamicMenuItemSoap() {
	}

	public long getPrimaryKey() {
		return _itemId;
	}

	public void setPrimaryKey(long pk) {
		setItemId(pk);
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
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

	public long getMenuId() {
		return _menuId;
	}

	public void setMenuId(long menuId) {
		_menuId = menuId;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getUrlType() {
		return _urlType;
	}

	public void setUrlType(String urlType) {
		_urlType = urlType;
	}

	public int getPosition() {
		return _position;
	}

	public void setPosition(int position) {
		_position = position;
	}

	private long _itemId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _menuId;
	private long _parentId;
	private String _name;
	private String _url;
	private String _urlType;
	private int _position;
}