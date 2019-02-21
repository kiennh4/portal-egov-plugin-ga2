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

package com.portal_egov.portlet.vbpq.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.portal_egov.portlet.vbpq.model.VBPQ_Category;
import com.portal_egov.portlet.vbpq.model.VBPQ_CategoryModel;
import com.portal_egov.portlet.vbpq.model.VBPQ_CategorySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the VBPQ_Category service. Represents a row in the &quot;vbpq_category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.portal_egov.portlet.vbpq.model.VBPQ_CategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VBPQ_CategoryImpl}.
 * </p>
 *
 * @author HungDX
 * @see VBPQ_CategoryImpl
 * @see com.portal_egov.portlet.vbpq.model.VBPQ_Category
 * @see com.portal_egov.portlet.vbpq.model.VBPQ_CategoryModel
 * @generated
 */
@JSON(strict = true)
public class VBPQ_CategoryModelImpl extends BaseModelImpl<VBPQ_Category>
	implements VBPQ_CategoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a v b p q_ category model instance should use the {@link com.portal_egov.portlet.vbpq.model.VBPQ_Category} interface instead.
	 */
	public static final String TABLE_NAME = "vbpq_category";
	public static final Object[][] TABLE_COLUMNS = {
			{ "categoryId", Types.BIGINT },
			{ "parentId", Types.BIGINT },
			{ "typeId", Types.INTEGER },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "categoryName", Types.VARCHAR },
			{ "categoryDesc", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "active_", Types.BOOLEAN },
			{ "displayPriority", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table vbpq_category (categoryId LONG not null primary key,parentId LONG,typeId INTEGER,companyId LONG,groupId LONG,userId LONG,categoryName VARCHAR(1000) null,categoryDesc VARCHAR(2000) null,createDate DATE null,modifiedDate DATE null,active_ BOOLEAN,displayPriority INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table vbpq_category";
	public static final String ORDER_BY_JPQL = " ORDER BY vbpq_Category.displayPriority ASC";
	public static final String ORDER_BY_SQL = " ORDER BY vbpq_category.displayPriority ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.portal_egov.portlet.vbpq.model.VBPQ_Category"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.portal_egov.portlet.vbpq.model.VBPQ_Category"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.portal_egov.portlet.vbpq.model.VBPQ_Category"),
			true);
	public static long ACTIVE_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long PARENTID_COLUMN_BITMASK = 8L;
	public static long TYPEID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static VBPQ_Category toModel(VBPQ_CategorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		VBPQ_Category model = new VBPQ_CategoryImpl();

		model.setCategoryId(soapModel.getCategoryId());
		model.setParentId(soapModel.getParentId());
		model.setTypeId(soapModel.getTypeId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCategoryName(soapModel.getCategoryName());
		model.setCategoryDesc(soapModel.getCategoryDesc());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setActive(soapModel.getActive());
		model.setDisplayPriority(soapModel.getDisplayPriority());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<VBPQ_Category> toModels(VBPQ_CategorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<VBPQ_Category> models = new ArrayList<VBPQ_Category>(soapModels.length);

		for (VBPQ_CategorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.portal_egov.portlet.vbpq.model.VBPQ_Category"));

	public VBPQ_CategoryModelImpl() {
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCategoryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_categoryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return VBPQ_Category.class;
	}

	public String getModelClassName() {
		return VBPQ_Category.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("parentId", getParentId());
		attributes.put("typeId", getTypeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("categoryDesc", getCategoryDesc());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", getActive());
		attributes.put("displayPriority", getDisplayPriority());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Integer typeId = (Integer)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		String categoryDesc = (String)attributes.get("categoryDesc");

		if (categoryDesc != null) {
			setCategoryDesc(categoryDesc);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Integer displayPriority = (Integer)attributes.get("displayPriority");

		if (displayPriority != null) {
			setDisplayPriority(displayPriority);
		}
	}

	@JSON
	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	@JSON
	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_columnBitmask |= PARENTID_COLUMN_BITMASK;

		if (!_setOriginalParentId) {
			_setOriginalParentId = true;

			_originalParentId = _parentId;
		}

		_parentId = parentId;
	}

	public long getOriginalParentId() {
		return _originalParentId;
	}

	@JSON
	public int getTypeId() {
		return _typeId;
	}

	public void setTypeId(int typeId) {
		_columnBitmask |= TYPEID_COLUMN_BITMASK;

		if (!_setOriginalTypeId) {
			_setOriginalTypeId = true;

			_originalTypeId = _typeId;
		}

		_typeId = typeId;
	}

	public int getOriginalTypeId() {
		return _originalTypeId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	public String getCategoryName() {
		if (_categoryName == null) {
			return StringPool.BLANK;
		}
		else {
			return _categoryName;
		}
	}

	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
	}

	@JSON
	public String getCategoryDesc() {
		if (_categoryDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _categoryDesc;
		}
	}

	public void setCategoryDesc(String categoryDesc) {
		_categoryDesc = categoryDesc;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	@JSON
	public int getDisplayPriority() {
		return _displayPriority;
	}

	public void setDisplayPriority(int displayPriority) {
		_columnBitmask = -1L;

		_displayPriority = displayPriority;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			VBPQ_Category.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VBPQ_Category toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (VBPQ_Category)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		VBPQ_CategoryImpl vbpq_CategoryImpl = new VBPQ_CategoryImpl();

		vbpq_CategoryImpl.setCategoryId(getCategoryId());
		vbpq_CategoryImpl.setParentId(getParentId());
		vbpq_CategoryImpl.setTypeId(getTypeId());
		vbpq_CategoryImpl.setCompanyId(getCompanyId());
		vbpq_CategoryImpl.setGroupId(getGroupId());
		vbpq_CategoryImpl.setUserId(getUserId());
		vbpq_CategoryImpl.setCategoryName(getCategoryName());
		vbpq_CategoryImpl.setCategoryDesc(getCategoryDesc());
		vbpq_CategoryImpl.setCreateDate(getCreateDate());
		vbpq_CategoryImpl.setModifiedDate(getModifiedDate());
		vbpq_CategoryImpl.setActive(getActive());
		vbpq_CategoryImpl.setDisplayPriority(getDisplayPriority());

		vbpq_CategoryImpl.resetOriginalValues();

		return vbpq_CategoryImpl;
	}

	public int compareTo(VBPQ_Category vbpq_Category) {
		int value = 0;

		if (getDisplayPriority() < vbpq_Category.getDisplayPriority()) {
			value = -1;
		}
		else if (getDisplayPriority() > vbpq_Category.getDisplayPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		VBPQ_Category vbpq_Category = null;

		try {
			vbpq_Category = (VBPQ_Category)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = vbpq_Category.getPrimaryKey();

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
		VBPQ_CategoryModelImpl vbpq_CategoryModelImpl = this;

		vbpq_CategoryModelImpl._originalParentId = vbpq_CategoryModelImpl._parentId;

		vbpq_CategoryModelImpl._setOriginalParentId = false;

		vbpq_CategoryModelImpl._originalTypeId = vbpq_CategoryModelImpl._typeId;

		vbpq_CategoryModelImpl._setOriginalTypeId = false;

		vbpq_CategoryModelImpl._originalCompanyId = vbpq_CategoryModelImpl._companyId;

		vbpq_CategoryModelImpl._setOriginalCompanyId = false;

		vbpq_CategoryModelImpl._originalGroupId = vbpq_CategoryModelImpl._groupId;

		vbpq_CategoryModelImpl._setOriginalGroupId = false;

		vbpq_CategoryModelImpl._originalActive = vbpq_CategoryModelImpl._active;

		vbpq_CategoryModelImpl._setOriginalActive = false;

		vbpq_CategoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VBPQ_Category> toCacheModel() {
		VBPQ_CategoryCacheModel vbpq_CategoryCacheModel = new VBPQ_CategoryCacheModel();

		vbpq_CategoryCacheModel.categoryId = getCategoryId();

		vbpq_CategoryCacheModel.parentId = getParentId();

		vbpq_CategoryCacheModel.typeId = getTypeId();

		vbpq_CategoryCacheModel.companyId = getCompanyId();

		vbpq_CategoryCacheModel.groupId = getGroupId();

		vbpq_CategoryCacheModel.userId = getUserId();

		vbpq_CategoryCacheModel.categoryName = getCategoryName();

		String categoryName = vbpq_CategoryCacheModel.categoryName;

		if ((categoryName != null) && (categoryName.length() == 0)) {
			vbpq_CategoryCacheModel.categoryName = null;
		}

		vbpq_CategoryCacheModel.categoryDesc = getCategoryDesc();

		String categoryDesc = vbpq_CategoryCacheModel.categoryDesc;

		if ((categoryDesc != null) && (categoryDesc.length() == 0)) {
			vbpq_CategoryCacheModel.categoryDesc = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			vbpq_CategoryCacheModel.createDate = createDate.getTime();
		}
		else {
			vbpq_CategoryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			vbpq_CategoryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			vbpq_CategoryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		vbpq_CategoryCacheModel.active = getActive();

		vbpq_CategoryCacheModel.displayPriority = getDisplayPriority();

		return vbpq_CategoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{categoryId=");
		sb.append(getCategoryId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", typeId=");
		sb.append(getTypeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", categoryName=");
		sb.append(getCategoryName());
		sb.append(", categoryDesc=");
		sb.append(getCategoryDesc());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", displayPriority=");
		sb.append(getDisplayPriority());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.vbpq.model.VBPQ_Category");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeId</column-name><column-value><![CDATA[");
		sb.append(getTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryName</column-name><column-value><![CDATA[");
		sb.append(getCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryDesc</column-name><column-value><![CDATA[");
		sb.append(getCategoryDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayPriority</column-name><column-value><![CDATA[");
		sb.append(getDisplayPriority());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = VBPQ_Category.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			VBPQ_Category.class
		};
	private long _categoryId;
	private long _parentId;
	private long _originalParentId;
	private boolean _setOriginalParentId;
	private int _typeId;
	private int _originalTypeId;
	private boolean _setOriginalTypeId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private String _categoryName;
	private String _categoryDesc;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private int _displayPriority;
	private long _columnBitmask;
	private VBPQ_Category _escapedModelProxy;
}