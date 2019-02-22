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
 * This class is a wrapper for {@link ContactsDepartmentPropertyLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       ContactsDepartmentPropertyLocalService
 * @generated
 */
public class ContactsDepartmentPropertyLocalServiceWrapper
	implements ContactsDepartmentPropertyLocalService,
		ServiceWrapper<ContactsDepartmentPropertyLocalService> {
	public ContactsDepartmentPropertyLocalServiceWrapper(
		ContactsDepartmentPropertyLocalService contactsDepartmentPropertyLocalService) {
		_contactsDepartmentPropertyLocalService = contactsDepartmentPropertyLocalService;
	}

	/**
	* Adds the contacts department property to the database. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartmentProperty the contacts department property
	* @return the contacts department property that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty addContactsDepartmentProperty(
		com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty contactsDepartmentProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.addContactsDepartmentProperty(contactsDepartmentProperty);
	}

	/**
	* Creates a new contacts department property with the primary key. Does not add the contacts department property to the database.
	*
	* @param propertyId the primary key for the new contacts department property
	* @return the new contacts department property
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty createContactsDepartmentProperty(
		long propertyId) {
		return _contactsDepartmentPropertyLocalService.createContactsDepartmentProperty(propertyId);
	}

	/**
	* Deletes the contacts department property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propertyId the primary key of the contacts department property
	* @return the contacts department property that was removed
	* @throws PortalException if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty deleteContactsDepartmentProperty(
		long propertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.deleteContactsDepartmentProperty(propertyId);
	}

	/**
	* Deletes the contacts department property from the database. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartmentProperty the contacts department property
	* @return the contacts department property that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty deleteContactsDepartmentProperty(
		com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty contactsDepartmentProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.deleteContactsDepartmentProperty(contactsDepartmentProperty);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contactsDepartmentPropertyLocalService.dynamicQuery();
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
		return _contactsDepartmentPropertyLocalService.dynamicQuery(dynamicQuery);
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
		return _contactsDepartmentPropertyLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
		return _contactsDepartmentPropertyLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _contactsDepartmentPropertyLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchContactsDepartmentProperty(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.fetchContactsDepartmentProperty(propertyId);
	}

	/**
	* Returns the contacts department property with the primary key.
	*
	* @param propertyId the primary key of the contacts department property
	* @return the contacts department property
	* @throws PortalException if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty getContactsDepartmentProperty(
		long propertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.getContactsDepartmentProperty(propertyId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contacts department properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contacts department properties
	* @param end the upper bound of the range of contacts department properties (not inclusive)
	* @return the range of contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> getContactsDepartmentProperties(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.getContactsDepartmentProperties(start,
			end);
	}

	/**
	* Returns the number of contacts department properties.
	*
	* @return the number of contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public int getContactsDepartmentPropertiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.getContactsDepartmentPropertiesCount();
	}

	/**
	* Updates the contacts department property in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartmentProperty the contacts department property
	* @return the contacts department property that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty updateContactsDepartmentProperty(
		com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty contactsDepartmentProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.updateContactsDepartmentProperty(contactsDepartmentProperty);
	}

	/**
	* Updates the contacts department property in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartmentProperty the contacts department property
	* @param merge whether to merge the contacts department property with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the contacts department property that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty updateContactsDepartmentProperty(
		com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty contactsDepartmentProperty,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.updateContactsDepartmentProperty(contactsDepartmentProperty,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _contactsDepartmentPropertyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contactsDepartmentPropertyLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contactsDepartmentPropertyLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.countByGroup(groupId);
	}

	public int countByContactsDepartment(long contactDepartmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.countByContactsDepartment(contactDepartmentId);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.findAll();
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.findByCompany(companyId,
			start, end);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.findByGroup(groupId,
			start, end);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.findByContactsDepartment(departmentId);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartment(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.findByContactsDepartment(departmentId,
			start, end);
	}

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByPropertyKey(
		long groupId, long departmentId, java.lang.String propertyKey) {
		return _contactsDepartmentPropertyLocalService.findByPropertyKey(groupId,
			departmentId, propertyKey);
	}

	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty addDepartmentProperty(
		long companyId, long groupId, long userId, java.lang.String userName,
		long departmentId, java.lang.String propertyKey,
		java.lang.String propertyValue, java.lang.String propertyType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.addDepartmentProperty(companyId,
			groupId, userId, userName, departmentId, propertyKey,
			propertyValue, propertyType);
	}

	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty addDepartmentProperty(
		long propertyId, long companyId, long groupId, long userId,
		java.lang.String userName, long departmentId,
		java.lang.String propertyKey, java.lang.String propertyValue,
		java.lang.String propertyType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentPropertyLocalService.addDepartmentProperty(propertyId,
			companyId, groupId, userId, userName, departmentId, propertyKey,
			propertyValue, propertyType);
	}

	public void deleteDepartmentProperty(long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		_contactsDepartmentPropertyLocalService.deleteDepartmentProperty(propertyId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ContactsDepartmentPropertyLocalService getWrappedContactsDepartmentPropertyLocalService() {
		return _contactsDepartmentPropertyLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedContactsDepartmentPropertyLocalService(
		ContactsDepartmentPropertyLocalService contactsDepartmentPropertyLocalService) {
		_contactsDepartmentPropertyLocalService = contactsDepartmentPropertyLocalService;
	}

	public ContactsDepartmentPropertyLocalService getWrappedService() {
		return _contactsDepartmentPropertyLocalService;
	}

	public void setWrappedService(
		ContactsDepartmentPropertyLocalService contactsDepartmentPropertyLocalService) {
		_contactsDepartmentPropertyLocalService = contactsDepartmentPropertyLocalService;
	}

	private ContactsDepartmentPropertyLocalService _contactsDepartmentPropertyLocalService;
}