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

package com.portal_egov.portlet.banner.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.banner.service.BannerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class BannerClp extends BaseModelImpl<Banner> implements Banner {
	public BannerClp() {
	}

	public Class<?> getModelClass() {
		return Banner.class;
	}

	public String getModelClassName() {
		return Banner.class.getName();
	}

	public long getPrimaryKey() {
		return _bannerId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBannerId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_bannerId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bannerId", getBannerId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("bannerGroupId", getBannerGroupId());
		attributes.put("bannerTitle", getBannerTitle());
		attributes.put("bannerLink", getBannerLink());
		attributes.put("bannerImageId", getBannerImageId());
		attributes.put("viewCounter", getViewCounter());
		attributes.put("bannerStatus", getBannerStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bannerId = (Long)attributes.get("bannerId");

		if (bannerId != null) {
			setBannerId(bannerId);
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

		Long bannerGroupId = (Long)attributes.get("bannerGroupId");

		if (bannerGroupId != null) {
			setBannerGroupId(bannerGroupId);
		}

		String bannerTitle = (String)attributes.get("bannerTitle");

		if (bannerTitle != null) {
			setBannerTitle(bannerTitle);
		}

		String bannerLink = (String)attributes.get("bannerLink");

		if (bannerLink != null) {
			setBannerLink(bannerLink);
		}

		Long bannerImageId = (Long)attributes.get("bannerImageId");

		if (bannerImageId != null) {
			setBannerImageId(bannerImageId);
		}

		Integer viewCounter = (Integer)attributes.get("viewCounter");

		if (viewCounter != null) {
			setViewCounter(viewCounter);
		}

		Integer bannerStatus = (Integer)attributes.get("bannerStatus");

		if (bannerStatus != null) {
			setBannerStatus(bannerStatus);
		}
	}

	public long getBannerId() {
		return _bannerId;
	}

	public void setBannerId(long bannerId) {
		_bannerId = bannerId;
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

	public long getBannerGroupId() {
		return _bannerGroupId;
	}

	public void setBannerGroupId(long bannerGroupId) {
		_bannerGroupId = bannerGroupId;
	}

	public String getBannerTitle() {
		return _bannerTitle;
	}

	public void setBannerTitle(String bannerTitle) {
		_bannerTitle = bannerTitle;
	}

	public String getBannerLink() {
		return _bannerLink;
	}

	public void setBannerLink(String bannerLink) {
		_bannerLink = bannerLink;
	}

	public long getBannerImageId() {
		return _bannerImageId;
	}

	public void setBannerImageId(long bannerImageId) {
		_bannerImageId = bannerImageId;
	}

	public int getViewCounter() {
		return _viewCounter;
	}

	public void setViewCounter(int viewCounter) {
		_viewCounter = viewCounter;
	}

	public int getBannerStatus() {
		return _bannerStatus;
	}

	public void setBannerStatus(int bannerStatus) {
		_bannerStatus = bannerStatus;
	}

	public BaseModel<?> getBannerRemoteModel() {
		return _bannerRemoteModel;
	}

	public void setBannerRemoteModel(BaseModel<?> bannerRemoteModel) {
		_bannerRemoteModel = bannerRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			BannerLocalServiceUtil.addBanner(this);
		}
		else {
			BannerLocalServiceUtil.updateBanner(this);
		}
	}

	@Override
	public Banner toEscapedModel() {
		return (Banner)Proxy.newProxyInstance(Banner.class.getClassLoader(),
			new Class[] { Banner.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BannerClp clone = new BannerClp();

		clone.setBannerId(getBannerId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setBannerGroupId(getBannerGroupId());
		clone.setBannerTitle(getBannerTitle());
		clone.setBannerLink(getBannerLink());
		clone.setBannerImageId(getBannerImageId());
		clone.setViewCounter(getViewCounter());
		clone.setBannerStatus(getBannerStatus());

		return clone;
	}

	public int compareTo(Banner banner) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(), banner.getModifiedDate());

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

		BannerClp banner = null;

		try {
			banner = (BannerClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = banner.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{bannerId=");
		sb.append(getBannerId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", bannerGroupId=");
		sb.append(getBannerGroupId());
		sb.append(", bannerTitle=");
		sb.append(getBannerTitle());
		sb.append(", bannerLink=");
		sb.append(getBannerLink());
		sb.append(", bannerImageId=");
		sb.append(getBannerImageId());
		sb.append(", viewCounter=");
		sb.append(getViewCounter());
		sb.append(", bannerStatus=");
		sb.append(getBannerStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.banner.model.Banner");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bannerId</column-name><column-value><![CDATA[");
		sb.append(getBannerId());
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
			"<column><column-name>bannerGroupId</column-name><column-value><![CDATA[");
		sb.append(getBannerGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bannerTitle</column-name><column-value><![CDATA[");
		sb.append(getBannerTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bannerLink</column-name><column-value><![CDATA[");
		sb.append(getBannerLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bannerImageId</column-name><column-value><![CDATA[");
		sb.append(getBannerImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewCounter</column-name><column-value><![CDATA[");
		sb.append(getViewCounter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bannerStatus</column-name><column-value><![CDATA[");
		sb.append(getBannerStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _bannerId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _bannerGroupId;
	private String _bannerTitle;
	private String _bannerLink;
	private long _bannerImageId;
	private int _viewCounter;
	private int _bannerStatus;
	private BaseModel<?> _bannerRemoteModel;
}