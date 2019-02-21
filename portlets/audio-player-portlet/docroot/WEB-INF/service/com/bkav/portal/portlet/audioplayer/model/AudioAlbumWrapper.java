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
 * This class is a wrapper for {@link AudioAlbum}.
 * </p>
 *
 * @author    anhbdb
 * @see       AudioAlbum
 * @generated
 */
public class AudioAlbumWrapper implements AudioAlbum, ModelWrapper<AudioAlbum> {
	public AudioAlbumWrapper(AudioAlbum audioAlbum) {
		_audioAlbum = audioAlbum;
	}

	public Class<?> getModelClass() {
		return AudioAlbum.class;
	}

	public String getModelClassName() {
		return AudioAlbum.class.getName();
	}

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

	/**
	* Returns the primary key of this audio album.
	*
	* @return the primary key of this audio album
	*/
	public long getPrimaryKey() {
		return _audioAlbum.getPrimaryKey();
	}

	/**
	* Sets the primary key of this audio album.
	*
	* @param primaryKey the primary key of this audio album
	*/
	public void setPrimaryKey(long primaryKey) {
		_audioAlbum.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the album ID of this audio album.
	*
	* @return the album ID of this audio album
	*/
	public long getAlbumId() {
		return _audioAlbum.getAlbumId();
	}

	/**
	* Sets the album ID of this audio album.
	*
	* @param albumId the album ID of this audio album
	*/
	public void setAlbumId(long albumId) {
		_audioAlbum.setAlbumId(albumId);
	}

	/**
	* Returns the album name of this audio album.
	*
	* @return the album name of this audio album
	*/
	public java.lang.String getAlbumName() {
		return _audioAlbum.getAlbumName();
	}

	/**
	* Sets the album name of this audio album.
	*
	* @param albumName the album name of this audio album
	*/
	public void setAlbumName(java.lang.String albumName) {
		_audioAlbum.setAlbumName(albumName);
	}

	/**
	* Returns the album info of this audio album.
	*
	* @return the album info of this audio album
	*/
	public java.lang.String getAlbumInfo() {
		return _audioAlbum.getAlbumInfo();
	}

	/**
	* Sets the album info of this audio album.
	*
	* @param albumInfo the album info of this audio album
	*/
	public void setAlbumInfo(java.lang.String albumInfo) {
		_audioAlbum.setAlbumInfo(albumInfo);
	}

	/**
	* Returns the album cover ID of this audio album.
	*
	* @return the album cover ID of this audio album
	*/
	public long getAlbumCoverId() {
		return _audioAlbum.getAlbumCoverId();
	}

	/**
	* Sets the album cover ID of this audio album.
	*
	* @param albumCoverId the album cover ID of this audio album
	*/
	public void setAlbumCoverId(long albumCoverId) {
		_audioAlbum.setAlbumCoverId(albumCoverId);
	}

	/**
	* Returns the create date of this audio album.
	*
	* @return the create date of this audio album
	*/
	public java.util.Date getCreateDate() {
		return _audioAlbum.getCreateDate();
	}

	/**
	* Sets the create date of this audio album.
	*
	* @param createDate the create date of this audio album
	*/
	public void setCreateDate(java.util.Date createDate) {
		_audioAlbum.setCreateDate(createDate);
	}

	/**
	* Returns the modify date of this audio album.
	*
	* @return the modify date of this audio album
	*/
	public java.util.Date getModifyDate() {
		return _audioAlbum.getModifyDate();
	}

	/**
	* Sets the modify date of this audio album.
	*
	* @param modifyDate the modify date of this audio album
	*/
	public void setModifyDate(java.util.Date modifyDate) {
		_audioAlbum.setModifyDate(modifyDate);
	}

	/**
	* Returns the group ID of this audio album.
	*
	* @return the group ID of this audio album
	*/
	public long getGroupId() {
		return _audioAlbum.getGroupId();
	}

	/**
	* Sets the group ID of this audio album.
	*
	* @param groupId the group ID of this audio album
	*/
	public void setGroupId(long groupId) {
		_audioAlbum.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this audio album.
	*
	* @return the company ID of this audio album
	*/
	public long getCompanyId() {
		return _audioAlbum.getCompanyId();
	}

	/**
	* Sets the company ID of this audio album.
	*
	* @param companyId the company ID of this audio album
	*/
	public void setCompanyId(long companyId) {
		_audioAlbum.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this audio album.
	*
	* @return the user ID of this audio album
	*/
	public long getUserId() {
		return _audioAlbum.getUserId();
	}

	/**
	* Sets the user ID of this audio album.
	*
	* @param userId the user ID of this audio album
	*/
	public void setUserId(long userId) {
		_audioAlbum.setUserId(userId);
	}

	/**
	* Returns the user uuid of this audio album.
	*
	* @return the user uuid of this audio album
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbum.getUserUuid();
	}

	/**
	* Sets the user uuid of this audio album.
	*
	* @param userUuid the user uuid of this audio album
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_audioAlbum.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this audio album.
	*
	* @return the user name of this audio album
	*/
	public java.lang.String getUserName() {
		return _audioAlbum.getUserName();
	}

	/**
	* Sets the user name of this audio album.
	*
	* @param userName the user name of this audio album
	*/
	public void setUserName(java.lang.String userName) {
		_audioAlbum.setUserName(userName);
	}

	/**
	* Returns the view counter of this audio album.
	*
	* @return the view counter of this audio album
	*/
	public long getViewCounter() {
		return _audioAlbum.getViewCounter();
	}

	/**
	* Sets the view counter of this audio album.
	*
	* @param viewCounter the view counter of this audio album
	*/
	public void setViewCounter(long viewCounter) {
		_audioAlbum.setViewCounter(viewCounter);
	}

	public boolean isNew() {
		return _audioAlbum.isNew();
	}

	public void setNew(boolean n) {
		_audioAlbum.setNew(n);
	}

	public boolean isCachedModel() {
		return _audioAlbum.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_audioAlbum.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _audioAlbum.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _audioAlbum.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_audioAlbum.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _audioAlbum.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_audioAlbum.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AudioAlbumWrapper((AudioAlbum)_audioAlbum.clone());
	}

	public int compareTo(
		com.bkav.portal.portlet.audioplayer.model.AudioAlbum audioAlbum) {
		return _audioAlbum.compareTo(audioAlbum);
	}

	@Override
	public int hashCode() {
		return _audioAlbum.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> toCacheModel() {
		return _audioAlbum.toCacheModel();
	}

	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum toEscapedModel() {
		return new AudioAlbumWrapper(_audioAlbum.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _audioAlbum.toString();
	}

	public java.lang.String toXmlString() {
		return _audioAlbum.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_audioAlbum.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AudioAlbum getWrappedAudioAlbum() {
		return _audioAlbum;
	}

	public AudioAlbum getWrappedModel() {
		return _audioAlbum;
	}

	public void resetOriginalValues() {
		_audioAlbum.resetOriginalValues();
	}

	private AudioAlbum _audioAlbum;
}