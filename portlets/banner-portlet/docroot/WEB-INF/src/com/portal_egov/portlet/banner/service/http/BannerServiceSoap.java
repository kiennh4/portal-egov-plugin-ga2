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

package com.portal_egov.portlet.banner.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.portal_egov.portlet.banner.service.BannerServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.portal_egov.portlet.banner.service.BannerServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.portal_egov.portlet.banner.model.BannerSoap}.
 * If the method in the service utility returns a
 * {@link com.portal_egov.portlet.banner.model.Banner}, that is translated to a
 * {@link com.portal_egov.portlet.banner.model.BannerSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    HungDX
 * @see       BannerServiceHttp
 * @see       com.portal_egov.portlet.banner.model.BannerSoap
 * @see       com.portal_egov.portlet.banner.service.BannerServiceUtil
 * @generated
 */
public class BannerServiceSoap {
	public static com.portal_egov.portlet.banner.model.BannerSoap getBanner(
		long bannerId) throws RemoteException {
		try {
			com.portal_egov.portlet.banner.model.Banner returnValue = BannerServiceUtil.getBanner(bannerId);

			return com.portal_egov.portlet.banner.model.BannerSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getAllBanners(long groupId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = BannerServiceUtil.getAllBanners(groupId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getGroupBanners(long bannerGroupId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = BannerServiceUtil.getGroupBanners(bannerGroupId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String findByKeyword(long groupId,
		long bannerGroupId, java.lang.String searchKeyword)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = BannerServiceUtil.findByKeyword(groupId,
					bannerGroupId, searchKeyword);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteBanner(long groupId, long bannerId)
		throws RemoteException {
		try {
			BannerServiceUtil.deleteBanner(groupId, bannerId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(BannerServiceSoap.class);
}