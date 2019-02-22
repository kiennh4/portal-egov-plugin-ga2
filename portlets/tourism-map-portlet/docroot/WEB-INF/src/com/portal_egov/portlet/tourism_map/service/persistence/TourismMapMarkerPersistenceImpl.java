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

import com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException;
import com.portal_egov.portlet.tourism_map.model.TourismMapMarker;
import com.portal_egov.portlet.tourism_map.model.impl.TourismMapMarkerImpl;
import com.portal_egov.portlet.tourism_map.model.impl.TourismMapMarkerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tourism map marker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see TourismMapMarkerPersistence
 * @see TourismMapMarkerUtil
 * @generated
 */
public class TourismMapMarkerPersistenceImpl extends BasePersistenceImpl<TourismMapMarker>
	implements TourismMapMarkerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TourismMapMarkerUtil} to access the tourism map marker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TourismMapMarkerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerModelImpl.FINDER_CACHE_ENABLED,
			TourismMapMarkerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerModelImpl.FINDER_CACHE_ENABLED,
			TourismMapMarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			TourismMapMarkerModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerModelImpl.FINDER_CACHE_ENABLED,
			TourismMapMarkerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerModelImpl.FINDER_CACHE_ENABLED,
			TourismMapMarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			TourismMapMarkerModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONGROUP =
		new FinderPath(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerModelImpl.FINDER_CACHE_ENABLED,
			TourismMapMarkerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLocationGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONGROUP =
		new FinderPath(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerModelImpl.FINDER_CACHE_ENABLED,
			TourismMapMarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLocationGroup",
			new String[] { Long.class.getName() },
			TourismMapMarkerModelImpl.MARKERGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCATIONGROUP = new FinderPath(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLocationGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerModelImpl.FINDER_CACHE_ENABLED,
			TourismMapMarkerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerModelImpl.FINDER_CACHE_ENABLED,
			TourismMapMarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the tourism map marker in the entity cache if it is enabled.
	 *
	 * @param tourismMapMarker the tourism map marker
	 */
	public void cacheResult(TourismMapMarker tourismMapMarker) {
		EntityCacheUtil.putResult(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerImpl.class, tourismMapMarker.getPrimaryKey(),
			tourismMapMarker);

		tourismMapMarker.resetOriginalValues();
	}

	/**
	 * Caches the tourism map markers in the entity cache if it is enabled.
	 *
	 * @param tourismMapMarkers the tourism map markers
	 */
	public void cacheResult(List<TourismMapMarker> tourismMapMarkers) {
		for (TourismMapMarker tourismMapMarker : tourismMapMarkers) {
			if (EntityCacheUtil.getResult(
						TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
						TourismMapMarkerImpl.class,
						tourismMapMarker.getPrimaryKey()) == null) {
				cacheResult(tourismMapMarker);
			}
			else {
				tourismMapMarker.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tourism map markers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TourismMapMarkerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TourismMapMarkerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tourism map marker.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TourismMapMarker tourismMapMarker) {
		EntityCacheUtil.removeResult(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerImpl.class, tourismMapMarker.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TourismMapMarker> tourismMapMarkers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TourismMapMarker tourismMapMarker : tourismMapMarkers) {
			EntityCacheUtil.removeResult(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
				TourismMapMarkerImpl.class, tourismMapMarker.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tourism map marker with the primary key. Does not add the tourism map marker to the database.
	 *
	 * @param markerId the primary key for the new tourism map marker
	 * @return the new tourism map marker
	 */
	public TourismMapMarker create(long markerId) {
		TourismMapMarker tourismMapMarker = new TourismMapMarkerImpl();

		tourismMapMarker.setNew(true);
		tourismMapMarker.setPrimaryKey(markerId);

		return tourismMapMarker;
	}

	/**
	 * Removes the tourism map marker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param markerId the primary key of the tourism map marker
	 * @return the tourism map marker that was removed
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker remove(long markerId)
		throws NoSuchTourismMapMarkerException, SystemException {
		return remove(Long.valueOf(markerId));
	}

	/**
	 * Removes the tourism map marker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tourism map marker
	 * @return the tourism map marker that was removed
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TourismMapMarker remove(Serializable primaryKey)
		throws NoSuchTourismMapMarkerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TourismMapMarker tourismMapMarker = (TourismMapMarker)session.get(TourismMapMarkerImpl.class,
					primaryKey);

			if (tourismMapMarker == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTourismMapMarkerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tourismMapMarker);
		}
		catch (NoSuchTourismMapMarkerException nsee) {
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
	protected TourismMapMarker removeImpl(TourismMapMarker tourismMapMarker)
		throws SystemException {
		tourismMapMarker = toUnwrappedModel(tourismMapMarker);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tourismMapMarker);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tourismMapMarker);

		return tourismMapMarker;
	}

	@Override
	public TourismMapMarker updateImpl(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarker tourismMapMarker,
		boolean merge) throws SystemException {
		tourismMapMarker = toUnwrappedModel(tourismMapMarker);

		boolean isNew = tourismMapMarker.isNew();

		TourismMapMarkerModelImpl tourismMapMarkerModelImpl = (TourismMapMarkerModelImpl)tourismMapMarker;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tourismMapMarker, merge);

			tourismMapMarker.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TourismMapMarkerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tourismMapMarkerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tourismMapMarkerModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(tourismMapMarkerModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((tourismMapMarkerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tourismMapMarkerModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(tourismMapMarkerModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((tourismMapMarkerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tourismMapMarkerModelImpl.getOriginalMarkerGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONGROUP,
					args);

				args = new Object[] {
						Long.valueOf(tourismMapMarkerModelImpl.getMarkerGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCATIONGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TourismMapMarkerImpl.class, tourismMapMarker.getPrimaryKey(),
			tourismMapMarker);

		return tourismMapMarker;
	}

	protected TourismMapMarker toUnwrappedModel(
		TourismMapMarker tourismMapMarker) {
		if (tourismMapMarker instanceof TourismMapMarkerImpl) {
			return tourismMapMarker;
		}

		TourismMapMarkerImpl tourismMapMarkerImpl = new TourismMapMarkerImpl();

		tourismMapMarkerImpl.setNew(tourismMapMarker.isNew());
		tourismMapMarkerImpl.setPrimaryKey(tourismMapMarker.getPrimaryKey());

		tourismMapMarkerImpl.setMarkerId(tourismMapMarker.getMarkerId());
		tourismMapMarkerImpl.setCompanyId(tourismMapMarker.getCompanyId());
		tourismMapMarkerImpl.setGroupId(tourismMapMarker.getGroupId());
		tourismMapMarkerImpl.setUserId(tourismMapMarker.getUserId());
		tourismMapMarkerImpl.setUserName(tourismMapMarker.getUserName());
		tourismMapMarkerImpl.setCreateDate(tourismMapMarker.getCreateDate());
		tourismMapMarkerImpl.setModifiedDate(tourismMapMarker.getModifiedDate());
		tourismMapMarkerImpl.setMarkerGroupId(tourismMapMarker.getMarkerGroupId());
		tourismMapMarkerImpl.setMarkerTitle(tourismMapMarker.getMarkerTitle());
		tourismMapMarkerImpl.setMarkerInfo(tourismMapMarker.getMarkerInfo());
		tourismMapMarkerImpl.setMarkerAddress(tourismMapMarker.getMarkerAddress());
		tourismMapMarkerImpl.setMarkerImageId(tourismMapMarker.getMarkerImageId());
		tourismMapMarkerImpl.setMarkerLongitude(tourismMapMarker.getMarkerLongitude());
		tourismMapMarkerImpl.setMarkerLatitude(tourismMapMarker.getMarkerLatitude());

		return tourismMapMarkerImpl;
	}

	/**
	 * Returns the tourism map marker with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tourism map marker
	 * @return the tourism map marker
	 * @throws com.liferay.portal.NoSuchModelException if a tourism map marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TourismMapMarker findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tourism map marker with the primary key or throws a {@link com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException} if it could not be found.
	 *
	 * @param markerId the primary key of the tourism map marker
	 * @return the tourism map marker
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker findByPrimaryKey(long markerId)
		throws NoSuchTourismMapMarkerException, SystemException {
		TourismMapMarker tourismMapMarker = fetchByPrimaryKey(markerId);

		if (tourismMapMarker == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + markerId);
			}

			throw new NoSuchTourismMapMarkerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				markerId);
		}

		return tourismMapMarker;
	}

	/**
	 * Returns the tourism map marker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tourism map marker
	 * @return the tourism map marker, or <code>null</code> if a tourism map marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TourismMapMarker fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tourism map marker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param markerId the primary key of the tourism map marker
	 * @return the tourism map marker, or <code>null</code> if a tourism map marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker fetchByPrimaryKey(long markerId)
		throws SystemException {
		TourismMapMarker tourismMapMarker = (TourismMapMarker)EntityCacheUtil.getResult(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
				TourismMapMarkerImpl.class, markerId);

		if (tourismMapMarker == _nullTourismMapMarker) {
			return null;
		}

		if (tourismMapMarker == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tourismMapMarker = (TourismMapMarker)session.get(TourismMapMarkerImpl.class,
						Long.valueOf(markerId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tourismMapMarker != null) {
					cacheResult(tourismMapMarker);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TourismMapMarkerModelImpl.ENTITY_CACHE_ENABLED,
						TourismMapMarkerImpl.class, markerId,
						_nullTourismMapMarker);
				}

				closeSession(session);
			}
		}

		return tourismMapMarker;
	}

	/**
	 * Returns all the tourism map markers where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the tourism map markers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tourism map markers
	 * @param end the upper bound of the range of tourism map markers (not inclusive)
	 * @return the range of matching tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tourism map markers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tourism map markers
	 * @param end the upper bound of the range of tourism map markers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> findByCompany(long companyId, int start,
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

		List<TourismMapMarker> list = (List<TourismMapMarker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TourismMapMarker tourismMapMarker : list) {
				if ((companyId != tourismMapMarker.getCompanyId())) {
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

			query.append(_SQL_SELECT_TOURISMMAPMARKER_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TourismMapMarkerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<TourismMapMarker>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tourism map marker in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tourism map marker
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerException, SystemException {
		TourismMapMarker tourismMapMarker = fetchByCompany_First(companyId,
				orderByComparator);

		if (tourismMapMarker != null) {
			return tourismMapMarker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTourismMapMarkerException(msg.toString());
	}

	/**
	 * Returns the first tourism map marker in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TourismMapMarker> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tourism map marker in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tourism map marker
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerException, SystemException {
		TourismMapMarker tourismMapMarker = fetchByCompany_Last(companyId,
				orderByComparator);

		if (tourismMapMarker != null) {
			return tourismMapMarker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTourismMapMarkerException(msg.toString());
	}

	/**
	 * Returns the last tourism map marker in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<TourismMapMarker> list = findByCompany(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tourism map markers before and after the current tourism map marker in the ordered set where companyId = &#63;.
	 *
	 * @param markerId the primary key of the current tourism map marker
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tourism map marker
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker[] findByCompany_PrevAndNext(long markerId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerException, SystemException {
		TourismMapMarker tourismMapMarker = findByPrimaryKey(markerId);

		Session session = null;

		try {
			session = openSession();

			TourismMapMarker[] array = new TourismMapMarkerImpl[3];

			array[0] = getByCompany_PrevAndNext(session, tourismMapMarker,
					companyId, orderByComparator, true);

			array[1] = tourismMapMarker;

			array[2] = getByCompany_PrevAndNext(session, tourismMapMarker,
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

	protected TourismMapMarker getByCompany_PrevAndNext(Session session,
		TourismMapMarker tourismMapMarker, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOURISMMAPMARKER_WHERE);

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
			query.append(TourismMapMarkerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tourismMapMarker);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TourismMapMarker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tourism map markers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tourism map markers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tourism map markers
	 * @param end the upper bound of the range of tourism map markers (not inclusive)
	 * @return the range of matching tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tourism map markers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tourism map markers
	 * @param end the upper bound of the range of tourism map markers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> findByGroup(long groupId, int start, int end,
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

		List<TourismMapMarker> list = (List<TourismMapMarker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TourismMapMarker tourismMapMarker : list) {
				if ((groupId != tourismMapMarker.getGroupId())) {
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

			query.append(_SQL_SELECT_TOURISMMAPMARKER_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TourismMapMarkerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<TourismMapMarker>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tourism map marker in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tourism map marker
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerException, SystemException {
		TourismMapMarker tourismMapMarker = fetchByGroup_First(groupId,
				orderByComparator);

		if (tourismMapMarker != null) {
			return tourismMapMarker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTourismMapMarkerException(msg.toString());
	}

	/**
	 * Returns the first tourism map marker in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TourismMapMarker> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tourism map marker in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tourism map marker
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerException, SystemException {
		TourismMapMarker tourismMapMarker = fetchByGroup_Last(groupId,
				orderByComparator);

		if (tourismMapMarker != null) {
			return tourismMapMarker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTourismMapMarkerException(msg.toString());
	}

	/**
	 * Returns the last tourism map marker in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<TourismMapMarker> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tourism map markers before and after the current tourism map marker in the ordered set where groupId = &#63;.
	 *
	 * @param markerId the primary key of the current tourism map marker
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tourism map marker
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker[] findByGroup_PrevAndNext(long markerId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerException, SystemException {
		TourismMapMarker tourismMapMarker = findByPrimaryKey(markerId);

		Session session = null;

		try {
			session = openSession();

			TourismMapMarker[] array = new TourismMapMarkerImpl[3];

			array[0] = getByGroup_PrevAndNext(session, tourismMapMarker,
					groupId, orderByComparator, true);

			array[1] = tourismMapMarker;

			array[2] = getByGroup_PrevAndNext(session, tourismMapMarker,
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

	protected TourismMapMarker getByGroup_PrevAndNext(Session session,
		TourismMapMarker tourismMapMarker, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOURISMMAPMARKER_WHERE);

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
			query.append(TourismMapMarkerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tourismMapMarker);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TourismMapMarker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tourism map markers that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tourism map markers that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the tourism map markers that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tourism map markers
	 * @param end the upper bound of the range of tourism map markers (not inclusive)
	 * @return the range of matching tourism map markers that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tourism map markers that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tourism map markers
	 * @param end the upper bound of the range of tourism map markers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tourism map markers that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_TOURISMMAPMARKER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TOURISMMAPMARKER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOURISMMAPMARKER_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TourismMapMarkerModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TourismMapMarkerModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TourismMapMarker.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TourismMapMarkerImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TourismMapMarkerImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<TourismMapMarker>)QueryUtil.list(q, getDialect(),
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
	 * Returns the tourism map markers before and after the current tourism map marker in the ordered set of tourism map markers that the user has permission to view where groupId = &#63;.
	 *
	 * @param markerId the primary key of the current tourism map marker
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tourism map marker
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker[] filterFindByGroup_PrevAndNext(long markerId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(markerId, groupId, orderByComparator);
		}

		TourismMapMarker tourismMapMarker = findByPrimaryKey(markerId);

		Session session = null;

		try {
			session = openSession();

			TourismMapMarker[] array = new TourismMapMarkerImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, tourismMapMarker,
					groupId, orderByComparator, true);

			array[1] = tourismMapMarker;

			array[2] = filterGetByGroup_PrevAndNext(session, tourismMapMarker,
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

	protected TourismMapMarker filterGetByGroup_PrevAndNext(Session session,
		TourismMapMarker tourismMapMarker, long groupId,
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
			query.append(_FILTER_SQL_SELECT_TOURISMMAPMARKER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TOURISMMAPMARKER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOURISMMAPMARKER_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TourismMapMarkerModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TourismMapMarkerModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TourismMapMarker.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TourismMapMarkerImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TourismMapMarkerImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tourismMapMarker);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TourismMapMarker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tourism map markers where markerGroupId = &#63;.
	 *
	 * @param markerGroupId the marker group ID
	 * @return the matching tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> findByLocationGroup(long markerGroupId)
		throws SystemException {
		return findByLocationGroup(markerGroupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tourism map markers where markerGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param markerGroupId the marker group ID
	 * @param start the lower bound of the range of tourism map markers
	 * @param end the upper bound of the range of tourism map markers (not inclusive)
	 * @return the range of matching tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> findByLocationGroup(long markerGroupId,
		int start, int end) throws SystemException {
		return findByLocationGroup(markerGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tourism map markers where markerGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param markerGroupId the marker group ID
	 * @param start the lower bound of the range of tourism map markers
	 * @param end the upper bound of the range of tourism map markers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> findByLocationGroup(long markerGroupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCATIONGROUP;
			finderArgs = new Object[] { markerGroupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCATIONGROUP;
			finderArgs = new Object[] {
					markerGroupId,
					
					start, end, orderByComparator
				};
		}

		List<TourismMapMarker> list = (List<TourismMapMarker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TourismMapMarker tourismMapMarker : list) {
				if ((markerGroupId != tourismMapMarker.getMarkerGroupId())) {
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

			query.append(_SQL_SELECT_TOURISMMAPMARKER_WHERE);

			query.append(_FINDER_COLUMN_LOCATIONGROUP_MARKERGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TourismMapMarkerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(markerGroupId);

				list = (List<TourismMapMarker>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tourism map marker in the ordered set where markerGroupId = &#63;.
	 *
	 * @param markerGroupId the marker group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tourism map marker
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker findByLocationGroup_First(long markerGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerException, SystemException {
		TourismMapMarker tourismMapMarker = fetchByLocationGroup_First(markerGroupId,
				orderByComparator);

		if (tourismMapMarker != null) {
			return tourismMapMarker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("markerGroupId=");
		msg.append(markerGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTourismMapMarkerException(msg.toString());
	}

	/**
	 * Returns the first tourism map marker in the ordered set where markerGroupId = &#63;.
	 *
	 * @param markerGroupId the marker group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker fetchByLocationGroup_First(long markerGroupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TourismMapMarker> list = findByLocationGroup(markerGroupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tourism map marker in the ordered set where markerGroupId = &#63;.
	 *
	 * @param markerGroupId the marker group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tourism map marker
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker findByLocationGroup_Last(long markerGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerException, SystemException {
		TourismMapMarker tourismMapMarker = fetchByLocationGroup_Last(markerGroupId,
				orderByComparator);

		if (tourismMapMarker != null) {
			return tourismMapMarker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("markerGroupId=");
		msg.append(markerGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTourismMapMarkerException(msg.toString());
	}

	/**
	 * Returns the last tourism map marker in the ordered set where markerGroupId = &#63;.
	 *
	 * @param markerGroupId the marker group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker fetchByLocationGroup_Last(long markerGroupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLocationGroup(markerGroupId);

		List<TourismMapMarker> list = findByLocationGroup(markerGroupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tourism map markers before and after the current tourism map marker in the ordered set where markerGroupId = &#63;.
	 *
	 * @param markerId the primary key of the current tourism map marker
	 * @param markerGroupId the marker group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tourism map marker
	 * @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TourismMapMarker[] findByLocationGroup_PrevAndNext(long markerId,
		long markerGroupId, OrderByComparator orderByComparator)
		throws NoSuchTourismMapMarkerException, SystemException {
		TourismMapMarker tourismMapMarker = findByPrimaryKey(markerId);

		Session session = null;

		try {
			session = openSession();

			TourismMapMarker[] array = new TourismMapMarkerImpl[3];

			array[0] = getByLocationGroup_PrevAndNext(session,
					tourismMapMarker, markerGroupId, orderByComparator, true);

			array[1] = tourismMapMarker;

			array[2] = getByLocationGroup_PrevAndNext(session,
					tourismMapMarker, markerGroupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TourismMapMarker getByLocationGroup_PrevAndNext(Session session,
		TourismMapMarker tourismMapMarker, long markerGroupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOURISMMAPMARKER_WHERE);

		query.append(_FINDER_COLUMN_LOCATIONGROUP_MARKERGROUPID_2);

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
			query.append(TourismMapMarkerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(markerGroupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tourismMapMarker);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TourismMapMarker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tourism map markers.
	 *
	 * @return the tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tourism map markers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tourism map markers
	 * @param end the upper bound of the range of tourism map markers (not inclusive)
	 * @return the range of tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tourism map markers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tourism map markers
	 * @param end the upper bound of the range of tourism map markers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<TourismMapMarker> findAll(int start, int end,
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

		List<TourismMapMarker> list = (List<TourismMapMarker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TOURISMMAPMARKER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TOURISMMAPMARKER.concat(TourismMapMarkerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TourismMapMarker>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TourismMapMarker>)QueryUtil.list(q,
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
	 * Removes all the tourism map markers where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (TourismMapMarker tourismMapMarker : findByCompany(companyId)) {
			remove(tourismMapMarker);
		}
	}

	/**
	 * Removes all the tourism map markers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (TourismMapMarker tourismMapMarker : findByGroup(groupId)) {
			remove(tourismMapMarker);
		}
	}

	/**
	 * Removes all the tourism map markers where markerGroupId = &#63; from the database.
	 *
	 * @param markerGroupId the marker group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLocationGroup(long markerGroupId)
		throws SystemException {
		for (TourismMapMarker tourismMapMarker : findByLocationGroup(
				markerGroupId)) {
			remove(tourismMapMarker);
		}
	}

	/**
	 * Removes all the tourism map markers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TourismMapMarker tourismMapMarker : findAll()) {
			remove(tourismMapMarker);
		}
	}

	/**
	 * Returns the number of tourism map markers where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOURISMMAPMARKER_WHERE);

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
	 * Returns the number of tourism map markers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOURISMMAPMARKER_WHERE);

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
	 * Returns the number of tourism map markers that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tourism map markers that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_TOURISMMAPMARKER_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TourismMapMarker.class.getName(),
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
	 * Returns the number of tourism map markers where markerGroupId = &#63;.
	 *
	 * @param markerGroupId the marker group ID
	 * @return the number of matching tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLocationGroup(long markerGroupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { markerGroupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOCATIONGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOURISMMAPMARKER_WHERE);

			query.append(_FINDER_COLUMN_LOCATIONGROUP_MARKERGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(markerGroupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOCATIONGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of tourism map markers.
	 *
	 * @return the number of tourism map markers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TOURISMMAPMARKER);

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
	 * Initializes the tourism map marker persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.tourism_map.model.TourismMapMarker")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TourismMapMarker>> listenersList = new ArrayList<ModelListener<TourismMapMarker>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TourismMapMarker>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TourismMapMarkerImpl.class.getName());
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
	private static final String _SQL_SELECT_TOURISMMAPMARKER = "SELECT tourismMapMarker FROM TourismMapMarker tourismMapMarker";
	private static final String _SQL_SELECT_TOURISMMAPMARKER_WHERE = "SELECT tourismMapMarker FROM TourismMapMarker tourismMapMarker WHERE ";
	private static final String _SQL_COUNT_TOURISMMAPMARKER = "SELECT COUNT(tourismMapMarker) FROM TourismMapMarker tourismMapMarker";
	private static final String _SQL_COUNT_TOURISMMAPMARKER_WHERE = "SELECT COUNT(tourismMapMarker) FROM TourismMapMarker tourismMapMarker WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "tourismMapMarker.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "tourismMapMarker.groupId = ?";
	private static final String _FINDER_COLUMN_LOCATIONGROUP_MARKERGROUPID_2 = "tourismMapMarker.markerGroupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "tourismMapMarker.markerId";
	private static final String _FILTER_SQL_SELECT_TOURISMMAPMARKER_WHERE = "SELECT DISTINCT {tourismMapMarker.*} FROM TourismMapMarker tourismMapMarker WHERE ";
	private static final String _FILTER_SQL_SELECT_TOURISMMAPMARKER_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {TourismMapMarker.*} FROM (SELECT DISTINCT tourismMapMarker.markerId FROM TourismMapMarker tourismMapMarker WHERE ";
	private static final String _FILTER_SQL_SELECT_TOURISMMAPMARKER_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN TourismMapMarker ON TEMP_TABLE.markerId = TourismMapMarker.markerId";
	private static final String _FILTER_SQL_COUNT_TOURISMMAPMARKER_WHERE = "SELECT COUNT(DISTINCT tourismMapMarker.markerId) AS COUNT_VALUE FROM TourismMapMarker tourismMapMarker WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "tourismMapMarker";
	private static final String _FILTER_ENTITY_TABLE = "TourismMapMarker";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tourismMapMarker.";
	private static final String _ORDER_BY_ENTITY_TABLE = "TourismMapMarker.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TourismMapMarker exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TourismMapMarker exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TourismMapMarkerPersistenceImpl.class);
	private static TourismMapMarker _nullTourismMapMarker = new TourismMapMarkerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TourismMapMarker> toCacheModel() {
				return _nullTourismMapMarkerCacheModel;
			}
		};

	private static CacheModel<TourismMapMarker> _nullTourismMapMarkerCacheModel = new CacheModel<TourismMapMarker>() {
			public TourismMapMarker toEntityModel() {
				return _nullTourismMapMarker;
			}
		};
}