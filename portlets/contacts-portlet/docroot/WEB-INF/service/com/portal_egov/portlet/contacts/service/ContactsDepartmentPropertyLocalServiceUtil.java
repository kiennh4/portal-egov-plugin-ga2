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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the contacts department property local service. This utility wraps {@link com.portal_egov.portlet.contacts.service.impl.ContactsDepartmentPropertyLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see ContactsDepartmentPropertyLocalService
 * @see com.portal_egov.portlet.contacts.service.base.ContactsDepartmentPropertyLocalServiceBaseImpl
 * @see com.portal_egov.portlet.contacts.service.impl.ContactsDepartmentPropertyLocalServiceImpl
 * @generated
 */
public class ContactsDepartmentPropertyLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.contacts.service.impl.ContactsDepartmentPropertyLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the contacts department property to the database. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartmentProperty the contacts department property
	* @return the contacts department property that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty addContactsDepartmentProperty(
		com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty contactsDepartmentProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addContactsDepartmentProperty(contactsDepartmentProperty);
	}

	/**
	* Creates a new contacts department property with the primary key. Does not add the contacts department property to the database.
	*
	* @param propertyId the primary key for the new contacts department property
	* @return the new contacts department property
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty createContactsDepartmentProperty(
		long propertyId) {
		return getService().createContactsDepartmentProperty(propertyId);
	}

	/**
	* Deletes the contacts department property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propertyId the primary key of the contacts department property
	* @return the contacts department property that was removed
	* @throws PortalException if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty deleteContactsDepartmentProperty(
		long propertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContactsDepartmentProperty(propertyId);
	}

	/**
	* Deletes the contacts department property from the database. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartmentProperty the contacts department property
	* @return the contacts department property that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty deleteContactsDepartmentProperty(
		com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty contactsDepartmentProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteContactsDepartmentProperty(contactsDepartmentProperty);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchContactsDepartmentProperty(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchContactsDepartmentProperty(propertyId);
	}

	/**
	* Returns the contacts department property with the primary key.
	*
	* @param propertyId the primary key of the contacts department property
	* @return the contacts department property
	* @throws PortalException if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty getContactsDepartmentProperty(
		long propertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactsDepartmentProperty(propertyId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> getContactsDepartmentProperties(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactsDepartmentProperties(start, end);
	}

	/**
	* Returns the number of contacts department properties.
	*
	* @return the number of contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public static int getContactsDepartmentPropertiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactsDepartmentPropertiesCount();
	}

	/**
	* Updates the contacts department property in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartmentProperty the contacts department property
	* @return the contacts department property that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty updateContactsDepartmentProperty(
		com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty contactsDepartmentProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateContactsDepartmentProperty(contactsDepartmentProperty);
	}

	/**
	* Updates the contacts department property in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartmentProperty the contacts department property
	* @param merge whether to merge the contacts department property with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the contacts department property that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty updateContactsDepartmentProperty(
		com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty contactsDepartmentProperty,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateContactsDepartmentProperty(contactsDepartmentProperty,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll();
	}

	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCompany(companyId);
	}

	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroup(groupId);
	}

	public static int countByContactsDepartment(long contactDepartmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByContactsDepartment(contactDepartmentId);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByContactsDepartment(departmentId);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartment(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByContactsDepartment(departmentId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByPropertyKey(
		long groupId, long departmentId, java.lang.String propertyKey) {
		return getService().findByPropertyKey(groupId, departmentId, propertyKey);
	}

	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty addDepartmentProperty(
		long companyId, long groupId, long userId, java.lang.String userName,
		long departmentId, java.lang.String propertyKey,
		java.lang.String propertyValue, java.lang.String propertyType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addDepartmentProperty(companyId, groupId, userId, userName,
			departmentId, propertyKey, propertyValue, propertyType);
	}

	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty addDepartmentProperty(
		long propertyId, long companyId, long groupId, long userId,
		java.lang.String userName, long departmentId,
		java.lang.String propertyKey, java.lang.String propertyValue,
		java.lang.String propertyType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addDepartmentProperty(propertyId, companyId, groupId,
			userId, userName, departmentId, propertyKey, propertyValue,
			propertyType);
	}

	public static void deleteDepartmentProperty(long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		getService().deleteDepartmentProperty(propertyId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ContactsDepartmentPropertyLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ContactsDepartmentPropertyLocalService.class.getName());

			if (invokableLocalService instanceof ContactsDepartmentPropertyLocalService) {
				_service = (ContactsDepartmentPropertyLocalService)invokableLocalService;
			}
			else {
				_service = new ContactsDepartmentPropertyLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ContactsDepartmentPropertyLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ContactsDepartmentPropertyLocalService service) {
	}

	private static ContactsDepartmentPropertyLocalService _service;
}