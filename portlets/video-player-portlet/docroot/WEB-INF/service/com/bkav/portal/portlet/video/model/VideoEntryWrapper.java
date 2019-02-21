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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VideoEntry}.
 * </p>
 *
 * @author    hungdx
 * @see       VideoEntry
 * @generated
 */
public class VideoEntryWrapper implements VideoEntry, ModelWrapper<VideoEntry> {
	public VideoEntryWrapper(VideoEntry videoEntry) {
		_videoEntry = videoEntry;
	}

	public Class<?> getModelClass() {
		return VideoEntry.class;
	}

	public String getModelClassName() {
		return VideoEntry.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("videoType", getVideoType());
		attributes.put("videoUrl", getVideoUrl());
		attributes.put("videoFileId", getVideoFileId());
		attributes.put("thumbnailImage", getThumbnailImage());
		attributes.put("thumbnailImageId", getThumbnailImageId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String videoType = (String)attributes.get("videoType");

		if (videoType != null) {
			setVideoType(videoType);
		}

		String videoUrl = (String)attributes.get("videoUrl");

		if (videoUrl != null) {
			setVideoUrl(videoUrl);
		}

		Long videoFileId = (Long)attributes.get("videoFileId");

		if (videoFileId != null) {
			setVideoFileId(videoFileId);
		}

		Boolean thumbnailImage = (Boolean)attributes.get("thumbnailImage");

		if (thumbnailImage != null) {
			setThumbnailImage(thumbnailImage);
		}

		Long thumbnailImageId = (Long)attributes.get("thumbnailImageId");

		if (thumbnailImageId != null) {
			setThumbnailImageId(thumbnailImageId);
		}
	}

	/**
	* Returns the primary key of this video entry.
	*
	* @return the primary key of this video entry
	*/
	public long getPrimaryKey() {
		return _videoEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video entry.
	*
	* @param primaryKey the primary key of this video entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_videoEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the entry ID of this video entry.
	*
	* @return the entry ID of this video entry
	*/
	public long getEntryId() {
		return _videoEntry.getEntryId();
	}

	/**
	* Sets the entry ID of this video entry.
	*
	* @param entryId the entry ID of this video entry
	*/
	public void setEntryId(long entryId) {
		_videoEntry.setEntryId(entryId);
	}

	/**
	* Returns the group ID of this video entry.
	*
	* @return the group ID of this video entry
	*/
	public long getGroupId() {
		return _videoEntry.getGroupId();
	}

	/**
	* Sets the group ID of this video entry.
	*
	* @param groupId the group ID of this video entry
	*/
	public void setGroupId(long groupId) {
		_videoEntry.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this video entry.
	*
	* @return the company ID of this video entry
	*/
	public long getCompanyId() {
		return _videoEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this video entry.
	*
	* @param companyId the company ID of this video entry
	*/
	public void setCompanyId(long companyId) {
		_videoEntry.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this video entry.
	*
	* @return the user ID of this video entry
	*/
	public long getUserId() {
		return _videoEntry.getUserId();
	}

	/**
	* Sets the user ID of this video entry.
	*
	* @param userId the user ID of this video entry
	*/
	public void setUserId(long userId) {
		_videoEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this video entry.
	*
	* @return the user uuid of this video entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this video entry.
	*
	* @param userUuid the user uuid of this video entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_videoEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this video entry.
	*
	* @return the user name of this video entry
	*/
	public java.lang.String getUserName() {
		return _videoEntry.getUserName();
	}

	/**
	* Sets the user name of this video entry.
	*
	* @param userName the user name of this video entry
	*/
	public void setUserName(java.lang.String userName) {
		_videoEntry.setUserName(userName);
	}

	/**
	* Returns the create date of this video entry.
	*
	* @return the create date of this video entry
	*/
	public java.util.Date getCreateDate() {
		return _videoEntry.getCreateDate();
	}

	/**
	* Sets the create date of this video entry.
	*
	* @param createDate the create date of this video entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_videoEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this video entry.
	*
	* @return the modified date of this video entry
	*/
	public java.util.Date getModifiedDate() {
		return _videoEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this video entry.
	*
	* @param modifiedDate the modified date of this video entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_videoEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this video entry.
	*
	* @return the name of this video entry
	*/
	public java.lang.String getName() {
		return _videoEntry.getName();
	}

	/**
	* Sets the name of this video entry.
	*
	* @param name the name of this video entry
	*/
	public void setName(java.lang.String name) {
		_videoEntry.setName(name);
	}

	/**
	* Returns the description of this video entry.
	*
	* @return the description of this video entry
	*/
	public java.lang.String getDescription() {
		return _videoEntry.getDescription();
	}

	/**
	* Sets the description of this video entry.
	*
	* @param description the description of this video entry
	*/
	public void setDescription(java.lang.String description) {
		_videoEntry.setDescription(description);
	}

	/**
	* Returns the video type of this video entry.
	*
	* @return the video type of this video entry
	*/
	public java.lang.String getVideoType() {
		return _videoEntry.getVideoType();
	}

	/**
	* Sets the video type of this video entry.
	*
	* @param videoType the video type of this video entry
	*/
	public void setVideoType(java.lang.String videoType) {
		_videoEntry.setVideoType(videoType);
	}

	/**
	* Returns the video url of this video entry.
	*
	* @return the video url of this video entry
	*/
	public java.lang.String getVideoUrl() {
		return _videoEntry.getVideoUrl();
	}

	/**
	* Sets the video url of this video entry.
	*
	* @param videoUrl the video url of this video entry
	*/
	public void setVideoUrl(java.lang.String videoUrl) {
		_videoEntry.setVideoUrl(videoUrl);
	}

	/**
	* Returns the video file ID of this video entry.
	*
	* @return the video file ID of this video entry
	*/
	public long getVideoFileId() {
		return _videoEntry.getVideoFileId();
	}

	/**
	* Sets the video file ID of this video entry.
	*
	* @param videoFileId the video file ID of this video entry
	*/
	public void setVideoFileId(long videoFileId) {
		_videoEntry.setVideoFileId(videoFileId);
	}

	/**
	* Returns the thumbnail image of this video entry.
	*
	* @return the thumbnail image of this video entry
	*/
	public boolean getThumbnailImage() {
		return _videoEntry.getThumbnailImage();
	}

	/**
	* Returns <code>true</code> if this video entry is thumbnail image.
	*
	* @return <code>true</code> if this video entry is thumbnail image; <code>false</code> otherwise
	*/
	public boolean isThumbnailImage() {
		return _videoEntry.isThumbnailImage();
	}

	/**
	* Sets whether this video entry is thumbnail image.
	*
	* @param thumbnailImage the thumbnail image of this video entry
	*/
	public void setThumbnailImage(boolean thumbnailImage) {
		_videoEntry.setThumbnailImage(thumbnailImage);
	}

	/**
	* Returns the thumbnail image ID of this video entry.
	*
	* @return the thumbnail image ID of this video entry
	*/
	public long getThumbnailImageId() {
		return _videoEntry.getThumbnailImageId();
	}

	/**
	* Sets the thumbnail image ID of this video entry.
	*
	* @param thumbnailImageId the thumbnail image ID of this video entry
	*/
	public void setThumbnailImageId(long thumbnailImageId) {
		_videoEntry.setThumbnailImageId(thumbnailImageId);
	}

	public boolean isNew() {
		return _videoEntry.isNew();
	}

	public void setNew(boolean n) {
		_videoEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _videoEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_videoEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _videoEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _videoEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_videoEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _videoEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_videoEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VideoEntryWrapper((VideoEntry)_videoEntry.clone());
	}

	public int compareTo(
		com.bkav.portal.portlet.video.model.VideoEntry videoEntry) {
		return _videoEntry.compareTo(videoEntry);
	}

	@Override
	public int hashCode() {
		return _videoEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.video.model.VideoEntry> toCacheModel() {
		return _videoEntry.toCacheModel();
	}

	public com.bkav.portal.portlet.video.model.VideoEntry toEscapedModel() {
		return new VideoEntryWrapper(_videoEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _videoEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _videoEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_videoEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VideoEntry getWrappedVideoEntry() {
		return _videoEntry;
	}

	public VideoEntry getWrappedModel() {
		return _videoEntry;
	}

	public void resetOriginalValues() {
		_videoEntry.resetOriginalValues();
	}

	private VideoEntry _videoEntry;
}