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

package com.bkav.portal.portlet.employee.model.impl;

import com.bkav.portal.portlet.employee.model.Department;
import com.bkav.portal.portlet.employee.model.DepartmentModel;
import com.bkav.portal.portlet.employee.model.DepartmentSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
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

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Department service. Represents a row in the &quot;Department&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.bkav.portal.portlet.employee.model.DepartmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DepartmentImpl}.
 * </p>
 *
 * @author ducdvd
 * @see DepartmentImpl
 * @see com.bkav.portal.portlet.employee.model.Department
 * @see com.bkav.portal.portlet.employee.model.DepartmentModel
 * @generated
 */
@JSON(strict = true)
public class DepartmentModelImpl extends BaseModelImpl<Department>
	implements DepartmentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a department model instance should use the {@link com.bkav.portal.portlet.employee.model.Department} interface instead.
	 */
	public static final String TABLE_NAME = "Department";
	public static final Object[][] TABLE_COLUMNS = {
			{ "depId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "depName", Types.VARCHAR },
			{ "depAddres", Types.VARCHAR },
			{ "depPhone", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Department (depId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,depName VARCHAR(75) null,depAddres VARCHAR(75) null,depPhone VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Department";
	public static final String ORDER_BY_JPQL = " ORDER BY department.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Department.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.bkav.portal.portlet.employee.model.Department"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.bkav.portal.portlet.employee.model.Department"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.bkav.portal.portlet.employee.model.Department"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Department toModel(DepartmentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Department model = new DepartmentImpl();

		model.setDepId(soapModel.getDepId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDepName(soapModel.getDepName());
		model.setDepAddres(soapModel.getDepAddres());
		model.setDepPhone(soapModel.getDepPhone());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Department> toModels(DepartmentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Department> models = new ArrayList<Department>(soapModels.length);

		for (DepartmentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.bkav.portal.portlet.employee.model.Department"));

	public DepartmentModelImpl() {
	}

	public long getPrimaryKey() {
		return _depId;
	}

	public void setPrimaryKey(long primaryKey) {
		setDepId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_depId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Department.class;
	}

	public String getModelClassName() {
		return Department.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("depId", getDepId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("depName", getDepName());
		attributes.put("depAddres", getDepAddres());
		attributes.put("depPhone", getDepPhone());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long depId = (Long)attributes.get("depId");

		if (depId != null) {
			setDepId(depId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String depName = (String)attributes.get("depName");

		if (depName != null) {
			setDepName(depName);
		}

		String depAddres = (String)attributes.get("depAddres");

		if (depAddres != null) {
			setDepAddres(depAddres);
		}

		String depPhone = (String)attributes.get("depPhone");

		if (depPhone != null) {
			setDepPhone(depPhone);
		}
	}

	@JSON
	public long getDepId() {
		return _depId;
	}

	public void setDepId(long depId) {
		_depId = depId;
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
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

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
	public String getDepName() {
		if (_depName == null) {
			return StringPool.BLANK;
		}
		else {
			return _depName;
		}
	}

	public void setDepName(String depName) {
		_depName = depName;
	}

	@JSON
	public String getDepAddres() {
		if (_depAddres == null) {
			return StringPool.BLANK;
		}
		else {
			return _depAddres;
		}
	}

	public void setDepAddres(String depAddres) {
		_depAddres = depAddres;
	}

	@JSON
	public String getDepPhone() {
		if (_depPhone == null) {
			return StringPool.BLANK;
		}
		else {
			return _depPhone;
		}
	}

	public void setDepPhone(String depPhone) {
		_depPhone = depPhone;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Department.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Department toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Department)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		DepartmentImpl departmentImpl = new DepartmentImpl();

		departmentImpl.setDepId(getDepId());
		departmentImpl.setGroupId(getGroupId());
		departmentImpl.setCompanyId(getCompanyId());
		departmentImpl.setUserId(getUserId());
		departmentImpl.setUserName(getUserName());
		departmentImpl.setCreateDate(getCreateDate());
		departmentImpl.setModifiedDate(getModifiedDate());
		departmentImpl.setDepName(getDepName());
		departmentImpl.setDepAddres(getDepAddres());
		departmentImpl.setDepPhone(getDepPhone());

		departmentImpl.resetOriginalValues();

		return departmentImpl;
	}

	public int compareTo(Department department) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), department.getCreateDate());

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

		Department department = null;

		try {
			department = (Department)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = department.getPrimaryKey();

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
		DepartmentModelImpl departmentModelImpl = this;

		departmentModelImpl._originalGroupId = departmentModelImpl._groupId;

		departmentModelImpl._setOriginalGroupId = false;

		departmentModelImpl._originalCompanyId = departmentModelImpl._companyId;

		departmentModelImpl._setOriginalCompanyId = false;

		departmentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Department> toCacheModel() {
		DepartmentCacheModel departmentCacheModel = new DepartmentCacheModel();

		departmentCacheModel.depId = getDepId();

		departmentCacheModel.groupId = getGroupId();

		departmentCacheModel.companyId = getCompanyId();

		departmentCacheModel.userId = getUserId();

		departmentCacheModel.userName = getUserName();

		String userName = departmentCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			departmentCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			departmentCacheModel.createDate = createDate.getTime();
		}
		else {
			departmentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			departmentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			departmentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		departmentCacheModel.depName = getDepName();

		String depName = departmentCacheModel.depName;

		if ((depName != null) && (depName.length() == 0)) {
			departmentCacheModel.depName = null;
		}

		departmentCacheModel.depAddres = getDepAddres();

		String depAddres = departmentCacheModel.depAddres;

		if ((depAddres != null) && (depAddres.length() == 0)) {
			departmentCacheModel.depAddres = null;
		}

		departmentCacheModel.depPhone = getDepPhone();

		String depPhone = departmentCacheModel.depPhone;

		if ((depPhone != null) && (depPhone.length() == 0)) {
			departmentCacheModel.depPhone = null;
		}

		return departmentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{depId=");
		sb.append(getDepId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", depName=");
		sb.append(getDepName());
		sb.append(", depAddres=");
		sb.append(getDepAddres());
		sb.append(", depPhone=");
		sb.append(getDepPhone());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.employee.model.Department");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>depId</column-name><column-value><![CDATA[");
		sb.append(getDepId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
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
			"<column><column-name>depName</column-name><column-value><![CDATA[");
		sb.append(getDepName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>depAddres</column-name><column-value><![CDATA[");
		sb.append(getDepAddres());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>depPhone</column-name><column-value><![CDATA[");
		sb.append(getDepPhone());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Department.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Department.class
		};
	private long _depId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _depName;
	private String _depAddres;
	private String _depPhone;
	private long _columnBitmask;
	private Department _escapedModelProxy;
}