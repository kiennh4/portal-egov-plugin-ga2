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

package com.bkav.portal.portlet.topic.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Topic}.
 * </p>
 *
 * @author    anhbdb
 * @see       Topic
 * @generated
 */
public class TopicWrapper implements Topic, ModelWrapper<Topic> {
	public TopicWrapper(Topic topic) {
		_topic = topic;
	}

	public Class<?> getModelClass() {
		return Topic.class;
	}

	public String getModelClassName() {
		return Topic.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("topicId", getTopicId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("topicName", getTopicName());
		attributes.put("categoryIds", getCategoryIds());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long topicId = (Long)attributes.get("topicId");

		if (topicId != null) {
			setTopicId(topicId);
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

		String topicName = (String)attributes.get("topicName");

		if (topicName != null) {
			setTopicName(topicName);
		}

		String categoryIds = (String)attributes.get("categoryIds");

		if (categoryIds != null) {
			setCategoryIds(categoryIds);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this topic.
	*
	* @return the primary key of this topic
	*/
	public long getPrimaryKey() {
		return _topic.getPrimaryKey();
	}

	/**
	* Sets the primary key of this topic.
	*
	* @param primaryKey the primary key of this topic
	*/
	public void setPrimaryKey(long primaryKey) {
		_topic.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the topic ID of this topic.
	*
	* @return the topic ID of this topic
	*/
	public long getTopicId() {
		return _topic.getTopicId();
	}

	/**
	* Sets the topic ID of this topic.
	*
	* @param topicId the topic ID of this topic
	*/
	public void setTopicId(long topicId) {
		_topic.setTopicId(topicId);
	}

	/**
	* Returns the group ID of this topic.
	*
	* @return the group ID of this topic
	*/
	public long getGroupId() {
		return _topic.getGroupId();
	}

	/**
	* Sets the group ID of this topic.
	*
	* @param groupId the group ID of this topic
	*/
	public void setGroupId(long groupId) {
		_topic.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this topic.
	*
	* @return the company ID of this topic
	*/
	public long getCompanyId() {
		return _topic.getCompanyId();
	}

	/**
	* Sets the company ID of this topic.
	*
	* @param companyId the company ID of this topic
	*/
	public void setCompanyId(long companyId) {
		_topic.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this topic.
	*
	* @return the user ID of this topic
	*/
	public long getUserId() {
		return _topic.getUserId();
	}

	/**
	* Sets the user ID of this topic.
	*
	* @param userId the user ID of this topic
	*/
	public void setUserId(long userId) {
		_topic.setUserId(userId);
	}

	/**
	* Returns the user uuid of this topic.
	*
	* @return the user uuid of this topic
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _topic.getUserUuid();
	}

	/**
	* Sets the user uuid of this topic.
	*
	* @param userUuid the user uuid of this topic
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_topic.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this topic.
	*
	* @return the user name of this topic
	*/
	public java.lang.String getUserName() {
		return _topic.getUserName();
	}

	/**
	* Sets the user name of this topic.
	*
	* @param userName the user name of this topic
	*/
	public void setUserName(java.lang.String userName) {
		_topic.setUserName(userName);
	}

	/**
	* Returns the topic name of this topic.
	*
	* @return the topic name of this topic
	*/
	public java.lang.String getTopicName() {
		return _topic.getTopicName();
	}

	/**
	* Sets the topic name of this topic.
	*
	* @param topicName the topic name of this topic
	*/
	public void setTopicName(java.lang.String topicName) {
		_topic.setTopicName(topicName);
	}

	/**
	* Returns the category IDs of this topic.
	*
	* @return the category IDs of this topic
	*/
	public java.lang.String getCategoryIds() {
		return _topic.getCategoryIds();
	}

	/**
	* Sets the category IDs of this topic.
	*
	* @param categoryIds the category IDs of this topic
	*/
	public void setCategoryIds(java.lang.String categoryIds) {
		_topic.setCategoryIds(categoryIds);
	}

	/**
	* Returns the create date of this topic.
	*
	* @return the create date of this topic
	*/
	public java.util.Date getCreateDate() {
		return _topic.getCreateDate();
	}

	/**
	* Sets the create date of this topic.
	*
	* @param createDate the create date of this topic
	*/
	public void setCreateDate(java.util.Date createDate) {
		_topic.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this topic.
	*
	* @return the modified date of this topic
	*/
	public java.util.Date getModifiedDate() {
		return _topic.getModifiedDate();
	}

	/**
	* Sets the modified date of this topic.
	*
	* @param modifiedDate the modified date of this topic
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_topic.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _topic.isNew();
	}

	public void setNew(boolean n) {
		_topic.setNew(n);
	}

	public boolean isCachedModel() {
		return _topic.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_topic.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _topic.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _topic.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_topic.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _topic.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_topic.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TopicWrapper((Topic)_topic.clone());
	}

	public int compareTo(com.bkav.portal.portlet.topic.model.Topic topic) {
		return _topic.compareTo(topic);
	}

	@Override
	public int hashCode() {
		return _topic.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.topic.model.Topic> toCacheModel() {
		return _topic.toCacheModel();
	}

	public com.bkav.portal.portlet.topic.model.Topic toEscapedModel() {
		return new TopicWrapper(_topic.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _topic.toString();
	}

	public java.lang.String toXmlString() {
		return _topic.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_topic.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Topic getWrappedTopic() {
		return _topic;
	}

	public Topic getWrappedModel() {
		return _topic;
	}

	public void resetOriginalValues() {
		_topic.resetOriginalValues();
	}

	private Topic _topic;
}