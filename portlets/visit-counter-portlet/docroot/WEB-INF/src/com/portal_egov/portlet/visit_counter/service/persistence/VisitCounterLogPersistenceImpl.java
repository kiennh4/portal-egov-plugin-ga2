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

import com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException;
import com.portal_egov.portlet.visit_counter.model.VisitCounterLog;
import com.portal_egov.portlet.visit_counter.model.impl.VisitCounterLogImpl;
import com.portal_egov.portlet.visit_counter.model.impl.VisitCounterLogModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the visit counter log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see VisitCounterLogPersistence
 * @see VisitCounterLogUtil
 * @generated
 */
public class VisitCounterLogPersistenceImpl extends BasePersistenceImpl<VisitCounterLog>
	implements VisitCounterLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VisitCounterLogUtil} to access the visit counter log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VisitCounterLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterLogImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			VisitCounterLogModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterLogImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			VisitCounterLogModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterLogImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED,
			VisitCounterLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the visit counter log in the entity cache if it is enabled.
	 *
	 * @param visitCounterLog the visit counter log
	 */
	public void cacheResult(VisitCounterLog visitCounterLog) {
		EntityCacheUtil.putResult(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogImpl.class, visitCounterLog.getPrimaryKey(),
			visitCounterLog);

		visitCounterLog.resetOriginalValues();
	}

	/**
	 * Caches the visit counter logs in the entity cache if it is enabled.
	 *
	 * @param visitCounterLogs the visit counter logs
	 */
	public void cacheResult(List<VisitCounterLog> visitCounterLogs) {
		for (VisitCounterLog visitCounterLog : visitCounterLogs) {
			if (EntityCacheUtil.getResult(
						VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
						VisitCounterLogImpl.class,
						visitCounterLog.getPrimaryKey()) == null) {
				cacheResult(visitCounterLog);
			}
			else {
				visitCounterLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all visit counter logs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VisitCounterLogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VisitCounterLogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the visit counter log.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VisitCounterLog visitCounterLog) {
		EntityCacheUtil.removeResult(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogImpl.class, visitCounterLog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VisitCounterLog> visitCounterLogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VisitCounterLog visitCounterLog : visitCounterLogs) {
			EntityCacheUtil.removeResult(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
				VisitCounterLogImpl.class, visitCounterLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new visit counter log with the primary key. Does not add the visit counter log to the database.
	 *
	 * @param visitorIp the primary key for the new visit counter log
	 * @return the new visit counter log
	 */
	public VisitCounterLog create(String visitorIp) {
		VisitCounterLog visitCounterLog = new VisitCounterLogImpl();

		visitCounterLog.setNew(true);
		visitCounterLog.setPrimaryKey(visitorIp);

		return visitCounterLog;
	}

	/**
	 * Removes the visit counter log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param visitorIp the primary key of the visit counter log
	 * @return the visit counter log that was removed
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterLog remove(String visitorIp)
		throws NoSuchVisitCounterLogException, SystemException {
		return remove((Serializable)visitorIp);
	}

	/**
	 * Removes the visit counter log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the visit counter log
	 * @return the visit counter log that was removed
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog remove(Serializable primaryKey)
		throws NoSuchVisitCounterLogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VisitCounterLog visitCounterLog = (VisitCounterLog)session.get(VisitCounterLogImpl.class,
					primaryKey);

			if (visitCounterLog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVisitCounterLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(visitCounterLog);
		}
		catch (NoSuchVisitCounterLogException nsee) {
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
	protected VisitCounterLog removeImpl(VisitCounterLog visitCounterLog)
		throws SystemException {
		visitCounterLog = toUnwrappedModel(visitCounterLog);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, visitCounterLog);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(visitCounterLog);

		return visitCounterLog;
	}

	@Override
	public VisitCounterLog updateImpl(
		com.portal_egov.portlet.visit_counter.model.VisitCounterLog visitCounterLog,
		boolean merge) throws SystemException {
		visitCounterLog = toUnwrappedModel(visitCounterLog);

		boolean isNew = visitCounterLog.isNew();

		VisitCounterLogModelImpl visitCounterLogModelImpl = (VisitCounterLogModelImpl)visitCounterLog;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, visitCounterLog, merge);

			visitCounterLog.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VisitCounterLogModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((visitCounterLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(visitCounterLogModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(visitCounterLogModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((visitCounterLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(visitCounterLogModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(visitCounterLogModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
			VisitCounterLogImpl.class, visitCounterLog.getPrimaryKey(),
			visitCounterLog);

		return visitCounterLog;
	}

	protected VisitCounterLog toUnwrappedModel(VisitCounterLog visitCounterLog) {
		if (visitCounterLog instanceof VisitCounterLogImpl) {
			return visitCounterLog;
		}

		VisitCounterLogImpl visitCounterLogImpl = new VisitCounterLogImpl();

		visitCounterLogImpl.setNew(visitCounterLog.isNew());
		visitCounterLogImpl.setPrimaryKey(visitCounterLog.getPrimaryKey());

		visitCounterLogImpl.setVisitorIp(visitCounterLog.getVisitorIp());
		visitCounterLogImpl.setCompanyId(visitCounterLog.getCompanyId());
		visitCounterLogImpl.setGroupId(visitCounterLog.getGroupId());
		visitCounterLogImpl.setUserId(visitCounterLog.getUserId());
		visitCounterLogImpl.setUserName(visitCounterLog.getUserName());
		visitCounterLogImpl.setCreateDate(visitCounterLog.getCreateDate());
		visitCounterLogImpl.setModifiedDate(visitCounterLog.getModifiedDate());
		visitCounterLogImpl.setHitCounter(visitCounterLog.getHitCounter());
		visitCounterLogImpl.setLastAccessPageId(visitCounterLog.getLastAccessPageId());
		visitCounterLogImpl.setLastAccessDate(visitCounterLog.getLastAccessDate());

		return visitCounterLogImpl;
	}

	/**
	 * Returns the visit counter log with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the visit counter log
	 * @return the visit counter log
	 * @throws com.liferay.portal.NoSuchModelException if a visit counter log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the visit counter log with the primary key or throws a {@link com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException} if it could not be found.
	 *
	 * @param visitorIp the primary key of the visit counter log
	 * @return the visit counter log
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterLog findByPrimaryKey(String visitorIp)
		throws NoSuchVisitCounterLogException, SystemException {
		VisitCounterLog visitCounterLog = fetchByPrimaryKey(visitorIp);

		if (visitCounterLog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + visitorIp);
			}

			throw new NoSuchVisitCounterLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				visitorIp);
		}

		return visitCounterLog;
	}

	/**
	 * Returns the visit counter log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the visit counter log
	 * @return the visit counter log, or <code>null</code> if a visit counter log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitCounterLog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the visit counter log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param visitorIp the primary key of the visit counter log
	 * @return the visit counter log, or <code>null</code> if a visit counter log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterLog fetchByPrimaryKey(String visitorIp)
		throws SystemException {
		VisitCounterLog visitCounterLog = (VisitCounterLog)EntityCacheUtil.getResult(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
				VisitCounterLogImpl.class, visitorIp);

		if (visitCounterLog == _nullVisitCounterLog) {
			return null;
		}

		if (visitCounterLog == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				visitCounterLog = (VisitCounterLog)session.get(VisitCounterLogImpl.class,
						visitorIp);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (visitCounterLog != null) {
					cacheResult(visitCounterLog);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VisitCounterLogModelImpl.ENTITY_CACHE_ENABLED,
						VisitCounterLogImpl.class, visitorIp,
						_nullVisitCounterLog);
				}

				closeSession(session);
			}
		}

		return visitCounterLog;
	}

	/**
	 * Returns all the visit counter logs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterLog> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the visit counter logs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit counter logs
	 * @param end the upper bound of the range of visit counter logs (not inclusive)
	 * @return the range of matching visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterLog> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visit counter logs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit counter logs
	 * @param end the upper bound of the range of visit counter logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterLog> findByCompany(long companyId, int start,
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

		List<VisitCounterLog> list = (List<VisitCounterLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VisitCounterLog visitCounterLog : list) {
				if ((companyId != visitCounterLog.getCompanyId())) {
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

			query.append(_SQL_SELECT_VISITCOUNTERLOG_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VisitCounterLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<VisitCounterLog>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first visit counter log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter log
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterLog findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterLogException, SystemException {
		VisitCounterLog visitCounterLog = fetchByCompany_First(companyId,
				orderByComparator);

		if (visitCounterLog != null) {
			return visitCounterLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterLogException(msg.toString());
	}

	/**
	 * Returns the first visit counter log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterLog fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VisitCounterLog> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visit counter log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit counter log
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterLog findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterLogException, SystemException {
		VisitCounterLog visitCounterLog = fetchByCompany_Last(companyId,
				orderByComparator);

		if (visitCounterLog != null) {
			return visitCounterLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterLogException(msg.toString());
	}

	/**
	 * Returns the last visit counter log in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterLog fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<VisitCounterLog> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visit counter logs before and after the current visit counter log in the ordered set where companyId = &#63;.
	 *
	 * @param visitorIp the primary key of the current visit counter log
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit counter log
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterLog[] findByCompany_PrevAndNext(String visitorIp,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVisitCounterLogException, SystemException {
		VisitCounterLog visitCounterLog = findByPrimaryKey(visitorIp);

		Session session = null;

		try {
			session = openSession();

			VisitCounterLog[] array = new VisitCounterLogImpl[3];

			array[0] = getByCompany_PrevAndNext(session, visitCounterLog,
					companyId, orderByComparator, true);

			array[1] = visitCounterLog;

			array[2] = getByCompany_PrevAndNext(session, visitCounterLog,
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

	protected VisitCounterLog getByCompany_PrevAndNext(Session session,
		VisitCounterLog visitCounterLog, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VISITCOUNTERLOG_WHERE);

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
			query.append(VisitCounterLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(visitCounterLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VisitCounterLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the visit counter logs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterLog> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visit counter logs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of visit counter logs
	 * @param end the upper bound of the range of visit counter logs (not inclusive)
	 * @return the range of matching visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterLog> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visit counter logs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of visit counter logs
	 * @param end the upper bound of the range of visit counter logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterLog> findByGroup(long groupId, int start, int end,
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

		List<VisitCounterLog> list = (List<VisitCounterLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VisitCounterLog visitCounterLog : list) {
				if ((groupId != visitCounterLog.getGroupId())) {
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

			query.append(_SQL_SELECT_VISITCOUNTERLOG_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VisitCounterLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<VisitCounterLog>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first visit counter log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter log
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterLog findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterLogException, SystemException {
		VisitCounterLog visitCounterLog = fetchByGroup_First(groupId,
				orderByComparator);

		if (visitCounterLog != null) {
			return visitCounterLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterLogException(msg.toString());
	}

	/**
	 * Returns the first visit counter log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterLog fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VisitCounterLog> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visit counter log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit counter log
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterLog findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVisitCounterLogException, SystemException {
		VisitCounterLog visitCounterLog = fetchByGroup_Last(groupId,
				orderByComparator);

		if (visitCounterLog != null) {
			return visitCounterLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVisitCounterLogException(msg.toString());
	}

	/**
	 * Returns the last visit counter log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit counter log, or <code>null</code> if a matching visit counter log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterLog fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<VisitCounterLog> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visit counter logs before and after the current visit counter log in the ordered set where groupId = &#63;.
	 *
	 * @param visitorIp the primary key of the current visit counter log
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit counter log
	 * @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterLogException if a visit counter log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VisitCounterLog[] findByGroup_PrevAndNext(String visitorIp,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVisitCounterLogException, SystemException {
		VisitCounterLog visitCounterLog = findByPrimaryKey(visitorIp);

		Session session = null;

		try {
			session = openSession();

			VisitCounterLog[] array = new VisitCounterLogImpl[3];

			array[0] = getByGroup_PrevAndNext(session, visitCounterLog,
					groupId, orderByComparator, true);

			array[1] = visitCounterLog;

			array[2] = getByGroup_PrevAndNext(session, visitCounterLog,
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

	protected VisitCounterLog getByGroup_PrevAndNext(Session session,
		VisitCounterLog visitCounterLog, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VISITCOUNTERLOG_WHERE);

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
			query.append(VisitCounterLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(visitCounterLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VisitCounterLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the visit counter logs.
	 *
	 * @return the visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterLog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visit counter logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit counter logs
	 * @param end the upper bound of the range of visit counter logs (not inclusive)
	 * @return the range of visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterLog> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the visit counter logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit counter logs
	 * @param end the upper bound of the range of visit counter logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VisitCounterLog> findAll(int start, int end,
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

		List<VisitCounterLog> list = (List<VisitCounterLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VISITCOUNTERLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VISITCOUNTERLOG.concat(VisitCounterLogModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VisitCounterLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VisitCounterLog>)QueryUtil.list(q,
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
	 * Removes all the visit counter logs where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (VisitCounterLog visitCounterLog : findByCompany(companyId)) {
			remove(visitCounterLog);
		}
	}

	/**
	 * Removes all the visit counter logs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (VisitCounterLog visitCounterLog : findByGroup(groupId)) {
			remove(visitCounterLog);
		}
	}

	/**
	 * Removes all the visit counter logs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VisitCounterLog visitCounterLog : findAll()) {
			remove(visitCounterLog);
		}
	}

	/**
	 * Returns the number of visit counter logs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VISITCOUNTERLOG_WHERE);

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
	 * Returns the number of visit counter logs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VISITCOUNTERLOG_WHERE);

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
	 * Returns the number of visit counter logs.
	 *
	 * @return the number of visit counter logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VISITCOUNTERLOG);

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
	 * Initializes the visit counter log persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.visit_counter.model.VisitCounterLog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VisitCounterLog>> listenersList = new ArrayList<ModelListener<VisitCounterLog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VisitCounterLog>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VisitCounterLogImpl.class.getName());
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
	private static final String _SQL_SELECT_VISITCOUNTERLOG = "SELECT visitCounterLog FROM VisitCounterLog visitCounterLog";
	private static final String _SQL_SELECT_VISITCOUNTERLOG_WHERE = "SELECT visitCounterLog FROM VisitCounterLog visitCounterLog WHERE ";
	private static final String _SQL_COUNT_VISITCOUNTERLOG = "SELECT COUNT(visitCounterLog) FROM VisitCounterLog visitCounterLog";
	private static final String _SQL_COUNT_VISITCOUNTERLOG_WHERE = "SELECT COUNT(visitCounterLog) FROM VisitCounterLog visitCounterLog WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "visitCounterLog.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "visitCounterLog.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "visitCounterLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VisitCounterLog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VisitCounterLog exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VisitCounterLogPersistenceImpl.class);
	private static VisitCounterLog _nullVisitCounterLog = new VisitCounterLogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VisitCounterLog> toCacheModel() {
				return _nullVisitCounterLogCacheModel;
			}
		};

	private static CacheModel<VisitCounterLog> _nullVisitCounterLogCacheModel = new CacheModel<VisitCounterLog>() {
			public VisitCounterLog toEntityModel() {
				return _nullVisitCounterLog;
			}
		};
}