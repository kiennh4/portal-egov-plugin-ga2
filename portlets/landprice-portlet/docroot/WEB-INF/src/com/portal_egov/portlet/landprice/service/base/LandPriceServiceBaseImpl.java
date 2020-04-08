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

package com.portal_egov.portlet.landprice.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.portal_egov.portlet.landprice.model.LandPrice;
import com.portal_egov.portlet.landprice.service.LandLocationLocalService;
import com.portal_egov.portlet.landprice.service.LandLocationService;
import com.portal_egov.portlet.landprice.service.LandPriceLocalService;
import com.portal_egov.portlet.landprice.service.LandPriceService;
import com.portal_egov.portlet.landprice.service.persistence.LandLocationFinder;
import com.portal_egov.portlet.landprice.service.persistence.LandLocationPersistence;
import com.portal_egov.portlet.landprice.service.persistence.LandPriceFinder;
import com.portal_egov.portlet.landprice.service.persistence.LandPricePersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the land price remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.landprice.service.impl.LandPriceServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.landprice.service.impl.LandPriceServiceImpl
 * @see com.portal_egov.portlet.landprice.service.LandPriceServiceUtil
 * @generated
 */
public abstract class LandPriceServiceBaseImpl extends BaseServiceImpl
	implements LandPriceService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.landprice.service.LandPriceServiceUtil} to access the land price remote service.
	 */

	/**
	 * Returns the land location local service.
	 *
	 * @return the land location local service
	 */
	public LandLocationLocalService getLandLocationLocalService() {
		return landLocationLocalService;
	}

	/**
	 * Sets the land location local service.
	 *
	 * @param landLocationLocalService the land location local service
	 */
	public void setLandLocationLocalService(
		LandLocationLocalService landLocationLocalService) {
		this.landLocationLocalService = landLocationLocalService;
	}

	/**
	 * Returns the land location remote service.
	 *
	 * @return the land location remote service
	 */
	public LandLocationService getLandLocationService() {
		return landLocationService;
	}

	/**
	 * Sets the land location remote service.
	 *
	 * @param landLocationService the land location remote service
	 */
	public void setLandLocationService(LandLocationService landLocationService) {
		this.landLocationService = landLocationService;
	}

	/**
	 * Returns the land location persistence.
	 *
	 * @return the land location persistence
	 */
	public LandLocationPersistence getLandLocationPersistence() {
		return landLocationPersistence;
	}

	/**
	 * Sets the land location persistence.
	 *
	 * @param landLocationPersistence the land location persistence
	 */
	public void setLandLocationPersistence(
		LandLocationPersistence landLocationPersistence) {
		this.landLocationPersistence = landLocationPersistence;
	}

	/**
	 * Returns the land location finder.
	 *
	 * @return the land location finder
	 */
	public LandLocationFinder getLandLocationFinder() {
		return landLocationFinder;
	}

	/**
	 * Sets the land location finder.
	 *
	 * @param landLocationFinder the land location finder
	 */
	public void setLandLocationFinder(LandLocationFinder landLocationFinder) {
		this.landLocationFinder = landLocationFinder;
	}

	/**
	 * Returns the land price local service.
	 *
	 * @return the land price local service
	 */
	public LandPriceLocalService getLandPriceLocalService() {
		return landPriceLocalService;
	}

	/**
	 * Sets the land price local service.
	 *
	 * @param landPriceLocalService the land price local service
	 */
	public void setLandPriceLocalService(
		LandPriceLocalService landPriceLocalService) {
		this.landPriceLocalService = landPriceLocalService;
	}

	/**
	 * Returns the land price remote service.
	 *
	 * @return the land price remote service
	 */
	public LandPriceService getLandPriceService() {
		return landPriceService;
	}

	/**
	 * Sets the land price remote service.
	 *
	 * @param landPriceService the land price remote service
	 */
	public void setLandPriceService(LandPriceService landPriceService) {
		this.landPriceService = landPriceService;
	}

	/**
	 * Returns the land price persistence.
	 *
	 * @return the land price persistence
	 */
	public LandPricePersistence getLandPricePersistence() {
		return landPricePersistence;
	}

	/**
	 * Sets the land price persistence.
	 *
	 * @param landPricePersistence the land price persistence
	 */
	public void setLandPricePersistence(
		LandPricePersistence landPricePersistence) {
		this.landPricePersistence = landPricePersistence;
	}

	/**
	 * Returns the land price finder.
	 *
	 * @return the land price finder
	 */
	public LandPriceFinder getLandPriceFinder() {
		return landPriceFinder;
	}

	/**
	 * Sets the land price finder.
	 *
	 * @param landPriceFinder the land price finder
	 */
	public void setLandPriceFinder(LandPriceFinder landPriceFinder) {
		this.landPriceFinder = landPriceFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return LandPrice.class;
	}

	protected String getModelClassName() {
		return LandPrice.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = landPricePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = LandLocationLocalService.class)
	protected LandLocationLocalService landLocationLocalService;
	@BeanReference(type = LandLocationService.class)
	protected LandLocationService landLocationService;
	@BeanReference(type = LandLocationPersistence.class)
	protected LandLocationPersistence landLocationPersistence;
	@BeanReference(type = LandLocationFinder.class)
	protected LandLocationFinder landLocationFinder;
	@BeanReference(type = LandPriceLocalService.class)
	protected LandPriceLocalService landPriceLocalService;
	@BeanReference(type = LandPriceService.class)
	protected LandPriceService landPriceService;
	@BeanReference(type = LandPricePersistence.class)
	protected LandPricePersistence landPricePersistence;
	@BeanReference(type = LandPriceFinder.class)
	protected LandPriceFinder landPriceFinder;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private LandPriceServiceClpInvoker _clpInvoker = new LandPriceServiceClpInvoker();
}