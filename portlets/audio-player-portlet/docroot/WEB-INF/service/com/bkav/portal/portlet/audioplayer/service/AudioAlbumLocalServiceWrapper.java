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
 * This class is a wrapper for {@link AudioAlbumLocalService}.
 * </p>
 *
 * @author    anhbdb
 * @see       AudioAlbumLocalService
 * @generated
 */
public class AudioAlbumLocalServiceWrapper implements AudioAlbumLocalService,
	ServiceWrapper<AudioAlbumLocalService> {
	public AudioAlbumLocalServiceWrapper(
		AudioAlbumLocalService audioAlbumLocalService) {
		_audioAlbumLocalService = audioAlbumLocalService;
	}

	/**
	* Adds the audio album to the database. Also notifies the appropriate model listeners.
	*
	* @param audioAlbum the audio album
	* @return the audio album that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum addAudioAlbum(
		com.bkav.portal.portlet.audioplayer.model.AudioAlbum audioAlbum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.addAudioAlbum(audioAlbum);
	}

	/**
	* Creates a new audio album with the primary key. Does not add the audio album to the database.
	*
	* @param albumId the primary key for the new audio album
	* @return the new audio album
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum createAudioAlbum(
		long albumId) {
		return _audioAlbumLocalService.createAudioAlbum(albumId);
	}

	/**
	* Deletes the audio album with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param albumId the primary key of the audio album
	* @return the audio album that was removed
	* @throws PortalException if a audio album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum deleteAudioAlbum(
		long albumId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.deleteAudioAlbum(albumId);
	}

	/**
	* Deletes the audio album from the database. Also notifies the appropriate model listeners.
	*
	* @param audioAlbum the audio album
	* @return the audio album that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum deleteAudioAlbum(
		com.bkav.portal.portlet.audioplayer.model.AudioAlbum audioAlbum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.deleteAudioAlbum(audioAlbum);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _audioAlbumLocalService.dynamicQuery();
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
		return _audioAlbumLocalService.dynamicQuery(dynamicQuery);
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
		return _audioAlbumLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _audioAlbumLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _audioAlbumLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum fetchAudioAlbum(
		long albumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.fetchAudioAlbum(albumId);
	}

	/**
	* Returns the audio album with the primary key.
	*
	* @param albumId the primary key of the audio album
	* @return the audio album
	* @throws PortalException if a audio album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum getAudioAlbum(
		long albumId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.getAudioAlbum(albumId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.getPersistedModel(primaryKeyObj);
	}

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
	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> getAudioAlbums(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.getAudioAlbums(start, end);
	}

	/**
	* Returns the number of audio albums.
	*
	* @return the number of audio albums
	* @throws SystemException if a system exception occurred
	*/
	public int getAudioAlbumsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.getAudioAlbumsCount();
	}

	/**
	* Updates the audio album in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param audioAlbum the audio album
	* @return the audio album that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum updateAudioAlbum(
		com.bkav.portal.portlet.audioplayer.model.AudioAlbum audioAlbum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.updateAudioAlbum(audioAlbum);
	}

	/**
	* Updates the audio album in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param audioAlbum the audio album
	* @param merge whether to merge the audio album with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the audio album that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum updateAudioAlbum(
		com.bkav.portal.portlet.audioplayer.model.AudioAlbum audioAlbum,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.updateAudioAlbum(audioAlbum, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _audioAlbumLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_audioAlbumLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _audioAlbumLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findAll()
		throws java.lang.Exception {
		return _audioAlbumLocalService.findAll();
	}

	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.findByCompany(companyId);
	}

	public java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.findByGroup(groupId);
	}

	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum getAudioAlbumCounter(
		long albumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.getAudioAlbumCounter(albumId);
	}

	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum addAudioAlbum(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String albumName, java.lang.String albumInfo,
		long albumCoverId, long viewCounter,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.addAudioAlbum(companyId, groupId,
			userId, userName, albumName, albumInfo, albumCoverId, viewCounter,
			serviceContext);
	}

	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum updateAudioAlbum(
		java.lang.String albumName, java.lang.String albumInfo,
		long albumCoverId, long viewCounter, long albumId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.updateAudioAlbum(albumName, albumInfo,
			albumCoverId, viewCounter, albumId);
	}

	public com.bkav.portal.portlet.audioplayer.model.AudioAlbum updateAlbumView(
		long albumId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _audioAlbumLocalService.updateAlbumView(albumId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AudioAlbumLocalService getWrappedAudioAlbumLocalService() {
		return _audioAlbumLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAudioAlbumLocalService(
		AudioAlbumLocalService audioAlbumLocalService) {
		_audioAlbumLocalService = audioAlbumLocalService;
	}

	public AudioAlbumLocalService getWrappedService() {
		return _audioAlbumLocalService;
	}

	public void setWrappedService(AudioAlbumLocalService audioAlbumLocalService) {
		_audioAlbumLocalService = audioAlbumLocalService;
	}

	private AudioAlbumLocalService _audioAlbumLocalService;
}