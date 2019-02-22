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

import com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;
import com.portal_egov.portlet.proposition_feedback.model.Proposition;
import com.portal_egov.portlet.proposition_feedback.model.impl.PropositionImpl;
import com.portal_egov.portlet.proposition_feedback.model.impl.PropositionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the proposition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see PropositionPersistence
 * @see PropositionUtil
 * @generated
 */
public class PropositionPersistenceImpl extends BasePersistenceImpl<Proposition>
	implements PropositionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PropositionUtil} to access the proposition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PropositionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			PropositionModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			PropositionModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDCOMPANY =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			PropositionModelImpl.COMPANYID_COLUMN_BITMASK |
			PropositionModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY = new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDGROUP =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			PropositionModelImpl.GROUPID_COLUMN_BITMASK |
			PropositionModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDGROUP = new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDCOMPANY =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusAndCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatusAndCompany",
			new String[] { Long.class.getName(), Integer.class.getName() },
			PropositionModelImpl.COMPANYID_COLUMN_BITMASK |
			PropositionModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDCOMPANY = new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusAndCompany",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDGROUP =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusAndGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusAndGroup",
			new String[] { Long.class.getName(), Integer.class.getName() },
			PropositionModelImpl.GROUPID_COLUMN_BITMASK |
			PropositionModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDGROUP = new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusAndGroup",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDSTATUSANDCOMPANY =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategoryAndStatusAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUSANDCOMPANY =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndStatusAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			PropositionModelImpl.COMPANYID_COLUMN_BITMASK |
			PropositionModelImpl.CATEGORYID_COLUMN_BITMASK |
			PropositionModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDSTATUSANDCOMPANY =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndStatusAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDSTATUSANDGROUP =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategoryAndStatusAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUSANDGROUP =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndStatusAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			PropositionModelImpl.GROUPID_COLUMN_BITMASK |
			PropositionModelImpl.CATEGORYID_COLUMN_BITMASK |
			PropositionModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDSTATUSANDGROUP =
		new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndStatusAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, PropositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the proposition in the entity cache if it is enabled.
	 *
	 * @param proposition the proposition
	 */
	public void cacheResult(Proposition proposition) {
		EntityCacheUtil.putResult(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionImpl.class, proposition.getPrimaryKey(), proposition);

		proposition.resetOriginalValues();
	}

	/**
	 * Caches the propositions in the entity cache if it is enabled.
	 *
	 * @param propositions the propositions
	 */
	public void cacheResult(List<Proposition> propositions) {
		for (Proposition proposition : propositions) {
			if (EntityCacheUtil.getResult(
						PropositionModelImpl.ENTITY_CACHE_ENABLED,
						PropositionImpl.class, proposition.getPrimaryKey()) == null) {
				cacheResult(proposition);
			}
			else {
				proposition.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all propositions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PropositionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PropositionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the proposition.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Proposition proposition) {
		EntityCacheUtil.removeResult(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionImpl.class, proposition.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Proposition> propositions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Proposition proposition : propositions) {
			EntityCacheUtil.removeResult(PropositionModelImpl.ENTITY_CACHE_ENABLED,
				PropositionImpl.class, proposition.getPrimaryKey());
		}
	}

	/**
	 * Creates a new proposition with the primary key. Does not add the proposition to the database.
	 *
	 * @param propositionId the primary key for the new proposition
	 * @return the new proposition
	 */
	public Proposition create(long propositionId) {
		Proposition proposition = new PropositionImpl();

		proposition.setNew(true);
		proposition.setPrimaryKey(propositionId);

		return proposition;
	}

	/**
	 * Removes the proposition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param propositionId the primary key of the proposition
	 * @return the proposition that was removed
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition remove(long propositionId)
		throws NoSuchPropositionException, SystemException {
		return remove(Long.valueOf(propositionId));
	}

	/**
	 * Removes the proposition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the proposition
	 * @return the proposition that was removed
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Proposition remove(Serializable primaryKey)
		throws NoSuchPropositionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Proposition proposition = (Proposition)session.get(PropositionImpl.class,
					primaryKey);

			if (proposition == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPropositionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(proposition);
		}
		catch (NoSuchPropositionException nsee) {
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
	protected Proposition removeImpl(Proposition proposition)
		throws SystemException {
		proposition = toUnwrappedModel(proposition);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, proposition);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(proposition);

		return proposition;
	}

	@Override
	public Proposition updateImpl(
		com.portal_egov.portlet.proposition_feedback.model.Proposition proposition,
		boolean merge) throws SystemException {
		proposition = toUnwrappedModel(proposition);

		boolean isNew = proposition.isNew();

		PropositionModelImpl propositionModelImpl = (PropositionModelImpl)proposition;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proposition, merge);

			proposition.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PropositionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((propositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(propositionModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((propositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(propositionModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((propositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionModelImpl.getOriginalCompanyId()),
						Long.valueOf(propositionModelImpl.getOriginalCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(propositionModelImpl.getCompanyId()),
						Long.valueOf(propositionModelImpl.getCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY,
					args);
			}

			if ((propositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionModelImpl.getOriginalGroupId()),
						Long.valueOf(propositionModelImpl.getOriginalCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(propositionModelImpl.getGroupId()),
						Long.valueOf(propositionModelImpl.getCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP,
					args);
			}

			if ((propositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionModelImpl.getOriginalCompanyId()),
						Integer.valueOf(propositionModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(propositionModelImpl.getCompanyId()),
						Integer.valueOf(propositionModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY,
					args);
			}

			if ((propositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionModelImpl.getOriginalGroupId()),
						Integer.valueOf(propositionModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(propositionModelImpl.getGroupId()),
						Integer.valueOf(propositionModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP,
					args);
			}

			if ((propositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUSANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionModelImpl.getOriginalCompanyId()),
						Long.valueOf(propositionModelImpl.getOriginalCategoryId()),
						Integer.valueOf(propositionModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDSTATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUSANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(propositionModelImpl.getCompanyId()),
						Long.valueOf(propositionModelImpl.getCategoryId()),
						Integer.valueOf(propositionModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDSTATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUSANDCOMPANY,
					args);
			}

			if ((propositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUSANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionModelImpl.getOriginalGroupId()),
						Long.valueOf(propositionModelImpl.getOriginalCategoryId()),
						Integer.valueOf(propositionModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDSTATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUSANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(propositionModelImpl.getGroupId()),
						Long.valueOf(propositionModelImpl.getCategoryId()),
						Integer.valueOf(propositionModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDSTATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUSANDGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(PropositionModelImpl.ENTITY_CACHE_ENABLED,
			PropositionImpl.class, proposition.getPrimaryKey(), proposition);

		return proposition;
	}

	protected Proposition toUnwrappedModel(Proposition proposition) {
		if (proposition instanceof PropositionImpl) {
			return proposition;
		}

		PropositionImpl propositionImpl = new PropositionImpl();

		propositionImpl.setNew(proposition.isNew());
		propositionImpl.setPrimaryKey(proposition.getPrimaryKey());

		propositionImpl.setPropositionId(proposition.getPropositionId());
		propositionImpl.setCompanyId(proposition.getCompanyId());
		propositionImpl.setGroupId(proposition.getGroupId());
		propositionImpl.setUserId(proposition.getUserId());
		propositionImpl.setUserName(proposition.getUserName());
		propositionImpl.setCategoryId(proposition.getCategoryId());
		propositionImpl.setCompilationDepartmentId(proposition.getCompilationDepartmentId());
		propositionImpl.setVerificationDepartmentId(proposition.getVerificationDepartmentId());
		propositionImpl.setPropositionName(proposition.getPropositionName());
		propositionImpl.setPropositionDesc(proposition.getPropositionDesc());
		propositionImpl.setPropositionContent(proposition.getPropositionContent());
		propositionImpl.setDocumentFileId(proposition.getDocumentFileId());
		propositionImpl.setCreateDate(proposition.getCreateDate());
		propositionImpl.setModifiedDate(proposition.getModifiedDate());
		propositionImpl.setViewCount(proposition.getViewCount());
		propositionImpl.setFeedbackCount(proposition.getFeedbackCount());
		propositionImpl.setStatus(proposition.getStatus());
		propositionImpl.setStatusByUserId(proposition.getStatusByUserId());
		propositionImpl.setStatusDate(proposition.getStatusDate());

		return propositionImpl;
	}

	/**
	 * Returns the proposition with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the proposition
	 * @return the proposition
	 * @throws com.liferay.portal.NoSuchModelException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Proposition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the proposition with the primary key or throws a {@link com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException} if it could not be found.
	 *
	 * @param propositionId the primary key of the proposition
	 * @return the proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByPrimaryKey(long propositionId)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByPrimaryKey(propositionId);

		if (proposition == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + propositionId);
			}

			throw new NoSuchPropositionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				propositionId);
		}

		return proposition;
	}

	/**
	 * Returns the proposition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the proposition
	 * @return the proposition, or <code>null</code> if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Proposition fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the proposition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param propositionId the primary key of the proposition
	 * @return the proposition, or <code>null</code> if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByPrimaryKey(long propositionId)
		throws SystemException {
		Proposition proposition = (Proposition)EntityCacheUtil.getResult(PropositionModelImpl.ENTITY_CACHE_ENABLED,
				PropositionImpl.class, propositionId);

		if (proposition == _nullProposition) {
			return null;
		}

		if (proposition == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				proposition = (Proposition)session.get(PropositionImpl.class,
						Long.valueOf(propositionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (proposition != null) {
					cacheResult(proposition);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PropositionModelImpl.ENTITY_CACHE_ENABLED,
						PropositionImpl.class, propositionId, _nullProposition);
				}

				closeSession(session);
			}
		}

		return proposition;
	}

	/**
	 * Returns all the propositions where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the propositions where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @return the range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the propositions where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCompany(long companyId, int start, int end,
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

		List<Proposition> list = (List<Proposition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Proposition proposition : list) {
				if ((companyId != proposition.getCompanyId())) {
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

			query.append(_SQL_SELECT_PROPOSITION_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Proposition>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first proposition in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByCompany_First(companyId,
				orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the first proposition in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Proposition> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByCompany_Last(companyId,
				orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the last proposition in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<Proposition> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the propositions before and after the current proposition in the ordered set where companyId = &#63;.
	 *
	 * @param propositionId the primary key of the current proposition
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition[] findByCompany_PrevAndNext(long propositionId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = findByPrimaryKey(propositionId);

		Session session = null;

		try {
			session = openSession();

			Proposition[] array = new PropositionImpl[3];

			array[0] = getByCompany_PrevAndNext(session, proposition,
					companyId, orderByComparator, true);

			array[1] = proposition;

			array[2] = getByCompany_PrevAndNext(session, proposition,
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

	protected Proposition getByCompany_PrevAndNext(Session session,
		Proposition proposition, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITION_WHERE);

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
			query.append(PropositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(proposition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Proposition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the propositions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the propositions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @return the range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the propositions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByGroup(long groupId, int start, int end,
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

		List<Proposition> list = (List<Proposition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Proposition proposition : list) {
				if ((groupId != proposition.getGroupId())) {
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

			query.append(_SQL_SELECT_PROPOSITION_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Proposition>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first proposition in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByGroup_First(groupId, orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the first proposition in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Proposition> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByGroup_Last(groupId, orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the last proposition in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<Proposition> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the propositions before and after the current proposition in the ordered set where groupId = &#63;.
	 *
	 * @param propositionId the primary key of the current proposition
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition[] findByGroup_PrevAndNext(long propositionId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = findByPrimaryKey(propositionId);

		Session session = null;

		try {
			session = openSession();

			Proposition[] array = new PropositionImpl[3];

			array[0] = getByGroup_PrevAndNext(session, proposition, groupId,
					orderByComparator, true);

			array[1] = proposition;

			array[2] = getByGroup_PrevAndNext(session, proposition, groupId,
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

	protected Proposition getByGroup_PrevAndNext(Session session,
		Proposition proposition, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITION_WHERE);

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
			query.append(PropositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(proposition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Proposition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the propositions that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the propositions that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @return the range of matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the propositions that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Proposition.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PropositionImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PropositionImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Proposition>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the propositions before and after the current proposition in the ordered set of propositions that the user has permission to view where groupId = &#63;.
	 *
	 * @param propositionId the primary key of the current proposition
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition[] filterFindByGroup_PrevAndNext(long propositionId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(propositionId, groupId,
				orderByComparator);
		}

		Proposition proposition = findByPrimaryKey(propositionId);

		Session session = null;

		try {
			session = openSession();

			Proposition[] array = new PropositionImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, proposition,
					groupId, orderByComparator, true);

			array[1] = proposition;

			array[2] = filterGetByGroup_PrevAndNext(session, proposition,
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

	protected Proposition filterGetByGroup_PrevAndNext(Session session,
		Proposition proposition, long groupId,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Proposition.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PropositionImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PropositionImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(proposition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Proposition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the propositions where companyId = &#63; and categoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @return the matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCategoryAndCompany(long companyId,
		long categoryId) throws SystemException {
		return findByCategoryAndCompany(companyId, categoryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the propositions where companyId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @return the range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCategoryAndCompany(long companyId,
		long categoryId, int start, int end) throws SystemException {
		return findByCategoryAndCompany(companyId, categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the propositions where companyId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCategoryAndCompany(long companyId,
		long categoryId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDCOMPANY;
			finderArgs = new Object[] { companyId, categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDCOMPANY;
			finderArgs = new Object[] {
					companyId, categoryId,
					
					start, end, orderByComparator
				};
		}

		List<Proposition> list = (List<Proposition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Proposition proposition : list) {
				if ((companyId != proposition.getCompanyId()) ||
						(categoryId != proposition.getCategoryId())) {
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

			query.append(_SQL_SELECT_PROPOSITION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(categoryId);

				list = (List<Proposition>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first proposition in the ordered set where companyId = &#63; and categoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByCategoryAndCompany_First(long companyId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByCategoryAndCompany_First(companyId,
				categoryId, orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the first proposition in the ordered set where companyId = &#63; and categoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByCategoryAndCompany_First(long companyId,
		long categoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Proposition> list = findByCategoryAndCompany(companyId,
				categoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition in the ordered set where companyId = &#63; and categoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByCategoryAndCompany_Last(long companyId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByCategoryAndCompany_Last(companyId,
				categoryId, orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the last proposition in the ordered set where companyId = &#63; and categoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByCategoryAndCompany_Last(long companyId,
		long categoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryAndCompany(companyId, categoryId);

		List<Proposition> list = findByCategoryAndCompany(companyId,
				categoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the propositions before and after the current proposition in the ordered set where companyId = &#63; and categoryId = &#63;.
	 *
	 * @param propositionId the primary key of the current proposition
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition[] findByCategoryAndCompany_PrevAndNext(
		long propositionId, long companyId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = findByPrimaryKey(propositionId);

		Session session = null;

		try {
			session = openSession();

			Proposition[] array = new PropositionImpl[3];

			array[0] = getByCategoryAndCompany_PrevAndNext(session,
					proposition, companyId, categoryId, orderByComparator, true);

			array[1] = proposition;

			array[2] = getByCategoryAndCompany_PrevAndNext(session,
					proposition, companyId, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Proposition getByCategoryAndCompany_PrevAndNext(Session session,
		Proposition proposition, long companyId, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITION_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_CATEGORYID_2);

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
			query.append(PropositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(proposition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Proposition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the propositions where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCategoryAndGroup(long groupId,
		long categoryId) throws SystemException {
		return findByCategoryAndGroup(groupId, categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the propositions where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @return the range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCategoryAndGroup(long groupId,
		long categoryId, int start, int end) throws SystemException {
		return findByCategoryAndGroup(groupId, categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the propositions where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCategoryAndGroup(long groupId,
		long categoryId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDGROUP;
			finderArgs = new Object[] { groupId, categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDGROUP;
			finderArgs = new Object[] {
					groupId, categoryId,
					
					start, end, orderByComparator
				};
		}

		List<Proposition> list = (List<Proposition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Proposition proposition : list) {
				if ((groupId != proposition.getGroupId()) ||
						(categoryId != proposition.getCategoryId())) {
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

			query.append(_SQL_SELECT_PROPOSITION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				list = (List<Proposition>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first proposition in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByCategoryAndGroup_First(long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByCategoryAndGroup_First(groupId,
				categoryId, orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the first proposition in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByCategoryAndGroup_First(long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Proposition> list = findByCategoryAndGroup(groupId, categoryId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByCategoryAndGroup_Last(long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByCategoryAndGroup_Last(groupId,
				categoryId, orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the last proposition in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByCategoryAndGroup_Last(long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryAndGroup(groupId, categoryId);

		List<Proposition> list = findByCategoryAndGroup(groupId, categoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the propositions before and after the current proposition in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param propositionId the primary key of the current proposition
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition[] findByCategoryAndGroup_PrevAndNext(
		long propositionId, long groupId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = findByPrimaryKey(propositionId);

		Session session = null;

		try {
			session = openSession();

			Proposition[] array = new PropositionImpl[3];

			array[0] = getByCategoryAndGroup_PrevAndNext(session, proposition,
					groupId, categoryId, orderByComparator, true);

			array[1] = proposition;

			array[2] = getByCategoryAndGroup_PrevAndNext(session, proposition,
					groupId, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Proposition getByCategoryAndGroup_PrevAndNext(Session session,
		Proposition proposition, long groupId, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITION_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

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
			query.append(PropositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(proposition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Proposition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the propositions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> filterFindByCategoryAndGroup(long groupId,
		long categoryId) throws SystemException {
		return filterFindByCategoryAndGroup(groupId, categoryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the propositions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @return the range of matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> filterFindByCategoryAndGroup(long groupId,
		long categoryId, int start, int end) throws SystemException {
		return filterFindByCategoryAndGroup(groupId, categoryId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the propositions that the user has permissions to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> filterFindByCategoryAndGroup(long groupId,
		long categoryId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryAndGroup(groupId, categoryId, start, end,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Proposition.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PropositionImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PropositionImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

			return (List<Proposition>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the propositions before and after the current proposition in the ordered set of propositions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param propositionId the primary key of the current proposition
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition[] filterFindByCategoryAndGroup_PrevAndNext(
		long propositionId, long groupId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryAndGroup_PrevAndNext(propositionId, groupId,
				categoryId, orderByComparator);
		}

		Proposition proposition = findByPrimaryKey(propositionId);

		Session session = null;

		try {
			session = openSession();

			Proposition[] array = new PropositionImpl[3];

			array[0] = filterGetByCategoryAndGroup_PrevAndNext(session,
					proposition, groupId, categoryId, orderByComparator, true);

			array[1] = proposition;

			array[2] = filterGetByCategoryAndGroup_PrevAndNext(session,
					proposition, groupId, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Proposition filterGetByCategoryAndGroup_PrevAndNext(
		Session session, Proposition proposition, long groupId,
		long categoryId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Proposition.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PropositionImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PropositionImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(proposition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Proposition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the propositions where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByStatusAndCompany(long companyId, int status)
		throws SystemException {
		return findByStatusAndCompany(companyId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the propositions where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @return the range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByStatusAndCompany(long companyId, int status,
		int start, int end) throws SystemException {
		return findByStatusAndCompany(companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the propositions where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByStatusAndCompany(long companyId, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY;
			finderArgs = new Object[] { companyId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDCOMPANY;
			finderArgs = new Object[] {
					companyId, status,
					
					start, end, orderByComparator
				};
		}

		List<Proposition> list = (List<Proposition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Proposition proposition : list) {
				if ((companyId != proposition.getCompanyId()) ||
						(status != proposition.getStatus())) {
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

			query.append(_SQL_SELECT_PROPOSITION_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(status);

				list = (List<Proposition>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first proposition in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByStatusAndCompany_First(long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByStatusAndCompany_First(companyId,
				status, orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the first proposition in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByStatusAndCompany_First(long companyId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<Proposition> list = findByStatusAndCompany(companyId, status, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByStatusAndCompany_Last(long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByStatusAndCompany_Last(companyId,
				status, orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the last proposition in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByStatusAndCompany_Last(long companyId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatusAndCompany(companyId, status);

		List<Proposition> list = findByStatusAndCompany(companyId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the propositions before and after the current proposition in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param propositionId the primary key of the current proposition
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition[] findByStatusAndCompany_PrevAndNext(
		long propositionId, long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = findByPrimaryKey(propositionId);

		Session session = null;

		try {
			session = openSession();

			Proposition[] array = new PropositionImpl[3];

			array[0] = getByStatusAndCompany_PrevAndNext(session, proposition,
					companyId, status, orderByComparator, true);

			array[1] = proposition;

			array[2] = getByStatusAndCompany_PrevAndNext(session, proposition,
					companyId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Proposition getByStatusAndCompany_PrevAndNext(Session session,
		Proposition proposition, long companyId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITION_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_STATUSANDCOMPANY_STATUS_2);

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
			query.append(PropositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(proposition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Proposition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the propositions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByStatusAndGroup(long groupId, int status)
		throws SystemException {
		return findByStatusAndGroup(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the propositions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @return the range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByStatusAndGroup(long groupId, int status,
		int start, int end) throws SystemException {
		return findByStatusAndGroup(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the propositions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByStatusAndGroup(long groupId, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP;
			finderArgs = new Object[] { groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDGROUP;
			finderArgs = new Object[] {
					groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<Proposition> list = (List<Proposition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Proposition proposition : list) {
				if ((groupId != proposition.getGroupId()) ||
						(status != proposition.getStatus())) {
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

			query.append(_SQL_SELECT_PROPOSITION_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				list = (List<Proposition>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first proposition in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByStatusAndGroup_First(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByStatusAndGroup_First(groupId, status,
				orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the first proposition in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByStatusAndGroup_First(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Proposition> list = findByStatusAndGroup(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByStatusAndGroup_Last(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByStatusAndGroup_Last(groupId, status,
				orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the last proposition in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByStatusAndGroup_Last(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatusAndGroup(groupId, status);

		List<Proposition> list = findByStatusAndGroup(groupId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the propositions before and after the current proposition in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param propositionId the primary key of the current proposition
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition[] findByStatusAndGroup_PrevAndNext(long propositionId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = findByPrimaryKey(propositionId);

		Session session = null;

		try {
			session = openSession();

			Proposition[] array = new PropositionImpl[3];

			array[0] = getByStatusAndGroup_PrevAndNext(session, proposition,
					groupId, status, orderByComparator, true);

			array[1] = proposition;

			array[2] = getByStatusAndGroup_PrevAndNext(session, proposition,
					groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Proposition getByStatusAndGroup_PrevAndNext(Session session,
		Proposition proposition, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITION_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

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
			query.append(PropositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(proposition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Proposition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the propositions that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> filterFindByStatusAndGroup(long groupId, int status)
		throws SystemException {
		return filterFindByStatusAndGroup(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the propositions that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @return the range of matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> filterFindByStatusAndGroup(long groupId,
		int status, int start, int end) throws SystemException {
		return filterFindByStatusAndGroup(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the propositions that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> filterFindByStatusAndGroup(long groupId,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByStatusAndGroup(groupId, status, start, end,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Proposition.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PropositionImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PropositionImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(status);

			return (List<Proposition>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the propositions before and after the current proposition in the ordered set of propositions that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param propositionId the primary key of the current proposition
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition[] filterFindByStatusAndGroup_PrevAndNext(
		long propositionId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByStatusAndGroup_PrevAndNext(propositionId, groupId,
				status, orderByComparator);
		}

		Proposition proposition = findByPrimaryKey(propositionId);

		Session session = null;

		try {
			session = openSession();

			Proposition[] array = new PropositionImpl[3];

			array[0] = filterGetByStatusAndGroup_PrevAndNext(session,
					proposition, groupId, status, orderByComparator, true);

			array[1] = proposition;

			array[2] = filterGetByStatusAndGroup_PrevAndNext(session,
					proposition, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Proposition filterGetByStatusAndGroup_PrevAndNext(
		Session session, Proposition proposition, long groupId, int status,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Proposition.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PropositionImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PropositionImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(proposition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Proposition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the propositions where companyId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @return the matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCategoryAndStatusAndCompany(long companyId,
		long categoryId, int status) throws SystemException {
		return findByCategoryAndStatusAndCompany(companyId, categoryId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the propositions where companyId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @return the range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCategoryAndStatusAndCompany(long companyId,
		long categoryId, int status, int start, int end)
		throws SystemException {
		return findByCategoryAndStatusAndCompany(companyId, categoryId, status,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the propositions where companyId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCategoryAndStatusAndCompany(long companyId,
		long categoryId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUSANDCOMPANY;
			finderArgs = new Object[] { companyId, categoryId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDSTATUSANDCOMPANY;
			finderArgs = new Object[] {
					companyId, categoryId, status,
					
					start, end, orderByComparator
				};
		}

		List<Proposition> list = (List<Proposition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Proposition proposition : list) {
				if ((companyId != proposition.getCompanyId()) ||
						(categoryId != proposition.getCategoryId()) ||
						(status != proposition.getStatus())) {
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

			query.append(_SQL_SELECT_PROPOSITION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDCOMPANY_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDCOMPANY_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(categoryId);

				qPos.add(status);

				list = (List<Proposition>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first proposition in the ordered set where companyId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByCategoryAndStatusAndCompany_First(long companyId,
		long categoryId, int status, OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByCategoryAndStatusAndCompany_First(companyId,
				categoryId, status, orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the first proposition in the ordered set where companyId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByCategoryAndStatusAndCompany_First(
		long companyId, long categoryId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Proposition> list = findByCategoryAndStatusAndCompany(companyId,
				categoryId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition in the ordered set where companyId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByCategoryAndStatusAndCompany_Last(long companyId,
		long categoryId, int status, OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByCategoryAndStatusAndCompany_Last(companyId,
				categoryId, status, orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the last proposition in the ordered set where companyId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByCategoryAndStatusAndCompany_Last(long companyId,
		long categoryId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryAndStatusAndCompany(companyId, categoryId,
				status);

		List<Proposition> list = findByCategoryAndStatusAndCompany(companyId,
				categoryId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the propositions before and after the current proposition in the ordered set where companyId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param propositionId the primary key of the current proposition
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition[] findByCategoryAndStatusAndCompany_PrevAndNext(
		long propositionId, long companyId, long categoryId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = findByPrimaryKey(propositionId);

		Session session = null;

		try {
			session = openSession();

			Proposition[] array = new PropositionImpl[3];

			array[0] = getByCategoryAndStatusAndCompany_PrevAndNext(session,
					proposition, companyId, categoryId, status,
					orderByComparator, true);

			array[1] = proposition;

			array[2] = getByCategoryAndStatusAndCompany_PrevAndNext(session,
					proposition, companyId, categoryId, status,
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

	protected Proposition getByCategoryAndStatusAndCompany_PrevAndNext(
		Session session, Proposition proposition, long companyId,
		long categoryId, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITION_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDCOMPANY_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDCOMPANY_STATUS_2);

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
			query.append(PropositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(categoryId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(proposition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Proposition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the propositions where groupId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @return the matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCategoryAndStatusAndGroup(long groupId,
		long categoryId, int status) throws SystemException {
		return findByCategoryAndStatusAndGroup(groupId, categoryId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the propositions where groupId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @return the range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCategoryAndStatusAndGroup(long groupId,
		long categoryId, int status, int start, int end)
		throws SystemException {
		return findByCategoryAndStatusAndGroup(groupId, categoryId, status,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the propositions where groupId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findByCategoryAndStatusAndGroup(long groupId,
		long categoryId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDSTATUSANDGROUP;
			finderArgs = new Object[] { groupId, categoryId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDSTATUSANDGROUP;
			finderArgs = new Object[] {
					groupId, categoryId, status,
					
					start, end, orderByComparator
				};
		}

		List<Proposition> list = (List<Proposition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Proposition proposition : list) {
				if ((groupId != proposition.getGroupId()) ||
						(categoryId != proposition.getCategoryId()) ||
						(status != proposition.getStatus())) {
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

			query.append(_SQL_SELECT_PROPOSITION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				qPos.add(status);

				list = (List<Proposition>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first proposition in the ordered set where groupId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByCategoryAndStatusAndGroup_First(long groupId,
		long categoryId, int status, OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByCategoryAndStatusAndGroup_First(groupId,
				categoryId, status, orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the first proposition in the ordered set where groupId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByCategoryAndStatusAndGroup_First(long groupId,
		long categoryId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<Proposition> list = findByCategoryAndStatusAndGroup(groupId,
				categoryId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition in the ordered set where groupId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition findByCategoryAndStatusAndGroup_Last(long groupId,
		long categoryId, int status, OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = fetchByCategoryAndStatusAndGroup_Last(groupId,
				categoryId, status, orderByComparator);

		if (proposition != null) {
			return proposition;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionException(msg.toString());
	}

	/**
	 * Returns the last proposition in the ordered set where groupId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition fetchByCategoryAndStatusAndGroup_Last(long groupId,
		long categoryId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryAndStatusAndGroup(groupId, categoryId, status);

		List<Proposition> list = findByCategoryAndStatusAndGroup(groupId,
				categoryId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the propositions before and after the current proposition in the ordered set where groupId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param propositionId the primary key of the current proposition
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition[] findByCategoryAndStatusAndGroup_PrevAndNext(
		long propositionId, long groupId, long categoryId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		Proposition proposition = findByPrimaryKey(propositionId);

		Session session = null;

		try {
			session = openSession();

			Proposition[] array = new PropositionImpl[3];

			array[0] = getByCategoryAndStatusAndGroup_PrevAndNext(session,
					proposition, groupId, categoryId, status,
					orderByComparator, true);

			array[1] = proposition;

			array[2] = getByCategoryAndStatusAndGroup_PrevAndNext(session,
					proposition, groupId, categoryId, status,
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

	protected Proposition getByCategoryAndStatusAndGroup_PrevAndNext(
		Session session, Proposition proposition, long groupId,
		long categoryId, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITION_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_STATUS_2);

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
			query.append(PropositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(proposition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Proposition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the propositions that the user has permission to view where groupId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @return the matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> filterFindByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status) throws SystemException {
		return filterFindByCategoryAndStatusAndGroup(groupId, categoryId,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the propositions that the user has permission to view where groupId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @return the range of matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> filterFindByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status, int start, int end)
		throws SystemException {
		return filterFindByCategoryAndStatusAndGroup(groupId, categoryId,
			status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the propositions that the user has permissions to view where groupId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> filterFindByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryAndStatusAndGroup(groupId, categoryId, status,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Proposition.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PropositionImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PropositionImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

			qPos.add(status);

			return (List<Proposition>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the propositions before and after the current proposition in the ordered set of propositions that the user has permission to view where groupId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param propositionId the primary key of the current proposition
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Proposition[] filterFindByCategoryAndStatusAndGroup_PrevAndNext(
		long propositionId, long groupId, long categoryId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCategoryAndStatusAndGroup_PrevAndNext(propositionId,
				groupId, categoryId, status, orderByComparator);
		}

		Proposition proposition = findByPrimaryKey(propositionId);

		Session session = null;

		try {
			session = openSession();

			Proposition[] array = new PropositionImpl[3];

			array[0] = filterGetByCategoryAndStatusAndGroup_PrevAndNext(session,
					proposition, groupId, categoryId, status,
					orderByComparator, true);

			array[1] = proposition;

			array[2] = filterGetByCategoryAndStatusAndGroup_PrevAndNext(session,
					proposition, groupId, categoryId, status,
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

	protected Proposition filterGetByCategoryAndStatusAndGroup_PrevAndNext(
		Session session, Proposition proposition, long groupId,
		long categoryId, int status, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Proposition.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PropositionImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PropositionImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(proposition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Proposition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the propositions.
	 *
	 * @return the propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the propositions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @return the range of propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the propositions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of propositions
	 * @param end the upper bound of the range of propositions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of propositions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Proposition> findAll(int start, int end,
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

		List<Proposition> list = (List<Proposition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROPOSITION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROPOSITION.concat(PropositionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Proposition>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Proposition>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the propositions where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (Proposition proposition : findByCompany(companyId)) {
			remove(proposition);
		}
	}

	/**
	 * Removes all the propositions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (Proposition proposition : findByGroup(groupId)) {
			remove(proposition);
		}
	}

	/**
	 * Removes all the propositions where companyId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryAndCompany(long companyId, long categoryId)
		throws SystemException {
		for (Proposition proposition : findByCategoryAndCompany(companyId,
				categoryId)) {
			remove(proposition);
		}
	}

	/**
	 * Removes all the propositions where groupId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryAndGroup(long groupId, long categoryId)
		throws SystemException {
		for (Proposition proposition : findByCategoryAndGroup(groupId,
				categoryId)) {
			remove(proposition);
		}
	}

	/**
	 * Removes all the propositions where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusAndCompany(long companyId, int status)
		throws SystemException {
		for (Proposition proposition : findByStatusAndCompany(companyId, status)) {
			remove(proposition);
		}
	}

	/**
	 * Removes all the propositions where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusAndGroup(long groupId, int status)
		throws SystemException {
		for (Proposition proposition : findByStatusAndGroup(groupId, status)) {
			remove(proposition);
		}
	}

	/**
	 * Removes all the propositions where companyId = &#63; and categoryId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryAndStatusAndCompany(long companyId,
		long categoryId, int status) throws SystemException {
		for (Proposition proposition : findByCategoryAndStatusAndCompany(
				companyId, categoryId, status)) {
			remove(proposition);
		}
	}

	/**
	 * Removes all the propositions where groupId = &#63; and categoryId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryAndStatusAndGroup(long groupId,
		long categoryId, int status) throws SystemException {
		for (Proposition proposition : findByCategoryAndStatusAndGroup(
				groupId, categoryId, status)) {
			remove(proposition);
		}
	}

	/**
	 * Removes all the propositions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Proposition proposition : findAll()) {
			remove(proposition);
		}
	}

	/**
	 * Returns the number of propositions where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROPOSITION_WHERE);

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
	 * Returns the number of propositions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROPOSITION_WHERE);

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
	 * Returns the number of propositions that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_PROPOSITION_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Proposition.class.getName(),
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
	 * Returns the number of propositions where companyId = &#63; and categoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @return the number of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryAndCompany(long companyId, long categoryId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, categoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROPOSITION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDCOMPANY_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(categoryId);

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
	 * Returns the number of propositions where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryAndGroup(long groupId, long categoryId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, categoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROPOSITION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

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
	 * Returns the number of propositions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByCategoryAndGroup(long groupId, long categoryId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCategoryAndGroup(groupId, categoryId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PROPOSITION_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Proposition.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

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
	 * Returns the number of propositions where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusAndCompany(long companyId, int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROPOSITION_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of propositions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusAndGroup(long groupId, int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROPOSITION_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of propositions that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByStatusAndGroup(long groupId, int status)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByStatusAndGroup(groupId, status);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PROPOSITION_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Proposition.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

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
	 * Returns the number of propositions where companyId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @return the number of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryAndStatusAndCompany(long companyId,
		long categoryId, int status) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, categoryId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYANDSTATUSANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PROPOSITION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDCOMPANY_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDCOMPANY_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(categoryId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYANDSTATUSANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of propositions where groupId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @return the number of matching propositions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryAndStatusAndGroup(long groupId, long categoryId,
		int status) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, categoryId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYANDSTATUSANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PROPOSITION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYANDSTATUSANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of propositions that the user has permission to view where groupId = &#63; and categoryId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param status the status
	 * @return the number of matching propositions that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByCategoryAndStatusAndGroup(long groupId,
		long categoryId, int status) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCategoryAndStatusAndGroup(groupId, categoryId, status);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_PROPOSITION_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_CATEGORYID_2);

		query.append(_FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Proposition.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

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
	 * Returns the number of propositions.
	 *
	 * @return the number of propositions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROPOSITION);

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
	 * Initializes the proposition persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.proposition_feedback.model.Proposition")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Proposition>> listenersList = new ArrayList<ModelListener<Proposition>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Proposition>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PropositionImpl.class.getName());
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
	private static final String _SQL_SELECT_PROPOSITION = "SELECT proposition FROM Proposition proposition";
	private static final String _SQL_SELECT_PROPOSITION_WHERE = "SELECT proposition FROM Proposition proposition WHERE ";
	private static final String _SQL_COUNT_PROPOSITION = "SELECT COUNT(proposition) FROM Proposition proposition";
	private static final String _SQL_COUNT_PROPOSITION_WHERE = "SELECT COUNT(proposition) FROM Proposition proposition WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "proposition.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "proposition.groupId = ?";
	private static final String _FINDER_COLUMN_CATEGORYANDCOMPANY_COMPANYID_2 = "proposition.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDCOMPANY_CATEGORYID_2 = "proposition.categoryId = ?";
	private static final String _FINDER_COLUMN_CATEGORYANDGROUP_GROUPID_2 = "proposition.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDGROUP_CATEGORYID_2 = "proposition.categoryId = ?";
	private static final String _FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2 = "proposition.companyId = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDCOMPANY_STATUS_2 = "proposition.status = ?";
	private static final String _FINDER_COLUMN_STATUSANDGROUP_GROUPID_2 = "proposition.groupId = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDGROUP_STATUS_2 = "proposition.status = ?";
	private static final String _FINDER_COLUMN_CATEGORYANDSTATUSANDCOMPANY_COMPANYID_2 =
		"proposition.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDSTATUSANDCOMPANY_CATEGORYID_2 =
		"proposition.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDSTATUSANDCOMPANY_STATUS_2 =
		"proposition.status = ?";
	private static final String _FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_GROUPID_2 =
		"proposition.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_CATEGORYID_2 =
		"proposition.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDSTATUSANDGROUP_STATUS_2 =
		"proposition.status = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "proposition.propositionId";
	private static final String _FILTER_SQL_SELECT_PROPOSITION_WHERE = "SELECT DISTINCT {proposition.*} FROM Proposition proposition WHERE ";
	private static final String _FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Proposition.*} FROM (SELECT DISTINCT proposition.propositionId FROM Proposition proposition WHERE ";
	private static final String _FILTER_SQL_SELECT_PROPOSITION_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Proposition ON TEMP_TABLE.propositionId = Proposition.propositionId";
	private static final String _FILTER_SQL_COUNT_PROPOSITION_WHERE = "SELECT COUNT(DISTINCT proposition.propositionId) AS COUNT_VALUE FROM Proposition proposition WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "proposition";
	private static final String _FILTER_ENTITY_TABLE = "Proposition";
	private static final String _ORDER_BY_ENTITY_ALIAS = "proposition.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Proposition.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Proposition exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Proposition exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PropositionPersistenceImpl.class);
	private static Proposition _nullProposition = new PropositionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Proposition> toCacheModel() {
				return _nullPropositionCacheModel;
			}
		};

	private static CacheModel<Proposition> _nullPropositionCacheModel = new CacheModel<Proposition>() {
			public Proposition toEntityModel() {
				return _nullProposition;
			}
		};
}