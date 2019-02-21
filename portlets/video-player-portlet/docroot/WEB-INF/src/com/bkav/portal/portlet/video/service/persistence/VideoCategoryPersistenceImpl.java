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

import com.bkav.portal.portlet.video.NoSuchVideoCategoryException;
import com.bkav.portal.portlet.video.model.VideoCategory;
import com.bkav.portal.portlet.video.model.impl.VideoCategoryImpl;
import com.bkav.portal.portlet.video.model.impl.VideoCategoryModelImpl;

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
 * The persistence implementation for the video category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see VideoCategoryPersistence
 * @see VideoCategoryUtil
 * @generated
 */
public class VideoCategoryPersistenceImpl extends BasePersistenceImpl<VideoCategory>
	implements VideoCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoCategoryUtil} to access the video category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryModelImpl.FINDER_CACHE_ENABLED,
			VideoCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryModelImpl.FINDER_CACHE_ENABLED,
			VideoCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroup", new String[] { Long.class.getName() },
			VideoCategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryModelImpl.FINDER_CACHE_ENABLED,
			VideoCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryModelImpl.FINDER_CACHE_ENABLED,
			VideoCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the video category in the entity cache if it is enabled.
	 *
	 * @param videoCategory the video category
	 */
	public void cacheResult(VideoCategory videoCategory) {
		EntityCacheUtil.putResult(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryImpl.class, videoCategory.getPrimaryKey(),
			videoCategory);

		videoCategory.resetOriginalValues();
	}

	/**
	 * Caches the video categories in the entity cache if it is enabled.
	 *
	 * @param videoCategories the video categories
	 */
	public void cacheResult(List<VideoCategory> videoCategories) {
		for (VideoCategory videoCategory : videoCategories) {
			if (EntityCacheUtil.getResult(
						VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
						VideoCategoryImpl.class, videoCategory.getPrimaryKey()) == null) {
				cacheResult(videoCategory);
			}
			else {
				videoCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideoCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideoCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VideoCategory videoCategory) {
		EntityCacheUtil.removeResult(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryImpl.class, videoCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VideoCategory> videoCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VideoCategory videoCategory : videoCategories) {
			EntityCacheUtil.removeResult(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
				VideoCategoryImpl.class, videoCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video category with the primary key. Does not add the video category to the database.
	 *
	 * @param categoryId the primary key for the new video category
	 * @return the new video category
	 */
	public VideoCategory create(long categoryId) {
		VideoCategory videoCategory = new VideoCategoryImpl();

		videoCategory.setNew(true);
		videoCategory.setPrimaryKey(categoryId);

		return videoCategory;
	}

	/**
	 * Removes the video category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the video category
	 * @return the video category that was removed
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategory remove(long categoryId)
		throws NoSuchVideoCategoryException, SystemException {
		return remove(Long.valueOf(categoryId));
	}

	/**
	 * Removes the video category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video category
	 * @return the video category that was removed
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoCategory remove(Serializable primaryKey)
		throws NoSuchVideoCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VideoCategory videoCategory = (VideoCategory)session.get(VideoCategoryImpl.class,
					primaryKey);

			if (videoCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videoCategory);
		}
		catch (NoSuchVideoCategoryException nsee) {
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
	protected VideoCategory removeImpl(VideoCategory videoCategory)
		throws SystemException {
		videoCategory = toUnwrappedModel(videoCategory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, videoCategory);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(videoCategory);

		return videoCategory;
	}

	@Override
	public VideoCategory updateImpl(
		com.bkav.portal.portlet.video.model.VideoCategory videoCategory,
		boolean merge) throws SystemException {
		videoCategory = toUnwrappedModel(videoCategory);

		boolean isNew = videoCategory.isNew();

		VideoCategoryModelImpl videoCategoryModelImpl = (VideoCategoryModelImpl)videoCategory;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, videoCategory, merge);

			videoCategory.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VideoCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((videoCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoCategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						Long.valueOf(videoCategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryImpl.class, videoCategory.getPrimaryKey(),
			videoCategory);

		return videoCategory;
	}

	protected VideoCategory toUnwrappedModel(VideoCategory videoCategory) {
		if (videoCategory instanceof VideoCategoryImpl) {
			return videoCategory;
		}

		VideoCategoryImpl videoCategoryImpl = new VideoCategoryImpl();

		videoCategoryImpl.setNew(videoCategory.isNew());
		videoCategoryImpl.setPrimaryKey(videoCategory.getPrimaryKey());

		videoCategoryImpl.setCategoryId(videoCategory.getCategoryId());
		videoCategoryImpl.setGroupId(videoCategory.getGroupId());
		videoCategoryImpl.setCompanyId(videoCategory.getCompanyId());
		videoCategoryImpl.setUserId(videoCategory.getUserId());
		videoCategoryImpl.setUserName(videoCategory.getUserName());
		videoCategoryImpl.setCreateDate(videoCategory.getCreateDate());
		videoCategoryImpl.setModifiedDate(videoCategory.getModifiedDate());
		videoCategoryImpl.setCategoryName(videoCategory.getCategoryName());

		return videoCategoryImpl;
	}

	/**
	 * Returns the video category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video category
	 * @return the video category
	 * @throws com.liferay.portal.NoSuchModelException if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video category with the primary key or throws a {@link com.bkav.portal.portlet.video.NoSuchVideoCategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the video category
	 * @return the video category
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategory findByPrimaryKey(long categoryId)
		throws NoSuchVideoCategoryException, SystemException {
		VideoCategory videoCategory = fetchByPrimaryKey(categoryId);

		if (videoCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
			}

			throw new NoSuchVideoCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryId);
		}

		return videoCategory;
	}

	/**
	 * Returns the video category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video category
	 * @return the video category, or <code>null</code> if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the video category
	 * @return the video category, or <code>null</code> if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategory fetchByPrimaryKey(long categoryId)
		throws SystemException {
		VideoCategory videoCategory = (VideoCategory)EntityCacheUtil.getResult(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
				VideoCategoryImpl.class, categoryId);

		if (videoCategory == _nullVideoCategory) {
			return null;
		}

		if (videoCategory == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				videoCategory = (VideoCategory)session.get(VideoCategoryImpl.class,
						Long.valueOf(categoryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (videoCategory != null) {
					cacheResult(videoCategory);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VideoCategoryModelImpl.ENTITY_CACHE_ENABLED,
						VideoCategoryImpl.class, categoryId, _nullVideoCategory);
				}

				closeSession(session);
			}
		}

		return videoCategory;
	}

	/**
	 * Returns all the video categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching video categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategory> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of video categories
	 * @param end the upper bound of the range of video categories (not inclusive)
	 * @return the range of matching video categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategory> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of video categories
	 * @param end the upper bound of the range of video categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategory> findByGroup(long groupId, int start, int end,
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

		List<VideoCategory> list = (List<VideoCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VideoCategory videoCategory : list) {
				if ((groupId != videoCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_VIDEOCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<VideoCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first video category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video category
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a matching video category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategory findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoCategoryException, SystemException {
		VideoCategory videoCategory = fetchByGroup_First(groupId,
				orderByComparator);

		if (videoCategory != null) {
			return videoCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoCategoryException(msg.toString());
	}

	/**
	 * Returns the first video category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video category, or <code>null</code> if a matching video category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategory fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VideoCategory> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video category
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a matching video category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategory findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoCategoryException, SystemException {
		VideoCategory videoCategory = fetchByGroup_Last(groupId,
				orderByComparator);

		if (videoCategory != null) {
			return videoCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoCategoryException(msg.toString());
	}

	/**
	 * Returns the last video category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video category, or <code>null</code> if a matching video category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategory fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<VideoCategory> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video categories before and after the current video category in the ordered set where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current video category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video category
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategory[] findByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVideoCategoryException, SystemException {
		VideoCategory videoCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VideoCategory[] array = new VideoCategoryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, videoCategory, groupId,
					orderByComparator, true);

			array[1] = videoCategory;

			array[2] = getByGroup_PrevAndNext(session, videoCategory, groupId,
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

	protected VideoCategory getByGroup_PrevAndNext(Session session,
		VideoCategory videoCategory, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOCATEGORY_WHERE);

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
			query.append(VideoCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching video categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategory> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the video categories that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of video categories
	 * @param end the upper bound of the range of video categories (not inclusive)
	 * @return the range of matching video categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategory> filterFindByGroup(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video categories that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of video categories
	 * @param end the upper bound of the range of video categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategory> filterFindByGroup(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_VIDEOCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VIDEOCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VIDEOCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VideoCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VideoCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VideoCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VideoCategoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VideoCategoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<VideoCategory>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the video categories before and after the current video category in the ordered set of video categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param categoryId the primary key of the current video category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video category
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a video category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategory[] filterFindByGroup_PrevAndNext(long categoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVideoCategoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(categoryId, groupId,
				orderByComparator);
		}

		VideoCategory videoCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VideoCategory[] array = new VideoCategoryImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, videoCategory,
					groupId, orderByComparator, true);

			array[1] = videoCategory;

			array[2] = filterGetByGroup_PrevAndNext(session, videoCategory,
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

	protected VideoCategory filterGetByGroup_PrevAndNext(Session session,
		VideoCategory videoCategory, long groupId,
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
			query.append(_FILTER_SQL_SELECT_VIDEOCATEGORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VIDEOCATEGORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VIDEOCATEGORY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VideoCategoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VideoCategoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VideoCategory.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VideoCategoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VideoCategoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video categories.
	 *
	 * @return the video categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video categories
	 * @param end the upper bound of the range of video categories (not inclusive)
	 * @return the range of video categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video categories
	 * @param end the upper bound of the range of video categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategory> findAll(int start, int end,
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

		List<VideoCategory> list = (List<VideoCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEOCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOCATEGORY.concat(VideoCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VideoCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VideoCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the video categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (VideoCategory videoCategory : findByGroup(groupId)) {
			remove(videoCategory);
		}
	}

	/**
	 * Removes all the video categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VideoCategory videoCategory : findAll()) {
			remove(videoCategory);
		}
	}

	/**
	 * Returns the number of video categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching video categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOCATEGORY_WHERE);

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
	 * Returns the number of video categories that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching video categories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_VIDEOCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VideoCategory.class.getName(),
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
	 * Returns the number of video categories.
	 *
	 * @return the number of video categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEOCATEGORY);

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
	 * Initializes the video category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.video.model.VideoCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VideoCategory>> listenersList = new ArrayList<ModelListener<VideoCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VideoCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VideoCategoryImpl.class.getName());
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
	private static final String _SQL_SELECT_VIDEOCATEGORY = "SELECT videoCategory FROM VideoCategory videoCategory";
	private static final String _SQL_SELECT_VIDEOCATEGORY_WHERE = "SELECT videoCategory FROM VideoCategory videoCategory WHERE ";
	private static final String _SQL_COUNT_VIDEOCATEGORY = "SELECT COUNT(videoCategory) FROM VideoCategory videoCategory";
	private static final String _SQL_COUNT_VIDEOCATEGORY_WHERE = "SELECT COUNT(videoCategory) FROM VideoCategory videoCategory WHERE ";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "videoCategory.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "videoCategory.categoryId";
	private static final String _FILTER_SQL_SELECT_VIDEOCATEGORY_WHERE = "SELECT DISTINCT {videoCategory.*} FROM VideoCategory videoCategory WHERE ";
	private static final String _FILTER_SQL_SELECT_VIDEOCATEGORY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {VideoCategory.*} FROM (SELECT DISTINCT videoCategory.categoryId FROM VideoCategory videoCategory WHERE ";
	private static final String _FILTER_SQL_SELECT_VIDEOCATEGORY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN VideoCategory ON TEMP_TABLE.categoryId = VideoCategory.categoryId";
	private static final String _FILTER_SQL_COUNT_VIDEOCATEGORY_WHERE = "SELECT COUNT(DISTINCT videoCategory.categoryId) AS COUNT_VALUE FROM VideoCategory videoCategory WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "videoCategory";
	private static final String _FILTER_ENTITY_TABLE = "VideoCategory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoCategory.";
	private static final String _ORDER_BY_ENTITY_TABLE = "VideoCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VideoCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideoCategoryPersistenceImpl.class);
	private static VideoCategory _nullVideoCategory = new VideoCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VideoCategory> toCacheModel() {
				return _nullVideoCategoryCacheModel;
			}
		};

	private static CacheModel<VideoCategory> _nullVideoCategoryCacheModel = new CacheModel<VideoCategory>() {
			public VideoCategory toEntityModel() {
				return _nullVideoCategory;
			}
		};
}