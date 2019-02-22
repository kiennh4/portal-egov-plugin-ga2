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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the video category map service. This utility wraps {@link VideoCategoryMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see VideoCategoryMapPersistence
 * @see VideoCategoryMapPersistenceImpl
 * @generated
 */
public class VideoCategoryMapUtil {
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
	public static void clearCache(VideoCategoryMap videoCategoryMap) {
		getPersistence().clearCache(videoCategoryMap);
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
	public static List<VideoCategoryMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VideoCategoryMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VideoCategoryMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VideoCategoryMap update(VideoCategoryMap videoCategoryMap,
		boolean merge) throws SystemException {
		return getPersistence().update(videoCategoryMap, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VideoCategoryMap update(VideoCategoryMap videoCategoryMap,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(videoCategoryMap, merge, serviceContext);
	}

	/**
	* Caches the video category map in the entity cache if it is enabled.
	*
	* @param videoCategoryMap the video category map
	*/
	public static void cacheResult(
		com.bkav.portal.portlet.video.model.VideoCategoryMap videoCategoryMap) {
		getPersistence().cacheResult(videoCategoryMap);
	}

	/**
	* Caches the video category maps in the entity cache if it is enabled.
	*
	* @param videoCategoryMaps the video category maps
	*/
	public static void cacheResult(
		java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> videoCategoryMaps) {
		getPersistence().cacheResult(videoCategoryMaps);
	}

	/**
	* Creates a new video category map with the primary key. Does not add the video category map to the database.
	*
	* @param mapId the primary key for the new video category map
	* @return the new video category map
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap create(
		long mapId) {
		return getPersistence().create(mapId);
	}

	/**
	* Removes the video category map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mapId the primary key of the video category map
	* @return the video category map that was removed
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a video category map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap remove(
		long mapId)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(mapId);
	}

	public static com.bkav.portal.portlet.video.model.VideoCategoryMap updateImpl(
		com.bkav.portal.portlet.video.model.VideoCategoryMap videoCategoryMap,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(videoCategoryMap, merge);
	}

	/**
	* Returns the video category map with the primary key or throws a {@link com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException} if it could not be found.
	*
	* @param mapId the primary key of the video category map
	* @return the video category map
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a video category map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap findByPrimaryKey(
		long mapId)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(mapId);
	}

	/**
	* Returns the video category map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mapId the primary key of the video category map
	* @return the video category map, or <code>null</code> if a video category map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap fetchByPrimaryKey(
		long mapId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(mapId);
	}

	/**
	* Returns all the video category maps where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching video category maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId);
	}

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
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId, start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory(categoryId, start, end, orderByComparator);
	}

	/**
	* Returns the first video category map in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video category map
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap findByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory_First(categoryId, orderByComparator);
	}

	/**
	* Returns the first video category map in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video category map, or <code>null</code> if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_First(categoryId, orderByComparator);
	}

	/**
	* Returns the last video category map in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video category map
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap findByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the last video category map in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video category map, or <code>null</code> if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_Last(categoryId, orderByComparator);
	}

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
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap[] findByCategory_PrevAndNext(
		long mapId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory_PrevAndNext(mapId, categoryId,
			orderByComparator);
	}

	/**
	* Returns all the video category maps where entryId = &#63;.
	*
	* @param entryId the entry ID
	* @return the matching video category maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findByEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEntry(entryId);
	}

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
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findByEntry(
		long entryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEntry(entryId, start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findByEntry(
		long entryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEntry(entryId, start, end, orderByComparator);
	}

	/**
	* Returns the first video category map in the ordered set where entryId = &#63;.
	*
	* @param entryId the entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video category map
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap findByEntry_First(
		long entryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEntry_First(entryId, orderByComparator);
	}

	/**
	* Returns the first video category map in the ordered set where entryId = &#63;.
	*
	* @param entryId the entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video category map, or <code>null</code> if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap fetchByEntry_First(
		long entryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEntry_First(entryId, orderByComparator);
	}

	/**
	* Returns the last video category map in the ordered set where entryId = &#63;.
	*
	* @param entryId the entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video category map
	* @throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap findByEntry_Last(
		long entryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEntry_Last(entryId, orderByComparator);
	}

	/**
	* Returns the last video category map in the ordered set where entryId = &#63;.
	*
	* @param entryId the entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video category map, or <code>null</code> if a matching video category map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap fetchByEntry_Last(
		long entryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEntry_Last(entryId, orderByComparator);
	}

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
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap[] findByEntry_PrevAndNext(
		long mapId, long entryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.video.NoSuchVideoCategoryMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEntry_PrevAndNext(mapId, entryId, orderByComparator);
	}

	/**
	* Returns all the video category maps.
	*
	* @return the video category maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the video category maps where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategory(categoryId);
	}

	/**
	* Removes all the video category maps where entryId = &#63; from the database.
	*
	* @param entryId the entry ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEntry(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEntry(entryId);
	}

	/**
	* Removes all the video category maps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video category maps where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching video category maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategory(categoryId);
	}

	/**
	* Returns the number of video category maps where entryId = &#63;.
	*
	* @param entryId the entry ID
	* @return the number of matching video category maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEntry(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEntry(entryId);
	}

	/**
	* Returns the number of video category maps.
	*
	* @return the number of video category maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VideoCategoryMapPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VideoCategoryMapPersistence)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.video.service.ClpSerializer.getServletContextName(),
					VideoCategoryMapPersistence.class.getName());

			ReferenceRegistry.registerReference(VideoCategoryMapUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(VideoCategoryMapPersistence persistence) {
	}

	private static VideoCategoryMapPersistence _persistence;
}