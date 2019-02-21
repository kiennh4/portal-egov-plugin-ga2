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

import com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;
import com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback;
import com.portal_egov.portlet.proposition_feedback.model.impl.PropositionFeedbackImpl;
import com.portal_egov.portlet.proposition_feedback.model.impl.PropositionFeedbackModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the proposition feedback service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see PropositionFeedbackPersistence
 * @see PropositionFeedbackUtil
 * @generated
 */
public class PropositionFeedbackPersistenceImpl extends BasePersistenceImpl<PropositionFeedback>
	implements PropositionFeedbackPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PropositionFeedbackUtil} to access the proposition feedback persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PropositionFeedbackImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			PropositionFeedbackModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			PropositionFeedbackModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDCOMPANY =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusAndCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatusAndCompany",
			new String[] { Long.class.getName(), Integer.class.getName() },
			PropositionFeedbackModelImpl.COMPANYID_COLUMN_BITMASK |
			PropositionFeedbackModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDCOMPANY = new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusAndCompany",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDGROUP =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusAndGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusAndGroup",
			new String[] { Long.class.getName(), Integer.class.getName() },
			PropositionFeedbackModelImpl.GROUPID_COLUMN_BITMASK |
			PropositionFeedbackModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDGROUP = new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusAndGroup",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSITIONANDCOMPANY =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPropositionAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDCOMPANY =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPropositionAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			PropositionFeedbackModelImpl.COMPANYID_COLUMN_BITMASK |
			PropositionFeedbackModelImpl.PROPOSITIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROPOSITIONANDCOMPANY = new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPropositionAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSITIONANDGROUP =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPropositionAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDGROUP =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPropositionAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			PropositionFeedbackModelImpl.GROUPID_COLUMN_BITMASK |
			PropositionFeedbackModelImpl.PROPOSITIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROPOSITIONANDGROUP = new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPropositionAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSITIONANDSTATUSANDCOMPANY =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPropositionAndStatusAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDSTATUSANDCOMPANY =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPropositionAndStatusAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			PropositionFeedbackModelImpl.COMPANYID_COLUMN_BITMASK |
			PropositionFeedbackModelImpl.PROPOSITIONID_COLUMN_BITMASK |
			PropositionFeedbackModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROPOSITIONANDSTATUSANDCOMPANY =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPropositionAndStatusAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSITIONANDSTATUSANDGROUP =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPropositionAndStatusAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDSTATUSANDGROUP =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPropositionAndStatusAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			PropositionFeedbackModelImpl.GROUPID_COLUMN_BITMASK |
			PropositionFeedbackModelImpl.PROPOSITIONID_COLUMN_BITMASK |
			PropositionFeedbackModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROPOSITIONANDSTATUSANDGROUP =
		new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPropositionAndStatusAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED,
			PropositionFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the proposition feedback in the entity cache if it is enabled.
	 *
	 * @param propositionFeedback the proposition feedback
	 */
	public void cacheResult(PropositionFeedback propositionFeedback) {
		EntityCacheUtil.putResult(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackImpl.class, propositionFeedback.getPrimaryKey(),
			propositionFeedback);

		propositionFeedback.resetOriginalValues();
	}

	/**
	 * Caches the proposition feedbacks in the entity cache if it is enabled.
	 *
	 * @param propositionFeedbacks the proposition feedbacks
	 */
	public void cacheResult(List<PropositionFeedback> propositionFeedbacks) {
		for (PropositionFeedback propositionFeedback : propositionFeedbacks) {
			if (EntityCacheUtil.getResult(
						PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
						PropositionFeedbackImpl.class,
						propositionFeedback.getPrimaryKey()) == null) {
				cacheResult(propositionFeedback);
			}
			else {
				propositionFeedback.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all proposition feedbacks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PropositionFeedbackImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PropositionFeedbackImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the proposition feedback.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PropositionFeedback propositionFeedback) {
		EntityCacheUtil.removeResult(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackImpl.class, propositionFeedback.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PropositionFeedback> propositionFeedbacks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PropositionFeedback propositionFeedback : propositionFeedbacks) {
			EntityCacheUtil.removeResult(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
				PropositionFeedbackImpl.class,
				propositionFeedback.getPrimaryKey());
		}
	}

	/**
	 * Creates a new proposition feedback with the primary key. Does not add the proposition feedback to the database.
	 *
	 * @param feedbackId the primary key for the new proposition feedback
	 * @return the new proposition feedback
	 */
	public PropositionFeedback create(long feedbackId) {
		PropositionFeedback propositionFeedback = new PropositionFeedbackImpl();

		propositionFeedback.setNew(true);
		propositionFeedback.setPrimaryKey(feedbackId);

		return propositionFeedback;
	}

	/**
	 * Removes the proposition feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedbackId the primary key of the proposition feedback
	 * @return the proposition feedback that was removed
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback remove(long feedbackId)
		throws NoSuchPropositionFeedbackException, SystemException {
		return remove(Long.valueOf(feedbackId));
	}

	/**
	 * Removes the proposition feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the proposition feedback
	 * @return the proposition feedback that was removed
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PropositionFeedback remove(Serializable primaryKey)
		throws NoSuchPropositionFeedbackException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PropositionFeedback propositionFeedback = (PropositionFeedback)session.get(PropositionFeedbackImpl.class,
					primaryKey);

			if (propositionFeedback == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPropositionFeedbackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(propositionFeedback);
		}
		catch (NoSuchPropositionFeedbackException nsee) {
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
	protected PropositionFeedback removeImpl(
		PropositionFeedback propositionFeedback) throws SystemException {
		propositionFeedback = toUnwrappedModel(propositionFeedback);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, propositionFeedback);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(propositionFeedback);

		return propositionFeedback;
	}

	@Override
	public PropositionFeedback updateImpl(
		com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback propositionFeedback,
		boolean merge) throws SystemException {
		propositionFeedback = toUnwrappedModel(propositionFeedback);

		boolean isNew = propositionFeedback.isNew();

		PropositionFeedbackModelImpl propositionFeedbackModelImpl = (PropositionFeedbackModelImpl)propositionFeedback;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, propositionFeedback, merge);

			propositionFeedback.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PropositionFeedbackModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((propositionFeedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((propositionFeedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((propositionFeedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getOriginalCompanyId()),
						Integer.valueOf(propositionFeedbackModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getCompanyId()),
						Integer.valueOf(propositionFeedbackModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY,
					args);
			}

			if ((propositionFeedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getOriginalGroupId()),
						Integer.valueOf(propositionFeedbackModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getGroupId()),
						Integer.valueOf(propositionFeedbackModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP,
					args);
			}

			if ((propositionFeedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getOriginalCompanyId()),
						Long.valueOf(propositionFeedbackModelImpl.getOriginalPropositionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getCompanyId()),
						Long.valueOf(propositionFeedbackModelImpl.getPropositionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDCOMPANY,
					args);
			}

			if ((propositionFeedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getOriginalGroupId()),
						Long.valueOf(propositionFeedbackModelImpl.getOriginalPropositionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getGroupId()),
						Long.valueOf(propositionFeedbackModelImpl.getPropositionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDGROUP,
					args);
			}

			if ((propositionFeedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDSTATUSANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getOriginalCompanyId()),
						Long.valueOf(propositionFeedbackModelImpl.getOriginalPropositionId()),
						Integer.valueOf(propositionFeedbackModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDSTATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDSTATUSANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getCompanyId()),
						Long.valueOf(propositionFeedbackModelImpl.getPropositionId()),
						Integer.valueOf(propositionFeedbackModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDSTATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDSTATUSANDCOMPANY,
					args);
			}

			if ((propositionFeedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDSTATUSANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getOriginalGroupId()),
						Long.valueOf(propositionFeedbackModelImpl.getOriginalPropositionId()),
						Integer.valueOf(propositionFeedbackModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDSTATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDSTATUSANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(propositionFeedbackModelImpl.getGroupId()),
						Long.valueOf(propositionFeedbackModelImpl.getPropositionId()),
						Integer.valueOf(propositionFeedbackModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDSTATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDSTATUSANDGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			PropositionFeedbackImpl.class, propositionFeedback.getPrimaryKey(),
			propositionFeedback);

		return propositionFeedback;
	}

	protected PropositionFeedback toUnwrappedModel(
		PropositionFeedback propositionFeedback) {
		if (propositionFeedback instanceof PropositionFeedbackImpl) {
			return propositionFeedback;
		}

		PropositionFeedbackImpl propositionFeedbackImpl = new PropositionFeedbackImpl();

		propositionFeedbackImpl.setNew(propositionFeedback.isNew());
		propositionFeedbackImpl.setPrimaryKey(propositionFeedback.getPrimaryKey());

		propositionFeedbackImpl.setFeedbackId(propositionFeedback.getFeedbackId());
		propositionFeedbackImpl.setCompanyId(propositionFeedback.getCompanyId());
		propositionFeedbackImpl.setGroupId(propositionFeedback.getGroupId());
		propositionFeedbackImpl.setUserId(propositionFeedback.getUserId());
		propositionFeedbackImpl.setPropositionId(propositionFeedback.getPropositionId());
		propositionFeedbackImpl.setFeedbackFileAttId(propositionFeedback.getFeedbackFileAttId());
		propositionFeedbackImpl.setFeedbackTitle(propositionFeedback.getFeedbackTitle());
		propositionFeedbackImpl.setFeedbackContent(propositionFeedback.getFeedbackContent());
		propositionFeedbackImpl.setCitizenName(propositionFeedback.getCitizenName());
		propositionFeedbackImpl.setCitizenEmail(propositionFeedback.getCitizenEmail());
		propositionFeedbackImpl.setCitizenPhone(propositionFeedback.getCitizenPhone());
		propositionFeedbackImpl.setCitizenAddress(propositionFeedback.getCitizenAddress());
		propositionFeedbackImpl.setCreateDate(propositionFeedback.getCreateDate());
		propositionFeedbackImpl.setModifiedDate(propositionFeedback.getModifiedDate());
		propositionFeedbackImpl.setStatus(propositionFeedback.getStatus());
		propositionFeedbackImpl.setStatusByUserId(propositionFeedback.getStatusByUserId());
		propositionFeedbackImpl.setStatusDate(propositionFeedback.getStatusDate());

		return propositionFeedbackImpl;
	}

	/**
	 * Returns the proposition feedback with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the proposition feedback
	 * @return the proposition feedback
	 * @throws com.liferay.portal.NoSuchModelException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PropositionFeedback findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the proposition feedback with the primary key or throws a {@link com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException} if it could not be found.
	 *
	 * @param feedbackId the primary key of the proposition feedback
	 * @return the proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByPrimaryKey(long feedbackId)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByPrimaryKey(feedbackId);

		if (propositionFeedback == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + feedbackId);
			}

			throw new NoSuchPropositionFeedbackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				feedbackId);
		}

		return propositionFeedback;
	}

	/**
	 * Returns the proposition feedback with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the proposition feedback
	 * @return the proposition feedback, or <code>null</code> if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PropositionFeedback fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the proposition feedback with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param feedbackId the primary key of the proposition feedback
	 * @return the proposition feedback, or <code>null</code> if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByPrimaryKey(long feedbackId)
		throws SystemException {
		PropositionFeedback propositionFeedback = (PropositionFeedback)EntityCacheUtil.getResult(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
				PropositionFeedbackImpl.class, feedbackId);

		if (propositionFeedback == _nullPropositionFeedback) {
			return null;
		}

		if (propositionFeedback == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				propositionFeedback = (PropositionFeedback)session.get(PropositionFeedbackImpl.class,
						Long.valueOf(feedbackId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (propositionFeedback != null) {
					cacheResult(propositionFeedback);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PropositionFeedbackModelImpl.ENTITY_CACHE_ENABLED,
						PropositionFeedbackImpl.class, feedbackId,
						_nullPropositionFeedback);
				}

				closeSession(session);
			}
		}

		return propositionFeedback;
	}

	/**
	 * Returns all the proposition feedbacks where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the proposition feedbacks where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @return the range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition feedbacks where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByCompany(long companyId, int start,
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

		List<PropositionFeedback> list = (List<PropositionFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PropositionFeedback propositionFeedback : list) {
				if ((companyId != propositionFeedback.getCompanyId())) {
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

			query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<PropositionFeedback>)QueryUtil.list(q,
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
	 * Returns the first proposition feedback in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByCompany_First(companyId,
				orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the first proposition feedback in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PropositionFeedback> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition feedback in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByCompany_Last(companyId,
				orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the last proposition feedback in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<PropositionFeedback> list = findByCompany(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where companyId = &#63;.
	 *
	 * @param feedbackId the primary key of the current proposition feedback
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback[] findByCompany_PrevAndNext(long feedbackId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			PropositionFeedback[] array = new PropositionFeedbackImpl[3];

			array[0] = getByCompany_PrevAndNext(session, propositionFeedback,
					companyId, orderByComparator, true);

			array[1] = propositionFeedback;

			array[2] = getByCompany_PrevAndNext(session, propositionFeedback,
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

	protected PropositionFeedback getByCompany_PrevAndNext(Session session,
		PropositionFeedback propositionFeedback, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

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
			query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition feedbacks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition feedbacks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @return the range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByGroup(long groupId, int start,
		int end) throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition feedbacks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByGroup(long groupId, int start,
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

		List<PropositionFeedback> list = (List<PropositionFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PropositionFeedback propositionFeedback : list) {
				if ((groupId != propositionFeedback.getGroupId())) {
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

			query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<PropositionFeedback>)QueryUtil.list(q,
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
	 * Returns the first proposition feedback in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByGroup_First(groupId,
				orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the first proposition feedback in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PropositionFeedback> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition feedback in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByGroup_Last(groupId,
				orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the last proposition feedback in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<PropositionFeedback> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where groupId = &#63;.
	 *
	 * @param feedbackId the primary key of the current proposition feedback
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback[] findByGroup_PrevAndNext(long feedbackId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			PropositionFeedback[] array = new PropositionFeedbackImpl[3];

			array[0] = getByGroup_PrevAndNext(session, propositionFeedback,
					groupId, orderByComparator, true);

			array[1] = propositionFeedback;

			array[2] = getByGroup_PrevAndNext(session, propositionFeedback,
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

	protected PropositionFeedback getByGroup_PrevAndNext(Session session,
		PropositionFeedback propositionFeedback, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

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
			query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition feedbacks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the proposition feedbacks that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @return the range of matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition feedbacks that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionFeedback.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PropositionFeedbackImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PropositionFeedbackImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<PropositionFeedback>)QueryUtil.list(q, getDialect(),
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
	 * Returns the proposition feedbacks before and after the current proposition feedback in the ordered set of proposition feedbacks that the user has permission to view where groupId = &#63;.
	 *
	 * @param feedbackId the primary key of the current proposition feedback
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback[] filterFindByGroup_PrevAndNext(
		long feedbackId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(feedbackId, groupId,
				orderByComparator);
		}

		PropositionFeedback propositionFeedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			PropositionFeedback[] array = new PropositionFeedbackImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session,
					propositionFeedback, groupId, orderByComparator, true);

			array[1] = propositionFeedback;

			array[2] = filterGetByGroup_PrevAndNext(session,
					propositionFeedback, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PropositionFeedback filterGetByGroup_PrevAndNext(
		Session session, PropositionFeedback propositionFeedback, long groupId,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionFeedback.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PropositionFeedbackImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PropositionFeedbackImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition feedbacks where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByStatusAndCompany(long companyId,
		int status) throws SystemException {
		return findByStatusAndCompany(companyId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition feedbacks where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @return the range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByStatusAndCompany(long companyId,
		int status, int start, int end) throws SystemException {
		return findByStatusAndCompany(companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition feedbacks where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByStatusAndCompany(long companyId,
		int status, int start, int end, OrderByComparator orderByComparator)
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

		List<PropositionFeedback> list = (List<PropositionFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PropositionFeedback propositionFeedback : list) {
				if ((companyId != propositionFeedback.getCompanyId()) ||
						(status != propositionFeedback.getStatus())) {
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

			query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(status);

				list = (List<PropositionFeedback>)QueryUtil.list(q,
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
	 * Returns the first proposition feedback in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByStatusAndCompany_First(long companyId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByStatusAndCompany_First(companyId,
				status, orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the first proposition feedback in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByStatusAndCompany_First(long companyId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<PropositionFeedback> list = findByStatusAndCompany(companyId,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition feedback in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByStatusAndCompany_Last(long companyId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByStatusAndCompany_Last(companyId,
				status, orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the last proposition feedback in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByStatusAndCompany_Last(long companyId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStatusAndCompany(companyId, status);

		List<PropositionFeedback> list = findByStatusAndCompany(companyId,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param feedbackId the primary key of the current proposition feedback
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback[] findByStatusAndCompany_PrevAndNext(
		long feedbackId, long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			PropositionFeedback[] array = new PropositionFeedbackImpl[3];

			array[0] = getByStatusAndCompany_PrevAndNext(session,
					propositionFeedback, companyId, status, orderByComparator,
					true);

			array[1] = propositionFeedback;

			array[2] = getByStatusAndCompany_PrevAndNext(session,
					propositionFeedback, companyId, status, orderByComparator,
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

	protected PropositionFeedback getByStatusAndCompany_PrevAndNext(
		Session session, PropositionFeedback propositionFeedback,
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

		query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

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
			query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition feedbacks where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByStatusAndGroup(long groupId,
		int status) throws SystemException {
		return findByStatusAndGroup(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition feedbacks where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @return the range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByStatusAndGroup(long groupId,
		int status, int start, int end) throws SystemException {
		return findByStatusAndGroup(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition feedbacks where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByStatusAndGroup(long groupId,
		int status, int start, int end, OrderByComparator orderByComparator)
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

		List<PropositionFeedback> list = (List<PropositionFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PropositionFeedback propositionFeedback : list) {
				if ((groupId != propositionFeedback.getGroupId()) ||
						(status != propositionFeedback.getStatus())) {
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

			query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				list = (List<PropositionFeedback>)QueryUtil.list(q,
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
	 * Returns the first proposition feedback in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByStatusAndGroup_First(long groupId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByStatusAndGroup_First(groupId,
				status, orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the first proposition feedback in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByStatusAndGroup_First(long groupId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<PropositionFeedback> list = findByStatusAndGroup(groupId, status,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition feedback in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByStatusAndGroup_Last(long groupId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByStatusAndGroup_Last(groupId,
				status, orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the last proposition feedback in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByStatusAndGroup_Last(long groupId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStatusAndGroup(groupId, status);

		List<PropositionFeedback> list = findByStatusAndGroup(groupId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param feedbackId the primary key of the current proposition feedback
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback[] findByStatusAndGroup_PrevAndNext(
		long feedbackId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			PropositionFeedback[] array = new PropositionFeedbackImpl[3];

			array[0] = getByStatusAndGroup_PrevAndNext(session,
					propositionFeedback, groupId, status, orderByComparator,
					true);

			array[1] = propositionFeedback;

			array[2] = getByStatusAndGroup_PrevAndNext(session,
					propositionFeedback, groupId, status, orderByComparator,
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

	protected PropositionFeedback getByStatusAndGroup_PrevAndNext(
		Session session, PropositionFeedback propositionFeedback, long groupId,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

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
			query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition feedbacks that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> filterFindByStatusAndGroup(long groupId,
		int status) throws SystemException {
		return filterFindByStatusAndGroup(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition feedbacks that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @return the range of matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> filterFindByStatusAndGroup(long groupId,
		int status, int start, int end) throws SystemException {
		return filterFindByStatusAndGroup(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition feedbacks that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> filterFindByStatusAndGroup(long groupId,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionFeedback.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PropositionFeedbackImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PropositionFeedbackImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(status);

			return (List<PropositionFeedback>)QueryUtil.list(q, getDialect(),
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
	 * Returns the proposition feedbacks before and after the current proposition feedback in the ordered set of proposition feedbacks that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param feedbackId the primary key of the current proposition feedback
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback[] filterFindByStatusAndGroup_PrevAndNext(
		long feedbackId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByStatusAndGroup_PrevAndNext(feedbackId, groupId,
				status, orderByComparator);
		}

		PropositionFeedback propositionFeedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			PropositionFeedback[] array = new PropositionFeedbackImpl[3];

			array[0] = filterGetByStatusAndGroup_PrevAndNext(session,
					propositionFeedback, groupId, status, orderByComparator,
					true);

			array[1] = propositionFeedback;

			array[2] = filterGetByStatusAndGroup_PrevAndNext(session,
					propositionFeedback, groupId, status, orderByComparator,
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

	protected PropositionFeedback filterGetByStatusAndGroup_PrevAndNext(
		Session session, PropositionFeedback propositionFeedback, long groupId,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionFeedback.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PropositionFeedbackImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PropositionFeedbackImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition feedbacks where companyId = &#63; and propositionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @return the matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByPropositionAndCompany(
		long companyId, long propositionId) throws SystemException {
		return findByPropositionAndCompany(companyId, propositionId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition feedbacks where companyId = &#63; and propositionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @return the range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByPropositionAndCompany(
		long companyId, long propositionId, int start, int end)
		throws SystemException {
		return findByPropositionAndCompany(companyId, propositionId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the proposition feedbacks where companyId = &#63; and propositionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByPropositionAndCompany(
		long companyId, long propositionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDCOMPANY;
			finderArgs = new Object[] { companyId, propositionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSITIONANDCOMPANY;
			finderArgs = new Object[] {
					companyId, propositionId,
					
					start, end, orderByComparator
				};
		}

		List<PropositionFeedback> list = (List<PropositionFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PropositionFeedback propositionFeedback : list) {
				if ((companyId != propositionFeedback.getCompanyId()) ||
						(propositionId != propositionFeedback.getPropositionId())) {
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

			query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_PROPOSITIONANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_PROPOSITIONANDCOMPANY_PROPOSITIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(propositionId);

				list = (List<PropositionFeedback>)QueryUtil.list(q,
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
	 * Returns the first proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByPropositionAndCompany_First(
		long companyId, long propositionId, OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByPropositionAndCompany_First(companyId,
				propositionId, orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", propositionId=");
		msg.append(propositionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the first proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByPropositionAndCompany_First(
		long companyId, long propositionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PropositionFeedback> list = findByPropositionAndCompany(companyId,
				propositionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByPropositionAndCompany_Last(
		long companyId, long propositionId, OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByPropositionAndCompany_Last(companyId,
				propositionId, orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", propositionId=");
		msg.append(propositionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the last proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByPropositionAndCompany_Last(
		long companyId, long propositionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPropositionAndCompany(companyId, propositionId);

		List<PropositionFeedback> list = findByPropositionAndCompany(companyId,
				propositionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63;.
	 *
	 * @param feedbackId the primary key of the current proposition feedback
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback[] findByPropositionAndCompany_PrevAndNext(
		long feedbackId, long companyId, long propositionId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			PropositionFeedback[] array = new PropositionFeedbackImpl[3];

			array[0] = getByPropositionAndCompany_PrevAndNext(session,
					propositionFeedback, companyId, propositionId,
					orderByComparator, true);

			array[1] = propositionFeedback;

			array[2] = getByPropositionAndCompany_PrevAndNext(session,
					propositionFeedback, companyId, propositionId,
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

	protected PropositionFeedback getByPropositionAndCompany_PrevAndNext(
		Session session, PropositionFeedback propositionFeedback,
		long companyId, long propositionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

		query.append(_FINDER_COLUMN_PROPOSITIONANDCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDCOMPANY_PROPOSITIONID_2);

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
			query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(propositionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition feedbacks where groupId = &#63; and propositionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @return the matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByPropositionAndGroup(long groupId,
		long propositionId) throws SystemException {
		return findByPropositionAndGroup(groupId, propositionId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition feedbacks where groupId = &#63; and propositionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @return the range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByPropositionAndGroup(long groupId,
		long propositionId, int start, int end) throws SystemException {
		return findByPropositionAndGroup(groupId, propositionId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the proposition feedbacks where groupId = &#63; and propositionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByPropositionAndGroup(long groupId,
		long propositionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDGROUP;
			finderArgs = new Object[] { groupId, propositionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSITIONANDGROUP;
			finderArgs = new Object[] {
					groupId, propositionId,
					
					start, end, orderByComparator
				};
		}

		List<PropositionFeedback> list = (List<PropositionFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PropositionFeedback propositionFeedback : list) {
				if ((groupId != propositionFeedback.getGroupId()) ||
						(propositionId != propositionFeedback.getPropositionId())) {
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

			query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_PROPOSITIONANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_PROPOSITIONANDGROUP_PROPOSITIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(propositionId);

				list = (List<PropositionFeedback>)QueryUtil.list(q,
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
	 * Returns the first proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByPropositionAndGroup_First(long groupId,
		long propositionId, OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByPropositionAndGroup_First(groupId,
				propositionId, orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", propositionId=");
		msg.append(propositionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the first proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByPropositionAndGroup_First(long groupId,
		long propositionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PropositionFeedback> list = findByPropositionAndGroup(groupId,
				propositionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByPropositionAndGroup_Last(long groupId,
		long propositionId, OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByPropositionAndGroup_Last(groupId,
				propositionId, orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", propositionId=");
		msg.append(propositionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the last proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByPropositionAndGroup_Last(long groupId,
		long propositionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPropositionAndGroup(groupId, propositionId);

		List<PropositionFeedback> list = findByPropositionAndGroup(groupId,
				propositionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63;.
	 *
	 * @param feedbackId the primary key of the current proposition feedback
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback[] findByPropositionAndGroup_PrevAndNext(
		long feedbackId, long groupId, long propositionId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			PropositionFeedback[] array = new PropositionFeedbackImpl[3];

			array[0] = getByPropositionAndGroup_PrevAndNext(session,
					propositionFeedback, groupId, propositionId,
					orderByComparator, true);

			array[1] = propositionFeedback;

			array[2] = getByPropositionAndGroup_PrevAndNext(session,
					propositionFeedback, groupId, propositionId,
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

	protected PropositionFeedback getByPropositionAndGroup_PrevAndNext(
		Session session, PropositionFeedback propositionFeedback, long groupId,
		long propositionId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

		query.append(_FINDER_COLUMN_PROPOSITIONANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDGROUP_PROPOSITIONID_2);

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
			query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(propositionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @return the matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> filterFindByPropositionAndGroup(
		long groupId, long propositionId) throws SystemException {
		return filterFindByPropositionAndGroup(groupId, propositionId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @return the range of matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> filterFindByPropositionAndGroup(
		long groupId, long propositionId, int start, int end)
		throws SystemException {
		return filterFindByPropositionAndGroup(groupId, propositionId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the proposition feedbacks that the user has permissions to view where groupId = &#63; and propositionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> filterFindByPropositionAndGroup(
		long groupId, long propositionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByPropositionAndGroup(groupId, propositionId, start,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PROPOSITIONANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDGROUP_PROPOSITIONID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionFeedback.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PropositionFeedbackImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PropositionFeedbackImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(propositionId);

			return (List<PropositionFeedback>)QueryUtil.list(q, getDialect(),
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
	 * Returns the proposition feedbacks before and after the current proposition feedback in the ordered set of proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63;.
	 *
	 * @param feedbackId the primary key of the current proposition feedback
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback[] filterFindByPropositionAndGroup_PrevAndNext(
		long feedbackId, long groupId, long propositionId,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByPropositionAndGroup_PrevAndNext(feedbackId, groupId,
				propositionId, orderByComparator);
		}

		PropositionFeedback propositionFeedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			PropositionFeedback[] array = new PropositionFeedbackImpl[3];

			array[0] = filterGetByPropositionAndGroup_PrevAndNext(session,
					propositionFeedback, groupId, propositionId,
					orderByComparator, true);

			array[1] = propositionFeedback;

			array[2] = filterGetByPropositionAndGroup_PrevAndNext(session,
					propositionFeedback, groupId, propositionId,
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

	protected PropositionFeedback filterGetByPropositionAndGroup_PrevAndNext(
		Session session, PropositionFeedback propositionFeedback, long groupId,
		long propositionId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PROPOSITIONANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDGROUP_PROPOSITIONID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionFeedback.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PropositionFeedbackImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PropositionFeedbackImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(propositionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition feedbacks where companyId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @return the matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByPropositionAndStatusAndCompany(
		long companyId, long propositionId, int status)
		throws SystemException {
		return findByPropositionAndStatusAndCompany(companyId, propositionId,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition feedbacks where companyId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @return the range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByPropositionAndStatusAndCompany(
		long companyId, long propositionId, int status, int start, int end)
		throws SystemException {
		return findByPropositionAndStatusAndCompany(companyId, propositionId,
			status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition feedbacks where companyId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByPropositionAndStatusAndCompany(
		long companyId, long propositionId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDSTATUSANDCOMPANY;
			finderArgs = new Object[] { companyId, propositionId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSITIONANDSTATUSANDCOMPANY;
			finderArgs = new Object[] {
					companyId, propositionId, status,
					
					start, end, orderByComparator
				};
		}

		List<PropositionFeedback> list = (List<PropositionFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PropositionFeedback propositionFeedback : list) {
				if ((companyId != propositionFeedback.getCompanyId()) ||
						(propositionId != propositionFeedback.getPropositionId()) ||
						(status != propositionFeedback.getStatus())) {
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

			query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDCOMPANY_PROPOSITIONID_2);

			query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDCOMPANY_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(propositionId);

				qPos.add(status);

				list = (List<PropositionFeedback>)QueryUtil.list(q,
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
	 * Returns the first proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByPropositionAndStatusAndCompany_First(
		long companyId, long propositionId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByPropositionAndStatusAndCompany_First(companyId,
				propositionId, status, orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", propositionId=");
		msg.append(propositionId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the first proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByPropositionAndStatusAndCompany_First(
		long companyId, long propositionId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<PropositionFeedback> list = findByPropositionAndStatusAndCompany(companyId,
				propositionId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByPropositionAndStatusAndCompany_Last(
		long companyId, long propositionId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByPropositionAndStatusAndCompany_Last(companyId,
				propositionId, status, orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", propositionId=");
		msg.append(propositionId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the last proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByPropositionAndStatusAndCompany_Last(
		long companyId, long propositionId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPropositionAndStatusAndCompany(companyId,
				propositionId, status);

		List<PropositionFeedback> list = findByPropositionAndStatusAndCompany(companyId,
				propositionId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param feedbackId the primary key of the current proposition feedback
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback[] findByPropositionAndStatusAndCompany_PrevAndNext(
		long feedbackId, long companyId, long propositionId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			PropositionFeedback[] array = new PropositionFeedbackImpl[3];

			array[0] = getByPropositionAndStatusAndCompany_PrevAndNext(session,
					propositionFeedback, companyId, propositionId, status,
					orderByComparator, true);

			array[1] = propositionFeedback;

			array[2] = getByPropositionAndStatusAndCompany_PrevAndNext(session,
					propositionFeedback, companyId, propositionId, status,
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

	protected PropositionFeedback getByPropositionAndStatusAndCompany_PrevAndNext(
		Session session, PropositionFeedback propositionFeedback,
		long companyId, long propositionId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDCOMPANY_PROPOSITIONID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDCOMPANY_STATUS_2);

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
			query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(propositionId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition feedbacks where groupId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @return the matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status) throws SystemException {
		return findByPropositionAndStatusAndGroup(groupId, propositionId,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition feedbacks where groupId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @return the range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status, int start, int end)
		throws SystemException {
		return findByPropositionAndStatusAndGroup(groupId, propositionId,
			status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition feedbacks where groupId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSITIONANDSTATUSANDGROUP;
			finderArgs = new Object[] { groupId, propositionId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSITIONANDSTATUSANDGROUP;
			finderArgs = new Object[] {
					groupId, propositionId, status,
					
					start, end, orderByComparator
				};
		}

		List<PropositionFeedback> list = (List<PropositionFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PropositionFeedback propositionFeedback : list) {
				if ((groupId != propositionFeedback.getGroupId()) ||
						(propositionId != propositionFeedback.getPropositionId()) ||
						(status != propositionFeedback.getStatus())) {
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

			query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_PROPOSITIONID_2);

			query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(propositionId);

				qPos.add(status);

				list = (List<PropositionFeedback>)QueryUtil.list(q,
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
	 * Returns the first proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByPropositionAndStatusAndGroup_First(
		long groupId, long propositionId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByPropositionAndStatusAndGroup_First(groupId,
				propositionId, status, orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", propositionId=");
		msg.append(propositionId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the first proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByPropositionAndStatusAndGroup_First(
		long groupId, long propositionId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<PropositionFeedback> list = findByPropositionAndStatusAndGroup(groupId,
				propositionId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback findByPropositionAndStatusAndGroup_Last(
		long groupId, long propositionId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = fetchByPropositionAndStatusAndGroup_Last(groupId,
				propositionId, status, orderByComparator);

		if (propositionFeedback != null) {
			return propositionFeedback;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", propositionId=");
		msg.append(propositionId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPropositionFeedbackException(msg.toString());
	}

	/**
	 * Returns the last proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback fetchByPropositionAndStatusAndGroup_Last(
		long groupId, long propositionId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPropositionAndStatusAndGroup(groupId, propositionId,
				status);

		List<PropositionFeedback> list = findByPropositionAndStatusAndGroup(groupId,
				propositionId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param feedbackId the primary key of the current proposition feedback
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback[] findByPropositionAndStatusAndGroup_PrevAndNext(
		long feedbackId, long groupId, long propositionId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		PropositionFeedback propositionFeedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			PropositionFeedback[] array = new PropositionFeedbackImpl[3];

			array[0] = getByPropositionAndStatusAndGroup_PrevAndNext(session,
					propositionFeedback, groupId, propositionId, status,
					orderByComparator, true);

			array[1] = propositionFeedback;

			array[2] = getByPropositionAndStatusAndGroup_PrevAndNext(session,
					propositionFeedback, groupId, propositionId, status,
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

	protected PropositionFeedback getByPropositionAndStatusAndGroup_PrevAndNext(
		Session session, PropositionFeedback propositionFeedback, long groupId,
		long propositionId, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_PROPOSITIONID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_STATUS_2);

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
			query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(propositionId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @return the matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> filterFindByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status) throws SystemException {
		return filterFindByPropositionAndStatusAndGroup(groupId, propositionId,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @return the range of matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> filterFindByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status, int start, int end)
		throws SystemException {
		return filterFindByPropositionAndStatusAndGroup(groupId, propositionId,
			status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition feedbacks that the user has permissions to view where groupId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> filterFindByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByPropositionAndStatusAndGroup(groupId, propositionId,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_PROPOSITIONID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionFeedback.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PropositionFeedbackImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PropositionFeedbackImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(propositionId);

			qPos.add(status);

			return (List<PropositionFeedback>)QueryUtil.list(q, getDialect(),
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
	 * Returns the proposition feedbacks before and after the current proposition feedback in the ordered set of proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param feedbackId the primary key of the current proposition feedback
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposition feedback
	 * @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PropositionFeedback[] filterFindByPropositionAndStatusAndGroup_PrevAndNext(
		long feedbackId, long groupId, long propositionId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPropositionFeedbackException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByPropositionAndStatusAndGroup_PrevAndNext(feedbackId,
				groupId, propositionId, status, orderByComparator);
		}

		PropositionFeedback propositionFeedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			PropositionFeedback[] array = new PropositionFeedbackImpl[3];

			array[0] = filterGetByPropositionAndStatusAndGroup_PrevAndNext(session,
					propositionFeedback, groupId, propositionId, status,
					orderByComparator, true);

			array[1] = propositionFeedback;

			array[2] = filterGetByPropositionAndStatusAndGroup_PrevAndNext(session,
					propositionFeedback, groupId, propositionId, status,
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

	protected PropositionFeedback filterGetByPropositionAndStatusAndGroup_PrevAndNext(
		Session session, PropositionFeedback propositionFeedback, long groupId,
		long propositionId, int status, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_PROPOSITIONID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PropositionFeedbackModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionFeedback.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PropositionFeedbackImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PropositionFeedbackImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(propositionId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(propositionFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PropositionFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the proposition feedbacks.
	 *
	 * @return the proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposition feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @return the range of proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposition feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposition feedbacks
	 * @param end the upper bound of the range of proposition feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public List<PropositionFeedback> findAll(int start, int end,
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

		List<PropositionFeedback> list = (List<PropositionFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROPOSITIONFEEDBACK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROPOSITIONFEEDBACK.concat(PropositionFeedbackModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PropositionFeedback>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PropositionFeedback>)QueryUtil.list(q,
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
	 * Removes all the proposition feedbacks where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (PropositionFeedback propositionFeedback : findByCompany(companyId)) {
			remove(propositionFeedback);
		}
	}

	/**
	 * Removes all the proposition feedbacks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (PropositionFeedback propositionFeedback : findByGroup(groupId)) {
			remove(propositionFeedback);
		}
	}

	/**
	 * Removes all the proposition feedbacks where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusAndCompany(long companyId, int status)
		throws SystemException {
		for (PropositionFeedback propositionFeedback : findByStatusAndCompany(
				companyId, status)) {
			remove(propositionFeedback);
		}
	}

	/**
	 * Removes all the proposition feedbacks where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusAndGroup(long groupId, int status)
		throws SystemException {
		for (PropositionFeedback propositionFeedback : findByStatusAndGroup(
				groupId, status)) {
			remove(propositionFeedback);
		}
	}

	/**
	 * Removes all the proposition feedbacks where companyId = &#63; and propositionId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPropositionAndCompany(long companyId, long propositionId)
		throws SystemException {
		for (PropositionFeedback propositionFeedback : findByPropositionAndCompany(
				companyId, propositionId)) {
			remove(propositionFeedback);
		}
	}

	/**
	 * Removes all the proposition feedbacks where groupId = &#63; and propositionId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPropositionAndGroup(long groupId, long propositionId)
		throws SystemException {
		for (PropositionFeedback propositionFeedback : findByPropositionAndGroup(
				groupId, propositionId)) {
			remove(propositionFeedback);
		}
	}

	/**
	 * Removes all the proposition feedbacks where companyId = &#63; and propositionId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPropositionAndStatusAndCompany(long companyId,
		long propositionId, int status) throws SystemException {
		for (PropositionFeedback propositionFeedback : findByPropositionAndStatusAndCompany(
				companyId, propositionId, status)) {
			remove(propositionFeedback);
		}
	}

	/**
	 * Removes all the proposition feedbacks where groupId = &#63; and propositionId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPropositionAndStatusAndGroup(long groupId,
		long propositionId, int status) throws SystemException {
		for (PropositionFeedback propositionFeedback : findByPropositionAndStatusAndGroup(
				groupId, propositionId, status)) {
			remove(propositionFeedback);
		}
	}

	/**
	 * Removes all the proposition feedbacks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PropositionFeedback propositionFeedback : findAll()) {
			remove(propositionFeedback);
		}
	}

	/**
	 * Returns the number of proposition feedbacks where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROPOSITIONFEEDBACK_WHERE);

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
	 * Returns the number of proposition feedbacks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROPOSITIONFEEDBACK_WHERE);

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
	 * Returns the number of proposition feedbacks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_PROPOSITIONFEEDBACK_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionFeedback.class.getName(),
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
	 * Returns the number of proposition feedbacks where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusAndCompany(long companyId, int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROPOSITIONFEEDBACK_WHERE);

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
	 * Returns the number of proposition feedbacks where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusAndGroup(long groupId, int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROPOSITIONFEEDBACK_WHERE);

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
	 * Returns the number of proposition feedbacks that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByStatusAndGroup(long groupId, int status)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByStatusAndGroup(groupId, status);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PROPOSITIONFEEDBACK_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionFeedback.class.getName(),
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
	 * Returns the number of proposition feedbacks where companyId = &#63; and propositionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @return the number of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPropositionAndCompany(long companyId, long propositionId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, propositionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROPOSITIONFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_PROPOSITIONANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_PROPOSITIONANDCOMPANY_PROPOSITIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(propositionId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of proposition feedbacks where groupId = &#63; and propositionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @return the number of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPropositionAndGroup(long groupId, long propositionId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, propositionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROPOSITIONFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_PROPOSITIONANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_PROPOSITIONANDGROUP_PROPOSITIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(propositionId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @return the number of matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByPropositionAndGroup(long groupId, long propositionId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByPropositionAndGroup(groupId, propositionId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PROPOSITIONFEEDBACK_WHERE);

		query.append(_FINDER_COLUMN_PROPOSITIONANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDGROUP_PROPOSITIONID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionFeedback.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(propositionId);

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
	 * Returns the number of proposition feedbacks where companyId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @return the number of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPropositionAndStatusAndCompany(long companyId,
		long propositionId, int status) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, propositionId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDSTATUSANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PROPOSITIONFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDCOMPANY_PROPOSITIONID_2);

			query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDCOMPANY_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(propositionId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDSTATUSANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of proposition feedbacks where groupId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @return the number of matching proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPropositionAndStatusAndGroup(long groupId,
		long propositionId, int status) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, propositionId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDSTATUSANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PROPOSITIONFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_PROPOSITIONID_2);

			query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(propositionId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROPOSITIONANDSTATUSANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param propositionId the proposition ID
	 * @param status the status
	 * @return the number of matching proposition feedbacks that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByPropositionAndStatusAndGroup(long groupId,
		long propositionId, int status) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByPropositionAndStatusAndGroup(groupId, propositionId,
				status);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_PROPOSITIONFEEDBACK_WHERE);

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_PROPOSITIONID_2);

		query.append(_FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PropositionFeedback.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(propositionId);

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
	 * Returns the number of proposition feedbacks.
	 *
	 * @return the number of proposition feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROPOSITIONFEEDBACK);

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
	 * Initializes the proposition feedback persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PropositionFeedback>> listenersList = new ArrayList<ModelListener<PropositionFeedback>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PropositionFeedback>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PropositionFeedbackImpl.class.getName());
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
	private static final String _SQL_SELECT_PROPOSITIONFEEDBACK = "SELECT propositionFeedback FROM PropositionFeedback propositionFeedback";
	private static final String _SQL_SELECT_PROPOSITIONFEEDBACK_WHERE = "SELECT propositionFeedback FROM PropositionFeedback propositionFeedback WHERE ";
	private static final String _SQL_COUNT_PROPOSITIONFEEDBACK = "SELECT COUNT(propositionFeedback) FROM PropositionFeedback propositionFeedback";
	private static final String _SQL_COUNT_PROPOSITIONFEEDBACK_WHERE = "SELECT COUNT(propositionFeedback) FROM PropositionFeedback propositionFeedback WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "propositionFeedback.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "propositionFeedback.groupId = ?";
	private static final String _FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2 = "propositionFeedback.companyId = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDCOMPANY_STATUS_2 = "propositionFeedback.status = ?";
	private static final String _FINDER_COLUMN_STATUSANDGROUP_GROUPID_2 = "propositionFeedback.groupId = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDGROUP_STATUS_2 = "propositionFeedback.status = ?";
	private static final String _FINDER_COLUMN_PROPOSITIONANDCOMPANY_COMPANYID_2 =
		"propositionFeedback.companyId = ? AND ";
	private static final String _FINDER_COLUMN_PROPOSITIONANDCOMPANY_PROPOSITIONID_2 =
		"propositionFeedback.propositionId = ?";
	private static final String _FINDER_COLUMN_PROPOSITIONANDGROUP_GROUPID_2 = "propositionFeedback.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PROPOSITIONANDGROUP_PROPOSITIONID_2 =
		"propositionFeedback.propositionId = ?";
	private static final String _FINDER_COLUMN_PROPOSITIONANDSTATUSANDCOMPANY_COMPANYID_2 =
		"propositionFeedback.companyId = ? AND ";
	private static final String _FINDER_COLUMN_PROPOSITIONANDSTATUSANDCOMPANY_PROPOSITIONID_2 =
		"propositionFeedback.propositionId = ? AND ";
	private static final String _FINDER_COLUMN_PROPOSITIONANDSTATUSANDCOMPANY_STATUS_2 =
		"propositionFeedback.status = ?";
	private static final String _FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_GROUPID_2 =
		"propositionFeedback.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_PROPOSITIONID_2 =
		"propositionFeedback.propositionId = ? AND ";
	private static final String _FINDER_COLUMN_PROPOSITIONANDSTATUSANDGROUP_STATUS_2 =
		"propositionFeedback.status = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "propositionFeedback.feedbackId";
	private static final String _FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_WHERE = "SELECT DISTINCT {propositionFeedback.*} FROM PropositionFeedback propositionFeedback WHERE ";
	private static final String _FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {PropositionFeedback.*} FROM (SELECT DISTINCT propositionFeedback.feedbackId FROM PropositionFeedback propositionFeedback WHERE ";
	private static final String _FILTER_SQL_SELECT_PROPOSITIONFEEDBACK_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN PropositionFeedback ON TEMP_TABLE.feedbackId = PropositionFeedback.feedbackId";
	private static final String _FILTER_SQL_COUNT_PROPOSITIONFEEDBACK_WHERE = "SELECT COUNT(DISTINCT propositionFeedback.feedbackId) AS COUNT_VALUE FROM PropositionFeedback propositionFeedback WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "propositionFeedback";
	private static final String _FILTER_ENTITY_TABLE = "PropositionFeedback";
	private static final String _ORDER_BY_ENTITY_ALIAS = "propositionFeedback.";
	private static final String _ORDER_BY_ENTITY_TABLE = "PropositionFeedback.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PropositionFeedback exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PropositionFeedback exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PropositionFeedbackPersistenceImpl.class);
	private static PropositionFeedback _nullPropositionFeedback = new PropositionFeedbackImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PropositionFeedback> toCacheModel() {
				return _nullPropositionFeedbackCacheModel;
			}
		};

	private static CacheModel<PropositionFeedback> _nullPropositionFeedbackCacheModel =
		new CacheModel<PropositionFeedback>() {
			public PropositionFeedback toEntityModel() {
				return _nullPropositionFeedback;
			}
		};
}