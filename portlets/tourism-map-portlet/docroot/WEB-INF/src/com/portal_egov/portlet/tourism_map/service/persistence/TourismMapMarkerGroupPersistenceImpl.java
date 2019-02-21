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

package com.portal_egov.portlet.tourism_map.service.persistence;

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

import com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException;
import com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup;
import com.portal_egov.portlet.tourism_map.model.impl.TourismMapMarkerGroupImpl;
import com.portal_egov.portlet.tourism_map.model.impl.TourismMapMarkerGroupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tourism map marker group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see TourismMapMarkerGroupPersistence
 * @see TourismMapMarkerGroupUtil
 * @generated
 */
public class TourismMapMarkerGroupPersistenceImpl extends BasePersistenceImpl<TourismMapMarkerGroup>
	implements TourismMapMarkerGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TourismMapMarkerGroupUtil} to access the tourism map marker group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TourismMapMarkerGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerGroupModelImpl.FINDER_CACHE_ENABLED,
			TourismMapMarkerGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerGroupModelImpl.FINDER_CACHE_ENABLED,
			TourismMapMarkerGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			TourismMapMarkerGroupModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerGroupModelImpl.FINDER_CACHE_ENABLED,
			TourismMapMarkerGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerGroupModelImpl.FINDER_CACHE_ENABLED,
			TourismMapMarkerGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			TourismMapMarkerGroupModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerGroupModelImpl.FINDER_CACHE_ENABLED,
			TourismMapMarkerGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerGroupModelImpl.FINDER_CACHE_ENABLED,
			TourismMapMarkerGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the tourism map marker group in the entity cache if it is enabled.
	 *
	 * @param tourismMapMarkerGroup the tourism map marker group
	 */
	public void cacheResult(TourismMapMarkerGroup tourismMapMarkerGroup) {
		EntityCacheUtil.putResult(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerGroupImpl.class,
			tourismMapMarkerGroup.getPrimaryKey(), tourismMapMarkerGroup);

		tourismMapMarkerGroup.resetOriginalValues();
	}

	/**
	 * Caches the tourism map marker groups in the entity cache if it is enabled.
	 *
	 * @param tourismMapMarkerGroups the tourism map marker groups
	 */
	public void cacheResult(List<TourismMapMarkerGroup> tourismMapMarkerGroups) {
		for (TourismMapMarkerGroup tourismMapMarkerGroup : tourismMapMarkerGroups) {
			if (EntityCacheUtil.getResult(
						TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
						TourismMapMarkerGroupImpl.class,
						tourismMapMarkerGroup.getPrimaryKey()) == null) {
				cacheResult(tourismMapMarkerGroup);
			}
			else {
				tourismMapMarkerGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tourism map marker groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TourismMapMarkerGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TourismMapMarkerGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tourism map marker group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TourismMapMarkerGroup tourismMapMarkerGroup) {
		EntityCacheUtil.removeResult(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerGroupImpl.class,
			tourismMapMarkerGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TourismMapMarkerGroup> tourismMapMarkerGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TourismMapMarkerGroup tourismMapMarkerGroup : tourismMapMarkerGroups) {
			EntityCacheUtil.removeResult(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
				TourismMapMarkerGroupImpl.class,
				tourismMapMarkerGroup.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tourism map marker group with the primary key. Does not add the tourism map marker group to the database.
	 *
	 * @param markerGroupId the primary key for the new tourism map marker group
	 * @return the new tourism map marker group
	 */
	public TourismMapMarkerGroup create(long markerGroupId) {
		TourismMapMarkerGroup tourismMapMarkerGroup = new TourismMapMarkerGroupImpl();

		tourismMapMarkerGroup.setNew(true);
		tourismMapMarkerGroup.setPrimaryKey(markerGroupId);

		return tourismMapMarkerGroup;
	}

	/**
	 * Removes the tourism map marker group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param markerGroupId the primary key of the tourism map marker group
	 * @return the tourism map marker group that was removed
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a tourism map marker group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarkerGroup remove(long markerGroupId)
		throws NoSuchTourismMapMarkerGroupException, SystemException {
		return remove(Long.valueOf(markerGroupId));
	}

	/**
	 * Removes the tourism map marker group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tourism map marker group
	 * @return the tourism map marker group that was removed
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a tourism map marker group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TourismMapMarkerGroup remove(Serializable primaryKey)
		throws NoSuchTourismMapMarkerGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TourismMapMarkerGroup tourismMapMarkerGroup = (TourismMapMarkerGroup)session.get(TourismMapMarkerGroupImpl.class,
					primaryKey);

			if (tourismMapMarkerGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTourismMapMarkerGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tourismMapMarkerGroup);
		}
		catch (NoSuchTourismMapMarkerGroupException nsee) {
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
	protected TourismMapMarkerGroup removeImpl(
		TourismMapMarkerGroup tourismMapMarkerGroup) throws SystemException {
		tourismMapMarkerGroup = toUnwrappedModel(tourismMapMarkerGroup);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tourismMapMarkerGroup);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tourismMapMarkerGroup);

		return tourismMapMarkerGroup;
	}

	@Override
	public TourismMapMarkerGroup updateImpl(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup tourismMapMarkerGroup,
		boolean merge) throws SystemException {
		tourismMapMarkerGroup = toUnwrappedModel(tourismMapMarkerGroup);

		boolean isNew = tourismMapMarkerGroup.isNew();

		TourismMapMarkerGroupModelImpl tourismMapMarkerGroupModelImpl = (TourismMapMarkerGroupModelImpl)tourismMapMarkerGroup;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tourismMapMarkerGroup, merge);

			tourismMapMarkerGroup.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TourismMapMarkerGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tourismMapMarkerGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tourismMapMarkerGroupModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(tourismMapMarkerGroupModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((tourismMapMarkerGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tourismMapMarkerGroupModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(tourismMapMarkerGroupModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerGroupImpl.class,
			tourismMapMarkerGroup.getPrimaryKey(), tourismMapMarkerGroup);

		return tourismMapMarkerGroup;
	}

	protected TourismMapMarkerGroup toUnwrappedModel(
		TourismMapMarkerGroup tourismMapMarkerGroup) {
		if (tourismMapMarkerGroup instanceof TourismMapMarkerGroupImpl) {
			return tourismMapMarkerGroup;
		}

		TourismMapMarkerGroupImpl tourismMapMarkerGroupImpl = new TourismMapMarkerGroupImpl();

		tourismMapMarkerGroupImpl.setNew(tourismMapMarkerGroup.isNew());
		tourismMapMarkerGroupImpl.setPrimaryKey(tourismMapMarkerGroup.getPrimaryKey());

		tourismMapMarkerGroupImpl.setMarkerGroupId(tourismMapMarkerGroup.getMarkerGroupId());
		tourismMapMarkerGroupImpl.setCompanyId(tourismMapMarkerGroup.getCompanyId());
		tourismMapMarkerGroupImpl.setGroupId(tourismMapMarkerGroup.getGroupId());
		tourismMapMarkerGroupImpl.setUserId(tourismMapMarkerGroup.getUserId());
		tourismMapMarkerGroupImpl.setUserName(tourismMapMarkerGroup.getUserName());
		tourismMapMarkerGroupImpl.setCreateDate(tourismMapMarkerGroup.getCreateDate());
		tourismMapMarkerGroupImpl.setModifiedDate(tourismMapMarkerGroup.getModifiedDate());
		tourismMapMarkerGroupImpl.setMarkerGroupName(tourismMapMarkerGroup.getMarkerGroupName());
		tourismMapMarkerGroupImpl.setMarkerGroupInfo(tourismMapMarkerGroup.getMarkerGroupInfo());

		return tourismMapMarkerGroupImpl;
	}

	/**
	 * Returns the tourism map marker group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tourism map marker group
	 * @return the tourism map marker group
	 * @throws com.liferay.portal.NoSuchModelException if a tourism map marker group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TourismMapMarkerGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tourism map marker group with the primary key or throws a {@link com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException} if it could not be found.
	 *
	 * @param markerGroupId the primary key of the tourism map marker group
	 * @return the tourism map marker group
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a tourism map marker group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarkerGroup findByPrimaryKey(long markerGroupId)
		throws NoSuchTourismMapMarkerGroupException, SystemException {
		TourismMapMarkerGroup tourismMapMarkerGroup = fetchByPrimaryKey(markerGroupId);

		if (tourismMapMarkerGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + markerGroupId);
			}

			throw new NoSuchTourismMapMarkerGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				markerGroupId);
		}

		return tourismMapMarkerGroup;
	}

	/**
	 * Returns the tourism map marker group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tourism map marker group
	 * @return the tourism map marker group, or <code>null</code> if a tourism map marker group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TourismMapMarkerGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tourism map marker group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param markerGroupId the primary key of the tourism map marker group
	 * @return the tourism map marker group, or <code>null</code> if a tourism map marker group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarkerGroup fetchByPrimaryKey(long markerGroupId)
		throws SystemException {
		TourismMapMarkerGroup tourismMapMarkerGroup = (TourismMapMarkerGroup)EntityCacheUtil.getResult(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
				TourismMapMarkerGroupImpl.class, markerGroupId);

		if (tourismMapMarkerGroup == _nullTourismMapMarkerGroup) {
			return null;
		}

		if (tourismMapMarkerGroup == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tourismMapMarkerGroup = (TourismMapMarkerGroup)session.get(TourismMapMarkerGroupImpl.class,
						Long.valueOf(markerGroupId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tourismMapMarkerGroup != null) {
					cacheResult(tourismMapMarkerGroup);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TourismMapMarkerGroupModelImpl.ENTITY_CACHE_ENABLED,
						TourismMapMarkerGroupImpl.class, markerGroupId,
						_nullTourismMapMarkerGroup);
				}

				closeSession(session);
			}
		}

		return tourismMapMarkerGroup;
	}

	/**
	 * Returns all the tourism map marker groups where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching tourism map marker groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarkerGroup> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the tourism map marker groups where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tourism map marker groups
	 * @param end the upper bound of the range of tourism map marker groups (not inclusive)
	 * @return the range of matching tourism map marker groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarkerGroup> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tourism map marker groups where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tourism map marker groups
	 * @param end the upper bound of the range of tourism map marker groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tourism map marker groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarkerGroup> findByCompany(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<TourismMapMarkerGroup> list = (List<TourismMapMarkerGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TourismMapMarkerGroup tourismMapMarkerGroup : list) {
				if ((companyId != tourismMapMarkerGroup.getCompanyId())) {
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

			query.append(_SQL_SELECT_TOURISMMAPMARKERGROUP_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TourismMapMarkerGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<TourismMapMarkerGroup>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first tourism map marker group in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tourism map marker group
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a matching tourism map marker group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarkerGroup findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerGroupException, SystemException {
		TourismMapMarkerGroup tourismMapMarkerGroup = fetchByCompany_First(companyId,
				orderByComparator);

		if (tourismMapMarkerGroup != null) {
			return tourismMapMarkerGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTourismMapMarkerGroupException(msg.toString());
	}

	/**
	 * Returns the first tourism map marker group in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tourism map marker group, or <code>null</code> if a matching tourism map marker group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarkerGroup fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TourismMapMarkerGroup> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tourism map marker group in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tourism map marker group
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a matching tourism map marker group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarkerGroup findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerGroupException, SystemException {
		TourismMapMarkerGroup tourismMapMarkerGroup = fetchByCompany_Last(companyId,
				orderByComparator);

		if (tourismMapMarkerGroup != null) {
			return tourismMapMarkerGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTourismMapMarkerGroupException(msg.toString());
	}

	/**
	 * Returns the last tourism map marker group in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tourism map marker group, or <code>null</code> if a matching tourism map marker group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarkerGroup fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<TourismMapMarkerGroup> list = findByCompany(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tourism map marker groups before and after the current tourism map marker group in the ordered set where companyId = &#63;.
	 *
	 * @param markerGroupId the primary key of the current tourism map marker group
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tourism map marker group
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a tourism map marker group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarkerGroup[] findByCompany_PrevAndNext(
		long markerGroupId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerGroupException, SystemException {
		TourismMapMarkerGroup tourismMapMarkerGroup = findByPrimaryKey(markerGroupId);

		Session session = null;

		try {
			session = openSession();

			TourismMapMarkerGroup[] array = new TourismMapMarkerGroupImpl[3];

			array[0] = getByCompany_PrevAndNext(session, tourismMapMarkerGroup,
					companyId, orderByComparator, true);

			array[1] = tourismMapMarkerGroup;

			array[2] = getByCompany_PrevAndNext(session, tourismMapMarkerGroup,
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

	protected TourismMapMarkerGroup getByCompany_PrevAndNext(Session session,
		TourismMapMarkerGroup tourismMapMarkerGroup, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOURISMMAPMARKERGROUP_WHERE);

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
			query.append(TourismMapMarkerGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tourismMapMarkerGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TourismMapMarkerGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tourism map marker groups where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tourism map marker groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarkerGroup> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tourism map marker groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tourism map marker groups
	 * @param end the upper bound of the range of tourism map marker groups (not inclusive)
	 * @return the range of matching tourism map marker groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarkerGroup> findByGroup(long groupId, int start,
		int end) throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tourism map marker groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tourism map marker groups
	 * @param end the upper bound of the range of tourism map marker groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tourism map marker groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarkerGroup> findByGroup(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<TourismMapMarkerGroup> list = (List<TourismMapMarkerGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TourismMapMarkerGroup tourismMapMarkerGroup : list) {
				if ((groupId != tourismMapMarkerGroup.getGroupId())) {
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

			query.append(_SQL_SELECT_TOURISMMAPMARKERGROUP_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TourismMapMarkerGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<TourismMapMarkerGroup>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first tourism map marker group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tourism map marker group
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a matching tourism map marker group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarkerGroup findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerGroupException, SystemException {
		TourismMapMarkerGroup tourismMapMarkerGroup = fetchByGroup_First(groupId,
				orderByComparator);

		if (tourismMapMarkerGroup != null) {
			return tourismMapMarkerGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTourismMapMarkerGroupException(msg.toString());
	}

	/**
	 * Returns the first tourism map marker group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tourism map marker group, or <code>null</code> if a matching tourism map marker group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarkerGroup fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TourismMapMarkerGroup> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tourism map marker group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tourism map marker group
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a matching tourism map marker group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarkerGroup findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerGroupException, SystemException {
		TourismMapMarkerGroup tourismMapMarkerGroup = fetchByGroup_Last(groupId,
				orderByComparator);

		if (tourismMapMarkerGroup != null) {
			return tourismMapMarkerGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTourismMapMarkerGroupException(msg.toString());
	}

	/**
	 * Returns the last tourism map marker group in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tourism map marker group, or <code>null</code> if a matching tourism map marker group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarkerGroup fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<TourismMapMarkerGroup> list = findByGroup(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tourism map marker groups before and after the current tourism map marker group in the ordered set where groupId = &#63;.
	 *
	 * @param markerGroupId the primary key of the current tourism map marker group
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tourism map marker group
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a tourism map marker group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarkerGroup[] findByGroup_PrevAndNext(long markerGroupId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerGroupException, SystemException {
		TourismMapMarkerGroup tourismMapMarkerGroup = findByPrimaryKey(markerGroupId);

		Session session = null;

		try {
			session = openSession();

			TourismMapMarkerGroup[] array = new TourismMapMarkerGroupImpl[3];

			array[0] = getByGroup_PrevAndNext(session, tourismMapMarkerGroup,
					groupId, orderByComparator, true);

			array[1] = tourismMapMarkerGroup;

			array[2] = getByGroup_PrevAndNext(session, tourismMapMarkerGroup,
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

	protected TourismMapMarkerGroup getByGroup_PrevAndNext(Session session,
		TourismMapMarkerGroup tourismMapMarkerGroup, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOURISMMAPMARKERGROUP_WHERE);

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
			query.append(TourismMapMarkerGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tourismMapMarkerGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TourismMapMarkerGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tourism map marker groups that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tourism map marker groups that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarkerGroup> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the tourism map marker groups that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tourism map marker groups
	 * @param end the upper bound of the range of tourism map marker groups (not inclusive)
	 * @return the range of matching tourism map marker groups that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarkerGroup> filterFindByGroup(long groupId,
		int start, int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tourism map marker groups that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tourism map marker groups
	 * @param end the upper bound of the range of tourism map marker groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tourism map marker groups that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarkerGroup> filterFindByGroup(long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_TOURISMMAPMARKERGROUP_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TOURISMMAPMARKERGROUP_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOURISMMAPMARKERGROUP_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TourismMapMarkerGroupModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TourismMapMarkerGroupModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TourismMapMarkerGroup.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS,
					TourismMapMarkerGroupImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE,
					TourismMapMarkerGroupImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<TourismMapMarkerGroup>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the tourism map marker groups before and after the current tourism map marker group in the ordered set of tourism map marker groups that the user has permission to view where groupId = &#63;.
	 *
	 * @param markerGroupId the primary key of the current tourism map marker group
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tourism map marker group
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a tourism map marker group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarkerGroup[] filterFindByGroup_PrevAndNext(
		long markerGroupId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerGroupException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(markerGroupId, groupId,
				orderByComparator);
		}

		TourismMapMarkerGroup tourismMapMarkerGroup = findByPrimaryKey(markerGroupId);

		Session session = null;

		try {
			session = openSession();

			TourismMapMarkerGroup[] array = new TourismMapMarkerGroupImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session,
					tourismMapMarkerGroup, groupId, orderByComparator, true);

			array[1] = tourismMapMarkerGroup;

			array[2] = filterGetByGroup_PrevAndNext(session,
					tourismMapMarkerGroup, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TourismMapMarkerGroup filterGetByGroup_PrevAndNext(
		Session session, TourismMapMarkerGroup tourismMapMarkerGroup,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOURISMMAPMARKERGROUP_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TOURISMMAPMARKERGROUP_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOURISMMAPMARKERGROUP_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TourismMapMarkerGroupModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TourismMapMarkerGroupModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TourismMapMarkerGroup.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TourismMapMarkerGroupImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TourismMapMarkerGroupImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tourismMapMarkerGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TourismMapMarkerGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tourism map marker groups.
	 *
	 * @return the tourism map marker groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarkerGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tourism map marker groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tourism map marker groups
	 * @param end the upper bound of the range of tourism map marker groups (not inclusive)
	 * @return the range of tourism map marker groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarkerGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tourism map marker groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tourism map marker groups
	 * @param end the upper bound of the range of tourism map marker groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tourism map marker groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarkerGroup> findAll(int start, int end,
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

		List<TourismMapMarkerGroup> list = (List<TourismMapMarkerGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TOURISMMAPMARKERGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TOURISMMAPMARKERGROUP.concat(TourismMapMarkerGroupModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TourismMapMarkerGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TourismMapMarkerGroup>)QueryUtil.list(q,
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
	 * Removes all the tourism map marker groups where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (TourismMapMarkerGroup tourismMapMarkerGroup : findByCompany(
				companyId)) {
			remove(tourismMapMarkerGroup);
		}
	}

	/**
	 * Removes all the tourism map marker groups where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (TourismMapMarkerGroup tourismMapMarkerGroup : findByGroup(groupId)) {
			remove(tourismMapMarkerGroup);
		}
	}

	/**
	 * Removes all the tourism map marker groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TourismMapMarkerGroup tourismMapMarkerGroup : findAll()) {
			remove(tourismMapMarkerGroup);
		}
	}

	/**
	 * Returns the number of tourism map marker groups where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching tourism map marker groups
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOURISMMAPMARKERGROUP_WHERE);

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
	 * Returns the number of tourism map marker groups where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tourism map marker groups
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOURISMMAPMARKERGROUP_WHERE);

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
	 * Returns the number of tourism map marker groups that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tourism map marker groups that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_TOURISMMAPMARKERGROUP_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TourismMapMarkerGroup.class.getName(),
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
	 * Returns the number of tourism map marker groups.
	 *
	 * @return the number of tourism map marker groups
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TOURISMMAPMARKERGROUP);

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
	 * Initializes the tourism map marker group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TourismMapMarkerGroup>> listenersList = new ArrayList<ModelListener<TourismMapMarkerGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TourismMapMarkerGroup>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TourismMapMarkerGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = TourismMapMarkerPersistence.class)
	protected TourismMapMarkerPersistence tourismMapMarkerPersistence;
	@BeanReference(type = TourismMapMarkerGroupPersistence.class)
	protected TourismMapMarkerGroupPersistence tourismMapMarkerGroupPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TOURISMMAPMARKERGROUP = "SELECT tourismMapMarkerGroup FROM TourismMapMarkerGroup tourismMapMarkerGroup";
	private static final String _SQL_SELECT_TOURISMMAPMARKERGROUP_WHERE = "SELECT tourismMapMarkerGroup FROM TourismMapMarkerGroup tourismMapMarkerGroup WHERE ";
	private static final String _SQL_COUNT_TOURISMMAPMARKERGROUP = "SELECT COUNT(tourismMapMarkerGroup) FROM TourismMapMarkerGroup tourismMapMarkerGroup";
	private static final String _SQL_COUNT_TOURISMMAPMARKERGROUP_WHERE = "SELECT COUNT(tourismMapMarkerGroup) FROM TourismMapMarkerGroup tourismMapMarkerGroup WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "tourismMapMarkerGroup.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "tourismMapMarkerGroup.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "tourismMapMarkerGroup.markerGroupId";
	private static final String _FILTER_SQL_SELECT_TOURISMMAPMARKERGROUP_WHERE = "SELECT DISTINCT {tourismMapMarkerGroup.*} FROM TourismMapMarkerGroup tourismMapMarkerGroup WHERE ";
	private static final String _FILTER_SQL_SELECT_TOURISMMAPMARKERGROUP_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {TourismMapMarkerGroup.*} FROM (SELECT DISTINCT tourismMapMarkerGroup.markerGroupId FROM TourismMapMarkerGroup tourismMapMarkerGroup WHERE ";
	private static final String _FILTER_SQL_SELECT_TOURISMMAPMARKERGROUP_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN TourismMapMarkerGroup ON TEMP_TABLE.markerGroupId = TourismMapMarkerGroup.markerGroupId";
	private static final String _FILTER_SQL_COUNT_TOURISMMAPMARKERGROUP_WHERE = "SELECT COUNT(DISTINCT tourismMapMarkerGroup.markerGroupId) AS COUNT_VALUE FROM TourismMapMarkerGroup tourismMapMarkerGroup WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "tourismMapMarkerGroup";
	private static final String _FILTER_ENTITY_TABLE = "TourismMapMarkerGroup";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tourismMapMarkerGroup.";
	private static final String _ORDER_BY_ENTITY_TABLE = "TourismMapMarkerGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TourismMapMarkerGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TourismMapMarkerGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TourismMapMarkerGroupPersistenceImpl.class);
	private static TourismMapMarkerGroup _nullTourismMapMarkerGroup = new TourismMapMarkerGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TourismMapMarkerGroup> toCacheModel() {
				return _nullTourismMapMarkerGroupCacheModel;
			}
		};

	private static CacheModel<TourismMapMarkerGroup> _nullTourismMapMarkerGroupCacheModel =
		new CacheModel<TourismMapMarkerGroup>() {
			public TourismMapMarkerGroup toEntityModel() {
				return _nullTourismMapMarkerGroup;
			}
		};
}