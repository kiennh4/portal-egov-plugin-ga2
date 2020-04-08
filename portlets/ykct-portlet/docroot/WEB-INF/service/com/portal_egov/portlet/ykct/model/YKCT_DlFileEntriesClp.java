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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.portal_egov.portlet.ykct.service.YKCT_DlFileEntriesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DucDVd
 */
public class YKCT_DlFileEntriesClp extends BaseModelImpl<YKCT_DlFileEntries>
	implements YKCT_DlFileEntries {
	public YKCT_DlFileEntriesClp() {
	}

	public Class<?> getModelClass() {
		return YKCT_DlFileEntries.class;
	}

	public String getModelClassName() {
		return YKCT_DlFileEntries.class.getName();
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
		attributes.put("ykctEntryId", getYkctEntryId());
		attributes.put("fileEntryId", getFileEntryId());

		return attributes;
	}

	@Override
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

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getYkctEntryId() {
		return _ykctEntryId;
	}

	public void setYkctEntryId(long ykctEntryId) {
		_ykctEntryId = ykctEntryId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public BaseModel<?> getYKCT_DlFileEntriesRemoteModel() {
		return _ykct_DlFileEntriesRemoteModel;
	}

	public void setYKCT_DlFileEntriesRemoteModel(
		BaseModel<?> ykct_DlFileEntriesRemoteModel) {
		_ykct_DlFileEntriesRemoteModel = ykct_DlFileEntriesRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			YKCT_DlFileEntriesLocalServiceUtil.addYKCT_DlFileEntries(this);
		}
		else {
			YKCT_DlFileEntriesLocalServiceUtil.updateYKCT_DlFileEntries(this);
		}
	}

	@Override
	public YKCT_DlFileEntries toEscapedModel() {
		return (YKCT_DlFileEntries)Proxy.newProxyInstance(YKCT_DlFileEntries.class.getClassLoader(),
			new Class[] { YKCT_DlFileEntries.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		YKCT_DlFileEntriesClp clone = new YKCT_DlFileEntriesClp();

		clone.setId(getId());
		clone.setYkctEntryId(getYkctEntryId());
		clone.setFileEntryId(getFileEntryId());

		return clone;
	}

	public int compareTo(YKCT_DlFileEntries ykct_DlFileEntries) {
		long primaryKey = ykct_DlFileEntries.getPrimaryKey();

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

		YKCT_DlFileEntriesClp ykct_DlFileEntries = null;

		try {
			ykct_DlFileEntries = (YKCT_DlFileEntriesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = ykct_DlFileEntries.getPrimaryKey();

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
		sb.append(", ykctEntryId=");
		sb.append(getYkctEntryId());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ykctEntryId</column-name><column-value><![CDATA[");
		sb.append(getYkctEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _ykctEntryId;
	private long _fileEntryId;
	private BaseModel<?> _ykct_DlFileEntriesRemoteModel;
}