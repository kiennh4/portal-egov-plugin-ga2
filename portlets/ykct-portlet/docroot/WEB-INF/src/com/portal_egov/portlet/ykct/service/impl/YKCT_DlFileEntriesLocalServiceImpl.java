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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries;
import com.portal_egov.portlet.ykct.service.base.YKCT_DlFileEntriesLocalServiceBaseImpl;

/**
 * The implementation of the y k c t_ dl file entries local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.ykct.service.YKCT_DlFileEntriesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucDVd
 * @see com.portal_egov.portlet.ykct.service.base.YKCT_DlFileEntriesLocalServiceBaseImpl
 * @see com.portal_egov.portlet.ykct.service.YKCT_DlFileEntriesLocalServiceUtil
 */
public class YKCT_DlFileEntriesLocalServiceImpl
	extends YKCT_DlFileEntriesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.ykct.service.YKCT_DlFileEntriesLocalServiceUtil} to access the y k c t_ dl file entries local service.
	 */
	
	public int countByVBPQEntry(long ykctEntryId) throws SystemException{
		return ykct_DlFileEntriesPersistence.countByYKCTEntry(ykctEntryId);
	}
	
	public List<YKCT_DlFileEntries> findByYKCTEntry(long ykctEntryId) throws SystemException{
		return ykct_DlFileEntriesPersistence.findByYKCTEntry(ykctEntryId);
	}
	
	public List<YKCT_DlFileEntries> findByDLFileEntry(long fileEntryId) throws SystemException{
		return ykct_DlFileEntriesPersistence.findByDLFileEntry(fileEntryId);
	}
	
	public void updateMapping(long entryId,long ykctEntryId,long fileEntryId) throws SystemException{
		
		YKCT_DlFileEntries mappingEntry = null;
		
		if(entryId > 0){
			
			mappingEntry = ykct_DlFileEntriesPersistence.fetchByPrimaryKey(entryId);
			
		}else{
			
			entryId = counterLocalService.increment();
			mappingEntry = ykct_DlFileEntriesPersistence.create(entryId);
		}
		
		mappingEntry.setYkctEntryId(ykctEntryId);
		mappingEntry.setFileEntryId(fileEntryId);
		
	}
}