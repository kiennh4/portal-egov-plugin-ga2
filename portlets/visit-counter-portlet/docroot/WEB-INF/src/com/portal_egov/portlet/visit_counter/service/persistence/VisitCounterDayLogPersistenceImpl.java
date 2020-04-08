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

import com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException;
import com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog;
import com.portal_egov.portlet.visit_counter.model.impl.VisitCounterDayLogImpl;
import com.portal_egov.portlet.visit_counter.model.impl.VisitCounterDayLogModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the visit counter day log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see VisitCounterDayLogPersistence
 * @see VisitCounterDayLogUtil
 * @generated
 */
public class VisitCounterDayLogPersistenceImpl extends BasePersistenceImpl<VisitCounterDayLog>
	implements VisitCounterDayLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VisitCounterDayLogUtil} to access the visit counter day log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VisitCounterDayLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterDayLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterDayLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterDayLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterDayLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			VisitCounterDayLogModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterDayLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterDayLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterDayLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterDayLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterDayLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			VisitCounterDayLogModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterDayLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterDayLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterDayLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterDayLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterDayLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterDayLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the visit counter day log in the entity cache if it is enabled.
	 *
	 * @param visitCounterDayLog the visit counter day log
	 */
	public void cacheResult(VisitCounterDayLog visitCounterDayLog) {
		EntityCacheUtil.putResult(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterDayLogImpl.class, visitCounterDayLog.getPrimaryKey(),
			visitCounterDayLog);

		visitCounterDayLog.resetOriginalValues();
	}

	/**
	 * Caches the visit counter day logs in the entity cache if it is enabled.
	 *
	 * @param visitCounterDayLogs the visit counter day logs
	 */
	public void cacheResult(List<VisitCounterDayLog> visitCounterDayLogs) {
		for (VisitCounterDayLog visitCounterDayLog : visitCounterDayLogs) {
			if (EntityCacheUtil.getResult(
						VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
						VisitCounterDayLogImpl.class,
						visitCounterDayLog.getPrimaryKey()) == null) {
				cacheResult(visitCounterDayLog);
			}
			else {
				visitCounterDayLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all visit counter day logs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VisitCounterDayLogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VisitCounterDayLogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the visit counter day log.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VisitCounterDayLog visitCounterDayLog) {
		EntityCacheUtil.removeResult(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterDayLogImpl.class, visitCounterDayLog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VisitCounterDayLog> visitCounterDayLogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VisitCounterDayLog visitCounterDayLog : visitCounterDayLogs) {
			EntityCacheUtil.removeResult(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
				VisitCounterDayLogImpl.class, visitCounterDayLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new visit counter day log with the primary key. Does not add the visit counter day log to the database.
	 *
	 * @param daylogId the primary key for the new visit counter day log
	 * @return the new visit counter day log
	 */
	public VisitCounterDayLog create(String daylogId) {
		VisitCounterDayLog visitCounterDayLog = new VisitCounterDayLogImpl();

		visitCounterDayLog.setNew(true);
		visitCounterDayLog.setPrimaryKey(daylogId);

		return visitCounterDayLog;
	}

	/**
	 * Removes the visit counter day log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param daylogId the primary key of the visit counter day log
	 * @return the visit counter day log that was removed
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a visit counter day log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterDayLog remove(String daylogId)
		throws NoSuchVisitCounterDayLogException, SystemException {
		return remove((Serializable)daylogId);
	}

	/**
	 * Removes the visit counter day log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the visit counter day log
	 * @return the visit counter day log that was removed
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a visit counter day log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterDayLog remove(Serializable primaryKey)
		throws NoSuchVisitCounterDayLogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VisitCounterDayLog visitCounterDayLog = (VisitCounterDayLog)session.get(VisitCounterDayLogImpl.class,
					primaryKey);

			if (visitCounterDayLog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVisitCounterDayLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(visitCounterDayLog);
		}
		catch (NoSuchVisitCounterDayLogException nsee) {
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
	protected VisitCounterDayLog removeImpl(
		VisitCounterDayLog visitCounterDayLog) throws SystemException {
		visitCounterDayLog = toUnwrappedModel(visitCounterDayLog);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, visitCounterDayLog);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(visitCounterDayLog);

		return visitCounterDayLog;
	}

	@Override
	public VisitCounterDayLog updateImpl(
		com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog visitCounterDayLog,
		boolean merge) throws SystemException {
		visitCounterDayLog = toUnwrappedModel(visitCounterDayLog);

		boolean isNew = visitCounterDayLog.isNew();

		VisitCounterDayLogModelImpl visitCounterDayLogModelImpl = (VisitCounterDayLogModelImpl)visitCounterDayLog;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, visitCounterDayLog, merge);

			visitCounterDayLog.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VisitCounterDayLogModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((visitCounterDayLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(visitCounterDayLogModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(visitCounterDayLogModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((visitCounterDayLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(visitCounterDayLogModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(visitCounterDayLogModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterDayLogImpl.class, visitCounterDayLog.getPrimaryKey(),
			visitCounterDayLog);

		return visitCounterDayLog;
	}

	protected VisitCounterDayLog toUnwrappedModel(
		VisitCounterDayLog visitCounterDayLog) {
		if (visitCounterDayLog instanceof VisitCounterDayLogImpl) {
			return visitCounterDayLog;
		}

		VisitCounterDayLogImpl visitCounterDayLogImpl = new VisitCounterDayLogImpl();

		visitCounterDayLogImpl.setNew(visitCounterDayLog.isNew());
		visitCounterDayLogImpl.setPrimaryKey(visitCounterDayLog.getPrimaryKey());

		visitCounterDayLogImpl.setDaylogId(visitCounterDayLog.getDaylogId());
		visitCounterDayLogImpl.setCompanyId(visitCounterDayLog.getCompanyId());
		visitCounterDayLogImpl.setGroupId(visitCounterDayLog.getGroupId());
		visitCounterDayLogImpl.setHitCounter(visitCounterDayLog.getHitCounter());

		return visitCounterDayLogImpl;
	}

	/**
	 * Returns the visit counter day log with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the visit counter day log
	 * @return the visit counter day log
	 * @throws com.liferay.portal.NoSuchModelException if a visit counter day log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterDayLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the visit counter day log with the primary key or throws a {@link com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException} if it could not be found.
	 *
	 * @param daylogId the primary key of the visit counter day log
	 * @return the visit counter day log
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a visit counter day log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterDayLog findByPrimaryKey(String daylogId)
		throws NoSuchVisitCounterDayLogException, SystemException {
		VisitCounterDayLog visitCounterDayLog = fetchByPrimaryKey(daylogId);

		if (visitCounterDayLog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + daylogId);
			}

			throw new NoSuchVisitCounterDayLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				daylogId);
		}

		return visitCounterDayLog;
	}

	/**
	 * Returns the visit counter day log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the visit counter day log
	 * @return the visit counter day log, or <code>null</code> if a visit counter day log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterDayLog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the visit counter day log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param daylogId the primary key of the visit counter day log
	 * @return the visit counter day log, or <code>null</code> if a visit counter day log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterDayLog fetchByPrimaryKey(String daylogId)
		throws SystemException {
		VisitCounterDayLog visitCounterDayLog = (VisitCounterDayLog)EntityCacheUtil.getResult(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
				VisitCounterDayLogImpl.class, daylogId);

		if (visitCounterDayLog == _nullVisitCounterDayLog) {
			return null;
		}

		if (visitCounterDayLog == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				visitCounterDayLog = (VisitCounterDayLog)session.get(VisitCounterDayLogImpl.class,
						daylogId);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (visitCounterDayLog != null) {
					cacheResult(visitCounterDayLog);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VisitCounterDayLogModelImpl.ENTITY_CACHE_ENABLED,
						VisitCounterDayLogImpl.class, daylogId,
						_nullVisitCounterDayLog);
				}

				closeSession(session);
			}
		}

		return visitCounterDayLog;
	}

	/**
	 * Returns all the visit counter day logs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching visit counter day logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterDayLog> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the visit counter day logs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit counter day logs
	 * @param end the upper bound of the range of visit counter day logs (not inclusive)
	 * @return the range of matching visit counter day logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterDayLog> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visit counter day logs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit counter day logs
	 * @param end the upper bound of the range of visit counter day logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit counter day logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterDayLog> findByCompany(long companyId, int start,
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

		List<VisitCounterDayLog> list = (List<VisitCounterDayLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VisitCounterDayLog visitCounterDayLog : list) {
				if ((companyId != visitCounterDayLog.getCompanyId())) {
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
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_VISITCOUNTERDAYLOG_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<VisitCounterDayLog>)QueryUtil.list(q,
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
	 * Returns the first visit counter day log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter day log
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a matching visit counter day log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterDayLog findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterDayLogException, SystemException {
		VisitCounterDayLog visitCounterDayLog = fetchByCompany_First(companyId,
				orderByComparator);

		if (visitCounterDayLog != null) {
			return visitCounterDayLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterDayLogException(msg.toString());
	}

	/**
	 * Returns the first visit counter day log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter day log, or <code>null</code> if a matching visit counter day log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterDayLog fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VisitCounterDayLog> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visit counter day log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit counter day log
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a matching visit counter day log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterDayLog findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterDayLogException, SystemException {
		VisitCounterDayLog visitCounterDayLog = fetchByCompany_Last(companyId,
				orderByComparator);

		if (visitCounterDayLog != null) {
			return visitCounterDayLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterDayLogException(msg.toString());
	}

	/**
	 * Returns the last visit counter day log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit counter day log, or <code>null</code> if a matching visit counter day log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterDayLog fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<VisitCounterDayLog> list = findByCompany(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visit counter day logs before and after the current visit counter day log in the ordered set where companyId = &#63;.
	 *
	 * @param daylogId the primary key of the current visit counter day log
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit counter day log
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a visit counter day log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterDayLog[] findByCompany_PrevAndNext(String daylogId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVisitCounterDayLogException, SystemException {
		VisitCounterDayLog visitCounterDayLog = findByPrimaryKey(daylogId);

		Session session = null;

		try {
			session = openSession();

			VisitCounterDayLog[] array = new VisitCounterDayLogImpl[3];

			array[0] = getByCompany_PrevAndNext(session, visitCounterDayLog,
					companyId, orderByComparator, true);

			array[1] = visitCounterDayLog;

			array[2] = getByCompany_PrevAndNext(session, visitCounterDayLog,
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

	protected VisitCounterDayLog getByCompany_PrevAndNext(Session session,
		VisitCounterDayLog visitCounterDayLog, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VISITCOUNTERDAYLOG_WHERE);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(visitCounterDayLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VisitCounterDayLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the visit counter day logs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching visit counter day logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterDayLog> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visit counter day logs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of visit counter day logs
	 * @param end the upper bound of the range of visit counter day logs (not inclusive)
	 * @return the range of matching visit counter day logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterDayLog> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visit counter day logs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of visit counter day logs
	 * @param end the upper bound of the range of visit counter day logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit counter day logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterDayLog> findByGroup(long groupId, int start,
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

		List<VisitCounterDayLog> list = (List<VisitCounterDayLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VisitCounterDayLog visitCounterDayLog : list) {
				if ((groupId != visitCounterDayLog.getGroupId())) {
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
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_VISITCOUNTERDAYLOG_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<VisitCounterDayLog>)QueryUtil.list(q,
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
	 * Returns the first visit counter day log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter day log
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a matching visit counter day log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterDayLog findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterDayLogException, SystemException {
		VisitCounterDayLog visitCounterDayLog = fetchByGroup_First(groupId,
				orderByComparator);

		if (visitCounterDayLog != null) {
			return visitCounterDayLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterDayLogException(msg.toString());
	}

	/**
	 * Returns the first visit counter day log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter day log, or <code>null</code> if a matching visit counter day log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterDayLog fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VisitCounterDayLog> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visit counter day log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit counter day log
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a matching visit counter day log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterDayLog findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterDayLogException, SystemException {
		VisitCounterDayLog visitCounterDayLog = fetchByGroup_Last(groupId,
				orderByComparator);

		if (visitCounterDayLog != null) {
			return visitCounterDayLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterDayLogException(msg.toString());
	}

	/**
	 * Returns the last visit counter day log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit counter day log, or <code>null</code> if a matching visit counter day log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterDayLog fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<VisitCounterDayLog> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visit counter day logs before and after the current visit counter day log in the ordered set where groupId = &#63;.
	 *
	 * @param daylogId the primary key of the current visit counter day log
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit counter day log
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a visit counter day log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterDayLog[] findByGroup_PrevAndNext(String daylogId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVisitCounterDayLogException, SystemException {
		VisitCounterDayLog visitCounterDayLog = findByPrimaryKey(daylogId);

		Session session = null;

		try {
			session = openSession();

			VisitCounterDayLog[] array = new VisitCounterDayLogImpl[3];

			array[0] = getByGroup_PrevAndNext(session, visitCounterDayLog,
					groupId, orderByComparator, true);

			array[1] = visitCounterDayLog;

			array[2] = getByGroup_PrevAndNext(session, visitCounterDayLog,
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

	protected VisitCounterDayLog getByGroup_PrevAndNext(Session session,
		VisitCounterDayLog visitCounterDayLog, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VISITCOUNTERDAYLOG_WHERE);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(visitCounterDayLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VisitCounterDayLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the visit counter day logs.
	 *
	 * @return the visit counter day logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterDayLog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visit counter day logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit counter day logs
	 * @param end the upper bound of the range of visit counter day logs (not inclusive)
	 * @return the range of visit counter day logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterDayLog> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the visit counter day logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit counter day logs
	 * @param end the upper bound of the range of visit counter day logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of visit counter day logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterDayLog> findAll(int start, int end,
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

		List<VisitCounterDayLog> list = (List<VisitCounterDayLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VISITCOUNTERDAYLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VISITCOUNTERDAYLOG;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VisitCounterDayLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VisitCounterDayLog>)QueryUtil.list(q,
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
	 * Removes all the visit counter day logs where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (VisitCounterDayLog visitCounterDayLog : findByCompany(companyId)) {
			remove(visitCounterDayLog);
		}
	}

	/**
	 * Removes all the visit counter day logs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (VisitCounterDayLog visitCounterDayLog : findByGroup(groupId)) {
			remove(visitCounterDayLog);
		}
	}

	/**
	 * Removes all the visit counter day logs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VisitCounterDayLog visitCounterDayLog : findAll()) {
			remove(visitCounterDayLog);
		}
	}

	/**
	 * Returns the number of visit counter day logs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching visit counter day logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VISITCOUNTERDAYLOG_WHERE);

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
	 * Returns the number of visit counter day logs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching visit counter day logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VISITCOUNTERDAYLOG_WHERE);

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
	 * Returns the number of visit counter day logs.
	 *
	 * @return the number of visit counter day logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VISITCOUNTERDAYLOG);

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
	 * Initializes the visit counter day log persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VisitCounterDayLog>> listenersList = new ArrayList<ModelListener<VisitCounterDayLog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VisitCounterDayLog>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VisitCounterDayLogImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = VisitCounterPersistence.class)
	protected VisitCounterPersistence visitCounterPersistence;
	@BeanReference(type = VisitCounterDayLogPersistence.class)
	protected VisitCounterDayLogPersistence visitCounterDayLogPersistence;
	@BeanReference(type = VisitCounterLogPersistence.class)
	protected VisitCounterLogPersistence visitCounterLogPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_VISITCOUNTERDAYLOG = "SELECT visitCounterDayLog FROM VisitCounterDayLog visitCounterDayLog";
	private static final String _SQL_SELECT_VISITCOUNTERDAYLOG_WHERE = "SELECT visitCounterDayLog FROM VisitCounterDayLog visitCounterDayLog WHERE ";
	private static final String _SQL_COUNT_VISITCOUNTERDAYLOG = "SELECT COUNT(visitCounterDayLog) FROM VisitCounterDayLog visitCounterDayLog";
	private static final String _SQL_COUNT_VISITCOUNTERDAYLOG_WHERE = "SELECT COUNT(visitCounterDayLog) FROM VisitCounterDayLog visitCounterDayLog WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "visitCounterDayLog.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "visitCounterDayLog.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "visitCounterDayLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VisitCounterDayLog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VisitCounterDayLog exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VisitCounterDayLogPersistenceImpl.class);
	private static VisitCounterDayLog _nullVisitCounterDayLog = new VisitCounterDayLogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VisitCounterDayLog> toCacheModel() {
				return _nullVisitCounterDayLogCacheModel;
			}
		};

	private static CacheModel<VisitCounterDayLog> _nullVisitCounterDayLogCacheModel =
		new CacheModel<VisitCounterDayLog>() {
			public VisitCounterDayLog toEntityModel() {
				return _nullVisitCounterDayLog;
			}
		};
}