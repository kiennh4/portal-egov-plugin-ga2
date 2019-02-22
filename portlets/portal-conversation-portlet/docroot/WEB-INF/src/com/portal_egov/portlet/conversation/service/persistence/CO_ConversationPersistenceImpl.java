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

import com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;
import com.portal_egov.portlet.conversation.model.CO_Conversation;
import com.portal_egov.portlet.conversation.model.impl.CO_ConversationImpl;
import com.portal_egov.portlet.conversation.model.impl.CO_ConversationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the c o_ conversation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see CO_ConversationPersistence
 * @see CO_ConversationUtil
 * @generated
 */
public class CO_ConversationPersistenceImpl extends BasePersistenceImpl<CO_Conversation>
	implements CO_ConversationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CO_ConversationUtil} to access the c o_ conversation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CO_ConversationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			CO_ConversationModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			CO_ConversationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDCOMPANY =
		new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatusAndCompany",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY =
		new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatusAndCompany",
			new String[] { Integer.class.getName(), Long.class.getName() },
			CO_ConversationModelImpl.STATUS_COLUMN_BITMASK |
			CO_ConversationModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDCOMPANY = new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusAndCompany",
			new String[] { Integer.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDGROUP =
		new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatusAndGroup",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP =
		new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusAndGroup",
			new String[] { Integer.class.getName(), Long.class.getName() },
			CO_ConversationModelImpl.STATUS_COLUMN_BITMASK |
			CO_ConversationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSANDGROUP = new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusAndGroup",
			new String[] { Integer.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THREADANDCOMPANY =
		new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByThreadAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDCOMPANY =
		new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByThreadAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			CO_ConversationModelImpl.THREADID_COLUMN_BITMASK |
			CO_ConversationModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THREADANDCOMPANY = new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByThreadAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THREADANDGROUP =
		new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByThreadAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDGROUP =
		new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByThreadAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			CO_ConversationModelImpl.THREADID_COLUMN_BITMASK |
			CO_ConversationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THREADANDGROUP = new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByThreadAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THREADANDCOMPANYANDSTATUS =
		new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByThreadAndCompanyAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDCOMPANYANDSTATUS =
		new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByThreadAndCompanyAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			CO_ConversationModelImpl.THREADID_COLUMN_BITMASK |
			CO_ConversationModelImpl.COMPANYID_COLUMN_BITMASK |
			CO_ConversationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THREADANDCOMPANYANDSTATUS =
		new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByThreadAndCompanyAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THREADANDGROUPANDSTATUS =
		new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByThreadAndGroupAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDGROUPANDSTATUS =
		new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByThreadAndGroupAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			CO_ConversationModelImpl.THREADID_COLUMN_BITMASK |
			CO_ConversationModelImpl.GROUPID_COLUMN_BITMASK |
			CO_ConversationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THREADANDGROUPANDSTATUS = new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByThreadAndGroupAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED,
			CO_ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the c o_ conversation in the entity cache if it is enabled.
	 *
	 * @param co_Conversation the c o_ conversation
	 */
	public void cacheResult(CO_Conversation co_Conversation) {
		EntityCacheUtil.putResult(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationImpl.class, co_Conversation.getPrimaryKey(),
			co_Conversation);

		co_Conversation.resetOriginalValues();
	}

	/**
	 * Caches the c o_ conversations in the entity cache if it is enabled.
	 *
	 * @param co_Conversations the c o_ conversations
	 */
	public void cacheResult(List<CO_Conversation> co_Conversations) {
		for (CO_Conversation co_Conversation : co_Conversations) {
			if (EntityCacheUtil.getResult(
						CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
						CO_ConversationImpl.class,
						co_Conversation.getPrimaryKey()) == null) {
				cacheResult(co_Conversation);
			}
			else {
				co_Conversation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all c o_ conversations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CO_ConversationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CO_ConversationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the c o_ conversation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CO_Conversation co_Conversation) {
		EntityCacheUtil.removeResult(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationImpl.class, co_Conversation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CO_Conversation> co_Conversations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CO_Conversation co_Conversation : co_Conversations) {
			EntityCacheUtil.removeResult(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
				CO_ConversationImpl.class, co_Conversation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new c o_ conversation with the primary key. Does not add the c o_ conversation to the database.
	 *
	 * @param conversationId the primary key for the new c o_ conversation
	 * @return the new c o_ conversation
	 */
	public CO_Conversation create(long conversationId) {
		CO_Conversation co_Conversation = new CO_ConversationImpl();

		co_Conversation.setNew(true);
		co_Conversation.setPrimaryKey(conversationId);

		return co_Conversation;
	}

	/**
	 * Removes the c o_ conversation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param conversationId the primary key of the c o_ conversation
	 * @return the c o_ conversation that was removed
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation remove(long conversationId)
		throws NoSuchCO_ConversationException, SystemException {
		return remove(Long.valueOf(conversationId));
	}

	/**
	 * Removes the c o_ conversation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the c o_ conversation
	 * @return the c o_ conversation that was removed
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CO_Conversation remove(Serializable primaryKey)
		throws NoSuchCO_ConversationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CO_Conversation co_Conversation = (CO_Conversation)session.get(CO_ConversationImpl.class,
					primaryKey);

			if (co_Conversation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCO_ConversationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(co_Conversation);
		}
		catch (NoSuchCO_ConversationException nsee) {
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
	protected CO_Conversation removeImpl(CO_Conversation co_Conversation)
		throws SystemException {
		co_Conversation = toUnwrappedModel(co_Conversation);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, co_Conversation);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(co_Conversation);

		return co_Conversation;
	}

	@Override
	public CO_Conversation updateImpl(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation,
		boolean merge) throws SystemException {
		co_Conversation = toUnwrappedModel(co_Conversation);

		boolean isNew = co_Conversation.isNew();

		CO_ConversationModelImpl co_ConversationModelImpl = (CO_ConversationModelImpl)co_Conversation;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, co_Conversation, merge);

			co_Conversation.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CO_ConversationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((co_ConversationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ConversationModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(co_ConversationModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((co_ConversationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ConversationModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(co_ConversationModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((co_ConversationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(co_ConversationModelImpl.getOriginalStatus()),
						Long.valueOf(co_ConversationModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY,
					args);

				args = new Object[] {
						Integer.valueOf(co_ConversationModelImpl.getStatus()),
						Long.valueOf(co_ConversationModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY,
					args);
			}

			if ((co_ConversationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(co_ConversationModelImpl.getOriginalStatus()),
						Long.valueOf(co_ConversationModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP,
					args);

				args = new Object[] {
						Integer.valueOf(co_ConversationModelImpl.getStatus()),
						Long.valueOf(co_ConversationModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP,
					args);
			}

			if ((co_ConversationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ConversationModelImpl.getOriginalThreadId()),
						Long.valueOf(co_ConversationModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THREADANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(co_ConversationModelImpl.getThreadId()),
						Long.valueOf(co_ConversationModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THREADANDCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDCOMPANY,
					args);
			}

			if ((co_ConversationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ConversationModelImpl.getOriginalThreadId()),
						Long.valueOf(co_ConversationModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THREADANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDGROUP,
					args);

				args = new Object[] {
						Long.valueOf(co_ConversationModelImpl.getThreadId()),
						Long.valueOf(co_ConversationModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THREADANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDGROUP,
					args);
			}

			if ((co_ConversationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDCOMPANYANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ConversationModelImpl.getOriginalThreadId()),
						Long.valueOf(co_ConversationModelImpl.getOriginalCompanyId()),
						Integer.valueOf(co_ConversationModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THREADANDCOMPANYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDCOMPANYANDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(co_ConversationModelImpl.getThreadId()),
						Long.valueOf(co_ConversationModelImpl.getCompanyId()),
						Integer.valueOf(co_ConversationModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THREADANDCOMPANYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDCOMPANYANDSTATUS,
					args);
			}

			if ((co_ConversationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDGROUPANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(co_ConversationModelImpl.getOriginalThreadId()),
						Long.valueOf(co_ConversationModelImpl.getOriginalGroupId()),
						Integer.valueOf(co_ConversationModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THREADANDGROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDGROUPANDSTATUS,
					args);

				args = new Object[] {
						Long.valueOf(co_ConversationModelImpl.getThreadId()),
						Long.valueOf(co_ConversationModelImpl.getGroupId()),
						Integer.valueOf(co_ConversationModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THREADANDGROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDGROUPANDSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
			CO_ConversationImpl.class, co_Conversation.getPrimaryKey(),
			co_Conversation);

		return co_Conversation;
	}

	protected CO_Conversation toUnwrappedModel(CO_Conversation co_Conversation) {
		if (co_Conversation instanceof CO_ConversationImpl) {
			return co_Conversation;
		}

		CO_ConversationImpl co_ConversationImpl = new CO_ConversationImpl();

		co_ConversationImpl.setNew(co_Conversation.isNew());
		co_ConversationImpl.setPrimaryKey(co_Conversation.getPrimaryKey());

		co_ConversationImpl.setConversationId(co_Conversation.getConversationId());
		co_ConversationImpl.setCompanyId(co_Conversation.getCompanyId());
		co_ConversationImpl.setGroupId(co_Conversation.getGroupId());
		co_ConversationImpl.setUserId(co_Conversation.getUserId());
		co_ConversationImpl.setThreadId(co_Conversation.getThreadId());
		co_ConversationImpl.setTitle(co_Conversation.getTitle());
		co_ConversationImpl.setAskUserName(co_Conversation.getAskUserName());
		co_ConversationImpl.setAskUserInfo(co_Conversation.getAskUserInfo());
		co_ConversationImpl.setAskContent(co_Conversation.getAskContent());
		co_ConversationImpl.setAnswerUserName(co_Conversation.getAnswerUserName());
		co_ConversationImpl.setAnswerUserInfo(co_Conversation.getAnswerUserInfo());
		co_ConversationImpl.setAnswerContent(co_Conversation.getAnswerContent());
		co_ConversationImpl.setAskDate(co_Conversation.getAskDate());
		co_ConversationImpl.setAnswerDate(co_Conversation.getAnswerDate());
		co_ConversationImpl.setCreateDate(co_Conversation.getCreateDate());
		co_ConversationImpl.setModifiedDate(co_Conversation.getModifiedDate());
		co_ConversationImpl.setStatus(co_Conversation.getStatus());
		co_ConversationImpl.setStatusByUserId(co_Conversation.getStatusByUserId());
		co_ConversationImpl.setStatusDate(co_Conversation.getStatusDate());

		return co_ConversationImpl;
	}

	/**
	 * Returns the c o_ conversation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the c o_ conversation
	 * @return the c o_ conversation
	 * @throws com.liferay.portal.NoSuchModelException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CO_Conversation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the c o_ conversation with the primary key or throws a {@link com.portal_egov.portlet.conversation.NoSuchCO_ConversationException} if it could not be found.
	 *
	 * @param conversationId the primary key of the c o_ conversation
	 * @return the c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByPrimaryKey(long conversationId)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByPrimaryKey(conversationId);

		if (co_Conversation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + conversationId);
			}

			throw new NoSuchCO_ConversationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				conversationId);
		}

		return co_Conversation;
	}

	/**
	 * Returns the c o_ conversation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the c o_ conversation
	 * @return the c o_ conversation, or <code>null</code> if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CO_Conversation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the c o_ conversation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param conversationId the primary key of the c o_ conversation
	 * @return the c o_ conversation, or <code>null</code> if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByPrimaryKey(long conversationId)
		throws SystemException {
		CO_Conversation co_Conversation = (CO_Conversation)EntityCacheUtil.getResult(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
				CO_ConversationImpl.class, conversationId);

		if (co_Conversation == _nullCO_Conversation) {
			return null;
		}

		if (co_Conversation == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				co_Conversation = (CO_Conversation)session.get(CO_ConversationImpl.class,
						Long.valueOf(conversationId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (co_Conversation != null) {
					cacheResult(co_Conversation);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CO_ConversationModelImpl.ENTITY_CACHE_ENABLED,
						CO_ConversationImpl.class, conversationId,
						_nullCO_Conversation);
				}

				closeSession(session);
			}
		}

		return co_Conversation;
	}

	/**
	 * Returns all the c o_ conversations where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the c o_ conversations where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @return the range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ conversations where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByCompany(long companyId, int start,
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

		List<CO_Conversation> list = (List<CO_Conversation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Conversation co_Conversation : list) {
				if ((companyId != co_Conversation.getCompanyId())) {
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

			query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<CO_Conversation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c o_ conversation in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByCompany_First(companyId,
				orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the first c o_ conversation in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CO_Conversation> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByCompany_Last(companyId,
				orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		List<CO_Conversation> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where companyId = &#63;.
	 *
	 * @param conversationId the primary key of the current c o_ conversation
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation[] findByCompany_PrevAndNext(long conversationId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = findByPrimaryKey(conversationId);

		Session session = null;

		try {
			session = openSession();

			CO_Conversation[] array = new CO_ConversationImpl[3];

			array[0] = getByCompany_PrevAndNext(session, co_Conversation,
					companyId, orderByComparator, true);

			array[1] = co_Conversation;

			array[2] = getByCompany_PrevAndNext(session, co_Conversation,
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

	protected CO_Conversation getByCompany_PrevAndNext(Session session,
		CO_Conversation co_Conversation, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

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
			query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ conversations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ conversations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @return the range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ conversations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByGroup(long groupId, int start, int end,
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

		List<CO_Conversation> list = (List<CO_Conversation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Conversation co_Conversation : list) {
				if ((groupId != co_Conversation.getGroupId())) {
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

			query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<CO_Conversation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c o_ conversation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByGroup_First(groupId,
				orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the first c o_ conversation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CO_Conversation> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByGroup_Last(groupId,
				orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<CO_Conversation> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where groupId = &#63;.
	 *
	 * @param conversationId the primary key of the current c o_ conversation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation[] findByGroup_PrevAndNext(long conversationId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = findByPrimaryKey(conversationId);

		Session session = null;

		try {
			session = openSession();

			CO_Conversation[] array = new CO_ConversationImpl[3];

			array[0] = getByGroup_PrevAndNext(session, co_Conversation,
					groupId, orderByComparator, true);

			array[1] = co_Conversation;

			array[2] = getByGroup_PrevAndNext(session, co_Conversation,
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

	protected CO_Conversation getByGroup_PrevAndNext(Session session,
		CO_Conversation co_Conversation, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

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
			query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ conversations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the c o_ conversations that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @return the range of matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ conversations that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Conversation.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CO_ConversationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CO_ConversationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<CO_Conversation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the c o_ conversations before and after the current c o_ conversation in the ordered set of c o_ conversations that the user has permission to view where groupId = &#63;.
	 *
	 * @param conversationId the primary key of the current c o_ conversation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation[] filterFindByGroup_PrevAndNext(
		long conversationId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(conversationId, groupId,
				orderByComparator);
		}

		CO_Conversation co_Conversation = findByPrimaryKey(conversationId);

		Session session = null;

		try {
			session = openSession();

			CO_Conversation[] array = new CO_ConversationImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, co_Conversation,
					groupId, orderByComparator, true);

			array[1] = co_Conversation;

			array[2] = filterGetByGroup_PrevAndNext(session, co_Conversation,
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

	protected CO_Conversation filterGetByGroup_PrevAndNext(Session session,
		CO_Conversation co_Conversation, long groupId,
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
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Conversation.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CO_ConversationImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CO_ConversationImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ conversations where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @return the matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByStatusAndCompany(int status,
		long companyId) throws SystemException {
		return findByStatusAndCompany(status, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ conversations where status = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @return the range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByStatusAndCompany(int status,
		long companyId, int start, int end) throws SystemException {
		return findByStatusAndCompany(status, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ conversations where status = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByStatusAndCompany(int status,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDCOMPANY;
			finderArgs = new Object[] { status, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDCOMPANY;
			finderArgs = new Object[] {
					status, companyId,
					
					start, end, orderByComparator
				};
		}

		List<CO_Conversation> list = (List<CO_Conversation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Conversation co_Conversation : list) {
				if ((status != co_Conversation.getStatus()) ||
						(companyId != co_Conversation.getCompanyId())) {
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

			query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_STATUS_2);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(companyId);

				list = (List<CO_Conversation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c o_ conversation in the ordered set where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByStatusAndCompany_First(int status,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByStatusAndCompany_First(status,
				companyId, orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the first c o_ conversation in the ordered set where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByStatusAndCompany_First(int status,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CO_Conversation> list = findByStatusAndCompany(status, companyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByStatusAndCompany_Last(int status,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByStatusAndCompany_Last(status,
				companyId, orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByStatusAndCompany_Last(int status,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStatusAndCompany(status, companyId);

		List<CO_Conversation> list = findByStatusAndCompany(status, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where status = &#63; and companyId = &#63;.
	 *
	 * @param conversationId the primary key of the current c o_ conversation
	 * @param status the status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation[] findByStatusAndCompany_PrevAndNext(
		long conversationId, int status, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = findByPrimaryKey(conversationId);

		Session session = null;

		try {
			session = openSession();

			CO_Conversation[] array = new CO_ConversationImpl[3];

			array[0] = getByStatusAndCompany_PrevAndNext(session,
					co_Conversation, status, companyId, orderByComparator, true);

			array[1] = co_Conversation;

			array[2] = getByStatusAndCompany_PrevAndNext(session,
					co_Conversation, status, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CO_Conversation getByStatusAndCompany_PrevAndNext(
		Session session, CO_Conversation co_Conversation, int status,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDCOMPANY_STATUS_2);

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
			query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ conversations where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByStatusAndGroup(int status, long groupId)
		throws SystemException {
		return findByStatusAndGroup(status, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ conversations where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @return the range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByStatusAndGroup(int status, long groupId,
		int start, int end) throws SystemException {
		return findByStatusAndGroup(status, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ conversations where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByStatusAndGroup(int status, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSANDGROUP;
			finderArgs = new Object[] { status, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDGROUP;
			finderArgs = new Object[] {
					status, groupId,
					
					start, end, orderByComparator
				};
		}

		List<CO_Conversation> list = (List<CO_Conversation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Conversation co_Conversation : list) {
				if ((status != co_Conversation.getStatus()) ||
						(groupId != co_Conversation.getGroupId())) {
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

			query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(groupId);

				list = (List<CO_Conversation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c o_ conversation in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByStatusAndGroup_First(int status, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByStatusAndGroup_First(status,
				groupId, orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the first c o_ conversation in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByStatusAndGroup_First(int status,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CO_Conversation> list = findByStatusAndGroup(status, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByStatusAndGroup_Last(int status, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByStatusAndGroup_Last(status,
				groupId, orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByStatusAndGroup_Last(int status, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatusAndGroup(status, groupId);

		List<CO_Conversation> list = findByStatusAndGroup(status, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param conversationId the primary key of the current c o_ conversation
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation[] findByStatusAndGroup_PrevAndNext(
		long conversationId, int status, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = findByPrimaryKey(conversationId);

		Session session = null;

		try {
			session = openSession();

			CO_Conversation[] array = new CO_ConversationImpl[3];

			array[0] = getByStatusAndGroup_PrevAndNext(session,
					co_Conversation, status, groupId, orderByComparator, true);

			array[1] = co_Conversation;

			array[2] = getByStatusAndGroup_PrevAndNext(session,
					co_Conversation, status, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CO_Conversation getByStatusAndGroup_PrevAndNext(Session session,
		CO_Conversation co_Conversation, int status, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

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
			query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ conversations that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> filterFindByStatusAndGroup(int status,
		long groupId) throws SystemException {
		return filterFindByStatusAndGroup(status, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ conversations that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @return the range of matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> filterFindByStatusAndGroup(int status,
		long groupId, int start, int end) throws SystemException {
		return filterFindByStatusAndGroup(status, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ conversations that the user has permissions to view where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> filterFindByStatusAndGroup(int status,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByStatusAndGroup(status, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Conversation.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CO_ConversationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CO_ConversationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(status);

			qPos.add(groupId);

			return (List<CO_Conversation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the c o_ conversations before and after the current c o_ conversation in the ordered set of c o_ conversations that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param conversationId the primary key of the current c o_ conversation
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation[] filterFindByStatusAndGroup_PrevAndNext(
		long conversationId, int status, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByStatusAndGroup_PrevAndNext(conversationId, status,
				groupId, orderByComparator);
		}

		CO_Conversation co_Conversation = findByPrimaryKey(conversationId);

		Session session = null;

		try {
			session = openSession();

			CO_Conversation[] array = new CO_ConversationImpl[3];

			array[0] = filterGetByStatusAndGroup_PrevAndNext(session,
					co_Conversation, status, groupId, orderByComparator, true);

			array[1] = co_Conversation;

			array[2] = filterGetByStatusAndGroup_PrevAndNext(session,
					co_Conversation, status, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CO_Conversation filterGetByStatusAndGroup_PrevAndNext(
		Session session, CO_Conversation co_Conversation, int status,
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
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Conversation.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CO_ConversationImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CO_ConversationImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ conversations where threadId = &#63; and companyId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @return the matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByThreadAndCompany(long threadId,
		long companyId) throws SystemException {
		return findByThreadAndCompany(threadId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ conversations where threadId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @return the range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByThreadAndCompany(long threadId,
		long companyId, int start, int end) throws SystemException {
		return findByThreadAndCompany(threadId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ conversations where threadId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByThreadAndCompany(long threadId,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDCOMPANY;
			finderArgs = new Object[] { threadId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THREADANDCOMPANY;
			finderArgs = new Object[] {
					threadId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<CO_Conversation> list = (List<CO_Conversation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Conversation co_Conversation : list) {
				if ((threadId != co_Conversation.getThreadId()) ||
						(companyId != co_Conversation.getCompanyId())) {
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

			query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_THREADANDCOMPANY_THREADID_2);

			query.append(_FINDER_COLUMN_THREADANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(threadId);

				qPos.add(companyId);

				list = (List<CO_Conversation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByThreadAndCompany_First(long threadId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByThreadAndCompany_First(threadId,
				companyId, orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("threadId=");
		msg.append(threadId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the first c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByThreadAndCompany_First(long threadId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CO_Conversation> list = findByThreadAndCompany(threadId,
				companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByThreadAndCompany_Last(long threadId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByThreadAndCompany_Last(threadId,
				companyId, orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("threadId=");
		msg.append(threadId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByThreadAndCompany_Last(long threadId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByThreadAndCompany(threadId, companyId);

		List<CO_Conversation> list = findByThreadAndCompany(threadId,
				companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63;.
	 *
	 * @param conversationId the primary key of the current c o_ conversation
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation[] findByThreadAndCompany_PrevAndNext(
		long conversationId, long threadId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = findByPrimaryKey(conversationId);

		Session session = null;

		try {
			session = openSession();

			CO_Conversation[] array = new CO_ConversationImpl[3];

			array[0] = getByThreadAndCompany_PrevAndNext(session,
					co_Conversation, threadId, companyId, orderByComparator,
					true);

			array[1] = co_Conversation;

			array[2] = getByThreadAndCompany_PrevAndNext(session,
					co_Conversation, threadId, companyId, orderByComparator,
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

	protected CO_Conversation getByThreadAndCompany_PrevAndNext(
		Session session, CO_Conversation co_Conversation, long threadId,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

		query.append(_FINDER_COLUMN_THREADANDCOMPANY_THREADID_2);

		query.append(_FINDER_COLUMN_THREADANDCOMPANY_COMPANYID_2);

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
			query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(threadId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ conversations where threadId = &#63; and groupId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @return the matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByThreadAndGroup(long threadId,
		long groupId) throws SystemException {
		return findByThreadAndGroup(threadId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ conversations where threadId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @return the range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByThreadAndGroup(long threadId,
		long groupId, int start, int end) throws SystemException {
		return findByThreadAndGroup(threadId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ conversations where threadId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByThreadAndGroup(long threadId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDGROUP;
			finderArgs = new Object[] { threadId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THREADANDGROUP;
			finderArgs = new Object[] {
					threadId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<CO_Conversation> list = (List<CO_Conversation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Conversation co_Conversation : list) {
				if ((threadId != co_Conversation.getThreadId()) ||
						(groupId != co_Conversation.getGroupId())) {
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

			query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_THREADANDGROUP_THREADID_2);

			query.append(_FINDER_COLUMN_THREADANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(threadId);

				qPos.add(groupId);

				list = (List<CO_Conversation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByThreadAndGroup_First(long threadId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByThreadAndGroup_First(threadId,
				groupId, orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("threadId=");
		msg.append(threadId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the first c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByThreadAndGroup_First(long threadId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CO_Conversation> list = findByThreadAndGroup(threadId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByThreadAndGroup_Last(long threadId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByThreadAndGroup_Last(threadId,
				groupId, orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("threadId=");
		msg.append(threadId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByThreadAndGroup_Last(long threadId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByThreadAndGroup(threadId, groupId);

		List<CO_Conversation> list = findByThreadAndGroup(threadId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63;.
	 *
	 * @param conversationId the primary key of the current c o_ conversation
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation[] findByThreadAndGroup_PrevAndNext(
		long conversationId, long threadId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = findByPrimaryKey(conversationId);

		Session session = null;

		try {
			session = openSession();

			CO_Conversation[] array = new CO_ConversationImpl[3];

			array[0] = getByThreadAndGroup_PrevAndNext(session,
					co_Conversation, threadId, groupId, orderByComparator, true);

			array[1] = co_Conversation;

			array[2] = getByThreadAndGroup_PrevAndNext(session,
					co_Conversation, threadId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CO_Conversation getByThreadAndGroup_PrevAndNext(Session session,
		CO_Conversation co_Conversation, long threadId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

		query.append(_FINDER_COLUMN_THREADANDGROUP_THREADID_2);

		query.append(_FINDER_COLUMN_THREADANDGROUP_GROUPID_2);

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
			query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(threadId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @return the matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> filterFindByThreadAndGroup(long threadId,
		long groupId) throws SystemException {
		return filterFindByThreadAndGroup(threadId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @return the range of matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> filterFindByThreadAndGroup(long threadId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByThreadAndGroup(threadId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ conversations that the user has permissions to view where threadId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> filterFindByThreadAndGroup(long threadId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByThreadAndGroup(threadId, groupId, start, end,
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
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_THREADANDGROUP_THREADID_2);

		query.append(_FINDER_COLUMN_THREADANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Conversation.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CO_ConversationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CO_ConversationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(threadId);

			qPos.add(groupId);

			return (List<CO_Conversation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the c o_ conversations before and after the current c o_ conversation in the ordered set of c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63;.
	 *
	 * @param conversationId the primary key of the current c o_ conversation
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation[] filterFindByThreadAndGroup_PrevAndNext(
		long conversationId, long threadId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByThreadAndGroup_PrevAndNext(conversationId, threadId,
				groupId, orderByComparator);
		}

		CO_Conversation co_Conversation = findByPrimaryKey(conversationId);

		Session session = null;

		try {
			session = openSession();

			CO_Conversation[] array = new CO_ConversationImpl[3];

			array[0] = filterGetByThreadAndGroup_PrevAndNext(session,
					co_Conversation, threadId, groupId, orderByComparator, true);

			array[1] = co_Conversation;

			array[2] = filterGetByThreadAndGroup_PrevAndNext(session,
					co_Conversation, threadId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CO_Conversation filterGetByThreadAndGroup_PrevAndNext(
		Session session, CO_Conversation co_Conversation, long threadId,
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
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_THREADANDGROUP_THREADID_2);

		query.append(_FINDER_COLUMN_THREADANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Conversation.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CO_ConversationImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CO_ConversationImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(threadId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ conversations where threadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int status) throws SystemException {
		return findByThreadAndCompanyAndStatus(threadId, companyId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ conversations where threadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @return the range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int status, int start, int end)
		throws SystemException {
		return findByThreadAndCompanyAndStatus(threadId, companyId, status,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ conversations where threadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDCOMPANYANDSTATUS;
			finderArgs = new Object[] { threadId, companyId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THREADANDCOMPANYANDSTATUS;
			finderArgs = new Object[] {
					threadId, companyId, status,
					
					start, end, orderByComparator
				};
		}

		List<CO_Conversation> list = (List<CO_Conversation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Conversation co_Conversation : list) {
				if ((threadId != co_Conversation.getThreadId()) ||
						(companyId != co_Conversation.getCompanyId()) ||
						(status != co_Conversation.getStatus())) {
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

			query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_THREADANDCOMPANYANDSTATUS_THREADID_2);

			query.append(_FINDER_COLUMN_THREADANDCOMPANYANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_THREADANDCOMPANYANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(threadId);

				qPos.add(companyId);

				qPos.add(status);

				list = (List<CO_Conversation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByThreadAndCompanyAndStatus_First(
		long threadId, long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByThreadAndCompanyAndStatus_First(threadId,
				companyId, status, orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("threadId=");
		msg.append(threadId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the first c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByThreadAndCompanyAndStatus_First(
		long threadId, long companyId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<CO_Conversation> list = findByThreadAndCompanyAndStatus(threadId,
				companyId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByThreadAndCompanyAndStatus_Last(long threadId,
		long companyId, int status, OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByThreadAndCompanyAndStatus_Last(threadId,
				companyId, status, orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("threadId=");
		msg.append(threadId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByThreadAndCompanyAndStatus_Last(
		long threadId, long companyId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByThreadAndCompanyAndStatus(threadId, companyId, status);

		List<CO_Conversation> list = findByThreadAndCompanyAndStatus(threadId,
				companyId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param conversationId the primary key of the current c o_ conversation
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation[] findByThreadAndCompanyAndStatus_PrevAndNext(
		long conversationId, long threadId, long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = findByPrimaryKey(conversationId);

		Session session = null;

		try {
			session = openSession();

			CO_Conversation[] array = new CO_ConversationImpl[3];

			array[0] = getByThreadAndCompanyAndStatus_PrevAndNext(session,
					co_Conversation, threadId, companyId, status,
					orderByComparator, true);

			array[1] = co_Conversation;

			array[2] = getByThreadAndCompanyAndStatus_PrevAndNext(session,
					co_Conversation, threadId, companyId, status,
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

	protected CO_Conversation getByThreadAndCompanyAndStatus_PrevAndNext(
		Session session, CO_Conversation co_Conversation, long threadId,
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

		query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

		query.append(_FINDER_COLUMN_THREADANDCOMPANYANDSTATUS_THREADID_2);

		query.append(_FINDER_COLUMN_THREADANDCOMPANYANDSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_THREADANDCOMPANYANDSTATUS_STATUS_2);

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
			query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(threadId);

		qPos.add(companyId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ conversations where threadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByThreadAndGroupAndStatus(long threadId,
		long groupId, int status) throws SystemException {
		return findByThreadAndGroupAndStatus(threadId, groupId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ conversations where threadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @return the range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByThreadAndGroupAndStatus(long threadId,
		long groupId, int status, int start, int end) throws SystemException {
		return findByThreadAndGroupAndStatus(threadId, groupId, status, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ conversations where threadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findByThreadAndGroupAndStatus(long threadId,
		long groupId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREADANDGROUPANDSTATUS;
			finderArgs = new Object[] { threadId, groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THREADANDGROUPANDSTATUS;
			finderArgs = new Object[] {
					threadId, groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<CO_Conversation> list = (List<CO_Conversation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CO_Conversation co_Conversation : list) {
				if ((threadId != co_Conversation.getThreadId()) ||
						(groupId != co_Conversation.getGroupId()) ||
						(status != co_Conversation.getStatus())) {
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

			query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_THREADID_2);

			query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(threadId);

				qPos.add(groupId);

				qPos.add(status);

				list = (List<CO_Conversation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByThreadAndGroupAndStatus_First(long threadId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByThreadAndGroupAndStatus_First(threadId,
				groupId, status, orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("threadId=");
		msg.append(threadId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the first c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByThreadAndGroupAndStatus_First(long threadId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<CO_Conversation> list = findByThreadAndGroupAndStatus(threadId,
				groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation findByThreadAndGroupAndStatus_Last(long threadId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = fetchByThreadAndGroupAndStatus_Last(threadId,
				groupId, status, orderByComparator);

		if (co_Conversation != null) {
			return co_Conversation;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("threadId=");
		msg.append(threadId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCO_ConversationException(msg.toString());
	}

	/**
	 * Returns the last c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation fetchByThreadAndGroupAndStatus_Last(long threadId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByThreadAndGroupAndStatus(threadId, groupId, status);

		List<CO_Conversation> list = findByThreadAndGroupAndStatus(threadId,
				groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param conversationId the primary key of the current c o_ conversation
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation[] findByThreadAndGroupAndStatus_PrevAndNext(
		long conversationId, long threadId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		CO_Conversation co_Conversation = findByPrimaryKey(conversationId);

		Session session = null;

		try {
			session = openSession();

			CO_Conversation[] array = new CO_ConversationImpl[3];

			array[0] = getByThreadAndGroupAndStatus_PrevAndNext(session,
					co_Conversation, threadId, groupId, status,
					orderByComparator, true);

			array[1] = co_Conversation;

			array[2] = getByThreadAndGroupAndStatus_PrevAndNext(session,
					co_Conversation, threadId, groupId, status,
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

	protected CO_Conversation getByThreadAndGroupAndStatus_PrevAndNext(
		Session session, CO_Conversation co_Conversation, long threadId,
		long groupId, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CO_CONVERSATION_WHERE);

		query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_THREADID_2);

		query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_STATUS_2);

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
			query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(threadId);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> filterFindByThreadAndGroupAndStatus(
		long threadId, long groupId, int status) throws SystemException {
		return filterFindByThreadAndGroupAndStatus(threadId, groupId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @return the range of matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> filterFindByThreadAndGroupAndStatus(
		long threadId, long groupId, int status, int start, int end)
		throws SystemException {
		return filterFindByThreadAndGroupAndStatus(threadId, groupId, status,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ conversations that the user has permissions to view where threadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> filterFindByThreadAndGroupAndStatus(
		long threadId, long groupId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByThreadAndGroupAndStatus(threadId, groupId, status,
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
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_THREADID_2);

		query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Conversation.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CO_ConversationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CO_ConversationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(threadId);

			qPos.add(groupId);

			qPos.add(status);

			return (List<CO_Conversation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the c o_ conversations before and after the current c o_ conversation in the ordered set of c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param conversationId the primary key of the current c o_ conversation
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c o_ conversation
	 * @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Conversation[] filterFindByThreadAndGroupAndStatus_PrevAndNext(
		long conversationId, long threadId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCO_ConversationException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByThreadAndGroupAndStatus_PrevAndNext(conversationId,
				threadId, groupId, status, orderByComparator);
		}

		CO_Conversation co_Conversation = findByPrimaryKey(conversationId);

		Session session = null;

		try {
			session = openSession();

			CO_Conversation[] array = new CO_ConversationImpl[3];

			array[0] = filterGetByThreadAndGroupAndStatus_PrevAndNext(session,
					co_Conversation, threadId, groupId, status,
					orderByComparator, true);

			array[1] = co_Conversation;

			array[2] = filterGetByThreadAndGroupAndStatus_PrevAndNext(session,
					co_Conversation, threadId, groupId, status,
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

	protected CO_Conversation filterGetByThreadAndGroupAndStatus_PrevAndNext(
		Session session, CO_Conversation co_Conversation, long threadId,
		long groupId, int status, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_THREADID_2);

		query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CO_ConversationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Conversation.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CO_ConversationImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CO_ConversationImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(threadId);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(co_Conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CO_Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the c o_ conversations.
	 *
	 * @return the c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c o_ conversations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @return the range of c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the c o_ conversations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of c o_ conversations
	 * @param end the upper bound of the range of c o_ conversations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public List<CO_Conversation> findAll(int start, int end,
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

		List<CO_Conversation> list = (List<CO_Conversation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CO_CONVERSATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CO_CONVERSATION.concat(CO_ConversationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CO_Conversation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CO_Conversation>)QueryUtil.list(q,
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
	 * Removes all the c o_ conversations where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (CO_Conversation co_Conversation : findByCompany(companyId)) {
			remove(co_Conversation);
		}
	}

	/**
	 * Removes all the c o_ conversations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (CO_Conversation co_Conversation : findByGroup(groupId)) {
			remove(co_Conversation);
		}
	}

	/**
	 * Removes all the c o_ conversations where status = &#63; and companyId = &#63; from the database.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusAndCompany(int status, long companyId)
		throws SystemException {
		for (CO_Conversation co_Conversation : findByStatusAndCompany(status,
				companyId)) {
			remove(co_Conversation);
		}
	}

	/**
	 * Removes all the c o_ conversations where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusAndGroup(int status, long groupId)
		throws SystemException {
		for (CO_Conversation co_Conversation : findByStatusAndGroup(status,
				groupId)) {
			remove(co_Conversation);
		}
	}

	/**
	 * Removes all the c o_ conversations where threadId = &#63; and companyId = &#63; from the database.
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThreadAndCompany(long threadId, long companyId)
		throws SystemException {
		for (CO_Conversation co_Conversation : findByThreadAndCompany(
				threadId, companyId)) {
			remove(co_Conversation);
		}
	}

	/**
	 * Removes all the c o_ conversations where threadId = &#63; and groupId = &#63; from the database.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThreadAndGroup(long threadId, long groupId)
		throws SystemException {
		for (CO_Conversation co_Conversation : findByThreadAndGroup(threadId,
				groupId)) {
			remove(co_Conversation);
		}
	}

	/**
	 * Removes all the c o_ conversations where threadId = &#63; and companyId = &#63; and status = &#63; from the database.
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThreadAndCompanyAndStatus(long threadId,
		long companyId, int status) throws SystemException {
		for (CO_Conversation co_Conversation : findByThreadAndCompanyAndStatus(
				threadId, companyId, status)) {
			remove(co_Conversation);
		}
	}

	/**
	 * Removes all the c o_ conversations where threadId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThreadAndGroupAndStatus(long threadId, long groupId,
		int status) throws SystemException {
		for (CO_Conversation co_Conversation : findByThreadAndGroupAndStatus(
				threadId, groupId, status)) {
			remove(co_Conversation);
		}
	}

	/**
	 * Removes all the c o_ conversations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CO_Conversation co_Conversation : findAll()) {
			remove(co_Conversation);
		}
	}

	/**
	 * Returns the number of c o_ conversations where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CO_CONVERSATION_WHERE);

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
	 * Returns the number of c o_ conversations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CO_CONVERSATION_WHERE);

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
	 * Returns the number of c o_ conversations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CO_CONVERSATION_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Conversation.class.getName(),
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
	 * Returns the number of c o_ conversations where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @return the number of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusAndCompany(int status, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { status, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CO_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_STATUS_2);

			query.append(_FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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
	 * Returns the number of c o_ conversations where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusAndGroup(int status, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { status, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CO_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

			query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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
	 * Returns the number of c o_ conversations that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByStatusAndGroup(int status, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByStatusAndGroup(status, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CO_CONVERSATION_WHERE);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_STATUS_2);

		query.append(_FINDER_COLUMN_STATUSANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Conversation.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(status);

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
	 * Returns the number of c o_ conversations where threadId = &#63; and companyId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @return the number of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThreadAndCompany(long threadId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { threadId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THREADANDCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CO_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_THREADANDCOMPANY_THREADID_2);

			query.append(_FINDER_COLUMN_THREADANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(threadId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THREADANDCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of c o_ conversations where threadId = &#63; and groupId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @return the number of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThreadAndGroup(long threadId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { threadId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THREADANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CO_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_THREADANDGROUP_THREADID_2);

			query.append(_FINDER_COLUMN_THREADANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(threadId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THREADANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @return the number of matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByThreadAndGroup(long threadId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByThreadAndGroup(threadId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CO_CONVERSATION_WHERE);

		query.append(_FINDER_COLUMN_THREADANDGROUP_THREADID_2);

		query.append(_FINDER_COLUMN_THREADANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Conversation.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(threadId);

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
	 * Returns the number of c o_ conversations where threadId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThreadAndCompanyAndStatus(long threadId, long companyId,
		int status) throws SystemException {
		Object[] finderArgs = new Object[] { threadId, companyId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THREADANDCOMPANYANDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CO_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_THREADANDCOMPANYANDSTATUS_THREADID_2);

			query.append(_FINDER_COLUMN_THREADANDCOMPANYANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_THREADANDCOMPANYANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(threadId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THREADANDCOMPANYANDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of c o_ conversations where threadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThreadAndGroupAndStatus(long threadId, long groupId,
		int status) throws SystemException {
		Object[] finderArgs = new Object[] { threadId, groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THREADANDGROUPANDSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CO_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_THREADID_2);

			query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(threadId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THREADANDGROUPANDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param threadId the thread ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching c o_ conversations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByThreadAndGroupAndStatus(long threadId,
		long groupId, int status) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByThreadAndGroupAndStatus(threadId, groupId, status);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CO_CONVERSATION_WHERE);

		query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_THREADID_2);

		query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_THREADANDGROUPANDSTATUS_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CO_Conversation.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(threadId);

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
	 * Returns the number of c o_ conversations.
	 *
	 * @return the number of c o_ conversations
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CO_CONVERSATION);

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
	 * Initializes the c o_ conversation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.portal_egov.portlet.conversation.model.CO_Conversation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CO_Conversation>> listenersList = new ArrayList<ModelListener<CO_Conversation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CO_Conversation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CO_ConversationImpl.class.getName());
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
	private static final String _SQL_SELECT_CO_CONVERSATION = "SELECT co_Conversation FROM CO_Conversation co_Conversation";
	private static final String _SQL_SELECT_CO_CONVERSATION_WHERE = "SELECT co_Conversation FROM CO_Conversation co_Conversation WHERE ";
	private static final String _SQL_COUNT_CO_CONVERSATION = "SELECT COUNT(co_Conversation) FROM CO_Conversation co_Conversation";
	private static final String _SQL_COUNT_CO_CONVERSATION_WHERE = "SELECT COUNT(co_Conversation) FROM CO_Conversation co_Conversation WHERE ";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "co_Conversation.companyId = ?";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "co_Conversation.groupId = ?";
	private static final String _FINDER_COLUMN_STATUSANDCOMPANY_STATUS_2 = "co_Conversation.status = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDCOMPANY_COMPANYID_2 = "co_Conversation.companyId = ?";
	private static final String _FINDER_COLUMN_STATUSANDGROUP_STATUS_2 = "co_Conversation.status = ? AND ";
	private static final String _FINDER_COLUMN_STATUSANDGROUP_GROUPID_2 = "co_Conversation.groupId = ?";
	private static final String _FINDER_COLUMN_THREADANDCOMPANY_THREADID_2 = "co_Conversation.threadId = ? AND ";
	private static final String _FINDER_COLUMN_THREADANDCOMPANY_COMPANYID_2 = "co_Conversation.companyId = ?";
	private static final String _FINDER_COLUMN_THREADANDGROUP_THREADID_2 = "co_Conversation.threadId = ? AND ";
	private static final String _FINDER_COLUMN_THREADANDGROUP_GROUPID_2 = "co_Conversation.groupId = ?";
	private static final String _FINDER_COLUMN_THREADANDCOMPANYANDSTATUS_THREADID_2 =
		"co_Conversation.threadId = ? AND ";
	private static final String _FINDER_COLUMN_THREADANDCOMPANYANDSTATUS_COMPANYID_2 =
		"co_Conversation.companyId = ? AND ";
	private static final String _FINDER_COLUMN_THREADANDCOMPANYANDSTATUS_STATUS_2 =
		"co_Conversation.status = ?";
	private static final String _FINDER_COLUMN_THREADANDGROUPANDSTATUS_THREADID_2 =
		"co_Conversation.threadId = ? AND ";
	private static final String _FINDER_COLUMN_THREADANDGROUPANDSTATUS_GROUPID_2 =
		"co_Conversation.groupId = ? AND ";
	private static final String _FINDER_COLUMN_THREADANDGROUPANDSTATUS_STATUS_2 = "co_Conversation.status = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "co_Conversation.conversationId";
	private static final String _FILTER_SQL_SELECT_CO_CONVERSATION_WHERE = "SELECT DISTINCT {co_Conversation.*} FROM CO_Conversation co_Conversation WHERE ";
	private static final String _FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {CO_Conversation.*} FROM (SELECT DISTINCT co_Conversation.conversationId FROM CO_Conversation co_Conversation WHERE ";
	private static final String _FILTER_SQL_SELECT_CO_CONVERSATION_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN CO_Conversation ON TEMP_TABLE.conversationId = CO_Conversation.conversationId";
	private static final String _FILTER_SQL_COUNT_CO_CONVERSATION_WHERE = "SELECT COUNT(DISTINCT co_Conversation.conversationId) AS COUNT_VALUE FROM CO_Conversation co_Conversation WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "co_Conversation";
	private static final String _FILTER_ENTITY_TABLE = "CO_Conversation";
	private static final String _ORDER_BY_ENTITY_ALIAS = "co_Conversation.";
	private static final String _ORDER_BY_ENTITY_TABLE = "CO_Conversation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CO_Conversation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CO_Conversation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CO_ConversationPersistenceImpl.class);
	private static CO_Conversation _nullCO_Conversation = new CO_ConversationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CO_Conversation> toCacheModel() {
				return _nullCO_ConversationCacheModel;
			}
		};

	private static CacheModel<CO_Conversation> _nullCO_ConversationCacheModel = new CacheModel<CO_Conversation>() {
			public CO_Conversation toEntityModel() {
				return _nullCO_Conversation;
			}
		};
}