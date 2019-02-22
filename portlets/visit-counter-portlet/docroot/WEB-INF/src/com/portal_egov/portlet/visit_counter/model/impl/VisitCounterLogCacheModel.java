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

package com.portal_egov.portlet.visit_counter.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.visit_counter.model.VisitCounterLog;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VisitCounterLog in entity cache.
 *
 * @author HungDX
 * @see VisitCounterLog
 * @generated
 */
public class VisitCounterLogCacheModel implements CacheModel<VisitCounterLog>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{visitorIp=");
		sb.append(visitorIp);
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
		sb.append(", hitCounter=");
		sb.append(hitCounter);
		sb.append(", lastAccessPageId=");
		sb.append(lastAccessPageId);
		sb.append(", lastAccessDate=");
		sb.append(lastAccessDate);
		sb.append("}");

		return sb.toString();
	}

	public VisitCounterLog toEntityModel() {
		VisitCounterLogImpl visitCounterLogImpl = new VisitCounterLogImpl();

		if (visitorIp == null) {
			visitCounterLogImpl.setVisitorIp(StringPool.BLANK);
		}
		else {
			visitCounterLogImpl.setVisitorIp(visitorIp);
		}

		visitCounterLogImpl.setCompanyId(companyId);
		visitCounterLogImpl.setGroupId(groupId);
		visitCounterLogImpl.setUserId(userId);

		if (userName == null) {
			visitCounterLogImpl.setUserName(StringPool.BLANK);
		}
		else {
			visitCounterLogImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			visitCounterLogImpl.setCreateDate(null);
		}
		else {
			visitCounterLogImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			visitCounterLogImpl.setModifiedDate(null);
		}
		else {
			visitCounterLogImpl.setModifiedDate(new Date(modifiedDate));
		}

		visitCounterLogImpl.setHitCounter(hitCounter);
		visitCounterLogImpl.setLastAccessPageId(lastAccessPageId);

		if (lastAccessDate == Long.MIN_VALUE) {
			visitCounterLogImpl.setLastAccessDate(null);
		}
		else {
			visitCounterLogImpl.setLastAccessDate(new Date(lastAccessDate));
		}

		visitCounterLogImpl.resetOriginalValues();

		return visitCounterLogImpl;
	}

	public String visitorIp;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int hitCounter;
	public long lastAccessPageId;
	public long lastAccessDate;
}