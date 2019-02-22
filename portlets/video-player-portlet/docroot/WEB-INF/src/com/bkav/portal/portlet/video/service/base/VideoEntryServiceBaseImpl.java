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

package com.bkav.portal.portlet.video.service.base;

import com.bkav.portal.portlet.video.model.VideoEntry;
import com.bkav.portal.portlet.video.service.VideoCategoryLocalService;
import com.bkav.portal.portlet.video.service.VideoCategoryMapLocalService;
import com.bkav.portal.portlet.video.service.VideoCategoryMapService;
import com.bkav.portal.portlet.video.service.VideoCategoryService;
import com.bkav.portal.portlet.video.service.VideoEntryLocalService;
import com.bkav.portal.portlet.video.service.VideoEntryService;
import com.bkav.portal.portlet.video.service.persistence.VideoCategoryMapPersistence;
import com.bkav.portal.portlet.video.service.persistence.VideoCategoryPersistence;
import com.bkav.portal.portlet.video.service.persistence.VideoEntryFinder;
import com.bkav.portal.portlet.video.service.persistence.VideoEntryPersistence;

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

import javax.sql.DataSource;

/**
 * The base implementation of the video entry remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.bkav.portal.portlet.video.service.impl.VideoEntryServiceImpl}.
 * </p>
 *
 * @author hungdx
 * @see com.bkav.portal.portlet.video.service.impl.VideoEntryServiceImpl
 * @see com.bkav.portal.portlet.video.service.VideoEntryServiceUtil
 * @generated
 */
