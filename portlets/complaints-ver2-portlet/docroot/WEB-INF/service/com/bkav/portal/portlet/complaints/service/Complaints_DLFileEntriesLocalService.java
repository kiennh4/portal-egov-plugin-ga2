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

package com.bkav.portal.portlet.complaints.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the complaints_ d l file entries local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author AnhBDb
 * @see Complaints_DLFileEntriesLocalServiceUtil
 * @see com.bkav.portal.portlet.complaints.service.base.Complaints_DLFileEntriesLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.complaints.service.impl.Complaints_DLFileEntriesLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface Complaints_DLFileEntriesLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Complaints_DLFileEntriesLocalServiceUtil} to access the complaints_ d l file entries local service. Add custom service methods to {@link com.bkav.portal.portlet.complaints.service.impl.Complaints_DLFileEntriesLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the complaints_ d l file entries to the database. Also notifies the appropriate model listeners.
	*
	* @param complaints_DLFileEntries the complaints_ d l file entries
	* @return the complaints_ d l file entries that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries addComplaints_DLFileEntries(
		com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries complaints_DLFileEntries)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new complaints_ d l file entries with the primary key. Does not add the complaints_ d l file entries to the database.
	*
	* @param id the primary key for the new complaints_ d l file entries
	* @return the new complaints_ d l file entries
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries createComplaints_DLFileEntries(
		long id);

	/**
	* Deletes the complaints_ d l file entries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the complaints_ d l file entries
	* @return the complaints_ d l file entries that was removed
	* @throws PortalException if a complaints_ d l file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries deleteComplaints_DLFileEntries(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the complaints_ d l file entries from the database. Also notifies the appropriate model listeners.
	*
	* @param complaints_DLFileEntries the complaints_ d l file entries
	* @return the complaints_ d l file entries that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries deleteComplaints_DLFileEntries(
		com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries complaints_DLFileEntries)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries fetchComplaints_DLFileEntries(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complaints_ d l file entries with the primary key.
	*
	* @param id the primary key of the complaints_ d l file entries
	* @return the complaints_ d l file entries
	* @throws PortalException if a complaints_ d l file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries getComplaints_DLFileEntries(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the complaints_ d l file entrieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of complaints_ d l file entrieses
	* @param end the upper bound of the range of complaints_ d l file entrieses (not inclusive)
	* @return the range of complaints_ d l file entrieses
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries> getComplaints_DLFileEntrieses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of complaints_ d l file entrieses.
	*
	* @return the number of complaints_ d l file entrieses
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getComplaints_DLFileEntriesesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the complaints_ d l file entries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param complaints_DLFileEntries the complaints_ d l file entries
	* @return the complaints_ d l file entries that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries updateComplaints_DLFileEntries(
		com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries complaints_DLFileEntries)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the complaints_ d l file entries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param complaints_DLFileEntries the complaints_ d l file entries
	* @param merge whether to merge the complaints_ d l file entries with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the complaints_ d l file entries that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries updateComplaints_DLFileEntries(
		com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries complaints_DLFileEntries,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries> findByComplaintId(
		long complaintId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries> findByDLFileEntrytId(
		long fileEntrytId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addComplaintsDlFileEntry(long complaintId, long fileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void deleteComplaintsDLFileEntry(long complaintId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}