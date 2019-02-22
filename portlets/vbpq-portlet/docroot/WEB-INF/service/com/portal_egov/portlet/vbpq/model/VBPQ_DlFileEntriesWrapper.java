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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VBPQ_DlFileEntries}.
 * </p>
 *
 * @author    HungDX
 * @see       VBPQ_DlFileEntries
 * @generated
 */
public class VBPQ_DlFileEntriesWrapper implements VBPQ_DlFileEntries,
	ModelWrapper<VBPQ_DlFileEntries> {
	public VBPQ_DlFileEntriesWrapper(VBPQ_DlFileEntries vbpq_DlFileEntries) {
		_vbpq_DlFileEntries = vbpq_DlFileEntries;
	}

	public Class<?> getModelClass() {
		return VBPQ_DlFileEntries.class;
	}

	public String getModelClassName() {
		return VBPQ_DlFileEntries.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("vbpqEntryId", getVbpqEntryId());
		attributes.put("fileEntryId", getFileEntryId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long vbpqEntryId = (Long)attributes.get("vbpqEntryId");

		if (vbpqEntryId != null) {
			setVbpqEntryId(vbpqEntryId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}
	}

	/**
	* Returns the primary key of this v b p q_ dl file entries.
	*
	* @return the primary key of this v b p q_ dl file entries
	*/
	public long getPrimaryKey() {
		return _vbpq_DlFileEntries.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v b p q_ dl file entries.
	*
	* @param primaryKey the primary key of this v b p q_ dl file entries
	*/
	public void setPrimaryKey(long primaryKey) {
		_vbpq_DlFileEntries.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this v b p q_ dl file entries.
	*
	* @return the ID of this v b p q_ dl file entries
	*/
	public long getId() {
		return _vbpq_DlFileEntries.getId();
	}

	/**
	* Sets the ID of this v b p q_ dl file entries.
	*
	* @param id the ID of this v b p q_ dl file entries
	*/
	public void setId(long id) {
		_vbpq_DlFileEntries.setId(id);
	}

	/**
	* Returns the vbpq entry ID of this v b p q_ dl file entries.
	*
	* @return the vbpq entry ID of this v b p q_ dl file entries
	*/
	public long getVbpqEntryId() {
		return _vbpq_DlFileEntries.getVbpqEntryId();
	}

	/**
	* Sets the vbpq entry ID of this v b p q_ dl file entries.
	*
	* @param vbpqEntryId the vbpq entry ID of this v b p q_ dl file entries
	*/
	public void setVbpqEntryId(long vbpqEntryId) {
		_vbpq_DlFileEntries.setVbpqEntryId(vbpqEntryId);
	}

	/**
	* Returns the file entry ID of this v b p q_ dl file entries.
	*
	* @return the file entry ID of this v b p q_ dl file entries
	*/
	public long getFileEntryId() {
		return _vbpq_DlFileEntries.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this v b p q_ dl file entries.
	*
	* @param fileEntryId the file entry ID of this v b p q_ dl file entries
	*/
	public void setFileEntryId(long fileEntryId) {
		_vbpq_DlFileEntries.setFileEntryId(fileEntryId);
	}

	public boolean isNew() {
		return _vbpq_DlFileEntries.isNew();
	}

	public void setNew(boolean n) {
		_vbpq_DlFileEntries.setNew(n);
	}

	public boolean isCachedModel() {
		return _vbpq_DlFileEntries.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vbpq_DlFileEntries.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vbpq_DlFileEntries.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vbpq_DlFileEntries.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vbpq_DlFileEntries.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vbpq_DlFileEntries.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vbpq_DlFileEntries.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VBPQ_DlFileEntriesWrapper((VBPQ_DlFileEntries)_vbpq_DlFileEntries.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries vbpq_DlFileEntries) {
		return _vbpq_DlFileEntries.compareTo(vbpq_DlFileEntries);
	}

	@Override
	public int hashCode() {
		return _vbpq_DlFileEntries.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries> toCacheModel() {
		return _vbpq_DlFileEntries.toCacheModel();
	}

	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries toEscapedModel() {
		return new VBPQ_DlFileEntriesWrapper(_vbpq_DlFileEntries.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vbpq_DlFileEntries.toString();
	}

	public java.lang.String toXmlString() {
		return _vbpq_DlFileEntries.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vbpq_DlFileEntries.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VBPQ_DlFileEntries getWrappedVBPQ_DlFileEntries() {
		return _vbpq_DlFileEntries;
	}

	public VBPQ_DlFileEntries getWrappedModel() {
		return _vbpq_DlFileEntries;
	}

	public void resetOriginalValues() {
		_vbpq_DlFileEntries.resetOriginalValues();
	}

	private VBPQ_DlFileEntries _vbpq_DlFileEntries;
}