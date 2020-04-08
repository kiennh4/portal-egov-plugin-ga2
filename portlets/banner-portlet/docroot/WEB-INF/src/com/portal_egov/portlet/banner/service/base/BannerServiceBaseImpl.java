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

package com.portal_egov.portlet.banner.service.base;

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

import com.portal_egov.portlet.banner.model.Banner;
import com.portal_egov.portlet.banner.service.BannerGroupLocalService;
import com.portal_egov.portlet.banner.service.BannerGroupService;
import com.portal_egov.portlet.banner.service.BannerLocalService;
import com.portal_egov.portlet.banner.service.BannerService;
import com.portal_egov.portlet.banner.service.persistence.BannerFinder;
import com.portal_egov.portlet.banner.service.persistence.BannerGroupPersistence;
import com.portal_egov.portlet.banner.service.persistence.BannerPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the banner remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.banner.service.impl.BannerServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.banner.service.impl.BannerServiceImpl
 * @see com.portal_egov.portlet.banner.service.BannerServiceUtil
 * @generated
 */
public abstract class BannerServiceBaseImpl extends BaseServiceImpl
	implements BannerService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.banner.service.BannerServiceUtil} to access the banner remote service.
	 */

	/**
	 * Returns the banner local service.
	 *
	 * @return the banner local service
	 */
	public BannerLocalService getBannerLocalService() {
		return bannerLocalService;
	}

	/**
	 * Sets the banner local service.
	 *
	 * @param bannerLocalService the banner local service
	 */
	public void setBannerLocalService(BannerLocalService bannerLocalService) {
		this.bannerLocalService = bannerLocalService;
	}

	/**
	 * Returns the banner remote service.
	 *
	 * @return the banner remote service
	 */
	public BannerService getBannerService() {
		return bannerService;
	}

	/**
	 * Sets the banner remote service.
	 *
	 * @param bannerService the banner remote service
	 */
	public void setBannerService(BannerService bannerService) {
		this.bannerService = bannerService;
	}

	/**
	 * Returns the banner persistence.
	 *
	 * @return the banner persistence
	 */
	public BannerPersistence getBannerPersistence() {
		return bannerPersistence;
	}

	/**
	 * Sets the banner persistence.
	 *
	 * @param bannerPersistence the banner persistence
	 */
	public void setBannerPersistence(BannerPersistence bannerPersistence) {
		this.bannerPersistence = bannerPersistence;
	}

	/**
	 * Returns the banner finder.
	 *
	 * @return the banner finder
	 */
	public BannerFinder getBannerFinder() {
		return bannerFinder;
	}

	/**
	 * Sets the banner finder.
	 *
	 * @param bannerFinder the banner finder
	 */
	public void setBannerFinder(BannerFinder bannerFinder) {
		this.bannerFinder = bannerFinder;
	}

	/**
	 * Returns the banner group local service.
	 *
	 * @return the banner group local service
	 */
	public BannerGroupLocalService getBannerGroupLocalService() {
		return bannerGroupLocalService;
	}

	/**
	 * Sets the banner group local service.
	 *
	 * @param bannerGroupLocalService the banner group local service
	 */
	public void setBannerGroupLocalService(
		BannerGroupLocalService bannerGroupLocalService) {
		this.bannerGroupLocalService = bannerGroupLocalService;
	}

	/**
	 * Returns the banner group remote service.
	 *
	 * @return the banner group remote service
	 */
	public BannerGroupService getBannerGroupService() {
		return bannerGroupService;
	}

	/**
	 * Sets the banner group remote service.
	 *
	 * @param bannerGroupService the banner group remote service
	 */
	public void setBannerGroupService(BannerGroupService bannerGroupService) {
		this.bannerGroupService = bannerGroupService;
	}

	/**
	 * Returns the banner group persistence.
	 *
	 * @return the banner group persistence
	 */
	public BannerGroupPersistence getBannerGroupPersistence() {
		return bannerGroupPersistence;
	}

	/**
	 * Sets the banner group persistence.
	 *
	 * @param bannerGroupPersistence the banner group persistence
	 */
	public void setBannerGroupPersistence(
		BannerGroupPersistence bannerGroupPersistence) {
		this.bannerGroupPersistence = bannerGroupPersistence;
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
		return Banner.class;
	}

	protected String getModelClassName() {
		return Banner.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = bannerPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = BannerLocalService.class)
	protected BannerLocalService bannerLocalService;
	@BeanReference(type = BannerService.class)
	protected BannerService bannerService;
	@BeanReference(type = BannerPersistence.class)
	protected BannerPersistence bannerPersistence;
	@BeanReference(type = BannerFinder.class)
	protected BannerFinder bannerFinder;
	@BeanReference(type = BannerGroupLocalService.class)
	protected BannerGroupLocalService bannerGroupLocalService;
	@BeanReference(type = BannerGroupService.class)
	protected BannerGroupService bannerGroupService;
	@BeanReference(type = BannerGroupPersistence.class)
	protected BannerGroupPersistence bannerGroupPersistence;
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
	private BannerServiceClpInvoker _clpInvoker = new BannerServiceClpInvoker();
}