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
 * This class is a wrapper for {@link Banner}.
 * </p>
 *
 * @author    HungDX
 * @see       Banner
 * @generated
 */
public class BannerWrapper implements Banner, ModelWrapper<Banner> {
	public BannerWrapper(Banner banner) {
		_banner = banner;
	}

	public Class<?> getModelClass() {
		return Banner.class;
	}

	public String getModelClassName() {
		return Banner.class.getName();
	}

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

	/**
	* Returns the primary key of this banner.
	*
	* @return the primary key of this banner
	*/
	public long getPrimaryKey() {
		return _banner.getPrimaryKey();
	}

	/**
	* Sets the primary key of this banner.
	*
	* @param primaryKey the primary key of this banner
	*/
	public void setPrimaryKey(long primaryKey) {
		_banner.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the banner ID of this banner.
	*
	* @return the banner ID of this banner
	*/
	public long getBannerId() {
		return _banner.getBannerId();
	}

	/**
	* Sets the banner ID of this banner.
	*
	* @param bannerId the banner ID of this banner
	*/
	public void setBannerId(long bannerId) {
		_banner.setBannerId(bannerId);
	}

	/**
	* Returns the company ID of this banner.
	*
	* @return the company ID of this banner
	*/
	public long getCompanyId() {
		return _banner.getCompanyId();
	}

	/**
	* Sets the company ID of this banner.
	*
	* @param companyId the company ID of this banner
	*/
	public void setCompanyId(long companyId) {
		_banner.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this banner.
	*
	* @return the group ID of this banner
	*/
	public long getGroupId() {
		return _banner.getGroupId();
	}

	/**
	* Sets the group ID of this banner.
	*
	* @param groupId the group ID of this banner
	*/
	public void setGroupId(long groupId) {
		_banner.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this banner.
	*
	* @return the user ID of this banner
	*/
	public long getUserId() {
		return _banner.getUserId();
	}

	/**
	* Sets the user ID of this banner.
	*
	* @param userId the user ID of this banner
	*/
	public void setUserId(long userId) {
		_banner.setUserId(userId);
	}

	/**
	* Returns the user uuid of this banner.
	*
	* @return the user uuid of this banner
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _banner.getUserUuid();
	}

	/**
	* Sets the user uuid of this banner.
	*
	* @param userUuid the user uuid of this banner
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_banner.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this banner.
	*
	* @return the user name of this banner
	*/
	public java.lang.String getUserName() {
		return _banner.getUserName();
	}

	/**
	* Sets the user name of this banner.
	*
	* @param userName the user name of this banner
	*/
	public void setUserName(java.lang.String userName) {
		_banner.setUserName(userName);
	}

	/**
	* Returns the create date of this banner.
	*
	* @return the create date of this banner
	*/
	public java.util.Date getCreateDate() {
		return _banner.getCreateDate();
	}

	/**
	* Sets the create date of this banner.
	*
	* @param createDate the create date of this banner
	*/
	public void setCreateDate(java.util.Date createDate) {
		_banner.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this banner.
	*
	* @return the modified date of this banner
	*/
	public java.util.Date getModifiedDate() {
		return _banner.getModifiedDate();
	}

	/**
	* Sets the modified date of this banner.
	*
	* @param modifiedDate the modified date of this banner
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_banner.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the banner group ID of this banner.
	*
	* @return the banner group ID of this banner
	*/
	public long getBannerGroupId() {
		return _banner.getBannerGroupId();
	}

	/**
	* Sets the banner group ID of this banner.
	*
	* @param bannerGroupId the banner group ID of this banner
	*/
	public void setBannerGroupId(long bannerGroupId) {
		_banner.setBannerGroupId(bannerGroupId);
	}

	/**
	* Returns the banner title of this banner.
	*
	* @return the banner title of this banner
	*/
	public java.lang.String getBannerTitle() {
		return _banner.getBannerTitle();
	}

	/**
	* Sets the banner title of this banner.
	*
	* @param bannerTitle the banner title of this banner
	*/
	public void setBannerTitle(java.lang.String bannerTitle) {
		_banner.setBannerTitle(bannerTitle);
	}

	/**
	* Returns the banner link of this banner.
	*
	* @return the banner link of this banner
	*/
	public java.lang.String getBannerLink() {
		return _banner.getBannerLink();
	}

	/**
	* Sets the banner link of this banner.
	*
	* @param bannerLink the banner link of this banner
	*/
	public void setBannerLink(java.lang.String bannerLink) {
		_banner.setBannerLink(bannerLink);
	}

	/**
	* Returns the banner image ID of this banner.
	*
	* @return the banner image ID of this banner
	*/
	public long getBannerImageId() {
		return _banner.getBannerImageId();
	}

	/**
	* Sets the banner image ID of this banner.
	*
	* @param bannerImageId the banner image ID of this banner
	*/
	public void setBannerImageId(long bannerImageId) {
		_banner.setBannerImageId(bannerImageId);
	}

	/**
	* Returns the view counter of this banner.
	*
	* @return the view counter of this banner
	*/
	public int getViewCounter() {
		return _banner.getViewCounter();
	}

	/**
	* Sets the view counter of this banner.
	*
	* @param viewCounter the view counter of this banner
	*/
	public void setViewCounter(int viewCounter) {
		_banner.setViewCounter(viewCounter);
	}

	/**
	* Returns the banner status of this banner.
	*
	* @return the banner status of this banner
	*/
	public int getBannerStatus() {
		return _banner.getBannerStatus();
	}

	/**
	* Sets the banner status of this banner.
	*
	* @param bannerStatus the banner status of this banner
	*/
	public void setBannerStatus(int bannerStatus) {
		_banner.setBannerStatus(bannerStatus);
	}

	public boolean isNew() {
		return _banner.isNew();
	}

	public void setNew(boolean n) {
		_banner.setNew(n);
	}

	public boolean isCachedModel() {
		return _banner.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_banner.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _banner.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _banner.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_banner.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _banner.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_banner.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BannerWrapper((Banner)_banner.clone());
	}

	public int compareTo(com.portal_egov.portlet.banner.model.Banner banner) {
		return _banner.compareTo(banner);
	}

	@Override
	public int hashCode() {
		return _banner.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.banner.model.Banner> toCacheModel() {
		return _banner.toCacheModel();
	}

	public com.portal_egov.portlet.banner.model.Banner toEscapedModel() {
		return new BannerWrapper(_banner.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _banner.toString();
	}

	public java.lang.String toXmlString() {
		return _banner.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_banner.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Banner getWrappedBanner() {
		return _banner;
	}

	public Banner getWrappedModel() {
		return _banner;
	}

	public void resetOriginalValues() {
		_banner.resetOriginalValues();
	}

	private Banner _banner;
}