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

import com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;
import com.portal_egov.portlet.tthc.model.TTHC_Category;
import com.portal_egov.portlet.tthc.model.impl.TTHC_CategoryImpl;
import com.portal_egov.portlet.tthc.model.impl.TTHC_CategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the t t h c_ category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see TTHC_CategoryPersistence
 * @see TTHC_CategoryUtil
 * @generated
 */
public class TTHC_CategoryPersistenceImpl extends BasePersistenceImpl<TTHC_Category>
	implements TTHC_CategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TTHC_CategoryUtil} to access the t t h c_ category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TTHC_CategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED,
			TTHC_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED,
			TTHC_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompany", new String[] { Long.class.getName() },
			TTHC_CategoryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED,
			TTHC_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED,
			TTHC_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroup", new String[] { Long.class.getName() },
			TTHC_CategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDCOMPANY =
		new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED,
			TTHC_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY =
		new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED,
			TTHC_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC_CategoryModelImpl.PARENTID_COLUMN_BITMASK |
			TTHC_CategoryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTANDCOMPANY = new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDGROUP =
		new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED,
			TTHC_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP =
		new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED,
			TTHC_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTHC_CategoryModelImpl.PARENTID_COLUMN_BITMASK |
			TTHC_CategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTANDGROUP = new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDCOMPANY =
		new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED,
			TTHC_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTypeAndCompany",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY =
		new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED,
			TTHC_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTypeAndCompany",
			new String[] { Integer.class.getName(), Long.class.getName() },
			TTHC_CategoryModelImpl.CATEGORYTYPEID_COLUMN_BITMASK |
			TTHC_CategoryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEANDCOMPANY = new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeAndCompany",
			new String[] { Integer.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDGROUP =
		new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED,
			TTHC_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTypeAndGroup",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP =
		new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED,
			TTHC_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTypeAndGroup",
			new String[] { Integer.class.getName(), Long.class.getName() },
			TTHC_CategoryModelImpl.CATEGORYTYPEID_COLUMN_BITMASK |
			TTHC_CategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEANDGROUP = new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeAndGroup",
			new String[] { Integer.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED,
			TTHC_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED,
			TTHC_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the t t h c_ category in the entity cache if it is enabled.
	 *
	 * @param tthc_Category the t t h c_ category
	 */
	public void cacheResult(TTHC_Category tthc_Category) {
		EntityCacheUtil.putResult(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryImpl.class, tthc_Category.getPrimaryKey(),
			tthc_Category);

		tthc_Category.resetOriginalValues();
	}

	/**
	 * Caches the t t h c_ categories in the entity cache if it is enabled.
	 *
	 * @param tthc_Categories the t t h c_ categories
	 */
	public void cacheResult(List<TTHC_Category> tthc_Categories) {
		for (TTHC_Category tthc_Category : tthc_Categories) {
			if (EntityCacheUtil.getResult(
						TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
						TTHC_CategoryImpl.class, tthc_Category.getPrimaryKey()) == null) {
				cacheResult(tthc_Category);
			}
			else {
				tthc_Category.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all t t h c_ categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TTHC_CategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TTHC_CategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the t t h c_ category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TTHC_Category tthc_Category) {
		EntityCacheUtil.removeResult(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryImpl.class, tthc_Category.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TTHC_Category> tthc_Categories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TTHC_Category tthc_Category : tthc_Categories) {
			EntityCacheUtil.removeResult(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				TTHC_CategoryImpl.class, tthc_Category.getPrimaryKey());
		}
	}

	/**
	 * Creates a new t t h c_ category with the primary key. Does not add the t t h c_ category to the database.
	 *
	 * @param categoryId the primary key for the new t t h c_ category
	 * @return the new t t h c_ category
	 */
	public TTHC_Category create(long categoryId) {
		TTHC_Category tthc_Category = new TTHC_CategoryImpl();

		tthc_Category.setNew(true);
		tthc_Category.setPrimaryKey(categoryId);

		return tthc_Category;
	}

	/**
	 * Removes the t t h c_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the t t h c_ category
	 * @return the t t h c_ category that was removed
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category remove(long categoryId)
		throws NoSuchTTHC_CategoryException, SystemException {
		return remove(Long.valueOf(categoryId));
	}

	/**
	 * Removes the t t h c_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the t t h c_ category
	 * @return the t t h c_ category that was removed
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC_Category remove(Serializable primaryKey)
		throws NoSuchTTHC_CategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TTHC_Category tthc_Category = (TTHC_Category)session.get(TTHC_CategoryImpl.class,
					primaryKey);

			if (tthc_Category == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTTHC_CategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tthc_Category);
		}
		catch (NoSuchTTHC_CategoryException nsee) {
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
	protected TTHC_Category removeImpl(TTHC_Category tthc_Category)
		throws SystemException {
		tthc_Category = toUnwrappedModel(tthc_Category);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tthc_Category);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tthc_Category);

		return tthc_Category;
	}

	@Override
	public TTHC_Category updateImpl(
		com.portal_egov.portlet.tthc.model.TTHC_Category tthc_Category,
		boolean merge) throws SystemException {
		tthc_Category = toUnwrappedModel(tthc_Category);

		boolean isNew = tthc_Category.isNew();

		TTHC_CategoryModelImpl tthc_CategoryModelImpl = (TTHC_CategoryModelImpl)tthc_Category;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tthc_Category, merge);

			tthc_Category.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TTHC_CategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tthc_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_CategoryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(tthc_CategoryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((tthc_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_CategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(tthc_CategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((tthc_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_CategoryModelImpl.getOriginalParentId()),
						Long.valueOf(tthc_CategoryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(tthc_CategoryModelImpl.getParentId()),
						Long.valueOf(tthc_CategoryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY,
					args);
			}

			if ((tthc_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tthc_CategoryModelImpl.getOriginalParentId()),
						Long.valueOf(tthc_CategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(tthc_CategoryModelImpl.getParentId()),
						Long.valueOf(tthc_CategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP,
					args);
			}

			if ((tthc_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(tthc_CategoryModelImpl.getOriginalCategoryTypeId()),
						Long.valueOf(tthc_CategoryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY,
					args);

				args = new Object[] {
						Integer.valueOf(tthc_CategoryModelImpl.getCategoryTypeId()),
						Long.valueOf(tthc_CategoryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY,
					args);
			}

			if ((tthc_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(tthc_CategoryModelImpl.getOriginalCategoryTypeId()),
						Long.valueOf(tthc_CategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP,
					args);

				args = new Object[] {
						Integer.valueOf(tthc_CategoryModelImpl.getCategoryTypeId()),
						Long.valueOf(tthc_CategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			TTHC_CategoryImpl.class, tthc_Category.getPrimaryKey(),
			tthc_Category);

		return tthc_Category;
	}

	protected TTHC_Category toUnwrappedModel(TTHC_Category tthc_Category) {
		if (tthc_Category instanceof TTHC_CategoryImpl) {
			return tthc_Category;
		}

		TTHC_CategoryImpl tthc_CategoryImpl = new TTHC_CategoryImpl();

		tthc_CategoryImpl.setNew(tthc_Category.isNew());
		tthc_CategoryImpl.setPrimaryKey(tthc_Category.getPrimaryKey());

		tthc_CategoryImpl.setCategoryId(tthc_Category.getCategoryId());
		tthc_CategoryImpl.setParentId(tthc_Category.getParentId());
		tthc_CategoryImpl.setCategoryTypeId(tthc_Category.getCategoryTypeId());
		tthc_CategoryImpl.setCompanyId(tthc_Category.getCompanyId());
		tthc_CategoryImpl.setGroupId(tthc_Category.getGroupId());
		tthc_CategoryImpl.setUserId(tthc_Category.getUserId());
		tthc_CategoryImpl.setCategoryName(tthc_Category.getCategoryName());
		tthc_CategoryImpl.setCategoryDesc(tthc_Category.getCategoryDesc());
		tthc_CategoryImpl.setCreateDate(tthc_Category.getCreateDate());
		tthc_CategoryImpl.setModifiedDate(tthc_Category.getModifiedDate());
		tthc_CategoryImpl.setDisplayPriority(tthc_Category.getDisplayPriority());

		return tthc_CategoryImpl;
	}

	/**
	 * Returns the t t h c_ category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the t t h c_ category
	 * @return the t t h c_ category
	 * @throws com.liferay.portal.NoSuchModelException if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC_Category findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the t t h c_ category with the primary key or throws a {@link com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the t t h c_ category
	 * @return the t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category findByPrimaryKey(long categoryId)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = fetchByPrimaryKey(categoryId);

		if (tthc_Category == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
			}

			throw new NoSuchTTHC_CategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryId);
		}

		return tthc_Category;
	}

	/**
	 * Returns the t t h c_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the t t h c_ category
	 * @return the t t h c_ category, or <code>null</code> if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TTHC_Category fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the t t h c_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the t t h c_ category
	 * @return the t t h c_ category, or <code>null</code> if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category fetchByPrimaryKey(long categoryId)
		throws SystemException {
		TTHC_Category tthc_Category = (TTHC_Category)EntityCacheUtil.getResult(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				TTHC_CategoryImpl.class, categoryId);

		if (tthc_Category == _nullTTHC_Category) {
			return null;
		}

		if (tthc_Category == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tthc_Category = (TTHC_Category)session.get(TTHC_CategoryImpl.class,
						Long.valueOf(categoryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tthc_Category != null) {
					cacheResult(tthc_Category);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TTHC_CategoryModelImpl.ENTITY_CACHE_ENABLED,
						TTHC_CategoryImpl.class, categoryId, _nullTTHC_Category);
				}

				closeSession(session);
			}
		}

		return tthc_Category;
	}

	/**
	 * Returns all the t t h c_ categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the t t h c_ categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @return the range of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByCompany(long companyId, int start,
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

		List<TTHC_Category> list = (List<TTHC_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Category tthc_Category : list) {
				if ((companyId != tthc_Category.getCompanyId())) {
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

			query.append(_SQL_SELECT_TTHC_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<TTHC_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first t t h c_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = fetchByCompany_First(companyId,
				orderByComparator);

		if (tthc_Category != null) {
			return tthc_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_CategoryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TTHC_Category> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = fetchByCompany_Last(companyId,
				orderByComparator);

		if (tthc_Category != null) {
			return tthc_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_CategoryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<TTHC_Category> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set where companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current t t h c_ category
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category[] findByCompany_PrevAndNext(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Category[] array = new TTHC_CategoryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, tthc_Category,
					companyId, orderByComparator, true);

			array[1] = tthc_Category;

			array[2] = getByCompany_PrevAndNext(session, tthc_Category,
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

	protected TTHC_Category getByCompany_PrevAndNext(Session session,
		TTHC_Category tthc_Category, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_CATEGORY_WHERE);

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
			query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @return the range of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByGroup(long groupId, int start, int end,
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

		List<TTHC_Category> list = (List<TTHC_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Category tthc_Category : list) {
				if ((groupId != tthc_Category.getGroupId())) {
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

			query.append(_SQL_SELECT_TTHC_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<TTHC_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first t t h c_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = fetchByGroup_First(groupId,
				orderByComparator);

		if (tthc_Category != null) {
			return tthc_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_CategoryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TTHC_Category> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = fetchByGroup_Last(groupId,
				orderByComparator);

		if (tthc_Category != null) {
			return tthc_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_CategoryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<TTHC_Category> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current t t h c_ category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category[] findByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Category[] array = new TTHC_CategoryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, tthc_Category, groupId,
					orderByComparator, true);

			array[1] = tthc_Category;

			array[2] = getByGroup_PrevAndNext(session, tthc_Category, groupId,
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

	protected TTHC_Category getByGroup_PrevAndNext(Session session,
		TTHC_Category tthc_Category, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_CATEGORY_WHERE);

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
			query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching t t h c_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the t t h c_ categories that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @return the range of matching t t h c_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ categories that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_CategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TTHC_CategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<TTHC_Category>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set of t t h c_ categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current t t h c_ category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category[] filterFindByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(categoryId, groupId,
				orderByComparator);
		}

		TTHC_Category tthc_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Category[] array = new TTHC_CategoryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, tthc_Category,
					groupId, orderByComparator, true);

			array[1] = tthc_Category;

			array[2] = filterGetByGroup_PrevAndNext(session, tthc_Category,
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

	protected TTHC_Category filterGetByGroup_PrevAndNext(Session session,
		TTHC_Category tthc_Category, long groupId,
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
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_CategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TTHC_CategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ categories where parentId = &#63; and companyId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @return the matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByParentAndCompany(long parentId,
		long companyId) throws SystemException {
		return findByParentAndCompany(parentId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ categories where parentId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @return the range of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByParentAndCompany(long parentId,
		long companyId, int start, int end) throws SystemException {
		return findByParentAndCompany(parentId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ categories where parentId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByParentAndCompany(long parentId,
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

		List<TTHC_Category> list = (List<TTHC_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Category tthc_Category : list) {
				if ((parentId != tthc_Category.getParentId()) ||
						(companyId != tthc_Category.getCompanyId())) {
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

			query.append(_SQL_SELECT_TTHC_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_PARENTID_2);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				qPos.add(companyId);

				list = (List<TTHC_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first t t h c_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category findByParentAndCompany_First(long parentId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = fetchByParentAndCompany_First(parentId,
				companyId, orderByComparator);

		if (tthc_Category != null) {
			return tthc_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_CategoryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category fetchByParentAndCompany_First(long parentId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Category> list = findByParentAndCompany(parentId, companyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category findByParentAndCompany_Last(long parentId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = fetchByParentAndCompany_Last(parentId,
				companyId, orderByComparator);

		if (tthc_Category != null) {
			return tthc_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_CategoryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category fetchByParentAndCompany_Last(long parentId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentAndCompany(parentId, companyId);

		List<TTHC_Category> list = findByParentAndCompany(parentId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current t t h c_ category
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category[] findByParentAndCompany_PrevAndNext(long categoryId,
		long parentId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Category[] array = new TTHC_CategoryImpl[3];

			array[0] = getByParentAndCompany_PrevAndNext(session,
					tthc_Category, parentId, companyId, orderByComparator, true);

			array[1] = tthc_Category;

			array[2] = getByParentAndCompany_PrevAndNext(session,
					tthc_Category, parentId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Category getByParentAndCompany_PrevAndNext(Session session,
		TTHC_Category tthc_Category, long parentId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_CATEGORY_WHERE);

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
			query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ categories where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @return the matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByParentAndGroup(long parentId, long groupId)
		throws SystemException {
		return findByParentAndGroup(parentId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ categories where parentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @return the range of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByParentAndGroup(long parentId,
		long groupId, int start, int end) throws SystemException {
		return findByParentAndGroup(parentId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ categories where parentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByParentAndGroup(long parentId,
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

		List<TTHC_Category> list = (List<TTHC_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Category tthc_Category : list) {
				if ((parentId != tthc_Category.getParentId()) ||
						(groupId != tthc_Category.getGroupId())) {
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

			query.append(_SQL_SELECT_TTHC_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				qPos.add(groupId);

				list = (List<TTHC_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first t t h c_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category findByParentAndGroup_First(long parentId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = fetchByParentAndGroup_First(parentId,
				groupId, orderByComparator);

		if (tthc_Category != null) {
			return tthc_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_CategoryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category fetchByParentAndGroup_First(long parentId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Category> list = findByParentAndGroup(parentId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category findByParentAndGroup_Last(long parentId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = fetchByParentAndGroup_Last(parentId,
				groupId, orderByComparator);

		if (tthc_Category != null) {
			return tthc_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_CategoryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category fetchByParentAndGroup_Last(long parentId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentAndGroup(parentId, groupId);

		List<TTHC_Category> list = findByParentAndGroup(parentId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current t t h c_ category
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category[] findByParentAndGroup_PrevAndNext(long categoryId,
		long parentId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Category[] array = new TTHC_CategoryImpl[3];

			array[0] = getByParentAndGroup_PrevAndNext(session, tthc_Category,
					parentId, groupId, orderByComparator, true);

			array[1] = tthc_Category;

			array[2] = getByParentAndGroup_PrevAndNext(session, tthc_Category,
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

	protected TTHC_Category getByParentAndGroup_PrevAndNext(Session session,
		TTHC_Category tthc_Category, long parentId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_CATEGORY_WHERE);

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
			query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @return the matching t t h c_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> filterFindByParentAndGroup(long parentId,
		long groupId) throws SystemException {
		return filterFindByParentAndGroup(parentId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @return the range of matching t t h c_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> filterFindByParentAndGroup(long parentId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByParentAndGroup(parentId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ categories that the user has permissions to view where parentId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> filterFindByParentAndGroup(long parentId,
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
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_CategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TTHC_CategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(parentId);

			qPos.add(groupId);

			return (List<TTHC_Category>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set of t t h c_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current t t h c_ category
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category[] filterFindByParentAndGroup_PrevAndNext(
		long categoryId, long parentId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParentAndGroup_PrevAndNext(categoryId, parentId,
				groupId, orderByComparator);
		}

		TTHC_Category tthc_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Category[] array = new TTHC_CategoryImpl[3];

			array[0] = filterGetByParentAndGroup_PrevAndNext(session,
					tthc_Category, parentId, groupId, orderByComparator, true);

			array[1] = tthc_Category;

			array[2] = filterGetByParentAndGroup_PrevAndNext(session,
					tthc_Category, parentId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Category filterGetByParentAndGroup_PrevAndNext(
		Session session, TTHC_Category tthc_Category, long parentId,
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
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_CategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TTHC_CategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ categories where categoryTypeId = &#63; and companyId = &#63;.
	 *
	 * @param categoryTypeId the category type ID
	 * @param companyId the company ID
	 * @return the matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByTypeAndCompany(int categoryTypeId,
		long companyId) throws SystemException {
		return findByTypeAndCompany(categoryTypeId, companyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ categories where categoryTypeId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryTypeId the category type ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @return the range of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByTypeAndCompany(int categoryTypeId,
		long companyId, int start, int end) throws SystemException {
		return findByTypeAndCompany(categoryTypeId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ categories where categoryTypeId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryTypeId the category type ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByTypeAndCompany(int categoryTypeId,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY;
			finderArgs = new Object[] { categoryTypeId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDCOMPANY;
			finderArgs = new Object[] {
					categoryTypeId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Category> list = (List<TTHC_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Category tthc_Category : list) {
				if ((categoryTypeId != tthc_Category.getCategoryTypeId()) ||
						(companyId != tthc_Category.getCompanyId())) {
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

			query.append(_SQL_SELECT_TTHC_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDCOMPANY_CATEGORYTYPEID_2);

			query.append(_FINDER_COLUMN_TYPEANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryTypeId);

				qPos.add(companyId);

				list = (List<TTHC_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first t t h c_ category in the ordered set where categoryTypeId = &#63; and companyId = &#63;.
	 *
	 * @param categoryTypeId the category type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category findByTypeAndCompany_First(int categoryTypeId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = fetchByTypeAndCompany_First(categoryTypeId,
				companyId, orderByComparator);

		if (tthc_Category != null) {
			return tthc_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryTypeId=");
		msg.append(categoryTypeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_CategoryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ category in the ordered set where categoryTypeId = &#63; and companyId = &#63;.
	 *
	 * @param categoryTypeId the category type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category fetchByTypeAndCompany_First(int categoryTypeId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Category> list = findByTypeAndCompany(categoryTypeId,
				companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ category in the ordered set where categoryTypeId = &#63; and companyId = &#63;.
	 *
	 * @param categoryTypeId the category type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category findByTypeAndCompany_Last(int categoryTypeId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = fetchByTypeAndCompany_Last(categoryTypeId,
				companyId, orderByComparator);

		if (tthc_Category != null) {
			return tthc_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryTypeId=");
		msg.append(categoryTypeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_CategoryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ category in the ordered set where categoryTypeId = &#63; and companyId = &#63;.
	 *
	 * @param categoryTypeId the category type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category fetchByTypeAndCompany_Last(int categoryTypeId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTypeAndCompany(categoryTypeId, companyId);

		List<TTHC_Category> list = findByTypeAndCompany(categoryTypeId,
				companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set where categoryTypeId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current t t h c_ category
	 * @param categoryTypeId the category type ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category[] findByTypeAndCompany_PrevAndNext(long categoryId,
		int categoryTypeId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Category[] array = new TTHC_CategoryImpl[3];

			array[0] = getByTypeAndCompany_PrevAndNext(session, tthc_Category,
					categoryTypeId, companyId, orderByComparator, true);

			array[1] = tthc_Category;

			array[2] = getByTypeAndCompany_PrevAndNext(session, tthc_Category,
					categoryTypeId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Category getByTypeAndCompany_PrevAndNext(Session session,
		TTHC_Category tthc_Category, int categoryTypeId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_TYPEANDCOMPANY_CATEGORYTYPEID_2);

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
			query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryTypeId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ categories where categoryTypeId = &#63; and groupId = &#63;.
	 *
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @return the matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByTypeAndGroup(int categoryTypeId,
		long groupId) throws SystemException {
		return findByTypeAndGroup(categoryTypeId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ categories where categoryTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @return the range of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByTypeAndGroup(int categoryTypeId,
		long groupId, int start, int end) throws SystemException {
		return findByTypeAndGroup(categoryTypeId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ categories where categoryTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findByTypeAndGroup(int categoryTypeId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP;
			finderArgs = new Object[] { categoryTypeId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDGROUP;
			finderArgs = new Object[] {
					categoryTypeId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<TTHC_Category> list = (List<TTHC_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TTHC_Category tthc_Category : list) {
				if ((categoryTypeId != tthc_Category.getCategoryTypeId()) ||
						(groupId != tthc_Category.getGroupId())) {
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

			query.append(_SQL_SELECT_TTHC_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDGROUP_CATEGORYTYPEID_2);

			query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryTypeId);

				qPos.add(groupId);

				list = (List<TTHC_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first t t h c_ category in the ordered set where categoryTypeId = &#63; and groupId = &#63;.
	 *
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category findByTypeAndGroup_First(int categoryTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = fetchByTypeAndGroup_First(categoryTypeId,
				groupId, orderByComparator);

		if (tthc_Category != null) {
			return tthc_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryTypeId=");
		msg.append(categoryTypeId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_CategoryException(msg.toString());
	}

	/**
	 * Returns the first t t h c_ category in the ordered set where categoryTypeId = &#63; and groupId = &#63;.
	 *
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category fetchByTypeAndGroup_First(int categoryTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TTHC_Category> list = findByTypeAndGroup(categoryTypeId, groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t t h c_ category in the ordered set where categoryTypeId = &#63; and groupId = &#63;.
	 *
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category findByTypeAndGroup_Last(int categoryTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = fetchByTypeAndGroup_Last(categoryTypeId,
				groupId, orderByComparator);

		if (tthc_Category != null) {
			return tthc_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryTypeId=");
		msg.append(categoryTypeId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTTHC_CategoryException(msg.toString());
	}

	/**
	 * Returns the last t t h c_ category in the ordered set where categoryTypeId = &#63; and groupId = &#63;.
	 *
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category fetchByTypeAndGroup_Last(int categoryTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTypeAndGroup(categoryTypeId, groupId);

		List<TTHC_Category> list = findByTypeAndGroup(categoryTypeId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set where categoryTypeId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current t t h c_ category
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category[] findByTypeAndGroup_PrevAndNext(long categoryId,
		int categoryTypeId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		TTHC_Category tthc_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Category[] array = new TTHC_CategoryImpl[3];

			array[0] = getByTypeAndGroup_PrevAndNext(session, tthc_Category,
					categoryTypeId, groupId, orderByComparator, true);

			array[1] = tthc_Category;

			array[2] = getByTypeAndGroup_PrevAndNext(session, tthc_Category,
					categoryTypeId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTHC_Category getByTypeAndGroup_PrevAndNext(Session session,
		TTHC_Category tthc_Category, int categoryTypeId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTHC_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_CATEGORYTYPEID_2);

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
			query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryTypeId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ categories that the user has permission to view where categoryTypeId = &#63; and groupId = &#63;.
	 *
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @return the matching t t h c_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> filterFindByTypeAndGroup(int categoryTypeId,
		long groupId) throws SystemException {
		return filterFindByTypeAndGroup(categoryTypeId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ categories that the user has permission to view where categoryTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @return the range of matching t t h c_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> filterFindByTypeAndGroup(int categoryTypeId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByTypeAndGroup(categoryTypeId, groupId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ categories that the user has permissions to view where categoryTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t t h c_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> filterFindByTypeAndGroup(int categoryTypeId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByTypeAndGroup(categoryTypeId, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_TYPEANDGROUP_CATEGORYTYPEID_2);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_CategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TTHC_CategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(categoryTypeId);

			qPos.add(groupId);

			return (List<TTHC_Category>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set of t t h c_ categories that the user has permission to view where categoryTypeId = &#63; and groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current t t h c_ category
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t t h c_ category
	 * @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TTHC_Category[] filterFindByTypeAndGroup_PrevAndNext(
		long categoryId, int categoryTypeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTTHC_CategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByTypeAndGroup_PrevAndNext(categoryId, categoryTypeId,
				groupId, orderByComparator);
		}

		TTHC_Category tthc_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			TTHC_Category[] array = new TTHC_CategoryImpl[3];

			array[0] = filterGetByTypeAndGroup_PrevAndNext(session,
					tthc_Category, categoryTypeId, groupId, orderByComparator,
					true);

			array[1] = tthc_Category;

			array[2] = filterGetByTypeAndGroup_PrevAndNext(session,
					tthc_Category, categoryTypeId, groupId, orderByComparator,
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

	protected TTHC_Category filterGetByTypeAndGroup_PrevAndNext(
		Session session, TTHC_Category tthc_Category, int categoryTypeId,
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
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_TYPEANDGROUP_CATEGORYTYPEID_2);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TTHC_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TTHC_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TTHC_CategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TTHC_CategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryTypeId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tthc_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTHC_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t t h c_ categories.
	 *
	 * @return the t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t t h c_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @return the range of t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the t t h c_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of t t h c_ categories
	 * @param end the upper bound of the range of t t h c_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<TTHC_Category> findAll(int start, int end,
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

		List<TTHC_Category> list = (List<TTHC_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TTHC_CATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TTHC_CATEGORY.concat(TTHC_CategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TTHC_Category>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TTHC_Category>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the t t h c_ categories where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (TTHC_Category tthc_Category : findByCompany(companyId)) {
			remove(tthc_Category);
		}
	}

	/**
	 * Removes all the t t h c_ categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (TTHC_Category tthc_Category : findByGroup(groupId)) {
			remove(tthc_Category);
		}
	}

	/**
	 * Removes all the t t h c_ categories where parentId = &#63; and companyId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentAndCompany(long parentId, long companyId)
		throws SystemException {
		for (TTHC_Category tthc_Category : findByParentAndCompany(parentId,
				companyId)) {
			remove(tthc_Category);
		}
	}

	/**
	 * Removes all the t t h c_ categories where parentId = &#63; and groupId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentAndGroup(long parentId, long groupId)
		throws SystemException {
		for (TTHC_Category tthc_Category : findByParentAndGroup(parentId,
				groupId)) {
			remove(tthc_Category);
		}
	}

	/**
	 * Removes all the t t h c_ categories where categoryTypeId = &#63; and companyId = &#63; from the database.
	 *
	 * @param categoryTypeId the category type ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTypeAndCompany(int categoryTypeId, long companyId)
		throws SystemException {
		for (TTHC_Category tthc_Category : findByTypeAndCompany(
				categoryTypeId, companyId)) {
			remove(tthc_Category);
		}
	}

	/**
	 * Removes all the t t h c_ categories where categoryTypeId = &#63; and groupId = &#63; from the database.
	 *
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTypeAndGroup(int categoryTypeId, long groupId)
		throws SystemException {
		for (TTHC_Category tthc_Category : findByTypeAndGroup(categoryTypeId,
				groupId)) {
			remove(tthc_Category);
		}
	}

	/**
	 * Removes all the t t h c_ categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TTHC_Category tthc_Category : findAll()) {
			remove(tthc_Category);
		}
	}

	/**
	 * Returns the number of t t h c_ categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TTHC_CATEGORY_WHERE);

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
	 * Returns the number of t t h c_ categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TTHC_CATEGORY_WHERE);

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
	 * Returns the number of t t h c_ categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_TTHC_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Category.class.getName(),
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
	 * Returns the number of t t h c_ categories where parentId = &#63; and companyId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @return the number of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentAndCompany(long parentId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { parentId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_CATEGORY_WHERE);

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
	 * Returns the number of t t h c_ categories where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentAndGroup(long parentId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { parentId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_CATEGORY_WHERE);

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
	 * Returns the number of t t h c_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByParentAndGroup(long parentId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByParentAndGroup(parentId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TTHC_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Category.class.getName(),
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
	 * Returns the number of t t h c_ categories where categoryTypeId = &#63; and companyId = &#63;.
	 *
	 * @param categoryTypeId the category type ID
	 * @param companyId the company ID
	 * @return the number of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTypeAndCompany(int categoryTypeId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { categoryTypeId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TYPEANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDCOMPANY_CATEGORYTYPEID_2);

			query.append(_FINDER_COLUMN_TYPEANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryTypeId);

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
	 * Returns the number of t t h c_ categories where categoryTypeId = &#63; and groupId = &#63;.
	 *
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTypeAndGroup(int categoryTypeId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { categoryTypeId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TYPEANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTHC_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDGROUP_CATEGORYTYPEID_2);

			query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryTypeId);

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
	 * Returns the number of t t h c_ categories that the user has permission to view where categoryTypeId = &#63; and groupId = &#63;.
	 *
	 * @param categoryTypeId the category type ID
	 * @param groupId the group ID
	 * @return the number of matching t t h c_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByTypeAndGroup(int categoryTypeId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByTypeAndGroup(categoryTypeId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TTHC_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_CATEGORYTYPEID_2);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TTHC_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(categoryTypeId);

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
	 * Returns the number of t t h c_ categories.
	 *
	 * @return the number of t t h c_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TTHC_CATEGORY);

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
	 * Initializes the t t h c_ category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.tthc.model.TTHC_Category")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TTHC_Category>> listenersList = new ArrayList<ModelListener<TTHC_Category>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TTHC_Category>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TTHC_CategoryImpl.class.getName());
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
	private static final String _SQL_SELECT_TTHC_CATEGORY = "SELECT tthc_Category FROM TTHC_Category tthc_Category";
	private static final String _SQL_SELECT_TTHC_CATEGORY_WHERE = "SELECT tthc_Category FROM TTHC_Category tthc_Category WHERE ";
	private static final String _SQL_COUNT_TTHC_CATEGORY = "SELECT COUNT(tthc_Category) FROM TTHC_Category tthc_Category";
	private static final String _SQL_COUNT_TTHC_CATEGORY_WHERE = "SELECT COUNT(tthc_Category) FROM TTHC_Category tthc_Category WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "tthc_Category.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "tthc_Category.groupId = ?";
	private static final String _FINDER_COLUMN_PARENTANDCOMPANY_PARENTID_2 = "tthc_Category.parentId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2 = "tthc_Category.companyId = ?";
	private static final String _FINDER_COLUMN_PARENTANDGROUP_PARENTID_2 = "tthc_Category.parentId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTANDGROUP_GROUPID_2 = "tthc_Category.groupId = ?";
	private static final String _FINDER_COLUMN_TYPEANDCOMPANY_CATEGORYTYPEID_2 = "tthc_Category.categoryTypeId = ? AND ";
	private static final String _FINDER_COLUMN_TYPEANDCOMPANY_COMPANYID_2 = "tthc_Category.companyId = ?";
	private static final String _FINDER_COLUMN_TYPEANDGROUP_CATEGORYTYPEID_2 = "tthc_Category.categoryTypeId = ? AND ";
	private static final String _FINDER_COLUMN_TYPEANDGROUP_GROUPID_2 = "tthc_Category.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "tthc_Category.categoryId";
	private static final String _FILTER_SQL_SELECT_TTHC_CATEGORY_WHERE = "SELECT DISTINCT {tthc_Category.*} FROM tthc_category tthc_Category WHERE ";
	private static final String _FILTER_SQL_SELECT_TTHC_CATEGORY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {tthc_category.*} FROM (SELECT DISTINCT tthc_Category.categoryId FROM tthc_category tthc_Category WHERE ";
	private static final String _FILTER_SQL_SELECT_TTHC_CATEGORY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN tthc_category ON TEMP_TABLE.categoryId = tthc_category.categoryId";
	private static final String _FILTER_SQL_COUNT_TTHC_CATEGORY_WHERE = "SELECT COUNT(DISTINCT tthc_Category.categoryId) AS COUNT_VALUE FROM tthc_category tthc_Category WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "tthc_Category";
	private static final String _FILTER_ENTITY_TABLE = "tthc_category";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tthc_Category.";
	private static final String _ORDER_BY_ENTITY_TABLE = "tthc_category.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TTHC_Category exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TTHC_Category exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TTHC_CategoryPersistenceImpl.class);
	private static TTHC_Category _nullTTHC_Category = new TTHC_CategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TTHC_Category> toCacheModel() {
				return _nullTTHC_CategoryCacheModel;
			}
		};

	private static CacheModel<TTHC_Category> _nullTTHC_CategoryCacheModel = new CacheModel<TTHC_Category>() {
			public TTHC_Category toEntityModel() {
				return _nullTTHC_Category;
			}
		};
}