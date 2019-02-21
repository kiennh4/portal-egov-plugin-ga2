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

package com.portal_egov.portlet.ykct.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link YKCT_Entry}.
 * </p>
 *
 * @author    DucDVd
 * @see       YKCT_Entry
 * @generated
 */
public class YKCT_EntryWrapper implements YKCT_Entry, ModelWrapper<YKCT_Entry> {
	public YKCT_EntryWrapper(YKCT_Entry ykct_Entry) {
		_ykct_Entry = ykct_Entry;
	}

	public Class<?> getModelClass() {
		return YKCT_Entry.class;
	}

	public String getModelClassName() {
		return YKCT_Entry.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("entryName", getEntryName());
		attributes.put("categoryId", getCategoryId());
		attributes.put("fileAttachmentURL", getFileAttachmentURL());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
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

		String entryName = (String)attributes.get("entryName");

		if (entryName != null) {
			setEntryName(entryName);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String fileAttachmentURL = (String)attributes.get("fileAttachmentURL");

		if (fileAttachmentURL != null) {
			setFileAttachmentURL(fileAttachmentURL);
		}
	}

	/**
	* Returns the primary key of this y k c t_ entry.
	*
	* @return the primary key of this y k c t_ entry
	*/
	public long getPrimaryKey() {
		return _ykct_Entry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this y k c t_ entry.
	*
	* @param primaryKey the primary key of this y k c t_ entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_ykct_Entry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the entry ID of this y k c t_ entry.
	*
	* @return the entry ID of this y k c t_ entry
	*/
	public long getEntryId() {
		return _ykct_Entry.getEntryId();
	}

	/**
	* Sets the entry ID of this y k c t_ entry.
	*
	* @param entryId the entry ID of this y k c t_ entry
	*/
	public void setEntryId(long entryId) {
		_ykct_Entry.setEntryId(entryId);
	}

	/**
	* Returns the group ID of this y k c t_ entry.
	*
	* @return the group ID of this y k c t_ entry
	*/
	public long getGroupId() {
		return _ykct_Entry.getGroupId();
	}

	/**
	* Sets the group ID of this y k c t_ entry.
	*
	* @param groupId the group ID of this y k c t_ entry
	*/
	public void setGroupId(long groupId) {
		_ykct_Entry.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this y k c t_ entry.
	*
	* @return the company ID of this y k c t_ entry
	*/
	public long getCompanyId() {
		return _ykct_Entry.getCompanyId();
	}

	/**
	* Sets the company ID of this y k c t_ entry.
	*
	* @param companyId the company ID of this y k c t_ entry
	*/
	public void setCompanyId(long companyId) {
		_ykct_Entry.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this y k c t_ entry.
	*
	* @return the user ID of this y k c t_ entry
	*/
	public long getUserId() {
		return _ykct_Entry.getUserId();
	}

	/**
	* Sets the user ID of this y k c t_ entry.
	*
	* @param userId the user ID of this y k c t_ entry
	*/
	public void setUserId(long userId) {
		_ykct_Entry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this y k c t_ entry.
	*
	* @return the user uuid of this y k c t_ entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_Entry.getUserUuid();
	}

	/**
	* Sets the user uuid of this y k c t_ entry.
	*
	* @param userUuid the user uuid of this y k c t_ entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_ykct_Entry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this y k c t_ entry.
	*
	* @return the user name of this y k c t_ entry
	*/
	public java.lang.String getUserName() {
		return _ykct_Entry.getUserName();
	}

	/**
	* Sets the user name of this y k c t_ entry.
	*
	* @param userName the user name of this y k c t_ entry
	*/
	public void setUserName(java.lang.String userName) {
		_ykct_Entry.setUserName(userName);
	}

	/**
	* Returns the create date of this y k c t_ entry.
	*
	* @return the create date of this y k c t_ entry
	*/
	public java.util.Date getCreateDate() {
		return _ykct_Entry.getCreateDate();
	}

	/**
	* Sets the create date of this y k c t_ entry.
	*
	* @param createDate the create date of this y k c t_ entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_ykct_Entry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this y k c t_ entry.
	*
	* @return the modified date of this y k c t_ entry
	*/
	public java.util.Date getModifiedDate() {
		return _ykct_Entry.getModifiedDate();
	}

	/**
	* Sets the modified date of this y k c t_ entry.
	*
	* @param modifiedDate the modified date of this y k c t_ entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_ykct_Entry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the entry name of this y k c t_ entry.
	*
	* @return the entry name of this y k c t_ entry
	*/
	public java.lang.String getEntryName() {
		return _ykct_Entry.getEntryName();
	}

	/**
	* Sets the entry name of this y k c t_ entry.
	*
	* @param entryName the entry name of this y k c t_ entry
	*/
	public void setEntryName(java.lang.String entryName) {
		_ykct_Entry.setEntryName(entryName);
	}

	/**
	* Returns the category ID of this y k c t_ entry.
	*
	* @return the category ID of this y k c t_ entry
	*/
	public long getCategoryId() {
		return _ykct_Entry.getCategoryId();
	}

	/**
	* Sets the category ID of this y k c t_ entry.
	*
	* @param categoryId the category ID of this y k c t_ entry
	*/
	public void setCategoryId(long categoryId) {
		_ykct_Entry.setCategoryId(categoryId);
	}

	/**
	* Returns the file attachment u r l of this y k c t_ entry.
	*
	* @return the file attachment u r l of this y k c t_ entry
	*/
	public java.lang.String getFileAttachmentURL() {
		return _ykct_Entry.getFileAttachmentURL();
	}

	/**
	* Sets the file attachment u r l of this y k c t_ entry.
	*
	* @param fileAttachmentURL the file attachment u r l of this y k c t_ entry
	*/
	public void setFileAttachmentURL(java.lang.String fileAttachmentURL) {
		_ykct_Entry.setFileAttachmentURL(fileAttachmentURL);
	}

	public boolean isNew() {
		return _ykct_Entry.isNew();
	}

	public void setNew(boolean n) {
		_ykct_Entry.setNew(n);
	}

	public boolean isCachedModel() {
		return _ykct_Entry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_ykct_Entry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _ykct_Entry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _ykct_Entry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ykct_Entry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ykct_Entry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ykct_Entry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new YKCT_EntryWrapper((YKCT_Entry)_ykct_Entry.clone());
	}

	public int compareTo(YKCT_Entry ykct_Entry) {
		return _ykct_Entry.compareTo(ykct_Entry);
	}

	@Override
	public int hashCode() {
		return _ykct_Entry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<YKCT_Entry> toCacheModel() {
		return _ykct_Entry.toCacheModel();
	}

	public YKCT_Entry toEscapedModel() {
		return new YKCT_EntryWrapper(_ykct_Entry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ykct_Entry.toString();
	}

	public java.lang.String toXmlString() {
		return _ykct_Entry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ykct_Entry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public YKCT_Entry getWrappedYKCT_Entry() {
		return _ykct_Entry;
	}

	public YKCT_Entry getWrappedModel() {
		return _ykct_Entry;
	}

	public void resetOriginalValues() {
		_ykct_Entry.resetOriginalValues();
	}

	private YKCT_Entry _ykct_Entry;
}