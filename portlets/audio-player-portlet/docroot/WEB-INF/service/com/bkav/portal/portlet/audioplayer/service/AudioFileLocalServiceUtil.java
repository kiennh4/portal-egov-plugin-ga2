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
 * The utility for the audio file local service. This utility wraps {@link com.bkav.portal.portlet.audioplayer.service.impl.AudioFileLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anhbdb
 * @see AudioFileLocalService
 * @see com.bkav.portal.portlet.audioplayer.service.base.AudioFileLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.audioplayer.service.impl.AudioFileLocalServiceImpl
 * @generated
 */
public class AudioFileLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bkav.portal.portlet.audioplayer.service.impl.AudioFileLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the audio file to the database. Also notifies the appropriate model listeners.
	*
	* @param audioFile the audio file
	* @return the audio file that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AudioFile addAudioFile(
		com.bkav.portal.portlet.audioplayer.model.AudioFile audioFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAudioFile(audioFile);
	}

	/**
	* Creates a new audio file with the primary key. Does not add the audio file to the database.
	*
	* @param audioId the primary key for the new audio file
	* @return the new audio file
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AudioFile createAudioFile(
		long audioId) {
		return getService().createAudioFile(audioId);
	}

	/**
	* Deletes the audio file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param audioId the primary key of the audio file
	* @return the audio file that was removed
	* @throws PortalException if a audio file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AudioFile deleteAudioFile(
		long audioId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAudioFile(audioId);
	}

	/**
	* Deletes the audio file from the database. Also notifies the appropriate model listeners.
	*
	* @param audioFile the audio file
	* @return the audio file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AudioFile deleteAudioFile(
		com.bkav.portal.portlet.audioplayer.model.AudioFile audioFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAudioFile(audioFile);
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

	public static com.bkav.portal.portlet.audioplayer.model.AudioFile fetchAudioFile(
		long audioId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAudioFile(audioId);
	}

	/**
	* Returns the audio file with the primary key.
	*
	* @param audioId the primary key of the audio file
	* @return the audio file
	* @throws PortalException if a audio file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AudioFile getAudioFile(
		long audioId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAudioFile(audioId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> getAudioFiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAudioFiles(start, end);
	}

	/**
	* Returns the number of audio files.
	*
	* @return the number of audio files
	* @throws SystemException if a system exception occurred
	*/
	public static int getAudioFilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAudioFilesCount();
	}

	/**
	* Updates the audio file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param audioFile the audio file
	* @return the audio file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AudioFile updateAudioFile(
		com.bkav.portal.portlet.audioplayer.model.AudioFile audioFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAudioFile(audioFile);
	}

	/**
	* Updates the audio file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param audioFile the audio file
	* @param merge whether to merge the audio file with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the audio file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AudioFile updateAudioFile(
		com.bkav.portal.portlet.audioplayer.model.AudioFile audioFile,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAudioFile(audioFile, merge);
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

	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findAll()
		throws java.lang.Exception {
		return getService().findAll();
	}

	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findByAudioName(
		long groupId, java.lang.String key, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService().findByAudioName(groupId, key, start, end, obc);
	}

	public static com.bkav.portal.portlet.audioplayer.model.AudioFile getAudioFileCounter(
		long AudioFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAudioFileCounter(AudioFileId);
	}

	public static com.bkav.portal.portlet.audioplayer.model.AudioFile addAudioFile(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String audioName, java.lang.String audioInfo,
		long audioFileId, long viewCounter, java.lang.String audioType,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addAudioFile(companyId, groupId, userId, userName,
			audioName, audioInfo, audioFileId, viewCounter, audioType,
			serviceContext);
	}

	public static com.bkav.portal.portlet.audioplayer.model.AudioFile updateAudioFile(
		java.lang.String audioName, java.lang.String audioInfo,
		long audioFileId, long viewCounter, long audioId,
		java.lang.String audioType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateAudioFile(audioName, audioInfo, audioFileId,
			viewCounter, audioId, audioType);
	}

	public static void clearService() {
		_service = null;
	}

	public static AudioFileLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AudioFileLocalService.class.getName());

			if (invokableLocalService instanceof AudioFileLocalService) {
				_service = (AudioFileLocalService)invokableLocalService;
			}
			else {
				_service = new AudioFileLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AudioFileLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(AudioFileLocalService service) {
	}

	private static AudioFileLocalService _service;
}