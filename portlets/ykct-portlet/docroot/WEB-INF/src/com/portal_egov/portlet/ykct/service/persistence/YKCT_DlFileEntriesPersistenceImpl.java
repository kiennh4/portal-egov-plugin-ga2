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

package com.portal_egov.portlet.ykct.service.persistence;

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

import com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException;
import com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries;
import com.portal_egov.portlet.ykct.model.impl.YKCT_DlFileEntriesImpl;
import com.portal_egov.portlet.ykct.model.impl.YKCT_DlFileEntriesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the y k c t_ dl file entries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see YKCT_DlFileEntriesPersistence
 * @see YKCT_DlFileEntriesUtil
 * @generated
 */
public class YKCT_DlFileEntriesPersistenceImpl extends BasePersistenceImpl<YKCT_DlFileEntries>
	implements YKCT_DlFileEntriesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link YKCT_DlFileEntriesUtil} to access the y k c t_ dl file entries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = YKCT_DlFileEntriesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_YKCTENTRY =
		new FinderPath(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			YKCT_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByYKCTEntry",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YKCTENTRY =
		new FinderPath(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			YKCT_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYKCTEntry",
			new String[] { Long.class.getName() },
			YKCT_DlFileEntriesModelImpl.YKCTENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_YKCTENTRY = new FinderPath(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYKCTEntry",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DLFILEENTRY =
		new FinderPath(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			YKCT_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDLFileEntry",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILEENTRY =
		new FinderPath(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			YKCT_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDLFileEntry",
			new String[] { Long.class.getName() },
			YKCT_DlFileEntriesModelImpl.FILEENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DLFILEENTRY = new FinderPath(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDLFileEntry",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			YKCT_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED,
			YKCT_DlFileEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_DlFileEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the y k c t_ dl file entries in the entity cache if it is enabled.
	 *
	 * @param ykct_DlFileEntries the y k c t_ dl file entries
	 */
	public void cacheResult(YKCT_DlFileEntries ykct_DlFileEntries) {
		EntityCacheUtil.putResult(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_DlFileEntriesImpl.class, ykct_DlFileEntries.getPrimaryKey(),
			ykct_DlFileEntries);

		ykct_DlFileEntries.resetOriginalValues();
	}

	/**
	 * Caches the y k c t_ dl file entrieses in the entity cache if it is enabled.
	 *
	 * @param ykct_DlFileEntrieses the y k c t_ dl file entrieses
	 */
	public void cacheResult(List<YKCT_DlFileEntries> ykct_DlFileEntrieses) {
		for (YKCT_DlFileEntries ykct_DlFileEntries : ykct_DlFileEntrieses) {
			if (EntityCacheUtil.getResult(
						YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
						YKCT_DlFileEntriesImpl.class,
						ykct_DlFileEntries.getPrimaryKey()) == null) {
				cacheResult(ykct_DlFileEntries);
			}
			else {
				ykct_DlFileEntries.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all y k c t_ dl file entrieses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(YKCT_DlFileEntriesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(YKCT_DlFileEntriesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the y k c t_ dl file entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(YKCT_DlFileEntries ykct_DlFileEntries) {
		EntityCacheUtil.removeResult(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_DlFileEntriesImpl.class, ykct_DlFileEntries.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<YKCT_DlFileEntries> ykct_DlFileEntrieses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (YKCT_DlFileEntries ykct_DlFileEntries : ykct_DlFileEntrieses) {
			EntityCacheUtil.removeResult(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
				YKCT_DlFileEntriesImpl.class, ykct_DlFileEntries.getPrimaryKey());
		}
	}

	/**
	 * Creates a new y k c t_ dl file entries with the primary key. Does not add the y k c t_ dl file entries to the database.
	 *
	 * @param id the primary key for the new y k c t_ dl file entries
	 * @return the new y k c t_ dl file entries
	 */
	public YKCT_DlFileEntries create(long id) {
		YKCT_DlFileEntries ykct_DlFileEntries = new YKCT_DlFileEntriesImpl();

		ykct_DlFileEntries.setNew(true);
		ykct_DlFileEntries.setPrimaryKey(id);

		return ykct_DlFileEntries;
	}

	/**
	 * Removes the y k c t_ dl file entries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the y k c t_ dl file entries
	 * @return the y k c t_ dl file entries that was removed
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a y k c t_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_DlFileEntries remove(long id)
		throws NoSuchYKCT_DlFileEntriesException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the y k c t_ dl file entries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the y k c t_ dl file entries
	 * @return the y k c t_ dl file entries that was removed
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a y k c t_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YKCT_DlFileEntries remove(Serializable primaryKey)
		throws NoSuchYKCT_DlFileEntriesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			YKCT_DlFileEntries ykct_DlFileEntries = (YKCT_DlFileEntries)session.get(YKCT_DlFileEntriesImpl.class,
					primaryKey);

			if (ykct_DlFileEntries == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchYKCT_DlFileEntriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ykct_DlFileEntries);
		}
		catch (NoSuchYKCT_DlFileEntriesException nsee) {
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
	protected YKCT_DlFileEntries removeImpl(
		YKCT_DlFileEntries ykct_DlFileEntries) throws SystemException {
		ykct_DlFileEntries = toUnwrappedModel(ykct_DlFileEntries);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, ykct_DlFileEntries);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(ykct_DlFileEntries);

		return ykct_DlFileEntries;
	}

	@Override
	public YKCT_DlFileEntries updateImpl(
		com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries ykct_DlFileEntries,
		boolean merge) throws SystemException {
		ykct_DlFileEntries = toUnwrappedModel(ykct_DlFileEntries);

		boolean isNew = ykct_DlFileEntries.isNew();

		YKCT_DlFileEntriesModelImpl ykct_DlFileEntriesModelImpl = (YKCT_DlFileEntriesModelImpl)ykct_DlFileEntries;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, ykct_DlFileEntries, merge);

			ykct_DlFileEntries.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !YKCT_DlFileEntriesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ykct_DlFileEntriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YKCTENTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ykct_DlFileEntriesModelImpl.getOriginalYkctEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YKCTENTRY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YKCTENTRY,
					args);

				args = new Object[] {
						Long.valueOf(ykct_DlFileEntriesModelImpl.getYkctEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YKCTENTRY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YKCTENTRY,
					args);
			}

			if ((ykct_DlFileEntriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILEENTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ykct_DlFileEntriesModelImpl.getOriginalFileEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DLFILEENTRY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILEENTRY,
					args);

				args = new Object[] {
						Long.valueOf(ykct_DlFileEntriesModelImpl.getFileEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DLFILEENTRY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DLFILEENTRY,
					args);
			}
		}

		EntityCacheUtil.putResult(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_DlFileEntriesImpl.class, ykct_DlFileEntries.getPrimaryKey(),
			ykct_DlFileEntries);

		return ykct_DlFileEntries;
	}

	protected YKCT_DlFileEntries toUnwrappedModel(
		YKCT_DlFileEntries ykct_DlFileEntries) {
		if (ykct_DlFileEntries instanceof YKCT_DlFileEntriesImpl) {
			return ykct_DlFileEntries;
		}

		YKCT_DlFileEntriesImpl ykct_DlFileEntriesImpl = new YKCT_DlFileEntriesImpl();

		ykct_DlFileEntriesImpl.setNew(ykct_DlFileEntries.isNew());
		ykct_DlFileEntriesImpl.setPrimaryKey(ykct_DlFileEntries.getPrimaryKey());

		ykct_DlFileEntriesImpl.setId(ykct_DlFileEntries.getId());
		ykct_DlFileEntriesImpl.setYkctEntryId(ykct_DlFileEntries.getYkctEntryId());
		ykct_DlFileEntriesImpl.setFileEntryId(ykct_DlFileEntries.getFileEntryId());

		return ykct_DlFileEntriesImpl;
	}

	/**
	 * Returns the y k c t_ dl file entries with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the y k c t_ dl file entries
	 * @return the y k c t_ dl file entries
	 * @throws com.liferay.portal.NoSuchModelException if a y k c t_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YKCT_DlFileEntries findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the y k c t_ dl file entries with the primary key or throws a {@link com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException} if it could not be found.
	 *
	 * @param id the primary key of the y k c t_ dl file entries
	 * @return the y k c t_ dl file entries
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a y k c t_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_DlFileEntries findByPrimaryKey(long id)
		throws NoSuchYKCT_DlFileEntriesException, SystemException {
		YKCT_DlFileEntries ykct_DlFileEntries = fetchByPrimaryKey(id);

		if (ykct_DlFileEntries == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchYKCT_DlFileEntriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return ykct_DlFileEntries;
	}

	/**
	 * Returns the y k c t_ dl file entries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the y k c t_ dl file entries
	 * @return the y k c t_ dl file entries, or <code>null</code> if a y k c t_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YKCT_DlFileEntries fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the y k c t_ dl file entries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the y k c t_ dl file entries
	 * @return the y k c t_ dl file entries, or <code>null</code> if a y k c t_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_DlFileEntries fetchByPrimaryKey(long id)
		throws SystemException {
		YKCT_DlFileEntries ykct_DlFileEntries = (YKCT_DlFileEntries)EntityCacheUtil.getResult(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
				YKCT_DlFileEntriesImpl.class, id);

		if (ykct_DlFileEntries == _nullYKCT_DlFileEntries) {
			return null;
		}

		if (ykct_DlFileEntries == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				ykct_DlFileEntries = (YKCT_DlFileEntries)session.get(YKCT_DlFileEntriesImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (ykct_DlFileEntries != null) {
					cacheResult(ykct_DlFileEntries);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(YKCT_DlFileEntriesModelImpl.ENTITY_CACHE_ENABLED,
						YKCT_DlFileEntriesImpl.class, id,
						_nullYKCT_DlFileEntries);
				}

				closeSession(session);
			}
		}

		return ykct_DlFileEntries;
	}

	/**
	 * Returns all the y k c t_ dl file entrieses where ykctEntryId = &#63;.
	 *
	 * @param ykctEntryId the ykct entry ID
	 * @return the matching y k c t_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_DlFileEntries> findByYKCTEntry(long ykctEntryId)
		throws SystemException {
		return findByYKCTEntry(ykctEntryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the y k c t_ dl file entrieses where ykctEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ykctEntryId the ykct entry ID
	 * @param start the lower bound of the range of y k c t_ dl file entrieses
	 * @param end the upper bound of the range of y k c t_ dl file entrieses (not inclusive)
	 * @return the range of matching y k c t_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_DlFileEntries> findByYKCTEntry(long ykctEntryId,
		int start, int end) throws SystemException {
		return findByYKCTEntry(ykctEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the y k c t_ dl file entrieses where ykctEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ykctEntryId the ykct entry ID
	 * @param start the lower bound of the range of y k c t_ dl file entrieses
	 * @param end the upper bound of the range of y k c t_ dl file entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching y k c t_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_DlFileEntries> findByYKCTEntry(long ykctEntryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YKCTENTRY;
			finderArgs = new Object[] { ykctEntryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_YKCTENTRY;
			finderArgs = new Object[] { ykctEntryId, start, end, orderByComparator };
		}

		List<YKCT_DlFileEntries> list = (List<YKCT_DlFileEntries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (YKCT_DlFileEntries ykct_DlFileEntries : list) {
				if ((ykctEntryId != ykct_DlFileEntries.getYkctEntryId())) {
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

			query.append(_SQL_SELECT_YKCT_DLFILEENTRIES_WHERE);

			query.append(_FINDER_COLUMN_YKCTENTRY_YKCTENTRYID_2);

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

				qPos.add(ykctEntryId);

				list = (List<YKCT_DlFileEntries>)QueryUtil.list(q,
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
	 * Returns the first y k c t_ dl file entries in the ordered set where ykctEntryId = &#63;.
	 *
	 * @param ykctEntryId the ykct entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y k c t_ dl file entries
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a matching y k c t_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_DlFileEntries findByYKCTEntry_First(long ykctEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_DlFileEntriesException, SystemException {
		YKCT_DlFileEntries ykct_DlFileEntries = fetchByYKCTEntry_First(ykctEntryId,
				orderByComparator);

		if (ykct_DlFileEntries != null) {
			return ykct_DlFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ykctEntryId=");
		msg.append(ykctEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYKCT_DlFileEntriesException(msg.toString());
	}

	/**
	 * Returns the first y k c t_ dl file entries in the ordered set where ykctEntryId = &#63;.
	 *
	 * @param ykctEntryId the ykct entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y k c t_ dl file entries, or <code>null</code> if a matching y k c t_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_DlFileEntries fetchByYKCTEntry_First(long ykctEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<YKCT_DlFileEntries> list = findByYKCTEntry(ykctEntryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last y k c t_ dl file entries in the ordered set where ykctEntryId = &#63;.
	 *
	 * @param ykctEntryId the ykct entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y k c t_ dl file entries
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a matching y k c t_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_DlFileEntries findByYKCTEntry_Last(long ykctEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_DlFileEntriesException, SystemException {
		YKCT_DlFileEntries ykct_DlFileEntries = fetchByYKCTEntry_Last(ykctEntryId,
				orderByComparator);

		if (ykct_DlFileEntries != null) {
			return ykct_DlFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ykctEntryId=");
		msg.append(ykctEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYKCT_DlFileEntriesException(msg.toString());
	}

	/**
	 * Returns the last y k c t_ dl file entries in the ordered set where ykctEntryId = &#63;.
	 *
	 * @param ykctEntryId the ykct entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y k c t_ dl file entries, or <code>null</code> if a matching y k c t_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_DlFileEntries fetchByYKCTEntry_Last(long ykctEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByYKCTEntry(ykctEntryId);

		List<YKCT_DlFileEntries> list = findByYKCTEntry(ykctEntryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the y k c t_ dl file entrieses before and after the current y k c t_ dl file entries in the ordered set where ykctEntryId = &#63;.
	 *
	 * @param id the primary key of the current y k c t_ dl file entries
	 * @param ykctEntryId the ykct entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next y k c t_ dl file entries
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a y k c t_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_DlFileEntries[] findByYKCTEntry_PrevAndNext(long id,
		long ykctEntryId, OrderByComparator orderByComparator)
		throws NoSuchYKCT_DlFileEntriesException, SystemException {
		YKCT_DlFileEntries ykct_DlFileEntries = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			YKCT_DlFileEntries[] array = new YKCT_DlFileEntriesImpl[3];

			array[0] = getByYKCTEntry_PrevAndNext(session, ykct_DlFileEntries,
					ykctEntryId, orderByComparator, true);

			array[1] = ykct_DlFileEntries;

			array[2] = getByYKCTEntry_PrevAndNext(session, ykct_DlFileEntries,
					ykctEntryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected YKCT_DlFileEntries getByYKCTEntry_PrevAndNext(Session session,
		YKCT_DlFileEntries ykct_DlFileEntries, long ykctEntryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_YKCT_DLFILEENTRIES_WHERE);

		query.append(_FINDER_COLUMN_YKCTENTRY_YKCTENTRYID_2);

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

		qPos.add(ykctEntryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ykct_DlFileEntries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<YKCT_DlFileEntries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the y k c t_ dl file entrieses where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching y k c t_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_DlFileEntries> findByDLFileEntry(long fileEntryId)
		throws SystemException {
		return findByDLFileEntry(fileEntryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the y k c t_ dl file entrieses where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of y k c t_ dl file entrieses
	 * @param end the upper bound of the range of y k c t_ dl file entrieses (not inclusive)
	 * @return the range of matching y k c t_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_DlFileEntries> findByDLFileEntry(long fileEntryId,
		int start, int end) throws SystemException {
		return findByDLFileEntry(fileEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the y k c t_ dl file entrieses where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of y k c t_ dl file entrieses
	 * @param end the upper bound of the range of y k c t_ dl file entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching y k c t_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_DlFileEntries> findByDLFileEntry(long fileEntryId,
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

		List<YKCT_DlFileEntries> list = (List<YKCT_DlFileEntries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (YKCT_DlFileEntries ykct_DlFileEntries : list) {
				if ((fileEntryId != ykct_DlFileEntries.getFileEntryId())) {
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

			query.append(_SQL_SELECT_YKCT_DLFILEENTRIES_WHERE);

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

				list = (List<YKCT_DlFileEntries>)QueryUtil.list(q,
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
	 * Returns the first y k c t_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y k c t_ dl file entries
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a matching y k c t_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_DlFileEntries findByDLFileEntry_First(long fileEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_DlFileEntriesException, SystemException {
		YKCT_DlFileEntries ykct_DlFileEntries = fetchByDLFileEntry_First(fileEntryId,
				orderByComparator);

		if (ykct_DlFileEntries != null) {
			return ykct_DlFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileEntryId=");
		msg.append(fileEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYKCT_DlFileEntriesException(msg.toString());
	}

	/**
	 * Returns the first y k c t_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y k c t_ dl file entries, or <code>null</code> if a matching y k c t_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_DlFileEntries fetchByDLFileEntry_First(long fileEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<YKCT_DlFileEntries> list = findByDLFileEntry(fileEntryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last y k c t_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y k c t_ dl file entries
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a matching y k c t_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_DlFileEntries findByDLFileEntry_Last(long fileEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_DlFileEntriesException, SystemException {
		YKCT_DlFileEntries ykct_DlFileEntries = fetchByDLFileEntry_Last(fileEntryId,
				orderByComparator);

		if (ykct_DlFileEntries != null) {
			return ykct_DlFileEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileEntryId=");
		msg.append(fileEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYKCT_DlFileEntriesException(msg.toString());
	}

	/**
	 * Returns the last y k c t_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y k c t_ dl file entries, or <code>null</code> if a matching y k c t_ dl file entries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_DlFileEntries fetchByDLFileEntry_Last(long fileEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDLFileEntry(fileEntryId);

		List<YKCT_DlFileEntries> list = findByDLFileEntry(fileEntryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the y k c t_ dl file entrieses before and after the current y k c t_ dl file entries in the ordered set where fileEntryId = &#63;.
	 *
	 * @param id the primary key of the current y k c t_ dl file entries
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next y k c t_ dl file entries
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a y k c t_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_DlFileEntries[] findByDLFileEntry_PrevAndNext(long id,
		long fileEntryId, OrderByComparator orderByComparator)
		throws NoSuchYKCT_DlFileEntriesException, SystemException {
		YKCT_DlFileEntries ykct_DlFileEntries = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			YKCT_DlFileEntries[] array = new YKCT_DlFileEntriesImpl[3];

			array[0] = getByDLFileEntry_PrevAndNext(session,
					ykct_DlFileEntries, fileEntryId, orderByComparator, true);

			array[1] = ykct_DlFileEntries;

			array[2] = getByDLFileEntry_PrevAndNext(session,
					ykct_DlFileEntries, fileEntryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected YKCT_DlFileEntries getByDLFileEntry_PrevAndNext(Session session,
		YKCT_DlFileEntries ykct_DlFileEntries, long fileEntryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_YKCT_DLFILEENTRIES_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(ykct_DlFileEntries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<YKCT_DlFileEntries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the y k c t_ dl file entrieses.
	 *
	 * @return the y k c t_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_DlFileEntries> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the y k c t_ dl file entrieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of y k c t_ dl file entrieses
	 * @param end the upper bound of the range of y k c t_ dl file entrieses (not inclusive)
	 * @return the range of y k c t_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_DlFileEntries> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the y k c t_ dl file entrieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of y k c t_ dl file entrieses
	 * @param end the upper bound of the range of y k c t_ dl file entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of y k c t_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_DlFileEntries> findAll(int start, int end,
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

		List<YKCT_DlFileEntries> list = (List<YKCT_DlFileEntries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_YKCT_DLFILEENTRIES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_YKCT_DLFILEENTRIES;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<YKCT_DlFileEntries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<YKCT_DlFileEntries>)QueryUtil.list(q,
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
	 * Removes all the y k c t_ dl file entrieses where ykctEntryId = &#63; from the database.
	 *
	 * @param ykctEntryId the ykct entry ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByYKCTEntry(long ykctEntryId) throws SystemException {
		for (YKCT_DlFileEntries ykct_DlFileEntries : findByYKCTEntry(
				ykctEntryId)) {
			remove(ykct_DlFileEntries);
		}
	}

	/**
	 * Removes all the y k c t_ dl file entrieses where fileEntryId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDLFileEntry(long fileEntryId) throws SystemException {
		for (YKCT_DlFileEntries ykct_DlFileEntries : findByDLFileEntry(
				fileEntryId)) {
			remove(ykct_DlFileEntries);
		}
	}

	/**
	 * Removes all the y k c t_ dl file entrieses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (YKCT_DlFileEntries ykct_DlFileEntries : findAll()) {
			remove(ykct_DlFileEntries);
		}
	}

	/**
	 * Returns the number of y k c t_ dl file entrieses where ykctEntryId = &#63;.
	 *
	 * @param ykctEntryId the ykct entry ID
	 * @return the number of matching y k c t_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByYKCTEntry(long ykctEntryId) throws SystemException {
		Object[] finderArgs = new Object[] { ykctEntryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_YKCTENTRY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YKCT_DLFILEENTRIES_WHERE);

			query.append(_FINDER_COLUMN_YKCTENTRY_YKCTENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ykctEntryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_YKCTENTRY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of y k c t_ dl file entrieses where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the number of matching y k c t_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDLFileEntry(long fileEntryId) throws SystemException {
		Object[] finderArgs = new Object[] { fileEntryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DLFILEENTRY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YKCT_DLFILEENTRIES_WHERE);

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
	 * Returns the number of y k c t_ dl file entrieses.
	 *
	 * @return the number of y k c t_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_YKCT_DLFILEENTRIES);

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
	 * Initializes the y k c t_ dl file entries persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<YKCT_DlFileEntries>> listenersList = new ArrayList<ModelListener<YKCT_DlFileEntries>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<YKCT_DlFileEntries>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(YKCT_DlFileEntriesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = YKCT_CategoryPersistence.class)
	protected YKCT_CategoryPersistence ykct_CategoryPersistence;
	@BeanReference(type = YKCT_DlFileEntriesPersistence.class)
	protected YKCT_DlFileEntriesPersistence ykct_DlFileEntriesPersistence;
	@BeanReference(type = YKCT_EntryPersistence.class)
	protected YKCT_EntryPersistence ykct_EntryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_YKCT_DLFILEENTRIES = "SELECT ykct_DlFileEntries FROM YKCT_DlFileEntries ykct_DlFileEntries";
	private static final String _SQL_SELECT_YKCT_DLFILEENTRIES_WHERE = "SELECT ykct_DlFileEntries FROM YKCT_DlFileEntries ykct_DlFileEntries WHERE ";
	private static final String _SQL_COUNT_YKCT_DLFILEENTRIES = "SELECT COUNT(ykct_DlFileEntries) FROM YKCT_DlFileEntries ykct_DlFileEntries";
	private static final String _SQL_COUNT_YKCT_DLFILEENTRIES_WHERE = "SELECT COUNT(ykct_DlFileEntries) FROM YKCT_DlFileEntries ykct_DlFileEntries WHERE ";
	private static final String _FINDER_COLUMN_YKCTENTRY_YKCTENTRYID_2 = "ykct_DlFileEntries.ykctEntryId = ?";
	private static final String _FINDER_COLUMN_DLFILEENTRY_FILEENTRYID_2 = "ykct_DlFileEntries.fileEntryId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ykct_DlFileEntries.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No YKCT_DlFileEntries exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No YKCT_DlFileEntries exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(YKCT_DlFileEntriesPersistenceImpl.class);
	private static YKCT_DlFileEntries _nullYKCT_DlFileEntries = new YKCT_DlFileEntriesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<YKCT_DlFileEntries> toCacheModel() {
				return _nullYKCT_DlFileEntriesCacheModel;
			}
		};

	private static CacheModel<YKCT_DlFileEntries> _nullYKCT_DlFileEntriesCacheModel =
		new CacheModel<YKCT_DlFileEntries>() {
			public YKCT_DlFileEntries toEntityModel() {
				return _nullYKCT_DlFileEntries;
			}
		};
}