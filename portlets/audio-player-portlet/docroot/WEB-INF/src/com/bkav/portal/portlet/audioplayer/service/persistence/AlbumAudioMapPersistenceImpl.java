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

package com.bkav.portal.portlet.audioplayer.service.persistence;

import com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException;
import com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap;
import com.bkav.portal.portlet.audioplayer.model.impl.AlbumAudioMapImpl;
import com.bkav.portal.portlet.audioplayer.model.impl.AlbumAudioMapModelImpl;

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
 * The persistence implementation for the album audio map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see AlbumAudioMapPersistence
 * @see AlbumAudioMapUtil
 * @generated
 */
public class AlbumAudioMapPersistenceImpl extends BasePersistenceImpl<AlbumAudioMap>
	implements AlbumAudioMapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AlbumAudioMapUtil} to access the album audio map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AlbumAudioMapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALBUM = new FinderPath(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapModelImpl.FINDER_CACHE_ENABLED,
			AlbumAudioMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAlbum",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUM = new FinderPath(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapModelImpl.FINDER_CACHE_ENABLED,
			AlbumAudioMapImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAlbum", new String[] { Long.class.getName() },
			AlbumAudioMapModelImpl.ALBUMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALBUM = new FinderPath(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAlbum",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUDIO = new FinderPath(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapModelImpl.FINDER_CACHE_ENABLED,
			AlbumAudioMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAudio",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIO = new FinderPath(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapModelImpl.FINDER_CACHE_ENABLED,
			AlbumAudioMapImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAudio", new String[] { Long.class.getName() },
			AlbumAudioMapModelImpl.AUDIOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUDIO = new FinderPath(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAudio",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUDIOALBUM =
		new FinderPath(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapModelImpl.FINDER_CACHE_ENABLED,
			AlbumAudioMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAudioAlbum",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIOALBUM =
		new FinderPath(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapModelImpl.FINDER_CACHE_ENABLED,
			AlbumAudioMapImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAudioAlbum",
			new String[] { Long.class.getName(), Long.class.getName() },
			AlbumAudioMapModelImpl.AUDIOID_COLUMN_BITMASK |
			AlbumAudioMapModelImpl.ALBUMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUDIOALBUM = new FinderPath(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAudioAlbum",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapModelImpl.FINDER_CACHE_ENABLED,
			AlbumAudioMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapModelImpl.FINDER_CACHE_ENABLED,
			AlbumAudioMapImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the album audio map in the entity cache if it is enabled.
	 *
	 * @param albumAudioMap the album audio map
	 */
	public void cacheResult(AlbumAudioMap albumAudioMap) {
		EntityCacheUtil.putResult(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapImpl.class, albumAudioMap.getPrimaryKey(),
			albumAudioMap);

		albumAudioMap.resetOriginalValues();
	}

	/**
	 * Caches the album audio maps in the entity cache if it is enabled.
	 *
	 * @param albumAudioMaps the album audio maps
	 */
	public void cacheResult(List<AlbumAudioMap> albumAudioMaps) {
		for (AlbumAudioMap albumAudioMap : albumAudioMaps) {
			if (EntityCacheUtil.getResult(
						AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
						AlbumAudioMapImpl.class, albumAudioMap.getPrimaryKey()) == null) {
				cacheResult(albumAudioMap);
			}
			else {
				albumAudioMap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all album audio maps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AlbumAudioMapImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AlbumAudioMapImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the album audio map.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AlbumAudioMap albumAudioMap) {
		EntityCacheUtil.removeResult(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapImpl.class, albumAudioMap.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AlbumAudioMap> albumAudioMaps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AlbumAudioMap albumAudioMap : albumAudioMaps) {
			EntityCacheUtil.removeResult(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
				AlbumAudioMapImpl.class, albumAudioMap.getPrimaryKey());
		}
	}

	/**
	 * Creates a new album audio map with the primary key. Does not add the album audio map to the database.
	 *
	 * @param mapId the primary key for the new album audio map
	 * @return the new album audio map
	 */
	public AlbumAudioMap create(long mapId) {
		AlbumAudioMap albumAudioMap = new AlbumAudioMapImpl();

		albumAudioMap.setNew(true);
		albumAudioMap.setPrimaryKey(mapId);

		return albumAudioMap;
	}

	/**
	 * Removes the album audio map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapId the primary key of the album audio map
	 * @return the album audio map that was removed
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a album audio map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap remove(long mapId)
		throws NoSuchAlbumAudioMapException, SystemException {
		return remove(Long.valueOf(mapId));
	}

	/**
	 * Removes the album audio map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the album audio map
	 * @return the album audio map that was removed
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a album audio map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AlbumAudioMap remove(Serializable primaryKey)
		throws NoSuchAlbumAudioMapException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AlbumAudioMap albumAudioMap = (AlbumAudioMap)session.get(AlbumAudioMapImpl.class,
					primaryKey);

			if (albumAudioMap == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAlbumAudioMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(albumAudioMap);
		}
		catch (NoSuchAlbumAudioMapException nsee) {
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
	protected AlbumAudioMap removeImpl(AlbumAudioMap albumAudioMap)
		throws SystemException {
		albumAudioMap = toUnwrappedModel(albumAudioMap);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, albumAudioMap);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(albumAudioMap);

		return albumAudioMap;
	}

	@Override
	public AlbumAudioMap updateImpl(
		com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap albumAudioMap,
		boolean merge) throws SystemException {
		albumAudioMap = toUnwrappedModel(albumAudioMap);

		boolean isNew = albumAudioMap.isNew();

		AlbumAudioMapModelImpl albumAudioMapModelImpl = (AlbumAudioMapModelImpl)albumAudioMap;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, albumAudioMap, merge);

			albumAudioMap.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AlbumAudioMapModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((albumAudioMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(albumAudioMapModelImpl.getOriginalAlbumId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALBUM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUM,
					args);

				args = new Object[] {
						Long.valueOf(albumAudioMapModelImpl.getAlbumId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALBUM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUM,
					args);
			}

			if ((albumAudioMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(albumAudioMapModelImpl.getOriginalAudioId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUDIO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIO,
					args);

				args = new Object[] {
						Long.valueOf(albumAudioMapModelImpl.getAudioId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUDIO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIO,
					args);
			}

			if ((albumAudioMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIOALBUM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(albumAudioMapModelImpl.getOriginalAudioId()),
						Long.valueOf(albumAudioMapModelImpl.getOriginalAlbumId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUDIOALBUM,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIOALBUM,
					args);

				args = new Object[] {
						Long.valueOf(albumAudioMapModelImpl.getAudioId()),
						Long.valueOf(albumAudioMapModelImpl.getAlbumId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUDIOALBUM,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIOALBUM,
					args);
			}
		}

		EntityCacheUtil.putResult(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
			AlbumAudioMapImpl.class, albumAudioMap.getPrimaryKey(),
			albumAudioMap);

		return albumAudioMap;
	}

	protected AlbumAudioMap toUnwrappedModel(AlbumAudioMap albumAudioMap) {
		if (albumAudioMap instanceof AlbumAudioMapImpl) {
			return albumAudioMap;
		}

		AlbumAudioMapImpl albumAudioMapImpl = new AlbumAudioMapImpl();

		albumAudioMapImpl.setNew(albumAudioMap.isNew());
		albumAudioMapImpl.setPrimaryKey(albumAudioMap.getPrimaryKey());

		albumAudioMapImpl.setMapId(albumAudioMap.getMapId());
		albumAudioMapImpl.setAlbumId(albumAudioMap.getAlbumId());
		albumAudioMapImpl.setAudioId(albumAudioMap.getAudioId());

		return albumAudioMapImpl;
	}

	/**
	 * Returns the album audio map with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the album audio map
	 * @return the album audio map
	 * @throws com.liferay.portal.NoSuchModelException if a album audio map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AlbumAudioMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the album audio map with the primary key or throws a {@link com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException} if it could not be found.
	 *
	 * @param mapId the primary key of the album audio map
	 * @return the album audio map
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a album audio map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap findByPrimaryKey(long mapId)
		throws NoSuchAlbumAudioMapException, SystemException {
		AlbumAudioMap albumAudioMap = fetchByPrimaryKey(mapId);

		if (albumAudioMap == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + mapId);
			}

			throw new NoSuchAlbumAudioMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				mapId);
		}

		return albumAudioMap;
	}

	/**
	 * Returns the album audio map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the album audio map
	 * @return the album audio map, or <code>null</code> if a album audio map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AlbumAudioMap fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the album audio map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mapId the primary key of the album audio map
	 * @return the album audio map, or <code>null</code> if a album audio map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap fetchByPrimaryKey(long mapId)
		throws SystemException {
		AlbumAudioMap albumAudioMap = (AlbumAudioMap)EntityCacheUtil.getResult(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
				AlbumAudioMapImpl.class, mapId);

		if (albumAudioMap == _nullAlbumAudioMap) {
			return null;
		}

		if (albumAudioMap == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				albumAudioMap = (AlbumAudioMap)session.get(AlbumAudioMapImpl.class,
						Long.valueOf(mapId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (albumAudioMap != null) {
					cacheResult(albumAudioMap);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AlbumAudioMapModelImpl.ENTITY_CACHE_ENABLED,
						AlbumAudioMapImpl.class, mapId, _nullAlbumAudioMap);
				}

				closeSession(session);
			}
		}

		return albumAudioMap;
	}

	/**
	 * Returns all the album audio maps where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @return the matching album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<AlbumAudioMap> findByAlbum(long albumId)
		throws SystemException {
		return findByAlbum(albumId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the album audio maps where albumId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param albumId the album ID
	 * @param start the lower bound of the range of album audio maps
	 * @param end the upper bound of the range of album audio maps (not inclusive)
	 * @return the range of matching album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<AlbumAudioMap> findByAlbum(long albumId, int start, int end)
		throws SystemException {
		return findByAlbum(albumId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the album audio maps where albumId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param albumId the album ID
	 * @param start the lower bound of the range of album audio maps
	 * @param end the upper bound of the range of album audio maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<AlbumAudioMap> findByAlbum(long albumId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUM;
			finderArgs = new Object[] { albumId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALBUM;
			finderArgs = new Object[] { albumId, start, end, orderByComparator };
		}

		List<AlbumAudioMap> list = (List<AlbumAudioMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AlbumAudioMap albumAudioMap : list) {
				if ((albumId != albumAudioMap.getAlbumId())) {
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

			query.append(_SQL_SELECT_ALBUMAUDIOMAP_WHERE);

			query.append(_FINDER_COLUMN_ALBUM_ALBUMID_2);

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

				qPos.add(albumId);

				list = (List<AlbumAudioMap>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first album audio map in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching album audio map
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap findByAlbum_First(long albumId,
		OrderByComparator orderByComparator)
		throws NoSuchAlbumAudioMapException, SystemException {
		AlbumAudioMap albumAudioMap = fetchByAlbum_First(albumId,
				orderByComparator);

		if (albumAudioMap != null) {
			return albumAudioMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("albumId=");
		msg.append(albumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAlbumAudioMapException(msg.toString());
	}

	/**
	 * Returns the first album audio map in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching album audio map, or <code>null</code> if a matching album audio map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap fetchByAlbum_First(long albumId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AlbumAudioMap> list = findByAlbum(albumId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last album audio map in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching album audio map
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap findByAlbum_Last(long albumId,
		OrderByComparator orderByComparator)
		throws NoSuchAlbumAudioMapException, SystemException {
		AlbumAudioMap albumAudioMap = fetchByAlbum_Last(albumId,
				orderByComparator);

		if (albumAudioMap != null) {
			return albumAudioMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("albumId=");
		msg.append(albumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAlbumAudioMapException(msg.toString());
	}

	/**
	 * Returns the last album audio map in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching album audio map, or <code>null</code> if a matching album audio map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap fetchByAlbum_Last(long albumId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAlbum(albumId);

		List<AlbumAudioMap> list = findByAlbum(albumId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the album audio maps before and after the current album audio map in the ordered set where albumId = &#63;.
	 *
	 * @param mapId the primary key of the current album audio map
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next album audio map
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a album audio map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap[] findByAlbum_PrevAndNext(long mapId, long albumId,
		OrderByComparator orderByComparator)
		throws NoSuchAlbumAudioMapException, SystemException {
		AlbumAudioMap albumAudioMap = findByPrimaryKey(mapId);

		Session session = null;

		try {
			session = openSession();

			AlbumAudioMap[] array = new AlbumAudioMapImpl[3];

			array[0] = getByAlbum_PrevAndNext(session, albumAudioMap, albumId,
					orderByComparator, true);

			array[1] = albumAudioMap;

			array[2] = getByAlbum_PrevAndNext(session, albumAudioMap, albumId,
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

	protected AlbumAudioMap getByAlbum_PrevAndNext(Session session,
		AlbumAudioMap albumAudioMap, long albumId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ALBUMAUDIOMAP_WHERE);

		query.append(_FINDER_COLUMN_ALBUM_ALBUMID_2);

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

		qPos.add(albumId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(albumAudioMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AlbumAudioMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the album audio maps where audioId = &#63;.
	 *
	 * @param audioId the audio ID
	 * @return the matching album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<AlbumAudioMap> findByAudio(long audioId)
		throws SystemException {
		return findByAudio(audioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the album audio maps where audioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param audioId the audio ID
	 * @param start the lower bound of the range of album audio maps
	 * @param end the upper bound of the range of album audio maps (not inclusive)
	 * @return the range of matching album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<AlbumAudioMap> findByAudio(long audioId, int start, int end)
		throws SystemException {
		return findByAudio(audioId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the album audio maps where audioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param audioId the audio ID
	 * @param start the lower bound of the range of album audio maps
	 * @param end the upper bound of the range of album audio maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<AlbumAudioMap> findByAudio(long audioId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIO;
			finderArgs = new Object[] { audioId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUDIO;
			finderArgs = new Object[] { audioId, start, end, orderByComparator };
		}

		List<AlbumAudioMap> list = (List<AlbumAudioMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AlbumAudioMap albumAudioMap : list) {
				if ((audioId != albumAudioMap.getAudioId())) {
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

			query.append(_SQL_SELECT_ALBUMAUDIOMAP_WHERE);

			query.append(_FINDER_COLUMN_AUDIO_AUDIOID_2);

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

				qPos.add(audioId);

				list = (List<AlbumAudioMap>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first album audio map in the ordered set where audioId = &#63;.
	 *
	 * @param audioId the audio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching album audio map
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap findByAudio_First(long audioId,
		OrderByComparator orderByComparator)
		throws NoSuchAlbumAudioMapException, SystemException {
		AlbumAudioMap albumAudioMap = fetchByAudio_First(audioId,
				orderByComparator);

		if (albumAudioMap != null) {
			return albumAudioMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("audioId=");
		msg.append(audioId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAlbumAudioMapException(msg.toString());
	}

	/**
	 * Returns the first album audio map in the ordered set where audioId = &#63;.
	 *
	 * @param audioId the audio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching album audio map, or <code>null</code> if a matching album audio map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap fetchByAudio_First(long audioId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AlbumAudioMap> list = findByAudio(audioId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last album audio map in the ordered set where audioId = &#63;.
	 *
	 * @param audioId the audio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching album audio map
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap findByAudio_Last(long audioId,
		OrderByComparator orderByComparator)
		throws NoSuchAlbumAudioMapException, SystemException {
		AlbumAudioMap albumAudioMap = fetchByAudio_Last(audioId,
				orderByComparator);

		if (albumAudioMap != null) {
			return albumAudioMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("audioId=");
		msg.append(audioId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAlbumAudioMapException(msg.toString());
	}

	/**
	 * Returns the last album audio map in the ordered set where audioId = &#63;.
	 *
	 * @param audioId the audio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching album audio map, or <code>null</code> if a matching album audio map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap fetchByAudio_Last(long audioId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAudio(audioId);

		List<AlbumAudioMap> list = findByAudio(audioId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the album audio maps before and after the current album audio map in the ordered set where audioId = &#63;.
	 *
	 * @param mapId the primary key of the current album audio map
	 * @param audioId the audio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next album audio map
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a album audio map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap[] findByAudio_PrevAndNext(long mapId, long audioId,
		OrderByComparator orderByComparator)
		throws NoSuchAlbumAudioMapException, SystemException {
		AlbumAudioMap albumAudioMap = findByPrimaryKey(mapId);

		Session session = null;

		try {
			session = openSession();

			AlbumAudioMap[] array = new AlbumAudioMapImpl[3];

			array[0] = getByAudio_PrevAndNext(session, albumAudioMap, audioId,
					orderByComparator, true);

			array[1] = albumAudioMap;

			array[2] = getByAudio_PrevAndNext(session, albumAudioMap, audioId,
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

	protected AlbumAudioMap getByAudio_PrevAndNext(Session session,
		AlbumAudioMap albumAudioMap, long audioId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ALBUMAUDIOMAP_WHERE);

		query.append(_FINDER_COLUMN_AUDIO_AUDIOID_2);

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

		qPos.add(audioId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(albumAudioMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AlbumAudioMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the album audio maps where audioId = &#63; and albumId = &#63;.
	 *
	 * @param audioId the audio ID
	 * @param albumId the album ID
	 * @return the matching album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<AlbumAudioMap> findByAudioAlbum(long audioId, long albumId)
		throws SystemException {
		return findByAudioAlbum(audioId, albumId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the album audio maps where audioId = &#63; and albumId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param audioId the audio ID
	 * @param albumId the album ID
	 * @param start the lower bound of the range of album audio maps
	 * @param end the upper bound of the range of album audio maps (not inclusive)
	 * @return the range of matching album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<AlbumAudioMap> findByAudioAlbum(long audioId, long albumId,
		int start, int end) throws SystemException {
		return findByAudioAlbum(audioId, albumId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the album audio maps where audioId = &#63; and albumId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param audioId the audio ID
	 * @param albumId the album ID
	 * @param start the lower bound of the range of album audio maps
	 * @param end the upper bound of the range of album audio maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<AlbumAudioMap> findByAudioAlbum(long audioId, long albumId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUDIOALBUM;
			finderArgs = new Object[] { audioId, albumId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUDIOALBUM;
			finderArgs = new Object[] {
					audioId, albumId,
					
					start, end, orderByComparator
				};
		}

		List<AlbumAudioMap> list = (List<AlbumAudioMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AlbumAudioMap albumAudioMap : list) {
				if ((audioId != albumAudioMap.getAudioId()) ||
						(albumId != albumAudioMap.getAlbumId())) {
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
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ALBUMAUDIOMAP_WHERE);

			query.append(_FINDER_COLUMN_AUDIOALBUM_AUDIOID_2);

			query.append(_FINDER_COLUMN_AUDIOALBUM_ALBUMID_2);

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

				qPos.add(audioId);

				qPos.add(albumId);

				list = (List<AlbumAudioMap>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first album audio map in the ordered set where audioId = &#63; and albumId = &#63;.
	 *
	 * @param audioId the audio ID
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching album audio map
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap findByAudioAlbum_First(long audioId, long albumId,
		OrderByComparator orderByComparator)
		throws NoSuchAlbumAudioMapException, SystemException {
		AlbumAudioMap albumAudioMap = fetchByAudioAlbum_First(audioId, albumId,
				orderByComparator);

		if (albumAudioMap != null) {
			return albumAudioMap;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("audioId=");
		msg.append(audioId);

		msg.append(", albumId=");
		msg.append(albumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAlbumAudioMapException(msg.toString());
	}

	/**
	 * Returns the first album audio map in the ordered set where audioId = &#63; and albumId = &#63;.
	 *
	 * @param audioId the audio ID
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching album audio map, or <code>null</code> if a matching album audio map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap fetchByAudioAlbum_First(long audioId, long albumId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AlbumAudioMap> list = findByAudioAlbum(audioId, albumId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last album audio map in the ordered set where audioId = &#63; and albumId = &#63;.
	 *
	 * @param audioId the audio ID
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching album audio map
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap findByAudioAlbum_Last(long audioId, long albumId,
		OrderByComparator orderByComparator)
		throws NoSuchAlbumAudioMapException, SystemException {
		AlbumAudioMap albumAudioMap = fetchByAudioAlbum_Last(audioId, albumId,
				orderByComparator);

		if (albumAudioMap != null) {
			return albumAudioMap;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("audioId=");
		msg.append(audioId);

		msg.append(", albumId=");
		msg.append(albumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAlbumAudioMapException(msg.toString());
	}

	/**
	 * Returns the last album audio map in the ordered set where audioId = &#63; and albumId = &#63;.
	 *
	 * @param audioId the audio ID
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching album audio map, or <code>null</code> if a matching album audio map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap fetchByAudioAlbum_Last(long audioId, long albumId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAudioAlbum(audioId, albumId);

		List<AlbumAudioMap> list = findByAudioAlbum(audioId, albumId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the album audio maps before and after the current album audio map in the ordered set where audioId = &#63; and albumId = &#63;.
	 *
	 * @param mapId the primary key of the current album audio map
	 * @param audioId the audio ID
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next album audio map
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a album audio map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AlbumAudioMap[] findByAudioAlbum_PrevAndNext(long mapId,
		long audioId, long albumId, OrderByComparator orderByComparator)
		throws NoSuchAlbumAudioMapException, SystemException {
		AlbumAudioMap albumAudioMap = findByPrimaryKey(mapId);

		Session session = null;

		try {
			session = openSession();

			AlbumAudioMap[] array = new AlbumAudioMapImpl[3];

			array[0] = getByAudioAlbum_PrevAndNext(session, albumAudioMap,
					audioId, albumId, orderByComparator, true);

			array[1] = albumAudioMap;

			array[2] = getByAudioAlbum_PrevAndNext(session, albumAudioMap,
					audioId, albumId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AlbumAudioMap getByAudioAlbum_PrevAndNext(Session session,
		AlbumAudioMap albumAudioMap, long audioId, long albumId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ALBUMAUDIOMAP_WHERE);

		query.append(_FINDER_COLUMN_AUDIOALBUM_AUDIOID_2);

		query.append(_FINDER_COLUMN_AUDIOALBUM_ALBUMID_2);

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

		qPos.add(audioId);

		qPos.add(albumId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(albumAudioMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AlbumAudioMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the album audio maps.
	 *
	 * @return the album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<AlbumAudioMap> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the album audio maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of album audio maps
	 * @param end the upper bound of the range of album audio maps (not inclusive)
	 * @return the range of album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<AlbumAudioMap> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the album audio maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of album audio maps
	 * @param end the upper bound of the range of album audio maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public List<AlbumAudioMap> findAll(int start, int end,
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

		List<AlbumAudioMap> list = (List<AlbumAudioMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ALBUMAUDIOMAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ALBUMAUDIOMAP;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AlbumAudioMap>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AlbumAudioMap>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the album audio maps where albumId = &#63; from the database.
	 *
	 * @param albumId the album ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAlbum(long albumId) throws SystemException {
		for (AlbumAudioMap albumAudioMap : findByAlbum(albumId)) {
			remove(albumAudioMap);
		}
	}

	/**
	 * Removes all the album audio maps where audioId = &#63; from the database.
	 *
	 * @param audioId the audio ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAudio(long audioId) throws SystemException {
		for (AlbumAudioMap albumAudioMap : findByAudio(audioId)) {
			remove(albumAudioMap);
		}
	}

	/**
	 * Removes all the album audio maps where audioId = &#63; and albumId = &#63; from the database.
	 *
	 * @param audioId the audio ID
	 * @param albumId the album ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAudioAlbum(long audioId, long albumId)
		throws SystemException {
		for (AlbumAudioMap albumAudioMap : findByAudioAlbum(audioId, albumId)) {
			remove(albumAudioMap);
		}
	}

	/**
	 * Removes all the album audio maps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AlbumAudioMap albumAudioMap : findAll()) {
			remove(albumAudioMap);
		}
	}

	/**
	 * Returns the number of album audio maps where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @return the number of matching album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAlbum(long albumId) throws SystemException {
		Object[] finderArgs = new Object[] { albumId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ALBUM,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ALBUMAUDIOMAP_WHERE);

			query.append(_FINDER_COLUMN_ALBUM_ALBUMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(albumId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ALBUM,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of album audio maps where audioId = &#63;.
	 *
	 * @param audioId the audio ID
	 * @return the number of matching album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAudio(long audioId) throws SystemException {
		Object[] finderArgs = new Object[] { audioId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AUDIO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ALBUMAUDIOMAP_WHERE);

			query.append(_FINDER_COLUMN_AUDIO_AUDIOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(audioId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AUDIO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of album audio maps where audioId = &#63; and albumId = &#63;.
	 *
	 * @param audioId the audio ID
	 * @param albumId the album ID
	 * @return the number of matching album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAudioAlbum(long audioId, long albumId)
		throws SystemException {
		Object[] finderArgs = new Object[] { audioId, albumId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AUDIOALBUM,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ALBUMAUDIOMAP_WHERE);

			query.append(_FINDER_COLUMN_AUDIOALBUM_AUDIOID_2);

			query.append(_FINDER_COLUMN_AUDIOALBUM_ALBUMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(audioId);

				qPos.add(albumId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AUDIOALBUM,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of album audio maps.
	 *
	 * @return the number of album audio maps
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ALBUMAUDIOMAP);

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
	 * Initializes the album audio map persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AlbumAudioMap>> listenersList = new ArrayList<ModelListener<AlbumAudioMap>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AlbumAudioMap>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AlbumAudioMapImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AlbumAudioMapPersistence.class)
	protected AlbumAudioMapPersistence albumAudioMapPersistence;
	@BeanReference(type = AudioAlbumPersistence.class)
	protected AudioAlbumPersistence audioAlbumPersistence;
	@BeanReference(type = AudioFilePersistence.class)
	protected AudioFilePersistence audioFilePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ALBUMAUDIOMAP = "SELECT albumAudioMap FROM AlbumAudioMap albumAudioMap";
	private static final String _SQL_SELECT_ALBUMAUDIOMAP_WHERE = "SELECT albumAudioMap FROM AlbumAudioMap albumAudioMap WHERE ";
	private static final String _SQL_COUNT_ALBUMAUDIOMAP = "SELECT COUNT(albumAudioMap) FROM AlbumAudioMap albumAudioMap";
	private static final String _SQL_COUNT_ALBUMAUDIOMAP_WHERE = "SELECT COUNT(albumAudioMap) FROM AlbumAudioMap albumAudioMap WHERE ";
	private static final String _FINDER_COLUMN_ALBUM_ALBUMID_2 = "albumAudioMap.albumId = ?";
	private static final String _FINDER_COLUMN_AUDIO_AUDIOID_2 = "albumAudioMap.audioId = ?";
	private static final String _FINDER_COLUMN_AUDIOALBUM_AUDIOID_2 = "albumAudioMap.audioId = ? AND ";
	private static final String _FINDER_COLUMN_AUDIOALBUM_ALBUMID_2 = "albumAudioMap.albumId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "albumAudioMap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AlbumAudioMap exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AlbumAudioMap exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AlbumAudioMapPersistenceImpl.class);
	private static AlbumAudioMap _nullAlbumAudioMap = new AlbumAudioMapImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AlbumAudioMap> toCacheModel() {
				return _nullAlbumAudioMapCacheModel;
			}
		};

	private static CacheModel<AlbumAudioMap> _nullAlbumAudioMapCacheModel = new CacheModel<AlbumAudioMap>() {
			public AlbumAudioMap toEntityModel() {
				return _nullAlbumAudioMap;
			}
		};
}