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

package com.bkav.portal.portlet.video.service.persistence;

import com.bkav.portal.portlet.video.model.VideoEntry;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the video entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see VideoEntryPersistenceImpl
 * @see VideoEntryUtil
 * @generated
 */
public interface VideoEntryPersistence extends BasePersistence<VideoEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoEntryUtil} to access the video entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the video entry in the entity cache if it is enabled.
	*
	* @param videoEntry the video entry
	*/
	public void cacheResult(
		com.bkav.portal.portlet.video.model.VideoEntry videoEntry);

	/**
	* Caches the video entries in the entity cache if it is enabled.
	*
	* @param videoEntries the video entries
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> videoEntries);

	/**
	* Creates a new video entry with the primary key. Does not add the video entry to the database.
	*
	* @param entryId the primary key for the new video entry
	* @return the new video entry
	*/
	public com.bkav.portal.portlet.video.model.VideoEntry create(long entryId);

	/**
	* Removes the video entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the video entry
	* @return the video entry that was removed
	* @throws com.bkav.portal.portlet.video.NoSuchVideoEntryException if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoEntry remove(long entryId)
		throws com.bkav.portal.portlet.video.NoSuchVideoEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.video.model.VideoEntry updateImpl(
		com.bkav.portal.portlet.video.model.VideoEntry videoEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video entry with the primary key or throws a {@link com.bkav.portal.portlet.video.NoSuchVideoEntryException} if it could not be found.
	*
	* @param entryId the primary key of the video entry
	* @return the video entry
	* @throws com.bkav.portal.portlet.video.NoSuchVideoEntryException if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoEntry findByPrimaryKey(
		long entryId)
		throws com.bkav.portal.portlet.video.NoSuchVideoEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the video entry
	* @return the video entry, or <code>null</code> if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoEntry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @return the range of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video entry
	* @throws com.bkav.portal.portlet.video.NoSuchVideoEntryException if a matching video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoEntry findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video entry, or <code>null</code> if a matching video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoEntry fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video entry
	* @throws com.bkav.portal.portlet.video.NoSuchVideoEntryException if a matching video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoEntry findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video entry, or <code>null</code> if a matching video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoEntry fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video entries before and after the current video entry in the ordered set where groupId = &#63;.
	*
	* @param entryId the primary key of the current video entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video entry
	* @throws com.bkav.portal.portlet.video.NoSuchVideoEntryException if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoEntry[] findByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video entries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching video entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video entries that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @return the range of matching video entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video entries that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video entries before and after the current video entry in the ordered set of video entries that the user has permission to view where groupId = &#63;.
	*
	* @param entryId the primary key of the current video entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video entry
	* @throws com.bkav.portal.portlet.video.NoSuchVideoEntryException if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoEntry[] filterFindByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video entries.
	*
	* @return the video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @return the range of video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video entries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching video entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video entries.
	*
	* @return the number of video entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}