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

package com.portal_egov.portlet.tthc.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.portal_egov.portlet.tthc.model.TTHC_Entry;
import com.portal_egov.portlet.tthc.service.base.TTHC_EntryLocalServiceBaseImpl;
import com.portal_egov.portlet.tthc.service.persistence.TTHC_EntryFinderUtil;
import com.portal_egov.portlet.vbpq.model.VBPQ_Entry;

/**
 * The implementation of the t t h c_ entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder 
 * to copy their definitions into the {@link com.portal_egov.portlet.tthc.service.TTHC_EntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials 
 * because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.tthc.service.base.TTHC_EntryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil
 */
public class TTHC_EntryLocalServiceImpl extends TTHC_EntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil} 
	 * to access the t t h c_ entry local service.
	 */
	
	public int countAll() throws SystemException{
		return tthc_EntryPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return tthc_EntryPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return tthc_EntryPersistence.countByGroup(groupId);
	}
	
	public int countByLevelAndCompany(long levelId,long companyId) throws SystemException{
		return tthc_EntryPersistence.countByLevelAndCompany(levelId, companyId);
	}
	
	public int countByLevelAndGroup(long levelId,long groupId) throws SystemException{
		return tthc_EntryPersistence.countByLevelAndGroup(levelId, groupId);
	}
	
	public int countByCategoryAndCompany(long categoryId,long companyId) throws SystemException{
		return tthc_EntryPersistence.countByCategoryAndCompany(categoryId, companyId);
	}
	
	public int countByCategoryAndGroup(long categoryId,long groupId) throws SystemException{
		return tthc_EntryPersistence.countByCategoryAndGroup(categoryId, groupId);
	}
	
	public int countByDepartment(long departmentId,long groupId) throws SystemException{
		return tthc_EntryPersistence.countByDepartmentAndGroup(departmentId, groupId);
	}
	
	public int countByAudience(long audienceId,long groupId) throws SystemException{
		return tthc_EntryPersistence.countByAudienceAndGroup(audienceId, groupId);
	}
	
	public int countByResultType(long resultTypeId,long groupId) throws SystemException{
		return tthc_EntryPersistence.countByResultTypeAndGroup(resultTypeId, groupId);
	}
	
	public List<TTHC_Entry> findAll() throws SystemException{
		return tthc_EntryPersistence.findAll();
	}
	
	public List<TTHC_Entry> findByCompany(long companyId) throws SystemException{
		return tthc_EntryPersistence.findByCompany(companyId);
	}
	
	public List<TTHC_Entry> findByCompany(long companyId,int start,int end) throws SystemException{
		return tthc_EntryPersistence.findByCompany(companyId,start,end);
	}
	
	public List<TTHC_Entry> findByGroup(long groupId) throws SystemException{
		return tthc_EntryPersistence.findByGroup(groupId);
	}
	
	public List<TTHC_Entry> findByGroup(long groupId,int start,int end) throws SystemException{
		return tthc_EntryPersistence.findByGroup(groupId, start, end);
	}

	public List<TTHC_Entry> findByLevelAndCompany(long levelId,long companyId) throws SystemException{
		return tthc_EntryPersistence.findByLevelAndCompany(levelId, companyId);
	}

	public List<TTHC_Entry> findByLevelAndCompany(long levelId,long companyId,int start,int end) throws SystemException{
		return tthc_EntryPersistence.findByLevelAndCompany(levelId, companyId,start,end);
	}
	
	public List<TTHC_Entry> findByLevelAndGroup(long levelId,long groupId) throws SystemException{
		return tthc_EntryPersistence.findByLevelAndGroup(levelId, groupId);
	}

	public List<TTHC_Entry> findByLevelAndGroup(long levelId,long groupId,int start,int end) throws SystemException{
		return tthc_EntryPersistence.findByLevelAndGroup(levelId, groupId, start, end);
	}

	public List<TTHC_Entry> findByDepartmentAndCompany(long departmentId,long companyId) throws SystemException{
		return tthc_EntryPersistence.findByDepartmentAndCompany(departmentId, companyId);
	}

	public List<TTHC_Entry> findByDepartmentAndCompany(long departmentId,long companyId,int start,int end) throws SystemException{
		return tthc_EntryPersistence.findByDepartmentAndCompany(departmentId, companyId,start,end);
	}
	
	public List<TTHC_Entry> findByDepartmentAndGroup(long departmentId,long groupId) throws SystemException{
		return tthc_EntryPersistence.findByDepartmentAndGroup(departmentId, groupId);
	}

	public List<TTHC_Entry> findByDepartmentAndGroup(long departmentId,long groupId,int start,int end) throws SystemException{
		return tthc_EntryPersistence.findByDepartmentAndGroup(departmentId, groupId, start, end);
	}

	public List<TTHC_Entry> findByCategoryAndCompany(long categoryId,long companyId) throws SystemException{
		return tthc_EntryPersistence.findByCategoryAndCompany(categoryId, companyId);
	}

	public List<TTHC_Entry> findByCategoryAndCompany(long categoryId,long companyId,int start,int end) throws SystemException{
		return tthc_EntryPersistence.findByCategoryAndCompany(categoryId, companyId, start, end);
	}
		
	public List<TTHC_Entry> findByCategoryAndGroup(long categoryId,long groupId) throws SystemException{
		return tthc_EntryPersistence.findByCategoryAndGroup(categoryId, groupId);
	}

	public List<TTHC_Entry> findByCategoryAndGroup(long categoryId,long groupId,int start,int end) throws SystemException{
		return tthc_EntryPersistence.findByCategoryAndGroup(categoryId, groupId, start, end);
	}

	public List<TTHC_Entry> findByAudienceAndCompany(long audienceId,long companyId) throws SystemException{
		return tthc_EntryPersistence.findByAudienceAndCompany(audienceId, companyId);
	}

	public List<TTHC_Entry> findByAudienceAndCompany(long audienceId,long companyId,int start,int end) throws SystemException{
		return tthc_EntryPersistence.findByAudienceAndCompany(audienceId, companyId, start, end);
	}
	
	public List<TTHC_Entry> findByAudienceAndGroup(long audienceId,long groupId) throws SystemException{
		return tthc_EntryPersistence.findByAudienceAndGroup(audienceId, groupId);
	}
	
	public List<TTHC_Entry> findByAudienceAndGroup(long audienceId,long groupId,int start,int end) throws SystemException{
		return tthc_EntryPersistence.findByAudienceAndGroup(audienceId, groupId, start, end);
	}

	public List<TTHC_Entry> findByResultTypeAndCompany(long resultTypeId,long companyId) throws SystemException{
		return tthc_EntryPersistence.findByResultTypeAndCompany(resultTypeId, companyId);
	}

	public List<TTHC_Entry> findByResultTypeAndCompany(long resultTypeId,long companyId,int start,int end) throws SystemException{
		return tthc_EntryPersistence.findByResultTypeAndCompany(resultTypeId, companyId);
	}
	
	public List<TTHC_Entry> findByResultTypeAndGroup(long resultTypeId,long groupId) throws SystemException{
		return tthc_EntryPersistence.findByResultTypeAndGroup(resultTypeId, groupId);
	}
	
	public List<TTHC_Entry> findByResultTypeAndGroup(long resultTypeId,long groupId,int start,int end) throws SystemException{
		return tthc_EntryPersistence.findByResultTypeAndGroup(resultTypeId, groupId, start, end);
	}
	
	public List<TTHC_Entry> findByKeyword(long groupId,String keyword,int start,int end){
		return TTHC_EntryFinderUtil.findByKeyword(groupId, keyword,start,end);
	}
	
	public List<TTHC_Entry> findByMultiCondition(long groupId,String keyword,long levelId,long departmentId,long categoryId,
		long audienceId,long resultTypeId,int start,int end){
		return TTHC_EntryFinderUtil.findByMultiCondition(groupId, keyword, levelId, departmentId, categoryId, audienceId, resultTypeId, start, end);
	}
	
	public TTHC_Entry getTTHCEntry(long entryId) throws SystemException{
		return tthc_EntryPersistence.fetchByPrimaryKey(entryId);
	}
	
	public TTHC_Entry addTTHCEntry(long companyId,long groupId,long userId,long levelId,long departmentId,long categoryId,
						long audienceId,long resultTypeId,String entryCode,String entryName,String entryDesc,
						String processType,String processGuide,String processTime,String processFee,
						String processRequirement,String processFoundationDocument,ServiceContext serviceContext ) throws SystemException, PortalException{
		
		Date now = new Date();
		
		String userName = "";
		
		if(userId > 0){
			User user = userLocalService.getUser(userId);
			
			if(user != null){
				userName = user.getFullName();
			}
		}
		long entryId = counterLocalService.increment();
		
		TTHC_Entry tthcEntry = tthc_EntryPersistence.create(entryId);
		
		tthcEntry.setCompanyId(companyId);
		tthcEntry.setGroupId(groupId);
		tthcEntry.setUserId(userId);
		tthcEntry.setUserName(userName);
		tthcEntry.setLevelId(levelId);
		tthcEntry.setDepartmentId(departmentId);
		tthcEntry.setCategoryId(categoryId);
		tthcEntry.setAudienceId(audienceId);
		tthcEntry.setResultTypeId(resultTypeId);
		tthcEntry.setEntryCode(entryCode);
		tthcEntry.setEntryName(entryName);
		tthcEntry.setEntryDesc(entryDesc);
		tthcEntry.setProcessGuide(processGuide);
		tthcEntry.setProcessType(processType);
		tthcEntry.setProcessTime(processTime);
		tthcEntry.setProcessFee(processFee);
		tthcEntry.setProcessRequirement(processRequirement);
		tthcEntry.setProcessFoundationDocument(processFoundationDocument);
		tthcEntry.setCreateDate(now);
		tthcEntry.setModifiedDate(now);
		
		tthc_EntryPersistence.update(tthcEntry, false);
		
		if(serviceContext.isAddGroupPermissions()
			|| serviceContext.isAddGuestPermissions()){
		
			addVBPQEntryResources(tthcEntry, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addVBPQEntryResources(tthcEntry, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		//Indexer

		Indexer indexer = IndexerRegistryUtil.getIndexer(TTHC_Entry.class);
		
		if(indexer != null){
			indexer.reindex(tthcEntry);
		}
		
		return tthcEntry;
	}
	
	public TTHC_Entry updateTTHCEntry(long entryId,long companyId,long groupId,long userId,long levelId,long departmentId,long categoryId,
						long audienceId,long resultTypeId,String entryCode,String entryName,String entryDesc,
						String processGuide,String processType,String processTime,String processFee,
						String processRequirement,String processFoundationDocument) throws SystemException, PortalException{
	
		Date now = new Date();
		
		String userName = "";
		
		if(userId > 0){
			User user = userLocalService.getUser(userId);
			
			if(user != null){
				userName = user.getFullName();
			}
		}
		TTHC_Entry tthcEntry = tthc_EntryPersistence.fetchByPrimaryKey(entryId);
		
		tthcEntry.setCompanyId(companyId);
		tthcEntry.setGroupId(groupId);
		tthcEntry.setUserId(userId);
		tthcEntry.setUserName(userName);
		tthcEntry.setLevelId(levelId);
		tthcEntry.setDepartmentId(departmentId);
		tthcEntry.setCategoryId(categoryId);
		tthcEntry.setAudienceId(audienceId);
		tthcEntry.setResultTypeId(resultTypeId);
		tthcEntry.setEntryCode(entryCode);
		tthcEntry.setEntryName(entryName);
		tthcEntry.setEntryDesc(entryDesc);
		tthcEntry.setProcessGuide(processGuide);
		tthcEntry.setProcessType(processType);
		tthcEntry.setProcessTime(processTime);
		tthcEntry.setProcessFee(processFee);
		tthcEntry.setProcessRequirement(processRequirement);
		tthcEntry.setProcessFoundationDocument(processFoundationDocument);
		tthcEntry.setModifiedDate(now);
		
		tthc_EntryPersistence.update(tthcEntry, false);
		
		//Indexer

		Indexer indexer = IndexerRegistryUtil.getIndexer(TTHC_Entry.class);
		
		if(indexer != null){
			indexer.reindex(tthcEntry);
		}
		
		return tthcEntry;
	}
	
	
	public void deleteTTHCEntry(long entryId) throws SystemException, PortalException{
		
		TTHC_Entry tthcEntry = tthc_EntryPersistence.fetchByPrimaryKey(entryId);
		
		if(tthcEntry != null){
			
			tthc_EntryPersistence.remove(tthcEntry);
			
			resourceLocalService.deleteResource(tthcEntry.getCompanyId(), TTHC_Entry.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, tthcEntry.getEntryId());
			
			//Expando
			ExpandoValueLocalServiceUtil.deleteValues(TTHC_Entry.class.getName(), entryId);
			
			// Indexer
			Indexer indexer = IndexerRegistryUtil.getIndexer(VBPQ_Entry.class);
			
			if(indexer != null){
				indexer.delete(tthcEntry);
			}
		}
	}
	
	private void addVBPQEntryResources(TTHC_Entry tthcEntry,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(tthcEntry.getCompanyId(), tthcEntry.getGroupId(), 
			tthcEntry.getUserId(), TTHC_Entry.class.getName(),
			tthcEntry.getEntryId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addVBPQEntryResources(TTHC_Entry tthcEntry,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(tthcEntry.getCompanyId(), tthcEntry.getGroupId(),
			tthcEntry.getUserId(), TTHC_Entry.class.getName(),
			tthcEntry.getEntryId(), groupPermissions, guestPermissions);
	}
		
}