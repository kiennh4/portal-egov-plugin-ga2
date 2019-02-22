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

package com.portal_egov.portlet.compaints.service.persistence;

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

import com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException;
import com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries;
import com.portal_egov.portlet.compaints.model.impl.Complaint_DlFileEntriesImpl;
import com.portal_egov.portlet.compaints.model.impl.Complaint_DlFileEntriesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the complaint_ dl file entries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see Complaint_DlFileEntriesPersistence
 * @see Complaint_DlFileEntriesUtil
 * @generated
 */
public class Complaint_DlFileEntriesPersistenceImpl extends BasePersistenceImpl<Complaint_DlFileEntries>
	implements Complaint_DlFileEntriesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Complaint_DlFileEntriesUtil} to access the complaint_ dl file entries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Complaint_DlFileEntriesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPLAINT =
		new FinderPath(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaint_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			Complaint_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByComplaint",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLAINT =
		new FinderPath(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaint_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			Complaint_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByComplaint",
			new String[] { Long.class.getName() },
			Complaint_DlFileEntriesModelImpl.COMPLAINTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPLAINT = new FinderPath(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaint_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByComplaint",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DLFILE = new FinderPath(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaint_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			Complaint_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDLFile",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILE =
		new FinderPath(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaint_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			Complaint_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDLFile",
			new String[] { Long.class.getName() },
			Complaint_DlFileEntriesModelImpl.FILEENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DLFILE = new FinderPath(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaint_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDLFile",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaint_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			Complaint_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaint_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			Complaint_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaint_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the complaint_ dl file entries in the entity cache if it is enabled.
	 *
	 * @param complaint_DlFileEntries the complaint_ dl file entries
	 */
	public void cacheResult(Complaint_DlFileEntries complaint_DlFileEntries) {
		EntityCacheUtil.putResult(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaint_DlFileEntriesImpl.class,
			complaint_DlFileEntries.getPrimaryKey(), complaint_DlFileEntries);

		complaint_DlFileEntries.resetOriginalValues();
	}

	/**
	 * Caches the complaint_ dl file entrieses in the entity cache if it is enabled.
	 *
	 * @param complaint_DlFileEntrieses the complaint_ dl file entrieses
	 */
	public void cacheResult(
		List<Complaint_DlFileEntries> complaint_DlFileEntrieses) {
		for (Complaint_DlFileEntries complaint_DlFileEntries : complaint_DlFileEntrieses) {
			if (EntityCacheUtil.getResult(
						Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
						Complaint_DlFileEntriesImpl.class,
						complaint_DlFileEntries.getPrimaryKey()) == null) {
				cacheResult(complaint_DlFileEntries);
			}
			else {
				complaint_DlFileEntries.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all complaint_ dl file entrieses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Complaint_DlFileEntriesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Complaint_DlFileEntriesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the complaint_ dl file entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Complaint_DlFileEntries complaint_DlFileEntries) {
		EntityCacheUtil.removeResult(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaint_DlFileEntriesImpl.class,
			complaint_DlFileEntries.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<Complaint_DlFileEntries> complaint_DlFileEntrieses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Complaint_DlFileEntries complaint_DlFileEntries : complaint_DlFileEntrieses) {
			EntityCacheUtil.removeResult(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
				Complaint_DlFileEntriesImpl.class,
				complaint_DlFileEntries.getPrimaryKey());
		}
	}

	/**
	 * Creates a new complaint_ dl file entries with the primary key. Does not add the complaint_ dl file entries to the database.
	 *
	 * @param id the primary key for the new complaint_ dl file entries
	 * @return the new complaint_ dl file entries
	 */
	public Complaint_DlFileEntries create(long id) {
		Complaint_DlFileEntries complaint_DlFileEntries = new Complaint_DlFileEntriesImpl();

		complaint_DlFileEntries.setNew(true);
		complaint_DlFileEntries.setPrimaryKey(id);

		return complaint_DlFileEntries;
	}

	/**
	 * Removes the complaint_ dl file entries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the complaint_ dl file entries
	 * @return the complaint_ dl file entries that was removed
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a complaint_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint_DlFileEntries remove(long id)
		throws NoSuchComplaint_DlFileEntriesException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the complaint_ dl file entries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the complaint_ dl file entries
	 * @return the complaint_ dl file entries that was removed
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a complaint_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complaint_DlFileEntries remove(Serializable primaryKey)
		throws NoSuchComplaint_DlFileEntriesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Complaint_DlFileEntries complaint_DlFileEntries = (Complaint_DlFileEntries)session.get(Complaint_DlFileEntriesImpl.class,
					primaryKey);

			if (complaint_DlFileEntries == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchComplaint_DlFileEntriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(complaint_DlFileEntries);
		}
		catch (NoSuchComplaint_DlFileEntriesException nsee) {
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
	protected Complaint_DlFileEntries removeImpl(
		Complaint_DlFileEntries complaint_DlFileEntries)
		throws SystemException {
		complaint_DlFileEntries = toUnwrappedModel(complaint_DlFileEntries);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, complaint_DlFileEntries);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(complaint_DlFileEntries);

		return complaint_DlFileEntries;
	}

	@Override
	public Complaint_DlFileEntries updateImpl(
		com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries complaint_DlFileEntries,
		boolean merge) throws SystemException {
		complaint_DlFileEntries = toUnwrappedModel(complaint_DlFileEntries);

		boolean isNew = complaint_DlFileEntries.isNew();

		Complaint_DlFileEntriesModelImpl complaint_DlFileEntriesModelImpl = (Complaint_DlFileEntriesModelImpl)complaint_DlFileEntries;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, complaint_DlFileEntries, merge);

			complaint_DlFileEntries.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Complaint_DlFileEntriesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((complaint_DlFileEntriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLAINT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(complaint_DlFileEntriesModelImpl.getOriginalComplaintId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPLAINT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLAINT,
					args);

				args = new Object[] {
						Long.valueOf(complaint_DlFileEntriesModelImpl.getComplaintId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPLAINT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLAINT,
					args);
			}

			if ((complaint_DlFileEntriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(complaint_DlFileEntriesModelImpl.getOriginalFileEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DLFILE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILE,
					args);

				args = new Object[] {
						Long.valueOf(complaint_DlFileEntriesModelImpl.getFileEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DLFILE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILE,
					args);
			}
		}

		EntityCacheUtil.putResult(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			Complaint_DlFileEntriesImpl.class,
			complaint_DlFileEntries.getPrimaryKey(), complaint_DlFileEntries);

		return complaint_DlFileEntries;
	}

	protected Complaint_DlFileEntries toUnwrappedModel(
		Complaint_DlFileEntries complaint_DlFileEntries) {
		if (complaint_DlFileEntries instanceof Complaint_DlFileEntriesImpl) {
			return complaint_DlFileEntries;
		}

		Complaint_DlFileEntriesImpl complaint_DlFileEntriesImpl = new Complaint_DlFileEntriesImpl();

		complaint_DlFileEntriesImpl.setNew(complaint_DlFileEntries.isNew());
		complaint_DlFileEntriesImpl.setPrimaryKey(complaint_DlFileEntries.getPrimaryKey());

		complaint_DlFileEntriesImpl.setId(complaint_DlFileEntries.getId());
		complaint_DlFileEntriesImpl.setComplaintId(complaint_DlFileEntries.getComplaintId());
		complaint_DlFileEntriesImpl.setFileEntryId(complaint_DlFileEntries.getFileEntryId());

		return complaint_DlFileEntriesImpl;
	}

	/**
	 * Returns the complaint_ dl file entries with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the complaint_ dl file entries
	 * @return the complaint_ dl file entries
	 * @throws com.liferay.portal.NoSuchModelException if a complaint_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complaint_DlFileEntries findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the complaint_ dl file entries with the primary key or throws a {@link com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException} if it could not be found.
	 *
	 * @param id the primary key of the complaint_ dl file entries
	 * @return the complaint_ dl file entries
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a complaint_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint_DlFileEntries findByPrimaryKey(long id)
		throws NoSuchComplaint_DlFileEntriesException, SystemException {
		Complaint_DlFileEntries complaint_DlFileEntries = fetchByPrimaryKey(id);

		if (complaint_DlFileEntries == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchComplaint_DlFileEntriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return complaint_DlFileEntries;
	}

	/**
	 * Returns the complaint_ dl file entries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the complaint_ dl file entries
	 * @return the complaint_ dl file entries, or <code>null</code> if a complaint_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complaint_DlFileEntries fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the complaint_ dl file entries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the complaint_ dl file entries
	 * @return the complaint_ dl file entries, or <code>null</code> if a complaint_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint_DlFileEntries fetchByPrimaryKey(long id)
		throws SystemException {
		Complaint_DlFileEntries complaint_DlFileEntries = (Complaint_DlFileEntries)EntityCacheUtil.getResult(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
				Complaint_DlFileEntriesImpl.class, id);

		if (complaint_DlFileEntries == _nullComplaint_DlFileEntries) {
			return null;
		}

		if (complaint_DlFileEntries == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				complaint_DlFileEntries = (Complaint_DlFileEntries)session.get(Complaint_DlFileEntriesImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (complaint_DlFileEntries != null) {
					cacheResult(complaint_DlFileEntries);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(Complaint_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
						Complaint_DlFileEntriesImpl.class, id,
						_nullComplaint_DlFileEntries);
				}

				closeSession(session);
			}
		}

		return complaint_DlFileEntries;
	}

	/**
	 * Returns all the complaint_ dl file entrieses where complaintId = &#63;.
	 *
	 * @param complaintId the complaint ID
	 * @return the matching complaint_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint_DlFileEntries> findByComplaint(long complaintId)
		throws SystemException {
		return findByComplaint(complaintId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complaint_ dl file entrieses where complaintId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param complaintId the complaint ID
	 * @param start the lower bound of the range of complaint_ dl file entrieses
	 * @param end the upper bound of the range of complaint_ dl file entrieses (not inclusive)
	 * @return the range of matching complaint_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint_DlFileEntries> findByComplaint(long complaintId,
		int start, int end) throws SystemException {
		return findByComplaint(complaintId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaint_ dl file entrieses where complaintId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param complaintId the complaint ID
	 * @param start the lower bound of the range of complaint_ dl file entrieses
	 * @param end the upper bound of the range of complaint_ dl file entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching complaint_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint_DlFileEntries> findByComplaint(long complaintId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLAINT;
			finderArgs = new Object[] { complaintId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPLAINT;
			finderArgs = new Object[] { complaintId, start, end, orderByComparator };
		}

		List<Complaint_DlFileEntries> list = (List<Complaint_DlFileEntries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Complaint_DlFileEntries complaint_DlFileEntries : list) {
				if ((complaintId != complaint_DlFileEntries.getComplaintId())) {
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

			query.append(_SQL_SELECT_COMPLAINT_DLFILEENTRIES_WHERE);

			query.append(_FINDER_COLUMN_COMPLAINT_COMPLAINTID_2);

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

				list = (List<Complaint_DlFileEntries>)QueryUtil.list(q,
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
	 * Returns the first complaint_ dl file entries in the ordered set where complaintId = &#63;.
	 *
	 * @param complaintId the complaint ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaint_ dl file entries
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a matching complaint_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint_DlFileEntries findByComplaint_First(long complaintId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaint_DlFileEntriesException, SystemException {
		Complaint_DlFileEntries complaint_DlFileEntries = fetchByComplaint_First(complaintId,
				orderByComparator);

		if (complaint_DlFileEntries != null) {
			return complaint_DlFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("complaintId=");
		msg.append(complaintId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaint_DlFileEntriesException(msg.toString());
	}

	/**
	 * Returns the first complaint_ dl file entries in the ordered set where complaintId = &#63;.
	 *
	 * @param complaintId the complaint ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaint_ dl file entries, or <code>null</code> if a matching complaint_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint_DlFileEntries fetchByComplaint_First(long complaintId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Complaint_DlFileEntries> list = findByComplaint(complaintId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last complaint_ dl file entries in the ordered set where complaintId = &#63;.
	 *
	 * @param complaintId the complaint ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaint_ dl file entries
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a matching complaint_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint_DlFileEntries findByComplaint_Last(long complaintId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaint_DlFileEntriesException, SystemException {
		Complaint_DlFileEntries complaint_DlFileEntries = fetchByComplaint_Last(complaintId,
				orderByComparator);

		if (complaint_DlFileEntries != null) {
			return complaint_DlFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("complaintId=");
		msg.append(complaintId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaint_DlFileEntriesException(msg.toString());
	}

	/**
	 * Returns the last complaint_ dl file entries in the ordered set where complaintId = &#63;.
	 *
	 * @param complaintId the complaint ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaint_ dl file entries, or <code>null</code> if a matching complaint_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint_DlFileEntries fetchByComplaint_Last(long complaintId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByComplaint(complaintId);

		List<Complaint_DlFileEntries> list = findByComplaint(complaintId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the complaint_ dl file entrieses before and after the current complaint_ dl file entries in the ordered set where complaintId = &#63;.
	 *
	 * @param id the primary key of the current complaint_ dl file entries
	 * @param complaintId the complaint ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next complaint_ dl file entries
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a complaint_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint_DlFileEntries[] findByComplaint_PrevAndNext(long id,
		long complaintId, OrderByComparator orderByComparator)
		throws NoSuchComplaint_DlFileEntriesException, SystemException {
		Complaint_DlFileEntries complaint_DlFileEntries = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Complaint_DlFileEntries[] array = new Complaint_DlFileEntriesImpl[3];

			array[0] = getByComplaint_PrevAndNext(session,
					complaint_DlFileEntries, complaintId, orderByComparator,
					true);

			array[1] = complaint_DlFileEntries;

			array[2] = getByComplaint_PrevAndNext(session,
					complaint_DlFileEntries, complaintId, orderByComparator,
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

	protected Complaint_DlFileEntries getByComplaint_PrevAndNext(
		Session session, Complaint_DlFileEntries complaint_DlFileEntries,
		long complaintId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPLAINT_DLFILEENTRIES_WHERE);

		query.append(_FINDER_COLUMN_COMPLAINT_COMPLAINTID_2);

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
			Object[] values = orderByComparator.getOrderByConditionValues(complaint_DlFileEntries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Complaint_DlFileEntries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the complaint_ dl file entrieses where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching complaint_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint_DlFileEntries> findByDLFile(long fileEntryId)
		throws SystemException {
		return findByDLFile(fileEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the complaint_ dl file entrieses where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of complaint_ dl file entrieses
	 * @param end the upper bound of the range of complaint_ dl file entrieses (not inclusive)
	 * @return the range of matching complaint_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint_DlFileEntries> findByDLFile(long fileEntryId,
		int start, int end) throws SystemException {
		return findByDLFile(fileEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaint_ dl file entrieses where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of complaint_ dl file entrieses
	 * @param end the upper bound of the range of complaint_ dl file entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching complaint_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint_DlFileEntries> findByDLFile(long fileEntryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILE;
			finderArgs = new Object[] { fileEntryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DLFILE;
			finderArgs = new Object[] { fileEntryId, start, end, orderByComparator };
		}

		List<Complaint_DlFileEntries> list = (List<Complaint_DlFileEntries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Complaint_DlFileEntries complaint_DlFileEntries : list) {
				if ((fileEntryId != complaint_DlFileEntries.getFileEntryId())) {
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

			query.append(_SQL_SELECT_COMPLAINT_DLFILEENTRIES_WHERE);

			query.append(_FINDER_COLUMN_DLFILE_FILEENTRYID_2);

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

				list = (List<Complaint_DlFileEntries>)QueryUtil.list(q,
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
	 * Returns the first complaint_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaint_ dl file entries
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a matching complaint_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint_DlFileEntries findByDLFile_First(long fileEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaint_DlFileEntriesException, SystemException {
		Complaint_DlFileEntries complaint_DlFileEntries = fetchByDLFile_First(fileEntryId,
				orderByComparator);

		if (complaint_DlFileEntries != null) {
			return complaint_DlFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileEntryId=");
		msg.append(fileEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaint_DlFileEntriesException(msg.toString());
	}

	/**
	 * Returns the first complaint_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complaint_ dl file entries, or <code>null</code> if a matching complaint_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint_DlFileEntries fetchByDLFile_First(long fileEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Complaint_DlFileEntries> list = findByDLFile(fileEntryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last complaint_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaint_ dl file entries
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a matching complaint_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint_DlFileEntries findByDLFile_Last(long fileEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchComplaint_DlFileEntriesException, SystemException {
		Complaint_DlFileEntries complaint_DlFileEntries = fetchByDLFile_Last(fileEntryId,
				orderByComparator);

		if (complaint_DlFileEntries != null) {
			return complaint_DlFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileEntryId=");
		msg.append(fileEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchComplaint_DlFileEntriesException(msg.toString());
	}

	/**
	 * Returns the last complaint_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complaint_ dl file entries, or <code>null</code> if a matching complaint_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint_DlFileEntries fetchByDLFile_Last(long fileEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDLFile(fileEntryId);

		List<Complaint_DlFileEntries> list = findByDLFile(fileEntryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the complaint_ dl file entrieses before and after the current complaint_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param id the primary key of the current complaint_ dl file entries
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next complaint_ dl file entries
	 * @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a complaint_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint_DlFileEntries[] findByDLFile_PrevAndNext(long id,
		long fileEntryId, OrderByComparator orderByComparator)
		throws NoSuchComplaint_DlFileEntriesException, SystemException {
		Complaint_DlFileEntries complaint_DlFileEntries = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Complaint_DlFileEntries[] array = new Complaint_DlFileEntriesImpl[3];

			array[0] = getByDLFile_PrevAndNext(session,
					complaint_DlFileEntries, fileEntryId, orderByComparator,
					true);

			array[1] = complaint_DlFileEntries;

			array[2] = getByDLFile_PrevAndNext(session,
					complaint_DlFileEntries, fileEntryId, orderByComparator,
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

	protected Complaint_DlFileEntries getByDLFile_PrevAndNext(Session session,
		Complaint_DlFileEntries complaint_DlFileEntries, long fileEntryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPLAINT_DLFILEENTRIES_WHERE);

		query.append(_FINDER_COLUMN_DLFILE_FILEENTRYID_2);

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
			Object[] values = orderByComparator.getOrderByConditionValues(complaint_DlFileEntries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Complaint_DlFileEntries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the complaint_ dl file entrieses.
	 *
	 * @return the complaint_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint_DlFileEntries> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complaint_ dl file entrieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaint_ dl file entrieses
	 * @param end the upper bound of the range of complaint_ dl file entrieses (not inclusive)
	 * @return the range of complaint_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint_DlFileEntries> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaint_ dl file entrieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaint_ dl file entrieses
	 * @param end the upper bound of the range of complaint_ dl file entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of complaint_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint_DlFileEntries> findAll(int start, int end,
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

		List<Complaint_DlFileEntries> list = (List<Complaint_DlFileEntries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMPLAINT_DLFILEENTRIES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMPLAINT_DLFILEENTRIES;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Complaint_DlFileEntries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Complaint_DlFileEntries>)QueryUtil.list(q,
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
	 * Removes all the complaint_ dl file entrieses where complaintId = &#63; from the database.
	 *
	 * @param complaintId the complaint ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByComplaint(long complaintId) throws SystemException {
		for (Complaint_DlFileEntries complaint_DlFileEntries : findByComplaint(
				complaintId)) {
			remove(complaint_DlFileEntries);
		}
	}

	/**
	 * Removes all the complaint_ dl file entrieses where fileEntryId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDLFile(long fileEntryId) throws SystemException {
		for (Complaint_DlFileEntries complaint_DlFileEntries : findByDLFile(
				fileEntryId)) {
			remove(complaint_DlFileEntries);
		}
	}

	/**
	 * Removes all the complaint_ dl file entrieses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Complaint_DlFileEntries complaint_DlFileEntries : findAll()) {
			remove(complaint_DlFileEntries);
		}
	}

	/**
	 * Returns the number of complaint_ dl file entrieses where complaintId = &#63;.
	 *
	 * @param complaintId the complaint ID
	 * @return the number of matching complaint_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByComplaint(long complaintId) throws SystemException {
		Object[] finderArgs = new Object[] { complaintId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPLAINT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPLAINT_DLFILEENTRIES_WHERE);

			query.append(_FINDER_COLUMN_COMPLAINT_COMPLAINTID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPLAINT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of complaint_ dl file entrieses where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the number of matching complaint_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDLFile(long fileEntryId) throws SystemException {
		Object[] finderArgs = new Object[] { fileEntryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DLFILE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPLAINT_DLFILEENTRIES_WHERE);

			query.append(_FINDER_COLUMN_DLFILE_FILEENTRYID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DLFILE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of complaint_ dl file entrieses.
	 *
	 * @return the number of complaint_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMPLAINT_DLFILEENTRIES);

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
	 * Initializes the complaint_ dl file entries persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Complaint_DlFileEntries>> listenersList = new ArrayList<ModelListener<Complaint_DlFileEntries>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Complaint_DlFileEntries>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Complaint_DlFileEntriesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ComplaintPersistence.class)
	protected ComplaintPersistence complaintPersistence;
	@BeanReference(type = Complaint_DlFileEntriesPersistence.class)
	protected Complaint_DlFileEntriesPersistence complaint_DlFileEntriesPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_COMPLAINT_DLFILEENTRIES = "SELECT complaint_DlFileEntries FROM Complaint_DlFileEntries complaint_DlFileEntries";
	private static final String _SQL_SELECT_COMPLAINT_DLFILEENTRIES_WHERE = "SELECT complaint_DlFileEntries FROM Complaint_DlFileEntries complaint_DlFileEntries WHERE ";
	private static final String _SQL_COUNT_COMPLAINT_DLFILEENTRIES = "SELECT COUNT(complaint_DlFileEntries) FROM Complaint_DlFileEntries complaint_DlFileEntries";
	private static final String _SQL_COUNT_COMPLAINT_DLFILEENTRIES_WHERE = "SELECT COUNT(complaint_DlFileEntries) FROM Complaint_DlFileEntries complaint_DlFileEntries WHERE ";
	private static final String _FINDER_COLUMN_COMPLAINT_COMPLAINTID_2 = "complaint_DlFileEntries.complaintId = ?";
	private static final String _FINDER_COLUMN_DLFILE_FILEENTRYID_2 = "complaint_DlFileEntries.fileEntryId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "complaint_DlFileEntries.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Complaint_DlFileEntries exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Complaint_DlFileEntries exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Complaint_DlFileEntriesPersistenceImpl.class);
	private static Complaint_DlFileEntries _nullComplaint_DlFileEntries = new Complaint_DlFileEntriesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Complaint_DlFileEntries> toCacheModel() {
				return _nullComplaint_DlFileEntriesCacheModel;
			}
		};

	private static CacheModel<Complaint_DlFileEntries> _nullComplaint_DlFileEntriesCacheModel =
		new CacheModel<Complaint_DlFileEntries>() {
			public Complaint_DlFileEntries toEntityModel() {
				return _nullComplaint_DlFileEntries;
			}
		};
}