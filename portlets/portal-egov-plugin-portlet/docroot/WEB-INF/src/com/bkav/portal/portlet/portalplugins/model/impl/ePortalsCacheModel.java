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

package com.bkav.portal.portlet.portalplugins.model.impl;

import com.bkav.portal.portlet.portalplugins.model.ePortals;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ePortals in entity cache.
 *
 * @author AnhBDb
 * @see ePortals
 * @generated
 */
public class ePortalsCacheModel implements CacheModel<ePortals>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{eportalId=");
		sb.append(eportalId);
		sb.append(", eportalName=");
		sb.append(eportalName);
		sb.append(", eportalCode=");
		sb.append(eportalCode);
		sb.append(", eportalDomain=");
		sb.append(eportalDomain);
		sb.append(", eportalVersion=");
		sb.append(eportalVersion);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifyDate=");
		sb.append(modifyDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append("}");

		return sb.toString();
	}

	public ePortals toEntityModel() {
		ePortalsImpl ePortalsImpl = new ePortalsImpl();

		ePortalsImpl.setEportalId(eportalId);

		if (eportalName == null) {
			ePortalsImpl.setEportalName(StringPool.BLANK);
		}
		else {
			ePortalsImpl.setEportalName(eportalName);
		}

		if (eportalCode == null) {
			ePortalsImpl.setEportalCode(StringPool.BLANK);
		}
		else {
			ePortalsImpl.setEportalCode(eportalCode);
		}

		if (eportalDomain == null) {
			ePortalsImpl.setEportalDomain(StringPool.BLANK);
		}
		else {
			ePortalsImpl.setEportalDomain(eportalDomain);
		}

		if (eportalVersion == null) {
			ePortalsImpl.setEportalVersion(StringPool.BLANK);
		}
		else {
			ePortalsImpl.setEportalVersion(eportalVersion);
		}

		if (createDate == Long.MIN_VALUE) {
			ePortalsImpl.setCreateDate(null);
		}
		else {
			ePortalsImpl.setCreateDate(new Date(createDate));
		}

		if (modifyDate == Long.MIN_VALUE) {
			ePortalsImpl.setModifyDate(null);
		}
		else {
			ePortalsImpl.setModifyDate(new Date(modifyDate));
		}

		ePortalsImpl.setGroupId(groupId);
		ePortalsImpl.setCompanyId(companyId);
		ePortalsImpl.setUserId(userId);

		if (userName == null) {
			ePortalsImpl.setUserName(StringPool.BLANK);
		}
		else {
			ePortalsImpl.setUserName(userName);
		}

		ePortalsImpl.resetOriginalValues();

		return ePortalsImpl;
	}

	public long eportalId;
	public String eportalName;
	public String eportalCode;
	public String eportalDomain;
	public String eportalVersion;
	public long createDate;
	public long modifyDate;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
}