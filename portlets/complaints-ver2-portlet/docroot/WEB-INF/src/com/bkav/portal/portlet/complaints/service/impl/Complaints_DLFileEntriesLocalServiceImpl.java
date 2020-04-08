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

package com.bkav.portal.portlet.complaints.service.impl;

import java.util.List;

import com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries;
import com.bkav.portal.portlet.complaints.service.base.Complaints_DLFileEntriesLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the complaints_ d l file entries local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bkav.portal.portlet.complaints.service.Complaints_DLFileEntriesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author AnhBDb
 * @see com.bkav.portal.portlet.complaints.service.base.Complaints_DLFileEntriesLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.complaints.service.Complaints_DLFileEntriesLocalServiceUtil
 */
public class Complaints_DLFileEntriesLocalServiceImpl
	extends Complaints_DLFileEntriesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bkav.portal.portlet.complaints.service.Complaints_DLFileEntriesLocalServiceUtil} to access the complaints_ d l file entries local service.
	 */
	
	public List<Complaints_DLFileEntries> findByComplaintId (long complaintId) throws PortalException, SystemException
	{
		return complaints_DLFileEntriesPersistence.findByComplaintId(complaintId);
	}
	
	public List<Complaints_DLFileEntries> findByDLFileEntrytId (long fileEntrytId) throws PortalException, SystemException
	{
		return complaints_DLFileEntriesPersistence.findByDLFileEntry(fileEntrytId);
	}
	
	public void addComplaintsDlFileEntry (long complaintId, long fileEntryId) throws PortalException, SystemException
	{
		long complaintDLFileId = counterLocalService.increment();
		
		Complaints_DLFileEntries complaintDLFile = complaints_DLFileEntriesPersistence.create(complaintDLFileId);
		complaintDLFile.setComplaintId(complaintId);
		complaintDLFile.setFileEntryId(fileEntryId);
		
		complaints_DLFileEntriesPersistence.update(complaintDLFile, false);
	}
	
	public void deleteComplaintsDLFileEntry (long complaintId) throws PortalException, SystemException
	{
		List<Complaints_DLFileEntries> listComplaintsDLFileEntries = complaints_DLFileEntriesPersistence.findByComplaintId(complaintId);
		
		if (listComplaintsDLFileEntries!=null)
		{
			for (Complaints_DLFileEntries item : listComplaintsDLFileEntries)
			{
				complaints_DLFileEntriesPersistence.remove(item);
			}
		}
	}
}