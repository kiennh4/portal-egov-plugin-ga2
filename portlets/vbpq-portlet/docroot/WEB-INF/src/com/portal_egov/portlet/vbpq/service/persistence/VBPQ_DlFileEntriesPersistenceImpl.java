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

package com.portal_egov.portlet.vbpq.service.persistence;

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

import com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException;
import com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries;
import com.portal_egov.portlet.vbpq.model.impl.VBPQ_DlFileEntriesImpl;
import com.portal_egov.portlet.vbpq.model.impl.VBPQ_DlFileEntriesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the v b p q_ dl file entries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see VBPQ_DlFileEntriesPersistence
 * @see VBPQ_DlFileEntriesUtil
 * @generated
 */
public class VBPQ_DlFileEntriesPersistenceImpl extends BasePersistenceImpl<VBPQ_DlFileEntries>
	implements VBPQ_DlFileEntriesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VBPQ_DlFileEntriesUtil} to access the v b p q_ dl file entries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VBPQ_DlFileEntriesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VBPQENTRY =
		new FinderPath(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVBPQEntry",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VBPQENTRY =
		new FinderPath(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVBPQEntry",
			new String[] { Long.class.getName() },
			VBPQ_DlFileEntriesModelImpl.VBPQENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VBPQENTRY = new FinderPath(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVBPQEntry",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DLFILEENTRY =
		new FinderPath(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDLFileEntry",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILEENTRY =
		new FinderPath(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDLFileEntry",
			new String[] { Long.class.getName() },
			VBPQ_DlFileEntriesModelImpl.FILEENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DLFILEENTRY = new FinderPath(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDLFileEntry",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the v b p q_ dl file entries in the entity cache if it is enabled.
	 *
	 * @param vbpq_DlFileEntries the v b p q_ dl file entries
	 */
	public void cacheResult(VBPQ_DlFileEntries vbpq_DlFileEntries) {
		EntityCacheUtil.putResult(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_DlFileEntriesImpl.class, vbpq_DlFileEntries.getPrimaryKey(),
			vbpq_DlFileEntries);

		vbpq_DlFileEntries.resetOriginalValues();
	}

	/**
	 * Caches the v b p q_ dl file entrieses in the entity cache if it is enabled.
	 *
	 * @param vbpq_DlFileEntrieses the v b p q_ dl file entrieses
	 */
	public void cacheResult(List<VBPQ_DlFileEntries> vbpq_DlFileEntrieses) {
		for (VBPQ_DlFileEntries vbpq_DlFileEntries : vbpq_DlFileEntrieses) {
			if (EntityCacheUtil.getResult(
						VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
						VBPQ_DlFileEntriesImpl.class,
						vbpq_DlFileEntries.getPrimaryKey()) == null) {
				cacheResult(vbpq_DlFileEntries);
			}
			else {
				vbpq_DlFileEntries.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v b p q_ dl file entrieses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VBPQ_DlFileEntriesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VBPQ_DlFileEntriesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v b p q_ dl file entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VBPQ_DlFileEntries vbpq_DlFileEntries) {
		EntityCacheUtil.removeResult(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_DlFileEntriesImpl.class, vbpq_DlFileEntries.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VBPQ_DlFileEntries> vbpq_DlFileEntrieses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VBPQ_DlFileEntries vbpq_DlFileEntries : vbpq_DlFileEntrieses) {
			EntityCacheUtil.removeResult(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
				VBPQ_DlFileEntriesImpl.class, vbpq_DlFileEntries.getPrimaryKey());
		}
	}

	/**
	 * Creates a new v b p q_ dl file entries with the primary key. Does not add the v b p q_ dl file entries to the database.
	 *
	 * @param id the primary key for the new v b p q_ dl file entries
	 * @return the new v b p q_ dl file entries
	 */
	public VBPQ_DlFileEntries create(long id) {
		VBPQ_DlFileEntries vbpq_DlFileEntries = new VBPQ_DlFileEntriesImpl();

		vbpq_DlFileEntries.setNew(true);
		vbpq_DlFileEntries.setPrimaryKey(id);

		return vbpq_DlFileEntries;
	}

	/**
	 * Removes the v b p q_ dl file entries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the v b p q_ dl file entries
	 * @return the v b p q_ dl file entries that was removed
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a v b p q_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_DlFileEntries remove(long id)
		throws NoSuchVBPQ_DlFileEntriesException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the v b p q_ dl file entries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v b p q_ dl file entries
	 * @return the v b p q_ dl file entries that was removed
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a v b p q_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VBPQ_DlFileEntries remove(Serializable primaryKey)
		throws NoSuchVBPQ_DlFileEntriesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VBPQ_DlFileEntries vbpq_DlFileEntries = (VBPQ_DlFileEntries)session.get(VBPQ_DlFileEntriesImpl.class,
					primaryKey);

			if (vbpq_DlFileEntries == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVBPQ_DlFileEntriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vbpq_DlFileEntries);
		}
		catch (NoSuchVBPQ_DlFileEntriesException nsee) {
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
	protected VBPQ_DlFileEntries removeImpl(
		VBPQ_DlFileEntries vbpq_DlFileEntries) throws SystemException {
		vbpq_DlFileEntries = toUnwrappedModel(vbpq_DlFileEntries);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vbpq_DlFileEntries);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vbpq_DlFileEntries);

		return vbpq_DlFileEntries;
	}

	@Override
	public VBPQ_DlFileEntries updateImpl(
		com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries vbpq_DlFileEntries,
		boolean merge) throws SystemException {
		vbpq_DlFileEntries = toUnwrappedModel(vbpq_DlFileEntries);

		boolean isNew = vbpq_DlFileEntries.isNew();

		VBPQ_DlFileEntriesModelImpl vbpq_DlFileEntriesModelImpl = (VBPQ_DlFileEntriesModelImpl)vbpq_DlFileEntries;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vbpq_DlFileEntries, merge);

			vbpq_DlFileEntries.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VBPQ_DlFileEntriesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vbpq_DlFileEntriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VBPQENTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vbpq_DlFileEntriesModelImpl.getOriginalVbpqEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VBPQENTRY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VBPQENTRY,
					args);

				args = new Object[] {
						Long.valueOf(vbpq_DlFileEntriesModelImpl.getVbpqEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VBPQENTRY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VBPQENTRY,
					args);
			}

			if ((vbpq_DlFileEntriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILEENTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vbpq_DlFileEntriesModelImpl.getOriginalFileEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DLFILEENTRY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILEENTRY,
					args);

				args = new Object[] {
						Long.valueOf(vbpq_DlFileEntriesModelImpl.getFileEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DLFILEENTRY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILEENTRY,
					args);
			}
		}

		EntityCacheUtil.putResult(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_DlFileEntriesImpl.class, vbpq_DlFileEntries.getPrimaryKey(),
			vbpq_DlFileEntries);

		return vbpq_DlFileEntries;
	}

	protected VBPQ_DlFileEntries toUnwrappedModel(
		VBPQ_DlFileEntries vbpq_DlFileEntries) {
		if (vbpq_DlFileEntries instanceof VBPQ_DlFileEntriesImpl) {
			return vbpq_DlFileEntries;
		}

		VBPQ_DlFileEntriesImpl vbpq_DlFileEntriesImpl = new VBPQ_DlFileEntriesImpl();

		vbpq_DlFileEntriesImpl.setNew(vbpq_DlFileEntries.isNew());
		vbpq_DlFileEntriesImpl.setPrimaryKey(vbpq_DlFileEntries.getPrimaryKey());

		vbpq_DlFileEntriesImpl.setId(vbpq_DlFileEntries.getId());
		vbpq_DlFileEntriesImpl.setVbpqEntryId(vbpq_DlFileEntries.getVbpqEntryId());
		vbpq_DlFileEntriesImpl.setFileEntryId(vbpq_DlFileEntries.getFileEntryId());

		return vbpq_DlFileEntriesImpl;
	}

	/**
	 * Returns the v b p q_ dl file entries with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v b p q_ dl file entries
	 * @return the v b p q_ dl file entries
	 * @throws com.liferay.portal.NoSuchModelException if a v b p q_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VBPQ_DlFileEntries findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the v b p q_ dl file entries with the primary key or throws a {@link com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException} if it could not be found.
	 *
	 * @param id the primary key of the v b p q_ dl file entries
	 * @return the v b p q_ dl file entries
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a v b p q_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_DlFileEntries findByPrimaryKey(long id)
		throws NoSuchVBPQ_DlFileEntriesException, SystemException {
		VBPQ_DlFileEntries vbpq_DlFileEntries = fetchByPrimaryKey(id);

		if (vbpq_DlFileEntries == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchVBPQ_DlFileEntriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return vbpq_DlFileEntries;
	}

	/**
	 * Returns the v b p q_ dl file entries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v b p q_ dl file entries
	 * @return the v b p q_ dl file entries, or <code>null</code> if a v b p q_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VBPQ_DlFileEntries fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the v b p q_ dl file entries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the v b p q_ dl file entries
	 * @return the v b p q_ dl file entries, or <code>null</code> if a v b p q_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_DlFileEntries fetchByPrimaryKey(long id)
		throws SystemException {
		VBPQ_DlFileEntries vbpq_DlFileEntries = (VBPQ_DlFileEntries)EntityCacheUtil.getResult(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
				VBPQ_DlFileEntriesImpl.class, id);

		if (vbpq_DlFileEntries == _nullVBPQ_DlFileEntries) {
			return null;
		}

		if (vbpq_DlFileEntries == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vbpq_DlFileEntries = (VBPQ_DlFileEntries)session.get(VBPQ_DlFileEntriesImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vbpq_DlFileEntries != null) {
					cacheResult(vbpq_DlFileEntries);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VBPQ_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
						VBPQ_DlFileEntriesImpl.class, id,
						_nullVBPQ_DlFileEntries);
				}

				closeSession(session);
			}
		}

		return vbpq_DlFileEntries;
	}

	/**
	 * Returns all the v b p q_ dl file entrieses where vbpqEntryId = &#63;.
	 *
	 * @param vbpqEntryId the vbpq entry ID
	 * @return the matching v b p q_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_DlFileEntries> findByVBPQEntry(long vbpqEntryId)
		throws SystemException {
		return findByVBPQEntry(vbpqEntryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ dl file entrieses where vbpqEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vbpqEntryId the vbpq entry ID
	 * @param start the lower bound of the range of v b p q_ dl file entrieses
	 * @param end the upper bound of the range of v b p q_ dl file entrieses (not inclusive)
	 * @return the range of matching v b p q_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_DlFileEntries> findByVBPQEntry(long vbpqEntryId,
		int start, int end) throws SystemException {
		return findByVBPQEntry(vbpqEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ dl file entrieses where vbpqEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vbpqEntryId the vbpq entry ID
	 * @param start the lower bound of the range of v b p q_ dl file entrieses
	 * @param end the upper bound of the range of v b p q_ dl file entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_DlFileEntries> findByVBPQEntry(long vbpqEntryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VBPQENTRY;
			finderArgs = new Object[] { vbpqEntryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VBPQENTRY;
			finderArgs = new Object[] { vbpqEntryId, start, end, orderByComparator };
		}

		List<VBPQ_DlFileEntries> list = (List<VBPQ_DlFileEntries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_DlFileEntries vbpq_DlFileEntries : list) {
				if ((vbpqEntryId != vbpq_DlFileEntries.getVbpqEntryId())) {
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

			query.append(_SQL_SELECT_VBPQ_DLFILEENTRIES_WHERE);

			query.append(_FINDER_COLUMN_VBPQENTRY_VBPQENTRYID_2);

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

				qPos.add(vbpqEntryId);

				list = (List<VBPQ_DlFileEntries>)QueryUtil.list(q,
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
	 * Returns the first v b p q_ dl file entries in the ordered set where vbpqEntryId = &#63;.
	 *
	 * @param vbpqEntryId the vbpq entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ dl file entries
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a matching v b p q_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_DlFileEntries findByVBPQEntry_First(long vbpqEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_DlFileEntriesException, SystemException {
		VBPQ_DlFileEntries vbpq_DlFileEntries = fetchByVBPQEntry_First(vbpqEntryId,
				orderByComparator);

		if (vbpq_DlFileEntries != null) {
			return vbpq_DlFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vbpqEntryId=");
		msg.append(vbpqEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_DlFileEntriesException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ dl file entries in the ordered set where vbpqEntryId = &#63;.
	 *
	 * @param vbpqEntryId the vbpq entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ dl file entries, or <code>null</code> if a matching v b p q_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_DlFileEntries fetchByVBPQEntry_First(long vbpqEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VBPQ_DlFileEntries> list = findByVBPQEntry(vbpqEntryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ dl file entries in the ordered set where vbpqEntryId = &#63;.
	 *
	 * @param vbpqEntryId the vbpq entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ dl file entries
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a matching v b p q_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_DlFileEntries findByVBPQEntry_Last(long vbpqEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_DlFileEntriesException, SystemException {
		VBPQ_DlFileEntries vbpq_DlFileEntries = fetchByVBPQEntry_Last(vbpqEntryId,
				orderByComparator);

		if (vbpq_DlFileEntries != null) {
			return vbpq_DlFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vbpqEntryId=");
		msg.append(vbpqEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_DlFileEntriesException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ dl file entries in the ordered set where vbpqEntryId = &#63;.
	 *
	 * @param vbpqEntryId the vbpq entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ dl file entries, or <code>null</code> if a matching v b p q_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_DlFileEntries fetchByVBPQEntry_Last(long vbpqEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVBPQEntry(vbpqEntryId);

		List<VBPQ_DlFileEntries> list = findByVBPQEntry(vbpqEntryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ dl file entrieses before and after the current v b p q_ dl file entries in the ordered set where vbpqEntryId = &#63;.
	 *
	 * @param id the primary key of the current v b p q_ dl file entries
	 * @param vbpqEntryId the vbpq entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ dl file entries
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a v b p q_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_DlFileEntries[] findByVBPQEntry_PrevAndNext(long id,
		long vbpqEntryId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_DlFileEntriesException, SystemException {
		VBPQ_DlFileEntries vbpq_DlFileEntries = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VBPQ_DlFileEntries[] array = new VBPQ_DlFileEntriesImpl[3];

			array[0] = getByVBPQEntry_PrevAndNext(session, vbpq_DlFileEntries,
					vbpqEntryId, orderByComparator, true);

			array[1] = vbpq_DlFileEntries;

			array[2] = getByVBPQEntry_PrevAndNext(session, vbpq_DlFileEntries,
					vbpqEntryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_DlFileEntries getByVBPQEntry_PrevAndNext(Session session,
		VBPQ_DlFileEntries vbpq_DlFileEntries, long vbpqEntryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_DLFILEENTRIES_WHERE);

		query.append(_FINDER_COLUMN_VBPQENTRY_VBPQENTRYID_2);

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

		qPos.add(vbpqEntryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_DlFileEntries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_DlFileEntries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ dl file entrieses where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching v b p q_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_DlFileEntries> findByDLFileEntry(long fileEntryId)
		throws SystemException {
		return findByDLFileEntry(fileEntryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ dl file entrieses where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of v b p q_ dl file entrieses
	 * @param end the upper bound of the range of v b p q_ dl file entrieses (not inclusive)
	 * @return the range of matching v b p q_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_DlFileEntries> findByDLFileEntry(long fileEntryId,
		int start, int end) throws SystemException {
		return findByDLFileEntry(fileEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ dl file entrieses where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of v b p q_ dl file entrieses
	 * @param end the upper bound of the range of v b p q_ dl file entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_DlFileEntries> findByDLFileEntry(long fileEntryId,
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

		List<VBPQ_DlFileEntries> list = (List<VBPQ_DlFileEntries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_DlFileEntries vbpq_DlFileEntries : list) {
				if ((fileEntryId != vbpq_DlFileEntries.getFileEntryId())) {
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

			query.append(_SQL_SELECT_VBPQ_DLFILEENTRIES_WHERE);

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

				list = (List<VBPQ_DlFileEntries>)QueryUtil.list(q,
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
	 * Returns the first v b p q_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ dl file entries
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a matching v b p q_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_DlFileEntries findByDLFileEntry_First(long fileEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_DlFileEntriesException, SystemException {
		VBPQ_DlFileEntries vbpq_DlFileEntries = fetchByDLFileEntry_First(fileEntryId,
				orderByComparator);

		if (vbpq_DlFileEntries != null) {
			return vbpq_DlFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileEntryId=");
		msg.append(fileEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_DlFileEntriesException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ dl file entries, or <code>null</code> if a matching v b p q_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_DlFileEntries fetchByDLFileEntry_First(long fileEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VBPQ_DlFileEntries> list = findByDLFileEntry(fileEntryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ dl file entries
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a matching v b p q_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_DlFileEntries findByDLFileEntry_Last(long fileEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_DlFileEntriesException, SystemException {
		VBPQ_DlFileEntries vbpq_DlFileEntries = fetchByDLFileEntry_Last(fileEntryId,
				orderByComparator);

		if (vbpq_DlFileEntries != null) {
			return vbpq_DlFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileEntryId=");
		msg.append(fileEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_DlFileEntriesException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ dl file entries, or <code>null</code> if a matching v b p q_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_DlFileEntries fetchByDLFileEntry_Last(long fileEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDLFileEntry(fileEntryId);

		List<VBPQ_DlFileEntries> list = findByDLFileEntry(fileEntryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ dl file entrieses before and after the current v b p q_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param id the primary key of the current v b p q_ dl file entries
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ dl file entries
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a v b p q_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_DlFileEntries[] findByDLFileEntry_PrevAndNext(long id,
		long fileEntryId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_DlFileEntriesException, SystemException {
		VBPQ_DlFileEntries vbpq_DlFileEntries = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VBPQ_DlFileEntries[] array = new VBPQ_DlFileEntriesImpl[3];

			array[0] = getByDLFileEntry_PrevAndNext(session,
					vbpq_DlFileEntries, fileEntryId, orderByComparator, true);

			array[1] = vbpq_DlFileEntries;

			array[2] = getByDLFileEntry_PrevAndNext(session,
					vbpq_DlFileEntries, fileEntryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_DlFileEntries getByDLFileEntry_PrevAndNext(Session session,
		VBPQ_DlFileEntries vbpq_DlFileEntries, long fileEntryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_DLFILEENTRIES_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_DlFileEntries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_DlFileEntries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ dl file entrieses.
	 *
	 * @return the v b p q_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_DlFileEntries> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ dl file entrieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of v b p q_ dl file entrieses
	 * @param end the upper bound of the range of v b p q_ dl file entrieses (not inclusive)
	 * @return the range of v b p q_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_DlFileEntries> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ dl file entrieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of v b p q_ dl file entrieses
	 * @param end the upper bound of the range of v b p q_ dl file entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v b p q_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_DlFileEntries> findAll(int start, int end,
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

		List<VBPQ_DlFileEntries> list = (List<VBPQ_DlFileEntries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VBPQ_DLFILEENTRIES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VBPQ_DLFILEENTRIES;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VBPQ_DlFileEntries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VBPQ_DlFileEntries>)QueryUtil.list(q,
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
	 * Removes all the v b p q_ dl file entrieses where vbpqEntryId = &#63; from the database.
	 *
	 * @param vbpqEntryId the vbpq entry ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVBPQEntry(long vbpqEntryId) throws SystemException {
		for (VBPQ_DlFileEntries vbpq_DlFileEntries : findByVBPQEntry(
				vbpqEntryId)) {
			remove(vbpq_DlFileEntries);
		}
	}

	/**
	 * Removes all the v b p q_ dl file entrieses where fileEntryId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDLFileEntry(long fileEntryId) throws SystemException {
		for (VBPQ_DlFileEntries vbpq_DlFileEntries : findByDLFileEntry(
				fileEntryId)) {
			remove(vbpq_DlFileEntries);
		}
	}

	/**
	 * Removes all the v b p q_ dl file entrieses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VBPQ_DlFileEntries vbpq_DlFileEntries : findAll()) {
			remove(vbpq_DlFileEntries);
		}
	}

	/**
	 * Returns the number of v b p q_ dl file entrieses where vbpqEntryId = &#63;.
	 *
	 * @param vbpqEntryId the vbpq entry ID
	 * @return the number of matching v b p q_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVBPQEntry(long vbpqEntryId) throws SystemException {
		Object[] finderArgs = new Object[] { vbpqEntryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VBPQENTRY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VBPQ_DLFILEENTRIES_WHERE);

			query.append(_FINDER_COLUMN_VBPQENTRY_VBPQENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vbpqEntryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VBPQENTRY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v b p q_ dl file entrieses where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the number of matching v b p q_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDLFileEntry(long fileEntryId) throws SystemException {
		Object[] finderArgs = new Object[] { fileEntryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DLFILEENTRY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VBPQ_DLFILEENTRIES_WHERE);

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
	 * Returns the number of v b p q_ dl file entrieses.
	 *
	 * @return the number of v b p q_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VBPQ_DLFILEENTRIES);

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
	 * Initializes the v b p q_ dl file entries persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VBPQ_DlFileEntries>> listenersList = new ArrayList<ModelListener<VBPQ_DlFileEntries>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VBPQ_DlFileEntries>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VBPQ_DlFileEntriesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = VBPQ_CategoryPersistence.class)
	protected VBPQ_CategoryPersistence vbpq_CategoryPersistence;
	@BeanReference(type = VBPQ_DlFileEntriesPersistence.class)
	protected VBPQ_DlFileEntriesPersistence vbpq_DlFileEntriesPersistence;
	@BeanReference(type = VBPQ_EntryPersistence.class)
	protected VBPQ_EntryPersistence vbpq_EntryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_VBPQ_DLFILEENTRIES = "SELECT vbpq_DlFileEntries FROM VBPQ_DlFileEntries vbpq_DlFileEntries";
	private static final String _SQL_SELECT_VBPQ_DLFILEENTRIES_WHERE = "SELECT vbpq_DlFileEntries FROM VBPQ_DlFileEntries vbpq_DlFileEntries WHERE ";
	private static final String _SQL_COUNT_VBPQ_DLFILEENTRIES = "SELECT COUNT(vbpq_DlFileEntries) FROM VBPQ_DlFileEntries vbpq_DlFileEntries";
	private static final String _SQL_COUNT_VBPQ_DLFILEENTRIES_WHERE = "SELECT COUNT(vbpq_DlFileEntries) FROM VBPQ_DlFileEntries vbpq_DlFileEntries WHERE ";
	private static final String _FINDER_COLUMN_VBPQENTRY_VBPQENTRYID_2 = "vbpq_DlFileEntries.vbpqEntryId = ?";
	private static final String _FINDER_COLUMN_DLFILEENTRY_FILEENTRYID_2 = "vbpq_DlFileEntries.fileEntryId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vbpq_DlFileEntries.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VBPQ_DlFileEntries exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VBPQ_DlFileEntries exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VBPQ_DlFileEntriesPersistenceImpl.class);
	private static VBPQ_DlFileEntries _nullVBPQ_DlFileEntries = new VBPQ_DlFileEntriesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VBPQ_DlFileEntries> toCacheModel() {
				return _nullVBPQ_DlFileEntriesCacheModel;
			}
		};

	private static CacheModel<VBPQ_DlFileEntries> _nullVBPQ_DlFileEntriesCacheModel =
		new CacheModel<VBPQ_DlFileEntries>() {
			public VBPQ_DlFileEntries toEntityModel() {
				return _nullVBPQ_DlFileEntries;
			}
		};
}