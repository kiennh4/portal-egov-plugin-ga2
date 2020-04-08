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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bkav.portal.portlet.video.service.http.VideoCategoryMapServiceSoap}.
 *
 * @author    hungdx
 * @see       com.bkav.portal.portlet.video.service.http.VideoCategoryMapServiceSoap
 * @generated
 */
public class VideoCategoryMapSoap implements Serializable {
	public static VideoCategoryMapSoap toSoapModel(VideoCategoryMap model) {
		VideoCategoryMapSoap soapModel = new VideoCategoryMapSoap();

		soapModel.setMapId(model.getMapId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setEntryId(model.getEntryId());

		return soapModel;
	}

	public static VideoCategoryMapSoap[] toSoapModels(VideoCategoryMap[] models) {
		VideoCategoryMapSoap[] soapModels = new VideoCategoryMapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoCategoryMapSoap[][] toSoapModels(
		VideoCategoryMap[][] models) {
		VideoCategoryMapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoCategoryMapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoCategoryMapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoCategoryMapSoap[] toSoapModels(
		List<VideoCategoryMap> models) {
		List<VideoCategoryMapSoap> soapModels = new ArrayList<VideoCategoryMapSoap>(models.size());

		for (VideoCategoryMap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoCategoryMapSoap[soapModels.size()]);
	}

	public VideoCategoryMapSoap() {
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

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	private long _mapId;
	private long _categoryId;
	private long _entryId;
}