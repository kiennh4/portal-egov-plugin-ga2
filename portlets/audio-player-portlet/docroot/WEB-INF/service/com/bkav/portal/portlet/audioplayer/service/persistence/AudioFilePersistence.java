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

import com.bkav.portal.portlet.audioplayer.model.AudioFile;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the audio file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see AudioFilePersistenceImpl
 * @see AudioFileUtil
 * @generated
 */
public interface AudioFilePersistence extends BasePersistence<AudioFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AudioFileUtil} to access the audio file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the audio file in the entity cache if it is enabled.
	*
	* @param audioFile the audio file
	*/
	public void cacheResult(
		com.bkav.portal.portlet.audioplayer.model.AudioFile audioFile);

	/**
	* Caches the audio files in the entity cache if it is enabled.
	*
	* @param audioFiles the audio files
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> audioFiles);

	/**
	* Creates a new audio file with the primary key. Does not add the audio file to the database.
	*
	* @param audioId the primary key for the new audio file
	* @return the new audio file
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile create(
		long audioId);

	/**
	* Removes the audio file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param audioId the primary key of the audio file
	* @return the audio file that was removed
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a audio file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile remove(
		long audioId)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.audioplayer.model.AudioFile updateImpl(
		com.bkav.portal.portlet.audioplayer.model.AudioFile audioFile,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the audio file with the primary key or throws a {@link com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException} if it could not be found.
	*
	* @param audioId the primary key of the audio file
	* @return the audio file
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a audio file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile findByPrimaryKey(
		long audioId)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the audio file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param audioId the primary key of the audio file
	* @return the audio file, or <code>null</code> if a audio file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile fetchByPrimaryKey(
		long audioId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the audio files where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching audio files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the audio files where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of audio files
	* @param end the upper bound of the range of audio files (not inclusive)
	* @return the range of matching audio files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the audio files where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of audio files
	* @param end the upper bound of the range of audio files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching audio files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first audio file in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching audio file
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a matching audio file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first audio file in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching audio file, or <code>null</code> if a matching audio file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last audio file in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching audio file
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a matching audio file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last audio file in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching audio file, or <code>null</code> if a matching audio file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the audio files before and after the current audio file in the ordered set where groupId = &#63;.
	*
	* @param audioId the primary key of the current audio file
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next audio file
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a audio file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile[] findByGroupId_PrevAndNext(
		long audioId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the audio files that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching audio files that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the audio files that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of audio files
	* @param end the upper bound of the range of audio files (not inclusive)
	* @return the range of matching audio files that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the audio files that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of audio files
	* @param end the upper bound of the range of audio files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching audio files that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the audio files before and after the current audio file in the ordered set of audio files that the user has permission to view where groupId = &#63;.
	*
	* @param audioId the primary key of the current audio file
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next audio file
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a audio file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile[] filterFindByGroupId_PrevAndNext(
		long audioId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the audio files where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching audio files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the audio files where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of audio files
	* @param end the upper bound of the range of audio files (not inclusive)
	* @return the range of matching audio files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the audio files where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of audio files
	* @param end the upper bound of the range of audio files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching audio files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first audio file in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching audio file
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a matching audio file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first audio file in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching audio file, or <code>null</code> if a matching audio file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last audio file in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching audio file
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a matching audio file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last audio file in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching audio file, or <code>null</code> if a matching audio file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the audio files before and after the current audio file in the ordered set where companyId = &#63;.
	*
	* @param audioId the primary key of the current audio file
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next audio file
	* @throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException if a audio file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile[] findByCompanyId_PrevAndNext(
		long audioId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.audioplayer.NoSuchAudioFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the audio files.
	*
	* @return the audio files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the audio files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of audio files
	* @param end the upper bound of the range of audio files (not inclusive)
	* @return the range of audio files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the audio files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of audio files
	* @param end the upper bound of the range of audio files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of audio files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the audio files where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the audio files where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the audio files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of audio files where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching audio files
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of audio files that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching audio files that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of audio files where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching audio files
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of audio files.
	*
	* @return the number of audio files
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}