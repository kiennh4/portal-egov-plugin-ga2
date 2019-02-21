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

package com.bkav.portal.portlet.video.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VideoCategoryMap}.
 * </p>
 *
 * @author    hungdx
 * @see       VideoCategoryMap
 * @generated
 */
public class VideoCategoryMapWrapper implements VideoCategoryMap,
	ModelWrapper<VideoCategoryMap> {
	public VideoCategoryMapWrapper(VideoCategoryMap videoCategoryMap) {
		_videoCategoryMap = videoCategoryMap;
	}

	public Class<?> getModelClass() {
		return VideoCategoryMap.class;
	}

	public String getModelClassName() {
		return VideoCategoryMap.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mapId", getMapId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("entryId", getEntryId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long mapId = (Long)attributes.get("mapId");

		if (mapId != null) {
			setMapId(mapId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}
	}

	/**
	* Returns the primary key of this video category map.
	*
	* @return the primary key of this video category map
	*/
	public long getPrimaryKey() {
		return _videoCategoryMap.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video category map.
	*
	* @param primaryKey the primary key of this video category map
	*/
	public void setPrimaryKey(long primaryKey) {
		_videoCategoryMap.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the map ID of this video category map.
	*
	* @return the map ID of this video category map
	*/
	public long getMapId() {
		return _videoCategoryMap.getMapId();
	}

	/**
	* Sets the map ID of this video category map.
	*
	* @param mapId the map ID of this video category map
	*/
	public void setMapId(long mapId) {
		_videoCategoryMap.setMapId(mapId);
	}

	/**
	* Returns the category ID of this video category map.
	*
	* @return the category ID of this video category map
	*/
	public long getCategoryId() {
		return _videoCategoryMap.getCategoryId();
	}

	/**
	* Sets the category ID of this video category map.
	*
	* @param categoryId the category ID of this video category map
	*/
	public void setCategoryId(long categoryId) {
		_videoCategoryMap.setCategoryId(categoryId);
	}

	/**
	* Returns the entry ID of this video category map.
	*
	* @return the entry ID of this video category map
	*/
	public long getEntryId() {
		return _videoCategoryMap.getEntryId();
	}

	/**
	* Sets the entry ID of this video category map.
	*
	* @param entryId the entry ID of this video category map
	*/
	public void setEntryId(long entryId) {
		_videoCategoryMap.setEntryId(entryId);
	}

	public boolean isNew() {
		return _videoCategoryMap.isNew();
	}

	public void setNew(boolean n) {
		_videoCategoryMap.setNew(n);
	}

	public boolean isCachedModel() {
		return _videoCategoryMap.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_videoCategoryMap.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _videoCategoryMap.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _videoCategoryMap.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_videoCategoryMap.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _videoCategoryMap.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_videoCategoryMap.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VideoCategoryMapWrapper((VideoCategoryMap)_videoCategoryMap.clone());
	}

	public int compareTo(VideoCategoryMap videoCategoryMap) {
		return _videoCategoryMap.compareTo(videoCategoryMap);
	}

	@Override
	public int hashCode() {
		return _videoCategoryMap.hashCode();
	}

	public com.liferay.portal.model.CacheModel<VideoCategoryMap> toCacheModel() {
		return _videoCategoryMap.toCacheModel();
	}

	public VideoCategoryMap toEscapedModel() {
		return new VideoCategoryMapWrapper(_videoCategoryMap.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _videoCategoryMap.toString();
	}

	public java.lang.String toXmlString() {
		return _videoCategoryMap.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_videoCategoryMap.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VideoCategoryMap getWrappedVideoCategoryMap() {
		return _videoCategoryMap;
	}

	public VideoCategoryMap getWrappedModel() {
		return _videoCategoryMap;
	}

	public void resetOriginalValues() {
		_videoCategoryMap.resetOriginalValues();
	}

	private VideoCategoryMap _videoCategoryMap;
}