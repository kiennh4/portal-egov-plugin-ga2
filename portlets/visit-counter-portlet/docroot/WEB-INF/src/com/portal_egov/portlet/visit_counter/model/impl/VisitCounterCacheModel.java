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

import com.portal_egov.portlet.visit_counter.model.VisitCounter;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VisitCounter in entity cache.
 *
 * @author HungDX
 * @see VisitCounter
 * @generated
 */
public class VisitCounterCacheModel implements CacheModel<VisitCounter>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{counterId=");
		sb.append(counterId);
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
		sb.append(", totalHitCounter=");
		sb.append(totalHitCounter);
		sb.append("}");

		return sb.toString();
	}

	public VisitCounter toEntityModel() {
		VisitCounterImpl visitCounterImpl = new VisitCounterImpl();

		visitCounterImpl.setCounterId(counterId);
		visitCounterImpl.setCompanyId(companyId);
		visitCounterImpl.setGroupId(groupId);
		visitCounterImpl.setUserId(userId);

		if (userName == null) {
			visitCounterImpl.setUserName(StringPool.BLANK);
		}
		else {
			visitCounterImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			visitCounterImpl.setCreateDate(null);
		}
		else {
			visitCounterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			visitCounterImpl.setModifiedDate(null);
		}
		else {
			visitCounterImpl.setModifiedDate(new Date(modifiedDate));
		}

		visitCounterImpl.setTotalHitCounter(totalHitCounter);

		visitCounterImpl.resetOriginalValues();

		return visitCounterImpl;
	}

	public long counterId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int totalHitCounter;
}