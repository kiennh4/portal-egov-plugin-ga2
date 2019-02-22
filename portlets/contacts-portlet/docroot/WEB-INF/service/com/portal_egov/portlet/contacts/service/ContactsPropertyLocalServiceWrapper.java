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
 * This class is a wrapper for {@link ContactsPropertyLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       ContactsPropertyLocalService
 * @generated
 */
public class ContactsPropertyLocalServiceWrapper
	implements ContactsPropertyLocalService,
		ServiceWrapper<ContactsPropertyLocalService> {
	public ContactsPropertyLocalServiceWrapper(
		ContactsPropertyLocalService contactsPropertyLocalService) {
		_contactsPropertyLocalService = contactsPropertyLocalService;
	}

	/**
	* Adds the contacts property to the database. Also notifies the appropriate model listeners.
	*
	* @param contactsProperty the contacts property
	* @return the contacts property that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsProperty addContactsProperty(
		com.portal_egov.portlet.contacts.model.ContactsProperty contactsProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.addContactsProperty(contactsProperty);
	}

	/**
	* Creates a new contacts property with the primary key. Does not add the contacts property to the database.
	*
	* @param propertyId the primary key for the new contacts property
	* @return the new contacts property
	*/
	public com.portal_egov.portlet.contacts.model.ContactsProperty createContactsProperty(
		long propertyId) {
		return _contactsPropertyLocalService.createContactsProperty(propertyId);
	}

	/**
	* Deletes the contacts property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propertyId the primary key of the contacts property
	* @return the contacts property that was removed
	* @throws PortalException if a contacts property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsProperty deleteContactsProperty(
		long propertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.deleteContactsProperty(propertyId);
	}

	/**
	* Deletes the contacts property from the database. Also notifies the appropriate model listeners.
	*
	* @param contactsProperty the contacts property
	* @return the contacts property that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsProperty deleteContactsProperty(
		com.portal_egov.portlet.contacts.model.ContactsProperty contactsProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.deleteContactsProperty(contactsProperty);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contactsPropertyLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.contacts.model.ContactsProperty fetchContactsProperty(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.fetchContactsProperty(propertyId);
	}

	/**
	* Returns the contacts property with the primary key.
	*
	* @param propertyId the primary key of the contacts property
	* @return the contacts property
	* @throws PortalException if a contacts property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsProperty getContactsProperty(
		long propertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.getContactsProperty(propertyId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contacts properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contacts properties
	* @param end the upper bound of the range of contacts properties (not inclusive)
	* @return the range of contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> getContactsProperties(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.getContactsProperties(start, end);
	}

	/**
	* Returns the number of contacts properties.
	*
	* @return the number of contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public int getContactsPropertiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.getContactsPropertiesCount();
	}

	/**
	* Updates the contacts property in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactsProperty the contacts property
	* @return the contacts property that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsProperty updateContactsProperty(
		com.portal_egov.portlet.contacts.model.ContactsProperty contactsProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.updateContactsProperty(contactsProperty);
	}

	/**
	* Updates the contacts property in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactsProperty the contacts property
	* @param merge whether to merge the contacts property with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the contacts property that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsProperty updateContactsProperty(
		com.portal_egov.portlet.contacts.model.ContactsProperty contactsProperty,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.updateContactsProperty(contactsProperty,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _contactsPropertyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contactsPropertyLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contactsPropertyLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.countByGroup(groupId);
	}

	public int countByContact(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.countByContact(contactId);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.findByCompany(companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.findByGroup(groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByContact(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.findByContact(contactId);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByContact(
		long contactId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.findByContact(contactId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByContactAndPropertyKey(
		long contactId, java.lang.String propertyKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.findByContactAndPropertyKey(contactId,
			propertyKey);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByContactAndPropertyKey(
		long contactId, java.lang.String propertyKey, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.findByContactAndPropertyKey(contactId,
			propertyKey, start, end);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByPropertyKey(
		long groupId, long contactId, java.lang.String propertyKey) {
		return _contactsPropertyLocalService.findByPropertyKey(groupId,
			contactId, propertyKey);
	}

	public com.portal_egov.portlet.contacts.model.ContactsProperty addContactProperty(
		long groupId, long companyId, long userId, java.lang.String userName,
		long contactId, java.lang.String propertyKey,
		java.lang.String propertyValue, java.lang.String propertyType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.addContactProperty(groupId,
			companyId, userId, userName, contactId, propertyKey, propertyValue,
			propertyType);
	}

	public com.portal_egov.portlet.contacts.model.ContactsProperty updateContactProperty(
		long propertyId, long groupId, long companyId, long userId,
		java.lang.String userName, long contactId,
		java.lang.String propertyKey, java.lang.String propertyValue,
		java.lang.String propertyType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsPropertyLocalService.updateContactProperty(propertyId,
			groupId, companyId, userId, userName, contactId, propertyKey,
			propertyValue, propertyType);
	}

	public void deleteContactProperty(long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		_contactsPropertyLocalService.deleteContactProperty(propertyId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ContactsPropertyLocalService getWrappedContactsPropertyLocalService() {
		return _contactsPropertyLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedContactsPropertyLocalService(
		ContactsPropertyLocalService contactsPropertyLocalService) {
		_contactsPropertyLocalService = contactsPropertyLocalService;
	}

	public ContactsPropertyLocalService getWrappedService() {
		return _contactsPropertyLocalService;
	}

	public void setWrappedService(
		ContactsPropertyLocalService contactsPropertyLocalService) {
		_contactsPropertyLocalService = contactsPropertyLocalService;
	}

	private ContactsPropertyLocalService _contactsPropertyLocalService;
}