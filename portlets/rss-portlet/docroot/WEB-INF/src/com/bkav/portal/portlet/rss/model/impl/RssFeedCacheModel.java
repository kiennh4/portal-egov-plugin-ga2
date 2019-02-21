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

package com.bkav.portal.portlet.rss.model.impl;

import com.bkav.portal.portlet.rss.model.RssFeed;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing RssFeed in entity cache.
 *
 * @author hungdx
 * @see RssFeed
 * @generated
 */
public class RssFeedCacheModel implements CacheModel<RssFeed>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id_=");
		sb.append(id_);
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
		sb.append(", url=");
		sb.append(url);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public RssFeed toEntityModel() {
		RssFeedImpl rssFeedImpl = new RssFeedImpl();

		rssFeedImpl.setId_(id_);
		rssFeedImpl.setGroupId(groupId);
		rssFeedImpl.setCompanyId(companyId);
		rssFeedImpl.setUserId(userId);

		if (userName == null) {
			rssFeedImpl.setUserName(StringPool.BLANK);
		}
		else {
			rssFeedImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			rssFeedImpl.setCreateDate(null);
		}
		else {
			rssFeedImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rssFeedImpl.setModifiedDate(null);
		}
		else {
			rssFeedImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			rssFeedImpl.setName(StringPool.BLANK);
		}
		else {
			rssFeedImpl.setName(name);
		}

		if (url == null) {
			rssFeedImpl.setUrl(StringPool.BLANK);
		}
		else {
			rssFeedImpl.setUrl(url);
		}

		if (description == null) {
			rssFeedImpl.setDescription(StringPool.BLANK);
		}
		else {
			rssFeedImpl.setDescription(description);
		}

		rssFeedImpl.setStatus(status);

		rssFeedImpl.resetOriginalValues();

		return rssFeedImpl;
	}

	public long id_;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String url;
	public String description;
	public int status;
}