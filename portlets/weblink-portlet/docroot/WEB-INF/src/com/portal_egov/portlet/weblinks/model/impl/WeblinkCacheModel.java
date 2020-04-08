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

package com.portal_egov.portlet.weblinks.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.weblinks.model.Weblink;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Weblink in entity cache.
 *
 * @author HungDX
 * @see Weblink
 * @generated
 */
public class WeblinkCacheModel implements CacheModel<Weblink>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{weblinkId=");
		sb.append(weblinkId);
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
		sb.append(", weblinkCategoryId=");
		sb.append(weblinkCategoryId);
		sb.append(", weblinkName=");
		sb.append(weblinkName);
		sb.append(", weblinkDesc=");
		sb.append(weblinkDesc);
		sb.append(", weblinkURL=");
		sb.append(weblinkURL);
		sb.append(", weblinkIconId=");
		sb.append(weblinkIconId);
		sb.append("}");

		return sb.toString();
	}

	public Weblink toEntityModel() {
		WeblinkImpl weblinkImpl = new WeblinkImpl();

		weblinkImpl.setWeblinkId(weblinkId);
		weblinkImpl.setGroupId(groupId);
		weblinkImpl.setCompanyId(companyId);
		weblinkImpl.setUserId(userId);

		if (userName == null) {
			weblinkImpl.setUserName(StringPool.BLANK);
		}
		else {
			weblinkImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			weblinkImpl.setCreateDate(null);
		}
		else {
			weblinkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			weblinkImpl.setModifiedDate(null);
		}
		else {
			weblinkImpl.setModifiedDate(new Date(modifiedDate));
		}

		weblinkImpl.setWeblinkCategoryId(weblinkCategoryId);

		if (weblinkName == null) {
			weblinkImpl.setWeblinkName(StringPool.BLANK);
		}
		else {
			weblinkImpl.setWeblinkName(weblinkName);
		}

		if (weblinkDesc == null) {
			weblinkImpl.setWeblinkDesc(StringPool.BLANK);
		}
		else {
			weblinkImpl.setWeblinkDesc(weblinkDesc);
		}

		if (weblinkURL == null) {
			weblinkImpl.setWeblinkURL(StringPool.BLANK);
		}
		else {
			weblinkImpl.setWeblinkURL(weblinkURL);
		}

		weblinkImpl.setWeblinkIconId(weblinkIconId);

		weblinkImpl.resetOriginalValues();

		return weblinkImpl;
	}

	public long weblinkId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long weblinkCategoryId;
	public String weblinkName;
	public String weblinkDesc;
	public String weblinkURL;
	public long weblinkIconId;
}