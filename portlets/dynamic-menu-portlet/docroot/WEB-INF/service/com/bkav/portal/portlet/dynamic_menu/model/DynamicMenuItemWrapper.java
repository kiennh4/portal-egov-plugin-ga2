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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DynamicMenuItem}.
 * </p>
 *
 * @author    hungdx
 * @see       DynamicMenuItem
 * @generated
 */
public class DynamicMenuItemWrapper implements DynamicMenuItem,
	ModelWrapper<DynamicMenuItem> {
	public DynamicMenuItemWrapper(DynamicMenuItem dynamicMenuItem) {
		_dynamicMenuItem = dynamicMenuItem;
	}

	public Class<?> getModelClass() {
		return DynamicMenuItem.class;
	}

	public String getModelClassName() {
		return DynamicMenuItem.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("menuId", getMenuId());
		attributes.put("parentId", getParentId());
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("urlType", getUrlType());
		attributes.put("position", getPosition());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long menuId = (Long)attributes.get("menuId");

		if (menuId != null) {
			setMenuId(menuId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String urlType = (String)attributes.get("urlType");

		if (urlType != null) {
			setUrlType(urlType);
		}

		Integer position = (Integer)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}
	}

	/**
	* Returns the primary key of this dynamic menu item.
	*
	* @return the primary key of this dynamic menu item
	*/
	public long getPrimaryKey() {
		return _dynamicMenuItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dynamic menu item.
	*
	* @param primaryKey the primary key of this dynamic menu item
	*/
	public void setPrimaryKey(long primaryKey) {
		_dynamicMenuItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item ID of this dynamic menu item.
	*
	* @return the item ID of this dynamic menu item
	*/
	public long getItemId() {
		return _dynamicMenuItem.getItemId();
	}

	/**
	* Sets the item ID of this dynamic menu item.
	*
	* @param itemId the item ID of this dynamic menu item
	*/
	public void setItemId(long itemId) {
		_dynamicMenuItem.setItemId(itemId);
	}

	/**
	* Returns the group ID of this dynamic menu item.
	*
	* @return the group ID of this dynamic menu item
	*/
	public long getGroupId() {
		return _dynamicMenuItem.getGroupId();
	}

	/**
	* Sets the group ID of this dynamic menu item.
	*
	* @param groupId the group ID of this dynamic menu item
	*/
	public void setGroupId(long groupId) {
		_dynamicMenuItem.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this dynamic menu item.
	*
	* @return the company ID of this dynamic menu item
	*/
	public long getCompanyId() {
		return _dynamicMenuItem.getCompanyId();
	}

	/**
	* Sets the company ID of this dynamic menu item.
	*
	* @param companyId the company ID of this dynamic menu item
	*/
	public void setCompanyId(long companyId) {
		_dynamicMenuItem.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this dynamic menu item.
	*
	* @return the user ID of this dynamic menu item
	*/
	public long getUserId() {
		return _dynamicMenuItem.getUserId();
	}

	/**
	* Sets the user ID of this dynamic menu item.
	*
	* @param userId the user ID of this dynamic menu item
	*/
	public void setUserId(long userId) {
		_dynamicMenuItem.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dynamic menu item.
	*
	* @return the user uuid of this dynamic menu item
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItem.getUserUuid();
	}

	/**
	* Sets the user uuid of this dynamic menu item.
	*
	* @param userUuid the user uuid of this dynamic menu item
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_dynamicMenuItem.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this dynamic menu item.
	*
	* @return the user name of this dynamic menu item
	*/
	public java.lang.String getUserName() {
		return _dynamicMenuItem.getUserName();
	}

	/**
	* Sets the user name of this dynamic menu item.
	*
	* @param userName the user name of this dynamic menu item
	*/
	public void setUserName(java.lang.String userName) {
		_dynamicMenuItem.setUserName(userName);
	}

	/**
	* Returns the create date of this dynamic menu item.
	*
	* @return the create date of this dynamic menu item
	*/
	public java.util.Date getCreateDate() {
		return _dynamicMenuItem.getCreateDate();
	}

	/**
	* Sets the create date of this dynamic menu item.
	*
	* @param createDate the create date of this dynamic menu item
	*/
	public void setCreateDate(java.util.Date createDate) {
		_dynamicMenuItem.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dynamic menu item.
	*
	* @return the modified date of this dynamic menu item
	*/
	public java.util.Date getModifiedDate() {
		return _dynamicMenuItem.getModifiedDate();
	}

	/**
	* Sets the modified date of this dynamic menu item.
	*
	* @param modifiedDate the modified date of this dynamic menu item
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dynamicMenuItem.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the menu ID of this dynamic menu item.
	*
	* @return the menu ID of this dynamic menu item
	*/
	public long getMenuId() {
		return _dynamicMenuItem.getMenuId();
	}

	/**
	* Sets the menu ID of this dynamic menu item.
	*
	* @param menuId the menu ID of this dynamic menu item
	*/
	public void setMenuId(long menuId) {
		_dynamicMenuItem.setMenuId(menuId);
	}

	/**
	* Returns the parent ID of this dynamic menu item.
	*
	* @return the parent ID of this dynamic menu item
	*/
	public long getParentId() {
		return _dynamicMenuItem.getParentId();
	}

	/**
	* Sets the parent ID of this dynamic menu item.
	*
	* @param parentId the parent ID of this dynamic menu item
	*/
	public void setParentId(long parentId) {
		_dynamicMenuItem.setParentId(parentId);
	}

	/**
	* Returns the name of this dynamic menu item.
	*
	* @return the name of this dynamic menu item
	*/
	public java.lang.String getName() {
		return _dynamicMenuItem.getName();
	}

	/**
	* Sets the name of this dynamic menu item.
	*
	* @param name the name of this dynamic menu item
	*/
	public void setName(java.lang.String name) {
		_dynamicMenuItem.setName(name);
	}

	/**
	* Returns the url of this dynamic menu item.
	*
	* @return the url of this dynamic menu item
	*/
	public java.lang.String getUrl() {
		return _dynamicMenuItem.getUrl();
	}

	/**
	* Sets the url of this dynamic menu item.
	*
	* @param url the url of this dynamic menu item
	*/
	public void setUrl(java.lang.String url) {
		_dynamicMenuItem.setUrl(url);
	}

	/**
	* Returns the url type of this dynamic menu item.
	*
	* @return the url type of this dynamic menu item
	*/
	public java.lang.String getUrlType() {
		return _dynamicMenuItem.getUrlType();
	}

	/**
	* Sets the url type of this dynamic menu item.
	*
	* @param urlType the url type of this dynamic menu item
	*/
	public void setUrlType(java.lang.String urlType) {
		_dynamicMenuItem.setUrlType(urlType);
	}

	/**
	* Returns the position of this dynamic menu item.
	*
	* @return the position of this dynamic menu item
	*/
	public int getPosition() {
		return _dynamicMenuItem.getPosition();
	}

	/**
	* Sets the position of this dynamic menu item.
	*
	* @param position the position of this dynamic menu item
	*/
	public void setPosition(int position) {
		_dynamicMenuItem.setPosition(position);
	}

	public boolean isNew() {
		return _dynamicMenuItem.isNew();
	}

	public void setNew(boolean n) {
		_dynamicMenuItem.setNew(n);
	}

	public boolean isCachedModel() {
		return _dynamicMenuItem.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_dynamicMenuItem.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _dynamicMenuItem.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _dynamicMenuItem.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dynamicMenuItem.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dynamicMenuItem.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dynamicMenuItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DynamicMenuItemWrapper((DynamicMenuItem)_dynamicMenuItem.clone());
	}

	public int compareTo(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem dynamicMenuItem) {
		return _dynamicMenuItem.compareTo(dynamicMenuItem);
	}

	@Override
	public int hashCode() {
		return _dynamicMenuItem.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> toCacheModel() {
		return _dynamicMenuItem.toCacheModel();
	}

	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem toEscapedModel() {
		return new DynamicMenuItemWrapper(_dynamicMenuItem.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dynamicMenuItem.toString();
	}

	public java.lang.String toXmlString() {
		return _dynamicMenuItem.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dynamicMenuItem.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DynamicMenuItem getWrappedDynamicMenuItem() {
		return _dynamicMenuItem;
	}

	public DynamicMenuItem getWrappedModel() {
		return _dynamicMenuItem;
	}

	public void resetOriginalValues() {
		_dynamicMenuItem.resetOriginalValues();
	}

	private DynamicMenuItem _dynamicMenuItem;
}