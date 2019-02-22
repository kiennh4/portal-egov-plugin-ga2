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

package com.bkav.portal.portlet.video.model.impl;

import com.bkav.portal.portlet.video.model.VideoCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VideoCategory in entity cache.
 *
 * @author hungdx
 * @see VideoCategory
 * @generated
 */
public class VideoCategoryCacheModel implements CacheModel<VideoCategory>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{categoryId=");
		sb.append(categoryId);
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
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append("}");

		return sb.toString();
	}

	public VideoCategory toEntityModel() {
		VideoCategoryImpl videoCategoryImpl = new VideoCategoryImpl();

		videoCategoryImpl.setCategoryId(categoryId);
		videoCategoryImpl.setGroupId(groupId);
		videoCategoryImpl.setCompanyId(companyId);
		videoCategoryImpl.setUserId(userId);

		if (userName == null) {
			videoCategoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			videoCategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			videoCategoryImpl.setCreateDate(null);
		}
		else {
			videoCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			videoCategoryImpl.setModifiedDate(null);
		}
		else {
			videoCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (categoryName == null) {
			videoCategoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			videoCategoryImpl.setCategoryName(categoryName);
		}

		videoCategoryImpl.resetOriginalValues();

		return videoCategoryImpl;
	}

	public long categoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String categoryName;
}