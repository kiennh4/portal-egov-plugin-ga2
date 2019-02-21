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

package com.bkav.portal.portlet.employee.service.persistence;

import com.bkav.portal.portlet.employee.model.Department;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ducdvd
 * @see DepartmentPersistenceImpl
 * @see DepartmentUtil
 * @generated
 */
public interface DepartmentPersistence extends BasePersistence<Department> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DepartmentUtil} to access the department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the department in the entity cache if it is enabled.
	*
	* @param department the department
	*/
	public void cacheResult(
		com.bkav.portal.portlet.employee.model.Department department);

	/**
	* Caches the departments in the entity cache if it is enabled.
	*
	* @param departments the departments
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.employee.model.Department> departments);

	/**
	* Creates a new department with the primary key. Does not add the department to the database.
	*
	* @param depId the primary key for the new department
	* @return the new department
	*/
	public com.bkav.portal.portlet.employee.model.Department create(long depId);

	/**
	* Removes the department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param depId the primary key of the department
	* @return the department that was removed
	* @throws com.bkav.portal.portlet.employee.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Department remove(long depId)
		throws com.bkav.portal.portlet.employee.NoSuchDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.employee.model.Department updateImpl(
		com.bkav.portal.portlet.employee.model.Department department,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the department with the primary key or throws a {@link com.bkav.portal.portlet.employee.NoSuchDepartmentException} if it could not be found.
	*
	* @param depId the primary key of the department
	* @return the department
	* @throws com.bkav.portal.portlet.employee.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Department findByPrimaryKey(
		long depId)
		throws com.bkav.portal.portlet.employee.NoSuchDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param depId the primary key of the department
	* @return the department, or <code>null</code> if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Department fetchByPrimaryKey(
		long depId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the departments where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.employee.model.Department> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the departments where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of matching departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.employee.model.Department> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the departments where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.employee.model.Department> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first department in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department
	* @throws com.bkav.portal.portlet.employee.NoSuchDepartmentException if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Department findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.employee.NoSuchDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first department in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department, or <code>null</code> if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Department fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last department in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department
	* @throws com.bkav.portal.portlet.employee.NoSuchDepartmentException if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Department findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.employee.NoSuchDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last department in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department, or <code>null</code> if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Department fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the departments before and after the current department in the ordered set where companyId = &#63;.
	*
	* @param depId the primary key of the current department
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next department
	* @throws com.bkav.portal.portlet.employee.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Department[] findByCompany_PrevAndNext(
		long depId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.employee.NoSuchDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the departments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.employee.model.Department> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the departments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of matching departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.employee.model.Department> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the departments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.employee.model.Department> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department
	* @throws com.bkav.portal.portlet.employee.NoSuchDepartmentException if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Department findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.employee.NoSuchDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department, or <code>null</code> if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Department fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department
	* @throws com.bkav.portal.portlet.employee.NoSuchDepartmentException if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Department findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.employee.NoSuchDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department, or <code>null</code> if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Department fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the departments before and after the current department in the ordered set where groupId = &#63;.
	*
	* @param depId the primary key of the current department
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next department
	* @throws com.bkav.portal.portlet.employee.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Department[] findByGroup_PrevAndNext(
		long depId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.employee.NoSuchDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the departments that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.employee.model.Department> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the departments that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of matching departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.employee.model.Department> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the departments that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.employee.model.Department> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the departments before and after the current department in the ordered set of departments that the user has permission to view where groupId = &#63;.
	*
	* @param depId the primary key of the current department
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next department
	* @throws com.bkav.portal.portlet.employee.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Department[] filterFindByGroup_PrevAndNext(
		long depId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.employee.NoSuchDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the departments.
	*
	* @return the departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.employee.model.Department> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.employee.model.Department> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.employee.model.Department> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the departments where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the departments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the departments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of departments where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of departments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of departments that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of departments.
	*
	* @return the number of departments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}