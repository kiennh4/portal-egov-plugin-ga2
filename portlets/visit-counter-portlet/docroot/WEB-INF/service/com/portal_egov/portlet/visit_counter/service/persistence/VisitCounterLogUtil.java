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

package com.portal_egov.portlet.visit_counter.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.visit_counter.model.VisitCounterLog;

import java.util.List;

/**
 * The persistence utility for the visit counter log service. This utility wraps {@link VisitCounterLogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see VisitCounterLogPersistence
 * @see VisitCounterLogPersistenceImpl
 * @generated
 */
public class VisitCounterLogUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(VisitCounterLog visitCounterLog) {
		getPersistence().clearCache(visitCounterLog);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VisitCounterLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VisitCounterLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VisitCounterLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VisitCounterLog update(VisitCounterLog visitCounterLog,
		boolean merge) throws SystemException {
		return getPersistence().update(visitCounterLog, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VisitCounterLog update(VisitCounterLog visitCounterLog,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(visitCounterLog, merge, serviceContext);
	}

	/**
	* Caches the visit counter log in the entity cache if it is enabled.
	*
	* @param visitCounterLog the visit counter log
	*/
	public static void cacheResult(
		com.portal_egov.portlet.visit_counter.model.VisitCounterLog visitCounterLog) {
		getPersistence().cacheResult(visitCounterLog);
	}

	/**
	* Caches the visit counter logs in the entity cache if it is enabled.
	*
	* @param visitCounterLogs the visit counter logs
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> visitCounterLogs) {
		getPersistence().cacheResult(visitCounterLogs);
	}

	/**
	* Creates a new visit counter log with the primary key. Does not add the visit counter log to the database.
	*
	* @param visitorIp the primary key for the new visit counter log
	* @return the new visit counter log
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog create(
		java.lang.String visitorIp) {
		return getPersistence().create(visitorIp);
	}

	/**
	* Removes the visit counter log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param visitorIp the primary key of the visit counter log
	* @return the visit counter log that was removed
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog remove(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException {
		return getPersistence().remove(visitorIp);
	}

	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog updateImpl(
		com.portal_egov.portlet.visit_counter.model.VisitCounterLog visitCounterLog,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(visitCounterLog, merge);
	}

	/**
	* Returns the visit counter log with the primary key or throws a {@link com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException} if it could not be found.
	*
	* @param visitorIp the primary key of the visit counter log
	* @return the visit counter log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog findByPrimaryKey(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException {
		return getPersistence().findByPrimaryKey(visitorIp);
	}

	/**
	* Returns the visit counter log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param visitorIp the primary key of the visit counter log
	* @return the visit counter log, or <code>null</code> if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog fetchByPrimaryKey(
		java.lang.String visitorIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(visitorIp);
	}

	/**
	* Returns all the visit counter logs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the visit counter logs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of visit counter logs
	* @param end the upper bound of the range of visit counter logs (not inclusive)
	* @return the range of matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the visit counter logs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of visit counter logs
	* @param end the upper bound of the range of visit counter logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first visit counter log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first visit counter log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last visit counter log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last visit counter log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the visit counter logs before and after the current visit counter log in the ordered set where companyId = &#63;.
	*
	* @param visitorIp the primary key of the current visit counter log
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next visit counter log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog[] findByCompany_PrevAndNext(
		java.lang.String visitorIp, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException {
		return getPersistence()
				   .findByCompany_PrevAndNext(visitorIp, companyId,
			orderByComparator);
	}

	/**
	* Returns all the visit counter logs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the visit counter logs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of visit counter logs
	* @param end the upper bound of the range of visit counter logs (not inclusive)
	* @return the range of matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the visit counter logs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of visit counter logs
	* @param end the upper bound of the range of visit counter logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first visit counter log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first visit counter log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last visit counter log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last visit counter log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the visit counter logs before and after the current visit counter log in the ordered set where groupId = &#63;.
	*
	* @param visitorIp the primary key of the current visit counter log
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next visit counter log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterLog[] findByGroup_PrevAndNext(
		java.lang.String visitorIp, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException {
		return getPersistence()
				   .findByGroup_PrevAndNext(visitorIp, groupId,
			orderByComparator);
	}

	/**
	* Returns all the visit counter logs.
	*
	* @return the visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the visit counter logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of visit counter logs
	* @param end the upper bound of the range of visit counter logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the visit counter logs where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the visit counter logs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the visit counter logs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of visit counter logs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of visit counter logs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of visit counter logs.
	*
	* @return the number of visit counter logs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VisitCounterLogPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VisitCounterLogPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.visit_counter.service.ClpSerializer.getServletContextName(),
					VisitCounterLogPersistence.class.getName());

			ReferenceRegistry.registerReference(VisitCounterLogUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(VisitCounterLogPersistence persistence) {
	}

	private static VisitCounterLogPersistence _persistence;
}