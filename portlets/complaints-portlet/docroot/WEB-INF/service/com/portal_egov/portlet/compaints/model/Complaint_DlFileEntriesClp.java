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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.portal_egov.portlet.compaints.service.Complaint_DlFileEntriesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class Complaint_DlFileEntriesClp extends BaseModelImpl<Complaint_DlFileEntries>
	implements Complaint_DlFileEntries {
	public Complaint_DlFileEntriesClp() {
	}

	public Class<?> getModelClass() {
		return Complaint_DlFileEntries.class;
	}

	public String getModelClassName() {
		return Complaint_DlFileEntries.class.getName();
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

	public BaseModel<?> getComplaint_DlFileEntriesRemoteModel() {
		return _complaint_DlFileEntriesRemoteModel;
	}

	public void setComplaint_DlFileEntriesRemoteModel(
		BaseModel<?> complaint_DlFileEntriesRemoteModel) {
		_complaint_DlFileEntriesRemoteModel = complaint_DlFileEntriesRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			Complaint_DlFileEntriesLocalServiceUtil.addComplaint_DlFileEntries(this);
		}
		else {
			Complaint_DlFileEntriesLocalServiceUtil.updateComplaint_DlFileEntries(this);
		}
	}

	@Override
	public Complaint_DlFileEntries toEscapedModel() {
		return (Complaint_DlFileEntries)Proxy.newProxyInstance(Complaint_DlFileEntries.class.getClassLoader(),
			new Class[] { Complaint_DlFileEntries.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Complaint_DlFileEntriesClp clone = new Complaint_DlFileEntriesClp();

		clone.setId(getId());
		clone.setComplaintId(getComplaintId());
		clone.setFileEntryId(getFileEntryId());

		return clone;
	}

	public int compareTo(Complaint_DlFileEntries complaint_DlFileEntries) {
		long primaryKey = complaint_DlFileEntries.getPrimaryKey();

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

		Complaint_DlFileEntriesClp complaint_DlFileEntries = null;

		try {
			complaint_DlFileEntries = (Complaint_DlFileEntriesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = complaint_DlFileEntries.getPrimaryKey();

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
			"com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries");
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
	private BaseModel<?> _complaint_DlFileEntriesRemoteModel;
}