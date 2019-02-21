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

import com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;
import com.portal_egov.portlet.vbpq.model.VBPQ_Category;
import com.portal_egov.portlet.vbpq.model.impl.VBPQ_CategoryImpl;
import com.portal_egov.portlet.vbpq.model.impl.VBPQ_CategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the v b p q_ category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see VBPQ_CategoryPersistence
 * @see VBPQ_CategoryUtil
 * @generated
 */
public class VBPQ_CategoryPersistenceImpl extends BasePersistenceImpl<VBPQ_Category>
	implements VBPQ_CategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VBPQ_CategoryUtil} to access the v b p q_ category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VBPQ_CategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompany", new String[] { Long.class.getName() },
			VBPQ_CategoryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroup", new String[] { Long.class.getName() },
			VBPQ_CategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDCOMPANY =
		new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY =
		new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			VBPQ_CategoryModelImpl.PARENTID_COLUMN_BITMASK |
			VBPQ_CategoryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTANDCOMPANY = new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDGROUP =
		new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP =
		new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			VBPQ_CategoryModelImpl.PARENTID_COLUMN_BITMASK |
			VBPQ_CategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTANDGROUP = new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDCOMPANY =
		new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTypeAndCompany",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY =
		new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTypeAndCompany",
			new String[] { Integer.class.getName(), Long.class.getName() },
			VBPQ_CategoryModelImpl.TYPEID_COLUMN_BITMASK |
			VBPQ_CategoryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEANDCOMPANY = new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeAndCompany",
			new String[] { Integer.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDGROUP =
		new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTypeAndGroup",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP =
		new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTypeAndGroup",
			new String[] { Integer.class.getName(), Long.class.getName() },
			VBPQ_CategoryModelImpl.TYPEID_COLUMN_BITMASK |
			VBPQ_CategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEANDGROUP = new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeAndGroup",
			new String[] { Integer.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDCOMPANY =
		new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatusAndCompany",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY =
		new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatusAndCompany",
			new String[] { Boolean.class.getName(), Long.class.getName() },
			VBPQ_CategoryModelImpl.ACTIVE_COLUMN_BITMASK |
			VBPQ_CategoryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDCOMPANY = new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusAndCompany",
			new String[] { Boolean.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDGROUP =
		new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatusAndGroup",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP =
		new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatusAndGroup",
			new String[] { Boolean.class.getName(), Long.class.getName() },
			VBPQ_CategoryModelImpl.ACTIVE_COLUMN_BITMASK |
			VBPQ_CategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDGROUP = new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusAndGroup",
			new String[] { Boolean.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the v b p q_ category in the entity cache if it is enabled.
	 *
	 * @param vbpq_Category the v b p q_ category
	 */
	public void cacheResult(VBPQ_Category vbpq_Category) {
		EntityCacheUtil.putResult(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, vbpq_Category.getPrimaryKey(),
			vbpq_Category);

		vbpq_Category.resetOriginalValues();
	}

	/**
	 * Caches the v b p q_ categories in the entity cache if it is enabled.
	 *
	 * @param vbpq_Categories the v b p q_ categories
	 */
	public void cacheResult(List<VBPQ_Category> vbpq_Categories) {
		for (VBPQ_Category vbpq_Category : vbpq_Categories) {
			if (EntityCacheUtil.getResult(
						VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
						VBPQ_CategoryImpl.class, vbpq_Category.getPrimaryKey()) == null) {
				cacheResult(vbpq_Category);
			}
			else {
				vbpq_Category.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v b p q_ categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VBPQ_CategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VBPQ_CategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v b p q_ category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VBPQ_Category vbpq_Category) {
		EntityCacheUtil.removeResult(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, vbpq_Category.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VBPQ_Category> vbpq_Categories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VBPQ_Category vbpq_Category : vbpq_Categories) {
			EntityCacheUtil.removeResult(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				VBPQ_CategoryImpl.class, vbpq_Category.getPrimaryKey());
		}
	}

	/**
	 * Creates a new v b p q_ category with the primary key. Does not add the v b p q_ category to the database.
	 *
	 * @param categoryId the primary key for the new v b p q_ category
	 * @return the new v b p q_ category
	 */
	public VBPQ_Category create(long categoryId) {
		VBPQ_Category vbpq_Category = new VBPQ_CategoryImpl();

		vbpq_Category.setNew(true);
		vbpq_Category.setPrimaryKey(categoryId);

		return vbpq_Category;
	}

	/**
	 * Removes the v b p q_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the v b p q_ category
	 * @return the v b p q_ category that was removed
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category remove(long categoryId)
		throws NoSuchVBPQ_CategoryException, SystemException {
		return remove(Long.valueOf(categoryId));
	}

	/**
	 * Removes the v b p q_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v b p q_ category
	 * @return the v b p q_ category that was removed
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VBPQ_Category remove(Serializable primaryKey)
		throws NoSuchVBPQ_CategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VBPQ_Category vbpq_Category = (VBPQ_Category)session.get(VBPQ_CategoryImpl.class,
					primaryKey);

			if (vbpq_Category == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVBPQ_CategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vbpq_Category);
		}
		catch (NoSuchVBPQ_CategoryException nsee) {
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
	protected VBPQ_Category removeImpl(VBPQ_Category vbpq_Category)
		throws SystemException {
		vbpq_Category = toUnwrappedModel(vbpq_Category);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vbpq_Category);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vbpq_Category);

		return vbpq_Category;
	}

	@Override
	public VBPQ_Category updateImpl(
		com.portal_egov.portlet.vbpq.model.VBPQ_Category vbpq_Category,
		boolean merge) throws SystemException {
		vbpq_Category = toUnwrappedModel(vbpq_Category);

		boolean isNew = vbpq_Category.isNew();

		VBPQ_CategoryModelImpl vbpq_CategoryModelImpl = (VBPQ_CategoryModelImpl)vbpq_Category;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vbpq_Category, merge);

			vbpq_Category.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VBPQ_CategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vbpq_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vbpq_CategoryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(vbpq_CategoryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((vbpq_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vbpq_CategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(vbpq_CategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((vbpq_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vbpq_CategoryModelImpl.getOriginalParentId()),
						Long.valueOf(vbpq_CategoryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(vbpq_CategoryModelImpl.getParentId()),
						Long.valueOf(vbpq_CategoryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY,
					args);
			}

			if ((vbpq_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vbpq_CategoryModelImpl.getOriginalParentId()),
						Long.valueOf(vbpq_CategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(vbpq_CategoryModelImpl.getParentId()),
						Long.valueOf(vbpq_CategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP,
					args);
			}

			if ((vbpq_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(vbpq_CategoryModelImpl.getOriginalTypeId()),
						Long.valueOf(vbpq_CategoryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY,
					args);

				args = new Object[] {
						Integer.valueOf(vbpq_CategoryModelImpl.getTypeId()),
						Long.valueOf(vbpq_CategoryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY,
					args);
			}

			if ((vbpq_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(vbpq_CategoryModelImpl.getOriginalTypeId()),
						Long.valueOf(vbpq_CategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP,
					args);

				args = new Object[] {
						Integer.valueOf(vbpq_CategoryModelImpl.getTypeId()),
						Long.valueOf(vbpq_CategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP,
					args);
			}

			if ((vbpq_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(vbpq_CategoryModelImpl.getOriginalActive()),
						Long.valueOf(vbpq_CategoryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY,
					args);

				args = new Object[] {
						Boolean.valueOf(vbpq_CategoryModelImpl.getActive()),
						Long.valueOf(vbpq_CategoryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY,
					args);
			}

			if ((vbpq_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(vbpq_CategoryModelImpl.getOriginalActive()),
						Long.valueOf(vbpq_CategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP,
					args);

				args = new Object[] {
						Boolean.valueOf(vbpq_CategoryModelImpl.getActive()),
						Long.valueOf(vbpq_CategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			VBPQ_CategoryImpl.class, vbpq_Category.getPrimaryKey(),
			vbpq_Category);

		return vbpq_Category;
	}

	protected VBPQ_Category toUnwrappedModel(VBPQ_Category vbpq_Category) {
		if (vbpq_Category instanceof VBPQ_CategoryImpl) {
			return vbpq_Category;
		}

		VBPQ_CategoryImpl vbpq_CategoryImpl = new VBPQ_CategoryImpl();

		vbpq_CategoryImpl.setNew(vbpq_Category.isNew());
		vbpq_CategoryImpl.setPrimaryKey(vbpq_Category.getPrimaryKey());

		vbpq_CategoryImpl.setCategoryId(vbpq_Category.getCategoryId());
		vbpq_CategoryImpl.setParentId(vbpq_Category.getParentId());
		vbpq_CategoryImpl.setTypeId(vbpq_Category.getTypeId());
		vbpq_CategoryImpl.setCompanyId(vbpq_Category.getCompanyId());
		vbpq_CategoryImpl.setGroupId(vbpq_Category.getGroupId());
		vbpq_CategoryImpl.setUserId(vbpq_Category.getUserId());
		vbpq_CategoryImpl.setCategoryName(vbpq_Category.getCategoryName());
		vbpq_CategoryImpl.setCategoryDesc(vbpq_Category.getCategoryDesc());
		vbpq_CategoryImpl.setCreateDate(vbpq_Category.getCreateDate());
		vbpq_CategoryImpl.setModifiedDate(vbpq_Category.getModifiedDate());
		vbpq_CategoryImpl.setActive(vbpq_Category.isActive());
		vbpq_CategoryImpl.setDisplayPriority(vbpq_Category.getDisplayPriority());

		return vbpq_CategoryImpl;
	}

	/**
	 * Returns the v b p q_ category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v b p q_ category
	 * @return the v b p q_ category
	 * @throws com.liferay.portal.NoSuchModelException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VBPQ_Category findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the v b p q_ category with the primary key or throws a {@link com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the v b p q_ category
	 * @return the v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByPrimaryKey(long categoryId)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByPrimaryKey(categoryId);

		if (vbpq_Category == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
			}

			throw new NoSuchVBPQ_CategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryId);
		}

		return vbpq_Category;
	}

	/**
	 * Returns the v b p q_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v b p q_ category
	 * @return the v b p q_ category, or <code>null</code> if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VBPQ_Category fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the v b p q_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the v b p q_ category
	 * @return the v b p q_ category, or <code>null</code> if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByPrimaryKey(long categoryId)
		throws SystemException {
		VBPQ_Category vbpq_Category = (VBPQ_Category)EntityCacheUtil.getResult(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				VBPQ_CategoryImpl.class, categoryId);

		if (vbpq_Category == _nullVBPQ_Category) {
			return null;
		}

		if (vbpq_Category == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vbpq_Category = (VBPQ_Category)session.get(VBPQ_CategoryImpl.class,
						Long.valueOf(categoryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vbpq_Category != null) {
					cacheResult(vbpq_Category);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VBPQ_CategoryModelImpl.ENTITY_CACHE_ENABLED,
						VBPQ_CategoryImpl.class, categoryId, _nullVBPQ_Category);
				}

				closeSession(session);
			}
		}

		return vbpq_Category;
	}

	/**
	 * Returns all the v b p q_ categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the v b p q_ categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @return the range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByCompany(long companyId, int start,
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

		List<VBPQ_Category> list = (List<VBPQ_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Category vbpq_Category : list) {
				if ((companyId != vbpq_Category.getCompanyId())) {
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

			query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<VBPQ_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v b p q_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByCompany_First(companyId,
				orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VBPQ_Category> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByCompany_Last(companyId,
				orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<VBPQ_Category> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current v b p q_ category
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category[] findByCompany_PrevAndNext(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Category[] array = new VBPQ_CategoryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, vbpq_Category,
					companyId, orderByComparator, true);

			array[1] = vbpq_Category;

			array[2] = getByCompany_PrevAndNext(session, vbpq_Category,
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

	protected VBPQ_Category getByCompany_PrevAndNext(Session session,
		VBPQ_Category vbpq_Category, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

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
			query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @return the range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByGroup(long groupId, int start, int end,
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

		List<VBPQ_Category> list = (List<VBPQ_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Category vbpq_Category : list) {
				if ((groupId != vbpq_Category.getGroupId())) {
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

			query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<VBPQ_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v b p q_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByGroup_First(groupId,
				orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VBPQ_Category> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByGroup_Last(groupId,
				orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<VBPQ_Category> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current v b p q_ category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category[] findByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Category[] array = new VBPQ_CategoryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, vbpq_Category, groupId,
					orderByComparator, true);

			array[1] = vbpq_Category;

			array[2] = getByGroup_PrevAndNext(session, vbpq_Category, groupId,
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

	protected VBPQ_Category getByGroup_PrevAndNext(Session session,
		VBPQ_Category vbpq_Category, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

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
			query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the v b p q_ categories that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @return the range of matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ categories that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_CategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_CategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<VBPQ_Category>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set of v b p q_ categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current v b p q_ category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category[] filterFindByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(categoryId, groupId,
				orderByComparator);
		}

		VBPQ_Category vbpq_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Category[] array = new VBPQ_CategoryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, vbpq_Category,
					groupId, orderByComparator, true);

			array[1] = vbpq_Category;

			array[2] = filterGetByGroup_PrevAndNext(session, vbpq_Category,
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

	protected VBPQ_Category filterGetByGroup_PrevAndNext(Session session,
		VBPQ_Category vbpq_Category, long groupId,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_CategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_CategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ categories where parentId = &#63; and companyId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @return the matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByParentAndCompany(long parentId,
		long companyId) throws SystemException {
		return findByParentAndCompany(parentId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ categories where parentId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @return the range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByParentAndCompany(long parentId,
		long companyId, int start, int end) throws SystemException {
		return findByParentAndCompany(parentId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ categories where parentId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByParentAndCompany(long parentId,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY;
			finderArgs = new Object[] { parentId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDCOMPANY;
			finderArgs = new Object[] {
					parentId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<VBPQ_Category> list = (List<VBPQ_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Category vbpq_Category : list) {
				if ((parentId != vbpq_Category.getParentId()) ||
						(companyId != vbpq_Category.getCompanyId())) {
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

			query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_PARENTID_2);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				qPos.add(companyId);

				list = (List<VBPQ_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v b p q_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByParentAndCompany_First(long parentId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByParentAndCompany_First(parentId,
				companyId, orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByParentAndCompany_First(long parentId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VBPQ_Category> list = findByParentAndCompany(parentId, companyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByParentAndCompany_Last(long parentId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByParentAndCompany_Last(parentId,
				companyId, orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByParentAndCompany_Last(long parentId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentAndCompany(parentId, companyId);

		List<VBPQ_Category> list = findByParentAndCompany(parentId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current v b p q_ category
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category[] findByParentAndCompany_PrevAndNext(long categoryId,
		long parentId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Category[] array = new VBPQ_CategoryImpl[3];

			array[0] = getByParentAndCompany_PrevAndNext(session,
					vbpq_Category, parentId, companyId, orderByComparator, true);

			array[1] = vbpq_Category;

			array[2] = getByParentAndCompany_PrevAndNext(session,
					vbpq_Category, parentId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Category getByParentAndCompany_PrevAndNext(Session session,
		VBPQ_Category vbpq_Category, long parentId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PARENTANDCOMPANY_PARENTID_2);

		query.append(_FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2);

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
			query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ categories where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @return the matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByParentAndGroup(long parentId, long groupId)
		throws SystemException {
		return findByParentAndGroup(parentId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ categories where parentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @return the range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByParentAndGroup(long parentId,
		long groupId, int start, int end) throws SystemException {
		return findByParentAndGroup(parentId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ categories where parentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByParentAndGroup(long parentId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP;
			finderArgs = new Object[] { parentId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDGROUP;
			finderArgs = new Object[] {
					parentId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VBPQ_Category> list = (List<VBPQ_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Category vbpq_Category : list) {
				if ((parentId != vbpq_Category.getParentId()) ||
						(groupId != vbpq_Category.getGroupId())) {
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

			query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				qPos.add(groupId);

				list = (List<VBPQ_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v b p q_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByParentAndGroup_First(long parentId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByParentAndGroup_First(parentId,
				groupId, orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByParentAndGroup_First(long parentId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VBPQ_Category> list = findByParentAndGroup(parentId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByParentAndGroup_Last(long parentId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByParentAndGroup_Last(parentId,
				groupId, orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByParentAndGroup_Last(long parentId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentAndGroup(parentId, groupId);

		List<VBPQ_Category> list = findByParentAndGroup(parentId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current v b p q_ category
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category[] findByParentAndGroup_PrevAndNext(long categoryId,
		long parentId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Category[] array = new VBPQ_CategoryImpl[3];

			array[0] = getByParentAndGroup_PrevAndNext(session, vbpq_Category,
					parentId, groupId, orderByComparator, true);

			array[1] = vbpq_Category;

			array[2] = getByParentAndGroup_PrevAndNext(session, vbpq_Category,
					parentId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Category getByParentAndGroup_PrevAndNext(Session session,
		VBPQ_Category vbpq_Category, long parentId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

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
			query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @return the matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> filterFindByParentAndGroup(long parentId,
		long groupId) throws SystemException {
		return filterFindByParentAndGroup(parentId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @return the range of matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> filterFindByParentAndGroup(long parentId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByParentAndGroup(parentId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ categories that the user has permissions to view where parentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> filterFindByParentAndGroup(long parentId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParentAndGroup(parentId, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_CategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_CategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(parentId);

			qPos.add(groupId);

			return (List<VBPQ_Category>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set of v b p q_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current v b p q_ category
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category[] filterFindByParentAndGroup_PrevAndNext(
		long categoryId, long parentId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParentAndGroup_PrevAndNext(categoryId, parentId,
				groupId, orderByComparator);
		}

		VBPQ_Category vbpq_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Category[] array = new VBPQ_CategoryImpl[3];

			array[0] = filterGetByParentAndGroup_PrevAndNext(session,
					vbpq_Category, parentId, groupId, orderByComparator, true);

			array[1] = vbpq_Category;

			array[2] = filterGetByParentAndGroup_PrevAndNext(session,
					vbpq_Category, parentId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Category filterGetByParentAndGroup_PrevAndNext(
		Session session, VBPQ_Category vbpq_Category, long parentId,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_CategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_CategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ categories where typeId = &#63; and companyId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param companyId the company ID
	 * @return the matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByTypeAndCompany(int typeId, long companyId)
		throws SystemException {
		return findByTypeAndCompany(typeId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ categories where typeId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @return the range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByTypeAndCompany(int typeId, long companyId,
		int start, int end) throws SystemException {
		return findByTypeAndCompany(typeId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ categories where typeId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByTypeAndCompany(int typeId, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY;
			finderArgs = new Object[] { typeId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDCOMPANY;
			finderArgs = new Object[] {
					typeId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<VBPQ_Category> list = (List<VBPQ_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Category vbpq_Category : list) {
				if ((typeId != vbpq_Category.getTypeId()) ||
						(companyId != vbpq_Category.getCompanyId())) {
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

			query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDCOMPANY_TYPEID_2);

			query.append(_FINDER_COLUMN_TYPEANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

				qPos.add(companyId);

				list = (List<VBPQ_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v b p q_ category in the ordered set where typeId = &#63; and companyId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByTypeAndCompany_First(int typeId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByTypeAndCompany_First(typeId,
				companyId, orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ category in the ordered set where typeId = &#63; and companyId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByTypeAndCompany_First(int typeId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VBPQ_Category> list = findByTypeAndCompany(typeId, companyId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where typeId = &#63; and companyId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByTypeAndCompany_Last(int typeId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByTypeAndCompany_Last(typeId,
				companyId, orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where typeId = &#63; and companyId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByTypeAndCompany_Last(int typeId, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTypeAndCompany(typeId, companyId);

		List<VBPQ_Category> list = findByTypeAndCompany(typeId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where typeId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current v b p q_ category
	 * @param typeId the type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category[] findByTypeAndCompany_PrevAndNext(long categoryId,
		int typeId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Category[] array = new VBPQ_CategoryImpl[3];

			array[0] = getByTypeAndCompany_PrevAndNext(session, vbpq_Category,
					typeId, companyId, orderByComparator, true);

			array[1] = vbpq_Category;

			array[2] = getByTypeAndCompany_PrevAndNext(session, vbpq_Category,
					typeId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Category getByTypeAndCompany_PrevAndNext(Session session,
		VBPQ_Category vbpq_Category, int typeId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_TYPEANDCOMPANY_TYPEID_2);

		query.append(_FINDER_COLUMN_TYPEANDCOMPANY_COMPANYID_2);

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
			query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(typeId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ categories where typeId = &#63; and groupId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @return the matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByTypeAndGroup(int typeId, long groupId)
		throws SystemException {
		return findByTypeAndGroup(typeId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ categories where typeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @return the range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByTypeAndGroup(int typeId, long groupId,
		int start, int end) throws SystemException {
		return findByTypeAndGroup(typeId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ categories where typeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByTypeAndGroup(int typeId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP;
			finderArgs = new Object[] { typeId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDGROUP;
			finderArgs = new Object[] {
					typeId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VBPQ_Category> list = (List<VBPQ_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Category vbpq_Category : list) {
				if ((typeId != vbpq_Category.getTypeId()) ||
						(groupId != vbpq_Category.getGroupId())) {
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

			query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDGROUP_TYPEID_2);

			query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

				qPos.add(groupId);

				list = (List<VBPQ_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v b p q_ category in the ordered set where typeId = &#63; and groupId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByTypeAndGroup_First(int typeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByTypeAndGroup_First(typeId,
				groupId, orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ category in the ordered set where typeId = &#63; and groupId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByTypeAndGroup_First(int typeId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VBPQ_Category> list = findByTypeAndGroup(typeId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where typeId = &#63; and groupId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByTypeAndGroup_Last(int typeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByTypeAndGroup_Last(typeId, groupId,
				orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where typeId = &#63; and groupId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByTypeAndGroup_Last(int typeId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTypeAndGroup(typeId, groupId);

		List<VBPQ_Category> list = findByTypeAndGroup(typeId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where typeId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current v b p q_ category
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category[] findByTypeAndGroup_PrevAndNext(long categoryId,
		int typeId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Category[] array = new VBPQ_CategoryImpl[3];

			array[0] = getByTypeAndGroup_PrevAndNext(session, vbpq_Category,
					typeId, groupId, orderByComparator, true);

			array[1] = vbpq_Category;

			array[2] = getByTypeAndGroup_PrevAndNext(session, vbpq_Category,
					typeId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Category getByTypeAndGroup_PrevAndNext(Session session,
		VBPQ_Category vbpq_Category, int typeId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_TYPEID_2);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

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
			query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(typeId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ categories that the user has permission to view where typeId = &#63; and groupId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @return the matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> filterFindByTypeAndGroup(int typeId, long groupId)
		throws SystemException {
		return filterFindByTypeAndGroup(typeId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ categories that the user has permission to view where typeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @return the range of matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> filterFindByTypeAndGroup(int typeId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByTypeAndGroup(typeId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ categories that the user has permissions to view where typeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> filterFindByTypeAndGroup(int typeId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByTypeAndGroup(typeId, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_TYPEANDGROUP_TYPEID_2);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_CategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_CategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(typeId);

			qPos.add(groupId);

			return (List<VBPQ_Category>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set of v b p q_ categories that the user has permission to view where typeId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current v b p q_ category
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category[] filterFindByTypeAndGroup_PrevAndNext(
		long categoryId, int typeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByTypeAndGroup_PrevAndNext(categoryId, typeId, groupId,
				orderByComparator);
		}

		VBPQ_Category vbpq_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Category[] array = new VBPQ_CategoryImpl[3];

			array[0] = filterGetByTypeAndGroup_PrevAndNext(session,
					vbpq_Category, typeId, groupId, orderByComparator, true);

			array[1] = vbpq_Category;

			array[2] = filterGetByTypeAndGroup_PrevAndNext(session,
					vbpq_Category, typeId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Category filterGetByTypeAndGroup_PrevAndNext(
		Session session, VBPQ_Category vbpq_Category, int typeId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_TYPEANDGROUP_TYPEID_2);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_CategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_CategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(typeId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ categories where active = &#63; and companyId = &#63;.
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @return the matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByStatusAndCompany(boolean active,
		long companyId) throws SystemException {
		return findByStatusAndCompany(active, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ categories where active = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @return the range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByStatusAndCompany(boolean active,
		long companyId, int start, int end) throws SystemException {
		return findByStatusAndCompany(active, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ categories where active = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByStatusAndCompany(boolean active,
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

		List<VBPQ_Category> list = (List<VBPQ_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Category vbpq_Category : list) {
				if ((active != vbpq_Category.getActive()) ||
						(companyId != vbpq_Category.getCompanyId())) {
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

			query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_ACTIVE_2);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(companyId);

				list = (List<VBPQ_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v b p q_ category in the ordered set where active = &#63; and companyId = &#63;.
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByStatusAndCompany_First(boolean active,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByStatusAndCompany_First(active,
				companyId, orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ category in the ordered set where active = &#63; and companyId = &#63;.
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByStatusAndCompany_First(boolean active,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VBPQ_Category> list = findByStatusAndCompany(active, companyId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where active = &#63; and companyId = &#63;.
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByStatusAndCompany_Last(boolean active,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByStatusAndCompany_Last(active,
				companyId, orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where active = &#63; and companyId = &#63;.
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByStatusAndCompany_Last(boolean active,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStatusAndCompany(active, companyId);

		List<VBPQ_Category> list = findByStatusAndCompany(active, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where active = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current v b p q_ category
	 * @param active the active
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category[] findByStatusAndCompany_PrevAndNext(long categoryId,
		boolean active, long companyId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Category[] array = new VBPQ_CategoryImpl[3];

			array[0] = getByStatusAndCompany_PrevAndNext(session,
					vbpq_Category, active, companyId, orderByComparator, true);

			array[1] = vbpq_Category;

			array[2] = getByStatusAndCompany_PrevAndNext(session,
					vbpq_Category, active, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Category getByStatusAndCompany_PrevAndNext(Session session,
		VBPQ_Category vbpq_Category, boolean active, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

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
			query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ categories where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @return the matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByStatusAndGroup(boolean active, long groupId)
		throws SystemException {
		return findByStatusAndGroup(active, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ categories where active = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @return the range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByStatusAndGroup(boolean active,
		long groupId, int start, int end) throws SystemException {
		return findByStatusAndGroup(active, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ categories where active = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findByStatusAndGroup(boolean active,
		long groupId, int start, int end, OrderByComparator orderByComparator)
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

		List<VBPQ_Category> list = (List<VBPQ_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VBPQ_Category vbpq_Category : list) {
				if ((active != vbpq_Category.getActive()) ||
						(groupId != vbpq_Category.getGroupId())) {
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

			query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_ACTIVE_2);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(groupId);

				list = (List<VBPQ_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first v b p q_ category in the ordered set where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByStatusAndGroup_First(boolean active,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByStatusAndGroup_First(active,
				groupId, orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the first v b p q_ category in the ordered set where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByStatusAndGroup_First(boolean active,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VBPQ_Category> list = findByStatusAndGroup(active, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category findByStatusAndGroup_Last(boolean active,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = fetchByStatusAndGroup_Last(active,
				groupId, orderByComparator);

		if (vbpq_Category != null) {
			return vbpq_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVBPQ_CategoryException(msg.toString());
	}

	/**
	 * Returns the last v b p q_ category in the ordered set where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category fetchByStatusAndGroup_Last(boolean active,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStatusAndGroup(active, groupId);

		List<VBPQ_Category> list = findByStatusAndGroup(active, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where active = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current v b p q_ category
	 * @param active the active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category[] findByStatusAndGroup_PrevAndNext(long categoryId,
		boolean active, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		VBPQ_Category vbpq_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Category[] array = new VBPQ_CategoryImpl[3];

			array[0] = getByStatusAndGroup_PrevAndNext(session, vbpq_Category,
					active, groupId, orderByComparator, true);

			array[1] = vbpq_Category;

			array[2] = getByStatusAndGroup_PrevAndNext(session, vbpq_Category,
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

	protected VBPQ_Category getByStatusAndGroup_PrevAndNext(Session session,
		VBPQ_Category vbpq_Category, boolean active, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VBPQ_CATEGORY_WHERE);

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
			query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ categories that the user has permission to view where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @return the matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> filterFindByStatusAndGroup(boolean active,
		long groupId) throws SystemException {
		return filterFindByStatusAndGroup(active, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ categories that the user has permission to view where active = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @return the range of matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> filterFindByStatusAndGroup(boolean active,
		long groupId, int start, int end) throws SystemException {
		return filterFindByStatusAndGroup(active, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ categories that the user has permissions to view where active = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> filterFindByStatusAndGroup(boolean active,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSANDGROUP_ACTIVE_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_CategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_CategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(active);

			qPos.add(groupId);

			return (List<VBPQ_Category>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set of v b p q_ categories that the user has permission to view where active = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current v b p q_ category
	 * @param active the active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v b p q_ category
	 * @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VBPQ_Category[] filterFindByStatusAndGroup_PrevAndNext(
		long categoryId, boolean active, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVBPQ_CategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByStatusAndGroup_PrevAndNext(categoryId, active,
				groupId, orderByComparator);
		}

		VBPQ_Category vbpq_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VBPQ_Category[] array = new VBPQ_CategoryImpl[3];

			array[0] = filterGetByStatusAndGroup_PrevAndNext(session,
					vbpq_Category, active, groupId, orderByComparator, true);

			array[1] = vbpq_Category;

			array[2] = filterGetByStatusAndGroup_PrevAndNext(session,
					vbpq_Category, active, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VBPQ_Category filterGetByStatusAndGroup_PrevAndNext(
		Session session, VBPQ_Category vbpq_Category, boolean active,
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
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSANDGROUP_ACTIVE_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VBPQ_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VBPQ_CategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VBPQ_CategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vbpq_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VBPQ_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v b p q_ categories.
	 *
	 * @return the v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v b p q_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @return the range of v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v b p q_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of v b p q_ categories
	 * @param end the upper bound of the range of v b p q_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VBPQ_Category> findAll(int start, int end,
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

		List<VBPQ_Category> list = (List<VBPQ_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VBPQ_CATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VBPQ_CATEGORY.concat(VBPQ_CategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VBPQ_Category>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VBPQ_Category>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the v b p q_ categories where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (VBPQ_Category vbpq_Category : findByCompany(companyId)) {
			remove(vbpq_Category);
		}
	}

	/**
	 * Removes all the v b p q_ categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (VBPQ_Category vbpq_Category : findByGroup(groupId)) {
			remove(vbpq_Category);
		}
	}

	/**
	 * Removes all the v b p q_ categories where parentId = &#63; and companyId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentAndCompany(long parentId, long companyId)
		throws SystemException {
		for (VBPQ_Category vbpq_Category : findByParentAndCompany(parentId,
				companyId)) {
			remove(vbpq_Category);
		}
	}

	/**
	 * Removes all the v b p q_ categories where parentId = &#63; and groupId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentAndGroup(long parentId, long groupId)
		throws SystemException {
		for (VBPQ_Category vbpq_Category : findByParentAndGroup(parentId,
				groupId)) {
			remove(vbpq_Category);
		}
	}

	/**
	 * Removes all the v b p q_ categories where typeId = &#63; and companyId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTypeAndCompany(int typeId, long companyId)
		throws SystemException {
		for (VBPQ_Category vbpq_Category : findByTypeAndCompany(typeId,
				companyId)) {
			remove(vbpq_Category);
		}
	}

	/**
	 * Removes all the v b p q_ categories where typeId = &#63; and groupId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTypeAndGroup(int typeId, long groupId)
		throws SystemException {
		for (VBPQ_Category vbpq_Category : findByTypeAndGroup(typeId, groupId)) {
			remove(vbpq_Category);
		}
	}

	/**
	 * Removes all the v b p q_ categories where active = &#63; and companyId = &#63; from the database.
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusAndCompany(boolean active, long companyId)
		throws SystemException {
		for (VBPQ_Category vbpq_Category : findByStatusAndCompany(active,
				companyId)) {
			remove(vbpq_Category);
		}
	}

	/**
	 * Removes all the v b p q_ categories where active = &#63; and groupId = &#63; from the database.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusAndGroup(boolean active, long groupId)
		throws SystemException {
		for (VBPQ_Category vbpq_Category : findByStatusAndGroup(active, groupId)) {
			remove(vbpq_Category);
		}
	}

	/**
	 * Removes all the v b p q_ categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VBPQ_Category vbpq_Category : findAll()) {
			remove(vbpq_Category);
		}
	}

	/**
	 * Returns the number of v b p q_ categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VBPQ_CATEGORY_WHERE);

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
	 * Returns the number of v b p q_ categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VBPQ_CATEGORY_WHERE);

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
	 * Returns the number of v b p q_ categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_VBPQ_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Category.class.getName(),
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
	 * Returns the number of v b p q_ categories where parentId = &#63; and companyId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @return the number of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentAndCompany(long parentId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { parentId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_PARENTID_2);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v b p q_ categories where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentAndGroup(long parentId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { parentId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v b p q_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByParentAndGroup(long parentId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByParentAndGroup(parentId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_VBPQ_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(parentId);

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
	 * Returns the number of v b p q_ categories where typeId = &#63; and companyId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param companyId the company ID
	 * @return the number of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTypeAndCompany(int typeId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { typeId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TYPEANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDCOMPANY_TYPEID_2);

			query.append(_FINDER_COLUMN_TYPEANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPEANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v b p q_ categories where typeId = &#63; and groupId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTypeAndGroup(int typeId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { typeId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TYPEANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDGROUP_TYPEID_2);

			query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPEANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v b p q_ categories that the user has permission to view where typeId = &#63; and groupId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByTypeAndGroup(int typeId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByTypeAndGroup(typeId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_VBPQ_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_TYPEID_2);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(typeId);

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
	 * Returns the number of v b p q_ categories where active = &#63; and companyId = &#63;.
	 *
	 * @param active the active
	 * @param companyId the company ID
	 * @return the number of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusAndCompany(boolean active, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { active, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_CATEGORY_WHERE);

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
	 * Returns the number of v b p q_ categories where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusAndGroup(boolean active, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { active, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VBPQ_CATEGORY_WHERE);

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
	 * Returns the number of v b p q_ categories that the user has permission to view where active = &#63; and groupId = &#63;.
	 *
	 * @param active the active
	 * @param groupId the group ID
	 * @return the number of matching v b p q_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByStatusAndGroup(boolean active, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByStatusAndGroup(active, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_VBPQ_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_ACTIVE_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VBPQ_Category.class.getName(),
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
	 * Returns the number of v b p q_ categories.
	 *
	 * @return the number of v b p q_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VBPQ_CATEGORY);

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
	 * Initializes the v b p q_ category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.vbpq.model.VBPQ_Category")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VBPQ_Category>> listenersList = new ArrayList<ModelListener<VBPQ_Category>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VBPQ_Category>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VBPQ_CategoryImpl.class.getName());
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
	private static final String _SQL_SELECT_VBPQ_CATEGORY = "SELECT vbpq_Category FROM VBPQ_Category vbpq_Category";
	private static final String _SQL_SELECT_VBPQ_CATEGORY_WHERE = "SELECT vbpq_Category FROM VBPQ_Category vbpq_Category WHERE ";
	private static final String _SQL_COUNT_VBPQ_CATEGORY = "SELECT COUNT(vbpq_Category) FROM VBPQ_Category vbpq_Category";
	private static final String _SQL_COUNT_VBPQ_CATEGORY_WHERE = "SELECT COUNT(vbpq_Category) FROM VBPQ_Category vbpq_Category WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "vbpq_Category.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "vbpq_Category.groupId = ?";
	private static final String _FINDER_COLUMN_PARENTANDCOMPANY_PARENTID_2 = "vbpq_Category.parentId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2 = "vbpq_Category.companyId = ?";
	private static final String _FINDER_COLUMN_PARENTANDGROUP_PARENTID_2 = "vbpq_Category.parentId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTANDGROUP_GROUPID_2 = "vbpq_Category.groupId = ?";
	private static final String _FINDER_COLUMN_TYPEANDCOMPANY_TYPEID_2 = "vbpq_Category.typeId = ? AND ";
	private static final String _FINDER_COLUMN_TYPEANDCOMPANY_COMPANYID_2 = "vbpq_Category.companyId = ?";
	private static final String _FINDER_COLUMN_TYPEANDGROUP_TYPEID_2 = "vbpq_Category.typeId = ? AND ";
	private static final String _FINDER_COLUMN_TYPEANDGROUP_GROUPID_2 = "vbpq_Category.groupId = ?";
	private static final String _FINDER_COLUMN_STATUSANDCOMPANY_ACTIVE_2 = "vbpq_Category.active = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2 = "vbpq_Category.companyId = ?";
	private static final String _FINDER_COLUMN_STATUSANDGROUP_ACTIVE_2 = "vbpq_Category.active = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDGROUP_GROUPID_2 = "vbpq_Category.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "vbpq_Category.categoryId";
	private static final String _FILTER_SQL_SELECT_VBPQ_CATEGORY_WHERE = "SELECT DISTINCT {vbpq_Category.*} FROM vbpq_category vbpq_Category WHERE ";
	private static final String _FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {vbpq_category.*} FROM (SELECT DISTINCT vbpq_Category.categoryId FROM vbpq_category vbpq_Category WHERE ";
	private static final String _FILTER_SQL_SELECT_VBPQ_CATEGORY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN vbpq_category ON TEMP_TABLE.categoryId = vbpq_category.categoryId";
	private static final String _FILTER_SQL_COUNT_VBPQ_CATEGORY_WHERE = "SELECT COUNT(DISTINCT vbpq_Category.categoryId) AS COUNT_VALUE FROM vbpq_category vbpq_Category WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "vbpq_Category";
	private static final String _FILTER_ENTITY_TABLE = "vbpq_category";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vbpq_Category.";
	private static final String _ORDER_BY_ENTITY_TABLE = "vbpq_category.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VBPQ_Category exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VBPQ_Category exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VBPQ_CategoryPersistenceImpl.class);
	private static VBPQ_Category _nullVBPQ_Category = new VBPQ_CategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VBPQ_Category> toCacheModel() {
				return _nullVBPQ_CategoryCacheModel;
			}
		};

	private static CacheModel<VBPQ_Category> _nullVBPQ_CategoryCacheModel = new CacheModel<VBPQ_Category>() {
			public VBPQ_Category toEntityModel() {
				return _nullVBPQ_Category;
			}
		};
}