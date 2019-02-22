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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the album audio map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see AlbumAudioMapPersistenceImpl
 * @see AlbumAudioMapUtil
 * @generated
 */
public interface AlbumAudioMapPersistence extends BasePersistence<AlbumAudioMap> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AlbumAudioMapUtil} to access the album audio map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the album audio map in the entity cache if it is enabled.
	*
	* @param albumAudioMap the album audio map
	*/
	public void cacheResult(
		com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap albumAudioMap);

	/**
	* Caches the album audio maps in the entity cache if it is enabled.
	*
	* @param albumAudioMaps the album audio maps
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> albumAudioMaps);

	/**
	* Creates a new album audio map with the primary key. Does not add the album audio map to the database.
	*
	* @param mapId the primary key for the new album audio map
	* @return the new album audio map
	*/
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap create(
		long mapId);

	/**
	* Removes the album audio map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mapId the primary key of the album audio map
	* @return the album audio map that was removed
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a album audio map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap remove(
		long mapId)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap updateImpl(
		com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap albumAudioMap,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the album audio map with the primary key or throws a {@link com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException} if it could not be found.
	*
	* @param mapId the primary key of the album audio map
	* @return the album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a album audio map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap findByPrimaryKey(
		long mapId)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the album audio map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mapId the primary key of the album audio map
	* @return the album audio map, or <code>null</code> if a album audio map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchByPrimaryKey(
		long mapId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the album audio maps where albumId = &#63;.
	*
	* @param albumId the album ID
	* @return the matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAlbum(
		long albumId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAlbum(
		long albumId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAlbum(
		long albumId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first album audio map in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap findByAlbum_First(
		long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first album audio map in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album audio map, or <code>null</code> if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchByAlbum_First(
		long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last album audio map in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap findByAlbum_Last(
		long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last album audio map in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album audio map, or <code>null</code> if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchByAlbum_Last(
		long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap[] findByAlbum_PrevAndNext(
		long mapId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the album audio maps where audioId = &#63;.
	*
	* @param audioId the audio ID
	* @return the matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAudio(
		long audioId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAudio(
		long audioId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAudio(
		long audioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first album audio map in the ordered set where audioId = &#63;.
	*
	* @param audioId the audio ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap findByAudio_First(
		long audioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first album audio map in the ordered set where audioId = &#63;.
	*
	* @param audioId the audio ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album audio map, or <code>null</code> if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchByAudio_First(
		long audioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last album audio map in the ordered set where audioId = &#63;.
	*
	* @param audioId the audio ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album audio map
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap findByAudio_Last(
		long audioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last album audio map in the ordered set where audioId = &#63;.
	*
	* @param audioId the audio ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album audio map, or <code>null</code> if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchByAudio_Last(
		long audioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap[] findByAudio_PrevAndNext(
		long mapId, long audioId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the album audio maps where audioId = &#63; and albumId = &#63;.
	*
	* @param audioId the audio ID
	* @param albumId the album ID
	* @return the matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAudioAlbum(
		long audioId, long albumId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAudioAlbum(
		long audioId, long albumId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAudioAlbum(
		long audioId, long albumId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap findByAudioAlbum_First(
		long audioId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first album audio map in the ordered set where audioId = &#63; and albumId = &#63;.
	*
	* @param audioId the audio ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album audio map, or <code>null</code> if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchByAudioAlbum_First(
		long audioId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap findByAudioAlbum_Last(
		long audioId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last album audio map in the ordered set where audioId = &#63; and albumId = &#63;.
	*
	* @param audioId the audio ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album audio map, or <code>null</code> if a matching album audio map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchByAudioAlbum_Last(
		long audioId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap[] findByAudioAlbum_PrevAndNext(
		long mapId, long audioId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAlbumAudioMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the album audio maps.
	*
	* @return the album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the album audio maps where albumId = &#63; from the database.
	*
	* @param albumId the album ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAlbum(long albumId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the album audio maps where audioId = &#63; from the database.
	*
	* @param audioId the audio ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAudio(long audioId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the album audio maps where audioId = &#63; and albumId = &#63; from the database.
	*
	* @param audioId the audio ID
	* @param albumId the album ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAudioAlbum(long audioId, long albumId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the album audio maps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of album audio maps where albumId = &#63;.
	*
	* @param albumId the album ID
	* @return the number of matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public int countByAlbum(long albumId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of album audio maps where audioId = &#63;.
	*
	* @param audioId the audio ID
	* @return the number of matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public int countByAudio(long audioId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of album audio maps where audioId = &#63; and albumId = &#63;.
	*
	* @param audioId the audio ID
	* @param albumId the album ID
	* @return the number of matching album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public int countByAudioAlbum(long audioId, long albumId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of album audio maps.
	*
	* @return the number of album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}