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

import com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException;
import com.bkav.portal.portlet.audioplayer.model.AudioFile;
import com.bkav.portal.portlet.audioplayer.model.impl.AudioFileImpl;
import com.bkav.portal.portlet.audioplayer.model.impl.AudioFileModelImpl;

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
 * The persistence implementation for the audio file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see AudioFilePersistence
 * @see AudioFileUtil
 * @generated
 */
public class AudioFilePersistenceImpl extends BasePersistenceImpl<AudioFile>
	implements AudioFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AudioFileUtil} to access the audio file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AudioFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
			AudioFileModelImpl.FINDER_CACHE_ENABLED, AudioFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
			AudioFileModelImpl.FINDER_CACHE_ENABLED, AudioFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			AudioFileModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
			AudioFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
			AudioFileModelImpl.FINDER_CACHE_ENABLED, AudioFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
			AudioFileModelImpl.FINDER_CACHE_ENABLED, AudioFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			AudioFileModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
			AudioFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
			AudioFileModelImpl.FINDER_CACHE_ENABLED, AudioFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
			AudioFileModelImpl.FINDER_CACHE_ENABLED, AudioFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
			AudioFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the audio file in the entity cache if it is enabled.
	 *
	 * @param audioFile the audio file
	 */
	public void cacheResult(AudioFile audioFile) {
		EntityCacheUtil.putResult(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
			AudioFileImpl.class, audioFile.getPrimaryKey(), audioFile);

		audioFile.resetOriginalValues();
	}

	/**
	 * Caches the audio files in the entity cache if it is enabled.
	 *
	 * @param audioFiles the audio files
	 */
	public void cacheResult(List<AudioFile> audioFiles) {
		for (AudioFile audioFile : audioFiles) {
			if (EntityCacheUtil.getResult(
						AudioFileModelImpl.ENTITY_CACHE_ENABLED,
						AudioFileImpl.class, audioFile.getPrimaryKey()) == null) {
				cacheResult(audioFile);
			}
			else {
				audioFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all audio files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AudioFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AudioFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the audio file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AudioFile audioFile) {
		EntityCacheUtil.removeResult(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
			AudioFileImpl.class, audioFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AudioFile> audioFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AudioFile audioFile : audioFiles) {
			EntityCacheUtil.removeResult(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
				AudioFileImpl.class, audioFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new audio file with the primary key. Does not add the audio file to the database.
	 *
	 * @param audioId the primary key for the new audio file
	 * @return the new audio file
	 */
	public AudioFile create(long audioId) {
		AudioFile audioFile = new AudioFileImpl();

		audioFile.setNew(true);
		audioFile.setPrimaryKey(audioId);

		return audioFile;
	}

	/**
	 * Removes the audio file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param audioId the primary key of the audio file
	 * @return the audio file that was removed
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a audio file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile remove(long audioId)
		throws NoSuchAudioFileException, SystemException {
		return remove(Long.valueOf(audioId));
	}

	/**
	 * Removes the audio file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the audio file
	 * @return the audio file that was removed
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a audio file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AudioFile remove(Serializable primaryKey)
		throws NoSuchAudioFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AudioFile audioFile = (AudioFile)session.get(AudioFileImpl.class,
					primaryKey);

			if (audioFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAudioFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(audioFile);
		}
		catch (NoSuchAudioFileException nsee) {
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
	protected AudioFile removeImpl(AudioFile audioFile)
		throws SystemException {
		audioFile = toUnwrappedModel(audioFile);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, audioFile);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(audioFile);

		return audioFile;
	}

	@Override
	public AudioFile updateImpl(
		com.bkav.portal.portlet.audioplayer.model.AudioFile audioFile,
		boolean merge) throws SystemException {
		audioFile = toUnwrappedModel(audioFile);

		boolean isNew = audioFile.isNew();

		AudioFileModelImpl audioFileModelImpl = (AudioFileModelImpl)audioFile;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, audioFile, merge);

			audioFile.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AudioFileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((audioFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(audioFileModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(audioFileModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((audioFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(audioFileModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(audioFileModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
			AudioFileImpl.class, audioFile.getPrimaryKey(), audioFile);

		return audioFile;
	}

	protected AudioFile toUnwrappedModel(AudioFile audioFile) {
		if (audioFile instanceof AudioFileImpl) {
			return audioFile;
		}

		AudioFileImpl audioFileImpl = new AudioFileImpl();

		audioFileImpl.setNew(audioFile.isNew());
		audioFileImpl.setPrimaryKey(audioFile.getPrimaryKey());

		audioFileImpl.setAudioId(audioFile.getAudioId());
		audioFileImpl.setAudioName(audioFile.getAudioName());
		audioFileImpl.setAudioInfo(audioFile.getAudioInfo());
		audioFileImpl.setAudioType(audioFile.getAudioType());
		audioFileImpl.setAudioFileId(audioFile.getAudioFileId());
		audioFileImpl.setCreateDate(audioFile.getCreateDate());
		audioFileImpl.setModifyDate(audioFile.getModifyDate());
		audioFileImpl.setGroupId(audioFile.getGroupId());
		audioFileImpl.setCompanyId(audioFile.getCompanyId());
		audioFileImpl.setUserId(audioFile.getUserId());
		audioFileImpl.setUserName(audioFile.getUserName());
		audioFileImpl.setViewCounter(audioFile.getViewCounter());

		return audioFileImpl;
	}

	/**
	 * Returns the audio file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the audio file
	 * @return the audio file
	 * @throws com.liferay.portal.NoSuchModelException if a audio file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AudioFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the audio file with the primary key or throws a {@link com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException} if it could not be found.
	 *
	 * @param audioId the primary key of the audio file
	 * @return the audio file
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a audio file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile findByPrimaryKey(long audioId)
		throws NoSuchAudioFileException, SystemException {
		AudioFile audioFile = fetchByPrimaryKey(audioId);

		if (audioFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + audioId);
			}

			throw new NoSuchAudioFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				audioId);
		}

		return audioFile;
	}

	/**
	 * Returns the audio file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the audio file
	 * @return the audio file, or <code>null</code> if a audio file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AudioFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the audio file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param audioId the primary key of the audio file
	 * @return the audio file, or <code>null</code> if a audio file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile fetchByPrimaryKey(long audioId) throws SystemException {
		AudioFile audioFile = (AudioFile)EntityCacheUtil.getResult(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
				AudioFileImpl.class, audioId);

		if (audioFile == _nullAudioFile) {
			return null;
		}

		if (audioFile == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				audioFile = (AudioFile)session.get(AudioFileImpl.class,
						Long.valueOf(audioId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (audioFile != null) {
					cacheResult(audioFile);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AudioFileModelImpl.ENTITY_CACHE_ENABLED,
						AudioFileImpl.class, audioId, _nullAudioFile);
				}

				closeSession(session);
			}
		}

		return audioFile;
	}

	/**
	 * Returns all the audio files where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching audio files
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioFile> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the audio files where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of audio files
	 * @param end the upper bound of the range of audio files (not inclusive)
	 * @return the range of matching audio files
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioFile> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the audio files where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of audio files
	 * @param end the upper bound of the range of audio files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audio files
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioFile> findByGroupId(long groupId, int start, int end,
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

		List<AudioFile> list = (List<AudioFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AudioFile audioFile : list) {
				if ((groupId != audioFile.getGroupId())) {
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

			query.append(_SQL_SELECT_AUDIOFILE_WHERE);

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

				list = (List<AudioFile>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first audio file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audio file
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a matching audio file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAudioFileException, SystemException {
		AudioFile audioFile = fetchByGroupId_First(groupId, orderByComparator);

		if (audioFile != null) {
			return audioFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAudioFileException(msg.toString());
	}

	/**
	 * Returns the first audio file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audio file, or <code>null</code> if a matching audio file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AudioFile> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last audio file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audio file
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a matching audio file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAudioFileException, SystemException {
		AudioFile audioFile = fetchByGroupId_Last(groupId, orderByComparator);

		if (audioFile != null) {
			return audioFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAudioFileException(msg.toString());
	}

	/**
	 * Returns the last audio file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audio file, or <code>null</code> if a matching audio file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		List<AudioFile> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the audio files before and after the current audio file in the ordered set where groupId = &#63;.
	 *
	 * @param audioId the primary key of the current audio file
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audio file
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a audio file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile[] findByGroupId_PrevAndNext(long audioId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAudioFileException, SystemException {
		AudioFile audioFile = findByPrimaryKey(audioId);

		Session session = null;

		try {
			session = openSession();

			AudioFile[] array = new AudioFileImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, audioFile, groupId,
					orderByComparator, true);

			array[1] = audioFile;

			array[2] = getByGroupId_PrevAndNext(session, audioFile, groupId,
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

	protected AudioFile getByGroupId_PrevAndNext(Session session,
		AudioFile audioFile, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AUDIOFILE_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(audioFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AudioFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the audio files that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching audio files that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioFile> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the audio files that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of audio files
	 * @param end the upper bound of the range of audio files (not inclusive)
	 * @return the range of matching audio files that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioFile> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the audio files that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of audio files
	 * @param end the upper bound of the range of audio files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audio files that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioFile> filterFindByGroupId(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_AUDIOFILE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_AUDIOFILE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_AUDIOFILE_NO_INLINE_DISTINCT_WHERE_2);
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
				AudioFile.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, AudioFileImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, AudioFileImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<AudioFile>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the audio files before and after the current audio file in the ordered set of audio files that the user has permission to view where groupId = &#63;.
	 *
	 * @param audioId the primary key of the current audio file
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audio file
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a audio file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile[] filterFindByGroupId_PrevAndNext(long audioId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchAudioFileException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(audioId, groupId, orderByComparator);
		}

		AudioFile audioFile = findByPrimaryKey(audioId);

		Session session = null;

		try {
			session = openSession();

			AudioFile[] array = new AudioFileImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, audioFile,
					groupId, orderByComparator, true);

			array[1] = audioFile;

			array[2] = filterGetByGroupId_PrevAndNext(session, audioFile,
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

	protected AudioFile filterGetByGroupId_PrevAndNext(Session session,
		AudioFile audioFile, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_AUDIOFILE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_AUDIOFILE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_AUDIOFILE_NO_INLINE_DISTINCT_WHERE_2);
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
				AudioFile.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, AudioFileImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, AudioFileImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(audioFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AudioFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the audio files where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching audio files
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioFile> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the audio files where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of audio files
	 * @param end the upper bound of the range of audio files (not inclusive)
	 * @return the range of matching audio files
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioFile> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the audio files where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of audio files
	 * @param end the upper bound of the range of audio files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audio files
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioFile> findByCompanyId(long companyId, int start, int end,
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

		List<AudioFile> list = (List<AudioFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AudioFile audioFile : list) {
				if ((companyId != audioFile.getCompanyId())) {
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

			query.append(_SQL_SELECT_AUDIOFILE_WHERE);

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

				list = (List<AudioFile>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first audio file in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audio file
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a matching audio file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAudioFileException, SystemException {
		AudioFile audioFile = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (audioFile != null) {
			return audioFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAudioFileException(msg.toString());
	}

	/**
	 * Returns the first audio file in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audio file, or <code>null</code> if a matching audio file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AudioFile> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last audio file in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audio file
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a matching audio file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAudioFileException, SystemException {
		AudioFile audioFile = fetchByCompanyId_Last(companyId, orderByComparator);

		if (audioFile != null) {
			return audioFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAudioFileException(msg.toString());
	}

	/**
	 * Returns the last audio file in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audio file, or <code>null</code> if a matching audio file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<AudioFile> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the audio files before and after the current audio file in the ordered set where companyId = &#63;.
	 *
	 * @param audioId the primary key of the current audio file
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audio file
	 * @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a audio file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AudioFile[] findByCompanyId_PrevAndNext(long audioId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchAudioFileException, SystemException {
		AudioFile audioFile = findByPrimaryKey(audioId);

		Session session = null;

		try {
			session = openSession();

			AudioFile[] array = new AudioFileImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, audioFile,
					companyId, orderByComparator, true);

			array[1] = audioFile;

			array[2] = getByCompanyId_PrevAndNext(session, audioFile,
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

	protected AudioFile getByCompanyId_PrevAndNext(Session session,
		AudioFile audioFile, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AUDIOFILE_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(audioFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AudioFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the audio files.
	 *
	 * @return the audio files
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the audio files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of audio files
	 * @param end the upper bound of the range of audio files (not inclusive)
	 * @return the range of audio files
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioFile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the audio files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of audio files
	 * @param end the upper bound of the range of audio files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of audio files
	 * @throws SystemException if a system exception occurred
	 */
	public List<AudioFile> findAll(int start, int end,
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

		List<AudioFile> list = (List<AudioFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AUDIOFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUDIOFILE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AudioFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AudioFile>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the audio files where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (AudioFile audioFile : findByGroupId(groupId)) {
			remove(audioFile);
		}
	}

	/**
	 * Removes all the audio files where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (AudioFile audioFile : findByCompanyId(companyId)) {
			remove(audioFile);
		}
	}

	/**
	 * Removes all the audio files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AudioFile audioFile : findAll()) {
			remove(audioFile);
		}
	}

	/**
	 * Returns the number of audio files where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching audio files
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AUDIOFILE_WHERE);

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
	 * Returns the number of audio files that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching audio files that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_AUDIOFILE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				AudioFile.class.getName(),
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
	 * Returns the number of audio files where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching audio files
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AUDIOFILE_WHERE);

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
	 * Returns the number of audio files.
	 *
	 * @return the number of audio files
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AUDIOFILE);

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
	 * Initializes the audio file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.audioplayer.model.AudioFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AudioFile>> listenersList = new ArrayList<ModelListener<AudioFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AudioFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AudioFileImpl.class.getName());
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
	private static final String _SQL_SELECT_AUDIOFILE = "SELECT audioFile FROM AudioFile audioFile";
	private static final String _SQL_SELECT_AUDIOFILE_WHERE = "SELECT audioFile FROM AudioFile audioFile WHERE ";
	private static final String _SQL_COUNT_AUDIOFILE = "SELECT COUNT(audioFile) FROM AudioFile audioFile";
	private static final String _SQL_COUNT_AUDIOFILE_WHERE = "SELECT COUNT(audioFile) FROM AudioFile audioFile WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "audioFile.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "audioFile.companyId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "audioFile.audioId";
	private static final String _FILTER_SQL_SELECT_AUDIOFILE_WHERE = "SELECT DISTINCT {audioFile.*} FROM AudioPlayer_AudioFile audioFile WHERE ";
	private static final String _FILTER_SQL_SELECT_AUDIOFILE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {AudioPlayer_AudioFile.*} FROM (SELECT DISTINCT audioFile.audioId FROM AudioPlayer_AudioFile audioFile WHERE ";
	private static final String _FILTER_SQL_SELECT_AUDIOFILE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN AudioPlayer_AudioFile ON TEMP_TABLE.audioId = AudioPlayer_AudioFile.audioId";
	private static final String _FILTER_SQL_COUNT_AUDIOFILE_WHERE = "SELECT COUNT(DISTINCT audioFile.audioId) AS COUNT_VALUE FROM AudioPlayer_AudioFile audioFile WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "audioFile";
	private static final String _FILTER_ENTITY_TABLE = "AudioPlayer_AudioFile";
	private static final String _ORDER_BY_ENTITY_ALIAS = "audioFile.";
	private static final String _ORDER_BY_ENTITY_TABLE = "AudioPlayer_AudioFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AudioFile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AudioFile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AudioFilePersistenceImpl.class);
	private static AudioFile _nullAudioFile = new AudioFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AudioFile> toCacheModel() {
				return _nullAudioFileCacheModel;
			}
		};

	private static CacheModel<AudioFile> _nullAudioFileCacheModel = new CacheModel<AudioFile>() {
			public AudioFile toEntityModel() {
				return _nullAudioFile;
			}
		};
}