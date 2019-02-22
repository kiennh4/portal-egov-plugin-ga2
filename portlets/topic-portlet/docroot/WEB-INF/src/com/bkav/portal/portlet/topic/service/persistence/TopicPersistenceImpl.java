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

package com.bkav.portal.portlet.topic.service.persistence;

import com.bkav.portal.portlet.topic.NoSuchTopicException;
import com.bkav.portal.portlet.topic.model.Topic;
import com.bkav.portal.portlet.topic.model.impl.TopicImpl;
import com.bkav.portal.portlet.topic.model.impl.TopicModelImpl;

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
 * The persistence implementation for the topic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see TopicPersistence
 * @see TopicUtil
 * @generated
 */
public class TopicPersistenceImpl extends BasePersistenceImpl<Topic>
	implements TopicPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TopicUtil} to access the topic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TopicImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, TopicImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, TopicImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			TopicModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, TopicImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, TopicImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the topic in the entity cache if it is enabled.
	 *
	 * @param topic the topic
	 */
	public void cacheResult(Topic topic) {
		EntityCacheUtil.putResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicImpl.class, topic.getPrimaryKey(), topic);

		topic.resetOriginalValues();
	}

	/**
	 * Caches the topics in the entity cache if it is enabled.
	 *
	 * @param topics the topics
	 */
	public void cacheResult(List<Topic> topics) {
		for (Topic topic : topics) {
			if (EntityCacheUtil.getResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
						TopicImpl.class, topic.getPrimaryKey()) == null) {
				cacheResult(topic);
			}
			else {
				topic.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all topics.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TopicImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TopicImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the topic.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Topic topic) {
		EntityCacheUtil.removeResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicImpl.class, topic.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Topic> topics) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Topic topic : topics) {
			EntityCacheUtil.removeResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
				TopicImpl.class, topic.getPrimaryKey());
		}
	}

	/**
	 * Creates a new topic with the primary key. Does not add the topic to the database.
	 *
	 * @param topicId the primary key for the new topic
	 * @return the new topic
	 */
	public Topic create(long topicId) {
		Topic topic = new TopicImpl();

		topic.setNew(true);
		topic.setPrimaryKey(topicId);

		return topic;
	}

	/**
	 * Removes the topic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param topicId the primary key of the topic
	 * @return the topic that was removed
	 * @throws com.bkav.portal.portlet.topic.NoSuchTopicException if a topic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Topic remove(long topicId)
		throws NoSuchTopicException, SystemException {
		return remove(Long.valueOf(topicId));
	}

	/**
	 * Removes the topic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the topic
	 * @return the topic that was removed
	 * @throws com.bkav.portal.portlet.topic.NoSuchTopicException if a topic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Topic remove(Serializable primaryKey)
		throws NoSuchTopicException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Topic topic = (Topic)session.get(TopicImpl.class, primaryKey);

			if (topic == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTopicException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(topic);
		}
		catch (NoSuchTopicException nsee) {
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
	protected Topic removeImpl(Topic topic) throws SystemException {
		topic = toUnwrappedModel(topic);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, topic);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(topic);

		return topic;
	}

	@Override
	public Topic updateImpl(com.bkav.portal.portlet.topic.model.Topic topic,
		boolean merge) throws SystemException {
		topic = toUnwrappedModel(topic);

		boolean isNew = topic.isNew();

		TopicModelImpl topicModelImpl = (TopicModelImpl)topic;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, topic, merge);

			topic.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TopicModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((topicModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(topicModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { Long.valueOf(topicModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicImpl.class, topic.getPrimaryKey(), topic);

		return topic;
	}

	protected Topic toUnwrappedModel(Topic topic) {
		if (topic instanceof TopicImpl) {
			return topic;
		}

		TopicImpl topicImpl = new TopicImpl();

		topicImpl.setNew(topic.isNew());
		topicImpl.setPrimaryKey(topic.getPrimaryKey());

		topicImpl.setTopicId(topic.getTopicId());
		topicImpl.setGroupId(topic.getGroupId());
		topicImpl.setCompanyId(topic.getCompanyId());
		topicImpl.setUserId(topic.getUserId());
		topicImpl.setUserName(topic.getUserName());
		topicImpl.setTopicName(topic.getTopicName());
		topicImpl.setCategoryIds(topic.getCategoryIds());
		topicImpl.setCreateDate(topic.getCreateDate());
		topicImpl.setModifiedDate(topic.getModifiedDate());

		return topicImpl;
	}

	/**
	 * Returns the topic with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the topic
	 * @return the topic
	 * @throws com.liferay.portal.NoSuchModelException if a topic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Topic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the topic with the primary key or throws a {@link com.bkav.portal.portlet.topic.NoSuchTopicException} if it could not be found.
	 *
	 * @param topicId the primary key of the topic
	 * @return the topic
	 * @throws com.bkav.portal.portlet.topic.NoSuchTopicException if a topic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Topic findByPrimaryKey(long topicId)
		throws NoSuchTopicException, SystemException {
		Topic topic = fetchByPrimaryKey(topicId);

		if (topic == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + topicId);
			}

			throw new NoSuchTopicException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				topicId);
		}

		return topic;
	}

	/**
	 * Returns the topic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the topic
	 * @return the topic, or <code>null</code> if a topic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Topic fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the topic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param topicId the primary key of the topic
	 * @return the topic, or <code>null</code> if a topic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Topic fetchByPrimaryKey(long topicId) throws SystemException {
		Topic topic = (Topic)EntityCacheUtil.getResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
				TopicImpl.class, topicId);

		if (topic == _nullTopic) {
			return null;
		}

		if (topic == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				topic = (Topic)session.get(TopicImpl.class,
						Long.valueOf(topicId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (topic != null) {
					cacheResult(topic);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
						TopicImpl.class, topicId, _nullTopic);
				}

				closeSession(session);
			}
		}

		return topic;
	}

	/**
	 * Returns all the topics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching topics
	 * @throws SystemException if a system exception occurred
	 */
	public List<Topic> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the topics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @return the range of matching topics
	 * @throws SystemException if a system exception occurred
	 */
	public List<Topic> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the topics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching topics
	 * @throws SystemException if a system exception occurred
	 */
	public List<Topic> findByGroup(long groupId, int start, int end,
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

		List<Topic> list = (List<Topic>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Topic topic : list) {
				if ((groupId != topic.getGroupId())) {
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

			query.append(_SQL_SELECT_TOPIC_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TopicModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Topic>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first topic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching topic
	 * @throws com.bkav.portal.portlet.topic.NoSuchTopicException if a matching topic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Topic findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTopicException, SystemException {
		Topic topic = fetchByGroup_First(groupId, orderByComparator);

		if (topic != null) {
			return topic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTopicException(msg.toString());
	}

	/**
	 * Returns the first topic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching topic, or <code>null</code> if a matching topic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Topic fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Topic> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last topic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching topic
	 * @throws com.bkav.portal.portlet.topic.NoSuchTopicException if a matching topic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Topic findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTopicException, SystemException {
		Topic topic = fetchByGroup_Last(groupId, orderByComparator);

		if (topic != null) {
			return topic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTopicException(msg.toString());
	}

	/**
	 * Returns the last topic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching topic, or <code>null</code> if a matching topic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Topic fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		List<Topic> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the topics before and after the current topic in the ordered set where groupId = &#63;.
	 *
	 * @param topicId the primary key of the current topic
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next topic
	 * @throws com.bkav.portal.portlet.topic.NoSuchTopicException if a topic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Topic[] findByGroup_PrevAndNext(long topicId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTopicException, SystemException {
		Topic topic = findByPrimaryKey(topicId);

		Session session = null;

		try {
			session = openSession();

			Topic[] array = new TopicImpl[3];

			array[0] = getByGroup_PrevAndNext(session, topic, groupId,
					orderByComparator, true);

			array[1] = topic;

			array[2] = getByGroup_PrevAndNext(session, topic, groupId,
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

	protected Topic getByGroup_PrevAndNext(Session session, Topic topic,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOPIC_WHERE);

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
			query.append(TopicModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(topic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Topic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the topics that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching topics that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Topic> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the topics that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @return the range of matching topics that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Topic> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the topics that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching topics that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Topic> filterFindByGroup(long groupId, int start, int end,
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
			query.append(_FILTER_SQL_SELECT_TOPIC_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TOPIC_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOPIC_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TopicModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TopicModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Topic.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TopicImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TopicImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Topic>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the topics before and after the current topic in the ordered set of topics that the user has permission to view where groupId = &#63;.
	 *
	 * @param topicId the primary key of the current topic
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next topic
	 * @throws com.bkav.portal.portlet.topic.NoSuchTopicException if a topic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Topic[] filterFindByGroup_PrevAndNext(long topicId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTopicException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(topicId, groupId, orderByComparator);
		}

		Topic topic = findByPrimaryKey(topicId);

		Session session = null;

		try {
			session = openSession();

			Topic[] array = new TopicImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, topic, groupId,
					orderByComparator, true);

			array[1] = topic;

			array[2] = filterGetByGroup_PrevAndNext(session, topic, groupId,
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

	protected Topic filterGetByGroup_PrevAndNext(Session session, Topic topic,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOPIC_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TOPIC_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOPIC_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TopicModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TopicModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Topic.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TopicImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TopicImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(topic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Topic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the topics.
	 *
	 * @return the topics
	 * @throws SystemException if a system exception occurred
	 */
	public List<Topic> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the topics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @return the range of topics
	 * @throws SystemException if a system exception occurred
	 */
	public List<Topic> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the topics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of topics
	 * @throws SystemException if a system exception occurred
	 */
	public List<Topic> findAll(int start, int end,
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

		List<Topic> list = (List<Topic>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TOPIC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TOPIC.concat(TopicModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Topic>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Topic>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the topics where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long groupId) throws SystemException {
		for (Topic topic : findByGroup(groupId)) {
			remove(topic);
		}
	}

	/**
	 * Removes all the topics from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Topic topic : findAll()) {
			remove(topic);
		}
	}

	/**
	 * Returns the number of topics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching topics
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOPIC_WHERE);

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
	 * Returns the number of topics that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching topics that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_TOPIC_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Topic.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
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
	 * Returns the number of topics.
	 *
	 * @return the number of topics
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TOPIC);

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
	 * Initializes the topic persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bkav.portal.portlet.topic.model.Topic")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Topic>> listenersList = new ArrayList<ModelListener<Topic>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Topic>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TopicImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = TopicPersistence.class)
	protected TopicPersistence topicPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TOPIC = "SELECT topic FROM Topic topic";
	private static final String _SQL_SELECT_TOPIC_WHERE = "SELECT topic FROM Topic topic WHERE ";
	private static final String _SQL_COUNT_TOPIC = "SELECT COUNT(topic) FROM Topic topic";
	private static final String _SQL_COUNT_TOPIC_WHERE = "SELECT COUNT(topic) FROM Topic topic WHERE ";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "topic.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "topic.topicId";
	private static final String _FILTER_SQL_SELECT_TOPIC_WHERE = "SELECT DISTINCT {topic.*} FROM Asset_Topic topic WHERE ";
	private static final String _FILTER_SQL_SELECT_TOPIC_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Asset_Topic.*} FROM (SELECT DISTINCT topic.topicId FROM Asset_Topic topic WHERE ";
	private static final String _FILTER_SQL_SELECT_TOPIC_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Asset_Topic ON TEMP_TABLE.topicId = Asset_Topic.topicId";
	private static final String _FILTER_SQL_COUNT_TOPIC_WHERE = "SELECT COUNT(DISTINCT topic.topicId) AS COUNT_VALUE FROM Asset_Topic topic WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "topic";
	private static final String _FILTER_ENTITY_TABLE = "Asset_Topic";
	private static final String _ORDER_BY_ENTITY_ALIAS = "topic.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Asset_Topic.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Topic exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Topic exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TopicPersistenceImpl.class);
	private static Topic _nullTopic = new TopicImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Topic> toCacheModel() {
				return _nullTopicCacheModel;
			}
		};

	private static CacheModel<Topic> _nullTopicCacheModel = new CacheModel<Topic>() {
			public Topic toEntityModel() {
				return _nullTopic;
			}
		};
}