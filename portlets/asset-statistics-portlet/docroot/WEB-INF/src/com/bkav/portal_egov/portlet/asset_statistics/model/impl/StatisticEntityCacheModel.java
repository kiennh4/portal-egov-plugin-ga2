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

package com.bkav.portal_egov.portlet.asset_statistics.model.impl;

import com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing StatisticEntity in entity cache.
 *
 * @author HungDX
 * @see StatisticEntity
 * @generated
 */
public class StatisticEntityCacheModel implements CacheModel<StatisticEntity>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{entityId=");
		sb.append(entityId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", entityName=");
		sb.append(entityName);
		sb.append("}");

		return sb.toString();
	}

	public StatisticEntity toEntityModel() {
		StatisticEntityImpl statisticEntityImpl = new StatisticEntityImpl();

		statisticEntityImpl.setEntityId(entityId);
		statisticEntityImpl.setCompanyId(companyId);
		statisticEntityImpl.setGroupId(groupId);
		statisticEntityImpl.setUserId(userId);

		if (userName == null) {
			statisticEntityImpl.setUserName(StringPool.BLANK);
		}
		else {
			statisticEntityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			statisticEntityImpl.setCreateDate(null);
		}
		else {
			statisticEntityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			statisticEntityImpl.setModifiedDate(null);
		}
		else {
			statisticEntityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (entityName == null) {
			statisticEntityImpl.setEntityName(StringPool.BLANK);
		}
		else {
			statisticEntityImpl.setEntityName(entityName);
		}

		statisticEntityImpl.resetOriginalValues();

		return statisticEntityImpl;
	}

	public long entityId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String entityName;
}