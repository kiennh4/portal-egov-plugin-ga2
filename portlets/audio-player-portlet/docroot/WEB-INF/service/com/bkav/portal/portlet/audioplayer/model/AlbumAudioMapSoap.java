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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bkav.portal.portlet.audioplayer.service.http.AlbumAudioMapServiceSoap}.
 *
 * @author    anhbdb
 * @see       com.bkav.portal.portlet.audioplayer.service.http.AlbumAudioMapServiceSoap
 * @generated
 */
public class AlbumAudioMapSoap implements Serializable {
	public static AlbumAudioMapSoap toSoapModel(AlbumAudioMap model) {
		AlbumAudioMapSoap soapModel = new AlbumAudioMapSoap();

		soapModel.setMapId(model.getMapId());
		soapModel.setAlbumId(model.getAlbumId());
		soapModel.setAudioId(model.getAudioId());

		return soapModel;
	}

	public static AlbumAudioMapSoap[] toSoapModels(AlbumAudioMap[] models) {
		AlbumAudioMapSoap[] soapModels = new AlbumAudioMapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AlbumAudioMapSoap[][] toSoapModels(AlbumAudioMap[][] models) {
		AlbumAudioMapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AlbumAudioMapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AlbumAudioMapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AlbumAudioMapSoap[] toSoapModels(List<AlbumAudioMap> models) {
		List<AlbumAudioMapSoap> soapModels = new ArrayList<AlbumAudioMapSoap>(models.size());

		for (AlbumAudioMap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AlbumAudioMapSoap[soapModels.size()]);
	}

	public AlbumAudioMapSoap() {
	}

	public long getPrimaryKey() {
		return _mapId;
	}

	public void setPrimaryKey(long pk) {
		setMapId(pk);
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

	private long _mapId;
	private long _albumId;
	private long _audioId;
}