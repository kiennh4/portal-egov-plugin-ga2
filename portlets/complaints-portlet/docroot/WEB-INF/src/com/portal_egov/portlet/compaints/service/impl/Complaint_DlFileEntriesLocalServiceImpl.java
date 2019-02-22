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

package com.portal_egov.portlet.compaints.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries;
import com.portal_egov.portlet.compaints.service.base.Complaint_DlFileEntriesLocalServiceBaseImpl;

/**
 * The implementation of the complaint_ dl file entries local service. <p> All
 * custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.compaints.service.Complaint_DlFileEntriesLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author HungDX
 * @see com.portal_egov.portlet.compaints.service.base.Complaint_DlFileEntriesLocalServiceBaseImpl
 * @see com.portal_egov.portlet.compaints.service.Complaint_DlFileEntriesLocalServiceUtil
 */
public class Complaint_DlFileEntriesLocalServiceImpl extends Complaint_DlFileEntriesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.portal_egov.portlet.compaints.service.
	 * Complaint_DlFileEntriesLocalServiceUtil} to access the complaint_ dl file
	 * entries local service.
	 */
	
	public List<Complaint_DlFileEntries> findByComplaint(long complaintId) throws SystemException{
		
		return complaint_DlFileEntriesPersistence.findByComplaint(complaintId);
	}
	
	public List<Complaint_DlFileEntries> findByDLFile(long fileEntryId) throws SystemException{
		
		return complaint_DlFileEntriesPersistence.findByDLFile(fileEntryId);
	}
}
