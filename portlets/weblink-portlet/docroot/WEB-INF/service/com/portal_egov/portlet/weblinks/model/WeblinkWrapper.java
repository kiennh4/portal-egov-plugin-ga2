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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Weblink}.
 * </p>
 *
 * @author    HungDX
 * @see       Weblink
 * @generated
 */
public class WeblinkWrapper implements Weblink, ModelWrapper<Weblink> {
	public WeblinkWrapper(Weblink weblink) {
		_weblink = weblink;
	}

	public Class<?> getModelClass() {
		return Weblink.class;
	}

	public String getModelClassName() {
		return Weblink.class.getName();
	}

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

	/**
	* Returns the primary key of this weblink.
	*
	* @return the primary key of this weblink
	*/
	public long getPrimaryKey() {
		return _weblink.getPrimaryKey();
	}

	/**
	* Sets the primary key of this weblink.
	*
	* @param primaryKey the primary key of this weblink
	*/
	public void setPrimaryKey(long primaryKey) {
		_weblink.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the weblink ID of this weblink.
	*
	* @return the weblink ID of this weblink
	*/
	public long getWeblinkId() {
		return _weblink.getWeblinkId();
	}

	/**
	* Sets the weblink ID of this weblink.
	*
	* @param weblinkId the weblink ID of this weblink
	*/
	public void setWeblinkId(long weblinkId) {
		_weblink.setWeblinkId(weblinkId);
	}

	/**
	* Returns the group ID of this weblink.
	*
	* @return the group ID of this weblink
	*/
	public long getGroupId() {
		return _weblink.getGroupId();
	}

	/**
	* Sets the group ID of this weblink.
	*
	* @param groupId the group ID of this weblink
	*/
	public void setGroupId(long groupId) {
		_weblink.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this weblink.
	*
	* @return the company ID of this weblink
	*/
	public long getCompanyId() {
		return _weblink.getCompanyId();
	}

	/**
	* Sets the company ID of this weblink.
	*
	* @param companyId the company ID of this weblink
	*/
	public void setCompanyId(long companyId) {
		_weblink.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this weblink.
	*
	* @return the user ID of this weblink
	*/
	public long getUserId() {
		return _weblink.getUserId();
	}

	/**
	* Sets the user ID of this weblink.
	*
	* @param userId the user ID of this weblink
	*/
	public void setUserId(long userId) {
		_weblink.setUserId(userId);
	}

	/**
	* Returns the user uuid of this weblink.
	*
	* @return the user uuid of this weblink
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblink.getUserUuid();
	}

	/**
	* Sets the user uuid of this weblink.
	*
	* @param userUuid the user uuid of this weblink
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_weblink.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this weblink.
	*
	* @return the user name of this weblink
	*/
	public java.lang.String getUserName() {
		return _weblink.getUserName();
	}

	/**
	* Sets the user name of this weblink.
	*
	* @param userName the user name of this weblink
	*/
	public void setUserName(java.lang.String userName) {
		_weblink.setUserName(userName);
	}

	/**
	* Returns the create date of this weblink.
	*
	* @return the create date of this weblink
	*/
	public java.util.Date getCreateDate() {
		return _weblink.getCreateDate();
	}

	/**
	* Sets the create date of this weblink.
	*
	* @param createDate the create date of this weblink
	*/
	public void setCreateDate(java.util.Date createDate) {
		_weblink.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this weblink.
	*
	* @return the modified date of this weblink
	*/
	public java.util.Date getModifiedDate() {
		return _weblink.getModifiedDate();
	}

	/**
	* Sets the modified date of this weblink.
	*
	* @param modifiedDate the modified date of this weblink
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_weblink.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the weblink category ID of this weblink.
	*
	* @return the weblink category ID of this weblink
	*/
	public long getWeblinkCategoryId() {
		return _weblink.getWeblinkCategoryId();
	}

	/**
	* Sets the weblink category ID of this weblink.
	*
	* @param weblinkCategoryId the weblink category ID of this weblink
	*/
	public void setWeblinkCategoryId(long weblinkCategoryId) {
		_weblink.setWeblinkCategoryId(weblinkCategoryId);
	}

	/**
	* Returns the weblink name of this weblink.
	*
	* @return the weblink name of this weblink
	*/
	public java.lang.String getWeblinkName() {
		return _weblink.getWeblinkName();
	}

	/**
	* Sets the weblink name of this weblink.
	*
	* @param weblinkName the weblink name of this weblink
	*/
	public void setWeblinkName(java.lang.String weblinkName) {
		_weblink.setWeblinkName(weblinkName);
	}

	/**
	* Returns the weblink desc of this weblink.
	*
	* @return the weblink desc of this weblink
	*/
	public java.lang.String getWeblinkDesc() {
		return _weblink.getWeblinkDesc();
	}

	/**
	* Sets the weblink desc of this weblink.
	*
	* @param weblinkDesc the weblink desc of this weblink
	*/
	public void setWeblinkDesc(java.lang.String weblinkDesc) {
		_weblink.setWeblinkDesc(weblinkDesc);
	}

	/**
	* Returns the weblink u r l of this weblink.
	*
	* @return the weblink u r l of this weblink
	*/
	public java.lang.String getWeblinkURL() {
		return _weblink.getWeblinkURL();
	}

	/**
	* Sets the weblink u r l of this weblink.
	*
	* @param weblinkURL the weblink u r l of this weblink
	*/
	public void setWeblinkURL(java.lang.String weblinkURL) {
		_weblink.setWeblinkURL(weblinkURL);
	}

	/**
	* Returns the weblink icon ID of this weblink.
	*
	* @return the weblink icon ID of this weblink
	*/
	public long getWeblinkIconId() {
		return _weblink.getWeblinkIconId();
	}

	/**
	* Sets the weblink icon ID of this weblink.
	*
	* @param weblinkIconId the weblink icon ID of this weblink
	*/
	public void setWeblinkIconId(long weblinkIconId) {
		_weblink.setWeblinkIconId(weblinkIconId);
	}

	public boolean isNew() {
		return _weblink.isNew();
	}

	public void setNew(boolean n) {
		_weblink.setNew(n);
	}

	public boolean isCachedModel() {
		return _weblink.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_weblink.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _weblink.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _weblink.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_weblink.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _weblink.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_weblink.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WeblinkWrapper((Weblink)_weblink.clone());
	}

	public int compareTo(com.portal_egov.portlet.weblinks.model.Weblink weblink) {
		return _weblink.compareTo(weblink);
	}

	@Override
	public int hashCode() {
		return _weblink.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.weblinks.model.Weblink> toCacheModel() {
		return _weblink.toCacheModel();
	}

	public com.portal_egov.portlet.weblinks.model.Weblink toEscapedModel() {
		return new WeblinkWrapper(_weblink.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _weblink.toString();
	}

	public java.lang.String toXmlString() {
		return _weblink.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_weblink.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Weblink getWrappedWeblink() {
		return _weblink;
	}

	public Weblink getWrappedModel() {
		return _weblink;
	}

	public void resetOriginalValues() {
		_weblink.resetOriginalValues();
	}

	private Weblink _weblink;
}