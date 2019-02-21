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

package com.bkav.portal.portlet.contentsharing.service.persistence;

import com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException;
import com.bkav.portal.portlet.contentsharing.model.ContentSharing;
import com.bkav.portal.portlet.contentsharing.model.impl.ContentSharingImpl;
import com.bkav.portal.portlet.contentsharing.model.impl.ContentSharingModelImpl;

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
 * The persistence implementation for the content sharing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see ContentSharingPersistence
 * @see ContentSharingUtil
 * @generated
 */
public class ContentSharingPersistenceImpl extends BasePersistenceImpl<ContentSharing>
	implements ContentSharingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContentSharingUtil} to access the content sharing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContentSharingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_COMPANYID = new FinderPath(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
			ContentSharingModelImpl.FINDER_CACHE_ENABLED,
			ContentSharingImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBycompanyId", new String[] { Long.class.getName() },
			ContentSharingModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
			ContentSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
			ContentSharingModelImpl.FINDER_CACHE_ENABLED,
			ContentSharingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBygroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
			ContentSharingModelImpl.FINDER_CACHE_ENABLED,
			ContentSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygroupId",
			new String[] { Long.class.getName() },
			ContentSharingModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
			ContentSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_COMPANYIDANDGROUPID = new FinderPath(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
			ContentSharingModelImpl.FINDER_CACHE_ENABLED,
			ContentSharingImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBycompanyIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContentSharingModelImpl.COMPANYID_COLUMN_BITMASK |
			ContentSharingModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID = new FinderPath(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
			ContentSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycompanyIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
			ContentSharingModelImpl.FINDER_CACHE_ENABLED,
			ContentSharingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
			ContentSharingModelImpl.FINDER_CACHE_ENABLED,
			ContentSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
			ContentSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the content sharing in the entity cache if it is enabled.
	 *
	 * @param contentSharing the content sharing
	 */
	public void cacheResult(ContentSharing contentSharing) {
		EntityCacheUtil.putResult(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
			ContentSharingImpl.class, contentSharing.getPrimaryKey(),
			contentSharing);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYID,
			new Object[] { Long.valueOf(contentSharing.getCompanyId()) },
			contentSharing);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDANDGROUPID,
			new Object[] {
				Long.valueOf(contentSharing.getCompanyId()),
				Long.valueOf(contentSharing.getGroupId())
			}, contentSharing);

		contentSharing.resetOriginalValues();
	}

	/**
	 * Caches the content sharings in the entity cache if it is enabled.
	 *
	 * @param contentSharings the content sharings
	 */
	public void cacheResult(List<ContentSharing> contentSharings) {
		for (ContentSharing contentSharing : contentSharings) {
			if (EntityCacheUtil.getResult(
						ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
						ContentSharingImpl.class, contentSharing.getPrimaryKey()) == null) {
				cacheResult(contentSharing);
			}
			else {
				contentSharing.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all content sharings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContentSharingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContentSharingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the content sharing.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContentSharing contentSharing) {
		EntityCacheUtil.removeResult(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
			ContentSharingImpl.class, contentSharing.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(contentSharing);
	}

	@Override
	public void clearCache(List<ContentSharing> contentSharings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContentSharing contentSharing : contentSharings) {
			EntityCacheUtil.removeResult(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
				ContentSharingImpl.class, contentSharing.getPrimaryKey());

			clearUniqueFindersCache(contentSharing);
		}
	}

	protected void clearUniqueFindersCache(ContentSharing contentSharing) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYID,
			new Object[] { Long.valueOf(contentSharing.getCompanyId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYIDANDGROUPID,
			new Object[] {
				Long.valueOf(contentSharing.getCompanyId()),
				Long.valueOf(contentSharing.getGroupId())
			});
	}

	/**
	 * Creates a new content sharing with the primary key. Does not add the content sharing to the database.
	 *
	 * @param contentId the primary key for the new content sharing
	 * @return the new content sharing
	 */
	public ContentSharing create(long contentId) {
		ContentSharing contentSharing = new ContentSharingImpl();

		contentSharing.setNew(true);
		contentSharing.setPrimaryKey(contentId);

		return contentSharing;
	}

	/**
	 * Removes the content sharing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contentId the primary key of the content sharing
	 * @return the content sharing that was removed
	 * @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a content sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing remove(long contentId)
		throws NoSuchContentSharingException, SystemException {
		return remove(Long.valueOf(contentId));
	}

	/**
	 * Removes the content sharing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the content sharing
	 * @return the content sharing that was removed
	 * @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a content sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentSharing remove(Serializable primaryKey)
		throws NoSuchContentSharingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContentSharing contentSharing = (ContentSharing)session.get(ContentSharingImpl.class,
					primaryKey);

			if (contentSharing == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContentSharingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contentSharing);
		}
		catch (NoSuchContentSharingException nsee) {
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
	protected ContentSharing removeImpl(ContentSharing contentSharing)
		throws SystemException {
		contentSharing = toUnwrappedModel(contentSharing);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, contentSharing);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(contentSharing);

		return contentSharing;
	}

	@Override
	public ContentSharing updateImpl(
		com.bkav.portal.portlet.contentsharing.model.ContentSharing contentSharing,
		boolean merge) throws SystemException {
		contentSharing = toUnwrappedModel(contentSharing);

		boolean isNew = contentSharing.isNew();

		ContentSharingModelImpl contentSharingModelImpl = (ContentSharingModelImpl)contentSharing;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, contentSharing, merge);

			contentSharing.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContentSharingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contentSharingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contentSharingModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(contentSharingModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
			ContentSharingImpl.class, contentSharing.getPrimaryKey(),
			contentSharing);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYID,
				new Object[] { Long.valueOf(contentSharing.getCompanyId()) },
				contentSharing);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDANDGROUPID,
				new Object[] {
					Long.valueOf(contentSharing.getCompanyId()),
					Long.valueOf(contentSharing.getGroupId())
				}, contentSharing);
		}
		else {
			if ((contentSharingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contentSharingModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYID,
					new Object[] { Long.valueOf(contentSharing.getCompanyId()) },
					contentSharing);
			}

			if ((contentSharingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COMPANYIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contentSharingModelImpl.getOriginalCompanyId()),
						Long.valueOf(contentSharingModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYIDANDGROUPID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDANDGROUPID,
					new Object[] {
						Long.valueOf(contentSharing.getCompanyId()),
						Long.valueOf(contentSharing.getGroupId())
					}, contentSharing);
			}
		}

		return contentSharing;
	}

	protected ContentSharing toUnwrappedModel(ContentSharing contentSharing) {
		if (contentSharing instanceof ContentSharingImpl) {
			return contentSharing;
		}

		ContentSharingImpl contentSharingImpl = new ContentSharingImpl();

		contentSharingImpl.setNew(contentSharing.isNew());
		contentSharingImpl.setPrimaryKey(contentSharing.getPrimaryKey());

		contentSharingImpl.setContentId(contentSharing.getContentId());
		contentSharingImpl.setCompanyId(contentSharing.getCompanyId());
		contentSharingImpl.setGroupId(contentSharing.getGroupId());
		contentSharingImpl.setUserId(contentSharing.getUserId());
		contentSharingImpl.setContentSharing(contentSharing.getContentSharing());

		return contentSharingImpl;
	}

	/**
	 * Returns the content sharing with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the content sharing
	 * @return the content sharing
	 * @throws com.liferay.portal.NoSuchModelException if a content sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentSharing findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the content sharing with the primary key or throws a {@link com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException} if it could not be found.
	 *
	 * @param contentId the primary key of the content sharing
	 * @return the content sharing
	 * @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a content sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing findByPrimaryKey(long contentId)
		throws NoSuchContentSharingException, SystemException {
		ContentSharing contentSharing = fetchByPrimaryKey(contentId);

		if (contentSharing == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + contentId);
			}

			throw new NoSuchContentSharingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				contentId);
		}

		return contentSharing;
	}

	/**
	 * Returns the content sharing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the content sharing
	 * @return the content sharing, or <code>null</code> if a content sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContentSharing fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the content sharing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contentId the primary key of the content sharing
	 * @return the content sharing, or <code>null</code> if a content sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing fetchByPrimaryKey(long contentId)
		throws SystemException {
		ContentSharing contentSharing = (ContentSharing)EntityCacheUtil.getResult(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
				ContentSharingImpl.class, contentId);

		if (contentSharing == _nullContentSharing) {
			return null;
		}

		if (contentSharing == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				contentSharing = (ContentSharing)session.get(ContentSharingImpl.class,
						Long.valueOf(contentId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (contentSharing != null) {
					cacheResult(contentSharing);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ContentSharingModelImpl.ENTITY_CACHE_ENABLED,
						ContentSharingImpl.class, contentId, _nullContentSharing);
				}

				closeSession(session);
			}
		}

		return contentSharing;
	}

	/**
	 * Returns the content sharing where companyId = &#63; or throws a {@link com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @return the matching content sharing
	 * @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a matching content sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing findBycompanyId(long companyId)
		throws NoSuchContentSharingException, SystemException {
		ContentSharing contentSharing = fetchBycompanyId(companyId);

		if (contentSharing == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchContentSharingException(msg.toString());
		}

		return contentSharing;
	}

	/**
	 * Returns the content sharing where companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @return the matching content sharing, or <code>null</code> if a matching content sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing fetchBycompanyId(long companyId)
		throws SystemException {
		return fetchBycompanyId(companyId, true);
	}

	/**
	 * Returns the content sharing where companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching content sharing, or <code>null</code> if a matching content sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing fetchBycompanyId(long companyId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COMPANYID,
					finderArgs, this);
		}

		if (result instanceof ContentSharing) {
			ContentSharing contentSharing = (ContentSharing)result;

			if ((companyId != contentSharing.getCompanyId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_CONTENTSHARING_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				List<ContentSharing> list = q.list();

				result = list;

				ContentSharing contentSharing = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYID,
						finderArgs, list);
				}
				else {
					contentSharing = list.get(0);

					cacheResult(contentSharing);

					if ((contentSharing.getCompanyId() != companyId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYID,
							finderArgs, contentSharing);
					}
				}

				return contentSharing;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYID,
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
				return (ContentSharing)result;
			}
		}
	}

	/**
	 * Returns all the content sharings where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching content sharings
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContentSharing> findBygroupId(long groupId)
		throws SystemException {
		return findBygroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content sharings where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of content sharings
	 * @param end the upper bound of the range of content sharings (not inclusive)
	 * @return the range of matching content sharings
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContentSharing> findBygroupId(long groupId, int start, int end)
		throws SystemException {
		return findBygroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the content sharings where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of content sharings
	 * @param end the upper bound of the range of content sharings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching content sharings
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContentSharing> findBygroupId(long groupId, int start, int end,
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

		List<ContentSharing> list = (List<ContentSharing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContentSharing contentSharing : list) {
				if ((groupId != contentSharing.getGroupId())) {
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

			query.append(_SQL_SELECT_CONTENTSHARING_WHERE);

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

				list = (List<ContentSharing>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content sharing in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content sharing
	 * @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a matching content sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing findBygroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContentSharingException, SystemException {
		ContentSharing contentSharing = fetchBygroupId_First(groupId,
				orderByComparator);

		if (contentSharing != null) {
			return contentSharing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentSharingException(msg.toString());
	}

	/**
	 * Returns the first content sharing in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content sharing, or <code>null</code> if a matching content sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing fetchBygroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContentSharing> list = findBygroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content sharing in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content sharing
	 * @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a matching content sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing findBygroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContentSharingException, SystemException {
		ContentSharing contentSharing = fetchBygroupId_Last(groupId,
				orderByComparator);

		if (contentSharing != null) {
			return contentSharing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentSharingException(msg.toString());
	}

	/**
	 * Returns the last content sharing in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content sharing, or <code>null</code> if a matching content sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing fetchBygroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBygroupId(groupId);

		List<ContentSharing> list = findBygroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the content sharings before and after the current content sharing in the ordered set where groupId = &#63;.
	 *
	 * @param contentId the primary key of the current content sharing
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content sharing
	 * @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a content sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing[] findBygroupId_PrevAndNext(long contentId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchContentSharingException, SystemException {
		ContentSharing contentSharing = findByPrimaryKey(contentId);

		Session session = null;

		try {
			session = openSession();

			ContentSharing[] array = new ContentSharingImpl[3];

			array[0] = getBygroupId_PrevAndNext(session, contentSharing,
					groupId, orderByComparator, true);

			array[1] = contentSharing;

			array[2] = getBygroupId_PrevAndNext(session, contentSharing,
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

	protected ContentSharing getBygroupId_PrevAndNext(Session session,
		ContentSharing contentSharing, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENTSHARING_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(contentSharing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContentSharing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the content sharings that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching content sharings that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContentSharing> filterFindBygroupId(long groupId)
		throws SystemException {
		return filterFindBygroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content sharings that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of content sharings
	 * @param end the upper bound of the range of content sharings (not inclusive)
	 * @return the range of matching content sharings that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContentSharing> filterFindBygroupId(long groupId, int start,
		int end) throws SystemException {
		return filterFindBygroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the content sharings that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of content sharings
	 * @param end the upper bound of the range of content sharings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching content sharings that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContentSharing> filterFindBygroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findBygroupId(groupId, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_CONTENTSHARING_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENTSHARING_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTENTSHARING_NO_INLINE_DISTINCT_WHERE_2);
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
				ContentSharing.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ContentSharingImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ContentSharingImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ContentSharing>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the content sharings before and after the current content sharing in the ordered set of content sharings that the user has permission to view where groupId = &#63;.
	 *
	 * @param contentId the primary key of the current content sharing
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content sharing
	 * @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a content sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing[] filterFindBygroupId_PrevAndNext(long contentId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchContentSharingException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findBygroupId_PrevAndNext(contentId, groupId,
				orderByComparator);
		}

		ContentSharing contentSharing = findByPrimaryKey(contentId);

		Session session = null;

		try {
			session = openSession();

			ContentSharing[] array = new ContentSharingImpl[3];

			array[0] = filterGetBygroupId_PrevAndNext(session, contentSharing,
					groupId, orderByComparator, true);

			array[1] = contentSharing;

			array[2] = filterGetBygroupId_PrevAndNext(session, contentSharing,
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

	protected ContentSharing filterGetBygroupId_PrevAndNext(Session session,
		ContentSharing contentSharing, long groupId,
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
			query.append(_FILTER_SQL_SELECT_CONTENTSHARING_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CONTENTSHARING_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CONTENTSHARING_NO_INLINE_DISTINCT_WHERE_2);
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
				ContentSharing.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ContentSharingImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ContentSharingImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contentSharing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContentSharing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the content sharing where companyId = &#63; and groupId = &#63; or throws a {@link com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching content sharing
	 * @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a matching content sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing findBycompanyIdAndGroupId(long companyId, long groupId)
		throws NoSuchContentSharingException, SystemException {
		ContentSharing contentSharing = fetchBycompanyIdAndGroupId(companyId,
				groupId);

		if (contentSharing == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchContentSharingException(msg.toString());
		}

		return contentSharing;
	}

	/**
	 * Returns the content sharing where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching content sharing, or <code>null</code> if a matching content sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing fetchBycompanyIdAndGroupId(long companyId,
		long groupId) throws SystemException {
		return fetchBycompanyIdAndGroupId(companyId, groupId, true);
	}

	/**
	 * Returns the content sharing where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching content sharing, or <code>null</code> if a matching content sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing fetchBycompanyIdAndGroupId(long companyId,
		long groupId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COMPANYIDANDGROUPID,
					finderArgs, this);
		}

		if (result instanceof ContentSharing) {
			ContentSharing contentSharing = (ContentSharing)result;

			if ((companyId != contentSharing.getCompanyId()) ||
					(groupId != contentSharing.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CONTENTSHARING_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				List<ContentSharing> list = q.list();

				result = list;

				ContentSharing contentSharing = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDANDGROUPID,
						finderArgs, list);
				}
				else {
					contentSharing = list.get(0);

					cacheResult(contentSharing);

					if ((contentSharing.getCompanyId() != companyId) ||
							(contentSharing.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDANDGROUPID,
							finderArgs, contentSharing);
					}
				}

				return contentSharing;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYIDANDGROUPID,
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
				return (ContentSharing)result;
			}
		}
	}

	/**
	 * Returns all the content sharings.
	 *
	 * @return the content sharings
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContentSharing> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the content sharings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of content sharings
	 * @param end the upper bound of the range of content sharings (not inclusive)
	 * @return the range of content sharings
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContentSharing> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the content sharings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of content sharings
	 * @param end the upper bound of the range of content sharings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of content sharings
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContentSharing> findAll(int start, int end,
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

		List<ContentSharing> list = (List<ContentSharing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTENTSHARING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTENTSHARING;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ContentSharing>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ContentSharing>)QueryUtil.list(q,
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
	 * Removes the content sharing where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @return the content sharing that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing removeBycompanyId(long companyId)
		throws NoSuchContentSharingException, SystemException {
		ContentSharing contentSharing = findBycompanyId(companyId);

		return remove(contentSharing);
	}

	/**
	 * Removes all the content sharings where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBygroupId(long groupId) throws SystemException {
		for (ContentSharing contentSharing : findBygroupId(groupId)) {
			remove(contentSharing);
		}
	}

	/**
	 * Removes the content sharing where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the content sharing that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public ContentSharing removeBycompanyIdAndGroupId(long companyId,
		long groupId) throws NoSuchContentSharingException, SystemException {
		ContentSharing contentSharing = findBycompanyIdAndGroupId(companyId,
				groupId);

		return remove(contentSharing);
	}

	/**
	 * Removes all the content sharings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ContentSharing contentSharing : findAll()) {
			remove(contentSharing);
		}
	}

	/**
	 * Returns the number of content sharings where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching content sharings
	 * @throws SystemException if a system exception occurred
	 */
	public int countBycompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTENTSHARING_WHERE);

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
	 * Returns the number of content sharings where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching content sharings
	 * @throws SystemException if a system exception occurred
	 */
	public int countBygroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTENTSHARING_WHERE);

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
	 * Returns the number of content sharings that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching content sharings that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountBygroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countBygroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CONTENTSHARING_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ContentSharing.class.getName(),
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
	 * Returns the number of content sharings where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching content sharings
	 * @throws SystemException if a system exception occurred
	 */
	public int countBycompanyIdAndGroupId(long companyId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTENTSHARING_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of content sharings.
	 *
	 * @return the number of content sharings
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONTENTSHARING);

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
	 * Initializes the content sharing persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.contentsharing.model.ContentSharing")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContentSharing>> listenersList = new ArrayList<ModelListener<ContentSharing>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContentSharing>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContentSharingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ContentSharingPersistence.class)
	protected ContentSharingPersistence contentSharingPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CONTENTSHARING = "SELECT contentSharing FROM ContentSharing contentSharing";
	private static final String _SQL_SELECT_CONTENTSHARING_WHERE = "SELECT contentSharing FROM ContentSharing contentSharing WHERE ";
	private static final String _SQL_COUNT_CONTENTSHARING = "SELECT COUNT(contentSharing) FROM ContentSharing contentSharing";
	private static final String _SQL_COUNT_CONTENTSHARING_WHERE = "SELECT COUNT(contentSharing) FROM ContentSharing contentSharing WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "contentSharing.companyId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "contentSharing.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2 = "contentSharing.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2 = "contentSharing.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "contentSharing.contentId";
	private static final String _FILTER_SQL_SELECT_CONTENTSHARING_WHERE = "SELECT DISTINCT {contentSharing.*} FROM ContentSharing contentSharing WHERE ";
	private static final String _FILTER_SQL_SELECT_CONTENTSHARING_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {ContentSharing.*} FROM (SELECT DISTINCT contentSharing.contentId FROM ContentSharing contentSharing WHERE ";
	private static final String _FILTER_SQL_SELECT_CONTENTSHARING_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN ContentSharing ON TEMP_TABLE.contentId = ContentSharing.contentId";
	private static final String _FILTER_SQL_COUNT_CONTENTSHARING_WHERE = "SELECT COUNT(DISTINCT contentSharing.contentId) AS COUNT_VALUE FROM ContentSharing contentSharing WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "contentSharing";
	private static final String _FILTER_ENTITY_TABLE = "ContentSharing";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contentSharing.";
	private static final String _ORDER_BY_ENTITY_TABLE = "ContentSharing.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContentSharing exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContentSharing exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContentSharingPersistenceImpl.class);
	private static ContentSharing _nullContentSharing = new ContentSharingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContentSharing> toCacheModel() {
				return _nullContentSharingCacheModel;
			}
		};

	private static CacheModel<ContentSharing> _nullContentSharingCacheModel = new CacheModel<ContentSharing>() {
			public ContentSharing toEntityModel() {
				return _nullContentSharing;
			}
		};
}