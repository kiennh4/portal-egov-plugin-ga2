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

package com.bkav.portal_egov.portlet.asset_statistics.service.persistence;

import com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the statistic entity service. This utility wraps {@link StatisticEntityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see StatisticEntityPersistence
 * @see StatisticEntityPersistenceImpl
 * @generated
 */
public class StatisticEntityUtil {
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
	public static void clearCache(StatisticEntity statisticEntity) {
		getPersistence().clearCache(statisticEntity);
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
	public static List<StatisticEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StatisticEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StatisticEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static StatisticEntity update(StatisticEntity statisticEntity,
		boolean merge) throws SystemException {
		return getPersistence().update(statisticEntity, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static StatisticEntity update(StatisticEntity statisticEntity,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(statisticEntity, merge, serviceContext);
	}

	/**
	* Caches the statistic entity in the entity cache if it is enabled.
	*
	* @param statisticEntity the statistic entity
	*/
	public static void cacheResult(
		com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity statisticEntity) {
		getPersistence().cacheResult(statisticEntity);
	}

	/**
	* Caches the statistic entities in the entity cache if it is enabled.
	*
	* @param statisticEntities the statistic entities
	*/
	public static void cacheResult(
		java.util.List<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> statisticEntities) {
		getPersistence().cacheResult(statisticEntities);
	}

	/**
	* Creates a new statistic entity with the primary key. Does not add the statistic entity to the database.
	*
	* @param entityId the primary key for the new statistic entity
	* @return the new statistic entity
	*/
	public static com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity create(
		long entityId) {
		return getPersistence().create(entityId);
	}

	/**
	* Removes the statistic entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the statistic entity
	* @return the statistic entity that was removed
	* @throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException if a statistic entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity remove(
		long entityId)
		throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(entityId);
	}

	public static com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity updateImpl(
		com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity statisticEntity,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(statisticEntity, merge);
	}

	/**
	* Returns the statistic entity with the primary key or throws a {@link com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException} if it could not be found.
	*
	* @param entityId the primary key of the statistic entity
	* @return the statistic entity
	* @throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException if a statistic entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity findByPrimaryKey(
		long entityId)
		throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(entityId);
	}

	/**
	* Returns the statistic entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entityId the primary key of the statistic entity
	* @return the statistic entity, or <code>null</code> if a statistic entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity fetchByPrimaryKey(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entityId);
	}

	/**
	* Returns all the statistic entities where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching statistic entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the statistic entities where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of statistic entities
	* @param end the upper bound of the range of statistic entities (not inclusive)
	* @return the range of matching statistic entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the statistic entities where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of statistic entities
	* @param end the upper bound of the range of statistic entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching statistic entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first statistic entity in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching statistic entity
	* @throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException if a matching statistic entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first statistic entity in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching statistic entity, or <code>null</code> if a matching statistic entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last statistic entity in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching statistic entity
	* @throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException if a matching statistic entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last statistic entity in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching statistic entity, or <code>null</code> if a matching statistic entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the statistic entities before and after the current statistic entity in the ordered set where groupId = &#63;.
	*
	* @param entityId the primary key of the current statistic entity
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next statistic entity
	* @throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException if a statistic entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity[] findByGroup_PrevAndNext(
		long entityId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_PrevAndNext(entityId, groupId, orderByComparator);
	}

	/**
	* Returns all the statistic entities.
	*
	* @return the statistic entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the statistic entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of statistic entities
	* @param end the upper bound of the range of statistic entities (not inclusive)
	* @return the range of statistic entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the statistic entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of statistic entities
	* @param end the upper bound of the range of statistic entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of statistic entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the statistic entities where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the statistic entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of statistic entities where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching statistic entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of statistic entities.
	*
	* @return the number of statistic entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StatisticEntityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StatisticEntityPersistence)PortletBeanLocatorUtil.locate(com.bkav.portal_egov.portlet.asset_statistics.service.ClpSerializer.getServletContextName(),
					StatisticEntityPersistence.class.getName());

			ReferenceRegistry.registerReference(StatisticEntityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(StatisticEntityPersistence persistence) {
	}

	private static StatisticEntityPersistence _persistence;
}