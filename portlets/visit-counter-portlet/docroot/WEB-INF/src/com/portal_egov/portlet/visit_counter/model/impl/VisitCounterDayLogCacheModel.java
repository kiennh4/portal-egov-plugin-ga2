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

import com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog;

import java.io.Serializable;

/**
 * The cache model class for representing VisitCounterDayLog in entity cache.
 *
 * @author HungDX
 * @see VisitCounterDayLog
 * @generated
 */
public class VisitCounterDayLogCacheModel implements CacheModel<VisitCounterDayLog>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{daylogId=");
		sb.append(daylogId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", hitCounter=");
		sb.append(hitCounter);
		sb.append("}");

		return sb.toString();
	}

	public VisitCounterDayLog toEntityModel() {
		VisitCounterDayLogImpl visitCounterDayLogImpl = new VisitCounterDayLogImpl();

		if (daylogId == null) {
			visitCounterDayLogImpl.setDaylogId(StringPool.BLANK);
		}
		else {
			visitCounterDayLogImpl.setDaylogId(daylogId);
		}

		visitCounterDayLogImpl.setCompanyId(companyId);
		visitCounterDayLogImpl.setGroupId(groupId);
		visitCounterDayLogImpl.setHitCounter(hitCounter);

		visitCounterDayLogImpl.resetOriginalValues();

		return visitCounterDayLogImpl;
	}

	public String daylogId;
	public long companyId;
	public long groupId;
	public int hitCounter;
}