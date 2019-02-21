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

import com.bkav.portal.portlet.video.model.VideoCategoryMap;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the video category map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see VideoCategoryMapPersistenceImpl
 * @see VideoCategoryMapUtil
 * @generated
 */
public interface VideoCategoryMapPersistence extends BasePersistence<VideoCategoryMap> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoCategoryMapUtil} to access the video category map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the video category map in the entity cache if it is enabled.
	*
	* @param videoCategoryMap the video category map
	*/
	public void cacheResult(
		com.bkav.portal.portlet.video.model.VideoCategoryMap videoCategoryMap);

	/**
	* Caches the video category maps in the entity cache if it is enabled.
	*
	* @param videoCategoryMaps the video category maps
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> videoCategoryMaps);

	/**
	* Creates a new video category map with the primary key. Does not add the video category map to the database.
	*
	* @param mapId the primary key for the new video category map
	* @return the new video category map
	*/
	public com.bkav.portal.portlet.video.model.VideoCategoryMap create(
		long mapId);

	/**
	* Removes the video category map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mapId the primary key of the video category map
	* @return the video category map that was removed
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a video category map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategoryMap remove(
		long mapId)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.video.model.VideoCategoryMap updateImpl(
		com.bkav.portal.portlet.video.model.VideoCategoryMap videoCategoryMap,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video category map with the primary key or throws a {@link com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException} if it could not be found.
	*
	* @param mapId the primary key of the video category map
	* @return the video category map
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a video category map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategoryMap findByPrimaryKey(
		long mapId)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video category map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mapId the primary key of the video category map
	* @return the video category map, or <code>null</code> if a video category map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategoryMap fetchByPrimaryKey(
		long mapId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video category maps where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching video category maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video category maps where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of video category maps
	* @param end the upper bound of the range of video category maps (not inclusive)
	* @return the range of matching video category maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video category maps where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of video category maps
	* @param end the upper bound of the range of video category maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video category maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video category map in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video category map
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategoryMap findByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video category map in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video category map, or <code>null</code> if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategoryMap fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video category map in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video category map
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategoryMap findByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video category map in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video category map, or <code>null</code> if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategoryMap fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video category maps before and after the current video category map in the ordered set where categoryId = &#63;.
	*
	* @param mapId the primary key of the current video category map
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video category map
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a video category map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategoryMap[] findByCategory_PrevAndNext(
		long mapId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video category maps where entryId = &#63;.
	*
	* @param entryId the entry ID
	* @return the matching video category maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findByEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video category maps where entryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the entry ID
	* @param start the lower bound of the range of video category maps
	* @param end the upper bound of the range of video category maps (not inclusive)
	* @return the range of matching video category maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findByEntry(
		long entryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video category maps where entryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the entry ID
	* @param start the lower bound of the range of video category maps
	* @param end the upper bound of the range of video category maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video category maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findByEntry(
		long entryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video category map in the ordered set where entryId = &#63;.
	*
	* @param entryId the entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video category map
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategoryMap findByEntry_First(
		long entryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video category map in the ordered set where entryId = &#63;.
	*
	* @param entryId the entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video category map, or <code>null</code> if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategoryMap fetchByEntry_First(
		long entryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video category map in the ordered set where entryId = &#63;.
	*
	* @param entryId the entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video category map
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategoryMap findByEntry_Last(
		long entryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video category map in the ordered set where entryId = &#63;.
	*
	* @param entryId the entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video category map, or <code>null</code> if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategoryMap fetchByEntry_Last(
		long entryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video category maps before and after the current video category map in the ordered set where entryId = &#63;.
	*
	* @param mapId the primary key of the current video category map
	* @param entryId the entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video category map
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a video category map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategoryMap[] findByEntry_PrevAndNext(
		long mapId, long entryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video category maps.
	*
	* @return the video category maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video category maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video category maps
	* @param end the upper bound of the range of video category maps (not inclusive)
	* @return the range of video category maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video category maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video category maps
	* @param end the upper bound of the range of video category maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video category maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video category maps where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video category maps where entryId = &#63; from the database.
	*
	* @param entryId the entry ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEntry(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video category maps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video category maps where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching video category maps
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video category maps where entryId = &#63;.
	*
	* @param entryId the entry ID
	* @return the number of matching video category maps
	* @throws SystemException if a system exception occurred
	*/
	public int countByEntry(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video category maps.
	*
	* @return the number of video category maps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}