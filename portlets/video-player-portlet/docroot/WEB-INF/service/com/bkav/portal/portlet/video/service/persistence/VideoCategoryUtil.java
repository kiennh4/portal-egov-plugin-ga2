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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the video category service. This utility wraps {@link VideoCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see VideoCategoryPersistence
 * @see VideoCategoryPersistenceImpl
 * @generated
 */
public class VideoCategoryUtil {
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
	public static void clearCache(VideoCategory videoCategory) {
		getPersistence().clearCache(videoCategory);
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
	public static List<VideoCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VideoCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VideoCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VideoCategory update(VideoCategory videoCategory,
		boolean merge) throws SystemException {
		return getPersistence().update(videoCategory, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VideoCategory update(VideoCategory videoCategory,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(videoCategory, merge, serviceContext);
	}

	/**
	* Caches the video category in the entity cache if it is enabled.
	*
	* @param videoCategory the video category
	*/
	public static void cacheResult(
		com.bkav.portal.portlet.video.model.VideoCategory videoCategory) {
		getPersistence().cacheResult(videoCategory);
	}

	/**
	* Caches the video categories in the entity cache if it is enabled.
	*
	* @param videoCategories the video categories
	*/
	public static void cacheResult(
		java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> videoCategories) {
		getPersistence().cacheResult(videoCategories);
	}

	/**
	* Creates a new video category with the primary key. Does not add the video category to the database.
	*
	* @param categoryId the primary key for the new video category
	* @return the new video category
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategory create(
		long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the video category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the video category
	* @return the video category that was removed
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategory remove(
		long categoryId)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(categoryId);
	}

	public static com.bkav.portal.portlet.video.model.VideoCategory updateImpl(
		com.bkav.portal.portlet.video.model.VideoCategory videoCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(videoCategory, merge);
	}

	/**
	* Returns the video category with the primary key or throws a {@link com.bkav.portal.portlet.video.NoSuchVideoCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the video category
	* @return the video category
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategory findByPrimaryKey(
		long categoryId)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the video category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the video category
	* @return the video category, or <code>null</code> if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the video categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching video categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first video category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video category
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a matching video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategory findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first video category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video category, or <code>null</code> if a matching video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategory fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last video category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video category
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException if a matching video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategory findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last video category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video category, or <code>null</code> if a matching video category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategory fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.bkav.portal.portlet.video.model.VideoCategory[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the video categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching video categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

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
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

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
	public static com.bkav.portal.portlet.video.model.VideoCategory[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the video categories.
	*
	* @return the video categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the video categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the video categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching video categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of video categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching video categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of video categories.
	*
	* @return the number of video categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VideoCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VideoCategoryPersistence)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.video.service.ClpSerializer.getServletContextName(),
					VideoCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(VideoCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(VideoCategoryPersistence persistence) {
	}

	private static VideoCategoryPersistence _persistence;
}