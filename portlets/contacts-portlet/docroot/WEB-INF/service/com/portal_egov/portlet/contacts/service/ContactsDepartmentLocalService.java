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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the contacts department local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see ContactsDepartmentLocalServiceUtil
 * @see com.portal_egov.portlet.contacts.service.base.ContactsDepartmentLocalServiceBaseImpl
 * @see com.portal_egov.portlet.contacts.service.impl.ContactsDepartmentLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ContactsDepartmentLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactsDepartmentLocalServiceUtil} to access the contacts department local service. Add custom service methods to {@link com.portal_egov.portlet.contacts.service.impl.ContactsDepartmentLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the contacts department to the database. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartment the contacts department
	* @return the contacts department that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment addContactsDepartment(
		com.portal_egov.portlet.contacts.model.ContactsDepartment contactsDepartment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new contacts department with the primary key. Does not add the contacts department to the database.
	*
	* @param departmentId the primary key for the new contacts department
	* @return the new contacts department
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment createContactsDepartment(
		long departmentId);

	/**
	* Deletes the contacts department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param departmentId the primary key of the contacts department
	* @return the contacts department that was removed
	* @throws PortalException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment deleteContactsDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the contacts department from the database. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartment the contacts department
	* @return the contacts department that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment deleteContactsDepartment(
		com.portal_egov.portlet.contacts.model.ContactsDepartment contactsDepartment)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.portal_egov.portlet.contacts.model.ContactsDepartment fetchContactsDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts department with the primary key.
	*
	* @param departmentId the primary key of the contacts department
	* @return the contacts department
	* @throws PortalException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.portal_egov.portlet.contacts.model.ContactsDepartment getContactsDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> getContactsDepartments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts departments.
	*
	* @return the number of contacts departments
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getContactsDepartmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the contacts department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartment the contacts department
	* @return the contacts department that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment updateContactsDepartment(
		com.portal_egov.portlet.contacts.model.ContactsDepartment contactsDepartment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the contacts department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactsDepartment the contacts department
	* @param merge whether to merge the contacts department with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the contacts department that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment updateContactsDepartment(
		com.portal_egov.portlet.contacts.model.ContactsDepartment contactsDepartment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByParentAndCompany(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByStatusAndCompany(long companyId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByStatusAndGroup(long groupId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndCompany(
		long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndCompany(
		long companyId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndGroup(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndGroup(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndCompany(
		long companyId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndCompany(
		long companyId, int departmentStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndGroup(
		long groupId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndGroup(
		long groupId, int departmentStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByKeyword(
		long groupId, long parentId, java.lang.String keyword,
		int departmentStatus, int start, int end);

	public com.portal_egov.portlet.contacts.model.ContactsDepartment addDepartment(
		long groupId, long companyId, long userId, java.lang.String userName,
		long parentId, java.lang.String departmentName,
		java.lang.String departmentAddress, java.lang.String departmentPhone,
		java.lang.String departmentWebsite, java.lang.String departmentEmail,
		int displayPriority, int departmentStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.portal_egov.portlet.contacts.model.ContactsDepartment updateDepartment(
		long departmentId, long groupId, long companyId, long userId,
		java.lang.String userName, long parentId,
		java.lang.String departmentName, java.lang.String departmentAddress,
		java.lang.String departmentPhone, java.lang.String departmentWebsite,
		java.lang.String departmentEmail, int displayPriority,
		int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateDepartmentState(long departmentId, int displayPriority)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateDepartmentParent(long departmentId,
		long parentDepartmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deleteDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;
}