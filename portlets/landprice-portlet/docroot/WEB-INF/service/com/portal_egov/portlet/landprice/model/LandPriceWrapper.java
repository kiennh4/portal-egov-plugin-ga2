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

package com.portal_egov.portlet.landprice.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LandPrice}.
 * </p>
 *
 * @author    HungDX
 * @see       LandPrice
 * @generated
 */
public class LandPriceWrapper implements LandPrice, ModelWrapper<LandPrice> {
	public LandPriceWrapper(LandPrice landPrice) {
		_landPrice = landPrice;
	}

	public Class<?> getModelClass() {
		return LandPrice.class;
	}

	public String getModelClassName() {
		return LandPrice.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("priceId", getPriceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("locationId", getLocationId());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("statisticYear", getStatisticYear());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long priceId = (Long)attributes.get("priceId");

		if (priceId != null) {
			setPriceId(priceId);
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

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Integer statisticYear = (Integer)attributes.get("statisticYear");

		if (statisticYear != null) {
			setStatisticYear(statisticYear);
		}
	}

	/**
	* Returns the primary key of this land price.
	*
	* @return the primary key of this land price
	*/
	public long getPrimaryKey() {
		return _landPrice.getPrimaryKey();
	}

	/**
	* Sets the primary key of this land price.
	*
	* @param primaryKey the primary key of this land price
	*/
	public void setPrimaryKey(long primaryKey) {
		_landPrice.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the price ID of this land price.
	*
	* @return the price ID of this land price
	*/
	public long getPriceId() {
		return _landPrice.getPriceId();
	}

	/**
	* Sets the price ID of this land price.
	*
	* @param priceId the price ID of this land price
	*/
	public void setPriceId(long priceId) {
		_landPrice.setPriceId(priceId);
	}

	/**
	* Returns the company ID of this land price.
	*
	* @return the company ID of this land price
	*/
	public long getCompanyId() {
		return _landPrice.getCompanyId();
	}

	/**
	* Sets the company ID of this land price.
	*
	* @param companyId the company ID of this land price
	*/
	public void setCompanyId(long companyId) {
		_landPrice.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this land price.
	*
	* @return the group ID of this land price
	*/
	public long getGroupId() {
		return _landPrice.getGroupId();
	}

	/**
	* Sets the group ID of this land price.
	*
	* @param groupId the group ID of this land price
	*/
	public void setGroupId(long groupId) {
		_landPrice.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this land price.
	*
	* @return the user ID of this land price
	*/
	public long getUserId() {
		return _landPrice.getUserId();
	}

	/**
	* Sets the user ID of this land price.
	*
	* @param userId the user ID of this land price
	*/
	public void setUserId(long userId) {
		_landPrice.setUserId(userId);
	}

	/**
	* Returns the user uuid of this land price.
	*
	* @return the user uuid of this land price
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _landPrice.getUserUuid();
	}

	/**
	* Sets the user uuid of this land price.
	*
	* @param userUuid the user uuid of this land price
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_landPrice.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this land price.
	*
	* @return the user name of this land price
	*/
	public java.lang.String getUserName() {
		return _landPrice.getUserName();
	}

	/**
	* Sets the user name of this land price.
	*
	* @param userName the user name of this land price
	*/
	public void setUserName(java.lang.String userName) {
		_landPrice.setUserName(userName);
	}

	/**
	* Returns the create date of this land price.
	*
	* @return the create date of this land price
	*/
	public java.util.Date getCreateDate() {
		return _landPrice.getCreateDate();
	}

	/**
	* Sets the create date of this land price.
	*
	* @param createDate the create date of this land price
	*/
	public void setCreateDate(java.util.Date createDate) {
		_landPrice.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this land price.
	*
	* @return the modified date of this land price
	*/
	public java.util.Date getModifiedDate() {
		return _landPrice.getModifiedDate();
	}

	/**
	* Sets the modified date of this land price.
	*
	* @param modifiedDate the modified date of this land price
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_landPrice.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the location ID of this land price.
	*
	* @return the location ID of this land price
	*/
	public long getLocationId() {
		return _landPrice.getLocationId();
	}

	/**
	* Sets the location ID of this land price.
	*
	* @param locationId the location ID of this land price
	*/
	public void setLocationId(long locationId) {
		_landPrice.setLocationId(locationId);
	}

	/**
	* Returns the title of this land price.
	*
	* @return the title of this land price
	*/
	public java.lang.String getTitle() {
		return _landPrice.getTitle();
	}

	/**
	* Sets the title of this land price.
	*
	* @param title the title of this land price
	*/
	public void setTitle(java.lang.String title) {
		_landPrice.setTitle(title);
	}

	/**
	* Returns the content of this land price.
	*
	* @return the content of this land price
	*/
	public java.lang.String getContent() {
		return _landPrice.getContent();
	}

	/**
	* Sets the content of this land price.
	*
	* @param content the content of this land price
	*/
	public void setContent(java.lang.String content) {
		_landPrice.setContent(content);
	}

	/**
	* Returns the statistic year of this land price.
	*
	* @return the statistic year of this land price
	*/
	public int getStatisticYear() {
		return _landPrice.getStatisticYear();
	}

	/**
	* Sets the statistic year of this land price.
	*
	* @param statisticYear the statistic year of this land price
	*/
	public void setStatisticYear(int statisticYear) {
		_landPrice.setStatisticYear(statisticYear);
	}

	public boolean isNew() {
		return _landPrice.isNew();
	}

	public void setNew(boolean n) {
		_landPrice.setNew(n);
	}

	public boolean isCachedModel() {
		return _landPrice.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_landPrice.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _landPrice.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _landPrice.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_landPrice.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _landPrice.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_landPrice.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LandPriceWrapper((LandPrice)_landPrice.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.landprice.model.LandPrice landPrice) {
		return _landPrice.compareTo(landPrice);
	}

	@Override
	public int hashCode() {
		return _landPrice.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.landprice.model.LandPrice> toCacheModel() {
		return _landPrice.toCacheModel();
	}

	public com.portal_egov.portlet.landprice.model.LandPrice toEscapedModel() {
		return new LandPriceWrapper(_landPrice.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _landPrice.toString();
	}

	public java.lang.String toXmlString() {
		return _landPrice.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_landPrice.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LandPrice getWrappedLandPrice() {
		return _landPrice;
	}

	public LandPrice getWrappedModel() {
		return _landPrice;
	}

	public void resetOriginalValues() {
		_landPrice.resetOriginalValues();
	}

	private LandPrice _landPrice;
}