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

package com.portal_egov.portlet.compaints.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Complaint_DlFileEntries}.
 * </p>
 *
 * @author    HungDX
 * @see       Complaint_DlFileEntries
 * @generated
 */
public class Complaint_DlFileEntriesWrapper implements Complaint_DlFileEntries,
	ModelWrapper<Complaint_DlFileEntries> {
	public Complaint_DlFileEntriesWrapper(
		Complaint_DlFileEntries complaint_DlFileEntries) {
		_complaint_DlFileEntries = complaint_DlFileEntries;
	}

	public Class<?> getModelClass() {
		return Complaint_DlFileEntries.class;
	}

	public String getModelClassName() {
		return Complaint_DlFileEntries.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("complaintId", getComplaintId());
		attributes.put("fileEntryId", getFileEntryId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long complaintId = (Long)attributes.get("complaintId");

		if (complaintId != null) {
			setComplaintId(complaintId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}
	}

	/**
	* Returns the primary key of this complaint_ dl file entries.
	*
	* @return the primary key of this complaint_ dl file entries
	*/
	public long getPrimaryKey() {
		return _complaint_DlFileEntries.getPrimaryKey();
	}

	/**
	* Sets the primary key of this complaint_ dl file entries.
	*
	* @param primaryKey the primary key of this complaint_ dl file entries
	*/
	public void setPrimaryKey(long primaryKey) {
		_complaint_DlFileEntries.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this complaint_ dl file entries.
	*
	* @return the ID of this complaint_ dl file entries
	*/
	public long getId() {
		return _complaint_DlFileEntries.getId();
	}

	/**
	* Sets the ID of this complaint_ dl file entries.
	*
	* @param id the ID of this complaint_ dl file entries
	*/
	public void setId(long id) {
		_complaint_DlFileEntries.setId(id);
	}

	/**
	* Returns the complaint ID of this complaint_ dl file entries.
	*
	* @return the complaint ID of this complaint_ dl file entries
	*/
	public long getComplaintId() {
		return _complaint_DlFileEntries.getComplaintId();
	}

	/**
	* Sets the complaint ID of this complaint_ dl file entries.
	*
	* @param complaintId the complaint ID of this complaint_ dl file entries
	*/
	public void setComplaintId(long complaintId) {
		_complaint_DlFileEntries.setComplaintId(complaintId);
	}

	/**
	* Returns the file entry ID of this complaint_ dl file entries.
	*
	* @return the file entry ID of this complaint_ dl file entries
	*/
	public long getFileEntryId() {
		return _complaint_DlFileEntries.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this complaint_ dl file entries.
	*
	* @param fileEntryId the file entry ID of this complaint_ dl file entries
	*/
	public void setFileEntryId(long fileEntryId) {
		_complaint_DlFileEntries.setFileEntryId(fileEntryId);
	}

	public boolean isNew() {
		return _complaint_DlFileEntries.isNew();
	}

	public void setNew(boolean n) {
		_complaint_DlFileEntries.setNew(n);
	}

	public boolean isCachedModel() {
		return _complaint_DlFileEntries.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_complaint_DlFileEntries.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _complaint_DlFileEntries.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _complaint_DlFileEntries.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_complaint_DlFileEntries.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _complaint_DlFileEntries.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_complaint_DlFileEntries.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Complaint_DlFileEntriesWrapper((Complaint_DlFileEntries)_complaint_DlFileEntries.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries complaint_DlFileEntries) {
		return _complaint_DlFileEntries.compareTo(complaint_DlFileEntries);
	}

	@Override
	public int hashCode() {
		return _complaint_DlFileEntries.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> toCacheModel() {
		return _complaint_DlFileEntries.toCacheModel();
	}

	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries toEscapedModel() {
		return new Complaint_DlFileEntriesWrapper(_complaint_DlFileEntries.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _complaint_DlFileEntries.toString();
	}

	public java.lang.String toXmlString() {
		return _complaint_DlFileEntries.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_complaint_DlFileEntries.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Complaint_DlFileEntries getWrappedComplaint_DlFileEntries() {
		return _complaint_DlFileEntries;
	}

	public Complaint_DlFileEntries getWrappedModel() {
		return _complaint_DlFileEntries;
	}

	public void resetOriginalValues() {
		_complaint_DlFileEntries.resetOriginalValues();
	}

	private Complaint_DlFileEntries _complaint_DlFileEntries;
}