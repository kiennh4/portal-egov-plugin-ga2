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

package com.portal_egov.portlet.landprice.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LandPriceLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       LandPriceLocalService
 * @generated
 */
public class LandPriceLocalServiceWrapper implements LandPriceLocalService,
	ServiceWrapper<LandPriceLocalService> {
	public LandPriceLocalServiceWrapper(
		LandPriceLocalService landPriceLocalService) {
		_landPriceLocalService = landPriceLocalService;
	}

	/**
	* Adds the land price to the database. Also notifies the appropriate model listeners.
	*
	* @param landPrice the land price
	* @return the land price that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice addLandPrice(
		com.portal_egov.portlet.landprice.model.LandPrice landPrice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.addLandPrice(landPrice);
	}

	/**
	* Creates a new land price with the primary key. Does not add the land price to the database.
	*
	* @param priceId the primary key for the new land price
	* @return the new land price
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice createLandPrice(
		long priceId) {
		return _landPriceLocalService.createLandPrice(priceId);
	}

	/**
	* Deletes the land price with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param priceId the primary key of the land price
	* @return the land price that was removed
	* @throws PortalException if a land price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice deleteLandPrice(
		long priceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException {
		return _landPriceLocalService.deleteLandPrice(priceId);
	}

	/**
	* Deletes the land price from the database. Also notifies the appropriate model listeners.
	*
	* @param landPrice the land price
	* @return the land price that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice deleteLandPrice(
		com.portal_egov.portlet.landprice.model.LandPrice landPrice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.deleteLandPrice(landPrice);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _landPriceLocalService.dynamicQuery();
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
		return _landPriceLocalService.dynamicQuery(dynamicQuery);
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
		return _landPriceLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _landPriceLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _landPriceLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.landprice.model.LandPrice fetchLandPrice(
		long priceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.fetchLandPrice(priceId);
	}

	/**
	* Returns the land price with the primary key.
	*
	* @param priceId the primary key of the land price
	* @return the land price
	* @throws PortalException if a land price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice getLandPrice(
		long priceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.getLandPrice(priceId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the land prices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of land prices
	* @param end the upper bound of the range of land prices (not inclusive)
	* @return the range of land prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> getLandPrices(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.getLandPrices(start, end);
	}

	/**
	* Returns the number of land prices.
	*
	* @return the number of land prices
	* @throws SystemException if a system exception occurred
	*/
	public int getLandPricesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.getLandPricesCount();
	}

	/**
	* Updates the land price in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param landPrice the land price
	* @return the land price that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice updateLandPrice(
		com.portal_egov.portlet.landprice.model.LandPrice landPrice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.updateLandPrice(landPrice);
	}

	/**
	* Updates the land price in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param landPrice the land price
	* @param merge whether to merge the land price with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the land price that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice updateLandPrice(
		com.portal_egov.portlet.landprice.model.LandPrice landPrice,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.updateLandPrice(landPrice, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _landPriceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_landPriceLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _landPriceLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByLocation(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.findByLocation(locationId);
	}

	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByStatisticYear(
		int statisticYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.findByStatisticYear(statisticYear);
	}

	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByKeyword(
		long groupId, long locationId, java.lang.String keyword,
		int statisticYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.findByKeyword(groupId, locationId,
			keyword, statisticYear, start, end, obc);
	}

	public com.portal_egov.portlet.landprice.model.LandPrice addLandPrice(
		long companyId, long groupId, long userId, java.lang.String userName,
		long locationId, java.lang.String title, java.lang.String content,
		int statisticYear,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.addLandPrice(companyId, groupId, userId,
			userName, locationId, title, content, statisticYear, serviceContext);
	}

	public com.portal_egov.portlet.landprice.model.LandPrice updateLandPrice(
		long priceId, long companyId, long groupId, long userId,
		java.lang.String userName, long locationId, java.lang.String title,
		java.lang.String content, int statisticYear,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _landPriceLocalService.updateLandPrice(priceId, companyId,
			groupId, userId, userName, locationId, title, content,
			statisticYear, serviceContext);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LandPriceLocalService getWrappedLandPriceLocalService() {
		return _landPriceLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLandPriceLocalService(
		LandPriceLocalService landPriceLocalService) {
		_landPriceLocalService = landPriceLocalService;
	}

	public LandPriceLocalService getWrappedService() {
		return _landPriceLocalService;
	}

	public void setWrappedService(LandPriceLocalService landPriceLocalService) {
		_landPriceLocalService = landPriceLocalService;
	}

	private LandPriceLocalService _landPriceLocalService;
}