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

import com.bkav.portal.portlet.topic.service.TopicLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anhbdb
 */
public class TopicClp extends BaseModelImpl<Topic> implements Topic {
	public TopicClp() {
	}

	public Class<?> getModelClass() {
		return Topic.class;
	}

	public String getModelClassName() {
		return Topic.class.getName();
	}

	public long getPrimaryKey() {
		return _topicId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTopicId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_topicId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getTopicId() {
		return _topicId;
	}

	public void setTopicId(long topicId) {
		_topicId = topicId;
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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getTopicName() {
		return _topicName;
	}

	public void setTopicName(String topicName) {
		_topicName = topicName;
	}

	public String getCategoryIds() {
		return _categoryIds;
	}

	public void setCategoryIds(String categoryIds) {
		_categoryIds = categoryIds;
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

	public BaseModel<?> getTopicRemoteModel() {
		return _topicRemoteModel;
	}

	public void setTopicRemoteModel(BaseModel<?> topicRemoteModel) {
		_topicRemoteModel = topicRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TopicLocalServiceUtil.addTopic(this);
		}
		else {
			TopicLocalServiceUtil.updateTopic(this);
		}
	}

	@Override
	public Topic toEscapedModel() {
		return (Topic)Proxy.newProxyInstance(Topic.class.getClassLoader(),
			new Class[] { Topic.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TopicClp clone = new TopicClp();

		clone.setTopicId(getTopicId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setTopicName(getTopicName());
		clone.setCategoryIds(getCategoryIds());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(Topic topic) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), topic.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TopicClp topic = null;

		try {
			topic = (TopicClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = topic.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{topicId=");
		sb.append(getTopicId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", topicName=");
		sb.append(getTopicName());
		sb.append(", categoryIds=");
		sb.append(getCategoryIds());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.topic.model.Topic");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>topicId</column-name><column-value><![CDATA[");
		sb.append(getTopicId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>topicName</column-name><column-value><![CDATA[");
		sb.append(getTopicName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryIds</column-name><column-value><![CDATA[");
		sb.append(getCategoryIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _topicId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private String _topicName;
	private String _categoryIds;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _topicRemoteModel;
}