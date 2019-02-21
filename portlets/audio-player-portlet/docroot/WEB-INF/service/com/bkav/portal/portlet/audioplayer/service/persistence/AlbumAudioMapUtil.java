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

package com.bkav.portal.portlet.audioplayer.service.persistence;

import com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the album audio map service. This utility wraps {@link AlbumAudioMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see AlbumAudioMapPersistence
 * @see AlbumAudioMapPersistenceImpl
 * @generated
 */
public class AlbumAudioMapUtil {
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
	public static void clearCache(AlbumAudioMap albumAudioMap) {
		getPersistence().clearCache(albumAudioMap);
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
	public static List<AlbumAudioMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AlbumAudioMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AlbumAudioMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AlbumAudioMap update(AlbumAudioMap albumAudioMap,
		boolean merge) throws SystemException {
		return getPersistence().update(albumAudioMap, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AlbumAudioMap update(AlbumAudioMap albumAudioMap,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(albumAudioMap, merge, serviceContext);
	}

	/**
	* Caches the album audio map in the entity cache if it is enabled.
	*
	* @param albumAudioMap the album audio map
	*/
	public static void cacheResult(
		com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap albumAudioMap) {
		getPersistence().cacheResult(albumAudioMap);
	}

	/**
	* Caches the album audio maps in the entity cache if it is enabled.
	*
	* @param albumAudioMaps the album audio maps
	*/
	public static void cacheResult(
		java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> albumAudioMaps) {
		getPersistence().cacheResult(albumAudioMaps);
	}

	/**
	* Creates a new album audio map with the primary key. Does not add the album audio map to the database.
	*
	* @param mapId the primary key for the new album audio map
	* @return the new album audio map
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap create(
		long mapId) {
		return getPersistence().create(mapId);
	}

	/**
	* Removes the album audio map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mapId the primary key of the album audio map
	* @return the album audio map that was removed
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a album audio map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap remove(
		long mapId)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(mapId);
	}

	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap updateImpl(
		com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap albumAudioMap,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(albumAudioMap, merge);
	}

	/**
	* Returns the album audio map with the primary key or throws a {@link com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException} if it could not be found.
	*
	* @param mapId the primary key of the album audio map
	* @return the album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a album audio map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap findByPrimaryKey(
		long mapId)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(mapId);
	}

	/**
	* Returns the album audio map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mapId the primary key of the album audio map
	* @return the album audio map, or <code>null</code> if a album audio map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchByPrimaryKey(
		long mapId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(mapId);
	}

	/**
	* Returns all the album audio maps where albumId = &#63;.
	*
	* @param albumId the album ID
	* @return the matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAlbum(
		long albumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAlbum(albumId);
	}

	/**
	* Returns a range of all the album audio maps where albumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param albumId the album ID
	* @param start the lower bound of the range of album audio maps
	* @param end the upper bound of the range of album audio maps (not inclusive)
	* @return the range of matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAlbum(
		long albumId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAlbum(albumId, start, end);
	}

	/**
	* Returns an ordered range of all the album audio maps where albumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param albumId the album ID
	* @param start the lower bound of the range of album audio maps
	* @param end the upper bound of the range of album audio maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAlbum(
		long albumId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAlbum(albumId, start, end, orderByComparator);
	}

	/**
	* Returns the first album audio map in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap findByAlbum_First(
		long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAlbum_First(albumId, orderByComparator);
	}

	/**
	* Returns the first album audio map in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album audio map, or <code>null</code> if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchByAlbum_First(
		long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAlbum_First(albumId, orderByComparator);
	}

	/**
	* Returns the last album audio map in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap findByAlbum_Last(
		long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAlbum_Last(albumId, orderByComparator);
	}

	/**
	* Returns the last album audio map in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album audio map, or <code>null</code> if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchByAlbum_Last(
		long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAlbum_Last(albumId, orderByComparator);
	}

	/**
	* Returns the album audio maps before and after the current album audio map in the ordered set where albumId = &#63;.
	*
	* @param mapId the primary key of the current album audio map
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a album audio map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap[] findByAlbum_PrevAndNext(
		long mapId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAlbum_PrevAndNext(mapId, albumId, orderByComparator);
	}

	/**
	* Returns all the album audio maps where audioId = &#63;.
	*
	* @param audioId the audio ID
	* @return the matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAudio(
		long audioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAudio(audioId);
	}

	/**
	* Returns a range of all the album audio maps where audioId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param audioId the audio ID
	* @param start the lower bound of the range of album audio maps
	* @param end the upper bound of the range of album audio maps (not inclusive)
	* @return the range of matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAudio(
		long audioId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAudio(audioId, start, end);
	}

	/**
	* Returns an ordered range of all the album audio maps where audioId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param audioId the audio ID
	* @param start the lower bound of the range of album audio maps
	* @param end the upper bound of the range of album audio maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAudio(
		long audioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAudio(audioId, start, end, orderByComparator);
	}

	/**
	* Returns the first album audio map in the ordered set where audioId = &#63;.
	*
	* @param audioId the audio ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap findByAudio_First(
		long audioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAudio_First(audioId, orderByComparator);
	}

	/**
	* Returns the first album audio map in the ordered set where audioId = &#63;.
	*
	* @param audioId the audio ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album audio map, or <code>null</code> if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchByAudio_First(
		long audioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAudio_First(audioId, orderByComparator);
	}

	/**
	* Returns the last album audio map in the ordered set where audioId = &#63;.
	*
	* @param audioId the audio ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap findByAudio_Last(
		long audioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAudio_Last(audioId, orderByComparator);
	}

	/**
	* Returns the last album audio map in the ordered set where audioId = &#63;.
	*
	* @param audioId the audio ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album audio map, or <code>null</code> if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchByAudio_Last(
		long audioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAudio_Last(audioId, orderByComparator);
	}

	/**
	* Returns the album audio maps before and after the current album audio map in the ordered set where audioId = &#63;.
	*
	* @param mapId the primary key of the current album audio map
	* @param audioId the audio ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a album audio map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap[] findByAudio_PrevAndNext(
		long mapId, long audioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAudio_PrevAndNext(mapId, audioId, orderByComparator);
	}

	/**
	* Returns all the album audio maps where audioId = &#63; and albumId = &#63;.
	*
	* @param audioId the audio ID
	* @param albumId the album ID
	* @return the matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAudioAlbum(
		long audioId, long albumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAudioAlbum(audioId, albumId);
	}

	/**
	* Returns a range of all the album audio maps where audioId = &#63; and albumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param audioId the audio ID
	* @param albumId the album ID
	* @param start the lower bound of the range of album audio maps
	* @param end the upper bound of the range of album audio maps (not inclusive)
	* @return the range of matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAudioAlbum(
		long audioId, long albumId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAudioAlbum(audioId, albumId, start, end);
	}

	/**
	* Returns an ordered range of all the album audio maps where audioId = &#63; and albumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param audioId the audio ID
	* @param albumId the album ID
	* @param start the lower bound of the range of album audio maps
	* @param end the upper bound of the range of album audio maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAudioAlbum(
		long audioId, long albumId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAudioAlbum(audioId, albumId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first album audio map in the ordered set where audioId = &#63; and albumId = &#63;.
	*
	* @param audioId the audio ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap findByAudioAlbum_First(
		long audioId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAudioAlbum_First(audioId, albumId, orderByComparator);
	}

	/**
	* Returns the first album audio map in the ordered set where audioId = &#63; and albumId = &#63;.
	*
	* @param audioId the audio ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album audio map, or <code>null</code> if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchByAudioAlbum_First(
		long audioId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAudioAlbum_First(audioId, albumId, orderByComparator);
	}

	/**
	* Returns the last album audio map in the ordered set where audioId = &#63; and albumId = &#63;.
	*
	* @param audioId the audio ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap findByAudioAlbum_Last(
		long audioId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAudioAlbum_Last(audioId, albumId, orderByComparator);
	}

	/**
	* Returns the last album audio map in the ordered set where audioId = &#63; and albumId = &#63;.
	*
	* @param audioId the audio ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album audio map, or <code>null</code> if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchByAudioAlbum_Last(
		long audioId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAudioAlbum_Last(audioId, albumId, orderByComparator);
	}

	/**
	* Returns the album audio maps before and after the current album audio map in the ordered set where audioId = &#63; and albumId = &#63;.
	*
	* @param mapId the primary key of the current album audio map
	* @param audioId the audio ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a album audio map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap[] findByAudioAlbum_PrevAndNext(
		long mapId, long audioId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAudioAlbum_PrevAndNext(mapId, audioId, albumId,
			orderByComparator);
	}

	/**
	* Returns all the album audio maps.
	*
	* @return the album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the album audio maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of album audio maps
	* @param end the upper bound of the range of album audio maps (not inclusive)
	* @return the range of album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the album audio maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of album audio maps
	* @param end the upper bound of the range of album audio maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the album audio maps where albumId = &#63; from the database.
	*
	* @param albumId the album ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAlbum(long albumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAlbum(albumId);
	}

	/**
	* Removes all the album audio maps where audioId = &#63; from the database.
	*
	* @param audioId the audio ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAudio(long audioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAudio(audioId);
	}

	/**
	* Removes all the album audio maps where audioId = &#63; and albumId = &#63; from the database.
	*
	* @param audioId the audio ID
	* @param albumId the album ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAudioAlbum(long audioId, long albumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAudioAlbum(audioId, albumId);
	}

	/**
	* Removes all the album audio maps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of album audio maps where albumId = &#63;.
	*
	* @param albumId the album ID
	* @return the number of matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAlbum(long albumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAlbum(albumId);
	}

	/**
	* Returns the number of album audio maps where audioId = &#63;.
	*
	* @param audioId the audio ID
	* @return the number of matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAudio(long audioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAudio(audioId);
	}

	/**
	* Returns the number of album audio maps where audioId = &#63; and albumId = &#63;.
	*
	* @param audioId the audio ID
	* @param albumId the album ID
	* @return the number of matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAudioAlbum(long audioId, long albumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAudioAlbum(audioId, albumId);
	}

	/**
	* Returns the number of album audio maps.
	*
	* @return the number of album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AlbumAudioMapPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AlbumAudioMapPersistence)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.audioplayer.service.ClpSerializer.getServletContextName(),
					AlbumAudioMapPersistence.class.getName());

			ReferenceRegistry.registerReference(AlbumAudioMapUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(AlbumAudioMapPersistence persistence) {
	}

	private static AlbumAudioMapPersistence _persistence;
}