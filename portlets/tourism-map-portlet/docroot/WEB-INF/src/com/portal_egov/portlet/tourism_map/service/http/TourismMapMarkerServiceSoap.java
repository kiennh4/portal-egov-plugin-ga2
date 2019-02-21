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

package com.portal_egov.portlet.tourism_map.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.portal_egov.portlet.tourism_map.service.TourismMapMarkerServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.portal_egov.portlet.tourism_map.service.TourismMapMarkerServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.portal_egov.portlet.tourism_map.model.TourismMapMarkerSoap}.
 * If the method in the service utility returns a
 * {@link com.portal_egov.portlet.tourism_map.model.TourismMapMarker}, that is translated to a
 * {@link com.portal_egov.portlet.tourism_map.model.TourismMapMarkerSoap}. Methods that SOAP cannot
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
 * @see       TourismMapMarkerServiceHttp
 * @see       com.portal_egov.portlet.tourism_map.model.TourismMapMarkerSoap
 * @see       com.portal_egov.portlet.tourism_map.service.TourismMapMarkerServiceUtil
 * @generated
 */
public class TourismMapMarkerServiceSoap {
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerSoap getMarker(
		long markerId) throws RemoteException {
		try {
			com.portal_egov.portlet.tourism_map.model.TourismMapMarker returnValue =
				TourismMapMarkerServiceUtil.getMarker(markerId);

			return com.portal_egov.portlet.tourism_map.model.TourismMapMarkerSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getJSONMarkersByGroup(long markerGroupId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = TourismMapMarkerServiceUtil.getJSONMarkersByGroup(markerGroupId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getJSONMarkers(long groupId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = TourismMapMarkerServiceUtil.getJSONMarkers(groupId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteMarker(long markerId) throws RemoteException {
		try {
			TourismMapMarkerServiceUtil.deleteMarker(markerId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TourismMapMarkerServiceSoap.class);
}