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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AudioFile}.
 * </p>
 *
 * @author    anhbdb
 * @see       AudioFile
 * @generated
 */
public class AudioFileWrapper implements AudioFile, ModelWrapper<AudioFile> {
	public AudioFileWrapper(AudioFile audioFile) {
		_audioFile = audioFile;
	}

	public Class<?> getModelClass() {
		return AudioFile.class;
	}

	public String getModelClassName() {
		return AudioFile.class.getName();
	}

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

	/**
	* Returns the primary key of this audio file.
	*
	* @return the primary key of this audio file
	*/
	public long getPrimaryKey() {
		return _audioFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this audio file.
	*
	* @param primaryKey the primary key of this audio file
	*/
	public void setPrimaryKey(long primaryKey) {
		_audioFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the audio ID of this audio file.
	*
	* @return the audio ID of this audio file
	*/
	public long getAudioId() {
		return _audioFile.getAudioId();
	}

	/**
	* Sets the audio ID of this audio file.
	*
	* @param audioId the audio ID of this audio file
	*/
	public void setAudioId(long audioId) {
		_audioFile.setAudioId(audioId);
	}

	/**
	* Returns the audio name of this audio file.
	*
	* @return the audio name of this audio file
	*/
	public java.lang.String getAudioName() {
		return _audioFile.getAudioName();
	}

	/**
	* Sets the audio name of this audio file.
	*
	* @param audioName the audio name of this audio file
	*/
	public void setAudioName(java.lang.String audioName) {
		_audioFile.setAudioName(audioName);
	}

	/**
	* Returns the audio info of this audio file.
	*
	* @return the audio info of this audio file
	*/
	public java.lang.String getAudioInfo() {
		return _audioFile.getAudioInfo();
	}

	/**
	* Sets the audio info of this audio file.
	*
	* @param audioInfo the audio info of this audio file
	*/
	public void setAudioInfo(java.lang.String audioInfo) {
		_audioFile.setAudioInfo(audioInfo);
	}

	/**
	* Returns the audio type of this audio file.
	*
	* @return the audio type of this audio file
	*/
	public java.lang.String getAudioType() {
		return _audioFile.getAudioType();
	}

	/**
	* Sets the audio type of this audio file.
	*
	* @param audioType the audio type of this audio file
	*/
	public void setAudioType(java.lang.String audioType) {
		_audioFile.setAudioType(audioType);
	}

	/**
	* Returns the audio file ID of this audio file.
	*
	* @return the audio file ID of this audio file
	*/
	public long getAudioFileId() {
		return _audioFile.getAudioFileId();
	}

	/**
	* Sets the audio file ID of this audio file.
	*
	* @param audioFileId the audio file ID of this audio file
	*/
	public void setAudioFileId(long audioFileId) {
		_audioFile.setAudioFileId(audioFileId);
	}

	/**
	* Returns the create date of this audio file.
	*
	* @return the create date of this audio file
	*/
	public java.util.Date getCreateDate() {
		return _audioFile.getCreateDate();
	}

	/**
	* Sets the create date of this audio file.
	*
	* @param createDate the create date of this audio file
	*/
	public void setCreateDate(java.util.Date createDate) {
		_audioFile.setCreateDate(createDate);
	}

	/**
	* Returns the modify date of this audio file.
	*
	* @return the modify date of this audio file
	*/
	public java.util.Date getModifyDate() {
		return _audioFile.getModifyDate();
	}

	/**
	* Sets the modify date of this audio file.
	*
	* @param modifyDate the modify date of this audio file
	*/
	public void setModifyDate(java.util.Date modifyDate) {
		_audioFile.setModifyDate(modifyDate);
	}

	/**
	* Returns the group ID of this audio file.
	*
	* @return the group ID of this audio file
	*/
	public long getGroupId() {
		return _audioFile.getGroupId();
	}

	/**
	* Sets the group ID of this audio file.
	*
	* @param groupId the group ID of this audio file
	*/
	public void setGroupId(long groupId) {
		_audioFile.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this audio file.
	*
	* @return the company ID of this audio file
	*/
	public long getCompanyId() {
		return _audioFile.getCompanyId();
	}

	/**
	* Sets the company ID of this audio file.
	*
	* @param companyId the company ID of this audio file
	*/
	public void setCompanyId(long companyId) {
		_audioFile.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this audio file.
	*
	* @return the user ID of this audio file
	*/
	public long getUserId() {
		return _audioFile.getUserId();
	}

	/**
	* Sets the user ID of this audio file.
	*
	* @param userId the user ID of this audio file
	*/
	public void setUserId(long userId) {
		_audioFile.setUserId(userId);
	}

	/**
	* Returns the user uuid of this audio file.
	*
	* @return the user uuid of this audio file
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFile.getUserUuid();
	}

	/**
	* Sets the user uuid of this audio file.
	*
	* @param userUuid the user uuid of this audio file
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_audioFile.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this audio file.
	*
	* @return the user name of this audio file
	*/
	public java.lang.String getUserName() {
		return _audioFile.getUserName();
	}

	/**
	* Sets the user name of this audio file.
	*
	* @param userName the user name of this audio file
	*/
	public void setUserName(java.lang.String userName) {
		_audioFile.setUserName(userName);
	}

	/**
	* Returns the view counter of this audio file.
	*
	* @return the view counter of this audio file
	*/
	public long getViewCounter() {
		return _audioFile.getViewCounter();
	}

	/**
	* Sets the view counter of this audio file.
	*
	* @param viewCounter the view counter of this audio file
	*/
	public void setViewCounter(long viewCounter) {
		_audioFile.setViewCounter(viewCounter);
	}

	public boolean isNew() {
		return _audioFile.isNew();
	}

	public void setNew(boolean n) {
		_audioFile.setNew(n);
	}

	public boolean isCachedModel() {
		return _audioFile.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_audioFile.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _audioFile.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _audioFile.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_audioFile.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _audioFile.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_audioFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AudioFileWrapper((AudioFile)_audioFile.clone());
	}

	public int compareTo(
		com.bkav.portal.portlet.audioplayer.model.AudioFile audioFile) {
		return _audioFile.compareTo(audioFile);
	}

	@Override
	public int hashCode() {
		return _audioFile.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.audioplayer.model.AudioFile> toCacheModel() {
		return _audioFile.toCacheModel();
	}

	public com.bkav.portal.portlet.audioplayer.model.AudioFile toEscapedModel() {
		return new AudioFileWrapper(_audioFile.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _audioFile.toString();
	}

	public java.lang.String toXmlString() {
		return _audioFile.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_audioFile.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AudioFile getWrappedAudioFile() {
		return _audioFile;
	}

	public AudioFile getWrappedModel() {
		return _audioFile;
	}

	public void resetOriginalValues() {
		_audioFile.resetOriginalValues();
	}

	private AudioFile _audioFile;
}