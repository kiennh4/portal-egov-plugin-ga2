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

package com.portal_egov.portlet.tourism_map.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the tourism map marker group local service. This utility wraps {@link com.portal_egov.portlet.tourism_map.service.impl.TourismMapMarkerGroupLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see TourismMapMarkerGroupLocalService
 * @see com.portal_egov.portlet.tourism_map.service.base.TourismMapMarkerGroupLocalServiceBaseImpl
 * @see com.portal_egov.portlet.tourism_map.service.impl.TourismMapMarkerGroupLocalServiceImpl
 * @generated
 */
public class TourismMapMarkerGroupLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.tourism_map.service.impl.TourismMapMarkerGroupLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tourism map marker group to the database. Also notifies the appropriate model listeners.
	*
	* @param tourismMapMarkerGroup the tourism map marker group
	* @return the tourism map marker group that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup addTourismMapMarkerGroup(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup tourismMapMarkerGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTourismMapMarkerGroup(tourismMapMarkerGroup);
	}

	/**
	* Creates a new tourism map marker group with the primary key. Does not add the tourism map marker group to the database.
	*
	* @param markerGroupId the primary key for the new tourism map marker group
	* @return the new tourism map marker group
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup createTourismMapMarkerGroup(
		long markerGroupId) {
		return getService().createTourismMapMarkerGroup(markerGroupId);
	}

	/**
	* Deletes the tourism map marker group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerGroupId the primary key of the tourism map marker group
	* @return the tourism map marker group that was removed
	* @throws PortalException if a tourism map marker group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup deleteTourismMapMarkerGroup(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTourismMapMarkerGroup(markerGroupId);
	}

	/**
	* Deletes the tourism map marker group from the database. Also notifies the appropriate model listeners.
	*
	* @param tourismMapMarkerGroup the tourism map marker group
	* @return the tourism map marker group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup deleteTourismMapMarkerGroup(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup tourismMapMarkerGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTourismMapMarkerGroup(tourismMapMarkerGroup);
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

	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup fetchTourismMapMarkerGroup(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTourismMapMarkerGroup(markerGroupId);
	}

	/**
	* Returns the tourism map marker group with the primary key.
	*
	* @param markerGroupId the primary key of the tourism map marker group
	* @return the tourism map marker group
	* @throws PortalException if a tourism map marker group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup getTourismMapMarkerGroup(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTourismMapMarkerGroup(markerGroupId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tourism map marker groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tourism map marker groups
	* @param end the upper bound of the range of tourism map marker groups (not inclusive)
	* @return the range of tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> getTourismMapMarkerGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTourismMapMarkerGroups(start, end);
	}

	/**
	* Returns the number of tourism map marker groups.
	*
	* @return the number of tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public static int getTourismMapMarkerGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTourismMapMarkerGroupsCount();
	}

	/**
	* Updates the tourism map marker group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tourismMapMarkerGroup the tourism map marker group
	* @return the tourism map marker group that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup updateTourismMapMarkerGroup(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup tourismMapMarkerGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTourismMapMarkerGroup(tourismMapMarkerGroup);
	}

	/**
	* Updates the tourism map marker group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tourismMapMarkerGroup the tourism map marker group
	* @param merge whether to merge the tourism map marker group with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the tourism map marker group that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup updateTourismMapMarkerGroup(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup tourismMapMarkerGroup,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTourismMapMarkerGroup(tourismMapMarkerGroup, merge);
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

	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup getMarkerGroup(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMarkerGroup(markerGroupId);
	}

	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup addMarkerGroup(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String markerGroupName, java.lang.String markerGroupInfo,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addMarkerGroup(companyId, groupId, userId, userName,
			markerGroupName, markerGroupInfo, serviceContext);
	}

	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup updateMarkerGroup(
		long markerGroupId, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String markerGroupName,
		java.lang.String markerGroupInfo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateMarkerGroup(markerGroupId, companyId, groupId,
			userId, userName, markerGroupName, markerGroupInfo);
	}

	public static void deleteMarkerGroup(long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException {
		getService().deleteMarkerGroup(markerGroupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static TourismMapMarkerGroupLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TourismMapMarkerGroupLocalService.class.getName());

			if (invokableLocalService instanceof TourismMapMarkerGroupLocalService) {
				_service = (TourismMapMarkerGroupLocalService)invokableLocalService;
			}
			else {
				_service = new TourismMapMarkerGroupLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TourismMapMarkerGroupLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(TourismMapMarkerGroupLocalService service) {
	}

	private static TourismMapMarkerGroupLocalService _service;
}