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

package com.portal_egov.portlet.visit_counter.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog;
import com.portal_egov.portlet.visit_counter.service.base.VisitCounterDayLogLocalServiceBaseImpl;

/**
 * The implementation of the visit counter day log local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.visit_counter.service.VisitCounterDayLogLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.visit_counter.service.base.VisitCounterDayLogLocalServiceBaseImpl
 * @see com.portal_egov.portlet.visit_counter.service.VisitCounterDayLogLocalServiceUtil
 */
public class VisitCounterDayLogLocalServiceImpl
	extends VisitCounterDayLogLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.visit_counter.service.VisitCounterDayLogLocalServiceUtil} to access the visit counter day log local service.
	 */
	
	public VisitCounterDayLog addVisitCounterDayLog (long groupId, long companyId, String daylogId) throws SystemException, PortalException
	{
		VisitCounterDayLog daylog = visitCounterDayLogPersistence.create(daylogId);
		
		daylog.setGroupId(groupId);
		daylog.setCompanyId(companyId);
		daylog.setHitCounter(1);
		
		return visitCounterDayLogPersistence.update(daylog, false);
	}
	
	public void updateVisitCounterDayLog (String daylogId) throws SystemException, PortalException
	{
		VisitCounterDayLog daylog = visitCounterDayLogPersistence.fetchByPrimaryKey(daylogId);
		
		if (daylog!=null)
		{
			daylog.setHitCounter(daylog.getHitCounter()+1);
			
			visitCounterDayLogPersistence.update(daylog, false);
		}
		
	}
}