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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link YKCT_DlFileEntries}.
 * </p>
 *
 * @author    DucDVd
 * @see       YKCT_DlFileEntries
 * @generated
 */
public class YKCT_DlFileEntriesWrapper implements YKCT_DlFileEntries,
	ModelWrapper<YKCT_DlFileEntries> {
	public YKCT_DlFileEntriesWrapper(YKCT_DlFileEntries ykct_DlFileEntries) {
		_ykct_DlFileEntries = ykct_DlFileEntries;
	}

	public Class<?> getModelClass() {
		return YKCT_DlFileEntries.class;
	}

	public String getModelClassName() {
		return YKCT_DlFileEntries.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("ykctEntryId", getYkctEntryId());
		attributes.put("fileEntryId", getFileEntryId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long ykctEntryId = (Long)attributes.get("ykctEntryId");

		if (ykctEntryId != null) {
			setYkctEntryId(ykctEntryId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}
	}

	/**
	* Returns the primary key of this y k c t_ dl file entries.
	*
	* @return the primary key of this y k c t_ dl file entries
	*/
	public long getPrimaryKey() {
		return _ykct_DlFileEntries.getPrimaryKey();
	}

	/**
	* Sets the primary key of this y k c t_ dl file entries.
	*
	* @param primaryKey the primary key of this y k c t_ dl file entries
	*/
	public void setPrimaryKey(long primaryKey) {
		_ykct_DlFileEntries.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this y k c t_ dl file entries.
	*
	* @return the ID of this y k c t_ dl file entries
	*/
	public long getId() {
		return _ykct_DlFileEntries.getId();
	}

	/**
	* Sets the ID of this y k c t_ dl file entries.
	*
	* @param id the ID of this y k c t_ dl file entries
	*/
	public void setId(long id) {
		_ykct_DlFileEntries.setId(id);
	}

	/**
	* Returns the ykct entry ID of this y k c t_ dl file entries.
	*
	* @return the ykct entry ID of this y k c t_ dl file entries
	*/
	public long getYkctEntryId() {
		return _ykct_DlFileEntries.getYkctEntryId();
	}

	/**
	* Sets the ykct entry ID of this y k c t_ dl file entries.
	*
	* @param ykctEntryId the ykct entry ID of this y k c t_ dl file entries
	*/
	public void setYkctEntryId(long ykctEntryId) {
		_ykct_DlFileEntries.setYkctEntryId(ykctEntryId);
	}

	/**
	* Returns the file entry ID of this y k c t_ dl file entries.
	*
	* @return the file entry ID of this y k c t_ dl file entries
	*/
	public long getFileEntryId() {
		return _ykct_DlFileEntries.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this y k c t_ dl file entries.
	*
	* @param fileEntryId the file entry ID of this y k c t_ dl file entries
	*/
	public void setFileEntryId(long fileEntryId) {
		_ykct_DlFileEntries.setFileEntryId(fileEntryId);
	}

	public boolean isNew() {
		return _ykct_DlFileEntries.isNew();
	}

	public void setNew(boolean n) {
		_ykct_DlFileEntries.setNew(n);
	}

	public boolean isCachedModel() {
		return _ykct_DlFileEntries.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_ykct_DlFileEntries.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _ykct_DlFileEntries.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _ykct_DlFileEntries.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ykct_DlFileEntries.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ykct_DlFileEntries.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ykct_DlFileEntries.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new YKCT_DlFileEntriesWrapper((YKCT_DlFileEntries)_ykct_DlFileEntries.clone());
	}

	public int compareTo(YKCT_DlFileEntries ykct_DlFileEntries) {
		return _ykct_DlFileEntries.compareTo(ykct_DlFileEntries);
	}

	@Override
	public int hashCode() {
		return _ykct_DlFileEntries.hashCode();
	}

	public com.liferay.portal.model.CacheModel<YKCT_DlFileEntries> toCacheModel() {
		return _ykct_DlFileEntries.toCacheModel();
	}

	public YKCT_DlFileEntries toEscapedModel() {
		return new YKCT_DlFileEntriesWrapper(_ykct_DlFileEntries.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ykct_DlFileEntries.toString();
	}

	public java.lang.String toXmlString() {
		return _ykct_DlFileEntries.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ykct_DlFileEntries.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public YKCT_DlFileEntries getWrappedYKCT_DlFileEntries() {
		return _ykct_DlFileEntries;
	}

	public YKCT_DlFileEntries getWrappedModel() {
		return _ykct_DlFileEntries;
	}

	public void resetOriginalValues() {
		_ykct_DlFileEntries.resetOriginalValues();
	}

	private YKCT_DlFileEntries _ykct_DlFileEntries;
}