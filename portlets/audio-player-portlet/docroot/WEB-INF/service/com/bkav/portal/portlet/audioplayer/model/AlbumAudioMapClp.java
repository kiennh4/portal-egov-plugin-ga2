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

import com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anhbdb
 */
public class AlbumAudioMapClp extends BaseModelImpl<AlbumAudioMap>
	implements AlbumAudioMap {
	public AlbumAudioMapClp() {
	}

	public Class<?> getModelClass() {
		return AlbumAudioMap.class;
	}

	public String getModelClassName() {
		return AlbumAudioMap.class.getName();
	}

	public long getPrimaryKey() {
		return _mapId;
	}

	public void setPrimaryKey(long primaryKey) {
		setMapId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_mapId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mapId", getMapId());
		attributes.put("albumId", getAlbumId());
		attributes.put("audioId", getAudioId());

		return attributes;
	}

	@Override
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

	public long getMapId() {
		return _mapId;
	}

	public void setMapId(long mapId) {
		_mapId = mapId;
	}

	public long getAlbumId() {
		return _albumId;
	}

	public void setAlbumId(long albumId) {
		_albumId = albumId;
	}

	public long getAudioId() {
		return _audioId;
	}

	public void setAudioId(long audioId) {
		_audioId = audioId;
	}

	public BaseModel<?> getAlbumAudioMapRemoteModel() {
		return _albumAudioMapRemoteModel;
	}

	public void setAlbumAudioMapRemoteModel(
		BaseModel<?> albumAudioMapRemoteModel) {
		_albumAudioMapRemoteModel = albumAudioMapRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AlbumAudioMapLocalServiceUtil.addAlbumAudioMap(this);
		}
		else {
			AlbumAudioMapLocalServiceUtil.updateAlbumAudioMap(this);
		}
	}

	@Override
	public AlbumAudioMap toEscapedModel() {
		return (AlbumAudioMap)Proxy.newProxyInstance(AlbumAudioMap.class.getClassLoader(),
			new Class[] { AlbumAudioMap.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AlbumAudioMapClp clone = new AlbumAudioMapClp();

		clone.setMapId(getMapId());
		clone.setAlbumId(getAlbumId());
		clone.setAudioId(getAudioId());

		return clone;
	}

	public int compareTo(AlbumAudioMap albumAudioMap) {
		long primaryKey = albumAudioMap.getPrimaryKey();

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

		AlbumAudioMapClp albumAudioMap = null;

		try {
			albumAudioMap = (AlbumAudioMapClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = albumAudioMap.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{mapId=");
		sb.append(getMapId());
		sb.append(", albumId=");
		sb.append(getAlbumId());
		sb.append(", audioId=");
		sb.append(getAudioId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mapId</column-name><column-value><![CDATA[");
		sb.append(getMapId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>albumId</column-name><column-value><![CDATA[");
		sb.append(getAlbumId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>audioId</column-name><column-value><![CDATA[");
		sb.append(getAudioId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _mapId;
	private long _albumId;
	private long _audioId;
	private BaseModel<?> _albumAudioMapRemoteModel;
}