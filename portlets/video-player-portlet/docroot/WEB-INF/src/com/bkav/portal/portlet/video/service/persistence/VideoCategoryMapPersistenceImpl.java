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

import com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException;
import com.bkav.portal.portlet.video.model.VideoCategoryMap;
import com.bkav.portal.portlet.video.model.impl.VideoCategoryMapImpl;
import com.bkav.portal.portlet.video.model.impl.VideoCategoryMapModelImpl;

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
 * The persistence implementation for the video category map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see VideoCategoryMapPersistence
 * @see VideoCategoryMapUtil
 * @generated
 */
public class VideoCategoryMapPersistenceImpl extends BasePersistenceImpl<VideoCategoryMap>
	implements VideoCategoryMapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoCategoryMapUtil} to access the video category map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoCategoryMapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryMapModelImpl.FINDER_CACHE_ENABLED,
			VideoCategoryMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategory",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryMapModelImpl.FINDER_CACHE_ENABLED,
			VideoCategoryMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { Long.class.getName() },
			VideoCategoryMapModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTRY = new FinderPath(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryMapModelImpl.FINDER_CACHE_ENABLED,
			VideoCategoryMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEntry",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRY = new FinderPath(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryMapModelImpl.FINDER_CACHE_ENABLED,
			VideoCategoryMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEntry",
			new String[] { Long.class.getName() },
			VideoCategoryMapModelImpl.ENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTRY = new FinderPath(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEntry",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryMapModelImpl.FINDER_CACHE_ENABLED,
			VideoCategoryMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryMapModelImpl.FINDER_CACHE_ENABLED,
			VideoCategoryMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the video category map in the entity cache if it is enabled.
	 *
	 * @param videoCategoryMap the video category map
	 */
	public void cacheResult(VideoCategoryMap videoCategoryMap) {
		EntityCacheUtil.putResult(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryMapImpl.class, videoCategoryMap.getPrimaryKey(),
			videoCategoryMap);

		videoCategoryMap.resetOriginalValues();
	}

	/**
	 * Caches the video category maps in the entity cache if it is enabled.
	 *
	 * @param videoCategoryMaps the video category maps
	 */
	public void cacheResult(List<VideoCategoryMap> videoCategoryMaps) {
		for (VideoCategoryMap videoCategoryMap : videoCategoryMaps) {
			if (EntityCacheUtil.getResult(
						VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
						VideoCategoryMapImpl.class,
						videoCategoryMap.getPrimaryKey()) == null) {
				cacheResult(videoCategoryMap);
			}
			else {
				videoCategoryMap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video category maps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideoCategoryMapImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideoCategoryMapImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video category map.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VideoCategoryMap videoCategoryMap) {
		EntityCacheUtil.removeResult(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryMapImpl.class, videoCategoryMap.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VideoCategoryMap> videoCategoryMaps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VideoCategoryMap videoCategoryMap : videoCategoryMaps) {
			EntityCacheUtil.removeResult(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
				VideoCategoryMapImpl.class, videoCategoryMap.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video category map with the primary key. Does not add the video category map to the database.
	 *
	 * @param mapId the primary key for the new video category map
	 * @return the new video category map
	 */
	public VideoCategoryMap create(long mapId) {
		VideoCategoryMap videoCategoryMap = new VideoCategoryMapImpl();

		videoCategoryMap.setNew(true);
		videoCategoryMap.setPrimaryKey(mapId);

		return videoCategoryMap;
	}

	/**
	 * Removes the video category map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapId the primary key of the video category map
	 * @return the video category map that was removed
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a video category map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategoryMap remove(long mapId)
		throws NoSuchVideoCategoryMapException, SystemException {
		return remove(Long.valueOf(mapId));
	}

	/**
	 * Removes the video category map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video category map
	 * @return the video category map that was removed
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a video category map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoCategoryMap remove(Serializable primaryKey)
		throws NoSuchVideoCategoryMapException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VideoCategoryMap videoCategoryMap = (VideoCategoryMap)session.get(VideoCategoryMapImpl.class,
					primaryKey);

			if (videoCategoryMap == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoCategoryMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videoCategoryMap);
		}
		catch (NoSuchVideoCategoryMapException nsee) {
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
	protected VideoCategoryMap removeImpl(VideoCategoryMap videoCategoryMap)
		throws SystemException {
		videoCategoryMap = toUnwrappedModel(videoCategoryMap);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, videoCategoryMap);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(videoCategoryMap);

		return videoCategoryMap;
	}

	@Override
	public VideoCategoryMap updateImpl(
		com.bkav.portal.portlet.video.model.VideoCategoryMap videoCategoryMap,
		boolean merge) throws SystemException {
		videoCategoryMap = toUnwrappedModel(videoCategoryMap);

		boolean isNew = videoCategoryMap.isNew();

		VideoCategoryMapModelImpl videoCategoryMapModelImpl = (VideoCategoryMapModelImpl)videoCategoryMap;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, videoCategoryMap, merge);

			videoCategoryMap.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VideoCategoryMapModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((videoCategoryMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoCategoryMapModelImpl.getOriginalCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] {
						Long.valueOf(videoCategoryMapModelImpl.getCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}

			if ((videoCategoryMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoCategoryMapModelImpl.getOriginalEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTRY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRY,
					args);

				args = new Object[] {
						Long.valueOf(videoCategoryMapModelImpl.getEntryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTRY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRY,
					args);
			}
		}

		EntityCacheUtil.putResult(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
			VideoCategoryMapImpl.class, videoCategoryMap.getPrimaryKey(),
			videoCategoryMap);

		return videoCategoryMap;
	}

	protected VideoCategoryMap toUnwrappedModel(
		VideoCategoryMap videoCategoryMap) {
		if (videoCategoryMap instanceof VideoCategoryMapImpl) {
			return videoCategoryMap;
		}

		VideoCategoryMapImpl videoCategoryMapImpl = new VideoCategoryMapImpl();

		videoCategoryMapImpl.setNew(videoCategoryMap.isNew());
		videoCategoryMapImpl.setPrimaryKey(videoCategoryMap.getPrimaryKey());

		videoCategoryMapImpl.setMapId(videoCategoryMap.getMapId());
		videoCategoryMapImpl.setCategoryId(videoCategoryMap.getCategoryId());
		videoCategoryMapImpl.setEntryId(videoCategoryMap.getEntryId());

		return videoCategoryMapImpl;
	}

	/**
	 * Returns the video category map with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video category map
	 * @return the video category map
	 * @throws com.liferay.portal.NoSuchModelException if a video category map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoCategoryMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video category map with the primary key or throws a {@link com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException} if it could not be found.
	 *
	 * @param mapId the primary key of the video category map
	 * @return the video category map
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a video category map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategoryMap findByPrimaryKey(long mapId)
		throws NoSuchVideoCategoryMapException, SystemException {
		VideoCategoryMap videoCategoryMap = fetchByPrimaryKey(mapId);

		if (videoCategoryMap == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + mapId);
			}

			throw new NoSuchVideoCategoryMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				mapId);
		}

		return videoCategoryMap;
	}

	/**
	 * Returns the video category map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video category map
	 * @return the video category map, or <code>null</code> if a video category map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoCategoryMap fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video category map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mapId the primary key of the video category map
	 * @return the video category map, or <code>null</code> if a video category map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategoryMap fetchByPrimaryKey(long mapId)
		throws SystemException {
		VideoCategoryMap videoCategoryMap = (VideoCategoryMap)EntityCacheUtil.getResult(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
				VideoCategoryMapImpl.class, mapId);

		if (videoCategoryMap == _nullVideoCategoryMap) {
			return null;
		}

		if (videoCategoryMap == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				videoCategoryMap = (VideoCategoryMap)session.get(VideoCategoryMapImpl.class,
						Long.valueOf(mapId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (videoCategoryMap != null) {
					cacheResult(videoCategoryMap);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VideoCategoryMapModelImpl.ENTITY_CACHE_ENABLED,
						VideoCategoryMapImpl.class, mapId, _nullVideoCategoryMap);
				}

				closeSession(session);
			}
		}

		return videoCategoryMap;
	}

	/**
	 * Returns all the video category maps where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching video category maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategoryMap> findByCategory(long categoryId)
		throws SystemException {
		return findByCategory(categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the video category maps where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video category maps
	 * @param end the upper bound of the range of video category maps (not inclusive)
	 * @return the range of matching video category maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategoryMap> findByCategory(long categoryId, int start,
		int end) throws SystemException {
		return findByCategory(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video category maps where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video category maps
	 * @param end the upper bound of the range of video category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video category maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategoryMap> findByCategory(long categoryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId, start, end, orderByComparator };
		}

		List<VideoCategoryMap> list = (List<VideoCategoryMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VideoCategoryMap videoCategoryMap : list) {
				if ((categoryId != videoCategoryMap.getCategoryId())) {
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
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_VIDEOCATEGORYMAP_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				list = (List<VideoCategoryMap>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first video category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video category map
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a matching video category map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategoryMap findByCategory_First(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoCategoryMapException, SystemException {
		VideoCategoryMap videoCategoryMap = fetchByCategory_First(categoryId,
				orderByComparator);

		if (videoCategoryMap != null) {
			return videoCategoryMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoCategoryMapException(msg.toString());
	}

	/**
	 * Returns the first video category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video category map, or <code>null</code> if a matching video category map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategoryMap fetchByCategory_First(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VideoCategoryMap> list = findByCategory(categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video category map
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a matching video category map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategoryMap findByCategory_Last(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoCategoryMapException, SystemException {
		VideoCategoryMap videoCategoryMap = fetchByCategory_Last(categoryId,
				orderByComparator);

		if (videoCategoryMap != null) {
			return videoCategoryMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoCategoryMapException(msg.toString());
	}

	/**
	 * Returns the last video category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video category map, or <code>null</code> if a matching video category map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategoryMap fetchByCategory_Last(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(categoryId);

		List<VideoCategoryMap> list = findByCategory(categoryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video category maps before and after the current video category map in the ordered set where categoryId = &#63;.
	 *
	 * @param mapId the primary key of the current video category map
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video category map
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a video category map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategoryMap[] findByCategory_PrevAndNext(long mapId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchVideoCategoryMapException, SystemException {
		VideoCategoryMap videoCategoryMap = findByPrimaryKey(mapId);

		Session session = null;

		try {
			session = openSession();

			VideoCategoryMap[] array = new VideoCategoryMapImpl[3];

			array[0] = getByCategory_PrevAndNext(session, videoCategoryMap,
					categoryId, orderByComparator, true);

			array[1] = videoCategoryMap;

			array[2] = getByCategory_PrevAndNext(session, videoCategoryMap,
					categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VideoCategoryMap getByCategory_PrevAndNext(Session session,
		VideoCategoryMap videoCategoryMap, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOCATEGORYMAP_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoCategoryMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoCategoryMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video category maps where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @return the matching video category maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategoryMap> findByEntry(long entryId)
		throws SystemException {
		return findByEntry(entryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video category maps where entryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId the entry ID
	 * @param start the lower bound of the range of video category maps
	 * @param end the upper bound of the range of video category maps (not inclusive)
	 * @return the range of matching video category maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategoryMap> findByEntry(long entryId, int start, int end)
		throws SystemException {
		return findByEntry(entryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video category maps where entryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId the entry ID
	 * @param start the lower bound of the range of video category maps
	 * @param end the upper bound of the range of video category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video category maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategoryMap> findByEntry(long entryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRY;
			finderArgs = new Object[] { entryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTRY;
			finderArgs = new Object[] { entryId, start, end, orderByComparator };
		}

		List<VideoCategoryMap> list = (List<VideoCategoryMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VideoCategoryMap videoCategoryMap : list) {
				if ((entryId != videoCategoryMap.getEntryId())) {
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
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_VIDEOCATEGORYMAP_WHERE);

			query.append(_FINDER_COLUMN_ENTRY_ENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryId);

				list = (List<VideoCategoryMap>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first video category map in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video category map
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a matching video category map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategoryMap findByEntry_First(long entryId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoCategoryMapException, SystemException {
		VideoCategoryMap videoCategoryMap = fetchByEntry_First(entryId,
				orderByComparator);

		if (videoCategoryMap != null) {
			return videoCategoryMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("entryId=");
		msg.append(entryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoCategoryMapException(msg.toString());
	}

	/**
	 * Returns the first video category map in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video category map, or <code>null</code> if a matching video category map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategoryMap fetchByEntry_First(long entryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VideoCategoryMap> list = findByEntry(entryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video category map in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video category map
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a matching video category map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategoryMap findByEntry_Last(long entryId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoCategoryMapException, SystemException {
		VideoCategoryMap videoCategoryMap = fetchByEntry_Last(entryId,
				orderByComparator);

		if (videoCategoryMap != null) {
			return videoCategoryMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("entryId=");
		msg.append(entryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoCategoryMapException(msg.toString());
	}

	/**
	 * Returns the last video category map in the ordered set where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video category map, or <code>null</code> if a matching video category map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategoryMap fetchByEntry_Last(long entryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEntry(entryId);

		List<VideoCategoryMap> list = findByEntry(entryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video category maps before and after the current video category map in the ordered set where entryId = &#63;.
	 *
	 * @param mapId the primary key of the current video category map
	 * @param entryId the entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video category map
	 * @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a video category map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoCategoryMap[] findByEntry_PrevAndNext(long mapId, long entryId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoCategoryMapException, SystemException {
		VideoCategoryMap videoCategoryMap = findByPrimaryKey(mapId);

		Session session = null;

		try {
			session = openSession();

			VideoCategoryMap[] array = new VideoCategoryMapImpl[3];

			array[0] = getByEntry_PrevAndNext(session, videoCategoryMap,
					entryId, orderByComparator, true);

			array[1] = videoCategoryMap;

			array[2] = getByEntry_PrevAndNext(session, videoCategoryMap,
					entryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VideoCategoryMap getByEntry_PrevAndNext(Session session,
		VideoCategoryMap videoCategoryMap, long entryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOCATEGORYMAP_WHERE);

		query.append(_FINDER_COLUMN_ENTRY_ENTRYID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(entryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoCategoryMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoCategoryMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video category maps.
	 *
	 * @return the video category maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategoryMap> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video category maps
	 * @param end the upper bound of the range of video category maps (not inclusive)
	 * @return the range of video category maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategoryMap> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video category maps
	 * @param end the upper bound of the range of video category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video category maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoCategoryMap> findAll(int start, int end,
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

		List<VideoCategoryMap> list = (List<VideoCategoryMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEOCATEGORYMAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOCATEGORYMAP;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VideoCategoryMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VideoCategoryMap>)QueryUtil.list(q,
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
	 * Removes all the video category maps where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategory(long categoryId) throws SystemException {
		for (VideoCategoryMap videoCategoryMap : findByCategory(categoryId)) {
			remove(videoCategoryMap);
		}
	}

	/**
	 * Removes all the video category maps where entryId = &#63; from the database.
	 *
	 * @param entryId the entry ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEntry(long entryId) throws SystemException {
		for (VideoCategoryMap videoCategoryMap : findByEntry(entryId)) {
			remove(videoCategoryMap);
		}
	}

	/**
	 * Removes all the video category maps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VideoCategoryMap videoCategoryMap : findAll()) {
			remove(videoCategoryMap);
		}
	}

	/**
	 * Returns the number of video category maps where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching video category maps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategory(long categoryId) throws SystemException {
		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOCATEGORYMAP_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video category maps where entryId = &#63;.
	 *
	 * @param entryId the entry ID
	 * @return the number of matching video category maps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEntry(long entryId) throws SystemException {
		Object[] finderArgs = new Object[] { entryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ENTRY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOCATEGORYMAP_WHERE);

			query.append(_FINDER_COLUMN_ENTRY_ENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTRY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video category maps.
	 *
	 * @return the number of video category maps
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEOCATEGORYMAP);

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
	 * Initializes the video category map persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.video.model.VideoCategoryMap")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VideoCategoryMap>> listenersList = new ArrayList<ModelListener<VideoCategoryMap>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VideoCategoryMap>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VideoCategoryMapImpl.class.getName());
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
	private static final String _SQL_SELECT_VIDEOCATEGORYMAP = "SELECT videoCategoryMap FROM VideoCategoryMap videoCategoryMap";
	private static final String _SQL_SELECT_VIDEOCATEGORYMAP_WHERE = "SELECT videoCategoryMap FROM VideoCategoryMap videoCategoryMap WHERE ";
	private static final String _SQL_COUNT_VIDEOCATEGORYMAP = "SELECT COUNT(videoCategoryMap) FROM VideoCategoryMap videoCategoryMap";
	private static final String _SQL_COUNT_VIDEOCATEGORYMAP_WHERE = "SELECT COUNT(videoCategoryMap) FROM VideoCategoryMap videoCategoryMap WHERE ";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 = "videoCategoryMap.categoryId = ?";
	private static final String _FINDER_COLUMN_ENTRY_ENTRYID_2 = "videoCategoryMap.entryId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoCategoryMap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoCategoryMap exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VideoCategoryMap exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideoCategoryMapPersistenceImpl.class);
	private static VideoCategoryMap _nullVideoCategoryMap = new VideoCategoryMapImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VideoCategoryMap> toCacheModel() {
				return _nullVideoCategoryMapCacheModel;
			}
		};

	private static CacheModel<VideoCategoryMap> _nullVideoCategoryMapCacheModel = new CacheModel<VideoCategoryMap>() {
			public VideoCategoryMap toEntityModel() {
				return _nullVideoCategoryMap;
			}
		};
}