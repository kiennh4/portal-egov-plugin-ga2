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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the statistic entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see StatisticEntityPersistenceImpl
 * @see StatisticEntityUtil
 * @generated
 */
public interface StatisticEntityPersistence extends BasePersistence<StatisticEntity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatisticEntityUtil} to access the statistic entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the statistic entity in the entity cache if it is enabled.
	*
	* @param statisticEntity the statistic entity
	*/
	public void cacheResult(
		com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity statisticEntity);

	/**
	* Caches the statistic entities in the entity cache if it is enabled.
	*
	* @param statisticEntities the statistic entities
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> statisticEntities);

	/**
	* Creates a new statistic entity with the primary key. Does not add the statistic entity to the database.
	*
	* @param entityId the primary key for the new statistic entity
	* @return the new statistic entity
	*/
	public com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity create(
		long entityId);

	/**
	* Removes the statistic entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the statistic entity
	* @return the statistic entity that was removed
	* @throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException if a statistic entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity remove(
		long entityId)
		throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity updateImpl(
		com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity statisticEntity,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the statistic entity with the primary key or throws a {@link com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException} if it could not be found.
	*
	* @param entityId the primary key of the statistic entity
	* @return the statistic entity
	* @throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException if a statistic entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity findByPrimaryKey(
		long entityId)
		throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the statistic entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entityId the primary key of the statistic entity
	* @return the statistic entity, or <code>null</code> if a statistic entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity fetchByPrimaryKey(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the statistic entities where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching statistic entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first statistic entity in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching statistic entity
	* @throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException if a matching statistic entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first statistic entity in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching statistic entity, or <code>null</code> if a matching statistic entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last statistic entity in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching statistic entity
	* @throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException if a matching statistic entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last statistic entity in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching statistic entity, or <code>null</code> if a matching statistic entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity[] findByGroup_PrevAndNext(
		long entityId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the statistic entities.
	*
	* @return the statistic entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the statistic entities where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the statistic entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of statistic entities where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching statistic entities
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of statistic entities.
	*
	* @return the number of statistic entities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}