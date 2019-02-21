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

import com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException;
import com.portal_egov.portlet.citymaps.model.CityMapType;
import com.portal_egov.portlet.citymaps.model.impl.CityMapTypeImpl;
import com.portal_egov.portlet.citymaps.model.impl.CityMapTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the city map type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see CityMapTypePersistence
 * @see CityMapTypeUtil
 * @generated
 */
public class CityMapTypePersistenceImpl extends BasePersistenceImpl<CityMapType>
	implements CityMapTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CityMapTypeUtil} to access the city map type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CityMapTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
			CityMapTypeModelImpl.FINDER_CACHE_ENABLED, CityMapTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
			CityMapTypeModelImpl.FINDER_CACHE_ENABLED, CityMapTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			CityMapTypeModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
			CityMapTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
			CityMapTypeModelImpl.FINDER_CACHE_ENABLED, CityMapTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
			CityMapTypeModelImpl.FINDER_CACHE_ENABLED, CityMapTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			CityMapTypeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
			CityMapTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
			CityMapTypeModelImpl.FINDER_CACHE_ENABLED, CityMapTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
			CityMapTypeModelImpl.FINDER_CACHE_ENABLED, CityMapTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
			CityMapTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the city map type in the entity cache if it is enabled.
	 *
	 * @param cityMapType the city map type
	 */
	public void cacheResult(CityMapType cityMapType) {
		EntityCacheUtil.putResult(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
			CityMapTypeImpl.class, cityMapType.getPrimaryKey(), cityMapType);

		cityMapType.resetOriginalValues();
	}

	/**
	 * Caches the city map types in the entity cache if it is enabled.
	 *
	 * @param cityMapTypes the city map types
	 */
	public void cacheResult(List<CityMapType> cityMapTypes) {
		for (CityMapType cityMapType : cityMapTypes) {
			if (EntityCacheUtil.getResult(
						CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
						CityMapTypeImpl.class, cityMapType.getPrimaryKey()) == null) {
				cacheResult(cityMapType);
			}
			else {
				cityMapType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all city map types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CityMapTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CityMapTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the city map type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CityMapType cityMapType) {
		EntityCacheUtil.removeResult(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
			CityMapTypeImpl.class, cityMapType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CityMapType> cityMapTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CityMapType cityMapType : cityMapTypes) {
			EntityCacheUtil.removeResult(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
				CityMapTypeImpl.class, cityMapType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new city map type with the primary key. Does not add the city map type to the database.
	 *
	 * @param typeId the primary key for the new city map type
	 * @return the new city map type
	 */
	public CityMapType create(long typeId) {
		CityMapType cityMapType = new CityMapTypeImpl();

		cityMapType.setNew(true);
		cityMapType.setPrimaryKey(typeId);

		return cityMapType;
	}

	/**
	 * Removes the city map type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeId the primary key of the city map type
	 * @return the city map type that was removed
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a city map type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMapType remove(long typeId)
		throws NoSuchCityMapTypeException, SystemException {
		return remove(Long.valueOf(typeId));
	}

	/**
	 * Removes the city map type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the city map type
	 * @return the city map type that was removed
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a city map type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CityMapType remove(Serializable primaryKey)
		throws NoSuchCityMapTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CityMapType cityMapType = (CityMapType)session.get(CityMapTypeImpl.class,
					primaryKey);

			if (cityMapType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCityMapTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cityMapType);
		}
		catch (NoSuchCityMapTypeException nsee) {
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
	protected CityMapType removeImpl(CityMapType cityMapType)
		throws SystemException {
		cityMapType = toUnwrappedModel(cityMapType);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, cityMapType);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(cityMapType);

		return cityMapType;
	}

	@Override
	public CityMapType updateImpl(
		com.portal_egov.portlet.citymaps.model.CityMapType cityMapType,
		boolean merge) throws SystemException {
		cityMapType = toUnwrappedModel(cityMapType);

		boolean isNew = cityMapType.isNew();

		CityMapTypeModelImpl cityMapTypeModelImpl = (CityMapTypeModelImpl)cityMapType;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cityMapType, merge);

			cityMapType.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CityMapTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cityMapTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(cityMapTypeModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(cityMapTypeModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((cityMapTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(cityMapTypeModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(cityMapTypeModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
			CityMapTypeImpl.class, cityMapType.getPrimaryKey(), cityMapType);

		return cityMapType;
	}

	protected CityMapType toUnwrappedModel(CityMapType cityMapType) {
		if (cityMapType instanceof CityMapTypeImpl) {
			return cityMapType;
		}

		CityMapTypeImpl cityMapTypeImpl = new CityMapTypeImpl();

		cityMapTypeImpl.setNew(cityMapType.isNew());
		cityMapTypeImpl.setPrimaryKey(cityMapType.getPrimaryKey());

		cityMapTypeImpl.setTypeId(cityMapType.getTypeId());
		cityMapTypeImpl.setCompanyId(cityMapType.getCompanyId());
		cityMapTypeImpl.setGroupId(cityMapType.getGroupId());
		cityMapTypeImpl.setUserId(cityMapType.getUserId());
		cityMapTypeImpl.setUserName(cityMapType.getUserName());
		cityMapTypeImpl.setCreateDate(cityMapType.getCreateDate());
		cityMapTypeImpl.setModifiedDate(cityMapType.getModifiedDate());
		cityMapTypeImpl.setTypeName(cityMapType.getTypeName());
		cityMapTypeImpl.setTypeDesc(cityMapType.getTypeDesc());

		return cityMapTypeImpl;
	}

	/**
	 * Returns the city map type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the city map type
	 * @return the city map type
	 * @throws com.liferay.portal.NoSuchModelException if a city map type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CityMapType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the city map type with the primary key or throws a {@link com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException} if it could not be found.
	 *
	 * @param typeId the primary key of the city map type
	 * @return the city map type
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a city map type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMapType findByPrimaryKey(long typeId)
		throws NoSuchCityMapTypeException, SystemException {
		CityMapType cityMapType = fetchByPrimaryKey(typeId);

		if (cityMapType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + typeId);
			}

			throw new NoSuchCityMapTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				typeId);
		}

		return cityMapType;
	}

	/**
	 * Returns the city map type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the city map type
	 * @return the city map type, or <code>null</code> if a city map type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CityMapType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the city map type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeId the primary key of the city map type
	 * @return the city map type, or <code>null</code> if a city map type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMapType fetchByPrimaryKey(long typeId) throws SystemException {
		CityMapType cityMapType = (CityMapType)EntityCacheUtil.getResult(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
				CityMapTypeImpl.class, typeId);

		if (cityMapType == _nullCityMapType) {
			return null;
		}

		if (cityMapType == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				cityMapType = (CityMapType)session.get(CityMapTypeImpl.class,
						Long.valueOf(typeId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (cityMapType != null) {
					cacheResult(cityMapType);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CityMapTypeModelImpl.ENTITY_CACHE_ENABLED,
						CityMapTypeImpl.class, typeId, _nullCityMapType);
				}

				closeSession(session);
			}
		}

		return cityMapType;
	}

	/**
	 * Returns all the city map types where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching city map types
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMapType> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the city map types where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of city map types
	 * @param end the upper bound of the range of city map types (not inclusive)
	 * @return the range of matching city map types
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMapType> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the city map types where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of city map types
	 * @param end the upper bound of the range of city map types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching city map types
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMapType> findByCompany(long companyId, int start, int end,
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

		List<CityMapType> list = (List<CityMapType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CityMapType cityMapType : list) {
				if ((companyId != cityMapType.getCompanyId())) {
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

			query.append(_SQL_SELECT_CITYMAPTYPE_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CityMapTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<CityMapType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first city map type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city map type
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a matching city map type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMapType findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapTypeException, SystemException {
		CityMapType cityMapType = fetchByCompany_First(companyId,
				orderByComparator);

		if (cityMapType != null) {
			return cityMapType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCityMapTypeException(msg.toString());
	}

	/**
	 * Returns the first city map type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city map type, or <code>null</code> if a matching city map type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMapType fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CityMapType> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last city map type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city map type
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a matching city map type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMapType findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapTypeException, SystemException {
		CityMapType cityMapType = fetchByCompany_Last(companyId,
				orderByComparator);

		if (cityMapType != null) {
			return cityMapType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCityMapTypeException(msg.toString());
	}

	/**
	 * Returns the last city map type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city map type, or <code>null</code> if a matching city map type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMapType fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<CityMapType> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the city map types before and after the current city map type in the ordered set where companyId = &#63;.
	 *
	 * @param typeId the primary key of the current city map type
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city map type
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a city map type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMapType[] findByCompany_PrevAndNext(long typeId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapTypeException, SystemException {
		CityMapType cityMapType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			CityMapType[] array = new CityMapTypeImpl[3];

			array[0] = getByCompany_PrevAndNext(session, cityMapType,
					companyId, orderByComparator, true);

			array[1] = cityMapType;

			array[2] = getByCompany_PrevAndNext(session, cityMapType,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CityMapType getByCompany_PrevAndNext(Session session,
		CityMapType cityMapType, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITYMAPTYPE_WHERE);

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
			query.append(CityMapTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cityMapType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CityMapType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the city map types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching city map types
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMapType> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the city map types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of city map types
	 * @param end the upper bound of the range of city map types (not inclusive)
	 * @return the range of matching city map types
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMapType> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the city map types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of city map types
	 * @param end the upper bound of the range of city map types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching city map types
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMapType> findByGroup(long groupId, int start, int end,
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

		List<CityMapType> list = (List<CityMapType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CityMapType cityMapType : list) {
				if ((groupId != cityMapType.getGroupId())) {
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

			query.append(_SQL_SELECT_CITYMAPTYPE_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CityMapTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<CityMapType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first city map type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city map type
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a matching city map type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMapType findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapTypeException, SystemException {
		CityMapType cityMapType = fetchByGroup_First(groupId, orderByComparator);

		if (cityMapType != null) {
			return cityMapType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCityMapTypeException(msg.toString());
	}

	/**
	 * Returns the first city map type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city map type, or <code>null</code> if a matching city map type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMapType fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CityMapType> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last city map type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city map type
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a matching city map type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMapType findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapTypeException, SystemException {
		CityMapType cityMapType = fetchByGroup_Last(groupId, orderByComparator);

		if (cityMapType != null) {
			return cityMapType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCityMapTypeException(msg.toString());
	}

	/**
	 * Returns the last city map type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city map type, or <code>null</code> if a matching city map type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMapType fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<CityMapType> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the city map types before and after the current city map type in the ordered set where groupId = &#63;.
	 *
	 * @param typeId the primary key of the current city map type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city map type
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a city map type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMapType[] findByGroup_PrevAndNext(long typeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCityMapTypeException, SystemException {
		CityMapType cityMapType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			CityMapType[] array = new CityMapTypeImpl[3];

			array[0] = getByGroup_PrevAndNext(session, cityMapType, groupId,
					orderByComparator, true);

			array[1] = cityMapType;

			array[2] = getByGroup_PrevAndNext(session, cityMapType, groupId,
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

	protected CityMapType getByGroup_PrevAndNext(Session session,
		CityMapType cityMapType, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITYMAPTYPE_WHERE);

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
			query.append(CityMapTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cityMapType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CityMapType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the city map types that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching city map types that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMapType> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the city map types that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of city map types
	 * @param end the upper bound of the range of city map types (not inclusive)
	 * @return the range of matching city map types that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMapType> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the city map types that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of city map types
	 * @param end the upper bound of the range of city map types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching city map types that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMapType> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_CITYMAPTYPE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITYMAPTYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITYMAPTYPE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CityMapTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CityMapTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CityMapType.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CityMapTypeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CityMapTypeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<CityMapType>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the city map types before and after the current city map type in the ordered set of city map types that the user has permission to view where groupId = &#63;.
	 *
	 * @param typeId the primary key of the current city map type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city map type
	 * @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a city map type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CityMapType[] filterFindByGroup_PrevAndNext(long typeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCityMapTypeException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(typeId, groupId, orderByComparator);
		}

		CityMapType cityMapType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			CityMapType[] array = new CityMapTypeImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, cityMapType,
					groupId, orderByComparator, true);

			array[1] = cityMapType;

			array[2] = filterGetByGroup_PrevAndNext(session, cityMapType,
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

	protected CityMapType filterGetByGroup_PrevAndNext(Session session,
		CityMapType cityMapType, long groupId,
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
			query.append(_FILTER_SQL_SELECT_CITYMAPTYPE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITYMAPTYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITYMAPTYPE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CityMapTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CityMapTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CityMapType.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CityMapTypeImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CityMapTypeImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cityMapType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CityMapType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the city map types.
	 *
	 * @return the city map types
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMapType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the city map types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of city map types
	 * @param end the upper bound of the range of city map types (not inclusive)
	 * @return the range of city map types
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMapType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the city map types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of city map types
	 * @param end the upper bound of the range of city map types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of city map types
	 * @throws SystemException if a system exception occurred
	 */
	public List<CityMapType> findAll(int start, int end,
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

		List<CityMapType> list = (List<CityMapType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CITYMAPTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CITYMAPTYPE.concat(CityMapTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CityMapType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CityMapType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the city map types where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (CityMapType cityMapType : findByCompany(companyId)) {
			remove(cityMapType);
		}
	}

	/**
	 * Removes all the city map types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (CityMapType cityMapType : findByGroup(groupId)) {
			remove(cityMapType);
		}
	}

	/**
	 * Removes all the city map types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CityMapType cityMapType : findAll()) {
			remove(cityMapType);
		}
	}

	/**
	 * Returns the number of city map types where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching city map types
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITYMAPTYPE_WHERE);

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
	 * Returns the number of city map types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching city map types
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITYMAPTYPE_WHERE);

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
	 * Returns the number of city map types that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching city map types that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CITYMAPTYPE_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CityMapType.class.getName(),
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
	 * Returns the number of city map types.
	 *
	 * @return the number of city map types
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CITYMAPTYPE);

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
	 * Initializes the city map type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.citymaps.model.CityMapType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CityMapType>> listenersList = new ArrayList<ModelListener<CityMapType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CityMapType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CityMapTypeImpl.class.getName());
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
	private static final String _SQL_SELECT_CITYMAPTYPE = "SELECT cityMapType FROM CityMapType cityMapType";
	private static final String _SQL_SELECT_CITYMAPTYPE_WHERE = "SELECT cityMapType FROM CityMapType cityMapType WHERE ";
	private static final String _SQL_COUNT_CITYMAPTYPE = "SELECT COUNT(cityMapType) FROM CityMapType cityMapType";
	private static final String _SQL_COUNT_CITYMAPTYPE_WHERE = "SELECT COUNT(cityMapType) FROM CityMapType cityMapType WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "cityMapType.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "cityMapType.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "cityMapType.typeId";
	private static final String _FILTER_SQL_SELECT_CITYMAPTYPE_WHERE = "SELECT DISTINCT {cityMapType.*} FROM CityMapType cityMapType WHERE ";
	private static final String _FILTER_SQL_SELECT_CITYMAPTYPE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {CityMapType.*} FROM (SELECT DISTINCT cityMapType.typeId FROM CityMapType cityMapType WHERE ";
	private static final String _FILTER_SQL_SELECT_CITYMAPTYPE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN CityMapType ON TEMP_TABLE.typeId = CityMapType.typeId";
	private static final String _FILTER_SQL_COUNT_CITYMAPTYPE_WHERE = "SELECT COUNT(DISTINCT cityMapType.typeId) AS COUNT_VALUE FROM CityMapType cityMapType WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "cityMapType";
	private static final String _FILTER_ENTITY_TABLE = "CityMapType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cityMapType.";
	private static final String _ORDER_BY_ENTITY_TABLE = "CityMapType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CityMapType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CityMapType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CityMapTypePersistenceImpl.class);
	private static CityMapType _nullCityMapType = new CityMapTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CityMapType> toCacheModel() {
				return _nullCityMapTypeCacheModel;
			}
		};

	private static CacheModel<CityMapType> _nullCityMapTypeCacheModel = new CacheModel<CityMapType>() {
			public CityMapType toEntityModel() {
				return _nullCityMapType;
			}
		};
}