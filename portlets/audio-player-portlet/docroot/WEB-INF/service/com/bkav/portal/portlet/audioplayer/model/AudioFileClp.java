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

import com.bkav.portal.portlet.audioplayer.service.AudioFileLocalServiceUtil;

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
public class AudioFileClp extends BaseModelImpl<AudioFile> implements AudioFile {
	public AudioFileClp() {
	}

	public Class<?> getModelClass() {
		return AudioFile.class;
	}

	public String getModelClassName() {
		return AudioFile.class.getName();
	}

	public long getPrimaryKey() {
		return _audioId;
	}

	public void setPrimaryKey(long primaryKey) {
		setAudioId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_audioId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("audioId", getAudioId());
		attributes.put("audioName", getAudioName());
		attributes.put("audioInfo", getAudioInfo());
		attributes.put("audioType", getAudioType());
		attributes.put("audioFileId", getAudioFileId());
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
		Long audioId = (Long)attributes.get("audioId");

		if (audioId != null) {
			setAudioId(audioId);
		}

		String audioName = (String)attributes.get("audioName");

		if (audioName != null) {
			setAudioName(audioName);
		}

		String audioInfo = (String)attributes.get("audioInfo");

		if (audioInfo != null) {
			setAudioInfo(audioInfo);
		}

		String audioType = (String)attributes.get("audioType");

		if (audioType != null) {
			setAudioType(audioType);
		}

		Long audioFileId = (Long)attributes.get("audioFileId");

		if (audioFileId != null) {
			setAudioFileId(audioFileId);
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

	public long getAudioId() {
		return _audioId;
	}

	public void setAudioId(long audioId) {
		_audioId = audioId;
	}

	public String getAudioName() {
		return _audioName;
	}

	public void setAudioName(String audioName) {
		_audioName = audioName;
	}

	public String getAudioInfo() {
		return _audioInfo;
	}

	public void setAudioInfo(String audioInfo) {
		_audioInfo = audioInfo;
	}

	public String getAudioType() {
		return _audioType;
	}

	public void setAudioType(String audioType) {
		_audioType = audioType;
	}

	public long getAudioFileId() {
		return _audioFileId;
	}

	public void setAudioFileId(long audioFileId) {
		_audioFileId = audioFileId;
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

	public BaseModel<?> getAudioFileRemoteModel() {
		return _audioFileRemoteModel;
	}

	public void setAudioFileRemoteModel(BaseModel<?> audioFileRemoteModel) {
		_audioFileRemoteModel = audioFileRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AudioFileLocalServiceUtil.addAudioFile(this);
		}
		else {
			AudioFileLocalServiceUtil.updateAudioFile(this);
		}
	}

	@Override
	public AudioFile toEscapedModel() {
		return (AudioFile)Proxy.newProxyInstance(AudioFile.class.getClassLoader(),
			new Class[] { AudioFile.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AudioFileClp clone = new AudioFileClp();

		clone.setAudioId(getAudioId());
		clone.setAudioName(getAudioName());
		clone.setAudioInfo(getAudioInfo());
		clone.setAudioType(getAudioType());
		clone.setAudioFileId(getAudioFileId());
		clone.setCreateDate(getCreateDate());
		clone.setModifyDate(getModifyDate());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setViewCounter(getViewCounter());

		return clone;
	}

	public int compareTo(AudioFile audioFile) {
		long primaryKey = audioFile.getPrimaryKey();

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

		AudioFileClp audioFile = null;

		try {
			audioFile = (AudioFileClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = audioFile.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{audioId=");
		sb.append(getAudioId());
		sb.append(", audioName=");
		sb.append(getAudioName());
		sb.append(", audioInfo=");
		sb.append(getAudioInfo());
		sb.append(", audioType=");
		sb.append(getAudioType());
		sb.append(", audioFileId=");
		sb.append(getAudioFileId());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.audioplayer.model.AudioFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>audioId</column-name><column-value><![CDATA[");
		sb.append(getAudioId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>audioName</column-name><column-value><![CDATA[");
		sb.append(getAudioName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>audioInfo</column-name><column-value><![CDATA[");
		sb.append(getAudioInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>audioType</column-name><column-value><![CDATA[");
		sb.append(getAudioType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>audioFileId</column-name><column-value><![CDATA[");
		sb.append(getAudioFileId());
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

	private long _audioId;
	private String _audioName;
	private String _audioInfo;
	private String _audioType;
	private long _audioFileId;
	private Date _createDate;
	private Date _modifyDate;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _viewCounter;
	private BaseModel<?> _audioFileRemoteModel;
}