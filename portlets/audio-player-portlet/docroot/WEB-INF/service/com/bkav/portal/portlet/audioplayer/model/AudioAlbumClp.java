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

package com.bkav.portal.portlet.audioplayer.model;

import com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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
 * @author anhbdb
 */
public class AudioAlbumClp extends BaseModelImpl<AudioAlbum>
	implements AudioAlbum {
	public AudioAlbumClp() {
	}

	public Class<?> getModelClass() {
		return AudioAlbum.class;
	}

	public String getModelClassName() {
		return AudioAlbum.class.getName();
	}

	public long getPrimaryKey() {
		return _albumId;
	}

	public void setPrimaryKey(long primaryKey) {
		setAlbumId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_albumId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("albumId", getAlbumId());
		attributes.put("albumName", getAlbumName());
		attributes.put("albumInfo", getAlbumInfo());
		attributes.put("albumCoverId", getAlbumCoverId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("viewCounter", getViewCounter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long albumId = (Long)attributes.get("albumId");

		if (albumId != null) {
			setAlbumId(albumId);
		}

		String albumName = (String)attributes.get("albumName");

		if (albumName != null) {
			setAlbumName(albumName);
		}

		String albumInfo = (String)attributes.get("albumInfo");

		if (albumInfo != null) {
			setAlbumInfo(albumInfo);
		}

		Long albumCoverId = (Long)attributes.get("albumCoverId");

		if (albumCoverId != null) {
			setAlbumCoverId(albumCoverId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
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

		Long viewCounter = (Long)attributes.get("viewCounter");

		if (viewCounter != null) {
			setViewCounter(viewCounter);
		}
	}

	public long getAlbumId() {
		return _albumId;
	}

	public void setAlbumId(long albumId) {
		_albumId = albumId;
	}

	public String getAlbumName() {
		return _albumName;
	}

	public void setAlbumName(String albumName) {
		_albumName = albumName;
	}

	public String getAlbumInfo() {
		return _albumInfo;
	}

	public void setAlbumInfo(String albumInfo) {
		_albumInfo = albumInfo;
	}

	public long getAlbumCoverId() {
		return _albumCoverId;
	}

	public void setAlbumCoverId(long albumCoverId) {
		_albumCoverId = albumCoverId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifyDate() {
		return _modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		_modifyDate = modifyDate;
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

	public long getViewCounter() {
		return _viewCounter;
	}

	public void setViewCounter(long viewCounter) {
		_viewCounter = viewCounter;
	}

	public BaseModel<?> getAudioAlbumRemoteModel() {
		return _audioAlbumRemoteModel;
	}

	public void setAudioAlbumRemoteModel(BaseModel<?> audioAlbumRemoteModel) {
		_audioAlbumRemoteModel = audioAlbumRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AudioAlbumLocalServiceUtil.addAudioAlbum(this);
		}
		else {
			AudioAlbumLocalServiceUtil.updateAudioAlbum(this);
		}
	}

	@Override
	public AudioAlbum toEscapedModel() {
		return (AudioAlbum)Proxy.newProxyInstance(AudioAlbum.class.getClassLoader(),
			new Class[] { AudioAlbum.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AudioAlbumClp clone = new AudioAlbumClp();

		clone.setAlbumId(getAlbumId());
		clone.setAlbumName(getAlbumName());
		clone.setAlbumInfo(getAlbumInfo());
		clone.setAlbumCoverId(getAlbumCoverId());
		clone.setCreateDate(getCreateDate());
		clone.setModifyDate(getModifyDate());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setViewCounter(getViewCounter());

		return clone;
	}

	public int compareTo(AudioAlbum audioAlbum) {
		long primaryKey = audioAlbum.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		AudioAlbumClp audioAlbum = null;

		try {
			audioAlbum = (AudioAlbumClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = audioAlbum.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{albumId=");
		sb.append(getAlbumId());
		sb.append(", albumName=");
		sb.append(getAlbumName());
		sb.append(", albumInfo=");
		sb.append(getAlbumInfo());
		sb.append(", albumCoverId=");
		sb.append(getAlbumCoverId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", viewCounter=");
		sb.append(getViewCounter());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.audioplayer.model.AudioAlbum");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>albumId</column-name><column-value><![CDATA[");
		sb.append(getAlbumId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>albumName</column-name><column-value><![CDATA[");
		sb.append(getAlbumName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>albumInfo</column-name><column-value><![CDATA[");
		sb.append(getAlbumInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>albumCoverId</column-name><column-value><![CDATA[");
		sb.append(getAlbumCoverId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifyDate</column-name><column-value><![CDATA[");
		sb.append(getModifyDate());
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
			"<column><column-name>viewCounter</column-name><column-value><![CDATA[");
		sb.append(getViewCounter());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _albumId;
	private String _albumName;
	private String _albumInfo;
	private long _albumCoverId;
	private Date _createDate;
	private Date _modifyDate;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _viewCounter;
	private BaseModel<?> _audioAlbumRemoteModel;
}