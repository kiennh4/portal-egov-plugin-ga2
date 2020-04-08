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
 * This class is a wrapper for {@link VideoCategory}.
 * </p>
 *
 * @author    hungdx
 * @see       VideoCategory
 * @generated
 */
public class VideoCategoryWrapper implements VideoCategory,
	ModelWrapper<VideoCategory> {
	public VideoCategoryWrapper(VideoCategory videoCategory) {
		_videoCategory = videoCategory;
	}

	public Class<?> getModelClass() {
		return VideoCategory.class;
	}

	public String getModelClassName() {
		return VideoCategory.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryName", getCategoryName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
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

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}
	}

	/**
	* Returns the primary key of this video category.
	*
	* @return the primary key of this video category
	*/
	public long getPrimaryKey() {
		return _videoCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video category.
	*
	* @param primaryKey the primary key of this video category
	*/
	public void setPrimaryKey(long primaryKey) {
		_videoCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this video category.
	*
	* @return the category ID of this video category
	*/
	public long getCategoryId() {
		return _videoCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this video category.
	*
	* @param categoryId the category ID of this video category
	*/
	public void setCategoryId(long categoryId) {
		_videoCategory.setCategoryId(categoryId);
	}

	/**
	* Returns the group ID of this video category.
	*
	* @return the group ID of this video category
	*/
	public long getGroupId() {
		return _videoCategory.getGroupId();
	}

	/**
	* Sets the group ID of this video category.
	*
	* @param groupId the group ID of this video category
	*/
	public void setGroupId(long groupId) {
		_videoCategory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this video category.
	*
	* @return the company ID of this video category
	*/
	public long getCompanyId() {
		return _videoCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this video category.
	*
	* @param companyId the company ID of this video category
	*/
	public void setCompanyId(long companyId) {
		_videoCategory.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this video category.
	*
	* @return the user ID of this video category
	*/
	public long getUserId() {
		return _videoCategory.getUserId();
	}

	/**
	* Sets the user ID of this video category.
	*
	* @param userId the user ID of this video category
	*/
	public void setUserId(long userId) {
		_videoCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this video category.
	*
	* @return the user uuid of this video category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this video category.
	*
	* @param userUuid the user uuid of this video category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_videoCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this video category.
	*
	* @return the user name of this video category
	*/
	public java.lang.String getUserName() {
		return _videoCategory.getUserName();
	}

	/**
	* Sets the user name of this video category.
	*
	* @param userName the user name of this video category
	*/
	public void setUserName(java.lang.String userName) {
		_videoCategory.setUserName(userName);
	}

	/**
	* Returns the create date of this video category.
	*
	* @return the create date of this video category
	*/
	public java.util.Date getCreateDate() {
		return _videoCategory.getCreateDate();
	}

	/**
	* Sets the create date of this video category.
	*
	* @param createDate the create date of this video category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_videoCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this video category.
	*
	* @return the modified date of this video category
	*/
	public java.util.Date getModifiedDate() {
		return _videoCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this video category.
	*
	* @param modifiedDate the modified date of this video category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_videoCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category name of this video category.
	*
	* @return the category name of this video category
	*/
	public java.lang.String getCategoryName() {
		return _videoCategory.getCategoryName();
	}

	/**
	* Sets the category name of this video category.
	*
	* @param categoryName the category name of this video category
	*/
	public void setCategoryName(java.lang.String categoryName) {
		_videoCategory.setCategoryName(categoryName);
	}

	public boolean isNew() {
		return _videoCategory.isNew();
	}

	public void setNew(boolean n) {
		_videoCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _videoCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_videoCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _videoCategory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _videoCategory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_videoCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _videoCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_videoCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VideoCategoryWrapper((VideoCategory)_videoCategory.clone());
	}

	public int compareTo(VideoCategory videoCategory) {
		return _videoCategory.compareTo(videoCategory);
	}

	@Override
	public int hashCode() {
		return _videoCategory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<VideoCategory> toCacheModel() {
		return _videoCategory.toCacheModel();
	}

	public VideoCategory toEscapedModel() {
		return new VideoCategoryWrapper(_videoCategory.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _videoCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _videoCategory.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_videoCategory.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VideoCategory getWrappedVideoCategory() {
		return _videoCategory;
	}

	public VideoCategory getWrappedModel() {
		return _videoCategory;
	}

	public void resetOriginalValues() {
		_videoCategory.resetOriginalValues();
	}

	private VideoCategory _videoCategory;
}