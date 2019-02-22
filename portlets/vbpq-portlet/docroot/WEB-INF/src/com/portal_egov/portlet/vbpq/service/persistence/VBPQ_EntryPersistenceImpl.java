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

import com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;
import com.portal_egov.portlet.vbpq.model.VBPQ_Entry;
import com.portal_egov.portlet.vbpq.model.impl.VBPQ_EntryImpl;
import com.portal_egov.portlet.vbpq.model.impl.VBPQ_EntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the v b p q_ entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see VBPQ_EntryPersistence
 * @see VBPQ_EntryUtil
 * @generated
 */
public class VBPQ_EntryPersistenceImpl extends BasePersistenceImpl<VBPQ_Entry>
	implements VBPQ_EntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VBPQ_EntryUtil} to access the v b p q_ entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VBPQ_EntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			VBPQ_EntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			VBPQ_EntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDepartmentAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDepartmentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			VBPQ_EntryModelImpl.DEPARTMENTID_COLUMN_BITMASK |
			VBPQ_EntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTANDCOMPANY = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDepartmentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTANDGROUP =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDepartmentAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDGROUP =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDepartmentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			VBPQ_EntryModelImpl.DEPARTMENTID_COLUMN_BITMASK |
			VBPQ_EntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTANDGROUP = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDepartmentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDCOMPANY =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			VBPQ_EntryModelImpl.CATEGORYID_COLUMN_BITMASK |
			VBPQ_EntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDGROUP =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			VBPQ_EntryModelImpl.CATEGORYID_COLUMN_BITMASK |
			VBPQ_EntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDGROUP = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCTYPEANDCOMPANY =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocTypeAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCTYPEANDCOMPANY =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDocTypeAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			VBPQ_EntryModelImpl.DOCTYPEID_COLUMN_BITMASK |
			VBPQ_EntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOCTYPEANDCOMPANY = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDocTypeAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCTYPEANDGROUP =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocTypeAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCTYPEANDGROUP =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocTypeAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			VBPQ_EntryModelImpl.DOCTYPEID_COLUMN_BITMASK |
			VBPQ_EntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOCTYPEANDGROUP = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDocTypeAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EXPIRATIONANDCOMPANY =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByExpirationAndCompany",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIRATIONANDCOMPANY =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByExpirationAndCompany",
			new String[] { Boolean.class.getName(), Long.class.getName() },
			VBPQ_EntryModelImpl.NEVEREXPIRED_COLUMN_BITMASK |
			VBPQ_EntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EXPIRATIONANDCOMPANY = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExpirationAndCompany",
			new String[] { Boolean.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EXPIRATIONANDGROUP =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByExpirationAndGroup",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIRATIONANDGROUP =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByExpirationAndGroup",
			new String[] { Boolean.class.getName(), Long.class.getName() },
			VBPQ_EntryModelImpl.NEVEREXPIRED_COLUMN_BITMASK |
			VBPQ_EntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EXPIRATIONANDGROUP = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExpirationAndGroup",
			new String[] { Boolean.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDCOMPANY =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusAndCompany",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatusAndCompany",
			new String[] { Boolean.class.getName(), Long.class.getName() },
			VBPQ_EntryModelImpl.ACTIVE_COLUMN_BITMASK |
			VBPQ_EntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDCOMPANY = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusAndCompany",
			new String[] { Boolean.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDGROUP =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusAndGroup",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP =
		new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusAndGroup",
			new String[] { Boolean.class.getName(), Long.class.getName() },
			VBPQ_EntryModelImpl.ACTIVE_COLUMN_BITMASK |
			VBPQ_EntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDGROUP = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusAndGroup",
			new String[] { Boolean.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, VBPQ_EntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the v b p q_ entry in the entity cache if it is enabled.
	 *
	 * @param vbpq_Entry the v b p q_ entry
	 */
	public void cacheResult(VBPQ_Entry vbpq_Entry) {
		EntityCacheUtil.putResult(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryImpl.class, vbpq_Entry.getPrimaryKey(), vbpq_Entry);

		vbpq_Entry.resetOriginalValues();
	}

	/**
	 * Caches the v b p q_ entries in the entity cache if it is enabled.
	 *
	 * @param vbpq_Entries the v b p q_ entries
	 */
	public void cacheResult(List<VBPQ_Entry> vbpq_Entries) {
		for (VBPQ_Entry vbpq_Entry : vbpq_Entries) {
			if (EntityCacheUtil.getResult(
						VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
						VBPQ_EntryImpl.class, vbpq_Entry.getPrimaryKey()) == null) {
				cacheResult(vbpq_Entry);
			}
			else {
				vbpq_Entry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v b p q_ entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VBPQ_EntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VBPQ_EntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v b p q_ entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VBPQ_Entry vbpq_Entry) {
		EntityCacheUtil.removeResult(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryImpl.class, vbpq_Entry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VBPQ_Entry> vbpq_Entries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VBPQ_Entry vbpq_Entry : vbpq_Entries) {
			EntityCacheUtil.removeResult(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
				VBPQ_EntryImpl.class, vbpq_Entry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new v b p q_ entry with the primary key. Does not add the v b p q_ entry to the database.
	 *
	 * @param entryId the primary key for the new v b p q_ entry
	 * @return the new v b p q_ entry
	 */
	public VBPQ_Entry create(long entryId) {
		VBPQ_Entry vbpq_Entry = new VBPQ_EntryImpl();

		vbpq_Entry.setNew(true);
		vbpq_Entry.setPrimaryKey(entryId);

		return vbpq_Entry;
	}

	/**
	 * Removes the v b p q_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the v b p q_ entry
	 * @return the v b p q_ entry that was removed
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry remove(long entryId)
		throws NoSuchVBPQ_EntryException, SystemException {
		return remove(Long.valueOf(entryId));
	}

	/**
	 * Removes the v b p q_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v b p q_ entry
	 * @return the v b p q_ entry that was removed
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VBPQ_Entry remove(Serializable primaryKey)
		throws NoSuchVBPQ_EntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry vbpq_Entry = (VBPQ_Entry)session.get(VBPQ_EntryImpl.class,
					primaryKey);

			if (vbpq_Entry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVBPQ_EntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vbpq_Entry);
		}
		catch (NoSuchVBPQ_EntryException nsee) {
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
	protected VBPQ_Entry removeImpl(VBPQ_Entry vbpq_Entry)
		throws SystemException {
		vbpq_Entry = toUnwrappedModel(vbpq_Entry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vbpq_Entry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vbpq_Entry);

		return vbpq_Entry;
	}

	@Override
	public VBPQ_Entry updateImpl(
		com.portal_egov.portlet.vbpq.model.VBPQ_Entry vbpq_Entry, boolean merge)
		throws SystemException {
		vbpq_Entry = toUnwrappedModel(vbpq_Entry);

		boolean isNew = vbpq_Entry.isNew();

		VBPQ_EntryModelImpl vbpq_EntryModelImpl = (VBPQ_EntryModelImpl)vbpq_Entry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vbpq_Entry, merge);

			vbpq_Entry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VBPQ_EntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vbpq_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((vbpq_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((vbpq_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getOriginalDepartmentId()),
						Long.valueOf(vbpq_EntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getDepartmentId()),
						Long.valueOf(vbpq_EntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDCOMPANY,
					args);
			}

			if ((vbpq_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getOriginalDepartmentId()),
						Long.valueOf(vbpq_EntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getDepartmentId()),
						Long.valueOf(vbpq_EntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTANDGROUP,
					args);
			}

			if ((vbpq_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getOriginalCategoryId()),
						Long.valueOf(vbpq_EntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getCategoryId()),
						Long.valueOf(vbpq_EntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY,
					args);
			}

			if ((vbpq_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getOriginalCategoryId()),
						Long.valueOf(vbpq_EntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getCategoryId()),
						Long.valueOf(vbpq_EntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP,
					args);
			}

			if ((vbpq_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCTYPEANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getOriginalDocTypeId()),
						Long.valueOf(vbpq_EntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCTYPEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCTYPEANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getDocTypeId()),
						Long.valueOf(vbpq_EntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCTYPEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCTYPEANDCOMPANY,
					args);
			}

			if ((vbpq_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCTYPEANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getOriginalDocTypeId()),
						Long.valueOf(vbpq_EntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCTYPEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCTYPEANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(vbpq_EntryModelImpl.getDocTypeId()),
						Long.valueOf(vbpq_EntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCTYPEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCTYPEANDGROUP,
					args);
			}

			if ((vbpq_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIRATIONANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(vbpq_EntryModelImpl.getOriginalNeverExpired()),
						Long.valueOf(vbpq_EntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXPIRATIONANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIRATIONANDCOMPANY,
					args);

				args = new Object[] {
						Boolean.valueOf(vbpq_EntryModelImpl.getNeverExpired()),
						Long.valueOf(vbpq_EntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXPIRATIONANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIRATIONANDCOMPANY,
					args);
			}

			if ((vbpq_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIRATIONANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(vbpq_EntryModelImpl.getOriginalNeverExpired()),
						Long.valueOf(vbpq_EntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXPIRATIONANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIRATIONANDGROUP,
					args);

				args = new Object[] {
						Boolean.valueOf(vbpq_EntryModelImpl.getNeverExpired()),
						Long.valueOf(vbpq_EntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXPIRATIONANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIRATIONANDGROUP,
					args);
			}

			if ((vbpq_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(vbpq_EntryModelImpl.getOriginalActive()),
						Long.valueOf(vbpq_EntryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY,
					args);

				args = new Object[] {
						Boolean.valueOf(vbpq_EntryModelImpl.getActive()),
						Long.valueOf(vbpq_EntryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY,
					args);
			}

			if ((vbpq_EntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(vbpq_EntryModelImpl.getOriginalActive()),
						Long.valueOf(vbpq_EntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP,
					args);

				args = new Object[] {
						Boolean.valueOf(vbpq_EntryModelImpl.getActive()),
						Long.valueOf(vbpq_EntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_EntryImpl.class, vbpq_Entry.getPrimaryKey(), vbpq_Entry);

		return vbpq_Entry;
	}

	protected VBPQ_Entry toUnwrappedModel(VBPQ_Entry vbpq_Entry) {
		if (vbpq_Entry instanceof VBPQ_EntryImpl) {
			return vbpq_Entry;
		}

		VBPQ_EntryImpl vbpq_EntryImpl = new VBPQ_EntryImpl();

		vbpq_EntryImpl.setNew(vbpq_Entry.isNew());
		vbpq_EntryImpl.setPrimaryKey(vbpq_Entry.getPrimaryKey());

		vbpq_EntryImpl.setEntryId(vbpq_Entry.getEntryId());
		vbpq_EntryImpl.setDepartmentId(vbpq_Entry.getDepartmentId());
		vbpq_EntryImpl.setCategoryId(vbpq_Entry.getCategoryId());
		vbpq_EntryImpl.setDocTypeId(vbpq_Entry.getDocTypeId());
		vbpq_EntryImpl.setCompanyId(vbpq_Entry.getCompanyId());
		vbpq_EntryImpl.setGroupId(vbpq_Entry.getGroupId());
		vbpq_EntryImpl.setUserId(vbpq_Entry.getUserId());
		vbpq_EntryImpl.setUserName(vbpq_Entry.getUserName());
		vbpq_EntryImpl.setEntryName(vbpq_Entry.getEntryName());
		vbpq_EntryImpl.setEntryCode(vbpq_Entry.getEntryCode());
		vbpq_EntryImpl.setEntryDesc(vbpq_Entry.getEntryDesc());
		vbpq_EntryImpl.setFileAttachmentURL(vbpq_Entry.getFileAttachmentURL());
		vbpq_EntryImpl.setPublicatorName(vbpq_Entry.getPublicatorName());
		vbpq_EntryImpl.setCreateDate(vbpq_Entry.getCreateDate());
		vbpq_EntryImpl.setModifiedDate(vbpq_Entry.getModifiedDate());
		vbpq_EntryImpl.setPublishDate(vbpq_Entry.getPublishDate());
		vbpq_EntryImpl.setExecuteDate(vbpq_Entry.getExecuteDate());
		vbpq_EntryImpl.setExpirationDate(vbpq_Entry.getExpirationDate());
		vbpq_EntryImpl.setNeverExpired(vbpq_Entry.isNeverExpired());
		vbpq_EntryImpl.setActive(vbpq_Entry.isActive());

		return vbpq_EntryImpl;
	}

	/**
	 * Returns the v b p q_ entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v b p q_ entry
	 * @return the v b p q_ entry
	 * @throws com.liferay.portal.NoSuchModelException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VBPQ_Entry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the v b p q_ entry with the primary key or throws a {@link com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException} if it could not be found.
	 *
	 * @param entryId the primary key of the v b p q_ entry
	 * @return the v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByPrimaryKey(long entryId)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByPrimaryKey(entryId);

		if (vbpq_Entry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entryId);
			}

			throw new NoSuchVBPQ_EntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				entryId);
		}

		return vbpq_Entry;
	}

	/**
	 * Returns the v b p q_ entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v b p q_ entry
	 * @return the v b p q_ entry, or <code>null</code> if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VBPQ_Entry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the v b p q_ entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the v b p q_ entry
	 * @return the v b p q_ entry, or <code>null</code> if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByPrimaryKey(long entryId) throws SystemException {
		VBPQ_Entry vbpq_Entry = (VBPQ_Entry)EntityCacheUtil.getResult(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
				VBPQ_EntryImpl.class, entryId);

		if (vbpq_Entry == _nullVBPQ_Entry) {
			return null;
		}

		if (vbpq_Entry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vbpq_Entry = (VBPQ_Entry)session.get(VBPQ_EntryImpl.class,
						Long.valueOf(entryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vbpq_Entry != null) {
					cacheResult(vbpq_Entry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VBPQ_EntryModelImpl.ENTITY_CACHE_ENABLED,
						VBPQ_EntryImpl.class, entryId, _nullVBPQ_Entry);
				}

				closeSession(session);
			}
		}

		return vbpq_Entry;
	}

	/**
	 * Returns all the v b p q_ entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the v b p q_ entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByCompany(long companyId, int start, int end,
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

		List<VBPQ_Entry> list = (List<VBPQ_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Entry vbpq_Entry : list) {
				if ((companyId != vbpq_Entry.getCompanyId())) {
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

			query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first v b p q_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByCompany_First(companyId,
				orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VBPQ_Entry> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByCompany_Last(companyId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<VBPQ_Entry> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where companyId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] findByCompany_PrevAndNext(long entryId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, vbpq_Entry, companyId,
					orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = getByCompany_PrevAndNext(session, vbpq_Entry, companyId,
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

	protected VBPQ_Entry getByCompany_PrevAndNext(Session session,
		VBPQ_Entry vbpq_Entry, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

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
			query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByGroup(long groupId, int start, int end,
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

		List<VBPQ_Entry> list = (List<VBPQ_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Entry vbpq_Entry : list) {
				if ((groupId != vbpq_Entry.getGroupId())) {
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

			query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first v b p q_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByGroup_First(groupId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VBPQ_Entry> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByGroup_Last(groupId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<VBPQ_Entry> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where groupId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] findByGroup_PrevAndNext(long entryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, vbpq_Entry, groupId,
					orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = getByGroup_PrevAndNext(session, vbpq_Entry, groupId,
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

	protected VBPQ_Entry getByGroup_PrevAndNext(Session session,
		VBPQ_Entry vbpq_Entry, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

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
			query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the v b p q_ entries that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByGroup(long groupId, int start, int end,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_EntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_EntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set of v b p q_ entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] filterFindByGroup_PrevAndNext(long entryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(entryId, groupId, orderByComparator);
		}

		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, vbpq_Entry,
					groupId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = filterGetByGroup_PrevAndNext(session, vbpq_Entry,
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

	protected VBPQ_Entry filterGetByGroup_PrevAndNext(Session session,
		VBPQ_Entry vbpq_Entry, long groupId,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_EntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_EntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries where departmentId = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @return the matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByDepartmentAndCompany(long departmentId,
		long companyId) throws SystemException {
		return findByDepartmentAndCompany(departmentId, companyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries where departmentId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByDepartmentAndCompany(long departmentId,
		long companyId, int start, int end) throws SystemException {
		return findByDepartmentAndCompany(departmentId, companyId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries where departmentId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByDepartmentAndCompany(long departmentId,
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

		List<VBPQ_Entry> list = (List<VBPQ_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Entry vbpq_Entry : list) {
				if ((departmentId != vbpq_Entry.getDepartmentId()) ||
						(companyId != vbpq_Entry.getCompanyId())) {
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

			query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTANDCOMPANY_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				qPos.add(companyId);

				list = (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first v b p q_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByDepartmentAndCompany_First(long departmentId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByDepartmentAndCompany_First(departmentId,
				companyId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByDepartmentAndCompany_First(long departmentId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VBPQ_Entry> list = findByDepartmentAndCompany(departmentId,
				companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByDepartmentAndCompany_Last(long departmentId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByDepartmentAndCompany_Last(departmentId,
				companyId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByDepartmentAndCompany_Last(long departmentId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDepartmentAndCompany(departmentId, companyId);

		List<VBPQ_Entry> list = findByDepartmentAndCompany(departmentId,
				companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] findByDepartmentAndCompany_PrevAndNext(long entryId,
		long departmentId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = getByDepartmentAndCompany_PrevAndNext(session,
					vbpq_Entry, departmentId, companyId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = getByDepartmentAndCompany_PrevAndNext(session,
					vbpq_Entry, departmentId, companyId, orderByComparator,
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

	protected VBPQ_Entry getByDepartmentAndCompany_PrevAndNext(
		Session session, VBPQ_Entry vbpq_Entry, long departmentId,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

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
			query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @return the matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByDepartmentAndGroup(long departmentId,
		long groupId) throws SystemException {
		return findByDepartmentAndGroup(departmentId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries where departmentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByDepartmentAndGroup(long departmentId,
		long groupId, int start, int end) throws SystemException {
		return findByDepartmentAndGroup(departmentId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries where departmentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByDepartmentAndGroup(long departmentId,
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

		List<VBPQ_Entry> list = (List<VBPQ_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Entry vbpq_Entry : list) {
				if ((departmentId != vbpq_Entry.getDepartmentId()) ||
						(groupId != vbpq_Entry.getGroupId())) {
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

			query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				qPos.add(groupId);

				list = (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first v b p q_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByDepartmentAndGroup_First(long departmentId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByDepartmentAndGroup_First(departmentId,
				groupId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByDepartmentAndGroup_First(long departmentId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VBPQ_Entry> list = findByDepartmentAndGroup(departmentId, groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByDepartmentAndGroup_Last(long departmentId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByDepartmentAndGroup_Last(departmentId,
				groupId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByDepartmentAndGroup_Last(long departmentId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDepartmentAndGroup(departmentId, groupId);

		List<VBPQ_Entry> list = findByDepartmentAndGroup(departmentId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] findByDepartmentAndGroup_PrevAndNext(long entryId,
		long departmentId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = getByDepartmentAndGroup_PrevAndNext(session, vbpq_Entry,
					departmentId, groupId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = getByDepartmentAndGroup_PrevAndNext(session, vbpq_Entry,
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

	protected VBPQ_Entry getByDepartmentAndGroup_PrevAndNext(Session session,
		VBPQ_Entry vbpq_Entry, long departmentId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

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
			query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @return the matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByDepartmentAndGroup(long departmentId,
		long groupId) throws SystemException {
		return filterFindByDepartmentAndGroup(departmentId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByDepartmentAndGroup(long departmentId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByDepartmentAndGroup(departmentId, groupId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries that the user has permissions to view where departmentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByDepartmentAndGroup(long departmentId,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_EntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_EntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(departmentId);

			qPos.add(groupId);

			return (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set of v b p q_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] filterFindByDepartmentAndGroup_PrevAndNext(
		long entryId, long departmentId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByDepartmentAndGroup_PrevAndNext(entryId, departmentId,
				groupId, orderByComparator);
		}

		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = filterGetByDepartmentAndGroup_PrevAndNext(session,
					vbpq_Entry, departmentId, groupId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = filterGetByDepartmentAndGroup_PrevAndNext(session,
					vbpq_Entry, departmentId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Entry filterGetByDepartmentAndGroup_PrevAndNext(
		Session session, VBPQ_Entry vbpq_Entry, long departmentId,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_EntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_EntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @return the matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByCategoryAndCompany(long categoryId,
		long companyId) throws SystemException {
		return findByCategoryAndCompany(categoryId, companyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries where categoryId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByCategoryAndCompany(long categoryId,
		long companyId, int start, int end) throws SystemException {
		return findByCategoryAndCompany(categoryId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries where categoryId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByCategoryAndCompany(long categoryId,
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

		List<VBPQ_Entry> list = (List<VBPQ_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Entry vbpq_Entry : list) {
				if ((categoryId != vbpq_Entry.getCategoryId()) ||
						(companyId != vbpq_Entry.getCompanyId())) {
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

			query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(companyId);

				list = (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first v b p q_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByCategoryAndCompany_First(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByCategoryAndCompany_First(categoryId,
				companyId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByCategoryAndCompany_First(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VBPQ_Entry> list = findByCategoryAndCompany(categoryId, companyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByCategoryAndCompany_Last(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByCategoryAndCompany_Last(categoryId,
				companyId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByCategoryAndCompany_Last(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryAndCompany(categoryId, companyId);

		List<VBPQ_Entry> list = findByCategoryAndCompany(categoryId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] findByCategoryAndCompany_PrevAndNext(long entryId,
		long categoryId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = getByCategoryAndCompany_PrevAndNext(session, vbpq_Entry,
					categoryId, companyId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = getByCategoryAndCompany_PrevAndNext(session, vbpq_Entry,
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

	protected VBPQ_Entry getByCategoryAndCompany_PrevAndNext(Session session,
		VBPQ_Entry vbpq_Entry, long categoryId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

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
			query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByCategoryAndGroup(long categoryId, long groupId)
		throws SystemException {
		return findByCategoryAndGroup(categoryId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByCategoryAndGroup(long categoryId,
		long groupId, int start, int end) throws SystemException {
		return findByCategoryAndGroup(categoryId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByCategoryAndGroup(long categoryId,
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

		List<VBPQ_Entry> list = (List<VBPQ_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Entry vbpq_Entry : list) {
				if ((categoryId != vbpq_Entry.getCategoryId()) ||
						(groupId != vbpq_Entry.getGroupId())) {
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

			query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(groupId);

				list = (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first v b p q_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByCategoryAndGroup_First(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByCategoryAndGroup_First(categoryId,
				groupId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByCategoryAndGroup_First(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VBPQ_Entry> list = findByCategoryAndGroup(categoryId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByCategoryAndGroup_Last(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByCategoryAndGroup_Last(categoryId,
				groupId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByCategoryAndGroup_Last(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryAndGroup(categoryId, groupId);

		List<VBPQ_Entry> list = findByCategoryAndGroup(categoryId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] findByCategoryAndGroup_PrevAndNext(long entryId,
		long categoryId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = getByCategoryAndGroup_PrevAndNext(session, vbpq_Entry,
					categoryId, groupId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = getByCategoryAndGroup_PrevAndNext(session, vbpq_Entry,
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

	protected VBPQ_Entry getByCategoryAndGroup_PrevAndNext(Session session,
		VBPQ_Entry vbpq_Entry, long categoryId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

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
			query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByCategoryAndGroup(long categoryId,
		long groupId) throws SystemException {
		return filterFindByCategoryAndGroup(categoryId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByCategoryAndGroup(long categoryId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByCategoryAndGroup(categoryId, groupId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries that the user has permissions to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByCategoryAndGroup(long categoryId,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_EntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_EntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(categoryId);

			qPos.add(groupId);

			return (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set of v b p q_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] filterFindByCategoryAndGroup_PrevAndNext(long entryId,
		long categoryId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryAndGroup_PrevAndNext(entryId, categoryId,
				groupId, orderByComparator);
		}

		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = filterGetByCategoryAndGroup_PrevAndNext(session,
					vbpq_Entry, categoryId, groupId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = filterGetByCategoryAndGroup_PrevAndNext(session,
					vbpq_Entry, categoryId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Entry filterGetByCategoryAndGroup_PrevAndNext(
		Session session, VBPQ_Entry vbpq_Entry, long categoryId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_EntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_EntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries where docTypeId = &#63; and companyId = &#63;.
	 *
	 * @param docTypeId the doc type ID
	 * @param companyId the company ID
	 * @return the matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByDocTypeAndCompany(long docTypeId,
		long companyId) throws SystemException {
		return findByDocTypeAndCompany(docTypeId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries where docTypeId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param docTypeId the doc type ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByDocTypeAndCompany(long docTypeId,
		long companyId, int start, int end) throws SystemException {
		return findByDocTypeAndCompany(docTypeId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries where docTypeId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param docTypeId the doc type ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByDocTypeAndCompany(long docTypeId,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCTYPEANDCOMPANY;
			finderArgs = new Object[] { docTypeId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCTYPEANDCOMPANY;
			finderArgs = new Object[] {
					docTypeId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<VBPQ_Entry> list = (List<VBPQ_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Entry vbpq_Entry : list) {
				if ((docTypeId != vbpq_Entry.getDocTypeId()) ||
						(companyId != vbpq_Entry.getCompanyId())) {
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

			query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_DOCTYPEANDCOMPANY_DOCTYPEID_2);

			query.append(_FINDER_COLUMN_DOCTYPEANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(docTypeId);

				qPos.add(companyId);

				list = (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first v b p q_ entry in the ordered set where docTypeId = &#63; and companyId = &#63;.
	 *
	 * @param docTypeId the doc type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByDocTypeAndCompany_First(long docTypeId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByDocTypeAndCompany_First(docTypeId,
				companyId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docTypeId=");
		msg.append(docTypeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ entry in the ordered set where docTypeId = &#63; and companyId = &#63;.
	 *
	 * @param docTypeId the doc type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByDocTypeAndCompany_First(long docTypeId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VBPQ_Entry> list = findByDocTypeAndCompany(docTypeId, companyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where docTypeId = &#63; and companyId = &#63;.
	 *
	 * @param docTypeId the doc type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByDocTypeAndCompany_Last(long docTypeId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByDocTypeAndCompany_Last(docTypeId,
				companyId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docTypeId=");
		msg.append(docTypeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where docTypeId = &#63; and companyId = &#63;.
	 *
	 * @param docTypeId the doc type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByDocTypeAndCompany_Last(long docTypeId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDocTypeAndCompany(docTypeId, companyId);

		List<VBPQ_Entry> list = findByDocTypeAndCompany(docTypeId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where docTypeId = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param docTypeId the doc type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] findByDocTypeAndCompany_PrevAndNext(long entryId,
		long docTypeId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = getByDocTypeAndCompany_PrevAndNext(session, vbpq_Entry,
					docTypeId, companyId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = getByDocTypeAndCompany_PrevAndNext(session, vbpq_Entry,
					docTypeId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Entry getByDocTypeAndCompany_PrevAndNext(Session session,
		VBPQ_Entry vbpq_Entry, long docTypeId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_DOCTYPEANDCOMPANY_DOCTYPEID_2);

		query.append(_FINDER_COLUMN_DOCTYPEANDCOMPANY_COMPANYID_2);

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
			query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(docTypeId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries where docTypeId = &#63; and groupId = &#63;.
	 *
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @return the matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByDocTypeAndGroup(long docTypeId, long groupId)
		throws SystemException {
		return findByDocTypeAndGroup(docTypeId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries where docTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByDocTypeAndGroup(long docTypeId, long groupId,
		int start, int end) throws SystemException {
		return findByDocTypeAndGroup(docTypeId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries where docTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByDocTypeAndGroup(long docTypeId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCTYPEANDGROUP;
			finderArgs = new Object[] { docTypeId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCTYPEANDGROUP;
			finderArgs = new Object[] {
					docTypeId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VBPQ_Entry> list = (List<VBPQ_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Entry vbpq_Entry : list) {
				if ((docTypeId != vbpq_Entry.getDocTypeId()) ||
						(groupId != vbpq_Entry.getGroupId())) {
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

			query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_DOCTYPEANDGROUP_DOCTYPEID_2);

			query.append(_FINDER_COLUMN_DOCTYPEANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(docTypeId);

				qPos.add(groupId);

				list = (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first v b p q_ entry in the ordered set where docTypeId = &#63; and groupId = &#63;.
	 *
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByDocTypeAndGroup_First(long docTypeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByDocTypeAndGroup_First(docTypeId,
				groupId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docTypeId=");
		msg.append(docTypeId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ entry in the ordered set where docTypeId = &#63; and groupId = &#63;.
	 *
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByDocTypeAndGroup_First(long docTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VBPQ_Entry> list = findByDocTypeAndGroup(docTypeId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where docTypeId = &#63; and groupId = &#63;.
	 *
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByDocTypeAndGroup_Last(long docTypeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByDocTypeAndGroup_Last(docTypeId, groupId,
				orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docTypeId=");
		msg.append(docTypeId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where docTypeId = &#63; and groupId = &#63;.
	 *
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByDocTypeAndGroup_Last(long docTypeId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDocTypeAndGroup(docTypeId, groupId);

		List<VBPQ_Entry> list = findByDocTypeAndGroup(docTypeId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where docTypeId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] findByDocTypeAndGroup_PrevAndNext(long entryId,
		long docTypeId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = getByDocTypeAndGroup_PrevAndNext(session, vbpq_Entry,
					docTypeId, groupId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = getByDocTypeAndGroup_PrevAndNext(session, vbpq_Entry,
					docTypeId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Entry getByDocTypeAndGroup_PrevAndNext(Session session,
		VBPQ_Entry vbpq_Entry, long docTypeId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_DOCTYPEANDGROUP_DOCTYPEID_2);

		query.append(_FINDER_COLUMN_DOCTYPEANDGROUP_GROUPID_2);

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
			query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(docTypeId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries that the user has permission to view where docTypeId = &#63; and groupId = &#63;.
	 *
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @return the matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByDocTypeAndGroup(long docTypeId,
		long groupId) throws SystemException {
		return filterFindByDocTypeAndGroup(docTypeId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries that the user has permission to view where docTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByDocTypeAndGroup(long docTypeId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByDocTypeAndGroup(docTypeId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries that the user has permissions to view where docTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByDocTypeAndGroup(long docTypeId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByDocTypeAndGroup(docTypeId, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_DOCTYPEANDGROUP_DOCTYPEID_2);

		query.append(_FINDER_COLUMN_DOCTYPEANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_EntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_EntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(docTypeId);

			qPos.add(groupId);

			return (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set of v b p q_ entries that the user has permission to view where docTypeId = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] filterFindByDocTypeAndGroup_PrevAndNext(long entryId,
		long docTypeId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByDocTypeAndGroup_PrevAndNext(entryId, docTypeId,
				groupId, orderByComparator);
		}

		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = filterGetByDocTypeAndGroup_PrevAndNext(session,
					vbpq_Entry, docTypeId, groupId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = filterGetByDocTypeAndGroup_PrevAndNext(session,
					vbpq_Entry, docTypeId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Entry filterGetByDocTypeAndGroup_PrevAndNext(
		Session session, VBPQ_Entry vbpq_Entry, long docTypeId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_DOCTYPEANDGROUP_DOCTYPEID_2);

		query.append(_FINDER_COLUMN_DOCTYPEANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_EntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_EntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(docTypeId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries where neverExpired = &#63; and companyId = &#63;.
	 *
	 * @param neverExpired the never expired
	 * @param companyId the company ID
	 * @return the matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByExpirationAndCompany(boolean neverExpired,
		long companyId) throws SystemException {
		return findByExpirationAndCompany(neverExpired, companyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries where neverExpired = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param neverExpired the never expired
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByExpirationAndCompany(boolean neverExpired,
		long companyId, int start, int end) throws SystemException {
		return findByExpirationAndCompany(neverExpired, companyId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries where neverExpired = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param neverExpired the never expired
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByExpirationAndCompany(boolean neverExpired,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIRATIONANDCOMPANY;
			finderArgs = new Object[] { neverExpired, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EXPIRATIONANDCOMPANY;
			finderArgs = new Object[] {
					neverExpired, companyId,
					
					start, end, orderByComparator
				};
		}

		List<VBPQ_Entry> list = (List<VBPQ_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Entry vbpq_Entry : list) {
				if ((neverExpired != vbpq_Entry.getNeverExpired()) ||
						(companyId != vbpq_Entry.getCompanyId())) {
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

			query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_EXPIRATIONANDCOMPANY_NEVEREXPIRED_2);

			query.append(_FINDER_COLUMN_EXPIRATIONANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(neverExpired);

				qPos.add(companyId);

				list = (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first v b p q_ entry in the ordered set where neverExpired = &#63; and companyId = &#63;.
	 *
	 * @param neverExpired the never expired
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByExpirationAndCompany_First(boolean neverExpired,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByExpirationAndCompany_First(neverExpired,
				companyId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("neverExpired=");
		msg.append(neverExpired);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ entry in the ordered set where neverExpired = &#63; and companyId = &#63;.
	 *
	 * @param neverExpired the never expired
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByExpirationAndCompany_First(boolean neverExpired,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VBPQ_Entry> list = findByExpirationAndCompany(neverExpired,
				companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where neverExpired = &#63; and companyId = &#63;.
	 *
	 * @param neverExpired the never expired
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByExpirationAndCompany_Last(boolean neverExpired,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByExpirationAndCompany_Last(neverExpired,
				companyId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("neverExpired=");
		msg.append(neverExpired);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where neverExpired = &#63; and companyId = &#63;.
	 *
	 * @param neverExpired the never expired
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByExpirationAndCompany_Last(boolean neverExpired,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByExpirationAndCompany(neverExpired, companyId);

		List<VBPQ_Entry> list = findByExpirationAndCompany(neverExpired,
				companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where neverExpired = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param neverExpired the never expired
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] findByExpirationAndCompany_PrevAndNext(long entryId,
		boolean neverExpired, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = getByExpirationAndCompany_PrevAndNext(session,
					vbpq_Entry, neverExpired, companyId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = getByExpirationAndCompany_PrevAndNext(session,
					vbpq_Entry, neverExpired, companyId, orderByComparator,
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

	protected VBPQ_Entry getByExpirationAndCompany_PrevAndNext(
		Session session, VBPQ_Entry vbpq_Entry, boolean neverExpired,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_EXPIRATIONANDCOMPANY_NEVEREXPIRED_2);

		query.append(_FINDER_COLUMN_EXPIRATIONANDCOMPANY_COMPANYID_2);

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
			query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(neverExpired);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries where neverExpired = &#63; and groupId = &#63;.
	 *
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @return the matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByExpirationAndGroup(boolean neverExpired,
		long groupId) throws SystemException {
		return findByExpirationAndGroup(neverExpired, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries where neverExpired = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByExpirationAndGroup(boolean neverExpired,
		long groupId, int start, int end) throws SystemException {
		return findByExpirationAndGroup(neverExpired, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries where neverExpired = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByExpirationAndGroup(boolean neverExpired,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIRATIONANDGROUP;
			finderArgs = new Object[] { neverExpired, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EXPIRATIONANDGROUP;
			finderArgs = new Object[] {
					neverExpired, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VBPQ_Entry> list = (List<VBPQ_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Entry vbpq_Entry : list) {
				if ((neverExpired != vbpq_Entry.getNeverExpired()) ||
						(groupId != vbpq_Entry.getGroupId())) {
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

			query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_EXPIRATIONANDGROUP_NEVEREXPIRED_2);

			query.append(_FINDER_COLUMN_EXPIRATIONANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(neverExpired);

				qPos.add(groupId);

				list = (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first v b p q_ entry in the ordered set where neverExpired = &#63; and groupId = &#63;.
	 *
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByExpirationAndGroup_First(boolean neverExpired,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByExpirationAndGroup_First(neverExpired,
				groupId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("neverExpired=");
		msg.append(neverExpired);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ entry in the ordered set where neverExpired = &#63; and groupId = &#63;.
	 *
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByExpirationAndGroup_First(boolean neverExpired,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VBPQ_Entry> list = findByExpirationAndGroup(neverExpired, groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where neverExpired = &#63; and groupId = &#63;.
	 *
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByExpirationAndGroup_Last(boolean neverExpired,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByExpirationAndGroup_Last(neverExpired,
				groupId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("neverExpired=");
		msg.append(neverExpired);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where neverExpired = &#63; and groupId = &#63;.
	 *
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByExpirationAndGroup_Last(boolean neverExpired,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByExpirationAndGroup(neverExpired, groupId);

		List<VBPQ_Entry> list = findByExpirationAndGroup(neverExpired, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where neverExpired = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] findByExpirationAndGroup_PrevAndNext(long entryId,
		boolean neverExpired, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = getByExpirationAndGroup_PrevAndNext(session, vbpq_Entry,
					neverExpired, groupId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = getByExpirationAndGroup_PrevAndNext(session, vbpq_Entry,
					neverExpired, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Entry getByExpirationAndGroup_PrevAndNext(Session session,
		VBPQ_Entry vbpq_Entry, boolean neverExpired, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_EXPIRATIONANDGROUP_NEVEREXPIRED_2);

		query.append(_FINDER_COLUMN_EXPIRATIONANDGROUP_GROUPID_2);

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
			query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(neverExpired);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries that the user has permission to view where neverExpired = &#63; and groupId = &#63;.
	 *
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @return the matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByExpirationAndGroup(
		boolean neverExpired, long groupId) throws SystemException {
		return filterFindByExpirationAndGroup(neverExpired, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries that the user has permission to view where neverExpired = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByExpirationAndGroup(
		boolean neverExpired, long groupId, int start, int end)
		throws SystemException {
		return filterFindByExpirationAndGroup(neverExpired, groupId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries that the user has permissions to view where neverExpired = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByExpirationAndGroup(
		boolean neverExpired, long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByExpirationAndGroup(neverExpired, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_EXPIRATIONANDGROUP_NEVEREXPIRED_2);

		query.append(_FINDER_COLUMN_EXPIRATIONANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_EntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_EntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(neverExpired);

			qPos.add(groupId);

			return (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set of v b p q_ entries that the user has permission to view where neverExpired = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] filterFindByExpirationAndGroup_PrevAndNext(
		long entryId, boolean neverExpired, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByExpirationAndGroup_PrevAndNext(entryId, neverExpired,
				groupId, orderByComparator);
		}

		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = filterGetByExpirationAndGroup_PrevAndNext(session,
					vbpq_Entry, neverExpired, groupId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = filterGetByExpirationAndGroup_PrevAndNext(session,
					vbpq_Entry, neverExpired, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Entry filterGetByExpirationAndGroup_PrevAndNext(
		Session session, VBPQ_Entry vbpq_Entry, boolean neverExpired,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_EXPIRATIONANDGROUP_NEVEREXPIRED_2);

		query.append(_FINDER_COLUMN_EXPIRATIONANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_EntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_EntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(neverExpired);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries where active = &#63; and companyId = &#63;.
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @return the matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByStatusAndCompany(boolean active,
		long companyId) throws SystemException {
		return findByStatusAndCompany(active, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries where active = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByStatusAndCompany(boolean active,
		long companyId, int start, int end) throws SystemException {
		return findByStatusAndCompany(active, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries where active = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByStatusAndCompany(boolean active,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY;
			finderArgs = new Object[] { active, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDCOMPANY;
			finderArgs = new Object[] {
					active, companyId,
					
					start, end, orderByComparator
				};
		}

		List<VBPQ_Entry> list = (List<VBPQ_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Entry vbpq_Entry : list) {
				if ((active != vbpq_Entry.getActive()) ||
						(companyId != vbpq_Entry.getCompanyId())) {
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

			query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_ACTIVE_2);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(companyId);

				list = (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first v b p q_ entry in the ordered set where active = &#63; and companyId = &#63;.
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByStatusAndCompany_First(boolean active,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByStatusAndCompany_First(active,
				companyId, orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ entry in the ordered set where active = &#63; and companyId = &#63;.
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByStatusAndCompany_First(boolean active,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VBPQ_Entry> list = findByStatusAndCompany(active, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where active = &#63; and companyId = &#63;.
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByStatusAndCompany_Last(boolean active,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByStatusAndCompany_Last(active, companyId,
				orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where active = &#63; and companyId = &#63;.
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByStatusAndCompany_Last(boolean active,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStatusAndCompany(active, companyId);

		List<VBPQ_Entry> list = findByStatusAndCompany(active, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where active = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param active the active
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] findByStatusAndCompany_PrevAndNext(long entryId,
		boolean active, long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = getByStatusAndCompany_PrevAndNext(session, vbpq_Entry,
					active, companyId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = getByStatusAndCompany_PrevAndNext(session, vbpq_Entry,
					active, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Entry getByStatusAndCompany_PrevAndNext(Session session,
		VBPQ_Entry vbpq_Entry, boolean active, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDCOMPANY_ACTIVE_2);

		query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

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
			query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @return the matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByStatusAndGroup(boolean active, long groupId)
		throws SystemException {
		return findByStatusAndGroup(active, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries where active = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByStatusAndGroup(boolean active, long groupId,
		int start, int end) throws SystemException {
		return findByStatusAndGroup(active, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries where active = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findByStatusAndGroup(boolean active, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP;
			finderArgs = new Object[] { active, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDGROUP;
			finderArgs = new Object[] {
					active, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VBPQ_Entry> list = (List<VBPQ_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Entry vbpq_Entry : list) {
				if ((active != vbpq_Entry.getActive()) ||
						(groupId != vbpq_Entry.getGroupId())) {
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

			query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_ACTIVE_2);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(groupId);

				list = (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first v b p q_ entry in the ordered set where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByStatusAndGroup_First(boolean active, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByStatusAndGroup_First(active, groupId,
				orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ entry in the ordered set where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByStatusAndGroup_First(boolean active, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VBPQ_Entry> list = findByStatusAndGroup(active, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry findByStatusAndGroup_Last(boolean active, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = fetchByStatusAndGroup_Last(active, groupId,
				orderByComparator);

		if (vbpq_Entry != null) {
			return vbpq_Entry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_EntryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ entry in the ordered set where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry fetchByStatusAndGroup_Last(boolean active, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatusAndGroup(active, groupId);

		List<VBPQ_Entry> list = findByStatusAndGroup(active, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where active = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param active the active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] findByStatusAndGroup_PrevAndNext(long entryId,
		boolean active, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = getByStatusAndGroup_PrevAndNext(session, vbpq_Entry,
					active, groupId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = getByStatusAndGroup_PrevAndNext(session, vbpq_Entry,
					active, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Entry getByStatusAndGroup_PrevAndNext(Session session,
		VBPQ_Entry vbpq_Entry, boolean active, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_ACTIVE_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

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
			query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries that the user has permission to view where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @return the matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByStatusAndGroup(boolean active,
		long groupId) throws SystemException {
		return filterFindByStatusAndGroup(active, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries that the user has permission to view where active = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByStatusAndGroup(boolean active,
		long groupId, int start, int end) throws SystemException {
		return filterFindByStatusAndGroup(active, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries that the user has permissions to view where active = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> filterFindByStatusAndGroup(boolean active,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByStatusAndGroup(active, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSANDGROUP_ACTIVE_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_EntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_EntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(active);

			qPos.add(groupId);

			return (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set of v b p q_ entries that the user has permission to view where active = &#63; and groupId = &#63;.
	 *
	 * @param entryId the primary key of the current v b p q_ entry
	 * @param active the active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ entry
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Entry[] filterFindByStatusAndGroup_PrevAndNext(long entryId,
		boolean active, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_EntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByStatusAndGroup_PrevAndNext(entryId, active, groupId,
				orderByComparator);
		}

		VBPQ_Entry vbpq_Entry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Entry[] array = new VBPQ_EntryImpl[3];

			array[0] = filterGetByStatusAndGroup_PrevAndNext(session,
					vbpq_Entry, active, groupId, orderByComparator, true);

			array[1] = vbpq_Entry;

			array[2] = filterGetByStatusAndGroup_PrevAndNext(session,
					vbpq_Entry, active, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Entry filterGetByStatusAndGroup_PrevAndNext(
		Session session, VBPQ_Entry vbpq_Entry, boolean active, long groupId,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSANDGROUP_ACTIVE_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_EntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_EntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_EntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Entry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Entry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ entries.
	 *
	 * @return the v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @return the range of v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of v b p q_ entries
	 * @param end the upper bound of the range of v b p q_ entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Entry> findAll(int start, int end,
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

		List<VBPQ_Entry> list = (List<VBPQ_Entry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VBPQ_ENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VBPQ_ENTRY.concat(VBPQ_EntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VBPQ_Entry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the v b p q_ entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (VBPQ_Entry vbpq_Entry : findByCompany(companyId)) {
			remove(vbpq_Entry);
		}
	}

	/**
	 * Removes all the v b p q_ entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (VBPQ_Entry vbpq_Entry : findByGroup(groupId)) {
			remove(vbpq_Entry);
		}
	}

	/**
	 * Removes all the v b p q_ entries where departmentId = &#63; and companyId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDepartmentAndCompany(long departmentId, long companyId)
		throws SystemException {
		for (VBPQ_Entry vbpq_Entry : findByDepartmentAndCompany(departmentId,
				companyId)) {
			remove(vbpq_Entry);
		}
	}

	/**
	 * Removes all the v b p q_ entries where departmentId = &#63; and groupId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDepartmentAndGroup(long departmentId, long groupId)
		throws SystemException {
		for (VBPQ_Entry vbpq_Entry : findByDepartmentAndGroup(departmentId,
				groupId)) {
			remove(vbpq_Entry);
		}
	}

	/**
	 * Removes all the v b p q_ entries where categoryId = &#63; and companyId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryAndCompany(long categoryId, long companyId)
		throws SystemException {
		for (VBPQ_Entry vbpq_Entry : findByCategoryAndCompany(categoryId,
				companyId)) {
			remove(vbpq_Entry);
		}
	}

	/**
	 * Removes all the v b p q_ entries where categoryId = &#63; and groupId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryAndGroup(long categoryId, long groupId)
		throws SystemException {
		for (VBPQ_Entry vbpq_Entry : findByCategoryAndGroup(categoryId, groupId)) {
			remove(vbpq_Entry);
		}
	}

	/**
	 * Removes all the v b p q_ entries where docTypeId = &#63; and companyId = &#63; from the database.
	 *
	 * @param docTypeId the doc type ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDocTypeAndCompany(long docTypeId, long companyId)
		throws SystemException {
		for (VBPQ_Entry vbpq_Entry : findByDocTypeAndCompany(docTypeId,
				companyId)) {
			remove(vbpq_Entry);
		}
	}

	/**
	 * Removes all the v b p q_ entries where docTypeId = &#63; and groupId = &#63; from the database.
	 *
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDocTypeAndGroup(long docTypeId, long groupId)
		throws SystemException {
		for (VBPQ_Entry vbpq_Entry : findByDocTypeAndGroup(docTypeId, groupId)) {
			remove(vbpq_Entry);
		}
	}

	/**
	 * Removes all the v b p q_ entries where neverExpired = &#63; and companyId = &#63; from the database.
	 *
	 * @param neverExpired the never expired
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByExpirationAndCompany(boolean neverExpired,
		long companyId) throws SystemException {
		for (VBPQ_Entry vbpq_Entry : findByExpirationAndCompany(neverExpired,
				companyId)) {
			remove(vbpq_Entry);
		}
	}

	/**
	 * Removes all the v b p q_ entries where neverExpired = &#63; and groupId = &#63; from the database.
	 *
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByExpirationAndGroup(boolean neverExpired, long groupId)
		throws SystemException {
		for (VBPQ_Entry vbpq_Entry : findByExpirationAndGroup(neverExpired,
				groupId)) {
			remove(vbpq_Entry);
		}
	}

	/**
	 * Removes all the v b p q_ entries where active = &#63; and companyId = &#63; from the database.
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusAndCompany(boolean active, long companyId)
		throws SystemException {
		for (VBPQ_Entry vbpq_Entry : findByStatusAndCompany(active, companyId)) {
			remove(vbpq_Entry);
		}
	}

	/**
	 * Removes all the v b p q_ entries where active = &#63; and groupId = &#63; from the database.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusAndGroup(boolean active, long groupId)
		throws SystemException {
		for (VBPQ_Entry vbpq_Entry : findByStatusAndGroup(active, groupId)) {
			remove(vbpq_Entry);
		}
	}

	/**
	 * Removes all the v b p q_ entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VBPQ_Entry vbpq_Entry : findAll()) {
			remove(vbpq_Entry);
		}
	}

	/**
	 * Returns the number of v b p q_ entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VBPQ_ENTRY_WHERE);

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
	 * Returns the number of v b p q_ entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VBPQ_ENTRY_WHERE);

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
	 * Returns the number of v b p q_ entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_VBPQ_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
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
	 * Returns the number of v b p q_ entries where departmentId = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param companyId the company ID
	 * @return the number of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDepartmentAndCompany(long departmentId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { departmentId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_ENTRY_WHERE);

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
	 * Returns the number of v b p q_ entries where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDepartmentAndGroup(long departmentId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { departmentId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_ENTRY_WHERE);

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
	 * Returns the number of v b p q_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByDepartmentAndGroup(long departmentId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByDepartmentAndGroup(departmentId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_VBPQ_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
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
	 * Returns the number of v b p q_ entries where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @return the number of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryAndCompany(long categoryId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { categoryId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_ENTRY_WHERE);

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
	 * Returns the number of v b p q_ entries where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryAndGroup(long categoryId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { categoryId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_ENTRY_WHERE);

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
	 * Returns the number of v b p q_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByCategoryAndGroup(long categoryId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCategoryAndGroup(categoryId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_VBPQ_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
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
	 * Returns the number of v b p q_ entries where docTypeId = &#63; and companyId = &#63;.
	 *
	 * @param docTypeId the doc type ID
	 * @param companyId the company ID
	 * @return the number of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDocTypeAndCompany(long docTypeId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { docTypeId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DOCTYPEANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_DOCTYPEANDCOMPANY_DOCTYPEID_2);

			query.append(_FINDER_COLUMN_DOCTYPEANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(docTypeId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DOCTYPEANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v b p q_ entries where docTypeId = &#63; and groupId = &#63;.
	 *
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDocTypeAndGroup(long docTypeId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { docTypeId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DOCTYPEANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_DOCTYPEANDGROUP_DOCTYPEID_2);

			query.append(_FINDER_COLUMN_DOCTYPEANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(docTypeId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DOCTYPEANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v b p q_ entries that the user has permission to view where docTypeId = &#63; and groupId = &#63;.
	 *
	 * @param docTypeId the doc type ID
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByDocTypeAndGroup(long docTypeId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByDocTypeAndGroup(docTypeId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_VBPQ_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_DOCTYPEANDGROUP_DOCTYPEID_2);

		query.append(_FINDER_COLUMN_DOCTYPEANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(docTypeId);

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
	 * Returns the number of v b p q_ entries where neverExpired = &#63; and companyId = &#63;.
	 *
	 * @param neverExpired the never expired
	 * @param companyId the company ID
	 * @return the number of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByExpirationAndCompany(boolean neverExpired, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { neverExpired, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EXPIRATIONANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_EXPIRATIONANDCOMPANY_NEVEREXPIRED_2);

			query.append(_FINDER_COLUMN_EXPIRATIONANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(neverExpired);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EXPIRATIONANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v b p q_ entries where neverExpired = &#63; and groupId = &#63;.
	 *
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByExpirationAndGroup(boolean neverExpired, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { neverExpired, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EXPIRATIONANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_EXPIRATIONANDGROUP_NEVEREXPIRED_2);

			query.append(_FINDER_COLUMN_EXPIRATIONANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(neverExpired);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EXPIRATIONANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v b p q_ entries that the user has permission to view where neverExpired = &#63; and groupId = &#63;.
	 *
	 * @param neverExpired the never expired
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByExpirationAndGroup(boolean neverExpired,
		long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByExpirationAndGroup(neverExpired, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_VBPQ_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_EXPIRATIONANDGROUP_NEVEREXPIRED_2);

		query.append(_FINDER_COLUMN_EXPIRATIONANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(neverExpired);

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
	 * Returns the number of v b p q_ entries where active = &#63; and companyId = &#63;.
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @return the number of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusAndCompany(boolean active, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { active, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_ACTIVE_2);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v b p q_ entries where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusAndGroup(boolean active, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { active, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_ENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_ACTIVE_2);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v b p q_ entries that the user has permission to view where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByStatusAndGroup(boolean active, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByStatusAndGroup(active, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_VBPQ_ENTRY_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_ACTIVE_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Entry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(active);

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
	 * Returns the number of v b p q_ entries.
	 *
	 * @return the number of v b p q_ entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VBPQ_ENTRY);

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
	 * Initializes the v b p q_ entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.vbpq.model.VBPQ_Entry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VBPQ_Entry>> listenersList = new ArrayList<ModelListener<VBPQ_Entry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VBPQ_Entry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VBPQ_EntryImpl.class.getName());
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
	private static final String _SQL_SELECT_VBPQ_ENTRY = "SELECT vbpq_Entry FROM VBPQ_Entry vbpq_Entry";
	private static final String _SQL_SELECT_VBPQ_ENTRY_WHERE = "SELECT vbpq_Entry FROM VBPQ_Entry vbpq_Entry WHERE ";
	private static final String _SQL_COUNT_VBPQ_ENTRY = "SELECT COUNT(vbpq_Entry) FROM VBPQ_Entry vbpq_Entry";
	private static final String _SQL_COUNT_VBPQ_ENTRY_WHERE = "SELECT COUNT(vbpq_Entry) FROM VBPQ_Entry vbpq_Entry WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "vbpq_Entry.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "vbpq_Entry.groupId = ?";
	private static final String _FINDER_COLUMN_DEPARTMENTANDCOMPANY_DEPARTMENTID_2 =
		"vbpq_Entry.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_DEPARTMENTANDCOMPANY_COMPANYID_2 = "vbpq_Entry.companyId = ?";
	private static final String _FINDER_COLUMN_DEPARTMENTANDGROUP_DEPARTMENTID_2 =
		"vbpq_Entry.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_DEPARTMENTANDGROUP_GROUPID_2 = "vbpq_Entry.groupId = ?";
	private static final String _FINDER_COLUMN_CATEGORYANDCOMPANY_CATEGORYID_2 = "vbpq_Entry.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDCOMPANY_COMPANYID_2 = "vbpq_Entry.companyId = ?";
	private static final String _FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2 = "vbpq_Entry.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2 = "vbpq_Entry.groupId = ?";
	private static final String _FINDER_COLUMN_DOCTYPEANDCOMPANY_DOCTYPEID_2 = "vbpq_Entry.docTypeId = ? AND ";
	private static final String _FINDER_COLUMN_DOCTYPEANDCOMPANY_COMPANYID_2 = "vbpq_Entry.companyId = ?";
	private static final String _FINDER_COLUMN_DOCTYPEANDGROUP_DOCTYPEID_2 = "vbpq_Entry.docTypeId = ? AND ";
	private static final String _FINDER_COLUMN_DOCTYPEANDGROUP_GROUPID_2 = "vbpq_Entry.groupId = ?";
	private static final String _FINDER_COLUMN_EXPIRATIONANDCOMPANY_NEVEREXPIRED_2 =
		"vbpq_Entry.neverExpired = ? AND ";
	private static final String _FINDER_COLUMN_EXPIRATIONANDCOMPANY_COMPANYID_2 = "vbpq_Entry.companyId = ?";
	private static final String _FINDER_COLUMN_EXPIRATIONANDGROUP_NEVEREXPIRED_2 =
		"vbpq_Entry.neverExpired = ? AND ";
	private static final String _FINDER_COLUMN_EXPIRATIONANDGROUP_GROUPID_2 = "vbpq_Entry.groupId = ?";
	private static final String _FINDER_COLUMN_STATUSANDCOMPANY_ACTIVE_2 = "vbpq_Entry.active = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2 = "vbpq_Entry.companyId = ?";
	private static final String _FINDER_COLUMN_STATUSANDGROUP_ACTIVE_2 = "vbpq_Entry.active = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDGROUP_GROUPID_2 = "vbpq_Entry.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "vbpq_Entry.entryId";
	private static final String _FILTER_SQL_SELECT_VBPQ_ENTRY_WHERE = "SELECT DISTINCT {vbpq_Entry.*} FROM vbpq_entry vbpq_Entry WHERE ";
	private static final String _FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {vbpq_entry.*} FROM (SELECT DISTINCT vbpq_Entry.entryId FROM vbpq_entry vbpq_Entry WHERE ";
	private static final String _FILTER_SQL_SELECT_VBPQ_ENTRY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN vbpq_entry ON TEMP_TABLE.entryId = vbpq_entry.entryId";
	private static final String _FILTER_SQL_COUNT_VBPQ_ENTRY_WHERE = "SELECT COUNT(DISTINCT vbpq_Entry.entryId) AS COUNT_VALUE FROM vbpq_entry vbpq_Entry WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "vbpq_Entry";
	private static final String _FILTER_ENTITY_TABLE = "vbpq_entry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vbpq_Entry.";
	private static final String _ORDER_BY_ENTITY_TABLE = "vbpq_entry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VBPQ_Entry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VBPQ_Entry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VBPQ_EntryPersistenceImpl.class);
	private static VBPQ_Entry _nullVBPQ_Entry = new VBPQ_EntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VBPQ_Entry> toCacheModel() {
				return _nullVBPQ_EntryCacheModel;
			}
		};

	private static CacheModel<VBPQ_Entry> _nullVBPQ_EntryCacheModel = new CacheModel<VBPQ_Entry>() {
			public VBPQ_Entry toEntityModel() {
				return _nullVBPQ_Entry;
			}
		};
}