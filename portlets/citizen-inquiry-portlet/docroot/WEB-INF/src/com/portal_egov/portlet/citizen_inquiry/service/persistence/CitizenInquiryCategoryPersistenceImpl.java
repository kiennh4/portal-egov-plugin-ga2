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

package com.portal_egov.portlet.citizen_inquiry.service.persistence;

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

import com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException;
import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory;
import com.portal_egov.portlet.citizen_inquiry.model.impl.CitizenInquiryCategoryImpl;
import com.portal_egov.portlet.citizen_inquiry.model.impl.CitizenInquiryCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the citizen inquiry category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see CitizenInquiryCategoryPersistence
 * @see CitizenInquiryCategoryUtil
 * @generated
 */
public class CitizenInquiryCategoryPersistenceImpl extends BasePersistenceImpl<CitizenInquiryCategory>
	implements CitizenInquiryCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CitizenInquiryCategoryUtil} to access the citizen inquiry category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CitizenInquiryCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryCategoryModelImpl.FINDER_CACHE_ENABLED,
			CitizenInquiryCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryCategoryModelImpl.FINDER_CACHE_ENABLED,
			CitizenInquiryCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			CitizenInquiryCategoryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryCategoryModelImpl.FINDER_CACHE_ENABLED,
			CitizenInquiryCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryCategoryModelImpl.FINDER_CACHE_ENABLED,
			CitizenInquiryCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			CitizenInquiryCategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryCategoryModelImpl.FINDER_CACHE_ENABLED,
			CitizenInquiryCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryCategoryModelImpl.FINDER_CACHE_ENABLED,
			CitizenInquiryCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the citizen inquiry category in the entity cache if it is enabled.
	 *
	 * @param citizenInquiryCategory the citizen inquiry category
	 */
	public void cacheResult(CitizenInquiryCategory citizenInquiryCategory) {
		EntityCacheUtil.putResult(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryCategoryImpl.class,
			citizenInquiryCategory.getPrimaryKey(), citizenInquiryCategory);

		citizenInquiryCategory.resetOriginalValues();
	}

	/**
	 * Caches the citizen inquiry categories in the entity cache if it is enabled.
	 *
	 * @param citizenInquiryCategories the citizen inquiry categories
	 */
	public void cacheResult(
		List<CitizenInquiryCategory> citizenInquiryCategories) {
		for (CitizenInquiryCategory citizenInquiryCategory : citizenInquiryCategories) {
			if (EntityCacheUtil.getResult(
						CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
						CitizenInquiryCategoryImpl.class,
						citizenInquiryCategory.getPrimaryKey()) == null) {
				cacheResult(citizenInquiryCategory);
			}
			else {
				citizenInquiryCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all citizen inquiry categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CitizenInquiryCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CitizenInquiryCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the citizen inquiry category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CitizenInquiryCategory citizenInquiryCategory) {
		EntityCacheUtil.removeResult(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryCategoryImpl.class,
			citizenInquiryCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<CitizenInquiryCategory> citizenInquiryCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CitizenInquiryCategory citizenInquiryCategory : citizenInquiryCategories) {
			EntityCacheUtil.removeResult(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
				CitizenInquiryCategoryImpl.class,
				citizenInquiryCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new citizen inquiry category with the primary key. Does not add the citizen inquiry category to the database.
	 *
	 * @param categoryId the primary key for the new citizen inquiry category
	 * @return the new citizen inquiry category
	 */
	public CitizenInquiryCategory create(long categoryId) {
		CitizenInquiryCategory citizenInquiryCategory = new CitizenInquiryCategoryImpl();

		citizenInquiryCategory.setNew(true);
		citizenInquiryCategory.setPrimaryKey(categoryId);

		return citizenInquiryCategory;
	}

	/**
	 * Removes the citizen inquiry category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the citizen inquiry category
	 * @return the citizen inquiry category that was removed
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a citizen inquiry category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiryCategory remove(long categoryId)
		throws NoSuchCitizenInquiryCategoryException, SystemException {
		return remove(Long.valueOf(categoryId));
	}

	/**
	 * Removes the citizen inquiry category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the citizen inquiry category
	 * @return the citizen inquiry category that was removed
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a citizen inquiry category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CitizenInquiryCategory remove(Serializable primaryKey)
		throws NoSuchCitizenInquiryCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CitizenInquiryCategory citizenInquiryCategory = (CitizenInquiryCategory)session.get(CitizenInquiryCategoryImpl.class,
					primaryKey);

			if (citizenInquiryCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCitizenInquiryCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(citizenInquiryCategory);
		}
		catch (NoSuchCitizenInquiryCategoryException nsee) {
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
	protected CitizenInquiryCategory removeImpl(
		CitizenInquiryCategory citizenInquiryCategory)
		throws SystemException {
		citizenInquiryCategory = toUnwrappedModel(citizenInquiryCategory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, citizenInquiryCategory);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(citizenInquiryCategory);

		return citizenInquiryCategory;
	}

	@Override
	public CitizenInquiryCategory updateImpl(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory citizenInquiryCategory,
		boolean merge) throws SystemException {
		citizenInquiryCategory = toUnwrappedModel(citizenInquiryCategory);

		boolean isNew = citizenInquiryCategory.isNew();

		CitizenInquiryCategoryModelImpl citizenInquiryCategoryModelImpl = (CitizenInquiryCategoryModelImpl)citizenInquiryCategory;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, citizenInquiryCategory, merge);

			citizenInquiryCategory.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CitizenInquiryCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((citizenInquiryCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(citizenInquiryCategoryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(citizenInquiryCategoryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((citizenInquiryCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(citizenInquiryCategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(citizenInquiryCategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
			CitizenInquiryCategoryImpl.class,
			citizenInquiryCategory.getPrimaryKey(), citizenInquiryCategory);

		return citizenInquiryCategory;
	}

	protected CitizenInquiryCategory toUnwrappedModel(
		CitizenInquiryCategory citizenInquiryCategory) {
		if (citizenInquiryCategory instanceof CitizenInquiryCategoryImpl) {
			return citizenInquiryCategory;
		}

		CitizenInquiryCategoryImpl citizenInquiryCategoryImpl = new CitizenInquiryCategoryImpl();

		citizenInquiryCategoryImpl.setNew(citizenInquiryCategory.isNew());
		citizenInquiryCategoryImpl.setPrimaryKey(citizenInquiryCategory.getPrimaryKey());

		citizenInquiryCategoryImpl.setCategoryId(citizenInquiryCategory.getCategoryId());
		citizenInquiryCategoryImpl.setGroupId(citizenInquiryCategory.getGroupId());
		citizenInquiryCategoryImpl.setCompanyId(citizenInquiryCategory.getCompanyId());
		citizenInquiryCategoryImpl.setUserId(citizenInquiryCategory.getUserId());
		citizenInquiryCategoryImpl.setUserName(citizenInquiryCategory.getUserName());
		citizenInquiryCategoryImpl.setCreateDate(citizenInquiryCategory.getCreateDate());
		citizenInquiryCategoryImpl.setModifiedDate(citizenInquiryCategory.getModifiedDate());
		citizenInquiryCategoryImpl.setCategoryName(citizenInquiryCategory.getCategoryName());
		citizenInquiryCategoryImpl.setCategoryDesc(citizenInquiryCategory.getCategoryDesc());

		return citizenInquiryCategoryImpl;
	}

	/**
	 * Returns the citizen inquiry category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the citizen inquiry category
	 * @return the citizen inquiry category
	 * @throws com.liferay.portal.NoSuchModelException if a citizen inquiry category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CitizenInquiryCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the citizen inquiry category with the primary key or throws a {@link com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the citizen inquiry category
	 * @return the citizen inquiry category
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a citizen inquiry category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiryCategory findByPrimaryKey(long categoryId)
		throws NoSuchCitizenInquiryCategoryException, SystemException {
		CitizenInquiryCategory citizenInquiryCategory = fetchByPrimaryKey(categoryId);

		if (citizenInquiryCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
			}

			throw new NoSuchCitizenInquiryCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryId);
		}

		return citizenInquiryCategory;
	}

	/**
	 * Returns the citizen inquiry category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the citizen inquiry category
	 * @return the citizen inquiry category, or <code>null</code> if a citizen inquiry category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CitizenInquiryCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the citizen inquiry category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the citizen inquiry category
	 * @return the citizen inquiry category, or <code>null</code> if a citizen inquiry category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiryCategory fetchByPrimaryKey(long categoryId)
		throws SystemException {
		CitizenInquiryCategory citizenInquiryCategory = (CitizenInquiryCategory)EntityCacheUtil.getResult(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
				CitizenInquiryCategoryImpl.class, categoryId);

		if (citizenInquiryCategory == _nullCitizenInquiryCategory) {
			return null;
		}

		if (citizenInquiryCategory == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				citizenInquiryCategory = (CitizenInquiryCategory)session.get(CitizenInquiryCategoryImpl.class,
						Long.valueOf(categoryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (citizenInquiryCategory != null) {
					cacheResult(citizenInquiryCategory);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CitizenInquiryCategoryModelImpl.ENTITY_CACHE_ENABLED,
						CitizenInquiryCategoryImpl.class, categoryId,
						_nullCitizenInquiryCategory);
				}

				closeSession(session);
			}
		}

		return citizenInquiryCategory;
	}

	/**
	 * Returns all the citizen inquiry categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching citizen inquiry categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiryCategory> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the citizen inquiry categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of citizen inquiry categories
	 * @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	 * @return the range of matching citizen inquiry categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiryCategory> findByCompany(long companyId,
		int start, int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizen inquiry categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of citizen inquiry categories
	 * @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizen inquiry categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiryCategory> findByCompany(long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<CitizenInquiryCategory> list = (List<CitizenInquiryCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CitizenInquiryCategory citizenInquiryCategory : list) {
				if ((companyId != citizenInquiryCategory.getCompanyId())) {
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

			query.append(_SQL_SELECT_CITIZENINQUIRYCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CitizenInquiryCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<CitizenInquiryCategory>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first citizen inquiry category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen inquiry category
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a matching citizen inquiry category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiryCategory findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryCategoryException, SystemException {
		CitizenInquiryCategory citizenInquiryCategory = fetchByCompany_First(companyId,
				orderByComparator);

		if (citizenInquiryCategory != null) {
			return citizenInquiryCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenInquiryCategoryException(msg.toString());
	}

	/**
	 * Returns the first citizen inquiry category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen inquiry category, or <code>null</code> if a matching citizen inquiry category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiryCategory fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CitizenInquiryCategory> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last citizen inquiry category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen inquiry category
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a matching citizen inquiry category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiryCategory findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryCategoryException, SystemException {
		CitizenInquiryCategory citizenInquiryCategory = fetchByCompany_Last(companyId,
				orderByComparator);

		if (citizenInquiryCategory != null) {
			return citizenInquiryCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenInquiryCategoryException(msg.toString());
	}

	/**
	 * Returns the last citizen inquiry category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen inquiry category, or <code>null</code> if a matching citizen inquiry category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiryCategory fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<CitizenInquiryCategory> list = findByCompany(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the citizen inquiry categories before and after the current citizen inquiry category in the ordered set where companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current citizen inquiry category
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen inquiry category
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a citizen inquiry category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiryCategory[] findByCompany_PrevAndNext(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryCategoryException, SystemException {
		CitizenInquiryCategory citizenInquiryCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CitizenInquiryCategory[] array = new CitizenInquiryCategoryImpl[3];

			array[0] = getByCompany_PrevAndNext(session,
					citizenInquiryCategory, companyId, orderByComparator, true);

			array[1] = citizenInquiryCategory;

			array[2] = getByCompany_PrevAndNext(session,
					citizenInquiryCategory, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CitizenInquiryCategory getByCompany_PrevAndNext(Session session,
		CitizenInquiryCategory citizenInquiryCategory, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITIZENINQUIRYCATEGORY_WHERE);

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
			query.append(CitizenInquiryCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizenInquiryCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CitizenInquiryCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the citizen inquiry categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching citizen inquiry categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiryCategory> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizen inquiry categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of citizen inquiry categories
	 * @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	 * @return the range of matching citizen inquiry categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiryCategory> findByGroup(long groupId, int start,
		int end) throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizen inquiry categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of citizen inquiry categories
	 * @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizen inquiry categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiryCategory> findByGroup(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<CitizenInquiryCategory> list = (List<CitizenInquiryCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CitizenInquiryCategory citizenInquiryCategory : list) {
				if ((groupId != citizenInquiryCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_CITIZENINQUIRYCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CitizenInquiryCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<CitizenInquiryCategory>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first citizen inquiry category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen inquiry category
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a matching citizen inquiry category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiryCategory findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryCategoryException, SystemException {
		CitizenInquiryCategory citizenInquiryCategory = fetchByGroup_First(groupId,
				orderByComparator);

		if (citizenInquiryCategory != null) {
			return citizenInquiryCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenInquiryCategoryException(msg.toString());
	}

	/**
	 * Returns the first citizen inquiry category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen inquiry category, or <code>null</code> if a matching citizen inquiry category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiryCategory fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CitizenInquiryCategory> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last citizen inquiry category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen inquiry category
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a matching citizen inquiry category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiryCategory findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryCategoryException, SystemException {
		CitizenInquiryCategory citizenInquiryCategory = fetchByGroup_Last(groupId,
				orderByComparator);

		if (citizenInquiryCategory != null) {
			return citizenInquiryCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenInquiryCategoryException(msg.toString());
	}

	/**
	 * Returns the last citizen inquiry category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen inquiry category, or <code>null</code> if a matching citizen inquiry category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiryCategory fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<CitizenInquiryCategory> list = findByGroup(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the citizen inquiry categories before and after the current citizen inquiry category in the ordered set where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current citizen inquiry category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen inquiry category
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a citizen inquiry category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiryCategory[] findByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryCategoryException, SystemException {
		CitizenInquiryCategory citizenInquiryCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CitizenInquiryCategory[] array = new CitizenInquiryCategoryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, citizenInquiryCategory,
					groupId, orderByComparator, true);

			array[1] = citizenInquiryCategory;

			array[2] = getByGroup_PrevAndNext(session, citizenInquiryCategory,
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

	protected CitizenInquiryCategory getByGroup_PrevAndNext(Session session,
		CitizenInquiryCategory citizenInquiryCategory, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITIZENINQUIRYCATEGORY_WHERE);

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
			query.append(CitizenInquiryCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizenInquiryCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CitizenInquiryCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the citizen inquiry categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching citizen inquiry categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiryCategory> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the citizen inquiry categories that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of citizen inquiry categories
	 * @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	 * @return the range of matching citizen inquiry categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiryCategory> filterFindByGroup(long groupId,
		int start, int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizen inquiry categories that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of citizen inquiry categories
	 * @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizen inquiry categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiryCategory> filterFindByGroup(long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_CITIZENINQUIRYCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZENINQUIRYCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZENINQUIRYCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CitizenInquiryCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenInquiryCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CitizenInquiryCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS,
					CitizenInquiryCategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE,
					CitizenInquiryCategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<CitizenInquiryCategory>)QueryUtil.list(q,
				getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the citizen inquiry categories before and after the current citizen inquiry category in the ordered set of citizen inquiry categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current citizen inquiry category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen inquiry category
	 * @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a citizen inquiry category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CitizenInquiryCategory[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCitizenInquiryCategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(categoryId, groupId,
				orderByComparator);
		}

		CitizenInquiryCategory citizenInquiryCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CitizenInquiryCategory[] array = new CitizenInquiryCategoryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session,
					citizenInquiryCategory, groupId, orderByComparator, true);

			array[1] = citizenInquiryCategory;

			array[2] = filterGetByGroup_PrevAndNext(session,
					citizenInquiryCategory, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CitizenInquiryCategory filterGetByGroup_PrevAndNext(
		Session session, CitizenInquiryCategory citizenInquiryCategory,
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
			query.append(_FILTER_SQL_SELECT_CITIZENINQUIRYCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZENINQUIRYCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZENINQUIRYCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CitizenInquiryCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenInquiryCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CitizenInquiryCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CitizenInquiryCategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CitizenInquiryCategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizenInquiryCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CitizenInquiryCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the citizen inquiry categories.
	 *
	 * @return the citizen inquiry categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiryCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizen inquiry categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of citizen inquiry categories
	 * @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	 * @return the range of citizen inquiry categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiryCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizen inquiry categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of citizen inquiry categories
	 * @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of citizen inquiry categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<CitizenInquiryCategory> findAll(int start, int end,
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

		List<CitizenInquiryCategory> list = (List<CitizenInquiryCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CITIZENINQUIRYCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CITIZENINQUIRYCATEGORY.concat(CitizenInquiryCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CitizenInquiryCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CitizenInquiryCategory>)QueryUtil.list(q,
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
	 * Removes all the citizen inquiry categories where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (CitizenInquiryCategory citizenInquiryCategory : findByCompany(
				companyId)) {
			remove(citizenInquiryCategory);
		}
	}

	/**
	 * Removes all the citizen inquiry categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (CitizenInquiryCategory citizenInquiryCategory : findByGroup(
				groupId)) {
			remove(citizenInquiryCategory);
		}
	}

	/**
	 * Removes all the citizen inquiry categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CitizenInquiryCategory citizenInquiryCategory : findAll()) {
			remove(citizenInquiryCategory);
		}
	}

	/**
	 * Returns the number of citizen inquiry categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching citizen inquiry categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITIZENINQUIRYCATEGORY_WHERE);

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
	 * Returns the number of citizen inquiry categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching citizen inquiry categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITIZENINQUIRYCATEGORY_WHERE);

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
	 * Returns the number of citizen inquiry categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching citizen inquiry categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CITIZENINQUIRYCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CitizenInquiryCategory.class.getName(),
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
	 * Returns the number of citizen inquiry categories.
	 *
	 * @return the number of citizen inquiry categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CITIZENINQUIRYCATEGORY);

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
	 * Initializes the citizen inquiry category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CitizenInquiryCategory>> listenersList = new ArrayList<ModelListener<CitizenInquiryCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CitizenInquiryCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CitizenInquiryCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CitizenInquiryPersistence.class)
	protected CitizenInquiryPersistence citizenInquiryPersistence;
	@BeanReference(type = CitizenInquiryCategoryPersistence.class)
	protected CitizenInquiryCategoryPersistence citizenInquiryCategoryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CITIZENINQUIRYCATEGORY = "SELECT citizenInquiryCategory FROM CitizenInquiryCategory citizenInquiryCategory";
	private static final String _SQL_SELECT_CITIZENINQUIRYCATEGORY_WHERE = "SELECT citizenInquiryCategory FROM CitizenInquiryCategory citizenInquiryCategory WHERE ";
	private static final String _SQL_COUNT_CITIZENINQUIRYCATEGORY = "SELECT COUNT(citizenInquiryCategory) FROM CitizenInquiryCategory citizenInquiryCategory";
	private static final String _SQL_COUNT_CITIZENINQUIRYCATEGORY_WHERE = "SELECT COUNT(citizenInquiryCategory) FROM CitizenInquiryCategory citizenInquiryCategory WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "citizenInquiryCategory.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "citizenInquiryCategory.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "citizenInquiryCategory.categoryId";
	private static final String _FILTER_SQL_SELECT_CITIZENINQUIRYCATEGORY_WHERE = "SELECT DISTINCT {citizenInquiryCategory.*} FROM CitizenInquiryCategory citizenInquiryCategory WHERE ";
	private static final String _FILTER_SQL_SELECT_CITIZENINQUIRYCATEGORY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {CitizenInquiryCategory.*} FROM (SELECT DISTINCT citizenInquiryCategory.categoryId FROM CitizenInquiryCategory citizenInquiryCategory WHERE ";
	private static final String _FILTER_SQL_SELECT_CITIZENINQUIRYCATEGORY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN CitizenInquiryCategory ON TEMP_TABLE.categoryId = CitizenInquiryCategory.categoryId";
	private static final String _FILTER_SQL_COUNT_CITIZENINQUIRYCATEGORY_WHERE = "SELECT COUNT(DISTINCT citizenInquiryCategory.categoryId) AS COUNT_VALUE FROM CitizenInquiryCategory citizenInquiryCategory WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "citizenInquiryCategory";
	private static final String _FILTER_ENTITY_TABLE = "CitizenInquiryCategory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "citizenInquiryCategory.";
	private static final String _ORDER_BY_ENTITY_TABLE = "CitizenInquiryCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CitizenInquiryCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CitizenInquiryCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CitizenInquiryCategoryPersistenceImpl.class);
	private static CitizenInquiryCategory _nullCitizenInquiryCategory = new CitizenInquiryCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CitizenInquiryCategory> toCacheModel() {
				return _nullCitizenInquiryCategoryCacheModel;
			}
		};

	private static CacheModel<CitizenInquiryCategory> _nullCitizenInquiryCategoryCacheModel =
		new CacheModel<CitizenInquiryCategory>() {
			public CitizenInquiryCategory toEntityModel() {
				return _nullCitizenInquiryCategory;
			}
		};
}