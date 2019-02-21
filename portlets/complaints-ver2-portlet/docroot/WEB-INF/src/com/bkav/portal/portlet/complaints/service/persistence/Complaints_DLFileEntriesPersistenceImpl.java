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

package com.bkav.portal.portlet.complaints.service.persistence;

import com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException;
import com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries;
import com.bkav.portal.portlet.complaints.model.impl.Complaints_DLFileEntriesImpl;
import com.bkav.portal.portlet.complaints.model.impl.Complaints_DLFileEntriesModelImpl;

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
 * The persistence implementation for the complaints_ d l file entries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhBDb
 * @see Complaints_DLFileEntriesPersistence
 * @see Complaints_DLFileEntriesUtil
 * @generated
 */
public class Complaints_DLFileEntriesPersistenceImpl extends BasePersistenceImpl<Complaints_DLFileEntries>
	implements Complaints_DLFileEntriesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Complaints_DLFileEntriesUtil} to access the complaints_ d l file entries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Complaints_DLFileEntriesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPLAINTID =
		new FinderPath(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaints_DLFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			Complaints_DLFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByComplaintId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLAINTID =
		new FinderPath(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaints_DLFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			Complaints_DLFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByComplaintId",
			new String[] { Long.class.getName() },
			Complaints_DLFileEntriesModelImpl.COMPLAINTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPLAINTID = new FinderPath(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaints_DLFileEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByComplaintId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DLFILEENTRY =
		new FinderPath(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaints_DLFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			Complaints_DLFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDLFileEntry",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILEENTRY =
		new FinderPath(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaints_DLFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			Complaints_DLFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDLFileEntry",
			new String[] { Long.class.getName() },
			Complaints_DLFileEntriesModelImpl.FILEENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DLFILEENTRY = new FinderPath(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaints_DLFileEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDLFileEntry",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaints_DLFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			Complaints_DLFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaints_DLFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			Complaints_DLFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaints_DLFileEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the complaints_ d l file entries in the entity cache if it is enabled.
	 *
	 * @param complaints_DLFileEntries the complaints_ d l file entries
	 */
	public void cacheResult(Complaints_DLFileEntries complaints_DLFileEntries) {
		EntityCacheUtil.putResult(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaints_DLFileEntriesImpl.class,
			complaints_DLFileEntries.getPrimaryKey(), complaints_DLFileEntries);

		complaints_DLFileEntries.resetOriginalValues();
	}

	/**
	 * Caches the complaints_ d l file entrieses in the entity cache if it is enabled.
	 *
	 * @param complaints_DLFileEntrieses the complaints_ d l file entrieses
	 */
	public void cacheResult(
		List<Complaints_DLFileEntries> complaints_DLFileEntrieses) {
		for (Complaints_DLFileEntries complaints_DLFileEntries : complaints_DLFileEntrieses) {
			if (EntityCacheUtil.getResult(
						Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
						Complaints_DLFileEntriesImpl.class,
						complaints_DLFileEntries.getPrimaryKey()) == null) {
				cacheResult(complaints_DLFileEntries);
			}
			else {
				complaints_DLFileEntries.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all complaints_ d l file entrieses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Complaints_DLFileEntriesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Complaints_DLFileEntriesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the complaints_ d l file entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Complaints_DLFileEntries complaints_DLFileEntries) {
		EntityCacheUtil.removeResult(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaints_DLFileEntriesImpl.class,
			complaints_DLFileEntries.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<Complaints_DLFileEntries> complaints_DLFileEntrieses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Complaints_DLFileEntries complaints_DLFileEntries : complaints_DLFileEntrieses) {
			EntityCacheUtil.removeResult(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
				Complaints_DLFileEntriesImpl.class,
				complaints_DLFileEntries.getPrimaryKey());
		}
	}

	/**
	 * Creates a new complaints_ d l file entries with the primary key. Does not add the complaints_ d l file entries to the database.
	 *
	 * @param id the primary key for the new complaints_ d l file entries
	 * @return the new complaints_ d l file entries
	 */
	public Complaints_DLFileEntries create(long id) {
		Complaints_DLFileEntries complaints_DLFileEntries = new Complaints_DLFileEntriesImpl();

		complaints_DLFileEntries.setNew(true);
		complaints_DLFileEntries.setPrimaryKey(id);

		return complaints_DLFileEntries;
	}

	/**
	 * Removes the complaints_ d l file entries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the complaints_ d l file entries
	 * @return the complaints_ d l file entries that was removed
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a complaints_ d l file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints_DLFileEntries remove(long id)
		throws NoSuchComplaints_DLFileEntriesException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the complaints_ d l file entries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the complaints_ d l file entries
	 * @return the complaints_ d l file entries that was removed
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a complaints_ d l file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complaints_DLFileEntries remove(Serializable primaryKey)
		throws NoSuchComplaints_DLFileEntriesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Complaints_DLFileEntries complaints_DLFileEntries = (Complaints_DLFileEntries)session.get(Complaints_DLFileEntriesImpl.class,
					primaryKey);

			if (complaints_DLFileEntries == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchComplaints_DLFileEntriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(complaints_DLFileEntries);
		}
		catch (NoSuchComplaints_DLFileEntriesException nsee) {
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
	protected Complaints_DLFileEntries removeImpl(
		Complaints_DLFileEntries complaints_DLFileEntries)
		throws SystemException {
		complaints_DLFileEntries = toUnwrappedModel(complaints_DLFileEntries);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, complaints_DLFileEntries);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(complaints_DLFileEntries);

		return complaints_DLFileEntries;
	}

	@Override
	public Complaints_DLFileEntries updateImpl(
		com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries complaints_DLFileEntries,
		boolean merge) throws SystemException {
		complaints_DLFileEntries = toUnwrappedModel(complaints_DLFileEntries);

		boolean isNew = complaints_DLFileEntries.isNew();

		Complaints_DLFileEntriesModelImpl complaints_DLFileEntriesModelImpl = (Complaints_DLFileEntriesModelImpl)complaints_DLFileEntries;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, complaints_DLFileEntries, merge);

			complaints_DLFileEntries.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Complaints_DLFileEntriesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((complaints_DLFileEntriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLAINTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(complaints_DLFileEntriesModelImpl.getOriginalComplaintId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPLAINTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLAINTID,
					args);

				args = new Object[] {
						Long.valueOf(complaints_DLFileEntriesModelImpl.getComplaintId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPLAINTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLAINTID,
					args);
			}

			if ((complaints_DLFileEntriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILEENTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(complaints_DLFileEntriesModelImpl.getOriginalFileEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DLFILEENTRY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILEENTRY,
					args);

				args = new Object[] {
						Long.valueOf(complaints_DLFileEntriesModelImpl.getFileEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DLFILEENTRY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILEENTRY,
					args);
			}
		}

		EntityCacheUtil.putResult(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaints_DLFileEntriesImpl.class,
			complaints_DLFileEntries.getPrimaryKey(), complaints_DLFileEntries);

		return complaints_DLFileEntries;
	}

	protected Complaints_DLFileEntries toUnwrappedModel(
		Complaints_DLFileEntries complaints_DLFileEntries) {
		if (complaints_DLFileEntries instanceof Complaints_DLFileEntriesImpl) {
			return complaints_DLFileEntries;
		}

		Complaints_DLFileEntriesImpl complaints_DLFileEntriesImpl = new Complaints_DLFileEntriesImpl();

		complaints_DLFileEntriesImpl.setNew(complaints_DLFileEntries.isNew());
		complaints_DLFileEntriesImpl.setPrimaryKey(complaints_DLFileEntries.getPrimaryKey());

		complaints_DLFileEntriesImpl.setId(complaints_DLFileEntries.getId());
		complaints_DLFileEntriesImpl.setComplaintId(complaints_DLFileEntries.getComplaintId());
		complaints_DLFileEntriesImpl.setFileEntryId(complaints_DLFileEntries.getFileEntryId());

		return complaints_DLFileEntriesImpl;
	}

	/**
	 * Returns the complaints_ d l file entries with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the complaints_ d l file entries
	 * @return the complaints_ d l file entries
	 * @throws com.liferay.portal.NoSuchModelException if a complaints_ d l file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complaints_DLFileEntries findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the complaints_ d l file entries with the primary key or throws a {@link com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException} if it could not be found.
	 *
	 * @param id the primary key of the complaints_ d l file entries
	 * @return the complaints_ d l file entries
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a complaints_ d l file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints_DLFileEntries findByPrimaryKey(long id)
		throws NoSuchComplaints_DLFileEntriesException, SystemException {
		Complaints_DLFileEntries complaints_DLFileEntries = fetchByPrimaryKey(id);

		if (complaints_DLFileEntries == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchComplaints_DLFileEntriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return complaints_DLFileEntries;
	}

	/**
	 * Returns the complaints_ d l file entries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the complaints_ d l file entries
	 * @return the complaints_ d l file entries, or <code>null</code> if a complaints_ d l file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complaints_DLFileEntries fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the complaints_ d l file entries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the complaints_ d l file entries
	 * @return the complaints_ d l file entries, or <code>null</code> if a complaints_ d l file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints_DLFileEntries fetchByPrimaryKey(long id)
		throws SystemException {
		Complaints_DLFileEntries complaints_DLFileEntries = (Complaints_DLFileEntries)EntityCacheUtil.getResult(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
				Complaints_DLFileEntriesImpl.class, id);

		if (complaints_DLFileEntries == _nullComplaints_DLFileEntries) {
			return null;
		}

		if (complaints_DLFileEntries == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				complaints_DLFileEntries = (Complaints_DLFileEntries)session.get(Complaints_DLFileEntriesImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (complaints_DLFileEntries != null) {
					cacheResult(complaints_DLFileEntries);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(Complaints_DLFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
						Complaints_DLFileEntriesImpl.class, id,
						_nullComplaints_DLFileEntries);
				}

				closeSession(session);
			}
		}

		return complaints_DLFileEntries;
	}

	/**
	 * Returns all the complaints_ d l file entrieses where complaintId = &#63;.
	 *
	 * @param complaintId the complaint ID
	 * @return the matching complaints_ d l file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints_DLFileEntries> findByComplaintId(long complaintId)
		throws SystemException {
		return findByComplaintId(complaintId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complaints_ d l file entrieses where complaintId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param complaintId the complaint ID
	 * @param start the lower bound of the range of complaints_ d l file entrieses
	 * @param end the upper bound of the range of complaints_ d l file entrieses (not inclusive)
	 * @return the range of matching complaints_ d l file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints_DLFileEntries> findByComplaintId(long complaintId,
		int start, int end) throws SystemException {
		return findByComplaintId(complaintId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaints_ d l file entrieses where complaintId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param complaintId the complaint ID
	 * @param start the lower bound of the range of complaints_ d l file entrieses
	 * @param end the upper bound of the range of complaints_ d l file entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching complaints_ d l file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints_DLFileEntries> findByComplaintId(long complaintId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLAINTID;
			finderArgs = new Object[] { complaintId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPLAINTID;
			finderArgs = new Object[] { complaintId, start, end, orderByComparator };
		}

		List<Complaints_DLFileEntries> list = (List<Complaints_DLFileEntries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Complaints_DLFileEntries complaints_DLFileEntries : list) {
				if ((complaintId != complaints_DLFileEntries.getComplaintId())) {
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

			query.append(_SQL_SELECT_COMPLAINTS_DLFILEENTRIES_WHERE);

			query.append(_FINDER_COLUMN_COMPLAINTID_COMPLAINTID_2);

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

				qPos.add(complaintId);

				list = (List<Complaints_DLFileEntries>)QueryUtil.list(q,
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
	 * Returns the first complaints_ d l file entries in the ordered set where complaintId = &#63;.
	 *
	 * @param complaintId the complaint ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaints_ d l file entries
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a matching complaints_ d l file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints_DLFileEntries findByComplaintId_First(long complaintId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaints_DLFileEntriesException, SystemException {
		Complaints_DLFileEntries complaints_DLFileEntries = fetchByComplaintId_First(complaintId,
				orderByComparator);

		if (complaints_DLFileEntries != null) {
			return complaints_DLFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("complaintId=");
		msg.append(complaintId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaints_DLFileEntriesException(msg.toString());
	}

	/**
	 * Returns the first complaints_ d l file entries in the ordered set where complaintId = &#63;.
	 *
	 * @param complaintId the complaint ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaints_ d l file entries, or <code>null</code> if a matching complaints_ d l file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints_DLFileEntries fetchByComplaintId_First(long complaintId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Complaints_DLFileEntries> list = findByComplaintId(complaintId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last complaints_ d l file entries in the ordered set where complaintId = &#63;.
	 *
	 * @param complaintId the complaint ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaints_ d l file entries
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a matching complaints_ d l file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints_DLFileEntries findByComplaintId_Last(long complaintId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaints_DLFileEntriesException, SystemException {
		Complaints_DLFileEntries complaints_DLFileEntries = fetchByComplaintId_Last(complaintId,
				orderByComparator);

		if (complaints_DLFileEntries != null) {
			return complaints_DLFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("complaintId=");
		msg.append(complaintId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaints_DLFileEntriesException(msg.toString());
	}

	/**
	 * Returns the last complaints_ d l file entries in the ordered set where complaintId = &#63;.
	 *
	 * @param complaintId the complaint ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaints_ d l file entries, or <code>null</code> if a matching complaints_ d l file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints_DLFileEntries fetchByComplaintId_Last(long complaintId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByComplaintId(complaintId);

		List<Complaints_DLFileEntries> list = findByComplaintId(complaintId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the complaints_ d l file entrieses before and after the current complaints_ d l file entries in the ordered set where complaintId = &#63;.
	 *
	 * @param id the primary key of the current complaints_ d l file entries
	 * @param complaintId the complaint ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next complaints_ d l file entries
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a complaints_ d l file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints_DLFileEntries[] findByComplaintId_PrevAndNext(long id,
		long complaintId, OrderByComparator orderByComparator)
		throws NoSuchComplaints_DLFileEntriesException, SystemException {
		Complaints_DLFileEntries complaints_DLFileEntries = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Complaints_DLFileEntries[] array = new Complaints_DLFileEntriesImpl[3];

			array[0] = getByComplaintId_PrevAndNext(session,
					complaints_DLFileEntries, complaintId, orderByComparator,
					true);

			array[1] = complaints_DLFileEntries;

			array[2] = getByComplaintId_PrevAndNext(session,
					complaints_DLFileEntries, complaintId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Complaints_DLFileEntries getByComplaintId_PrevAndNext(
		Session session, Complaints_DLFileEntries complaints_DLFileEntries,
		long complaintId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPLAINTS_DLFILEENTRIES_WHERE);

		query.append(_FINDER_COLUMN_COMPLAINTID_COMPLAINTID_2);

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

		qPos.add(complaintId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(complaints_DLFileEntries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Complaints_DLFileEntries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the complaints_ d l file entrieses where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching complaints_ d l file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints_DLFileEntries> findByDLFileEntry(long fileEntryId)
		throws SystemException {
		return findByDLFileEntry(fileEntryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complaints_ d l file entrieses where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of complaints_ d l file entrieses
	 * @param end the upper bound of the range of complaints_ d l file entrieses (not inclusive)
	 * @return the range of matching complaints_ d l file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints_DLFileEntries> findByDLFileEntry(long fileEntryId,
		int start, int end) throws SystemException {
		return findByDLFileEntry(fileEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaints_ d l file entrieses where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of complaints_ d l file entrieses
	 * @param end the upper bound of the range of complaints_ d l file entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching complaints_ d l file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints_DLFileEntries> findByDLFileEntry(long fileEntryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILEENTRY;
			finderArgs = new Object[] { fileEntryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DLFILEENTRY;
			finderArgs = new Object[] { fileEntryId, start, end, orderByComparator };
		}

		List<Complaints_DLFileEntries> list = (List<Complaints_DLFileEntries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Complaints_DLFileEntries complaints_DLFileEntries : list) {
				if ((fileEntryId != complaints_DLFileEntries.getFileEntryId())) {
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

			query.append(_SQL_SELECT_COMPLAINTS_DLFILEENTRIES_WHERE);

			query.append(_FINDER_COLUMN_DLFILEENTRY_FILEENTRYID_2);

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

				qPos.add(fileEntryId);

				list = (List<Complaints_DLFileEntries>)QueryUtil.list(q,
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
	 * Returns the first complaints_ d l file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaints_ d l file entries
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a matching complaints_ d l file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints_DLFileEntries findByDLFileEntry_First(long fileEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaints_DLFileEntriesException, SystemException {
		Complaints_DLFileEntries complaints_DLFileEntries = fetchByDLFileEntry_First(fileEntryId,
				orderByComparator);

		if (complaints_DLFileEntries != null) {
			return complaints_DLFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileEntryId=");
		msg.append(fileEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaints_DLFileEntriesException(msg.toString());
	}

	/**
	 * Returns the first complaints_ d l file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaints_ d l file entries, or <code>null</code> if a matching complaints_ d l file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints_DLFileEntries fetchByDLFileEntry_First(long fileEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Complaints_DLFileEntries> list = findByDLFileEntry(fileEntryId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last complaints_ d l file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaints_ d l file entries
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a matching complaints_ d l file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints_DLFileEntries findByDLFileEntry_Last(long fileEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaints_DLFileEntriesException, SystemException {
		Complaints_DLFileEntries complaints_DLFileEntries = fetchByDLFileEntry_Last(fileEntryId,
				orderByComparator);

		if (complaints_DLFileEntries != null) {
			return complaints_DLFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileEntryId=");
		msg.append(fileEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaints_DLFileEntriesException(msg.toString());
	}

	/**
	 * Returns the last complaints_ d l file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaints_ d l file entries, or <code>null</code> if a matching complaints_ d l file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints_DLFileEntries fetchByDLFileEntry_Last(long fileEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDLFileEntry(fileEntryId);

		List<Complaints_DLFileEntries> list = findByDLFileEntry(fileEntryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the complaints_ d l file entrieses before and after the current complaints_ d l file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param id the primary key of the current complaints_ d l file entries
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next complaints_ d l file entries
	 * @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a complaints_ d l file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints_DLFileEntries[] findByDLFileEntry_PrevAndNext(long id,
		long fileEntryId, OrderByComparator orderByComparator)
		throws NoSuchComplaints_DLFileEntriesException, SystemException {
		Complaints_DLFileEntries complaints_DLFileEntries = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Complaints_DLFileEntries[] array = new Complaints_DLFileEntriesImpl[3];

			array[0] = getByDLFileEntry_PrevAndNext(session,
					complaints_DLFileEntries, fileEntryId, orderByComparator,
					true);

			array[1] = complaints_DLFileEntries;

			array[2] = getByDLFileEntry_PrevAndNext(session,
					complaints_DLFileEntries, fileEntryId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Complaints_DLFileEntries getByDLFileEntry_PrevAndNext(
		Session session, Complaints_DLFileEntries complaints_DLFileEntries,
		long fileEntryId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPLAINTS_DLFILEENTRIES_WHERE);

		query.append(_FINDER_COLUMN_DLFILEENTRY_FILEENTRYID_2);

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

		qPos.add(fileEntryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(complaints_DLFileEntries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Complaints_DLFileEntries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the complaints_ d l file entrieses.
	 *
	 * @return the complaints_ d l file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints_DLFileEntries> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complaints_ d l file entrieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaints_ d l file entrieses
	 * @param end the upper bound of the range of complaints_ d l file entrieses (not inclusive)
	 * @return the range of complaints_ d l file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints_DLFileEntries> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaints_ d l file entrieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaints_ d l file entrieses
	 * @param end the upper bound of the range of complaints_ d l file entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of complaints_ d l file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints_DLFileEntries> findAll(int start, int end,
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

		List<Complaints_DLFileEntries> list = (List<Complaints_DLFileEntries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMPLAINTS_DLFILEENTRIES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMPLAINTS_DLFILEENTRIES;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Complaints_DLFileEntries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Complaints_DLFileEntries>)QueryUtil.list(q,
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
	 * Removes all the complaints_ d l file entrieses where complaintId = &#63; from the database.
	 *
	 * @param complaintId the complaint ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByComplaintId(long complaintId) throws SystemException {
		for (Complaints_DLFileEntries complaints_DLFileEntries : findByComplaintId(
				complaintId)) {
			remove(complaints_DLFileEntries);
		}
	}

	/**
	 * Removes all the complaints_ d l file entrieses where fileEntryId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDLFileEntry(long fileEntryId) throws SystemException {
		for (Complaints_DLFileEntries complaints_DLFileEntries : findByDLFileEntry(
				fileEntryId)) {
			remove(complaints_DLFileEntries);
		}
	}

	/**
	 * Removes all the complaints_ d l file entrieses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Complaints_DLFileEntries complaints_DLFileEntries : findAll()) {
			remove(complaints_DLFileEntries);
		}
	}

	/**
	 * Returns the number of complaints_ d l file entrieses where complaintId = &#63;.
	 *
	 * @param complaintId the complaint ID
	 * @return the number of matching complaints_ d l file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByComplaintId(long complaintId) throws SystemException {
		Object[] finderArgs = new Object[] { complaintId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPLAINTID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPLAINTS_DLFILEENTRIES_WHERE);

			query.append(_FINDER_COLUMN_COMPLAINTID_COMPLAINTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(complaintId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPLAINTID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of complaints_ d l file entrieses where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the number of matching complaints_ d l file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDLFileEntry(long fileEntryId) throws SystemException {
		Object[] finderArgs = new Object[] { fileEntryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DLFILEENTRY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPLAINTS_DLFILEENTRIES_WHERE);

			query.append(_FINDER_COLUMN_DLFILEENTRY_FILEENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileEntryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DLFILEENTRY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of complaints_ d l file entrieses.
	 *
	 * @return the number of complaints_ d l file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMPLAINTS_DLFILEENTRIES);

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
	 * Initializes the complaints_ d l file entries persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Complaints_DLFileEntries>> listenersList = new ArrayList<ModelListener<Complaints_DLFileEntries>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Complaints_DLFileEntries>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Complaints_DLFileEntriesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ComplaintsPersistence.class)
	protected ComplaintsPersistence complaintsPersistence;
	@BeanReference(type = Complaints_DLFileEntriesPersistence.class)
	protected Complaints_DLFileEntriesPersistence complaints_DLFileEntriesPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_COMPLAINTS_DLFILEENTRIES = "SELECT complaints_DLFileEntries FROM Complaints_DLFileEntries complaints_DLFileEntries";
	private static final String _SQL_SELECT_COMPLAINTS_DLFILEENTRIES_WHERE = "SELECT complaints_DLFileEntries FROM Complaints_DLFileEntries complaints_DLFileEntries WHERE ";
	private static final String _SQL_COUNT_COMPLAINTS_DLFILEENTRIES = "SELECT COUNT(complaints_DLFileEntries) FROM Complaints_DLFileEntries complaints_DLFileEntries";
	private static final String _SQL_COUNT_COMPLAINTS_DLFILEENTRIES_WHERE = "SELECT COUNT(complaints_DLFileEntries) FROM Complaints_DLFileEntries complaints_DLFileEntries WHERE ";
	private static final String _FINDER_COLUMN_COMPLAINTID_COMPLAINTID_2 = "complaints_DLFileEntries.complaintId = ?";
	private static final String _FINDER_COLUMN_DLFILEENTRY_FILEENTRYID_2 = "complaints_DLFileEntries.fileEntryId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "complaints_DLFileEntries.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Complaints_DLFileEntries exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Complaints_DLFileEntries exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Complaints_DLFileEntriesPersistenceImpl.class);
	private static Complaints_DLFileEntries _nullComplaints_DLFileEntries = new Complaints_DLFileEntriesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Complaints_DLFileEntries> toCacheModel() {
				return _nullComplaints_DLFileEntriesCacheModel;
			}
		};

	private static CacheModel<Complaints_DLFileEntries> _nullComplaints_DLFileEntriesCacheModel =
		new CacheModel<Complaints_DLFileEntries>() {
			public Complaints_DLFileEntries toEntityModel() {
				return _nullComplaints_DLFileEntries;
			}
		};
}