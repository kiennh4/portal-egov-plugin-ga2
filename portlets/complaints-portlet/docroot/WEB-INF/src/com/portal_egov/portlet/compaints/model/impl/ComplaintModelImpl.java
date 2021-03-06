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

package com.portal_egov.portlet.compaints.model.impl;

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

import com.portal_egov.portlet.compaints.model.Complaint;
import com.portal_egov.portlet.compaints.model.ComplaintModel;
import com.portal_egov.portlet.compaints.model.ComplaintSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Complaint service. Represents a row in the &quot;Complaint&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.portal_egov.portlet.compaints.model.ComplaintModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ComplaintImpl}.
 * </p>
 *
 * @author HungDX
 * @see ComplaintImpl
 * @see com.portal_egov.portlet.compaints.model.Complaint
 * @see com.portal_egov.portlet.compaints.model.ComplaintModel
 * @generated
 */
@JSON(strict = true)
public class ComplaintModelImpl extends BaseModelImpl<Complaint>
	implements ComplaintModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a complaint model instance should use the {@link com.portal_egov.portlet.compaints.model.Complaint} interface instead.
	 */
	public static final String TABLE_NAME = "Complaint";
	public static final Object[][] TABLE_COLUMNS = {
			{ "complaintId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "complaintTitle", Types.VARCHAR },
			{ "complaintDescription", Types.VARCHAR },
			{ "complaintContent", Types.VARCHAR },
			{ "fileAttachmentURL", Types.VARCHAR },
			{ "complaintStatus", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table Complaint (complaintId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,complaintTitle STRING null,complaintDescription STRING null,complaintContent STRING null,fileAttachmentURL VARCHAR(75) null,complaintStatus INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table Complaint";
	public static final String ORDER_BY_JPQL = " ORDER BY complaint.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY Complaint.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.portal_egov.portlet.compaints.model.Complaint"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.portal_egov.portlet.compaints.model.Complaint"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.portal_egov.portlet.compaints.model.Complaint"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Complaint toModel(ComplaintSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Complaint model = new ComplaintImpl();

		model.setComplaintId(soapModel.getComplaintId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setComplaintTitle(soapModel.getComplaintTitle());
		model.setComplaintDescription(soapModel.getComplaintDescription());
		model.setComplaintContent(soapModel.getComplaintContent());
		model.setFileAttachmentURL(soapModel.getFileAttachmentURL());
		model.setComplaintStatus(soapModel.getComplaintStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Complaint> toModels(ComplaintSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Complaint> models = new ArrayList<Complaint>(soapModels.length);

		for (ComplaintSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.portal_egov.portlet.compaints.model.Complaint"));

	public ComplaintModelImpl() {
	}

	public long getPrimaryKey() {
		return _complaintId;
	}

	public void setPrimaryKey(long primaryKey) {
		setComplaintId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_complaintId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Complaint.class;
	}

	public String getModelClassName() {
		return Complaint.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("complaintId", getComplaintId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("complaintTitle", getComplaintTitle());
		attributes.put("complaintDescription", getComplaintDescription());
		attributes.put("complaintContent", getComplaintContent());
		attributes.put("fileAttachmentURL", getFileAttachmentURL());
		attributes.put("complaintStatus", getComplaintStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long complaintId = (Long)attributes.get("complaintId");

		if (complaintId != null) {
			setComplaintId(complaintId);
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

		String complaintTitle = (String)attributes.get("complaintTitle");

		if (complaintTitle != null) {
			setComplaintTitle(complaintTitle);
		}

		String complaintDescription = (String)attributes.get(
				"complaintDescription");

		if (complaintDescription != null) {
			setComplaintDescription(complaintDescription);
		}

		String complaintContent = (String)attributes.get("complaintContent");

		if (complaintContent != null) {
			setComplaintContent(complaintContent);
		}

		String fileAttachmentURL = (String)attributes.get("fileAttachmentURL");

		if (fileAttachmentURL != null) {
			setFileAttachmentURL(fileAttachmentURL);
		}

		Integer complaintStatus = (Integer)attributes.get("complaintStatus");

		if (complaintStatus != null) {
			setComplaintStatus(complaintStatus);
		}
	}

	@JSON
	public long getComplaintId() {
		return _complaintId;
	}

	public void setComplaintId(long complaintId) {
		_complaintId = complaintId;
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
	public String getComplaintTitle() {
		if (_complaintTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _complaintTitle;
		}
	}

	public void setComplaintTitle(String complaintTitle) {
		_complaintTitle = complaintTitle;
	}

	@JSON
	public String getComplaintDescription() {
		if (_complaintDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _complaintDescription;
		}
	}

	public void setComplaintDescription(String complaintDescription) {
		_complaintDescription = complaintDescription;
	}

	@JSON
	public String getComplaintContent() {
		if (_complaintContent == null) {
			return StringPool.BLANK;
		}
		else {
			return _complaintContent;
		}
	}

	public void setComplaintContent(String complaintContent) {
		_complaintContent = complaintContent;
	}

	@JSON
	public String getFileAttachmentURL() {
		if (_fileAttachmentURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileAttachmentURL;
		}
	}

	public void setFileAttachmentURL(String fileAttachmentURL) {
		_fileAttachmentURL = fileAttachmentURL;
	}

	@JSON
	public int getComplaintStatus() {
		return _complaintStatus;
	}

	public void setComplaintStatus(int complaintStatus) {
		_complaintStatus = complaintStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Complaint.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Complaint toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Complaint)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		ComplaintImpl complaintImpl = new ComplaintImpl();

		complaintImpl.setComplaintId(getComplaintId());
		complaintImpl.setGroupId(getGroupId());
		complaintImpl.setCompanyId(getCompanyId());
		complaintImpl.setUserId(getUserId());
		complaintImpl.setUserName(getUserName());
		complaintImpl.setCreateDate(getCreateDate());
		complaintImpl.setModifiedDate(getModifiedDate());
		complaintImpl.setComplaintTitle(getComplaintTitle());
		complaintImpl.setComplaintDescription(getComplaintDescription());
		complaintImpl.setComplaintContent(getComplaintContent());
		complaintImpl.setFileAttachmentURL(getFileAttachmentURL());
		complaintImpl.setComplaintStatus(getComplaintStatus());

		complaintImpl.resetOriginalValues();

		return complaintImpl;
	}

	public int compareTo(Complaint complaint) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), complaint.getCreateDate());

		value = value * -1;

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

		Complaint complaint = null;

		try {
			complaint = (Complaint)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = complaint.getPrimaryKey();

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
		ComplaintModelImpl complaintModelImpl = this;

		complaintModelImpl._originalGroupId = complaintModelImpl._groupId;

		complaintModelImpl._setOriginalGroupId = false;

		complaintModelImpl._originalCompanyId = complaintModelImpl._companyId;

		complaintModelImpl._setOriginalCompanyId = false;

		complaintModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Complaint> toCacheModel() {
		ComplaintCacheModel complaintCacheModel = new ComplaintCacheModel();

		complaintCacheModel.complaintId = getComplaintId();

		complaintCacheModel.groupId = getGroupId();

		complaintCacheModel.companyId = getCompanyId();

		complaintCacheModel.userId = getUserId();

		complaintCacheModel.userName = getUserName();

		String userName = complaintCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			complaintCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			complaintCacheModel.createDate = createDate.getTime();
		}
		else {
			complaintCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			complaintCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			complaintCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		complaintCacheModel.complaintTitle = getComplaintTitle();

		String complaintTitle = complaintCacheModel.complaintTitle;

		if ((complaintTitle != null) && (complaintTitle.length() == 0)) {
			complaintCacheModel.complaintTitle = null;
		}

		complaintCacheModel.complaintDescription = getComplaintDescription();

		String complaintDescription = complaintCacheModel.complaintDescription;

		if ((complaintDescription != null) &&
				(complaintDescription.length() == 0)) {
			complaintCacheModel.complaintDescription = null;
		}

		complaintCacheModel.complaintContent = getComplaintContent();

		String complaintContent = complaintCacheModel.complaintContent;

		if ((complaintContent != null) && (complaintContent.length() == 0)) {
			complaintCacheModel.complaintContent = null;
		}

		complaintCacheModel.fileAttachmentURL = getFileAttachmentURL();

		String fileAttachmentURL = complaintCacheModel.fileAttachmentURL;

		if ((fileAttachmentURL != null) && (fileAttachmentURL.length() == 0)) {
			complaintCacheModel.fileAttachmentURL = null;
		}

		complaintCacheModel.complaintStatus = getComplaintStatus();

		return complaintCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{complaintId=");
		sb.append(getComplaintId());
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
		sb.append(", complaintTitle=");
		sb.append(getComplaintTitle());
		sb.append(", complaintDescription=");
		sb.append(getComplaintDescription());
		sb.append(", complaintContent=");
		sb.append(getComplaintContent());
		sb.append(", fileAttachmentURL=");
		sb.append(getFileAttachmentURL());
		sb.append(", complaintStatus=");
		sb.append(getComplaintStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.compaints.model.Complaint");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>complaintId</column-name><column-value><![CDATA[");
		sb.append(getComplaintId());
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
			"<column><column-name>complaintTitle</column-name><column-value><![CDATA[");
		sb.append(getComplaintTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complaintDescription</column-name><column-value><![CDATA[");
		sb.append(getComplaintDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complaintContent</column-name><column-value><![CDATA[");
		sb.append(getComplaintContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileAttachmentURL</column-name><column-value><![CDATA[");
		sb.append(getFileAttachmentURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complaintStatus</column-name><column-value><![CDATA[");
		sb.append(getComplaintStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Complaint.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Complaint.class
		};
	private long _complaintId;
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
	private String _complaintTitle;
	private String _complaintDescription;
	private String _complaintContent;
	private String _fileAttachmentURL;
	private int _complaintStatus;
	private long _columnBitmask;
	private Complaint _escapedModelProxy;
}