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

package com.bkav.portal.portlet.contentsharing.model;

import com.bkav.portal.portlet.contentsharing.service.ContentSharingLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anhbdb
 */
public class ContentSharingClp extends BaseModelImpl<ContentSharing>
	implements ContentSharing {
	public ContentSharingClp() {
	}

	public Class<?> getModelClass() {
		return ContentSharing.class;
	}

	public String getModelClassName() {
		return ContentSharing.class.getName();
	}

	public long getPrimaryKey() {
		return _contentId;
	}

	public void setPrimaryKey(long primaryKey) {
		setContentId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_contentId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contentId", getContentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("contentSharing", getContentSharing());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contentId = (Long)attributes.get("contentId");

		if (contentId != null) {
			setContentId(contentId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String contentSharing = (String)attributes.get("contentSharing");

		if (contentSharing != null) {
			setContentSharing(contentSharing);
		}
	}

	public long getContentId() {
		return _contentId;
	}

	public void setContentId(long contentId) {
		_contentId = contentId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getContentSharing() {
		return _contentSharing;
	}

	public void setContentSharing(String contentSharing) {
		_contentSharing = contentSharing;
	}

	public BaseModel<?> getContentSharingRemoteModel() {
		return _contentSharingRemoteModel;
	}

	public void setContentSharingRemoteModel(
		BaseModel<?> contentSharingRemoteModel) {
		_contentSharingRemoteModel = contentSharingRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ContentSharingLocalServiceUtil.addContentSharing(this);
		}
		else {
			ContentSharingLocalServiceUtil.updateContentSharing(this);
		}
	}

	@Override
	public ContentSharing toEscapedModel() {
		return (ContentSharing)Proxy.newProxyInstance(ContentSharing.class.getClassLoader(),
			new Class[] { ContentSharing.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContentSharingClp clone = new ContentSharingClp();

		clone.setContentId(getContentId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setContentSharing(getContentSharing());

		return clone;
	}

	public int compareTo(ContentSharing contentSharing) {
		long primaryKey = contentSharing.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ContentSharingClp contentSharing = null;

		try {
			contentSharing = (ContentSharingClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = contentSharing.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{contentId=");
		sb.append(getContentId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", contentSharing=");
		sb.append(getContentSharing());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.contentsharing.model.ContentSharing");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contentId</column-name><column-value><![CDATA[");
		sb.append(getContentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentSharing</column-name><column-value><![CDATA[");
		sb.append(getContentSharing());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contentId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _contentSharing;
	private BaseModel<?> _contentSharingRemoteModel;
}