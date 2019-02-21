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

package com.portal_egov.portlet.compaints.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Complaint_DlFileEntriesLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       Complaint_DlFileEntriesLocalService
 * @generated
 */
public class Complaint_DlFileEntriesLocalServiceWrapper
	implements Complaint_DlFileEntriesLocalService,
		ServiceWrapper<Complaint_DlFileEntriesLocalService> {
	public Complaint_DlFileEntriesLocalServiceWrapper(
		Complaint_DlFileEntriesLocalService complaint_DlFileEntriesLocalService) {
		_complaint_DlFileEntriesLocalService = complaint_DlFileEntriesLocalService;
	}

	/**
	* Adds the complaint_ dl file entries to the database. Also notifies the appropriate model listeners.
	*
	* @param complaint_DlFileEntries the complaint_ dl file entries
	* @return the complaint_ dl file entries that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries addComplaint_DlFileEntries(
		com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries complaint_DlFileEntries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.addComplaint_DlFileEntries(complaint_DlFileEntries);
	}

	/**
	* Creates a new complaint_ dl file entries with the primary key. Does not add the complaint_ dl file entries to the database.
	*
	* @param id the primary key for the new complaint_ dl file entries
	* @return the new complaint_ dl file entries
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries createComplaint_DlFileEntries(
		long id) {
		return _complaint_DlFileEntriesLocalService.createComplaint_DlFileEntries(id);
	}

	/**
	* Deletes the complaint_ dl file entries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the complaint_ dl file entries
	* @return the complaint_ dl file entries that was removed
	* @throws PortalException if a complaint_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries deleteComplaint_DlFileEntries(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.deleteComplaint_DlFileEntries(id);
	}

	/**
	* Deletes the complaint_ dl file entries from the database. Also notifies the appropriate model listeners.
	*
	* @param complaint_DlFileEntries the complaint_ dl file entries
	* @return the complaint_ dl file entries that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries deleteComplaint_DlFileEntries(
		com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries complaint_DlFileEntries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.deleteComplaint_DlFileEntries(complaint_DlFileEntries);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _complaint_DlFileEntriesLocalService.dynamicQuery();
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.dynamicQuery(dynamicQuery);
	}

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
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries fetchComplaint_DlFileEntries(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.fetchComplaint_DlFileEntries(id);
	}

	/**
	* Returns the complaint_ dl file entries with the primary key.
	*
	* @param id the primary key of the complaint_ dl file entries
	* @return the complaint_ dl file entries
	* @throws PortalException if a complaint_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries getComplaint_DlFileEntries(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.getComplaint_DlFileEntries(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the complaint_ dl file entrieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of complaint_ dl file entrieses
	* @param end the upper bound of the range of complaint_ dl file entrieses (not inclusive)
	* @return the range of complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> getComplaint_DlFileEntrieses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.getComplaint_DlFileEntrieses(start,
			end);
	}

	/**
	* Returns the number of complaint_ dl file entrieses.
	*
	* @return the number of complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public int getComplaint_DlFileEntriesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.getComplaint_DlFileEntriesesCount();
	}

	/**
	* Updates the complaint_ dl file entries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param complaint_DlFileEntries the complaint_ dl file entries
	* @return the complaint_ dl file entries that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries updateComplaint_DlFileEntries(
		com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries complaint_DlFileEntries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.updateComplaint_DlFileEntries(complaint_DlFileEntries);
	}

	/**
	* Updates the complaint_ dl file entries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param complaint_DlFileEntries the complaint_ dl file entries
	* @param merge whether to merge the complaint_ dl file entries with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the complaint_ dl file entries that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries updateComplaint_DlFileEntries(
		com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries complaint_DlFileEntries,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.updateComplaint_DlFileEntries(complaint_DlFileEntries,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _complaint_DlFileEntriesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_complaint_DlFileEntriesLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _complaint_DlFileEntriesLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	public java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findByComplaint(
		long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.findByComplaint(complaintId);
	}

	public java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findByDLFile(
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _complaint_DlFileEntriesLocalService.findByDLFile(fileEntryId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public Complaint_DlFileEntriesLocalService getWrappedComplaint_DlFileEntriesLocalService() {
		return _complaint_DlFileEntriesLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedComplaint_DlFileEntriesLocalService(
		Complaint_DlFileEntriesLocalService complaint_DlFileEntriesLocalService) {
		_complaint_DlFileEntriesLocalService = complaint_DlFileEntriesLocalService;
	}

	public Complaint_DlFileEntriesLocalService getWrappedService() {
		return _complaint_DlFileEntriesLocalService;
	}

	public void setWrappedService(
		Complaint_DlFileEntriesLocalService complaint_DlFileEntriesLocalService) {
		_complaint_DlFileEntriesLocalService = complaint_DlFileEntriesLocalService;
	}

	private Complaint_DlFileEntriesLocalService _complaint_DlFileEntriesLocalService;
}