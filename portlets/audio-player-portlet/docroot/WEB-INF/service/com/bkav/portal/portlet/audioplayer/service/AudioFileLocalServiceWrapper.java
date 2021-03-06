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

package com.bkav.portal.portlet.audioplayer.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AudioFileLocalService}.
 * </p>
 *
 * @author    anhbdb
 * @see       AudioFileLocalService
 * @generated
 */
public class AudioFileLocalServiceWrapper implements AudioFileLocalService,
	ServiceWrapper<AudioFileLocalService> {
	public AudioFileLocalServiceWrapper(
		AudioFileLocalService audioFileLocalService) {
		_audioFileLocalService = audioFileLocalService;
	}

	/**
	* Adds the audio file to the database. Also notifies the appropriate model listeners.
	*
	* @param audioFile the audio file
	* @return the audio file that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile addAudioFile(
		com.bkav.portal.portlet.audioplayer.model.AudioFile audioFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.addAudioFile(audioFile);
	}

	/**
	* Creates a new audio file with the primary key. Does not add the audio file to the database.
	*
	* @param audioId the primary key for the new audio file
	* @return the new audio file
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile createAudioFile(
		long audioId) {
		return _audioFileLocalService.createAudioFile(audioId);
	}

	/**
	* Deletes the audio file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param audioId the primary key of the audio file
	* @return the audio file that was removed
	* @throws PortalException if a audio file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile deleteAudioFile(
		long audioId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.deleteAudioFile(audioId);
	}

	/**
	* Deletes the audio file from the database. Also notifies the appropriate model listeners.
	*
	* @param audioFile the audio file
	* @return the audio file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile deleteAudioFile(
		com.bkav.portal.portlet.audioplayer.model.AudioFile audioFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.deleteAudioFile(audioFile);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _audioFileLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.bkav.portal.portlet.audioplayer.model.AudioFile fetchAudioFile(
		long audioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.fetchAudioFile(audioId);
	}

	/**
	* Returns the audio file with the primary key.
	*
	* @param audioId the primary key of the audio file
	* @return the audio file
	* @throws PortalException if a audio file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile getAudioFile(
		long audioId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.getAudioFile(audioId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.getPersistedModel(primaryKeyObj);
	}

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
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> getAudioFiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.getAudioFiles(start, end);
	}

	/**
	* Returns the number of audio files.
	*
	* @return the number of audio files
	* @throws SystemException if a system exception occurred
	*/
	public int getAudioFilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.getAudioFilesCount();
	}

	/**
	* Updates the audio file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param audioFile the audio file
	* @return the audio file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile updateAudioFile(
		com.bkav.portal.portlet.audioplayer.model.AudioFile audioFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.updateAudioFile(audioFile);
	}

	/**
	* Updates the audio file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param audioFile the audio file
	* @param merge whether to merge the audio file with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the audio file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioFile updateAudioFile(
		com.bkav.portal.portlet.audioplayer.model.AudioFile audioFile,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.updateAudioFile(audioFile, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _audioFileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_audioFileLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _audioFileLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findAll()
		throws java.lang.Exception {
		return _audioFileLocalService.findAll();
	}

	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.findByCompany(companyId);
	}

	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.findByGroup(groupId);
	}

	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findByAudioName(
		long groupId, java.lang.String key, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _audioFileLocalService.findByAudioName(groupId, key, start, end,
			obc);
	}

	public com.bkav.portal.portlet.audioplayer.model.AudioFile getAudioFileCounter(
		long AudioFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.getAudioFileCounter(AudioFileId);
	}

	public com.bkav.portal.portlet.audioplayer.model.AudioFile addAudioFile(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String audioName, java.lang.String audioInfo,
		long audioFileId, long viewCounter, java.lang.String audioType,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.addAudioFile(companyId, groupId, userId,
			userName, audioName, audioInfo, audioFileId, viewCounter,
			audioType, serviceContext);
	}

	public com.bkav.portal.portlet.audioplayer.model.AudioFile updateAudioFile(
		java.lang.String audioName, java.lang.String audioInfo,
		long audioFileId, long viewCounter, long audioId,
		java.lang.String audioType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _audioFileLocalService.updateAudioFile(audioName, audioInfo,
			audioFileId, viewCounter, audioId, audioType);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AudioFileLocalService getWrappedAudioFileLocalService() {
		return _audioFileLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAudioFileLocalService(
		AudioFileLocalService audioFileLocalService) {
		_audioFileLocalService = audioFileLocalService;
	}

	public AudioFileLocalService getWrappedService() {
		return _audioFileLocalService;
	}

	public void setWrappedService(AudioFileLocalService audioFileLocalService) {
		_audioFileLocalService = audioFileLocalService;
	}

	private AudioFileLocalService _audioFileLocalService;
}