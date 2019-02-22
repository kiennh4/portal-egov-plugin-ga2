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

package com.portal_egov.portlet.landprice.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.portal_egov.portlet.landprice.NoSuchLandLocationException;
import com.portal_egov.portlet.landprice.model.LandLocation;
import com.portal_egov.portlet.landprice.model.impl.LandLocationImpl;
import com.portal_egov.portlet.landprice.model.impl.LandLocationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the land location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see LandLocationPersistence
 * @see LandLocationUtil
 * @generated
 */
public class LandLocationPersistenceImpl extends BasePersistenceImpl<LandLocation>
	implements LandLocationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LandLocationUtil} to access the land location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LandLocationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
			LandLocationModelImpl.FINDER_CACHE_ENABLED, LandLocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
			LandLocationModelImpl.FINDER_CACHE_ENABLED, LandLocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			LandLocationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
			LandLocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTLOCATION =
		new FinderPath(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
			LandLocationModelImpl.FINDER_CACHE_ENABLED, LandLocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentLocation",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTLOCATION =
		new FinderPath(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
			LandLocationModelImpl.FINDER_CACHE_ENABLED, LandLocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentLocation",
			new String[] { Long.class.getName() },
			LandLocationModelImpl.PARENTLOCATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTLOCATION = new FinderPath(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
			LandLocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentLocation",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
			LandLocationModelImpl.FINDER_CACHE_ENABLED, LandLocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
			LandLocationModelImpl.FINDER_CACHE_ENABLED, LandLocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
			LandLocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the land location in the entity cache if it is enabled.
	 *
	 * @param landLocation the land location
	 */
	public void cacheResult(LandLocation landLocation) {
		EntityCacheUtil.putResult(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
			LandLocationImpl.class, landLocation.getPrimaryKey(), landLocation);

		landLocation.resetOriginalValues();
	}

	/**
	 * Caches the land locations in the entity cache if it is enabled.
	 *
	 * @param landLocations the land locations
	 */
	public void cacheResult(List<LandLocation> landLocations) {
		for (LandLocation landLocation : landLocations) {
			if (EntityCacheUtil.getResult(
						LandLocationModelImpl.ENTITY_CACHE_ENABLED,
						LandLocationImpl.class, landLocation.getPrimaryKey()) == null) {
				cacheResult(landLocation);
			}
			else {
				landLocation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all land locations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LandLocationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LandLocationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the land location.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LandLocation landLocation) {
		EntityCacheUtil.removeResult(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
			LandLocationImpl.class, landLocation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LandLocation> landLocations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LandLocation landLocation : landLocations) {
			EntityCacheUtil.removeResult(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
				LandLocationImpl.class, landLocation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new land location with the primary key. Does not add the land location to the database.
	 *
	 * @param locationId the primary key for the new land location
	 * @return the new land location
	 */
	public LandLocation create(long locationId) {
		LandLocation landLocation = new LandLocationImpl();

		landLocation.setNew(true);
		landLocation.setPrimaryKey(locationId);

		return landLocation;
	}

	/**
	 * Removes the land location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param locationId the primary key of the land location
	 * @return the land location that was removed
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a land location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandLocation remove(long locationId)
		throws NoSuchLandLocationException, SystemException {
		return remove(Long.valueOf(locationId));
	}

	/**
	 * Removes the land location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the land location
	 * @return the land location that was removed
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a land location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LandLocation remove(Serializable primaryKey)
		throws NoSuchLandLocationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LandLocation landLocation = (LandLocation)session.get(LandLocationImpl.class,
					primaryKey);

			if (landLocation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLandLocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(landLocation);
		}
		catch (NoSuchLandLocationException nsee) {
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
	protected LandLocation removeImpl(LandLocation landLocation)
		throws SystemException {
		landLocation = toUnwrappedModel(landLocation);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, landLocation);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(landLocation);

		return landLocation;
	}

	@Override
	public LandLocation updateImpl(
		com.portal_egov.portlet.landprice.model.LandLocation landLocation,
		boolean merge) throws SystemException {
		landLocation = toUnwrappedModel(landLocation);

		boolean isNew = landLocation.isNew();

		LandLocationModelImpl landLocationModelImpl = (LandLocationModelImpl)landLocation;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, landLocation, merge);

			landLocation.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LandLocationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((landLocationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(landLocationModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(landLocationModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((landLocationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTLOCATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(landLocationModelImpl.getOriginalParentLocationId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTLOCATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTLOCATION,
					args);

				args = new Object[] {
						Long.valueOf(landLocationModelImpl.getParentLocationId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTLOCATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTLOCATION,
					args);
			}
		}

		EntityCacheUtil.putResult(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
			LandLocationImpl.class, landLocation.getPrimaryKey(), landLocation);

		return landLocation;
	}

	protected LandLocation toUnwrappedModel(LandLocation landLocation) {
		if (landLocation instanceof LandLocationImpl) {
			return landLocation;
		}

		LandLocationImpl landLocationImpl = new LandLocationImpl();

		landLocationImpl.setNew(landLocation.isNew());
		landLocationImpl.setPrimaryKey(landLocation.getPrimaryKey());

		landLocationImpl.setLocationId(landLocation.getLocationId());
		landLocationImpl.setCompanyId(landLocation.getCompanyId());
		landLocationImpl.setGroupId(landLocation.getGroupId());
		landLocationImpl.setUserId(landLocation.getUserId());
		landLocationImpl.setUserName(landLocation.getUserName());
		landLocationImpl.setCreateDate(landLocation.getCreateDate());
		landLocationImpl.setModifiedDate(landLocation.getModifiedDate());
		landLocationImpl.setParentLocationId(landLocation.getParentLocationId());
		landLocationImpl.setLocationName(landLocation.getLocationName());
		landLocationImpl.setLocationInfo(landLocation.getLocationInfo());

		return landLocationImpl;
	}

	/**
	 * Returns the land location with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the land location
	 * @return the land location
	 * @throws com.liferay.portal.NoSuchModelException if a land location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LandLocation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the land location with the primary key or throws a {@link com.portal_egov.portlet.landprice.NoSuchLandLocationException} if it could not be found.
	 *
	 * @param locationId the primary key of the land location
	 * @return the land location
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a land location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandLocation findByPrimaryKey(long locationId)
		throws NoSuchLandLocationException, SystemException {
		LandLocation landLocation = fetchByPrimaryKey(locationId);

		if (landLocation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + locationId);
			}

			throw new NoSuchLandLocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				locationId);
		}

		return landLocation;
	}

	/**
	 * Returns the land location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the land location
	 * @return the land location, or <code>null</code> if a land location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LandLocation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the land location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param locationId the primary key of the land location
	 * @return the land location, or <code>null</code> if a land location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandLocation fetchByPrimaryKey(long locationId)
		throws SystemException {
		LandLocation landLocation = (LandLocation)EntityCacheUtil.getResult(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
				LandLocationImpl.class, locationId);

		if (landLocation == _nullLandLocation) {
			return null;
		}

		if (landLocation == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				landLocation = (LandLocation)session.get(LandLocationImpl.class,
						Long.valueOf(locationId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (landLocation != null) {
					cacheResult(landLocation);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LandLocationModelImpl.ENTITY_CACHE_ENABLED,
						LandLocationImpl.class, locationId, _nullLandLocation);
				}

				closeSession(session);
			}
		}

		return landLocation;
	}

	/**
	 * Returns all the land locations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching land locations
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandLocation> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the land locations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of land locations
	 * @param end the upper bound of the range of land locations (not inclusive)
	 * @return the range of matching land locations
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandLocation> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the land locations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of land locations
	 * @param end the upper bound of the range of land locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching land locations
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandLocation> findByGroup(long groupId, int start, int end,
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

		List<LandLocation> list = (List<LandLocation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LandLocation landLocation : list) {
				if ((groupId != landLocation.getGroupId())) {
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

			query.append(_SQL_SELECT_LANDLOCATION_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LandLocationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<LandLocation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first land location in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching land location
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a matching land location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandLocation findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLandLocationException, SystemException {
		LandLocation landLocation = fetchByGroup_First(groupId,
				orderByComparator);

		if (landLocation != null) {
			return landLocation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLandLocationException(msg.toString());
	}

	/**
	 * Returns the first land location in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching land location, or <code>null</code> if a matching land location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandLocation fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LandLocation> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last land location in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching land location
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a matching land location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandLocation findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLandLocationException, SystemException {
		LandLocation landLocation = fetchByGroup_Last(groupId, orderByComparator);

		if (landLocation != null) {
			return landLocation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLandLocationException(msg.toString());
	}

	/**
	 * Returns the last land location in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching land location, or <code>null</code> if a matching land location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandLocation fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<LandLocation> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the land locations before and after the current land location in the ordered set where groupId = &#63;.
	 *
	 * @param locationId the primary key of the current land location
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next land location
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a land location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandLocation[] findByGroup_PrevAndNext(long locationId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLandLocationException, SystemException {
		LandLocation landLocation = findByPrimaryKey(locationId);

		Session session = null;

		try {
			session = openSession();

			LandLocation[] array = new LandLocationImpl[3];

			array[0] = getByGroup_PrevAndNext(session, landLocation, groupId,
					orderByComparator, true);

			array[1] = landLocation;

			array[2] = getByGroup_PrevAndNext(session, landLocation, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LandLocation getByGroup_PrevAndNext(Session session,
		LandLocation landLocation, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LANDLOCATION_WHERE);

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
			query.append(LandLocationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(landLocation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LandLocation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the land locations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching land locations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandLocation> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the land locations that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of land locations
	 * @param end the upper bound of the range of land locations (not inclusive)
	 * @return the range of matching land locations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandLocation> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the land locations that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of land locations
	 * @param end the upper bound of the range of land locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching land locations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandLocation> filterFindByGroup(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LANDLOCATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LANDLOCATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LANDLOCATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(LandLocationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LandLocationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LandLocation.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LandLocationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LandLocationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<LandLocation>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the land locations before and after the current land location in the ordered set of land locations that the user has permission to view where groupId = &#63;.
	 *
	 * @param locationId the primary key of the current land location
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next land location
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a land location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandLocation[] filterFindByGroup_PrevAndNext(long locationId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLandLocationException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(locationId, groupId,
				orderByComparator);
		}

		LandLocation landLocation = findByPrimaryKey(locationId);

		Session session = null;

		try {
			session = openSession();

			LandLocation[] array = new LandLocationImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, landLocation,
					groupId, orderByComparator, true);

			array[1] = landLocation;

			array[2] = filterGetByGroup_PrevAndNext(session, landLocation,
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

	protected LandLocation filterGetByGroup_PrevAndNext(Session session,
		LandLocation landLocation, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LANDLOCATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LANDLOCATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LANDLOCATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(LandLocationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LandLocationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LandLocation.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, LandLocationImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, LandLocationImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(landLocation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LandLocation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the land locations where parentLocationId = &#63;.
	 *
	 * @param parentLocationId the parent location ID
	 * @return the matching land locations
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandLocation> findByParentLocation(long parentLocationId)
		throws SystemException {
		return findByParentLocation(parentLocationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the land locations where parentLocationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentLocationId the parent location ID
	 * @param start the lower bound of the range of land locations
	 * @param end the upper bound of the range of land locations (not inclusive)
	 * @return the range of matching land locations
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandLocation> findByParentLocation(long parentLocationId,
		int start, int end) throws SystemException {
		return findByParentLocation(parentLocationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the land locations where parentLocationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentLocationId the parent location ID
	 * @param start the lower bound of the range of land locations
	 * @param end the upper bound of the range of land locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching land locations
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandLocation> findByParentLocation(long parentLocationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTLOCATION;
			finderArgs = new Object[] { parentLocationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTLOCATION;
			finderArgs = new Object[] {
					parentLocationId,
					
					start, end, orderByComparator
				};
		}

		List<LandLocation> list = (List<LandLocation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LandLocation landLocation : list) {
				if ((parentLocationId != landLocation.getParentLocationId())) {
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

			query.append(_SQL_SELECT_LANDLOCATION_WHERE);

			query.append(_FINDER_COLUMN_PARENTLOCATION_PARENTLOCATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LandLocationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentLocationId);

				list = (List<LandLocation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first land location in the ordered set where parentLocationId = &#63;.
	 *
	 * @param parentLocationId the parent location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching land location
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a matching land location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandLocation findByParentLocation_First(long parentLocationId,
		OrderByComparator orderByComparator)
		throws NoSuchLandLocationException, SystemException {
		LandLocation landLocation = fetchByParentLocation_First(parentLocationId,
				orderByComparator);

		if (landLocation != null) {
			return landLocation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentLocationId=");
		msg.append(parentLocationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLandLocationException(msg.toString());
	}

	/**
	 * Returns the first land location in the ordered set where parentLocationId = &#63;.
	 *
	 * @param parentLocationId the parent location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching land location, or <code>null</code> if a matching land location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandLocation fetchByParentLocation_First(long parentLocationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LandLocation> list = findByParentLocation(parentLocationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last land location in the ordered set where parentLocationId = &#63;.
	 *
	 * @param parentLocationId the parent location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching land location
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a matching land location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandLocation findByParentLocation_Last(long parentLocationId,
		OrderByComparator orderByComparator)
		throws NoSuchLandLocationException, SystemException {
		LandLocation landLocation = fetchByParentLocation_Last(parentLocationId,
				orderByComparator);

		if (landLocation != null) {
			return landLocation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentLocationId=");
		msg.append(parentLocationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLandLocationException(msg.toString());
	}

	/**
	 * Returns the last land location in the ordered set where parentLocationId = &#63;.
	 *
	 * @param parentLocationId the parent location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching land location, or <code>null</code> if a matching land location could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandLocation fetchByParentLocation_Last(long parentLocationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParentLocation(parentLocationId);

		List<LandLocation> list = findByParentLocation(parentLocationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the land locations before and after the current land location in the ordered set where parentLocationId = &#63;.
	 *
	 * @param locationId the primary key of the current land location
	 * @param parentLocationId the parent location ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next land location
	 * @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a land location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LandLocation[] findByParentLocation_PrevAndNext(long locationId,
		long parentLocationId, OrderByComparator orderByComparator)
		throws NoSuchLandLocationException, SystemException {
		LandLocation landLocation = findByPrimaryKey(locationId);

		Session session = null;

		try {
			session = openSession();

			LandLocation[] array = new LandLocationImpl[3];

			array[0] = getByParentLocation_PrevAndNext(session, landLocation,
					parentLocationId, orderByComparator, true);

			array[1] = landLocation;

			array[2] = getByParentLocation_PrevAndNext(session, landLocation,
					parentLocationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LandLocation getByParentLocation_PrevAndNext(Session session,
		LandLocation landLocation, long parentLocationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LANDLOCATION_WHERE);

		query.append(_FINDER_COLUMN_PARENTLOCATION_PARENTLOCATIONID_2);

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
			query.append(LandLocationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentLocationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(landLocation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LandLocation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the land locations.
	 *
	 * @return the land locations
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandLocation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the land locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of land locations
	 * @param end the upper bound of the range of land locations (not inclusive)
	 * @return the range of land locations
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandLocation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the land locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of land locations
	 * @param end the upper bound of the range of land locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of land locations
	 * @throws SystemException if a system exception occurred
	 */
	public List<LandLocation> findAll(int start, int end,
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

		List<LandLocation> list = (List<LandLocation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LANDLOCATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LANDLOCATION.concat(LandLocationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LandLocation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LandLocation>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the land locations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (LandLocation landLocation : findByGroup(groupId)) {
			remove(landLocation);
		}
	}

	/**
	 * Removes all the land locations where parentLocationId = &#63; from the database.
	 *
	 * @param parentLocationId the parent location ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentLocation(long parentLocationId)
		throws SystemException {
		for (LandLocation landLocation : findByParentLocation(parentLocationId)) {
			remove(landLocation);
		}
	}

	/**
	 * Removes all the land locations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LandLocation landLocation : findAll()) {
			remove(landLocation);
		}
	}

	/**
	 * Returns the number of land locations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching land locations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LANDLOCATION_WHERE);

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
	 * Returns the number of land locations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching land locations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_LANDLOCATION_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LandLocation.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of land locations where parentLocationId = &#63;.
	 *
	 * @param parentLocationId the parent location ID
	 * @return the number of matching land locations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentLocation(long parentLocationId)
		throws SystemException {
		Object[] finderArgs = new Object[] { parentLocationId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTLOCATION,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LANDLOCATION_WHERE);

			query.append(_FINDER_COLUMN_PARENTLOCATION_PARENTLOCATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentLocationId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTLOCATION,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of land locations.
	 *
	 * @return the number of land locations
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LANDLOCATION);

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
	 * Initializes the land location persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.landprice.model.LandLocation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LandLocation>> listenersList = new ArrayList<ModelListener<LandLocation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LandLocation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LandLocationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LandLocationPersistence.class)
	protected LandLocationPersistence landLocationPersistence;
	@BeanReference(type = LandPricePersistence.class)
	protected LandPricePersistence landPricePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LANDLOCATION = "SELECT landLocation FROM LandLocation landLocation";
	private static final String _SQL_SELECT_LANDLOCATION_WHERE = "SELECT landLocation FROM LandLocation landLocation WHERE ";
	private static final String _SQL_COUNT_LANDLOCATION = "SELECT COUNT(landLocation) FROM LandLocation landLocation";
	private static final String _SQL_COUNT_LANDLOCATION_WHERE = "SELECT COUNT(landLocation) FROM LandLocation landLocation WHERE ";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "landLocation.groupId = ?";
	private static final String _FINDER_COLUMN_PARENTLOCATION_PARENTLOCATIONID_2 =
		"landLocation.parentLocationId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "landLocation.locationId";
	private static final String _FILTER_SQL_SELECT_LANDLOCATION_WHERE = "SELECT DISTINCT {landLocation.*} FROM LandLocation landLocation WHERE ";
	private static final String _FILTER_SQL_SELECT_LANDLOCATION_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {LandLocation.*} FROM (SELECT DISTINCT landLocation.locationId FROM LandLocation landLocation WHERE ";
	private static final String _FILTER_SQL_SELECT_LANDLOCATION_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN LandLocation ON TEMP_TABLE.locationId = LandLocation.locationId";
	private static final String _FILTER_SQL_COUNT_LANDLOCATION_WHERE = "SELECT COUNT(DISTINCT landLocation.locationId) AS COUNT_VALUE FROM LandLocation landLocation WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "landLocation";
	private static final String _FILTER_ENTITY_TABLE = "LandLocation";
	private static final String _ORDER_BY_ENTITY_ALIAS = "landLocation.";
	private static final String _ORDER_BY_ENTITY_TABLE = "LandLocation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LandLocation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LandLocation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LandLocationPersistenceImpl.class);
	private static LandLocation _nullLandLocation = new LandLocationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LandLocation> toCacheModel() {
				return _nullLandLocationCacheModel;
			}
		};

	private static CacheModel<LandLocation> _nullLandLocationCacheModel = new CacheModel<LandLocation>() {
			public LandLocation toEntityModel() {
				return _nullLandLocation;
			}
		};
}