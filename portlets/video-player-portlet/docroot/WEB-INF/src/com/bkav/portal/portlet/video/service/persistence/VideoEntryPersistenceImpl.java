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

package com.bkav.portal.portlet.video.service.persistence;

import com.bkav.portal.portlet.video.NoSuchVideoEntryException;
import com.bkav.portal.portlet.video.model.VideoEntry;
import com.bkav.portal.portlet.video.model.impl.VideoEntryImpl;
import com.bkav.portal.portlet.video.model.impl.VideoEntryModelImpl;

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
 * The persistence implementation for the video entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see VideoEntryPersistence
 * @see VideoEntryUtil
 * @generated
 */
public class VideoEntryPersistenceImpl extends BasePersistenceImpl<VideoEntry>
	implements VideoEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoEntryUtil} to access the video entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, VideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, VideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			VideoEntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, VideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, VideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the video entry in the entity cache if it is enabled.
	 *
	 * @param videoEntry the video entry
	 */
	public void cacheResult(VideoEntry videoEntry) {
		EntityCacheUtil.putResult(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryImpl.class, videoEntry.getPrimaryKey(), videoEntry);

		videoEntry.resetOriginalValues();
	}

	/**
	 * Caches the video entries in the entity cache if it is enabled.
	 *
	 * @param videoEntries the video entries
	 */
	public void cacheResult(List<VideoEntry> videoEntries) {
		for (VideoEntry videoEntry : videoEntries) {
			if (EntityCacheUtil.getResult(
						VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoEntryImpl.class, videoEntry.getPrimaryKey()) == null) {
				cacheResult(videoEntry);
			}
			else {
				videoEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideoEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideoEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VideoEntry videoEntry) {
		EntityCacheUtil.removeResult(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryImpl.class, videoEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VideoEntry> videoEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VideoEntry videoEntry : videoEntries) {
			EntityCacheUtil.removeResult(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoEntryImpl.class, videoEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video entry with the primary key. Does not add the video entry to the database.
	 *
	 * @param entryId the primary key for the new video entry
	 * @return the new video entry
	 */
	public VideoEntry create(long entryId) {
		VideoEntry videoEntry = new VideoEntryImpl();

		videoEntry.setNew(true);
		videoEntry.setPrimaryKey(entryId);

		return videoEntry;
	}

	/**
	 * Removes the video entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the video entry
	 * @return the video entry that was removed
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoEntryException if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry remove(long entryId)
		throws NoSuchVideoEntryException, SystemException {
		return remove(Long.valueOf(entryId));
	}

	/**
	 * Removes the video entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video entry
	 * @return the video entry that was removed
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoEntryException if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoEntry remove(Serializable primaryKey)
		throws NoSuchVideoEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VideoEntry videoEntry = (VideoEntry)session.get(VideoEntryImpl.class,
					primaryKey);

			if (videoEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videoEntry);
		}
		catch (NoSuchVideoEntryException nsee) {
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
	protected VideoEntry removeImpl(VideoEntry videoEntry)
		throws SystemException {
		videoEntry = toUnwrappedModel(videoEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, videoEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(videoEntry);

		return videoEntry;
	}

	@Override
	public VideoEntry updateImpl(
		com.bkav.portal.portlet.video.model.VideoEntry videoEntry, boolean merge)
		throws SystemException {
		videoEntry = toUnwrappedModel(videoEntry);

		boolean isNew = videoEntry.isNew();

		VideoEntryModelImpl videoEntryModelImpl = (VideoEntryModelImpl)videoEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, videoEntry, merge);

			videoEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VideoEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((videoEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoEntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(videoEntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryImpl.class, videoEntry.getPrimaryKey(), videoEntry);

		return videoEntry;
	}

	protected VideoEntry toUnwrappedModel(VideoEntry videoEntry) {
		if (videoEntry instanceof VideoEntryImpl) {
			return videoEntry;
		}

		VideoEntryImpl videoEntryImpl = new VideoEntryImpl();

		videoEntryImpl.setNew(videoEntry.isNew());
		videoEntryImpl.setPrimaryKey(videoEntry.getPrimaryKey());

		videoEntryImpl.setEntryId(videoEntry.getEntryId());
		videoEntryImpl.setGroupId(videoEntry.getGroupId());
		videoEntryImpl.setCompanyId(videoEntry.getCompanyId());
		videoEntryImpl.setUserId(videoEntry.getUserId());
		videoEntryImpl.setUserName(videoEntry.getUserName());
		videoEntryImpl.setCreateDate(videoEntry.getCreateDate());
		videoEntryImpl.setModifiedDate(videoEntry.getModifiedDate());
		videoEntryImpl.setName(videoEntry.getName());
		videoEntryImpl.setDescription(videoEntry.getDescription());
		videoEntryImpl.setVideoType(videoEntry.getVideoType());
		videoEntryImpl.setVideoUrl(videoEntry.getVideoUrl());
		videoEntryImpl.setVideoFileId(videoEntry.getVideoFileId());
		videoEntryImpl.setThumbnailImage(videoEntry.isThumbnailImage());
		videoEntryImpl.setThumbnailImageId(videoEntry.getThumbnailImageId());

		return videoEntryImpl;
	}

	/**
	 * Returns the video entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video entry
	 * @return the video entry
	 * @throws com.liferay.portal.NoSuchModelException if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video entry with the primary key or throws a {@link com.bkav.portal.portlet.video.NoSuchVideoEntryException} if it could not be found.
	 *
	 * @param entryId the primary key of the video entry
	 * @return the video entry
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoEntryException if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry findByPrimaryKey(long entryId)
		throws NoSuchVideoEntryException, SystemException {
		VideoEntry videoEntry = fetchByPrimaryKey(entryId);

		if (videoEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entryId);
			}

			throw new NoSuchVideoEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				entryId);
		}

		return videoEntry;
	}

	/**
	 * Returns the video entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video entry
	 * @return the video entry, or <code>null</code> if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the video entry
	 * @return the video entry, or <code>null</code> if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry fetchByPrimaryKey(long entryId) throws SystemException {
		VideoEntry videoEntry = (VideoEntry)EntityCacheUtil.getResult(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoEntryImpl.class, entryId);

		if (videoEntry == _nullVideoEntry) {
			return null;
		}

		if (videoEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				videoEntry = (VideoEntry)session.get(VideoEntryImpl.class,
						Long.valueOf(entryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (videoEntry != null) {
					cacheResult(videoEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoEntryImpl.class, entryId, _nullVideoEntry);
				}

				closeSession(session);
			}
		}

		return videoEntry;
	}

	/**
	 * Returns all the video entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @return the range of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByGroup(long groupId, int start, int end,
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

		List<VideoEntry> list = (List<VideoEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VideoEntry videoEntry : list) {
				if ((groupId != videoEntry.getGroupId())) {
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

			query.append(_SQL_SELECT_VIDEOENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<VideoEntry>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first video entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video entry
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoEntryException if a matching video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoEntryException, SystemException {
		VideoEntry videoEntry = fetchByGroup_First(groupId, orderByComparator);

		if (videoEntry != null) {
			return videoEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoEntryException(msg.toString());
	}

	/**
	 * Returns the first video entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video entry, or <code>null</code> if a matching video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VideoEntry> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video entry
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoEntryException if a matching video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoEntryException, SystemException {
		VideoEntry videoEntry = fetchByGroup_Last(groupId, orderByComparator);

		if (videoEntry != null) {
			return videoEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoEntryException(msg.toString());
	}

	/**
	 * Returns the last video entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video entry, or <code>null</code> if a matching video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<VideoEntry> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video entries before and after the current video entry in the ordered set where groupId = &#63;.
	 *
	 * @param entryId the primary key of the current video entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video entry
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoEntryException if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry[] findByGroup_PrevAndNext(long entryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoEntryException, SystemException {
		VideoEntry videoEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VideoEntry[] array = new VideoEntryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, videoEntry, groupId,
					orderByComparator, true);

			array[1] = videoEntry;

			array[2] = getByGroup_PrevAndNext(session, videoEntry, groupId,
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

	protected VideoEntry getByGroup_PrevAndNext(Session session,
		VideoEntry videoEntry, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOENTRY_WHERE);

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
			query.append(VideoEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching video entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the video entries that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @return the range of matching video entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video entries that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> filterFindByGroup(long groupId, int start, int end,
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
			query.append(_FILTER_SQL_SELECT_VIDEOENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VIDEOENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VIDEOENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VideoEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VideoEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VideoEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VideoEntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VideoEntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<VideoEntry>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the video entries before and after the current video entry in the ordered set of video entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param entryId the primary key of the current video entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video entry
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoEntryException if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry[] filterFindByGroup_PrevAndNext(long entryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVideoEntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(entryId, groupId, orderByComparator);
		}

		VideoEntry videoEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			VideoEntry[] array = new VideoEntryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, videoEntry,
					groupId, orderByComparator, true);

			array[1] = videoEntry;

			array[2] = filterGetByGroup_PrevAndNext(session, videoEntry,
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

	protected VideoEntry filterGetByGroup_PrevAndNext(Session session,
		VideoEntry videoEntry, long groupId,
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
			query.append(_FILTER_SQL_SELECT_VIDEOENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VIDEOENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VIDEOENTRY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VideoEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VideoEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VideoEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VideoEntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VideoEntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video entries.
	 *
	 * @return the video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @return the range of video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findAll(int start, int end,
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

		List<VideoEntry> list = (List<VideoEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEOENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOENTRY.concat(VideoEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VideoEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VideoEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the video entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (VideoEntry videoEntry : findByGroup(groupId)) {
			remove(videoEntry);
		}
	}

	/**
	 * Removes all the video entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VideoEntry videoEntry : findAll()) {
			remove(videoEntry);
		}
	}

	/**
	 * Returns the number of video entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOENTRY_WHERE);

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
	 * Returns the number of video entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching video entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_VIDEOENTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VideoEntry.class.getName(),
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
	 * Returns the number of video entries.
	 *
	 * @return the number of video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEOENTRY);

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
	 * Initializes the video entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.video.model.VideoEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VideoEntry>> listenersList = new ArrayList<ModelListener<VideoEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VideoEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VideoEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = VideoCategoryPersistence.class)
	protected VideoCategoryPersistence videoCategoryPersistence;
	@BeanReference(type = VideoCategoryMapPersistence.class)
	protected VideoCategoryMapPersistence videoCategoryMapPersistence;
	@BeanReference(type = VideoEntryPersistence.class)
	protected VideoEntryPersistence videoEntryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_VIDEOENTRY = "SELECT videoEntry FROM VideoEntry videoEntry";
	private static final String _SQL_SELECT_VIDEOENTRY_WHERE = "SELECT videoEntry FROM VideoEntry videoEntry WHERE ";
	private static final String _SQL_COUNT_VIDEOENTRY = "SELECT COUNT(videoEntry) FROM VideoEntry videoEntry";
	private static final String _SQL_COUNT_VIDEOENTRY_WHERE = "SELECT COUNT(videoEntry) FROM VideoEntry videoEntry WHERE ";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "videoEntry.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "videoEntry.entryId";
	private static final String _FILTER_SQL_SELECT_VIDEOENTRY_WHERE = "SELECT DISTINCT {videoEntry.*} FROM VideoEntry videoEntry WHERE ";
	private static final String _FILTER_SQL_SELECT_VIDEOENTRY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {VideoEntry.*} FROM (SELECT DISTINCT videoEntry.entryId FROM VideoEntry videoEntry WHERE ";
	private static final String _FILTER_SQL_SELECT_VIDEOENTRY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN VideoEntry ON TEMP_TABLE.entryId = VideoEntry.entryId";
	private static final String _FILTER_SQL_COUNT_VIDEOENTRY_WHERE = "SELECT COUNT(DISTINCT videoEntry.entryId) AS COUNT_VALUE FROM VideoEntry videoEntry WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "videoEntry";
	private static final String _FILTER_ENTITY_TABLE = "VideoEntry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoEntry.";
	private static final String _ORDER_BY_ENTITY_TABLE = "VideoEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VideoEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideoEntryPersistenceImpl.class);
	private static VideoEntry _nullVideoEntry = new VideoEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VideoEntry> toCacheModel() {
				return _nullVideoEntryCacheModel;
			}
		};

	private static CacheModel<VideoEntry> _nullVideoEntryCacheModel = new CacheModel<VideoEntry>() {
			public VideoEntry toEntityModel() {
				return _nullVideoEntry;
			}
		};
}