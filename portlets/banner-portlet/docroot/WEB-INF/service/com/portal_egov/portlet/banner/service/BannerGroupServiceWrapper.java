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

package com.portal_egov.portlet.banner.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link BannerGroupService}.
 * </p>
 *
 * @author    HungDX
 * @see       BannerGroupService
 * @generated
 */
public class BannerGroupServiceWrapper implements BannerGroupService,
	ServiceWrapper<BannerGroupService> {
	public BannerGroupServiceWrapper(BannerGroupService bannerGroupService) {
		_bannerGroupService = bannerGroupService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _bannerGroupService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bannerGroupService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bannerGroupService.invokeMethod(name, parameterTypes, arguments);
	}

	public com.liferay.portal.kernel.json.JSONObject getBannerGroups(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return _bannerGroupService.getBannerGroups(groupId);
	}

	public void deleteBannerGroup(long groupId, long bannerGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		_bannerGroupService.deleteBannerGroup(groupId, bannerGroupId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public BannerGroupService getWrappedBannerGroupService() {
		return _bannerGroupService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedBannerGroupService(
		BannerGroupService bannerGroupService) {
		_bannerGroupService = bannerGroupService;
	}

	public BannerGroupService getWrappedService() {
		return _bannerGroupService;
	}

	public void setWrappedService(BannerGroupService bannerGroupService) {
		_bannerGroupService = bannerGroupService;
	}

	private BannerGroupService _bannerGroupService;
}