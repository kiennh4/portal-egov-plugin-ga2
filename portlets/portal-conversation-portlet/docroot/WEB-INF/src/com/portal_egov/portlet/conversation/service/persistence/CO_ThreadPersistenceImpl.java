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

package com.portal_egov.portlet.conversation.service.persistence;

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

import com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;
import com.portal_egov.portlet.conversation.model.CO_Thread;
import com.portal_egov.portlet.conversation.model.impl.CO_ThreadImpl;
import com.portal_egov.portlet.conversation.model.impl.CO_ThreadModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the c o_ thread service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see CO_ThreadPersistence
 * @see CO_ThreadUtil
 * @generated
 */
public class CO_ThreadPersistenceImpl extends BasePersistenceImpl<CO_Thread>
	implements CO_ThreadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CO_ThreadUtil} to access the c o_ thread persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CO_ThreadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			CO_ThreadModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			CO_ThreadModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDCOMPANY =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusAndCompany",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatusAndCompany",
			new String[] { Integer.class.getName(), Long.class.getName() },
			CO_ThreadModelImpl.STATUS_COLUMN_BITMASK |
			CO_ThreadModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDCOMPANY = new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusAndCompany",
			new String[] { Integer.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDGROUP =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusAndGroup",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusAndGroup",
			new String[] { Integer.class.getName(), Long.class.getName() },
			CO_ThreadModelImpl.STATUS_COLUMN_BITMASK |
			CO_ThreadModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDGROUP = new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusAndGroup",
			new String[] { Integer.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTHREADANDCOMPANY =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentThreadAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDCOMPANY =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentThreadAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			CO_ThreadModelImpl.PARENTTHREADID_COLUMN_BITMASK |
			CO_ThreadModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTTHREADANDCOMPANY = new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentThreadAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTHREADANDGROUP =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentThreadAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDGROUP =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentThreadAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			CO_ThreadModelImpl.PARENTTHREADID_COLUMN_BITMASK |
			CO_ThreadModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTTHREADANDGROUP = new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentThreadAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTHREADANDCOMPANYANDSTATUS =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentThreadAndCompanyAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDCOMPANYANDSTATUS =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentThreadAndCompanyAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			CO_ThreadModelImpl.PARENTTHREADID_COLUMN_BITMASK |
			CO_ThreadModelImpl.COMPANYID_COLUMN_BITMASK |
			CO_ThreadModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTTHREADANDCOMPANYANDSTATUS =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentThreadAndCompanyAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTHREADANDGROUPANDSTATUS =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentThreadAndGroupAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDGROUPANDSTATUS =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentThreadAndGroupAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			CO_ThreadModelImpl.PARENTTHREADID_COLUMN_BITMASK |
			CO_ThreadModelImpl.GROUPID_COLUMN_BITMASK |
			CO_ThreadModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTTHREADANDGROUPANDSTATUS =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentThreadAndGroupAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDCOMPANY =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			CO_ThreadModelImpl.CATEGORYID_COLUMN_BITMASK |
			CO_ThreadModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY = new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDGROUP =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			CO_ThreadModelImpl.CATEGORYID_COLUMN_BITMASK |
			CO_ThreadModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDGROUP = new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDCOMPANYANDSTATUS =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategoryAndCompanyAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANYANDSTATUS =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndCompanyAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			CO_ThreadModelImpl.CATEGORYID_COLUMN_BITMASK |
			CO_ThreadModelImpl.COMPANYID_COLUMN_BITMASK |
			CO_ThreadModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANYANDSTATUS =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndCompanyAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDGROUPANDSTATUS =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategoryAndGroupAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUPANDSTATUS =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndGroupAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			CO_ThreadModelImpl.CATEGORYID_COLUMN_BITMASK |
			CO_ThreadModelImpl.GROUPID_COLUMN_BITMASK |
			CO_ThreadModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDGROUPANDSTATUS =
		new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndGroupAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, CO_ThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the c o_ thread in the entity cache if it is enabled.
	 *
	 * @param co_Thread the c o_ thread
	 */
	public void cacheResult(CO_Thread co_Thread) {
		EntityCacheUtil.putResult(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadImpl.class, co_Thread.getPrimaryKey(), co_Thread);

		co_Thread.resetOriginalValues();
	}

	/**
	 * Caches the c o_ threads in the entity cache if it is enabled.
	 *
	 * @param co_Threads the c o_ threads
	 */
	public void cacheResult(List<CO_Thread> co_Threads) {
		for (CO_Thread co_Thread : co_Threads) {
			if (EntityCacheUtil.getResult(
						CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
						CO_ThreadImpl.class, co_Thread.getPrimaryKey()) == null) {
				cacheResult(co_Thread);
			}
			else {
				co_Thread.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all c o_ threads.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CO_ThreadImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CO_ThreadImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the c o_ thread.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CO_Thread co_Thread) {
		EntityCacheUtil.removeResult(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadImpl.class, co_Thread.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CO_Thread> co_Threads) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CO_Thread co_Thread : co_Threads) {
			EntityCacheUtil.removeResult(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
				CO_ThreadImpl.class, co_Thread.getPrimaryKey());
		}
	}

	/**
	 * Creates a new c o_ thread with the primary key. Does not add the c o_ thread to the database.
	 *
	 * @param threadId the primary key for the new c o_ thread
	 * @return the new c o_ thread
	 */
	public CO_Thread create(long threadId) {
		CO_Thread co_Thread = new CO_ThreadImpl();

		co_Thread.setNew(true);
		co_Thread.setPrimaryKey(threadId);

		return co_Thread;
	}

	/**
	 * Removes the c o_ thread with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param threadId the primary key of the c o_ thread
	 * @return the c o_ thread that was removed
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread remove(long threadId)
		throws NoSuchCO_ThreadException, SystemException {
		return remove(Long.valueOf(threadId));
	}

	/**
	 * Removes the c o_ thread with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the c o_ thread
	 * @return the c o_ thread that was removed
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CO_Thread remove(Serializable primaryKey)
		throws NoSuchCO_ThreadException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CO_Thread co_Thread = (CO_Thread)session.get(CO_ThreadImpl.class,
					primaryKey);

			if (co_Thread == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCO_ThreadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(co_Thread);
		}
		catch (NoSuchCO_ThreadException nsee) {
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
	protected CO_Thread removeImpl(CO_Thread co_Thread)
		throws SystemException {
		co_Thread = toUnwrappedModel(co_Thread);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, co_Thread);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(co_Thread);

		return co_Thread;
	}

	@Override
	public CO_Thread updateImpl(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread,
		boolean merge) throws SystemException {
		co_Thread = toUnwrappedModel(co_Thread);

		boolean isNew = co_Thread.isNew();

		CO_ThreadModelImpl co_ThreadModelImpl = (CO_ThreadModelImpl)co_Thread;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, co_Thread, merge);

			co_Thread.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CO_ThreadModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((co_ThreadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((co_ThreadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((co_ThreadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(co_ThreadModelImpl.getOriginalStatus()),
						Long.valueOf(co_ThreadModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY,
					args);

				args = new Object[] {
						Integer.valueOf(co_ThreadModelImpl.getStatus()),
						Long.valueOf(co_ThreadModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY,
					args);
			}

			if ((co_ThreadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(co_ThreadModelImpl.getOriginalStatus()),
						Long.valueOf(co_ThreadModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP,
					args);

				args = new Object[] {
						Integer.valueOf(co_ThreadModelImpl.getStatus()),
						Long.valueOf(co_ThreadModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP,
					args);
			}

			if ((co_ThreadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getOriginalParentThreadId()),
						Long.valueOf(co_ThreadModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getParentThreadId()),
						Long.valueOf(co_ThreadModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDCOMPANY,
					args);
			}

			if ((co_ThreadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getOriginalParentThreadId()),
						Long.valueOf(co_ThreadModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getParentThreadId()),
						Long.valueOf(co_ThreadModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDGROUP,
					args);
			}

			if ((co_ThreadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDCOMPANYANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getOriginalParentThreadId()),
						Long.valueOf(co_ThreadModelImpl.getOriginalCompanyId()),
						Integer.valueOf(co_ThreadModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDCOMPANYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDCOMPANYANDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getParentThreadId()),
						Long.valueOf(co_ThreadModelImpl.getCompanyId()),
						Integer.valueOf(co_ThreadModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDCOMPANYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDCOMPANYANDSTATUS,
					args);
			}

			if ((co_ThreadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDGROUPANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getOriginalParentThreadId()),
						Long.valueOf(co_ThreadModelImpl.getOriginalGroupId()),
						Integer.valueOf(co_ThreadModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDGROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDGROUPANDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getParentThreadId()),
						Long.valueOf(co_ThreadModelImpl.getGroupId()),
						Integer.valueOf(co_ThreadModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDGROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDGROUPANDSTATUS,
					args);
			}

			if ((co_ThreadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getOriginalCategoryId()),
						Long.valueOf(co_ThreadModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getCategoryId()),
						Long.valueOf(co_ThreadModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY,
					args);
			}

			if ((co_ThreadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getOriginalCategoryId()),
						Long.valueOf(co_ThreadModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getCategoryId()),
						Long.valueOf(co_ThreadModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP,
					args);
			}

			if ((co_ThreadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANYANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getOriginalCategoryId()),
						Long.valueOf(co_ThreadModelImpl.getOriginalCompanyId()),
						Integer.valueOf(co_ThreadModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANYANDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getCategoryId()),
						Long.valueOf(co_ThreadModelImpl.getCompanyId()),
						Integer.valueOf(co_ThreadModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANYANDSTATUS,
					args);
			}

			if ((co_ThreadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUPANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getOriginalCategoryId()),
						Long.valueOf(co_ThreadModelImpl.getOriginalGroupId()),
						Integer.valueOf(co_ThreadModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUPANDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(co_ThreadModelImpl.getCategoryId()),
						Long.valueOf(co_ThreadModelImpl.getGroupId()),
						Integer.valueOf(co_ThreadModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUPANDSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
			CO_ThreadImpl.class, co_Thread.getPrimaryKey(), co_Thread);

		return co_Thread;
	}

	protected CO_Thread toUnwrappedModel(CO_Thread co_Thread) {
		if (co_Thread instanceof CO_ThreadImpl) {
			return co_Thread;
		}

		CO_ThreadImpl co_ThreadImpl = new CO_ThreadImpl();

		co_ThreadImpl.setNew(co_Thread.isNew());
		co_ThreadImpl.setPrimaryKey(co_Thread.getPrimaryKey());

		co_ThreadImpl.setThreadId(co_Thread.getThreadId());
		co_ThreadImpl.setCompanyId(co_Thread.getCompanyId());
		co_ThreadImpl.setGroupId(co_Thread.getGroupId());
		co_ThreadImpl.setUserId(co_Thread.getUserId());
		co_ThreadImpl.setParentThreadId(co_Thread.getParentThreadId());
		co_ThreadImpl.setCategoryId(co_Thread.getCategoryId());
		co_ThreadImpl.setThreadName(co_Thread.getThreadName());
		co_ThreadImpl.setDepartmentName(co_Thread.getDepartmentName());
		co_ThreadImpl.setParticipants(co_Thread.getParticipants());
		co_ThreadImpl.setThreadDesc(co_Thread.getThreadDesc());
		co_ThreadImpl.setStartDate(co_Thread.getStartDate());
		co_ThreadImpl.setEndDate(co_Thread.getEndDate());
		co_ThreadImpl.setCreateDate(co_Thread.getCreateDate());
		co_ThreadImpl.setModifiedDate(co_Thread.getModifiedDate());
		co_ThreadImpl.setViewCount(co_Thread.getViewCount());
		co_ThreadImpl.setConversationCount(co_Thread.getConversationCount());
		co_ThreadImpl.setStatus(co_Thread.getStatus());
		co_ThreadImpl.setStatusByUserId(co_Thread.getStatusByUserId());
		co_ThreadImpl.setStatusDate(co_Thread.getStatusDate());

		return co_ThreadImpl;
	}

	/**
	 * Returns the c o_ thread with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the c o_ thread
	 * @return the c o_ thread
	 * @throws com.liferay.portal.NoSuchModelException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CO_Thread findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the c o_ thread with the primary key or throws a {@link com.portal_egov.portlet.conversation.NoSuchCO_ThreadException} if it could not be found.
	 *
	 * @param threadId the primary key of the c o_ thread
	 * @return the c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByPrimaryKey(long threadId)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByPrimaryKey(threadId);

		if (co_Thread == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + threadId);
			}

			throw new NoSuchCO_ThreadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				threadId);
		}

		return co_Thread;
	}

	/**
	 * Returns the c o_ thread with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the c o_ thread
	 * @return the c o_ thread, or <code>null</code> if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CO_Thread fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the c o_ thread with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param threadId the primary key of the c o_ thread
	 * @return the c o_ thread, or <code>null</code> if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByPrimaryKey(long threadId) throws SystemException {
		CO_Thread co_Thread = (CO_Thread)EntityCacheUtil.getResult(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
				CO_ThreadImpl.class, threadId);

		if (co_Thread == _nullCO_Thread) {
			return null;
		}

		if (co_Thread == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				co_Thread = (CO_Thread)session.get(CO_ThreadImpl.class,
						Long.valueOf(threadId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (co_Thread != null) {
					cacheResult(co_Thread);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CO_ThreadModelImpl.ENTITY_CACHE_ENABLED,
						CO_ThreadImpl.class, threadId, _nullCO_Thread);
				}

				closeSession(session);
			}
		}

		return co_Thread;
	}

	/**
	 * Returns all the c o_ threads where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the c o_ threads where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCompany(long companyId, int start, int end,
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

		List<CO_Thread> list = (List<CO_Thread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Thread co_Thread : list) {
				if ((companyId != co_Thread.getCompanyId())) {
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

			query.append(_SQL_SELECT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<CO_Thread>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first c o_ thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByCompany_First(companyId, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the first c o_ thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CO_Thread> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByCompany_Last(companyId, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the last c o_ thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<CO_Thread> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set where companyId = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] findByCompany_PrevAndNext(long threadId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = getByCompany_PrevAndNext(session, co_Thread, companyId,
					orderByComparator, true);

			array[1] = co_Thread;

			array[2] = getByCompany_PrevAndNext(session, co_Thread, companyId,
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

	protected CO_Thread getByCompany_PrevAndNext(Session session,
		CO_Thread co_Thread, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_THREAD_WHERE);

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
			query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByGroup(long groupId, int start, int end,
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

		List<CO_Thread> list = (List<CO_Thread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Thread co_Thread : list) {
				if ((groupId != co_Thread.getGroupId())) {
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

			query.append(_SQL_SELECT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<CO_Thread>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first c o_ thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByGroup_First(groupId, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the first c o_ thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CO_Thread> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByGroup_Last(groupId, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the last c o_ thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<CO_Thread> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set where groupId = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] findByGroup_PrevAndNext(long threadId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = getByGroup_PrevAndNext(session, co_Thread, groupId,
					orderByComparator, true);

			array[1] = co_Thread;

			array[2] = getByGroup_PrevAndNext(session, co_Thread, groupId,
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

	protected CO_Thread getByGroup_PrevAndNext(Session session,
		CO_Thread co_Thread, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_THREAD_WHERE);

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
			query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the c o_ threads that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByGroup(long groupId, int start, int end,
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
			query.append(_FILTER_SQL_SELECT_CO_THREAD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CO_ThreadImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CO_ThreadImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<CO_Thread>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set of c o_ threads that the user has permission to view where groupId = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] filterFindByGroup_PrevAndNext(long threadId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(threadId, groupId, orderByComparator);
		}

		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, co_Thread,
					groupId, orderByComparator, true);

			array[1] = co_Thread;

			array[2] = filterGetByGroup_PrevAndNext(session, co_Thread,
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

	protected CO_Thread filterGetByGroup_PrevAndNext(Session session,
		CO_Thread co_Thread, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_CO_THREAD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CO_ThreadImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CO_ThreadImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @return the matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByStatusAndCompany(int status, long companyId)
		throws SystemException {
		return findByStatusAndCompany(status, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads where status = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByStatusAndCompany(int status, long companyId,
		int start, int end) throws SystemException {
		return findByStatusAndCompany(status, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads where status = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByStatusAndCompany(int status, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY;
			finderArgs = new Object[] { status, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDCOMPANY;
			finderArgs = new Object[] {
					status, companyId,
					
					start, end, orderByComparator
				};
		}

		List<CO_Thread> list = (List<CO_Thread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Thread co_Thread : list) {
				if ((status != co_Thread.getStatus()) ||
						(companyId != co_Thread.getCompanyId())) {
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

			query.append(_SQL_SELECT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_STATUS_2);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(companyId);

				list = (List<CO_Thread>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first c o_ thread in the ordered set where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByStatusAndCompany_First(int status, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByStatusAndCompany_First(status, companyId,
				orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the first c o_ thread in the ordered set where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByStatusAndCompany_First(int status, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CO_Thread> list = findByStatusAndCompany(status, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ thread in the ordered set where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByStatusAndCompany_Last(int status, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByStatusAndCompany_Last(status, companyId,
				orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the last c o_ thread in the ordered set where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByStatusAndCompany_Last(int status, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatusAndCompany(status, companyId);

		List<CO_Thread> list = findByStatusAndCompany(status, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set where status = &#63; and companyId = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param status the status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] findByStatusAndCompany_PrevAndNext(long threadId,
		int status, long companyId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = getByStatusAndCompany_PrevAndNext(session, co_Thread,
					status, companyId, orderByComparator, true);

			array[1] = co_Thread;

			array[2] = getByStatusAndCompany_PrevAndNext(session, co_Thread,
					status, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CO_Thread getByStatusAndCompany_PrevAndNext(Session session,
		CO_Thread co_Thread, int status, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_THREAD_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDCOMPANY_STATUS_2);

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
			query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByStatusAndGroup(int status, long groupId)
		throws SystemException {
		return findByStatusAndGroup(status, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByStatusAndGroup(int status, long groupId,
		int start, int end) throws SystemException {
		return findByStatusAndGroup(status, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByStatusAndGroup(int status, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP;
			finderArgs = new Object[] { status, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDGROUP;
			finderArgs = new Object[] {
					status, groupId,
					
					start, end, orderByComparator
				};
		}

		List<CO_Thread> list = (List<CO_Thread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Thread co_Thread : list) {
				if ((status != co_Thread.getStatus()) ||
						(groupId != co_Thread.getGroupId())) {
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

			query.append(_SQL_SELECT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(groupId);

				list = (List<CO_Thread>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first c o_ thread in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByStatusAndGroup_First(int status, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByStatusAndGroup_First(status, groupId,
				orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the first c o_ thread in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByStatusAndGroup_First(int status, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CO_Thread> list = findByStatusAndGroup(status, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ thread in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByStatusAndGroup_Last(int status, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByStatusAndGroup_Last(status, groupId,
				orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the last c o_ thread in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByStatusAndGroup_Last(int status, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatusAndGroup(status, groupId);

		List<CO_Thread> list = findByStatusAndGroup(status, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] findByStatusAndGroup_PrevAndNext(long threadId,
		int status, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = getByStatusAndGroup_PrevAndNext(session, co_Thread,
					status, groupId, orderByComparator, true);

			array[1] = co_Thread;

			array[2] = getByStatusAndGroup_PrevAndNext(session, co_Thread,
					status, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CO_Thread getByStatusAndGroup_PrevAndNext(Session session,
		CO_Thread co_Thread, int status, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_THREAD_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

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
			query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByStatusAndGroup(int status, long groupId)
		throws SystemException {
		return filterFindByStatusAndGroup(status, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByStatusAndGroup(int status, long groupId,
		int start, int end) throws SystemException {
		return filterFindByStatusAndGroup(status, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads that the user has permissions to view where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByStatusAndGroup(int status, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByStatusAndGroup(status, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_CO_THREAD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CO_ThreadImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CO_ThreadImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(status);

			qPos.add(groupId);

			return (List<CO_Thread>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set of c o_ threads that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] filterFindByStatusAndGroup_PrevAndNext(long threadId,
		int status, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByStatusAndGroup_PrevAndNext(threadId, status, groupId,
				orderByComparator);
		}

		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = filterGetByStatusAndGroup_PrevAndNext(session,
					co_Thread, status, groupId, orderByComparator, true);

			array[1] = co_Thread;

			array[2] = filterGetByStatusAndGroup_PrevAndNext(session,
					co_Thread, status, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CO_Thread filterGetByStatusAndGroup_PrevAndNext(Session session,
		CO_Thread co_Thread, int status, long groupId,
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
			query.append(_FILTER_SQL_SELECT_CO_THREAD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CO_ThreadImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CO_ThreadImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads where parentThreadId = &#63; and companyId = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @return the matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByParentThreadAndCompany(long parentThreadId,
		long companyId) throws SystemException {
		return findByParentThreadAndCompany(parentThreadId, companyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads where parentThreadId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByParentThreadAndCompany(long parentThreadId,
		long companyId, int start, int end) throws SystemException {
		return findByParentThreadAndCompany(parentThreadId, companyId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads where parentThreadId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByParentThreadAndCompany(long parentThreadId,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDCOMPANY;
			finderArgs = new Object[] { parentThreadId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTHREADANDCOMPANY;
			finderArgs = new Object[] {
					parentThreadId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<CO_Thread> list = (List<CO_Thread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Thread co_Thread : list) {
				if ((parentThreadId != co_Thread.getParentThreadId()) ||
						(companyId != co_Thread.getCompanyId())) {
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

			query.append(_SQL_SELECT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANY_PARENTTHREADID_2);

			query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentThreadId);

				qPos.add(companyId);

				list = (List<CO_Thread>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByParentThreadAndCompany_First(long parentThreadId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByParentThreadAndCompany_First(parentThreadId,
				companyId, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentThreadId=");
		msg.append(parentThreadId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByParentThreadAndCompany_First(long parentThreadId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CO_Thread> list = findByParentThreadAndCompany(parentThreadId,
				companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByParentThreadAndCompany_Last(long parentThreadId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByParentThreadAndCompany_Last(parentThreadId,
				companyId, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentThreadId=");
		msg.append(parentThreadId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByParentThreadAndCompany_Last(long parentThreadId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentThreadAndCompany(parentThreadId, companyId);

		List<CO_Thread> list = findByParentThreadAndCompany(parentThreadId,
				companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] findByParentThreadAndCompany_PrevAndNext(long threadId,
		long parentThreadId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = getByParentThreadAndCompany_PrevAndNext(session,
					co_Thread, parentThreadId, companyId, orderByComparator,
					true);

			array[1] = co_Thread;

			array[2] = getByParentThreadAndCompany_PrevAndNext(session,
					co_Thread, parentThreadId, companyId, orderByComparator,
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

	protected CO_Thread getByParentThreadAndCompany_PrevAndNext(
		Session session, CO_Thread co_Thread, long parentThreadId,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_THREAD_WHERE);

		query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANY_PARENTTHREADID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANY_COMPANYID_2);

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
			query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentThreadId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads where parentThreadId = &#63; and groupId = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @return the matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByParentThreadAndGroup(long parentThreadId,
		long groupId) throws SystemException {
		return findByParentThreadAndGroup(parentThreadId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads where parentThreadId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByParentThreadAndGroup(long parentThreadId,
		long groupId, int start, int end) throws SystemException {
		return findByParentThreadAndGroup(parentThreadId, groupId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads where parentThreadId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByParentThreadAndGroup(long parentThreadId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDGROUP;
			finderArgs = new Object[] { parentThreadId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTHREADANDGROUP;
			finderArgs = new Object[] {
					parentThreadId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<CO_Thread> list = (List<CO_Thread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Thread co_Thread : list) {
				if ((parentThreadId != co_Thread.getParentThreadId()) ||
						(groupId != co_Thread.getGroupId())) {
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

			query.append(_SQL_SELECT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_PARENTTHREADANDGROUP_PARENTTHREADID_2);

			query.append(_FINDER_COLUMN_PARENTTHREADANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentThreadId);

				qPos.add(groupId);

				list = (List<CO_Thread>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByParentThreadAndGroup_First(long parentThreadId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByParentThreadAndGroup_First(parentThreadId,
				groupId, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentThreadId=");
		msg.append(parentThreadId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByParentThreadAndGroup_First(long parentThreadId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CO_Thread> list = findByParentThreadAndGroup(parentThreadId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByParentThreadAndGroup_Last(long parentThreadId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByParentThreadAndGroup_Last(parentThreadId,
				groupId, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentThreadId=");
		msg.append(parentThreadId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByParentThreadAndGroup_Last(long parentThreadId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentThreadAndGroup(parentThreadId, groupId);

		List<CO_Thread> list = findByParentThreadAndGroup(parentThreadId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] findByParentThreadAndGroup_PrevAndNext(long threadId,
		long parentThreadId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = getByParentThreadAndGroup_PrevAndNext(session,
					co_Thread, parentThreadId, groupId, orderByComparator, true);

			array[1] = co_Thread;

			array[2] = getByParentThreadAndGroup_PrevAndNext(session,
					co_Thread, parentThreadId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CO_Thread getByParentThreadAndGroup_PrevAndNext(Session session,
		CO_Thread co_Thread, long parentThreadId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_THREAD_WHERE);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUP_PARENTTHREADID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUP_GROUPID_2);

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
			query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentThreadId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @return the matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByParentThreadAndGroup(
		long parentThreadId, long groupId) throws SystemException {
		return filterFindByParentThreadAndGroup(parentThreadId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByParentThreadAndGroup(
		long parentThreadId, long groupId, int start, int end)
		throws SystemException {
		return filterFindByParentThreadAndGroup(parentThreadId, groupId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads that the user has permissions to view where parentThreadId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByParentThreadAndGroup(
		long parentThreadId, long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParentThreadAndGroup(parentThreadId, groupId, start,
				end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_CO_THREAD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUP_PARENTTHREADID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CO_ThreadImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CO_ThreadImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(parentThreadId);

			qPos.add(groupId);

			return (List<CO_Thread>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set of c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] filterFindByParentThreadAndGroup_PrevAndNext(
		long threadId, long parentThreadId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParentThreadAndGroup_PrevAndNext(threadId,
				parentThreadId, groupId, orderByComparator);
		}

		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = filterGetByParentThreadAndGroup_PrevAndNext(session,
					co_Thread, parentThreadId, groupId, orderByComparator, true);

			array[1] = co_Thread;

			array[2] = filterGetByParentThreadAndGroup_PrevAndNext(session,
					co_Thread, parentThreadId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CO_Thread filterGetByParentThreadAndGroup_PrevAndNext(
		Session session, CO_Thread co_Thread, long parentThreadId,
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
			query.append(_FILTER_SQL_SELECT_CO_THREAD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUP_PARENTTHREADID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CO_ThreadImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CO_ThreadImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentThreadId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int status)
		throws SystemException {
		return findByParentThreadAndCompanyAndStatus(parentThreadId, companyId,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int status, int start, int end)
		throws SystemException {
		return findByParentThreadAndCompanyAndStatus(parentThreadId, companyId,
			status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDCOMPANYANDSTATUS;
			finderArgs = new Object[] { parentThreadId, companyId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTHREADANDCOMPANYANDSTATUS;
			finderArgs = new Object[] {
					parentThreadId, companyId, status,
					
					start, end, orderByComparator
				};
		}

		List<CO_Thread> list = (List<CO_Thread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Thread co_Thread : list) {
				if ((parentThreadId != co_Thread.getParentThreadId()) ||
						(companyId != co_Thread.getCompanyId()) ||
						(status != co_Thread.getStatus())) {
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

			query.append(_SQL_SELECT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANYANDSTATUS_PARENTTHREADID_2);

			query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANYANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANYANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentThreadId);

				qPos.add(companyId);

				qPos.add(status);

				list = (List<CO_Thread>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByParentThreadAndCompanyAndStatus_First(
		long parentThreadId, long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByParentThreadAndCompanyAndStatus_First(parentThreadId,
				companyId, status, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentThreadId=");
		msg.append(parentThreadId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByParentThreadAndCompanyAndStatus_First(
		long parentThreadId, long companyId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<CO_Thread> list = findByParentThreadAndCompanyAndStatus(parentThreadId,
				companyId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByParentThreadAndCompanyAndStatus_Last(
		long parentThreadId, long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByParentThreadAndCompanyAndStatus_Last(parentThreadId,
				companyId, status, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentThreadId=");
		msg.append(parentThreadId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByParentThreadAndCompanyAndStatus_Last(
		long parentThreadId, long companyId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParentThreadAndCompanyAndStatus(parentThreadId,
				companyId, status);

		List<CO_Thread> list = findByParentThreadAndCompanyAndStatus(parentThreadId,
				companyId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] findByParentThreadAndCompanyAndStatus_PrevAndNext(
		long threadId, long parentThreadId, long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = getByParentThreadAndCompanyAndStatus_PrevAndNext(session,
					co_Thread, parentThreadId, companyId, status,
					orderByComparator, true);

			array[1] = co_Thread;

			array[2] = getByParentThreadAndCompanyAndStatus_PrevAndNext(session,
					co_Thread, parentThreadId, companyId, status,
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

	protected CO_Thread getByParentThreadAndCompanyAndStatus_PrevAndNext(
		Session session, CO_Thread co_Thread, long parentThreadId,
		long companyId, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_THREAD_WHERE);

		query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANYANDSTATUS_PARENTTHREADID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANYANDSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANYANDSTATUS_STATUS_2);

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
			query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentThreadId);

		qPos.add(companyId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status)
		throws SystemException {
		return findByParentThreadAndGroupAndStatus(parentThreadId, groupId,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status, int start, int end)
		throws SystemException {
		return findByParentThreadAndGroupAndStatus(parentThreadId, groupId,
			status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTHREADANDGROUPANDSTATUS;
			finderArgs = new Object[] { parentThreadId, groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTHREADANDGROUPANDSTATUS;
			finderArgs = new Object[] {
					parentThreadId, groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<CO_Thread> list = (List<CO_Thread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Thread co_Thread : list) {
				if ((parentThreadId != co_Thread.getParentThreadId()) ||
						(groupId != co_Thread.getGroupId()) ||
						(status != co_Thread.getStatus())) {
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

			query.append(_SQL_SELECT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_PARENTTHREADID_2);

			query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentThreadId);

				qPos.add(groupId);

				qPos.add(status);

				list = (List<CO_Thread>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByParentThreadAndGroupAndStatus_First(
		long parentThreadId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByParentThreadAndGroupAndStatus_First(parentThreadId,
				groupId, status, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentThreadId=");
		msg.append(parentThreadId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByParentThreadAndGroupAndStatus_First(
		long parentThreadId, long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<CO_Thread> list = findByParentThreadAndGroupAndStatus(parentThreadId,
				groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByParentThreadAndGroupAndStatus_Last(
		long parentThreadId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByParentThreadAndGroupAndStatus_Last(parentThreadId,
				groupId, status, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentThreadId=");
		msg.append(parentThreadId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByParentThreadAndGroupAndStatus_Last(
		long parentThreadId, long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParentThreadAndGroupAndStatus(parentThreadId,
				groupId, status);

		List<CO_Thread> list = findByParentThreadAndGroupAndStatus(parentThreadId,
				groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] findByParentThreadAndGroupAndStatus_PrevAndNext(
		long threadId, long parentThreadId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = getByParentThreadAndGroupAndStatus_PrevAndNext(session,
					co_Thread, parentThreadId, groupId, status,
					orderByComparator, true);

			array[1] = co_Thread;

			array[2] = getByParentThreadAndGroupAndStatus_PrevAndNext(session,
					co_Thread, parentThreadId, groupId, status,
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

	protected CO_Thread getByParentThreadAndGroupAndStatus_PrevAndNext(
		Session session, CO_Thread co_Thread, long parentThreadId,
		long groupId, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_THREAD_WHERE);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_PARENTTHREADID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_STATUS_2);

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
			query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentThreadId);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status)
		throws SystemException {
		return filterFindByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status, int start, int end)
		throws SystemException {
		return filterFindByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads that the user has permissions to view where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParentThreadAndGroupAndStatus(parentThreadId, groupId,
				status, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_CO_THREAD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_PARENTTHREADID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CO_ThreadImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CO_ThreadImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(parentThreadId);

			qPos.add(groupId);

			qPos.add(status);

			return (List<CO_Thread>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set of c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] filterFindByParentThreadAndGroupAndStatus_PrevAndNext(
		long threadId, long parentThreadId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParentThreadAndGroupAndStatus_PrevAndNext(threadId,
				parentThreadId, groupId, status, orderByComparator);
		}

		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = filterGetByParentThreadAndGroupAndStatus_PrevAndNext(session,
					co_Thread, parentThreadId, groupId, status,
					orderByComparator, true);

			array[1] = co_Thread;

			array[2] = filterGetByParentThreadAndGroupAndStatus_PrevAndNext(session,
					co_Thread, parentThreadId, groupId, status,
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

	protected CO_Thread filterGetByParentThreadAndGroupAndStatus_PrevAndNext(
		Session session, CO_Thread co_Thread, long parentThreadId,
		long groupId, int status, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_CO_THREAD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_PARENTTHREADID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CO_ThreadImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CO_ThreadImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentThreadId);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @return the matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCategoryAndCompany(long categoryId,
		long companyId) throws SystemException {
		return findByCategoryAndCompany(categoryId, companyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads where categoryId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCategoryAndCompany(long categoryId,
		long companyId, int start, int end) throws SystemException {
		return findByCategoryAndCompany(categoryId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads where categoryId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCategoryAndCompany(long categoryId,
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

		List<CO_Thread> list = (List<CO_Thread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Thread co_Thread : list) {
				if ((categoryId != co_Thread.getCategoryId()) ||
						(companyId != co_Thread.getCompanyId())) {
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

			query.append(_SQL_SELECT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(companyId);

				list = (List<CO_Thread>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByCategoryAndCompany_First(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByCategoryAndCompany_First(categoryId,
				companyId, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the first c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByCategoryAndCompany_First(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CO_Thread> list = findByCategoryAndCompany(categoryId, companyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByCategoryAndCompany_Last(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByCategoryAndCompany_Last(categoryId,
				companyId, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the last c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByCategoryAndCompany_Last(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryAndCompany(categoryId, companyId);

		List<CO_Thread> list = findByCategoryAndCompany(categoryId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] findByCategoryAndCompany_PrevAndNext(long threadId,
		long categoryId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = getByCategoryAndCompany_PrevAndNext(session, co_Thread,
					categoryId, companyId, orderByComparator, true);

			array[1] = co_Thread;

			array[2] = getByCategoryAndCompany_PrevAndNext(session, co_Thread,
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

	protected CO_Thread getByCategoryAndCompany_PrevAndNext(Session session,
		CO_Thread co_Thread, long categoryId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_THREAD_WHERE);

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
			query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCategoryAndGroup(long categoryId, long groupId)
		throws SystemException {
		return findByCategoryAndGroup(categoryId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCategoryAndGroup(long categoryId,
		long groupId, int start, int end) throws SystemException {
		return findByCategoryAndGroup(categoryId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCategoryAndGroup(long categoryId,
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

		List<CO_Thread> list = (List<CO_Thread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Thread co_Thread : list) {
				if ((categoryId != co_Thread.getCategoryId()) ||
						(groupId != co_Thread.getGroupId())) {
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

			query.append(_SQL_SELECT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(groupId);

				list = (List<CO_Thread>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByCategoryAndGroup_First(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByCategoryAndGroup_First(categoryId,
				groupId, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the first c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByCategoryAndGroup_First(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CO_Thread> list = findByCategoryAndGroup(categoryId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByCategoryAndGroup_Last(long categoryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByCategoryAndGroup_Last(categoryId, groupId,
				orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the last c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByCategoryAndGroup_Last(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryAndGroup(categoryId, groupId);

		List<CO_Thread> list = findByCategoryAndGroup(categoryId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] findByCategoryAndGroup_PrevAndNext(long threadId,
		long categoryId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = getByCategoryAndGroup_PrevAndNext(session, co_Thread,
					categoryId, groupId, orderByComparator, true);

			array[1] = co_Thread;

			array[2] = getByCategoryAndGroup_PrevAndNext(session, co_Thread,
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

	protected CO_Thread getByCategoryAndGroup_PrevAndNext(Session session,
		CO_Thread co_Thread, long categoryId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_THREAD_WHERE);

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
			query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByCategoryAndGroup(long categoryId,
		long groupId) throws SystemException {
		return filterFindByCategoryAndGroup(categoryId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByCategoryAndGroup(long categoryId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByCategoryAndGroup(categoryId, groupId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads that the user has permissions to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByCategoryAndGroup(long categoryId,
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
			query.append(_FILTER_SQL_SELECT_CO_THREAD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CO_ThreadImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CO_ThreadImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(categoryId);

			qPos.add(groupId);

			return (List<CO_Thread>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set of c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] filterFindByCategoryAndGroup_PrevAndNext(long threadId,
		long categoryId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryAndGroup_PrevAndNext(threadId, categoryId,
				groupId, orderByComparator);
		}

		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = filterGetByCategoryAndGroup_PrevAndNext(session,
					co_Thread, categoryId, groupId, orderByComparator, true);

			array[1] = co_Thread;

			array[2] = filterGetByCategoryAndGroup_PrevAndNext(session,
					co_Thread, categoryId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CO_Thread filterGetByCategoryAndGroup_PrevAndNext(
		Session session, CO_Thread co_Thread, long categoryId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_CO_THREAD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CO_ThreadImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CO_ThreadImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads where categoryId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCategoryAndCompanyAndStatus(long categoryId,
		long companyId, int status) throws SystemException {
		return findByCategoryAndCompanyAndStatus(categoryId, companyId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads where categoryId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCategoryAndCompanyAndStatus(long categoryId,
		long companyId, int status, int start, int end)
		throws SystemException {
		return findByCategoryAndCompanyAndStatus(categoryId, companyId, status,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads where categoryId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCategoryAndCompanyAndStatus(long categoryId,
		long companyId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANYANDSTATUS;
			finderArgs = new Object[] { categoryId, companyId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDCOMPANYANDSTATUS;
			finderArgs = new Object[] {
					categoryId, companyId, status,
					
					start, end, orderByComparator
				};
		}

		List<CO_Thread> list = (List<CO_Thread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Thread co_Thread : list) {
				if ((categoryId != co_Thread.getCategoryId()) ||
						(companyId != co_Thread.getCompanyId()) ||
						(status != co_Thread.getStatus())) {
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

			query.append(_SQL_SELECT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANYANDSTATUS_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANYANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANYANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(companyId);

				qPos.add(status);

				list = (List<CO_Thread>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByCategoryAndCompanyAndStatus_First(long categoryId,
		long companyId, int status, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByCategoryAndCompanyAndStatus_First(categoryId,
				companyId, status, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the first c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByCategoryAndCompanyAndStatus_First(long categoryId,
		long companyId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<CO_Thread> list = findByCategoryAndCompanyAndStatus(categoryId,
				companyId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByCategoryAndCompanyAndStatus_Last(long categoryId,
		long companyId, int status, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByCategoryAndCompanyAndStatus_Last(categoryId,
				companyId, status, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the last c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByCategoryAndCompanyAndStatus_Last(long categoryId,
		long companyId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryAndCompanyAndStatus(categoryId, companyId,
				status);

		List<CO_Thread> list = findByCategoryAndCompanyAndStatus(categoryId,
				companyId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] findByCategoryAndCompanyAndStatus_PrevAndNext(
		long threadId, long categoryId, long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = getByCategoryAndCompanyAndStatus_PrevAndNext(session,
					co_Thread, categoryId, companyId, status,
					orderByComparator, true);

			array[1] = co_Thread;

			array[2] = getByCategoryAndCompanyAndStatus_PrevAndNext(session,
					co_Thread, categoryId, companyId, status,
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

	protected CO_Thread getByCategoryAndCompanyAndStatus_PrevAndNext(
		Session session, CO_Thread co_Thread, long categoryId, long companyId,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_THREAD_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDCOMPANYANDSTATUS_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDCOMPANYANDSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDCOMPANYANDSTATUS_STATUS_2);

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
			query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(companyId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCategoryAndGroupAndStatus(long categoryId,
		long groupId, int status) throws SystemException {
		return findByCategoryAndGroupAndStatus(categoryId, groupId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCategoryAndGroupAndStatus(long categoryId,
		long groupId, int status, int start, int end) throws SystemException {
		return findByCategoryAndGroupAndStatus(categoryId, groupId, status,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findByCategoryAndGroupAndStatus(long categoryId,
		long groupId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUPANDSTATUS;
			finderArgs = new Object[] { categoryId, groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDGROUPANDSTATUS;
			finderArgs = new Object[] {
					categoryId, groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<CO_Thread> list = (List<CO_Thread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Thread co_Thread : list) {
				if ((categoryId != co_Thread.getCategoryId()) ||
						(groupId != co_Thread.getGroupId()) ||
						(status != co_Thread.getStatus())) {
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

			query.append(_SQL_SELECT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(groupId);

				qPos.add(status);

				list = (List<CO_Thread>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByCategoryAndGroupAndStatus_First(long categoryId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByCategoryAndGroupAndStatus_First(categoryId,
				groupId, status, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the first c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByCategoryAndGroupAndStatus_First(long categoryId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<CO_Thread> list = findByCategoryAndGroupAndStatus(categoryId,
				groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread findByCategoryAndGroupAndStatus_Last(long categoryId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = fetchByCategoryAndGroupAndStatus_Last(categoryId,
				groupId, status, orderByComparator);

		if (co_Thread != null) {
			return co_Thread;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ThreadException(msg.toString());
	}

	/**
	 * Returns the last c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread fetchByCategoryAndGroupAndStatus_Last(long categoryId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryAndGroupAndStatus(categoryId, groupId, status);

		List<CO_Thread> list = findByCategoryAndGroupAndStatus(categoryId,
				groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] findByCategoryAndGroupAndStatus_PrevAndNext(
		long threadId, long categoryId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = getByCategoryAndGroupAndStatus_PrevAndNext(session,
					co_Thread, categoryId, groupId, status, orderByComparator,
					true);

			array[1] = co_Thread;

			array[2] = getByCategoryAndGroupAndStatus_PrevAndNext(session,
					co_Thread, categoryId, groupId, status, orderByComparator,
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

	protected CO_Thread getByCategoryAndGroupAndStatus_PrevAndNext(
		Session session, CO_Thread co_Thread, long categoryId, long groupId,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_THREAD_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_STATUS_2);

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
			query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status) throws SystemException {
		return filterFindByCategoryAndGroupAndStatus(categoryId, groupId,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status, int start, int end)
		throws SystemException {
		return filterFindByCategoryAndGroupAndStatus(categoryId, groupId,
			status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads that the user has permissions to view where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> filterFindByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryAndGroupAndStatus(categoryId, groupId, status,
				start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_CO_THREAD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CO_ThreadImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CO_ThreadImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(categoryId);

			qPos.add(groupId);

			qPos.add(status);

			return (List<CO_Thread>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the c o_ threads before and after the current c o_ thread in the ordered set of c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param threadId the primary key of the current c o_ thread
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ thread
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread[] filterFindByCategoryAndGroupAndStatus_PrevAndNext(
		long threadId, long categoryId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ThreadException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryAndGroupAndStatus_PrevAndNext(threadId,
				categoryId, groupId, status, orderByComparator);
		}

		CO_Thread co_Thread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			CO_Thread[] array = new CO_ThreadImpl[3];

			array[0] = filterGetByCategoryAndGroupAndStatus_PrevAndNext(session,
					co_Thread, categoryId, groupId, status, orderByComparator,
					true);

			array[1] = co_Thread;

			array[2] = filterGetByCategoryAndGroupAndStatus_PrevAndNext(session,
					co_Thread, categoryId, groupId, status, orderByComparator,
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

	protected CO_Thread filterGetByCategoryAndGroupAndStatus_PrevAndNext(
		Session session, CO_Thread co_Thread, long categoryId, long groupId,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ThreadModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CO_ThreadImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CO_ThreadImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Thread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Thread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ threads.
	 *
	 * @return the c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @return the range of c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of c o_ threads
	 * @param end the upper bound of the range of c o_ threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Thread> findAll(int start, int end,
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

		List<CO_Thread> list = (List<CO_Thread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CO_THREAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CO_THREAD.concat(CO_ThreadModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CO_Thread>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CO_Thread>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the c o_ threads where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (CO_Thread co_Thread : findByCompany(companyId)) {
			remove(co_Thread);
		}
	}

	/**
	 * Removes all the c o_ threads where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (CO_Thread co_Thread : findByGroup(groupId)) {
			remove(co_Thread);
		}
	}

	/**
	 * Removes all the c o_ threads where status = &#63; and companyId = &#63; from the database.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusAndCompany(int status, long companyId)
		throws SystemException {
		for (CO_Thread co_Thread : findByStatusAndCompany(status, companyId)) {
			remove(co_Thread);
		}
	}

	/**
	 * Removes all the c o_ threads where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusAndGroup(int status, long groupId)
		throws SystemException {
		for (CO_Thread co_Thread : findByStatusAndGroup(status, groupId)) {
			remove(co_Thread);
		}
	}

	/**
	 * Removes all the c o_ threads where parentThreadId = &#63; and companyId = &#63; from the database.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentThreadAndCompany(long parentThreadId,
		long companyId) throws SystemException {
		for (CO_Thread co_Thread : findByParentThreadAndCompany(
				parentThreadId, companyId)) {
			remove(co_Thread);
		}
	}

	/**
	 * Removes all the c o_ threads where parentThreadId = &#63; and groupId = &#63; from the database.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentThreadAndGroup(long parentThreadId, long groupId)
		throws SystemException {
		for (CO_Thread co_Thread : findByParentThreadAndGroup(parentThreadId,
				groupId)) {
			remove(co_Thread);
		}
	}

	/**
	 * Removes all the c o_ threads where parentThreadId = &#63; and companyId = &#63; and status = &#63; from the database.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentThreadAndCompanyAndStatus(long parentThreadId,
		long companyId, int status) throws SystemException {
		for (CO_Thread co_Thread : findByParentThreadAndCompanyAndStatus(
				parentThreadId, companyId, status)) {
			remove(co_Thread);
		}
	}

	/**
	 * Removes all the c o_ threads where parentThreadId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentThreadAndGroupAndStatus(long parentThreadId,
		long groupId, int status) throws SystemException {
		for (CO_Thread co_Thread : findByParentThreadAndGroupAndStatus(
				parentThreadId, groupId, status)) {
			remove(co_Thread);
		}
	}

	/**
	 * Removes all the c o_ threads where categoryId = &#63; and companyId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryAndCompany(long categoryId, long companyId)
		throws SystemException {
		for (CO_Thread co_Thread : findByCategoryAndCompany(categoryId,
				companyId)) {
			remove(co_Thread);
		}
	}

	/**
	 * Removes all the c o_ threads where categoryId = &#63; and groupId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryAndGroup(long categoryId, long groupId)
		throws SystemException {
		for (CO_Thread co_Thread : findByCategoryAndGroup(categoryId, groupId)) {
			remove(co_Thread);
		}
	}

	/**
	 * Removes all the c o_ threads where categoryId = &#63; and companyId = &#63; and status = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryAndCompanyAndStatus(long categoryId,
		long companyId, int status) throws SystemException {
		for (CO_Thread co_Thread : findByCategoryAndCompanyAndStatus(
				categoryId, companyId, status)) {
			remove(co_Thread);
		}
	}

	/**
	 * Removes all the c o_ threads where categoryId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryAndGroupAndStatus(long categoryId,
		long groupId, int status) throws SystemException {
		for (CO_Thread co_Thread : findByCategoryAndGroupAndStatus(categoryId,
				groupId, status)) {
			remove(co_Thread);
		}
	}

	/**
	 * Removes all the c o_ threads from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CO_Thread co_Thread : findAll()) {
			remove(co_Thread);
		}
	}

	/**
	 * Returns the number of c o_ threads where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CO_THREAD_WHERE);

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
	 * Returns the number of c o_ threads where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CO_THREAD_WHERE);

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
	 * Returns the number of c o_ threads that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CO_THREAD_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
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
	 * Returns the number of c o_ threads where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @return the number of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusAndCompany(int status, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { status, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_STATUS_2);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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
	 * Returns the number of c o_ threads where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusAndGroup(int status, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { status, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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
	 * Returns the number of c o_ threads that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByStatusAndGroup(int status, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByStatusAndGroup(status, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CO_THREAD_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(status);

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
	 * Returns the number of c o_ threads where parentThreadId = &#63; and companyId = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @return the number of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentThreadAndCompany(long parentThreadId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { parentThreadId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANY_PARENTTHREADID_2);

			query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentThreadId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of c o_ threads where parentThreadId = &#63; and groupId = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @return the number of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentThreadAndGroup(long parentThreadId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { parentThreadId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_PARENTTHREADANDGROUP_PARENTTHREADID_2);

			query.append(_FINDER_COLUMN_PARENTTHREADANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentThreadId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @return the number of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByParentThreadAndGroup(long parentThreadId,
		long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByParentThreadAndGroup(parentThreadId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CO_THREAD_WHERE);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUP_PARENTTHREADID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(parentThreadId);

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
	 * Returns the number of c o_ threads where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentThreadAndCompanyAndStatus(long parentThreadId,
		long companyId, int status) throws SystemException {
		Object[] finderArgs = new Object[] { parentThreadId, companyId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDCOMPANYANDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANYANDSTATUS_PARENTTHREADID_2);

			query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANYANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_PARENTTHREADANDCOMPANYANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentThreadId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDCOMPANYANDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of c o_ threads where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentThreadAndGroupAndStatus(long parentThreadId,
		long groupId, int status) throws SystemException {
		Object[] finderArgs = new Object[] { parentThreadId, groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDGROUPANDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_PARENTTHREADID_2);

			query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentThreadId);

				qPos.add(groupId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTTHREADANDGROUPANDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param parentThreadId the parent thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByParentThreadAndGroupAndStatus(long parentThreadId,
		long groupId, int status) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByParentThreadAndGroupAndStatus(parentThreadId,
				groupId, status);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CO_THREAD_WHERE);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_PARENTTHREADID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(parentThreadId);

			qPos.add(groupId);

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
	 * Returns the number of c o_ threads where categoryId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @return the number of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryAndCompany(long categoryId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { categoryId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CO_THREAD_WHERE);

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
	 * Returns the number of c o_ threads where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the number of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryAndGroup(long categoryId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { categoryId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CO_THREAD_WHERE);

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
	 * Returns the number of c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @return the number of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByCategoryAndGroup(long categoryId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCategoryAndGroup(categoryId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CO_THREAD_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
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
	 * Returns the number of c o_ threads where categoryId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryAndCompanyAndStatus(long categoryId,
		long companyId, int status) throws SystemException {
		Object[] finderArgs = new Object[] { categoryId, companyId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANYANDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANYANDSTATUS_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANYANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANYANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANYANDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of c o_ threads where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryAndGroupAndStatus(long categoryId, long groupId,
		int status) throws SystemException {
		Object[] finderArgs = new Object[] { categoryId, groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUPANDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CO_THREAD_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(groupId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUPANDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching c o_ threads that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByCategoryAndGroupAndStatus(long categoryId,
		long groupId, int status) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCategoryAndGroupAndStatus(categoryId, groupId, status);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CO_THREAD_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Thread.class.getName(),
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
	 * Returns the number of c o_ threads.
	 *
	 * @return the number of c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CO_THREAD);

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
	 * Initializes the c o_ thread persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.conversation.model.CO_Thread")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CO_Thread>> listenersList = new ArrayList<ModelListener<CO_Thread>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CO_Thread>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CO_ThreadImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CO_CategoryPersistence.class)
	protected CO_CategoryPersistence co_CategoryPersistence;
	@BeanReference(type = CO_ConversationPersistence.class)
	protected CO_ConversationPersistence co_ConversationPersistence;
	@BeanReference(type = CO_ThreadPersistence.class)
	protected CO_ThreadPersistence co_ThreadPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CO_THREAD = "SELECT co_Thread FROM CO_Thread co_Thread";
	private static final String _SQL_SELECT_CO_THREAD_WHERE = "SELECT co_Thread FROM CO_Thread co_Thread WHERE ";
	private static final String _SQL_COUNT_CO_THREAD = "SELECT COUNT(co_Thread) FROM CO_Thread co_Thread";
	private static final String _SQL_COUNT_CO_THREAD_WHERE = "SELECT COUNT(co_Thread) FROM CO_Thread co_Thread WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "co_Thread.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "co_Thread.groupId = ?";
	private static final String _FINDER_COLUMN_STATUSANDCOMPANY_STATUS_2 = "co_Thread.status = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2 = "co_Thread.companyId = ?";
	private static final String _FINDER_COLUMN_STATUSANDGROUP_STATUS_2 = "co_Thread.status = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDGROUP_GROUPID_2 = "co_Thread.groupId = ?";
	private static final String _FINDER_COLUMN_PARENTTHREADANDCOMPANY_PARENTTHREADID_2 =
		"co_Thread.parentThreadId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTTHREADANDCOMPANY_COMPANYID_2 =
		"co_Thread.companyId = ?";
	private static final String _FINDER_COLUMN_PARENTTHREADANDGROUP_PARENTTHREADID_2 =
		"co_Thread.parentThreadId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTTHREADANDGROUP_GROUPID_2 = "co_Thread.groupId = ?";
	private static final String _FINDER_COLUMN_PARENTTHREADANDCOMPANYANDSTATUS_PARENTTHREADID_2 =
		"co_Thread.parentThreadId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTTHREADANDCOMPANYANDSTATUS_COMPANYID_2 =
		"co_Thread.companyId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTTHREADANDCOMPANYANDSTATUS_STATUS_2 =
		"co_Thread.status = ?";
	private static final String _FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_PARENTTHREADID_2 =
		"co_Thread.parentThreadId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_GROUPID_2 =
		"co_Thread.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTTHREADANDGROUPANDSTATUS_STATUS_2 =
		"co_Thread.status = ?";
	private static final String _FINDER_COLUMN_CATEGORYANDCOMPANY_CATEGORYID_2 = "co_Thread.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDCOMPANY_COMPANYID_2 = "co_Thread.companyId = ?";
	private static final String _FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2 = "co_Thread.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2 = "co_Thread.groupId = ?";
	private static final String _FINDER_COLUMN_CATEGORYANDCOMPANYANDSTATUS_CATEGORYID_2 =
		"co_Thread.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDCOMPANYANDSTATUS_COMPANYID_2 =
		"co_Thread.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDCOMPANYANDSTATUS_STATUS_2 =
		"co_Thread.status = ?";
	private static final String _FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_CATEGORYID_2 =
		"co_Thread.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_GROUPID_2 =
		"co_Thread.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDGROUPANDSTATUS_STATUS_2 =
		"co_Thread.status = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "co_Thread.threadId";
	private static final String _FILTER_SQL_SELECT_CO_THREAD_WHERE = "SELECT DISTINCT {co_Thread.*} FROM CO_Thread co_Thread WHERE ";
	private static final String _FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {CO_Thread.*} FROM (SELECT DISTINCT co_Thread.threadId FROM CO_Thread co_Thread WHERE ";
	private static final String _FILTER_SQL_SELECT_CO_THREAD_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN CO_Thread ON TEMP_TABLE.threadId = CO_Thread.threadId";
	private static final String _FILTER_SQL_COUNT_CO_THREAD_WHERE = "SELECT COUNT(DISTINCT co_Thread.threadId) AS COUNT_VALUE FROM CO_Thread co_Thread WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "co_Thread";
	private static final String _FILTER_ENTITY_TABLE = "CO_Thread";
	private static final String _ORDER_BY_ENTITY_ALIAS = "co_Thread.";
	private static final String _ORDER_BY_ENTITY_TABLE = "CO_Thread.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CO_Thread exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CO_Thread exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CO_ThreadPersistenceImpl.class);
	private static CO_Thread _nullCO_Thread = new CO_ThreadImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CO_Thread> toCacheModel() {
				return _nullCO_ThreadCacheModel;
			}
		};

	private static CacheModel<CO_Thread> _nullCO_ThreadCacheModel = new CacheModel<CO_Thread>() {
			public CO_Thread toEntityModel() {
				return _nullCO_Thread;
			}
		};
}