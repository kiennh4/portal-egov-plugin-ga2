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

package com.portal_egov.portlet.contacts.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.portal_egov.portlet.contacts.service.ContactsServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.portal_egov.portlet.contacts.service.ContactsServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.portal_egov.portlet.contacts.model.ContactsSoap}.
 * If the method in the service utility returns a
 * {@link com.portal_egov.portlet.contacts.model.Contacts}, that is translated to a
 * {@link com.portal_egov.portlet.contacts.model.ContactsSoap}. Methods that SOAP cannot
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
 * @see       ContactsServiceHttp
 * @see       com.portal_egov.portlet.contacts.model.ContactsSoap
 * @see       com.portal_egov.portlet.contacts.service.ContactsServiceUtil
 * @generated
 */
public class ContactsServiceSoap {
	public static com.portal_egov.portlet.contacts.model.ContactsSoap getContact(
		long contactId) throws RemoteException {
		try {
			com.portal_egov.portlet.contacts.model.Contacts returnValue = ContactsServiceUtil.getContact(contactId);

			return com.portal_egov.portlet.contacts.model.ContactsSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getGroupContacts(long groupId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ContactsServiceUtil.getGroupContacts(groupId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getDepartmentContacts(long groupId,
		long departmentId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ContactsServiceUtil.getDepartmentContacts(groupId,
					departmentId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String findByKeyword(long groupId,
		java.lang.String searchKeyword) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ContactsServiceUtil.findByKeyword(groupId,
					searchKeyword);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void updateContactState(long contactId, int displayPriority)
		throws RemoteException {
		try {
			ContactsServiceUtil.updateContactState(contactId, displayPriority);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void updateContactDepartment(long contactId, long departmentId)
		throws RemoteException {
		try {
			ContactsServiceUtil.updateContactDepartment(contactId, departmentId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteContacts(long contactId) throws RemoteException {
		try {
			ContactsServiceUtil.deleteContacts(contactId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getContactPortraitURL(
		java.lang.String imagePath, long contactImageId)
		throws RemoteException {
		try {
			java.lang.String returnValue = ContactsServiceUtil.getContactPortraitURL(imagePath,
					contactImageId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ContactsServiceSoap.class);
}