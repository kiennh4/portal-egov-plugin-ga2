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

package com.portal_egov.portlet.vbpq.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.NestableException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.portal_egov.portlet.vbpq.model.VBPQ_Entry;
import com.portal_egov.portlet.vbpq.service.base.VBPQ_EntryLocalServiceBaseImpl;
import com.portal_egov.portlet.vbpq.service.persistence.VBPQ_EntryFinderUtil;

/**
 * The implementation of the v b p q_ entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.vbpq.service.base.VBPQ_EntryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil
 */
public class VBPQ_EntryLocalServiceImpl extends VBPQ_EntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil} to access the v b p q_ entry local service.
	 */
	
	public static final boolean DEFAULT_VBPQ_ENTRY_ACTIVE_STATUS = true;
	

	public int countAll() throws SystemException{
		
		return vbpq_EntryPersistence.countAll();
	}
	
	
	public int countByCompany(long companyId) throws NestableException{
		
		return vbpq_EntryPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return vbpq_EntryPersistence.countByGroup(groupId);
	}
	
	public int countByCategoryAndCompany(long companyId,long categoryId) throws SystemException{
		return vbpq_EntryPersistence.countByCategoryAndCompany(categoryId, companyId);
	}
	
	public int countByCategoryAndGroup(long groupId,long categoryId) throws SystemException{
		return vbpq_EntryPersistence.countByCategoryAndGroup(categoryId, groupId);
	}
	
	public int countByDepartmentAndGroup(long groupId,long departmentId) throws SystemException{
		return vbpq_EntryPersistence.countByDepartmentAndGroup(departmentId, groupId);
	}
	
	public int countByDocTypeAndGroup(long groupId,long docTypeId) throws SystemException{
		return vbpq_EntryPersistence.countByDocTypeAndGroup(docTypeId, groupId);
	}
	
	public List<VBPQ_Entry> findAll() throws SystemException{
		return vbpq_EntryPersistence.findAll();
	}
	
	public List<VBPQ_Entry> findByCompany(long companyId) throws SystemException{
		return vbpq_EntryPersistence.findByCompany(companyId);
	}
		
	public List<VBPQ_Entry> findByCompany(long companyId,int start,int end) throws SystemException{
		return vbpq_EntryPersistence.findByCompany(companyId,start,end);
	}

	public List<VBPQ_Entry> findByGroup(long groupId) throws SystemException{
		return vbpq_EntryPersistence.findByGroup(groupId);
	}

	public List<VBPQ_Entry> findByGroup(long groupId,int start,int end) throws SystemException{
		return vbpq_EntryPersistence.findByGroup(groupId,start,end);
	}

	public List<VBPQ_Entry> findByDepartmentAndCompany(long departmentId,long companyId) throws SystemException{
		return vbpq_EntryPersistence.findByDepartmentAndCompany(departmentId, companyId);
	}

	public List<VBPQ_Entry> findByDepartmentAndCompany(long departmentId,long companyId,int start,int end) throws SystemException{
		return vbpq_EntryPersistence.findByDepartmentAndCompany(departmentId, companyId,start,end);
	}

	public List<VBPQ_Entry> findByDepartmentAndGroup(long departmentId,long groupId) throws SystemException{
		
		return vbpq_EntryPersistence.findByDepartmentAndGroup(departmentId, groupId);
	}

	public List<VBPQ_Entry> findByDepartmentAndGroup(long departmentId,long groupId,int start,int end) throws SystemException{
		
		return vbpq_EntryPersistence.findByDepartmentAndGroup(departmentId, groupId,start,end);
	}			

	public List<VBPQ_Entry> findByCategoryAndCompany(long categoryId,long companyId) throws SystemException{
		
		return vbpq_EntryPersistence.findByCategoryAndCompany(categoryId, companyId);
	}

	public List<VBPQ_Entry> findByCategoryAndCompany(long categoryId,long companyId,int start,int end) throws SystemException{
		
		return vbpq_EntryPersistence.findByCategoryAndCompany(categoryId, companyId,start,end);
	}

	public List<VBPQ_Entry> findByCategoryAndGroup(long categoryId,long groupId) throws SystemException{
		
		return vbpq_EntryPersistence.findByCategoryAndGroup(categoryId, groupId);		
	}

	public List<VBPQ_Entry> findByCategoryAndGroup(long categoryId,long groupId,int start,int end) throws SystemException{
		
		return vbpq_EntryPersistence.findByCategoryAndGroup(categoryId, groupId,start,end);		
	}

	public List<VBPQ_Entry> findByDocTypeAndCompany(long docTypeId,long companyId) throws SystemException{
		
		return vbpq_EntryPersistence.findByDocTypeAndCompany(docTypeId, companyId);
	}
	
	public List<VBPQ_Entry> findByDocTypeAndCompany(long docTypeId,long companyId,int start,int end) throws SystemException{
		
		return vbpq_EntryPersistence.findByDocTypeAndCompany(docTypeId, companyId,start,end);
	}

	public List<VBPQ_Entry> findByDocTypeAndGroup(long docTypeId,long groupId) throws SystemException{
		return vbpq_EntryPersistence.findByDocTypeAndGroup(docTypeId, groupId);
	}
	
	public List<VBPQ_Entry> findByDocTypeAndGroup(long docTypeId,long groupId,int start,int end) throws SystemException{
		return vbpq_EntryPersistence.findByDocTypeAndGroup(docTypeId, groupId,start,end);
	}
	
	public List<VBPQ_Entry> findByExpirationAndCompany(long companyId,boolean expiration) throws SystemException{
		return vbpq_EntryPersistence.findByExpirationAndCompany(expiration, companyId);
	}
	
	
	public List<VBPQ_Entry> findByExpirationAndGroup(long groupId,boolean expiration) throws SystemException{
		return vbpq_EntryPersistence.findByExpirationAndGroup(expiration, groupId);
	}
	
	
	public List<VBPQ_Entry> findByActiveStatusAndCompany(long companyId,boolean active) throws SystemException{
		return vbpq_EntryPersistence.findByStatusAndCompany(active, companyId);
	}
	
	
	public List<VBPQ_Entry> findByActiveStatusAndGroup(long groupId,boolean active) throws SystemException{
		return vbpq_EntryPersistence.findByStatusAndGroup(active, groupId);
	}
	
	public List<VBPQ_Entry> findByKeyword(String keyword,long groupId,int start,int end){
		return VBPQ_EntryFinderUtil.findByKeyword(groupId, keyword,start,end);
	}
	
	public List<VBPQ_Entry> findByMultiCondition(long groupId,String keyword,long departmentId,long categoryId,
		long docTypeId,String startDate,String endDate,int expirationStatus,int start,int end){
		
		return VBPQ_EntryFinderUtil.findByMultiCondition(groupId, keyword, departmentId, categoryId, docTypeId,
			startDate,endDate,expirationStatus,start,end);
	}

	public VBPQ_Entry addVBPQEntry(long companyId,long groupId,long userId,long departmentId,long categoryId,long docTypeId,
			String entryName,String entryCode,String entryDesc,String publicatorName,Date publishDate,Date executeDate,
			Date expirationDate,boolean neverExpired,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		String userName = "";
		
		if(userId > 0){
			User user = userLocalService.getUser(userId);
			
			if(user != null){
				userName = user.getFullName();
			}
		}
		
		long entryId = counterLocalService.increment();
		
		VBPQ_Entry vbpqEntry = vbpq_EntryPersistence.create(entryId);
		
		vbpqEntry.setCompanyId(companyId);
		vbpqEntry.setGroupId(groupId);
		vbpqEntry.setUserId(userId);
		vbpqEntry.setUserName(userName);
		vbpqEntry.setDepartmentId(departmentId);
		vbpqEntry.setCategoryId(categoryId);
		vbpqEntry.setDocTypeId(docTypeId);
		vbpqEntry.setEntryName(entryName);
		vbpqEntry.setEntryCode(entryCode);
		vbpqEntry.setEntryDesc(entryDesc);
		vbpqEntry.setFileAttachmentURL(StringPool.BLANK);
		vbpqEntry.setPublicatorName(publicatorName);
		vbpqEntry.setCreateDate(now);
		vbpqEntry.setModifiedDate(now);
		vbpqEntry.setPublishDate(publishDate);
		vbpqEntry.setExecuteDate(executeDate);
		vbpqEntry.setExpirationDate(expirationDate);
		vbpqEntry.setNeverExpired(neverExpired);
		vbpqEntry.setActive(DEFAULT_VBPQ_ENTRY_ACTIVE_STATUS);
		
		vbpq_EntryPersistence.update(vbpqEntry, false);
		
		if(serviceContext.isAddGroupPermissions()
			|| serviceContext.isAddGuestPermissions()){
		
			addVBPQEntryResources(vbpqEntry, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addVBPQEntryResources(vbpqEntry, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		//Lucene Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(VBPQ_Entry.class);
		
		if(indexer != null){
			indexer.reindex(vbpqEntry);
		}
		
		return vbpqEntry;
	}
	

	public VBPQ_Entry updateVBPQEntry(long entryId,long companyId,long groupId,long userId,long departmentId,long categoryId,
			long docTypeId,String entryName,String entryCode,String entryDesc,String publicatorName,Date publishDate,String vbpqFileAttachmentURL,
			Date executeDate,Date expirationDate,boolean neverExpired,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		String userName = "";
		
		if(userId > 0){
			User user = userLocalService.getUser(userId);
			
			if(user != null){
				userName = user.getFullName();
			}
		}
		
		VBPQ_Entry vbpqEntry = vbpq_EntryPersistence.fetchByPrimaryKey(entryId);
		
		vbpqEntry.setCompanyId(companyId);
		vbpqEntry.setGroupId(groupId);
		vbpqEntry.setUserId(userId);
		vbpqEntry.setUserName(userName);
		vbpqEntry.setDepartmentId(departmentId);
		vbpqEntry.setCategoryId(categoryId);
		vbpqEntry.setDocTypeId(docTypeId);
		vbpqEntry.setEntryName(entryName);
		vbpqEntry.setEntryCode(entryCode);
		vbpqEntry.setEntryDesc(entryDesc);
		vbpqEntry.setFileAttachmentURL(vbpqFileAttachmentURL);
		vbpqEntry.setPublicatorName(publicatorName);
		vbpqEntry.setModifiedDate(now);
		vbpqEntry.setPublishDate(publishDate);
		vbpqEntry.setExecuteDate(executeDate);
		vbpqEntry.setExpirationDate(expirationDate);
		vbpqEntry.setNeverExpired(neverExpired);
		
		vbpq_EntryPersistence.update(vbpqEntry, false);
		
		//Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(VBPQ_Entry.class);

		if(indexer != null){
			
			indexer.reindex(vbpqEntry);
		}
		
		return vbpqEntry;
	}
	
	/**
	 * Deactive
	 * @param entryId
	 * @throws SystemException
	 */
	public void deactiveVBPQEntry(long entryId) throws SystemException{
		
		VBPQ_Entry vbpqEntry = vbpq_EntryPersistence.fetchByPrimaryKey(entryId);
		
		vbpqEntry.setActive(false);
		
		vbpq_EntryPersistence.update(vbpqEntry, false);
	}
	
	/**
	 * Xoa VBPQ
	 * @param entryId
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void deleteVBPQEntry(long entryId) throws SystemException, PortalException{
		
		VBPQ_Entry vbpqEntry = vbpq_EntryPersistence.fetchByPrimaryKey(entryId);
		
		if(vbpqEntry != null){
			
			//Remove entry
			vbpq_EntryPersistence.remove(vbpqEntry);
			
			//remove resource
			resourceLocalService.deleteResource(vbpqEntry.getCompanyId(), VBPQ_Entry.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, vbpqEntry.getEntryId());
			
			//Expando
			ExpandoValueLocalServiceUtil.deleteValues(VBPQ_Entry.class.getName(), entryId);
			
			// Indexer
			Indexer indexer = IndexerRegistryUtil.getIndexer(VBPQ_Entry.class);

			indexer.delete(vbpqEntry);
		}
	}
	
	
	private void addVBPQEntryResources(VBPQ_Entry vbpqEntry,boolean addGroupPermissions,boolean addGuestPermissions) throws PortalException, SystemException{
		
		resourceLocalService.addResources(vbpqEntry.getCompanyId(), vbpqEntry.getGroupId(), 
				vbpqEntry.getUserId(), VBPQ_Entry.class.getName(),
				vbpqEntry.getEntryId(), false, addGroupPermissions, addGuestPermissions);
	}
	
	
	private void addVBPQEntryResources(VBPQ_Entry vbpqEntry,String[] groupPermissions,String[] guestPermissions) throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(vbpqEntry.getCompanyId(), vbpqEntry.getGroupId(),
				vbpqEntry.getUserId(), VBPQ_Entry.class.getName(),
				vbpqEntry.getEntryId(), groupPermissions, guestPermissions);
	}
}













































