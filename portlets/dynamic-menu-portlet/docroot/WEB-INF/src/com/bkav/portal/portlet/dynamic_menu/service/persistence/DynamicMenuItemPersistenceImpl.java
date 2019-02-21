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

package com.bkav.portal.portlet.dynamic_menu.service.persistence;

import com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException;
import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem;
import com.bkav.portal.portlet.dynamic_menu.model.impl.DynamicMenuItemImpl;
import com.bkav.portal.portlet.dynamic_menu.model.impl.DynamicMenuItemModelImpl;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the dynamic menu item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see DynamicMenuItemPersistence
 * @see DynamicMenuItemUtil
 * @generated
 */
public class DynamicMenuItemPersistenceImpl extends BasePersistenceImpl<DynamicMenuItem>
	implements DynamicMenuItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DynamicMenuItemUtil} to access the dynamic menu item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DynamicMenuItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED,
			DynamicMenuItemImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED,
			DynamicMenuItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			DynamicMenuItemModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MENU = new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED,
			DynamicMenuItemImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMenu",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENU = new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED,
			DynamicMenuItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMenu",
			new String[] { Long.class.getName(), Long.class.getName() },
			DynamicMenuItemModelImpl.GROUPID_COLUMN_BITMASK |
			DynamicMenuItemModelImpl.MENUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MENU = new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMenu",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT = new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED,
			DynamicMenuItemImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParent",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT =
		new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED,
			DynamicMenuItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParent",
			new String[] { Long.class.getName(), Long.class.getName() },
			DynamicMenuItemModelImpl.GROUPID_COLUMN_BITMASK |
			DynamicMenuItemModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENT = new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParent",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_M_P = new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED,
			DynamicMenuItemImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_M_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_M_P = new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED,
			DynamicMenuItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_M_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			DynamicMenuItemModelImpl.GROUPID_COLUMN_BITMASK |
			DynamicMenuItemModelImpl.MENUID_COLUMN_BITMASK |
			DynamicMenuItemModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_M_P = new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_M_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED,
			DynamicMenuItemImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED,
			DynamicMenuItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the dynamic menu item in the entity cache if it is enabled.
	 *
	 * @param dynamicMenuItem the dynamic menu item
	 */
	public void cacheResult(DynamicMenuItem dynamicMenuItem) {
		EntityCacheUtil.putResult(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemImpl.class, dynamicMenuItem.getPrimaryKey(),
			dynamicMenuItem);

		dynamicMenuItem.resetOriginalValues();
	}

	/**
	 * Caches the dynamic menu items in the entity cache if it is enabled.
	 *
	 * @param dynamicMenuItems the dynamic menu items
	 */
	public void cacheResult(List<DynamicMenuItem> dynamicMenuItems) {
		for (DynamicMenuItem dynamicMenuItem : dynamicMenuItems) {
			if (EntityCacheUtil.getResult(
						DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
						DynamicMenuItemImpl.class,
						dynamicMenuItem.getPrimaryKey()) == null) {
				cacheResult(dynamicMenuItem);
			}
			else {
				dynamicMenuItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dynamic menu items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DynamicMenuItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DynamicMenuItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dynamic menu item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DynamicMenuItem dynamicMenuItem) {
		EntityCacheUtil.removeResult(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemImpl.class, dynamicMenuItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DynamicMenuItem> dynamicMenuItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DynamicMenuItem dynamicMenuItem : dynamicMenuItems) {
			EntityCacheUtil.removeResult(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
				DynamicMenuItemImpl.class, dynamicMenuItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dynamic menu item with the primary key. Does not add the dynamic menu item to the database.
	 *
	 * @param itemId the primary key for the new dynamic menu item
	 * @return the new dynamic menu item
	 */
	public DynamicMenuItem create(long itemId) {
		DynamicMenuItem dynamicMenuItem = new DynamicMenuItemImpl();

		dynamicMenuItem.setNew(true);
		dynamicMenuItem.setPrimaryKey(itemId);

		return dynamicMenuItem;
	}

	/**
	 * Removes the dynamic menu item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemId the primary key of the dynamic menu item
	 * @return the dynamic menu item that was removed
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem remove(long itemId)
		throws NoSuchDynamicMenuItemException, SystemException {
		return remove(Long.valueOf(itemId));
	}

	/**
	 * Removes the dynamic menu item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dynamic menu item
	 * @return the dynamic menu item that was removed
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DynamicMenuItem remove(Serializable primaryKey)
		throws NoSuchDynamicMenuItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DynamicMenuItem dynamicMenuItem = (DynamicMenuItem)session.get(DynamicMenuItemImpl.class,
					primaryKey);

			if (dynamicMenuItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDynamicMenuItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dynamicMenuItem);
		}
		catch (NoSuchDynamicMenuItemException nsee) {
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
	protected DynamicMenuItem removeImpl(DynamicMenuItem dynamicMenuItem)
		throws SystemException {
		dynamicMenuItem = toUnwrappedModel(dynamicMenuItem);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, dynamicMenuItem);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(dynamicMenuItem);

		return dynamicMenuItem;
	}

	@Override
	public DynamicMenuItem updateImpl(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem dynamicMenuItem,
		boolean merge) throws SystemException {
		dynamicMenuItem = toUnwrappedModel(dynamicMenuItem);

		boolean isNew = dynamicMenuItem.isNew();

		DynamicMenuItemModelImpl dynamicMenuItemModelImpl = (DynamicMenuItemModelImpl)dynamicMenuItem;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, dynamicMenuItem, merge);

			dynamicMenuItem.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DynamicMenuItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dynamicMenuItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(dynamicMenuItemModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(dynamicMenuItemModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((dynamicMenuItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENU.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(dynamicMenuItemModelImpl.getOriginalGroupId()),
						Long.valueOf(dynamicMenuItemModelImpl.getOriginalMenuId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MENU, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENU,
					args);

				args = new Object[] {
						Long.valueOf(dynamicMenuItemModelImpl.getGroupId()),
						Long.valueOf(dynamicMenuItemModelImpl.getMenuId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MENU, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENU,
					args);
			}

			if ((dynamicMenuItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(dynamicMenuItemModelImpl.getOriginalGroupId()),
						Long.valueOf(dynamicMenuItemModelImpl.getOriginalParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
					args);

				args = new Object[] {
						Long.valueOf(dynamicMenuItemModelImpl.getGroupId()),
						Long.valueOf(dynamicMenuItemModelImpl.getParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
					args);
			}

			if ((dynamicMenuItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_M_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(dynamicMenuItemModelImpl.getOriginalGroupId()),
						Long.valueOf(dynamicMenuItemModelImpl.getOriginalMenuId()),
						Long.valueOf(dynamicMenuItemModelImpl.getOriginalParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_M_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_M_P,
					args);

				args = new Object[] {
						Long.valueOf(dynamicMenuItemModelImpl.getGroupId()),
						Long.valueOf(dynamicMenuItemModelImpl.getMenuId()),
						Long.valueOf(dynamicMenuItemModelImpl.getParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_M_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_M_P,
					args);
			}
		}

		EntityCacheUtil.putResult(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuItemImpl.class, dynamicMenuItem.getPrimaryKey(),
			dynamicMenuItem);

		return dynamicMenuItem;
	}

	protected DynamicMenuItem toUnwrappedModel(DynamicMenuItem dynamicMenuItem) {
		if (dynamicMenuItem instanceof DynamicMenuItemImpl) {
			return dynamicMenuItem;
		}

		DynamicMenuItemImpl dynamicMenuItemImpl = new DynamicMenuItemImpl();

		dynamicMenuItemImpl.setNew(dynamicMenuItem.isNew());
		dynamicMenuItemImpl.setPrimaryKey(dynamicMenuItem.getPrimaryKey());

		dynamicMenuItemImpl.setItemId(dynamicMenuItem.getItemId());
		dynamicMenuItemImpl.setGroupId(dynamicMenuItem.getGroupId());
		dynamicMenuItemImpl.setCompanyId(dynamicMenuItem.getCompanyId());
		dynamicMenuItemImpl.setUserId(dynamicMenuItem.getUserId());
		dynamicMenuItemImpl.setUserName(dynamicMenuItem.getUserName());
		dynamicMenuItemImpl.setCreateDate(dynamicMenuItem.getCreateDate());
		dynamicMenuItemImpl.setModifiedDate(dynamicMenuItem.getModifiedDate());
		dynamicMenuItemImpl.setMenuId(dynamicMenuItem.getMenuId());
		dynamicMenuItemImpl.setParentId(dynamicMenuItem.getParentId());
		dynamicMenuItemImpl.setName(dynamicMenuItem.getName());
		dynamicMenuItemImpl.setUrl(dynamicMenuItem.getUrl());
		dynamicMenuItemImpl.setUrlType(dynamicMenuItem.getUrlType());
		dynamicMenuItemImpl.setPosition(dynamicMenuItem.getPosition());

		return dynamicMenuItemImpl;
	}

	/**
	 * Returns the dynamic menu item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dynamic menu item
	 * @return the dynamic menu item
	 * @throws com.liferay.portal.NoSuchModelException if a dynamic menu item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DynamicMenuItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the dynamic menu item with the primary key or throws a {@link com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException} if it could not be found.
	 *
	 * @param itemId the primary key of the dynamic menu item
	 * @return the dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem findByPrimaryKey(long itemId)
		throws NoSuchDynamicMenuItemException, SystemException {
		DynamicMenuItem dynamicMenuItem = fetchByPrimaryKey(itemId);

		if (dynamicMenuItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + itemId);
			}

			throw new NoSuchDynamicMenuItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				itemId);
		}

		return dynamicMenuItem;
	}

	/**
	 * Returns the dynamic menu item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dynamic menu item
	 * @return the dynamic menu item, or <code>null</code> if a dynamic menu item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DynamicMenuItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the dynamic menu item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemId the primary key of the dynamic menu item
	 * @return the dynamic menu item, or <code>null</code> if a dynamic menu item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem fetchByPrimaryKey(long itemId)
		throws SystemException {
		DynamicMenuItem dynamicMenuItem = (DynamicMenuItem)EntityCacheUtil.getResult(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
				DynamicMenuItemImpl.class, itemId);

		if (dynamicMenuItem == _nullDynamicMenuItem) {
			return null;
		}

		if (dynamicMenuItem == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				dynamicMenuItem = (DynamicMenuItem)session.get(DynamicMenuItemImpl.class,
						Long.valueOf(itemId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (dynamicMenuItem != null) {
					cacheResult(dynamicMenuItem);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DynamicMenuItemModelImpl.ENTITY_CACHE_ENABLED,
						DynamicMenuItemImpl.class, itemId, _nullDynamicMenuItem);
				}

				closeSession(session);
			}
		}

		return dynamicMenuItem;
	}

	/**
	 * Returns all the dynamic menu items where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dynamic menu items where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @return the range of matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dynamic menu items where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findByGroup(long groupId, int start, int end,
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

		List<DynamicMenuItem> list = (List<DynamicMenuItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DynamicMenuItem dynamicMenuItem : list) {
				if ((groupId != dynamicMenuItem.getGroupId())) {
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

			query.append(_SQL_SELECT_DYNAMICMENUITEM_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<DynamicMenuItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dynamic menu item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		DynamicMenuItem dynamicMenuItem = fetchByGroup_First(groupId,
				orderByComparator);

		if (dynamicMenuItem != null) {
			return dynamicMenuItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDynamicMenuItemException(msg.toString());
	}

	/**
	 * Returns the first dynamic menu item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DynamicMenuItem> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dynamic menu item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		DynamicMenuItem dynamicMenuItem = fetchByGroup_Last(groupId,
				orderByComparator);

		if (dynamicMenuItem != null) {
			return dynamicMenuItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDynamicMenuItemException(msg.toString());
	}

	/**
	 * Returns the last dynamic menu item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<DynamicMenuItem> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dynamic menu items before and after the current dynamic menu item in the ordered set where groupId = &#63;.
	 *
	 * @param itemId the primary key of the current dynamic menu item
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem[] findByGroup_PrevAndNext(long itemId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		DynamicMenuItem dynamicMenuItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			DynamicMenuItem[] array = new DynamicMenuItemImpl[3];

			array[0] = getByGroup_PrevAndNext(session, dynamicMenuItem,
					groupId, orderByComparator, true);

			array[1] = dynamicMenuItem;

			array[2] = getByGroup_PrevAndNext(session, dynamicMenuItem,
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

	protected DynamicMenuItem getByGroup_PrevAndNext(Session session,
		DynamicMenuItem dynamicMenuItem, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DYNAMICMENUITEM_WHERE);

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
			query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dynamicMenuItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DynamicMenuItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dynamic menu items that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dynamic menu items that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @return the range of matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dynamic menu items that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DynamicMenuItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenuItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, DynamicMenuItemImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, DynamicMenuItemImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<DynamicMenuItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the dynamic menu items before and after the current dynamic menu item in the ordered set of dynamic menu items that the user has permission to view where groupId = &#63;.
	 *
	 * @param itemId the primary key of the current dynamic menu item
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem[] filterFindByGroup_PrevAndNext(long itemId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(itemId, groupId, orderByComparator);
		}

		DynamicMenuItem dynamicMenuItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			DynamicMenuItem[] array = new DynamicMenuItemImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, dynamicMenuItem,
					groupId, orderByComparator, true);

			array[1] = dynamicMenuItem;

			array[2] = filterGetByGroup_PrevAndNext(session, dynamicMenuItem,
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

	protected DynamicMenuItem filterGetByGroup_PrevAndNext(Session session,
		DynamicMenuItem dynamicMenuItem, long groupId,
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
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DynamicMenuItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenuItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, DynamicMenuItemImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, DynamicMenuItemImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dynamicMenuItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DynamicMenuItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dynamic menu items where groupId = &#63; and menuId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @return the matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findByMenu(long groupId, long menuId)
		throws SystemException {
		return findByMenu(groupId, menuId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dynamic menu items where groupId = &#63; and menuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @return the range of matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findByMenu(long groupId, long menuId,
		int start, int end) throws SystemException {
		return findByMenu(groupId, menuId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dynamic menu items where groupId = &#63; and menuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findByMenu(long groupId, long menuId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENU;
			finderArgs = new Object[] { groupId, menuId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MENU;
			finderArgs = new Object[] {
					groupId, menuId,
					
					start, end, orderByComparator
				};
		}

		List<DynamicMenuItem> list = (List<DynamicMenuItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DynamicMenuItem dynamicMenuItem : list) {
				if ((groupId != dynamicMenuItem.getGroupId()) ||
						(menuId != dynamicMenuItem.getMenuId())) {
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

			query.append(_SQL_SELECT_DYNAMICMENUITEM_WHERE);

			query.append(_FINDER_COLUMN_MENU_GROUPID_2);

			query.append(_FINDER_COLUMN_MENU_MENUID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(menuId);

				list = (List<DynamicMenuItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem findByMenu_First(long groupId, long menuId,
		OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		DynamicMenuItem dynamicMenuItem = fetchByMenu_First(groupId, menuId,
				orderByComparator);

		if (dynamicMenuItem != null) {
			return dynamicMenuItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", menuId=");
		msg.append(menuId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDynamicMenuItemException(msg.toString());
	}

	/**
	 * Returns the first dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem fetchByMenu_First(long groupId, long menuId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DynamicMenuItem> list = findByMenu(groupId, menuId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem findByMenu_Last(long groupId, long menuId,
		OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		DynamicMenuItem dynamicMenuItem = fetchByMenu_Last(groupId, menuId,
				orderByComparator);

		if (dynamicMenuItem != null) {
			return dynamicMenuItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", menuId=");
		msg.append(menuId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDynamicMenuItemException(msg.toString());
	}

	/**
	 * Returns the last dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem fetchByMenu_Last(long groupId, long menuId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMenu(groupId, menuId);

		List<DynamicMenuItem> list = findByMenu(groupId, menuId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dynamic menu items before and after the current dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63;.
	 *
	 * @param itemId the primary key of the current dynamic menu item
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem[] findByMenu_PrevAndNext(long itemId, long groupId,
		long menuId, OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		DynamicMenuItem dynamicMenuItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			DynamicMenuItem[] array = new DynamicMenuItemImpl[3];

			array[0] = getByMenu_PrevAndNext(session, dynamicMenuItem, groupId,
					menuId, orderByComparator, true);

			array[1] = dynamicMenuItem;

			array[2] = getByMenu_PrevAndNext(session, dynamicMenuItem, groupId,
					menuId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DynamicMenuItem getByMenu_PrevAndNext(Session session,
		DynamicMenuItem dynamicMenuItem, long groupId, long menuId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DYNAMICMENUITEM_WHERE);

		query.append(_FINDER_COLUMN_MENU_GROUPID_2);

		query.append(_FINDER_COLUMN_MENU_MENUID_2);

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
			query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(menuId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dynamicMenuItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DynamicMenuItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @return the matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> filterFindByMenu(long groupId, long menuId)
		throws SystemException {
		return filterFindByMenu(groupId, menuId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @return the range of matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> filterFindByMenu(long groupId, long menuId,
		int start, int end) throws SystemException {
		return filterFindByMenu(groupId, menuId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dynamic menu items that the user has permissions to view where groupId = &#63; and menuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> filterFindByMenu(long groupId, long menuId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByMenu(groupId, menuId, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_MENU_GROUPID_2);

		query.append(_FINDER_COLUMN_MENU_MENUID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DynamicMenuItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenuItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, DynamicMenuItemImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, DynamicMenuItemImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(menuId);

			return (List<DynamicMenuItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the dynamic menu items before and after the current dynamic menu item in the ordered set of dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63;.
	 *
	 * @param itemId the primary key of the current dynamic menu item
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem[] filterFindByMenu_PrevAndNext(long itemId,
		long groupId, long menuId, OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByMenu_PrevAndNext(itemId, groupId, menuId,
				orderByComparator);
		}

		DynamicMenuItem dynamicMenuItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			DynamicMenuItem[] array = new DynamicMenuItemImpl[3];

			array[0] = filterGetByMenu_PrevAndNext(session, dynamicMenuItem,
					groupId, menuId, orderByComparator, true);

			array[1] = dynamicMenuItem;

			array[2] = filterGetByMenu_PrevAndNext(session, dynamicMenuItem,
					groupId, menuId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DynamicMenuItem filterGetByMenu_PrevAndNext(Session session,
		DynamicMenuItem dynamicMenuItem, long groupId, long menuId,
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
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_MENU_GROUPID_2);

		query.append(_FINDER_COLUMN_MENU_MENUID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DynamicMenuItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenuItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, DynamicMenuItemImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, DynamicMenuItemImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(menuId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dynamicMenuItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DynamicMenuItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dynamic menu items where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findByParent(long groupId, long parentId)
		throws SystemException {
		return findByParent(groupId, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dynamic menu items where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @return the range of matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findByParent(long groupId, long parentId,
		int start, int end) throws SystemException {
		return findByParent(groupId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dynamic menu items where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findByParent(long groupId, long parentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT;
			finderArgs = new Object[] { groupId, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT;
			finderArgs = new Object[] {
					groupId, parentId,
					
					start, end, orderByComparator
				};
		}

		List<DynamicMenuItem> list = (List<DynamicMenuItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DynamicMenuItem dynamicMenuItem : list) {
				if ((groupId != dynamicMenuItem.getGroupId()) ||
						(parentId != dynamicMenuItem.getParentId())) {
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

			query.append(_SQL_SELECT_DYNAMICMENUITEM_WHERE);

			query.append(_FINDER_COLUMN_PARENT_GROUPID_2);

			query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parentId);

				list = (List<DynamicMenuItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dynamic menu item in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem findByParent_First(long groupId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		DynamicMenuItem dynamicMenuItem = fetchByParent_First(groupId,
				parentId, orderByComparator);

		if (dynamicMenuItem != null) {
			return dynamicMenuItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDynamicMenuItemException(msg.toString());
	}

	/**
	 * Returns the first dynamic menu item in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem fetchByParent_First(long groupId, long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DynamicMenuItem> list = findByParent(groupId, parentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dynamic menu item in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem findByParent_Last(long groupId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		DynamicMenuItem dynamicMenuItem = fetchByParent_Last(groupId, parentId,
				orderByComparator);

		if (dynamicMenuItem != null) {
			return dynamicMenuItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDynamicMenuItemException(msg.toString());
	}

	/**
	 * Returns the last dynamic menu item in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem fetchByParent_Last(long groupId, long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParent(groupId, parentId);

		List<DynamicMenuItem> list = findByParent(groupId, parentId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dynamic menu items before and after the current dynamic menu item in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param itemId the primary key of the current dynamic menu item
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem[] findByParent_PrevAndNext(long itemId,
		long groupId, long parentId, OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		DynamicMenuItem dynamicMenuItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			DynamicMenuItem[] array = new DynamicMenuItemImpl[3];

			array[0] = getByParent_PrevAndNext(session, dynamicMenuItem,
					groupId, parentId, orderByComparator, true);

			array[1] = dynamicMenuItem;

			array[2] = getByParent_PrevAndNext(session, dynamicMenuItem,
					groupId, parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DynamicMenuItem getByParent_PrevAndNext(Session session,
		DynamicMenuItem dynamicMenuItem, long groupId, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DYNAMICMENUITEM_WHERE);

		query.append(_FINDER_COLUMN_PARENT_GROUPID_2);

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
			query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dynamicMenuItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DynamicMenuItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dynamic menu items that the user has permission to view where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> filterFindByParent(long groupId, long parentId)
		throws SystemException {
		return filterFindByParent(groupId, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dynamic menu items that the user has permission to view where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @return the range of matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> filterFindByParent(long groupId,
		long parentId, int start, int end) throws SystemException {
		return filterFindByParent(groupId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dynamic menu items that the user has permissions to view where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> filterFindByParent(long groupId,
		long parentId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParent(groupId, parentId, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENT_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DynamicMenuItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenuItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, DynamicMenuItemImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, DynamicMenuItemImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(parentId);

			return (List<DynamicMenuItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the dynamic menu items before and after the current dynamic menu item in the ordered set of dynamic menu items that the user has permission to view where groupId = &#63; and parentId = &#63;.
	 *
	 * @param itemId the primary key of the current dynamic menu item
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem[] filterFindByParent_PrevAndNext(long itemId,
		long groupId, long parentId, OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByParent_PrevAndNext(itemId, groupId, parentId,
				orderByComparator);
		}

		DynamicMenuItem dynamicMenuItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			DynamicMenuItem[] array = new DynamicMenuItemImpl[3];

			array[0] = filterGetByParent_PrevAndNext(session, dynamicMenuItem,
					groupId, parentId, orderByComparator, true);

			array[1] = dynamicMenuItem;

			array[2] = filterGetByParent_PrevAndNext(session, dynamicMenuItem,
					groupId, parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DynamicMenuItem filterGetByParent_PrevAndNext(Session session,
		DynamicMenuItem dynamicMenuItem, long groupId, long parentId,
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
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_PARENT_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DynamicMenuItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenuItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, DynamicMenuItemImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, DynamicMenuItemImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dynamicMenuItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DynamicMenuItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dynamic menu items where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @return the matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findByG_M_P(long groupId, long menuId,
		long parentId) throws SystemException {
		return findByG_M_P(groupId, menuId, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dynamic menu items where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @return the range of matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findByG_M_P(long groupId, long menuId,
		long parentId, int start, int end) throws SystemException {
		return findByG_M_P(groupId, menuId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dynamic menu items where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findByG_M_P(long groupId, long menuId,
		long parentId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_M_P;
			finderArgs = new Object[] { groupId, menuId, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_M_P;
			finderArgs = new Object[] {
					groupId, menuId, parentId,
					
					start, end, orderByComparator
				};
		}

		List<DynamicMenuItem> list = (List<DynamicMenuItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DynamicMenuItem dynamicMenuItem : list) {
				if ((groupId != dynamicMenuItem.getGroupId()) ||
						(menuId != dynamicMenuItem.getMenuId()) ||
						(parentId != dynamicMenuItem.getParentId())) {
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

			query.append(_SQL_SELECT_DYNAMICMENUITEM_WHERE);

			query.append(_FINDER_COLUMN_G_M_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_M_P_MENUID_2);

			query.append(_FINDER_COLUMN_G_M_P_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(menuId);

				qPos.add(parentId);

				list = (List<DynamicMenuItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem findByG_M_P_First(long groupId, long menuId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		DynamicMenuItem dynamicMenuItem = fetchByG_M_P_First(groupId, menuId,
				parentId, orderByComparator);

		if (dynamicMenuItem != null) {
			return dynamicMenuItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", menuId=");
		msg.append(menuId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDynamicMenuItemException(msg.toString());
	}

	/**
	 * Returns the first dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem fetchByG_M_P_First(long groupId, long menuId,
		long parentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<DynamicMenuItem> list = findByG_M_P(groupId, menuId, parentId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem findByG_M_P_Last(long groupId, long menuId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		DynamicMenuItem dynamicMenuItem = fetchByG_M_P_Last(groupId, menuId,
				parentId, orderByComparator);

		if (dynamicMenuItem != null) {
			return dynamicMenuItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", menuId=");
		msg.append(menuId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDynamicMenuItemException(msg.toString());
	}

	/**
	 * Returns the last dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem fetchByG_M_P_Last(long groupId, long menuId,
		long parentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_M_P(groupId, menuId, parentId);

		List<DynamicMenuItem> list = findByG_M_P(groupId, menuId, parentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dynamic menu items before and after the current dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	 *
	 * @param itemId the primary key of the current dynamic menu item
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem[] findByG_M_P_PrevAndNext(long itemId, long groupId,
		long menuId, long parentId, OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		DynamicMenuItem dynamicMenuItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			DynamicMenuItem[] array = new DynamicMenuItemImpl[3];

			array[0] = getByG_M_P_PrevAndNext(session, dynamicMenuItem,
					groupId, menuId, parentId, orderByComparator, true);

			array[1] = dynamicMenuItem;

			array[2] = getByG_M_P_PrevAndNext(session, dynamicMenuItem,
					groupId, menuId, parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DynamicMenuItem getByG_M_P_PrevAndNext(Session session,
		DynamicMenuItem dynamicMenuItem, long groupId, long menuId,
		long parentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DYNAMICMENUITEM_WHERE);

		query.append(_FINDER_COLUMN_G_M_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_M_P_MENUID_2);

		query.append(_FINDER_COLUMN_G_M_P_PARENTID_2);

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
			query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(menuId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dynamicMenuItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DynamicMenuItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @return the matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> filterFindByG_M_P(long groupId, long menuId,
		long parentId) throws SystemException {
		return filterFindByG_M_P(groupId, menuId, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @return the range of matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> filterFindByG_M_P(long groupId, long menuId,
		long parentId, int start, int end) throws SystemException {
		return filterFindByG_M_P(groupId, menuId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dynamic menu items that the user has permissions to view where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> filterFindByG_M_P(long groupId, long menuId,
		long parentId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_M_P(groupId, menuId, parentId, start, end,
				orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_M_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_M_P_MENUID_2);

		query.append(_FINDER_COLUMN_G_M_P_PARENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DynamicMenuItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenuItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, DynamicMenuItemImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, DynamicMenuItemImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(menuId);

			qPos.add(parentId);

			return (List<DynamicMenuItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the dynamic menu items before and after the current dynamic menu item in the ordered set of dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	 *
	 * @param itemId the primary key of the current dynamic menu item
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dynamic menu item
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenuItem[] filterFindByG_M_P_PrevAndNext(long itemId,
		long groupId, long menuId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuItemException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_M_P_PrevAndNext(itemId, groupId, menuId, parentId,
				orderByComparator);
		}

		DynamicMenuItem dynamicMenuItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			DynamicMenuItem[] array = new DynamicMenuItemImpl[3];

			array[0] = filterGetByG_M_P_PrevAndNext(session, dynamicMenuItem,
					groupId, menuId, parentId, orderByComparator, true);

			array[1] = dynamicMenuItem;

			array[2] = filterGetByG_M_P_PrevAndNext(session, dynamicMenuItem,
					groupId, menuId, parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DynamicMenuItem filterGetByG_M_P_PrevAndNext(Session session,
		DynamicMenuItem dynamicMenuItem, long groupId, long menuId,
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
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_M_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_M_P_MENUID_2);

		query.append(_FINDER_COLUMN_G_M_P_PARENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DynamicMenuItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenuItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, DynamicMenuItemImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, DynamicMenuItemImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(menuId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dynamicMenuItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DynamicMenuItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dynamic menu items.
	 *
	 * @return the dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dynamic menu items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @return the range of dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dynamic menu items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of dynamic menu items
	 * @param end the upper bound of the range of dynamic menu items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenuItem> findAll(int start, int end,
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

		List<DynamicMenuItem> list = (List<DynamicMenuItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DYNAMICMENUITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DYNAMICMENUITEM.concat(DynamicMenuItemModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DynamicMenuItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DynamicMenuItem>)QueryUtil.list(q,
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
	 * Removes all the dynamic menu items where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (DynamicMenuItem dynamicMenuItem : findByGroup(groupId)) {
			remove(dynamicMenuItem);
		}
	}

	/**
	 * Removes all the dynamic menu items where groupId = &#63; and menuId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMenu(long groupId, long menuId)
		throws SystemException {
		for (DynamicMenuItem dynamicMenuItem : findByMenu(groupId, menuId)) {
			remove(dynamicMenuItem);
		}
	}

	/**
	 * Removes all the dynamic menu items where groupId = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParent(long groupId, long parentId)
		throws SystemException {
		for (DynamicMenuItem dynamicMenuItem : findByParent(groupId, parentId)) {
			remove(dynamicMenuItem);
		}
	}

	/**
	 * Removes all the dynamic menu items where groupId = &#63; and menuId = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_M_P(long groupId, long menuId, long parentId)
		throws SystemException {
		for (DynamicMenuItem dynamicMenuItem : findByG_M_P(groupId, menuId,
				parentId)) {
			remove(dynamicMenuItem);
		}
	}

	/**
	 * Removes all the dynamic menu items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DynamicMenuItem dynamicMenuItem : findAll()) {
			remove(dynamicMenuItem);
		}
	}

	/**
	 * Returns the number of dynamic menu items where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DYNAMICMENUITEM_WHERE);

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
	 * Returns the number of dynamic menu items that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_DYNAMICMENUITEM_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenuItem.class.getName(),
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
	 * Returns the number of dynamic menu items where groupId = &#63; and menuId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @return the number of matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMenu(long groupId, long menuId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, menuId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MENU,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DYNAMICMENUITEM_WHERE);

			query.append(_FINDER_COLUMN_MENU_GROUPID_2);

			query.append(_FINDER_COLUMN_MENU_MENUID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(menuId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MENU,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @return the number of matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByMenu(long groupId, long menuId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByMenu(groupId, menuId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_DYNAMICMENUITEM_WHERE);

		query.append(_FINDER_COLUMN_MENU_GROUPID_2);

		query.append(_FINDER_COLUMN_MENU_MENUID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenuItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(menuId);

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
	 * Returns the number of dynamic menu items where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the number of matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParent(long groupId, long parentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, parentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DYNAMICMENUITEM_WHERE);

			query.append(_FINDER_COLUMN_PARENT_GROUPID_2);

			query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of dynamic menu items that the user has permission to view where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the number of matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByParent(long groupId, long parentId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByParent(groupId, parentId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_DYNAMICMENUITEM_WHERE);

		query.append(_FINDER_COLUMN_PARENT_GROUPID_2);

		query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenuItem.class.getName(),
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
	 * Returns the number of dynamic menu items where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @return the number of matching dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_M_P(long groupId, long menuId, long parentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, menuId, parentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_M_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_DYNAMICMENUITEM_WHERE);

			query.append(_FINDER_COLUMN_G_M_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_M_P_MENUID_2);

			query.append(_FINDER_COLUMN_G_M_P_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(menuId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_M_P,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param menuId the menu ID
	 * @param parentId the parent ID
	 * @return the number of matching dynamic menu items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_M_P(long groupId, long menuId, long parentId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_M_P(groupId, menuId, parentId);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_DYNAMICMENUITEM_WHERE);

		query.append(_FINDER_COLUMN_G_M_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_M_P_MENUID_2);

		query.append(_FINDER_COLUMN_G_M_P_PARENTID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenuItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(menuId);

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
	 * Returns the number of dynamic menu items.
	 *
	 * @return the number of dynamic menu items
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DYNAMICMENUITEM);

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
	 * Initializes the dynamic menu item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DynamicMenuItem>> listenersList = new ArrayList<ModelListener<DynamicMenuItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DynamicMenuItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DynamicMenuItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DynamicMenuPersistence.class)
	protected DynamicMenuPersistence dynamicMenuPersistence;
	@BeanReference(type = DynamicMenuItemPersistence.class)
	protected DynamicMenuItemPersistence dynamicMenuItemPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_DYNAMICMENUITEM = "SELECT dynamicMenuItem FROM DynamicMenuItem dynamicMenuItem";
	private static final String _SQL_SELECT_DYNAMICMENUITEM_WHERE = "SELECT dynamicMenuItem FROM DynamicMenuItem dynamicMenuItem WHERE ";
	private static final String _SQL_COUNT_DYNAMICMENUITEM = "SELECT COUNT(dynamicMenuItem) FROM DynamicMenuItem dynamicMenuItem";
	private static final String _SQL_COUNT_DYNAMICMENUITEM_WHERE = "SELECT COUNT(dynamicMenuItem) FROM DynamicMenuItem dynamicMenuItem WHERE ";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "dynamicMenuItem.groupId = ?";
	private static final String _FINDER_COLUMN_MENU_GROUPID_2 = "dynamicMenuItem.groupId = ? AND ";
	private static final String _FINDER_COLUMN_MENU_MENUID_2 = "dynamicMenuItem.menuId = ?";
	private static final String _FINDER_COLUMN_PARENT_GROUPID_2 = "dynamicMenuItem.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PARENT_PARENTID_2 = "dynamicMenuItem.parentId = ?";
	private static final String _FINDER_COLUMN_G_M_P_GROUPID_2 = "dynamicMenuItem.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_M_P_MENUID_2 = "dynamicMenuItem.menuId = ? AND ";
	private static final String _FINDER_COLUMN_G_M_P_PARENTID_2 = "dynamicMenuItem.parentId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "dynamicMenuItem.itemId";
	private static final String _FILTER_SQL_SELECT_DYNAMICMENUITEM_WHERE = "SELECT DISTINCT {dynamicMenuItem.*} FROM DynamicMenuItem dynamicMenuItem WHERE ";
	private static final String _FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {DynamicMenuItem.*} FROM (SELECT DISTINCT dynamicMenuItem.itemId FROM DynamicMenuItem dynamicMenuItem WHERE ";
	private static final String _FILTER_SQL_SELECT_DYNAMICMENUITEM_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN DynamicMenuItem ON TEMP_TABLE.itemId = DynamicMenuItem.itemId";
	private static final String _FILTER_SQL_COUNT_DYNAMICMENUITEM_WHERE = "SELECT COUNT(DISTINCT dynamicMenuItem.itemId) AS COUNT_VALUE FROM DynamicMenuItem dynamicMenuItem WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "dynamicMenuItem";
	private static final String _FILTER_ENTITY_TABLE = "DynamicMenuItem";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dynamicMenuItem.";
	private static final String _ORDER_BY_ENTITY_TABLE = "DynamicMenuItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DynamicMenuItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DynamicMenuItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DynamicMenuItemPersistenceImpl.class);
	private static DynamicMenuItem _nullDynamicMenuItem = new DynamicMenuItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DynamicMenuItem> toCacheModel() {
				return _nullDynamicMenuItemCacheModel;
			}
		};

	private static CacheModel<DynamicMenuItem> _nullDynamicMenuItemCacheModel = new CacheModel<DynamicMenuItem>() {
			public DynamicMenuItem toEntityModel() {
				return _nullDynamicMenuItem;
			}
		};
}