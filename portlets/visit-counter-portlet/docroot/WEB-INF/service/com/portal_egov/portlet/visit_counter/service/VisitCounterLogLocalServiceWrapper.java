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

package com.portal_egov.portlet.visit_counter.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VisitCounterLogLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       VisitCounterLogLocalService
 * @generated
 */
public class VisitCounterLogLocalServiceWrapper
	implements VisitCounterLogLocalService,
		ServiceWrapper<VisitCounterLogLocalService> {
	public VisitCounterLogLocalServiceWrapper(
		VisitCounterLogLocalService visitCounterLogLocalService) {
		_visitCounterLogLocalService = visitCounterLogLocalService;
	}

	/**
	* Adds the visit counter log to the database. Also notifies the appropriate model listeners.
	*
	* @param visitCounterLog the visit counter log
	* @return the visit counter log that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterLog addVisitCounterLog(
		com.portal_egov.portlet.visit_counter.model.VisitCounterLog visitCounterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.addVisitCounterLog(visitCounterLog);
	}

	/**
	* Creates a new visit counter log with the primary key. Does not add the visit counter log to the database.
	*
	* @param visitorIp the primary key for the new visit counter log
	* @return the new visit counter log
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterLog createVisitCounterLog(
		java.lang.String visitorIp) {
		return _visitCounterLogLocalService.createVisitCounterLog(visitorIp);
	}

	/**
	* Deletes the visit counter log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param visitorIp the primary key of the visit counter log
	* @return the visit counter log that was removed
	* @throws PortalException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterLog deleteVisitCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.deleteVisitCounterLog(visitorIp);
	}

	/**
	* Deletes the visit counter log from the database. Also notifies the appropriate model listeners.
	*
	* @param visitCounterLog the visit counter log
	* @return the visit counter log that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterLog deleteVisitCounterLog(
		com.portal_egov.portlet.visit_counter.model.VisitCounterLog visitCounterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.deleteVisitCounterLog(visitCounterLog);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _visitCounterLogLocalService.dynamicQuery();
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
		return _visitCounterLogLocalService.dynamicQuery(dynamicQuery);
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
		return _visitCounterLogLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _visitCounterLogLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _visitCounterLogLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.visit_counter.model.VisitCounterLog fetchVisitCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.fetchVisitCounterLog(visitorIp);
	}

	/**
	* Returns the visit counter log with the primary key.
	*
	* @param visitorIp the primary key of the visit counter log
	* @return the visit counter log
	* @throws PortalException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterLog getVisitCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.getVisitCounterLog(visitorIp);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the visit counter logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of visit counter logs
	* @param end the upper bound of the range of visit counter logs (not inclusive)
	* @return the range of visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> getVisitCounterLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.getVisitCounterLogs(start, end);
	}

	/**
	* Returns the number of visit counter logs.
	*
	* @return the number of visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public int getVisitCounterLogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.getVisitCounterLogsCount();
	}

	/**
	* Updates the visit counter log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param visitCounterLog the visit counter log
	* @return the visit counter log that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterLog updateVisitCounterLog(
		com.portal_egov.portlet.visit_counter.model.VisitCounterLog visitCounterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.updateVisitCounterLog(visitCounterLog);
	}

	/**
	* Updates the visit counter log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param visitCounterLog the visit counter log
	* @param merge whether to merge the visit counter log with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the visit counter log that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterLog updateVisitCounterLog(
		com.portal_egov.portlet.visit_counter.model.VisitCounterLog visitCounterLog,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.updateVisitCounterLog(visitCounterLog,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _visitCounterLogLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_visitCounterLogLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _visitCounterLogLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.findAll();
	}

	public java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.findByGroup(groupId);
	}

	public com.portal_egov.portlet.visit_counter.model.VisitCounterLog getCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.getCounterLog(visitorIp);
	}

	public com.portal_egov.portlet.visit_counter.model.VisitCounterLog addCounterLog(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String visitorIp, long lastAccessPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLogLocalService.addCounterLog(companyId, groupId,
			userId, userName, visitorIp, lastAccessPageId);
	}

	public void updateCounterLog(long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String visitorIp, int hitCounter,
		long lastAccessPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_visitCounterLogLocalService.updateCounterLog(companyId, groupId,
			userId, userName, visitorIp, hitCounter, lastAccessPageId);
	}

	public void incrementCounter(java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		_visitCounterLogLocalService.incrementCounter(visitorIp);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VisitCounterLogLocalService getWrappedVisitCounterLogLocalService() {
		return _visitCounterLogLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVisitCounterLogLocalService(
		VisitCounterLogLocalService visitCounterLogLocalService) {
		_visitCounterLogLocalService = visitCounterLogLocalService;
	}

	public VisitCounterLogLocalService getWrappedService() {
		return _visitCounterLogLocalService;
	}

	public void setWrappedService(
		VisitCounterLogLocalService visitCounterLogLocalService) {
		_visitCounterLogLocalService = visitCounterLogLocalService;
	}

	private VisitCounterLogLocalService _visitCounterLogLocalService;
}