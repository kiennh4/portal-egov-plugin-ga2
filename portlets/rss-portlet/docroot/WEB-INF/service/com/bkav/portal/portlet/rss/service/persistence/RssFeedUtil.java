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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the rss feed service. This utility wraps {@link RssFeedPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see RssFeedPersistence
 * @see RssFeedPersistenceImpl
 * @generated
 */
public class RssFeedUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(RssFeed rssFeed) {
		getPersistence().clearCache(rssFeed);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RssFeed> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RssFeed> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RssFeed> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static RssFeed update(RssFeed rssFeed, boolean merge)
		throws SystemException {
		return getPersistence().update(rssFeed, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static RssFeed update(RssFeed rssFeed, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(rssFeed, merge, serviceContext);
	}

	/**
	* Caches the rss feed in the entity cache if it is enabled.
	*
	* @param rssFeed the rss feed
	*/
	public static void cacheResult(
		com.bkav.portal.portlet.rss.model.RssFeed rssFeed) {
		getPersistence().cacheResult(rssFeed);
	}

	/**
	* Caches the rss feeds in the entity cache if it is enabled.
	*
	* @param rssFeeds the rss feeds
	*/
	public static void cacheResult(
		java.util.List<com.bkav.portal.portlet.rss.model.RssFeed> rssFeeds) {
		getPersistence().cacheResult(rssFeeds);
	}

	/**
	* Creates a new rss feed with the primary key. Does not add the rss feed to the database.
	*
	* @param id_ the primary key for the new rss feed
	* @return the new rss feed
	*/
	public static com.bkav.portal.portlet.rss.model.RssFeed create(long id_) {
		return getPersistence().create(id_);
	}

	/**
	* Removes the rss feed with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_ the primary key of the rss feed
	* @return the rss feed that was removed
	* @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a rss feed with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.rss.model.RssFeed remove(long id_)
		throws com.bkav.portal.portlet.rss.NoSuchRssFeedException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id_);
	}

	public static com.bkav.portal.portlet.rss.model.RssFeed updateImpl(
		com.bkav.portal.portlet.rss.model.RssFeed rssFeed, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rssFeed, merge);
	}

	/**
	* Returns the rss feed with the primary key or throws a {@link com.bkav.portal.portlet.rss.NoSuchRssFeedException} if it could not be found.
	*
	* @param id_ the primary key of the rss feed
	* @return the rss feed
	* @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a rss feed with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.rss.model.RssFeed findByPrimaryKey(
		long id_)
		throws com.bkav.portal.portlet.rss.NoSuchRssFeedException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id_);
	}

	/**
	* Returns the rss feed with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_ the primary key of the rss feed
	* @return the rss feed, or <code>null</code> if a rss feed with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.rss.model.RssFeed fetchByPrimaryKey(
		long id_) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_);
	}

	/**
	* Returns all the rss feeds where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching rss feeds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.rss.model.RssFeed> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.bkav.portal.portlet.rss.model.RssFeed> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.rss.model.RssFeed> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first rss feed in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rss feed
	* @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a matching rss feed could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.rss.model.RssFeed findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.rss.NoSuchRssFeedException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first rss feed in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rss feed, or <code>null</code> if a matching rss feed could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.rss.model.RssFeed fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last rss feed in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rss feed
	* @throws com.bkav.portal.portlet.rss.NoSuchRssFeedException if a matching rss feed could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.rss.model.RssFeed findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.rss.NoSuchRssFeedException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last rss feed in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rss feed, or <code>null</code> if a matching rss feed could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.rss.model.RssFeed fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.bkav.portal.portlet.rss.model.RssFeed[] findByGroup_PrevAndNext(
		long id_, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.rss.NoSuchRssFeedException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_PrevAndNext(id_, groupId, orderByComparator);
	}

	/**
	* Returns all the rss feeds.
	*
	* @return the rss feeds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.rss.model.RssFeed> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.bkav.portal.portlet.rss.model.RssFeed> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.rss.model.RssFeed> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the rss feeds where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the rss feeds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rss feeds where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching rss feeds
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of rss feeds.
	*
	* @return the number of rss feeds
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RssFeedPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RssFeedPersistence)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.rss.service.ClpSerializer.getServletContextName(),
					RssFeedPersistence.class.getName());

			ReferenceRegistry.registerReference(RssFeedUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(RssFeedPersistence persistence) {
	}

	private static RssFeedPersistence _persistence;
}