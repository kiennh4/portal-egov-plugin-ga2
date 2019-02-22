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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.portal_egov.portlet.vbpq.service.VBPQ_DlFileEntriesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class VBPQ_DlFileEntriesClp extends BaseModelImpl<VBPQ_DlFileEntries>
	implements VBPQ_DlFileEntries {
	public VBPQ_DlFileEntriesClp() {
	}

	public Class<?> getModelClass() {
		return VBPQ_DlFileEntries.class;
	}

	public String getModelClassName() {
		return VBPQ_DlFileEntries.class.getName();
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
		attributes.put("vbpqEntryId", getVbpqEntryId());
		attributes.put("fileEntryId", getFileEntryId());

		return attributes;
	}

	@Override
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

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getVbpqEntryId() {
		return _vbpqEntryId;
	}

	public void setVbpqEntryId(long vbpqEntryId) {
		_vbpqEntryId = vbpqEntryId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public BaseModel<?> getVBPQ_DlFileEntriesRemoteModel() {
		return _vbpq_DlFileEntriesRemoteModel;
	}

	public void setVBPQ_DlFileEntriesRemoteModel(
		BaseModel<?> vbpq_DlFileEntriesRemoteModel) {
		_vbpq_DlFileEntriesRemoteModel = vbpq_DlFileEntriesRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VBPQ_DlFileEntriesLocalServiceUtil.addVBPQ_DlFileEntries(this);
		}
		else {
			VBPQ_DlFileEntriesLocalServiceUtil.updateVBPQ_DlFileEntries(this);
		}
	}

	@Override
	public VBPQ_DlFileEntries toEscapedModel() {
		return (VBPQ_DlFileEntries)Proxy.newProxyInstance(VBPQ_DlFileEntries.class.getClassLoader(),
			new Class[] { VBPQ_DlFileEntries.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VBPQ_DlFileEntriesClp clone = new VBPQ_DlFileEntriesClp();

		clone.setId(getId());
		clone.setVbpqEntryId(getVbpqEntryId());
		clone.setFileEntryId(getFileEntryId());

		return clone;
	}

	public int compareTo(VBPQ_DlFileEntries vbpq_DlFileEntries) {
		long primaryKey = vbpq_DlFileEntries.getPrimaryKey();

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

		VBPQ_DlFileEntriesClp vbpq_DlFileEntries = null;

		try {
			vbpq_DlFileEntries = (VBPQ_DlFileEntriesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = vbpq_DlFileEntries.getPrimaryKey();

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
		sb.append(", vbpqEntryId=");
		sb.append(getVbpqEntryId());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vbpqEntryId</column-name><column-value><![CDATA[");
		sb.append(getVbpqEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _vbpqEntryId;
	private long _fileEntryId;
	private BaseModel<?> _vbpq_DlFileEntriesRemoteModel;
}