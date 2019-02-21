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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.contacts.model.ContactsDepartment;

import java.util.List;

/**
 * The persistence utility for the contacts department service. This utility wraps {@link ContactsDepartmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see ContactsDepartmentPersistence
 * @see ContactsDepartmentPersistenceImpl
 * @generated
 */
public class ContactsDepartmentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ContactsDepartment contactsDepartment) {
		getPersistence().clearCache(contactsDepartment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ContactsDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContactsDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContactsDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ContactsDepartment update(
		ContactsDepartment contactsDepartment, boolean merge)
		throws SystemException {
		return getPersistence().update(contactsDepartment, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ContactsDepartment update(
		ContactsDepartment contactsDepartment, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(contactsDepartment, merge, serviceContext);
	}

	/**
	* Caches the contacts department in the entity cache if it is enabled.
	*
	* @param contactsDepartment the contacts department
	*/
	public static void cacheResult(
		com.portal_egov.portlet.contacts.model.ContactsDepartment contactsDepartment) {
		getPersistence().cacheResult(contactsDepartment);
	}

	/**
	* Caches the contacts departments in the entity cache if it is enabled.
	*
	* @param contactsDepartments the contacts departments
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> contactsDepartments) {
		getPersistence().cacheResult(contactsDepartments);
	}

	/**
	* Creates a new contacts department with the primary key. Does not add the contacts department to the database.
	*
	* @param departmentId the primary key for the new contacts department
	* @return the new contacts department
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment create(
		long departmentId) {
		return getPersistence().create(departmentId);
	}

	/**
	* Removes the contacts department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param departmentId the primary key of the contacts department
	* @return the contacts department that was removed
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment remove(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence().remove(departmentId);
	}

	public static com.portal_egov.portlet.contacts.model.ContactsDepartment updateImpl(
		com.portal_egov.portlet.contacts.model.ContactsDepartment contactsDepartment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contactsDepartment, merge);
	}

	/**
	* Returns the contacts department with the primary key or throws a {@link com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException} if it could not be found.
	*
	* @param departmentId the primary key of the contacts department
	* @return the contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment findByPrimaryKey(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence().findByPrimaryKey(departmentId);
	}

	/**
	* Returns the contacts department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param departmentId the primary key of the contacts department
	* @return the contacts department, or <code>null</code> if a contacts department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByPrimaryKey(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(departmentId);
	}

	/**
	* Returns all the contacts departments where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first contacts department in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first contacts department in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last contacts department in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last contacts department in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment[] findByCompany_PrevAndNext(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .findByCompany_PrevAndNext(departmentId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the contacts departments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first contacts department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first contacts department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last contacts department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last contacts department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment[] findByGroup_PrevAndNext(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .findByGroup_PrevAndNext(departmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the contacts departments that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment[] filterFindByGroup_PrevAndNext(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(departmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the contacts departments where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @return the matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndCompany(
		long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentAndCompany(companyId, parentId);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndCompany(
		long companyId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndCompany(companyId, parentId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndCompany(
		long companyId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndCompany(companyId, parentId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment findByParentAndCompany_First(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .findByParentAndCompany_First(companyId, parentId,
			orderByComparator);
	}

	/**
	* Returns the first contacts department in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByParentAndCompany_First(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndCompany_First(companyId, parentId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment findByParentAndCompany_Last(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .findByParentAndCompany_Last(companyId, parentId,
			orderByComparator);
	}

	/**
	* Returns the last contacts department in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByParentAndCompany_Last(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndCompany_Last(companyId, parentId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment[] findByParentAndCompany_PrevAndNext(
		long departmentId, long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .findByParentAndCompany_PrevAndNext(departmentId, companyId,
			parentId, orderByComparator);
	}

	/**
	* Returns all the contacts departments where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndGroup(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentAndGroup(groupId, parentId);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndGroup(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndGroup(groupId, parentId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByParentAndGroup(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndGroup(groupId, parentId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment findByParentAndGroup_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .findByParentAndGroup_First(groupId, parentId,
			orderByComparator);
	}

	/**
	* Returns the first contacts department in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByParentAndGroup_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndGroup_First(groupId, parentId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment findByParentAndGroup_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .findByParentAndGroup_Last(groupId, parentId,
			orderByComparator);
	}

	/**
	* Returns the last contacts department in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByParentAndGroup_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndGroup_Last(groupId, parentId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment[] findByParentAndGroup_PrevAndNext(
		long departmentId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .findByParentAndGroup_PrevAndNext(departmentId, groupId,
			parentId, orderByComparator);
	}

	/**
	* Returns all the contacts departments that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByParentAndGroup(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByParentAndGroup(groupId, parentId);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByParentAndGroup(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentAndGroup(groupId, parentId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByParentAndGroup(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentAndGroup(groupId, parentId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment[] filterFindByParentAndGroup_PrevAndNext(
		long departmentId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .filterFindByParentAndGroup_PrevAndNext(departmentId,
			groupId, parentId, orderByComparator);
	}

	/**
	* Returns all the contacts departments where companyId = &#63; and departmentStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @return the matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndCompany(
		long companyId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(companyId, departmentStatus);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndCompany(
		long companyId, int departmentStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(companyId, departmentStatus, start,
			end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndCompany(
		long companyId, int departmentStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(companyId, departmentStatus, start,
			end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment findByStatusAndCompany_First(
		long companyId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .findByStatusAndCompany_First(companyId, departmentStatus,
			orderByComparator);
	}

	/**
	* Returns the first contacts department in the ordered set where companyId = &#63; and departmentStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByStatusAndCompany_First(
		long companyId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndCompany_First(companyId, departmentStatus,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment findByStatusAndCompany_Last(
		long companyId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .findByStatusAndCompany_Last(companyId, departmentStatus,
			orderByComparator);
	}

	/**
	* Returns the last contacts department in the ordered set where companyId = &#63; and departmentStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByStatusAndCompany_Last(
		long companyId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndCompany_Last(companyId, departmentStatus,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment[] findByStatusAndCompany_PrevAndNext(
		long departmentId, long companyId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .findByStatusAndCompany_PrevAndNext(departmentId, companyId,
			departmentStatus, orderByComparator);
	}

	/**
	* Returns all the contacts departments where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @return the matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndGroup(
		long groupId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndGroup(groupId, departmentStatus);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndGroup(
		long groupId, int departmentStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndGroup(groupId, departmentStatus, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByStatusAndGroup(
		long groupId, int departmentStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndGroup(groupId, departmentStatus, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment findByStatusAndGroup_First(
		long groupId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .findByStatusAndGroup_First(groupId, departmentStatus,
			orderByComparator);
	}

	/**
	* Returns the first contacts department in the ordered set where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByStatusAndGroup_First(
		long groupId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndGroup_First(groupId, departmentStatus,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment findByStatusAndGroup_Last(
		long groupId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .findByStatusAndGroup_Last(groupId, departmentStatus,
			orderByComparator);
	}

	/**
	* Returns the last contacts department in the ordered set where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department, or <code>null</code> if a matching contacts department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment fetchByStatusAndGroup_Last(
		long groupId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndGroup_Last(groupId, departmentStatus,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment[] findByStatusAndGroup_PrevAndNext(
		long departmentId, long groupId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .findByStatusAndGroup_PrevAndNext(departmentId, groupId,
			departmentStatus, orderByComparator);
	}

	/**
	* Returns all the contacts departments that the user has permission to view where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @return the matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByStatusAndGroup(
		long groupId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(groupId, departmentStatus);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByStatusAndGroup(
		long groupId, int departmentStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(groupId, departmentStatus,
			start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> filterFindByStatusAndGroup(
		long groupId, int departmentStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(groupId, departmentStatus,
			start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartment[] filterFindByStatusAndGroup_PrevAndNext(
		long departmentId, long groupId, int departmentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException {
		return getPersistence()
				   .filterFindByStatusAndGroup_PrevAndNext(departmentId,
			groupId, departmentStatus, orderByComparator);
	}

	/**
	* Returns all the contacts departments.
	*
	* @return the contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the contacts departments where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the contacts departments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the contacts departments where companyId = &#63; and parentId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentAndCompany(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentAndCompany(companyId, parentId);
	}

	/**
	* Removes all the contacts departments where groupId = &#63; and parentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentAndGroup(groupId, parentId);
	}

	/**
	* Removes all the contacts departments where companyId = &#63; and departmentStatus = &#63; from the database.
	*
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatusAndCompany(long companyId,
		int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatusAndCompany(companyId, departmentStatus);
	}

	/**
	* Removes all the contacts departments where groupId = &#63; and departmentStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatusAndGroup(long groupId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatusAndGroup(groupId, departmentStatus);
	}

	/**
	* Removes all the contacts departments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of contacts departments where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of contacts departments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of contacts departments that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of contacts departments where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @return the number of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentAndCompany(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentAndCompany(companyId, parentId);
	}

	/**
	* Returns the number of contacts departments where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentAndGroup(groupId, parentId);
	}

	/**
	* Returns the number of contacts departments that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByParentAndGroup(groupId, parentId);
	}

	/**
	* Returns the number of contacts departments where companyId = &#63; and departmentStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentStatus the department status
	* @return the number of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndCompany(long companyId,
		int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByStatusAndCompany(companyId, departmentStatus);
	}

	/**
	* Returns the number of contacts departments where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @return the number of matching contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndGroup(long groupId, int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndGroup(groupId, departmentStatus);
	}

	/**
	* Returns the number of contacts departments that the user has permission to view where groupId = &#63; and departmentStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentStatus the department status
	* @return the number of matching contacts departments that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByStatusAndGroup(long groupId,
		int departmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByStatusAndGroup(groupId, departmentStatus);
	}

	/**
	* Returns the number of contacts departments.
	*
	* @return the number of contacts departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContactsDepartmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContactsDepartmentPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.contacts.service.ClpSerializer.getServletContextName(),
					ContactsDepartmentPersistence.class.getName());

			ReferenceRegistry.registerReference(ContactsDepartmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ContactsDepartmentPersistence persistence) {
	}

	private static ContactsDepartmentPersistence _persistence;
}