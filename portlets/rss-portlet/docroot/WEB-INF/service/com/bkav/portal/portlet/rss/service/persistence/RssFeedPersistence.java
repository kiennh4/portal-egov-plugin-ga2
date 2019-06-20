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

import com.bkav.portal.portlet.rss.model.RssFeed;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the rss feed service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see RssFeedPersistenceImpl
 * @see RssFeedUtil
 * @generated
 */
public interface RssFeedPersistence extends BasePersistence<RssFeed> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RssFeedUtil} to access the rss feed persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the rss feed in the entity cache if it is enabled.
	*
	* @param rssFeed the rss feed
	*/
	public void cacheResult(com.bkav.portal.portlet.rss.model.RssFeed rssFeed);

	/**
	* Caches the rss feeds in the entity cache if it is enabled.
	*
	* @param rssFeeds the rss feeds
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.rss.model.RssFeed> rssFeeds);

	/**
	* Creates a new rss feed with the primary key. Does not add the rss feed to the database.
	*
	* @param id_ the primary key for the new rss feed
	* @return the new rss feed
	*/
	public com.bkav.portal.portlet.rss.model.RssFeed create(long id_);

	/**
	* Removes the rss feed with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_ the primary key of the rss feed
	* @return the rss feed that was removed
	* @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a rss feed with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.rss.model.RssFeed remove(long id_)
		throws com.bkav.portal.portlet.rss.NoSuchRssFeedException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.rss.model.RssFeed updateImpl(
		com.bkav.portal.portlet.rss.model.RssFeed rssFeed, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rss feed with the primary key or throws a {@link com.bkav.portal.portlet.rss.NoSuchRssFeedException} if it could not be found.
	*
	* @param id_ the primary key of the rss feed
	* @return the rss feed
	* @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a rss feed with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.rss.model.RssFeed findByPrimaryKey(long id_)
		throws com.bkav.portal.portlet.rss.NoSuchRssFeedException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rss feed with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_ the primary key of the rss feed
	* @return the rss feed, or <code>null</code> if a rss feed with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.rss.model.RssFeed fetchByPrimaryKey(long id_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rss feeds where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching rss feeds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.rss.model.RssFeed> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.rss.model.RssFeed> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.rss.model.RssFeed> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rss feed in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rss feed
	* @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a matching rss feed could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.rss.model.RssFeed findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.rss.NoSuchRssFeedException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rss feed in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rss feed, or <code>null</code> if a matching rss feed could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.rss.model.RssFeed fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rss feed in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rss feed
	* @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a matching rss feed could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.rss.model.RssFeed findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.rss.NoSuchRssFeedException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rss feed in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rss feed, or <code>null</code> if a matching rss feed could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.rss.model.RssFeed fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.rss.model.RssFeed[] findByGroup_PrevAndNext(
		long id_, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.rss.NoSuchRssFeedException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rss feeds.
	*
	* @return the rss feeds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.rss.model.RssFeed> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.rss.model.RssFeed> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.rss.model.RssFeed> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rss feeds where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rss feeds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rss feeds where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching rss feeds
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rss feeds.
	*
	* @return the number of rss feeds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}