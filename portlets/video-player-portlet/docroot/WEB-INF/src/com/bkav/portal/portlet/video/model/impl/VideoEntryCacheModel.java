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

import com.bkav.portal.portlet.video.model.VideoEntry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VideoEntry in entity cache.
 *
 * @author hungdx
 * @see VideoEntry
 * @generated
 */
public class VideoEntryCacheModel implements CacheModel<VideoEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{entryId=");
		sb.append(entryId);
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
		sb.append(", videoType=");
		sb.append(videoType);
		sb.append(", videoUrl=");
		sb.append(videoUrl);
		sb.append(", videoFileId=");
		sb.append(videoFileId);
		sb.append(", thumbnailImage=");
		sb.append(thumbnailImage);
		sb.append(", thumbnailImageId=");
		sb.append(thumbnailImageId);
		sb.append("}");

		return sb.toString();
	}

	public VideoEntry toEntityModel() {
		VideoEntryImpl videoEntryImpl = new VideoEntryImpl();

		videoEntryImpl.setEntryId(entryId);
		videoEntryImpl.setGroupId(groupId);
		videoEntryImpl.setCompanyId(companyId);
		videoEntryImpl.setUserId(userId);

		if (userName == null) {
			videoEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			videoEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			videoEntryImpl.setCreateDate(null);
		}
		else {
			videoEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			videoEntryImpl.setModifiedDate(null);
		}
		else {
			videoEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			videoEntryImpl.setName(StringPool.BLANK);
		}
		else {
			videoEntryImpl.setName(name);
		}

		if (description == null) {
			videoEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			videoEntryImpl.setDescription(description);
		}

		if (videoType == null) {
			videoEntryImpl.setVideoType(StringPool.BLANK);
		}
		else {
			videoEntryImpl.setVideoType(videoType);
		}

		if (videoUrl == null) {
			videoEntryImpl.setVideoUrl(StringPool.BLANK);
		}
		else {
			videoEntryImpl.setVideoUrl(videoUrl);
		}

		videoEntryImpl.setVideoFileId(videoFileId);
		videoEntryImpl.setThumbnailImage(thumbnailImage);
		videoEntryImpl.setThumbnailImageId(thumbnailImageId);

		videoEntryImpl.resetOriginalValues();

		return videoEntryImpl;
	}

	public long entryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public String videoType;
	public String videoUrl;
	public long videoFileId;
	public boolean thumbnailImage;
	public long thumbnailImageId;
}