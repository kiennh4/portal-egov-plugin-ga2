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

package com.portal_egov.portlet.legal_faq.service.persistence;

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

import com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;
import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;
import com.portal_egov.portlet.legal_faq.model.impl.LegalFAQEntryImpl;
import com.portal_egov.portlet.legal_faq.model.impl.LegalFAQEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the legal f a q entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see LegalFAQEntryPersistence
 * @see LegalFAQEntryUtil
 * @generated
 */
public class LegalFAQEntryPersistenceImpl extends BasePersistenceImpl<LegalFAQEntry>
	implements LegalFAQEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegalFAQEntryUtil} to access the legal f a q entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegalFAQEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompany", new String[] { Long.class.getName() },
			LegalFAQEntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroup", new String[] { Long.class.getName() },
			LegalFAQEntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategory",
			new String[] { Long.class.getName(), Long.class.getName() },
			LegalFAQEntryModelImpl.GROUPID_COLUMN_BITMASK |
			LegalFAQEntryModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDSTATUS =
		new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategoryAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUS =
		new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			},
			LegalFAQEntryModelImpl.GROUPID_COLUMN_BITMASK |
			LegalFAQEntryModelImpl.CATEGORYID_COLUMN_BITMASK |
			LegalFAQEntryModelImpl.PUBLISHSTATUS_COLUMN_BITMASK |
			LegalFAQEntryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDSTATUS = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYANDSTATUS =
		new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS =
		new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			LegalFAQEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalFAQEntryModelImpl.PUBLISHSTATUS_COLUMN_BITMASK |
			LegalFAQEntryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYANDSTATUS = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDSTATUS =
		new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS =
		new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			LegalFAQEntryModelImpl.GROUPID_COLUMN_BITMASK |
			LegalFAQEntryModelImpl.PUBLISHSTATUS_COLUMN_BITMASK |
			LegalFAQEntryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDSTATUS = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			LegalFAQEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalFAQEntryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHSTATUS =
		new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPublishStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHSTATUS =
		new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			LegalFAQEntryModelImpl.GROUPID_COLUMN_BITMASK |
			LegalFAQEntryModelImpl.PUBLISHSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHSTATUS = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublishStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the legal f a q entry in the entity cache if it is enabled.
	 *
	 * @param legalFAQEntry the legal f a q entry
	 */
	public void cacheResult(LegalFAQEntry legalFAQEntry) {
		EntityCacheUtil.putResult(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryImpl.class, legalFAQEntry.getPrimaryKey(),
			legalFAQEntry);

		legalFAQEntry.resetOriginalValues();
	}

	/**
	 * Caches the legal f a q entries in the entity cache if it is enabled.
	 *
	 * @param legalFAQEntries the legal f a q entries
	 */
	public void cacheResult(List<LegalFAQEntry> legalFAQEntries) {
		for (LegalFAQEntry legalFAQEntry : legalFAQEntries) {
			if (EntityCacheUtil.getResult(
						LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
						LegalFAQEntryImpl.class, legalFAQEntry.getPrimaryKey()) == null) {
				cacheResult(legalFAQEntry);
			}
			else {
				legalFAQEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal f a q entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegalFAQEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegalFAQEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal f a q entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalFAQEntry legalFAQEntry) {
		EntityCacheUtil.removeResult(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryImpl.class, legalFAQEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegalFAQEntry> legalFAQEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalFAQEntry legalFAQEntry : legalFAQEntries) {
			EntityCacheUtil.removeResult(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
				LegalFAQEntryImpl.class, legalFAQEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legal f a q entry with the primary key. Does not add the legal f a q entry to the database.
	 *
	 * @param entryId the primary key for the new legal f a q entry
	 * @return the new legal f a q entry
	 */
	public LegalFAQEntry create(long entryId) {
		LegalFAQEntry legalFAQEntry = new LegalFAQEntryImpl();

		legalFAQEntry.setNew(true);
		legalFAQEntry.setPrimaryKey(entryId);

		return legalFAQEntry;
	}

	/**
	 * Removes the legal f a q entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the legal f a q entry
	 * @return the legal f a q entry that was removed
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry remove(long entryId)
		throws NoSuchLegalFAQEntryException, SystemException {
		return remove(Long.valueOf(entryId));
	}

	/**
	 * Removes the legal f a q entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal f a q entry
	 * @return the legal f a q entry that was removed
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalFAQEntry remove(Serializable primaryKey)
		throws NoSuchLegalFAQEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegalFAQEntry legalFAQEntry = (LegalFAQEntry)session.get(LegalFAQEntryImpl.class,
					primaryKey);

			if (legalFAQEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalFAQEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legalFAQEntry);
		}
		catch (NoSuchLegalFAQEntryException nsee) {
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
	protected LegalFAQEntry removeImpl(LegalFAQEntry legalFAQEntry)
		throws SystemException {
		legalFAQEntry = toUnwrappedModel(legalFAQEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, legalFAQEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(legalFAQEntry);

		return legalFAQEntry;
	}

	@Override
	public LegalFAQEntry updateImpl(
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry,
		boolean merge) throws SystemException {
		legalFAQEntry = toUnwrappedModel(legalFAQEntry);

		boolean isNew = legalFAQEntry.isNew();

		LegalFAQEntryModelImpl legalFAQEntryModelImpl = (LegalFAQEntryModelImpl)legalFAQEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, legalFAQEntry, merge);

			legalFAQEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LegalFAQEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((legalFAQEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((legalFAQEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((legalFAQEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getOriginalGroupId()),
						Long.valueOf(legalFAQEntryModelImpl.getOriginalCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getGroupId()),
						Long.valueOf(legalFAQEntryModelImpl.getCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}

			if ((legalFAQEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getOriginalGroupId()),
						Long.valueOf(legalFAQEntryModelImpl.getOriginalCategoryId()),
						Integer.valueOf(legalFAQEntryModelImpl.getOriginalPublishStatus()),
						Integer.valueOf(legalFAQEntryModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getGroupId()),
						Long.valueOf(legalFAQEntryModelImpl.getCategoryId()),
						Integer.valueOf(legalFAQEntryModelImpl.getPublishStatus()),
						Integer.valueOf(legalFAQEntryModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUS,
					args);
			}

			if ((legalFAQEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getOriginalCompanyId()),
						Integer.valueOf(legalFAQEntryModelImpl.getOriginalPublishStatus()),
						Integer.valueOf(legalFAQEntryModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getCompanyId()),
						Integer.valueOf(legalFAQEntryModelImpl.getPublishStatus()),
						Integer.valueOf(legalFAQEntryModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS,
					args);
			}

			if ((legalFAQEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getOriginalGroupId()),
						Integer.valueOf(legalFAQEntryModelImpl.getOriginalPublishStatus()),
						Integer.valueOf(legalFAQEntryModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getGroupId()),
						Integer.valueOf(legalFAQEntryModelImpl.getPublishStatus()),
						Integer.valueOf(legalFAQEntryModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS,
					args);
			}

			if ((legalFAQEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getOriginalCompanyId()),
						Integer.valueOf(legalFAQEntryModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getCompanyId()),
						Integer.valueOf(legalFAQEntryModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((legalFAQEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getOriginalGroupId()),
						Integer.valueOf(legalFAQEntryModelImpl.getOriginalPublishStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(legalFAQEntryModelImpl.getGroupId()),
						Integer.valueOf(legalFAQEntryModelImpl.getPublishStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQEntryImpl.class, legalFAQEntry.getPrimaryKey(),
			legalFAQEntry);

		return legalFAQEntry;
	}

	protected LegalFAQEntry toUnwrappedModel(LegalFAQEntry legalFAQEntry) {
		if (legalFAQEntry instanceof LegalFAQEntryImpl) {
			return legalFAQEntry;
		}

		LegalFAQEntryImpl legalFAQEntryImpl = new LegalFAQEntryImpl();

		legalFAQEntryImpl.setNew(legalFAQEntry.isNew());
		legalFAQEntryImpl.setPrimaryKey(legalFAQEntry.getPrimaryKey());

		legalFAQEntryImpl.setEntryId(legalFAQEntry.getEntryId());
		legalFAQEntryImpl.setCompanyId(legalFAQEntry.getCompanyId());
		legalFAQEntryImpl.setGroupId(legalFAQEntry.getGroupId());
		legalFAQEntryImpl.setUserId(legalFAQEntry.getUserId());
		legalFAQEntryImpl.setUserName(legalFAQEntry.getUserName());
		legalFAQEntryImpl.setCategoryId(legalFAQEntry.getCategoryId());
		legalFAQEntryImpl.setCitizenName(legalFAQEntry.getCitizenName());
		legalFAQEntryImpl.setCitizenPhone(legalFAQEntry.getCitizenPhone());
		legalFAQEntryImpl.setCitizenEmail(legalFAQEntry.getCitizenEmail());
		legalFAQEntryImpl.setCitizenAddress(legalFAQEntry.getCitizenAddress());
		legalFAQEntryImpl.setAskDate(legalFAQEntry.getAskDate());
		legalFAQEntryImpl.setAskTitle(legalFAQEntry.getAskTitle());
		legalFAQEntryImpl.setAskContent(legalFAQEntry.getAskContent());
		legalFAQEntryImpl.setAnswerDate(legalFAQEntry.getAnswerDate());
		legalFAQEntryImpl.setAnswerContent(legalFAQEntry.getAnswerContent());
		legalFAQEntryImpl.setCreateDate(legalFAQEntry.getCreateDate());
		legalFAQEntryImpl.setModifiedDate(legalFAQEntry.getModifiedDate());
		legalFAQEntryImpl.setPublishDate(legalFAQEntry.getPublishDate());
		legalFAQEntryImpl.setAttachmentId(legalFAQEntry.getAttachmentId());
		legalFAQEntryImpl.setViewCount(legalFAQEntry.getViewCount());
		legalFAQEntryImpl.setPublishStatus(legalFAQEntry.getPublishStatus());
		legalFAQEntryImpl.setStatus(legalFAQEntry.getStatus());

		return legalFAQEntryImpl;
	}

	/**
	 * Returns the legal f a q entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal f a q entry
	 * @return the legal f a q entry
	 * @throws com.liferay.portal.NoSuchModelException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalFAQEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the legal f a q entry with the primary key or throws a {@link com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException} if it could not be found.
	 *
	 * @param entryId the primary key of the legal f a q entry
	 * @return the legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByPrimaryKey(long entryId)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByPrimaryKey(entryId);

		if (legalFAQEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entryId);
			}

			throw new NoSuchLegalFAQEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				entryId);
		}

		return legalFAQEntry;
	}

	/**
	 * Returns the legal f a q entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal f a q entry
	 * @return the legal f a q entry, or <code>null</code> if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalFAQEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the legal f a q entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the legal f a q entry
	 * @return the legal f a q entry, or <code>null</code> if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByPrimaryKey(long entryId)
		throws SystemException {
		LegalFAQEntry legalFAQEntry = (LegalFAQEntry)EntityCacheUtil.getResult(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
				LegalFAQEntryImpl.class, entryId);

		if (legalFAQEntry == _nullLegalFAQEntry) {
			return null;
		}

		if (legalFAQEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				legalFAQEntry = (LegalFAQEntry)session.get(LegalFAQEntryImpl.class,
						Long.valueOf(entryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (legalFAQEntry != null) {
					cacheResult(legalFAQEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LegalFAQEntryModelImpl.ENTITY_CACHE_ENABLED,
						LegalFAQEntryImpl.class, entryId, _nullLegalFAQEntry);
				}

				closeSession(session);
			}
		}

		return legalFAQEntry;
	}

	/**
	 * Returns all the legal f a q entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal f a q entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @return the range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByCompany(long companyId, int start,
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

		List<LegalFAQEntry> list = (List<LegalFAQEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegalFAQEntry legalFAQEntry : list) {
				if ((companyId != legalFAQEntry.getCompanyId())) {
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

			query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal f a q entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByCompany_First(companyId,
				orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the first legal f a q entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegalFAQEntry> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByCompany_Last(companyId,
				orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<LegalFAQEntry> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where companyId = &#63;.
	 *
	 * @param entryId the primary key of the current legal f a q entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry[] findByCompany_PrevAndNext(long entryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQEntry[] array = new LegalFAQEntryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, legalFAQEntry,
					companyId, orderByComparator, true);

			array[1] = legalFAQEntry;

			array[2] = getByCompany_PrevAndNext(session, legalFAQEntry,
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

	protected LegalFAQEntry getByCompany_PrevAndNext(Session session,
		LegalFAQEntry legalFAQEntry, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

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
			query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @return the range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByGroup(long groupId, int start, int end,
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

		List<LegalFAQEntry> list = (List<LegalFAQEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegalFAQEntry legalFAQEntry : list) {
				if ((groupId != legalFAQEntry.getGroupId())) {
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

			query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal f a q entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByGroup_First(groupId,
				orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the first legal f a q entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegalFAQEntry> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByGroup_Last(groupId,
				orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<LegalFAQEntry> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where groupId = &#63;.
	 *
	 * @param entryId the primary key of the current legal f a q entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry[] findByGroup_PrevAndNext(long entryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQEntry[] array = new LegalFAQEntryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, legalFAQEntry, groupId,
					orderByComparator, true);

			array[1] = legalFAQEntry;

			array[2] = getByGroup_PrevAndNext(session, legalFAQEntry, groupId,
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

	protected LegalFAQEntry getByGroup_PrevAndNext(Session session,
		LegalFAQEntry legalFAQEntry, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

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
			query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal f a q entries that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @return the range of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q entries that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LegalFAQEntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LegalFAQEntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the legal f a q entries before and after the current legal f a q entry in the ordered set of legal f a q entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param entryId the primary key of the current legal f a q entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry[] filterFindByGroup_PrevAndNext(long entryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(entryId, groupId, orderByComparator);
		}

		LegalFAQEntry legalFAQEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQEntry[] array = new LegalFAQEntryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, legalFAQEntry,
					groupId, orderByComparator, true);

			array[1] = legalFAQEntry;

			array[2] = filterGetByGroup_PrevAndNext(session, legalFAQEntry,
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

	protected LegalFAQEntry filterGetByGroup_PrevAndNext(Session session,
		LegalFAQEntry legalFAQEntry, long groupId,
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
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, LegalFAQEntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, LegalFAQEntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q entries where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByCategory(long groupId, long categoryId)
		throws SystemException {
		return findByCategory(groupId, categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q entries where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @return the range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByCategory(long groupId, long categoryId,
		int start, int end) throws SystemException {
		return findByCategory(groupId, categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q entries where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByCategory(long groupId, long categoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { groupId, categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] {
					groupId, categoryId,
					
					start, end, orderByComparator
				};
		}

		List<LegalFAQEntry> list = (List<LegalFAQEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegalFAQEntry legalFAQEntry : list) {
				if ((groupId != legalFAQEntry.getGroupId()) ||
						(categoryId != legalFAQEntry.getCategoryId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				list = (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByCategory_First(long groupId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByCategory_First(groupId,
				categoryId, orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the first legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByCategory_First(long groupId, long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegalFAQEntry> list = findByCategory(groupId, categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByCategory_Last(long groupId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByCategory_Last(groupId, categoryId,
				orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByCategory_Last(long groupId, long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(groupId, categoryId);

		List<LegalFAQEntry> list = findByCategory(groupId, categoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param entryId the primary key of the current legal f a q entry
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry[] findByCategory_PrevAndNext(long entryId,
		long groupId, long categoryId, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQEntry[] array = new LegalFAQEntryImpl[3];

			array[0] = getByCategory_PrevAndNext(session, legalFAQEntry,
					groupId, categoryId, orderByComparator, true);

			array[1] = legalFAQEntry;

			array[2] = getByCategory_PrevAndNext(session, legalFAQEntry,
					groupId, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalFAQEntry getByCategory_PrevAndNext(Session session,
		LegalFAQEntry legalFAQEntry, long groupId, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_GROUPID_2);

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
			query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByCategory(long groupId,
		long categoryId) throws SystemException {
		return filterFindByCategory(groupId, categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @return the range of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByCategory(long groupId,
		long categoryId, int start, int end) throws SystemException {
		return filterFindByCategory(groupId, categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q entries that the user has permissions to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByCategory(long groupId,
		long categoryId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategory(groupId, categoryId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORY_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LegalFAQEntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LegalFAQEntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

			return (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the legal f a q entries before and after the current legal f a q entry in the ordered set of legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param entryId the primary key of the current legal f a q entry
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry[] filterFindByCategory_PrevAndNext(long entryId,
		long groupId, long categoryId, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategory_PrevAndNext(entryId, groupId, categoryId,
				orderByComparator);
		}

		LegalFAQEntry legalFAQEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQEntry[] array = new LegalFAQEntryImpl[3];

			array[0] = filterGetByCategory_PrevAndNext(session, legalFAQEntry,
					groupId, categoryId, orderByComparator, true);

			array[1] = legalFAQEntry;

			array[2] = filterGetByCategory_PrevAndNext(session, legalFAQEntry,
					groupId, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalFAQEntry filterGetByCategory_PrevAndNext(Session session,
		LegalFAQEntry legalFAQEntry, long groupId, long categoryId,
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
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORY_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, LegalFAQEntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, LegalFAQEntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q entries where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @return the matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByCategoryAndStatus(long groupId,
		long categoryId, int publishStatus, int status)
		throws SystemException {
		return findByCategoryAndStatus(groupId, categoryId, publishStatus,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q entries where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @return the range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByCategoryAndStatus(long groupId,
		long categoryId, int publishStatus, int status, int start, int end)
		throws SystemException {
		return findByCategoryAndStatus(groupId, categoryId, publishStatus,
			status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q entries where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByCategoryAndStatus(long groupId,
		long categoryId, int publishStatus, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUS;
			finderArgs = new Object[] { groupId, categoryId, publishStatus, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDSTATUS;
			finderArgs = new Object[] {
					groupId, categoryId, publishStatus, status,
					
					start, end, orderByComparator
				};
		}

		List<LegalFAQEntry> list = (List<LegalFAQEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegalFAQEntry legalFAQEntry : list) {
				if ((groupId != legalFAQEntry.getGroupId()) ||
						(categoryId != legalFAQEntry.getCategoryId()) ||
						(publishStatus != legalFAQEntry.getPublishStatus()) ||
						(status != legalFAQEntry.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_PUBLISHSTATUS_2);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				qPos.add(publishStatus);

				qPos.add(status);

				list = (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByCategoryAndStatus_First(long groupId,
		long categoryId, int publishStatus, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByCategoryAndStatus_First(groupId,
				categoryId, publishStatus, status, orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(", publishStatus=");
		msg.append(publishStatus);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the first legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByCategoryAndStatus_First(long groupId,
		long categoryId, int publishStatus, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegalFAQEntry> list = findByCategoryAndStatus(groupId, categoryId,
				publishStatus, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByCategoryAndStatus_Last(long groupId,
		long categoryId, int publishStatus, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByCategoryAndStatus_Last(groupId,
				categoryId, publishStatus, status, orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(", publishStatus=");
		msg.append(publishStatus);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByCategoryAndStatus_Last(long groupId,
		long categoryId, int publishStatus, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategoryAndStatus(groupId, categoryId,
				publishStatus, status);

		List<LegalFAQEntry> list = findByCategoryAndStatus(groupId, categoryId,
				publishStatus, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current legal f a q entry
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry[] findByCategoryAndStatus_PrevAndNext(long entryId,
		long groupId, long categoryId, int publishStatus, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQEntry[] array = new LegalFAQEntryImpl[3];

			array[0] = getByCategoryAndStatus_PrevAndNext(session,
					legalFAQEntry, groupId, categoryId, publishStatus, status,
					orderByComparator, true);

			array[1] = legalFAQEntry;

			array[2] = getByCategoryAndStatus_PrevAndNext(session,
					legalFAQEntry, groupId, categoryId, publishStatus, status,
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

	protected LegalFAQEntry getByCategoryAndStatus_PrevAndNext(
		Session session, LegalFAQEntry legalFAQEntry, long groupId,
		long categoryId, int publishStatus, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_PUBLISHSTATUS_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_STATUS_2);

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
			query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		qPos.add(publishStatus);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @return the matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByCategoryAndStatus(long groupId,
		long categoryId, int publishStatus, int status)
		throws SystemException {
		return filterFindByCategoryAndStatus(groupId, categoryId,
			publishStatus, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @return the range of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByCategoryAndStatus(long groupId,
		long categoryId, int publishStatus, int status, int start, int end)
		throws SystemException {
		return filterFindByCategoryAndStatus(groupId, categoryId,
			publishStatus, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q entries that the user has permissions to view where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByCategoryAndStatus(long groupId,
		long categoryId, int publishStatus, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryAndStatus(groupId, categoryId, publishStatus,
				status, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_PUBLISHSTATUS_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LegalFAQEntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LegalFAQEntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

			qPos.add(publishStatus);

			qPos.add(status);

			return (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the legal f a q entries before and after the current legal f a q entry in the ordered set of legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current legal f a q entry
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry[] filterFindByCategoryAndStatus_PrevAndNext(
		long entryId, long groupId, long categoryId, int publishStatus,
		int status, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryAndStatus_PrevAndNext(entryId, groupId,
				categoryId, publishStatus, status, orderByComparator);
		}

		LegalFAQEntry legalFAQEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQEntry[] array = new LegalFAQEntryImpl[3];

			array[0] = filterGetByCategoryAndStatus_PrevAndNext(session,
					legalFAQEntry, groupId, categoryId, publishStatus, status,
					orderByComparator, true);

			array[1] = legalFAQEntry;

			array[2] = filterGetByCategoryAndStatus_PrevAndNext(session,
					legalFAQEntry, groupId, categoryId, publishStatus, status,
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

	protected LegalFAQEntry filterGetByCategoryAndStatus_PrevAndNext(
		Session session, LegalFAQEntry legalFAQEntry, long groupId,
		long categoryId, int publishStatus, int status,
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
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_PUBLISHSTATUS_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, LegalFAQEntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, LegalFAQEntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		qPos.add(publishStatus);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q entries where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @return the matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByCompanyAndStatus(long companyId,
		int publishStatus, int status) throws SystemException {
		return findByCompanyAndStatus(companyId, publishStatus, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q entries where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @return the range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByCompanyAndStatus(long companyId,
		int publishStatus, int status, int start, int end)
		throws SystemException {
		return findByCompanyAndStatus(companyId, publishStatus, status, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q entries where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByCompanyAndStatus(long companyId,
		int publishStatus, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS;
			finderArgs = new Object[] { companyId, publishStatus, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYANDSTATUS;
			finderArgs = new Object[] {
					companyId, publishStatus, status,
					
					start, end, orderByComparator
				};
		}

		List<LegalFAQEntry> list = (List<LegalFAQEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegalFAQEntry legalFAQEntry : list) {
				if ((companyId != legalFAQEntry.getCompanyId()) ||
						(publishStatus != legalFAQEntry.getPublishStatus()) ||
						(status != legalFAQEntry.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_PUBLISHSTATUS_2);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(publishStatus);

				qPos.add(status);

				list = (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal f a q entry in the ordered set where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByCompanyAndStatus_First(long companyId,
		int publishStatus, int status, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByCompanyAndStatus_First(companyId,
				publishStatus, status, orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", publishStatus=");
		msg.append(publishStatus);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the first legal f a q entry in the ordered set where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByCompanyAndStatus_First(long companyId,
		int publishStatus, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<LegalFAQEntry> list = findByCompanyAndStatus(companyId,
				publishStatus, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByCompanyAndStatus_Last(long companyId,
		int publishStatus, int status, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByCompanyAndStatus_Last(companyId,
				publishStatus, status, orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", publishStatus=");
		msg.append(publishStatus);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByCompanyAndStatus_Last(long companyId,
		int publishStatus, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyAndStatus(companyId, publishStatus, status);

		List<LegalFAQEntry> list = findByCompanyAndStatus(companyId,
				publishStatus, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current legal f a q entry
	 * @param companyId the company ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry[] findByCompanyAndStatus_PrevAndNext(long entryId,
		long companyId, int publishStatus, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQEntry[] array = new LegalFAQEntryImpl[3];

			array[0] = getByCompanyAndStatus_PrevAndNext(session,
					legalFAQEntry, companyId, publishStatus, status,
					orderByComparator, true);

			array[1] = legalFAQEntry;

			array[2] = getByCompanyAndStatus_PrevAndNext(session,
					legalFAQEntry, companyId, publishStatus, status,
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

	protected LegalFAQEntry getByCompanyAndStatus_PrevAndNext(Session session,
		LegalFAQEntry legalFAQEntry, long companyId, int publishStatus,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

		query.append(_FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYANDSTATUS_PUBLISHSTATUS_2);

		query.append(_FINDER_COLUMN_COMPANYANDSTATUS_STATUS_2);

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
			query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(publishStatus);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q entries where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @return the matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByGroupAndStatus(long groupId,
		int publishStatus, int status) throws SystemException {
		return findByGroupAndStatus(groupId, publishStatus, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q entries where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @return the range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByGroupAndStatus(long groupId,
		int publishStatus, int status, int start, int end)
		throws SystemException {
		return findByGroupAndStatus(groupId, publishStatus, status, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the legal f a q entries where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByGroupAndStatus(long groupId,
		int publishStatus, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS;
			finderArgs = new Object[] { groupId, publishStatus, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDSTATUS;
			finderArgs = new Object[] {
					groupId, publishStatus, status,
					
					start, end, orderByComparator
				};
		}

		List<LegalFAQEntry> list = (List<LegalFAQEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegalFAQEntry legalFAQEntry : list) {
				if ((groupId != legalFAQEntry.getGroupId()) ||
						(publishStatus != legalFAQEntry.getPublishStatus()) ||
						(status != legalFAQEntry.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_PUBLISHSTATUS_2);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(publishStatus);

				qPos.add(status);

				list = (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByGroupAndStatus_First(long groupId,
		int publishStatus, int status, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByGroupAndStatus_First(groupId,
				publishStatus, status, orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", publishStatus=");
		msg.append(publishStatus);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the first legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByGroupAndStatus_First(long groupId,
		int publishStatus, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<LegalFAQEntry> list = findByGroupAndStatus(groupId, publishStatus,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByGroupAndStatus_Last(long groupId,
		int publishStatus, int status, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByGroupAndStatus_Last(groupId,
				publishStatus, status, orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", publishStatus=");
		msg.append(publishStatus);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByGroupAndStatus_Last(long groupId,
		int publishStatus, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupAndStatus(groupId, publishStatus, status);

		List<LegalFAQEntry> list = findByGroupAndStatus(groupId, publishStatus,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current legal f a q entry
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry[] findByGroupAndStatus_PrevAndNext(long entryId,
		long groupId, int publishStatus, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQEntry[] array = new LegalFAQEntryImpl[3];

			array[0] = getByGroupAndStatus_PrevAndNext(session, legalFAQEntry,
					groupId, publishStatus, status, orderByComparator, true);

			array[1] = legalFAQEntry;

			array[2] = getByGroupAndStatus_PrevAndNext(session, legalFAQEntry,
					groupId, publishStatus, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalFAQEntry getByGroupAndStatus_PrevAndNext(Session session,
		LegalFAQEntry legalFAQEntry, long groupId, int publishStatus,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_PUBLISHSTATUS_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_STATUS_2);

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
			query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(publishStatus);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @return the matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByGroupAndStatus(long groupId,
		int publishStatus, int status) throws SystemException {
		return filterFindByGroupAndStatus(groupId, publishStatus, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @return the range of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByGroupAndStatus(long groupId,
		int publishStatus, int status, int start, int end)
		throws SystemException {
		return filterFindByGroupAndStatus(groupId, publishStatus, status,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q entries that the user has permissions to view where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByGroupAndStatus(long groupId,
		int publishStatus, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupAndStatus(groupId, publishStatus, status, start,
				end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_PUBLISHSTATUS_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LegalFAQEntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LegalFAQEntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(publishStatus);

			qPos.add(status);

			return (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the legal f a q entries before and after the current legal f a q entry in the ordered set of legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current legal f a q entry
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry[] filterFindByGroupAndStatus_PrevAndNext(
		long entryId, long groupId, int publishStatus, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupAndStatus_PrevAndNext(entryId, groupId,
				publishStatus, status, orderByComparator);
		}

		LegalFAQEntry legalFAQEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQEntry[] array = new LegalFAQEntryImpl[3];

			array[0] = filterGetByGroupAndStatus_PrevAndNext(session,
					legalFAQEntry, groupId, publishStatus, status,
					orderByComparator, true);

			array[1] = legalFAQEntry;

			array[2] = filterGetByGroupAndStatus_PrevAndNext(session,
					legalFAQEntry, groupId, publishStatus, status,
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

	protected LegalFAQEntry filterGetByGroupAndStatus_PrevAndNext(
		Session session, LegalFAQEntry legalFAQEntry, long groupId,
		int publishStatus, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_PUBLISHSTATUS_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, LegalFAQEntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, LegalFAQEntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(publishStatus);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByStatus(long companyId, int status)
		throws SystemException {
		return findByStatus(companyId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @return the range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByStatus(long companyId, int status,
		int start, int end) throws SystemException {
		return findByStatus(companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q entries where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByStatus(long companyId, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { companyId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] {
					companyId, status,
					
					start, end, orderByComparator
				};
		}

		List<LegalFAQEntry> list = (List<LegalFAQEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegalFAQEntry legalFAQEntry : list) {
				if ((companyId != legalFAQEntry.getCompanyId()) ||
						(status != legalFAQEntry.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(status);

				list = (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal f a q entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByStatus_First(long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByStatus_First(companyId, status,
				orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the first legal f a q entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByStatus_First(long companyId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegalFAQEntry> list = findByStatus(companyId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByStatus_Last(long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByStatus_Last(companyId, status,
				orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByStatus_Last(long companyId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(companyId, status);

		List<LegalFAQEntry> list = findByStatus(companyId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current legal f a q entry
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry[] findByStatus_PrevAndNext(long entryId,
		long companyId, int status, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQEntry[] array = new LegalFAQEntryImpl[3];

			array[0] = getByStatus_PrevAndNext(session, legalFAQEntry,
					companyId, status, orderByComparator, true);

			array[1] = legalFAQEntry;

			array[2] = getByStatus_PrevAndNext(session, legalFAQEntry,
					companyId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalFAQEntry getByStatus_PrevAndNext(Session session,
		LegalFAQEntry legalFAQEntry, long companyId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

		query.append(_FINDER_COLUMN_STATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q entries where groupId = &#63; and publishStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @return the matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByPublishStatus(long groupId,
		int publishStatus) throws SystemException {
		return findByPublishStatus(groupId, publishStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q entries where groupId = &#63; and publishStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @return the range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByPublishStatus(long groupId,
		int publishStatus, int start, int end) throws SystemException {
		return findByPublishStatus(groupId, publishStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q entries where groupId = &#63; and publishStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findByPublishStatus(long groupId,
		int publishStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHSTATUS;
			finderArgs = new Object[] { groupId, publishStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHSTATUS;
			finderArgs = new Object[] {
					groupId, publishStatus,
					
					start, end, orderByComparator
				};
		}

		List<LegalFAQEntry> list = (List<LegalFAQEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegalFAQEntry legalFAQEntry : list) {
				if ((groupId != legalFAQEntry.getGroupId()) ||
						(publishStatus != legalFAQEntry.getPublishStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_PUBLISHSTATUS_PUBLISHSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(publishStatus);

				list = (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByPublishStatus_First(long groupId,
		int publishStatus, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByPublishStatus_First(groupId,
				publishStatus, orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", publishStatus=");
		msg.append(publishStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the first legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByPublishStatus_First(long groupId,
		int publishStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<LegalFAQEntry> list = findByPublishStatus(groupId, publishStatus,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry findByPublishStatus_Last(long groupId,
		int publishStatus, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = fetchByPublishStatus_Last(groupId,
				publishStatus, orderByComparator);

		if (legalFAQEntry != null) {
			return legalFAQEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", publishStatus=");
		msg.append(publishStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQEntryException(msg.toString());
	}

	/**
	 * Returns the last legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry fetchByPublishStatus_Last(long groupId,
		int publishStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPublishStatus(groupId, publishStatus);

		List<LegalFAQEntry> list = findByPublishStatus(groupId, publishStatus,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63;.
	 *
	 * @param entryId the primary key of the current legal f a q entry
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry[] findByPublishStatus_PrevAndNext(long entryId,
		long groupId, int publishStatus, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		LegalFAQEntry legalFAQEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQEntry[] array = new LegalFAQEntryImpl[3];

			array[0] = getByPublishStatus_PrevAndNext(session, legalFAQEntry,
					groupId, publishStatus, orderByComparator, true);

			array[1] = legalFAQEntry;

			array[2] = getByPublishStatus_PrevAndNext(session, legalFAQEntry,
					groupId, publishStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalFAQEntry getByPublishStatus_PrevAndNext(Session session,
		LegalFAQEntry legalFAQEntry, long groupId, int publishStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFAQENTRY_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_PUBLISHSTATUS_PUBLISHSTATUS_2);

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
			query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(publishStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @return the matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByPublishStatus(long groupId,
		int publishStatus) throws SystemException {
		return filterFindByPublishStatus(groupId, publishStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @return the range of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByPublishStatus(long groupId,
		int publishStatus, int start, int end) throws SystemException {
		return filterFindByPublishStatus(groupId, publishStatus, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the legal f a q entries that the user has permissions to view where groupId = &#63; and publishStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> filterFindByPublishStatus(long groupId,
		int publishStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByPublishStatus(groupId, publishStatus, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PUBLISHSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_PUBLISHSTATUS_PUBLISHSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LegalFAQEntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LegalFAQEntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(publishStatus);

			return (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the legal f a q entries before and after the current legal f a q entry in the ordered set of legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63;.
	 *
	 * @param entryId the primary key of the current legal f a q entry
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q entry
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQEntry[] filterFindByPublishStatus_PrevAndNext(long entryId,
		long groupId, int publishStatus, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQEntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByPublishStatus_PrevAndNext(entryId, groupId,
				publishStatus, orderByComparator);
		}

		LegalFAQEntry legalFAQEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQEntry[] array = new LegalFAQEntryImpl[3];

			array[0] = filterGetByPublishStatus_PrevAndNext(session,
					legalFAQEntry, groupId, publishStatus, orderByComparator,
					true);

			array[1] = legalFAQEntry;

			array[2] = filterGetByPublishStatus_PrevAndNext(session,
					legalFAQEntry, groupId, publishStatus, orderByComparator,
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

	protected LegalFAQEntry filterGetByPublishStatus_PrevAndNext(
		Session session, LegalFAQEntry legalFAQEntry, long groupId,
		int publishStatus, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PUBLISHSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_PUBLISHSTATUS_PUBLISHSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LegalFAQEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, LegalFAQEntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, LegalFAQEntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(publishStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q entries.
	 *
	 * @return the legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @return the range of legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal f a q entries
	 * @param end the upper bound of the range of legal f a q entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQEntry> findAll(int start, int end,
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

		List<LegalFAQEntry> list = (List<LegalFAQEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGALFAQENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALFAQENTRY.concat(LegalFAQEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LegalFAQEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the legal f a q entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (LegalFAQEntry legalFAQEntry : findByCompany(companyId)) {
			remove(legalFAQEntry);
		}
	}

	/**
	 * Removes all the legal f a q entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (LegalFAQEntry legalFAQEntry : findByGroup(groupId)) {
			remove(legalFAQEntry);
		}
	}

	/**
	 * Removes all the legal f a q entries where groupId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategory(long groupId, long categoryId)
		throws SystemException {
		for (LegalFAQEntry legalFAQEntry : findByCategory(groupId, categoryId)) {
			remove(legalFAQEntry);
		}
	}

	/**
	 * Removes all the legal f a q entries where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryAndStatus(long groupId, long categoryId,
		int publishStatus, int status) throws SystemException {
		for (LegalFAQEntry legalFAQEntry : findByCategoryAndStatus(groupId,
				categoryId, publishStatus, status)) {
			remove(legalFAQEntry);
		}
	}

	/**
	 * Removes all the legal f a q entries where companyId = &#63; and publishStatus = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyAndStatus(long companyId, int publishStatus,
		int status) throws SystemException {
		for (LegalFAQEntry legalFAQEntry : findByCompanyAndStatus(companyId,
				publishStatus, status)) {
			remove(legalFAQEntry);
		}
	}

	/**
	 * Removes all the legal f a q entries where groupId = &#63; and publishStatus = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupAndStatus(long groupId, int publishStatus,
		int status) throws SystemException {
		for (LegalFAQEntry legalFAQEntry : findByGroupAndStatus(groupId,
				publishStatus, status)) {
			remove(legalFAQEntry);
		}
	}

	/**
	 * Removes all the legal f a q entries where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatus(long companyId, int status)
		throws SystemException {
		for (LegalFAQEntry legalFAQEntry : findByStatus(companyId, status)) {
			remove(legalFAQEntry);
		}
	}

	/**
	 * Removes all the legal f a q entries where groupId = &#63; and publishStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPublishStatus(long groupId, int publishStatus)
		throws SystemException {
		for (LegalFAQEntry legalFAQEntry : findByPublishStatus(groupId,
				publishStatus)) {
			remove(legalFAQEntry);
		}
	}

	/**
	 * Removes all the legal f a q entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LegalFAQEntry legalFAQEntry : findAll()) {
			remove(legalFAQEntry);
		}
	}

	/**
	 * Returns the number of legal f a q entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALFAQENTRY_WHERE);

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
	 * Returns the number of legal f a q entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALFAQENTRY_WHERE);

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
	 * Returns the number of legal f a q entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_LEGALFAQENTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
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
	 * Returns the number of legal f a q entries where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategory(long groupId, long categoryId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, categoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALFAQENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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
	 * Returns the number of legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByCategory(long groupId, long categoryId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCategory(groupId, categoryId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_LEGALFAQENTRY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

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
	 * Returns the number of legal f a q entries where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @return the number of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryAndStatus(long groupId, long categoryId,
		int publishStatus, int status) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, categoryId, publishStatus, status
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYANDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALFAQENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_PUBLISHSTATUS_2);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				qPos.add(publishStatus);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYANDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @return the number of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByCategoryAndStatus(long groupId, long categoryId,
		int publishStatus, int status) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCategoryAndStatus(groupId, categoryId, publishStatus,
				status);
		}

		StringBundler query = new StringBundler(5);

		query.append(_FILTER_SQL_COUNT_LEGALFAQENTRY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_PUBLISHSTATUS_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUS_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

			qPos.add(publishStatus);

			qPos.add(status);

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
	 * Returns the number of legal f a q entries where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @return the number of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyAndStatus(long companyId, int publishStatus,
		int status) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, publishStatus, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYANDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALFAQENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_PUBLISHSTATUS_2);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(publishStatus);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYANDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of legal f a q entries where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @return the number of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupAndStatus(long groupId, int publishStatus, int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, publishStatus, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALFAQENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_PUBLISHSTATUS_2);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(publishStatus);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @param status the status
	 * @return the number of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupAndStatus(long groupId, int publishStatus,
		int status) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupAndStatus(groupId, publishStatus, status);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_LEGALFAQENTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_PUBLISHSTATUS_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(publishStatus);

			qPos.add(status);

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
	 * Returns the number of legal f a q entries where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatus(long companyId, int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALFAQENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of legal f a q entries where groupId = &#63; and publishStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @return the number of matching legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPublishStatus(long groupId, int publishStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, publishStatus };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PUBLISHSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALFAQENTRY_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_PUBLISHSTATUS_PUBLISHSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(publishStatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publishStatus the publish status
	 * @return the number of matching legal f a q entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByPublishStatus(long groupId, int publishStatus)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByPublishStatus(groupId, publishStatus);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_LEGALFAQENTRY_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_PUBLISHSTATUS_PUBLISHSTATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(publishStatus);

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
	 * Returns the number of legal f a q entries.
	 *
	 * @return the number of legal f a q entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALFAQENTRY);

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
	 * Initializes the legal f a q entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.legal_faq.model.LegalFAQEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegalFAQEntry>> listenersList = new ArrayList<ModelListener<LegalFAQEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegalFAQEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegalFAQEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LegalFAQCategoryPersistence.class)
	protected LegalFAQCategoryPersistence legalFAQCategoryPersistence;
	@BeanReference(type = LegalFAQEntryPersistence.class)
	protected LegalFAQEntryPersistence legalFAQEntryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LEGALFAQENTRY = "SELECT legalFAQEntry FROM LegalFAQEntry legalFAQEntry";
	private static final String _SQL_SELECT_LEGALFAQENTRY_WHERE = "SELECT legalFAQEntry FROM LegalFAQEntry legalFAQEntry WHERE ";
	private static final String _SQL_COUNT_LEGALFAQENTRY = "SELECT COUNT(legalFAQEntry) FROM LegalFAQEntry legalFAQEntry";
	private static final String _SQL_COUNT_LEGALFAQENTRY_WHERE = "SELECT COUNT(legalFAQEntry) FROM LegalFAQEntry legalFAQEntry WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "legalFAQEntry.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "legalFAQEntry.groupId = ?";
	private static final String _FINDER_COLUMN_CATEGORY_GROUPID_2 = "legalFAQEntry.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 = "legalFAQEntry.categoryId = ?";
	private static final String _FINDER_COLUMN_CATEGORYANDSTATUS_GROUPID_2 = "legalFAQEntry.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDSTATUS_CATEGORYID_2 = "legalFAQEntry.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDSTATUS_PUBLISHSTATUS_2 =
		"legalFAQEntry.publishStatus = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDSTATUS_STATUS_2 = "legalFAQEntry.status = ?";
	private static final String _FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2 = "legalFAQEntry.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYANDSTATUS_PUBLISHSTATUS_2 = "legalFAQEntry.publishStatus = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYANDSTATUS_STATUS_2 = "legalFAQEntry.status = ?";
	private static final String _FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2 = "legalFAQEntry.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDSTATUS_PUBLISHSTATUS_2 = "legalFAQEntry.publishStatus = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDSTATUS_STATUS_2 = "legalFAQEntry.status = ?";
	private static final String _FINDER_COLUMN_STATUS_COMPANYID_2 = "legalFAQEntry.companyId = ? AND ";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "legalFAQEntry.status = ?";
	private static final String _FINDER_COLUMN_PUBLISHSTATUS_GROUPID_2 = "legalFAQEntry.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHSTATUS_PUBLISHSTATUS_2 = "legalFAQEntry.publishStatus = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "legalFAQEntry.entryId";
	private static final String _FILTER_SQL_SELECT_LEGALFAQENTRY_WHERE = "SELECT DISTINCT {legalFAQEntry.*} FROM LegalFAQEntry legalFAQEntry WHERE ";
	private static final String _FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {LegalFAQEntry.*} FROM (SELECT DISTINCT legalFAQEntry.entryId FROM LegalFAQEntry legalFAQEntry WHERE ";
	private static final String _FILTER_SQL_SELECT_LEGALFAQENTRY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN LegalFAQEntry ON TEMP_TABLE.entryId = LegalFAQEntry.entryId";
	private static final String _FILTER_SQL_COUNT_LEGALFAQENTRY_WHERE = "SELECT COUNT(DISTINCT legalFAQEntry.entryId) AS COUNT_VALUE FROM LegalFAQEntry legalFAQEntry WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "legalFAQEntry";
	private static final String _FILTER_ENTITY_TABLE = "LegalFAQEntry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legalFAQEntry.";
	private static final String _ORDER_BY_ENTITY_TABLE = "LegalFAQEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegalFAQEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LegalFAQEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegalFAQEntryPersistenceImpl.class);
	private static LegalFAQEntry _nullLegalFAQEntry = new LegalFAQEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegalFAQEntry> toCacheModel() {
				return _nullLegalFAQEntryCacheModel;
			}
		};

	private static CacheModel<LegalFAQEntry> _nullLegalFAQEntryCacheModel = new CacheModel<LegalFAQEntry>() {
			public LegalFAQEntry toEntityModel() {
				return _nullLegalFAQEntry;
			}
		};
}