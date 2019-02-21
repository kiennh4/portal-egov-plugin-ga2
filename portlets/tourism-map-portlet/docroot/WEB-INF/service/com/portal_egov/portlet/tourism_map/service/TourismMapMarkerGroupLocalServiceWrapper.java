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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TourismMapMarkerGroupLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       TourismMapMarkerGroupLocalService
 * @generated
 */
public class TourismMapMarkerGroupLocalServiceWrapper
	implements TourismMapMarkerGroupLocalService,
		ServiceWrapper<TourismMapMarkerGroupLocalService> {
	public TourismMapMarkerGroupLocalServiceWrapper(
		TourismMapMarkerGroupLocalService tourismMapMarkerGroupLocalService) {
		_tourismMapMarkerGroupLocalService = tourismMapMarkerGroupLocalService;
	}

	/**
	* Adds the tourism map marker group to the database. Also notifies the appropriate model listeners.
	*
	* @param tourismMapMarkerGroup the tourism map marker group
	* @return the tourism map marker group that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup addTourismMapMarkerGroup(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup tourismMapMarkerGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.addTourismMapMarkerGroup(tourismMapMarkerGroup);
	}

	/**
	* Creates a new tourism map marker group with the primary key. Does not add the tourism map marker group to the database.
	*
	* @param markerGroupId the primary key for the new tourism map marker group
	* @return the new tourism map marker group
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup createTourismMapMarkerGroup(
		long markerGroupId) {
		return _tourismMapMarkerGroupLocalService.createTourismMapMarkerGroup(markerGroupId);
	}

	/**
	* Deletes the tourism map marker group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerGroupId the primary key of the tourism map marker group
	* @return the tourism map marker group that was removed
	* @throws PortalException if a tourism map marker group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup deleteTourismMapMarkerGroup(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.deleteTourismMapMarkerGroup(markerGroupId);
	}

	/**
	* Deletes the tourism map marker group from the database. Also notifies the appropriate model listeners.
	*
	* @param tourismMapMarkerGroup the tourism map marker group
	* @return the tourism map marker group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup deleteTourismMapMarkerGroup(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup tourismMapMarkerGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.deleteTourismMapMarkerGroup(tourismMapMarkerGroup);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tourismMapMarkerGroupLocalService.dynamicQuery();
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
		return _tourismMapMarkerGroupLocalService.dynamicQuery(dynamicQuery);
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
		return _tourismMapMarkerGroupLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
		return _tourismMapMarkerGroupLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _tourismMapMarkerGroupLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup fetchTourismMapMarkerGroup(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.fetchTourismMapMarkerGroup(markerGroupId);
	}

	/**
	* Returns the tourism map marker group with the primary key.
	*
	* @param markerGroupId the primary key of the tourism map marker group
	* @return the tourism map marker group
	* @throws PortalException if a tourism map marker group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup getTourismMapMarkerGroup(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.getTourismMapMarkerGroup(markerGroupId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> getTourismMapMarkerGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.getTourismMapMarkerGroups(start,
			end);
	}

	/**
	* Returns the number of tourism map marker groups.
	*
	* @return the number of tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public int getTourismMapMarkerGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.getTourismMapMarkerGroupsCount();
	}

	/**
	* Updates the tourism map marker group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tourismMapMarkerGroup the tourism map marker group
	* @return the tourism map marker group that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup updateTourismMapMarkerGroup(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup tourismMapMarkerGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.updateTourismMapMarkerGroup(tourismMapMarkerGroup);
	}

	/**
	* Updates the tourism map marker group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tourismMapMarkerGroup the tourism map marker group
	* @param merge whether to merge the tourism map marker group with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the tourism map marker group that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup updateTourismMapMarkerGroup(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup tourismMapMarkerGroup,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.updateTourismMapMarkerGroup(tourismMapMarkerGroup,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tourismMapMarkerGroupLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tourismMapMarkerGroupLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tourismMapMarkerGroupLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.findByGroup(groupId);
	}

	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup getMarkerGroup(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.getMarkerGroup(markerGroupId);
	}

	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup addMarkerGroup(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String markerGroupName, java.lang.String markerGroupInfo,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.addMarkerGroup(companyId,
			groupId, userId, userName, markerGroupName, markerGroupInfo,
			serviceContext);
	}

	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup updateMarkerGroup(
		long markerGroupId, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String markerGroupName,
		java.lang.String markerGroupInfo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroupLocalService.updateMarkerGroup(markerGroupId,
			companyId, groupId, userId, userName, markerGroupName,
			markerGroupInfo);
	}

	public void deleteMarkerGroup(long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException {
		_tourismMapMarkerGroupLocalService.deleteMarkerGroup(markerGroupId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TourismMapMarkerGroupLocalService getWrappedTourismMapMarkerGroupLocalService() {
		return _tourismMapMarkerGroupLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTourismMapMarkerGroupLocalService(
		TourismMapMarkerGroupLocalService tourismMapMarkerGroupLocalService) {
		_tourismMapMarkerGroupLocalService = tourismMapMarkerGroupLocalService;
	}

	public TourismMapMarkerGroupLocalService getWrappedService() {
		return _tourismMapMarkerGroupLocalService;
	}

	public void setWrappedService(
		TourismMapMarkerGroupLocalService tourismMapMarkerGroupLocalService) {
		_tourismMapMarkerGroupLocalService = tourismMapMarkerGroupLocalService;
	}

	private TourismMapMarkerGroupLocalService _tourismMapMarkerGroupLocalService;
}