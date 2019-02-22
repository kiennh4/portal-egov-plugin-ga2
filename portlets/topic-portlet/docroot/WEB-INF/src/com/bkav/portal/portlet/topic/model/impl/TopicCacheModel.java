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

package com.bkav.portal.portlet.topic.model.impl;

import com.bkav.portal.portlet.topic.model.Topic;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Topic in entity cache.
 *
 * @author anhbdb
 * @see Topic
 * @generated
 */
public class TopicCacheModel implements CacheModel<Topic>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{topicId=");
		sb.append(topicId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", topicName=");
		sb.append(topicName);
		sb.append(", categoryIds=");
		sb.append(categoryIds);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	public Topic toEntityModel() {
		TopicImpl topicImpl = new TopicImpl();

		topicImpl.setTopicId(topicId);
		topicImpl.setGroupId(groupId);
		topicImpl.setCompanyId(companyId);
		topicImpl.setUserId(userId);

		if (userName == null) {
			topicImpl.setUserName(StringPool.BLANK);
		}
		else {
			topicImpl.setUserName(userName);
		}

		if (topicName == null) {
			topicImpl.setTopicName(StringPool.BLANK);
		}
		else {
			topicImpl.setTopicName(topicName);
		}

		if (categoryIds == null) {
			topicImpl.setCategoryIds(StringPool.BLANK);
		}
		else {
			topicImpl.setCategoryIds(categoryIds);
		}

		if (createDate == Long.MIN_VALUE) {
			topicImpl.setCreateDate(null);
		}
		else {
			topicImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			topicImpl.setModifiedDate(null);
		}
		else {
			topicImpl.setModifiedDate(new Date(modifiedDate));
		}

		topicImpl.resetOriginalValues();

		return topicImpl;
	}

	public long topicId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public String topicName;
	public String categoryIds;
	public long createDate;
	public long modifiedDate;
}