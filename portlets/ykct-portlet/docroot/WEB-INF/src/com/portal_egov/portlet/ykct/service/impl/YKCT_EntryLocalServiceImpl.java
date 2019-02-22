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

package com.portal_egov.portlet.ykct.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.ykct.model.YKCT_Entry;
import com.portal_egov.portlet.ykct.service.base.YKCT_EntryLocalServiceBaseImpl;
import com.portal_egov.portlet.ykct.service.persistence.YKCT_EntryFinderImpl;
import com.portal_egov.portlet.ykct.service.persistence.YKCT_EntryFinderUtil;
import com.portal_egov.portlet.ykct.service.persistence.YKCT_EntryUtil;

/**
 * The implementation of the y k c t_ entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.ykct.service.YKCT_EntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucDVd
 * @see com.portal_egov.portlet.ykct.service.base.YKCT_EntryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.ykct.service.YKCT_EntryLocalServiceUtil
 */
public class YKCT_EntryLocalServiceImpl extends YKCT_EntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.ykct.service.YKCT_EntryLocalServiceUtil} to access the y k c t_ entry local service.
	 */
	
	public int countAll() throws SystemException{
		return ykct_EntryPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return ykct_EntryPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return ykct_EntryPersistence.countByGroup(groupId);
	}
	
	public int countByCategory(long categoryId) throws SystemException{
		return ykct_EntryPersistence.countByCategory(categoryId);
	}
	
	public List<YKCT_Entry> findAll() throws SystemException{
		return ykct_EntryPersistence.findAll();
	}
	
	public List<YKCT_Entry> findByCompany(long companyId) throws SystemException{
		return ykct_EntryPersistence.findByCompany(companyId);
	}
	
	public List<YKCT_Entry> findByCompany(long companyId,int start,int end) throws SystemException{
		return ykct_EntryPersistence.findByCompany(companyId,start,end);
	}
	
	public List<YKCT_Entry> findByGroup(long groupId) throws SystemException{
		return ykct_EntryPersistence.findByGroup(groupId);
	}
	
	public List<YKCT_Entry> findByGroup(long groupId,int start,int end) throws SystemException{
		return ykct_EntryPersistence.findByGroup(groupId,start,end);
	}
	
	public List<YKCT_Entry> findByCategory(long categoryId) throws SystemException{
		return ykct_EntryPersistence.findByCategory(categoryId);
	}
	
	public List<YKCT_Entry> findByCategory(long categoryId,int start,int end) throws SystemException{
		return ykct_EntryPersistence.findByCategory(categoryId,start,end);
	}
	
	public List<YKCT_Entry> findByKeyword(long groupId,String keyword,int start,int end){
		return YKCT_EntryFinderUtil.findByKeyword(groupId, keyword, start, end);
	}
	
	public List<YKCT_Entry> findByMultiCondition(long groupId,String keyword,long categoryId,int start,int end){
		return YKCT_EntryFinderUtil.findByMultiCondition(groupId, keyword, categoryId, start, end);
	}
	
	public YKCT_Entry addYKCTEntry(long companyId,long groupId,long userId,String userName,String entryName,long categoryId,
			ServiceContext serviceContext) throws SystemException, PortalException{
	
		Date now = new Date();
		
		long entryId = counterLocalService.increment();
		
		YKCT_Entry ykctEntry = ykct_EntryPersistence.create(entryId);
		
		ykctEntry.setCompanyId(companyId);
		ykctEntry.setGroupId(groupId);
		ykctEntry.setUserId(userId);
		ykctEntry.setUserName(userName);
		ykctEntry.setEntryName(entryName);
		ykctEntry.setCategoryId(categoryId);
		ykctEntry.setFileAttachmentURL(StringPool.BLANK);
		ykctEntry.setCreateDate(now);
		ykctEntry.setModifiedDate(now);
		
		ykct_EntryPersistence.update(ykctEntry, false);
		
		if(serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()){
		
			addYKCTEntryResources(ykctEntry, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addYKCTEntryResources(ykctEntry, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		return ykctEntry;
		
	}
	
	public YKCT_Entry updateYKCTEntry(long companyId,long groupId,long userId,String userName,long entryId,String entryName,long categoryId,
		String fileAttachmentURL) throws SystemException, PortalException{
		
		Date now = new Date();
		
		YKCT_Entry ykctEntry = ykct_EntryPersistence.fetchByPrimaryKey(entryId);
		
		ykctEntry.setCompanyId(companyId);
		ykctEntry.setGroupId(groupId);
		ykctEntry.setUserId(userId);
		ykctEntry.setUserName(userName);
		ykctEntry.setEntryName(entryName);
		ykctEntry.setCategoryId(categoryId);
		ykctEntry.setFileAttachmentURL(fileAttachmentURL);
		ykctEntry.setModifiedDate(now);
		
		ykct_EntryPersistence.update(ykctEntry, false);
		
		return ykctEntry;
		
	}
	
	public void deleteYKCTEntry(long entryId) throws SystemException, PortalException{
		if(entryId > 0){
			
			YKCT_Entry ykctEntry = getYKCT_Entry(entryId);
			
			if(ykctEntry != null){
				
				ykct_EntryPersistence.remove(entryId);
				
				resourceLocalService.deleteResource(ykctEntry.getCompanyId(), YKCT_Entry.class.getName(),
						ResourceConstants.SCOPE_INDIVIDUAL, entryId);
			}
		}
	}
	
	private void addYKCTEntryResources(YKCT_Entry ykctEntry,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(ykctEntry.getCompanyId(), ykctEntry.getGroupId(), 
				ykctEntry.getUserId(), YKCT_Entry.class.getName(),
				ykctEntry.getEntryId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addYKCTEntryResources(YKCT_Entry ykctEntry,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(ykctEntry.getCompanyId(), ykctEntry.getGroupId(),
				ykctEntry.getUserId(), YKCT_Entry.class.getName(),
				ykctEntry.getEntryId(), groupPermissions, guestPermissions);
	}
}