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

package com.bkav.portal.portlet.video.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the video category map local service. This utility wraps {@link com.bkav.portal.portlet.video.service.impl.VideoCategoryMapLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hungdx
 * @see VideoCategoryMapLocalService
 * @see com.bkav.portal.portlet.video.service.base.VideoCategoryMapLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.video.service.impl.VideoCategoryMapLocalServiceImpl
 * @generated
 */
public class VideoCategoryMapLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bkav.portal.portlet.video.service.impl.VideoCategoryMapLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the video category map to the database. Also notifies the appropriate model listeners.
	*
	* @param videoCategoryMap the video category map
	* @return the video category map that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap addVideoCategoryMap(
		com.bkav.portal.portlet.video.model.VideoCategoryMap videoCategoryMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVideoCategoryMap(videoCategoryMap);
	}

	/**
	* Creates a new video category map with the primary key. Does not add the video category map to the database.
	*
	* @param mapId the primary key for the new video category map
	* @return the new video category map
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap createVideoCategoryMap(
		long mapId) {
		return getService().createVideoCategoryMap(mapId);
	}

	/**
	* Deletes the video category map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mapId the primary key of the video category map
	* @return the video category map that was removed
	* @throws PortalException if a video category map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap deleteVideoCategoryMap(
		long mapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVideoCategoryMap(mapId);
	}

	/**
	* Deletes the video category map from the database. Also notifies the appropriate model listeners.
	*
	* @param videoCategoryMap the video category map
	* @return the video category map that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap deleteVideoCategoryMap(
		com.bkav.portal.portlet.video.model.VideoCategoryMap videoCategoryMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVideoCategoryMap(videoCategoryMap);
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

	public static com.bkav.portal.portlet.video.model.VideoCategoryMap fetchVideoCategoryMap(
		long mapId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVideoCategoryMap(mapId);
	}

	/**
	* Returns the video category map with the primary key.
	*
	* @param mapId the primary key of the video category map
	* @return the video category map
	* @throws PortalException if a video category map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap getVideoCategoryMap(
		long mapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoCategoryMap(mapId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> getVideoCategoryMaps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoCategoryMaps(start, end);
	}

	/**
	* Returns the number of video category maps.
	*
	* @return the number of video category maps
	* @throws SystemException if a system exception occurred
	*/
	public static int getVideoCategoryMapsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoCategoryMapsCount();
	}

	/**
	* Updates the video category map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoCategoryMap the video category map
	* @return the video category map that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap updateVideoCategoryMap(
		com.bkav.portal.portlet.video.model.VideoCategoryMap videoCategoryMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVideoCategoryMap(videoCategoryMap);
	}

	/**
	* Updates the video category map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoCategoryMap the video category map
	* @param merge whether to merge the video category map with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the video category map that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoCategoryMap updateVideoCategoryMap(
		com.bkav.portal.portlet.video.model.VideoCategoryMap videoCategoryMap,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVideoCategoryMap(videoCategoryMap, merge);
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

	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategory(categoryId);
	}

	public static java.util.List<com.bkav.portal.portlet.video.model.VideoCategoryMap> findByEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByEntry(entryId);
	}

	public static com.bkav.portal.portlet.video.model.VideoCategoryMap addVideoCategoryMap(
		long categoryId, long entryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addVideoCategoryMap(categoryId, entryId, serviceContext);
	}

	public static com.bkav.portal.portlet.video.model.VideoCategoryMap updateVideoCategoryMap(
		long mapId, long categoryId, long entryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateVideoCategoryMap(mapId, categoryId, entryId,
			serviceContext);
	}

	public static void deleteVideoCategoryMapByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVideoCategoryMapByCategory(categoryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VideoCategoryMapLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VideoCategoryMapLocalService.class.getName());

			if (invokableLocalService instanceof VideoCategoryMapLocalService) {
				_service = (VideoCategoryMapLocalService)invokableLocalService;
			}
			else {
				_service = new VideoCategoryMapLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VideoCategoryMapLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(VideoCategoryMapLocalService service) {
	}

	private static VideoCategoryMapLocalService _service;
}