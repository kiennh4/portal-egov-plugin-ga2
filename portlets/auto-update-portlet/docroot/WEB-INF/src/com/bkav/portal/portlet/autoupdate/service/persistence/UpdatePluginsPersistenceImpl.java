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

package com.bkav.portal.portlet.autoupdate.service.persistence;

import com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException;
import com.bkav.portal.portlet.autoupdate.model.UpdatePlugins;
import com.bkav.portal.portlet.autoupdate.model.impl.UpdatePluginsImpl;
import com.bkav.portal.portlet.autoupdate.model.impl.UpdatePluginsModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the update plugins service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see UpdatePluginsPersistence
 * @see UpdatePluginsUtil
 * @generated
 */
public class UpdatePluginsPersistenceImpl extends BasePersistenceImpl<UpdatePlugins>
	implements UpdatePluginsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UpdatePluginsUtil} to access the update plugins persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UpdatePluginsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_PLUGINCODE = new FinderPath(UpdatePluginsModelImpl.ENTITY_CACHE_ENABLED,
			UpdatePluginsModelImpl.FINDER_CACHE_ENABLED,
			UpdatePluginsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPluginCode", new String[] { String.class.getName() },
			UpdatePluginsModelImpl.PLUGINCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PLUGINCODE = new FinderPath(UpdatePluginsModelImpl.ENTITY_CACHE_ENABLED,
			UpdatePluginsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPluginCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_PLUGINCODEANDVERSION = new FinderPath(UpdatePluginsModelImpl.ENTITY_CACHE_ENABLED,
			UpdatePluginsModelImpl.FINDER_CACHE_ENABLED,
			UpdatePluginsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPluginCodeAndVersion",
			new String[] { String.class.getName(), Double.class.getName() },
			UpdatePluginsModelImpl.PLUGINCODE_COLUMN_BITMASK |
			UpdatePluginsModelImpl.CURRENTVERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PLUGINCODEANDVERSION = new FinderPath(UpdatePluginsModelImpl.ENTITY_CACHE_ENABLED,
			UpdatePluginsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPluginCodeAndVersion",
			new String[] { String.class.getName(), Double.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UpdatePluginsModelImpl.ENTITY_CACHE_ENABLED,
			UpdatePluginsModelImpl.FINDER_CACHE_ENABLED,
			UpdatePluginsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UpdatePluginsModelImpl.ENTITY_CACHE_ENABLED,
			UpdatePluginsModelImpl.FINDER_CACHE_ENABLED,
			UpdatePluginsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UpdatePluginsModelImpl.ENTITY_CACHE_ENABLED,
			UpdatePluginsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the update plugins in the entity cache if it is enabled.
	 *
	 * @param updatePlugins the update plugins
	 */
	public void cacheResult(UpdatePlugins updatePlugins) {
		EntityCacheUtil.putResult(UpdatePluginsModelImpl.ENTITY_CACHE_ENABLED,
			UpdatePluginsImpl.class, updatePlugins.getPrimaryKey(),
			updatePlugins);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
			new Object[] { updatePlugins.getPluginCode() }, updatePlugins);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODEANDVERSION,
			new Object[] {
				updatePlugins.getPluginCode(),
				Double.valueOf(updatePlugins.getCurrentVersion())
			}, updatePlugins);

		updatePlugins.resetOriginalValues();
	}

	/**
	 * Caches the update pluginses in the entity cache if it is enabled.
	 *
	 * @param updatePluginses the update pluginses
	 */
	public void cacheResult(List<UpdatePlugins> updatePluginses) {
		for (UpdatePlugins updatePlugins : updatePluginses) {
			if (EntityCacheUtil.getResult(
						UpdatePluginsModelImpl.ENTITY_CACHE_ENABLED,
						UpdatePluginsImpl.class, updatePlugins.getPrimaryKey()) == null) {
				cacheResult(updatePlugins);
			}
			else {
				updatePlugins.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all update pluginses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UpdatePluginsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UpdatePluginsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the update plugins.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UpdatePlugins updatePlugins) {
		EntityCacheUtil.removeResult(UpdatePluginsModelImpl.ENTITY_CACHE_ENABLED,
			UpdatePluginsImpl.class, updatePlugins.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(updatePlugins);
	}

	@Override
	public void clearCache(List<UpdatePlugins> updatePluginses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UpdatePlugins updatePlugins : updatePluginses) {
			EntityCacheUtil.removeResult(UpdatePluginsModelImpl.ENTITY_CACHE_ENABLED,
				UpdatePluginsImpl.class, updatePlugins.getPrimaryKey());

			clearUniqueFindersCache(updatePlugins);
		}
	}

	protected void clearUniqueFindersCache(UpdatePlugins updatePlugins) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
			new Object[] { updatePlugins.getPluginCode() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PLUGINCODEANDVERSION,
			new Object[] {
				updatePlugins.getPluginCode(),
				Double.valueOf(updatePlugins.getCurrentVersion())
			});
	}

	/**
	 * Creates a new update plugins with the primary key. Does not add the update plugins to the database.
	 *
	 * @param pluginId the primary key for the new update plugins
	 * @return the new update plugins
	 */
	public UpdatePlugins create(long pluginId) {
		UpdatePlugins updatePlugins = new UpdatePluginsImpl();

		updatePlugins.setNew(true);
		updatePlugins.setPrimaryKey(pluginId);

		return updatePlugins;
	}

	/**
	 * Removes the update plugins with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pluginId the primary key of the update plugins
	 * @return the update plugins that was removed
	 * @throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException if a update plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UpdatePlugins remove(long pluginId)
		throws NoSuchUpdatePluginsException, SystemException {
		return remove(Long.valueOf(pluginId));
	}

	/**
	 * Removes the update plugins with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the update plugins
	 * @return the update plugins that was removed
	 * @throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException if a update plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpdatePlugins remove(Serializable primaryKey)
		throws NoSuchUpdatePluginsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UpdatePlugins updatePlugins = (UpdatePlugins)session.get(UpdatePluginsImpl.class,
					primaryKey);

			if (updatePlugins == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUpdatePluginsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(updatePlugins);
		}
		catch (NoSuchUpdatePluginsException nsee) {
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
	protected UpdatePlugins removeImpl(UpdatePlugins updatePlugins)
		throws SystemException {
		updatePlugins = toUnwrappedModel(updatePlugins);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, updatePlugins);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(updatePlugins);

		return updatePlugins;
	}

	@Override
	public UpdatePlugins updateImpl(
		com.bkav.portal.portlet.autoupdate.model.UpdatePlugins updatePlugins,
		boolean merge) throws SystemException {
		updatePlugins = toUnwrappedModel(updatePlugins);

		boolean isNew = updatePlugins.isNew();

		UpdatePluginsModelImpl updatePluginsModelImpl = (UpdatePluginsModelImpl)updatePlugins;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, updatePlugins, merge);

			updatePlugins.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UpdatePluginsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(UpdatePluginsModelImpl.ENTITY_CACHE_ENABLED,
			UpdatePluginsImpl.class, updatePlugins.getPrimaryKey(),
			updatePlugins);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
				new Object[] { updatePlugins.getPluginCode() }, updatePlugins);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODEANDVERSION,
				new Object[] {
					updatePlugins.getPluginCode(),
					Double.valueOf(updatePlugins.getCurrentVersion())
				}, updatePlugins);
		}
		else {
			if ((updatePluginsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PLUGINCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						updatePluginsModelImpl.getOriginalPluginCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PLUGINCODE,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
					new Object[] { updatePlugins.getPluginCode() },
					updatePlugins);
			}

			if ((updatePluginsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PLUGINCODEANDVERSION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						updatePluginsModelImpl.getOriginalPluginCode(),
						Double.valueOf(updatePluginsModelImpl.getOriginalCurrentVersion())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PLUGINCODEANDVERSION,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PLUGINCODEANDVERSION,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODEANDVERSION,
					new Object[] {
						updatePlugins.getPluginCode(),
						Double.valueOf(updatePlugins.getCurrentVersion())
					}, updatePlugins);
			}
		}

		return updatePlugins;
	}

	protected UpdatePlugins toUnwrappedModel(UpdatePlugins updatePlugins) {
		if (updatePlugins instanceof UpdatePluginsImpl) {
			return updatePlugins;
		}

		UpdatePluginsImpl updatePluginsImpl = new UpdatePluginsImpl();

		updatePluginsImpl.setNew(updatePlugins.isNew());
		updatePluginsImpl.setPrimaryKey(updatePlugins.getPrimaryKey());

		updatePluginsImpl.setPluginId(updatePlugins.getPluginId());
		updatePluginsImpl.setPluginName(updatePlugins.getPluginName());
		updatePluginsImpl.setPluginCode(updatePlugins.getPluginCode());
		updatePluginsImpl.setPluginType(updatePlugins.getPluginType());
		updatePluginsImpl.setCurrentVersion(updatePlugins.getCurrentVersion());
		updatePluginsImpl.setPreviousVersions(updatePlugins.getPreviousVersions());
		updatePluginsImpl.setCurrentSize(updatePlugins.getCurrentSize());
		updatePluginsImpl.setCreateDate(updatePlugins.getCreateDate());
		updatePluginsImpl.setModifyDate(updatePlugins.getModifyDate());
		updatePluginsImpl.setServerCompanyId(updatePlugins.getServerCompanyId());

		return updatePluginsImpl;
	}

	/**
	 * Returns the update plugins with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the update plugins
	 * @return the update plugins
	 * @throws com.liferay.portal.NoSuchModelException if a update plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpdatePlugins findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the update plugins with the primary key or throws a {@link com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException} if it could not be found.
	 *
	 * @param pluginId the primary key of the update plugins
	 * @return the update plugins
	 * @throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException if a update plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UpdatePlugins findByPrimaryKey(long pluginId)
		throws NoSuchUpdatePluginsException, SystemException {
		UpdatePlugins updatePlugins = fetchByPrimaryKey(pluginId);

		if (updatePlugins == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + pluginId);
			}

			throw new NoSuchUpdatePluginsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				pluginId);
		}

		return updatePlugins;
	}

	/**
	 * Returns the update plugins with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the update plugins
	 * @return the update plugins, or <code>null</code> if a update plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpdatePlugins fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the update plugins with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pluginId the primary key of the update plugins
	 * @return the update plugins, or <code>null</code> if a update plugins with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UpdatePlugins fetchByPrimaryKey(long pluginId)
		throws SystemException {
		UpdatePlugins updatePlugins = (UpdatePlugins)EntityCacheUtil.getResult(UpdatePluginsModelImpl.ENTITY_CACHE_ENABLED,
				UpdatePluginsImpl.class, pluginId);

		if (updatePlugins == _nullUpdatePlugins) {
			return null;
		}

		if (updatePlugins == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				updatePlugins = (UpdatePlugins)session.get(UpdatePluginsImpl.class,
						Long.valueOf(pluginId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (updatePlugins != null) {
					cacheResult(updatePlugins);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(UpdatePluginsModelImpl.ENTITY_CACHE_ENABLED,
						UpdatePluginsImpl.class, pluginId, _nullUpdatePlugins);
				}

				closeSession(session);
			}
		}

		return updatePlugins;
	}

	/**
	 * Returns the update plugins where pluginCode = &#63; or throws a {@link com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException} if it could not be found.
	 *
	 * @param pluginCode the plugin code
	 * @return the matching update plugins
	 * @throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException if a matching update plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UpdatePlugins findByPluginCode(String pluginCode)
		throws NoSuchUpdatePluginsException, SystemException {
		UpdatePlugins updatePlugins = fetchByPluginCode(pluginCode);

		if (updatePlugins == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("pluginCode=");
			msg.append(pluginCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUpdatePluginsException(msg.toString());
		}

		return updatePlugins;
	}

	/**
	 * Returns the update plugins where pluginCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pluginCode the plugin code
	 * @return the matching update plugins, or <code>null</code> if a matching update plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UpdatePlugins fetchByPluginCode(String pluginCode)
		throws SystemException {
		return fetchByPluginCode(pluginCode, true);
	}

	/**
	 * Returns the update plugins where pluginCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param pluginCode the plugin code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching update plugins, or <code>null</code> if a matching update plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UpdatePlugins fetchByPluginCode(String pluginCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { pluginCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
					finderArgs, this);
		}

		if (result instanceof UpdatePlugins) {
			UpdatePlugins updatePlugins = (UpdatePlugins)result;

			if (!Validator.equals(pluginCode, updatePlugins.getPluginCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_UPDATEPLUGINS_WHERE);

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

				List<UpdatePlugins> list = q.list();

				result = list;

				UpdatePlugins updatePlugins = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
						finderArgs, list);
				}
				else {
					updatePlugins = list.get(0);

					cacheResult(updatePlugins);

					if ((updatePlugins.getPluginCode() == null) ||
							!updatePlugins.getPluginCode().equals(pluginCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODE,
							finderArgs, updatePlugins);
					}
				}

				return updatePlugins;
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
				return (UpdatePlugins)result;
			}
		}
	}

	/**
	 * Returns the update plugins where pluginCode = &#63; and currentVersion = &#63; or throws a {@link com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException} if it could not be found.
	 *
	 * @param pluginCode the plugin code
	 * @param currentVersion the current version
	 * @return the matching update plugins
	 * @throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException if a matching update plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UpdatePlugins findByPluginCodeAndVersion(String pluginCode,
		double currentVersion)
		throws NoSuchUpdatePluginsException, SystemException {
		UpdatePlugins updatePlugins = fetchByPluginCodeAndVersion(pluginCode,
				currentVersion);

		if (updatePlugins == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("pluginCode=");
			msg.append(pluginCode);

			msg.append(", currentVersion=");
			msg.append(currentVersion);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUpdatePluginsException(msg.toString());
		}

		return updatePlugins;
	}

	/**
	 * Returns the update plugins where pluginCode = &#63; and currentVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pluginCode the plugin code
	 * @param currentVersion the current version
	 * @return the matching update plugins, or <code>null</code> if a matching update plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UpdatePlugins fetchByPluginCodeAndVersion(String pluginCode,
		double currentVersion) throws SystemException {
		return fetchByPluginCodeAndVersion(pluginCode, currentVersion, true);
	}

	/**
	 * Returns the update plugins where pluginCode = &#63; and currentVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param pluginCode the plugin code
	 * @param currentVersion the current version
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching update plugins, or <code>null</code> if a matching update plugins could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UpdatePlugins fetchByPluginCodeAndVersion(String pluginCode,
		double currentVersion, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { pluginCode, currentVersion };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PLUGINCODEANDVERSION,
					finderArgs, this);
		}

		if (result instanceof UpdatePlugins) {
			UpdatePlugins updatePlugins = (UpdatePlugins)result;

			if (!Validator.equals(pluginCode, updatePlugins.getPluginCode()) ||
					(currentVersion != updatePlugins.getCurrentVersion())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_UPDATEPLUGINS_WHERE);

			if (pluginCode == null) {
				query.append(_FINDER_COLUMN_PLUGINCODEANDVERSION_PLUGINCODE_1);
			}
			else {
				if (pluginCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PLUGINCODEANDVERSION_PLUGINCODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_PLUGINCODEANDVERSION_PLUGINCODE_2);
				}
			}

			query.append(_FINDER_COLUMN_PLUGINCODEANDVERSION_CURRENTVERSION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (pluginCode != null) {
					qPos.add(pluginCode);
				}

				qPos.add(currentVersion);

				List<UpdatePlugins> list = q.list();

				result = list;

				UpdatePlugins updatePlugins = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODEANDVERSION,
						finderArgs, list);
				}
				else {
					updatePlugins = list.get(0);

					cacheResult(updatePlugins);

					if ((updatePlugins.getPluginCode() == null) ||
							!updatePlugins.getPluginCode().equals(pluginCode) ||
							(updatePlugins.getCurrentVersion() != currentVersion)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PLUGINCODEANDVERSION,
							finderArgs, updatePlugins);
					}
				}

				return updatePlugins;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PLUGINCODEANDVERSION,
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
				return (UpdatePlugins)result;
			}
		}
	}

	/**
	 * Returns all the update pluginses.
	 *
	 * @return the update pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<UpdatePlugins> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the update pluginses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of update pluginses
	 * @param end the upper bound of the range of update pluginses (not inclusive)
	 * @return the range of update pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<UpdatePlugins> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the update pluginses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of update pluginses
	 * @param end the upper bound of the range of update pluginses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of update pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public List<UpdatePlugins> findAll(int start, int end,
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

		List<UpdatePlugins> list = (List<UpdatePlugins>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UPDATEPLUGINS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UPDATEPLUGINS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<UpdatePlugins>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<UpdatePlugins>)QueryUtil.list(q, getDialect(),
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
	 * Removes the update plugins where pluginCode = &#63; from the database.
	 *
	 * @param pluginCode the plugin code
	 * @return the update plugins that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public UpdatePlugins removeByPluginCode(String pluginCode)
		throws NoSuchUpdatePluginsException, SystemException {
		UpdatePlugins updatePlugins = findByPluginCode(pluginCode);

		return remove(updatePlugins);
	}

	/**
	 * Removes the update plugins where pluginCode = &#63; and currentVersion = &#63; from the database.
	 *
	 * @param pluginCode the plugin code
	 * @param currentVersion the current version
	 * @return the update plugins that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public UpdatePlugins removeByPluginCodeAndVersion(String pluginCode,
		double currentVersion)
		throws NoSuchUpdatePluginsException, SystemException {
		UpdatePlugins updatePlugins = findByPluginCodeAndVersion(pluginCode,
				currentVersion);

		return remove(updatePlugins);
	}

	/**
	 * Removes all the update pluginses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (UpdatePlugins updatePlugins : findAll()) {
			remove(updatePlugins);
		}
	}

	/**
	 * Returns the number of update pluginses where pluginCode = &#63;.
	 *
	 * @param pluginCode the plugin code
	 * @return the number of matching update pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPluginCode(String pluginCode) throws SystemException {
		Object[] finderArgs = new Object[] { pluginCode };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PLUGINCODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UPDATEPLUGINS_WHERE);

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
	 * Returns the number of update pluginses where pluginCode = &#63; and currentVersion = &#63;.
	 *
	 * @param pluginCode the plugin code
	 * @param currentVersion the current version
	 * @return the number of matching update pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPluginCodeAndVersion(String pluginCode,
		double currentVersion) throws SystemException {
		Object[] finderArgs = new Object[] { pluginCode, currentVersion };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PLUGINCODEANDVERSION,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_UPDATEPLUGINS_WHERE);

			if (pluginCode == null) {
				query.append(_FINDER_COLUMN_PLUGINCODEANDVERSION_PLUGINCODE_1);
			}
			else {
				if (pluginCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PLUGINCODEANDVERSION_PLUGINCODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_PLUGINCODEANDVERSION_PLUGINCODE_2);
				}
			}

			query.append(_FINDER_COLUMN_PLUGINCODEANDVERSION_CURRENTVERSION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (pluginCode != null) {
					qPos.add(pluginCode);
				}

				qPos.add(currentVersion);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PLUGINCODEANDVERSION,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of update pluginses.
	 *
	 * @return the number of update pluginses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_UPDATEPLUGINS);

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
	 * Initializes the update plugins persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.autoupdate.model.UpdatePlugins")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UpdatePlugins>> listenersList = new ArrayList<ModelListener<UpdatePlugins>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UpdatePlugins>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UpdatePluginsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = UpdatePluginsPersistence.class)
	protected UpdatePluginsPersistence updatePluginsPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_UPDATEPLUGINS = "SELECT updatePlugins FROM UpdatePlugins updatePlugins";
	private static final String _SQL_SELECT_UPDATEPLUGINS_WHERE = "SELECT updatePlugins FROM UpdatePlugins updatePlugins WHERE ";
	private static final String _SQL_COUNT_UPDATEPLUGINS = "SELECT COUNT(updatePlugins) FROM UpdatePlugins updatePlugins";
	private static final String _SQL_COUNT_UPDATEPLUGINS_WHERE = "SELECT COUNT(updatePlugins) FROM UpdatePlugins updatePlugins WHERE ";
	private static final String _FINDER_COLUMN_PLUGINCODE_PLUGINCODE_1 = "updatePlugins.pluginCode IS NULL";
	private static final String _FINDER_COLUMN_PLUGINCODE_PLUGINCODE_2 = "updatePlugins.pluginCode = ?";
	private static final String _FINDER_COLUMN_PLUGINCODE_PLUGINCODE_3 = "(updatePlugins.pluginCode IS NULL OR updatePlugins.pluginCode = ?)";
	private static final String _FINDER_COLUMN_PLUGINCODEANDVERSION_PLUGINCODE_1 =
		"updatePlugins.pluginCode IS NULL AND ";
	private static final String _FINDER_COLUMN_PLUGINCODEANDVERSION_PLUGINCODE_2 =
		"updatePlugins.pluginCode = ? AND ";
	private static final String _FINDER_COLUMN_PLUGINCODEANDVERSION_PLUGINCODE_3 =
		"(updatePlugins.pluginCode IS NULL OR updatePlugins.pluginCode = ?) AND ";
	private static final String _FINDER_COLUMN_PLUGINCODEANDVERSION_CURRENTVERSION_2 =
		"updatePlugins.currentVersion = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "updatePlugins.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UpdatePlugins exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UpdatePlugins exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UpdatePluginsPersistenceImpl.class);
	private static UpdatePlugins _nullUpdatePlugins = new UpdatePluginsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UpdatePlugins> toCacheModel() {
				return _nullUpdatePluginsCacheModel;
			}
		};

	private static CacheModel<UpdatePlugins> _nullUpdatePluginsCacheModel = new CacheModel<UpdatePlugins>() {
			public UpdatePlugins toEntityModel() {
				return _nullUpdatePlugins;
			}
		};
}