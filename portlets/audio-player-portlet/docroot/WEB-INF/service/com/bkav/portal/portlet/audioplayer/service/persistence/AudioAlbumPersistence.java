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

import com.bkav.portal.portlet.audioplayer.model.AudioAlbum;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the audio album service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see AudioAlbumPersistenceImpl
 * @see AudioAlbumUtil
 * @generated
 */
public interface AudioAlbumPersistence extends BasePersistence<AudioAlbum> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AudioAlbumUtil} to access the audio album persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the audio album in the entity cache if it is enabled.
	*
	* @param audioAlbum the audio album
	*/
	public void cacheResult(
		com.bkav.portal.portlet.audioplayer.model.AudioAlbum audioAlbum);

	/**
	* Caches the audio albums in the entity cache if it is enabled.
	*
	* @param audioAlbums the audio albums
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> audioAlbums);

	/**
	* Creates a new audio album with the primary key. Does not add the audio album to the database.
	*
	* @param albumId the primary key for the new audio album
	* @return the new audio album
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum create(
		long albumId);

	/**
	* Removes the audio album with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param albumId the primary key of the audio album
	* @return the audio album that was removed
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a audio album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum remove(
		long albumId)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum updateImpl(
		com.bkav.portal.portlet.audioplayer.model.AudioAlbum audioAlbum,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the audio album with the primary key or throws a {@link com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException} if it could not be found.
	*
	* @param albumId the primary key of the audio album
	* @return the audio album
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a audio album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum findByPrimaryKey(
		long albumId)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the audio album with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param albumId the primary key of the audio album
	* @return the audio album, or <code>null</code> if a audio album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum fetchByPrimaryKey(
		long albumId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the audio albums where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching audio albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the audio albums where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of audio albums
	* @param end the upper bound of the range of audio albums (not inclusive)
	* @return the range of matching audio albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the audio albums where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of audio albums
	* @param end the upper bound of the range of audio albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching audio albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first audio album in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching audio album
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a matching audio album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first audio album in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching audio album, or <code>null</code> if a matching audio album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last audio album in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching audio album
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a matching audio album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last audio album in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching audio album, or <code>null</code> if a matching audio album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the audio albums before and after the current audio album in the ordered set where groupId = &#63;.
	*
	* @param albumId the primary key of the current audio album
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next audio album
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a audio album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum[] findByGroupId_PrevAndNext(
		long albumId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the audio albums that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching audio albums that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the audio albums that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of audio albums
	* @param end the upper bound of the range of audio albums (not inclusive)
	* @return the range of matching audio albums that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the audio albums that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of audio albums
	* @param end the upper bound of the range of audio albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching audio albums that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the audio albums before and after the current audio album in the ordered set of audio albums that the user has permission to view where groupId = &#63;.
	*
	* @param albumId the primary key of the current audio album
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next audio album
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a audio album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum[] filterFindByGroupId_PrevAndNext(
		long albumId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the audio albums where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching audio albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the audio albums where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of audio albums
	* @param end the upper bound of the range of audio albums (not inclusive)
	* @return the range of matching audio albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the audio albums where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of audio albums
	* @param end the upper bound of the range of audio albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching audio albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first audio album in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching audio album
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a matching audio album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first audio album in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching audio album, or <code>null</code> if a matching audio album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last audio album in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching audio album
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a matching audio album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last audio album in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching audio album, or <code>null</code> if a matching audio album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the audio albums before and after the current audio album in the ordered set where companyId = &#63;.
	*
	* @param albumId the primary key of the current audio album
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next audio album
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException if a audio album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum[] findByCompanyId_PrevAndNext(
		long albumId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioAlbumException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the audio albums.
	*
	* @return the audio albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the audio albums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of audio albums
	* @param end the upper bound of the range of audio albums (not inclusive)
	* @return the range of audio albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the audio albums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of audio albums
	* @param end the upper bound of the range of audio albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of audio albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the audio albums where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the audio albums where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the audio albums from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of audio albums where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching audio albums
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of audio albums that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching audio albums that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of audio albums where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching audio albums
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of audio albums.
	*
	* @return the number of audio albums
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}