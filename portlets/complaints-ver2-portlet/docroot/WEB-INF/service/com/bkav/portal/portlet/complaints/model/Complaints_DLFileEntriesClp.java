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

import com.bkav.portal.portlet.complaints.service.Complaints_DLFileEntriesLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AnhBDb
 */
public class Complaints_DLFileEntriesClp extends BaseModelImpl<Complaints_DLFileEntries>
	implements Complaints_DLFileEntries {
	public Complaints_DLFileEntriesClp() {
	}

	public Class<?> getModelClass() {
		return Complaints_DLFileEntries.class;
	}

	public String getModelClassName() {
		return Complaints_DLFileEntries.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("complaintId", getComplaintId());
		attributes.put("fileEntryId", getFileEntryId());

		return attributes;
	}

	@Override
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

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getComplaintId() {
		return _complaintId;
	}

	public void setComplaintId(long complaintId) {
		_complaintId = complaintId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public BaseModel<?> getComplaints_DLFileEntriesRemoteModel() {
		return _complaints_DLFileEntriesRemoteModel;
	}

	public void setComplaints_DLFileEntriesRemoteModel(
		BaseModel<?> complaints_DLFileEntriesRemoteModel) {
		_complaints_DLFileEntriesRemoteModel = complaints_DLFileEntriesRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			Complaints_DLFileEntriesLocalServiceUtil.addComplaints_DLFileEntries(this);
		}
		else {
			Complaints_DLFileEntriesLocalServiceUtil.updateComplaints_DLFileEntries(this);
		}
	}

	@Override
	public Complaints_DLFileEntries toEscapedModel() {
		return (Complaints_DLFileEntries)Proxy.newProxyInstance(Complaints_DLFileEntries.class.getClassLoader(),
			new Class[] { Complaints_DLFileEntries.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Complaints_DLFileEntriesClp clone = new Complaints_DLFileEntriesClp();

		clone.setId(getId());
		clone.setComplaintId(getComplaintId());
		clone.setFileEntryId(getFileEntryId());

		return clone;
	}

	public int compareTo(Complaints_DLFileEntries complaints_DLFileEntries) {
		long primaryKey = complaints_DLFileEntries.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Complaints_DLFileEntriesClp complaints_DLFileEntries = null;

		try {
			complaints_DLFileEntries = (Complaints_DLFileEntriesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = complaints_DLFileEntries.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", complaintId=");
		sb.append(getComplaintId());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append(
			"com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complaintId</column-name><column-value><![CDATA[");
		sb.append(getComplaintId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _complaintId;
	private long _fileEntryId;
	private BaseModel<?> _complaints_DLFileEntriesRemoteModel;
}