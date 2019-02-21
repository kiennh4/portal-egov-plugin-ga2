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

import com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException;
import com.portal_egov.portlet.ykct.model.YKCT_Entry;
import com.portal_egov.portlet.ykct.model.impl.YKCT_EntryImpl;
import com.portal_egov.portlet.ykct.model.impl.YKCT_EntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the y k c t_ entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see YKCT_EntryPersistence
 * @see YKCT_EntryUtil
 * @generated
 */
public class YKCT_EntryPersistenceImpl extends BasePersistenceImpl<YKCT_Entry>
	implements YKCT_EntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link YKCT_EntryUtil} to access the y k c t_ entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = YKCT_EntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryModelImpl.FINDER_CACHE_ENABLED, YKCT_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryModelImpl.FINDER_CACHE_ENABLED, YKCT_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			YKCT_EntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryModelImpl.FINDER_CACHE_ENABLED, YKCT_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryModelImpl.FINDER_CACHE_ENABLED, YKCT_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			YKCT_EntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryModelImpl.FINDER_CACHE_ENABLED, YKCT_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategory",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryModelImpl.FINDER_CACHE_ENABLED, YKCT_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { Long.class.getName() },
			YKCT_EntryModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryModelImpl.FINDER_CACHE_ENABLED, YKCT_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryModelImpl.FINDER_CACHE_ENABLED, YKCT_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the y k c t_ entry in the entity cache if it is enabled.
	 *
	 * @param ykct_Entry the y k c t_ entry
	 */
	public void cacheResult(YKCT_Entry ykct_Entry) {
		EntityCacheUtil.putResult(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryImpl.class, ykct_Entry.getPrimaryKey(), ykct_Entry);

		ykct_Entry.resetOriginalValues();
	}

	/**
	 * Caches the y k c t_ entries in the entity cache if it is enabled.
	 *
	 * @param ykct_Entries the y k c t_ entries
	 */
	public void cacheResult(List<YKCT_Entry> ykct_Entries) {
		for (YKCT_Entry ykct_Entry : ykct_Entries) {
			if (EntityCacheUtil.getResult(
						YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
						YKCT_EntryImpl.class, ykct_Entry.getPrimaryKey()) == null) {
				cacheResult(ykct_Entry);
			}
			else {
				ykct_Entry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all y k c t_ entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(YKCT_EntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(YKCT_EntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the y k c t_ entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(YKCT_Entry ykct_Entry) {
		EntityCacheUtil.removeResult(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryImpl.class, ykct_Entry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<YKCT_Entry> ykct_Entries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (YKCT_Entry ykct_Entry : ykct_Entries) {
			EntityCacheUtil.removeResult(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
				YKCT_EntryImpl.class, ykct_Entry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new y k c t_ entry with the primary key. Does not add the y k c t_ entry to the database.
	 *
	 * @param entryId the primary key for the new y k c t_ entry
	 * @return the new y k c t_ entry
	 */
	public YKCT_Entry create(long entryId) {
		YKCT_Entry ykct_Entry = new YKCT_EntryImpl();

		ykct_Entry.setNew(true);
		ykct_Entry.setPrimaryKey(entryId);

		return ykct_Entry;
	}

	/**
	 * Removes the y k c t_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the y k c t_ entry
	 * @return the y k c t_ entry that was removed
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a y k c t_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry remove(long entryId)
		throws NoSuchYKCT_EntryException, SystemException {
		return remove(Long.valueOf(entryId));
	}

	/**
	 * Removes the y k c t_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the y k c t_ entry
	 * @return the y k c t_ entry that was removed
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a y k c t_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YKCT_Entry remove(Serializable primaryKey)
		throws NoSuchYKCT_EntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			YKCT_Entry ykct_Entry = (YKCT_Entry)session.get(YKCT_EntryImpl.class,
					primaryKey);

			if (ykct_Entry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchYKCT_EntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ykct_Entry);
		}
		catch (NoSuchYKCT_EntryException nsee) {
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
	protected YKCT_Entry removeImpl(YKCT_Entry ykct_Entry)
		throws SystemException {
		ykct_Entry = toUnwrappedModel(ykct_Entry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, ykct_Entry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(ykct_Entry);

		return ykct_Entry;
	}

	@Override
	public YKCT_Entry updateImpl(
		com.portal_egov.portlet.ykct.model.YKCT_Entry ykct_Entry, boolean merge)
		throws SystemException {
		ykct_Entry = toUnwrappedModel(ykct_Entry);

		boolean isNew = ykct_Entry.isNew();

		YKCT_EntryModelImpl ykct_EntryModelImpl = (YKCT_EntryModelImpl)ykct_Entry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, ykct_Entry, merge);

			ykct_Entry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !YKCT_EntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ykct_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ykct_EntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(ykct_EntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((ykct_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ykct_EntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(ykct_EntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((ykct_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ykct_EntryModelImpl.getOriginalCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] {
						Long.valueOf(ykct_EntryModelImpl.getCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_EntryImpl.class, ykct_Entry.getPrimaryKey(), ykct_Entry);

		return ykct_Entry;
	}

	protected YKCT_Entry toUnwrappedModel(YKCT_Entry ykct_Entry) {
		if (ykct_Entry instanceof YKCT_EntryImpl) {
			return ykct_Entry;
		}

		YKCT_EntryImpl ykct_EntryImpl = new YKCT_EntryImpl();

		ykct_EntryImpl.setNew(ykct_Entry.isNew());
		ykct_EntryImpl.setPrimaryKey(ykct_Entry.getPrimaryKey());

		ykct_EntryImpl.setEntryId(ykct_Entry.getEntryId());
		ykct_EntryImpl.setGroupId(ykct_Entry.getGroupId());
		ykct_EntryImpl.setCompanyId(ykct_Entry.getCompanyId());
		ykct_EntryImpl.setUserId(ykct_Entry.getUserId());
		ykct_EntryImpl.setUserName(ykct_Entry.getUserName());
		ykct_EntryImpl.setCreateDate(ykct_Entry.getCreateDate());
		ykct_EntryImpl.setModifiedDate(ykct_Entry.getModifiedDate());
		ykct_EntryImpl.setEntryName(ykct_Entry.getEntryName());
		ykct_EntryImpl.setCategoryId(ykct_Entry.getCategoryId());
		ykct_EntryImpl.setFileAttachmentURL(ykct_Entry.getFileAttachmentURL());

		return ykct_EntryImpl;
	}

	/**
	 * Returns the y k c t_ entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the y k c t_ entry
	 * @return the y k c t_ entry
	 * @throws com.liferay.portal.NoSuchModelException if a y k c t_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YKCT_Entry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the y k c t_ entry with the primary key or throws a {@link com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException} if it could not be found.
	 *
	 * @param entryId the primary key of the y k c t_ entry
	 * @return the y k c t_ entry
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a y k c t_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry findByPrimaryKey(long entryId)
		throws NoSuchYKCT_EntryException, SystemException {
		YKCT_Entry ykct_Entry = fetchByPrimaryKey(entryId);

		if (ykct_Entry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entryId);
			}

			throw new NoSuchYKCT_EntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				entryId);
		}

		return ykct_Entry;
	}

	/**
	 * Returns the y k c t_ entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the y k c t_ entry
	 * @return the y k c t_ entry, or <code>null</code> if a y k c t_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YKCT_Entry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the y k c t_ entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the y k c t_ entry
	 * @return the y k c t_ entry, or <code>null</code> if a y k c t_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry fetchByPrimaryKey(long entryId) throws SystemException {
		YKCT_Entry ykct_Entry = (YKCT_Entry)EntityCacheUtil.getResult(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
				YKCT_EntryImpl.class, entryId);

		if (ykct_Entry == _nullYKCT_Entry) {
			return null;
		}

		if (ykct_Entry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				ykct_Entry = (YKCT_Entry)session.get(YKCT_EntryImpl.class,
						Long.valueOf(entryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (ykct_Entry != null) {
					cacheResult(ykct_Entry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(YKCT_EntryModelImpl.ENTITY_CACHE_ENABLED,
						YKCT_EntryImpl.class, entryId, _nullYKCT_Entry);
				}

				closeSession(session);
			}
		}

		return ykct_Entry;
	}

	/**
	 * Returns all the y k c t_ entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Entry> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the y k c t_ entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of y k c t_ entries
	 * @param end the upper bound of the range of y k c t_ entries (not inclusive)
	 * @return the range of matching y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Entry> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the y k c t_ entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of y k c t_ entries
	 * @param end the upper bound of the range of y k c t_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Entry> findByCompany(long companyId, int start, int end,
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

		List<YKCT_Entry> list = (List<YKCT_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (YKCT_Entry ykct_Entry : list) {
				if ((companyId != ykct_Entry.getCompanyId())) {
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

			query.append(_SQL_SELECT_YKCT_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(YKCT_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<YKCT_Entry>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first y k c t_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y k c t_ entry
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_EntryException, SystemException {
		YKCT_Entry ykct_Entry = fetchByCompany_First(companyId,
				orderByComparator);

		if (ykct_Entry != null) {
			return ykct_Entry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYKCT_EntryException(msg.toString());
	}

	/**
	 * Returns the first y k c t_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<YKCT_Entry> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last y k c t_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y k c t_ entry
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_EntryException, SystemException {
		YKCT_Entry ykct_Entry = fetchByCompany_Last(companyId, orderByComparator);

		if (ykct_Entry != null) {
			return ykct_Entry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYKCT_EntryException(msg.toString());
	}

	/**
	 * Returns the last y k c t_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<YKCT_Entry> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the y k c t_ entries before and after the current y k c t_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param entryId the primary key of the current y k c t_ entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next y k c t_ entry
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a y k c t_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry[] findByCompany_PrevAndNext(long entryId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_EntryException, SystemException {
		YKCT_Entry ykct_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			YKCT_Entry[] array = new YKCT_EntryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, ykct_Entry, companyId,
					orderByComparator, true);

			array[1] = ykct_Entry;

			array[2] = getByCompany_PrevAndNext(session, ykct_Entry, companyId,
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

	protected YKCT_Entry getByCompany_PrevAndNext(Session session,
		YKCT_Entry ykct_Entry, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_YKCT_ENTRY_WHERE);

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
			query.append(YKCT_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ykct_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<YKCT_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the y k c t_ entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Entry> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the y k c t_ entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of y k c t_ entries
	 * @param end the upper bound of the range of y k c t_ entries (not inclusive)
	 * @return the range of matching y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Entry> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the y k c t_ entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of y k c t_ entries
	 * @param end the upper bound of the range of y k c t_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Entry> findByGroup(long groupId, int start, int end,
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

		List<YKCT_Entry> list = (List<YKCT_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (YKCT_Entry ykct_Entry : list) {
				if ((groupId != ykct_Entry.getGroupId())) {
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

			query.append(_SQL_SELECT_YKCT_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(YKCT_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<YKCT_Entry>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first y k c t_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y k c t_ entry
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_EntryException, SystemException {
		YKCT_Entry ykct_Entry = fetchByGroup_First(groupId, orderByComparator);

		if (ykct_Entry != null) {
			return ykct_Entry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYKCT_EntryException(msg.toString());
	}

	/**
	 * Returns the first y k c t_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<YKCT_Entry> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last y k c t_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y k c t_ entry
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_EntryException, SystemException {
		YKCT_Entry ykct_Entry = fetchByGroup_Last(groupId, orderByComparator);

		if (ykct_Entry != null) {
			return ykct_Entry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYKCT_EntryException(msg.toString());
	}

	/**
	 * Returns the last y k c t_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<YKCT_Entry> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the y k c t_ entries before and after the current y k c t_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param entryId the primary key of the current y k c t_ entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next y k c t_ entry
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a y k c t_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry[] findByGroup_PrevAndNext(long entryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_EntryException, SystemException {
		YKCT_Entry ykct_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			YKCT_Entry[] array = new YKCT_EntryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, ykct_Entry, groupId,
					orderByComparator, true);

			array[1] = ykct_Entry;

			array[2] = getByGroup_PrevAndNext(session, ykct_Entry, groupId,
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

	protected YKCT_Entry getByGroup_PrevAndNext(Session session,
		YKCT_Entry ykct_Entry, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_YKCT_ENTRY_WHERE);

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
			query.append(YKCT_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ykct_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<YKCT_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the y k c t_ entries where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Entry> findByCategory(long categoryId)
		throws SystemException {
		return findByCategory(categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the y k c t_ entries where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of y k c t_ entries
	 * @param end the upper bound of the range of y k c t_ entries (not inclusive)
	 * @return the range of matching y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Entry> findByCategory(long categoryId, int start, int end)
		throws SystemException {
		return findByCategory(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the y k c t_ entries where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of y k c t_ entries
	 * @param end the upper bound of the range of y k c t_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Entry> findByCategory(long categoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId, start, end, orderByComparator };
		}

		List<YKCT_Entry> list = (List<YKCT_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (YKCT_Entry ykct_Entry : list) {
				if ((categoryId != ykct_Entry.getCategoryId())) {
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

			query.append(_SQL_SELECT_YKCT_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(YKCT_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				list = (List<YKCT_Entry>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first y k c t_ entry in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y k c t_ entry
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry findByCategory_First(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_EntryException, SystemException {
		YKCT_Entry ykct_Entry = fetchByCategory_First(categoryId,
				orderByComparator);

		if (ykct_Entry != null) {
			return ykct_Entry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYKCT_EntryException(msg.toString());
	}

	/**
	 * Returns the first y k c t_ entry in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry fetchByCategory_First(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<YKCT_Entry> list = findByCategory(categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last y k c t_ entry in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y k c t_ entry
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry findByCategory_Last(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_EntryException, SystemException {
		YKCT_Entry ykct_Entry = fetchByCategory_Last(categoryId,
				orderByComparator);

		if (ykct_Entry != null) {
			return ykct_Entry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYKCT_EntryException(msg.toString());
	}

	/**
	 * Returns the last y k c t_ entry in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry fetchByCategory_Last(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(categoryId);

		List<YKCT_Entry> list = findByCategory(categoryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the y k c t_ entries before and after the current y k c t_ entry in the ordered set where categoryId = &#63;.
	 *
	 * @param entryId the primary key of the current y k c t_ entry
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next y k c t_ entry
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a y k c t_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Entry[] findByCategory_PrevAndNext(long entryId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchYKCT_EntryException, SystemException {
		YKCT_Entry ykct_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			YKCT_Entry[] array = new YKCT_EntryImpl[3];

			array[0] = getByCategory_PrevAndNext(session, ykct_Entry,
					categoryId, orderByComparator, true);

			array[1] = ykct_Entry;

			array[2] = getByCategory_PrevAndNext(session, ykct_Entry,
					categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected YKCT_Entry getByCategory_PrevAndNext(Session session,
		YKCT_Entry ykct_Entry, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_YKCT_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

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
			query.append(YKCT_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ykct_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<YKCT_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the y k c t_ entries.
	 *
	 * @return the y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Entry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the y k c t_ entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of y k c t_ entries
	 * @param end the upper bound of the range of y k c t_ entries (not inclusive)
	 * @return the range of y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Entry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the y k c t_ entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of y k c t_ entries
	 * @param end the upper bound of the range of y k c t_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Entry> findAll(int start, int end,
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

		List<YKCT_Entry> list = (List<YKCT_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_YKCT_ENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_YKCT_ENTRY.concat(YKCT_EntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<YKCT_Entry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<YKCT_Entry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the y k c t_ entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (YKCT_Entry ykct_Entry : findByCompany(companyId)) {
			remove(ykct_Entry);
		}
	}

	/**
	 * Removes all the y k c t_ entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (YKCT_Entry ykct_Entry : findByGroup(groupId)) {
			remove(ykct_Entry);
		}
	}

	/**
	 * Removes all the y k c t_ entries where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategory(long categoryId) throws SystemException {
		for (YKCT_Entry ykct_Entry : findByCategory(categoryId)) {
			remove(ykct_Entry);
		}
	}

	/**
	 * Removes all the y k c t_ entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (YKCT_Entry ykct_Entry : findAll()) {
			remove(ykct_Entry);
		}
	}

	/**
	 * Returns the number of y k c t_ entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YKCT_ENTRY_WHERE);

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
	 * Returns the number of y k c t_ entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YKCT_ENTRY_WHERE);

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
	 * Returns the number of y k c t_ entries where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategory(long categoryId) throws SystemException {
		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YKCT_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of y k c t_ entries.
	 *
	 * @return the number of y k c t_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_YKCT_ENTRY);

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
	 * Initializes the y k c t_ entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.ykct.model.YKCT_Entry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<YKCT_Entry>> listenersList = new ArrayList<ModelListener<YKCT_Entry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<YKCT_Entry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(YKCT_EntryImpl.class.getName());
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
	private static final String _SQL_SELECT_YKCT_ENTRY = "SELECT ykct_Entry FROM YKCT_Entry ykct_Entry";
	private static final String _SQL_SELECT_YKCT_ENTRY_WHERE = "SELECT ykct_Entry FROM YKCT_Entry ykct_Entry WHERE ";
	private static final String _SQL_COUNT_YKCT_ENTRY = "SELECT COUNT(ykct_Entry) FROM YKCT_Entry ykct_Entry";
	private static final String _SQL_COUNT_YKCT_ENTRY_WHERE = "SELECT COUNT(ykct_Entry) FROM YKCT_Entry ykct_Entry WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "ykct_Entry.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "ykct_Entry.groupId = ?";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 = "ykct_Entry.categoryId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ykct_Entry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No YKCT_Entry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No YKCT_Entry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(YKCT_EntryPersistenceImpl.class);
	private static YKCT_Entry _nullYKCT_Entry = new YKCT_EntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<YKCT_Entry> toCacheModel() {
				return _nullYKCT_EntryCacheModel;
			}
		};

	private static CacheModel<YKCT_Entry> _nullYKCT_EntryCacheModel = new CacheModel<YKCT_Entry>() {
			public YKCT_Entry toEntityModel() {
				return _nullYKCT_Entry;
			}
		};
}