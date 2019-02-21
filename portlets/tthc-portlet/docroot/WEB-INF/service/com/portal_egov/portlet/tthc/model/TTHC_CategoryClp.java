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

package com.portal_egov.portlet.tthc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.tthc.service.TTHC_CategoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class TTHC_CategoryClp extends BaseModelImpl<TTHC_Category>
	implements TTHC_Category {
	public TTHC_CategoryClp() {
	}

	public Class<?> getModelClass() {
		return TTHC_Category.class;
	}

	public String getModelClassName() {
		return TTHC_Category.class.getName();
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCategoryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_categoryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("parentId", getParentId());
		attributes.put("categoryTypeId", getCategoryTypeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("categoryDesc", getCategoryDesc());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("displayPriority", getDisplayPriority());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Integer categoryTypeId = (Integer)attributes.get("categoryTypeId");

		if (categoryTypeId != null) {
			setCategoryTypeId(categoryTypeId);
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

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		String categoryDesc = (String)attributes.get("categoryDesc");

		if (categoryDesc != null) {
			setCategoryDesc(categoryDesc);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer displayPriority = (Integer)attributes.get("displayPriority");

		if (displayPriority != null) {
			setDisplayPriority(displayPriority);
		}
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public int getCategoryTypeId() {
		return _categoryTypeId;
	}

	public void setCategoryTypeId(int categoryTypeId) {
		_categoryTypeId = categoryTypeId;
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

	public String getCategoryName() {
		return _categoryName;
	}

	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return _categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		_categoryDesc = categoryDesc;
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

	public int getDisplayPriority() {
		return _displayPriority;
	}

	public void setDisplayPriority(int displayPriority) {
		_displayPriority = displayPriority;
	}

	public BaseModel<?> getTTHC_CategoryRemoteModel() {
		return _tthc_CategoryRemoteModel;
	}

	public void setTTHC_CategoryRemoteModel(
		BaseModel<?> tthc_CategoryRemoteModel) {
		_tthc_CategoryRemoteModel = tthc_CategoryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TTHC_CategoryLocalServiceUtil.addTTHC_Category(this);
		}
		else {
			TTHC_CategoryLocalServiceUtil.updateTTHC_Category(this);
		}
	}

	@Override
	public TTHC_Category toEscapedModel() {
		return (TTHC_Category)Proxy.newProxyInstance(TTHC_Category.class.getClassLoader(),
			new Class[] { TTHC_Category.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TTHC_CategoryClp clone = new TTHC_CategoryClp();

		clone.setCategoryId(getCategoryId());
		clone.setParentId(getParentId());
		clone.setCategoryTypeId(getCategoryTypeId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCategoryName(getCategoryName());
		clone.setCategoryDesc(getCategoryDesc());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDisplayPriority(getDisplayPriority());

		return clone;
	}

	public int compareTo(TTHC_Category tthc_Category) {
		int value = 0;

		if (getDisplayPriority() < tthc_Category.getDisplayPriority()) {
			value = -1;
		}
		else if (getDisplayPriority() > tthc_Category.getDisplayPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		TTHC_CategoryClp tthc_Category = null;

		try {
			tthc_Category = (TTHC_CategoryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = tthc_Category.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{categoryId=");
		sb.append(getCategoryId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", categoryTypeId=");
		sb.append(getCategoryTypeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", categoryName=");
		sb.append(getCategoryName());
		sb.append(", categoryDesc=");
		sb.append(getCategoryDesc());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", displayPriority=");
		sb.append(getDisplayPriority());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.tthc.model.TTHC_Category");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryTypeId</column-name><column-value><![CDATA[");
		sb.append(getCategoryTypeId());
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
			"<column><column-name>categoryName</column-name><column-value><![CDATA[");
		sb.append(getCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryDesc</column-name><column-value><![CDATA[");
		sb.append(getCategoryDesc());
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
			"<column><column-name>displayPriority</column-name><column-value><![CDATA[");
		sb.append(getDisplayPriority());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _categoryId;
	private long _parentId;
	private int _categoryTypeId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _categoryName;
	private String _categoryDesc;
	private Date _createDate;
	private Date _modifiedDate;
	private int _displayPriority;
	private BaseModel<?> _tthc_CategoryRemoteModel;
}