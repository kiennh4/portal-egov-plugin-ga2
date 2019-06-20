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

package com.bkav.portal.portlet.rss.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RssFeed}.
 * </p>
 *
 * @author    hungdx
 * @see       RssFeed
 * @generated
 */
public class RssFeedWrapper implements RssFeed, ModelWrapper<RssFeed> {
	public RssFeedWrapper(RssFeed rssFeed) {
		_rssFeed = rssFeed;
	}

	public Class<?> getModelClass() {
		return RssFeed.class;
	}

	public String getModelClassName() {
		return RssFeed.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_", getId_());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_ = (Long)attributes.get("id_");

		if (id_ != null) {
			setId_(id_);
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

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this rss feed.
	*
	* @return the primary key of this rss feed
	*/
	public long getPrimaryKey() {
		return _rssFeed.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rss feed.
	*
	* @param primaryKey the primary key of this rss feed
	*/
	public void setPrimaryKey(long primaryKey) {
		_rssFeed.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_ of this rss feed.
	*
	* @return the id_ of this rss feed
	*/
	public long getId_() {
		return _rssFeed.getId_();
	}

	/**
	* Sets the id_ of this rss feed.
	*
	* @param id_ the id_ of this rss feed
	*/
	public void setId_(long id_) {
		_rssFeed.setId_(id_);
	}

	/**
	* Returns the group ID of this rss feed.
	*
	* @return the group ID of this rss feed
	*/
	public long getGroupId() {
		return _rssFeed.getGroupId();
	}

	/**
	* Sets the group ID of this rss feed.
	*
	* @param groupId the group ID of this rss feed
	*/
	public void setGroupId(long groupId) {
		_rssFeed.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this rss feed.
	*
	* @return the company ID of this rss feed
	*/
	public long getCompanyId() {
		return _rssFeed.getCompanyId();
	}

	/**
	* Sets the company ID of this rss feed.
	*
	* @param companyId the company ID of this rss feed
	*/
	public void setCompanyId(long companyId) {
		_rssFeed.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this rss feed.
	*
	* @return the user ID of this rss feed
	*/
	public long getUserId() {
		return _rssFeed.getUserId();
	}

	/**
	* Sets the user ID of this rss feed.
	*
	* @param userId the user ID of this rss feed
	*/
	public void setUserId(long userId) {
		_rssFeed.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rss feed.
	*
	* @return the user uuid of this rss feed
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rssFeed.getUserUuid();
	}

	/**
	* Sets the user uuid of this rss feed.
	*
	* @param userUuid the user uuid of this rss feed
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_rssFeed.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this rss feed.
	*
	* @return the user name of this rss feed
	*/
	public java.lang.String getUserName() {
		return _rssFeed.getUserName();
	}

	/**
	* Sets the user name of this rss feed.
	*
	* @param userName the user name of this rss feed
	*/
	public void setUserName(java.lang.String userName) {
		_rssFeed.setUserName(userName);
	}

	/**
	* Returns the create date of this rss feed.
	*
	* @return the create date of this rss feed
	*/
	public java.util.Date getCreateDate() {
		return _rssFeed.getCreateDate();
	}

	/**
	* Sets the create date of this rss feed.
	*
	* @param createDate the create date of this rss feed
	*/
	public void setCreateDate(java.util.Date createDate) {
		_rssFeed.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this rss feed.
	*
	* @return the modified date of this rss feed
	*/
	public java.util.Date getModifiedDate() {
		return _rssFeed.getModifiedDate();
	}

	/**
	* Sets the modified date of this rss feed.
	*
	* @param modifiedDate the modified date of this rss feed
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_rssFeed.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this rss feed.
	*
	* @return the name of this rss feed
	*/
	public java.lang.String getName() {
		return _rssFeed.getName();
	}

	/**
	* Sets the name of this rss feed.
	*
	* @param name the name of this rss feed
	*/
	public void setName(java.lang.String name) {
		_rssFeed.setName(name);
	}

	/**
	* Returns the url of this rss feed.
	*
	* @return the url of this rss feed
	*/
	public java.lang.String getUrl() {
		return _rssFeed.getUrl();
	}

	/**
	* Sets the url of this rss feed.
	*
	* @param url the url of this rss feed
	*/
	public void setUrl(java.lang.String url) {
		_rssFeed.setUrl(url);
	}

	/**
	* Returns the description of this rss feed.
	*
	* @return the description of this rss feed
	*/
	public java.lang.String getDescription() {
		return _rssFeed.getDescription();
	}

	/**
	* Sets the description of this rss feed.
	*
	* @param description the description of this rss feed
	*/
	public void setDescription(java.lang.String description) {
		_rssFeed.setDescription(description);
	}

	/**
	* Returns the status of this rss feed.
	*
	* @return the status of this rss feed
	*/
	public int getStatus() {
		return _rssFeed.getStatus();
	}

	/**
	* Sets the status of this rss feed.
	*
	* @param status the status of this rss feed
	*/
	public void setStatus(int status) {
		_rssFeed.setStatus(status);
	}

	public boolean isNew() {
		return _rssFeed.isNew();
	}

	public void setNew(boolean n) {
		_rssFeed.setNew(n);
	}

	public boolean isCachedModel() {
		return _rssFeed.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_rssFeed.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _rssFeed.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _rssFeed.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rssFeed.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rssFeed.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rssFeed.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RssFeedWrapper((RssFeed)_rssFeed.clone());
	}

	public int compareTo(com.bkav.portal.portlet.rss.model.RssFeed rssFeed) {
		return _rssFeed.compareTo(rssFeed);
	}

	@Override
	public int hashCode() {
		return _rssFeed.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.rss.model.RssFeed> toCacheModel() {
		return _rssFeed.toCacheModel();
	}

	public com.bkav.portal.portlet.rss.model.RssFeed toEscapedModel() {
		return new RssFeedWrapper(_rssFeed.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rssFeed.toString();
	}

	public java.lang.String toXmlString() {
		return _rssFeed.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rssFeed.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public RssFeed getWrappedRssFeed() {
		return _rssFeed;
	}

	public RssFeed getWrappedModel() {
		return _rssFeed;
	}

	public void resetOriginalValues() {
		_rssFeed.resetOriginalValues();
	}

	private RssFeed _rssFeed;
}