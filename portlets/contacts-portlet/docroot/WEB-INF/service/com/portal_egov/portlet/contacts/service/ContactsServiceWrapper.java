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

package com.portal_egov.portlet.contacts.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ContactsService}.
 * </p>
 *
 * @author    HungDX
 * @see       ContactsService
 * @generated
 */
public class ContactsServiceWrapper implements ContactsService,
	ServiceWrapper<ContactsService> {
	public ContactsServiceWrapper(ContactsService contactsService) {
		_contactsService = contactsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _contactsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contactsService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contactsService.invokeMethod(name, parameterTypes, arguments);
	}

	public com.portal_egov.portlet.contacts.model.Contacts getContact(
		long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactsService.getContact(contactId);
	}

	public com.liferay.portal.kernel.json.JSONObject getGroupContacts(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return _contactsService.getGroupContacts(groupId);
	}

	public com.liferay.portal.kernel.json.JSONObject getDepartmentContacts(
		long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return _contactsService.getDepartmentContacts(groupId, departmentId);
	}

	public com.liferay.portal.kernel.json.JSONObject findByKeyword(
		long groupId, java.lang.String searchKeyword)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return _contactsService.findByKeyword(groupId, searchKeyword);
	}

	public void updateContactState(long contactId, int displayPriority)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		_contactsService.updateContactState(contactId, displayPriority);
	}

	public void updateContactDepartment(long contactId, long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		_contactsService.updateContactDepartment(contactId, departmentId);
	}

	public void deleteContacts(long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		_contactsService.deleteContacts(contactId);
	}

	public java.lang.String getContactPortraitURL(java.lang.String imagePath,
		long contactImageId) {
		return _contactsService.getContactPortraitURL(imagePath, contactImageId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ContactsService getWrappedContactsService() {
		return _contactsService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedContactsService(ContactsService contactsService) {
		_contactsService = contactsService;
	}

	public ContactsService getWrappedService() {
		return _contactsService;
	}

	public void setWrappedService(ContactsService contactsService) {
		_contactsService = contactsService;
	}

	private ContactsService _contactsService;
}