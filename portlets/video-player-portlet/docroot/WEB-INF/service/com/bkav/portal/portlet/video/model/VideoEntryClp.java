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

package com.bkav.portal.portlet.video.model;

import com.bkav.portal.portlet.video.service.VideoEntryLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hungdx
 */
public class VideoEntryClp extends BaseModelImpl<VideoEntry>
	implements VideoEntry {
	public VideoEntryClp() {
	}

	public Class<?> getModelClass() {
		return VideoEntry.class;
	}

	public String getModelClassName() {
		return VideoEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEntryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_entryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("videoType", getVideoType());
		attributes.put("videoUrl", getVideoUrl());
		attributes.put("videoFileId", getVideoFileId());
		attributes.put("thumbnailImage", getThumbnailImage());
		attributes.put("thumbnailImageId", getThumbnailImageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String videoType = (String)attributes.get("videoType");

		if (videoType != null) {
			setVideoType(videoType);
		}

		String videoUrl = (String)attributes.get("videoUrl");

		if (videoUrl != null) {
			setVideoUrl(videoUrl);
		}

		Long videoFileId = (Long)attributes.get("videoFileId");

		if (videoFileId != null) {
			setVideoFileId(videoFileId);
		}

		Boolean thumbnailImage = (Boolean)attributes.get("thumbnailImage");

		if (thumbnailImage != null) {
			setThumbnailImage(thumbnailImage);
		}

		Long thumbnailImageId = (Long)attributes.get("thumbnailImageId");

		if (thumbnailImageId != null) {
			setThumbnailImageId(thumbnailImageId);
		}
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getVideoType() {
		return _videoType;
	}

	public void setVideoType(String videoType) {
		_videoType = videoType;
	}

	public String getVideoUrl() {
		return _videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		_videoUrl = videoUrl;
	}

	public long getVideoFileId() {
		return _videoFileId;
	}

	public void setVideoFileId(long videoFileId) {
		_videoFileId = videoFileId;
	}

	public boolean getThumbnailImage() {
		return _thumbnailImage;
	}

	public boolean isThumbnailImage() {
		return _thumbnailImage;
	}

	public void setThumbnailImage(boolean thumbnailImage) {
		_thumbnailImage = thumbnailImage;
	}

	public long getThumbnailImageId() {
		return _thumbnailImageId;
	}

	public void setThumbnailImageId(long thumbnailImageId) {
		_thumbnailImageId = thumbnailImageId;
	}

	public BaseModel<?> getVideoEntryRemoteModel() {
		return _videoEntryRemoteModel;
	}

	public void setVideoEntryRemoteModel(BaseModel<?> videoEntryRemoteModel) {
		_videoEntryRemoteModel = videoEntryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VideoEntryLocalServiceUtil.addVideoEntry(this);
		}
		else {
			VideoEntryLocalServiceUtil.updateVideoEntry(this);
		}
	}

	@Override
	public VideoEntry toEscapedModel() {
		return (VideoEntry)Proxy.newProxyInstance(VideoEntry.class.getClassLoader(),
			new Class[] { VideoEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VideoEntryClp clone = new VideoEntryClp();

		clone.setEntryId(getEntryId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setVideoType(getVideoType());
		clone.setVideoUrl(getVideoUrl());
		clone.setVideoFileId(getVideoFileId());
		clone.setThumbnailImage(getThumbnailImage());
		clone.setThumbnailImageId(getThumbnailImageId());

		return clone;
	}

	public int compareTo(VideoEntry videoEntry) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), videoEntry.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		VideoEntryClp videoEntry = null;

		try {
			videoEntry = (VideoEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = videoEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{entryId=");
		sb.append(getEntryId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", videoType=");
		sb.append(getVideoType());
		sb.append(", videoUrl=");
		sb.append(getVideoUrl());
		sb.append(", videoFileId=");
		sb.append(getVideoFileId());
		sb.append(", thumbnailImage=");
		sb.append(getThumbnailImage());
		sb.append(", thumbnailImageId=");
		sb.append(getThumbnailImageId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.video.model.VideoEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entryId</column-name><column-value><![CDATA[");
		sb.append(getEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoType</column-name><column-value><![CDATA[");
		sb.append(getVideoType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoUrl</column-name><column-value><![CDATA[");
		sb.append(getVideoUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoFileId</column-name><column-value><![CDATA[");
		sb.append(getVideoFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thumbnailImage</column-name><column-value><![CDATA[");
		sb.append(getThumbnailImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thumbnailImageId</column-name><column-value><![CDATA[");
		sb.append(getThumbnailImageId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _entryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _videoType;
	private String _videoUrl;
	private long _videoFileId;
	private boolean _thumbnailImage;
	private long _thumbnailImageId;
	private BaseModel<?> _videoEntryRemoteModel;
}