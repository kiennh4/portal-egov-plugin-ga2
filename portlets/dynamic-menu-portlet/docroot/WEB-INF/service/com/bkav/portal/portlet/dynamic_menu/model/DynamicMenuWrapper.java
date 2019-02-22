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
 * This class is a wrapper for {@link DynamicMenu}.
 * </p>
 *
 * @author    hungdx
 * @see       DynamicMenu
 * @generated
 */
public class DynamicMenuWrapper implements DynamicMenu,
	ModelWrapper<DynamicMenu> {
	public DynamicMenuWrapper(DynamicMenu dynamicMenu) {
		_dynamicMenu = dynamicMenu;
	}

	public Class<?> getModelClass() {
		return DynamicMenu.class;
	}

	public String getModelClassName() {
		return DynamicMenu.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("menuId", getMenuId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("itemCount", getItemCount());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long menuId = (Long)attributes.get("menuId");

		if (menuId != null) {
			setMenuId(menuId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer itemCount = (Integer)attributes.get("itemCount");

		if (itemCount != null) {
			setItemCount(itemCount);
		}
	}

	/**
	* Returns the primary key of this dynamic menu.
	*
	* @return the primary key of this dynamic menu
	*/
	public long getPrimaryKey() {
		return _dynamicMenu.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dynamic menu.
	*
	* @param primaryKey the primary key of this dynamic menu
	*/
	public void setPrimaryKey(long primaryKey) {
		_dynamicMenu.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the menu ID of this dynamic menu.
	*
	* @return the menu ID of this dynamic menu
	*/
	public long getMenuId() {
		return _dynamicMenu.getMenuId();
	}

	/**
	* Sets the menu ID of this dynamic menu.
	*
	* @param menuId the menu ID of this dynamic menu
	*/
	public void setMenuId(long menuId) {
		_dynamicMenu.setMenuId(menuId);
	}

	/**
	* Returns the group ID of this dynamic menu.
	*
	* @return the group ID of this dynamic menu
	*/
	public long getGroupId() {
		return _dynamicMenu.getGroupId();
	}

	/**
	* Sets the group ID of this dynamic menu.
	*
	* @param groupId the group ID of this dynamic menu
	*/
	public void setGroupId(long groupId) {
		_dynamicMenu.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this dynamic menu.
	*
	* @return the company ID of this dynamic menu
	*/
	public long getCompanyId() {
		return _dynamicMenu.getCompanyId();
	}

	/**
	* Sets the company ID of this dynamic menu.
	*
	* @param companyId the company ID of this dynamic menu
	*/
	public void setCompanyId(long companyId) {
		_dynamicMenu.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this dynamic menu.
	*
	* @return the user ID of this dynamic menu
	*/
	public long getUserId() {
		return _dynamicMenu.getUserId();
	}

	/**
	* Sets the user ID of this dynamic menu.
	*
	* @param userId the user ID of this dynamic menu
	*/
	public void setUserId(long userId) {
		_dynamicMenu.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dynamic menu.
	*
	* @return the user uuid of this dynamic menu
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenu.getUserUuid();
	}

	/**
	* Sets the user uuid of this dynamic menu.
	*
	* @param userUuid the user uuid of this dynamic menu
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_dynamicMenu.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this dynamic menu.
	*
	* @return the user name of this dynamic menu
	*/
	public java.lang.String getUserName() {
		return _dynamicMenu.getUserName();
	}

	/**
	* Sets the user name of this dynamic menu.
	*
	* @param userName the user name of this dynamic menu
	*/
	public void setUserName(java.lang.String userName) {
		_dynamicMenu.setUserName(userName);
	}

	/**
	* Returns the create date of this dynamic menu.
	*
	* @return the create date of this dynamic menu
	*/
	public java.util.Date getCreateDate() {
		return _dynamicMenu.getCreateDate();
	}

	/**
	* Sets the create date of this dynamic menu.
	*
	* @param createDate the create date of this dynamic menu
	*/
	public void setCreateDate(java.util.Date createDate) {
		_dynamicMenu.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dynamic menu.
	*
	* @return the modified date of this dynamic menu
	*/
	public java.util.Date getModifiedDate() {
		return _dynamicMenu.getModifiedDate();
	}

	/**
	* Sets the modified date of this dynamic menu.
	*
	* @param modifiedDate the modified date of this dynamic menu
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dynamicMenu.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this dynamic menu.
	*
	* @return the name of this dynamic menu
	*/
	public java.lang.String getName() {
		return _dynamicMenu.getName();
	}

	/**
	* Sets the name of this dynamic menu.
	*
	* @param name the name of this dynamic menu
	*/
	public void setName(java.lang.String name) {
		_dynamicMenu.setName(name);
	}

	/**
	* Returns the description of this dynamic menu.
	*
	* @return the description of this dynamic menu
	*/
	public java.lang.String getDescription() {
		return _dynamicMenu.getDescription();
	}

	/**
	* Sets the description of this dynamic menu.
	*
	* @param description the description of this dynamic menu
	*/
	public void setDescription(java.lang.String description) {
		_dynamicMenu.setDescription(description);
	}

	/**
	* Returns the item count of this dynamic menu.
	*
	* @return the item count of this dynamic menu
	*/
	public int getItemCount() {
		return _dynamicMenu.getItemCount();
	}

	/**
	* Sets the item count of this dynamic menu.
	*
	* @param itemCount the item count of this dynamic menu
	*/
	public void setItemCount(int itemCount) {
		_dynamicMenu.setItemCount(itemCount);
	}

	public boolean isNew() {
		return _dynamicMenu.isNew();
	}

	public void setNew(boolean n) {
		_dynamicMenu.setNew(n);
	}

	public boolean isCachedModel() {
		return _dynamicMenu.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_dynamicMenu.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _dynamicMenu.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _dynamicMenu.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dynamicMenu.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dynamicMenu.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dynamicMenu.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DynamicMenuWrapper((DynamicMenu)_dynamicMenu.clone());
	}

	public int compareTo(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu dynamicMenu) {
		return _dynamicMenu.compareTo(dynamicMenu);
	}

	@Override
	public int hashCode() {
		return _dynamicMenu.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> toCacheModel() {
		return _dynamicMenu.toCacheModel();
	}

	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu toEscapedModel() {
		return new DynamicMenuWrapper(_dynamicMenu.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dynamicMenu.toString();
	}

	public java.lang.String toXmlString() {
		return _dynamicMenu.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dynamicMenu.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DynamicMenu getWrappedDynamicMenu() {
		return _dynamicMenu;
	}

	public DynamicMenu getWrappedModel() {
		return _dynamicMenu;
	}

	public void resetOriginalValues() {
		_dynamicMenu.resetOriginalValues();
	}

	private DynamicMenu _dynamicMenu;
}