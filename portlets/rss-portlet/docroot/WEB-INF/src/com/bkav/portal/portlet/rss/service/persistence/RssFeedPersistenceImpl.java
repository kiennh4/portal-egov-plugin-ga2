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

package com.bkav.portal.portlet.rss.service.persistence;

import com.bkav.portal.portlet.rss.NoSuchRssFeedException;
import com.bkav.portal.portlet.rss.model.RssFeed;
import com.bkav.portal.portlet.rss.model.impl.RssFeedImpl;
import com.bkav.portal.portlet.rss.model.impl.RssFeedModelImpl;

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
 * The persistence implementation for the rss feed service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see RssFeedPersistence
 * @see RssFeedUtil
 * @generated
 */
public class RssFeedPersistenceImpl extends BasePersistenceImpl<RssFeed>
	implements RssFeedPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RssFeedUtil} to access the rss feed persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RssFeedImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(RssFeedModelImpl.ENTITY_CACHE_ENABLED,
			RssFeedModelImpl.FINDER_CACHE_ENABLED, RssFeedImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(RssFeedModelImpl.ENTITY_CACHE_ENABLED,
			RssFeedModelImpl.FINDER_CACHE_ENABLED, RssFeedImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			RssFeedModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(RssFeedModelImpl.ENTITY_CACHE_ENABLED,
			RssFeedModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RssFeedModelImpl.ENTITY_CACHE_ENABLED,
			RssFeedModelImpl.FINDER_CACHE_ENABLED, RssFeedImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RssFeedModelImpl.ENTITY_CACHE_ENABLED,
			RssFeedModelImpl.FINDER_CACHE_ENABLED, RssFeedImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RssFeedModelImpl.ENTITY_CACHE_ENABLED,
			RssFeedModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the rss feed in the entity cache if it is enabled.
	 *
	 * @param rssFeed the rss feed
	 */
	public void cacheResult(RssFeed rssFeed) {
		EntityCacheUtil.putResult(RssFeedModelImpl.ENTITY_CACHE_ENABLED,
			RssFeedImpl.class, rssFeed.getPrimaryKey(), rssFeed);

		rssFeed.resetOriginalValues();
	}

	/**
	 * Caches the rss feeds in the entity cache if it is enabled.
	 *
	 * @param rssFeeds the rss feeds
	 */
	public void cacheResult(List<RssFeed> rssFeeds) {
		for (RssFeed rssFeed : rssFeeds) {
			if (EntityCacheUtil.getResult(
						RssFeedModelImpl.ENTITY_CACHE_ENABLED,
						RssFeedImpl.class, rssFeed.getPrimaryKey()) == null) {
				cacheResult(rssFeed);
			}
			else {
				rssFeed.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rss feeds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RssFeedImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RssFeedImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rss feed.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RssFeed rssFeed) {
		EntityCacheUtil.removeResult(RssFeedModelImpl.ENTITY_CACHE_ENABLED,
			RssFeedImpl.class, rssFeed.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RssFeed> rssFeeds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RssFeed rssFeed : rssFeeds) {
			EntityCacheUtil.removeResult(RssFeedModelImpl.ENTITY_CACHE_ENABLED,
				RssFeedImpl.class, rssFeed.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rss feed with the primary key. Does not add the rss feed to the database.
	 *
	 * @param id_ the primary key for the new rss feed
	 * @return the new rss feed
	 */
	public RssFeed create(long id_) {
		RssFeed rssFeed = new RssFeedImpl();

		rssFeed.setNew(true);
		rssFeed.setPrimaryKey(id_);

		return rssFeed;
	}

	/**
	 * Removes the rss feed with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the rss feed
	 * @return the rss feed that was removed
	 * @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a rss feed with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RssFeed remove(long id_)
		throws NoSuchRssFeedException, SystemException {
		return remove(Long.valueOf(id_));
	}

	/**
	 * Removes the rss feed with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rss feed
	 * @return the rss feed that was removed
	 * @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a rss feed with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RssFeed remove(Serializable primaryKey)
		throws NoSuchRssFeedException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RssFeed rssFeed = (RssFeed)session.get(RssFeedImpl.class, primaryKey);

			if (rssFeed == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRssFeedException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rssFeed);
		}
		catch (NoSuchRssFeedException nsee) {
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
	protected RssFeed removeImpl(RssFeed rssFeed) throws SystemException {
		rssFeed = toUnwrappedModel(rssFeed);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, rssFeed);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(rssFeed);

		return rssFeed;
	}

	@Override
	public RssFeed updateImpl(
		com.bkav.portal.portlet.rss.model.RssFeed rssFeed, boolean merge)
		throws SystemException {
		rssFeed = toUnwrappedModel(rssFeed);

		boolean isNew = rssFeed.isNew();

		RssFeedModelImpl rssFeedModelImpl = (RssFeedModelImpl)rssFeed;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, rssFeed, merge);

			rssFeed.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RssFeedModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rssFeedModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(rssFeedModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { Long.valueOf(rssFeedModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(RssFeedModelImpl.ENTITY_CACHE_ENABLED,
			RssFeedImpl.class, rssFeed.getPrimaryKey(), rssFeed);

		return rssFeed;
	}

	protected RssFeed toUnwrappedModel(RssFeed rssFeed) {
		if (rssFeed instanceof RssFeedImpl) {
			return rssFeed;
		}

		RssFeedImpl rssFeedImpl = new RssFeedImpl();

		rssFeedImpl.setNew(rssFeed.isNew());
		rssFeedImpl.setPrimaryKey(rssFeed.getPrimaryKey());

		rssFeedImpl.setId_(rssFeed.getId_());
		rssFeedImpl.setGroupId(rssFeed.getGroupId());
		rssFeedImpl.setCompanyId(rssFeed.getCompanyId());
		rssFeedImpl.setUserId(rssFeed.getUserId());
		rssFeedImpl.setUserName(rssFeed.getUserName());
		rssFeedImpl.setCreateDate(rssFeed.getCreateDate());
		rssFeedImpl.setModifiedDate(rssFeed.getModifiedDate());
		rssFeedImpl.setName(rssFeed.getName());
		rssFeedImpl.setUrl(rssFeed.getUrl());
		rssFeedImpl.setDescription(rssFeed.getDescription());
		rssFeedImpl.setStatus(rssFeed.getStatus());

		return rssFeedImpl;
	}

	/**
	 * Returns the rss feed with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rss feed
	 * @return the rss feed
	 * @throws com.liferay.portal.NoSuchModelException if a rss feed with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RssFeed findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the rss feed with the primary key or throws a {@link com.bkav.portal.portlet.rss.NoSuchRssFeedException} if it could not be found.
	 *
	 * @param id_ the primary key of the rss feed
	 * @return the rss feed
	 * @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a rss feed with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RssFeed findByPrimaryKey(long id_)
		throws NoSuchRssFeedException, SystemException {
		RssFeed rssFeed = fetchByPrimaryKey(id_);

		if (rssFeed == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id_);
			}

			throw new NoSuchRssFeedException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id_);
		}

		return rssFeed;
	}

	/**
	 * Returns the rss feed with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rss feed
	 * @return the rss feed, or <code>null</code> if a rss feed with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RssFeed fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the rss feed with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the rss feed
	 * @return the rss feed, or <code>null</code> if a rss feed with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RssFeed fetchByPrimaryKey(long id_) throws SystemException {
		RssFeed rssFeed = (RssFeed)EntityCacheUtil.getResult(RssFeedModelImpl.ENTITY_CACHE_ENABLED,
				RssFeedImpl.class, id_);

		if (rssFeed == _nullRssFeed) {
			return null;
		}

		if (rssFeed == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				rssFeed = (RssFeed)session.get(RssFeedImpl.class,
						Long.valueOf(id_));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (rssFeed != null) {
					cacheResult(rssFeed);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(RssFeedModelImpl.ENTITY_CACHE_ENABLED,
						RssFeedImpl.class, id_, _nullRssFeed);
				}

				closeSession(session);
			}
		}

		return rssFeed;
	}

	/**
	 * Returns all the rss feeds where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching rss feeds
	 * @throws SystemException if a system exception occurred
	 */
	public List<RssFeed> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rss feeds where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of rss feeds
	 * @param end the upper bound of the range of rss feeds (not inclusive)
	 * @return the range of matching rss feeds
	 * @throws SystemException if a system exception occurred
	 */
	public List<RssFeed> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rss feeds where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of rss feeds
	 * @param end the upper bound of the range of rss feeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rss feeds
	 * @throws SystemException if a system exception occurred
	 */
	public List<RssFeed> findByGroup(long groupId, int start, int end,
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

		List<RssFeed> list = (List<RssFeed>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RssFeed rssFeed : list) {
				if ((groupId != rssFeed.getGroupId())) {
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

			query.append(_SQL_SELECT_RSSFEED_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(RssFeedModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<RssFeed>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first rss feed in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rss feed
	 * @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a matching rss feed could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RssFeed findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchRssFeedException, SystemException {
		RssFeed rssFeed = fetchByGroup_First(groupId, orderByComparator);

		if (rssFeed != null) {
			return rssFeed;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRssFeedException(msg.toString());
	}

	/**
	 * Returns the first rss feed in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rss feed, or <code>null</code> if a matching rss feed could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RssFeed fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RssFeed> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rss feed in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rss feed
	 * @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a matching rss feed could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RssFeed findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchRssFeedException, SystemException {
		RssFeed rssFeed = fetchByGroup_Last(groupId, orderByComparator);

		if (rssFeed != null) {
			return rssFeed;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRssFeedException(msg.toString());
	}

	/**
	 * Returns the last rss feed in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rss feed, or <code>null</code> if a matching rss feed could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RssFeed fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<RssFeed> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rss feeds before and after the current rss feed in the ordered set where groupId = &#63;.
	 *
	 * @param id_ the primary key of the current rss feed
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rss feed
	 * @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a rss feed with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RssFeed[] findByGroup_PrevAndNext(long id_, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchRssFeedException, SystemException {
		RssFeed rssFeed = findByPrimaryKey(id_);

		Session session = null;

		try {
			session = openSession();

			RssFeed[] array = new RssFeedImpl[3];

			array[0] = getByGroup_PrevAndNext(session, rssFeed, groupId,
					orderByComparator, true);

			array[1] = rssFeed;

			array[2] = getByGroup_PrevAndNext(session, rssFeed, groupId,
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

	protected RssFeed getByGroup_PrevAndNext(Session session, RssFeed rssFeed,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSSFEED_WHERE);

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
			query.append(RssFeedModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rssFeed);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RssFeed> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the rss feeds that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching rss feeds that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<RssFeed> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the rss feeds that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of rss feeds
	 * @param end the upper bound of the range of rss feeds (not inclusive)
	 * @return the range of matching rss feeds that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<RssFeed> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rss feeds that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of rss feeds
	 * @param end the upper bound of the range of rss feeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rss feeds that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<RssFeed> filterFindByGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_RSSFEED_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_RSSFEED_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_RSSFEED_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(RssFeedModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(RssFeedModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				RssFeed.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, RssFeedImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, RssFeedImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<RssFeed>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the rss feeds before and after the current rss feed in the ordered set of rss feeds that the user has permission to view where groupId = &#63;.
	 *
	 * @param id_ the primary key of the current rss feed
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rss feed
	 * @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a rss feed with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RssFeed[] filterFindByGroup_PrevAndNext(long id_, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchRssFeedException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(id_, groupId, orderByComparator);
		}

		RssFeed rssFeed = findByPrimaryKey(id_);

		Session session = null;

		try {
			session = openSession();

			RssFeed[] array = new RssFeedImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, rssFeed, groupId,
					orderByComparator, true);

			array[1] = rssFeed;

			array[2] = filterGetByGroup_PrevAndNext(session, rssFeed, groupId,
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

	protected RssFeed filterGetByGroup_PrevAndNext(Session session,
		RssFeed rssFeed, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_RSSFEED_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_RSSFEED_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_RSSFEED_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(RssFeedModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(RssFeedModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				RssFeed.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, RssFeedImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, RssFeedImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rssFeed);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RssFeed> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the rss feeds.
	 *
	 * @return the rss feeds
	 * @throws SystemException if a system exception occurred
	 */
	public List<RssFeed> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rss feeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of rss feeds
	 * @param end the upper bound of the range of rss feeds (not inclusive)
	 * @return the range of rss feeds
	 * @throws SystemException if a system exception occurred
	 */
	public List<RssFeed> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rss feeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of rss feeds
	 * @param end the upper bound of the range of rss feeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rss feeds
	 * @throws SystemException if a system exception occurred
	 */
	public List<RssFeed> findAll(int start, int end,
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

		List<RssFeed> list = (List<RssFeed>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RSSFEED);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RSSFEED.concat(RssFeedModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<RssFeed>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<RssFeed>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rss feeds where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (RssFeed rssFeed : findByGroup(groupId)) {
			remove(rssFeed);
		}
	}

	/**
	 * Removes all the rss feeds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (RssFeed rssFeed : findAll()) {
			remove(rssFeed);
		}
	}

	/**
	 * Returns the number of rss feeds where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching rss feeds
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RSSFEED_WHERE);

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
	 * Returns the number of rss feeds that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching rss feeds that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_RSSFEED_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				RssFeed.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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
	 * Returns the number of rss feeds.
	 *
	 * @return the number of rss feeds
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RSSFEED);

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
	 * Initializes the rss feed persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.rss.model.RssFeed")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RssFeed>> listenersList = new ArrayList<ModelListener<RssFeed>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RssFeed>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RssFeedImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = RssFeedPersistence.class)
	protected RssFeedPersistence rssFeedPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_RSSFEED = "SELECT rssFeed FROM RssFeed rssFeed";
	private static final String _SQL_SELECT_RSSFEED_WHERE = "SELECT rssFeed FROM RssFeed rssFeed WHERE ";
	private static final String _SQL_COUNT_RSSFEED = "SELECT COUNT(rssFeed) FROM RssFeed rssFeed";
	private static final String _SQL_COUNT_RSSFEED_WHERE = "SELECT COUNT(rssFeed) FROM RssFeed rssFeed WHERE ";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "rssFeed.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "rssFeed.id_";
	private static final String _FILTER_SQL_SELECT_RSSFEED_WHERE = "SELECT DISTINCT {rssFeed.*} FROM RssFeed rssFeed WHERE ";
	private static final String _FILTER_SQL_SELECT_RSSFEED_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {RssFeed.*} FROM (SELECT DISTINCT rssFeed.id_ FROM RssFeed rssFeed WHERE ";
	private static final String _FILTER_SQL_SELECT_RSSFEED_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN RssFeed ON TEMP_TABLE.id_ = RssFeed.id_";
	private static final String _FILTER_SQL_COUNT_RSSFEED_WHERE = "SELECT COUNT(DISTINCT rssFeed.id_) AS COUNT_VALUE FROM RssFeed rssFeed WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "rssFeed";
	private static final String _FILTER_ENTITY_TABLE = "RssFeed";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rssFeed.";
	private static final String _ORDER_BY_ENTITY_TABLE = "RssFeed.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RssFeed exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RssFeed exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RssFeedPersistenceImpl.class);
	private static RssFeed _nullRssFeed = new RssFeedImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RssFeed> toCacheModel() {
				return _nullRssFeedCacheModel;
			}
		};

	private static CacheModel<RssFeed> _nullRssFeedCacheModel = new CacheModel<RssFeed>() {
			public RssFeed toEntityModel() {
				return _nullRssFeed;
			}
		};
}