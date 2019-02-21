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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BannerGroup}.
 * </p>
 *
 * @author    HungDX
 * @see       BannerGroup
 * @generated
 */
public class BannerGroupWrapper implements BannerGroup,
	ModelWrapper<BannerGroup> {
	public BannerGroupWrapper(BannerGroup bannerGroup) {
		_bannerGroup = bannerGroup;
	}

	public Class<?> getModelClass() {
		return BannerGroup.class;
	}

	public String getModelClassName() {
		return BannerGroup.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bannerGroupId", getBannerGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("groupName", getGroupName());
		attributes.put("groupDesc", getGroupDesc());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long bannerGroupId = (Long)attributes.get("bannerGroupId");

		if (bannerGroupId != null) {
			setBannerGroupId(bannerGroupId);
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

		String groupName = (String)attributes.get("groupName");

		if (groupName != null) {
			setGroupName(groupName);
		}

		String groupDesc = (String)attributes.get("groupDesc");

		if (groupDesc != null) {
			setGroupDesc(groupDesc);
		}
	}

	/**
	* Returns the primary key of this banner group.
	*
	* @return the primary key of this banner group
	*/
	public long getPrimaryKey() {
		return _bannerGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this banner group.
	*
	* @param primaryKey the primary key of this banner group
	*/
	public void setPrimaryKey(long primaryKey) {
		_bannerGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the banner group ID of this banner group.
	*
	* @return the banner group ID of this banner group
	*/
	public long getBannerGroupId() {
		return _bannerGroup.getBannerGroupId();
	}

	/**
	* Sets the banner group ID of this banner group.
	*
	* @param bannerGroupId the banner group ID of this banner group
	*/
	public void setBannerGroupId(long bannerGroupId) {
		_bannerGroup.setBannerGroupId(bannerGroupId);
	}

	/**
	* Returns the company ID of this banner group.
	*
	* @return the company ID of this banner group
	*/
	public long getCompanyId() {
		return _bannerGroup.getCompanyId();
	}

	/**
	* Sets the company ID of this banner group.
	*
	* @param companyId the company ID of this banner group
	*/
	public void setCompanyId(long companyId) {
		_bannerGroup.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this banner group.
	*
	* @return the group ID of this banner group
	*/
	public long getGroupId() {
		return _bannerGroup.getGroupId();
	}

	/**
	* Sets the group ID of this banner group.
	*
	* @param groupId the group ID of this banner group
	*/
	public void setGroupId(long groupId) {
		_bannerGroup.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this banner group.
	*
	* @return the user ID of this banner group
	*/
	public long getUserId() {
		return _bannerGroup.getUserId();
	}

	/**
	* Sets the user ID of this banner group.
	*
	* @param userId the user ID of this banner group
	*/
	public void setUserId(long userId) {
		_bannerGroup.setUserId(userId);
	}

	/**
	* Returns the user uuid of this banner group.
	*
	* @return the user uuid of this banner group
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerGroup.getUserUuid();
	}

	/**
	* Sets the user uuid of this banner group.
	*
	* @param userUuid the user uuid of this banner group
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_bannerGroup.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this banner group.
	*
	* @return the user name of this banner group
	*/
	public java.lang.String getUserName() {
		return _bannerGroup.getUserName();
	}

	/**
	* Sets the user name of this banner group.
	*
	* @param userName the user name of this banner group
	*/
	public void setUserName(java.lang.String userName) {
		_bannerGroup.setUserName(userName);
	}

	/**
	* Returns the create date of this banner group.
	*
	* @return the create date of this banner group
	*/
	public java.util.Date getCreateDate() {
		return _bannerGroup.getCreateDate();
	}

	/**
	* Sets the create date of this banner group.
	*
	* @param createDate the create date of this banner group
	*/
	public void setCreateDate(java.util.Date createDate) {
		_bannerGroup.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this banner group.
	*
	* @return the modified date of this banner group
	*/
	public java.util.Date getModifiedDate() {
		return _bannerGroup.getModifiedDate();
	}

	/**
	* Sets the modified date of this banner group.
	*
	* @param modifiedDate the modified date of this banner group
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_bannerGroup.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the group name of this banner group.
	*
	* @return the group name of this banner group
	*/
	public java.lang.String getGroupName() {
		return _bannerGroup.getGroupName();
	}

	/**
	* Sets the group name of this banner group.
	*
	* @param groupName the group name of this banner group
	*/
	public void setGroupName(java.lang.String groupName) {
		_bannerGroup.setGroupName(groupName);
	}

	/**
	* Returns the group desc of this banner group.
	*
	* @return the group desc of this banner group
	*/
	public java.lang.String getGroupDesc() {
		return _bannerGroup.getGroupDesc();
	}

	/**
	* Sets the group desc of this banner group.
	*
	* @param groupDesc the group desc of this banner group
	*/
	public void setGroupDesc(java.lang.String groupDesc) {
		_bannerGroup.setGroupDesc(groupDesc);
	}

	public boolean isNew() {
		return _bannerGroup.isNew();
	}

	public void setNew(boolean n) {
		_bannerGroup.setNew(n);
	}

	public boolean isCachedModel() {
		return _bannerGroup.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_bannerGroup.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _bannerGroup.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _bannerGroup.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bannerGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bannerGroup.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bannerGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BannerGroupWrapper((BannerGroup)_bannerGroup.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.banner.model.BannerGroup bannerGroup) {
		return _bannerGroup.compareTo(bannerGroup);
	}

	@Override
	public int hashCode() {
		return _bannerGroup.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.banner.model.BannerGroup> toCacheModel() {
		return _bannerGroup.toCacheModel();
	}

	public com.portal_egov.portlet.banner.model.BannerGroup toEscapedModel() {
		return new BannerGroupWrapper(_bannerGroup.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bannerGroup.toString();
	}

	public java.lang.String toXmlString() {
		return _bannerGroup.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bannerGroup.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public BannerGroup getWrappedBannerGroup() {
		return _bannerGroup;
	}

	public BannerGroup getWrappedModel() {
		return _bannerGroup;
	}

	public void resetOriginalValues() {
		_bannerGroup.resetOriginalValues();
	}

	private BannerGroup _bannerGroup;
}