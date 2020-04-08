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

package com.bkav.portal.portlet.complaints.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Complaints_DLFileEntries}.
 * </p>
 *
 * @author    AnhBDb
 * @see       Complaints_DLFileEntries
 * @generated
 */
public class Complaints_DLFileEntriesWrapper implements Complaints_DLFileEntries,
	ModelWrapper<Complaints_DLFileEntries> {
	public Complaints_DLFileEntriesWrapper(
		Complaints_DLFileEntries complaints_DLFileEntries) {
		_complaints_DLFileEntries = complaints_DLFileEntries;
	}

	public Class<?> getModelClass() {
		return Complaints_DLFileEntries.class;
	}

	public String getModelClassName() {
		return Complaints_DLFileEntries.class.getName();
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
	* Returns the primary key of this complaints_ d l file entries.
	*
	* @return the primary key of this complaints_ d l file entries
	*/
	public long getPrimaryKey() {
		return _complaints_DLFileEntries.getPrimaryKey();
	}

	/**
	* Sets the primary key of this complaints_ d l file entries.
	*
	* @param primaryKey the primary key of this complaints_ d l file entries
	*/
	public void setPrimaryKey(long primaryKey) {
		_complaints_DLFileEntries.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this complaints_ d l file entries.
	*
	* @return the ID of this complaints_ d l file entries
	*/
	public long getId() {
		return _complaints_DLFileEntries.getId();
	}

	/**
	* Sets the ID of this complaints_ d l file entries.
	*
	* @param id the ID of this complaints_ d l file entries
	*/
	public void setId(long id) {
		_complaints_DLFileEntries.setId(id);
	}

	/**
	* Returns the complaint ID of this complaints_ d l file entries.
	*
	* @return the complaint ID of this complaints_ d l file entries
	*/
	public long getComplaintId() {
		return _complaints_DLFileEntries.getComplaintId();
	}

	/**
	* Sets the complaint ID of this complaints_ d l file entries.
	*
	* @param complaintId the complaint ID of this complaints_ d l file entries
	*/
	public void setComplaintId(long complaintId) {
		_complaints_DLFileEntries.setComplaintId(complaintId);
	}

	/**
	* Returns the file entry ID of this complaints_ d l file entries.
	*
	* @return the file entry ID of this complaints_ d l file entries
	*/
	public long getFileEntryId() {
		return _complaints_DLFileEntries.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this complaints_ d l file entries.
	*
	* @param fileEntryId the file entry ID of this complaints_ d l file entries
	*/
	public void setFileEntryId(long fileEntryId) {
		_complaints_DLFileEntries.setFileEntryId(fileEntryId);
	}

	public boolean isNew() {
		return _complaints_DLFileEntries.isNew();
	}

	public void setNew(boolean n) {
		_complaints_DLFileEntries.setNew(n);
	}

	public boolean isCachedModel() {
		return _complaints_DLFileEntries.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_complaints_DLFileEntries.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _complaints_DLFileEntries.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _complaints_DLFileEntries.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_complaints_DLFileEntries.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _complaints_DLFileEntries.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_complaints_DLFileEntries.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Complaints_DLFileEntriesWrapper((Complaints_DLFileEntries)_complaints_DLFileEntries.clone());
	}

	public int compareTo(
		com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries complaints_DLFileEntries) {
		return _complaints_DLFileEntries.compareTo(complaints_DLFileEntries);
	}

	@Override
	public int hashCode() {
		return _complaints_DLFileEntries.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries> toCacheModel() {
		return _complaints_DLFileEntries.toCacheModel();
	}

	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries toEscapedModel() {
		return new Complaints_DLFileEntriesWrapper(_complaints_DLFileEntries.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _complaints_DLFileEntries.toString();
	}

	public java.lang.String toXmlString() {
		return _complaints_DLFileEntries.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_complaints_DLFileEntries.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Complaints_DLFileEntries getWrappedComplaints_DLFileEntries() {
		return _complaints_DLFileEntries;
	}

	public Complaints_DLFileEntries getWrappedModel() {
		return _complaints_DLFileEntries;
	}

	public void resetOriginalValues() {
		_complaints_DLFileEntries.resetOriginalValues();
	}

	private Complaints_DLFileEntries _complaints_DLFileEntries;
}