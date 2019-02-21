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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the content sharing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see ContentSharingPersistenceImpl
 * @see ContentSharingUtil
 * @generated
 */
public interface ContentSharingPersistence extends BasePersistence<ContentSharing> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContentSharingUtil} to access the content sharing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the content sharing in the entity cache if it is enabled.
	*
	* @param contentSharing the content sharing
	*/
	public void cacheResult(
		com.bkav.portal.portlet.contentsharing.model.ContentSharing contentSharing);

	/**
	* Caches the content sharings in the entity cache if it is enabled.
	*
	* @param contentSharings the content sharings
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> contentSharings);

	/**
	* Creates a new content sharing with the primary key. Does not add the content sharing to the database.
	*
	* @param contentId the primary key for the new content sharing
	* @return the new content sharing
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing create(
		long contentId);

	/**
	* Removes the content sharing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentId the primary key of the content sharing
	* @return the content sharing that was removed
	* @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a content sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing remove(
		long contentId)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.contentsharing.model.ContentSharing updateImpl(
		com.bkav.portal.portlet.contentsharing.model.ContentSharing contentSharing,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content sharing with the primary key or throws a {@link com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException} if it could not be found.
	*
	* @param contentId the primary key of the content sharing
	* @return the content sharing
	* @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a content sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing findByPrimaryKey(
		long contentId)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content sharing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contentId the primary key of the content sharing
	* @return the content sharing, or <code>null</code> if a content sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchByPrimaryKey(
		long contentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content sharing where companyId = &#63; or throws a {@link com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException} if it could not be found.
	*
	* @param companyId the company ID
	* @return the matching content sharing
	* @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing findBycompanyId(
		long companyId)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content sharing where companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @return the matching content sharing, or <code>null</code> if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchBycompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content sharing where companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching content sharing, or <code>null</code> if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchBycompanyId(
		long companyId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the content sharings where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching content sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> findBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> findBygroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> findBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first content sharing in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content sharing
	* @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing findBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first content sharing in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content sharing, or <code>null</code> if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last content sharing in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content sharing
	* @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing findBygroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last content sharing in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content sharing, or <code>null</code> if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchBygroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing[] findBygroupId_PrevAndNext(
		long contentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the content sharings that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching content sharings that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> filterFindBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> filterFindBygroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> filterFindBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing[] filterFindBygroupId_PrevAndNext(
		long contentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content sharing where companyId = &#63; and groupId = &#63; or throws a {@link com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching content sharing
	* @throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing findBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content sharing where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching content sharing, or <code>null</code> if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content sharing where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching content sharing, or <code>null</code> if a matching content sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchBycompanyIdAndGroupId(
		long companyId, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the content sharings.
	*
	* @return the content sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the content sharing where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @return the content sharing that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing removeBycompanyId(
		long companyId)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the content sharings where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the content sharing where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the content sharing that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing removeBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.bkav.portal.portlet.contentsharing.NoSuchContentSharingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the content sharings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of content sharings where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching content sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countBycompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of content sharings where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching content sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of content sharings that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching content sharings that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of content sharings where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching content sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countBycompanyIdAndGroupId(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of content sharings.
	*
	* @return the number of content sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}