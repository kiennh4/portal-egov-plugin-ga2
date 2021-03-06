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

package com.portal_egov.portlet.tourism_map.service.base;

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

import com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup;
import com.portal_egov.portlet.tourism_map.service.TourismMapMarkerGroupLocalService;
import com.portal_egov.portlet.tourism_map.service.TourismMapMarkerGroupService;
import com.portal_egov.portlet.tourism_map.service.TourismMapMarkerLocalService;
import com.portal_egov.portlet.tourism_map.service.TourismMapMarkerService;
import com.portal_egov.portlet.tourism_map.service.persistence.TourismMapMarkerGroupPersistence;
import com.portal_egov.portlet.tourism_map.service.persistence.TourismMapMarkerPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the tourism map marker group remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.tourism_map.service.impl.TourismMapMarkerGroupServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.tourism_map.service.impl.TourismMapMarkerGroupServiceImpl
 * @see com.portal_egov.portlet.tourism_map.service.TourismMapMarkerGroupServiceUtil
 * @generated
 */
public abstract class TourismMapMarkerGroupServiceBaseImpl
	extends BaseServiceImpl implements TourismMapMarkerGroupService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.tourism_map.service.TourismMapMarkerGroupServiceUtil} to access the tourism map marker group remote service.
	 */

	/**
	 * Returns the tourism map marker local service.
	 *
	 * @return the tourism map marker local service
	 */
	public TourismMapMarkerLocalService getTourismMapMarkerLocalService() {
		return tourismMapMarkerLocalService;
	}

	/**
	 * Sets the tourism map marker local service.
	 *
	 * @param tourismMapMarkerLocalService the tourism map marker local service
	 */
	public void setTourismMapMarkerLocalService(
		TourismMapMarkerLocalService tourismMapMarkerLocalService) {
		this.tourismMapMarkerLocalService = tourismMapMarkerLocalService;
	}

	/**
	 * Returns the tourism map marker remote service.
	 *
	 * @return the tourism map marker remote service
	 */
	public TourismMapMarkerService getTourismMapMarkerService() {
		return tourismMapMarkerService;
	}

	/**
	 * Sets the tourism map marker remote service.
	 *
	 * @param tourismMapMarkerService the tourism map marker remote service
	 */
	public void setTourismMapMarkerService(
		TourismMapMarkerService tourismMapMarkerService) {
		this.tourismMapMarkerService = tourismMapMarkerService;
	}

	/**
	 * Returns the tourism map marker persistence.
	 *
	 * @return the tourism map marker persistence
	 */
	public TourismMapMarkerPersistence getTourismMapMarkerPersistence() {
		return tourismMapMarkerPersistence;
	}

	/**
	 * Sets the tourism map marker persistence.
	 *
	 * @param tourismMapMarkerPersistence the tourism map marker persistence
	 */
	public void setTourismMapMarkerPersistence(
		TourismMapMarkerPersistence tourismMapMarkerPersistence) {
		this.tourismMapMarkerPersistence = tourismMapMarkerPersistence;
	}

	/**
	 * Returns the tourism map marker group local service.
	 *
	 * @return the tourism map marker group local service
	 */
	public TourismMapMarkerGroupLocalService getTourismMapMarkerGroupLocalService() {
		return tourismMapMarkerGroupLocalService;
	}

	/**
	 * Sets the tourism map marker group local service.
	 *
	 * @param tourismMapMarkerGroupLocalService the tourism map marker group local service
	 */
	public void setTourismMapMarkerGroupLocalService(
		TourismMapMarkerGroupLocalService tourismMapMarkerGroupLocalService) {
		this.tourismMapMarkerGroupLocalService = tourismMapMarkerGroupLocalService;
	}

	/**
	 * Returns the tourism map marker group remote service.
	 *
	 * @return the tourism map marker group remote service
	 */
	public TourismMapMarkerGroupService getTourismMapMarkerGroupService() {
		return tourismMapMarkerGroupService;
	}

	/**
	 * Sets the tourism map marker group remote service.
	 *
	 * @param tourismMapMarkerGroupService the tourism map marker group remote service
	 */
	public void setTourismMapMarkerGroupService(
		TourismMapMarkerGroupService tourismMapMarkerGroupService) {
		this.tourismMapMarkerGroupService = tourismMapMarkerGroupService;
	}

	/**
	 * Returns the tourism map marker group persistence.
	 *
	 * @return the tourism map marker group persistence
	 */
	public TourismMapMarkerGroupPersistence getTourismMapMarkerGroupPersistence() {
		return tourismMapMarkerGroupPersistence;
	}

	/**
	 * Sets the tourism map marker group persistence.
	 *
	 * @param tourismMapMarkerGroupPersistence the tourism map marker group persistence
	 */
	public void setTourismMapMarkerGroupPersistence(
		TourismMapMarkerGroupPersistence tourismMapMarkerGroupPersistence) {
		this.tourismMapMarkerGroupPersistence = tourismMapMarkerGroupPersistence;
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
		return TourismMapMarkerGroup.class;
	}

	protected String getModelClassName() {
		return TourismMapMarkerGroup.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = tourismMapMarkerGroupPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = TourismMapMarkerLocalService.class)
	protected TourismMapMarkerLocalService tourismMapMarkerLocalService;
	@BeanReference(type = TourismMapMarkerService.class)
	protected TourismMapMarkerService tourismMapMarkerService;
	@BeanReference(type = TourismMapMarkerPersistence.class)
	protected TourismMapMarkerPersistence tourismMapMarkerPersistence;
	@BeanReference(type = TourismMapMarkerGroupLocalService.class)
	protected TourismMapMarkerGroupLocalService tourismMapMarkerGroupLocalService;
	@BeanReference(type = TourismMapMarkerGroupService.class)
	protected TourismMapMarkerGroupService tourismMapMarkerGroupService;
	@BeanReference(type = TourismMapMarkerGroupPersistence.class)
	protected TourismMapMarkerGroupPersistence tourismMapMarkerGroupPersistence;
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
	private TourismMapMarkerGroupServiceClpInvoker _clpInvoker = new TourismMapMarkerGroupServiceClpInvoker();
}