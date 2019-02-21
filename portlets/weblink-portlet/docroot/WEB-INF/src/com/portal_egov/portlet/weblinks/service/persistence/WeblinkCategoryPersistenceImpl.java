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

package com.portal_egov.portlet.weblinks.service.persistence;

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

import com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException;
import com.portal_egov.portlet.weblinks.model.WeblinkCategory;
import com.portal_egov.portlet.weblinks.model.impl.WeblinkCategoryImpl;
import com.portal_egov.portlet.weblinks.model.impl.WeblinkCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the weblink category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see WeblinkCategoryPersistence
 * @see WeblinkCategoryUtil
 * @generated
 */
public class WeblinkCategoryPersistenceImpl extends BasePersistenceImpl<WeblinkCategory>
	implements WeblinkCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WeblinkCategoryUtil} to access the weblink category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WeblinkCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkCategoryModelImpl.FINDER_CACHE_ENABLED,
			WeblinkCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkCategoryModelImpl.FINDER_CACHE_ENABLED,
			WeblinkCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			WeblinkCategoryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkCategoryModelImpl.FINDER_CACHE_ENABLED,
			WeblinkCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkCategoryModelImpl.FINDER_CACHE_ENABLED,
			WeblinkCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			WeblinkCategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkCategoryModelImpl.FINDER_CACHE_ENABLED,
			WeblinkCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkCategoryModelImpl.FINDER_CACHE_ENABLED,
			WeblinkCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the weblink category in the entity cache if it is enabled.
	 *
	 * @param weblinkCategory the weblink category
	 */
	public void cacheResult(WeblinkCategory weblinkCategory) {
		EntityCacheUtil.putResult(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkCategoryImpl.class, weblinkCategory.getPrimaryKey(),
			weblinkCategory);

		weblinkCategory.resetOriginalValues();
	}

	/**
	 * Caches the weblink categories in the entity cache if it is enabled.
	 *
	 * @param weblinkCategories the weblink categories
	 */
	public void cacheResult(List<WeblinkCategory> weblinkCategories) {
		for (WeblinkCategory weblinkCategory : weblinkCategories) {
			if (EntityCacheUtil.getResult(
						WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
						WeblinkCategoryImpl.class,
						weblinkCategory.getPrimaryKey()) == null) {
				cacheResult(weblinkCategory);
			}
			else {
				weblinkCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all weblink categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WeblinkCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WeblinkCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the weblink category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WeblinkCategory weblinkCategory) {
		EntityCacheUtil.removeResult(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkCategoryImpl.class, weblinkCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WeblinkCategory> weblinkCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WeblinkCategory weblinkCategory : weblinkCategories) {
			EntityCacheUtil.removeResult(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
				WeblinkCategoryImpl.class, weblinkCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new weblink category with the primary key. Does not add the weblink category to the database.
	 *
	 * @param categoryId the primary key for the new weblink category
	 * @return the new weblink category
	 */
	public WeblinkCategory create(long categoryId) {
		WeblinkCategory weblinkCategory = new WeblinkCategoryImpl();

		weblinkCategory.setNew(true);
		weblinkCategory.setPrimaryKey(categoryId);

		return weblinkCategory;
	}

	/**
	 * Removes the weblink category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the weblink category
	 * @return the weblink category that was removed
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a weblink category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WeblinkCategory remove(long categoryId)
		throws NoSuchWeblinkCategoryException, SystemException {
		return remove(Long.valueOf(categoryId));
	}

	/**
	 * Removes the weblink category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the weblink category
	 * @return the weblink category that was removed
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a weblink category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WeblinkCategory remove(Serializable primaryKey)
		throws NoSuchWeblinkCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WeblinkCategory weblinkCategory = (WeblinkCategory)session.get(WeblinkCategoryImpl.class,
					primaryKey);

			if (weblinkCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWeblinkCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(weblinkCategory);
		}
		catch (NoSuchWeblinkCategoryException nsee) {
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
	protected WeblinkCategory removeImpl(WeblinkCategory weblinkCategory)
		throws SystemException {
		weblinkCategory = toUnwrappedModel(weblinkCategory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, weblinkCategory);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(weblinkCategory);

		return weblinkCategory;
	}

	@Override
	public WeblinkCategory updateImpl(
		com.portal_egov.portlet.weblinks.model.WeblinkCategory weblinkCategory,
		boolean merge) throws SystemException {
		weblinkCategory = toUnwrappedModel(weblinkCategory);

		boolean isNew = weblinkCategory.isNew();

		WeblinkCategoryModelImpl weblinkCategoryModelImpl = (WeblinkCategoryModelImpl)weblinkCategory;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, weblinkCategory, merge);

			weblinkCategory.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WeblinkCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((weblinkCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(weblinkCategoryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(weblinkCategoryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((weblinkCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(weblinkCategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(weblinkCategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
			WeblinkCategoryImpl.class, weblinkCategory.getPrimaryKey(),
			weblinkCategory);

		return weblinkCategory;
	}

	protected WeblinkCategory toUnwrappedModel(WeblinkCategory weblinkCategory) {
		if (weblinkCategory instanceof WeblinkCategoryImpl) {
			return weblinkCategory;
		}

		WeblinkCategoryImpl weblinkCategoryImpl = new WeblinkCategoryImpl();

		weblinkCategoryImpl.setNew(weblinkCategory.isNew());
		weblinkCategoryImpl.setPrimaryKey(weblinkCategory.getPrimaryKey());

		weblinkCategoryImpl.setCategoryId(weblinkCategory.getCategoryId());
		weblinkCategoryImpl.setGroupId(weblinkCategory.getGroupId());
		weblinkCategoryImpl.setCompanyId(weblinkCategory.getCompanyId());
		weblinkCategoryImpl.setUserId(weblinkCategory.getUserId());
		weblinkCategoryImpl.setUserName(weblinkCategory.getUserName());
		weblinkCategoryImpl.setCreateDate(weblinkCategory.getCreateDate());
		weblinkCategoryImpl.setModifiedDate(weblinkCategory.getModifiedDate());
		weblinkCategoryImpl.setCategoryName(weblinkCategory.getCategoryName());
		weblinkCategoryImpl.setCategoryDesc(weblinkCategory.getCategoryDesc());
		weblinkCategoryImpl.setCategoryIconId(weblinkCategory.getCategoryIconId());

		return weblinkCategoryImpl;
	}

	/**
	 * Returns the weblink category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the weblink category
	 * @return the weblink category
	 * @throws com.liferay.portal.NoSuchModelException if a weblink category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WeblinkCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the weblink category with the primary key or throws a {@link com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the weblink category
	 * @return the weblink category
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a weblink category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WeblinkCategory findByPrimaryKey(long categoryId)
		throws NoSuchWeblinkCategoryException, SystemException {
		WeblinkCategory weblinkCategory = fetchByPrimaryKey(categoryId);

		if (weblinkCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
			}

			throw new NoSuchWeblinkCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryId);
		}

		return weblinkCategory;
	}

	/**
	 * Returns the weblink category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the weblink category
	 * @return the weblink category, or <code>null</code> if a weblink category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WeblinkCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the weblink category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the weblink category
	 * @return the weblink category, or <code>null</code> if a weblink category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WeblinkCategory fetchByPrimaryKey(long categoryId)
		throws SystemException {
		WeblinkCategory weblinkCategory = (WeblinkCategory)EntityCacheUtil.getResult(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
				WeblinkCategoryImpl.class, categoryId);

		if (weblinkCategory == _nullWeblinkCategory) {
			return null;
		}

		if (weblinkCategory == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				weblinkCategory = (WeblinkCategory)session.get(WeblinkCategoryImpl.class,
						Long.valueOf(categoryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (weblinkCategory != null) {
					cacheResult(weblinkCategory);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WeblinkCategoryModelImpl.ENTITY_CACHE_ENABLED,
						WeblinkCategoryImpl.class, categoryId,
						_nullWeblinkCategory);
				}

				closeSession(session);
			}
		}

		return weblinkCategory;
	}

	/**
	 * Returns all the weblink categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching weblink categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<WeblinkCategory> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the weblink categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of weblink categories
	 * @param end the upper bound of the range of weblink categories (not inclusive)
	 * @return the range of matching weblink categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<WeblinkCategory> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the weblink categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of weblink categories
	 * @param end the upper bound of the range of weblink categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching weblink categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<WeblinkCategory> findByCompany(long companyId, int start,
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

		List<WeblinkCategory> list = (List<WeblinkCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WeblinkCategory weblinkCategory : list) {
				if ((companyId != weblinkCategory.getCompanyId())) {
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

			query.append(_SQL_SELECT_WEBLINKCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WeblinkCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<WeblinkCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first weblink category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching weblink category
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a matching weblink category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WeblinkCategory findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchWeblinkCategoryException, SystemException {
		WeblinkCategory weblinkCategory = fetchByCompany_First(companyId,
				orderByComparator);

		if (weblinkCategory != null) {
			return weblinkCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWeblinkCategoryException(msg.toString());
	}

	/**
	 * Returns the first weblink category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching weblink category, or <code>null</code> if a matching weblink category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WeblinkCategory fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WeblinkCategory> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last weblink category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching weblink category
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a matching weblink category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WeblinkCategory findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchWeblinkCategoryException, SystemException {
		WeblinkCategory weblinkCategory = fetchByCompany_Last(companyId,
				orderByComparator);

		if (weblinkCategory != null) {
			return weblinkCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWeblinkCategoryException(msg.toString());
	}

	/**
	 * Returns the last weblink category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching weblink category, or <code>null</code> if a matching weblink category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WeblinkCategory fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<WeblinkCategory> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the weblink categories before and after the current weblink category in the ordered set where companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current weblink category
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next weblink category
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a weblink category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WeblinkCategory[] findByCompany_PrevAndNext(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchWeblinkCategoryException, SystemException {
		WeblinkCategory weblinkCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			WeblinkCategory[] array = new WeblinkCategoryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, weblinkCategory,
					companyId, orderByComparator, true);

			array[1] = weblinkCategory;

			array[2] = getByCompany_PrevAndNext(session, weblinkCategory,
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

	protected WeblinkCategory getByCompany_PrevAndNext(Session session,
		WeblinkCategory weblinkCategory, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WEBLINKCATEGORY_WHERE);

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
			query.append(WeblinkCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(weblinkCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WeblinkCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the weblink categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching weblink categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<WeblinkCategory> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the weblink categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of weblink categories
	 * @param end the upper bound of the range of weblink categories (not inclusive)
	 * @return the range of matching weblink categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<WeblinkCategory> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the weblink categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of weblink categories
	 * @param end the upper bound of the range of weblink categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching weblink categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<WeblinkCategory> findByGroup(long groupId, int start, int end,
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

		List<WeblinkCategory> list = (List<WeblinkCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WeblinkCategory weblinkCategory : list) {
				if ((groupId != weblinkCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_WEBLINKCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WeblinkCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<WeblinkCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first weblink category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching weblink category
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a matching weblink category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WeblinkCategory findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWeblinkCategoryException, SystemException {
		WeblinkCategory weblinkCategory = fetchByGroup_First(groupId,
				orderByComparator);

		if (weblinkCategory != null) {
			return weblinkCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWeblinkCategoryException(msg.toString());
	}

	/**
	 * Returns the first weblink category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching weblink category, or <code>null</code> if a matching weblink category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WeblinkCategory fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WeblinkCategory> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last weblink category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching weblink category
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a matching weblink category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WeblinkCategory findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWeblinkCategoryException, SystemException {
		WeblinkCategory weblinkCategory = fetchByGroup_Last(groupId,
				orderByComparator);

		if (weblinkCategory != null) {
			return weblinkCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWeblinkCategoryException(msg.toString());
	}

	/**
	 * Returns the last weblink category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching weblink category, or <code>null</code> if a matching weblink category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WeblinkCategory fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<WeblinkCategory> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the weblink categories before and after the current weblink category in the ordered set where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current weblink category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next weblink category
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a weblink category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WeblinkCategory[] findByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchWeblinkCategoryException, SystemException {
		WeblinkCategory weblinkCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			WeblinkCategory[] array = new WeblinkCategoryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, weblinkCategory,
					groupId, orderByComparator, true);

			array[1] = weblinkCategory;

			array[2] = getByGroup_PrevAndNext(session, weblinkCategory,
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

	protected WeblinkCategory getByGroup_PrevAndNext(Session session,
		WeblinkCategory weblinkCategory, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WEBLINKCATEGORY_WHERE);

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
			query.append(WeblinkCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(weblinkCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WeblinkCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the weblink categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching weblink categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<WeblinkCategory> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the weblink categories that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of weblink categories
	 * @param end the upper bound of the range of weblink categories (not inclusive)
	 * @return the range of matching weblink categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<WeblinkCategory> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the weblink categories that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of weblink categories
	 * @param end the upper bound of the range of weblink categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching weblink categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<WeblinkCategory> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_WEBLINKCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_WEBLINKCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_WEBLINKCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(WeblinkCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(WeblinkCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WeblinkCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, WeblinkCategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, WeblinkCategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<WeblinkCategory>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the weblink categories before and after the current weblink category in the ordered set of weblink categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current weblink category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next weblink category
	 * @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a weblink category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WeblinkCategory[] filterFindByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchWeblinkCategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(categoryId, groupId,
				orderByComparator);
		}

		WeblinkCategory weblinkCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			WeblinkCategory[] array = new WeblinkCategoryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, weblinkCategory,
					groupId, orderByComparator, true);

			array[1] = weblinkCategory;

			array[2] = filterGetByGroup_PrevAndNext(session, weblinkCategory,
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

	protected WeblinkCategory filterGetByGroup_PrevAndNext(Session session,
		WeblinkCategory weblinkCategory, long groupId,
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
			query.append(_FILTER_SQL_SELECT_WEBLINKCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_WEBLINKCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_WEBLINKCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(WeblinkCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(WeblinkCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WeblinkCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, WeblinkCategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, WeblinkCategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(weblinkCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WeblinkCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the weblink categories.
	 *
	 * @return the weblink categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<WeblinkCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the weblink categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of weblink categories
	 * @param end the upper bound of the range of weblink categories (not inclusive)
	 * @return the range of weblink categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<WeblinkCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the weblink categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of weblink categories
	 * @param end the upper bound of the range of weblink categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of weblink categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<WeblinkCategory> findAll(int start, int end,
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

		List<WeblinkCategory> list = (List<WeblinkCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WEBLINKCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WEBLINKCATEGORY.concat(WeblinkCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<WeblinkCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<WeblinkCategory>)QueryUtil.list(q,
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
	 * Removes all the weblink categories where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (WeblinkCategory weblinkCategory : findByCompany(companyId)) {
			remove(weblinkCategory);
		}
	}

	/**
	 * Removes all the weblink categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (WeblinkCategory weblinkCategory : findByGroup(groupId)) {
			remove(weblinkCategory);
		}
	}

	/**
	 * Removes all the weblink categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (WeblinkCategory weblinkCategory : findAll()) {
			remove(weblinkCategory);
		}
	}

	/**
	 * Returns the number of weblink categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching weblink categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WEBLINKCATEGORY_WHERE);

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
	 * Returns the number of weblink categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching weblink categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WEBLINKCATEGORY_WHERE);

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
	 * Returns the number of weblink categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching weblink categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_WEBLINKCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WeblinkCategory.class.getName(),
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
	 * Returns the number of weblink categories.
	 *
	 * @return the number of weblink categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WEBLINKCATEGORY);

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
	 * Initializes the weblink category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.weblinks.model.WeblinkCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WeblinkCategory>> listenersList = new ArrayList<ModelListener<WeblinkCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WeblinkCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WeblinkCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = WeblinkPersistence.class)
	protected WeblinkPersistence weblinkPersistence;
	@BeanReference(type = WeblinkCategoryPersistence.class)
	protected WeblinkCategoryPersistence weblinkCategoryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_WEBLINKCATEGORY = "SELECT weblinkCategory FROM WeblinkCategory weblinkCategory";
	private static final String _SQL_SELECT_WEBLINKCATEGORY_WHERE = "SELECT weblinkCategory FROM WeblinkCategory weblinkCategory WHERE ";
	private static final String _SQL_COUNT_WEBLINKCATEGORY = "SELECT COUNT(weblinkCategory) FROM WeblinkCategory weblinkCategory";
	private static final String _SQL_COUNT_WEBLINKCATEGORY_WHERE = "SELECT COUNT(weblinkCategory) FROM WeblinkCategory weblinkCategory WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "weblinkCategory.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "weblinkCategory.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "weblinkCategory.categoryId";
	private static final String _FILTER_SQL_SELECT_WEBLINKCATEGORY_WHERE = "SELECT DISTINCT {weblinkCategory.*} FROM WeblinkCategory weblinkCategory WHERE ";
	private static final String _FILTER_SQL_SELECT_WEBLINKCATEGORY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {WeblinkCategory.*} FROM (SELECT DISTINCT weblinkCategory.categoryId FROM WeblinkCategory weblinkCategory WHERE ";
	private static final String _FILTER_SQL_SELECT_WEBLINKCATEGORY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN WeblinkCategory ON TEMP_TABLE.categoryId = WeblinkCategory.categoryId";
	private static final String _FILTER_SQL_COUNT_WEBLINKCATEGORY_WHERE = "SELECT COUNT(DISTINCT weblinkCategory.categoryId) AS COUNT_VALUE FROM WeblinkCategory weblinkCategory WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "weblinkCategory";
	private static final String _FILTER_ENTITY_TABLE = "WeblinkCategory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "weblinkCategory.";
	private static final String _ORDER_BY_ENTITY_TABLE = "WeblinkCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WeblinkCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WeblinkCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WeblinkCategoryPersistenceImpl.class);
	private static WeblinkCategory _nullWeblinkCategory = new WeblinkCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WeblinkCategory> toCacheModel() {
				return _nullWeblinkCategoryCacheModel;
			}
		};

	private static CacheModel<WeblinkCategory> _nullWeblinkCategoryCacheModel = new CacheModel<WeblinkCategory>() {
			public WeblinkCategory toEntityModel() {
				return _nullWeblinkCategory;
			}
		};
}