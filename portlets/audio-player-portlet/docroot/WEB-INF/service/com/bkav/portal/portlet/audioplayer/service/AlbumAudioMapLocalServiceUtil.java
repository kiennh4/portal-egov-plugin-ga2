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
 * The utility for the album audio map local service. This utility wraps {@link com.bkav.portal.portlet.audioplayer.service.impl.AlbumAudioMapLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anhbdb
 * @see AlbumAudioMapLocalService
 * @see com.bkav.portal.portlet.audioplayer.service.base.AlbumAudioMapLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.audioplayer.service.impl.AlbumAudioMapLocalServiceImpl
 * @generated
 */
public class AlbumAudioMapLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bkav.portal.portlet.audioplayer.service.impl.AlbumAudioMapLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the album audio map to the database. Also notifies the appropriate model listeners.
	*
	* @param albumAudioMap the album audio map
	* @return the album audio map that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap addAlbumAudioMap(
		com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap albumAudioMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAlbumAudioMap(albumAudioMap);
	}

	/**
	* Creates a new album audio map with the primary key. Does not add the album audio map to the database.
	*
	* @param mapId the primary key for the new album audio map
	* @return the new album audio map
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap createAlbumAudioMap(
		long mapId) {
		return getService().createAlbumAudioMap(mapId);
	}

	/**
	* Deletes the album audio map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mapId the primary key of the album audio map
	* @return the album audio map that was removed
	* @throws PortalException if a album audio map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap deleteAlbumAudioMap(
		long mapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAlbumAudioMap(mapId);
	}

	/**
	* Deletes the album audio map from the database. Also notifies the appropriate model listeners.
	*
	* @param albumAudioMap the album audio map
	* @return the album audio map that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap deleteAlbumAudioMap(
		com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap albumAudioMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAlbumAudioMap(albumAudioMap);
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

	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap fetchAlbumAudioMap(
		long mapId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAlbumAudioMap(mapId);
	}

	/**
	* Returns the album audio map with the primary key.
	*
	* @param mapId the primary key of the album audio map
	* @return the album audio map
	* @throws PortalException if a album audio map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap getAlbumAudioMap(
		long mapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAlbumAudioMap(mapId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> getAlbumAudioMaps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAlbumAudioMaps(start, end);
	}

	/**
	* Returns the number of album audio maps.
	*
	* @return the number of album audio maps
	* @throws SystemException if a system exception occurred
	*/
	public static int getAlbumAudioMapsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAlbumAudioMapsCount();
	}

	/**
	* Updates the album audio map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param albumAudioMap the album audio map
	* @return the album audio map that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap updateAlbumAudioMap(
		com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap albumAudioMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAlbumAudioMap(albumAudioMap);
	}

	/**
	* Updates the album audio map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param albumAudioMap the album audio map
	* @param merge whether to merge the album audio map with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the album audio map that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap updateAlbumAudioMap(
		com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap albumAudioMap,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAlbumAudioMap(albumAudioMap, merge);
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

	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findAll()
		throws java.lang.Exception {
		return getService().findAll();
	}

	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAlbumId(
		long albumId) throws java.lang.Exception {
		return getService().findByAlbumId(albumId);
	}

	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap> findByAlbumAudio(
		long albumId, long audioId) throws java.lang.Exception {
		return getService().findByAlbumAudio(albumId, audioId);
	}

	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap addAlbumAudioMap(
		long audioId, long albumId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addAlbumAudioMap(audioId, albumId);
	}

	public static com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap updateAlbumAudioMap(
		long audioId, long albumId, long relId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateAlbumAudioMap(audioId, albumId, relId, serviceContext);
	}

	public static void deleteAlbumAudioMapByAlbumId(long albumId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteAlbumAudioMapByAlbumId(albumId);
	}

	public static void deleteAlbumAudioMapByAudioId(long audioId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteAlbumAudioMapByAudioId(audioId);
	}

	public static void clearService() {
		_service = null;
	}

	public static AlbumAudioMapLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AlbumAudioMapLocalService.class.getName());

			if (invokableLocalService instanceof AlbumAudioMapLocalService) {
				_service = (AlbumAudioMapLocalService)invokableLocalService;
			}
			else {
				_service = new AlbumAudioMapLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AlbumAudioMapLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(AlbumAudioMapLocalService service) {
	}

	private static AlbumAudioMapLocalService _service;
}