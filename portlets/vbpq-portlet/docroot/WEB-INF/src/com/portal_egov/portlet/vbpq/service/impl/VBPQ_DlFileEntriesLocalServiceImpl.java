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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries;
import com.portal_egov.portlet.vbpq.service.base.VBPQ_DlFileEntriesLocalServiceBaseImpl;

/**
 * The implementation of the v b p q_ dl file entries local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.vbpq.service.VBPQ_DlFileEntriesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.vbpq.service.base.VBPQ_DlFileEntriesLocalServiceBaseImpl
 * @see com.portal_egov.portlet.vbpq.service.VBPQ_DlFileEntriesLocalServiceUtil
 */
public class VBPQ_DlFileEntriesLocalServiceImpl
	extends VBPQ_DlFileEntriesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.vbpq.service.VBPQ_DlFileEntriesLocalServiceUtil} to access the v b p q_ dl file entries local service.
	 */
	
	public int countByVBPQEntry(long vbpqEntryId) throws SystemException{
		return vbpq_DlFileEntriesPersistence.countByVBPQEntry(vbpqEntryId);
	}
	
	public List<VBPQ_DlFileEntries> findByVBPQEntry(long vbpqEntryId) throws SystemException{
		return vbpq_DlFileEntriesPersistence.findByVBPQEntry(vbpqEntryId);
	}
	
	public List<VBPQ_DlFileEntries> findByDLFileEntry(long fileEntryId) throws SystemException{
		return vbpq_DlFileEntriesPersistence.findByDLFileEntry(fileEntryId);
	}
	
	public void updateMapping(long entryId,long vbpqEntryId,long fileEntryId) throws SystemException{
		
		VBPQ_DlFileEntries mappingEntry = null;
		
		if(entryId > 0){
			
			mappingEntry = vbpq_DlFileEntriesPersistence.fetchByPrimaryKey(entryId);
			
		}else{
			
			entryId = counterLocalService.increment();
			mappingEntry = vbpq_DlFileEntriesPersistence.create(entryId);
		}
		
		mappingEntry.setVbpqEntryId(vbpqEntryId);
		mappingEntry.setFileEntryId(fileEntryId);
		
	}
	
}