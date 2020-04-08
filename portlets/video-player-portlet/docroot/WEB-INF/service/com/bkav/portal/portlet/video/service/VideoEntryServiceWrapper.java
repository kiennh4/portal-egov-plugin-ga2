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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VideoEntryService}.
 * </p>
 *
 * @author    hungdx
 * @see       VideoEntryService
 * @generated
 */
public class VideoEntryServiceWrapper implements VideoEntryService,
	ServiceWrapper<VideoEntryService> {
	public VideoEntryServiceWrapper(VideoEntryService videoEntryService) {
		_videoEntryService = videoEntryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _videoEntryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_videoEntryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _videoEntryService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VideoEntryService getWrappedVideoEntryService() {
		return _videoEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVideoEntryService(VideoEntryService videoEntryService) {
		_videoEntryService = videoEntryService;
	}

	public VideoEntryService getWrappedService() {
		return _videoEntryService;
	}

	public void setWrappedService(VideoEntryService videoEntryService) {
		_videoEntryService = videoEntryService;
	}

	private VideoEntryService _videoEntryService;
}