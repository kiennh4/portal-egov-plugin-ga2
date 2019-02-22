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
 * This class is a wrapper for {@link BannerService}.
 * </p>
 *
 * @author    HungDX
 * @see       BannerService
 * @generated
 */
public class BannerServiceWrapper implements BannerService,
	ServiceWrapper<BannerService> {
	public BannerServiceWrapper(BannerService bannerService) {
		_bannerService = bannerService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _bannerService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bannerService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bannerService.invokeMethod(name, parameterTypes, arguments);
	}

	public com.portal_egov.portlet.banner.model.Banner getBanner(long bannerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bannerService.getBanner(bannerId);
	}

	public com.liferay.portal.kernel.json.JSONObject getAllBanners(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return _bannerService.getAllBanners(groupId);
	}

	public com.liferay.portal.kernel.json.JSONObject getGroupBanners(
		long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return _bannerService.getGroupBanners(bannerGroupId);
	}

	public com.liferay.portal.kernel.json.JSONObject findByKeyword(
		long groupId, long bannerGroupId, java.lang.String searchKeyword)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return _bannerService.findByKeyword(groupId, bannerGroupId,
			searchKeyword);
	}

	public void deleteBanner(long groupId, long bannerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		_bannerService.deleteBanner(groupId, bannerId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public BannerService getWrappedBannerService() {
		return _bannerService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedBannerService(BannerService bannerService) {
		_bannerService = bannerService;
	}

	public BannerService getWrappedService() {
		return _bannerService;
	}

	public void setWrappedService(BannerService bannerService) {
		_bannerService = bannerService;
	}

	private BannerService _bannerService;
}