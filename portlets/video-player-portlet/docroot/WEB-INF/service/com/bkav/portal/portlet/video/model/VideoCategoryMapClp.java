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

package com.bkav.portal.portlet.video.model;

import com.bkav.portal.portlet.video.service.VideoCategoryMapLocalServiceUtil;

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
 * @author hungdx
 */
public class VideoCategoryMapClp extends BaseModelImpl<VideoCategoryMap>
	implements VideoCategoryMap {
	public VideoCategoryMapClp() {
	}

	public Class<?> getModelClass() {
		return VideoCategoryMap.class;
	}

	public String getModelClassName() {
		return VideoCategoryMap.class.getName();
	}

	public long getPrimaryKey() {
		return _mapId;
	}

	public void setPrimaryKey(long primaryKey) {
		setMapId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_mapId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mapId", getMapId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("entryId", getEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mapId = (Long)attributes.get("mapId");

		if (mapId != null) {
			setMapId(mapId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}
	}

	public long getMapId() {
		return _mapId;
	}

	public void setMapId(long mapId) {
		_mapId = mapId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	public BaseModel<?> getVideoCategoryMapRemoteModel() {
		return _videoCategoryMapRemoteModel;
	}

	public void setVideoCategoryMapRemoteModel(
		BaseModel<?> videoCategoryMapRemoteModel) {
		_videoCategoryMapRemoteModel = videoCategoryMapRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VideoCategoryMapLocalServiceUtil.addVideoCategoryMap(this);
		}
		else {
			VideoCategoryMapLocalServiceUtil.updateVideoCategoryMap(this);
		}
	}

	@Override
	public VideoCategoryMap toEscapedModel() {
		return (VideoCategoryMap)Proxy.newProxyInstance(VideoCategoryMap.class.getClassLoader(),
			new Class[] { VideoCategoryMap.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VideoCategoryMapClp clone = new VideoCategoryMapClp();

		clone.setMapId(getMapId());
		clone.setCategoryId(getCategoryId());
		clone.setEntryId(getEntryId());

		return clone;
	}

	public int compareTo(VideoCategoryMap videoCategoryMap) {
		long primaryKey = videoCategoryMap.getPrimaryKey();

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

		VideoCategoryMapClp videoCategoryMap = null;

		try {
			videoCategoryMap = (VideoCategoryMapClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = videoCategoryMap.getPrimaryKey();

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

		sb.append("{mapId=");
		sb.append(getMapId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", entryId=");
		sb.append(getEntryId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.video.model.VideoCategoryMap");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mapId</column-name><column-value><![CDATA[");
		sb.append(getMapId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entryId</column-name><column-value><![CDATA[");
		sb.append(getEntryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _mapId;
	private long _categoryId;
	private long _entryId;
	private BaseModel<?> _videoCategoryMapRemoteModel;
}