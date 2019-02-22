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

package com.portal_egov.portlet.ykct.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries;
import com.portal_egov.portlet.ykct.model.YKCT_DlFileEntriesModel;
import com.portal_egov.portlet.ykct.model.YKCT_DlFileEntriesSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the YKCT_DlFileEntries service. Represents a row in the &quot;ykct_dlfileentries&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.portal_egov.portlet.ykct.model.YKCT_DlFileEntriesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link YKCT_DlFileEntriesImpl}.
 * </p>
 *
 * @author DucDVd
 * @see YKCT_DlFileEntriesImpl
 * @see com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries
 * @see com.portal_egov.portlet.ykct.model.YKCT_DlFileEntriesModel
 * @generated
 */
@JSON(strict = true)
public class YKCT_DlFileEntriesModelImpl extends BaseModelImpl<YKCT_DlFileEntries>
	implements YKCT_DlFileEntriesModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a y k c t_ dl file entries model instance should use the {@link com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries} interface instead.
	 */
	public static final String TABLE_NAME = "ykct_dlfileentries";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "ykctEntryId", Types.BIGINT },
			{ "fileEntryId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ykct_dlfileentries (id_ LONG not null primary key,ykctEntryId LONG,fileEntryId LONG)";
	public static final String TABLE_SQL_DROP = "drop table ykct_dlfileentries";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries"),
			true);
	public static long FILEENTRYID_COLUMN_BITMASK = 1L;
	public static long YKCTENTRYID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static YKCT_DlFileEntries toModel(YKCT_DlFileEntriesSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		YKCT_DlFileEntries model = new YKCT_DlFileEntriesImpl();

		model.setId(soapModel.getId());
		model.setYkctEntryId(soapModel.getYkctEntryId());
		model.setFileEntryId(soapModel.getFileEntryId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<YKCT_DlFileEntries> toModels(
		YKCT_DlFileEntriesSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<YKCT_DlFileEntries> models = new ArrayList<YKCT_DlFileEntries>(soapModels.length);

		for (YKCT_DlFileEntriesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries"));

	public YKCT_DlFileEntriesModelImpl() {
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

	public Class<?> getModelClass() {
		return YKCT_DlFileEntries.class;
	}

	public String getModelClassName() {
		return YKCT_DlFileEntries.class.getName();
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

	@JSON
	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	@JSON
	public long getYkctEntryId() {
		return _ykctEntryId;
	}

	public void setYkctEntryId(long ykctEntryId) {
		_columnBitmask |= YKCTENTRYID_COLUMN_BITMASK;

		if (!_setOriginalYkctEntryId) {
			_setOriginalYkctEntryId = true;

			_originalYkctEntryId = _ykctEntryId;
		}

		_ykctEntryId = ykctEntryId;
	}

	public long getOriginalYkctEntryId() {
		return _originalYkctEntryId;
	}

	@JSON
	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_columnBitmask |= FILEENTRYID_COLUMN_BITMASK;

		if (!_setOriginalFileEntryId) {
			_setOriginalFileEntryId = true;

			_originalFileEntryId = _fileEntryId;
		}

		_fileEntryId = fileEntryId;
	}

	public long getOriginalFileEntryId() {
		return _originalFileEntryId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			YKCT_DlFileEntries.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public YKCT_DlFileEntries toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (YKCT_DlFileEntries)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		YKCT_DlFileEntriesImpl ykct_DlFileEntriesImpl = new YKCT_DlFileEntriesImpl();

		ykct_DlFileEntriesImpl.setId(getId());
		ykct_DlFileEntriesImpl.setYkctEntryId(getYkctEntryId());
		ykct_DlFileEntriesImpl.setFileEntryId(getFileEntryId());

		ykct_DlFileEntriesImpl.resetOriginalValues();

		return ykct_DlFileEntriesImpl;
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

		YKCT_DlFileEntries ykct_DlFileEntries = null;

		try {
			ykct_DlFileEntries = (YKCT_DlFileEntries)obj;
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
	public void resetOriginalValues() {
		YKCT_DlFileEntriesModelImpl ykct_DlFileEntriesModelImpl = this;

		ykct_DlFileEntriesModelImpl._originalYkctEntryId = ykct_DlFileEntriesModelImpl._ykctEntryId;

		ykct_DlFileEntriesModelImpl._setOriginalYkctEntryId = false;

		ykct_DlFileEntriesModelImpl._originalFileEntryId = ykct_DlFileEntriesModelImpl._fileEntryId;

		ykct_DlFileEntriesModelImpl._setOriginalFileEntryId = false;

		ykct_DlFileEntriesModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<YKCT_DlFileEntries> toCacheModel() {
		YKCT_DlFileEntriesCacheModel ykct_DlFileEntriesCacheModel = new YKCT_DlFileEntriesCacheModel();

		ykct_DlFileEntriesCacheModel.id = getId();

		ykct_DlFileEntriesCacheModel.ykctEntryId = getYkctEntryId();

		ykct_DlFileEntriesCacheModel.fileEntryId = getFileEntryId();

		return ykct_DlFileEntriesCacheModel;
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

	private static ClassLoader _classLoader = YKCT_DlFileEntries.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			YKCT_DlFileEntries.class
		};
	private long _id;
	private long _ykctEntryId;
	private long _originalYkctEntryId;
	private boolean _setOriginalYkctEntryId;
	private long _fileEntryId;
	private long _originalFileEntryId;
	private boolean _setOriginalFileEntryId;
	private long _columnBitmask;
	private YKCT_DlFileEntries _escapedModelProxy;
}