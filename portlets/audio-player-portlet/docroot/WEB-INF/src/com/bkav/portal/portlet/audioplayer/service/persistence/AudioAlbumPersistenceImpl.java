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

import com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException;
import com.bkav.portal.portlet.audioplayer.model.AudioAlbum;
import com.bkav.portal.portlet.audioplayer.model.impl.AudioAlbumImpl;
import com.bkav.portal.portlet.audioplayer.model.impl.AudioAlbumModelImpl;

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
 * The persistence implementation for the audio album service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see AudioAlbumPersistence
 * @see AudioAlbumUtil
 * @generated
 */
public class AudioAlbumPersistenceImpl extends BasePersistenceImpl<AudioAlbum>
	implements AudioAlbumPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AudioAlbumUtil} to access the audio album persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AudioAlbumImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
			AudioAlbumModelImpl.FINDER_CACHE_ENABLED, AudioAlbumImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
			AudioAlbumModelImpl.FINDER_CACHE_ENABLED, AudioAlbumImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			AudioAlbumModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
			AudioAlbumModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
			AudioAlbumModelImpl.FINDER_CACHE_ENABLED, AudioAlbumImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
			AudioAlbumModelImpl.FINDER_CACHE_ENABLED, AudioAlbumImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			AudioAlbumModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
			AudioAlbumModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
			AudioAlbumModelImpl.FINDER_CACHE_ENABLED, AudioAlbumImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
			AudioAlbumModelImpl.FINDER_CACHE_ENABLED, AudioAlbumImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
			AudioAlbumModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the audio album in the entity cache if it is enabled.
	 *
	 * @param audioAlbum the audio album
	 */
	public void cacheResult(AudioAlbum audioAlbum) {
		EntityCacheUtil.putResult(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
			AudioAlbumImpl.class, audioAlbum.getPrimaryKey(), audioAlbum);

		audioAlbum.resetOriginalValues();
	}

	/**
	 * Caches the audio albums in the entity cache if it is enabled.
	 *
	 * @param audioAlbums the audio albums
	 */
	public void cacheResult(List<AudioAlbum> audioAlbums) {
		for (AudioAlbum audioAlbum : audioAlbums) {
			if (EntityCacheUtil.getResult(
						AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
						AudioAlbumImpl.class, audioAlbum.getPrimaryKey()) == null) {
				cacheResult(audioAlbum);
			}
			else {
				audioAlbum.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all audio albums.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AudioAlbumImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AudioAlbumImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the audio album.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AudioAlbum audioAlbum) {
		EntityCacheUtil.removeResult(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
			AudioAlbumImpl.class, audioAlbum.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AudioAlbum> audioAlbums) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AudioAlbum audioAlbum : audioAlbums) {
			EntityCacheUtil.removeResult(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
				AudioAlbumImpl.class, audioAlbum.getPrimaryKey());
		}
	}

	/**
	 * Creates a new audio album with the primary key. Does not add the audio album to the database.
	 *
	 * @param albumId the primary key for the new audio album
	 * @return the new audio album
	 */
	public AudioAlbum create(long albumId) {
		AudioAlbum audioAlbum = new AudioAlbumImpl();

		audioAlbum.setNew(true);
		audioAlbum.setPrimaryKey(albumId);

		return audioAlbum;
	}

	/**
	 * Removes the audio album with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param albumId the primary key of the audio album
	 * @return the audio album that was removed
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a audio album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioAlbum remove(long albumId)
		throws NoSuchAudioAlbumException, SystemException {
		return remove(Long.valueOf(albumId));
	}

	/**
	 * Removes the audio album with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the audio album
	 * @return the audio album that was removed
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a audio album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AudioAlbum remove(Serializable primaryKey)
		throws NoSuchAudioAlbumException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AudioAlbum audioAlbum = (AudioAlbum)session.get(AudioAlbumImpl.class,
					primaryKey);

			if (audioAlbum == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAudioAlbumException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(audioAlbum);
		}
		catch (NoSuchAudioAlbumException nsee) {
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
	protected AudioAlbum removeImpl(AudioAlbum audioAlbum)
		throws SystemException {
		audioAlbum = toUnwrappedModel(audioAlbum);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, audioAlbum);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(audioAlbum);

		return audioAlbum;
	}

	@Override
	public AudioAlbum updateImpl(
		com.bkav.portal.portlet.audioplayer.model.AudioAlbum audioAlbum,
		boolean merge) throws SystemException {
		audioAlbum = toUnwrappedModel(audioAlbum);

		boolean isNew = audioAlbum.isNew();

		AudioAlbumModelImpl audioAlbumModelImpl = (AudioAlbumModelImpl)audioAlbum;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, audioAlbum, merge);

			audioAlbum.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AudioAlbumModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((audioAlbumModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(audioAlbumModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(audioAlbumModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((audioAlbumModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(audioAlbumModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(audioAlbumModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
			AudioAlbumImpl.class, audioAlbum.getPrimaryKey(), audioAlbum);

		return audioAlbum;
	}

	protected AudioAlbum toUnwrappedModel(AudioAlbum audioAlbum) {
		if (audioAlbum instanceof AudioAlbumImpl) {
			return audioAlbum;
		}

		AudioAlbumImpl audioAlbumImpl = new AudioAlbumImpl();

		audioAlbumImpl.setNew(audioAlbum.isNew());
		audioAlbumImpl.setPrimaryKey(audioAlbum.getPrimaryKey());

		audioAlbumImpl.setAlbumId(audioAlbum.getAlbumId());
		audioAlbumImpl.setAlbumName(audioAlbum.getAlbumName());
		audioAlbumImpl.setAlbumInfo(audioAlbum.getAlbumInfo());
		audioAlbumImpl.setAlbumCoverId(audioAlbum.getAlbumCoverId());
		audioAlbumImpl.setCreateDate(audioAlbum.getCreateDate());
		audioAlbumImpl.setModifyDate(audioAlbum.getModifyDate());
		audioAlbumImpl.setGroupId(audioAlbum.getGroupId());
		audioAlbumImpl.setCompanyId(audioAlbum.getCompanyId());
		audioAlbumImpl.setUserId(audioAlbum.getUserId());
		audioAlbumImpl.setUserName(audioAlbum.getUserName());
		audioAlbumImpl.setViewCounter(audioAlbum.getViewCounter());

		return audioAlbumImpl;
	}

	/**
	 * Returns the audio album with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the audio album
	 * @return the audio album
	 * @throws com.liferay.portal.NoSuchModelException if a audio album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AudioAlbum findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the audio album with the primary key or throws a {@link com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException} if it could not be found.
	 *
	 * @param albumId the primary key of the audio album
	 * @return the audio album
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a audio album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioAlbum findByPrimaryKey(long albumId)
		throws NoSuchAudioAlbumException, SystemException {
		AudioAlbum audioAlbum = fetchByPrimaryKey(albumId);

		if (audioAlbum == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + albumId);
			}

			throw new NoSuchAudioAlbumException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				albumId);
		}

		return audioAlbum;
	}

	/**
	 * Returns the audio album with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the audio album
	 * @return the audio album, or <code>null</code> if a audio album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AudioAlbum fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the audio album with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param albumId the primary key of the audio album
	 * @return the audio album, or <code>null</code> if a audio album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioAlbum fetchByPrimaryKey(long albumId) throws SystemException {
		AudioAlbum audioAlbum = (AudioAlbum)EntityCacheUtil.getResult(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
				AudioAlbumImpl.class, albumId);

		if (audioAlbum == _nullAudioAlbum) {
			return null;
		}

		if (audioAlbum == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				audioAlbum = (AudioAlbum)session.get(AudioAlbumImpl.class,
						Long.valueOf(albumId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (audioAlbum != null) {
					cacheResult(audioAlbum);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AudioAlbumModelImpl.ENTITY_CACHE_ENABLED,
						AudioAlbumImpl.class, albumId, _nullAudioAlbum);
				}

				closeSession(session);
			}
		}

		return audioAlbum;
	}

	/**
	 * Returns all the audio albums where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching audio albums
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioAlbum> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the audio albums where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of audio albums
	 * @param end the upper bound of the range of audio albums (not inclusive)
	 * @return the range of matching audio albums
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioAlbum> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the audio albums where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of audio albums
	 * @param end the upper bound of the range of audio albums (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audio albums
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioAlbum> findByGroupId(long groupId, int start, int end,
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

		List<AudioAlbum> list = (List<AudioAlbum>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AudioAlbum audioAlbum : list) {
				if ((groupId != audioAlbum.getGroupId())) {
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

			query.append(_SQL_SELECT_AUDIOALBUM_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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

				qPos.add(groupId);

				list = (List<AudioAlbum>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first audio album in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audio album
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a matching audio album could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioAlbum findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAudioAlbumException, SystemException {
		AudioAlbum audioAlbum = fetchByGroupId_First(groupId, orderByComparator);

		if (audioAlbum != null) {
			return audioAlbum;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAudioAlbumException(msg.toString());
	}

	/**
	 * Returns the first audio album in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audio album, or <code>null</code> if a matching audio album could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioAlbum fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AudioAlbum> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last audio album in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audio album
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a matching audio album could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioAlbum findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAudioAlbumException, SystemException {
		AudioAlbum audioAlbum = fetchByGroupId_Last(groupId, orderByComparator);

		if (audioAlbum != null) {
			return audioAlbum;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAudioAlbumException(msg.toString());
	}

	/**
	 * Returns the last audio album in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audio album, or <code>null</code> if a matching audio album could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioAlbum fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		List<AudioAlbum> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the audio albums before and after the current audio album in the ordered set where groupId = &#63;.
	 *
	 * @param albumId the primary key of the current audio album
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audio album
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a audio album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioAlbum[] findByGroupId_PrevAndNext(long albumId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAudioAlbumException, SystemException {
		AudioAlbum audioAlbum = findByPrimaryKey(albumId);

		Session session = null;

		try {
			session = openSession();

			AudioAlbum[] array = new AudioAlbumImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, audioAlbum, groupId,
					orderByComparator, true);

			array[1] = audioAlbum;

			array[2] = getByGroupId_PrevAndNext(session, audioAlbum, groupId,
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

	protected AudioAlbum getByGroupId_PrevAndNext(Session session,
		AudioAlbum audioAlbum, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AUDIOALBUM_WHERE);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(audioAlbum);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AudioAlbum> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the audio albums that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching audio albums that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioAlbum> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the audio albums that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of audio albums
	 * @param end the upper bound of the range of audio albums (not inclusive)
	 * @return the range of matching audio albums that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioAlbum> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the audio albums that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of audio albums
	 * @param end the upper bound of the range of audio albums (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audio albums that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioAlbum> filterFindByGroupId(long groupId, int start,
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
			query = new StringBundler(2);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_AUDIOALBUM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_AUDIOALBUM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_AUDIOALBUM_NO_INLINE_DISTINCT_WHERE_2);
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

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				AudioAlbum.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, AudioAlbumImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, AudioAlbumImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<AudioAlbum>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the audio albums before and after the current audio album in the ordered set of audio albums that the user has permission to view where groupId = &#63;.
	 *
	 * @param albumId the primary key of the current audio album
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audio album
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a audio album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioAlbum[] filterFindByGroupId_PrevAndNext(long albumId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchAudioAlbumException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(albumId, groupId, orderByComparator);
		}

		AudioAlbum audioAlbum = findByPrimaryKey(albumId);

		Session session = null;

		try {
			session = openSession();

			AudioAlbum[] array = new AudioAlbumImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, audioAlbum,
					groupId, orderByComparator, true);

			array[1] = audioAlbum;

			array[2] = filterGetByGroupId_PrevAndNext(session, audioAlbum,
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

	protected AudioAlbum filterGetByGroupId_PrevAndNext(Session session,
		AudioAlbum audioAlbum, long groupId,
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
			query.append(_FILTER_SQL_SELECT_AUDIOALBUM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_AUDIOALBUM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_AUDIOALBUM_NO_INLINE_DISTINCT_WHERE_2);
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

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				AudioAlbum.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, AudioAlbumImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, AudioAlbumImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(audioAlbum);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AudioAlbum> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the audio albums where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching audio albums
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioAlbum> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the audio albums where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of audio albums
	 * @param end the upper bound of the range of audio albums (not inclusive)
	 * @return the range of matching audio albums
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioAlbum> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the audio albums where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of audio albums
	 * @param end the upper bound of the range of audio albums (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audio albums
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioAlbum> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<AudioAlbum> list = (List<AudioAlbum>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AudioAlbum audioAlbum : list) {
				if ((companyId != audioAlbum.getCompanyId())) {
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

			query.append(_SQL_SELECT_AUDIOALBUM_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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

				qPos.add(companyId);

				list = (List<AudioAlbum>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first audio album in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audio album
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a matching audio album could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioAlbum findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAudioAlbumException, SystemException {
		AudioAlbum audioAlbum = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (audioAlbum != null) {
			return audioAlbum;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAudioAlbumException(msg.toString());
	}

	/**
	 * Returns the first audio album in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audio album, or <code>null</code> if a matching audio album could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioAlbum fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AudioAlbum> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last audio album in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audio album
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a matching audio album could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioAlbum findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAudioAlbumException, SystemException {
		AudioAlbum audioAlbum = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (audioAlbum != null) {
			return audioAlbum;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAudioAlbumException(msg.toString());
	}

	/**
	 * Returns the last audio album in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audio album, or <code>null</code> if a matching audio album could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioAlbum fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<AudioAlbum> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the audio albums before and after the current audio album in the ordered set where companyId = &#63;.
	 *
	 * @param albumId the primary key of the current audio album
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audio album
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a audio album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioAlbum[] findByCompanyId_PrevAndNext(long albumId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchAudioAlbumException, SystemException {
		AudioAlbum audioAlbum = findByPrimaryKey(albumId);

		Session session = null;

		try {
			session = openSession();

			AudioAlbum[] array = new AudioAlbumImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, audioAlbum,
					companyId, orderByComparator, true);

			array[1] = audioAlbum;

			array[2] = getByCompanyId_PrevAndNext(session, audioAlbum,
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

	protected AudioAlbum getByCompanyId_PrevAndNext(Session session,
		AudioAlbum audioAlbum, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AUDIOALBUM_WHERE);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(audioAlbum);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AudioAlbum> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the audio albums.
	 *
	 * @return the audio albums
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioAlbum> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the audio albums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of audio albums
	 * @param end the upper bound of the range of audio albums (not inclusive)
	 * @return the range of audio albums
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioAlbum> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the audio albums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of audio albums
	 * @param end the upper bound of the range of audio albums (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of audio albums
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioAlbum> findAll(int start, int end,
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

		List<AudioAlbum> list = (List<AudioAlbum>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AUDIOALBUM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUDIOALBUM;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AudioAlbum>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AudioAlbum>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the audio albums where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (AudioAlbum audioAlbum : findByGroupId(groupId)) {
			remove(audioAlbum);
		}
	}

	/**
	 * Removes all the audio albums where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (AudioAlbum audioAlbum : findByCompanyId(companyId)) {
			remove(audioAlbum);
		}
	}

	/**
	 * Removes all the audio albums from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AudioAlbum audioAlbum : findAll()) {
			remove(audioAlbum);
		}
	}

	/**
	 * Returns the number of audio albums where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching audio albums
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AUDIOALBUM_WHERE);

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
	 * Returns the number of audio albums that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching audio albums that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_AUDIOALBUM_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				AudioAlbum.class.getName(),
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
	 * Returns the number of audio albums where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching audio albums
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AUDIOALBUM_WHERE);

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
	 * Returns the number of audio albums.
	 *
	 * @return the number of audio albums
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AUDIOALBUM);

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
	 * Initializes the audio album persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.audioplayer.model.AudioAlbum")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AudioAlbum>> listenersList = new ArrayList<ModelListener<AudioAlbum>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AudioAlbum>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AudioAlbumImpl.class.getName());
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
	private static final String _SQL_SELECT_AUDIOALBUM = "SELECT audioAlbum FROM AudioAlbum audioAlbum";
	private static final String _SQL_SELECT_AUDIOALBUM_WHERE = "SELECT audioAlbum FROM AudioAlbum audioAlbum WHERE ";
	private static final String _SQL_COUNT_AUDIOALBUM = "SELECT COUNT(audioAlbum) FROM AudioAlbum audioAlbum";
	private static final String _SQL_COUNT_AUDIOALBUM_WHERE = "SELECT COUNT(audioAlbum) FROM AudioAlbum audioAlbum WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "audioAlbum.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "audioAlbum.companyId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "audioAlbum.albumId";
	private static final String _FILTER_SQL_SELECT_AUDIOALBUM_WHERE = "SELECT DISTINCT {audioAlbum.*} FROM AudioPlayer_AudioAlbum audioAlbum WHERE ";
	private static final String _FILTER_SQL_SELECT_AUDIOALBUM_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {AudioPlayer_AudioAlbum.*} FROM (SELECT DISTINCT audioAlbum.albumId FROM AudioPlayer_AudioAlbum audioAlbum WHERE ";
	private static final String _FILTER_SQL_SELECT_AUDIOALBUM_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN AudioPlayer_AudioAlbum ON TEMP_TABLE.albumId = AudioPlayer_AudioAlbum.albumId";
	private static final String _FILTER_SQL_COUNT_AUDIOALBUM_WHERE = "SELECT COUNT(DISTINCT audioAlbum.albumId) AS COUNT_VALUE FROM AudioPlayer_AudioAlbum audioAlbum WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "audioAlbum";
	private static final String _FILTER_ENTITY_TABLE = "AudioPlayer_AudioAlbum";
	private static final String _ORDER_BY_ENTITY_ALIAS = "audioAlbum.";
	private static final String _ORDER_BY_ENTITY_TABLE = "AudioPlayer_AudioAlbum.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AudioAlbum exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AudioAlbum exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AudioAlbumPersistenceImpl.class);
	private static AudioAlbum _nullAudioAlbum = new AudioAlbumImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AudioAlbum> toCacheModel() {
				return _nullAudioAlbumCacheModel;
			}
		};

	private static CacheModel<AudioAlbum> _nullAudioAlbumCacheModel = new CacheModel<AudioAlbum>() {
			public AudioAlbum toEntityModel() {
				return _nullAudioAlbum;
			}
		};
}