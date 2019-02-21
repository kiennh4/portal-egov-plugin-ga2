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

import com.bkav.portal.portlet.video.model.VideoCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the video category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see VideoCategoryPersistenceImpl
 * @see VideoCategoryUtil
 * @generated
 */
public interface VideoCategoryPersistence extends BasePersistence<VideoCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoCategoryUtil} to access the video category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the video category in the entity cache if it is enabled.
	*
	* @param videoCategory the video category
	*/
	public void cacheResult(
		com.bkav.portal.portlet.video.model.VideoCategory videoCategory);

	/**
	* Caches the video categories in the entity cache if it is enabled.
	*
	* @param videoCategories the video categories
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> videoCategories);

	/**
	* Creates a new video category with the primary key. Does not add the video category to the database.
	*
	* @param categoryId the primary key for the new video category
	* @return the new video category
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory create(
		long categoryId);

	/**
	* Removes the video category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the video category
	* @return the video category that was removed
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory remove(
		long categoryId)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.video.model.VideoCategory updateImpl(
		com.bkav.portal.portlet.video.model.VideoCategory videoCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video category with the primary key or throws a {@link com.bkav.portal.portlet.video.NoSuchVideoCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the video category
	* @return the video category
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory findByPrimaryKey(
		long categoryId)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the video category
	* @return the video category, or <code>null</code> if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of video categories
	* @param end the upper bound of the range of video categories (not inclusive)
	* @return the range of matching video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of video categories
	* @param end the upper bound of the range of video categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video category
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a matching video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video category, or <code>null</code> if a matching video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video category
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a matching video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video category, or <code>null</code> if a matching video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video categories before and after the current video category in the ordered set where groupId = &#63;.
	*
	* @param categoryId the primary key of the current video category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video category
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching video categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video categories that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of video categories
	* @param end the upper bound of the range of video categories (not inclusive)
	* @return the range of matching video categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video categories that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of video categories
	* @param end the upper bound of the range of video categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video categories before and after the current video category in the ordered set of video categories that the user has permission to view where groupId = &#63;.
	*
	* @param categoryId the primary key of the current video category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video category
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video categories.
	*
	* @return the video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video categories
	* @param end the upper bound of the range of video categories (not inclusive)
	* @return the range of video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video categories
	* @param end the upper bound of the range of video categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching video categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching video categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video categories.
	*
	* @return the number of video categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}