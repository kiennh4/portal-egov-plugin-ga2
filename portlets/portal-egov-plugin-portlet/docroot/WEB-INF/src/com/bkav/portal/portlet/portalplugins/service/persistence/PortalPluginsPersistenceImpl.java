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

package com.bkav.portal.portlet.portalplugins.service.persistence;

import com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException;
import com.bkav.portal.portlet.portalplugins.model.PortalPlugins;
import com.bkav.portal.portlet.portalplugins.model.impl.PortalPluginsImpl;
import com.bkav.portal.portlet.portalplugins.model.impl.PortalPluginsModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the portal plugins service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhBDb
 * @see PortalPluginsPersistence
 * @see PortalPluginsUtil
 * @generated
 */
public class PortalPluginsPersistenceImpl extends BasePersistenceImpl<PortalPlugins>
	implements PortalPluginsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PortalPluginsUtil} to access the portal plugins persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PortalPluginsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED,
			PortalPluginsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED,
			PortalPluginsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] { Long.class.getName() },
			PortalPluginsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED,
			PortalPluginsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED,
			PortalPluginsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyId", new String[] { Long.class.getName() },
			PortalPluginsModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_PLUGINCODE = new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED,
			PortalPluginsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPluginCode", new String[] { String.class.getName() },
			PortalPluginsModelImpl.PLUGINCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PLUGINCODE = new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPluginCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_CODEANDVERSION = new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED,
			PortalPluginsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCodeAndVersion",
			new String[] {
				String.class.getName(), Double.class.getName(),
				Long.class.getName()
			},
			PortalPluginsModelImpl.PLUGINCODE_COLUMN_BITMASK |
			PortalPluginsModelImpl.PLUGINVERSION_COLUMN_BITMASK |
			PortalPluginsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODEANDVERSION = new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodeAndVersion",
			new String[] {
				String.class.getName(), Double.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EPORTALID =
		new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED,
			PortalPluginsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByePortalId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EPORTALID =
		new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED,
			PortalPluginsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByePortalId", new String[] { Long.class.getName() },
			PortalPluginsModelImpl.EPORTALID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EPORTALID = new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByePortalId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED,
			PortalPluginsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED,
			PortalPluginsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the portal plugins in the entity cache if it is enabled.
	 *
	 * @param portalPlugins the portal plugins
	 */
	public void cacheResult(PortalPlugins portalPlugins) {
		EntityCacheUtil.putResult(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsImpl.class, portalPlugins.getPrimaryKey(),
			portalPlugins);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
			new Object[] { portalPlugins.getPluginCode() }, portalPlugins);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEANDVERSION,
			new Object[] {
				portalPlugins.getPluginCode(),
				Double.valueOf(portalPlugins.getPluginVersion()),
				Long.valueOf(portalPlugins.getGroupId())
			}, portalPlugins);

		portalPlugins.resetOriginalValues();
	}

	/**
	 * Caches the portal pluginses in the entity cache if it is enabled.
	 *
	 * @param portalPluginses the portal pluginses
	 */
	public void cacheResult(List<PortalPlugins> portalPluginses) {
		for (PortalPlugins portalPlugins : portalPluginses) {
			if (EntityCacheUtil.getResult(
						PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
						PortalPluginsImpl.class, portalPlugins.getPrimaryKey()) == null) {
				cacheResult(portalPlugins);
			}
			else {
				portalPlugins.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all portal pluginses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PortalPluginsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PortalPluginsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the portal plugins.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PortalPlugins portalPlugins) {
		EntityCacheUtil.removeResult(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsImpl.class, portalPlugins.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(portalPlugins);
	}

	@Override
	public void clearCache(List<PortalPlugins> portalPluginses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PortalPlugins portalPlugins : portalPluginses) {
			EntityCacheUtil.removeResult(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
				PortalPluginsImpl.class, portalPlugins.getPrimaryKey());

			clearUniqueFindersCache(portalPlugins);
		}
	}

	protected void clearUniqueFindersCache(PortalPlugins portalPlugins) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
			new Object[] { portalPlugins.getPluginCode() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODEANDVERSION,
			new Object[] {
				portalPlugins.getPluginCode(),
				Double.valueOf(portalPlugins.getPluginVersion()),
				Long.valueOf(portalPlugins.getGroupId())
			});
	}

	/**
	 * Creates a new portal plugins with the primary key. Does not add the portal plugins to the database.
	 *
	 * @param pluginId the primary key for the new portal plugins
	 * @return the new portal plugins
	 */
	public PortalPlugins create(long pluginId) {
		PortalPlugins portalPlugins = new PortalPluginsImpl();

		portalPlugins.setNew(true);
		portalPlugins.setPrimaryKey(pluginId);

		return portalPlugins;
	}

	/**
	 * Removes the portal plugins with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pluginId the primary key of the portal plugins
	 * @return the portal plugins that was removed
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins remove(long pluginId)
		throws NoSuchPortalPluginsException, SystemException {
		return remove(Long.valueOf(pluginId));
	}

	/**
	 * Removes the portal plugins with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the portal plugins
	 * @return the portal plugins that was removed
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortalPlugins remove(Serializable primaryKey)
		throws NoSuchPortalPluginsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PortalPlugins portalPlugins = (PortalPlugins)session.get(PortalPluginsImpl.class,
					primaryKey);

			if (portalPlugins == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPortalPluginsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(portalPlugins);
		}
		catch (NoSuchPortalPluginsException nsee) {
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
	protected PortalPlugins removeImpl(PortalPlugins portalPlugins)
		throws SystemException {
		portalPlugins = toUnwrappedModel(portalPlugins);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, portalPlugins);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(portalPlugins);

		return portalPlugins;
	}

	@Override
	public PortalPlugins updateImpl(
		com.bkav.portal.portlet.portalplugins.model.PortalPlugins portalPlugins,
		boolean merge) throws SystemException {
		portalPlugins = toUnwrappedModel(portalPlugins);

		boolean isNew = portalPlugins.isNew();

		PortalPluginsModelImpl portalPluginsModelImpl = (PortalPluginsModelImpl)portalPlugins;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, portalPlugins, merge);

			portalPlugins.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PortalPluginsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((portalPluginsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portalPluginsModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(portalPluginsModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((portalPluginsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portalPluginsModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(portalPluginsModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((portalPluginsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EPORTALID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portalPluginsModelImpl.getOriginalEPortalId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EPORTALID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EPORTALID,
					args);

				args = new Object[] {
						Long.valueOf(portalPluginsModelImpl.getEPortalId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EPORTALID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EPORTALID,
					args);
			}
		}

		EntityCacheUtil.putResult(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
			PortalPluginsImpl.class, portalPlugins.getPrimaryKey(),
			portalPlugins);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
				new Object[] { portalPlugins.getPluginCode() }, portalPlugins);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEANDVERSION,
				new Object[] {
					portalPlugins.getPluginCode(),
					Double.valueOf(portalPlugins.getPluginVersion()),
					Long.valueOf(portalPlugins.getGroupId())
				}, portalPlugins);
		}
		else {
			if ((portalPluginsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PLUGINCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						portalPluginsModelImpl.getOriginalPluginCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PLUGINCODE,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
					new Object[] { portalPlugins.getPluginCode() },
					portalPlugins);
			}

			if ((portalPluginsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODEANDVERSION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						portalPluginsModelImpl.getOriginalPluginCode(),
						Double.valueOf(portalPluginsModelImpl.getOriginalPluginVersion()),
						Long.valueOf(portalPluginsModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODEANDVERSION,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODEANDVERSION,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEANDVERSION,
					new Object[] {
						portalPlugins.getPluginCode(),
						Double.valueOf(portalPlugins.getPluginVersion()),
						Long.valueOf(portalPlugins.getGroupId())
					}, portalPlugins);
			}
		}

		return portalPlugins;
	}

	protected PortalPlugins toUnwrappedModel(PortalPlugins portalPlugins) {
		if (portalPlugins instanceof PortalPluginsImpl) {
			return portalPlugins;
		}

		PortalPluginsImpl portalPluginsImpl = new PortalPluginsImpl();

		portalPluginsImpl.setNew(portalPlugins.isNew());
		portalPluginsImpl.setPrimaryKey(portalPlugins.getPrimaryKey());

		portalPluginsImpl.setPluginId(portalPlugins.getPluginId());
		portalPluginsImpl.setPluginName(portalPlugins.getPluginName());
		portalPluginsImpl.setPluginCode(portalPlugins.getPluginCode());
		portalPluginsImpl.setPluginVersion(portalPlugins.getPluginVersion());
		portalPluginsImpl.setPluginType(portalPlugins.getPluginType());
		portalPluginsImpl.setEPortalId(portalPlugins.getEPortalId());
		portalPluginsImpl.setIsImportant(portalPlugins.getIsImportant());
		portalPluginsImpl.setPluginDescription(portalPlugins.getPluginDescription());
		portalPluginsImpl.setPluginUpdateInfo(portalPlugins.getPluginUpdateInfo());
		portalPluginsImpl.setPluginSize(portalPlugins.getPluginSize());
		portalPluginsImpl.setWarFileId(portalPlugins.getWarFileId());
		portalPluginsImpl.setSignFileId(portalPlugins.getSignFileId());
		portalPluginsImpl.setCreateDate(portalPlugins.getCreateDate());
		portalPluginsImpl.setModifyDate(portalPlugins.getModifyDate());
		portalPluginsImpl.setGroupId(portalPlugins.getGroupId());
		portalPluginsImpl.setUserId(portalPlugins.getUserId());
		portalPluginsImpl.setCompanyId(portalPlugins.getCompanyId());
		portalPluginsImpl.setUserName(portalPlugins.getUserName());

		return portalPluginsImpl;
	}

	/**
	 * Returns the portal plugins with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the portal plugins
	 * @return the portal plugins
	 * @throws com.liferay.portal.NoSuchModelException if a portal plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortalPlugins findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the portal plugins with the primary key or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException} if it could not be found.
	 *
	 * @param pluginId the primary key of the portal plugins
	 * @return the portal plugins
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins findByPrimaryKey(long pluginId)
		throws NoSuchPortalPluginsException, SystemException {
		PortalPlugins portalPlugins = fetchByPrimaryKey(pluginId);

		if (portalPlugins == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + pluginId);
			}

			throw new NoSuchPortalPluginsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				pluginId);
		}

		return portalPlugins;
	}

	/**
	 * Returns the portal plugins with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the portal plugins
	 * @return the portal plugins, or <code>null</code> if a portal plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortalPlugins fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the portal plugins with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pluginId the primary key of the portal plugins
	 * @return the portal plugins, or <code>null</code> if a portal plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins fetchByPrimaryKey(long pluginId)
		throws SystemException {
		PortalPlugins portalPlugins = (PortalPlugins)EntityCacheUtil.getResult(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
				PortalPluginsImpl.class, pluginId);

		if (portalPlugins == _nullPortalPlugins) {
			return null;
		}

		if (portalPlugins == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				portalPlugins = (PortalPlugins)session.get(PortalPluginsImpl.class,
						Long.valueOf(pluginId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (portalPlugins != null) {
					cacheResult(portalPlugins);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PortalPluginsModelImpl.ENTITY_CACHE_ENABLED,
						PortalPluginsImpl.class, pluginId, _nullPortalPlugins);
				}

				closeSession(session);
			}
		}

		return portalPlugins;
	}

	/**
	 * Returns all the portal pluginses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the portal pluginses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of portal pluginses
	 * @param end the upper bound of the range of portal pluginses (not inclusive)
	 * @return the range of matching portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the portal pluginses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of portal pluginses
	 * @param end the upper bound of the range of portal pluginses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<PortalPlugins> list = (List<PortalPlugins>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortalPlugins portalPlugins : list) {
				if ((groupId != portalPlugins.getGroupId())) {
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

			query.append(_SQL_SELECT_PORTALPLUGINS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PortalPluginsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<PortalPlugins>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first portal plugins in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portal plugins
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPortalPluginsException, SystemException {
		PortalPlugins portalPlugins = fetchByGroupId_First(groupId,
				orderByComparator);

		if (portalPlugins != null) {
			return portalPlugins;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortalPluginsException(msg.toString());
	}

	/**
	 * Returns the first portal plugins in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PortalPlugins> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last portal plugins in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portal plugins
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPortalPluginsException, SystemException {
		PortalPlugins portalPlugins = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (portalPlugins != null) {
			return portalPlugins;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortalPluginsException(msg.toString());
	}

	/**
	 * Returns the last portal plugins in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		List<PortalPlugins> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the portal pluginses before and after the current portal plugins in the ordered set where groupId = &#63;.
	 *
	 * @param pluginId the primary key of the current portal plugins
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portal plugins
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins[] findByGroupId_PrevAndNext(long pluginId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPortalPluginsException, SystemException {
		PortalPlugins portalPlugins = findByPrimaryKey(pluginId);

		Session session = null;

		try {
			session = openSession();

			PortalPlugins[] array = new PortalPluginsImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, portalPlugins,
					groupId, orderByComparator, true);

			array[1] = portalPlugins;

			array[2] = getByGroupId_PrevAndNext(session, portalPlugins,
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

	protected PortalPlugins getByGroupId_PrevAndNext(Session session,
		PortalPlugins portalPlugins, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTALPLUGINS_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(PortalPluginsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portalPlugins);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortalPlugins> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portal pluginses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching portal pluginses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the portal pluginses that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of portal pluginses
	 * @param end the upper bound of the range of portal pluginses (not inclusive)
	 * @return the range of matching portal pluginses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> filterFindByGroupId(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the portal pluginses that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of portal pluginses
	 * @param end the upper bound of the range of portal pluginses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portal pluginses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_PORTALPLUGINS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PORTALPLUGINS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PORTALPLUGINS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PortalPluginsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PortalPluginsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PortalPlugins.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PortalPluginsImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PortalPluginsImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<PortalPlugins>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the portal pluginses before and after the current portal plugins in the ordered set of portal pluginses that the user has permission to view where groupId = &#63;.
	 *
	 * @param pluginId the primary key of the current portal plugins
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portal plugins
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins[] filterFindByGroupId_PrevAndNext(long pluginId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPortalPluginsException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(pluginId, groupId,
				orderByComparator);
		}

		PortalPlugins portalPlugins = findByPrimaryKey(pluginId);

		Session session = null;

		try {
			session = openSession();

			PortalPlugins[] array = new PortalPluginsImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, portalPlugins,
					groupId, orderByComparator, true);

			array[1] = portalPlugins;

			array[2] = filterGetByGroupId_PrevAndNext(session, portalPlugins,
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

	protected PortalPlugins filterGetByGroupId_PrevAndNext(Session session,
		PortalPlugins portalPlugins, long groupId,
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
			query.append(_FILTER_SQL_SELECT_PORTALPLUGINS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PORTALPLUGINS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PORTALPLUGINS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PortalPluginsModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PortalPluginsModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PortalPlugins.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PortalPluginsImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PortalPluginsImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portalPlugins);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortalPlugins> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portal pluginses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the portal pluginses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of portal pluginses
	 * @param end the upper bound of the range of portal pluginses (not inclusive)
	 * @return the range of matching portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the portal pluginses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of portal pluginses
	 * @param end the upper bound of the range of portal pluginses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<PortalPlugins> list = (List<PortalPlugins>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortalPlugins portalPlugins : list) {
				if ((companyId != portalPlugins.getCompanyId())) {
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

			query.append(_SQL_SELECT_PORTALPLUGINS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PortalPluginsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<PortalPlugins>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first portal plugins in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portal plugins
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPortalPluginsException, SystemException {
		PortalPlugins portalPlugins = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (portalPlugins != null) {
			return portalPlugins;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortalPluginsException(msg.toString());
	}

	/**
	 * Returns the first portal plugins in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PortalPlugins> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last portal plugins in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portal plugins
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPortalPluginsException, SystemException {
		PortalPlugins portalPlugins = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (portalPlugins != null) {
			return portalPlugins;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortalPluginsException(msg.toString());
	}

	/**
	 * Returns the last portal plugins in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<PortalPlugins> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the portal pluginses before and after the current portal plugins in the ordered set where companyId = &#63;.
	 *
	 * @param pluginId the primary key of the current portal plugins
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portal plugins
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins[] findByCompanyId_PrevAndNext(long pluginId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchPortalPluginsException, SystemException {
		PortalPlugins portalPlugins = findByPrimaryKey(pluginId);

		Session session = null;

		try {
			session = openSession();

			PortalPlugins[] array = new PortalPluginsImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, portalPlugins,
					companyId, orderByComparator, true);

			array[1] = portalPlugins;

			array[2] = getByCompanyId_PrevAndNext(session, portalPlugins,
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

	protected PortalPlugins getByCompanyId_PrevAndNext(Session session,
		PortalPlugins portalPlugins, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTALPLUGINS_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(PortalPluginsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portalPlugins);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortalPlugins> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the portal plugins where pluginCode = &#63; or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException} if it could not be found.
	 *
	 * @param pluginCode the plugin code
	 * @return the matching portal plugins
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins findByPluginCode(String pluginCode)
		throws NoSuchPortalPluginsException, SystemException {
		PortalPlugins portalPlugins = fetchByPluginCode(pluginCode);

		if (portalPlugins == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("pluginCode=");
			msg.append(pluginCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPortalPluginsException(msg.toString());
		}

		return portalPlugins;
	}

	/**
	 * Returns the portal plugins where pluginCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pluginCode the plugin code
	 * @return the matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins fetchByPluginCode(String pluginCode)
		throws SystemException {
		return fetchByPluginCode(pluginCode, true);
	}

	/**
	 * Returns the portal plugins where pluginCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param pluginCode the plugin code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins fetchByPluginCode(String pluginCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { pluginCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
					finderArgs, this);
		}

		if (result instanceof PortalPlugins) {
			PortalPlugins portalPlugins = (PortalPlugins)result;

			if (!Validator.equals(pluginCode, portalPlugins.getPluginCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PORTALPLUGINS_WHERE);

			if (pluginCode == null) {
				query.append(_FINDER_COLUMN_PLUGINCODE_PLUGINCODE_1);
			}
			else {
				if (pluginCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PLUGINCODE_PLUGINCODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_PLUGINCODE_PLUGINCODE_2);
				}
			}

			query.append(PortalPluginsModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (pluginCode != null) {
					qPos.add(pluginCode);
				}

				List<PortalPlugins> list = q.list();

				result = list;

				PortalPlugins portalPlugins = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
						finderArgs, list);
				}
				else {
					portalPlugins = list.get(0);

					cacheResult(portalPlugins);

					if ((portalPlugins.getPluginCode() == null) ||
							!portalPlugins.getPluginCode().equals(pluginCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
							finderArgs, portalPlugins);
					}
				}

				return portalPlugins;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (PortalPlugins)result;
			}
		}
	}

	/**
	 * Returns the portal plugins where pluginCode = &#63; and pluginVersion = &#63; and groupId = &#63; or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException} if it could not be found.
	 *
	 * @param pluginCode the plugin code
	 * @param pluginVersion the plugin version
	 * @param groupId the group ID
	 * @return the matching portal plugins
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins findByCodeAndVersion(String pluginCode,
		double pluginVersion, long groupId)
		throws NoSuchPortalPluginsException, SystemException {
		PortalPlugins portalPlugins = fetchByCodeAndVersion(pluginCode,
				pluginVersion, groupId);

		if (portalPlugins == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("pluginCode=");
			msg.append(pluginCode);

			msg.append(", pluginVersion=");
			msg.append(pluginVersion);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPortalPluginsException(msg.toString());
		}

		return portalPlugins;
	}

	/**
	 * Returns the portal plugins where pluginCode = &#63; and pluginVersion = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pluginCode the plugin code
	 * @param pluginVersion the plugin version
	 * @param groupId the group ID
	 * @return the matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins fetchByCodeAndVersion(String pluginCode,
		double pluginVersion, long groupId) throws SystemException {
		return fetchByCodeAndVersion(pluginCode, pluginVersion, groupId, true);
	}

	/**
	 * Returns the portal plugins where pluginCode = &#63; and pluginVersion = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param pluginCode the plugin code
	 * @param pluginVersion the plugin version
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins fetchByCodeAndVersion(String pluginCode,
		double pluginVersion, long groupId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { pluginCode, pluginVersion, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODEANDVERSION,
					finderArgs, this);
		}

		if (result instanceof PortalPlugins) {
			PortalPlugins portalPlugins = (PortalPlugins)result;

			if (!Validator.equals(pluginCode, portalPlugins.getPluginCode()) ||
					(pluginVersion != portalPlugins.getPluginVersion()) ||
					(groupId != portalPlugins.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_PORTALPLUGINS_WHERE);

			if (pluginCode == null) {
				query.append(_FINDER_COLUMN_CODEANDVERSION_PLUGINCODE_1);
			}
			else {
				if (pluginCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CODEANDVERSION_PLUGINCODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_CODEANDVERSION_PLUGINCODE_2);
				}
			}

			query.append(_FINDER_COLUMN_CODEANDVERSION_PLUGINVERSION_2);

			query.append(_FINDER_COLUMN_CODEANDVERSION_GROUPID_2);

			query.append(PortalPluginsModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (pluginCode != null) {
					qPos.add(pluginCode);
				}

				qPos.add(pluginVersion);

				qPos.add(groupId);

				List<PortalPlugins> list = q.list();

				result = list;

				PortalPlugins portalPlugins = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEANDVERSION,
						finderArgs, list);
				}
				else {
					portalPlugins = list.get(0);

					cacheResult(portalPlugins);

					if ((portalPlugins.getPluginCode() == null) ||
							!portalPlugins.getPluginCode().equals(pluginCode) ||
							(portalPlugins.getPluginVersion() != pluginVersion) ||
							(portalPlugins.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODEANDVERSION,
							finderArgs, portalPlugins);
					}
				}

				return portalPlugins;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODEANDVERSION,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (PortalPlugins)result;
			}
		}
	}

	/**
	 * Returns all the portal pluginses where ePortalId = &#63;.
	 *
	 * @param ePortalId the e portal ID
	 * @return the matching portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> findByePortalId(long ePortalId)
		throws SystemException {
		return findByePortalId(ePortalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the portal pluginses where ePortalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ePortalId the e portal ID
	 * @param start the lower bound of the range of portal pluginses
	 * @param end the upper bound of the range of portal pluginses (not inclusive)
	 * @return the range of matching portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> findByePortalId(long ePortalId, int start,
		int end) throws SystemException {
		return findByePortalId(ePortalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the portal pluginses where ePortalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ePortalId the e portal ID
	 * @param start the lower bound of the range of portal pluginses
	 * @param end the upper bound of the range of portal pluginses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> findByePortalId(long ePortalId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EPORTALID;
			finderArgs = new Object[] { ePortalId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EPORTALID;
			finderArgs = new Object[] { ePortalId, start, end, orderByComparator };
		}

		List<PortalPlugins> list = (List<PortalPlugins>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortalPlugins portalPlugins : list) {
				if ((ePortalId != portalPlugins.getEPortalId())) {
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

			query.append(_SQL_SELECT_PORTALPLUGINS_WHERE);

			query.append(_FINDER_COLUMN_EPORTALID_EPORTALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PortalPluginsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ePortalId);

				list = (List<PortalPlugins>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first portal plugins in the ordered set where ePortalId = &#63;.
	 *
	 * @param ePortalId the e portal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portal plugins
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins findByePortalId_First(long ePortalId,
		OrderByComparator orderByComparator)
		throws NoSuchPortalPluginsException, SystemException {
		PortalPlugins portalPlugins = fetchByePortalId_First(ePortalId,
				orderByComparator);

		if (portalPlugins != null) {
			return portalPlugins;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ePortalId=");
		msg.append(ePortalId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortalPluginsException(msg.toString());
	}

	/**
	 * Returns the first portal plugins in the ordered set where ePortalId = &#63;.
	 *
	 * @param ePortalId the e portal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins fetchByePortalId_First(long ePortalId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PortalPlugins> list = findByePortalId(ePortalId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last portal plugins in the ordered set where ePortalId = &#63;.
	 *
	 * @param ePortalId the e portal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portal plugins
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins findByePortalId_Last(long ePortalId,
		OrderByComparator orderByComparator)
		throws NoSuchPortalPluginsException, SystemException {
		PortalPlugins portalPlugins = fetchByePortalId_Last(ePortalId,
				orderByComparator);

		if (portalPlugins != null) {
			return portalPlugins;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ePortalId=");
		msg.append(ePortalId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortalPluginsException(msg.toString());
	}

	/**
	 * Returns the last portal plugins in the ordered set where ePortalId = &#63;.
	 *
	 * @param ePortalId the e portal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins fetchByePortalId_Last(long ePortalId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByePortalId(ePortalId);

		List<PortalPlugins> list = findByePortalId(ePortalId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the portal pluginses before and after the current portal plugins in the ordered set where ePortalId = &#63;.
	 *
	 * @param pluginId the primary key of the current portal plugins
	 * @param ePortalId the e portal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portal plugins
	 * @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins[] findByePortalId_PrevAndNext(long pluginId,
		long ePortalId, OrderByComparator orderByComparator)
		throws NoSuchPortalPluginsException, SystemException {
		PortalPlugins portalPlugins = findByPrimaryKey(pluginId);

		Session session = null;

		try {
			session = openSession();

			PortalPlugins[] array = new PortalPluginsImpl[3];

			array[0] = getByePortalId_PrevAndNext(session, portalPlugins,
					ePortalId, orderByComparator, true);

			array[1] = portalPlugins;

			array[2] = getByePortalId_PrevAndNext(session, portalPlugins,
					ePortalId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PortalPlugins getByePortalId_PrevAndNext(Session session,
		PortalPlugins portalPlugins, long ePortalId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTALPLUGINS_WHERE);

		query.append(_FINDER_COLUMN_EPORTALID_EPORTALID_2);

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
			query.append(PortalPluginsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ePortalId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portalPlugins);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortalPlugins> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portal pluginses.
	 *
	 * @return the portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the portal pluginses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of portal pluginses
	 * @param end the upper bound of the range of portal pluginses (not inclusive)
	 * @return the range of portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the portal pluginses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of portal pluginses
	 * @param end the upper bound of the range of portal pluginses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortalPlugins> findAll(int start, int end,
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

		List<PortalPlugins> list = (List<PortalPlugins>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PORTALPLUGINS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PORTALPLUGINS.concat(PortalPluginsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PortalPlugins>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PortalPlugins>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the portal pluginses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (PortalPlugins portalPlugins : findByGroupId(groupId)) {
			remove(portalPlugins);
		}
	}

	/**
	 * Removes all the portal pluginses where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (PortalPlugins portalPlugins : findByCompanyId(companyId)) {
			remove(portalPlugins);
		}
	}

	/**
	 * Removes the portal plugins where pluginCode = &#63; from the database.
	 *
	 * @param pluginCode the plugin code
	 * @return the portal plugins that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins removeByPluginCode(String pluginCode)
		throws NoSuchPortalPluginsException, SystemException {
		PortalPlugins portalPlugins = findByPluginCode(pluginCode);

		return remove(portalPlugins);
	}

	/**
	 * Removes the portal plugins where pluginCode = &#63; and pluginVersion = &#63; and groupId = &#63; from the database.
	 *
	 * @param pluginCode the plugin code
	 * @param pluginVersion the plugin version
	 * @param groupId the group ID
	 * @return the portal plugins that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public PortalPlugins removeByCodeAndVersion(String pluginCode,
		double pluginVersion, long groupId)
		throws NoSuchPortalPluginsException, SystemException {
		PortalPlugins portalPlugins = findByCodeAndVersion(pluginCode,
				pluginVersion, groupId);

		return remove(portalPlugins);
	}

	/**
	 * Removes all the portal pluginses where ePortalId = &#63; from the database.
	 *
	 * @param ePortalId the e portal ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByePortalId(long ePortalId) throws SystemException {
		for (PortalPlugins portalPlugins : findByePortalId(ePortalId)) {
			remove(portalPlugins);
		}
	}

	/**
	 * Removes all the portal pluginses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PortalPlugins portalPlugins : findAll()) {
			remove(portalPlugins);
		}
	}

	/**
	 * Returns the number of portal pluginses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PORTALPLUGINS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of portal pluginses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching portal pluginses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_PORTALPLUGINS_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PortalPlugins.class.getName(),
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
	 * Returns the number of portal pluginses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PORTALPLUGINS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of portal pluginses where pluginCode = &#63;.
	 *
	 * @param pluginCode the plugin code
	 * @return the number of matching portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPluginCode(String pluginCode) throws SystemException {
		Object[] finderArgs = new Object[] { pluginCode };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PLUGINCODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PORTALPLUGINS_WHERE);

			if (pluginCode == null) {
				query.append(_FINDER_COLUMN_PLUGINCODE_PLUGINCODE_1);
			}
			else {
				if (pluginCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PLUGINCODE_PLUGINCODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_PLUGINCODE_PLUGINCODE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (pluginCode != null) {
					qPos.add(pluginCode);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PLUGINCODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of portal pluginses where pluginCode = &#63; and pluginVersion = &#63; and groupId = &#63;.
	 *
	 * @param pluginCode the plugin code
	 * @param pluginVersion the plugin version
	 * @param groupId the group ID
	 * @return the number of matching portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCodeAndVersion(String pluginCode, double pluginVersion,
		long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { pluginCode, pluginVersion, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CODEANDVERSION,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PORTALPLUGINS_WHERE);

			if (pluginCode == null) {
				query.append(_FINDER_COLUMN_CODEANDVERSION_PLUGINCODE_1);
			}
			else {
				if (pluginCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CODEANDVERSION_PLUGINCODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_CODEANDVERSION_PLUGINCODE_2);
				}
			}

			query.append(_FINDER_COLUMN_CODEANDVERSION_PLUGINVERSION_2);

			query.append(_FINDER_COLUMN_CODEANDVERSION_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (pluginCode != null) {
					qPos.add(pluginCode);
				}

				qPos.add(pluginVersion);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODEANDVERSION,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of portal pluginses where ePortalId = &#63;.
	 *
	 * @param ePortalId the e portal ID
	 * @return the number of matching portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByePortalId(long ePortalId) throws SystemException {
		Object[] finderArgs = new Object[] { ePortalId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EPORTALID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PORTALPLUGINS_WHERE);

			query.append(_FINDER_COLUMN_EPORTALID_EPORTALID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ePortalId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EPORTALID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of portal pluginses.
	 *
	 * @return the number of portal pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PORTALPLUGINS);

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
	 * Initializes the portal plugins persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.portalplugins.model.PortalPlugins")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PortalPlugins>> listenersList = new ArrayList<ModelListener<PortalPlugins>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PortalPlugins>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PortalPluginsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ePortalsPersistence.class)
	protected ePortalsPersistence ePortalsPersistence;
	@BeanReference(type = PortalPluginsPersistence.class)
	protected PortalPluginsPersistence portalPluginsPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_PORTALPLUGINS = "SELECT portalPlugins FROM PortalPlugins portalPlugins";
	private static final String _SQL_SELECT_PORTALPLUGINS_WHERE = "SELECT portalPlugins FROM PortalPlugins portalPlugins WHERE ";
	private static final String _SQL_COUNT_PORTALPLUGINS = "SELECT COUNT(portalPlugins) FROM PortalPlugins portalPlugins";
	private static final String _SQL_COUNT_PORTALPLUGINS_WHERE = "SELECT COUNT(portalPlugins) FROM PortalPlugins portalPlugins WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "portalPlugins.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "portalPlugins.companyId = ?";
	private static final String _FINDER_COLUMN_PLUGINCODE_PLUGINCODE_1 = "portalPlugins.pluginCode IS NULL";
	private static final String _FINDER_COLUMN_PLUGINCODE_PLUGINCODE_2 = "portalPlugins.pluginCode = ?";
	private static final String _FINDER_COLUMN_PLUGINCODE_PLUGINCODE_3 = "(portalPlugins.pluginCode IS NULL OR portalPlugins.pluginCode = ?)";
	private static final String _FINDER_COLUMN_CODEANDVERSION_PLUGINCODE_1 = "portalPlugins.pluginCode IS NULL AND ";
	private static final String _FINDER_COLUMN_CODEANDVERSION_PLUGINCODE_2 = "portalPlugins.pluginCode = ? AND ";
	private static final String _FINDER_COLUMN_CODEANDVERSION_PLUGINCODE_3 = "(portalPlugins.pluginCode IS NULL OR portalPlugins.pluginCode = ?) AND ";
	private static final String _FINDER_COLUMN_CODEANDVERSION_PLUGINVERSION_2 = "portalPlugins.pluginVersion = ? AND ";
	private static final String _FINDER_COLUMN_CODEANDVERSION_GROUPID_2 = "portalPlugins.groupId = ?";
	private static final String _FINDER_COLUMN_EPORTALID_EPORTALID_2 = "portalPlugins.ePortalId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "portalPlugins.pluginId";
	private static final String _FILTER_SQL_SELECT_PORTALPLUGINS_WHERE = "SELECT DISTINCT {portalPlugins.*} FROM PortalPlugins portalPlugins WHERE ";
	private static final String _FILTER_SQL_SELECT_PORTALPLUGINS_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {PortalPlugins.*} FROM (SELECT DISTINCT portalPlugins.pluginId FROM PortalPlugins portalPlugins WHERE ";
	private static final String _FILTER_SQL_SELECT_PORTALPLUGINS_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN PortalPlugins ON TEMP_TABLE.pluginId = PortalPlugins.pluginId";
	private static final String _FILTER_SQL_COUNT_PORTALPLUGINS_WHERE = "SELECT COUNT(DISTINCT portalPlugins.pluginId) AS COUNT_VALUE FROM PortalPlugins portalPlugins WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "portalPlugins";
	private static final String _FILTER_ENTITY_TABLE = "PortalPlugins";
	private static final String _ORDER_BY_ENTITY_ALIAS = "portalPlugins.";
	private static final String _ORDER_BY_ENTITY_TABLE = "PortalPlugins.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PortalPlugins exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PortalPlugins exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PortalPluginsPersistenceImpl.class);
	private static PortalPlugins _nullPortalPlugins = new PortalPluginsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PortalPlugins> toCacheModel() {
				return _nullPortalPluginsCacheModel;
			}
		};

	private static CacheModel<PortalPlugins> _nullPortalPluginsCacheModel = new CacheModel<PortalPlugins>() {
			public PortalPlugins toEntityModel() {
				return _nullPortalPlugins;
			}
		};
}