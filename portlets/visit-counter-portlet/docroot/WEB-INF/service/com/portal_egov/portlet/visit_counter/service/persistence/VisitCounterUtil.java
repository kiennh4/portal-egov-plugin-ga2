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

import com.portal_egov.portlet.visit_counter.model.VisitCounter;

import java.util.List;

/**
 * The persistence utility for the visit counter service. This utility wraps {@link VisitCounterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see VisitCounterPersistence
 * @see VisitCounterPersistenceImpl
 * @generated
 */
public class VisitCounterUtil {
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
	public static void clearCache(VisitCounter visitCounter) {
		getPersistence().clearCache(visitCounter);
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
	public static List<VisitCounter> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VisitCounter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VisitCounter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VisitCounter update(VisitCounter visitCounter, boolean merge)
		throws SystemException {
		return getPersistence().update(visitCounter, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VisitCounter update(VisitCounter visitCounter, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(visitCounter, merge, serviceContext);
	}

	/**
	* Caches the visit counter in the entity cache if it is enabled.
	*
	* @param visitCounter the visit counter
	*/
	public static void cacheResult(
		com.portal_egov.portlet.visit_counter.model.VisitCounter visitCounter) {
		getPersistence().cacheResult(visitCounter);
	}

	/**
	* Caches the visit counters in the entity cache if it is enabled.
	*
	* @param visitCounters the visit counters
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounter> visitCounters) {
		getPersistence().cacheResult(visitCounters);
	}

	/**
	* Creates a new visit counter with the primary key. Does not add the visit counter to the database.
	*
	* @param counterId the primary key for the new visit counter
	* @return the new visit counter
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounter create(
		long counterId) {
		return getPersistence().create(counterId);
	}

	/**
	* Removes the visit counter with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param counterId the primary key of the visit counter
	* @return the visit counter that was removed
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException if a visit counter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounter remove(
		long counterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException {
		return getPersistence().remove(counterId);
	}

	public static com.portal_egov.portlet.visit_counter.model.VisitCounter updateImpl(
		com.portal_egov.portlet.visit_counter.model.VisitCounter visitCounter,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(visitCounter, merge);
	}

	/**
	* Returns the visit counter with the primary key or throws a {@link com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException} if it could not be found.
	*
	* @param counterId the primary key of the visit counter
	* @return the visit counter
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException if a visit counter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounter findByPrimaryKey(
		long counterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException {
		return getPersistence().findByPrimaryKey(counterId);
	}

	/**
	* Returns the visit counter with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param counterId the primary key of the visit counter
	* @return the visit counter, or <code>null</code> if a visit counter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounter fetchByPrimaryKey(
		long counterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(counterId);
	}

	/**
	* Returns all the visit counters where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounter> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the visit counters where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of visit counters
	* @param end the upper bound of the range of visit counters (not inclusive)
	* @return the range of matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounter> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the visit counters where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of visit counters
	* @param end the upper bound of the range of visit counters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounter> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first visit counter in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounter findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first visit counter in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter, or <code>null</code> if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounter fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last visit counter in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounter findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last visit counter in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter, or <code>null</code> if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounter fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the visit counters before and after the current visit counter in the ordered set where companyId = &#63;.
	*
	* @param counterId the primary key of the current visit counter
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next visit counter
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException if a visit counter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounter[] findByCompany_PrevAndNext(
		long counterId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException {
		return getPersistence()
				   .findByCompany_PrevAndNext(counterId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the visit counters where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounter> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the visit counters where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of visit counters
	* @param end the upper bound of the range of visit counters (not inclusive)
	* @return the range of matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounter> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the visit counters where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of visit counters
	* @param end the upper bound of the range of visit counters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounter> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first visit counter in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounter findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first visit counter in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter, or <code>null</code> if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounter fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last visit counter in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounter findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last visit counter in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter, or <code>null</code> if a matching visit counter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounter fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the visit counters before and after the current visit counter in the ordered set where groupId = &#63;.
	*
	* @param counterId the primary key of the current visit counter
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next visit counter
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException if a visit counter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounter[] findByGroup_PrevAndNext(
		long counterId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterException {
		return getPersistence()
				   .findByGroup_PrevAndNext(counterId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the visit counters.
	*
	* @return the visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounter> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the visit counters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of visit counters
	* @param end the upper bound of the range of visit counters (not inclusive)
	* @return the range of visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounter> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the visit counters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of visit counters
	* @param end the upper bound of the range of visit counters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounter> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the visit counters where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the visit counters where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the visit counters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of visit counters where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of visit counters where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of visit counters.
	*
	* @return the number of visit counters
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VisitCounterPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VisitCounterPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.visit_counter.service.ClpSerializer.getServletContextName(),
					VisitCounterPersistence.class.getName());

			ReferenceRegistry.registerReference(VisitCounterUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(VisitCounterPersistence persistence) {
	}

	private static VisitCounterPersistence _persistence;
}