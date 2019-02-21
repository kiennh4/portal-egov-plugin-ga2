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

import com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException;
import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu;
import com.bkav.portal.portlet.dynamic_menu.model.impl.DynamicMenuImpl;
import com.bkav.portal.portlet.dynamic_menu.model.impl.DynamicMenuModelImpl;

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
 * The persistence implementation for the dynamic menu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see DynamicMenuPersistence
 * @see DynamicMenuUtil
 * @generated
 */
public class DynamicMenuPersistenceImpl extends BasePersistenceImpl<DynamicMenu>
	implements DynamicMenuPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DynamicMenuUtil} to access the dynamic menu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DynamicMenuImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(DynamicMenuModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuModelImpl.FINDER_CACHE_ENABLED, DynamicMenuImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(DynamicMenuModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuModelImpl.FINDER_CACHE_ENABLED, DynamicMenuImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			DynamicMenuModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(DynamicMenuModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DynamicMenuModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuModelImpl.FINDER_CACHE_ENABLED, DynamicMenuImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DynamicMenuModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuModelImpl.FINDER_CACHE_ENABLED, DynamicMenuImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DynamicMenuModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the dynamic menu in the entity cache if it is enabled.
	 *
	 * @param dynamicMenu the dynamic menu
	 */
	public void cacheResult(DynamicMenu dynamicMenu) {
		EntityCacheUtil.putResult(DynamicMenuModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuImpl.class, dynamicMenu.getPrimaryKey(), dynamicMenu);

		dynamicMenu.resetOriginalValues();
	}

	/**
	 * Caches the dynamic menus in the entity cache if it is enabled.
	 *
	 * @param dynamicMenus the dynamic menus
	 */
	public void cacheResult(List<DynamicMenu> dynamicMenus) {
		for (DynamicMenu dynamicMenu : dynamicMenus) {
			if (EntityCacheUtil.getResult(
						DynamicMenuModelImpl.ENTITY_CACHE_ENABLED,
						DynamicMenuImpl.class, dynamicMenu.getPrimaryKey()) == null) {
				cacheResult(dynamicMenu);
			}
			else {
				dynamicMenu.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dynamic menus.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DynamicMenuImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DynamicMenuImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dynamic menu.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DynamicMenu dynamicMenu) {
		EntityCacheUtil.removeResult(DynamicMenuModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuImpl.class, dynamicMenu.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DynamicMenu> dynamicMenus) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DynamicMenu dynamicMenu : dynamicMenus) {
			EntityCacheUtil.removeResult(DynamicMenuModelImpl.ENTITY_CACHE_ENABLED,
				DynamicMenuImpl.class, dynamicMenu.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dynamic menu with the primary key. Does not add the dynamic menu to the database.
	 *
	 * @param menuId the primary key for the new dynamic menu
	 * @return the new dynamic menu
	 */
	public DynamicMenu create(long menuId) {
		DynamicMenu dynamicMenu = new DynamicMenuImpl();

		dynamicMenu.setNew(true);
		dynamicMenu.setPrimaryKey(menuId);

		return dynamicMenu;
	}

	/**
	 * Removes the dynamic menu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param menuId the primary key of the dynamic menu
	 * @return the dynamic menu that was removed
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a dynamic menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenu remove(long menuId)
		throws NoSuchDynamicMenuException, SystemException {
		return remove(Long.valueOf(menuId));
	}

	/**
	 * Removes the dynamic menu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dynamic menu
	 * @return the dynamic menu that was removed
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a dynamic menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DynamicMenu remove(Serializable primaryKey)
		throws NoSuchDynamicMenuException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DynamicMenu dynamicMenu = (DynamicMenu)session.get(DynamicMenuImpl.class,
					primaryKey);

			if (dynamicMenu == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDynamicMenuException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dynamicMenu);
		}
		catch (NoSuchDynamicMenuException nsee) {
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
	protected DynamicMenu removeImpl(DynamicMenu dynamicMenu)
		throws SystemException {
		dynamicMenu = toUnwrappedModel(dynamicMenu);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, dynamicMenu);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(dynamicMenu);

		return dynamicMenu;
	}

	@Override
	public DynamicMenu updateImpl(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu dynamicMenu,
		boolean merge) throws SystemException {
		dynamicMenu = toUnwrappedModel(dynamicMenu);

		boolean isNew = dynamicMenu.isNew();

		DynamicMenuModelImpl dynamicMenuModelImpl = (DynamicMenuModelImpl)dynamicMenu;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, dynamicMenu, merge);

			dynamicMenu.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DynamicMenuModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dynamicMenuModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(dynamicMenuModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(dynamicMenuModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(DynamicMenuModelImpl.ENTITY_CACHE_ENABLED,
			DynamicMenuImpl.class, dynamicMenu.getPrimaryKey(), dynamicMenu);

		return dynamicMenu;
	}

	protected DynamicMenu toUnwrappedModel(DynamicMenu dynamicMenu) {
		if (dynamicMenu instanceof DynamicMenuImpl) {
			return dynamicMenu;
		}

		DynamicMenuImpl dynamicMenuImpl = new DynamicMenuImpl();

		dynamicMenuImpl.setNew(dynamicMenu.isNew());
		dynamicMenuImpl.setPrimaryKey(dynamicMenu.getPrimaryKey());

		dynamicMenuImpl.setMenuId(dynamicMenu.getMenuId());
		dynamicMenuImpl.setGroupId(dynamicMenu.getGroupId());
		dynamicMenuImpl.setCompanyId(dynamicMenu.getCompanyId());
		dynamicMenuImpl.setUserId(dynamicMenu.getUserId());
		dynamicMenuImpl.setUserName(dynamicMenu.getUserName());
		dynamicMenuImpl.setCreateDate(dynamicMenu.getCreateDate());
		dynamicMenuImpl.setModifiedDate(dynamicMenu.getModifiedDate());
		dynamicMenuImpl.setName(dynamicMenu.getName());
		dynamicMenuImpl.setDescription(dynamicMenu.getDescription());
		dynamicMenuImpl.setItemCount(dynamicMenu.getItemCount());

		return dynamicMenuImpl;
	}

	/**
	 * Returns the dynamic menu with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dynamic menu
	 * @return the dynamic menu
	 * @throws com.liferay.portal.NoSuchModelException if a dynamic menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DynamicMenu findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the dynamic menu with the primary key or throws a {@link com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException} if it could not be found.
	 *
	 * @param menuId the primary key of the dynamic menu
	 * @return the dynamic menu
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a dynamic menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenu findByPrimaryKey(long menuId)
		throws NoSuchDynamicMenuException, SystemException {
		DynamicMenu dynamicMenu = fetchByPrimaryKey(menuId);

		if (dynamicMenu == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + menuId);
			}

			throw new NoSuchDynamicMenuException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				menuId);
		}

		return dynamicMenu;
	}

	/**
	 * Returns the dynamic menu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dynamic menu
	 * @return the dynamic menu, or <code>null</code> if a dynamic menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DynamicMenu fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the dynamic menu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param menuId the primary key of the dynamic menu
	 * @return the dynamic menu, or <code>null</code> if a dynamic menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenu fetchByPrimaryKey(long menuId) throws SystemException {
		DynamicMenu dynamicMenu = (DynamicMenu)EntityCacheUtil.getResult(DynamicMenuModelImpl.ENTITY_CACHE_ENABLED,
				DynamicMenuImpl.class, menuId);

		if (dynamicMenu == _nullDynamicMenu) {
			return null;
		}

		if (dynamicMenu == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				dynamicMenu = (DynamicMenu)session.get(DynamicMenuImpl.class,
						Long.valueOf(menuId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (dynamicMenu != null) {
					cacheResult(dynamicMenu);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DynamicMenuModelImpl.ENTITY_CACHE_ENABLED,
						DynamicMenuImpl.class, menuId, _nullDynamicMenu);
				}

				closeSession(session);
			}
		}

		return dynamicMenu;
	}

	/**
	 * Returns all the dynamic menus where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dynamic menus
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenu> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dynamic menus where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dynamic menus
	 * @param end the upper bound of the range of dynamic menus (not inclusive)
	 * @return the range of matching dynamic menus
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenu> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dynamic menus where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dynamic menus
	 * @param end the upper bound of the range of dynamic menus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dynamic menus
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenu> findByGroup(long groupId, int start, int end,
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

		List<DynamicMenu> list = (List<DynamicMenu>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DynamicMenu dynamicMenu : list) {
				if ((groupId != dynamicMenu.getGroupId())) {
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

			query.append(_SQL_SELECT_DYNAMICMENU_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DynamicMenuModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<DynamicMenu>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dynamic menu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dynamic menu
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a matching dynamic menu could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenu findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuException, SystemException {
		DynamicMenu dynamicMenu = fetchByGroup_First(groupId, orderByComparator);

		if (dynamicMenu != null) {
			return dynamicMenu;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDynamicMenuException(msg.toString());
	}

	/**
	 * Returns the first dynamic menu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dynamic menu, or <code>null</code> if a matching dynamic menu could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenu fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DynamicMenu> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dynamic menu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dynamic menu
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a matching dynamic menu could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenu findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuException, SystemException {
		DynamicMenu dynamicMenu = fetchByGroup_Last(groupId, orderByComparator);

		if (dynamicMenu != null) {
			return dynamicMenu;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDynamicMenuException(msg.toString());
	}

	/**
	 * Returns the last dynamic menu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dynamic menu, or <code>null</code> if a matching dynamic menu could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenu fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<DynamicMenu> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dynamic menus before and after the current dynamic menu in the ordered set where groupId = &#63;.
	 *
	 * @param menuId the primary key of the current dynamic menu
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dynamic menu
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a dynamic menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenu[] findByGroup_PrevAndNext(long menuId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuException, SystemException {
		DynamicMenu dynamicMenu = findByPrimaryKey(menuId);

		Session session = null;

		try {
			session = openSession();

			DynamicMenu[] array = new DynamicMenuImpl[3];

			array[0] = getByGroup_PrevAndNext(session, dynamicMenu, groupId,
					orderByComparator, true);

			array[1] = dynamicMenu;

			array[2] = getByGroup_PrevAndNext(session, dynamicMenu, groupId,
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

	protected DynamicMenu getByGroup_PrevAndNext(Session session,
		DynamicMenu dynamicMenu, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DYNAMICMENU_WHERE);

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
			query.append(DynamicMenuModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dynamicMenu);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DynamicMenu> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dynamic menus that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dynamic menus that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenu> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dynamic menus that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dynamic menus
	 * @param end the upper bound of the range of dynamic menus (not inclusive)
	 * @return the range of matching dynamic menus that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenu> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dynamic menus that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dynamic menus
	 * @param end the upper bound of the range of dynamic menus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dynamic menus that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenu> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_DYNAMICMENU_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENU_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENU_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DynamicMenuModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DynamicMenuModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenu.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, DynamicMenuImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, DynamicMenuImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<DynamicMenu>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the dynamic menus before and after the current dynamic menu in the ordered set of dynamic menus that the user has permission to view where groupId = &#63;.
	 *
	 * @param menuId the primary key of the current dynamic menu
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dynamic menu
	 * @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a dynamic menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DynamicMenu[] filterFindByGroup_PrevAndNext(long menuId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchDynamicMenuException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(menuId, groupId, orderByComparator);
		}

		DynamicMenu dynamicMenu = findByPrimaryKey(menuId);

		Session session = null;

		try {
			session = openSession();

			DynamicMenu[] array = new DynamicMenuImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, dynamicMenu,
					groupId, orderByComparator, true);

			array[1] = dynamicMenu;

			array[2] = filterGetByGroup_PrevAndNext(session, dynamicMenu,
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

	protected DynamicMenu filterGetByGroup_PrevAndNext(Session session,
		DynamicMenu dynamicMenu, long groupId,
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
			query.append(_FILTER_SQL_SELECT_DYNAMICMENU_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENU_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DYNAMICMENU_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DynamicMenuModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DynamicMenuModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenu.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, DynamicMenuImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, DynamicMenuImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dynamicMenu);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DynamicMenu> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dynamic menus.
	 *
	 * @return the dynamic menus
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenu> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dynamic menus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of dynamic menus
	 * @param end the upper bound of the range of dynamic menus (not inclusive)
	 * @return the range of dynamic menus
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenu> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dynamic menus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of dynamic menus
	 * @param end the upper bound of the range of dynamic menus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dynamic menus
	 * @throws SystemException if a system exception occurred
	 */
	public List<DynamicMenu> findAll(int start, int end,
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

		List<DynamicMenu> list = (List<DynamicMenu>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DYNAMICMENU);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DYNAMICMENU.concat(DynamicMenuModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DynamicMenu>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DynamicMenu>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dynamic menus where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (DynamicMenu dynamicMenu : findByGroup(groupId)) {
			remove(dynamicMenu);
		}
	}

	/**
	 * Removes all the dynamic menus from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DynamicMenu dynamicMenu : findAll()) {
			remove(dynamicMenu);
		}
	}

	/**
	 * Returns the number of dynamic menus where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dynamic menus
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DYNAMICMENU_WHERE);

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
	 * Returns the number of dynamic menus that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dynamic menus that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_DYNAMICMENU_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DynamicMenu.class.getName(),
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
	 * Returns the number of dynamic menus.
	 *
	 * @return the number of dynamic menus
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DYNAMICMENU);

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
	 * Initializes the dynamic menu persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DynamicMenu>> listenersList = new ArrayList<ModelListener<DynamicMenu>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DynamicMenu>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DynamicMenuImpl.class.getName());
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
	private static final String _SQL_SELECT_DYNAMICMENU = "SELECT dynamicMenu FROM DynamicMenu dynamicMenu";
	private static final String _SQL_SELECT_DYNAMICMENU_WHERE = "SELECT dynamicMenu FROM DynamicMenu dynamicMenu WHERE ";
	private static final String _SQL_COUNT_DYNAMICMENU = "SELECT COUNT(dynamicMenu) FROM DynamicMenu dynamicMenu";
	private static final String _SQL_COUNT_DYNAMICMENU_WHERE = "SELECT COUNT(dynamicMenu) FROM DynamicMenu dynamicMenu WHERE ";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "dynamicMenu.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "dynamicMenu.menuId";
	private static final String _FILTER_SQL_SELECT_DYNAMICMENU_WHERE = "SELECT DISTINCT {dynamicMenu.*} FROM DynamicMenu dynamicMenu WHERE ";
	private static final String _FILTER_SQL_SELECT_DYNAMICMENU_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {DynamicMenu.*} FROM (SELECT DISTINCT dynamicMenu.menuId FROM DynamicMenu dynamicMenu WHERE ";
	private static final String _FILTER_SQL_SELECT_DYNAMICMENU_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN DynamicMenu ON TEMP_TABLE.menuId = DynamicMenu.menuId";
	private static final String _FILTER_SQL_COUNT_DYNAMICMENU_WHERE = "SELECT COUNT(DISTINCT dynamicMenu.menuId) AS COUNT_VALUE FROM DynamicMenu dynamicMenu WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "dynamicMenu";
	private static final String _FILTER_ENTITY_TABLE = "DynamicMenu";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dynamicMenu.";
	private static final String _ORDER_BY_ENTITY_TABLE = "DynamicMenu.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DynamicMenu exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DynamicMenu exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DynamicMenuPersistenceImpl.class);
	private static DynamicMenu _nullDynamicMenu = new DynamicMenuImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DynamicMenu> toCacheModel() {
				return _nullDynamicMenuCacheModel;
			}
		};

	private static CacheModel<DynamicMenu> _nullDynamicMenuCacheModel = new CacheModel<DynamicMenu>() {
			public DynamicMenu toEntityModel() {
				return _nullDynamicMenu;
			}
		};
}