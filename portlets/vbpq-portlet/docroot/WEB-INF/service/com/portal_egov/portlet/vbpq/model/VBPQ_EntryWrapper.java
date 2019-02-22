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

package com.portal_egov.portlet.vbpq.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VBPQ_Entry}.
 * </p>
 *
 * @author    HungDX
 * @see       VBPQ_Entry
 * @generated
 */
public class VBPQ_EntryWrapper implements VBPQ_Entry, ModelWrapper<VBPQ_Entry> {
	public VBPQ_EntryWrapper(VBPQ_Entry vbpq_Entry) {
		_vbpq_Entry = vbpq_Entry;
	}

	public Class<?> getModelClass() {
		return VBPQ_Entry.class;
	}

	public String getModelClassName() {
		return VBPQ_Entry.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("docTypeId", getDocTypeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("entryName", getEntryName());
		attributes.put("entryCode", getEntryCode());
		attributes.put("entryDesc", getEntryDesc());
		attributes.put("fileAttachmentURL", getFileAttachmentURL());
		attributes.put("publicatorName", getPublicatorName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("publishDate", getPublishDate());
		attributes.put("executeDate", getExecuteDate());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("neverExpired", getNeverExpired());
		attributes.put("active", getActive());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long docTypeId = (Long)attributes.get("docTypeId");

		if (docTypeId != null) {
			setDocTypeId(docTypeId);
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

		String entryName = (String)attributes.get("entryName");

		if (entryName != null) {
			setEntryName(entryName);
		}

		String entryCode = (String)attributes.get("entryCode");

		if (entryCode != null) {
			setEntryCode(entryCode);
		}

		String entryDesc = (String)attributes.get("entryDesc");

		if (entryDesc != null) {
			setEntryDesc(entryDesc);
		}

		String fileAttachmentURL = (String)attributes.get("fileAttachmentURL");

		if (fileAttachmentURL != null) {
			setFileAttachmentURL(fileAttachmentURL);
		}

		String publicatorName = (String)attributes.get("publicatorName");

		if (publicatorName != null) {
			setPublicatorName(publicatorName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date publishDate = (Date)attributes.get("publishDate");

		if (publishDate != null) {
			setPublishDate(publishDate);
		}

		Date executeDate = (Date)attributes.get("executeDate");

		if (executeDate != null) {
			setExecuteDate(executeDate);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}

		Boolean neverExpired = (Boolean)attributes.get("neverExpired");

		if (neverExpired != null) {
			setNeverExpired(neverExpired);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the primary key of this v b p q_ entry.
	*
	* @return the primary key of this v b p q_ entry
	*/
	public long getPrimaryKey() {
		return _vbpq_Entry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v b p q_ entry.
	*
	* @param primaryKey the primary key of this v b p q_ entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_vbpq_Entry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the entry ID of this v b p q_ entry.
	*
	* @return the entry ID of this v b p q_ entry
	*/
	public long getEntryId() {
		return _vbpq_Entry.getEntryId();
	}

	/**
	* Sets the entry ID of this v b p q_ entry.
	*
	* @param entryId the entry ID of this v b p q_ entry
	*/
	public void setEntryId(long entryId) {
		_vbpq_Entry.setEntryId(entryId);
	}

	/**
	* Returns the department ID of this v b p q_ entry.
	*
	* @return the department ID of this v b p q_ entry
	*/
	public long getDepartmentId() {
		return _vbpq_Entry.getDepartmentId();
	}

	/**
	* Sets the department ID of this v b p q_ entry.
	*
	* @param departmentId the department ID of this v b p q_ entry
	*/
	public void setDepartmentId(long departmentId) {
		_vbpq_Entry.setDepartmentId(departmentId);
	}

	/**
	* Returns the category ID of this v b p q_ entry.
	*
	* @return the category ID of this v b p q_ entry
	*/
	public long getCategoryId() {
		return _vbpq_Entry.getCategoryId();
	}

	/**
	* Sets the category ID of this v b p q_ entry.
	*
	* @param categoryId the category ID of this v b p q_ entry
	*/
	public void setCategoryId(long categoryId) {
		_vbpq_Entry.setCategoryId(categoryId);
	}

	/**
	* Returns the doc type ID of this v b p q_ entry.
	*
	* @return the doc type ID of this v b p q_ entry
	*/
	public long getDocTypeId() {
		return _vbpq_Entry.getDocTypeId();
	}

	/**
	* Sets the doc type ID of this v b p q_ entry.
	*
	* @param docTypeId the doc type ID of this v b p q_ entry
	*/
	public void setDocTypeId(long docTypeId) {
		_vbpq_Entry.setDocTypeId(docTypeId);
	}

	/**
	* Returns the company ID of this v b p q_ entry.
	*
	* @return the company ID of this v b p q_ entry
	*/
	public long getCompanyId() {
		return _vbpq_Entry.getCompanyId();
	}

	/**
	* Sets the company ID of this v b p q_ entry.
	*
	* @param companyId the company ID of this v b p q_ entry
	*/
	public void setCompanyId(long companyId) {
		_vbpq_Entry.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this v b p q_ entry.
	*
	* @return the group ID of this v b p q_ entry
	*/
	public long getGroupId() {
		return _vbpq_Entry.getGroupId();
	}

	/**
	* Sets the group ID of this v b p q_ entry.
	*
	* @param groupId the group ID of this v b p q_ entry
	*/
	public void setGroupId(long groupId) {
		_vbpq_Entry.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this v b p q_ entry.
	*
	* @return the user ID of this v b p q_ entry
	*/
	public long getUserId() {
		return _vbpq_Entry.getUserId();
	}

	/**
	* Sets the user ID of this v b p q_ entry.
	*
	* @param userId the user ID of this v b p q_ entry
	*/
	public void setUserId(long userId) {
		_vbpq_Entry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this v b p q_ entry.
	*
	* @return the user uuid of this v b p q_ entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_Entry.getUserUuid();
	}

	/**
	* Sets the user uuid of this v b p q_ entry.
	*
	* @param userUuid the user uuid of this v b p q_ entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_vbpq_Entry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this v b p q_ entry.
	*
	* @return the user name of this v b p q_ entry
	*/
	public java.lang.String getUserName() {
		return _vbpq_Entry.getUserName();
	}

	/**
	* Sets the user name of this v b p q_ entry.
	*
	* @param userName the user name of this v b p q_ entry
	*/
	public void setUserName(java.lang.String userName) {
		_vbpq_Entry.setUserName(userName);
	}

	/**
	* Returns the entry name of this v b p q_ entry.
	*
	* @return the entry name of this v b p q_ entry
	*/
	public java.lang.String getEntryName() {
		return _vbpq_Entry.getEntryName();
	}

	/**
	* Sets the entry name of this v b p q_ entry.
	*
	* @param entryName the entry name of this v b p q_ entry
	*/
	public void setEntryName(java.lang.String entryName) {
		_vbpq_Entry.setEntryName(entryName);
	}

	/**
	* Returns the entry code of this v b p q_ entry.
	*
	* @return the entry code of this v b p q_ entry
	*/
	public java.lang.String getEntryCode() {
		return _vbpq_Entry.getEntryCode();
	}

	/**
	* Sets the entry code of this v b p q_ entry.
	*
	* @param entryCode the entry code of this v b p q_ entry
	*/
	public void setEntryCode(java.lang.String entryCode) {
		_vbpq_Entry.setEntryCode(entryCode);
	}

	/**
	* Returns the entry desc of this v b p q_ entry.
	*
	* @return the entry desc of this v b p q_ entry
	*/
	public java.lang.String getEntryDesc() {
		return _vbpq_Entry.getEntryDesc();
	}

	/**
	* Sets the entry desc of this v b p q_ entry.
	*
	* @param entryDesc the entry desc of this v b p q_ entry
	*/
	public void setEntryDesc(java.lang.String entryDesc) {
		_vbpq_Entry.setEntryDesc(entryDesc);
	}

	/**
	* Returns the file attachment u r l of this v b p q_ entry.
	*
	* @return the file attachment u r l of this v b p q_ entry
	*/
	public java.lang.String getFileAttachmentURL() {
		return _vbpq_Entry.getFileAttachmentURL();
	}

	/**
	* Sets the file attachment u r l of this v b p q_ entry.
	*
	* @param fileAttachmentURL the file attachment u r l of this v b p q_ entry
	*/
	public void setFileAttachmentURL(java.lang.String fileAttachmentURL) {
		_vbpq_Entry.setFileAttachmentURL(fileAttachmentURL);
	}

	/**
	* Returns the publicator name of this v b p q_ entry.
	*
	* @return the publicator name of this v b p q_ entry
	*/
	public java.lang.String getPublicatorName() {
		return _vbpq_Entry.getPublicatorName();
	}

	/**
	* Sets the publicator name of this v b p q_ entry.
	*
	* @param publicatorName the publicator name of this v b p q_ entry
	*/
	public void setPublicatorName(java.lang.String publicatorName) {
		_vbpq_Entry.setPublicatorName(publicatorName);
	}

	/**
	* Returns the create date of this v b p q_ entry.
	*
	* @return the create date of this v b p q_ entry
	*/
	public java.util.Date getCreateDate() {
		return _vbpq_Entry.getCreateDate();
	}

	/**
	* Sets the create date of this v b p q_ entry.
	*
	* @param createDate the create date of this v b p q_ entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_vbpq_Entry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this v b p q_ entry.
	*
	* @return the modified date of this v b p q_ entry
	*/
	public java.util.Date getModifiedDate() {
		return _vbpq_Entry.getModifiedDate();
	}

	/**
	* Sets the modified date of this v b p q_ entry.
	*
	* @param modifiedDate the modified date of this v b p q_ entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vbpq_Entry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the publish date of this v b p q_ entry.
	*
	* @return the publish date of this v b p q_ entry
	*/
	public java.util.Date getPublishDate() {
		return _vbpq_Entry.getPublishDate();
	}

	/**
	* Sets the publish date of this v b p q_ entry.
	*
	* @param publishDate the publish date of this v b p q_ entry
	*/
	public void setPublishDate(java.util.Date publishDate) {
		_vbpq_Entry.setPublishDate(publishDate);
	}

	/**
	* Returns the execute date of this v b p q_ entry.
	*
	* @return the execute date of this v b p q_ entry
	*/
	public java.util.Date getExecuteDate() {
		return _vbpq_Entry.getExecuteDate();
	}

	/**
	* Sets the execute date of this v b p q_ entry.
	*
	* @param executeDate the execute date of this v b p q_ entry
	*/
	public void setExecuteDate(java.util.Date executeDate) {
		_vbpq_Entry.setExecuteDate(executeDate);
	}

	/**
	* Returns the expiration date of this v b p q_ entry.
	*
	* @return the expiration date of this v b p q_ entry
	*/
	public java.util.Date getExpirationDate() {
		return _vbpq_Entry.getExpirationDate();
	}

	/**
	* Sets the expiration date of this v b p q_ entry.
	*
	* @param expirationDate the expiration date of this v b p q_ entry
	*/
	public void setExpirationDate(java.util.Date expirationDate) {
		_vbpq_Entry.setExpirationDate(expirationDate);
	}

	/**
	* Returns the never expired of this v b p q_ entry.
	*
	* @return the never expired of this v b p q_ entry
	*/
	public boolean getNeverExpired() {
		return _vbpq_Entry.getNeverExpired();
	}

	/**
	* Returns <code>true</code> if this v b p q_ entry is never expired.
	*
	* @return <code>true</code> if this v b p q_ entry is never expired; <code>false</code> otherwise
	*/
	public boolean isNeverExpired() {
		return _vbpq_Entry.isNeverExpired();
	}

	/**
	* Sets whether this v b p q_ entry is never expired.
	*
	* @param neverExpired the never expired of this v b p q_ entry
	*/
	public void setNeverExpired(boolean neverExpired) {
		_vbpq_Entry.setNeverExpired(neverExpired);
	}

	/**
	* Returns the active of this v b p q_ entry.
	*
	* @return the active of this v b p q_ entry
	*/
	public boolean getActive() {
		return _vbpq_Entry.getActive();
	}

	/**
	* Returns <code>true</code> if this v b p q_ entry is active.
	*
	* @return <code>true</code> if this v b p q_ entry is active; <code>false</code> otherwise
	*/
	public boolean isActive() {
		return _vbpq_Entry.isActive();
	}

	/**
	* Sets whether this v b p q_ entry is active.
	*
	* @param active the active of this v b p q_ entry
	*/
	public void setActive(boolean active) {
		_vbpq_Entry.setActive(active);
	}

	public boolean isNew() {
		return _vbpq_Entry.isNew();
	}

	public void setNew(boolean n) {
		_vbpq_Entry.setNew(n);
	}

	public boolean isCachedModel() {
		return _vbpq_Entry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vbpq_Entry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vbpq_Entry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vbpq_Entry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vbpq_Entry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vbpq_Entry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vbpq_Entry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VBPQ_EntryWrapper((VBPQ_Entry)_vbpq_Entry.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.vbpq.model.VBPQ_Entry vbpq_Entry) {
		return _vbpq_Entry.compareTo(vbpq_Entry);
	}

	@Override
	public int hashCode() {
		return _vbpq_Entry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> toCacheModel() {
		return _vbpq_Entry.toCacheModel();
	}

	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry toEscapedModel() {
		return new VBPQ_EntryWrapper(_vbpq_Entry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vbpq_Entry.toString();
	}

	public java.lang.String toXmlString() {
		return _vbpq_Entry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vbpq_Entry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VBPQ_Entry getWrappedVBPQ_Entry() {
		return _vbpq_Entry;
	}

	public VBPQ_Entry getWrappedModel() {
		return _vbpq_Entry;
	}

	public void resetOriginalValues() {
		_vbpq_Entry.resetOriginalValues();
	}

	private VBPQ_Entry _vbpq_Entry;
}