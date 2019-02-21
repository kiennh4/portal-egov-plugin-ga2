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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ContentSharing}.
 * </p>
 *
 * @author    anhbdb
 * @see       ContentSharing
 * @generated
 */
public class ContentSharingWrapper implements ContentSharing,
	ModelWrapper<ContentSharing> {
	public ContentSharingWrapper(ContentSharing contentSharing) {
		_contentSharing = contentSharing;
	}

	public Class<?> getModelClass() {
		return ContentSharing.class;
	}

	public String getModelClassName() {
		return ContentSharing.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contentId", getContentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("contentSharing", getContentSharing());

		return attributes;
	}

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

	/**
	* Returns the primary key of this content sharing.
	*
	* @return the primary key of this content sharing
	*/
	public long getPrimaryKey() {
		return _contentSharing.getPrimaryKey();
	}

	/**
	* Sets the primary key of this content sharing.
	*
	* @param primaryKey the primary key of this content sharing
	*/
	public void setPrimaryKey(long primaryKey) {
		_contentSharing.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the content ID of this content sharing.
	*
	* @return the content ID of this content sharing
	*/
	public long getContentId() {
		return _contentSharing.getContentId();
	}

	/**
	* Sets the content ID of this content sharing.
	*
	* @param contentId the content ID of this content sharing
	*/
	public void setContentId(long contentId) {
		_contentSharing.setContentId(contentId);
	}

	/**
	* Returns the company ID of this content sharing.
	*
	* @return the company ID of this content sharing
	*/
	public long getCompanyId() {
		return _contentSharing.getCompanyId();
	}

	/**
	* Sets the company ID of this content sharing.
	*
	* @param companyId the company ID of this content sharing
	*/
	public void setCompanyId(long companyId) {
		_contentSharing.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this content sharing.
	*
	* @return the group ID of this content sharing
	*/
	public long getGroupId() {
		return _contentSharing.getGroupId();
	}

	/**
	* Sets the group ID of this content sharing.
	*
	* @param groupId the group ID of this content sharing
	*/
	public void setGroupId(long groupId) {
		_contentSharing.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this content sharing.
	*
	* @return the user ID of this content sharing
	*/
	public long getUserId() {
		return _contentSharing.getUserId();
	}

	/**
	* Sets the user ID of this content sharing.
	*
	* @param userId the user ID of this content sharing
	*/
	public void setUserId(long userId) {
		_contentSharing.setUserId(userId);
	}

	/**
	* Returns the user uuid of this content sharing.
	*
	* @return the user uuid of this content sharing
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentSharing.getUserUuid();
	}

	/**
	* Sets the user uuid of this content sharing.
	*
	* @param userUuid the user uuid of this content sharing
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_contentSharing.setUserUuid(userUuid);
	}

	/**
	* Returns the content sharing of this content sharing.
	*
	* @return the content sharing of this content sharing
	*/
	public java.lang.String getContentSharing() {
		return _contentSharing.getContentSharing();
	}

	/**
	* Sets the content sharing of this content sharing.
	*
	* @param contentSharing the content sharing of this content sharing
	*/
	public void setContentSharing(java.lang.String contentSharing) {
		_contentSharing.setContentSharing(contentSharing);
	}

	public boolean isNew() {
		return _contentSharing.isNew();
	}

	public void setNew(boolean n) {
		_contentSharing.setNew(n);
	}

	public boolean isCachedModel() {
		return _contentSharing.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_contentSharing.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _contentSharing.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _contentSharing.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contentSharing.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contentSharing.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contentSharing.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContentSharingWrapper((ContentSharing)_contentSharing.clone());
	}

	public int compareTo(
		com.bkav.portal.portlet.contentsharing.model.ContentSharing contentSharing) {
		return _contentSharing.compareTo(contentSharing);
	}

	@Override
	public int hashCode() {
		return _contentSharing.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.contentsharing.model.ContentSharing> toCacheModel() {
		return _contentSharing.toCacheModel();
	}

	public com.bkav.portal.portlet.contentsharing.model.ContentSharing toEscapedModel() {
		return new ContentSharingWrapper(_contentSharing.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contentSharing.toString();
	}

	public java.lang.String toXmlString() {
		return _contentSharing.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contentSharing.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ContentSharing getWrappedContentSharing() {
		return _contentSharing;
	}

	public ContentSharing getWrappedModel() {
		return _contentSharing;
	}

	public void resetOriginalValues() {
		_contentSharing.resetOriginalValues();
	}

	private ContentSharing _contentSharing;
}