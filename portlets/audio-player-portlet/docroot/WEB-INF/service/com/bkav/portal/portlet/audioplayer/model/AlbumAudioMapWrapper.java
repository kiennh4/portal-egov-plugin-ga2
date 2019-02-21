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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AlbumAudioMap}.
 * </p>
 *
 * @author    anhbdb
 * @see       AlbumAudioMap
 * @generated
 */
public class AlbumAudioMapWrapper implements AlbumAudioMap,
	ModelWrapper<AlbumAudioMap> {
	public AlbumAudioMapWrapper(AlbumAudioMap albumAudioMap) {
		_albumAudioMap = albumAudioMap;
	}

	public Class<?> getModelClass() {
		return AlbumAudioMap.class;
	}

	public String getModelClassName() {
		return AlbumAudioMap.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mapId", getMapId());
		attributes.put("albumId", getAlbumId());
		attributes.put("audioId", getAudioId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long mapId = (Long)attributes.get("mapId");

		if (mapId != null) {
			setMapId(mapId);
		}

		Long albumId = (Long)attributes.get("albumId");

		if (albumId != null) {
			setAlbumId(albumId);
		}

		Long audioId = (Long)attributes.get("audioId");

		if (audioId != null) {
			setAudioId(audioId);
		}
	}

	/**
	* Returns the primary key of this album audio map.
	*
	* @return the primary key of this album audio map
	*/
	public long getPrimaryKey() {
		return _albumAudioMap.getPrimaryKey();
	}

	/**
	* Sets the primary key of this album audio map.
	*
	* @param primaryKey the primary key of this album audio map
	*/
	public void setPrimaryKey(long primaryKey) {
		_albumAudioMap.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the map ID of this album audio map.
	*
	* @return the map ID of this album audio map
	*/
	public long getMapId() {
		return _albumAudioMap.getMapId();
	}

	/**
	* Sets the map ID of this album audio map.
	*
	* @param mapId the map ID of this album audio map
	*/
	public void setMapId(long mapId) {
		_albumAudioMap.setMapId(mapId);
	}

	/**
	* Returns the album ID of this album audio map.
	*
	* @return the album ID of this album audio map
	*/
	public long getAlbumId() {
		return _albumAudioMap.getAlbumId();
	}

	/**
	* Sets the album ID of this album audio map.
	*
	* @param albumId the album ID of this album audio map
	*/
	public void setAlbumId(long albumId) {
		_albumAudioMap.setAlbumId(albumId);
	}

	/**
	* Returns the audio ID of this album audio map.
	*
	* @return the audio ID of this album audio map
	*/
	public long getAudioId() {
		return _albumAudioMap.getAudioId();
	}

	/**
	* Sets the audio ID of this album audio map.
	*
	* @param audioId the audio ID of this album audio map
	*/
	public void setAudioId(long audioId) {
		_albumAudioMap.setAudioId(audioId);
	}

	public boolean isNew() {
		return _albumAudioMap.isNew();
	}

	public void setNew(boolean n) {
		_albumAudioMap.setNew(n);
	}

	public boolean isCachedModel() {
		return _albumAudioMap.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_albumAudioMap.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _albumAudioMap.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _albumAudioMap.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_albumAudioMap.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _albumAudioMap.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_albumAudioMap.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AlbumAudioMapWrapper((AlbumAudioMap)_albumAudioMap.clone());
	}

	public int compareTo(
		com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap albumAudioMap) {
		return _albumAudioMap.compareTo(albumAudioMap);
	}

	@Override
	public int hashCode() {
		return _albumAudioMap.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> toCacheModel() {
		return _albumAudioMap.toCacheModel();
	}

	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap toEscapedModel() {
		return new AlbumAudioMapWrapper(_albumAudioMap.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _albumAudioMap.toString();
	}

	public java.lang.String toXmlString() {
		return _albumAudioMap.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_albumAudioMap.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AlbumAudioMap getWrappedAlbumAudioMap() {
		return _albumAudioMap;
	}

	public AlbumAudioMap getWrappedModel() {
		return _albumAudioMap;
	}

	public void resetOriginalValues() {
		_albumAudioMap.resetOriginalValues();
	}

	private AlbumAudioMap _albumAudioMap;
}