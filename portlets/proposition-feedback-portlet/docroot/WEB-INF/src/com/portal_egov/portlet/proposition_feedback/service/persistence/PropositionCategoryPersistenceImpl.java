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

package com.portal_egov.portlet.proposition_feedback.service.persistence;

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

import com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;
import com.portal_egov.portlet.proposition_feedback.model.PropositionCategory;
import com.portal_egov.portlet.proposition_feedback.model.impl.PropositionCategoryImpl;
import com.portal_egov.portlet.proposition_feedback.model.impl.PropositionCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the proposition category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see PropositionCategoryPersistence
 * @see PropositionCategoryUtil
 * @generated
 */
public class PropositionCategoryPersistenceImpl extends BasePersistenceImpl<PropositionCategory>
	implements PropositionCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PropositionCategoryUtil} to access the proposition category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PropositionCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED,
			PropositionCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED,
			PropositionCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			PropositionCategoryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED,
			PropositionCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED,
			PropositionCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			PropositionCategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDCOMPANY =
		new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED,
			PropositionCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTypeAndCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY =
		new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED,
			PropositionCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTypeAndCompany",
			new String[] { Long.class.getName(), Integer.class.getName() },
			PropositionCategoryModelImpl.COMPANYID_COLUMN_BITMASK |
			PropositionCategoryModelImpl.CATEGORYTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEANDCOMPANY = new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeAndCompany",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDGROUP =
		new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED,
			PropositionCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTypeAndGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP =
		new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED,
			PropositionCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTypeAndGroup",
			new String[] { Long.class.getName(), Integer.class.getName() },
			PropositionCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			PropositionCategoryModelImpl.CATEGORYTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEANDGROUP = new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeAndGroup",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDCOMPANY =
		new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED,
			PropositionCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY =
		new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED,
			PropositionCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			PropositionCategoryModelImpl.COMPANYID_COLUMN_BITMASK |
			PropositionCategoryModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTANDCOMPANY = new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDGROUP =
		new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED,
			PropositionCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP =
		new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED,
			PropositionCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			PropositionCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			PropositionCategoryModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTANDGROUP = new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED,
			PropositionCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED,
			PropositionCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the proposition category in the entity cache if it is enabled.
	 *
	 * @param propositionCategory the proposition category
	 */
	public void cacheResult(PropositionCategory propositionCategory) {
		EntityCacheUtil.putResult(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryImpl.class, propositionCategory.getPrimaryKey(),
			propositionCategory);

		propositionCategory.resetOriginalValues();
	}

	/**
	 * Caches the proposition categories in the entity cache if it is enabled.
	 *
	 * @param propositionCategories the proposition categories
	 */
	public void cacheResult(List<PropositionCategory> propositionCategories) {
		for (PropositionCategory propositionCategory : propositionCategories) {
			if (EntityCacheUtil.getResult(
						PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
						PropositionCategoryImpl.class,
						propositionCategory.getPrimaryKey()) == null) {
				cacheResult(propositionCategory);
			}
			else {
				propositionCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all proposition categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PropositionCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PropositionCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the proposition category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PropositionCategory propositionCategory) {
		EntityCacheUtil.removeResult(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryImpl.class, propositionCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PropositionCategory> propositionCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PropositionCategory propositionCategory : propositionCategories) {
			EntityCacheUtil.removeResult(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
				PropositionCategoryImpl.class,
				propositionCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new proposition category with the primary key. Does not add the proposition category to the database.
	 *
	 * @param categoryId the primary key for the new proposition category
	 * @return the new proposition category
	 */
	public PropositionCategory create(long categoryId) {
		PropositionCategory propositionCategory = new PropositionCategoryImpl();

		propositionCategory.setNew(true);
		propositionCategory.setPrimaryKey(categoryId);

		return propositionCategory;
	}

	/**
	 * Removes the proposition category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the proposition category
	 * @return the proposition category that was removed
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory remove(long categoryId)
		throws NoSuchPropositionCategoryException, SystemException {
		return remove(Long.valueOf(categoryId));
	}

	/**
	 * Removes the proposition category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the proposition category
	 * @return the proposition category that was removed
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PropositionCategory remove(Serializable primaryKey)
		throws NoSuchPropositionCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PropositionCategory propositionCategory = (PropositionCategory)session.get(PropositionCategoryImpl.class,
					primaryKey);

			if (propositionCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPropositionCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(propositionCategory);
		}
		catch (NoSuchPropositionCategoryException nsee) {
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
	protected PropositionCategory removeImpl(
		PropositionCategory propositionCategory) throws SystemException {
		propositionCategory = toUnwrappedModel(propositionCategory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, propositionCategory);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(propositionCategory);

		return propositionCategory;
	}

	@Override
	public PropositionCategory updateImpl(
		com.portal_egov.portlet.proposition_feedback.model.PropositionCategory propositionCategory,
		boolean merge) throws SystemException {
		propositionCategory = toUnwrappedModel(propositionCategory);

		boolean isNew = propositionCategory.isNew();

		PropositionCategoryModelImpl propositionCategoryModelImpl = (PropositionCategoryModelImpl)propositionCategory;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, propositionCategory, merge);

			propositionCategory.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PropositionCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((propositionCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionCategoryModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(propositionCategoryModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((propositionCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionCategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(propositionCategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((propositionCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionCategoryModelImpl.getOriginalCompanyId()),
						Integer.valueOf(propositionCategoryModelImpl.getOriginalCategoryTypeId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(propositionCategoryModelImpl.getCompanyId()),
						Integer.valueOf(propositionCategoryModelImpl.getCategoryTypeId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY,
					args);
			}

			if ((propositionCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionCategoryModelImpl.getOriginalGroupId()),
						Integer.valueOf(propositionCategoryModelImpl.getOriginalCategoryTypeId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(propositionCategoryModelImpl.getGroupId()),
						Integer.valueOf(propositionCategoryModelImpl.getCategoryTypeId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP,
					args);
			}

			if ((propositionCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionCategoryModelImpl.getOriginalCompanyId()),
						Long.valueOf(propositionCategoryModelImpl.getOriginalParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(propositionCategoryModelImpl.getCompanyId()),
						Long.valueOf(propositionCategoryModelImpl.getParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY,
					args);
			}

			if ((propositionCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionCategoryModelImpl.getOriginalGroupId()),
						Long.valueOf(propositionCategoryModelImpl.getOriginalParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(propositionCategoryModelImpl.getGroupId()),
						Long.valueOf(propositionCategoryModelImpl.getParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PropositionCategoryImpl.class, propositionCategory.getPrimaryKey(),
			propositionCategory);

		return propositionCategory;
	}

	protected PropositionCategory toUnwrappedModel(
		PropositionCategory propositionCategory) {
		if (propositionCategory instanceof PropositionCategoryImpl) {
			return propositionCategory;
		}

		PropositionCategoryImpl propositionCategoryImpl = new PropositionCategoryImpl();

		propositionCategoryImpl.setNew(propositionCategory.isNew());
		propositionCategoryImpl.setPrimaryKey(propositionCategory.getPrimaryKey());

		propositionCategoryImpl.setCategoryId(propositionCategory.getCategoryId());
		propositionCategoryImpl.setCompanyId(propositionCategory.getCompanyId());
		propositionCategoryImpl.setGroupId(propositionCategory.getGroupId());
		propositionCategoryImpl.setUserId(propositionCategory.getUserId());
		propositionCategoryImpl.setCategoryTypeId(propositionCategory.getCategoryTypeId());
		propositionCategoryImpl.setParentId(propositionCategory.getParentId());
		propositionCategoryImpl.setCategoryName(propositionCategory.getCategoryName());
		propositionCategoryImpl.setCategoryDesc(propositionCategory.getCategoryDesc());
		propositionCategoryImpl.setPropositionCount(propositionCategory.getPropositionCount());
		propositionCategoryImpl.setCreateDate(propositionCategory.getCreateDate());
		propositionCategoryImpl.setModifiedDate(propositionCategory.getModifiedDate());

		return propositionCategoryImpl;
	}

	/**
	 * Returns the proposition category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the proposition category
	 * @return the proposition category
	 * @throws com.liferay.portal.NoSuchModelException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PropositionCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the proposition category with the primary key or throws a {@link com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the proposition category
	 * @return the proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory findByPrimaryKey(long categoryId)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = fetchByPrimaryKey(categoryId);

		if (propositionCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
			}

			throw new NoSuchPropositionCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryId);
		}

		return propositionCategory;
	}

	/**
	 * Returns the proposition category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the proposition category
	 * @return the proposition category, or <code>null</code> if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PropositionCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the proposition category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the proposition category
	 * @return the proposition category, or <code>null</code> if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory fetchByPrimaryKey(long categoryId)
		throws SystemException {
		PropositionCategory propositionCategory = (PropositionCategory)EntityCacheUtil.getResult(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
				PropositionCategoryImpl.class, categoryId);

		if (propositionCategory == _nullPropositionCategory) {
			return null;
		}

		if (propositionCategory == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				propositionCategory = (PropositionCategory)session.get(PropositionCategoryImpl.class,
						Long.valueOf(categoryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (propositionCategory != null) {
					cacheResult(propositionCategory);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PropositionCategoryModelImpl.ENTITY_CACHE_ENABLED,
						PropositionCategoryImpl.class, categoryId,
						_nullPropositionCategory);
				}

				closeSession(session);
			}
		}

		return propositionCategory;
	}

	/**
	 * Returns all the proposition categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the proposition categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @return the range of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByCompany(long companyId, int start,
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

		List<PropositionCategory> list = (List<PropositionCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PropositionCategory propositionCategory : list) {
				if ((companyId != propositionCategory.getCompanyId())) {
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

			query.append(_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<PropositionCategory>)QueryUtil.list(q,
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
	 * Returns the first proposition category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = fetchByCompany_First(companyId,
				orderByComparator);

		if (propositionCategory != null) {
			return propositionCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionCategoryException(msg.toString());
	}

	/**
	 * Returns the first proposition category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PropositionCategory> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = fetchByCompany_Last(companyId,
				orderByComparator);

		if (propositionCategory != null) {
			return propositionCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionCategoryException(msg.toString());
	}

	/**
	 * Returns the last proposition category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<PropositionCategory> list = findByCompany(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposition categories before and after the current proposition category in the ordered set where companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current proposition category
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory[] findByCompany_PrevAndNext(long categoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			PropositionCategory[] array = new PropositionCategoryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, propositionCategory,
					companyId, orderByComparator, true);

			array[1] = propositionCategory;

			array[2] = getByCompany_PrevAndNext(session, propositionCategory,
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

	protected PropositionCategory getByCompany_PrevAndNext(Session session,
		PropositionCategory propositionCategory, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);

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
			query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @return the range of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByGroup(long groupId, int start,
		int end) throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByGroup(long groupId, int start,
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

		List<PropositionCategory> list = (List<PropositionCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PropositionCategory propositionCategory : list) {
				if ((groupId != propositionCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<PropositionCategory>)QueryUtil.list(q,
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
	 * Returns the first proposition category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = fetchByGroup_First(groupId,
				orderByComparator);

		if (propositionCategory != null) {
			return propositionCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionCategoryException(msg.toString());
	}

	/**
	 * Returns the first proposition category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PropositionCategory> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = fetchByGroup_Last(groupId,
				orderByComparator);

		if (propositionCategory != null) {
			return propositionCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionCategoryException(msg.toString());
	}

	/**
	 * Returns the last proposition category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<PropositionCategory> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposition categories before and after the current proposition category in the ordered set where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current proposition category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory[] findByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			PropositionCategory[] array = new PropositionCategoryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, propositionCategory,
					groupId, orderByComparator, true);

			array[1] = propositionCategory;

			array[2] = getByGroup_PrevAndNext(session, propositionCategory,
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

	protected PropositionCategory getByGroup_PrevAndNext(Session session,
		PropositionCategory propositionCategory, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);

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
			query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching proposition categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the proposition categories that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @return the range of matching proposition categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition categories that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PropositionCategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PropositionCategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<PropositionCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the proposition categories before and after the current proposition category in the ordered set of proposition categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current proposition category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(categoryId, groupId,
				orderByComparator);
		}

		PropositionCategory propositionCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			PropositionCategory[] array = new PropositionCategoryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session,
					propositionCategory, groupId, orderByComparator, true);

			array[1] = propositionCategory;

			array[2] = filterGetByGroup_PrevAndNext(session,
					propositionCategory, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PropositionCategory filterGetByGroup_PrevAndNext(
		Session session, PropositionCategory propositionCategory, long groupId,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PropositionCategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PropositionCategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition categories where companyId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryTypeId the category type ID
	 * @return the matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByTypeAndCompany(long companyId,
		int categoryTypeId) throws SystemException {
		return findByTypeAndCompany(companyId, categoryTypeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition categories where companyId = &#63; and categoryTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param categoryTypeId the category type ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @return the range of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByTypeAndCompany(long companyId,
		int categoryTypeId, int start, int end) throws SystemException {
		return findByTypeAndCompany(companyId, categoryTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition categories where companyId = &#63; and categoryTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param categoryTypeId the category type ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByTypeAndCompany(long companyId,
		int categoryTypeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDCOMPANY;
			finderArgs = new Object[] { companyId, categoryTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDCOMPANY;
			finderArgs = new Object[] {
					companyId, categoryTypeId,
					
					start, end, orderByComparator
				};
		}

		List<PropositionCategory> list = (List<PropositionCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PropositionCategory propositionCategory : list) {
				if ((companyId != propositionCategory.getCompanyId()) ||
						(categoryTypeId != propositionCategory.getCategoryTypeId())) {
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

			query.append(_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_TYPEANDCOMPANY_CATEGORYTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(categoryTypeId);

				list = (List<PropositionCategory>)QueryUtil.list(q,
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
	 * Returns the first proposition category in the ordered set where companyId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryTypeId the category type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory findByTypeAndCompany_First(long companyId,
		int categoryTypeId, OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = fetchByTypeAndCompany_First(companyId,
				categoryTypeId, orderByComparator);

		if (propositionCategory != null) {
			return propositionCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", categoryTypeId=");
		msg.append(categoryTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionCategoryException(msg.toString());
	}

	/**
	 * Returns the first proposition category in the ordered set where companyId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryTypeId the category type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory fetchByTypeAndCompany_First(long companyId,
		int categoryTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PropositionCategory> list = findByTypeAndCompany(companyId,
				categoryTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition category in the ordered set where companyId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryTypeId the category type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory findByTypeAndCompany_Last(long companyId,
		int categoryTypeId, OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = fetchByTypeAndCompany_Last(companyId,
				categoryTypeId, orderByComparator);

		if (propositionCategory != null) {
			return propositionCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", categoryTypeId=");
		msg.append(categoryTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionCategoryException(msg.toString());
	}

	/**
	 * Returns the last proposition category in the ordered set where companyId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryTypeId the category type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory fetchByTypeAndCompany_Last(long companyId,
		int categoryTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTypeAndCompany(companyId, categoryTypeId);

		List<PropositionCategory> list = findByTypeAndCompany(companyId,
				categoryTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposition categories before and after the current proposition category in the ordered set where companyId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param categoryId the primary key of the current proposition category
	 * @param companyId the company ID
	 * @param categoryTypeId the category type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory[] findByTypeAndCompany_PrevAndNext(
		long categoryId, long companyId, int categoryTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			PropositionCategory[] array = new PropositionCategoryImpl[3];

			array[0] = getByTypeAndCompany_PrevAndNext(session,
					propositionCategory, companyId, categoryTypeId,
					orderByComparator, true);

			array[1] = propositionCategory;

			array[2] = getByTypeAndCompany_PrevAndNext(session,
					propositionCategory, companyId, categoryTypeId,
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

	protected PropositionCategory getByTypeAndCompany_PrevAndNext(
		Session session, PropositionCategory propositionCategory,
		long companyId, int categoryTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_TYPEANDCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_TYPEANDCOMPANY_CATEGORYTYPEID_2);

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
			query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(categoryTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition categories where groupId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @return the matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByTypeAndGroup(long groupId,
		int categoryTypeId) throws SystemException {
		return findByTypeAndGroup(groupId, categoryTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition categories where groupId = &#63; and categoryTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @return the range of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByTypeAndGroup(long groupId,
		int categoryTypeId, int start, int end) throws SystemException {
		return findByTypeAndGroup(groupId, categoryTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition categories where groupId = &#63; and categoryTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByTypeAndGroup(long groupId,
		int categoryTypeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDGROUP;
			finderArgs = new Object[] { groupId, categoryTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDGROUP;
			finderArgs = new Object[] {
					groupId, categoryTypeId,
					
					start, end, orderByComparator
				};
		}

		List<PropositionCategory> list = (List<PropositionCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PropositionCategory propositionCategory : list) {
				if ((groupId != propositionCategory.getGroupId()) ||
						(categoryTypeId != propositionCategory.getCategoryTypeId())) {
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

			query.append(_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_TYPEANDGROUP_CATEGORYTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryTypeId);

				list = (List<PropositionCategory>)QueryUtil.list(q,
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
	 * Returns the first proposition category in the ordered set where groupId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory findByTypeAndGroup_First(long groupId,
		int categoryTypeId, OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = fetchByTypeAndGroup_First(groupId,
				categoryTypeId, orderByComparator);

		if (propositionCategory != null) {
			return propositionCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryTypeId=");
		msg.append(categoryTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionCategoryException(msg.toString());
	}

	/**
	 * Returns the first proposition category in the ordered set where groupId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory fetchByTypeAndGroup_First(long groupId,
		int categoryTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PropositionCategory> list = findByTypeAndGroup(groupId,
				categoryTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition category in the ordered set where groupId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory findByTypeAndGroup_Last(long groupId,
		int categoryTypeId, OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = fetchByTypeAndGroup_Last(groupId,
				categoryTypeId, orderByComparator);

		if (propositionCategory != null) {
			return propositionCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryTypeId=");
		msg.append(categoryTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionCategoryException(msg.toString());
	}

	/**
	 * Returns the last proposition category in the ordered set where groupId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory fetchByTypeAndGroup_Last(long groupId,
		int categoryTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTypeAndGroup(groupId, categoryTypeId);

		List<PropositionCategory> list = findByTypeAndGroup(groupId,
				categoryTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposition categories before and after the current proposition category in the ordered set where groupId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param categoryId the primary key of the current proposition category
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory[] findByTypeAndGroup_PrevAndNext(
		long categoryId, long groupId, int categoryTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			PropositionCategory[] array = new PropositionCategoryImpl[3];

			array[0] = getByTypeAndGroup_PrevAndNext(session,
					propositionCategory, groupId, categoryTypeId,
					orderByComparator, true);

			array[1] = propositionCategory;

			array[2] = getByTypeAndGroup_PrevAndNext(session,
					propositionCategory, groupId, categoryTypeId,
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

	protected PropositionCategory getByTypeAndGroup_PrevAndNext(
		Session session, PropositionCategory propositionCategory, long groupId,
		int categoryTypeId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_CATEGORYTYPEID_2);

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
			query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition categories that the user has permission to view where groupId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @return the matching proposition categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> filterFindByTypeAndGroup(long groupId,
		int categoryTypeId) throws SystemException {
		return filterFindByTypeAndGroup(groupId, categoryTypeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition categories that the user has permission to view where groupId = &#63; and categoryTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @return the range of matching proposition categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> filterFindByTypeAndGroup(long groupId,
		int categoryTypeId, int start, int end) throws SystemException {
		return filterFindByTypeAndGroup(groupId, categoryTypeId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the proposition categories that the user has permissions to view where groupId = &#63; and categoryTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> filterFindByTypeAndGroup(long groupId,
		int categoryTypeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByTypeAndGroup(groupId, categoryTypeId, start, end,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_CATEGORYTYPEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PropositionCategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PropositionCategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryTypeId);

			return (List<PropositionCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the proposition categories before and after the current proposition category in the ordered set of proposition categories that the user has permission to view where groupId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param categoryId the primary key of the current proposition category
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory[] filterFindByTypeAndGroup_PrevAndNext(
		long categoryId, long groupId, int categoryTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByTypeAndGroup_PrevAndNext(categoryId, groupId,
				categoryTypeId, orderByComparator);
		}

		PropositionCategory propositionCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			PropositionCategory[] array = new PropositionCategoryImpl[3];

			array[0] = filterGetByTypeAndGroup_PrevAndNext(session,
					propositionCategory, groupId, categoryTypeId,
					orderByComparator, true);

			array[1] = propositionCategory;

			array[2] = filterGetByTypeAndGroup_PrevAndNext(session,
					propositionCategory, groupId, categoryTypeId,
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

	protected PropositionCategory filterGetByTypeAndGroup_PrevAndNext(
		Session session, PropositionCategory propositionCategory, long groupId,
		int categoryTypeId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_CATEGORYTYPEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PropositionCategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PropositionCategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition categories where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByParentAndCompany(long companyId,
		long parentId) throws SystemException {
		return findByParentAndCompany(companyId, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition categories where companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @return the range of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByParentAndCompany(long companyId,
		long parentId, int start, int end) throws SystemException {
		return findByParentAndCompany(companyId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition categories where companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByParentAndCompany(long companyId,
		long parentId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDCOMPANY;
			finderArgs = new Object[] { companyId, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDCOMPANY;
			finderArgs = new Object[] {
					companyId, parentId,
					
					start, end, orderByComparator
				};
		}

		List<PropositionCategory> list = (List<PropositionCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PropositionCategory propositionCategory : list) {
				if ((companyId != propositionCategory.getCompanyId()) ||
						(parentId != propositionCategory.getParentId())) {
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

			query.append(_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(parentId);

				list = (List<PropositionCategory>)QueryUtil.list(q,
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
	 * Returns the first proposition category in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory findByParentAndCompany_First(long companyId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = fetchByParentAndCompany_First(companyId,
				parentId, orderByComparator);

		if (propositionCategory != null) {
			return propositionCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionCategoryException(msg.toString());
	}

	/**
	 * Returns the first proposition category in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory fetchByParentAndCompany_First(long companyId,
		long parentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PropositionCategory> list = findByParentAndCompany(companyId,
				parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition category in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory findByParentAndCompany_Last(long companyId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = fetchByParentAndCompany_Last(companyId,
				parentId, orderByComparator);

		if (propositionCategory != null) {
			return propositionCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionCategoryException(msg.toString());
	}

	/**
	 * Returns the last proposition category in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory fetchByParentAndCompany_Last(long companyId,
		long parentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentAndCompany(companyId, parentId);

		List<PropositionCategory> list = findByParentAndCompany(companyId,
				parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposition categories before and after the current proposition category in the ordered set where companyId = &#63; and parentId = &#63;.
	 *
	 * @param categoryId the primary key of the current proposition category
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory[] findByParentAndCompany_PrevAndNext(
		long categoryId, long companyId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			PropositionCategory[] array = new PropositionCategoryImpl[3];

			array[0] = getByParentAndCompany_PrevAndNext(session,
					propositionCategory, companyId, parentId,
					orderByComparator, true);

			array[1] = propositionCategory;

			array[2] = getByParentAndCompany_PrevAndNext(session,
					propositionCategory, companyId, parentId,
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

	protected PropositionCategory getByParentAndCompany_PrevAndNext(
		Session session, PropositionCategory propositionCategory,
		long companyId, long parentId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_PARENTANDCOMPANY_PARENTID_2);

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
			query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition categories where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByParentAndGroup(long groupId,
		long parentId) throws SystemException {
		return findByParentAndGroup(groupId, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition categories where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @return the range of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByParentAndGroup(long groupId,
		long parentId, int start, int end) throws SystemException {
		return findByParentAndGroup(groupId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition categories where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findByParentAndGroup(long groupId,
		long parentId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTANDGROUP;
			finderArgs = new Object[] { groupId, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTANDGROUP;
			finderArgs = new Object[] {
					groupId, parentId,
					
					start, end, orderByComparator
				};
		}

		List<PropositionCategory> list = (List<PropositionCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PropositionCategory propositionCategory : list) {
				if ((groupId != propositionCategory.getGroupId()) ||
						(parentId != propositionCategory.getParentId())) {
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

			query.append(_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parentId);

				list = (List<PropositionCategory>)QueryUtil.list(q,
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
	 * Returns the first proposition category in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory findByParentAndGroup_First(long groupId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = fetchByParentAndGroup_First(groupId,
				parentId, orderByComparator);

		if (propositionCategory != null) {
			return propositionCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionCategoryException(msg.toString());
	}

	/**
	 * Returns the first proposition category in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory fetchByParentAndGroup_First(long groupId,
		long parentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PropositionCategory> list = findByParentAndGroup(groupId,
				parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition category in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory findByParentAndGroup_Last(long groupId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = fetchByParentAndGroup_Last(groupId,
				parentId, orderByComparator);

		if (propositionCategory != null) {
			return propositionCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionCategoryException(msg.toString());
	}

	/**
	 * Returns the last proposition category in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory fetchByParentAndGroup_Last(long groupId,
		long parentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentAndGroup(groupId, parentId);

		List<PropositionCategory> list = findByParentAndGroup(groupId,
				parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposition categories before and after the current proposition category in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param categoryId the primary key of the current proposition category
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory[] findByParentAndGroup_PrevAndNext(
		long categoryId, long groupId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		PropositionCategory propositionCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			PropositionCategory[] array = new PropositionCategoryImpl[3];

			array[0] = getByParentAndGroup_PrevAndNext(session,
					propositionCategory, groupId, parentId, orderByComparator,
					true);

			array[1] = propositionCategory;

			array[2] = getByParentAndGroup_PrevAndNext(session,
					propositionCategory, groupId, parentId, orderByComparator,
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

	protected PropositionCategory getByParentAndGroup_PrevAndNext(
		Session session, PropositionCategory propositionCategory, long groupId,
		long parentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

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
			query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition categories that the user has permission to view where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the matching proposition categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> filterFindByParentAndGroup(long groupId,
		long parentId) throws SystemException {
		return filterFindByParentAndGroup(groupId, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition categories that the user has permission to view where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @return the range of matching proposition categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> filterFindByParentAndGroup(long groupId,
		long parentId, int start, int end) throws SystemException {
		return filterFindByParentAndGroup(groupId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition categories that the user has permissions to view where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> filterFindByParentAndGroup(long groupId,
		long parentId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParentAndGroup(groupId, parentId, start, end,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PropositionCategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PropositionCategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(parentId);

			return (List<PropositionCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the proposition categories before and after the current proposition category in the ordered set of proposition categories that the user has permission to view where groupId = &#63; and parentId = &#63;.
	 *
	 * @param categoryId the primary key of the current proposition category
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition category
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionCategory[] filterFindByParentAndGroup_PrevAndNext(
		long categoryId, long groupId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionCategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParentAndGroup_PrevAndNext(categoryId, groupId,
				parentId, orderByComparator);
		}

		PropositionCategory propositionCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			PropositionCategory[] array = new PropositionCategoryImpl[3];

			array[0] = filterGetByParentAndGroup_PrevAndNext(session,
					propositionCategory, groupId, parentId, orderByComparator,
					true);

			array[1] = propositionCategory;

			array[2] = filterGetByParentAndGroup_PrevAndNext(session,
					propositionCategory, groupId, parentId, orderByComparator,
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

	protected PropositionCategory filterGetByParentAndGroup_PrevAndNext(
		Session session, PropositionCategory propositionCategory, long groupId,
		long parentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PropositionCategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PropositionCategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition categories.
	 *
	 * @return the proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @return the range of proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposition categories
	 * @param end the upper bound of the range of proposition categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionCategory> findAll(int start, int end,
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

		List<PropositionCategory> list = (List<PropositionCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROPOSITIONCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROPOSITIONCATEGORY.concat(PropositionCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PropositionCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PropositionCategory>)QueryUtil.list(q,
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
	 * Removes all the proposition categories where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (PropositionCategory propositionCategory : findByCompany(companyId)) {
			remove(propositionCategory);
		}
	}

	/**
	 * Removes all the proposition categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (PropositionCategory propositionCategory : findByGroup(groupId)) {
			remove(propositionCategory);
		}
	}

	/**
	 * Removes all the proposition categories where companyId = &#63; and categoryTypeId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param categoryTypeId the category type ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTypeAndCompany(long companyId, int categoryTypeId)
		throws SystemException {
		for (PropositionCategory propositionCategory : findByTypeAndCompany(
				companyId, categoryTypeId)) {
			remove(propositionCategory);
		}
	}

	/**
	 * Removes all the proposition categories where groupId = &#63; and categoryTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTypeAndGroup(long groupId, int categoryTypeId)
		throws SystemException {
		for (PropositionCategory propositionCategory : findByTypeAndGroup(
				groupId, categoryTypeId)) {
			remove(propositionCategory);
		}
	}

	/**
	 * Removes all the proposition categories where companyId = &#63; and parentId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentAndCompany(long companyId, long parentId)
		throws SystemException {
		for (PropositionCategory propositionCategory : findByParentAndCompany(
				companyId, parentId)) {
			remove(propositionCategory);
		}
	}

	/**
	 * Removes all the proposition categories where groupId = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentAndGroup(long groupId, long parentId)
		throws SystemException {
		for (PropositionCategory propositionCategory : findByParentAndGroup(
				groupId, parentId)) {
			remove(propositionCategory);
		}
	}

	/**
	 * Removes all the proposition categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PropositionCategory propositionCategory : findAll()) {
			remove(propositionCategory);
		}
	}

	/**
	 * Returns the number of proposition categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROPOSITIONCATEGORY_WHERE);

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
	 * Returns the number of proposition categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROPOSITIONCATEGORY_WHERE);

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
	 * Returns the number of proposition categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching proposition categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_PROPOSITIONCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionCategory.class.getName(),
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
	 * Returns the number of proposition categories where companyId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryTypeId the category type ID
	 * @return the number of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTypeAndCompany(long companyId, int categoryTypeId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, categoryTypeId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TYPEANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROPOSITIONCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_TYPEANDCOMPANY_CATEGORYTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(categoryTypeId);

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
	 * Returns the number of proposition categories where groupId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @return the number of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTypeAndGroup(long groupId, int categoryTypeId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, categoryTypeId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TYPEANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROPOSITIONCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_TYPEANDGROUP_CATEGORYTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryTypeId);

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
	 * Returns the number of proposition categories that the user has permission to view where groupId = &#63; and categoryTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryTypeId the category type ID
	 * @return the number of matching proposition categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByTypeAndGroup(long groupId, int categoryTypeId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByTypeAndGroup(groupId, categoryTypeId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PROPOSITIONCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_TYPEANDGROUP_CATEGORYTYPEID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryTypeId);

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
	 * Returns the number of proposition categories where companyId = &#63; and parentId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the number of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentAndCompany(long companyId, long parentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, parentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROPOSITIONCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_PARENTANDCOMPANY_PARENTID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of proposition categories where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the number of matching proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentAndGroup(long groupId, long parentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, parentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROPOSITIONCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of proposition categories that the user has permission to view where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the number of matching proposition categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByParentAndGroup(long groupId, long parentId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByParentAndGroup(groupId, parentId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PROPOSITIONCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENTANDGROUP_PARENTID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(parentId);

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
	 * Returns the number of proposition categories.
	 *
	 * @return the number of proposition categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROPOSITIONCATEGORY);

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
	 * Initializes the proposition category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.proposition_feedback.model.PropositionCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PropositionCategory>> listenersList = new ArrayList<ModelListener<PropositionCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PropositionCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PropositionCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = PropositionPersistence.class)
	protected PropositionPersistence propositionPersistence;
	@BeanReference(type = PropositionCategoryPersistence.class)
	protected PropositionCategoryPersistence propositionCategoryPersistence;
	@BeanReference(type = PropositionFeedbackPersistence.class)
	protected PropositionFeedbackPersistence propositionFeedbackPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_PROPOSITIONCATEGORY = "SELECT propositionCategory FROM PropositionCategory propositionCategory";
	private static final String _SQL_SELECT_PROPOSITIONCATEGORY_WHERE = "SELECT propositionCategory FROM PropositionCategory propositionCategory WHERE ";
	private static final String _SQL_COUNT_PROPOSITIONCATEGORY = "SELECT COUNT(propositionCategory) FROM PropositionCategory propositionCategory";
	private static final String _SQL_COUNT_PROPOSITIONCATEGORY_WHERE = "SELECT COUNT(propositionCategory) FROM PropositionCategory propositionCategory WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "propositionCategory.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "propositionCategory.groupId = ?";
	private static final String _FINDER_COLUMN_TYPEANDCOMPANY_COMPANYID_2 = "propositionCategory.companyId = ? AND ";
	private static final String _FINDER_COLUMN_TYPEANDCOMPANY_CATEGORYTYPEID_2 = "propositionCategory.categoryTypeId = ?";
	private static final String _FINDER_COLUMN_TYPEANDGROUP_GROUPID_2 = "propositionCategory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_TYPEANDGROUP_CATEGORYTYPEID_2 = "propositionCategory.categoryTypeId = ?";
	private static final String _FINDER_COLUMN_PARENTANDCOMPANY_COMPANYID_2 = "propositionCategory.companyId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTANDCOMPANY_PARENTID_2 = "propositionCategory.parentId = ?";
	private static final String _FINDER_COLUMN_PARENTANDGROUP_GROUPID_2 = "propositionCategory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTANDGROUP_PARENTID_2 = "propositionCategory.parentId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "propositionCategory.categoryId";
	private static final String _FILTER_SQL_SELECT_PROPOSITIONCATEGORY_WHERE = "SELECT DISTINCT {propositionCategory.*} FROM PropositionCategory propositionCategory WHERE ";
	private static final String _FILTER_SQL_SELECT_PROPOSITIONCATEGORY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {PropositionCategory.*} FROM (SELECT DISTINCT propositionCategory.categoryId FROM PropositionCategory propositionCategory WHERE ";
	private static final String _FILTER_SQL_SELECT_PROPOSITIONCATEGORY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN PropositionCategory ON TEMP_TABLE.categoryId = PropositionCategory.categoryId";
	private static final String _FILTER_SQL_COUNT_PROPOSITIONCATEGORY_WHERE = "SELECT COUNT(DISTINCT propositionCategory.categoryId) AS COUNT_VALUE FROM PropositionCategory propositionCategory WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "propositionCategory";
	private static final String _FILTER_ENTITY_TABLE = "PropositionCategory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "propositionCategory.";
	private static final String _ORDER_BY_ENTITY_TABLE = "PropositionCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PropositionCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PropositionCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PropositionCategoryPersistenceImpl.class);
	private static PropositionCategory _nullPropositionCategory = new PropositionCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PropositionCategory> toCacheModel() {
				return _nullPropositionCategoryCacheModel;
			}
		};

	private static CacheModel<PropositionCategory> _nullPropositionCategoryCacheModel =
		new CacheModel<PropositionCategory>() {
			public PropositionCategory toEntityModel() {
				return _nullPropositionCategory;
			}
		};
}