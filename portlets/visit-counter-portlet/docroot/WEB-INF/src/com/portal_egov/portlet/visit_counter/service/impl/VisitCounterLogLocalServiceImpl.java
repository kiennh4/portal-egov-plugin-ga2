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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.portal_egov.portlet.visit_counter.model.VisitCounterLog;
import com.portal_egov.portlet.visit_counter.service.base.VisitCounterLogLocalServiceBaseImpl;

/**
 * The implementation of the visit counter log local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.visit_counter.service.VisitCounterLogLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author HUNGDX
 * @see com.portal_egov.portlet.visit_counter.service.base.VisitCounterLogLocalServiceBaseImpl
 * @see com.portal_egov.portlet.visit_counter.service.VisitCounterLogLocalServiceUtil
 */
public class VisitCounterLogLocalServiceImpl extends VisitCounterLogLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.portal_egov.portlet.visit_counter.service.VisitCounterLogLocalServiceUtil
	 * } to access the visit counter log local service.
	 */
	
	public List<VisitCounterLog> findAll() throws SystemException{
		
		return visitCounterLogPersistence.findAll();
	}
	
	public List<VisitCounterLog> findByCompany(long companyId) throws SystemException{
		
		return visitCounterLogPersistence.findByCompany(companyId);
	}
	
	public List<VisitCounterLog> findByGroup(long groupId) throws SystemException{
		
		return visitCounterLogPersistence.findByGroup(groupId);
	}
	
	public VisitCounterLog getCounterLog(String visitorIp) throws SystemException{
		
		return visitCounterLogPersistence.fetchByPrimaryKey(visitorIp);
	}
	
	public VisitCounterLog addCounterLog(long companyId,long groupId,long userId,String userName,
		String visitorIp,long lastAccessPageId) throws SystemException{
		
		Date now = new Date();
		
		VisitCounterLog  counterLog = visitCounterLogPersistence.create(visitorIp);
		
		counterLog.setCompanyId(companyId);
		counterLog.setGroupId(groupId);
		counterLog.setUserId(userId);
		counterLog.setUserName(userName);
		counterLog.setHitCounter(STARTED_HIT_COUNTER_VALUE);
		counterLog.setLastAccessPageId(lastAccessPageId);
		counterLog.setCreateDate(now);
		counterLog.setModifiedDate(now);
		counterLog.setLastAccessDate(now);
		
		visitCounterLogPersistence.update(counterLog, false);
		
		return counterLog;
	}
	
	public void updateCounterLog(long companyId,long groupId,long userId,String userName,
		String visitorIp,int hitCounter,long lastAccessPageId) throws SystemException{
		
		VisitCounterLog  counterLog = visitCounterLogPersistence.fetchByPrimaryKey(visitorIp);
		
		if(counterLog != null){
			
			Date now = new Date();
			counterLog.setCompanyId(companyId);
			counterLog.setGroupId(groupId);
			counterLog.setUserId(userId);
			counterLog.setUserName(userName);
			counterLog.setLastAccessPageId(lastAccessPageId);
			counterLog.setHitCounter(hitCounter);
			counterLog.setModifiedDate(now);
			counterLog.setLastAccessDate(now);
			
			visitCounterLogPersistence.update(counterLog, false);
		}
	}
	
	public void incrementCounter(String visitorIp) throws SystemException{
		
		VisitCounterLog  counterLog = visitCounterLogPersistence.fetchByPrimaryKey(visitorIp);
		
		if(counterLog != null){
			
			Date now = new Date();
			
			int hitCounter = counterLog.getHitCounter();
			
			hitCounter ++;
			
			counterLog.setHitCounter(hitCounter);
			counterLog.setModifiedDate(now);
			counterLog.setLastAccessDate(now);
			
			visitCounterLogPersistence.update(counterLog, false);
		}
	}
	
	private static final int STARTED_HIT_COUNTER_VALUE = 1;
}
