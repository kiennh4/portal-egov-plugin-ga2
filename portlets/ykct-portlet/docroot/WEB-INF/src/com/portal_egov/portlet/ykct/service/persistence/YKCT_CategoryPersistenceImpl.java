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

import com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException;
import com.portal_egov.portlet.ykct.model.YKCT_Category;
import com.portal_egov.portlet.ykct.model.impl.YKCT_CategoryImpl;
import com.portal_egov.portlet.ykct.model.impl.YKCT_CategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the y k c t_ category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see YKCT_CategoryPersistence
 * @see YKCT_CategoryUtil
 * @generated
 */
public class YKCT_CategoryPersistenceImpl extends BasePersistenceImpl<YKCT_Category>
	implements YKCT_CategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link YKCT_CategoryUtil} to access the y k c t_ category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = YKCT_CategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_CategoryModelImpl.FINDER_CACHE_ENABLED,
			YKCT_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_CategoryModelImpl.FINDER_CACHE_ENABLED,
			YKCT_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompany", new String[] { Long.class.getName() },
			YKCT_CategoryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_CategoryModelImpl.FINDER_CACHE_ENABLED,
			YKCT_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_CategoryModelImpl.FINDER_CACHE_ENABLED,
			YKCT_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroup", new String[] { Long.class.getName() },
			YKCT_CategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_CategoryModelImpl.FINDER_CACHE_ENABLED,
			YKCT_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_CategoryModelImpl.FINDER_CACHE_ENABLED,
			YKCT_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the y k c t_ category in the entity cache if it is enabled.
	 *
	 * @param ykct_Category the y k c t_ category
	 */
	public void cacheResult(YKCT_Category ykct_Category) {
		EntityCacheUtil.putResult(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_CategoryImpl.class, ykct_Category.getPrimaryKey(),
			ykct_Category);

		ykct_Category.resetOriginalValues();
	}

	/**
	 * Caches the y k c t_ categories in the entity cache if it is enabled.
	 *
	 * @param ykct_Categories the y k c t_ categories
	 */
	public void cacheResult(List<YKCT_Category> ykct_Categories) {
		for (YKCT_Category ykct_Category : ykct_Categories) {
			if (EntityCacheUtil.getResult(
						YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
						YKCT_CategoryImpl.class, ykct_Category.getPrimaryKey()) == null) {
				cacheResult(ykct_Category);
			}
			else {
				ykct_Category.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all y k c t_ categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(YKCT_CategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(YKCT_CategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the y k c t_ category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(YKCT_Category ykct_Category) {
		EntityCacheUtil.removeResult(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_CategoryImpl.class, ykct_Category.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<YKCT_Category> ykct_Categories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (YKCT_Category ykct_Category : ykct_Categories) {
			EntityCacheUtil.removeResult(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				YKCT_CategoryImpl.class, ykct_Category.getPrimaryKey());
		}
	}

	/**
	 * Creates a new y k c t_ category with the primary key. Does not add the y k c t_ category to the database.
	 *
	 * @param categoryId the primary key for the new y k c t_ category
	 * @return the new y k c t_ category
	 */
	public YKCT_Category create(long categoryId) {
		YKCT_Category ykct_Category = new YKCT_CategoryImpl();

		ykct_Category.setNew(true);
		ykct_Category.setPrimaryKey(categoryId);

		return ykct_Category;
	}

	/**
	 * Removes the y k c t_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the y k c t_ category
	 * @return the y k c t_ category that was removed
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a y k c t_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Category remove(long categoryId)
		throws NoSuchYKCT_CategoryException, SystemException {
		return remove(Long.valueOf(categoryId));
	}

	/**
	 * Removes the y k c t_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the y k c t_ category
	 * @return the y k c t_ category that was removed
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a y k c t_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YKCT_Category remove(Serializable primaryKey)
		throws NoSuchYKCT_CategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			YKCT_Category ykct_Category = (YKCT_Category)session.get(YKCT_CategoryImpl.class,
					primaryKey);

			if (ykct_Category == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchYKCT_CategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ykct_Category);
		}
		catch (NoSuchYKCT_CategoryException nsee) {
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
	protected YKCT_Category removeImpl(YKCT_Category ykct_Category)
		throws SystemException {
		ykct_Category = toUnwrappedModel(ykct_Category);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, ykct_Category);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(ykct_Category);

		return ykct_Category;
	}

	@Override
	public YKCT_Category updateImpl(
		com.portal_egov.portlet.ykct.model.YKCT_Category ykct_Category,
		boolean merge) throws SystemException {
		ykct_Category = toUnwrappedModel(ykct_Category);

		boolean isNew = ykct_Category.isNew();

		YKCT_CategoryModelImpl ykct_CategoryModelImpl = (YKCT_CategoryModelImpl)ykct_Category;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, ykct_Category, merge);

			ykct_Category.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !YKCT_CategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ykct_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ykct_CategoryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(ykct_CategoryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((ykct_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ykct_CategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(ykct_CategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			YKCT_CategoryImpl.class, ykct_Category.getPrimaryKey(),
			ykct_Category);

		return ykct_Category;
	}

	protected YKCT_Category toUnwrappedModel(YKCT_Category ykct_Category) {
		if (ykct_Category instanceof YKCT_CategoryImpl) {
			return ykct_Category;
		}

		YKCT_CategoryImpl ykct_CategoryImpl = new YKCT_CategoryImpl();

		ykct_CategoryImpl.setNew(ykct_Category.isNew());
		ykct_CategoryImpl.setPrimaryKey(ykct_Category.getPrimaryKey());

		ykct_CategoryImpl.setCategoryId(ykct_Category.getCategoryId());
		ykct_CategoryImpl.setGroupId(ykct_Category.getGroupId());
		ykct_CategoryImpl.setCompanyId(ykct_Category.getCompanyId());
		ykct_CategoryImpl.setUserId(ykct_Category.getUserId());
		ykct_CategoryImpl.setUserName(ykct_Category.getUserName());
		ykct_CategoryImpl.setCreateDate(ykct_Category.getCreateDate());
		ykct_CategoryImpl.setModifiedDate(ykct_Category.getModifiedDate());
		ykct_CategoryImpl.setCategoryName(ykct_Category.getCategoryName());
		ykct_CategoryImpl.setCategoryDesc(ykct_Category.getCategoryDesc());

		return ykct_CategoryImpl;
	}

	/**
	 * Returns the y k c t_ category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the y k c t_ category
	 * @return the y k c t_ category
	 * @throws com.liferay.portal.NoSuchModelException if a y k c t_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YKCT_Category findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the y k c t_ category with the primary key or throws a {@link com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the y k c t_ category
	 * @return the y k c t_ category
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a y k c t_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Category findByPrimaryKey(long categoryId)
		throws NoSuchYKCT_CategoryException, SystemException {
		YKCT_Category ykct_Category = fetchByPrimaryKey(categoryId);

		if (ykct_Category == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
			}

			throw new NoSuchYKCT_CategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryId);
		}

		return ykct_Category;
	}

	/**
	 * Returns the y k c t_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the y k c t_ category
	 * @return the y k c t_ category, or <code>null</code> if a y k c t_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YKCT_Category fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the y k c t_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the y k c t_ category
	 * @return the y k c t_ category, or <code>null</code> if a y k c t_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Category fetchByPrimaryKey(long categoryId)
		throws SystemException {
		YKCT_Category ykct_Category = (YKCT_Category)EntityCacheUtil.getResult(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				YKCT_CategoryImpl.class, categoryId);

		if (ykct_Category == _nullYKCT_Category) {
			return null;
		}

		if (ykct_Category == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				ykct_Category = (YKCT_Category)session.get(YKCT_CategoryImpl.class,
						Long.valueOf(categoryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (ykct_Category != null) {
					cacheResult(ykct_Category);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(YKCT_CategoryModelImpl.ENTITY_CACHE_ENABLED,
						YKCT_CategoryImpl.class, categoryId, _nullYKCT_Category);
				}

				closeSession(session);
			}
		}

		return ykct_Category;
	}

	/**
	 * Returns all the y k c t_ categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching y k c t_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Category> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the y k c t_ categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of y k c t_ categories
	 * @param end the upper bound of the range of y k c t_ categories (not inclusive)
	 * @return the range of matching y k c t_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Category> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the y k c t_ categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of y k c t_ categories
	 * @param end the upper bound of the range of y k c t_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching y k c t_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Category> findByCompany(long companyId, int start,
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

		List<YKCT_Category> list = (List<YKCT_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (YKCT_Category ykct_Category : list) {
				if ((companyId != ykct_Category.getCompanyId())) {
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

			query.append(_SQL_SELECT_YKCT_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(YKCT_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<YKCT_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first y k c t_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y k c t_ category
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a matching y k c t_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Category findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_CategoryException, SystemException {
		YKCT_Category ykct_Category = fetchByCompany_First(companyId,
				orderByComparator);

		if (ykct_Category != null) {
			return ykct_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYKCT_CategoryException(msg.toString());
	}

	/**
	 * Returns the first y k c t_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y k c t_ category, or <code>null</code> if a matching y k c t_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Category fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<YKCT_Category> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last y k c t_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y k c t_ category
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a matching y k c t_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Category findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_CategoryException, SystemException {
		YKCT_Category ykct_Category = fetchByCompany_Last(companyId,
				orderByComparator);

		if (ykct_Category != null) {
			return ykct_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYKCT_CategoryException(msg.toString());
	}

	/**
	 * Returns the last y k c t_ category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y k c t_ category, or <code>null</code> if a matching y k c t_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Category fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<YKCT_Category> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the y k c t_ categories before and after the current y k c t_ category in the ordered set where companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current y k c t_ category
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next y k c t_ category
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a y k c t_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Category[] findByCompany_PrevAndNext(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchYKCT_CategoryException, SystemException {
		YKCT_Category ykct_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			YKCT_Category[] array = new YKCT_CategoryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, ykct_Category,
					companyId, orderByComparator, true);

			array[1] = ykct_Category;

			array[2] = getByCompany_PrevAndNext(session, ykct_Category,
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

	protected YKCT_Category getByCompany_PrevAndNext(Session session,
		YKCT_Category ykct_Category, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_YKCT_CATEGORY_WHERE);

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
			query.append(YKCT_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ykct_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<YKCT_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the y k c t_ categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching y k c t_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Category> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the y k c t_ categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of y k c t_ categories
	 * @param end the upper bound of the range of y k c t_ categories (not inclusive)
	 * @return the range of matching y k c t_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Category> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the y k c t_ categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of y k c t_ categories
	 * @param end the upper bound of the range of y k c t_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching y k c t_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Category> findByGroup(long groupId, int start, int end,
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

		List<YKCT_Category> list = (List<YKCT_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (YKCT_Category ykct_Category : list) {
				if ((groupId != ykct_Category.getGroupId())) {
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

			query.append(_SQL_SELECT_YKCT_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(YKCT_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<YKCT_Category>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first y k c t_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y k c t_ category
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a matching y k c t_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Category findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_CategoryException, SystemException {
		YKCT_Category ykct_Category = fetchByGroup_First(groupId,
				orderByComparator);

		if (ykct_Category != null) {
			return ykct_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYKCT_CategoryException(msg.toString());
	}

	/**
	 * Returns the first y k c t_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching y k c t_ category, or <code>null</code> if a matching y k c t_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Category fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<YKCT_Category> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last y k c t_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y k c t_ category
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a matching y k c t_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Category findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchYKCT_CategoryException, SystemException {
		YKCT_Category ykct_Category = fetchByGroup_Last(groupId,
				orderByComparator);

		if (ykct_Category != null) {
			return ykct_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYKCT_CategoryException(msg.toString());
	}

	/**
	 * Returns the last y k c t_ category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching y k c t_ category, or <code>null</code> if a matching y k c t_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Category fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<YKCT_Category> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the y k c t_ categories before and after the current y k c t_ category in the ordered set where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current y k c t_ category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next y k c t_ category
	 * @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a y k c t_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public YKCT_Category[] findByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchYKCT_CategoryException, SystemException {
		YKCT_Category ykct_Category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			YKCT_Category[] array = new YKCT_CategoryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, ykct_Category, groupId,
					orderByComparator, true);

			array[1] = ykct_Category;

			array[2] = getByGroup_PrevAndNext(session, ykct_Category, groupId,
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

	protected YKCT_Category getByGroup_PrevAndNext(Session session,
		YKCT_Category ykct_Category, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_YKCT_CATEGORY_WHERE);

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
			query.append(YKCT_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ykct_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<YKCT_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the y k c t_ categories.
	 *
	 * @return the y k c t_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Category> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the y k c t_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of y k c t_ categories
	 * @param end the upper bound of the range of y k c t_ categories (not inclusive)
	 * @return the range of y k c t_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Category> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the y k c t_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of y k c t_ categories
	 * @param end the upper bound of the range of y k c t_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of y k c t_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<YKCT_Category> findAll(int start, int end,
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

		List<YKCT_Category> list = (List<YKCT_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_YKCT_CATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_YKCT_CATEGORY.concat(YKCT_CategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<YKCT_Category>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<YKCT_Category>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the y k c t_ categories where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (YKCT_Category ykct_Category : findByCompany(companyId)) {
			remove(ykct_Category);
		}
	}

	/**
	 * Removes all the y k c t_ categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (YKCT_Category ykct_Category : findByGroup(groupId)) {
			remove(ykct_Category);
		}
	}

	/**
	 * Removes all the y k c t_ categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (YKCT_Category ykct_Category : findAll()) {
			remove(ykct_Category);
		}
	}

	/**
	 * Returns the number of y k c t_ categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching y k c t_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YKCT_CATEGORY_WHERE);

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
	 * Returns the number of y k c t_ categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching y k c t_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YKCT_CATEGORY_WHERE);

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
	 * Returns the number of y k c t_ categories.
	 *
	 * @return the number of y k c t_ categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_YKCT_CATEGORY);

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
	 * Initializes the y k c t_ category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.ykct.model.YKCT_Category")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<YKCT_Category>> listenersList = new ArrayList<ModelListener<YKCT_Category>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<YKCT_Category>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(YKCT_CategoryImpl.class.getName());
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
	private static final String _SQL_SELECT_YKCT_CATEGORY = "SELECT ykct_Category FROM YKCT_Category ykct_Category";
	private static final String _SQL_SELECT_YKCT_CATEGORY_WHERE = "SELECT ykct_Category FROM YKCT_Category ykct_Category WHERE ";
	private static final String _SQL_COUNT_YKCT_CATEGORY = "SELECT COUNT(ykct_Category) FROM YKCT_Category ykct_Category";
	private static final String _SQL_COUNT_YKCT_CATEGORY_WHERE = "SELECT COUNT(ykct_Category) FROM YKCT_Category ykct_Category WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "ykct_Category.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "ykct_Category.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ykct_Category.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No YKCT_Category exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No YKCT_Category exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(YKCT_CategoryPersistenceImpl.class);
	private static YKCT_Category _nullYKCT_Category = new YKCT_CategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<YKCT_Category> toCacheModel() {
				return _nullYKCT_CategoryCacheModel;
			}
		};

	private static CacheModel<YKCT_Category> _nullYKCT_CategoryCacheModel = new CacheModel<YKCT_Category>() {
			public YKCT_Category toEntityModel() {
				return _nullYKCT_Category;
			}
		};
}