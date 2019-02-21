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
 * This class is used by SOAP remote services, specifically {@link com.bkav.portal.portlet.audioplayer.service.http.AudioAlbumServiceSoap}.
 *
 * @author    anhbdb
 * @see       com.bkav.portal.portlet.audioplayer.service.http.AudioAlbumServiceSoap
 * @generated
 */
public class AudioAlbumSoap implements Serializable {
	public static AudioAlbumSoap toSoapModel(AudioAlbum model) {
		AudioAlbumSoap soapModel = new AudioAlbumSoap();

		soapModel.setAlbumId(model.getAlbumId());
		soapModel.setAlbumName(model.getAlbumName());
		soapModel.setAlbumInfo(model.getAlbumInfo());
		soapModel.setAlbumCoverId(model.getAlbumCoverId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifyDate(model.getModifyDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setViewCounter(model.getViewCounter());

		return soapModel;
	}

	public static AudioAlbumSoap[] toSoapModels(AudioAlbum[] models) {
		AudioAlbumSoap[] soapModels = new AudioAlbumSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AudioAlbumSoap[][] toSoapModels(AudioAlbum[][] models) {
		AudioAlbumSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AudioAlbumSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AudioAlbumSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AudioAlbumSoap[] toSoapModels(List<AudioAlbum> models) {
		List<AudioAlbumSoap> soapModels = new ArrayList<AudioAlbumSoap>(models.size());

		for (AudioAlbum model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AudioAlbumSoap[soapModels.size()]);
	}

	public AudioAlbumSoap() {
	}

	public long getPrimaryKey() {
		return _albumId;
	}

	public void setPrimaryKey(long pk) {
		setAlbumId(pk);
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

	private long _albumId;
	private String _albumName;
	private String _albumInfo;
	private long _albumCoverId;
	private Date _createDate;
	private Date _modifyDate;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private long _viewCounter;
}