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
 * The utility for the contacts department local service. This utility wraps {@link com.portal_egov.portlet.contacts.service.impl.ContactsDepartmentLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see ContactsDepartmentLocalService
 * @see com.portal_egov.portlet.contacts.service.base.ContactsDepartmentLocalServiceBaseImpl
 * @see com.portal_egov.portlet.contacts.service.impl.ContactsDepartmentLocalServiceImpl
 * @generated
 */
public class ContactsDepartmentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.contacts.service.impl.ContactsDepartmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the contacts department to the database. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartment the contacts department
	* @return the contacts department that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment addContactsDepartment(
		com.portal_egov.portlet.contacts.model.ContactsDepartment contactsDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addContactsDepartment(contactsDepartment);
	}

	/**
	* Creates a new contacts department with the primary key. Does not add the contacts department to the database.
	*
	* @param departmentId the primary key for the new contacts department
	* @return the new contacts department
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment createContactsDepartment(
		long departmentId) {
		return getService().createContactsDepartment(departmentId);
	}

	/**
	* Deletes the contacts department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param departmentId the primary key of the contacts department
	* @return the contacts department that was removed
	* @throws PortalException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment deleteContactsDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContactsDepartment(departmentId);
	}

	/**
	* Deletes the contacts department from the database. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartment the contacts department
	* @return the contacts department that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment deleteContactsDepartment(
		com.portal_egov.portlet.contacts.model.ContactsDepartment contactsDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContactsDepartment(contactsDepartment);
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

	public static com.portal_egov.portlet.contacts.model.ContactsDepartment fetchContactsDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchContactsDepartment(departmentId);
	}

	/**
	* Returns the contacts department with the primary key.
	*
	* @param departmentId the primary key of the contacts department
	* @return the contacts department
	* @throws PortalException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment getContactsDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactsDepartment(departmentId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contacts departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @return the range of contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> getContactsDepartments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactsDepartments(start, end);
	}

	/**
	* Returns the number of contacts departments.
	*
	* @return the number of contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static int getContactsDepartmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactsDepartmentsCount();
	}

	/**
	* Updates the contacts department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartment the contacts department
	* @return the contacts department that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment updateContactsDepartment(
		com.portal_egov.portlet.contacts.model.ContactsDepartment contactsDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateContactsDepartment(contactsDepartment);
	}

	/**
	* Updates the contacts department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartment the contacts department
	* @param merge whether to merge the contacts department with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the contacts department that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment updateContactsDepartment(
		com.portal_egov.portlet.contacts.model.ContactsDepartment contactsDepartment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateContactsDepartment(contactsDepartment, merge);
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

	public static int countByParentAndCompany(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByParentAndCompany(companyId, parentId);
	}

	public static int countByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByParentAndGroup(groupId, parentId);
	}

	public static int countByStatusAndCompany(long companyId,
		int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByStatusAndCompany(companyId, departmentStatus);
	}

	public static int countByStatusAndGroup(long groupId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByStatusAndGroup(groupId, departmentStatus);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndCompany(
		long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByParentAndCompany(companyId, parentId);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndCompany(
		long companyId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByParentAndCompany(companyId, parentId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndGroup(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByParentAndGroup(groupId, parentId);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndGroup(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByParentAndGroup(groupId, parentId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndCompany(
		long companyId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatusAndCompany(companyId, departmentStatus);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndCompany(
		long companyId, int departmentStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByStatusAndCompany(companyId, departmentStatus, start,
			end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndGroup(
		long groupId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatusAndGroup(groupId, departmentStatus);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndGroup(
		long groupId, int departmentStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByStatusAndGroup(groupId, departmentStatus, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByKeyword(
		long groupId, long parentId, java.lang.String keyword,
		int departmentStatus, int start, int end) {
		return getService()
				   .findByKeyword(groupId, parentId, keyword, departmentStatus,
			start, end);
	}

	public static com.portal_egov.portlet.contacts.model.ContactsDepartment addDepartment(
		long groupId, long companyId, long userId, java.lang.String userName,
		long parentId, java.lang.String departmentName,
		java.lang.String departmentAddress, java.lang.String departmentPhone,
		java.lang.String departmentWebsite, java.lang.String departmentEmail,
		int displayPriority, int departmentStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addDepartment(groupId, companyId, userId, userName,
			parentId, departmentName, departmentAddress, departmentPhone,
			departmentWebsite, departmentEmail, displayPriority,
			departmentStatus, serviceContext);
	}

	public static com.portal_egov.portlet.contacts.model.ContactsDepartment updateDepartment(
		long departmentId, long groupId, long companyId, long userId,
		java.lang.String userName, long parentId,
		java.lang.String departmentName, java.lang.String departmentAddress,
		java.lang.String departmentPhone, java.lang.String departmentWebsite,
		java.lang.String departmentEmail, int displayPriority,
		int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateDepartment(departmentId, groupId, companyId, userId,
			userName, parentId, departmentName, departmentAddress,
			departmentPhone, departmentWebsite, departmentEmail,
			displayPriority, departmentStatus);
	}

	public static void updateDepartmentState(long departmentId,
		int displayPriority)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateDepartmentState(departmentId, displayPriority);
	}

	public static void updateDepartmentParent(long departmentId,
		long parentDepartmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateDepartmentParent(departmentId, parentDepartmentId);
	}

	public static void deleteDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		getService().deleteDepartment(departmentId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ContactsDepartmentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ContactsDepartmentLocalService.class.getName());

			if (invokableLocalService instanceof ContactsDepartmentLocalService) {
				_service = (ContactsDepartmentLocalService)invokableLocalService;
			}
			else {
				_service = new ContactsDepartmentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ContactsDepartmentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ContactsDepartmentLocalService service) {
	}

	private static ContactsDepartmentLocalService _service;
}