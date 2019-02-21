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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TTHC_Entry}.
 * </p>
 *
 * @author    HungDX
 * @see       TTHC_Entry
 * @generated
 */
public class TTHC_EntryWrapper implements TTHC_Entry, ModelWrapper<TTHC_Entry> {
	public TTHC_EntryWrapper(TTHC_Entry tthc_Entry) {
		_tthc_Entry = tthc_Entry;
	}

	public Class<?> getModelClass() {
		return TTHC_Entry.class;
	}

	public String getModelClassName() {
		return TTHC_Entry.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("levelId", getLevelId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("audienceId", getAudienceId());
		attributes.put("resultTypeId", getResultTypeId());
		attributes.put("entryCode", getEntryCode());
		attributes.put("entryName", getEntryName());
		attributes.put("entryDesc", getEntryDesc());
		attributes.put("processGuide", getProcessGuide());
		attributes.put("processType", getProcessType());
		attributes.put("processTime", getProcessTime());
		attributes.put("processFee", getProcessFee());
		attributes.put("processRequirement", getProcessRequirement());
		attributes.put("processFoundationDocument",
			getProcessFoundationDocument());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
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

		Long levelId = (Long)attributes.get("levelId");

		if (levelId != null) {
			setLevelId(levelId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long audienceId = (Long)attributes.get("audienceId");

		if (audienceId != null) {
			setAudienceId(audienceId);
		}

		Long resultTypeId = (Long)attributes.get("resultTypeId");

		if (resultTypeId != null) {
			setResultTypeId(resultTypeId);
		}

		String entryCode = (String)attributes.get("entryCode");

		if (entryCode != null) {
			setEntryCode(entryCode);
		}

		String entryName = (String)attributes.get("entryName");

		if (entryName != null) {
			setEntryName(entryName);
		}

		String entryDesc = (String)attributes.get("entryDesc");

		if (entryDesc != null) {
			setEntryDesc(entryDesc);
		}

		String processGuide = (String)attributes.get("processGuide");

		if (processGuide != null) {
			setProcessGuide(processGuide);
		}

		String processType = (String)attributes.get("processType");

		if (processType != null) {
			setProcessType(processType);
		}

		String processTime = (String)attributes.get("processTime");

		if (processTime != null) {
			setProcessTime(processTime);
		}

		String processFee = (String)attributes.get("processFee");

		if (processFee != null) {
			setProcessFee(processFee);
		}

		String processRequirement = (String)attributes.get("processRequirement");

		if (processRequirement != null) {
			setProcessRequirement(processRequirement);
		}

		String processFoundationDocument = (String)attributes.get(
				"processFoundationDocument");

		if (processFoundationDocument != null) {
			setProcessFoundationDocument(processFoundationDocument);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this t t h c_ entry.
	*
	* @return the primary key of this t t h c_ entry
	*/
	public long getPrimaryKey() {
		return _tthc_Entry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this t t h c_ entry.
	*
	* @param primaryKey the primary key of this t t h c_ entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_tthc_Entry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the entry ID of this t t h c_ entry.
	*
	* @return the entry ID of this t t h c_ entry
	*/
	public long getEntryId() {
		return _tthc_Entry.getEntryId();
	}

	/**
	* Sets the entry ID of this t t h c_ entry.
	*
	* @param entryId the entry ID of this t t h c_ entry
	*/
	public void setEntryId(long entryId) {
		_tthc_Entry.setEntryId(entryId);
	}

	/**
	* Returns the company ID of this t t h c_ entry.
	*
	* @return the company ID of this t t h c_ entry
	*/
	public long getCompanyId() {
		return _tthc_Entry.getCompanyId();
	}

	/**
	* Sets the company ID of this t t h c_ entry.
	*
	* @param companyId the company ID of this t t h c_ entry
	*/
	public void setCompanyId(long companyId) {
		_tthc_Entry.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this t t h c_ entry.
	*
	* @return the group ID of this t t h c_ entry
	*/
	public long getGroupId() {
		return _tthc_Entry.getGroupId();
	}

	/**
	* Sets the group ID of this t t h c_ entry.
	*
	* @param groupId the group ID of this t t h c_ entry
	*/
	public void setGroupId(long groupId) {
		_tthc_Entry.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this t t h c_ entry.
	*
	* @return the user ID of this t t h c_ entry
	*/
	public long getUserId() {
		return _tthc_Entry.getUserId();
	}

	/**
	* Sets the user ID of this t t h c_ entry.
	*
	* @param userId the user ID of this t t h c_ entry
	*/
	public void setUserId(long userId) {
		_tthc_Entry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this t t h c_ entry.
	*
	* @return the user uuid of this t t h c_ entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_Entry.getUserUuid();
	}

	/**
	* Sets the user uuid of this t t h c_ entry.
	*
	* @param userUuid the user uuid of this t t h c_ entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_tthc_Entry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this t t h c_ entry.
	*
	* @return the user name of this t t h c_ entry
	*/
	public java.lang.String getUserName() {
		return _tthc_Entry.getUserName();
	}

	/**
	* Sets the user name of this t t h c_ entry.
	*
	* @param userName the user name of this t t h c_ entry
	*/
	public void setUserName(java.lang.String userName) {
		_tthc_Entry.setUserName(userName);
	}

	/**
	* Returns the level ID of this t t h c_ entry.
	*
	* @return the level ID of this t t h c_ entry
	*/
	public long getLevelId() {
		return _tthc_Entry.getLevelId();
	}

	/**
	* Sets the level ID of this t t h c_ entry.
	*
	* @param levelId the level ID of this t t h c_ entry
	*/
	public void setLevelId(long levelId) {
		_tthc_Entry.setLevelId(levelId);
	}

	/**
	* Returns the department ID of this t t h c_ entry.
	*
	* @return the department ID of this t t h c_ entry
	*/
	public long getDepartmentId() {
		return _tthc_Entry.getDepartmentId();
	}

	/**
	* Sets the department ID of this t t h c_ entry.
	*
	* @param departmentId the department ID of this t t h c_ entry
	*/
	public void setDepartmentId(long departmentId) {
		_tthc_Entry.setDepartmentId(departmentId);
	}

	/**
	* Returns the category ID of this t t h c_ entry.
	*
	* @return the category ID of this t t h c_ entry
	*/
	public long getCategoryId() {
		return _tthc_Entry.getCategoryId();
	}

	/**
	* Sets the category ID of this t t h c_ entry.
	*
	* @param categoryId the category ID of this t t h c_ entry
	*/
	public void setCategoryId(long categoryId) {
		_tthc_Entry.setCategoryId(categoryId);
	}

	/**
	* Returns the audience ID of this t t h c_ entry.
	*
	* @return the audience ID of this t t h c_ entry
	*/
	public long getAudienceId() {
		return _tthc_Entry.getAudienceId();
	}

	/**
	* Sets the audience ID of this t t h c_ entry.
	*
	* @param audienceId the audience ID of this t t h c_ entry
	*/
	public void setAudienceId(long audienceId) {
		_tthc_Entry.setAudienceId(audienceId);
	}

	/**
	* Returns the result type ID of this t t h c_ entry.
	*
	* @return the result type ID of this t t h c_ entry
	*/
	public long getResultTypeId() {
		return _tthc_Entry.getResultTypeId();
	}

	/**
	* Sets the result type ID of this t t h c_ entry.
	*
	* @param resultTypeId the result type ID of this t t h c_ entry
	*/
	public void setResultTypeId(long resultTypeId) {
		_tthc_Entry.setResultTypeId(resultTypeId);
	}

	/**
	* Returns the entry code of this t t h c_ entry.
	*
	* @return the entry code of this t t h c_ entry
	*/
	public java.lang.String getEntryCode() {
		return _tthc_Entry.getEntryCode();
	}

	/**
	* Sets the entry code of this t t h c_ entry.
	*
	* @param entryCode the entry code of this t t h c_ entry
	*/
	public void setEntryCode(java.lang.String entryCode) {
		_tthc_Entry.setEntryCode(entryCode);
	}

	/**
	* Returns the entry name of this t t h c_ entry.
	*
	* @return the entry name of this t t h c_ entry
	*/
	public java.lang.String getEntryName() {
		return _tthc_Entry.getEntryName();
	}

	/**
	* Sets the entry name of this t t h c_ entry.
	*
	* @param entryName the entry name of this t t h c_ entry
	*/
	public void setEntryName(java.lang.String entryName) {
		_tthc_Entry.setEntryName(entryName);
	}

	/**
	* Returns the entry desc of this t t h c_ entry.
	*
	* @return the entry desc of this t t h c_ entry
	*/
	public java.lang.String getEntryDesc() {
		return _tthc_Entry.getEntryDesc();
	}

	/**
	* Sets the entry desc of this t t h c_ entry.
	*
	* @param entryDesc the entry desc of this t t h c_ entry
	*/
	public void setEntryDesc(java.lang.String entryDesc) {
		_tthc_Entry.setEntryDesc(entryDesc);
	}

	/**
	* Returns the process guide of this t t h c_ entry.
	*
	* @return the process guide of this t t h c_ entry
	*/
	public java.lang.String getProcessGuide() {
		return _tthc_Entry.getProcessGuide();
	}

	/**
	* Sets the process guide of this t t h c_ entry.
	*
	* @param processGuide the process guide of this t t h c_ entry
	*/
	public void setProcessGuide(java.lang.String processGuide) {
		_tthc_Entry.setProcessGuide(processGuide);
	}

	/**
	* Returns the process type of this t t h c_ entry.
	*
	* @return the process type of this t t h c_ entry
	*/
	public java.lang.String getProcessType() {
		return _tthc_Entry.getProcessType();
	}

	/**
	* Sets the process type of this t t h c_ entry.
	*
	* @param processType the process type of this t t h c_ entry
	*/
	public void setProcessType(java.lang.String processType) {
		_tthc_Entry.setProcessType(processType);
	}

	/**
	* Returns the process time of this t t h c_ entry.
	*
	* @return the process time of this t t h c_ entry
	*/
	public java.lang.String getProcessTime() {
		return _tthc_Entry.getProcessTime();
	}

	/**
	* Sets the process time of this t t h c_ entry.
	*
	* @param processTime the process time of this t t h c_ entry
	*/
	public void setProcessTime(java.lang.String processTime) {
		_tthc_Entry.setProcessTime(processTime);
	}

	/**
	* Returns the process fee of this t t h c_ entry.
	*
	* @return the process fee of this t t h c_ entry
	*/
	public java.lang.String getProcessFee() {
		return _tthc_Entry.getProcessFee();
	}

	/**
	* Sets the process fee of this t t h c_ entry.
	*
	* @param processFee the process fee of this t t h c_ entry
	*/
	public void setProcessFee(java.lang.String processFee) {
		_tthc_Entry.setProcessFee(processFee);
	}

	/**
	* Returns the process requirement of this t t h c_ entry.
	*
	* @return the process requirement of this t t h c_ entry
	*/
	public java.lang.String getProcessRequirement() {
		return _tthc_Entry.getProcessRequirement();
	}

	/**
	* Sets the process requirement of this t t h c_ entry.
	*
	* @param processRequirement the process requirement of this t t h c_ entry
	*/
	public void setProcessRequirement(java.lang.String processRequirement) {
		_tthc_Entry.setProcessRequirement(processRequirement);
	}

	/**
	* Returns the process foundation document of this t t h c_ entry.
	*
	* @return the process foundation document of this t t h c_ entry
	*/
	public java.lang.String getProcessFoundationDocument() {
		return _tthc_Entry.getProcessFoundationDocument();
	}

	/**
	* Sets the process foundation document of this t t h c_ entry.
	*
	* @param processFoundationDocument the process foundation document of this t t h c_ entry
	*/
	public void setProcessFoundationDocument(
		java.lang.String processFoundationDocument) {
		_tthc_Entry.setProcessFoundationDocument(processFoundationDocument);
	}

	/**
	* Returns the create date of this t t h c_ entry.
	*
	* @return the create date of this t t h c_ entry
	*/
	public java.util.Date getCreateDate() {
		return _tthc_Entry.getCreateDate();
	}

	/**
	* Sets the create date of this t t h c_ entry.
	*
	* @param createDate the create date of this t t h c_ entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_tthc_Entry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this t t h c_ entry.
	*
	* @return the modified date of this t t h c_ entry
	*/
	public java.util.Date getModifiedDate() {
		return _tthc_Entry.getModifiedDate();
	}

	/**
	* Sets the modified date of this t t h c_ entry.
	*
	* @param modifiedDate the modified date of this t t h c_ entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tthc_Entry.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _tthc_Entry.isNew();
	}

	public void setNew(boolean n) {
		_tthc_Entry.setNew(n);
	}

	public boolean isCachedModel() {
		return _tthc_Entry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tthc_Entry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tthc_Entry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tthc_Entry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tthc_Entry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tthc_Entry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tthc_Entry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TTHC_EntryWrapper((TTHC_Entry)_tthc_Entry.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.tthc.model.TTHC_Entry tthc_Entry) {
		return _tthc_Entry.compareTo(tthc_Entry);
	}

	@Override
	public int hashCode() {
		return _tthc_Entry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.tthc.model.TTHC_Entry> toCacheModel() {
		return _tthc_Entry.toCacheModel();
	}

	public com.portal_egov.portlet.tthc.model.TTHC_Entry toEscapedModel() {
		return new TTHC_EntryWrapper(_tthc_Entry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tthc_Entry.toString();
	}

	public java.lang.String toXmlString() {
		return _tthc_Entry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tthc_Entry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TTHC_Entry getWrappedTTHC_Entry() {
		return _tthc_Entry;
	}

	public TTHC_Entry getWrappedModel() {
		return _tthc_Entry;
	}

	public void resetOriginalValues() {
		_tthc_Entry.resetOriginalValues();
	}

	private TTHC_Entry _tthc_Entry;
}