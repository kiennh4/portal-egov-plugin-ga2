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

import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing DynamicMenuItem in entity cache.
 *
 * @author hungdx
 * @see DynamicMenuItem
 * @generated
 */
public class DynamicMenuItemCacheModel implements CacheModel<DynamicMenuItem>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{itemId=");
		sb.append(itemId);
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
		sb.append(", menuId=");
		sb.append(menuId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", url=");
		sb.append(url);
		sb.append(", urlType=");
		sb.append(urlType);
		sb.append(", position=");
		sb.append(position);
		sb.append("}");

		return sb.toString();
	}

	public DynamicMenuItem toEntityModel() {
		DynamicMenuItemImpl dynamicMenuItemImpl = new DynamicMenuItemImpl();

		dynamicMenuItemImpl.setItemId(itemId);
		dynamicMenuItemImpl.setGroupId(groupId);
		dynamicMenuItemImpl.setCompanyId(companyId);
		dynamicMenuItemImpl.setUserId(userId);

		if (userName == null) {
			dynamicMenuItemImpl.setUserName(StringPool.BLANK);
		}
		else {
			dynamicMenuItemImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dynamicMenuItemImpl.setCreateDate(null);
		}
		else {
			dynamicMenuItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dynamicMenuItemImpl.setModifiedDate(null);
		}
		else {
			dynamicMenuItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		dynamicMenuItemImpl.setMenuId(menuId);
		dynamicMenuItemImpl.setParentId(parentId);

		if (name == null) {
			dynamicMenuItemImpl.setName(StringPool.BLANK);
		}
		else {
			dynamicMenuItemImpl.setName(name);
		}

		if (url == null) {
			dynamicMenuItemImpl.setUrl(StringPool.BLANK);
		}
		else {
			dynamicMenuItemImpl.setUrl(url);
		}

		if (urlType == null) {
			dynamicMenuItemImpl.setUrlType(StringPool.BLANK);
		}
		else {
			dynamicMenuItemImpl.setUrlType(urlType);
		}

		dynamicMenuItemImpl.setPosition(position);

		dynamicMenuItemImpl.resetOriginalValues();

		return dynamicMenuItemImpl;
	}

	public long itemId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long menuId;
	public long parentId;
	public String name;
	public String url;
	public String urlType;
	public int position;
}