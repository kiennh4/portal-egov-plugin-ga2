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

import com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException;
import com.portal_egov.portlet.legal_faq.model.LegalFAQCategory;
import com.portal_egov.portlet.legal_faq.model.impl.LegalFAQCategoryImpl;
import com.portal_egov.portlet.legal_faq.model.impl.LegalFAQCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the legal f a q category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see LegalFAQCategoryPersistence
 * @see LegalFAQCategoryUtil
 * @generated
 */
public class LegalFAQCategoryPersistenceImpl extends BasePersistenceImpl<LegalFAQCategory>
	implements LegalFAQCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegalFAQCategoryUtil} to access the legal f a q category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegalFAQCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			LegalFAQCategoryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			LegalFAQCategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT = new FinderPath(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParent",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT =
		new FinderPath(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParent",
			new String[] { Long.class.getName(), Long.class.getName() },
			LegalFAQCategoryModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalFAQCategoryModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENT = new FinderPath(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParent",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryModelImpl.FINDER_CACHE_ENABLED,
			LegalFAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the legal f a q category in the entity cache if it is enabled.
	 *
	 * @param legalFAQCategory the legal f a q category
	 */
	public void cacheResult(LegalFAQCategory legalFAQCategory) {
		EntityCacheUtil.putResult(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryImpl.class, legalFAQCategory.getPrimaryKey(),
			legalFAQCategory);

		legalFAQCategory.resetOriginalValues();
	}

	/**
	 * Caches the legal f a q categories in the entity cache if it is enabled.
	 *
	 * @param legalFAQCategories the legal f a q categories
	 */
	public void cacheResult(List<LegalFAQCategory> legalFAQCategories) {
		for (LegalFAQCategory legalFAQCategory : legalFAQCategories) {
			if (EntityCacheUtil.getResult(
						LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
						LegalFAQCategoryImpl.class,
						legalFAQCategory.getPrimaryKey()) == null) {
				cacheResult(legalFAQCategory);
			}
			else {
				legalFAQCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal f a q categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegalFAQCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegalFAQCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal f a q category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalFAQCategory legalFAQCategory) {
		EntityCacheUtil.removeResult(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryImpl.class, legalFAQCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegalFAQCategory> legalFAQCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalFAQCategory legalFAQCategory : legalFAQCategories) {
			EntityCacheUtil.removeResult(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
				LegalFAQCategoryImpl.class, legalFAQCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legal f a q category with the primary key. Does not add the legal f a q category to the database.
	 *
	 * @param categoryId the primary key for the new legal f a q category
	 * @return the new legal f a q category
	 */
	public LegalFAQCategory create(long categoryId) {
		LegalFAQCategory legalFAQCategory = new LegalFAQCategoryImpl();

		legalFAQCategory.setNew(true);
		legalFAQCategory.setPrimaryKey(categoryId);

		return legalFAQCategory;
	}

	/**
	 * Removes the legal f a q category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the legal f a q category
	 * @return the legal f a q category that was removed
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a legal f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory remove(long categoryId)
		throws NoSuchLegalFAQCategoryException, SystemException {
		return remove(Long.valueOf(categoryId));
	}

	/**
	 * Removes the legal f a q category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal f a q category
	 * @return the legal f a q category that was removed
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a legal f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalFAQCategory remove(Serializable primaryKey)
		throws NoSuchLegalFAQCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegalFAQCategory legalFAQCategory = (LegalFAQCategory)session.get(LegalFAQCategoryImpl.class,
					primaryKey);

			if (legalFAQCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalFAQCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legalFAQCategory);
		}
		catch (NoSuchLegalFAQCategoryException nsee) {
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
	protected LegalFAQCategory removeImpl(LegalFAQCategory legalFAQCategory)
		throws SystemException {
		legalFAQCategory = toUnwrappedModel(legalFAQCategory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, legalFAQCategory);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(legalFAQCategory);

		return legalFAQCategory;
	}

	@Override
	public LegalFAQCategory updateImpl(
		com.portal_egov.portlet.legal_faq.model.LegalFAQCategory legalFAQCategory,
		boolean merge) throws SystemException {
		legalFAQCategory = toUnwrappedModel(legalFAQCategory);

		boolean isNew = legalFAQCategory.isNew();

		LegalFAQCategoryModelImpl legalFAQCategoryModelImpl = (LegalFAQCategoryModelImpl)legalFAQCategory;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, legalFAQCategory, merge);

			legalFAQCategory.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LegalFAQCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((legalFAQCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(legalFAQCategoryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(legalFAQCategoryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((legalFAQCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(legalFAQCategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(legalFAQCategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((legalFAQCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(legalFAQCategoryModelImpl.getOriginalCompanyId()),
						Long.valueOf(legalFAQCategoryModelImpl.getOriginalParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
					args);

				args = new Object[] {
						Long.valueOf(legalFAQCategoryModelImpl.getCompanyId()),
						Long.valueOf(legalFAQCategoryModelImpl.getParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
					args);
			}
		}

		EntityCacheUtil.putResult(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			LegalFAQCategoryImpl.class, legalFAQCategory.getPrimaryKey(),
			legalFAQCategory);

		return legalFAQCategory;
	}

	protected LegalFAQCategory toUnwrappedModel(
		LegalFAQCategory legalFAQCategory) {
		if (legalFAQCategory instanceof LegalFAQCategoryImpl) {
			return legalFAQCategory;
		}

		LegalFAQCategoryImpl legalFAQCategoryImpl = new LegalFAQCategoryImpl();

		legalFAQCategoryImpl.setNew(legalFAQCategory.isNew());
		legalFAQCategoryImpl.setPrimaryKey(legalFAQCategory.getPrimaryKey());

		legalFAQCategoryImpl.setCategoryId(legalFAQCategory.getCategoryId());
		legalFAQCategoryImpl.setCompanyId(legalFAQCategory.getCompanyId());
		legalFAQCategoryImpl.setGroupId(legalFAQCategory.getGroupId());
		legalFAQCategoryImpl.setUserId(legalFAQCategory.getUserId());
		legalFAQCategoryImpl.setParentId(legalFAQCategory.getParentId());
		legalFAQCategoryImpl.setCategoryName(legalFAQCategory.getCategoryName());
		legalFAQCategoryImpl.setCategoryDesc(legalFAQCategory.getCategoryDesc());
		legalFAQCategoryImpl.setCreateDate(legalFAQCategory.getCreateDate());
		legalFAQCategoryImpl.setModifiedDate(legalFAQCategory.getModifiedDate());

		return legalFAQCategoryImpl;
	}

	/**
	 * Returns the legal f a q category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal f a q category
	 * @return the legal f a q category
	 * @throws com.liferay.portal.NoSuchModelException if a legal f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalFAQCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the legal f a q category with the primary key or throws a {@link com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the legal f a q category
	 * @return the legal f a q category
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a legal f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory findByPrimaryKey(long categoryId)
		throws NoSuchLegalFAQCategoryException, SystemException {
		LegalFAQCategory legalFAQCategory = fetchByPrimaryKey(categoryId);

		if (legalFAQCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
			}

			throw new NoSuchLegalFAQCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryId);
		}

		return legalFAQCategory;
	}

	/**
	 * Returns the legal f a q category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal f a q category
	 * @return the legal f a q category, or <code>null</code> if a legal f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegalFAQCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the legal f a q category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the legal f a q category
	 * @return the legal f a q category, or <code>null</code> if a legal f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory fetchByPrimaryKey(long categoryId)
		throws SystemException {
		LegalFAQCategory legalFAQCategory = (LegalFAQCategory)EntityCacheUtil.getResult(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
				LegalFAQCategoryImpl.class, categoryId);

		if (legalFAQCategory == _nullLegalFAQCategory) {
			return null;
		}

		if (legalFAQCategory == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				legalFAQCategory = (LegalFAQCategory)session.get(LegalFAQCategoryImpl.class,
						Long.valueOf(categoryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (legalFAQCategory != null) {
					cacheResult(legalFAQCategory);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LegalFAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
						LegalFAQCategoryImpl.class, categoryId,
						_nullLegalFAQCategory);
				}

				closeSession(session);
			}
		}

		return legalFAQCategory;
	}

	/**
	 * Returns all the legal f a q categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal f a q categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal f a q categories
	 * @param end the upper bound of the range of legal f a q categories (not inclusive)
	 * @return the range of matching legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal f a q categories
	 * @param end the upper bound of the range of legal f a q categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> findByCompany(long companyId, int start,
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

		List<LegalFAQCategory> list = (List<LegalFAQCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegalFAQCategory legalFAQCategory : list) {
				if ((companyId != legalFAQCategory.getCompanyId())) {
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

			query.append(_SQL_SELECT_LEGALFAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LegalFAQCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<LegalFAQCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal f a q category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q category
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a matching legal f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQCategoryException, SystemException {
		LegalFAQCategory legalFAQCategory = fetchByCompany_First(companyId,
				orderByComparator);

		if (legalFAQCategory != null) {
			return legalFAQCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQCategoryException(msg.toString());
	}

	/**
	 * Returns the first legal f a q category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q category, or <code>null</code> if a matching legal f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegalFAQCategory> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal f a q category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q category
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a matching legal f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQCategoryException, SystemException {
		LegalFAQCategory legalFAQCategory = fetchByCompany_Last(companyId,
				orderByComparator);

		if (legalFAQCategory != null) {
			return legalFAQCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQCategoryException(msg.toString());
	}

	/**
	 * Returns the last legal f a q category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q category, or <code>null</code> if a matching legal f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<LegalFAQCategory> list = findByCompany(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal f a q categories before and after the current legal f a q category in the ordered set where companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current legal f a q category
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q category
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a legal f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory[] findByCompany_PrevAndNext(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQCategoryException, SystemException {
		LegalFAQCategory legalFAQCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQCategory[] array = new LegalFAQCategoryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, legalFAQCategory,
					companyId, orderByComparator, true);

			array[1] = legalFAQCategory;

			array[2] = getByCompany_PrevAndNext(session, legalFAQCategory,
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

	protected LegalFAQCategory getByCompany_PrevAndNext(Session session,
		LegalFAQCategory legalFAQCategory, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFAQCATEGORY_WHERE);

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
			query.append(LegalFAQCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal f a q categories
	 * @param end the upper bound of the range of legal f a q categories (not inclusive)
	 * @return the range of matching legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal f a q categories
	 * @param end the upper bound of the range of legal f a q categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> findByGroup(long groupId, int start, int end,
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

		List<LegalFAQCategory> list = (List<LegalFAQCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegalFAQCategory legalFAQCategory : list) {
				if ((groupId != legalFAQCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_LEGALFAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LegalFAQCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<LegalFAQCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal f a q category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q category
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a matching legal f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQCategoryException, SystemException {
		LegalFAQCategory legalFAQCategory = fetchByGroup_First(groupId,
				orderByComparator);

		if (legalFAQCategory != null) {
			return legalFAQCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQCategoryException(msg.toString());
	}

	/**
	 * Returns the first legal f a q category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q category, or <code>null</code> if a matching legal f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegalFAQCategory> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal f a q category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q category
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a matching legal f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQCategoryException, SystemException {
		LegalFAQCategory legalFAQCategory = fetchByGroup_Last(groupId,
				orderByComparator);

		if (legalFAQCategory != null) {
			return legalFAQCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQCategoryException(msg.toString());
	}

	/**
	 * Returns the last legal f a q category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q category, or <code>null</code> if a matching legal f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<LegalFAQCategory> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal f a q categories before and after the current legal f a q category in the ordered set where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current legal f a q category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q category
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a legal f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory[] findByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQCategoryException, SystemException {
		LegalFAQCategory legalFAQCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQCategory[] array = new LegalFAQCategoryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, legalFAQCategory,
					groupId, orderByComparator, true);

			array[1] = legalFAQCategory;

			array[2] = getByGroup_PrevAndNext(session, legalFAQCategory,
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

	protected LegalFAQCategory getByGroup_PrevAndNext(Session session,
		LegalFAQCategory legalFAQCategory, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFAQCATEGORY_WHERE);

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
			query.append(LegalFAQCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal f a q categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal f a q categories that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal f a q categories
	 * @param end the upper bound of the range of legal f a q categories (not inclusive)
	 * @return the range of matching legal f a q categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q categories that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal f a q categories
	 * @param end the upper bound of the range of legal f a q categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_LEGALFAQCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LEGALFAQCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LegalFAQCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LegalFAQCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LegalFAQCategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LegalFAQCategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<LegalFAQCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the legal f a q categories before and after the current legal f a q category in the ordered set of legal f a q categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current legal f a q category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q category
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a legal f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory[] filterFindByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQCategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(categoryId, groupId,
				orderByComparator);
		}

		LegalFAQCategory legalFAQCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQCategory[] array = new LegalFAQCategoryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, legalFAQCategory,
					groupId, orderByComparator, true);

			array[1] = legalFAQCategory;

			array[2] = filterGetByGroup_PrevAndNext(session, legalFAQCategory,
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

	protected LegalFAQCategory filterGetByGroup_PrevAndNext(Session session,
		LegalFAQCategory legalFAQCategory, long groupId,
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
			query.append(_FILTER_SQL_SELECT_LEGALFAQCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LEGALFAQCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LEGALFAQCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(LegalFAQCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LegalFAQCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, LegalFAQCategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, LegalFAQCategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q categories where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the matching legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> findByParent(long companyId, long parentId)
		throws SystemException {
		return findByParent(companyId, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q categories where companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal f a q categories
	 * @param end the upper bound of the range of legal f a q categories (not inclusive)
	 * @return the range of matching legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> findByParent(long companyId, long parentId,
		int start, int end) throws SystemException {
		return findByParent(companyId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q categories where companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal f a q categories
	 * @param end the upper bound of the range of legal f a q categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> findByParent(long companyId, long parentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT;
			finderArgs = new Object[] { companyId, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT;
			finderArgs = new Object[] {
					companyId, parentId,
					
					start, end, orderByComparator
				};
		}

		List<LegalFAQCategory> list = (List<LegalFAQCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegalFAQCategory legalFAQCategory : list) {
				if ((companyId != legalFAQCategory.getCompanyId()) ||
						(parentId != legalFAQCategory.getParentId())) {
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

			query.append(_SQL_SELECT_LEGALFAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENT_COMPANYID_2);

			query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LegalFAQCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(parentId);

				list = (List<LegalFAQCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legal f a q category in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q category
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a matching legal f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory findByParent_First(long companyId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQCategoryException, SystemException {
		LegalFAQCategory legalFAQCategory = fetchByParent_First(companyId,
				parentId, orderByComparator);

		if (legalFAQCategory != null) {
			return legalFAQCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQCategoryException(msg.toString());
	}

	/**
	 * Returns the first legal f a q category in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal f a q category, or <code>null</code> if a matching legal f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory fetchByParent_First(long companyId, long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegalFAQCategory> list = findByParent(companyId, parentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal f a q category in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q category
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a matching legal f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory findByParent_Last(long companyId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchLegalFAQCategoryException, SystemException {
		LegalFAQCategory legalFAQCategory = fetchByParent_Last(companyId,
				parentId, orderByComparator);

		if (legalFAQCategory != null) {
			return legalFAQCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegalFAQCategoryException(msg.toString());
	}

	/**
	 * Returns the last legal f a q category in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal f a q category, or <code>null</code> if a matching legal f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory fetchByParent_Last(long companyId, long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParent(companyId, parentId);

		List<LegalFAQCategory> list = findByParent(companyId, parentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal f a q categories before and after the current legal f a q category in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param categoryId the primary key of the current legal f a q category
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal f a q category
	 * @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a legal f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory[] findByParent_PrevAndNext(long categoryId,
		long companyId, long parentId, OrderByComparator orderByComparator)
		throws NoSuchLegalFAQCategoryException, SystemException {
		LegalFAQCategory legalFAQCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			LegalFAQCategory[] array = new LegalFAQCategoryImpl[3];

			array[0] = getByParent_PrevAndNext(session, legalFAQCategory,
					companyId, parentId, orderByComparator, true);

			array[1] = legalFAQCategory;

			array[2] = getByParent_PrevAndNext(session, legalFAQCategory,
					companyId, parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalFAQCategory getByParent_PrevAndNext(Session session,
		LegalFAQCategory legalFAQCategory, long companyId, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALFAQCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PARENT_COMPANYID_2);

		query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

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
			query.append(LegalFAQCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legalFAQCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegalFAQCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the legal f a q categories.
	 *
	 * @return the legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal f a q categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal f a q categories
	 * @param end the upper bound of the range of legal f a q categories (not inclusive)
	 * @return the range of legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal f a q categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal f a q categories
	 * @param end the upper bound of the range of legal f a q categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> findAll(int start, int end,
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

		List<LegalFAQCategory> list = (List<LegalFAQCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGALFAQCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALFAQCATEGORY.concat(LegalFAQCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LegalFAQCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LegalFAQCategory>)QueryUtil.list(q,
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
	 * Removes all the legal f a q categories where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (LegalFAQCategory legalFAQCategory : findByCompany(companyId)) {
			remove(legalFAQCategory);
		}
	}

	/**
	 * Removes all the legal f a q categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (LegalFAQCategory legalFAQCategory : findByGroup(groupId)) {
			remove(legalFAQCategory);
		}
	}

	/**
	 * Removes all the legal f a q categories where companyId = &#63; and parentId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParent(long companyId, long parentId)
		throws SystemException {
		for (LegalFAQCategory legalFAQCategory : findByParent(companyId,
				parentId)) {
			remove(legalFAQCategory);
		}
	}

	/**
	 * Removes all the legal f a q categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LegalFAQCategory legalFAQCategory : findAll()) {
			remove(legalFAQCategory);
		}
	}

	/**
	 * Returns the number of legal f a q categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALFAQCATEGORY_WHERE);

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
	 * Returns the number of legal f a q categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALFAQCATEGORY_WHERE);

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
	 * Returns the number of legal f a q categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal f a q categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_LEGALFAQCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LegalFAQCategory.class.getName(),
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
	 * Returns the number of legal f a q categories where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the number of matching legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParent(long companyId, long parentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, parentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALFAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENT_COMPANYID_2);

			query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(parentId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of legal f a q categories.
	 *
	 * @return the number of legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALFAQCATEGORY);

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
	 * Initializes the legal f a q category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.legal_faq.model.LegalFAQCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegalFAQCategory>> listenersList = new ArrayList<ModelListener<LegalFAQCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegalFAQCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegalFAQCategoryImpl.class.getName());
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
	private static final String _SQL_SELECT_LEGALFAQCATEGORY = "SELECT legalFAQCategory FROM LegalFAQCategory legalFAQCategory";
	private static final String _SQL_SELECT_LEGALFAQCATEGORY_WHERE = "SELECT legalFAQCategory FROM LegalFAQCategory legalFAQCategory WHERE ";
	private static final String _SQL_COUNT_LEGALFAQCATEGORY = "SELECT COUNT(legalFAQCategory) FROM LegalFAQCategory legalFAQCategory";
	private static final String _SQL_COUNT_LEGALFAQCATEGORY_WHERE = "SELECT COUNT(legalFAQCategory) FROM LegalFAQCategory legalFAQCategory WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "legalFAQCategory.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "legalFAQCategory.groupId = ?";
	private static final String _FINDER_COLUMN_PARENT_COMPANYID_2 = "legalFAQCategory.companyId = ? AND ";
	private static final String _FINDER_COLUMN_PARENT_PARENTID_2 = "legalFAQCategory.parentId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "legalFAQCategory.categoryId";
	private static final String _FILTER_SQL_SELECT_LEGALFAQCATEGORY_WHERE = "SELECT DISTINCT {legalFAQCategory.*} FROM LegalFAQCategory legalFAQCategory WHERE ";
	private static final String _FILTER_SQL_SELECT_LEGALFAQCATEGORY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {LegalFAQCategory.*} FROM (SELECT DISTINCT legalFAQCategory.categoryId FROM LegalFAQCategory legalFAQCategory WHERE ";
	private static final String _FILTER_SQL_SELECT_LEGALFAQCATEGORY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN LegalFAQCategory ON TEMP_TABLE.categoryId = LegalFAQCategory.categoryId";
	private static final String _FILTER_SQL_COUNT_LEGALFAQCATEGORY_WHERE = "SELECT COUNT(DISTINCT legalFAQCategory.categoryId) AS COUNT_VALUE FROM LegalFAQCategory legalFAQCategory WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "legalFAQCategory";
	private static final String _FILTER_ENTITY_TABLE = "LegalFAQCategory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legalFAQCategory.";
	private static final String _ORDER_BY_ENTITY_TABLE = "LegalFAQCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegalFAQCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LegalFAQCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegalFAQCategoryPersistenceImpl.class);
	private static LegalFAQCategory _nullLegalFAQCategory = new LegalFAQCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegalFAQCategory> toCacheModel() {
				return _nullLegalFAQCategoryCacheModel;
			}
		};

	private static CacheModel<LegalFAQCategory> _nullLegalFAQCategoryCacheModel = new CacheModel<LegalFAQCategory>() {
			public LegalFAQCategory toEntityModel() {
				return _nullLegalFAQCategory;
			}
		};
}