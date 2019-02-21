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

package com.bkav.portal.portlet.dynamic_menu.model.impl;

import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing DynamicMenu in entity cache.
 *
 * @author hungdx
 * @see DynamicMenu
 * @generated
 */
public class DynamicMenuCacheModel implements CacheModel<DynamicMenu>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{menuId=");
		sb.append(menuId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", itemCount=");
		sb.append(itemCount);
		sb.append("}");

		return sb.toString();
	}

	public DynamicMenu toEntityModel() {
		DynamicMenuImpl dynamicMenuImpl = new DynamicMenuImpl();

		dynamicMenuImpl.setMenuId(menuId);
		dynamicMenuImpl.setGroupId(groupId);
		dynamicMenuImpl.setCompanyId(companyId);
		dynamicMenuImpl.setUserId(userId);

		if (userName == null) {
			dynamicMenuImpl.setUserName(StringPool.BLANK);
		}
		else {
			dynamicMenuImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dynamicMenuImpl.setCreateDate(null);
		}
		else {
			dynamicMenuImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dynamicMenuImpl.setModifiedDate(null);
		}
		else {
			dynamicMenuImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			dynamicMenuImpl.setName(StringPool.BLANK);
		}
		else {
			dynamicMenuImpl.setName(name);
		}

		if (description == null) {
			dynamicMenuImpl.setDescription(StringPool.BLANK);
		}
		else {
			dynamicMenuImpl.setDescription(description);
		}

		dynamicMenuImpl.setItemCount(itemCount);

		dynamicMenuImpl.resetOriginalValues();

		return dynamicMenuImpl;
	}

	public long menuId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public int itemCount;
}