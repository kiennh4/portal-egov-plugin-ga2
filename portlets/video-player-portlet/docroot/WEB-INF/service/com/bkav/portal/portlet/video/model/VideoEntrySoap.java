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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bkav.portal.portlet.video.service.http.VideoEntryServiceSoap}.
 *
 * @author    hungdx
 * @see       com.bkav.portal.portlet.video.service.http.VideoEntryServiceSoap
 * @generated
 */
public class VideoEntrySoap implements Serializable {
	public static VideoEntrySoap toSoapModel(VideoEntry model) {
		VideoEntrySoap soapModel = new VideoEntrySoap();

		soapModel.setEntryId(model.getEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setVideoType(model.getVideoType());
		soapModel.setVideoUrl(model.getVideoUrl());
		soapModel.setVideoFileId(model.getVideoFileId());
		soapModel.setThumbnailImage(model.getThumbnailImage());
		soapModel.setThumbnailImageId(model.getThumbnailImageId());

		return soapModel;
	}

	public static VideoEntrySoap[] toSoapModels(VideoEntry[] models) {
		VideoEntrySoap[] soapModels = new VideoEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoEntrySoap[][] toSoapModels(VideoEntry[][] models) {
		VideoEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoEntrySoap[] toSoapModels(List<VideoEntry> models) {
		List<VideoEntrySoap> soapModels = new ArrayList<VideoEntrySoap>(models.size());

		for (VideoEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoEntrySoap[soapModels.size()]);
	}

	public VideoEntrySoap() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long pk) {
		setEntryId(pk);
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getVideoType() {
		return _videoType;
	}

	public void setVideoType(String videoType) {
		_videoType = videoType;
	}

	public String getVideoUrl() {
		return _videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		_videoUrl = videoUrl;
	}

	public long getVideoFileId() {
		return _videoFileId;
	}

	public void setVideoFileId(long videoFileId) {
		_videoFileId = videoFileId;
	}

	public boolean getThumbnailImage() {
		return _thumbnailImage;
	}

	public boolean isThumbnailImage() {
		return _thumbnailImage;
	}

	public void setThumbnailImage(boolean thumbnailImage) {
		_thumbnailImage = thumbnailImage;
	}

	public long getThumbnailImageId() {
		return _thumbnailImageId;
	}

	public void setThumbnailImageId(long thumbnailImageId) {
		_thumbnailImageId = thumbnailImageId;
	}

	private long _entryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _videoType;
	private String _videoUrl;
	private long _videoFileId;
	private boolean _thumbnailImage;
	private long _thumbnailImageId;
}