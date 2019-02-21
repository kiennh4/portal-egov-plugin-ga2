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
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.portal_egov.portlet.tthc.model.TTHC_Attribute;
import com.portal_egov.portlet.tthc.service.base.TTHC_AttributeLocalServiceBaseImpl;

/**
 * The implementation of the t t h c_ attribute local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder 
 * to copy their definitions into the {@link com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS 
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.tthc.service.base.TTHC_AttributeLocalServiceBaseImpl
 * @see com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalServiceUtil
 */
public class TTHC_AttributeLocalServiceImpl
	extends TTHC_AttributeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalServiceUtil} 
	 * to access the t t h c_ attribute local service.
	 */
	
	public int countAll() throws SystemException{
		return tthc_AttributePersistence.countAll();
	}
	
	public List<TTHC_Attribute> findByTTHCEntryAndCompany(long companyId,long tthcEntryId) throws SystemException{
		return tthc_AttributePersistence.findByTTHCEntryAndCompany(companyId, tthcEntryId);
	}	

	public List<TTHC_Attribute> findByTTHCEntryAndCompany(long companyId,long tthcEntryId,int start,int end) throws SystemException{
		return tthc_AttributePersistence.findByTTHCEntryAndCompany(companyId, tthcEntryId,start,end);
	}
	
	public List<TTHC_Attribute> findByTTHCEntryAndGroup(long groupId,long tthcEntryId) throws SystemException{
		return tthc_AttributePersistence.findByTTHCEntryAndGroup(groupId, tthcEntryId);
	}	

	public List<TTHC_Attribute> findByTTHCEntryAndGroup(long groupId,long tthcEntryId,int start,int end) throws SystemException{
		return tthc_AttributePersistence.findByTTHCEntryAndGroup(groupId, tthcEntryId,start,end);
	}
	
	public List<TTHC_Attribute> findByTTHCEntryAndAttrTypeAndCompany(long companyId,long tthcEntryId,int attributeTypeId) throws SystemException{
		return tthc_AttributePersistence.findByTTHCEntryAndAttributeTypeAndCompany(companyId, tthcEntryId, attributeTypeId);
	}	
	
	public List<TTHC_Attribute> findByTTHCEntryAndAttrTypeAndCompany(long companyId,long tthcEntryId,int attributeTypeId,int start,int end) throws SystemException{
		return tthc_AttributePersistence.findByTTHCEntryAndAttributeTypeAndCompany(companyId, tthcEntryId, attributeTypeId, start, end);
	}
	
	public List<TTHC_Attribute> findByTTHCEntryAndAttrTypeAndGroup(long groupId,long tthcEntryId,int attributeTypeId) throws SystemException{
		return tthc_AttributePersistence.findByTTHCEntryAndAttributeTypeAndGroup(groupId, tthcEntryId, attributeTypeId);
	}	
	
	public List<TTHC_Attribute> findByTTHCEntryAndAttrTypeAndGroup(long groupId,long tthcEntryId,int attributeTypeId,int start,int end) throws SystemException{
		return tthc_AttributePersistence.findByTTHCEntryAndAttributeTypeAndGroup(groupId, tthcEntryId, attributeTypeId, start, end);
	}
	public TTHC_Attribute addTTHCAttribute(long companyId,long groupId,long userId,long tthcEntryId,int attributeTypeId,int attributeIndex
								,String attributeName,String attributeValue,ServiceContext serviceContext)
												throws SystemException, PortalException{
		
		Date now = new Date();
		long attributeId = counterLocalService.increment();
		
		TTHC_Attribute tthcAttribute = tthc_AttributePersistence.create(attributeId);
		
		tthcAttribute.setCompanyId(companyId);
		tthcAttribute.setGroupId(groupId);
		tthcAttribute.setUserId(userId);
		tthcAttribute.setTthcEntryId(tthcEntryId);
		tthcAttribute.setAttributeTypeId(attributeTypeId);
		tthcAttribute.setAttributeIndex(attributeIndex);
		tthcAttribute.setAttributeName(attributeName);
		tthcAttribute.setAttributeValue(attributeValue);
		tthcAttribute.setCreateDate(now);
		tthcAttribute.setModifiedDate(now);
		
		tthc_AttributePersistence.update(tthcAttribute, false);
				
		if(serviceContext.isAddGroupPermissions()
			|| serviceContext.isAddGuestPermissions()){
		
			addVBPQAttributeResources(tthcAttribute, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}else{
			
			addVBPQAttributeResources(tthcAttribute, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		
		return tthcAttribute;
	}
	
	
	public TTHC_Attribute updateTTHCAttribute(long attributeId,long companyId,long groupId,long userId,long tthcEntryId,int attributeTypeId,
						int attributeIndex,String attributeName,String attributeValue)throws SystemException, PortalException{
		
		Date now = new Date();
				
		TTHC_Attribute tthcAttribute = tthc_AttributePersistence.fetchByPrimaryKey(attributeId);
		
		tthcAttribute.setCompanyId(companyId);
		tthcAttribute.setGroupId(groupId);
		tthcAttribute.setUserId(userId);
		tthcAttribute.setTthcEntryId(tthcEntryId);
		tthcAttribute.setAttributeTypeId(attributeTypeId);
		tthcAttribute.setAttributeIndex(attributeIndex);
		tthcAttribute.setAttributeName(attributeName);
		tthcAttribute.setAttributeValue(attributeValue);

		tthcAttribute.setModifiedDate(now);
		
		tthc_AttributePersistence.update(tthcAttribute, false);
						
		return tthcAttribute;
	}

	
	public void deleteTTHCAttribute(long attributeId) throws SystemException, PortalException{
		
		TTHC_Attribute tthcAttribute = tthc_AttributePersistence.fetchByPrimaryKey(attributeId);
		
		if(tthcAttribute != null){
			
			tthc_AttributePersistence.remove(tthcAttribute);
			resourceLocalService.deleteResource(tthcAttribute.getAttributeId(), TTHC_Attribute.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, tthcAttribute.getAttributeId());
		}
	}
	
	private void addVBPQAttributeResources(TTHC_Attribute tthcAttribute,boolean addGroupPermissions,boolean addGuestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addResources(tthcAttribute.getCompanyId(), tthcAttribute.getGroupId(), 
			tthcAttribute.getUserId(), TTHC_Attribute.class.getName(),
			tthcAttribute.getAttributeId(), false, addGroupPermissions, addGuestPermissions);
	}
		
	private void addVBPQAttributeResources(TTHC_Attribute tthcAttribute,String[] groupPermissions,String[] guestPermissions) 
					throws PortalException, SystemException{
		
		resourceLocalService.addModelResources(tthcAttribute.getCompanyId(), tthcAttribute.getGroupId(),
			tthcAttribute.getUserId(), TTHC_Attribute.class.getName(),
			tthcAttribute.getAttributeId(), groupPermissions, guestPermissions);
	}		
}