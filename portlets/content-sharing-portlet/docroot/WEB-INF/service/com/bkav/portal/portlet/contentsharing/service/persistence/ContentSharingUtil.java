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

import com.bkav.portal.portlet.contentsharing.model.ContentSharing;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the content sharing service. This utility wraps {@link ContentSharingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see ContentSharingPersistence
 * @see ContentSharingPersistenceImpl
 * @generated
 */
public class ContentSharingUtil {
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
	public static void clearCache(ContentSharing contentSharing) {
		getPersistence().clearCache(contentSharing);
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
	public static List<ContentSharing> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContentSharing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContentSharing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ContentSharing update(ContentSharing contentSharing,
		boolean merge) throws SystemException {
		return getPersistence().update(contentSharing, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ContentSharing update(ContentSharing contentSharing,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(contentSharing, merge, serviceContext);
	}

	/**
	* Caches the content sharing in the entity cache if it is enabled.
	*
	* @param contentSharing the content sharing
	*/
	public static void cacheResult(
		com.bkav.portal.portlet.contentsharing.model.ContentSharing contentSharing) {
		getPersistence().cacheResult(contentSharing);
	}

	/**
	* Caches the content sharings in the entity cache if it is enabled.
	*
	* @param contentSharings the content sharings
	*/
	public static void cacheResult(
		java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> contentSharings) {
		getPersistence().cacheResult(contentSharings);
	}

	/**
	* Creates a new content sharing with the primary key. Does not add the content sharing to the database.
	*
	* @param contentId the primary key for the new content sharing
	* @return the new content sharing
	*/
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing create(
		long contentId) {
		return getPersistence().create(contentId);
	}

	/**
	* Removes the content sharing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentId the primary key of the content sharing
	* @return the content sharing that was removed
	* @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a content sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing remove(
		long contentId)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(contentId);
	}

	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing updateImpl(
		com.bkav.portal.portlet.contentsharing.model.ContentSharing contentSharing,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contentSharing, merge);
	}

	/**
	* Returns the content sharing with the primary key or throws a {@link com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException} if it could not be found.
	*
	* @param contentId the primary key of the content sharing
	* @return the content sharing
	* @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a content sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing findByPrimaryKey(
		long contentId)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(contentId);
	}

	/**
	* Returns the content sharing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contentId the primary key of the content sharing
	* @return the content sharing, or <code>null</code> if a content sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchByPrimaryKey(
		long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(contentId);
	}

	/**
	* Returns the content sharing where companyId = &#63; or throws a {@link com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException} if it could not be found.
	*
	* @param companyId the company ID
	* @return the matching content sharing
	* @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing findBycompanyId(
		long companyId)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycompanyId(companyId);
	}

	/**
	* Returns the content sharing where companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @return the matching content sharing, or <code>null</code> if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchBycompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBycompanyId(companyId);
	}

	/**
	* Returns the content sharing where companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching content sharing, or <code>null</code> if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchBycompanyId(
		long companyId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBycompanyId(companyId, retrieveFromCache);
	}

	/**
	* Returns all the content sharings where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching content sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> findBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBygroupId(groupId);
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
	public static java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> findBygroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBygroupId(groupId, start, end);
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
	public static java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> findBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBygroupId(groupId, start, end, orderByComparator);
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
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing findBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBygroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first content sharing in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content sharing, or <code>null</code> if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBygroupId_First(groupId, orderByComparator);
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
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing findBygroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBygroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last content sharing in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content sharing, or <code>null</code> if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchBygroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBygroupId_Last(groupId, orderByComparator);
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
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing[] findBygroupId_PrevAndNext(
		long contentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBygroupId_PrevAndNext(contentId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the content sharings that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching content sharings that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> filterFindBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBygroupId(groupId);
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
	public static java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> filterFindBygroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBygroupId(groupId, start, end);
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
	public static java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> filterFindBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBygroupId(groupId, start, end, orderByComparator);
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
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing[] filterFindBygroupId_PrevAndNext(
		long contentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBygroupId_PrevAndNext(contentId, groupId,
			orderByComparator);
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
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing findBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycompanyIdAndGroupId(companyId, groupId);
	}

	/**
	* Returns the content sharing where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching content sharing, or <code>null</code> if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBycompanyIdAndGroupId(companyId, groupId);
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
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchBycompanyIdAndGroupId(
		long companyId, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycompanyIdAndGroupId(companyId, groupId,
			retrieveFromCache);
	}

	/**
	* Returns all the content sharings.
	*
	* @return the content sharings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the content sharing where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @return the content sharing that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing removeBycompanyId(
		long companyId)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBycompanyId(companyId);
	}

	/**
	* Removes all the content sharings where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBygroupId(groupId);
	}

	/**
	* Removes the content sharing where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the content sharing that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.contentsharing.model.ContentSharing removeBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBycompanyIdAndGroupId(companyId, groupId);
	}

	/**
	* Removes all the content sharings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of content sharings where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching content sharings
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycompanyId(companyId);
	}

	/**
	* Returns the number of content sharings where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching content sharings
	* @throws SystemException if a system exception occurred
	*/
	public static int countBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBygroupId(groupId);
	}

	/**
	* Returns the number of content sharings that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching content sharings that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountBygroupId(groupId);
	}

	/**
	* Returns the number of content sharings where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching content sharings
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycompanyIdAndGroupId(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycompanyIdAndGroupId(companyId, groupId);
	}

	/**
	* Returns the number of content sharings.
	*
	* @return the number of content sharings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContentSharingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContentSharingPersistence)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.contentsharing.service.ClpSerializer.getServletContextName(),
					ContentSharingPersistence.class.getName());

			ReferenceRegistry.registerReference(ContentSharingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ContentSharingPersistence persistence) {
	}

	private static ContentSharingPersistence _persistence;
}