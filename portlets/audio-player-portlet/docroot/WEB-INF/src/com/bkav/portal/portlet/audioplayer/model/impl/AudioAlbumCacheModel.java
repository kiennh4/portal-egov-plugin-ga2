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

package com.bkav.portal.portlet.audioplayer.model.impl;

import com.bkav.portal.portlet.audioplayer.model.AudioAlbum;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing AudioAlbum in entity cache.
 *
 * @author anhbdb
 * @see AudioAlbum
 * @generated
 */
public class AudioAlbumCacheModel implements CacheModel<AudioAlbum>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{albumId=");
		sb.append(albumId);
		sb.append(", albumName=");
		sb.append(albumName);
		sb.append(", albumInfo=");
		sb.append(albumInfo);
		sb.append(", albumCoverId=");
		sb.append(albumCoverId);
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
		sb.append(", viewCounter=");
		sb.append(viewCounter);
		sb.append("}");

		return sb.toString();
	}

	public AudioAlbum toEntityModel() {
		AudioAlbumImpl audioAlbumImpl = new AudioAlbumImpl();

		audioAlbumImpl.setAlbumId(albumId);

		if (albumName == null) {
			audioAlbumImpl.setAlbumName(StringPool.BLANK);
		}
		else {
			audioAlbumImpl.setAlbumName(albumName);
		}

		if (albumInfo == null) {
			audioAlbumImpl.setAlbumInfo(StringPool.BLANK);
		}
		else {
			audioAlbumImpl.setAlbumInfo(albumInfo);
		}

		audioAlbumImpl.setAlbumCoverId(albumCoverId);

		if (createDate == Long.MIN_VALUE) {
			audioAlbumImpl.setCreateDate(null);
		}
		else {
			audioAlbumImpl.setCreateDate(new Date(createDate));
		}

		if (modifyDate == Long.MIN_VALUE) {
			audioAlbumImpl.setModifyDate(null);
		}
		else {
			audioAlbumImpl.setModifyDate(new Date(modifyDate));
		}

		audioAlbumImpl.setGroupId(groupId);
		audioAlbumImpl.setCompanyId(companyId);
		audioAlbumImpl.setUserId(userId);

		if (userName == null) {
			audioAlbumImpl.setUserName(StringPool.BLANK);
		}
		else {
			audioAlbumImpl.setUserName(userName);
		}

		audioAlbumImpl.setViewCounter(viewCounter);

		audioAlbumImpl.resetOriginalValues();

		return audioAlbumImpl;
	}

	public long albumId;
	public String albumName;
	public String albumInfo;
	public long albumCoverId;
	public long createDate;
	public long modifyDate;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long viewCounter;
}