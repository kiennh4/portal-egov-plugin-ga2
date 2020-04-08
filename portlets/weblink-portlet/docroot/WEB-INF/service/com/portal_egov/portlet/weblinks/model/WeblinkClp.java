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

package com.portal_egov.portlet.weblinks.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.weblinks.service.WeblinkLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class WeblinkClp extends BaseModelImpl<Weblink> implements Weblink {
	public WeblinkClp() {
	}

	public Class<?> getModelClass() {
		return Weblink.class;
	}

	public String getModelClassName() {
		return Weblink.class.getName();
	}

	public long getPrimaryKey() {
		return _weblinkId;
	}

	public void setPrimaryKey(long primaryKey) {
		setWeblinkId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_weblinkId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("weblinkId", getWeblinkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("weblinkCategoryId", getWeblinkCategoryId());
		attributes.put("weblinkName", getWeblinkName());
		attributes.put("weblinkDesc", getWeblinkDesc());
		attributes.put("weblinkURL", getWeblinkURL());
		attributes.put("weblinkIconId", getWeblinkIconId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long weblinkId = (Long)attributes.get("weblinkId");

		if (weblinkId != null) {
			setWeblinkId(weblinkId);
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

		Long weblinkCategoryId = (Long)attributes.get("weblinkCategoryId");

		if (weblinkCategoryId != null) {
			setWeblinkCategoryId(weblinkCategoryId);
		}

		String weblinkName = (String)attributes.get("weblinkName");

		if (weblinkName != null) {
			setWeblinkName(weblinkName);
		}

		String weblinkDesc = (String)attributes.get("weblinkDesc");

		if (weblinkDesc != null) {
			setWeblinkDesc(weblinkDesc);
		}

		String weblinkURL = (String)attributes.get("weblinkURL");

		if (weblinkURL != null) {
			setWeblinkURL(weblinkURL);
		}

		Long weblinkIconId = (Long)attributes.get("weblinkIconId");

		if (weblinkIconId != null) {
			setWeblinkIconId(weblinkIconId);
		}
	}

	public long getWeblinkId() {
		return _weblinkId;
	}

	public void setWeblinkId(long weblinkId) {
		_weblinkId = weblinkId;
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

	public long getWeblinkCategoryId() {
		return _weblinkCategoryId;
	}

	public void setWeblinkCategoryId(long weblinkCategoryId) {
		_weblinkCategoryId = weblinkCategoryId;
	}

	public String getWeblinkName() {
		return _weblinkName;
	}

	public void setWeblinkName(String weblinkName) {
		_weblinkName = weblinkName;
	}

	public String getWeblinkDesc() {
		return _weblinkDesc;
	}

	public void setWeblinkDesc(String weblinkDesc) {
		_weblinkDesc = weblinkDesc;
	}

	public String getWeblinkURL() {
		return _weblinkURL;
	}

	public void setWeblinkURL(String weblinkURL) {
		_weblinkURL = weblinkURL;
	}

	public long getWeblinkIconId() {
		return _weblinkIconId;
	}

	public void setWeblinkIconId(long weblinkIconId) {
		_weblinkIconId = weblinkIconId;
	}

	public BaseModel<?> getWeblinkRemoteModel() {
		return _weblinkRemoteModel;
	}

	public void setWeblinkRemoteModel(BaseModel<?> weblinkRemoteModel) {
		_weblinkRemoteModel = weblinkRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			WeblinkLocalServiceUtil.addWeblink(this);
		}
		else {
			WeblinkLocalServiceUtil.updateWeblink(this);
		}
	}

	@Override
	public Weblink toEscapedModel() {
		return (Weblink)Proxy.newProxyInstance(Weblink.class.getClassLoader(),
			new Class[] { Weblink.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WeblinkClp clone = new WeblinkClp();

		clone.setWeblinkId(getWeblinkId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setWeblinkCategoryId(getWeblinkCategoryId());
		clone.setWeblinkName(getWeblinkName());
		clone.setWeblinkDesc(getWeblinkDesc());
		clone.setWeblinkURL(getWeblinkURL());
		clone.setWeblinkIconId(getWeblinkIconId());

		return clone;
	}

	public int compareTo(Weblink weblink) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), weblink.getCreateDate());

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

		WeblinkClp weblink = null;

		try {
			weblink = (WeblinkClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = weblink.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{weblinkId=");
		sb.append(getWeblinkId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", weblinkCategoryId=");
		sb.append(getWeblinkCategoryId());
		sb.append(", weblinkName=");
		sb.append(getWeblinkName());
		sb.append(", weblinkDesc=");
		sb.append(getWeblinkDesc());
		sb.append(", weblinkURL=");
		sb.append(getWeblinkURL());
		sb.append(", weblinkIconId=");
		sb.append(getWeblinkIconId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.weblinks.model.Weblink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>weblinkId</column-name><column-value><![CDATA[");
		sb.append(getWeblinkId());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weblinkCategoryId</column-name><column-value><![CDATA[");
		sb.append(getWeblinkCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weblinkName</column-name><column-value><![CDATA[");
		sb.append(getWeblinkName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weblinkDesc</column-name><column-value><![CDATA[");
		sb.append(getWeblinkDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weblinkURL</column-name><column-value><![CDATA[");
		sb.append(getWeblinkURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weblinkIconId</column-name><column-value><![CDATA[");
		sb.append(getWeblinkIconId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _weblinkId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _weblinkCategoryId;
	private String _weblinkName;
	private String _weblinkDesc;
	private String _weblinkURL;
	private long _weblinkIconId;
	private BaseModel<?> _weblinkRemoteModel;
}