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

package com.portal_egov.portlet.tthc.service.persistence;

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

import com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;
import com.portal_egov.portlet.tthc.model.TTHC_Entry;
import com.portal_egov.portlet.tthc.model.impl.TTHC_EntryImpl;
import com.portal_egov.portlet.tthc.model.impl.TTHC_EntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the t t h c_ entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see TTHC_EntryPersistence
 * @see TTHC_EntryUtil
 * @generated
 */
public class TTHC_EntryPersistenceImpl extends BasePersistenceImpl<TTHC_Entry>
	implements TTHC_EntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TTHC_EntryUtil} to access the t t h c_ entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TTHC_EntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			TTHC_EntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			TTHC_EntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVELANDCOMPANY =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLevelAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDCOMPANY =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLevelAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC_EntryModelImpl.LEVELID_COLUMN_BITMASK |
			TTHC_EntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEVELANDCOMPANY = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLevelAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVELANDGROUP =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLevelAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDGROUP =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLevelAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC_EntryModelImpl.LEVELID_COLUMN_BITMASK |
			TTHC_EntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEVELANDGROUP = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLevelAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDepartmentAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDepartmentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC_EntryModelImpl.DEPARTMENTID_COLUMN_BITMASK |
			TTHC_EntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTANDCOMPANY = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDepartmentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTANDGROUP =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDepartmentAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDGROUP =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDepartmentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC_EntryModelImpl.DEPARTMENTID_COLUMN_BITMASK |
			TTHC_EntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTANDGROUP = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDepartmentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDCOMPANY =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC_EntryModelImpl.CATEGORYID_COLUMN_BITMASK |
			TTHC_EntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDGROUP =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC_EntryModelImpl.CATEGORYID_COLUMN_BITMASK |
			TTHC_EntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDGROUP = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUDIENCEANDCOMPANY =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAudienceAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIENCEANDCOMPANY =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAudienceAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC_EntryModelImpl.AUDIENCEID_COLUMN_BITMASK |
			TTHC_EntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUDIENCEANDCOMPANY = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAudienceAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUDIENCEANDGROUP =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAudienceAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIENCEANDGROUP =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAudienceAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC_EntryModelImpl.AUDIENCEID_COLUMN_BITMASK |
			TTHC_EntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUDIENCEANDGROUP = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAudienceAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESULTTYPEANDCOMPANY =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByResultTypeAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTTYPEANDCOMPANY =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByResultTypeAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC_EntryModelImpl.RESULTTYPEID_COLUMN_BITMASK |
			TTHC_EntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESULTTYPEANDCOMPANY = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResultTypeAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESULTTYPEANDGROUP =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResultTypeAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTTYPEANDGROUP =
		new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByResultTypeAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC_EntryModelImpl.RESULTTYPEID_COLUMN_BITMASK |
			TTHC_EntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESULTTYPEANDGROUP = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResultTypeAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, TTHC_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the t t h c_ entry in the entity cache if it is enabled.
	 *
	 * @param tthc_Entry the t t h c_ entry
	 */
	public void cacheResult(TTHC_Entry tthc_Entry) {
		EntityCacheUtil.putResult(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryImpl.class, tthc_Entry.getPrimaryKey(), tthc_Entry);

		tthc_Entry.resetOriginalValues();
	}

	/**
	 * Caches the t t h c_ entries in the entity cache if it is enabled.
	 *
	 * @param tthc_Entries the t t h c_ entries
	 */
	public void cacheResult(List<TTHC_Entry> tthc_Entries) {
		for (TTHC_Entry tthc_Entry : tthc_Entries) {
			if (EntityCacheUtil.getResult(
						TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
						TTHC_EntryImpl.class, tthc_Entry.getPrimaryKey()) == null) {
				cacheResult(tthc_Entry);
			}
			else {
				tthc_Entry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all t t h c_ entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TTHC_EntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TTHC_EntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the t t h c_ entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TTHC_Entry tthc_Entry) {
		EntityCacheUtil.removeResult(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryImpl.class, tthc_Entry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TTHC_Entry> tthc_Entries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TTHC_Entry tthc_Entry : tthc_Entries) {
			EntityCacheUtil.removeResult(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
				TTHC_EntryImpl.class, tthc_Entry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new t t h c_ entry with the primary key. Does not add the t t h c_ entry to the database.
	 *
	 * @param entryId the primary key for the new t t h c_ entry
	 * @return the new t t h c_ entry
	 */
	public TTHC_Entry create(long entryId) {
		TTHC_Entry tthc_Entry = new TTHC_EntryImpl();

		tthc_Entry.setNew(true);
		tthc_Entry.setPrimaryKey(entryId);

		return tthc_Entry;
	}

	/**
	 * Removes the t t h c_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the t t h c_ entry
	 * @return the t t h c_ entry that was removed
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry remove(long entryId)
		throws NoSuchTTHC_EntryException, SystemException {
		return remove(Long.valueOf(entryId));
	}

	/**
	 * Removes the t t h c_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the t t h c_ entry
	 * @return the t t h c_ entry that was removed
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC_Entry remove(Serializable primaryKey)
		throws NoSuchTTHC_EntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TTHC_Entry tthc_Entry = (TTHC_Entry)session.get(TTHC_EntryImpl.class,
					primaryKey);

			if (tthc_Entry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTTHC_EntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tthc_Entry);
		}
		catch (NoSuchTTHC_EntryException nsee) {
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
	protected TTHC_Entry removeImpl(TTHC_Entry tthc_Entry)
		throws SystemException {
		tthc_Entry = toUnwrappedModel(tthc_Entry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tthc_Entry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tthc_Entry);

		return tthc_Entry;
	}

	@Override
	public TTHC_Entry updateImpl(
		com.portal_egov.portlet.tthc.model.TTHC_Entry tthc_Entry, boolean merge)
		throws SystemException {
		tthc_Entry = toUnwrappedModel(tthc_Entry);

		boolean isNew = tthc_Entry.isNew();

		TTHC_EntryModelImpl tthc_EntryModelImpl = (TTHC_EntryModelImpl)tthc_Entry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tthc_Entry, merge);

			tthc_Entry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TTHC_EntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tthc_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((tthc_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((tthc_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getOriginalLevelId()),
						Long.valueOf(tthc_EntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVELANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getLevelId()),
						Long.valueOf(tthc_EntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVELANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDCOMPANY,
					args);
			}

			if ((tthc_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getOriginalLevelId()),
						Long.valueOf(tthc_EntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVELANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getLevelId()),
						Long.valueOf(tthc_EntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVELANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDGROUP,
					args);
			}

			if ((tthc_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getOriginalDepartmentId()),
						Long.valueOf(tthc_EntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getDepartmentId()),
						Long.valueOf(tthc_EntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY,
					args);
			}

			if ((tthc_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getOriginalDepartmentId()),
						Long.valueOf(tthc_EntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getDepartmentId()),
						Long.valueOf(tthc_EntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDGROUP,
					args);
			}

			if ((tthc_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getOriginalCategoryId()),
						Long.valueOf(tthc_EntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getCategoryId()),
						Long.valueOf(tthc_EntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY,
					args);
			}

			if ((tthc_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getOriginalCategoryId()),
						Long.valueOf(tthc_EntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getCategoryId()),
						Long.valueOf(tthc_EntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP,
					args);
			}

			if ((tthc_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIENCEANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getOriginalAudienceId()),
						Long.valueOf(tthc_EntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUDIENCEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIENCEANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getAudienceId()),
						Long.valueOf(tthc_EntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUDIENCEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIENCEANDCOMPANY,
					args);
			}

			if ((tthc_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIENCEANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getOriginalAudienceId()),
						Long.valueOf(tthc_EntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUDIENCEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIENCEANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getAudienceId()),
						Long.valueOf(tthc_EntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUDIENCEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIENCEANDGROUP,
					args);
			}

			if ((tthc_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTTYPEANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getOriginalResultTypeId()),
						Long.valueOf(tthc_EntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESULTTYPEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTTYPEANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getResultTypeId()),
						Long.valueOf(tthc_EntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESULTTYPEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTTYPEANDCOMPANY,
					args);
			}

			if ((tthc_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTTYPEANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getOriginalResultTypeId()),
						Long.valueOf(tthc_EntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESULTTYPEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTTYPEANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(tthc_EntryModelImpl.getResultTypeId()),
						Long.valueOf(tthc_EntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESULTTYPEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTTYPEANDGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_EntryImpl.class, tthc_Entry.getPrimaryKey(), tthc_Entry);

		return tthc_Entry;
	}

	protected TTHC_Entry toUnwrappedModel(TTHC_Entry tthc_Entry) {
		if (tthc_Entry instanceof TTHC_EntryImpl) {
			return tthc_Entry;
		}

		TTHC_EntryImpl tthc_EntryImpl = new TTHC_EntryImpl();

		tthc_EntryImpl.setNew(tthc_Entry.isNew());
		tthc_EntryImpl.setPrimaryKey(tthc_Entry.getPrimaryKey());

		tthc_EntryImpl.setEntryId(tthc_Entry.getEntryId());
		tthc_EntryImpl.setCompanyId(tthc_Entry.getCompanyId());
		tthc_EntryImpl.setGroupId(tthc_Entry.getGroupId());
		tthc_EntryImpl.setUserId(tthc_Entry.getUserId());
		tthc_EntryImpl.setUserName(tthc_Entry.getUserName());
		tthc_EntryImpl.setLevelId(tthc_Entry.getLevelId());
		tthc_EntryImpl.setDepartmentId(tthc_Entry.getDepartmentId());
		tthc_EntryImpl.setCategoryId(tthc_Entry.getCategoryId());
		tthc_EntryImpl.setAudienceId(tthc_Entry.getAudienceId());
		tthc_EntryImpl.setResultTypeId(tthc_Entry.getResultTypeId());
		tthc_EntryImpl.setEntryCode(tthc_Entry.getEntryCode());
		tthc_EntryImpl.setEntryName(tthc_Entry.getEntryName());
		tthc_EntryImpl.setEntryDesc(tthc_Entry.getEntryDesc());
		tthc_EntryImpl.setProcessGuide(tthc_Entry.getProcessGuide());
		tthc_EntryImpl.setProcessType(tthc_Entry.getProcessType());
		tthc_EntryImpl.setProcessTime(tthc_Entry.getProcessTime());
		tthc_EntryImpl.setProcessFee(tthc_Entry.getProcessFee());
		tthc_EntryImpl.setProcessRequirement(tthc_Entry.getProcessRequirement());
		tthc_EntryImpl.setProcessFoundationDocument(tthc_Entry.getProcessFoundationDocument());
		tthc_EntryImpl.setCreateDate(tthc_Entry.getCreateDate());
		tthc_EntryImpl.setModifiedDate(tthc_Entry.getModifiedDate());

		return tthc_EntryImpl;
	}

	/**
	 * Returns the t t h c_ entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the t t h c_ entry
	 * @return the t t h c_ entry
	 * @throws com.liferay.portal.NoSuchModelException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC_Entry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the t t h c_ entry with the primary key or throws a {@link com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException} if it could not be found.
	 *
	 * @param entryId the primary key of the t t h c_ entry
	 * @return the t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByPrimaryKey(long entryId)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByPrimaryKey(entryId);

		if (tthc_Entry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entryId);
			}

			throw new NoSuchTTHC_EntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				entryId);
		}

		return tthc_Entry;
	}

	/**
	 * Returns the t t h c_ entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the t t h c_ entry
	 * @return the t t h c_ entry, or <code>null</code> if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC_Entry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the t t h c_ entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the t t h c_ entry
	 * @return the t t h c_ entry, or <code>null</code> if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByPrimaryKey(long entryId) throws SystemException {
		TTHC_Entry tthc_Entry = (TTHC_Entry)EntityCacheUtil.getResult(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
				TTHC_EntryImpl.class, entryId);

		if (tthc_Entry == _nullTTHC_Entry) {
			return null;
		}

		if (tthc_Entry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tthc_Entry = (TTHC_Entry)session.get(TTHC_EntryImpl.class,
						Long.valueOf(entryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tthc_Entry != null) {
					cacheResult(tthc_Entry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TTHC_EntryModelImpl.ENTITY_CACHE_ENABLED,
						TTHC_EntryImpl.class, entryId, _nullTTHC_Entry);
				}

				closeSession(session);
			}
		}

		return tthc_Entry;
	}

	/**
	 * Returns all the t t h c_ entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the t t h c_ entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByCompany(long companyId, int start, int end,
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

		List<TTHC_Entry> list = (List<TTHC_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Entry tthc_Entry : list) {
				if ((companyId != tthc_Entry.getCompanyId())) {
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

			query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first t t h c_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByCompany_First(companyId,
				orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TTHC_Entry> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByCompany_Last(companyId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<TTHC_Entry> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] findByCompany_PrevAndNext(long entryId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, tthc_Entry, companyId,
					orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = getByCompany_PrevAndNext(session, tthc_Entry, companyId,
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

	protected TTHC_Entry getByCompany_PrevAndNext(Session session,
		TTHC_Entry tthc_Entry, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

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
			query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByGroup(long groupId, int start, int end,
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

		List<TTHC_Entry> list = (List<TTHC_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Entry tthc_Entry : list) {
				if ((groupId != tthc_Entry.getGroupId())) {
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

			query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first t t h c_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByGroup_First(groupId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TTHC_Entry> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByGroup_Last(groupId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<TTHC_Entry> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] findByGroup_PrevAndNext(long entryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, tthc_Entry, groupId,
					orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = getByGroup_PrevAndNext(session, tthc_Entry, groupId,
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

	protected TTHC_Entry getByGroup_PrevAndNext(Session session,
		TTHC_Entry tthc_Entry, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

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
			query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the t t h c_ entries that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_EntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TTHC_EntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set of t t h c_ entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] filterFindByGroup_PrevAndNext(long entryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(entryId, groupId, orderByComparator);
		}

		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, tthc_Entry,
					groupId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = filterGetByGroup_PrevAndNext(session, tthc_Entry,
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

	protected TTHC_Entry filterGetByGroup_PrevAndNext(Session session,
		TTHC_Entry tthc_Entry, long groupId,
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
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_EntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TTHC_EntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries where levelId = &#63; and companyId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param companyId the company ID
	 * @return the matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByLevelAndCompany(long levelId, long companyId)
		throws SystemException {
		return findByLevelAndCompany(levelId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries where levelId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByLevelAndCompany(long levelId, long companyId,
		int start, int end) throws SystemException {
		return findByLevelAndCompany(levelId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries where levelId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByLevelAndCompany(long levelId, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDCOMPANY;
			finderArgs = new Object[] { levelId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVELANDCOMPANY;
			finderArgs = new Object[] {
					levelId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Entry> list = (List<TTHC_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Entry tthc_Entry : list) {
				if ((levelId != tthc_Entry.getLevelId()) ||
						(companyId != tthc_Entry.getCompanyId())) {
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

			query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_LEVELANDCOMPANY_LEVELID_2);

			query.append(_FINDER_COLUMN_LEVELANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(levelId);

				qPos.add(companyId);

				list = (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first t t h c_ entry in the ordered set where levelId = &#63; and companyId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByLevelAndCompany_First(long levelId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByLevelAndCompany_First(levelId,
				companyId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("levelId=");
		msg.append(levelId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ entry in the ordered set where levelId = &#63; and companyId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByLevelAndCompany_First(long levelId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Entry> list = findByLevelAndCompany(levelId, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where levelId = &#63; and companyId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByLevelAndCompany_Last(long levelId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByLevelAndCompany_Last(levelId, companyId,
				orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("levelId=");
		msg.append(levelId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where levelId = &#63; and companyId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByLevelAndCompany_Last(long levelId, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLevelAndCompany(levelId, companyId);

		List<TTHC_Entry> list = findByLevelAndCompany(levelId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where levelId = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param levelId the level ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] findByLevelAndCompany_PrevAndNext(long entryId,
		long levelId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = getByLevelAndCompany_PrevAndNext(session, tthc_Entry,
					levelId, companyId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = getByLevelAndCompany_PrevAndNext(session, tthc_Entry,
					levelId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Entry getByLevelAndCompany_PrevAndNext(Session session,
		TTHC_Entry tthc_Entry, long levelId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_LEVELANDCOMPANY_LEVELID_2);

		query.append(_FINDER_COLUMN_LEVELANDCOMPANY_COMPANYID_2);

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
			query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(levelId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries where levelId = &#63; and groupId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @return the matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByLevelAndGroup(long levelId, long groupId)
		throws SystemException {
		return findByLevelAndGroup(levelId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries where levelId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByLevelAndGroup(long levelId, long groupId,
		int start, int end) throws SystemException {
		return findByLevelAndGroup(levelId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries where levelId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByLevelAndGroup(long levelId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDGROUP;
			finderArgs = new Object[] { levelId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVELANDGROUP;
			finderArgs = new Object[] {
					levelId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Entry> list = (List<TTHC_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Entry tthc_Entry : list) {
				if ((levelId != tthc_Entry.getLevelId()) ||
						(groupId != tthc_Entry.getGroupId())) {
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

			query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_LEVELANDGROUP_LEVELID_2);

			query.append(_FINDER_COLUMN_LEVELANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(levelId);

				qPos.add(groupId);

				list = (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first t t h c_ entry in the ordered set where levelId = &#63; and groupId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByLevelAndGroup_First(long levelId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByLevelAndGroup_First(levelId, groupId,
				orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("levelId=");
		msg.append(levelId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ entry in the ordered set where levelId = &#63; and groupId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByLevelAndGroup_First(long levelId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TTHC_Entry> list = findByLevelAndGroup(levelId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where levelId = &#63; and groupId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByLevelAndGroup_Last(long levelId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByLevelAndGroup_Last(levelId, groupId,
				orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("levelId=");
		msg.append(levelId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where levelId = &#63; and groupId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByLevelAndGroup_Last(long levelId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLevelAndGroup(levelId, groupId);

		List<TTHC_Entry> list = findByLevelAndGroup(levelId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where levelId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] findByLevelAndGroup_PrevAndNext(long entryId,
		long levelId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = getByLevelAndGroup_PrevAndNext(session, tthc_Entry,
					levelId, groupId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = getByLevelAndGroup_PrevAndNext(session, tthc_Entry,
					levelId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Entry getByLevelAndGroup_PrevAndNext(Session session,
		TTHC_Entry tthc_Entry, long levelId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_LEVELANDGROUP_LEVELID_2);

		query.append(_FINDER_COLUMN_LEVELANDGROUP_GROUPID_2);

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
			query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(levelId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries that the user has permission to view where levelId = &#63; and groupId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @return the matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByLevelAndGroup(long levelId, long groupId)
		throws SystemException {
		return filterFindByLevelAndGroup(levelId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries that the user has permission to view where levelId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByLevelAndGroup(long levelId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByLevelAndGroup(levelId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries that the user has permissions to view where levelId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByLevelAndGroup(long levelId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByLevelAndGroup(levelId, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_LEVELANDGROUP_LEVELID_2);

		query.append(_FINDER_COLUMN_LEVELANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_EntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TTHC_EntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(levelId);

			qPos.add(groupId);

			return (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set of t t h c_ entries that the user has permission to view where levelId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] filterFindByLevelAndGroup_PrevAndNext(long entryId,
		long levelId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByLevelAndGroup_PrevAndNext(entryId, levelId, groupId,
				orderByComparator);
		}

		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = filterGetByLevelAndGroup_PrevAndNext(session,
					tthc_Entry, levelId, groupId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = filterGetByLevelAndGroup_PrevAndNext(session,
					tthc_Entry, levelId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Entry filterGetByLevelAndGroup_PrevAndNext(Session session,
		TTHC_Entry tthc_Entry, long levelId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_LEVELANDGROUP_LEVELID_2);

		query.append(_FINDER_COLUMN_LEVELANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_EntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TTHC_EntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(levelId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries where departmentId = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @return the matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByDepartmentAndCompany(long departmentId,
		long companyId) throws SystemException {
		return findByDepartmentAndCompany(departmentId, companyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries where departmentId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByDepartmentAndCompany(long departmentId,
		long companyId, int start, int end) throws SystemException {
		return findByDepartmentAndCompany(departmentId, companyId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries where departmentId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByDepartmentAndCompany(long departmentId,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY;
			finderArgs = new Object[] { departmentId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY;
			finderArgs = new Object[] {
					departmentId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Entry> list = (List<TTHC_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Entry tthc_Entry : list) {
				if ((departmentId != tthc_Entry.getDepartmentId()) ||
						(companyId != tthc_Entry.getCompanyId())) {
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

			query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTANDCOMPANY_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				qPos.add(companyId);

				list = (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first t t h c_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByDepartmentAndCompany_First(long departmentId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByDepartmentAndCompany_First(departmentId,
				companyId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByDepartmentAndCompany_First(long departmentId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Entry> list = findByDepartmentAndCompany(departmentId,
				companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByDepartmentAndCompany_Last(long departmentId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByDepartmentAndCompany_Last(departmentId,
				companyId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByDepartmentAndCompany_Last(long departmentId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDepartmentAndCompany(departmentId, companyId);

		List<TTHC_Entry> list = findByDepartmentAndCompany(departmentId,
				companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] findByDepartmentAndCompany_PrevAndNext(long entryId,
		long departmentId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = getByDepartmentAndCompany_PrevAndNext(session,
					tthc_Entry, departmentId, companyId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = getByDepartmentAndCompany_PrevAndNext(session,
					tthc_Entry, departmentId, companyId, orderByComparator,
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

	protected TTHC_Entry getByDepartmentAndCompany_PrevAndNext(
		Session session, TTHC_Entry tthc_Entry, long departmentId,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTANDCOMPANY_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTANDCOMPANY_COMPANYID_2);

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
			query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @return the matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByDepartmentAndGroup(long departmentId,
		long groupId) throws SystemException {
		return findByDepartmentAndGroup(departmentId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries where departmentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByDepartmentAndGroup(long departmentId,
		long groupId, int start, int end) throws SystemException {
		return findByDepartmentAndGroup(departmentId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries where departmentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByDepartmentAndGroup(long departmentId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDGROUP;
			finderArgs = new Object[] { departmentId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTANDGROUP;
			finderArgs = new Object[] {
					departmentId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Entry> list = (List<TTHC_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Entry tthc_Entry : list) {
				if ((departmentId != tthc_Entry.getDepartmentId()) ||
						(groupId != tthc_Entry.getGroupId())) {
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

			query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				qPos.add(groupId);

				list = (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first t t h c_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByDepartmentAndGroup_First(long departmentId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByDepartmentAndGroup_First(departmentId,
				groupId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByDepartmentAndGroup_First(long departmentId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Entry> list = findByDepartmentAndGroup(departmentId, groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByDepartmentAndGroup_Last(long departmentId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByDepartmentAndGroup_Last(departmentId,
				groupId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByDepartmentAndGroup_Last(long departmentId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDepartmentAndGroup(departmentId, groupId);

		List<TTHC_Entry> list = findByDepartmentAndGroup(departmentId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] findByDepartmentAndGroup_PrevAndNext(long entryId,
		long departmentId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = getByDepartmentAndGroup_PrevAndNext(session, tthc_Entry,
					departmentId, groupId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = getByDepartmentAndGroup_PrevAndNext(session, tthc_Entry,
					departmentId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Entry getByDepartmentAndGroup_PrevAndNext(Session session,
		TTHC_Entry tthc_Entry, long departmentId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

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
			query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @return the matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByDepartmentAndGroup(long departmentId,
		long groupId) throws SystemException {
		return filterFindByDepartmentAndGroup(departmentId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByDepartmentAndGroup(long departmentId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByDepartmentAndGroup(departmentId, groupId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries that the user has permissions to view where departmentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByDepartmentAndGroup(long departmentId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByDepartmentAndGroup(departmentId, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_EntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TTHC_EntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(departmentId);

			qPos.add(groupId);

			return (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set of t t h c_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] filterFindByDepartmentAndGroup_PrevAndNext(
		long entryId, long departmentId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByDepartmentAndGroup_PrevAndNext(entryId, departmentId,
				groupId, orderByComparator);
		}

		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = filterGetByDepartmentAndGroup_PrevAndNext(session,
					tthc_Entry, departmentId, groupId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = filterGetByDepartmentAndGroup_PrevAndNext(session,
					tthc_Entry, departmentId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Entry filterGetByDepartmentAndGroup_PrevAndNext(
		Session session, TTHC_Entry tthc_Entry, long departmentId,
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
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_EntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TTHC_EntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @return the matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByCategoryAndCompany(long categoryId,
		long companyId) throws SystemException {
		return findByCategoryAndCompany(categoryId, companyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries where categoryId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByCategoryAndCompany(long categoryId,
		long companyId, int start, int end) throws SystemException {
		return findByCategoryAndCompany(categoryId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries where categoryId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByCategoryAndCompany(long categoryId,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY;
			finderArgs = new Object[] { categoryId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDCOMPANY;
			finderArgs = new Object[] {
					categoryId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Entry> list = (List<TTHC_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Entry tthc_Entry : list) {
				if ((categoryId != tthc_Entry.getCategoryId()) ||
						(companyId != tthc_Entry.getCompanyId())) {
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

			query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(companyId);

				list = (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first t t h c_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByCategoryAndCompany_First(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByCategoryAndCompany_First(categoryId,
				companyId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByCategoryAndCompany_First(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Entry> list = findByCategoryAndCompany(categoryId, companyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByCategoryAndCompany_Last(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByCategoryAndCompany_Last(categoryId,
				companyId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByCategoryAndCompany_Last(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryAndCompany(categoryId, companyId);

		List<TTHC_Entry> list = findByCategoryAndCompany(categoryId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] findByCategoryAndCompany_PrevAndNext(long entryId,
		long categoryId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = getByCategoryAndCompany_PrevAndNext(session, tthc_Entry,
					categoryId, companyId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = getByCategoryAndCompany_PrevAndNext(session, tthc_Entry,
					categoryId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Entry getByCategoryAndCompany_PrevAndNext(Session session,
		TTHC_Entry tthc_Entry, long categoryId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_COMPANYID_2);

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
			query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByCategoryAndGroup(long categoryId, long groupId)
		throws SystemException {
		return findByCategoryAndGroup(categoryId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByCategoryAndGroup(long categoryId,
		long groupId, int start, int end) throws SystemException {
		return findByCategoryAndGroup(categoryId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByCategoryAndGroup(long categoryId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP;
			finderArgs = new Object[] { categoryId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDGROUP;
			finderArgs = new Object[] {
					categoryId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Entry> list = (List<TTHC_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Entry tthc_Entry : list) {
				if ((categoryId != tthc_Entry.getCategoryId()) ||
						(groupId != tthc_Entry.getGroupId())) {
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

			query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(groupId);

				list = (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first t t h c_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByCategoryAndGroup_First(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByCategoryAndGroup_First(categoryId,
				groupId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByCategoryAndGroup_First(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Entry> list = findByCategoryAndGroup(categoryId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByCategoryAndGroup_Last(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByCategoryAndGroup_Last(categoryId,
				groupId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByCategoryAndGroup_Last(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryAndGroup(categoryId, groupId);

		List<TTHC_Entry> list = findByCategoryAndGroup(categoryId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] findByCategoryAndGroup_PrevAndNext(long entryId,
		long categoryId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = getByCategoryAndGroup_PrevAndNext(session, tthc_Entry,
					categoryId, groupId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = getByCategoryAndGroup_PrevAndNext(session, tthc_Entry,
					categoryId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Entry getByCategoryAndGroup_PrevAndNext(Session session,
		TTHC_Entry tthc_Entry, long categoryId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

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
			query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByCategoryAndGroup(long categoryId,
		long groupId) throws SystemException {
		return filterFindByCategoryAndGroup(categoryId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByCategoryAndGroup(long categoryId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByCategoryAndGroup(categoryId, groupId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries that the user has permissions to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByCategoryAndGroup(long categoryId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryAndGroup(categoryId, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_EntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TTHC_EntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(categoryId);

			qPos.add(groupId);

			return (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set of t t h c_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] filterFindByCategoryAndGroup_PrevAndNext(long entryId,
		long categoryId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryAndGroup_PrevAndNext(entryId, categoryId,
				groupId, orderByComparator);
		}

		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = filterGetByCategoryAndGroup_PrevAndNext(session,
					tthc_Entry, categoryId, groupId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = filterGetByCategoryAndGroup_PrevAndNext(session,
					tthc_Entry, categoryId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Entry filterGetByCategoryAndGroup_PrevAndNext(
		Session session, TTHC_Entry tthc_Entry, long categoryId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_EntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TTHC_EntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries where audienceId = &#63; and companyId = &#63;.
	 *
	 * @param audienceId the audience ID
	 * @param companyId the company ID
	 * @return the matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByAudienceAndCompany(long audienceId,
		long companyId) throws SystemException {
		return findByAudienceAndCompany(audienceId, companyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries where audienceId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param audienceId the audience ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByAudienceAndCompany(long audienceId,
		long companyId, int start, int end) throws SystemException {
		return findByAudienceAndCompany(audienceId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries where audienceId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param audienceId the audience ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByAudienceAndCompany(long audienceId,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIENCEANDCOMPANY;
			finderArgs = new Object[] { audienceId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUDIENCEANDCOMPANY;
			finderArgs = new Object[] {
					audienceId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Entry> list = (List<TTHC_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Entry tthc_Entry : list) {
				if ((audienceId != tthc_Entry.getAudienceId()) ||
						(companyId != tthc_Entry.getCompanyId())) {
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

			query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_AUDIENCEANDCOMPANY_AUDIENCEID_2);

			query.append(_FINDER_COLUMN_AUDIENCEANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(audienceId);

				qPos.add(companyId);

				list = (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first t t h c_ entry in the ordered set where audienceId = &#63; and companyId = &#63;.
	 *
	 * @param audienceId the audience ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByAudienceAndCompany_First(long audienceId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByAudienceAndCompany_First(audienceId,
				companyId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("audienceId=");
		msg.append(audienceId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ entry in the ordered set where audienceId = &#63; and companyId = &#63;.
	 *
	 * @param audienceId the audience ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByAudienceAndCompany_First(long audienceId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Entry> list = findByAudienceAndCompany(audienceId, companyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where audienceId = &#63; and companyId = &#63;.
	 *
	 * @param audienceId the audience ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByAudienceAndCompany_Last(long audienceId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByAudienceAndCompany_Last(audienceId,
				companyId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("audienceId=");
		msg.append(audienceId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where audienceId = &#63; and companyId = &#63;.
	 *
	 * @param audienceId the audience ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByAudienceAndCompany_Last(long audienceId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByAudienceAndCompany(audienceId, companyId);

		List<TTHC_Entry> list = findByAudienceAndCompany(audienceId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where audienceId = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param audienceId the audience ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] findByAudienceAndCompany_PrevAndNext(long entryId,
		long audienceId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = getByAudienceAndCompany_PrevAndNext(session, tthc_Entry,
					audienceId, companyId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = getByAudienceAndCompany_PrevAndNext(session, tthc_Entry,
					audienceId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Entry getByAudienceAndCompany_PrevAndNext(Session session,
		TTHC_Entry tthc_Entry, long audienceId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_AUDIENCEANDCOMPANY_AUDIENCEID_2);

		query.append(_FINDER_COLUMN_AUDIENCEANDCOMPANY_COMPANYID_2);

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
			query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(audienceId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries where audienceId = &#63; and groupId = &#63;.
	 *
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @return the matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByAudienceAndGroup(long audienceId, long groupId)
		throws SystemException {
		return findByAudienceAndGroup(audienceId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries where audienceId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByAudienceAndGroup(long audienceId,
		long groupId, int start, int end) throws SystemException {
		return findByAudienceAndGroup(audienceId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries where audienceId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByAudienceAndGroup(long audienceId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIENCEANDGROUP;
			finderArgs = new Object[] { audienceId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUDIENCEANDGROUP;
			finderArgs = new Object[] {
					audienceId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Entry> list = (List<TTHC_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Entry tthc_Entry : list) {
				if ((audienceId != tthc_Entry.getAudienceId()) ||
						(groupId != tthc_Entry.getGroupId())) {
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

			query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_AUDIENCEANDGROUP_AUDIENCEID_2);

			query.append(_FINDER_COLUMN_AUDIENCEANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(audienceId);

				qPos.add(groupId);

				list = (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first t t h c_ entry in the ordered set where audienceId = &#63; and groupId = &#63;.
	 *
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByAudienceAndGroup_First(long audienceId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByAudienceAndGroup_First(audienceId,
				groupId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("audienceId=");
		msg.append(audienceId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ entry in the ordered set where audienceId = &#63; and groupId = &#63;.
	 *
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByAudienceAndGroup_First(long audienceId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Entry> list = findByAudienceAndGroup(audienceId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where audienceId = &#63; and groupId = &#63;.
	 *
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByAudienceAndGroup_Last(long audienceId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByAudienceAndGroup_Last(audienceId,
				groupId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("audienceId=");
		msg.append(audienceId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where audienceId = &#63; and groupId = &#63;.
	 *
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByAudienceAndGroup_Last(long audienceId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByAudienceAndGroup(audienceId, groupId);

		List<TTHC_Entry> list = findByAudienceAndGroup(audienceId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where audienceId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] findByAudienceAndGroup_PrevAndNext(long entryId,
		long audienceId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = getByAudienceAndGroup_PrevAndNext(session, tthc_Entry,
					audienceId, groupId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = getByAudienceAndGroup_PrevAndNext(session, tthc_Entry,
					audienceId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Entry getByAudienceAndGroup_PrevAndNext(Session session,
		TTHC_Entry tthc_Entry, long audienceId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_AUDIENCEANDGROUP_AUDIENCEID_2);

		query.append(_FINDER_COLUMN_AUDIENCEANDGROUP_GROUPID_2);

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
			query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(audienceId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries that the user has permission to view where audienceId = &#63; and groupId = &#63;.
	 *
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @return the matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByAudienceAndGroup(long audienceId,
		long groupId) throws SystemException {
		return filterFindByAudienceAndGroup(audienceId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries that the user has permission to view where audienceId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByAudienceAndGroup(long audienceId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByAudienceAndGroup(audienceId, groupId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries that the user has permissions to view where audienceId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByAudienceAndGroup(long audienceId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByAudienceAndGroup(audienceId, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_AUDIENCEANDGROUP_AUDIENCEID_2);

		query.append(_FINDER_COLUMN_AUDIENCEANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_EntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TTHC_EntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(audienceId);

			qPos.add(groupId);

			return (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set of t t h c_ entries that the user has permission to view where audienceId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] filterFindByAudienceAndGroup_PrevAndNext(long entryId,
		long audienceId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByAudienceAndGroup_PrevAndNext(entryId, audienceId,
				groupId, orderByComparator);
		}

		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = filterGetByAudienceAndGroup_PrevAndNext(session,
					tthc_Entry, audienceId, groupId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = filterGetByAudienceAndGroup_PrevAndNext(session,
					tthc_Entry, audienceId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Entry filterGetByAudienceAndGroup_PrevAndNext(
		Session session, TTHC_Entry tthc_Entry, long audienceId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_AUDIENCEANDGROUP_AUDIENCEID_2);

		query.append(_FINDER_COLUMN_AUDIENCEANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_EntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TTHC_EntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(audienceId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries where resultTypeId = &#63; and companyId = &#63;.
	 *
	 * @param resultTypeId the result type ID
	 * @param companyId the company ID
	 * @return the matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByResultTypeAndCompany(long resultTypeId,
		long companyId) throws SystemException {
		return findByResultTypeAndCompany(resultTypeId, companyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries where resultTypeId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param resultTypeId the result type ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByResultTypeAndCompany(long resultTypeId,
		long companyId, int start, int end) throws SystemException {
		return findByResultTypeAndCompany(resultTypeId, companyId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries where resultTypeId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param resultTypeId the result type ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByResultTypeAndCompany(long resultTypeId,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTTYPEANDCOMPANY;
			finderArgs = new Object[] { resultTypeId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RESULTTYPEANDCOMPANY;
			finderArgs = new Object[] {
					resultTypeId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Entry> list = (List<TTHC_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Entry tthc_Entry : list) {
				if ((resultTypeId != tthc_Entry.getResultTypeId()) ||
						(companyId != tthc_Entry.getCompanyId())) {
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

			query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_RESULTTYPEANDCOMPANY_RESULTTYPEID_2);

			query.append(_FINDER_COLUMN_RESULTTYPEANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(resultTypeId);

				qPos.add(companyId);

				list = (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first t t h c_ entry in the ordered set where resultTypeId = &#63; and companyId = &#63;.
	 *
	 * @param resultTypeId the result type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByResultTypeAndCompany_First(long resultTypeId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByResultTypeAndCompany_First(resultTypeId,
				companyId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("resultTypeId=");
		msg.append(resultTypeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ entry in the ordered set where resultTypeId = &#63; and companyId = &#63;.
	 *
	 * @param resultTypeId the result type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByResultTypeAndCompany_First(long resultTypeId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Entry> list = findByResultTypeAndCompany(resultTypeId,
				companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where resultTypeId = &#63; and companyId = &#63;.
	 *
	 * @param resultTypeId the result type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByResultTypeAndCompany_Last(long resultTypeId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByResultTypeAndCompany_Last(resultTypeId,
				companyId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("resultTypeId=");
		msg.append(resultTypeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where resultTypeId = &#63; and companyId = &#63;.
	 *
	 * @param resultTypeId the result type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByResultTypeAndCompany_Last(long resultTypeId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByResultTypeAndCompany(resultTypeId, companyId);

		List<TTHC_Entry> list = findByResultTypeAndCompany(resultTypeId,
				companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where resultTypeId = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param resultTypeId the result type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] findByResultTypeAndCompany_PrevAndNext(long entryId,
		long resultTypeId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = getByResultTypeAndCompany_PrevAndNext(session,
					tthc_Entry, resultTypeId, companyId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = getByResultTypeAndCompany_PrevAndNext(session,
					tthc_Entry, resultTypeId, companyId, orderByComparator,
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

	protected TTHC_Entry getByResultTypeAndCompany_PrevAndNext(
		Session session, TTHC_Entry tthc_Entry, long resultTypeId,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_RESULTTYPEANDCOMPANY_RESULTTYPEID_2);

		query.append(_FINDER_COLUMN_RESULTTYPEANDCOMPANY_COMPANYID_2);

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
			query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(resultTypeId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries where resultTypeId = &#63; and groupId = &#63;.
	 *
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @return the matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByResultTypeAndGroup(long resultTypeId,
		long groupId) throws SystemException {
		return findByResultTypeAndGroup(resultTypeId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries where resultTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByResultTypeAndGroup(long resultTypeId,
		long groupId, int start, int end) throws SystemException {
		return findByResultTypeAndGroup(resultTypeId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries where resultTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findByResultTypeAndGroup(long resultTypeId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTTYPEANDGROUP;
			finderArgs = new Object[] { resultTypeId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RESULTTYPEANDGROUP;
			finderArgs = new Object[] {
					resultTypeId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Entry> list = (List<TTHC_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Entry tthc_Entry : list) {
				if ((resultTypeId != tthc_Entry.getResultTypeId()) ||
						(groupId != tthc_Entry.getGroupId())) {
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

			query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_RESULTTYPEANDGROUP_RESULTTYPEID_2);

			query.append(_FINDER_COLUMN_RESULTTYPEANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(resultTypeId);

				qPos.add(groupId);

				list = (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first t t h c_ entry in the ordered set where resultTypeId = &#63; and groupId = &#63;.
	 *
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByResultTypeAndGroup_First(long resultTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByResultTypeAndGroup_First(resultTypeId,
				groupId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("resultTypeId=");
		msg.append(resultTypeId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ entry in the ordered set where resultTypeId = &#63; and groupId = &#63;.
	 *
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByResultTypeAndGroup_First(long resultTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Entry> list = findByResultTypeAndGroup(resultTypeId, groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where resultTypeId = &#63; and groupId = &#63;.
	 *
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry findByResultTypeAndGroup_Last(long resultTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = fetchByResultTypeAndGroup_Last(resultTypeId,
				groupId, orderByComparator);

		if (tthc_Entry != null) {
			return tthc_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("resultTypeId=");
		msg.append(resultTypeId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_EntryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ entry in the ordered set where resultTypeId = &#63; and groupId = &#63;.
	 *
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry fetchByResultTypeAndGroup_Last(long resultTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByResultTypeAndGroup(resultTypeId, groupId);

		List<TTHC_Entry> list = findByResultTypeAndGroup(resultTypeId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where resultTypeId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] findByResultTypeAndGroup_PrevAndNext(long entryId,
		long resultTypeId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = getByResultTypeAndGroup_PrevAndNext(session, tthc_Entry,
					resultTypeId, groupId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = getByResultTypeAndGroup_PrevAndNext(session, tthc_Entry,
					resultTypeId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Entry getByResultTypeAndGroup_PrevAndNext(Session session,
		TTHC_Entry tthc_Entry, long resultTypeId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_RESULTTYPEANDGROUP_RESULTTYPEID_2);

		query.append(_FINDER_COLUMN_RESULTTYPEANDGROUP_GROUPID_2);

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
			query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(resultTypeId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries that the user has permission to view where resultTypeId = &#63; and groupId = &#63;.
	 *
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @return the matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByResultTypeAndGroup(long resultTypeId,
		long groupId) throws SystemException {
		return filterFindByResultTypeAndGroup(resultTypeId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries that the user has permission to view where resultTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByResultTypeAndGroup(long resultTypeId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByResultTypeAndGroup(resultTypeId, groupId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries that the user has permissions to view where resultTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> filterFindByResultTypeAndGroup(long resultTypeId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByResultTypeAndGroup(resultTypeId, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_RESULTTYPEANDGROUP_RESULTTYPEID_2);

		query.append(_FINDER_COLUMN_RESULTTYPEANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_EntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TTHC_EntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(resultTypeId);

			qPos.add(groupId);

			return (List<TTHC_Entry>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set of t t h c_ entries that the user has permission to view where resultTypeId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current t t h c_ entry
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ entry
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Entry[] filterFindByResultTypeAndGroup_PrevAndNext(
		long entryId, long resultTypeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_EntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByResultTypeAndGroup_PrevAndNext(entryId, resultTypeId,
				groupId, orderByComparator);
		}

		TTHC_Entry tthc_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Entry[] array = new TTHC_EntryImpl[3];

			array[0] = filterGetByResultTypeAndGroup_PrevAndNext(session,
					tthc_Entry, resultTypeId, groupId, orderByComparator, true);

			array[1] = tthc_Entry;

			array[2] = filterGetByResultTypeAndGroup_PrevAndNext(session,
					tthc_Entry, resultTypeId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Entry filterGetByResultTypeAndGroup_PrevAndNext(
		Session session, TTHC_Entry tthc_Entry, long resultTypeId,
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
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_RESULTTYPEANDGROUP_RESULTTYPEID_2);

		query.append(_FINDER_COLUMN_RESULTTYPEANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_EntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TTHC_EntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(resultTypeId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ entries.
	 *
	 * @return the t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @return the range of t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of t t h c_ entries
	 * @param end the upper bound of the range of t t h c_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Entry> findAll(int start, int end,
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

		List<TTHC_Entry> list = (List<TTHC_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TTHC_ENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TTHC_ENTRY.concat(TTHC_EntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TTHC_Entry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TTHC_Entry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the t t h c_ entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (TTHC_Entry tthc_Entry : findByCompany(companyId)) {
			remove(tthc_Entry);
		}
	}

	/**
	 * Removes all the t t h c_ entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (TTHC_Entry tthc_Entry : findByGroup(groupId)) {
			remove(tthc_Entry);
		}
	}

	/**
	 * Removes all the t t h c_ entries where levelId = &#63; and companyId = &#63; from the database.
	 *
	 * @param levelId the level ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLevelAndCompany(long levelId, long companyId)
		throws SystemException {
		for (TTHC_Entry tthc_Entry : findByLevelAndCompany(levelId, companyId)) {
			remove(tthc_Entry);
		}
	}

	/**
	 * Removes all the t t h c_ entries where levelId = &#63; and groupId = &#63; from the database.
	 *
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLevelAndGroup(long levelId, long groupId)
		throws SystemException {
		for (TTHC_Entry tthc_Entry : findByLevelAndGroup(levelId, groupId)) {
			remove(tthc_Entry);
		}
	}

	/**
	 * Removes all the t t h c_ entries where departmentId = &#63; and companyId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDepartmentAndCompany(long departmentId, long companyId)
		throws SystemException {
		for (TTHC_Entry tthc_Entry : findByDepartmentAndCompany(departmentId,
				companyId)) {
			remove(tthc_Entry);
		}
	}

	/**
	 * Removes all the t t h c_ entries where departmentId = &#63; and groupId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDepartmentAndGroup(long departmentId, long groupId)
		throws SystemException {
		for (TTHC_Entry tthc_Entry : findByDepartmentAndGroup(departmentId,
				groupId)) {
			remove(tthc_Entry);
		}
	}

	/**
	 * Removes all the t t h c_ entries where categoryId = &#63; and companyId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryAndCompany(long categoryId, long companyId)
		throws SystemException {
		for (TTHC_Entry tthc_Entry : findByCategoryAndCompany(categoryId,
				companyId)) {
			remove(tthc_Entry);
		}
	}

	/**
	 * Removes all the t t h c_ entries where categoryId = &#63; and groupId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryAndGroup(long categoryId, long groupId)
		throws SystemException {
		for (TTHC_Entry tthc_Entry : findByCategoryAndGroup(categoryId, groupId)) {
			remove(tthc_Entry);
		}
	}

	/**
	 * Removes all the t t h c_ entries where audienceId = &#63; and companyId = &#63; from the database.
	 *
	 * @param audienceId the audience ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAudienceAndCompany(long audienceId, long companyId)
		throws SystemException {
		for (TTHC_Entry tthc_Entry : findByAudienceAndCompany(audienceId,
				companyId)) {
			remove(tthc_Entry);
		}
	}

	/**
	 * Removes all the t t h c_ entries where audienceId = &#63; and groupId = &#63; from the database.
	 *
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAudienceAndGroup(long audienceId, long groupId)
		throws SystemException {
		for (TTHC_Entry tthc_Entry : findByAudienceAndGroup(audienceId, groupId)) {
			remove(tthc_Entry);
		}
	}

	/**
	 * Removes all the t t h c_ entries where resultTypeId = &#63; and companyId = &#63; from the database.
	 *
	 * @param resultTypeId the result type ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByResultTypeAndCompany(long resultTypeId, long companyId)
		throws SystemException {
		for (TTHC_Entry tthc_Entry : findByResultTypeAndCompany(resultTypeId,
				companyId)) {
			remove(tthc_Entry);
		}
	}

	/**
	 * Removes all the t t h c_ entries where resultTypeId = &#63; and groupId = &#63; from the database.
	 *
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByResultTypeAndGroup(long resultTypeId, long groupId)
		throws SystemException {
		for (TTHC_Entry tthc_Entry : findByResultTypeAndGroup(resultTypeId,
				groupId)) {
			remove(tthc_Entry);
		}
	}

	/**
	 * Removes all the t t h c_ entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TTHC_Entry tthc_Entry : findAll()) {
			remove(tthc_Entry);
		}
	}

	/**
	 * Returns the number of t t h c_ entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TTHC_ENTRY_WHERE);

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
	 * Returns the number of t t h c_ entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TTHC_ENTRY_WHERE);

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
	 * Returns the number of t t h c_ entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
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
	 * Returns the number of t t h c_ entries where levelId = &#63; and companyId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param companyId the company ID
	 * @return the number of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLevelAndCompany(long levelId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { levelId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LEVELANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_LEVELANDCOMPANY_LEVELID_2);

			query.append(_FINDER_COLUMN_LEVELANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(levelId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEVELANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c_ entries where levelId = &#63; and groupId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLevelAndGroup(long levelId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { levelId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LEVELANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_LEVELANDGROUP_LEVELID_2);

			query.append(_FINDER_COLUMN_LEVELANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(levelId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEVELANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c_ entries that the user has permission to view where levelId = &#63; and groupId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByLevelAndGroup(long levelId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByLevelAndGroup(levelId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_LEVELANDGROUP_LEVELID_2);

		query.append(_FINDER_COLUMN_LEVELANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(levelId);

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
	 * Returns the number of t t h c_ entries where departmentId = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @return the number of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDepartmentAndCompany(long departmentId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { departmentId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTANDCOMPANY_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c_ entries where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDepartmentAndGroup(long departmentId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { departmentId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByDepartmentAndGroup(long departmentId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByDepartmentAndGroup(departmentId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(departmentId);

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
	 * Returns the number of t t h c_ entries where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @return the number of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryAndCompany(long categoryId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { categoryId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c_ entries where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryAndGroup(long categoryId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { categoryId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByCategoryAndGroup(long categoryId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCategoryAndGroup(categoryId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(categoryId);

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
	 * Returns the number of t t h c_ entries where audienceId = &#63; and companyId = &#63;.
	 *
	 * @param audienceId the audience ID
	 * @param companyId the company ID
	 * @return the number of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAudienceAndCompany(long audienceId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { audienceId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AUDIENCEANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_AUDIENCEANDCOMPANY_AUDIENCEID_2);

			query.append(_FINDER_COLUMN_AUDIENCEANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(audienceId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AUDIENCEANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c_ entries where audienceId = &#63; and groupId = &#63;.
	 *
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAudienceAndGroup(long audienceId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { audienceId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AUDIENCEANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_AUDIENCEANDGROUP_AUDIENCEID_2);

			query.append(_FINDER_COLUMN_AUDIENCEANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(audienceId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AUDIENCEANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c_ entries that the user has permission to view where audienceId = &#63; and groupId = &#63;.
	 *
	 * @param audienceId the audience ID
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByAudienceAndGroup(long audienceId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByAudienceAndGroup(audienceId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_AUDIENCEANDGROUP_AUDIENCEID_2);

		query.append(_FINDER_COLUMN_AUDIENCEANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(audienceId);

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
	 * Returns the number of t t h c_ entries where resultTypeId = &#63; and companyId = &#63;.
	 *
	 * @param resultTypeId the result type ID
	 * @param companyId the company ID
	 * @return the number of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByResultTypeAndCompany(long resultTypeId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { resultTypeId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RESULTTYPEANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_RESULTTYPEANDCOMPANY_RESULTTYPEID_2);

			query.append(_FINDER_COLUMN_RESULTTYPEANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(resultTypeId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RESULTTYPEANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c_ entries where resultTypeId = &#63; and groupId = &#63;.
	 *
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByResultTypeAndGroup(long resultTypeId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { resultTypeId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RESULTTYPEANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_RESULTTYPEANDGROUP_RESULTTYPEID_2);

			query.append(_FINDER_COLUMN_RESULTTYPEANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(resultTypeId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RESULTTYPEANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t t h c_ entries that the user has permission to view where resultTypeId = &#63; and groupId = &#63;.
	 *
	 * @param resultTypeId the result type ID
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByResultTypeAndGroup(long resultTypeId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByResultTypeAndGroup(resultTypeId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TTHC_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_RESULTTYPEANDGROUP_RESULTTYPEID_2);

		query.append(_FINDER_COLUMN_RESULTTYPEANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(resultTypeId);

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
	 * Returns the number of t t h c_ entries.
	 *
	 * @return the number of t t h c_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TTHC_ENTRY);

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
	 * Initializes the t t h c_ entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.tthc.model.TTHC_Entry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TTHC_Entry>> listenersList = new ArrayList<ModelListener<TTHC_Entry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TTHC_Entry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TTHC_EntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = TTHC_AttributePersistence.class)
	protected TTHC_AttributePersistence tthc_AttributePersistence;
	@BeanReference(type = TTHC_CategoryPersistence.class)
	protected TTHC_CategoryPersistence tthc_CategoryPersistence;
	@BeanReference(type = TTHC_EntryPersistence.class)
	protected TTHC_EntryPersistence tthc_EntryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TTHC_ENTRY = "SELECT tthc_Entry FROM TTHC_Entry tthc_Entry";
	private static final String _SQL_SELECT_TTHC_ENTRY_WHERE = "SELECT tthc_Entry FROM TTHC_Entry tthc_Entry WHERE ";
	private static final String _SQL_COUNT_TTHC_ENTRY = "SELECT COUNT(tthc_Entry) FROM TTHC_Entry tthc_Entry";
	private static final String _SQL_COUNT_TTHC_ENTRY_WHERE = "SELECT COUNT(tthc_Entry) FROM TTHC_Entry tthc_Entry WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "tthc_Entry.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "tthc_Entry.groupId = ?";
	private static final String _FINDER_COLUMN_LEVELANDCOMPANY_LEVELID_2 = "tthc_Entry.levelId = ? AND ";
	private static final String _FINDER_COLUMN_LEVELANDCOMPANY_COMPANYID_2 = "tthc_Entry.companyId = ?";
	private static final String _FINDER_COLUMN_LEVELANDGROUP_LEVELID_2 = "tthc_Entry.levelId = ? AND ";
	private static final String _FINDER_COLUMN_LEVELANDGROUP_GROUPID_2 = "tthc_Entry.groupId = ?";
	private static final String _FINDER_COLUMN_DEPARTMENTANDCOMPANY_DEPARTMENTID_2 =
		"tthc_Entry.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_DEPARTMENTANDCOMPANY_COMPANYID_2 = "tthc_Entry.companyId = ?";
	private static final String _FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2 =
		"tthc_Entry.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2 = "tthc_Entry.groupId = ?";
	private static final String _FINDER_COLUMN_CATEGORYANDCOMPANY_CATEGORYID_2 = "tthc_Entry.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDCOMPANY_COMPANYID_2 = "tthc_Entry.companyId = ?";
	private static final String _FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2 = "tthc_Entry.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2 = "tthc_Entry.groupId = ?";
	private static final String _FINDER_COLUMN_AUDIENCEANDCOMPANY_AUDIENCEID_2 = "tthc_Entry.audienceId = ? AND ";
	private static final String _FINDER_COLUMN_AUDIENCEANDCOMPANY_COMPANYID_2 = "tthc_Entry.companyId = ?";
	private static final String _FINDER_COLUMN_AUDIENCEANDGROUP_AUDIENCEID_2 = "tthc_Entry.audienceId = ? AND ";
	private static final String _FINDER_COLUMN_AUDIENCEANDGROUP_GROUPID_2 = "tthc_Entry.groupId = ?";
	private static final String _FINDER_COLUMN_RESULTTYPEANDCOMPANY_RESULTTYPEID_2 =
		"tthc_Entry.resultTypeId = ? AND ";
	private static final String _FINDER_COLUMN_RESULTTYPEANDCOMPANY_COMPANYID_2 = "tthc_Entry.companyId = ?";
	private static final String _FINDER_COLUMN_RESULTTYPEANDGROUP_RESULTTYPEID_2 =
		"tthc_Entry.resultTypeId = ? AND ";
	private static final String _FINDER_COLUMN_RESULTTYPEANDGROUP_GROUPID_2 = "tthc_Entry.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "tthc_Entry.entryId";
	private static final String _FILTER_SQL_SELECT_TTHC_ENTRY_WHERE = "SELECT DISTINCT {tthc_Entry.*} FROM tthc_entry tthc_Entry WHERE ";
	private static final String _FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {tthc_entry.*} FROM (SELECT DISTINCT tthc_Entry.entryId FROM tthc_entry tthc_Entry WHERE ";
	private static final String _FILTER_SQL_SELECT_TTHC_ENTRY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN tthc_entry ON TEMP_TABLE.entryId = tthc_entry.entryId";
	private static final String _FILTER_SQL_COUNT_TTHC_ENTRY_WHERE = "SELECT COUNT(DISTINCT tthc_Entry.entryId) AS COUNT_VALUE FROM tthc_entry tthc_Entry WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "tthc_Entry";
	private static final String _FILTER_ENTITY_TABLE = "tthc_entry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tthc_Entry.";
	private static final String _ORDER_BY_ENTITY_TABLE = "tthc_entry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TTHC_Entry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TTHC_Entry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TTHC_EntryPersistenceImpl.class);
	private static TTHC_Entry _nullTTHC_Entry = new TTHC_EntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TTHC_Entry> toCacheModel() {
				return _nullTTHC_EntryCacheModel;
			}
		};

	private static CacheModel<TTHC_Entry> _nullTTHC_EntryCacheModel = new CacheModel<TTHC_Entry>() {
			public TTHC_Entry toEntityModel() {
				return _nullTTHC_Entry;
			}
		};
}