public abstract class VideoEntryServiceBaseImpl extends BaseServiceImpl
	implements VideoEntryService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.bkav.portal.portlet.video.service.VideoEntryServiceUtil} to access the video entry remote service.
	 */

	/**
	 * Returns the video category local service.
	 *
	 * @return the video category local service
	 */
	public VideoCategoryLocalService getVideoCategoryLocalService() {
		return videoCategoryLocalService;
	}

	/**
	 * Sets the video category local service.
	 *
	 * @param videoCategoryLocalService the video category local service
	 */
	public void setVideoCategoryLocalService(
		VideoCategoryLocalService videoCategoryLocalService) {
		this.videoCategoryLocalService = videoCategoryLocalService;
	}

	/**
	 * Returns the video category remote service.
	 *
	 * @return the video category remote service
	 */
	public VideoCategoryService getVideoCategoryService() {
		return videoCategoryService;
	}

	/**
	 * Sets the video category remote service.
	 *
	 * @param videoCategoryService the video category remote service
	 */
	public void setVideoCategoryService(
		VideoCategoryService videoCategoryService) {
		this.videoCategoryService = videoCategoryService;
	}

	/**
	 * Returns the video category persistence.
	 *
	 * @return the video category persistence
	 */
	public VideoCategoryPersistence getVideoCategoryPersistence() {
		return videoCategoryPersistence;
	}

	/**
	 * Sets the video category persistence.
	 *
	 * @param videoCategoryPersistence the video category persistence
	 */
	public void setVideoCategoryPersistence(
		VideoCategoryPersistence videoCategoryPersistence) {
		this.videoCategoryPersistence = videoCategoryPersistence;
	}

	/**
	 * Returns the video category map local service.
	 *
	 * @return the video category map local service
	 */
	public VideoCategoryMapLocalService getVideoCategoryMapLocalService() {
		return videoCategoryMapLocalService;
	}

	/**
	 * Sets the video category map local service.
	 *
	 * @param videoCategoryMapLocalService the video category map local service
	 */
	public void setVideoCategoryMapLocalService(
		VideoCategoryMapLocalService videoCategoryMapLocalService) {
		this.videoCategoryMapLocalService = videoCategoryMapLocalService;
	}

	/**
	 * Returns the video category map remote service.
	 *
	 * @return the video category map remote service
	 */
	public VideoCategoryMapService getVideoCategoryMapService() {
		return videoCategoryMapService;
	}

	/**
	 * Sets the video category map remote service.
	 *
	 * @param videoCategoryMapService the video category map remote service
	 */
	public void setVideoCategoryMapService(
		VideoCategoryMapService videoCategoryMapService) {
		this.videoCategoryMapService = videoCategoryMapService;
	}

	/**
	 * Returns the video category map persistence.
	 *
	 * @return the video category map persistence
	 */
	public VideoCategoryMapPersistence getVideoCategoryMapPersistence() {
		return videoCategoryMapPersistence;
	}

	/**
	 * Sets the video category map persistence.
	 *
	 * @param videoCategoryMapPersistence the video category map persistence
	 */
	public void setVideoCategoryMapPersistence(
		VideoCategoryMapPersistence videoCategoryMapPersistence) {
		this.videoCategoryMapPersistence = videoCategoryMapPersistence;
	}

	/**
	 * Returns the video entry local service.
	 *
	 * @return the video entry local service
	 */
	public VideoEntryLocalService getVideoEntryLocalService() {
		return videoEntryLocalService;
	}

	/**
	 * Sets the video entry local service.
	 *
	 * @param videoEntryLocalService the video entry local service
	 */
	public void setVideoEntryLocalService(
		VideoEntryLocalService videoEntryLocalService) {
		this.videoEntryLocalService = videoEntryLocalService;
	}

	/**
	 * Returns the video entry remote service.
	 *
	 * @return the video entry remote service
	 */
	public VideoEntryService getVideoEntryService() {
		return videoEntryService;
	}

	/**
	 * Sets the video entry remote service.
	 *
	 * @param videoEntryService the video entry remote service
	 */
	public void setVideoEntryService(VideoEntryService videoEntryService) {
		this.videoEntryService = videoEntryService;
	}

	/**
	 * Returns the video entry persistence.
	 *
	 * @return the video entry persistence
	 */
	public VideoEntryPersistence getVideoEntryPersistence() {
		return videoEntryPersistence;
	}

	/**
	 * Sets the video entry persistence.
	 *
	 * @param videoEntryPersistence the video entry persistence
	 */
	public void setVideoEntryPersistence(
		VideoEntryPersistence videoEntryPersistence) {
		this.videoEntryPersistence = videoEntryPersistence;
	}

	/**
	 * Returns the video entry finder.
	 *
	 * @return the video entry finder
	 */
	public VideoEntryFinder getVideoEntryFinder() {
		return videoEntryFinder;
	}

	/**
	 * Sets the video entry finder.
	 *
	 * @param videoEntryFinder the video entry finder
	 */
	public void setVideoEntryFinder(VideoEntryFinder videoEntryFinder) {
		this.videoEntryFinder = videoEntryFinder;
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
		return VideoEntry.class;
	}

	protected String getModelClassName() {
		return VideoEntry.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = videoEntryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = VideoCategoryLocalService.class)
	protected VideoCategoryLocalService videoCategoryLocalService;
	@BeanReference(type = VideoCategoryService.class)
	protected VideoCategoryService videoCategoryService;
	@BeanReference(type = VideoCategoryPersistence.class)
	protected VideoCategoryPersistence videoCategoryPersistence;
	@BeanReference(type = VideoCategoryMapLocalService.class)
	protected VideoCategoryMapLocalService videoCategoryMapLocalService;
	@BeanReference(type = VideoCategoryMapService.class)
	protected VideoCategoryMapService videoCategoryMapService;
	@BeanReference(type = VideoCategoryMapPersistence.class)
	protected VideoCategoryMapPersistence videoCategoryMapPersistence;
	@BeanReference(type = VideoEntryLocalService.class)
	protected VideoEntryLocalService videoEntryLocalService;
	@BeanReference(type = VideoEntryService.class)
	protected VideoEntryService videoEntryService;
	@BeanReference(type = VideoEntryPersistence.class)
	protected VideoEntryPersistence videoEntryPersistence;
	@BeanReference(type = VideoEntryFinder.class)
	protected VideoEntryFinder videoEntryFinder;
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
	private VideoEntryServiceClpInvoker _clpInvoker = new VideoEntryServiceClpInvoker();
}