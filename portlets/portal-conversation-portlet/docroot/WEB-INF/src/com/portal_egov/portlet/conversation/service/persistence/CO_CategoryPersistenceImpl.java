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

import com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;
import com.portal_egov.portlet.conversation.model.CO_Category;
import com.portal_egov.portlet.conversation.model.impl.CO_CategoryImpl;
import com.portal_egov.portlet.conversation.model.impl.CO_CategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the c o_ category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see CO_CategoryPersistence
 * @see CO_CategoryUtil
 * @generated
 */
public class CO_CategoryPersistenceImpl extends BasePersistenceImpl<CO_Category>
	implements CO_CategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CO_CategoryUtil} to access the c o_ category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CO_CategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, CO_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, CO_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			CO_CategoryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, CO_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, CO_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			CO_CategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDCOMPANY =
		new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, CO_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY =
		new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, CO_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			CO_CategoryModelImpl.COMPANYID_COLUMN_BITMASK |
			CO_CategoryModelImpl.PARENTCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTANDCOMPANY = new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDGROUP =
		new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, CO_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP =
		new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, CO_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			CO_CategoryModelImpl.GROUPID_COLUMN_BITMASK |
			CO_CategoryModelImpl.PARENTCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTANDGROUP = new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, CO_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, CO_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the c o_ category in the entity cache if it is enabled.
	 *
	 * @param co_Category the c o_ category
	 */
	public void cacheResult(CO_Category co_Category) {
		EntityCacheUtil.putResult(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryImpl.class, co_Category.getPrimaryKey(), co_Category);

		co_Category.resetOriginalValues();
	}

	/**
	 * Caches the c o_ categories in the entity cache if it is enabled.
	 *
	 * @param co_Categories the c o_ categories
	 */
	public void cacheResult(List<CO_Category> co_Categories) {
		for (CO_Category co_Category : co_Categories) {
			if (EntityCacheUtil.getResult(
						CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
						CO_CategoryImpl.class, co_Category.getPrimaryKey()) == null) {
				cacheResult(co_Category);
			}
			else {
				co_Category.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all c o_ categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CO_CategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CO_CategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the c o_ category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CO_Category co_Category) {
		EntityCacheUtil.removeResult(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryImpl.class, co_Category.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CO_Category> co_Categories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CO_Category co_Category : co_Categories) {
			EntityCacheUtil.removeResult(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				CO_CategoryImpl.class, co_Category.getPrimaryKey());
		}
	}

	/**
	 * Creates a new c o_ category with the primary key. Does not add the c o_ category to the database.
	 *
	 * @param categoryId the primary key for the new c o_ category
	 * @return the new c o_ category
	 */
	public CO_Category create(long categoryId) {
		CO_Category co_Category = new CO_CategoryImpl();

		co_Category.setNew(true);
		co_Category.setPrimaryKey(categoryId);

		return co_Category;
	}

	/**
	 * Removes the c o_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the c o_ category
	 * @return the c o_ category that was removed
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category remove(long categoryId)
		throws NoSuchCO_CategoryException, SystemException {
		return remove(Long.valueOf(categoryId));
	}

	/**
	 * Removes the c o_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the c o_ category
	 * @return the c o_ category that was removed
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CO_Category remove(Serializable primaryKey)
		throws NoSuchCO_CategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CO_Category co_Category = (CO_Category)session.get(CO_CategoryImpl.class,
					primaryKey);

			if (co_Category == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCO_CategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(co_Category);
		}
		catch (NoSuchCO_CategoryException nsee) {
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
	protected CO_Category removeImpl(CO_Category co_Category)
		throws SystemException {
		co_Category = toUnwrappedModel(co_Category);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, co_Category);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(co_Category);

		return co_Category;
	}

	@Override
	public CO_Category updateImpl(
		com.portal_egov.portlet.conversation.model.CO_Category co_Category,
		boolean merge) throws SystemException {
		co_Category = toUnwrappedModel(co_Category);

		boolean isNew = co_Category.isNew();

		CO_CategoryModelImpl co_CategoryModelImpl = (CO_CategoryModelImpl)co_Category;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, co_Category, merge);

			co_Category.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CO_CategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((co_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_CategoryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(co_CategoryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((co_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_CategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(co_CategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((co_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_CategoryModelImpl.getOriginalCompanyId()),
						Long.valueOf(co_CategoryModelImpl.getOriginalParentCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(co_CategoryModelImpl.getCompanyId()),
						Long.valueOf(co_CategoryModelImpl.getParentCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY,
					args);
			}

			if ((co_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_CategoryModelImpl.getOriginalGroupId()),
						Long.valueOf(co_CategoryModelImpl.getOriginalParentCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(co_CategoryModelImpl.getGroupId()),
						Long.valueOf(co_CategoryModelImpl.getParentCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CO_CategoryImpl.class, co_Category.getPrimaryKey(), co_Category);

		return co_Category;
	}

	protected CO_Category toUnwrappedModel(CO_Category co_Category) {
		if (co_Category instanceof CO_CategoryImpl) {
			return co_Category;
		}

		CO_CategoryImpl co_CategoryImpl = new CO_CategoryImpl();

		co_CategoryImpl.setNew(co_Category.isNew());
		co_CategoryImpl.setPrimaryKey(co_Category.getPrimaryKey());

		co_CategoryImpl.setCategoryId(co_Category.getCategoryId());
		co_CategoryImpl.setCompanyId(co_Category.getCompanyId());
		co_CategoryImpl.setGroupId(co_Category.getGroupId());
		co_CategoryImpl.setUserId(co_Category.getUserId());
		co_CategoryImpl.setParentCategoryId(co_Category.getParentCategoryId());
		co_CategoryImpl.setCategoryName(co_Category.getCategoryName());
		co_CategoryImpl.setCategoryDesc(co_Category.getCategoryDesc());
		co_CategoryImpl.setThreadCount(co_Category.getThreadCount());
		co_CategoryImpl.setCreateDate(co_Category.getCreateDate());
		co_CategoryImpl.setModifiedDate(co_Category.getModifiedDate());

		return co_CategoryImpl;
	}

	/**
	 * Returns the c o_ category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the c o_ category
	 * @return the c o_ category
	 * @throws com.liferay.portal.NoSuchModelException if a c o_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CO_Category findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the c o_ category with the primary key or throws a {@link com.portal_egov.portlet.conversation.NoSuchCO_CategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the c o_ category
	 * @return the c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category findByPrimaryKey(long categoryId)
		throws NoSuchCO_CategoryException, SystemException {
		CO_Category co_Category = fetchByPrimaryKey(categoryId);

		if (co_Category == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
			}

			throw new NoSuchCO_CategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryId);
		}

		return co_Category;
	}

	/**
	 * Returns the c o_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the c o_ category
	 * @return the c o_ category, or <code>null</code> if a c o_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CO_Category fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the c o_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the c o_ category
	 * @return the c o_ category, or <code>null</code> if a c o_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category fetchByPrimaryKey(long categoryId)
		throws SystemException {
		CO_Category co_Category = (CO_Category)EntityCacheUtil.getResult(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				CO_CategoryImpl.class, categoryId);

		if (co_Category == _nullCO_Category) {
			return null;
		}

		if (co_Category == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				co_Category = (CO_Category)session.get(CO_CategoryImpl.class,
						Long.valueOf(categoryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (co_Category != null) {
					cacheResult(co_Category);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CO_CategoryModelImpl.ENTITY_CACHE_ENABLED,
						CO_CategoryImpl.class, categoryId, _nullCO_Category);
				}

				closeSession(session);
			}
		}

		return co_Category;
	}

	/**
	 * Returns all the c o_ categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the c o_ categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ categories
	 * @param end the upper bound of the range of c o_ categories (not inclusive)
	 * @return the range of matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ categories
	 * @param end the upper bound of the range of c o_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findByCompany(long companyId, int start, int end,
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

		List<CO_Category> list = (List<CO_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Category co_Category : list) {
				if ((companyId != co_Category.getCompanyId())) {
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

			query.append(_SQL_SELECT_CO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<CO_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c o_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_CategoryException, SystemException {
		CO_Category co_Category = fetchByCompany_First(companyId,
				orderByComparator);

		if (co_Category != null) {
			return co_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_CategoryException(msg.toString());
	}

	/**
	 * Returns the first c o_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CO_Category> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_CategoryException, SystemException {
		CO_Category co_Category = fetchByCompany_Last(companyId,
				orderByComparator);

		if (co_Category != null) {
			return co_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_CategoryException(msg.toString());
	}

	/**
	 * Returns the last c o_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<CO_Category> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ categories before and after the current c o_ category in the ordered set where companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current c o_ category
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category[] findByCompany_PrevAndNext(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCO_CategoryException, SystemException {
		CO_Category co_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CO_Category[] array = new CO_CategoryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, co_Category,
					companyId, orderByComparator, true);

			array[1] = co_Category;

			array[2] = getByCompany_PrevAndNext(session, co_Category,
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

	protected CO_Category getByCompany_PrevAndNext(Session session,
		CO_Category co_Category, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_CATEGORY_WHERE);

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
			query.append(CO_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ categories
	 * @param end the upper bound of the range of c o_ categories (not inclusive)
	 * @return the range of matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ categories
	 * @param end the upper bound of the range of c o_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findByGroup(long groupId, int start, int end,
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

		List<CO_Category> list = (List<CO_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Category co_Category : list) {
				if ((groupId != co_Category.getGroupId())) {
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

			query.append(_SQL_SELECT_CO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<CO_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c o_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_CategoryException, SystemException {
		CO_Category co_Category = fetchByGroup_First(groupId, orderByComparator);

		if (co_Category != null) {
			return co_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_CategoryException(msg.toString());
	}

	/**
	 * Returns the first c o_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CO_Category> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_CategoryException, SystemException {
		CO_Category co_Category = fetchByGroup_Last(groupId, orderByComparator);

		if (co_Category != null) {
			return co_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_CategoryException(msg.toString());
	}

	/**
	 * Returns the last c o_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<CO_Category> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ categories before and after the current c o_ category in the ordered set where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current c o_ category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category[] findByGroup_PrevAndNext(long categoryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_CategoryException, SystemException {
		CO_Category co_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CO_Category[] array = new CO_CategoryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, co_Category, groupId,
					orderByComparator, true);

			array[1] = co_Category;

			array[2] = getByGroup_PrevAndNext(session, co_Category, groupId,
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

	protected CO_Category getByGroup_PrevAndNext(Session session,
		CO_Category co_Category, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_CATEGORY_WHERE);

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
			query.append(CO_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching c o_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the c o_ categories that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ categories
	 * @param end the upper bound of the range of c o_ categories (not inclusive)
	 * @return the range of matching c o_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ categories that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ categories
	 * @param end the upper bound of the range of c o_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_CO_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CO_CategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CO_CategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<CO_Category>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the c o_ categories before and after the current c o_ category in the ordered set of c o_ categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current c o_ category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category[] filterFindByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCO_CategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(categoryId, groupId,
				orderByComparator);
		}

		CO_Category co_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CO_Category[] array = new CO_CategoryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, co_Category,
					groupId, orderByComparator, true);

			array[1] = co_Category;

			array[2] = filterGetByGroup_PrevAndNext(session, co_Category,
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

	protected CO_Category filterGetByGroup_PrevAndNext(Session session,
		CO_Category co_Category, long groupId,
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
			query.append(_FILTER_SQL_SELECT_CO_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CO_CategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CO_CategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ categories where companyId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentCategoryId the parent category ID
	 * @return the matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findByParentAndCompany(long companyId,
		long parentCategoryId) throws SystemException {
		return findByParentAndCompany(companyId, parentCategoryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ categories where companyId = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of c o_ categories
	 * @param end the upper bound of the range of c o_ categories (not inclusive)
	 * @return the range of matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findByParentAndCompany(long companyId,
		long parentCategoryId, int start, int end) throws SystemException {
		return findByParentAndCompany(companyId, parentCategoryId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the c o_ categories where companyId = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of c o_ categories
	 * @param end the upper bound of the range of c o_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findByParentAndCompany(long companyId,
		long parentCategoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY;
			finderArgs = new Object[] { companyId, parentCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDCOMPANY;
			finderArgs = new Object[] {
					companyId, parentCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<CO_Category> list = (List<CO_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Category co_Category : list) {
				if ((companyId != co_Category.getCompanyId()) ||
						(parentCategoryId != co_Category.getParentCategoryId())) {
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

			query.append(_SQL_SELECT_CO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_PARENTCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(parentCategoryId);

				list = (List<CO_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c o_ category in the ordered set where companyId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category findByParentAndCompany_First(long companyId,
		long parentCategoryId, OrderByComparator orderByComparator)
		throws NoSuchCO_CategoryException, SystemException {
		CO_Category co_Category = fetchByParentAndCompany_First(companyId,
				parentCategoryId, orderByComparator);

		if (co_Category != null) {
			return co_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", parentCategoryId=");
		msg.append(parentCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_CategoryException(msg.toString());
	}

	/**
	 * Returns the first c o_ category in the ordered set where companyId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category fetchByParentAndCompany_First(long companyId,
		long parentCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CO_Category> list = findByParentAndCompany(companyId,
				parentCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ category in the ordered set where companyId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category findByParentAndCompany_Last(long companyId,
		long parentCategoryId, OrderByComparator orderByComparator)
		throws NoSuchCO_CategoryException, SystemException {
		CO_Category co_Category = fetchByParentAndCompany_Last(companyId,
				parentCategoryId, orderByComparator);

		if (co_Category != null) {
			return co_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", parentCategoryId=");
		msg.append(parentCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_CategoryException(msg.toString());
	}

	/**
	 * Returns the last c o_ category in the ordered set where companyId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category fetchByParentAndCompany_Last(long companyId,
		long parentCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentAndCompany(companyId, parentCategoryId);

		List<CO_Category> list = findByParentAndCompany(companyId,
				parentCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ categories before and after the current c o_ category in the ordered set where companyId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param categoryId the primary key of the current c o_ category
	 * @param companyId the company ID
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category[] findByParentAndCompany_PrevAndNext(long categoryId,
		long companyId, long parentCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_CategoryException, SystemException {
		CO_Category co_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CO_Category[] array = new CO_CategoryImpl[3];

			array[0] = getByParentAndCompany_PrevAndNext(session, co_Category,
					companyId, parentCategoryId, orderByComparator, true);

			array[1] = co_Category;

			array[2] = getByParentAndCompany_PrevAndNext(session, co_Category,
					companyId, parentCategoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CO_Category getByParentAndCompany_PrevAndNext(Session session,
		CO_Category co_Category, long companyId, long parentCategoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_PARENTANDCOMPANY_PARENTCATEGORYID_2);

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
			query.append(CO_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(parentCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ categories where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @return the matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findByParentAndGroup(long groupId,
		long parentCategoryId) throws SystemException {
		return findByParentAndGroup(groupId, parentCategoryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ categories where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of c o_ categories
	 * @param end the upper bound of the range of c o_ categories (not inclusive)
	 * @return the range of matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findByParentAndGroup(long groupId,
		long parentCategoryId, int start, int end) throws SystemException {
		return findByParentAndGroup(groupId, parentCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ categories where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of c o_ categories
	 * @param end the upper bound of the range of c o_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findByParentAndGroup(long groupId,
		long parentCategoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP;
			finderArgs = new Object[] { groupId, parentCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDGROUP;
			finderArgs = new Object[] {
					groupId, parentCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<CO_Category> list = (List<CO_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Category co_Category : list) {
				if ((groupId != co_Category.getGroupId()) ||
						(parentCategoryId != co_Category.getParentCategoryId())) {
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

			query.append(_SQL_SELECT_CO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parentCategoryId);

				list = (List<CO_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c o_ category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category findByParentAndGroup_First(long groupId,
		long parentCategoryId, OrderByComparator orderByComparator)
		throws NoSuchCO_CategoryException, SystemException {
		CO_Category co_Category = fetchByParentAndGroup_First(groupId,
				parentCategoryId, orderByComparator);

		if (co_Category != null) {
			return co_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", parentCategoryId=");
		msg.append(parentCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_CategoryException(msg.toString());
	}

	/**
	 * Returns the first c o_ category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category fetchByParentAndGroup_First(long groupId,
		long parentCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CO_Category> list = findByParentAndGroup(groupId,
				parentCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category findByParentAndGroup_Last(long groupId,
		long parentCategoryId, OrderByComparator orderByComparator)
		throws NoSuchCO_CategoryException, SystemException {
		CO_Category co_Category = fetchByParentAndGroup_Last(groupId,
				parentCategoryId, orderByComparator);

		if (co_Category != null) {
			return co_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", parentCategoryId=");
		msg.append(parentCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_CategoryException(msg.toString());
	}

	/**
	 * Returns the last c o_ category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category fetchByParentAndGroup_Last(long groupId,
		long parentCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentAndGroup(groupId, parentCategoryId);

		List<CO_Category> list = findByParentAndGroup(groupId,
				parentCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ categories before and after the current c o_ category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param categoryId the primary key of the current c o_ category
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category[] findByParentAndGroup_PrevAndNext(long categoryId,
		long groupId, long parentCategoryId, OrderByComparator orderByComparator)
		throws NoSuchCO_CategoryException, SystemException {
		CO_Category co_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CO_Category[] array = new CO_CategoryImpl[3];

			array[0] = getByParentAndGroup_PrevAndNext(session, co_Category,
					groupId, parentCategoryId, orderByComparator, true);

			array[1] = co_Category;

			array[2] = getByParentAndGroup_PrevAndNext(session, co_Category,
					groupId, parentCategoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CO_Category getByParentAndGroup_PrevAndNext(Session session,
		CO_Category co_Category, long groupId, long parentCategoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTCATEGORYID_2);

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
			query.append(CO_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(parentCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ categories that the user has permission to view where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @return the matching c o_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> filterFindByParentAndGroup(long groupId,
		long parentCategoryId) throws SystemException {
		return filterFindByParentAndGroup(groupId, parentCategoryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ categories that the user has permission to view where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of c o_ categories
	 * @param end the upper bound of the range of c o_ categories (not inclusive)
	 * @return the range of matching c o_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> filterFindByParentAndGroup(long groupId,
		long parentCategoryId, int start, int end) throws SystemException {
		return filterFindByParentAndGroup(groupId, parentCategoryId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ categories that the user has permissions to view where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of c o_ categories
	 * @param end the upper bound of the range of c o_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> filterFindByParentAndGroup(long groupId,
		long parentCategoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParentAndGroup(groupId, parentCategoryId, start, end,
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
			query.append(_FILTER_SQL_SELECT_CO_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTCATEGORYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CO_CategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CO_CategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(parentCategoryId);

			return (List<CO_Category>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the c o_ categories before and after the current c o_ category in the ordered set of c o_ categories that the user has permission to view where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param categoryId the primary key of the current c o_ category
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ category
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Category[] filterFindByParentAndGroup_PrevAndNext(
		long categoryId, long groupId, long parentCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_CategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParentAndGroup_PrevAndNext(categoryId, groupId,
				parentCategoryId, orderByComparator);
		}

		CO_Category co_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CO_Category[] array = new CO_CategoryImpl[3];

			array[0] = filterGetByParentAndGroup_PrevAndNext(session,
					co_Category, groupId, parentCategoryId, orderByComparator,
					true);

			array[1] = co_Category;

			array[2] = filterGetByParentAndGroup_PrevAndNext(session,
					co_Category, groupId, parentCategoryId, orderByComparator,
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

	protected CO_Category filterGetByParentAndGroup_PrevAndNext(
		Session session, CO_Category co_Category, long groupId,
		long parentCategoryId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_CO_CATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_CATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTCATEGORYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_CATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_CategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_CategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CO_CategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CO_CategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(parentCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ categories.
	 *
	 * @return the c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of c o_ categories
	 * @param end the upper bound of the range of c o_ categories (not inclusive)
	 * @return the range of c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of c o_ categories
	 * @param end the upper bound of the range of c o_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Category> findAll(int start, int end,
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

		List<CO_Category> list = (List<CO_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CO_CATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CO_CATEGORY.concat(CO_CategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CO_Category>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CO_Category>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the c o_ categories where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (CO_Category co_Category : findByCompany(companyId)) {
			remove(co_Category);
		}
	}

	/**
	 * Removes all the c o_ categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (CO_Category co_Category : findByGroup(groupId)) {
			remove(co_Category);
		}
	}

	/**
	 * Removes all the c o_ categories where companyId = &#63; and parentCategoryId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param parentCategoryId the parent category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentAndCompany(long companyId, long parentCategoryId)
		throws SystemException {
		for (CO_Category co_Category : findByParentAndCompany(companyId,
				parentCategoryId)) {
			remove(co_Category);
		}
	}

	/**
	 * Removes all the c o_ categories where groupId = &#63; and parentCategoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentAndGroup(long groupId, long parentCategoryId)
		throws SystemException {
		for (CO_Category co_Category : findByParentAndGroup(groupId,
				parentCategoryId)) {
			remove(co_Category);
		}
	}

	/**
	 * Removes all the c o_ categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CO_Category co_Category : findAll()) {
			remove(co_Category);
		}
	}

	/**
	 * Returns the number of c o_ categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CO_CATEGORY_WHERE);

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
	 * Returns the number of c o_ categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CO_CATEGORY_WHERE);

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
	 * Returns the number of c o_ categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching c o_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CO_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Category.class.getName(),
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
	 * Returns the number of c o_ categories where companyId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentAndCompany(long companyId, long parentCategoryId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, parentCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_PARENTCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(parentCategoryId);

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
	 * Returns the number of c o_ categories where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentAndGroup(long groupId, long parentCategoryId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, parentCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parentCategoryId);

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
	 * Returns the number of c o_ categories that the user has permission to view where groupId = &#63; and parentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching c o_ categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByParentAndGroup(long groupId, long parentCategoryId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByParentAndGroup(groupId, parentCategoryId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CO_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTCATEGORYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Category.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(parentCategoryId);

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
	 * Returns the number of c o_ categories.
	 *
	 * @return the number of c o_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CO_CATEGORY);

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
	 * Initializes the c o_ category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.conversation.model.CO_Category")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CO_Category>> listenersList = new ArrayList<ModelListener<CO_Category>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CO_Category>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CO_CategoryImpl.class.getName());
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
	private static final String _SQL_SELECT_CO_CATEGORY = "SELECT co_Category FROM CO_Category co_Category";
	private static final String _SQL_SELECT_CO_CATEGORY_WHERE = "SELECT co_Category FROM CO_Category co_Category WHERE ";
	private static final String _SQL_COUNT_CO_CATEGORY = "SELECT COUNT(co_Category) FROM CO_Category co_Category";
	private static final String _SQL_COUNT_CO_CATEGORY_WHERE = "SELECT COUNT(co_Category) FROM CO_Category co_Category WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "co_Category.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "co_Category.groupId = ?";
	private static final String _FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2 = "co_Category.companyId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTANDCOMPANY_PARENTCATEGORYID_2 =
		"co_Category.parentCategoryId = ?";
	private static final String _FINDER_COLUMN_PARENTANDGROUP_GROUPID_2 = "co_Category.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTANDGROUP_PARENTCATEGORYID_2 =
		"co_Category.parentCategoryId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "co_Category.categoryId";
	private static final String _FILTER_SQL_SELECT_CO_CATEGORY_WHERE = "SELECT DISTINCT {co_Category.*} FROM CO_Category co_Category WHERE ";
	private static final String _FILTER_SQL_SELECT_CO_CATEGORY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {CO_Category.*} FROM (SELECT DISTINCT co_Category.categoryId FROM CO_Category co_Category WHERE ";
	private static final String _FILTER_SQL_SELECT_CO_CATEGORY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN CO_Category ON TEMP_TABLE.categoryId = CO_Category.categoryId";
	private static final String _FILTER_SQL_COUNT_CO_CATEGORY_WHERE = "SELECT COUNT(DISTINCT co_Category.categoryId) AS COUNT_VALUE FROM CO_Category co_Category WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "co_Category";
	private static final String _FILTER_ENTITY_TABLE = "CO_Category";
	private static final String _ORDER_BY_ENTITY_ALIAS = "co_Category.";
	private static final String _ORDER_BY_ENTITY_TABLE = "CO_Category.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CO_Category exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CO_Category exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CO_CategoryPersistenceImpl.class);
	private static CO_Category _nullCO_Category = new CO_CategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CO_Category> toCacheModel() {
				return _nullCO_CategoryCacheModel;
			}
		};

	private static CacheModel<CO_Category> _nullCO_CategoryCacheModel = new CacheModel<CO_Category>() {
			public CO_Category toEntityModel() {
				return _nullCO_Category;
			}
		};
}