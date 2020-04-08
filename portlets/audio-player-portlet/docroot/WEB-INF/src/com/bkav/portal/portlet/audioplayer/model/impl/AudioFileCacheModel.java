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

import com.bkav.portal.portlet.audioplayer.model.AudioFile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing AudioFile in entity cache.
 *
 * @author anhbdb
 * @see AudioFile
 * @generated
 */
public class AudioFileCacheModel implements CacheModel<AudioFile>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{audioId=");
		sb.append(audioId);
		sb.append(", audioName=");
		sb.append(audioName);
		sb.append(", audioInfo=");
		sb.append(audioInfo);
		sb.append(", audioType=");
		sb.append(audioType);
		sb.append(", audioFileId=");
		sb.append(audioFileId);
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

	public AudioFile toEntityModel() {
		AudioFileImpl audioFileImpl = new AudioFileImpl();

		audioFileImpl.setAudioId(audioId);

		if (audioName == null) {
			audioFileImpl.setAudioName(StringPool.BLANK);
		}
		else {
			audioFileImpl.setAudioName(audioName);
		}

		if (audioInfo == null) {
			audioFileImpl.setAudioInfo(StringPool.BLANK);
		}
		else {
			audioFileImpl.setAudioInfo(audioInfo);
		}

		if (audioType == null) {
			audioFileImpl.setAudioType(StringPool.BLANK);
		}
		else {
			audioFileImpl.setAudioType(audioType);
		}

		audioFileImpl.setAudioFileId(audioFileId);

		if (createDate == Long.MIN_VALUE) {
			audioFileImpl.setCreateDate(null);
		}
		else {
			audioFileImpl.setCreateDate(new Date(createDate));
		}

		if (modifyDate == Long.MIN_VALUE) {
			audioFileImpl.setModifyDate(null);
		}
		else {
			audioFileImpl.setModifyDate(new Date(modifyDate));
		}

		audioFileImpl.setGroupId(groupId);
		audioFileImpl.setCompanyId(companyId);
		audioFileImpl.setUserId(userId);

		if (userName == null) {
			audioFileImpl.setUserName(StringPool.BLANK);
		}
		else {
			audioFileImpl.setUserName(userName);
		}

		audioFileImpl.setViewCounter(viewCounter);

		audioFileImpl.resetOriginalValues();

		return audioFileImpl;
	}

	public long audioId;
	public String audioName;
	public String audioInfo;
	public String audioType;
	public long audioFileId;
	public long createDate;
	public long modifyDate;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long viewCounter;
}