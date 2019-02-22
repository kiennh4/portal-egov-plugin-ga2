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

package com.portal_egov.portlet.contacts.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.contacts.model.ContactsDepartment;

/**
 * The persistence interface for the contacts department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see ContactsDepartmentPersistenceImpl
 * @see ContactsDepartmentUtil
 * @generated
 */
public interface ContactsDepartmentPersistence extends BasePersistence<ContactsDepartment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactsDepartmentUtil} to access the contacts department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the contacts department in the entity cache if it is enabled.
	*
	* @param contactsDepartment the contacts department
	*/
	public void cacheResult(
		com.portal_egov.portlet.contacts.model.ContactsDepartment contactsDepartment);

	/**
	* Caches the contacts departments in the entity cache if it is enabled.
	*
	* @param contactsDepartments the contacts departments
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> contactsDepartments);

	/**
	* Creates a new contacts department with the primary key. Does not add the contacts department to the database.
	*
	* @param departmentId the primary key for the new contacts department
	* @return the new contacts department
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment create(
		long departmentId);

	/**
	* Removes the contacts department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param departmentId the primary key of the contacts department
	* @return the contacts department that was removed
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment remove(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	public com.portal_egov.portlet.contacts.model.ContactsDepartment updateImpl(
		com.portal_egov.portlet.contacts.model.ContactsDepartment contactsDepartment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts department with the primary key or throws a {@link com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException} if it could not be found.
	*
	* @param departmentId the primary key of the contacts department
	* @return the contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment findByPrimaryKey(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns the contacts department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param departmentId the primary key of the contacts department
	* @return the contacts department, or <code>null</code> if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByPrimaryKey(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contacts departments where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contacts departments where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @return the range of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts departments where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contacts department in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns the first contacts department in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contacts department in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns the last contacts department in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts departments before and after the current contacts department in the ordered set where companyId = &#63;.
	*
	* @param departmentId the primary key of the current contacts department
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment[] findByCompany_PrevAndNext(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns all the contacts departments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contacts departments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @return the range of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts departments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contacts department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns the first contacts department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contacts department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns the last contacts department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts departments before and after the current contacts department in the ordered set where groupId = &#63;.
	*
	* @param departmentId the primary key of the current contacts department
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment[] findByGroup_PrevAndNext(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns all the contacts departments that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contacts departments that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @return the range of matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts departments that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts departments before and after the current contacts department in the ordered set of contacts departments that the user has permission to view where groupId = &#63;.
	*
	* @param departmentId the primary key of the current contacts department
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment[] filterFindByGroup_PrevAndNext(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns all the contacts departments where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @return the matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndCompany(
		long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contacts departments where companyId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @return the range of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndCompany(
		long companyId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts departments where companyId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndCompany(
		long companyId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contacts department in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment findByParentAndCompany_First(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns the first contacts department in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByParentAndCompany_First(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contacts department in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment findByParentAndCompany_Last(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns the last contacts department in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByParentAndCompany_Last(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts departments before and after the current contacts department in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param departmentId the primary key of the current contacts department
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment[] findByParentAndCompany_PrevAndNext(
		long departmentId, long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns all the contacts departments where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndGroup(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contacts departments where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @return the range of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndGroup(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts departments where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndGroup(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contacts department in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment findByParentAndGroup_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns the first contacts department in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByParentAndGroup_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contacts department in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment findByParentAndGroup_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns the last contacts department in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByParentAndGroup_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts departments before and after the current contacts department in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param departmentId the primary key of the current contacts department
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment[] findByParentAndGroup_PrevAndNext(
		long departmentId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns all the contacts departments that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByParentAndGroup(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contacts departments that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @return the range of matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByParentAndGroup(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts departments that the user has permissions to view where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByParentAndGroup(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts departments before and after the current contacts department in the ordered set of contacts departments that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param departmentId the primary key of the current contacts department
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment[] filterFindByParentAndGroup_PrevAndNext(
		long departmentId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns all the contacts departments where companyId = &#63; and departmentStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @return the matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndCompany(
		long companyId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contacts departments where companyId = &#63; and departmentStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @return the range of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndCompany(
		long companyId, int departmentStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts departments where companyId = &#63; and departmentStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndCompany(
		long companyId, int departmentStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contacts department in the ordered set where companyId = &#63; and departmentStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment findByStatusAndCompany_First(
		long companyId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns the first contacts department in the ordered set where companyId = &#63; and departmentStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByStatusAndCompany_First(
		long companyId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contacts department in the ordered set where companyId = &#63; and departmentStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment findByStatusAndCompany_Last(
		long companyId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns the last contacts department in the ordered set where companyId = &#63; and departmentStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByStatusAndCompany_Last(
		long companyId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts departments before and after the current contacts department in the ordered set where companyId = &#63; and departmentStatus = &#63;.
	*
	* @param departmentId the primary key of the current contacts department
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment[] findByStatusAndCompany_PrevAndNext(
		long departmentId, long companyId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns all the contacts departments where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @return the matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndGroup(
		long groupId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contacts departments where groupId = &#63; and departmentStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @return the range of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndGroup(
		long groupId, int departmentStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts departments where groupId = &#63; and departmentStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndGroup(
		long groupId, int departmentStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contacts department in the ordered set where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment findByStatusAndGroup_First(
		long groupId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns the first contacts department in the ordered set where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByStatusAndGroup_First(
		long groupId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contacts department in the ordered set where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment findByStatusAndGroup_Last(
		long groupId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns the last contacts department in the ordered set where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByStatusAndGroup_Last(
		long groupId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts departments before and after the current contacts department in the ordered set where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param departmentId the primary key of the current contacts department
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment[] findByStatusAndGroup_PrevAndNext(
		long departmentId, long groupId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns all the contacts departments that the user has permission to view where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @return the matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByStatusAndGroup(
		long groupId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contacts departments that the user has permission to view where groupId = &#63; and departmentStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @return the range of matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByStatusAndGroup(
		long groupId, int departmentStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts departments that the user has permissions to view where groupId = &#63; and departmentStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByStatusAndGroup(
		long groupId, int departmentStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts departments before and after the current contacts department in the ordered set of contacts departments that the user has permission to view where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param departmentId the primary key of the current contacts department
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartment[] filterFindByStatusAndGroup_PrevAndNext(
		long departmentId, long groupId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;

	/**
	* Returns all the contacts departments.
	*
	* @return the contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contacts departments
	* @param end the upper bound of the range of contacts departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contacts departments where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contacts departments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contacts departments where companyId = &#63; and parentId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentAndCompany(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contacts departments where groupId = &#63; and parentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contacts departments where companyId = &#63; and departmentStatus = &#63; from the database.
	*
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndCompany(long companyId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contacts departments where groupId = &#63; and departmentStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndGroup(long groupId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contacts departments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts departments where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts departments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts departments that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts departments where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @return the number of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentAndCompany(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts departments where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts departments that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts departments where companyId = &#63; and departmentStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @return the number of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndCompany(long companyId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts departments where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @return the number of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndGroup(long groupId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts departments that the user has permission to view where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @return the number of matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByStatusAndGroup(long groupId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts departments.
	*
	* @return the number of contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}