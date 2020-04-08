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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the audio album local service. This utility wraps {@link com.bkav.portal.portlet.audioplayer.service.impl.AudioAlbumLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anhbdb
 * @see AudioAlbumLocalService
 * @see com.bkav.portal.portlet.audioplayer.service.base.AudioAlbumLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.audioplayer.service.impl.AudioAlbumLocalServiceImpl
 * @generated
 */
public class AudioAlbumLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bkav.portal.portlet.audioplayer.service.impl.AudioAlbumLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the audio album to the database. Also notifies the appropriate model listeners.
	*
	* @param audioAlbum the audio album
	* @return the audio album that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AudioAlbum addAudioAlbum(
		com.bkav.portal.portlet.audioplayer.model.AudioAlbum audioAlbum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAudioAlbum(audioAlbum);
	}

	/**
	* Creates a new audio album with the primary key. Does not add the audio album to the database.
	*
	* @param albumId the primary key for the new audio album
	* @return the new audio album
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AudioAlbum createAudioAlbum(
		long albumId) {
		return getService().createAudioAlbum(albumId);
	}

	/**
	* Deletes the audio album with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param albumId the primary key of the audio album
	* @return the audio album that was removed
	* @throws PortalException if a audio album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AudioAlbum deleteAudioAlbum(
		long albumId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAudioAlbum(albumId);
	}

	/**
	* Deletes the audio album from the database. Also notifies the appropriate model listeners.
	*
	* @param audioAlbum the audio album
	* @return the audio album that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AudioAlbum deleteAudioAlbum(
		com.bkav.portal.portlet.audioplayer.model.AudioAlbum audioAlbum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAudioAlbum(audioAlbum);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.bkav.portal.portlet.audioplayer.model.AudioAlbum fetchAudioAlbum(
		long albumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAudioAlbum(albumId);
	}

	/**
	* Returns the audio album with the primary key.
	*
	* @param albumId the primary key of the audio album
	* @return the audio album
	* @throws PortalException if a audio album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AudioAlbum getAudioAlbum(
		long albumId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAudioAlbum(albumId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> getAudioAlbums(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAudioAlbums(start, end);
	}

	/**
	* Returns the number of audio albums.
	*
	* @return the number of audio albums
	* @throws SystemException if a system exception occurred
	*/
	public static int getAudioAlbumsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAudioAlbumsCount();
	}

	/**
	* Updates the audio album in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param audioAlbum the audio album
	* @return the audio album that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AudioAlbum updateAudioAlbum(
		com.bkav.portal.portlet.audioplayer.model.AudioAlbum audioAlbum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAudioAlbum(audioAlbum);
	}

	/**
	* Updates the audio album in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param audioAlbum the audio album
	* @param merge whether to merge the audio album with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the audio album that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AudioAlbum updateAudioAlbum(
		com.bkav.portal.portlet.audioplayer.model.AudioAlbum audioAlbum,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAudioAlbum(audioAlbum, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findAll()
		throws java.lang.Exception {
		return getService().findAll();
	}

	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioAlbum> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static com.bkav.portal.portlet.audioplayer.model.AudioAlbum getAudioAlbumCounter(
		long albumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAudioAlbumCounter(albumId);
	}

	public static com.bkav.portal.portlet.audioplayer.model.AudioAlbum addAudioAlbum(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String albumName, java.lang.String albumInfo,
		long albumCoverId, long viewCounter,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addAudioAlbum(companyId, groupId, userId, userName,
			albumName, albumInfo, albumCoverId, viewCounter, serviceContext);
	}

	public static com.bkav.portal.portlet.audioplayer.model.AudioAlbum updateAudioAlbum(
		java.lang.String albumName, java.lang.String albumInfo,
		long albumCoverId, long viewCounter, long albumId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateAudioAlbum(albumName, albumInfo, albumCoverId,
			viewCounter, albumId);
	}

	public static com.bkav.portal.portlet.audioplayer.model.AudioAlbum updateAlbumView(
		long albumId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAlbumView(albumId);
	}

	public static void clearService() {
		_service = null;
	}

	public static AudioAlbumLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AudioAlbumLocalService.class.getName());

			if (invokableLocalService instanceof AudioAlbumLocalService) {
				_service = (AudioAlbumLocalService)invokableLocalService;
			}
			else {
				_service = new AudioAlbumLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AudioAlbumLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(AudioAlbumLocalService service) {
	}

	private static AudioAlbumLocalService _service;
}