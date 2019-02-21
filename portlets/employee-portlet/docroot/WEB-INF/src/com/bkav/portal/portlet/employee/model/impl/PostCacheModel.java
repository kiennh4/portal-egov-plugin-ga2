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

package com.bkav.portal.portlet.employee.model.impl;

import com.bkav.portal.portlet.employee.model.Post;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Post in entity cache.
 *
 * @author ducdvd
 * @see Post
 * @generated
 */
public class PostCacheModel implements CacheModel<Post>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{postId=");
		sb.append(postId);
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
		sb.append(", postName=");
		sb.append(postName);
		sb.append("}");

		return sb.toString();
	}

	public Post toEntityModel() {
		PostImpl postImpl = new PostImpl();

		postImpl.setPostId(postId);
		postImpl.setGroupId(groupId);
		postImpl.setCompanyId(companyId);
		postImpl.setUserId(userId);

		if (userName == null) {
			postImpl.setUserName(StringPool.BLANK);
		}
		else {
			postImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			postImpl.setCreateDate(null);
		}
		else {
			postImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			postImpl.setModifiedDate(null);
		}
		else {
			postImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (postName == null) {
			postImpl.setPostName(StringPool.BLANK);
		}
		else {
			postImpl.setPostName(postName);
		}

		postImpl.resetOriginalValues();

		return postImpl;
	}

	public long postId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String postName;
}