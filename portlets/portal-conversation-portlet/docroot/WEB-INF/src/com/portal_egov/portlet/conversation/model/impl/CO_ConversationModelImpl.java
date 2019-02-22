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

package com.portal_egov.portlet.conversation.model.impl;

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

import com.portal_egov.portlet.conversation.model.CO_Conversation;
import com.portal_egov.portlet.conversation.model.CO_ConversationModel;
import com.portal_egov.portlet.conversation.model.CO_ConversationSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CO_Conversation service. Represents a row in the &quot;CO_Conversation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.portal_egov.portlet.conversation.model.CO_ConversationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CO_ConversationImpl}.
 * </p>
 *
 * @author DucDVd
 * @see CO_ConversationImpl
 * @see com.portal_egov.portlet.conversation.model.CO_Conversation
 * @see com.portal_egov.portlet.conversation.model.CO_ConversationModel
 * @generated
 */
@JSON(strict = true)
public class CO_ConversationModelImpl extends BaseModelImpl<CO_Conversation>
	implements CO_ConversationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a c o_ conversation model instance should use the {@link com.portal_egov.portlet.conversation.model.CO_Conversation} interface instead.
	 */
	public static final String TABLE_NAME = "CO_Conversation";
	public static final Object[][] TABLE_COLUMNS = {
			{ "conversationId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "threadId", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "askUserName", Types.VARCHAR },
			{ "askUserInfo", Types.VARCHAR },
			{ "askContent", Types.VARCHAR },
			{ "answerUserName", Types.VARCHAR },
			{ "answerUserInfo", Types.VARCHAR },
			{ "answerContent", Types.VARCHAR },
			{ "askDate", Types.TIMESTAMP },
			{ "answerDate", Types.TIMESTAMP },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table CO_Conversation (conversationId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,threadId LONG,title VARCHAR(75) null,askUserName VARCHAR(75) null,askUserInfo VARCHAR(75) null,askContent VARCHAR(75) null,answerUserName VARCHAR(75) null,answerUserInfo VARCHAR(75) null,answerContent VARCHAR(75) null,askDate DATE null,answerDate DATE null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table CO_Conversation";
	public static final String ORDER_BY_JPQL = " ORDER BY co_Conversation.answerDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CO_Conversation.answerDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.portal_egov.portlet.conversation.model.CO_Conversation"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.portal_egov.portlet.conversation.model.CO_Conversation"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.portal_egov.portlet.conversation.model.CO_Conversation"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long STATUS_COLUMN_BITMASK = 4L;
	public static long THREADID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CO_Conversation toModel(CO_ConversationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CO_Conversation model = new CO_ConversationImpl();

		model.setConversationId(soapModel.getConversationId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setThreadId(soapModel.getThreadId());
		model.setTitle(soapModel.getTitle());
		model.setAskUserName(soapModel.getAskUserName());
		model.setAskUserInfo(soapModel.getAskUserInfo());
		model.setAskContent(soapModel.getAskContent());
		model.setAnswerUserName(soapModel.getAnswerUserName());
		model.setAnswerUserInfo(soapModel.getAnswerUserInfo());
		model.setAnswerContent(soapModel.getAnswerContent());
		model.setAskDate(soapModel.getAskDate());
		model.setAnswerDate(soapModel.getAnswerDate());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusDate(soapModel.getStatusDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CO_Conversation> toModels(
		CO_ConversationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CO_Conversation> models = new ArrayList<CO_Conversation>(soapModels.length);

		for (CO_ConversationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.portal_egov.portlet.conversation.model.CO_Conversation"));

	public CO_ConversationModelImpl() {
	}

	public long getPrimaryKey() {
		return _conversationId;
	}

	public void setPrimaryKey(long primaryKey) {
		setConversationId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_conversationId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return CO_Conversation.class;
	}

	public String getModelClassName() {
		return CO_Conversation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("conversationId", getConversationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("threadId", getThreadId());
		attributes.put("title", getTitle());
		attributes.put("askUserName", getAskUserName());
		attributes.put("askUserInfo", getAskUserInfo());
		attributes.put("askContent", getAskContent());
		attributes.put("answerUserName", getAnswerUserName());
		attributes.put("answerUserInfo", getAnswerUserInfo());
		attributes.put("answerContent", getAnswerContent());
		attributes.put("askDate", getAskDate());
		attributes.put("answerDate", getAnswerDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long conversationId = (Long)attributes.get("conversationId");

		if (conversationId != null) {
			setConversationId(conversationId);
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

		Long threadId = (Long)attributes.get("threadId");

		if (threadId != null) {
			setThreadId(threadId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String askUserName = (String)attributes.get("askUserName");

		if (askUserName != null) {
			setAskUserName(askUserName);
		}

		String askUserInfo = (String)attributes.get("askUserInfo");

		if (askUserInfo != null) {
			setAskUserInfo(askUserInfo);
		}

		String askContent = (String)attributes.get("askContent");

		if (askContent != null) {
			setAskContent(askContent);
		}

		String answerUserName = (String)attributes.get("answerUserName");

		if (answerUserName != null) {
			setAnswerUserName(answerUserName);
		}

		String answerUserInfo = (String)attributes.get("answerUserInfo");

		if (answerUserInfo != null) {
			setAnswerUserInfo(answerUserInfo);
		}

		String answerContent = (String)attributes.get("answerContent");

		if (answerContent != null) {
			setAnswerContent(answerContent);
		}

		Date askDate = (Date)attributes.get("askDate");

		if (askDate != null) {
			setAskDate(askDate);
		}

		Date answerDate = (Date)attributes.get("answerDate");

		if (answerDate != null) {
			setAnswerDate(answerDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@JSON
	public long getConversationId() {
		return _conversationId;
	}

	public void setConversationId(long conversationId) {
		_conversationId = conversationId;
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
	public long getThreadId() {
		return _threadId;
	}

	public void setThreadId(long threadId) {
		_columnBitmask |= THREADID_COLUMN_BITMASK;

		if (!_setOriginalThreadId) {
			_setOriginalThreadId = true;

			_originalThreadId = _threadId;
		}

		_threadId = threadId;
	}

	public long getOriginalThreadId() {
		return _originalThreadId;
	}

	@JSON
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	public String getAskUserName() {
		if (_askUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _askUserName;
		}
	}

	public void setAskUserName(String askUserName) {
		_askUserName = askUserName;
	}

	@JSON
	public String getAskUserInfo() {
		if (_askUserInfo == null) {
			return StringPool.BLANK;
		}
		else {
			return _askUserInfo;
		}
	}

	public void setAskUserInfo(String askUserInfo) {
		_askUserInfo = askUserInfo;
	}

	@JSON
	public String getAskContent() {
		if (_askContent == null) {
			return StringPool.BLANK;
		}
		else {
			return _askContent;
		}
	}

	public void setAskContent(String askContent) {
		_askContent = askContent;
	}

	@JSON
	public String getAnswerUserName() {
		if (_answerUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _answerUserName;
		}
	}

	public void setAnswerUserName(String answerUserName) {
		_answerUserName = answerUserName;
	}

	@JSON
	public String getAnswerUserInfo() {
		if (_answerUserInfo == null) {
			return StringPool.BLANK;
		}
		else {
			return _answerUserInfo;
		}
	}

	public void setAnswerUserInfo(String answerUserInfo) {
		_answerUserInfo = answerUserInfo;
	}

	@JSON
	public String getAnswerContent() {
		if (_answerContent == null) {
			return StringPool.BLANK;
		}
		else {
			return _answerContent;
		}
	}

	public void setAnswerContent(String answerContent) {
		_answerContent = answerContent;
	}

	@JSON
	public Date getAskDate() {
		return _askDate;
	}

	public void setAskDate(Date askDate) {
		_askDate = askDate;
	}

	@JSON
	public Date getAnswerDate() {
		return _answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		_columnBitmask = -1L;

		_answerDate = answerDate;
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
	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@JSON
	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CO_Conversation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CO_Conversation toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (CO_Conversation)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		CO_ConversationImpl co_ConversationImpl = new CO_ConversationImpl();

		co_ConversationImpl.setConversationId(getConversationId());
		co_ConversationImpl.setCompanyId(getCompanyId());
		co_ConversationImpl.setGroupId(getGroupId());
		co_ConversationImpl.setUserId(getUserId());
		co_ConversationImpl.setThreadId(getThreadId());
		co_ConversationImpl.setTitle(getTitle());
		co_ConversationImpl.setAskUserName(getAskUserName());
		co_ConversationImpl.setAskUserInfo(getAskUserInfo());
		co_ConversationImpl.setAskContent(getAskContent());
		co_ConversationImpl.setAnswerUserName(getAnswerUserName());
		co_ConversationImpl.setAnswerUserInfo(getAnswerUserInfo());
		co_ConversationImpl.setAnswerContent(getAnswerContent());
		co_ConversationImpl.setAskDate(getAskDate());
		co_ConversationImpl.setAnswerDate(getAnswerDate());
		co_ConversationImpl.setCreateDate(getCreateDate());
		co_ConversationImpl.setModifiedDate(getModifiedDate());
		co_ConversationImpl.setStatus(getStatus());
		co_ConversationImpl.setStatusByUserId(getStatusByUserId());
		co_ConversationImpl.setStatusDate(getStatusDate());

		co_ConversationImpl.resetOriginalValues();

		return co_ConversationImpl;
	}

	public int compareTo(CO_Conversation co_Conversation) {
		int value = 0;

		value = DateUtil.compareTo(getAnswerDate(),
				co_Conversation.getAnswerDate());

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

		CO_Conversation co_Conversation = null;

		try {
			co_Conversation = (CO_Conversation)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = co_Conversation.getPrimaryKey();

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
		CO_ConversationModelImpl co_ConversationModelImpl = this;

		co_ConversationModelImpl._originalCompanyId = co_ConversationModelImpl._companyId;

		co_ConversationModelImpl._setOriginalCompanyId = false;

		co_ConversationModelImpl._originalGroupId = co_ConversationModelImpl._groupId;

		co_ConversationModelImpl._setOriginalGroupId = false;

		co_ConversationModelImpl._originalThreadId = co_ConversationModelImpl._threadId;

		co_ConversationModelImpl._setOriginalThreadId = false;

		co_ConversationModelImpl._originalStatus = co_ConversationModelImpl._status;

		co_ConversationModelImpl._setOriginalStatus = false;

		co_ConversationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CO_Conversation> toCacheModel() {
		CO_ConversationCacheModel co_ConversationCacheModel = new CO_ConversationCacheModel();

		co_ConversationCacheModel.conversationId = getConversationId();

		co_ConversationCacheModel.companyId = getCompanyId();

		co_ConversationCacheModel.groupId = getGroupId();

		co_ConversationCacheModel.userId = getUserId();

		co_ConversationCacheModel.threadId = getThreadId();

		co_ConversationCacheModel.title = getTitle();

		String title = co_ConversationCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			co_ConversationCacheModel.title = null;
		}

		co_ConversationCacheModel.askUserName = getAskUserName();

		String askUserName = co_ConversationCacheModel.askUserName;

		if ((askUserName != null) && (askUserName.length() == 0)) {
			co_ConversationCacheModel.askUserName = null;
		}

		co_ConversationCacheModel.askUserInfo = getAskUserInfo();

		String askUserInfo = co_ConversationCacheModel.askUserInfo;

		if ((askUserInfo != null) && (askUserInfo.length() == 0)) {
			co_ConversationCacheModel.askUserInfo = null;
		}

		co_ConversationCacheModel.askContent = getAskContent();

		String askContent = co_ConversationCacheModel.askContent;

		if ((askContent != null) && (askContent.length() == 0)) {
			co_ConversationCacheModel.askContent = null;
		}

		co_ConversationCacheModel.answerUserName = getAnswerUserName();

		String answerUserName = co_ConversationCacheModel.answerUserName;

		if ((answerUserName != null) && (answerUserName.length() == 0)) {
			co_ConversationCacheModel.answerUserName = null;
		}

		co_ConversationCacheModel.answerUserInfo = getAnswerUserInfo();

		String answerUserInfo = co_ConversationCacheModel.answerUserInfo;

		if ((answerUserInfo != null) && (answerUserInfo.length() == 0)) {
			co_ConversationCacheModel.answerUserInfo = null;
		}

		co_ConversationCacheModel.answerContent = getAnswerContent();

		String answerContent = co_ConversationCacheModel.answerContent;

		if ((answerContent != null) && (answerContent.length() == 0)) {
			co_ConversationCacheModel.answerContent = null;
		}

		Date askDate = getAskDate();

		if (askDate != null) {
			co_ConversationCacheModel.askDate = askDate.getTime();
		}
		else {
			co_ConversationCacheModel.askDate = Long.MIN_VALUE;
		}

		Date answerDate = getAnswerDate();

		if (answerDate != null) {
			co_ConversationCacheModel.answerDate = answerDate.getTime();
		}
		else {
			co_ConversationCacheModel.answerDate = Long.MIN_VALUE;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			co_ConversationCacheModel.createDate = createDate.getTime();
		}
		else {
			co_ConversationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			co_ConversationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			co_ConversationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		co_ConversationCacheModel.status = getStatus();

		co_ConversationCacheModel.statusByUserId = getStatusByUserId();

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			co_ConversationCacheModel.statusDate = statusDate.getTime();
		}
		else {
			co_ConversationCacheModel.statusDate = Long.MIN_VALUE;
		}

		return co_ConversationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{conversationId=");
		sb.append(getConversationId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", threadId=");
		sb.append(getThreadId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", askUserName=");
		sb.append(getAskUserName());
		sb.append(", askUserInfo=");
		sb.append(getAskUserInfo());
		sb.append(", askContent=");
		sb.append(getAskContent());
		sb.append(", answerUserName=");
		sb.append(getAnswerUserName());
		sb.append(", answerUserInfo=");
		sb.append(getAnswerUserInfo());
		sb.append(", answerContent=");
		sb.append(getAnswerContent());
		sb.append(", askDate=");
		sb.append(getAskDate());
		sb.append(", answerDate=");
		sb.append(getAnswerDate());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.conversation.model.CO_Conversation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>conversationId</column-name><column-value><![CDATA[");
		sb.append(getConversationId());
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
			"<column><column-name>threadId</column-name><column-value><![CDATA[");
		sb.append(getThreadId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askUserName</column-name><column-value><![CDATA[");
		sb.append(getAskUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askUserInfo</column-name><column-value><![CDATA[");
		sb.append(getAskUserInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askContent</column-name><column-value><![CDATA[");
		sb.append(getAskContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerUserName</column-name><column-value><![CDATA[");
		sb.append(getAnswerUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerUserInfo</column-name><column-value><![CDATA[");
		sb.append(getAnswerUserInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerContent</column-name><column-value><![CDATA[");
		sb.append(getAnswerContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askDate</column-name><column-value><![CDATA[");
		sb.append(getAskDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerDate</column-name><column-value><![CDATA[");
		sb.append(getAnswerDate());
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
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CO_Conversation.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			CO_Conversation.class
		};
	private long _conversationId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _threadId;
	private long _originalThreadId;
	private boolean _setOriginalThreadId;
	private String _title;
	private String _askUserName;
	private String _askUserInfo;
	private String _askContent;
	private String _answerUserName;
	private String _answerUserInfo;
	private String _answerContent;
	private Date _askDate;
	private Date _answerDate;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private Date _statusDate;
	private long _columnBitmask;
	private CO_Conversation _escapedModelProxy;
}