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

package com.portal_egov.portlet.citymaps.service.persistence;

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

import com.portal_egov.portlet.citymaps.NoSuchCityMapException;
import com.portal_egov.portlet.citymaps.model.CityMap;
import com.portal_egov.portlet.citymaps.model.impl.CityMapImpl;
import com.portal_egov.portlet.citymaps.model.impl.CityMapModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the city map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see CityMapPersistence
 * @see CityMapUtil
 * @generated
 */
public class CityMapPersistenceImpl extends BasePersistenceImpl<CityMap>
	implements CityMapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CityMapUtil} to access the city map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CityMapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapModelImpl.FINDER_CACHE_ENABLED, CityMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapModelImpl.FINDER_CACHE_ENABLED, CityMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			CityMapModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapModelImpl.FINDER_CACHE_ENABLED, CityMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapModelImpl.FINDER_CACHE_ENABLED, CityMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			CityMapModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapModelImpl.FINDER_CACHE_ENABLED, CityMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapModelImpl.FINDER_CACHE_ENABLED, CityMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { Long.class.getName() },
			CityMapModelImpl.MAPTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapModelImpl.FINDER_CACHE_ENABLED, CityMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapModelImpl.FINDER_CACHE_ENABLED, CityMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the city map in the entity cache if it is enabled.
	 *
	 * @param cityMap the city map
	 */
	public void cacheResult(CityMap cityMap) {
		EntityCacheUtil.putResult(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapImpl.class, cityMap.getPrimaryKey(), cityMap);

		cityMap.resetOriginalValues();
	}

	/**
	 * Caches the city maps in the entity cache if it is enabled.
	 *
	 * @param cityMaps the city maps
	 */
	public void cacheResult(List<CityMap> cityMaps) {
		for (CityMap cityMap : cityMaps) {
			if (EntityCacheUtil.getResult(
						CityMapModelImpl.ENTITY_CACHE_ENABLED,
						CityMapImpl.class, cityMap.getPrimaryKey()) == null) {
				cacheResult(cityMap);
			}
			else {
				cityMap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all city maps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CityMapImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CityMapImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the city map.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CityMap cityMap) {
		EntityCacheUtil.removeResult(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapImpl.class, cityMap.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CityMap> cityMaps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CityMap cityMap : cityMaps) {
			EntityCacheUtil.removeResult(CityMapModelImpl.ENTITY_CACHE_ENABLED,
				CityMapImpl.class, cityMap.getPrimaryKey());
		}
	}

	/**
	 * Creates a new city map with the primary key. Does not add the city map to the database.
	 *
	 * @param mapId the primary key for the new city map
	 * @return the new city map
	 */
	public CityMap create(long mapId) {
		CityMap cityMap = new CityMapImpl();

		cityMap.setNew(true);
		cityMap.setPrimaryKey(mapId);

		return cityMap;
	}

	/**
	 * Removes the city map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapId the primary key of the city map
	 * @return the city map that was removed
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap remove(long mapId)
		throws NoSuchCityMapException, SystemException {
		return remove(Long.valueOf(mapId));
	}

	/**
	 * Removes the city map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the city map
	 * @return the city map that was removed
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CityMap remove(Serializable primaryKey)
		throws NoSuchCityMapException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CityMap cityMap = (CityMap)session.get(CityMapImpl.class, primaryKey);

			if (cityMap == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCityMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cityMap);
		}
		catch (NoSuchCityMapException nsee) {
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
	protected CityMap removeImpl(CityMap cityMap) throws SystemException {
		cityMap = toUnwrappedModel(cityMap);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, cityMap);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(cityMap);

		return cityMap;
	}

	@Override
	public CityMap updateImpl(
		com.portal_egov.portlet.citymaps.model.CityMap cityMap, boolean merge)
		throws SystemException {
		cityMap = toUnwrappedModel(cityMap);

		boolean isNew = cityMap.isNew();

		CityMapModelImpl cityMapModelImpl = (CityMapModelImpl)cityMap;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cityMap, merge);

			cityMap.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CityMapModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cityMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(cityMapModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(cityMapModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((cityMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(cityMapModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { Long.valueOf(cityMapModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((cityMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(cityMapModelImpl.getOriginalMapTypeId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] {
						Long.valueOf(cityMapModelImpl.getMapTypeId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(CityMapModelImpl.ENTITY_CACHE_ENABLED,
			CityMapImpl.class, cityMap.getPrimaryKey(), cityMap);

		return cityMap;
	}

	protected CityMap toUnwrappedModel(CityMap cityMap) {
		if (cityMap instanceof CityMapImpl) {
			return cityMap;
		}

		CityMapImpl cityMapImpl = new CityMapImpl();

		cityMapImpl.setNew(cityMap.isNew());
		cityMapImpl.setPrimaryKey(cityMap.getPrimaryKey());

		cityMapImpl.setMapId(cityMap.getMapId());
		cityMapImpl.setCompanyId(cityMap.getCompanyId());
		cityMapImpl.setGroupId(cityMap.getGroupId());
		cityMapImpl.setUserId(cityMap.getUserId());
		cityMapImpl.setUserName(cityMap.getUserName());
		cityMapImpl.setCreateDate(cityMap.getCreateDate());
		cityMapImpl.setModifiedDate(cityMap.getModifiedDate());
		cityMapImpl.setMapTypeId(cityMap.getMapTypeId());
		cityMapImpl.setMapImageId(cityMap.getMapImageId());
		cityMapImpl.setMapName(cityMap.getMapName());
		cityMapImpl.setMapDesc(cityMap.getMapDesc());
		cityMapImpl.setMapSumary(cityMap.getMapSumary());

		return cityMapImpl;
	}

	/**
	 * Returns the city map with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the city map
	 * @return the city map
	 * @throws com.liferay.portal.NoSuchModelException if a city map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CityMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the city map with the primary key or throws a {@link com.portal_egov.portlet.citymaps.NoSuchCityMapException} if it could not be found.
	 *
	 * @param mapId the primary key of the city map
	 * @return the city map
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap findByPrimaryKey(long mapId)
		throws NoSuchCityMapException, SystemException {
		CityMap cityMap = fetchByPrimaryKey(mapId);

		if (cityMap == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + mapId);
			}

			throw new NoSuchCityMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				mapId);
		}

		return cityMap;
	}

	/**
	 * Returns the city map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the city map
	 * @return the city map, or <code>null</code> if a city map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CityMap fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the city map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mapId the primary key of the city map
	 * @return the city map, or <code>null</code> if a city map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap fetchByPrimaryKey(long mapId) throws SystemException {
		CityMap cityMap = (CityMap)EntityCacheUtil.getResult(CityMapModelImpl.ENTITY_CACHE_ENABLED,
				CityMapImpl.class, mapId);

		if (cityMap == _nullCityMap) {
			return null;
		}

		if (cityMap == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				cityMap = (CityMap)session.get(CityMapImpl.class,
						Long.valueOf(mapId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (cityMap != null) {
					cacheResult(cityMap);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CityMapModelImpl.ENTITY_CACHE_ENABLED,
						CityMapImpl.class, mapId, _nullCityMap);
				}

				closeSession(session);
			}
		}

		return cityMap;
	}

	/**
	 * Returns all the city maps where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching city maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the city maps where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of city maps
	 * @param end the upper bound of the range of city maps (not inclusive)
	 * @return the range of matching city maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the city maps where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of city maps
	 * @param end the upper bound of the range of city maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching city maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> findByCompany(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<CityMap> list = (List<CityMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CityMap cityMap : list) {
				if ((companyId != cityMap.getCompanyId())) {
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

			query.append(_SQL_SELECT_CITYMAP_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CityMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<CityMap>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first city map in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city map
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapException, SystemException {
		CityMap cityMap = fetchByCompany_First(companyId, orderByComparator);

		if (cityMap != null) {
			return cityMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCityMapException(msg.toString());
	}

	/**
	 * Returns the first city map in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city map, or <code>null</code> if a matching city map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CityMap> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last city map in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city map
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapException, SystemException {
		CityMap cityMap = fetchByCompany_Last(companyId, orderByComparator);

		if (cityMap != null) {
			return cityMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCityMapException(msg.toString());
	}

	/**
	 * Returns the last city map in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city map, or <code>null</code> if a matching city map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<CityMap> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the city maps before and after the current city map in the ordered set where companyId = &#63;.
	 *
	 * @param mapId the primary key of the current city map
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city map
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap[] findByCompany_PrevAndNext(long mapId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapException, SystemException {
		CityMap cityMap = findByPrimaryKey(mapId);

		Session session = null;

		try {
			session = openSession();

			CityMap[] array = new CityMapImpl[3];

			array[0] = getByCompany_PrevAndNext(session, cityMap, companyId,
					orderByComparator, true);

			array[1] = cityMap;

			array[2] = getByCompany_PrevAndNext(session, cityMap, companyId,
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

	protected CityMap getByCompany_PrevAndNext(Session session,
		CityMap cityMap, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITYMAP_WHERE);

		query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

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
			query.append(CityMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cityMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CityMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the city maps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching city maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the city maps where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of city maps
	 * @param end the upper bound of the range of city maps (not inclusive)
	 * @return the range of matching city maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the city maps where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of city maps
	 * @param end the upper bound of the range of city maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching city maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> findByGroup(long groupId, int start, int end,
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

		List<CityMap> list = (List<CityMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CityMap cityMap : list) {
				if ((groupId != cityMap.getGroupId())) {
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

			query.append(_SQL_SELECT_CITYMAP_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CityMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<CityMap>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first city map in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city map
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapException, SystemException {
		CityMap cityMap = fetchByGroup_First(groupId, orderByComparator);

		if (cityMap != null) {
			return cityMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCityMapException(msg.toString());
	}

	/**
	 * Returns the first city map in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city map, or <code>null</code> if a matching city map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CityMap> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last city map in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city map
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapException, SystemException {
		CityMap cityMap = fetchByGroup_Last(groupId, orderByComparator);

		if (cityMap != null) {
			return cityMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCityMapException(msg.toString());
	}

	/**
	 * Returns the last city map in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city map, or <code>null</code> if a matching city map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<CityMap> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the city maps before and after the current city map in the ordered set where groupId = &#63;.
	 *
	 * @param mapId the primary key of the current city map
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city map
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap[] findByGroup_PrevAndNext(long mapId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapException, SystemException {
		CityMap cityMap = findByPrimaryKey(mapId);

		Session session = null;

		try {
			session = openSession();

			CityMap[] array = new CityMapImpl[3];

			array[0] = getByGroup_PrevAndNext(session, cityMap, groupId,
					orderByComparator, true);

			array[1] = cityMap;

			array[2] = getByGroup_PrevAndNext(session, cityMap, groupId,
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

	protected CityMap getByGroup_PrevAndNext(Session session, CityMap cityMap,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITYMAP_WHERE);

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
			query.append(CityMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cityMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CityMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the city maps that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching city maps that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the city maps that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of city maps
	 * @param end the upper bound of the range of city maps (not inclusive)
	 * @return the range of matching city maps that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the city maps that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of city maps
	 * @param end the upper bound of the range of city maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching city maps that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> filterFindByGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_CITYMAP_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITYMAP_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITYMAP_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CityMapModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CityMapModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CityMap.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CityMapImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CityMapImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<CityMap>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the city maps before and after the current city map in the ordered set of city maps that the user has permission to view where groupId = &#63;.
	 *
	 * @param mapId the primary key of the current city map
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city map
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap[] filterFindByGroup_PrevAndNext(long mapId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(mapId, groupId, orderByComparator);
		}

		CityMap cityMap = findByPrimaryKey(mapId);

		Session session = null;

		try {
			session = openSession();

			CityMap[] array = new CityMapImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, cityMap, groupId,
					orderByComparator, true);

			array[1] = cityMap;

			array[2] = filterGetByGroup_PrevAndNext(session, cityMap, groupId,
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

	protected CityMap filterGetByGroup_PrevAndNext(Session session,
		CityMap cityMap, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITYMAP_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITYMAP_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITYMAP_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CityMapModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CityMapModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CityMap.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CityMapImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CityMapImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cityMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CityMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the city maps where mapTypeId = &#63;.
	 *
	 * @param mapTypeId the map type ID
	 * @return the matching city maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> findByType(long mapTypeId) throws SystemException {
		return findByType(mapTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the city maps where mapTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param mapTypeId the map type ID
	 * @param start the lower bound of the range of city maps
	 * @param end the upper bound of the range of city maps (not inclusive)
	 * @return the range of matching city maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> findByType(long mapTypeId, int start, int end)
		throws SystemException {
		return findByType(mapTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the city maps where mapTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param mapTypeId the map type ID
	 * @param start the lower bound of the range of city maps
	 * @param end the upper bound of the range of city maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching city maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> findByType(long mapTypeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { mapTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { mapTypeId, start, end, orderByComparator };
		}

		List<CityMap> list = (List<CityMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CityMap cityMap : list) {
				if ((mapTypeId != cityMap.getMapTypeId())) {
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

			query.append(_SQL_SELECT_CITYMAP_WHERE);

			query.append(_FINDER_COLUMN_TYPE_MAPTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CityMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mapTypeId);

				list = (List<CityMap>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first city map in the ordered set where mapTypeId = &#63;.
	 *
	 * @param mapTypeId the map type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city map
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap findByType_First(long mapTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapException, SystemException {
		CityMap cityMap = fetchByType_First(mapTypeId, orderByComparator);

		if (cityMap != null) {
			return cityMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mapTypeId=");
		msg.append(mapTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCityMapException(msg.toString());
	}

	/**
	 * Returns the first city map in the ordered set where mapTypeId = &#63;.
	 *
	 * @param mapTypeId the map type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city map, or <code>null</code> if a matching city map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap fetchByType_First(long mapTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CityMap> list = findByType(mapTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last city map in the ordered set where mapTypeId = &#63;.
	 *
	 * @param mapTypeId the map type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city map
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap findByType_Last(long mapTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapException, SystemException {
		CityMap cityMap = fetchByType_Last(mapTypeId, orderByComparator);

		if (cityMap != null) {
			return cityMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mapTypeId=");
		msg.append(mapTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCityMapException(msg.toString());
	}

	/**
	 * Returns the last city map in the ordered set where mapTypeId = &#63;.
	 *
	 * @param mapTypeId the map type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city map, or <code>null</code> if a matching city map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap fetchByType_Last(long mapTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByType(mapTypeId);

		List<CityMap> list = findByType(mapTypeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the city maps before and after the current city map in the ordered set where mapTypeId = &#63;.
	 *
	 * @param mapId the primary key of the current city map
	 * @param mapTypeId the map type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city map
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMap[] findByType_PrevAndNext(long mapId, long mapTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapException, SystemException {
		CityMap cityMap = findByPrimaryKey(mapId);

		Session session = null;

		try {
			session = openSession();

			CityMap[] array = new CityMapImpl[3];

			array[0] = getByType_PrevAndNext(session, cityMap, mapTypeId,
					orderByComparator, true);

			array[1] = cityMap;

			array[2] = getByType_PrevAndNext(session, cityMap, mapTypeId,
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

	protected CityMap getByType_PrevAndNext(Session session, CityMap cityMap,
		long mapTypeId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITYMAP_WHERE);

		query.append(_FINDER_COLUMN_TYPE_MAPTYPEID_2);

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
			query.append(CityMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mapTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cityMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CityMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the city maps.
	 *
	 * @return the city maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the city maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of city maps
	 * @param end the upper bound of the range of city maps (not inclusive)
	 * @return the range of city maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the city maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of city maps
	 * @param end the upper bound of the range of city maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of city maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMap> findAll(int start, int end,
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

		List<CityMap> list = (List<CityMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CITYMAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CITYMAP.concat(CityMapModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CityMap>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CityMap>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the city maps where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (CityMap cityMap : findByCompany(companyId)) {
			remove(cityMap);
		}
	}

	/**
	 * Removes all the city maps where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (CityMap cityMap : findByGroup(groupId)) {
			remove(cityMap);
		}
	}

	/**
	 * Removes all the city maps where mapTypeId = &#63; from the database.
	 *
	 * @param mapTypeId the map type ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByType(long mapTypeId) throws SystemException {
		for (CityMap cityMap : findByType(mapTypeId)) {
			remove(cityMap);
		}
	}

	/**
	 * Removes all the city maps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CityMap cityMap : findAll()) {
			remove(cityMap);
		}
	}

	/**
	 * Returns the number of city maps where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching city maps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITYMAP_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of city maps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching city maps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITYMAP_WHERE);

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
	 * Returns the number of city maps that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching city maps that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CITYMAP_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CityMap.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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
	 * Returns the number of city maps where mapTypeId = &#63;.
	 *
	 * @param mapTypeId the map type ID
	 * @return the number of matching city maps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByType(long mapTypeId) throws SystemException {
		Object[] finderArgs = new Object[] { mapTypeId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TYPE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITYMAP_WHERE);

			query.append(_FINDER_COLUMN_TYPE_MAPTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mapTypeId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of city maps.
	 *
	 * @return the number of city maps
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CITYMAP);

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
	 * Initializes the city map persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.citymaps.model.CityMap")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CityMap>> listenersList = new ArrayList<ModelListener<CityMap>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CityMap>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CityMapImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CityMapPersistence.class)
	protected CityMapPersistence cityMapPersistence;
	@BeanReference(type = CityMapTypePersistence.class)
	protected CityMapTypePersistence cityMapTypePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CITYMAP = "SELECT cityMap FROM CityMap cityMap";
	private static final String _SQL_SELECT_CITYMAP_WHERE = "SELECT cityMap FROM CityMap cityMap WHERE ";
	private static final String _SQL_COUNT_CITYMAP = "SELECT COUNT(cityMap) FROM CityMap cityMap";
	private static final String _SQL_COUNT_CITYMAP_WHERE = "SELECT COUNT(cityMap) FROM CityMap cityMap WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "cityMap.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "cityMap.groupId = ?";
	private static final String _FINDER_COLUMN_TYPE_MAPTYPEID_2 = "cityMap.mapTypeId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "cityMap.mapId";
	private static final String _FILTER_SQL_SELECT_CITYMAP_WHERE = "SELECT DISTINCT {cityMap.*} FROM CityMap cityMap WHERE ";
	private static final String _FILTER_SQL_SELECT_CITYMAP_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {CityMap.*} FROM (SELECT DISTINCT cityMap.mapId FROM CityMap cityMap WHERE ";
	private static final String _FILTER_SQL_SELECT_CITYMAP_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN CityMap ON TEMP_TABLE.mapId = CityMap.mapId";
	private static final String _FILTER_SQL_COUNT_CITYMAP_WHERE = "SELECT COUNT(DISTINCT cityMap.mapId) AS COUNT_VALUE FROM CityMap cityMap WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "cityMap";
	private static final String _FILTER_ENTITY_TABLE = "CityMap";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cityMap.";
	private static final String _ORDER_BY_ENTITY_TABLE = "CityMap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CityMap exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CityMap exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CityMapPersistenceImpl.class);
	private static CityMap _nullCityMap = new CityMapImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CityMap> toCacheModel() {
				return _nullCityMapCacheModel;
			}
		};

	private static CacheModel<CityMap> _nullCityMapCacheModel = new CacheModel<CityMap>() {
			public CityMap toEntityModel() {
				return _nullCityMap;
			}
		};
}