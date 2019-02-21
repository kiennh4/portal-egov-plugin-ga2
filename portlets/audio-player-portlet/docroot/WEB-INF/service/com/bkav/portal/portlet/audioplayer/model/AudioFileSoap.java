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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bkav.portal.portlet.audioplayer.service.http.AudioFileServiceSoap}.
 *
 * @author    anhbdb
 * @see       com.bkav.portal.portlet.audioplayer.service.http.AudioFileServiceSoap
 * @generated
 */
public class AudioFileSoap implements Serializable {
	public static AudioFileSoap toSoapModel(AudioFile model) {
		AudioFileSoap soapModel = new AudioFileSoap();

		soapModel.setAudioId(model.getAudioId());
		soapModel.setAudioName(model.getAudioName());
		soapModel.setAudioInfo(model.getAudioInfo());
		soapModel.setAudioType(model.getAudioType());
		soapModel.setAudioFileId(model.getAudioFileId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifyDate(model.getModifyDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setViewCounter(model.getViewCounter());

		return soapModel;
	}

	public static AudioFileSoap[] toSoapModels(AudioFile[] models) {
		AudioFileSoap[] soapModels = new AudioFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AudioFileSoap[][] toSoapModels(AudioFile[][] models) {
		AudioFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AudioFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AudioFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AudioFileSoap[] toSoapModels(List<AudioFile> models) {
		List<AudioFileSoap> soapModels = new ArrayList<AudioFileSoap>(models.size());

		for (AudioFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AudioFileSoap[soapModels.size()]);
	}

	public AudioFileSoap() {
	}

	public long getPrimaryKey() {
		return _audioId;
	}

	public void setPrimaryKey(long pk) {
		setAudioId(pk);
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
	private String _userName;
	private long _viewCounter;
}