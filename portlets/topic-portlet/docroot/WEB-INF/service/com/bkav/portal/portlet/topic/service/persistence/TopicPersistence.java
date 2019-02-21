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

import com.bkav.portal.portlet.topic.model.Topic;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the topic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see TopicPersistenceImpl
 * @see TopicUtil
 * @generated
 */
public interface TopicPersistence extends BasePersistence<Topic> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TopicUtil} to access the topic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the topic in the entity cache if it is enabled.
	*
	* @param topic the topic
	*/
	public void cacheResult(com.bkav.portal.portlet.topic.model.Topic topic);

	/**
	* Caches the topics in the entity cache if it is enabled.
	*
	* @param topics the topics
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.topic.model.Topic> topics);

	/**
	* Creates a new topic with the primary key. Does not add the topic to the database.
	*
	* @param topicId the primary key for the new topic
	* @return the new topic
	*/
	public com.bkav.portal.portlet.topic.model.Topic create(long topicId);

	/**
	* Removes the topic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param topicId the primary key of the topic
	* @return the topic that was removed
	* @throws com.bkav.portal.portlet.topic.NoSuchTopicException if a topic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.topic.model.Topic remove(long topicId)
		throws com.bkav.portal.portlet.topic.NoSuchTopicException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.topic.model.Topic updateImpl(
		com.bkav.portal.portlet.topic.model.Topic topic, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the topic with the primary key or throws a {@link com.bkav.portal.portlet.topic.NoSuchTopicException} if it could not be found.
	*
	* @param topicId the primary key of the topic
	* @return the topic
	* @throws com.bkav.portal.portlet.topic.NoSuchTopicException if a topic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.topic.model.Topic findByPrimaryKey(
		long topicId)
		throws com.bkav.portal.portlet.topic.NoSuchTopicException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the topic with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param topicId the primary key of the topic
	* @return the topic, or <code>null</code> if a topic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.topic.model.Topic fetchByPrimaryKey(
		long topicId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the topics where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching topics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.topic.model.Topic> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.topic.model.Topic> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.topic.model.Topic> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first topic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic
	* @throws com.bkav.portal.portlet.topic.NoSuchTopicException if a matching topic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.topic.model.Topic findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.topic.NoSuchTopicException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first topic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic, or <code>null</code> if a matching topic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.topic.model.Topic fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last topic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic
	* @throws com.bkav.portal.portlet.topic.NoSuchTopicException if a matching topic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.topic.model.Topic findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.topic.NoSuchTopicException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last topic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic, or <code>null</code> if a matching topic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.topic.model.Topic fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.topic.model.Topic[] findByGroup_PrevAndNext(
		long topicId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.topic.NoSuchTopicException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the topics that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching topics that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.topic.model.Topic> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.topic.model.Topic> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.topic.model.Topic> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.topic.model.Topic[] filterFindByGroup_PrevAndNext(
		long topicId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.topic.NoSuchTopicException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the topics.
	*
	* @return the topics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.topic.model.Topic> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.topic.model.Topic> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.topic.model.Topic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the topics where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the topics from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of topics where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching topics
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of topics that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching topics that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of topics.
	*
	* @return the number of topics
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}