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

package com.bkav.portal.portlet.audioplayer.service.base;

import com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap;
import com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalService;
import com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapService;
import com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalService;
import com.bkav.portal.portlet.audioplayer.service.AudioAlbumService;
import com.bkav.portal.portlet.audioplayer.service.AudioFileLocalService;
import com.bkav.portal.portlet.audioplayer.service.AudioFileService;
import com.bkav.portal.portlet.audioplayer.service.persistence.AlbumAudioMapPersistence;
import com.bkav.portal.portlet.audioplayer.service.persistence.AudioAlbumPersistence;
import com.bkav.portal.portlet.audioplayer.service.persistence.AudioFileFinder;
import com.bkav.portal.portlet.audioplayer.service.persistence.AudioFilePersistence;

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
 * The base implementation of the album audio map remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.bkav.portal.portlet.audioplayer.service.impl.AlbumAudioMapServiceImpl}.
 * </p>
 *
 * @author anhbdb
 * @see com.bkav.portal.portlet.audioplayer.service.impl.AlbumAudioMapServiceImpl
 * @see com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapServiceUtil
 * @generated
 */
public abstract class AlbumAudioMapServiceBaseImpl extends BaseServiceImpl
	implements AlbumAudioMapService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapServiceUtil} to access the album audio map remote service.
	 */

	/**
	 * Returns the album audio map local service.
	 *
	 * @return the album audio map local service
	 */
	public AlbumAudioMapLocalService getAlbumAudioMapLocalService() {
		return albumAudioMapLocalService;
	}

	/**
	 * Sets the album audio map local service.
	 *
	 * @param albumAudioMapLocalService the album audio map local service
	 */
	public void setAlbumAudioMapLocalService(
		AlbumAudioMapLocalService albumAudioMapLocalService) {
		this.albumAudioMapLocalService = albumAudioMapLocalService;
	}

	/**
	 * Returns the album audio map remote service.
	 *
	 * @return the album audio map remote service
	 */
	public AlbumAudioMapService getAlbumAudioMapService() {
		return albumAudioMapService;
	}

	/**
	 * Sets the album audio map remote service.
	 *
	 * @param albumAudioMapService the album audio map remote service
	 */
	public void setAlbumAudioMapService(
		AlbumAudioMapService albumAudioMapService) {
		this.albumAudioMapService = albumAudioMapService;
	}

	/**
	 * Returns the album audio map persistence.
	 *
	 * @return the album audio map persistence
	 */
	public AlbumAudioMapPersistence getAlbumAudioMapPersistence() {
		return albumAudioMapPersistence;
	}

	/**
	 * Sets the album audio map persistence.
	 *
	 * @param albumAudioMapPersistence the album audio map persistence
	 */
	public void setAlbumAudioMapPersistence(
		AlbumAudioMapPersistence albumAudioMapPersistence) {
		this.albumAudioMapPersistence = albumAudioMapPersistence;
	}

	/**
	 * Returns the audio album local service.
	 *
	 * @return the audio album local service
	 */
	public AudioAlbumLocalService getAudioAlbumLocalService() {
		return audioAlbumLocalService;
	}

	/**
	 * Sets the audio album local service.
	 *
	 * @param audioAlbumLocalService the audio album local service
	 */
	public void setAudioAlbumLocalService(
		AudioAlbumLocalService audioAlbumLocalService) {
		this.audioAlbumLocalService = audioAlbumLocalService;
	}

	/**
	 * Returns the audio album remote service.
	 *
	 * @return the audio album remote service
	 */
	public AudioAlbumService getAudioAlbumService() {
		return audioAlbumService;
	}

	/**
	 * Sets the audio album remote service.
	 *
	 * @param audioAlbumService the audio album remote service
	 */
	public void setAudioAlbumService(AudioAlbumService audioAlbumService) {
		this.audioAlbumService = audioAlbumService;
	}

	/**
	 * Returns the audio album persistence.
	 *
	 * @return the audio album persistence
	 */
	public AudioAlbumPersistence getAudioAlbumPersistence() {
		return audioAlbumPersistence;
	}

	/**
	 * Sets the audio album persistence.
	 *
	 * @param audioAlbumPersistence the audio album persistence
	 */
	public void setAudioAlbumPersistence(
		AudioAlbumPersistence audioAlbumPersistence) {
		this.audioAlbumPersistence = audioAlbumPersistence;
	}

	/**
	 * Returns the audio file local service.
	 *
	 * @return the audio file local service
	 */
	public AudioFileLocalService getAudioFileLocalService() {
		return audioFileLocalService;
	}

	/**
	 * Sets the audio file local service.
	 *
	 * @param audioFileLocalService the audio file local service
	 */
	public void setAudioFileLocalService(
		AudioFileLocalService audioFileLocalService) {
		this.audioFileLocalService = audioFileLocalService;
	}

	/**
	 * Returns the audio file remote service.
	 *
	 * @return the audio file remote service
	 */
	public AudioFileService getAudioFileService() {
		return audioFileService;
	}

	/**
	 * Sets the audio file remote service.
	 *
	 * @param audioFileService the audio file remote service
	 */
	public void setAudioFileService(AudioFileService audioFileService) {
		this.audioFileService = audioFileService;
	}

	/**
	 * Returns the audio file persistence.
	 *
	 * @return the audio file persistence
	 */
	public AudioFilePersistence getAudioFilePersistence() {
		return audioFilePersistence;
	}

	/**
	 * Sets the audio file persistence.
	 *
	 * @param audioFilePersistence the audio file persistence
	 */
	public void setAudioFilePersistence(
		AudioFilePersistence audioFilePersistence) {
		this.audioFilePersistence = audioFilePersistence;
	}

	/**
	 * Returns the audio file finder.
	 *
	 * @return the audio file finder
	 */
	public AudioFileFinder getAudioFileFinder() {
		return audioFileFinder;
	}

	/**
	 * Sets the audio file finder.
	 *
	 * @param audioFileFinder the audio file finder
	 */
	public void setAudioFileFinder(AudioFileFinder audioFileFinder) {
		this.audioFileFinder = audioFileFinder;
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
		return AlbumAudioMap.class;
	}

	protected String getModelClassName() {
		return AlbumAudioMap.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = albumAudioMapPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AlbumAudioMapLocalService.class)
	protected AlbumAudioMapLocalService albumAudioMapLocalService;
	@BeanReference(type = AlbumAudioMapService.class)
	protected AlbumAudioMapService albumAudioMapService;
	@BeanReference(type = AlbumAudioMapPersistence.class)
	protected AlbumAudioMapPersistence albumAudioMapPersistence;
	@BeanReference(type = AudioAlbumLocalService.class)
	protected AudioAlbumLocalService audioAlbumLocalService;
	@BeanReference(type = AudioAlbumService.class)
	protected AudioAlbumService audioAlbumService;
	@BeanReference(type = AudioAlbumPersistence.class)
	protected AudioAlbumPersistence audioAlbumPersistence;
	@BeanReference(type = AudioFileLocalService.class)
	protected AudioFileLocalService audioFileLocalService;
	@BeanReference(type = AudioFileService.class)
	protected AudioFileService audioFileService;
	@BeanReference(type = AudioFilePersistence.class)
	protected AudioFilePersistence audioFilePersistence;
	@BeanReference(type = AudioFileFinder.class)
	protected AudioFileFinder audioFileFinder;
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
	private AlbumAudioMapServiceClpInvoker _clpInvoker = new AlbumAudioMapServiceClpInvoker();
}