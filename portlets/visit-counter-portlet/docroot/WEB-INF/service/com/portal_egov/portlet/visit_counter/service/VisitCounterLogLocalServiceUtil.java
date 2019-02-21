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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the visit counter log local service. This utility wraps {@link com.portal_egov.portlet.visit_counter.service.impl.VisitCounterLogLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see VisitCounterLogLocalService
 * @see com.portal_egov.portlet.visit_counter.service.base.VisitCounterLogLocalServiceBaseImpl
 * @see com.portal_egov.portlet.visit_counter.service.impl.VisitCounterLogLocalServiceImpl
 * @generated
 */
public class VisitCounterLogLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.visit_counter.service.impl.VisitCounterLogLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the visit counter log to the database. Also notifies the appropriate model listeners.
	*
	* @param visitCounterLog the visit counter log
	* @return the visit counter log that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog addVisitCounterLog(
		com.portal_egov.portlet.visit_counter.model.VisitCounterLog visitCounterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVisitCounterLog(visitCounterLog);
	}

	/**
	* Creates a new visit counter log with the primary key. Does not add the visit counter log to the database.
	*
	* @param visitorIp the primary key for the new visit counter log
	* @return the new visit counter log
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog createVisitCounterLog(
		java.lang.String visitorIp) {
		return getService().createVisitCounterLog(visitorIp);
	}

	/**
	* Deletes the visit counter log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param visitorIp the primary key of the visit counter log
	* @return the visit counter log that was removed
	* @throws PortalException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog deleteVisitCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVisitCounterLog(visitorIp);
	}

	/**
	* Deletes the visit counter log from the database. Also notifies the appropriate model listeners.
	*
	* @param visitCounterLog the visit counter log
	* @return the visit counter log that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog deleteVisitCounterLog(
		com.portal_egov.portlet.visit_counter.model.VisitCounterLog visitCounterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVisitCounterLog(visitCounterLog);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog fetchVisitCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVisitCounterLog(visitorIp);
	}

	/**
	* Returns the visit counter log with the primary key.
	*
	* @param visitorIp the primary key of the visit counter log
	* @return the visit counter log
	* @throws PortalException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog getVisitCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVisitCounterLog(visitorIp);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> getVisitCounterLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVisitCounterLogs(start, end);
	}

	/**
	* Returns the number of visit counter logs.
	*
	* @return the number of visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public static int getVisitCounterLogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVisitCounterLogsCount();
	}

	/**
	* Updates the visit counter log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param visitCounterLog the visit counter log
	* @return the visit counter log that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog updateVisitCounterLog(
		com.portal_egov.portlet.visit_counter.model.VisitCounterLog visitCounterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVisitCounterLog(visitCounterLog);
	}

	/**
	* Updates the visit counter log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param visitCounterLog the visit counter log
	* @param merge whether to merge the visit counter log with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the visit counter log that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog updateVisitCounterLog(
		com.portal_egov.portlet.visit_counter.model.VisitCounterLog visitCounterLog,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVisitCounterLog(visitCounterLog, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog getCounterLog(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCounterLog(visitorIp);
	}

	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog addCounterLog(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String visitorIp, long lastAccessPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCounterLog(companyId, groupId, userId, userName,
			visitorIp, lastAccessPageId);
	}

	public static void updateCounterLog(long companyId, long groupId,
		long userId, java.lang.String userName, java.lang.String visitorIp,
		int hitCounter, long lastAccessPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateCounterLog(companyId, groupId, userId, userName, visitorIp,
			hitCounter, lastAccessPageId);
	}

	public static void incrementCounter(java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().incrementCounter(visitorIp);
	}

	public static void clearService() {
		_service = null;
	}

	public static VisitCounterLogLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VisitCounterLogLocalService.class.getName());

			if (invokableLocalService instanceof VisitCounterLogLocalService) {
				_service = (VisitCounterLogLocalService)invokableLocalService;
			}
			else {
				_service = new VisitCounterLogLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VisitCounterLogLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(VisitCounterLogLocalService service) {
	}

	private static VisitCounterLogLocalService _service;
}