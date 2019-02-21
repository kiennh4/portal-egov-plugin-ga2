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

import com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException;
import com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity;
import com.bkav.portal_egov.portlet.asset_statistics.model.impl.StatisticEntityImpl;
import com.bkav.portal_egov.portlet.asset_statistics.model.impl.StatisticEntityModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the statistic entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see StatisticEntityPersistence
 * @see StatisticEntityUtil
 * @generated
 */
public class StatisticEntityPersistenceImpl extends BasePersistenceImpl<StatisticEntity>
	implements StatisticEntityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatisticEntityUtil} to access the statistic entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatisticEntityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(StatisticEntityModelImpl.ENTITY_CACHE_ENABLED,
			StatisticEntityModelImpl.FINDER_CACHE_ENABLED,
			StatisticEntityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(StatisticEntityModelImpl.ENTITY_CACHE_ENABLED,
			StatisticEntityModelImpl.FINDER_CACHE_ENABLED,
			StatisticEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			StatisticEntityModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(StatisticEntityModelImpl.ENTITY_CACHE_ENABLED,
			StatisticEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatisticEntityModelImpl.ENTITY_CACHE_ENABLED,
			StatisticEntityModelImpl.FINDER_CACHE_ENABLED,
			StatisticEntityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatisticEntityModelImpl.ENTITY_CACHE_ENABLED,
			StatisticEntityModelImpl.FINDER_CACHE_ENABLED,
			StatisticEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatisticEntityModelImpl.ENTITY_CACHE_ENABLED,
			StatisticEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the statistic entity in the entity cache if it is enabled.
	 *
	 * @param statisticEntity the statistic entity
	 */
	public void cacheResult(StatisticEntity statisticEntity) {
		EntityCacheUtil.putResult(StatisticEntityModelImpl.ENTITY_CACHE_ENABLED,
			StatisticEntityImpl.class, statisticEntity.getPrimaryKey(),
			statisticEntity);

		statisticEntity.resetOriginalValues();
	}

	/**
	 * Caches the statistic entities in the entity cache if it is enabled.
	 *
	 * @param statisticEntities the statistic entities
	 */
	public void cacheResult(List<StatisticEntity> statisticEntities) {
		for (StatisticEntity statisticEntity : statisticEntities) {
			if (EntityCacheUtil.getResult(
						StatisticEntityModelImpl.ENTITY_CACHE_ENABLED,
						StatisticEntityImpl.class,
						statisticEntity.getPrimaryKey()) == null) {
				cacheResult(statisticEntity);
			}
			else {
				statisticEntity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all statistic entities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StatisticEntityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StatisticEntityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the statistic entity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatisticEntity statisticEntity) {
		EntityCacheUtil.removeResult(StatisticEntityModelImpl.ENTITY_CACHE_ENABLED,
			StatisticEntityImpl.class, statisticEntity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StatisticEntity> statisticEntities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatisticEntity statisticEntity : statisticEntities) {
			EntityCacheUtil.removeResult(StatisticEntityModelImpl.ENTITY_CACHE_ENABLED,
				StatisticEntityImpl.class, statisticEntity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new statistic entity with the primary key. Does not add the statistic entity to the database.
	 *
	 * @param entityId the primary key for the new statistic entity
	 * @return the new statistic entity
	 */
	public StatisticEntity create(long entityId) {
		StatisticEntity statisticEntity = new StatisticEntityImpl();

		statisticEntity.setNew(true);
		statisticEntity.setPrimaryKey(entityId);

		return statisticEntity;
	}

	/**
	 * Removes the statistic entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the statistic entity
	 * @return the statistic entity that was removed
	 * @throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException if a statistic entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StatisticEntity remove(long entityId)
		throws NoSuchStatisticEntityException, SystemException {
		return remove(Long.valueOf(entityId));
	}

	/**
	 * Removes the statistic entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the statistic entity
	 * @return the statistic entity that was removed
	 * @throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException if a statistic entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatisticEntity remove(Serializable primaryKey)
		throws NoSuchStatisticEntityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StatisticEntity statisticEntity = (StatisticEntity)session.get(StatisticEntityImpl.class,
					primaryKey);

			if (statisticEntity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatisticEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statisticEntity);
		}
		catch (NoSuchStatisticEntityException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected StatisticEntity removeImpl(StatisticEntity statisticEntity)
		throws SystemException {
		statisticEntity = toUnwrappedModel(statisticEntity);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, statisticEntity);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(statisticEntity);

		return statisticEntity;
	}

	@Override
	public StatisticEntity updateImpl(
		com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity statisticEntity,
		boolean merge) throws SystemException {
		statisticEntity = toUnwrappedModel(statisticEntity);

		boolean isNew = statisticEntity.isNew();

		StatisticEntityModelImpl statisticEntityModelImpl = (StatisticEntityModelImpl)statisticEntity;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, statisticEntity, merge);

			statisticEntity.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StatisticEntityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((statisticEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(statisticEntityModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(statisticEntityModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(StatisticEntityModelImpl.ENTITY_CACHE_ENABLED,
			StatisticEntityImpl.class, statisticEntity.getPrimaryKey(),
			statisticEntity);

		return statisticEntity;
	}

	protected StatisticEntity toUnwrappedModel(StatisticEntity statisticEntity) {
		if (statisticEntity instanceof StatisticEntityImpl) {
			return statisticEntity;
		}

		StatisticEntityImpl statisticEntityImpl = new StatisticEntityImpl();

		statisticEntityImpl.setNew(statisticEntity.isNew());
		statisticEntityImpl.setPrimaryKey(statisticEntity.getPrimaryKey());

		statisticEntityImpl.setEntityId(statisticEntity.getEntityId());
		statisticEntityImpl.setCompanyId(statisticEntity.getCompanyId());
		statisticEntityImpl.setGroupId(statisticEntity.getGroupId());
		statisticEntityImpl.setUserId(statisticEntity.getUserId());
		statisticEntityImpl.setUserName(statisticEntity.getUserName());
		statisticEntityImpl.setCreateDate(statisticEntity.getCreateDate());
		statisticEntityImpl.setModifiedDate(statisticEntity.getModifiedDate());
		statisticEntityImpl.setEntityName(statisticEntity.getEntityName());

		return statisticEntityImpl;
	}

	/**
	 * Returns the statistic entity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the statistic entity
	 * @return the statistic entity
	 * @throws com.liferay.portal.NoSuchModelException if a statistic entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatisticEntity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the statistic entity with the primary key or throws a {@link com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException} if it could not be found.
	 *
	 * @param entityId the primary key of the statistic entity
	 * @return the statistic entity
	 * @throws com.bkav.portal_egov.portlet.asset_statistics.NoSuchStatisticEntityException if a statistic entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StatisticEntity findByPrimaryKey(long entityId)
		throws NoSuchStatisticEntityException, SystemException {
		StatisticEntity statisticEntity = fetchByPrimaryKey(entityId);

		if (statisticEntity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entityId);
			}

			throw new NoSuchStatisticEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				entityId);
		}

		return statisticEntity;
	}

	/**
	 * Returns the statistic entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the statistic entity
	 * @return the statistic entity, or <code>null</code> if a statistic entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatisticEntity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the statistic entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the statistic entity
	 * @return the statistic entity, or <code>null</code> if a statistic entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StatisticEntity fetchByPrimaryKey(long entityId)
		throws SystemException {
		StatisticEntity statisticEntity = (StatisticEntity)EntityCacheUtil.getResult(StatisticEntityModelImpl.ENTITY_CACHE_ENABLED,
				StatisticEntityImpl.class, entityId);

		if (statisticEntity == _nullStatisticEntity) {
			return null;
		}

		if (statisticEntity == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				statisticEntity = (StatisticEntity)session.get(StatisticEntityImpl.class,
						Long.valueOf(entityId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (statisticEntity != null) {
					cacheResult(statisticEntity);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(StatisticEntityModelImpl.ENTITY_CACHE_ENABLED,
						StatisticEntityImpl.class, entityId,
						_nullStatisticEntity);
				}

				closeSession(session);
			}
		}

		return statisticEntity;
	}

	/**
	 * Returns all the statistic entities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching statistic entities
	 * @throws SystemException if a system exception occurred
	 */
	public List<StatisticEntity> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<StatisticEntity> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
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
	public List<StatisticEntity> findByGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<StatisticEntity> list = (List<StatisticEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StatisticEntity statisticEntity : list) {
				if ((groupId != statisticEntity.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STATISTICENTITY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(StatisticEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<StatisticEntity>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public StatisticEntity findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchStatisticEntityException, SystemException {
		StatisticEntity statisticEntity = fetchByGroup_First(groupId,
				orderByComparator);

		if (statisticEntity != null) {
			return statisticEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatisticEntityException(msg.toString());
	}

	/**
	 * Returns the first statistic entity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic entity, or <code>null</code> if a matching statistic entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StatisticEntity fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StatisticEntity> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public StatisticEntity findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchStatisticEntityException, SystemException {
		StatisticEntity statisticEntity = fetchByGroup_Last(groupId,
				orderByComparator);

		if (statisticEntity != null) {
			return statisticEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatisticEntityException(msg.toString());
	}

	/**
	 * Returns the last statistic entity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic entity, or <code>null</code> if a matching statistic entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StatisticEntity fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<StatisticEntity> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public StatisticEntity[] findByGroup_PrevAndNext(long entityId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchStatisticEntityException, SystemException {
		StatisticEntity statisticEntity = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			StatisticEntity[] array = new StatisticEntityImpl[3];

			array[0] = getByGroup_PrevAndNext(session, statisticEntity,
					groupId, orderByComparator, true);

			array[1] = statisticEntity;

			array[2] = getByGroup_PrevAndNext(session, statisticEntity,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StatisticEntity getByGroup_PrevAndNext(Session session,
		StatisticEntity statisticEntity, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STATISTICENTITY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(StatisticEntityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(statisticEntity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StatisticEntity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the statistic entities.
	 *
	 * @return the statistic entities
	 * @throws SystemException if a system exception occurred
	 */
	public List<StatisticEntity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<StatisticEntity> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<StatisticEntity> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<StatisticEntity> list = (List<StatisticEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STATISTICENTITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATISTICENTITY.concat(StatisticEntityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<StatisticEntity>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<StatisticEntity>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the statistic entities where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (StatisticEntity statisticEntity : findByGroup(groupId)) {
			remove(statisticEntity);
		}
	}

	/**
	 * Removes all the statistic entities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (StatisticEntity statisticEntity : findAll()) {
			remove(statisticEntity);
		}
	}

	/**
	 * Returns the number of statistic entities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching statistic entities
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STATISTICENTITY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of statistic entities.
	 *
	 * @return the number of statistic entities
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STATISTICENTITY);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the statistic entity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StatisticEntity>> listenersList = new ArrayList<ModelListener<StatisticEntity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StatisticEntity>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(StatisticEntityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = StatisticEntityPersistence.class)
	protected StatisticEntityPersistence statisticEntityPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_STATISTICENTITY = "SELECT statisticEntity FROM StatisticEntity statisticEntity";
	private static final String _SQL_SELECT_STATISTICENTITY_WHERE = "SELECT statisticEntity FROM StatisticEntity statisticEntity WHERE ";
	private static final String _SQL_COUNT_STATISTICENTITY = "SELECT COUNT(statisticEntity) FROM StatisticEntity statisticEntity";
	private static final String _SQL_COUNT_STATISTICENTITY_WHERE = "SELECT COUNT(statisticEntity) FROM StatisticEntity statisticEntity WHERE ";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "statisticEntity.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statisticEntity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StatisticEntity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StatisticEntity exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StatisticEntityPersistenceImpl.class);
	private static StatisticEntity _nullStatisticEntity = new StatisticEntityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StatisticEntity> toCacheModel() {
				return _nullStatisticEntityCacheModel;
			}
		};

	private static CacheModel<StatisticEntity> _nullStatisticEntityCacheModel = new CacheModel<StatisticEntity>() {
			public StatisticEntity toEntityModel() {
				return _nullStatisticEntity;
			}
		};
}