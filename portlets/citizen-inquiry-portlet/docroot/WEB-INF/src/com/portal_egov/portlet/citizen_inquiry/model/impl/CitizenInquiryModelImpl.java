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

package com.portal_egov.portlet.citizen_inquiry.model.impl;

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

import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry;
import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryModel;
import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquirySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CitizenInquiry service. Represents a row in the &quot;CitizenInquiry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CitizenInquiryImpl}.
 * </p>
 *
 * @author HungDX
 * @see CitizenInquiryImpl
 * @see com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry
 * @see com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryModel
 * @generated
 */
@JSON(strict = true)
public class CitizenInquiryModelImpl extends BaseModelImpl<CitizenInquiry>
	implements CitizenInquiryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a citizen inquiry model instance should use the {@link com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry} interface instead.
	 */
	public static final String TABLE_NAME = "CitizenInquiry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "inquiryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "categoryId", Types.BIGINT },
			{ "citizenName", Types.VARCHAR },
			{ "citizenPhone", Types.VARCHAR },
			{ "citizenEmail", Types.VARCHAR },
			{ "citizenAddress", Types.VARCHAR },
			{ "inquiryTitle", Types.VARCHAR },
			{ "inquiryContent", Types.VARCHAR },
			{ "inquiryFeedback", Types.VARCHAR },
			{ "inquiryFeedbackUser", Types.VARCHAR },
			{ "inquiryFeedbackDate", Types.TIMESTAMP },
			{ "inquiryStatus", Types.INTEGER },
			{ "approved", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table CitizenInquiry (inquiryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,categoryId LONG,citizenName VARCHAR(75) null,citizenPhone VARCHAR(75) null,citizenEmail VARCHAR(75) null,citizenAddress VARCHAR(75) null,inquiryTitle VARCHAR(75) null,inquiryContent VARCHAR(75) null,inquiryFeedback VARCHAR(75) null,inquiryFeedbackUser VARCHAR(75) null,inquiryFeedbackDate DATE null,inquiryStatus INTEGER,approved BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table CitizenInquiry";
	public static final String ORDER_BY_JPQL = " ORDER BY citizenInquiry.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CitizenInquiry.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry"),
			true);
	public static long CATEGORYID_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CitizenInquiry toModel(CitizenInquirySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CitizenInquiry model = new CitizenInquiryImpl();

		model.setInquiryId(soapModel.getInquiryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCategoryId(soapModel.getCategoryId());
		model.setCitizenName(soapModel.getCitizenName());
		model.setCitizenPhone(soapModel.getCitizenPhone());
		model.setCitizenEmail(soapModel.getCitizenEmail());
		model.setCitizenAddress(soapModel.getCitizenAddress());
		model.setInquiryTitle(soapModel.getInquiryTitle());
		model.setInquiryContent(soapModel.getInquiryContent());
		model.setInquiryFeedback(soapModel.getInquiryFeedback());
		model.setInquiryFeedbackUser(soapModel.getInquiryFeedbackUser());
		model.setInquiryFeedbackDate(soapModel.getInquiryFeedbackDate());
		model.setInquiryStatus(soapModel.getInquiryStatus());
		model.setApproved(soapModel.getApproved());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CitizenInquiry> toModels(CitizenInquirySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CitizenInquiry> models = new ArrayList<CitizenInquiry>(soapModels.length);

		for (CitizenInquirySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry"));

	public CitizenInquiryModelImpl() {
	}

	public long getPrimaryKey() {
		return _inquiryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setInquiryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_inquiryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return CitizenInquiry.class;
	}

	public String getModelClassName() {
		return CitizenInquiry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("inquiryId", getInquiryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryId", getCategoryId());
		attributes.put("citizenName", getCitizenName());
		attributes.put("citizenPhone", getCitizenPhone());
		attributes.put("citizenEmail", getCitizenEmail());
		attributes.put("citizenAddress", getCitizenAddress());
		attributes.put("inquiryTitle", getInquiryTitle());
		attributes.put("inquiryContent", getInquiryContent());
		attributes.put("inquiryFeedback", getInquiryFeedback());
		attributes.put("inquiryFeedbackUser", getInquiryFeedbackUser());
		attributes.put("inquiryFeedbackDate", getInquiryFeedbackDate());
		attributes.put("inquiryStatus", getInquiryStatus());
		attributes.put("approved", getApproved());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long inquiryId = (Long)attributes.get("inquiryId");

		if (inquiryId != null) {
			setInquiryId(inquiryId);
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

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String citizenName = (String)attributes.get("citizenName");

		if (citizenName != null) {
			setCitizenName(citizenName);
		}

		String citizenPhone = (String)attributes.get("citizenPhone");

		if (citizenPhone != null) {
			setCitizenPhone(citizenPhone);
		}

		String citizenEmail = (String)attributes.get("citizenEmail");

		if (citizenEmail != null) {
			setCitizenEmail(citizenEmail);
		}

		String citizenAddress = (String)attributes.get("citizenAddress");

		if (citizenAddress != null) {
			setCitizenAddress(citizenAddress);
		}

		String inquiryTitle = (String)attributes.get("inquiryTitle");

		if (inquiryTitle != null) {
			setInquiryTitle(inquiryTitle);
		}

		String inquiryContent = (String)attributes.get("inquiryContent");

		if (inquiryContent != null) {
			setInquiryContent(inquiryContent);
		}

		String inquiryFeedback = (String)attributes.get("inquiryFeedback");

		if (inquiryFeedback != null) {
			setInquiryFeedback(inquiryFeedback);
		}

		String inquiryFeedbackUser = (String)attributes.get(
				"inquiryFeedbackUser");

		if (inquiryFeedbackUser != null) {
			setInquiryFeedbackUser(inquiryFeedbackUser);
		}

		Date inquiryFeedbackDate = (Date)attributes.get("inquiryFeedbackDate");

		if (inquiryFeedbackDate != null) {
			setInquiryFeedbackDate(inquiryFeedbackDate);
		}

		Integer inquiryStatus = (Integer)attributes.get("inquiryStatus");

		if (inquiryStatus != null) {
			setInquiryStatus(inquiryStatus);
		}

		Boolean approved = (Boolean)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}
	}

	@JSON
	public long getInquiryId() {
		return _inquiryId;
	}

	public void setInquiryId(long inquiryId) {
		_inquiryId = inquiryId;
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
	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_columnBitmask |= CATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalCategoryId) {
			_setOriginalCategoryId = true;

			_originalCategoryId = _categoryId;
		}

		_categoryId = categoryId;
	}

	public long getOriginalCategoryId() {
		return _originalCategoryId;
	}

	@JSON
	public String getCitizenName() {
		if (_citizenName == null) {
			return StringPool.BLANK;
		}
		else {
			return _citizenName;
		}
	}

	public void setCitizenName(String citizenName) {
		_citizenName = citizenName;
	}

	@JSON
	public String getCitizenPhone() {
		if (_citizenPhone == null) {
			return StringPool.BLANK;
		}
		else {
			return _citizenPhone;
		}
	}

	public void setCitizenPhone(String citizenPhone) {
		_citizenPhone = citizenPhone;
	}

	@JSON
	public String getCitizenEmail() {
		if (_citizenEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _citizenEmail;
		}
	}

	public void setCitizenEmail(String citizenEmail) {
		_citizenEmail = citizenEmail;
	}

	@JSON
	public String getCitizenAddress() {
		if (_citizenAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _citizenAddress;
		}
	}

	public void setCitizenAddress(String citizenAddress) {
		_citizenAddress = citizenAddress;
	}

	@JSON
	public String getInquiryTitle() {
		if (_inquiryTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _inquiryTitle;
		}
	}

	public void setInquiryTitle(String inquiryTitle) {
		_inquiryTitle = inquiryTitle;
	}

	@JSON
	public String getInquiryContent() {
		if (_inquiryContent == null) {
			return StringPool.BLANK;
		}
		else {
			return _inquiryContent;
		}
	}

	public void setInquiryContent(String inquiryContent) {
		_inquiryContent = inquiryContent;
	}

	@JSON
	public String getInquiryFeedback() {
		if (_inquiryFeedback == null) {
			return StringPool.BLANK;
		}
		else {
			return _inquiryFeedback;
		}
	}

	public void setInquiryFeedback(String inquiryFeedback) {
		_inquiryFeedback = inquiryFeedback;
	}

	@JSON
	public String getInquiryFeedbackUser() {
		if (_inquiryFeedbackUser == null) {
			return StringPool.BLANK;
		}
		else {
			return _inquiryFeedbackUser;
		}
	}

	public void setInquiryFeedbackUser(String inquiryFeedbackUser) {
		_inquiryFeedbackUser = inquiryFeedbackUser;
	}

	@JSON
	public Date getInquiryFeedbackDate() {
		return _inquiryFeedbackDate;
	}

	public void setInquiryFeedbackDate(Date inquiryFeedbackDate) {
		_inquiryFeedbackDate = inquiryFeedbackDate;
	}

	@JSON
	public int getInquiryStatus() {
		return _inquiryStatus;
	}

	public void setInquiryStatus(int inquiryStatus) {
		_inquiryStatus = inquiryStatus;
	}

	@JSON
	public boolean getApproved() {
		return _approved;
	}

	public boolean isApproved() {
		return _approved;
	}

	public void setApproved(boolean approved) {
		_approved = approved;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CitizenInquiry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CitizenInquiry toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (CitizenInquiry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		CitizenInquiryImpl citizenInquiryImpl = new CitizenInquiryImpl();

		citizenInquiryImpl.setInquiryId(getInquiryId());
		citizenInquiryImpl.setGroupId(getGroupId());
		citizenInquiryImpl.setCompanyId(getCompanyId());
		citizenInquiryImpl.setUserId(getUserId());
		citizenInquiryImpl.setUserName(getUserName());
		citizenInquiryImpl.setCreateDate(getCreateDate());
		citizenInquiryImpl.setModifiedDate(getModifiedDate());
		citizenInquiryImpl.setCategoryId(getCategoryId());
		citizenInquiryImpl.setCitizenName(getCitizenName());
		citizenInquiryImpl.setCitizenPhone(getCitizenPhone());
		citizenInquiryImpl.setCitizenEmail(getCitizenEmail());
		citizenInquiryImpl.setCitizenAddress(getCitizenAddress());
		citizenInquiryImpl.setInquiryTitle(getInquiryTitle());
		citizenInquiryImpl.setInquiryContent(getInquiryContent());
		citizenInquiryImpl.setInquiryFeedback(getInquiryFeedback());
		citizenInquiryImpl.setInquiryFeedbackUser(getInquiryFeedbackUser());
		citizenInquiryImpl.setInquiryFeedbackDate(getInquiryFeedbackDate());
		citizenInquiryImpl.setInquiryStatus(getInquiryStatus());
		citizenInquiryImpl.setApproved(getApproved());

		citizenInquiryImpl.resetOriginalValues();

		return citizenInquiryImpl;
	}

	public int compareTo(CitizenInquiry citizenInquiry) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				citizenInquiry.getCreateDate());

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

		CitizenInquiry citizenInquiry = null;

		try {
			citizenInquiry = (CitizenInquiry)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = citizenInquiry.getPrimaryKey();

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
		CitizenInquiryModelImpl citizenInquiryModelImpl = this;

		citizenInquiryModelImpl._originalGroupId = citizenInquiryModelImpl._groupId;

		citizenInquiryModelImpl._setOriginalGroupId = false;

		citizenInquiryModelImpl._originalCompanyId = citizenInquiryModelImpl._companyId;

		citizenInquiryModelImpl._setOriginalCompanyId = false;

		citizenInquiryModelImpl._originalCategoryId = citizenInquiryModelImpl._categoryId;

		citizenInquiryModelImpl._setOriginalCategoryId = false;

		citizenInquiryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CitizenInquiry> toCacheModel() {
		CitizenInquiryCacheModel citizenInquiryCacheModel = new CitizenInquiryCacheModel();

		citizenInquiryCacheModel.inquiryId = getInquiryId();

		citizenInquiryCacheModel.groupId = getGroupId();

		citizenInquiryCacheModel.companyId = getCompanyId();

		citizenInquiryCacheModel.userId = getUserId();

		citizenInquiryCacheModel.userName = getUserName();

		String userName = citizenInquiryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			citizenInquiryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			citizenInquiryCacheModel.createDate = createDate.getTime();
		}
		else {
			citizenInquiryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			citizenInquiryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			citizenInquiryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		citizenInquiryCacheModel.categoryId = getCategoryId();

		citizenInquiryCacheModel.citizenName = getCitizenName();

		String citizenName = citizenInquiryCacheModel.citizenName;

		if ((citizenName != null) && (citizenName.length() == 0)) {
			citizenInquiryCacheModel.citizenName = null;
		}

		citizenInquiryCacheModel.citizenPhone = getCitizenPhone();

		String citizenPhone = citizenInquiryCacheModel.citizenPhone;

		if ((citizenPhone != null) && (citizenPhone.length() == 0)) {
			citizenInquiryCacheModel.citizenPhone = null;
		}

		citizenInquiryCacheModel.citizenEmail = getCitizenEmail();

		String citizenEmail = citizenInquiryCacheModel.citizenEmail;

		if ((citizenEmail != null) && (citizenEmail.length() == 0)) {
			citizenInquiryCacheModel.citizenEmail = null;
		}

		citizenInquiryCacheModel.citizenAddress = getCitizenAddress();

		String citizenAddress = citizenInquiryCacheModel.citizenAddress;

		if ((citizenAddress != null) && (citizenAddress.length() == 0)) {
			citizenInquiryCacheModel.citizenAddress = null;
		}

		citizenInquiryCacheModel.inquiryTitle = getInquiryTitle();

		String inquiryTitle = citizenInquiryCacheModel.inquiryTitle;

		if ((inquiryTitle != null) && (inquiryTitle.length() == 0)) {
			citizenInquiryCacheModel.inquiryTitle = null;
		}

		citizenInquiryCacheModel.inquiryContent = getInquiryContent();

		String inquiryContent = citizenInquiryCacheModel.inquiryContent;

		if ((inquiryContent != null) && (inquiryContent.length() == 0)) {
			citizenInquiryCacheModel.inquiryContent = null;
		}

		citizenInquiryCacheModel.inquiryFeedback = getInquiryFeedback();

		String inquiryFeedback = citizenInquiryCacheModel.inquiryFeedback;

		if ((inquiryFeedback != null) && (inquiryFeedback.length() == 0)) {
			citizenInquiryCacheModel.inquiryFeedback = null;
		}

		citizenInquiryCacheModel.inquiryFeedbackUser = getInquiryFeedbackUser();

		String inquiryFeedbackUser = citizenInquiryCacheModel.inquiryFeedbackUser;

		if ((inquiryFeedbackUser != null) &&
				(inquiryFeedbackUser.length() == 0)) {
			citizenInquiryCacheModel.inquiryFeedbackUser = null;
		}

		Date inquiryFeedbackDate = getInquiryFeedbackDate();

		if (inquiryFeedbackDate != null) {
			citizenInquiryCacheModel.inquiryFeedbackDate = inquiryFeedbackDate.getTime();
		}
		else {
			citizenInquiryCacheModel.inquiryFeedbackDate = Long.MIN_VALUE;
		}

		citizenInquiryCacheModel.inquiryStatus = getInquiryStatus();

		citizenInquiryCacheModel.approved = getApproved();

		return citizenInquiryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{inquiryId=");
		sb.append(getInquiryId());
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
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", citizenName=");
		sb.append(getCitizenName());
		sb.append(", citizenPhone=");
		sb.append(getCitizenPhone());
		sb.append(", citizenEmail=");
		sb.append(getCitizenEmail());
		sb.append(", citizenAddress=");
		sb.append(getCitizenAddress());
		sb.append(", inquiryTitle=");
		sb.append(getInquiryTitle());
		sb.append(", inquiryContent=");
		sb.append(getInquiryContent());
		sb.append(", inquiryFeedback=");
		sb.append(getInquiryFeedback());
		sb.append(", inquiryFeedbackUser=");
		sb.append(getInquiryFeedbackUser());
		sb.append(", inquiryFeedbackDate=");
		sb.append(getInquiryFeedbackDate());
		sb.append(", inquiryStatus=");
		sb.append(getInquiryStatus());
		sb.append(", approved=");
		sb.append(getApproved());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append(
			"com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>inquiryId</column-name><column-value><![CDATA[");
		sb.append(getInquiryId());
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
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenName</column-name><column-value><![CDATA[");
		sb.append(getCitizenName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenPhone</column-name><column-value><![CDATA[");
		sb.append(getCitizenPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenEmail</column-name><column-value><![CDATA[");
		sb.append(getCitizenEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenAddress</column-name><column-value><![CDATA[");
		sb.append(getCitizenAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inquiryTitle</column-name><column-value><![CDATA[");
		sb.append(getInquiryTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inquiryContent</column-name><column-value><![CDATA[");
		sb.append(getInquiryContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inquiryFeedback</column-name><column-value><![CDATA[");
		sb.append(getInquiryFeedback());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inquiryFeedbackUser</column-name><column-value><![CDATA[");
		sb.append(getInquiryFeedbackUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inquiryFeedbackDate</column-name><column-value><![CDATA[");
		sb.append(getInquiryFeedbackDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inquiryStatus</column-name><column-value><![CDATA[");
		sb.append(getInquiryStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approved</column-name><column-value><![CDATA[");
		sb.append(getApproved());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CitizenInquiry.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			CitizenInquiry.class
		};
	private long _inquiryId;
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
	private long _categoryId;
	private long _originalCategoryId;
	private boolean _setOriginalCategoryId;
	private String _citizenName;
	private String _citizenPhone;
	private String _citizenEmail;
	private String _citizenAddress;
	private String _inquiryTitle;
	private String _inquiryContent;
	private String _inquiryFeedback;
	private String _inquiryFeedbackUser;
	private Date _inquiryFeedbackDate;
	private int _inquiryStatus;
	private boolean _approved;
	private long _columnBitmask;
	private CitizenInquiry _escapedModelProxy;
}